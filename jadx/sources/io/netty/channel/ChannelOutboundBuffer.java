package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ChannelOutboundBuffer {
    private final Channel channel;
    private volatile Runnable fireChannelWritabilityChangedTask;
    private int flushed;
    private Entry flushedEntry;
    private boolean inFail;
    private int nioBufferCount;
    private long nioBufferSize;
    private Entry tailEntry;
    private volatile long totalPendingSize;
    private Entry unflushedEntry;
    private volatile int unwritable;
    static final int CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.outboundBufferEntrySizeOverhead", 96);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelOutboundBuffer.class);
    private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS = new FastThreadLocal<ByteBuffer[]>() { // from class: io.netty.channel.ChannelOutboundBuffer.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public ByteBuffer[] initialValue() {
            return new ByteBuffer[1024];
        }
    };
    private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
    private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class Entry {
        private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<Entry>() { // from class: io.netty.channel.ChannelOutboundBuffer.Entry.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public Entry newObject(ObjectPool.Handle<Entry> handle) {
                return new Entry(handle);
            }
        });
        ByteBuffer buf;
        ByteBuffer[] bufs;
        boolean cancelled;
        int count;
        private final ObjectPool.Handle<Entry> handle;
        Object msg;
        Entry next;
        int pendingSize;
        long progress;
        ChannelPromise promise;
        long total;

        void recycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0L;
            this.total = 0L;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            this.handle.recycle(this);
        }

        private Entry(ObjectPool.Handle<Entry> handle) {
            this.count = -1;
            this.handle = handle;
        }

        static Entry newInstance(Object obj, int i10, long j10, ChannelPromise channelPromise) {
            Entry entry = RECYCLER.get();
            entry.msg = obj;
            entry.pendingSize = i10 + ChannelOutboundBuffer.CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
            entry.total = j10;
            entry.promise = channelPromise;
            return entry;
        }

        int cancel() {
            if (this.cancelled) {
                return 0;
            }
            this.cancelled = true;
            int i10 = this.pendingSize;
            ReferenceCountUtil.safeRelease(this.msg);
            this.msg = Unpooled.EMPTY_BUFFER;
            this.pendingSize = 0;
            this.total = 0L;
            this.progress = 0L;
            this.bufs = null;
            this.buf = null;
            return i10;
        }

        Entry recycleAndGetNext() {
            Entry entry = this.next;
            recycle();
            return entry;
        }
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] byteBufferArr, int i10, int i11) {
        int length = byteBufferArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i10 > length);
        ByteBuffer[] byteBufferArr2 = new ByteBuffer[length];
        System.arraycopy(byteBufferArr, 0, byteBufferArr2, 0, i11);
        return byteBufferArr2;
    }

    void close(final Throwable th, final boolean z10) {
        if (this.inFail) {
            this.channel.eventLoop().execute(new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelOutboundBuffer.this.close(th, z10);
                }
            });
            return;
        }
        this.inFail = true;
        if (!z10 && this.channel.isOpen()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        }
        if (!isEmpty()) {
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        }
        try {
            for (Entry entryRecycleAndGetNext = this.unflushedEntry; entryRecycleAndGetNext != null; entryRecycleAndGetNext = entryRecycleAndGetNext.recycleAndGetNext()) {
                TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -entryRecycleAndGetNext.pendingSize);
                if (!entryRecycleAndGetNext.cancelled) {
                    ReferenceCountUtil.safeRelease(entryRecycleAndGetNext.msg);
                    safeFail(entryRecycleAndGetNext.promise, th);
                }
            }
            this.inFail = false;
            clearNioBuffers();
        } catch (Throwable th2) {
            this.inFail = false;
            throw th2;
        }
    }

    void decrementPendingOutboundBytes(long j10) {
        decrementPendingOutboundBytes(j10, true, true);
    }

    void incrementPendingOutboundBytes(long j10) {
        incrementPendingOutboundBytes(j10, true);
    }

    public ByteBuffer[] nioBuffers(int i10, long j10) {
        ByteBuf byteBuf;
        int i11;
        int iWriterIndex;
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        ByteBuffer[] byteBufferArrExpandNioBufferArray = NIO_BUFFERS.get(internalThreadLocalMap);
        long j11 = 0;
        int iNioBuffers = 0;
        for (Entry entry = this.flushedEntry; isFlushedEntry(entry); entry = entry.next) {
            Object obj = entry.msg;
            if (!(obj instanceof ByteBuf)) {
                break;
            }
            if (!entry.cancelled && (iWriterIndex = byteBuf.writerIndex() - (i11 = (byteBuf = (ByteBuf) obj).readerIndex())) > 0) {
                long j12 = iWriterIndex;
                if (j10 - j12 < j11 && iNioBuffers != 0) {
                    break;
                }
                j11 += j12;
                int iNioBufferCount = entry.count;
                if (iNioBufferCount == -1) {
                    iNioBufferCount = byteBuf.nioBufferCount();
                    entry.count = iNioBufferCount;
                }
                int iMin = Math.min(i10, iNioBuffers + iNioBufferCount);
                if (iMin > byteBufferArrExpandNioBufferArray.length) {
                    byteBufferArrExpandNioBufferArray = expandNioBufferArray(byteBufferArrExpandNioBufferArray, iMin, iNioBuffers);
                    NIO_BUFFERS.set(internalThreadLocalMap, byteBufferArrExpandNioBufferArray);
                }
                if (iNioBufferCount == 1) {
                    ByteBuffer byteBufferInternalNioBuffer = entry.buf;
                    if (byteBufferInternalNioBuffer == null) {
                        byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(i11, iWriterIndex);
                        entry.buf = byteBufferInternalNioBuffer;
                    }
                    byteBufferArrExpandNioBufferArray[iNioBuffers] = byteBufferInternalNioBuffer;
                    iNioBuffers++;
                } else {
                    iNioBuffers = nioBuffers(entry, byteBuf, byteBufferArrExpandNioBufferArray, iNioBuffers, i10);
                }
                if (iNioBuffers >= i10) {
                    break;
                }
            }
        }
        this.nioBufferCount = iNioBuffers;
        this.nioBufferSize = j11;
        return byteBufferArrExpandNioBufferArray;
    }

    public boolean remove() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i10 = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeSuccess(channelPromise);
            decrementPendingOutboundBytes(i10, false, true);
        }
        entry.recycle();
        return true;
    }

    private void clearNioBuffers() {
        int i10 = this.nioBufferCount;
        if (i10 > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(NIO_BUFFERS.get(), 0, i10, (Object) null);
        }
    }

    private void decrementPendingOutboundBytes(long j10, boolean z10, boolean z11) {
        if (j10 == 0) {
            return;
        }
        long jAddAndGet = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j10);
        if (!z11 || jAddAndGet >= this.channel.config().getWriteBufferLowWaterMark()) {
            return;
        }
        setWritable(z10);
    }

    private void fireChannelWritabilityChanged(boolean z10) {
        final ChannelPipeline channelPipelinePipeline = this.channel.pipeline();
        if (!z10) {
            channelPipelinePipeline.fireChannelWritabilityChanged();
            return;
        }
        Runnable runnable = this.fireChannelWritabilityChangedTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.2
                @Override // java.lang.Runnable
                public void run() {
                    channelPipelinePipeline.fireChannelWritabilityChanged();
                }
            };
            this.fireChannelWritabilityChangedTask = runnable;
        }
        this.channel.eventLoop().execute(runnable);
    }

    private void incrementPendingOutboundBytes(long j10, boolean z10) {
        if (j10 != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j10) > this.channel.config().getWriteBufferHighWaterMark()) {
            setUnwritable(z10);
        }
    }

    private boolean isFlushedEntry(Entry entry) {
        return (entry == null || entry == this.unflushedEntry) ? false : true;
    }

    private boolean remove0(Throwable th, boolean z10) {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i10 = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeFail(channelPromise, th);
            decrementPendingOutboundBytes(i10, false, z10);
        }
        entry.recycle();
        return true;
    }

    private void removeEntry(Entry entry) {
        int i10 = this.flushed - 1;
        this.flushed = i10;
        if (i10 != 0) {
            this.flushedEntry = entry.next;
            return;
        }
        this.flushedEntry = null;
        if (entry == this.tailEntry) {
            this.tailEntry = null;
            this.unflushedEntry = null;
        }
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        PromiseNotificationUtil.tryFailure(channelPromise, th, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private static void safeSuccess(ChannelPromise channelPromise) {
        PromiseNotificationUtil.trySuccess(channelPromise, null, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private void setUnwritable(boolean z10) {
        int i10;
        do {
            i10 = this.unwritable;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i10, i10 | 1));
        if (i10 == 0) {
            fireChannelWritabilityChanged(z10);
        }
    }

    private void setWritable(boolean z10) {
        int i10;
        int i11;
        do {
            i10 = this.unwritable;
            i11 = i10 & (-2);
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i10, i11));
        if (i10 == 0 || i11 != 0) {
            return;
        }
        fireChannelWritabilityChanged(z10);
    }

    private static long total(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        if (obj instanceof ByteBufHolder) {
            return ((ByteBufHolder) obj).content().readableBytes();
        }
        return -1L;
    }

    public void addFlush() {
        Entry entry = this.unflushedEntry;
        if (entry != null) {
            if (this.flushedEntry == null) {
                this.flushedEntry = entry;
            }
            do {
                this.flushed++;
                if (!entry.promise.setUncancellable()) {
                    decrementPendingOutboundBytes(entry.cancel(), false, true);
                }
                entry = entry.next;
            } while (entry != null);
            this.unflushedEntry = null;
        }
    }

    public Object current() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return null;
        }
        return entry.msg;
    }

    void failFlushed(Throwable th, boolean z10) {
        if (this.inFail) {
            return;
        }
        try {
            this.inFail = true;
            do {
            } while (remove0(th, z10));
        } finally {
            this.inFail = false;
        }
    }

    public boolean isEmpty() {
        return this.flushed == 0;
    }

    public boolean isWritable() {
        return this.unwritable == 0;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public long nioBufferSize() {
        return this.nioBufferSize;
    }

    public void progress(long j10) {
        Entry entry = this.flushedEntry;
        ChannelPromise channelPromise = entry.promise;
        long j11 = entry.progress + j10;
        entry.progress = j11;
        if (channelPromise instanceof ChannelProgressivePromise) {
            ((ChannelProgressivePromise) channelPromise).tryProgress(j11, entry.total);
        }
    }

    ChannelOutboundBuffer(AbstractChannel abstractChannel) {
        this.channel = abstractChannel;
    }

    public void addMessage(Object obj, int i10, ChannelPromise channelPromise) {
        Entry entryNewInstance = Entry.newInstance(obj, i10, total(obj), channelPromise);
        Entry entry = this.tailEntry;
        if (entry == null) {
            this.flushedEntry = null;
        } else {
            entry.next = entryNewInstance;
        }
        this.tailEntry = entryNewInstance;
        if (this.unflushedEntry == null) {
            this.unflushedEntry = entryNewInstance;
        }
        incrementPendingOutboundBytes(entryNewInstance.pendingSize, false);
    }

    public void removeBytes(long j10) {
        while (true) {
            Object objCurrent = current();
            if (!(objCurrent instanceof ByteBuf)) {
                break;
            }
            ByteBuf byteBuf = (ByteBuf) objCurrent;
            int i10 = byteBuf.readerIndex();
            long jWriterIndex = byteBuf.writerIndex() - i10;
            if (jWriterIndex <= j10) {
                if (j10 != 0) {
                    progress(jWriterIndex);
                    j10 -= jWriterIndex;
                }
                remove();
            } else {
                if (j10 == 0) {
                    break;
                }
                byteBuf.readerIndex(i10 + ((int) j10));
                progress(j10);
                break;
            }
        }
        clearNioBuffers();
    }

    public boolean remove(Throwable th) {
        return remove0(th, true);
    }

    void close(ClosedChannelException closedChannelException) {
        close(closedChannelException, false);
    }

    private static int nioBuffers(Entry entry, ByteBuf byteBuf, ByteBuffer[] byteBufferArr, int i10, int i11) {
        ByteBuffer byteBuffer;
        ByteBuffer[] byteBufferArrNioBuffers = entry.bufs;
        if (byteBufferArrNioBuffers == null) {
            byteBufferArrNioBuffers = byteBuf.nioBuffers();
            entry.bufs = byteBufferArrNioBuffers;
        }
        for (int i12 = 0; i12 < byteBufferArrNioBuffers.length && i10 < i11 && (byteBuffer = byteBufferArrNioBuffers[i12]) != null; i12++) {
            if (byteBuffer.hasRemaining()) {
                byteBufferArr[i10] = byteBuffer;
                i10++;
            }
        }
        return i10;
    }
}
