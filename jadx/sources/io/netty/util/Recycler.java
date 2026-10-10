package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class Recycler<T> {
    private static final boolean BLOCKING_POOL;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final int DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD;
    private static final a<?> NOOP_HANDLE;
    private static final int RATIO;
    private static final InternalLogger logger;
    private final int chunkSize;
    private final int interval;
    private final int maxCapacityPerThread;
    private final FastThreadLocal<LocalPool<T>> threadLocal;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class DefaultHandle<T> implements a<T> {
        private static final AtomicIntegerFieldUpdater<DefaultHandle<?>> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultHandle.class, "state");
        private final LocalPool<T> localPool;
        private volatile int state;
        private T value;

        boolean availableToClaim() {
            if (this.state != 1) {
                return false;
            }
            return STATE_UPDATER.compareAndSet(this, 1, 0);
        }

        T get() {
            return this.value;
        }

        @Override // io.netty.util.internal.ObjectPool.Handle
        public void recycle(Object obj) {
            if (obj != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            this.localPool.release(this);
        }

        void set(T t10) {
            this.value = t10;
        }

        void toAvailable() {
            if (STATE_UPDATER.getAndSet(this, 1) == 1) {
                throw new IllegalStateException("Object has been recycled already.");
            }
        }

        DefaultHandle(LocalPool<T> localPool) {
            this.localPool = localPool;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class LocalPool<T> {
        private volatile MessagePassingQueue<DefaultHandle<T>> pooledHandles;
        private int ratioCounter;
        private final int ratioInterval;

        DefaultHandle<T> claim() {
            DefaultHandle<T> defaultHandleRelaxedPoll;
            MessagePassingQueue<DefaultHandle<T>> messagePassingQueue = this.pooledHandles;
            if (messagePassingQueue == null) {
                return null;
            }
            do {
                defaultHandleRelaxedPoll = messagePassingQueue.relaxedPoll();
                if (defaultHandleRelaxedPoll == null) {
                    break;
                }
            } while (!defaultHandleRelaxedPoll.availableToClaim());
            return defaultHandleRelaxedPoll;
        }

        DefaultHandle<T> newHandle() {
            int i10 = this.ratioCounter + 1;
            this.ratioCounter = i10;
            if (i10 < this.ratioInterval) {
                return null;
            }
            this.ratioCounter = 0;
            return new DefaultHandle<>(this);
        }

        void release(DefaultHandle<T> defaultHandle) {
            MessagePassingQueue<DefaultHandle<T>> messagePassingQueue = this.pooledHandles;
            defaultHandle.toAvailable();
            if (messagePassingQueue != null) {
                messagePassingQueue.relaxedOffer(defaultHandle);
            }
        }

        LocalPool(int i10, int i11, int i12) {
            this.ratioInterval = i11;
            if (Recycler.BLOCKING_POOL) {
                this.pooledHandles = new BlockingMessageQueue(i10);
            } else {
                this.pooledHandles = (MessagePassingQueue) PlatformDependent.newMpscQueue(i12, i10);
            }
            this.ratioCounter = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a<T> extends ObjectPool.Handle<T> {
    }

    protected Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    protected abstract T newObject(a<T> aVar);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class BlockingMessageQueue<T> implements MessagePassingQueue<T> {
        private final Queue<T> deque = new ArrayDeque();
        private final int maxCapacity;

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized void clear() {
            this.deque.clear();
        }

        public synchronized boolean offer(T t10) {
            if (this.deque.size() == this.maxCapacity) {
                return false;
            }
            return this.deque.offer(t10);
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public synchronized T poll() {
            return this.deque.poll();
        }

        BlockingMessageQueue(int i10) {
            this.maxCapacity = i10;
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public boolean relaxedOffer(T t10) {
            return offer(t10);
        }

        @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public T relaxedPoll() {
            return poll();
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) Recycler.class);
        logger = internalLoggerFactory;
        NOOP_HANDLE = new a<Object>() { // from class: io.netty.util.Recycler.1
            public String toString() {
                return "NOOP_HANDLE";
            }

            @Override // io.netty.util.internal.ObjectPool.Handle
            public void recycle(Object obj) {
            }
        };
        int i10 = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        int i11 = i10 >= 0 ? i10 : 4096;
        DEFAULT_MAX_CAPACITY_PER_THREAD = i11;
        int i12 = SystemPropertyUtil.getInt("io.netty.recycler.chunkSize", 32);
        DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD = i12;
        int iMax = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        RATIO = iMax;
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.recycler.blocking", false);
        BLOCKING_POOL = z10;
        if (internalLoggerFactory.isDebugEnabled()) {
            if (i11 == 0) {
                internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.ratio: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.chunkSize: disabled");
                internalLoggerFactory.debug("-Dio.netty.recycler.blocking: disabled");
                return;
            }
            internalLoggerFactory.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", Integer.valueOf(i11));
            internalLoggerFactory.debug("-Dio.netty.recycler.ratio: {}", Integer.valueOf(iMax));
            internalLoggerFactory.debug("-Dio.netty.recycler.chunkSize: {}", Integer.valueOf(i12));
            internalLoggerFactory.debug("-Dio.netty.recycler.blocking: {}", Boolean.valueOf(z10));
        }
    }

    protected Recycler(int i10) {
        this(i10, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    public final T get() {
        if (this.maxCapacityPerThread == 0) {
            return newObject(NOOP_HANDLE);
        }
        LocalPool<T> localPool = this.threadLocal.get();
        DefaultHandle<T> defaultHandleClaim = localPool.claim();
        if (defaultHandleClaim != null) {
            return defaultHandleClaim.get();
        }
        DefaultHandle<T> defaultHandleNewHandle = localPool.newHandle();
        if (defaultHandleNewHandle == null) {
            return newObject(NOOP_HANDLE);
        }
        T tNewObject = newObject(defaultHandleNewHandle);
        defaultHandleNewHandle.set(tNewObject);
        return tNewObject;
    }

    protected Recycler(int i10, int i11, int i12) {
        this.threadLocal = new FastThreadLocal<LocalPool<T>>() { // from class: io.netty.util.Recycler.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public LocalPool<T> initialValue() {
                return new LocalPool<>(Recycler.this.maxCapacityPerThread, Recycler.this.interval, Recycler.this.chunkSize);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public void onRemoval(LocalPool<T> localPool) {
                super.onRemoval(localPool);
                MessagePassingQueue messagePassingQueue = ((LocalPool) localPool).pooledHandles;
                ((LocalPool) localPool).pooledHandles = null;
                messagePassingQueue.clear();
            }
        };
        this.interval = Math.max(0, i11);
        if (i10 <= 0) {
            this.maxCapacityPerThread = 0;
            this.chunkSize = 0;
        } else {
            int iMax = Math.max(4, i10);
            this.maxCapacityPerThread = iMax;
            this.chunkSize = Math.max(2, Math.min(i12, iMax >> 1));
        }
    }
}
