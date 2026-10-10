package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable<ByteBuf> {
    private final ByteBufAllocator alloc;
    private int componentCount;
    private Component[] components;
    private final boolean direct;
    private boolean freed;
    private Component lastAccessed;
    private final int maxNumComponents;
    private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
    private static final Iterator<ByteBuf> EMPTY_ITERATOR = Collections.EMPTY_LIST.iterator();
    static final ByteWrapper<byte[]> BYTE_ARRAY_WRAPPER = new ByteWrapper<byte[]>() { // from class: io.netty.buffer.CompositeByteBuf.1
    };
    static final ByteWrapper<ByteBuffer> BYTE_BUFFER_WRAPPER = new ByteWrapper<ByteBuffer>() { // from class: io.netty.buffer.CompositeByteBuf.2
    };

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface ByteWrapper<T> {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class Component {
        int adjustment;
        final ByteBuf buf;
        int endOffset;
        int offset;
        private ByteBuf slice;
        int srcAdjustment;
        final ByteBuf srcBuf;

        void free() {
            this.slice = null;
            this.srcBuf.release();
        }

        int idx(int i10) {
            return i10 + this.adjustment;
        }

        ByteBuffer internalNioBuffer(int i10, int i11) {
            return this.srcBuf.internalNioBuffer(srcIdx(i10), i11);
        }

        int length() {
            return this.endOffset - this.offset;
        }

        void reposition(int i10) {
            int i11 = i10 - this.offset;
            this.endOffset += i11;
            this.srcAdjustment -= i11;
            this.adjustment -= i11;
            this.offset = i10;
        }

        ByteBuf slice() {
            ByteBuf byteBuf = this.slice;
            if (byteBuf != null) {
                return byteBuf;
            }
            ByteBuf byteBufSlice = this.srcBuf.slice(srcIdx(this.offset), length());
            this.slice = byteBufSlice;
            return byteBufSlice;
        }

        int srcIdx(int i10) {
            return i10 + this.srcAdjustment;
        }

        void transferTo(ByteBuf byteBuf) {
            byteBuf.writeBytes(this.buf, idx(this.offset), length());
            free();
        }

        Component(ByteBuf byteBuf, int i10, ByteBuf byteBuf2, int i11, int i12, int i13, ByteBuf byteBuf3) {
            this.srcBuf = byteBuf;
            this.srcAdjustment = i10 - i12;
            this.buf = byteBuf2;
            this.adjustment = i11 - i12;
            this.offset = i12;
            this.endOffset = i12 + i13;
            this.slice = byteBuf3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class CompositeByteBufIterator implements Iterator<ByteBuf> {
        private int index;
        private final int size;

        private CompositeByteBufIterator() {
            this.size = CompositeByteBuf.this.numComponents();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.size > this.index;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteBuf next() {
            if (this.size != CompositeByteBuf.this.numComponents()) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            try {
                Component[] componentArr = CompositeByteBuf.this.components;
                int i10 = this.index;
                this.index = i10 + 1;
                return componentArr[i10].slice();
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }
    }

    private CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z10, int i10, int i11) {
        super(Integer.MAX_VALUE);
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        if (i10 >= 1) {
            this.direct = z10;
            this.maxNumComponents = i10;
            this.components = newCompArray(i11, i10);
        } else {
            throw new IllegalArgumentException("maxNumComponents: " + i10 + " (expected: >= 1)");
        }
    }

    private void addComp(int i10, Component component) {
        shiftComps(i10, 1);
        this.components[i10] = component;
    }

    private int addComponent0(boolean z10, int i10, ByteBuf byteBuf) {
        boolean z11 = false;
        try {
            checkComponentIndex(i10);
            Component componentNewComponent = newComponent(ensureAccessible(byteBuf), 0);
            int length = componentNewComponent.length();
            checkForOverflow(capacity(), length);
            addComp(i10, componentNewComponent);
            z11 = true;
            if (length > 0 && i10 < this.componentCount - 1) {
                updateComponentOffsets(i10);
            } else if (i10 > 0) {
                componentNewComponent.reposition(this.components[i10 - 1].endOffset);
            }
            if (z10) {
                this.writerIndex += length;
            }
            return i10;
        } catch (Throwable th) {
            if (!z11) {
                byteBuf.release();
            }
            throw th;
        }
    }

    private void clearComps() {
        removeCompRange(0, this.componentCount);
    }

    private void consolidate0(int i10, int i11) {
        if (i11 <= 1) {
            return;
        }
        int i12 = i10 + i11;
        ByteBuf byteBufAllocBuffer = allocBuffer(this.components[i12 - 1].endOffset - (i10 != 0 ? this.components[i10].offset : 0));
        for (int i13 = i10; i13 < i12; i13++) {
            this.components[i13].transferTo(byteBufAllocBuffer);
        }
        this.lastAccessed = null;
        removeCompRange(i10 + 1, i12);
        this.components[i10] = newComponent(byteBufAllocBuffer, 0);
        if (i10 == 0 && i11 == this.componentCount) {
            return;
        }
        updateComponentOffsets(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int forEachByteAsc0(int i10, int i11, ByteProcessor byteProcessor) {
        if (i11 <= i10) {
            return -1;
        }
        int componentIndex0 = toComponentIndex0(i10);
        int i12 = i11 - i10;
        while (i12 > 0) {
            Component component = this.components[componentIndex0];
            if (component.offset != component.endOffset) {
                ByteBuf byteBuf = component.buf;
                int iIdx = component.idx(i10);
                int iMin = Math.min(i12, component.endOffset - i10);
                int iForEachByteAsc0 = byteBuf instanceof AbstractByteBuf ? ((AbstractByteBuf) byteBuf).forEachByteAsc0(iIdx, iIdx + iMin, byteProcessor) : byteBuf.forEachByte(iIdx, iMin, byteProcessor);
                if (iForEachByteAsc0 != -1) {
                    return iForEachByteAsc0 - component.adjustment;
                }
                i10 += iMin;
                i12 -= iMin;
            }
            componentIndex0++;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return new ByteBuffer[]{EMPTY_NIO_BUFFER};
        }
        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance(this.componentCount);
        try {
            int componentIndex0 = toComponentIndex0(i10);
            while (i11 > 0) {
                Component component = this.components[componentIndex0];
                ByteBuf byteBuf = component.buf;
                int iMin = Math.min(i11, component.endOffset - i10);
                int iNioBufferCount = byteBuf.nioBufferCount();
                if (iNioBufferCount == 0) {
                    throw new UnsupportedOperationException();
                }
                if (iNioBufferCount != 1) {
                    Collections.addAll(recyclableArrayListNewInstance, byteBuf.nioBuffers(component.idx(i10), iMin));
                } else {
                    recyclableArrayListNewInstance.add(byteBuf.nioBuffer(component.idx(i10), iMin));
                }
                i10 += iMin;
                i11 -= iMin;
                componentIndex0++;
            }
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) recyclableArrayListNewInstance.toArray(new ByteBuffer[0]);
            recyclableArrayListNewInstance.recycle();
            return byteBufferArr;
        } catch (Throwable th) {
            recyclableArrayListNewInstance.recycle();
            throw th;
        }
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    private ByteBuf allocBuffer(int i10) {
        return this.direct ? alloc().directBuffer(i10) : alloc().heapBuffer(i10);
    }

    private static void checkForOverflow(int i10, int i11) {
        if (i10 + i11 >= 0) {
            return;
        }
        throw new IllegalArgumentException("Can't increase by " + i11 + " as capacity(" + i10 + ") would overflow 2147483647");
    }

    private void consolidateIfNeeded() {
        int i10 = this.componentCount;
        if (i10 > this.maxNumComponents) {
            consolidate0(0, i10);
        }
    }

    private static ByteBuf ensureAccessible(ByteBuf byteBuf) {
        if (!AbstractByteBuf.checkAccessible || byteBuf.isAccessible()) {
            return byteBuf;
        }
        throw new IllegalReferenceCountException(0);
    }

    private Component findComponent(int i10) {
        Component component = this.lastAccessed;
        if (component == null || i10 < component.offset || i10 >= component.endOffset) {
            checkIndex(i10);
            return findIt(i10);
        }
        ensureAccessible();
        return component;
    }

    private Component findComponent0(int i10) {
        Component component = this.lastAccessed;
        return (component == null || i10 < component.offset || i10 >= component.endOffset) ? findIt(i10) : component;
    }

    private Component findIt(int i10) {
        int i11 = this.componentCount;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            Component component = this.components[i13];
            if (component == null) {
                throw new IllegalStateException("No component found for offset. Composite buffer layout might be outdated, e.g. from a discardReadBytes call.");
            }
            if (i10 >= component.endOffset) {
                i12 = i13 + 1;
            } else {
                if (i10 >= component.offset) {
                    this.lastAccessed = component;
                    return component;
                }
                i11 = i13 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private static Component[] newCompArray(int i10, int i11) {
        return new Component[Math.max(i10, Math.min(16, i11))];
    }

    private void removeComp(int i10) {
        removeCompRange(i10, i10 + 1);
    }

    private void removeCompRange(int i10, int i11) {
        if (i10 >= i11) {
            return;
        }
        int i12 = this.componentCount;
        if (i11 < i12) {
            Component[] componentArr = this.components;
            System.arraycopy(componentArr, i11, componentArr, i10, i12 - i11);
        }
        int i13 = (i12 - i11) + i10;
        for (int i14 = i13; i14 < i12; i14++) {
            this.components[i14] = null;
        }
        this.componentCount = i13;
    }

    private void shiftComps(int i10, int i11) {
        Component[] componentArr;
        int i12 = this.componentCount;
        int i13 = i12 + i11;
        Component[] componentArr2 = this.components;
        if (i13 > componentArr2.length) {
            int iMax = Math.max((i12 >> 1) + i12, i13);
            if (i10 == i12) {
                componentArr = (Component[]) Arrays.copyOf(this.components, iMax, Component[].class);
            } else {
                Component[] componentArr3 = new Component[iMax];
                if (i10 > 0) {
                    System.arraycopy(this.components, 0, componentArr3, 0, i10);
                }
                if (i10 < i12) {
                    System.arraycopy(this.components, i10, componentArr3, i11 + i10, i12 - i10);
                }
                componentArr = componentArr3;
            }
            this.components = componentArr;
        } else if (i10 < i12) {
            System.arraycopy(componentArr2, i10, componentArr2, i11 + i10, i12 - i10);
        }
        this.componentCount = i13;
    }

    private int toComponentIndex0(int i10) {
        int i11 = this.componentCount;
        int i12 = 0;
        if (i10 == 0) {
            for (int i13 = 0; i13 < i11; i13++) {
                if (this.components[i13].endOffset > 0) {
                    return i13;
                }
            }
        }
        if (i11 <= 2) {
            return (i11 == 1 || i10 < this.components[0].endOffset) ? 0 : 1;
        }
        while (i12 <= i11) {
            int i14 = (i12 + i11) >>> 1;
            Component component = this.components[i14];
            if (i10 >= component.endOffset) {
                i12 = i14 + 1;
            } else {
                if (i10 >= component.offset) {
                    return i14;
                }
                i11 = i14 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private void updateComponentOffsets(int i10) {
        int i11 = this.componentCount;
        if (i11 <= i10) {
            return;
        }
        int i12 = i10 > 0 ? this.components[i10 - 1].endOffset : 0;
        while (i10 < i11) {
            Component component = this.components[i10];
            component.reposition(i12);
            i12 = component.endOffset;
            i10++;
        }
    }

    public CompositeByteBuf addFlattenedComponents(boolean z10, ByteBuf byteBuf) {
        int i10;
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        int i11 = byteBuf.readerIndex();
        int iWriterIndex = byteBuf.writerIndex();
        if (i11 == iWriterIndex) {
            byteBuf.release();
            return this;
        }
        if (!(byteBuf instanceof CompositeByteBuf)) {
            addComponent0(z10, this.componentCount, byteBuf);
            consolidateIfNeeded();
            return this;
        }
        CompositeByteBuf compositeByteBuf = byteBuf instanceof WrappedCompositeByteBuf ? (CompositeByteBuf) byteBuf.unwrap() : (CompositeByteBuf) byteBuf;
        int i12 = iWriterIndex - i11;
        compositeByteBuf.checkIndex(i11, i12);
        Component[] componentArr = compositeByteBuf.components;
        int i13 = this.componentCount;
        int i14 = this.writerIndex;
        try {
            int componentIndex0 = compositeByteBuf.toComponentIndex0(i11);
            int iCapacity = capacity();
            while (true) {
                Component component = componentArr[componentIndex0];
                int iMax = Math.max(i11, component.offset);
                int iMin = Math.min(iWriterIndex, component.endOffset);
                int i15 = iMin - iMax;
                if (i15 > 0) {
                    i10 = iMin;
                    addComp(this.componentCount, new Component(component.srcBuf.retain(), component.srcIdx(iMax), component.buf, component.idx(iMax), iCapacity, i15, null));
                } else {
                    i10 = iMin;
                }
                if (iWriterIndex == i10) {
                    break;
                }
                iCapacity += i15;
                componentIndex0++;
            }
            if (z10) {
                this.writerIndex = i12 + i14;
            }
            consolidateIfNeeded();
            byteBuf.release();
            return this;
        } catch (Throwable th) {
            if (z10) {
                this.writerIndex = i14;
            }
            for (int i16 = this.componentCount - 1; i16 >= i13; i16--) {
                this.components[i16].free();
                removeComp(i16);
            }
            throw th;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (i10 == 1) {
            return this.components[0].buf.array();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return 0;
        }
        if (i10 != 1) {
            throw new UnsupportedOperationException();
        }
        Component component = this.components[0];
        return component.idx(component.buf.arrayOffset());
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        int i10 = this.componentCount;
        if (i10 > 0) {
            return this.components[i10 - 1].endOffset;
        }
        return 0;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf clear() {
        super.clear();
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        if (this.freed) {
            return;
        }
        this.freed = true;
        int i10 = this.componentCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.components[i11].free();
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        return discardReadComponents();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int i10) {
        super.ensureWritable(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        return this.components[0].buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (i10 != 1) {
            return false;
        }
        return this.components[0].buf.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        int i12 = this.componentCount;
        if (i12 == 0) {
            return EMPTY_NIO_BUFFER;
        }
        if (i12 == 1) {
            return this.components[0].internalNioBuffer(i10, i11);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf
    boolean isAccessible() {
        return !this.freed;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!this.components[i11].buf.isDirect()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (i10 != 1) {
            throw new UnsupportedOperationException();
        }
        Component component = this.components[0];
        return component.buf.memoryAddress() + ((long) component.adjustment);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        int i10 = this.componentCount;
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return this.components[0].buf.nioBufferCount();
        }
        int iNioBufferCount = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iNioBufferCount += this.components[i11].buf.nioBufferCount();
        }
        return iNioBufferCount;
    }

    public int numComponents() {
        return this.componentCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readerIndex(int i10) {
        super.readerIndex(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i10, int i11) {
        Component componentFindComponent = findComponent(i10);
        componentFindComponent.buf.setByte(componentFindComponent.idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setIndex(int i10, int i11) {
        super.setIndex(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i10, int i11) {
        checkIndex(i10, 4);
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i10, int i11) {
        checkIndex(i10, 3);
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i10, int i11) {
        checkIndex(i10, 2);
        _setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i10) {
        super.skipBytes(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i10) {
        ensureWritable0(1);
        int i11 = this.writerIndex;
        this.writerIndex = i11 + 1;
        _setByte(i11, i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i10) {
        super.writeInt(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i10) {
        super.writeMedium(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i10) {
        super.writeShort(i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writerIndex(int i10) {
        super.writerIndex(i10);
        return this;
    }

    private void checkComponentIndex(int i10) {
        ensureAccessible();
        if (i10 >= 0 && i10 <= this.componentCount) {
        } else {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", Integer.valueOf(i10), Integer.valueOf(this.componentCount)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    private Component newComponent(ByteBuf byteBuf, int i10) {
        int i11;
        int iIdx;
        ByteBuf byteBuf2;
        int i12 = byteBuf.readerIndex();
        int i13 = byteBuf.readableBytes();
        ByteBuf byteBufUnwrap = byteBuf;
        while (true) {
            if (!(byteBufUnwrap instanceof WrappedByteBuf) && !(byteBufUnwrap instanceof SwappedByteBuf)) {
                break;
            }
            int i14 = i10;
            byteBufUnwrap = byteBufUnwrap.unwrap();
            i10 = i14;
        }
        if (byteBufUnwrap instanceof AbstractUnpooledSlicedByteBuf) {
            iIdx = ((AbstractUnpooledSlicedByteBuf) byteBufUnwrap).idx(0) + i12;
            byteBufUnwrap = byteBufUnwrap.unwrap();
        } else {
            if (byteBufUnwrap instanceof PooledSlicedByteBuf) {
                iIdx = ((PooledSlicedByteBuf) byteBufUnwrap).adjustment + i12;
                byteBufUnwrap = byteBufUnwrap.unwrap();
            } else {
                if ((byteBufUnwrap instanceof DuplicatedByteBuf) || (byteBufUnwrap instanceof PooledDuplicatedByteBuf)) {
                    byteBufUnwrap = byteBufUnwrap.unwrap();
                }
                i11 = i12;
            }
            if (byteBuf.capacity() == i13) {
                byteBuf2 = byteBuf;
            } else {
                byteBuf2 = null;
            }
            ByteBuf byteBuf3 = byteBufUnwrap;
            ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
            return new Component(byteBuf.order(byteOrder), i12, byteBuf3.order(byteOrder), i11, i10, i13, byteBuf2);
        }
        i11 = iIdx;
        if (byteBuf.capacity() == i13) {
            byteBuf2 = byteBuf;
        } else {
            byteBuf2 = null;
        }
        ByteBuf byteBuf4 = byteBufUnwrap;
        ByteOrder byteOrder2 = ByteOrder.BIG_ENDIAN;
        return new Component(byteBuf.order(byteOrder2), i12, byteBuf4.order(byteOrder2), i11, i10, i13, byteBuf2);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        return componentFindComponent0.buf.getByte(componentFindComponent0.idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 4 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getInt(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i10 + 2) & 65535) | ((_getShort(i10) & 65535) << 16);
        }
        return ((_getShort(i10 + 2) & 65535) << 16) | (_getShort(i10) & 65535);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 4 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getIntLE(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i10 + 2) & 65535) << 16) | (_getShortLE(i10) & 65535);
        }
        return (_getShortLE(i10 + 2) & 65535) | ((_getShortLE(i10) & 65535) << 16);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 8 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getLong(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((((long) _getInt(i10)) & 4294967295L) << 32) | (4294967295L & ((long) _getInt(i10 + 4)));
        }
        return (((long) _getInt(i10)) & 4294967295L) | ((4294967295L & ((long) _getInt(i10 + 4))) << 32);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 2 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getShort(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i10 + 1) & 255) | ((_getByte(i10) & 255) << 8));
        }
        return (short) (((_getByte(i10 + 1) & 255) << 8) | (_getByte(i10) & 255));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 2 <= componentFindComponent0.endOffset) {
            return componentFindComponent0.buf.getShortLE(componentFindComponent0.idx(i10));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i10 + 1) & 255) << 8) | (_getByte(i10) & 255));
        }
        return (short) ((_getByte(i10 + 1) & 255) | ((_getByte(i10) & 255) << 8));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        componentFindComponent0.buf.setByte(componentFindComponent0.idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 4 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setInt(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i10, (short) (i11 >>> 16));
            _setShort(i10 + 2, (short) i11);
        } else {
            _setShort(i10, (short) i11);
            _setShort(i10 + 2, (short) (i11 >>> 16));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 3 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setMedium(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i10, (short) (i11 >> 8));
            _setByte(i10 + 2, (byte) i11);
        } else {
            _setShort(i10, (short) i11);
            _setByte(i10 + 2, (byte) (i11 >>> 16));
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        Component componentFindComponent0 = findComponent0(i10);
        if (i10 + 2 <= componentFindComponent0.endOffset) {
            componentFindComponent0.buf.setShort(componentFindComponent0.idx(i10), i11);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i10, (byte) (i11 >>> 8));
            _setByte(i10 + 1, (byte) i11);
        } else {
            _setByte(i10, (byte) i11);
            _setByte(i10 + 1, (byte) (i11 >>> 8));
        }
    }

    public CompositeByteBuf discardReadComponents() {
        ensureAccessible();
        int i10 = readerIndex();
        if (i10 != 0) {
            int iWriterIndex = writerIndex();
            if (i10 == iWriterIndex && iWriterIndex == capacity()) {
                int i11 = this.componentCount;
                for (int i12 = 0; i12 < i11; i12++) {
                    this.components[i12].free();
                }
                this.lastAccessed = null;
                clearComps();
                setIndex(0, 0);
                adjustMarkers(i10);
                return this;
            }
            int i13 = this.componentCount;
            Component component = null;
            int i14 = 0;
            while (i14 < i13) {
                component = this.components[i14];
                if (component.endOffset > i10) {
                    break;
                }
                component.free();
                i14++;
            }
            if (i14 != 0) {
                Component component2 = this.lastAccessed;
                if (component2 != null && component2.endOffset <= i10) {
                    this.lastAccessed = null;
                }
                removeCompRange(0, i14);
                int i15 = component.offset;
                updateComponentOffsets(0);
                setIndex(i10 - i15, iWriterIndex - i15);
                adjustMarkers(i15);
                return this;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        Component componentFindComponent = findComponent(i10);
        return componentFindComponent.buf.getByte(componentFindComponent.idx(i10));
    }

    public Iterator<ByteBuf> iterator() {
        ensureAccessible();
        if (this.componentCount == 0) {
            return EMPTY_ITERATOR;
        }
        return new CompositeByteBufIterator();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        int i12 = this.componentCount;
        if (i12 != 0) {
            if (i12 == 1) {
                Component component = this.components[0];
                ByteBuf byteBuf = component.buf;
                if (byteBuf.nioBufferCount() == 1) {
                    return byteBuf.nioBuffer(component.idx(i10), i11);
                }
            }
            ByteBuffer[] byteBufferArrNioBuffers = nioBuffers(i10, i11);
            if (byteBufferArrNioBuffers.length == 1) {
                return byteBufferArrNioBuffers[0];
            }
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(i11).order(order());
            for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
                byteBufferOrder.put(byteBuffer);
            }
            byteBufferOrder.flip();
            return byteBufferOrder;
        }
        return EMPTY_NIO_BUFFER;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i10) {
        super.readBytes(byteBuf, i10);
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        String string = super.toString();
        return string.substring(0, string.length() - 1) + ", components=" + this.componentCount + ')';
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i10) {
        checkNewCapacity(i10);
        int i11 = this.componentCount;
        int iCapacity = capacity();
        if (i10 > iCapacity) {
            int i12 = i10 - iCapacity;
            addComponent0(false, i11, allocBuffer(i12).setIndex(0, i12));
            if (this.componentCount >= this.maxNumComponents) {
                consolidateIfNeeded();
                return this;
            }
        } else if (i10 < iCapacity) {
            this.lastAccessed = null;
            int i13 = i11 - 1;
            int i14 = iCapacity - i10;
            while (i13 >= 0) {
                Component component = this.components[i13];
                int length = component.length();
                if (i14 < length) {
                    component.endOffset -= i14;
                    ByteBuf byteBuf = component.slice;
                    if (byteBuf == null) {
                        break;
                    }
                    component.slice = byteBuf.slice(0, component.length());
                    break;
                }
                component.free();
                i14 -= length;
                i13--;
            }
            removeCompRange(i13 + 1, i11);
            if (readerIndex() > i10) {
                setIndex0(i10, i10);
                return this;
            }
            if (this.writerIndex > i10) {
                this.writerIndex = i10;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkDstIndex(i10, i12, i11, bArr.length);
        if (i12 != 0) {
            int componentIndex0 = toComponentIndex0(i10);
            while (i12 > 0) {
                Component component = this.components[componentIndex0];
                int iMin = Math.min(i12, component.endOffset - i10);
                component.buf.getBytes(component.idx(i10), bArr, i11, iMin);
                i10 += iMin;
                i11 += iMin;
                i12 -= iMin;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i10, int i11) {
        super.readBytes(byteBuf, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, bArr.length);
        if (i12 != 0) {
            int componentIndex0 = toComponentIndex0(i10);
            while (i12 > 0) {
                Component component = this.components[componentIndex0];
                int iMin = Math.min(i12, component.endOffset - i10);
                component.buf.setBytes(component.idx(i10), bArr, i11, iMin);
                i10 += iMin;
                i11 += iMin;
                i12 -= iMin;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        super.writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z10, int i10) {
        this(byteBufAllocator, z10, i10, 0);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i10) {
        super.writeBytes(byteBuf, i10);
        return this;
    }

    CompositeByteBuf(ByteBufAllocator byteBufAllocator) {
        super(Integer.MAX_VALUE);
        this.alloc = byteBufAllocator;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = null;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11) {
        super.writeBytes(byteBuf, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (i12 != 0) {
            int componentIndex0 = toComponentIndex0(i10);
            while (i12 > 0) {
                Component component = this.components[componentIndex0];
                int iMin = Math.min(i12, component.endOffset - i10);
                component.buf.getBytes(component.idx(i10), byteBuf, i11, iMin);
                i10 += iMin;
                i11 += iMin;
                i12 -= iMin;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, byteBuf.capacity());
        if (i12 != 0) {
            int componentIndex0 = toComponentIndex0(i10);
            while (i12 > 0) {
                Component component = this.components[componentIndex0];
                int iMin = Math.min(i12, component.endOffset - i10);
                component.buf.setBytes(component.idx(i10), byteBuf, i11, iMin);
                i10 += iMin;
                i11 += iMin;
                i12 -= iMin;
                componentIndex0++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        super.writeBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i10, int i11) {
        super.writeBytes(bArr, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i10, i11));
        }
        long jWrite = gatheringByteChannel.write(nioBuffers(i10, i11));
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001e A[PHI: r1 r6 r8
      0x001e: PHI (r1v4 int) = (r1v1 int), (r1v2 int) binds: [B:8:0x001c, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r6v5 int) = (r6v1 int), (r6v3 int) binds: [B:8:0x001c, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r8v4 int) = (r8v1 int), (r8v2 int) binds: [B:8:0x001c, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return inputStream.read(EmptyArrays.EMPTY_BYTES);
        }
        int componentIndex0 = toComponentIndex0(i10);
        int i12 = 0;
        do {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i11, component.endOffset - i10);
            if (iMin != 0) {
                int bytes = component.buf.setBytes(component.idx(i10), inputStream, iMin);
                if (bytes < 0) {
                    if (i12 == 0) {
                        return -1;
                    }
                    return i12;
                }
                i10 += bytes;
                i11 -= bytes;
                i12 += bytes;
                if (bytes == iMin) {
                    componentIndex0++;
                }
            } else {
                componentIndex0++;
            }
        } while (i11 > 0);
        return i12;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(readerIndex(), readableBytes());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i10, byte[] bArr) {
        return getBytes(i10, bArr, 0, bArr.length);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001e A[PHI: r1 r6 r8
      0x001e: PHI (r1v4 int) = (r1v1 int), (r1v2 int) binds: [B:8:0x001c, B:19:0x0038] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r6v5 int) = (r6v1 int), (r6v3 int) binds: [B:8:0x001c, B:19:0x0038] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r8v4 int) = (r8v1 int), (r8v2 int) binds: [B:8:0x001c, B:19:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return scatteringByteChannel.read(EMPTY_NIO_BUFFER);
        }
        int componentIndex0 = toComponentIndex0(i10);
        int i12 = 0;
        do {
            Component component = this.components[componentIndex0];
            int iMin = Math.min(i11, component.endOffset - i10);
            if (iMin != 0) {
                int bytes = component.buf.setBytes(component.idx(i10), scatteringByteChannel, iMin);
                if (bytes != 0) {
                    if (bytes >= 0) {
                        i10 += bytes;
                        i11 -= bytes;
                        i12 += bytes;
                        if (bytes == iMin) {
                            componentIndex0++;
                        }
                    } else if (i12 == 0) {
                        return -1;
                    }
                }
                return i12;
            }
            componentIndex0++;
        } while (i11 > 0);
        return i12;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public CompositeByteBuf setBytes(int i10, byte[] bArr) {
        return setBytes(i10, bArr, 0, bArr.length);
    }
}
