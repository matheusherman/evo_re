package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class ByteToMessageDecoder extends ChannelInboundHandlerAdapter {
    ByteBuf cumulation;
    private Cumulator cumulator = MERGE_CUMULATOR;
    private byte decodeState = 0;
    private int discardAfterReads = 16;
    private boolean firedChannelRead;
    private boolean first;
    private int numReads;
    private boolean selfFiredChannelRead;
    private boolean singleDecode;
    public static final Cumulator MERGE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.1
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            if (!byteBuf.isReadable() && byteBuf2.isContiguous()) {
                byteBuf.release();
                return byteBuf2;
            }
            try {
                int i10 = byteBuf2.readableBytes();
                if (i10 <= byteBuf.maxWritableBytes() && (i10 <= byteBuf.maxFastWritableBytes() || byteBuf.refCnt() <= 1)) {
                    if (!byteBuf.isReadOnly()) {
                        byteBuf.writeBytes(byteBuf2, byteBuf2.readerIndex(), i10);
                        byteBuf2.readerIndex(byteBuf2.writerIndex());
                        return byteBuf;
                    }
                }
                return ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2);
            } finally {
                byteBuf2.release();
            }
        }
    };
    public static final Cumulator COMPOSITE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.2
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
            Throwable th;
            CompositeByteBuf compositeByteBufAddFlattenedComponents;
            if (!byteBuf.isReadable()) {
                byteBuf.release();
                return byteBuf2;
            }
            CompositeByteBuf compositeByteBuf = null;
            try {
                if ((byteBuf instanceof CompositeByteBuf) && byteBuf.refCnt() == 1) {
                    compositeByteBufAddFlattenedComponents = (CompositeByteBuf) byteBuf;
                    try {
                        if (compositeByteBufAddFlattenedComponents.writerIndex() != compositeByteBufAddFlattenedComponents.capacity()) {
                            compositeByteBufAddFlattenedComponents.capacity(compositeByteBufAddFlattenedComponents.writerIndex());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteBuf2 != null) {
                            byteBuf2.release();
                            if (compositeByteBufAddFlattenedComponents != null && compositeByteBufAddFlattenedComponents != byteBuf) {
                                compositeByteBufAddFlattenedComponents.release();
                            }
                        }
                        throw th;
                    }
                } else {
                    compositeByteBufAddFlattenedComponents = byteBufAllocator.compositeBuffer(Integer.MAX_VALUE).addFlattenedComponents(true, byteBuf);
                }
                compositeByteBuf = compositeByteBufAddFlattenedComponents;
                compositeByteBuf.addFlattenedComponents(true, byteBuf2);
                return compositeByteBuf;
            } catch (Throwable th3) {
                CompositeByteBuf compositeByteBuf2 = compositeByteBuf;
                th = th3;
                compositeByteBufAddFlattenedComponents = compositeByteBuf2;
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface Cumulator {
        ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);
    }

    private void channelInputClosed(ChannelHandlerContext channelHandlerContext, boolean z10) {
        CodecOutputList codecOutputListNewInstance = CodecOutputList.newInstance();
        try {
            try {
                channelInputClosed(channelHandlerContext, codecOutputListNewInstance);
                try {
                    ByteBuf byteBuf = this.cumulation;
                    if (byteBuf != null) {
                        byteBuf.release();
                        this.cumulation = null;
                    }
                    int size = codecOutputListNewInstance.size();
                    fireChannelRead(channelHandlerContext, codecOutputListNewInstance, size);
                    if (size > 0) {
                        channelHandlerContext.fireChannelReadComplete();
                    }
                    if (z10) {
                        channelHandlerContext.fireChannelInactive();
                    }
                } finally {
                    codecOutputListNewInstance.recycle();
                }
            } catch (DecoderException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new DecoderException(e11);
            }
        } catch (Throwable th) {
            try {
                ByteBuf byteBuf2 = this.cumulation;
                if (byteBuf2 != null) {
                    byteBuf2.release();
                    this.cumulation = null;
                }
                int size2 = codecOutputListNewInstance.size();
                fireChannelRead(channelHandlerContext, codecOutputListNewInstance, size2);
                if (size2 > 0) {
                    channelHandlerContext.fireChannelReadComplete();
                }
                if (z10) {
                    channelHandlerContext.fireChannelInactive();
                }
                throw th;
            } finally {
                codecOutputListNewInstance.recycle();
            }
        }
    }

    static void fireChannelRead(ChannelHandlerContext channelHandlerContext, List<Object> list, int i10) {
        if (list instanceof CodecOutputList) {
            fireChannelRead(channelHandlerContext, (CodecOutputList) list, i10);
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            channelHandlerContext.fireChannelRead(list.get(i11));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        channelInputClosed(channelHandlerContext, true);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        this.numReads = 0;
        discardSomeReadBytes();
        if (this.selfFiredChannelRead && !this.firedChannelRead && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        this.firedChannelRead = false;
        channelHandlerContext.fireChannelReadComplete();
    }

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list);

    final void decodeRemovalReentryProtection(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        boolean z10 = true;
        this.decodeState = (byte) 1;
        try {
            decode(channelHandlerContext, byteBuf, list);
        } finally {
            z10 = this.decodeState == 2;
            this.decodeState = (byte) 0;
            if (z10) {
                fireChannelRead(channelHandlerContext, list, list.size());
                list.clear();
                handlerRemoved(channelHandlerContext);
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (!(obj instanceof ByteBuf)) {
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        this.selfFiredChannelRead = true;
        CodecOutputList codecOutputListNewInstance = CodecOutputList.newInstance();
        try {
            try {
                this.first = this.cumulation == null;
                ByteBuf byteBufCumulate = this.cumulator.cumulate(channelHandlerContext.alloc(), this.first ? Unpooled.EMPTY_BUFFER : this.cumulation, (ByteBuf) obj);
                this.cumulation = byteBufCumulate;
                callDecode(channelHandlerContext, byteBufCumulate, codecOutputListNewInstance);
                try {
                    ByteBuf byteBuf = this.cumulation;
                    if (byteBuf == null || byteBuf.isReadable()) {
                        int i10 = this.numReads + 1;
                        this.numReads = i10;
                        if (i10 >= this.discardAfterReads) {
                            this.numReads = 0;
                            discardSomeReadBytes();
                        }
                    } else {
                        this.numReads = 0;
                        try {
                            this.cumulation.release();
                            this.cumulation = null;
                        } catch (IllegalReferenceCountException e10) {
                            throw new IllegalReferenceCountException(getClass().getSimpleName() + "#decode() might have released its input buffer, or passed it down the pipeline without a retain() call, which is not allowed.", e10);
                        }
                    }
                    int size = codecOutputListNewInstance.size();
                    this.firedChannelRead |= codecOutputListNewInstance.insertSinceRecycled();
                    fireChannelRead(channelHandlerContext, codecOutputListNewInstance, size);
                    codecOutputListNewInstance.recycle();
                } catch (Throwable th) {
                    codecOutputListNewInstance.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    ByteBuf byteBuf2 = this.cumulation;
                    if (byteBuf2 == null || byteBuf2.isReadable()) {
                        int i11 = this.numReads + 1;
                        this.numReads = i11;
                        if (i11 >= this.discardAfterReads) {
                            this.numReads = 0;
                            discardSomeReadBytes();
                        }
                    } else {
                        this.numReads = 0;
                        try {
                            this.cumulation.release();
                            this.cumulation = null;
                        } catch (IllegalReferenceCountException e11) {
                            throw new IllegalReferenceCountException(getClass().getSimpleName() + "#decode() might have released its input buffer, or passed it down the pipeline without a retain() call, which is not allowed.", e11);
                        }
                    }
                    int size2 = codecOutputListNewInstance.size();
                    this.firedChannelRead |= codecOutputListNewInstance.insertSinceRecycled();
                    fireChannelRead(channelHandlerContext, codecOutputListNewInstance, size2);
                    codecOutputListNewInstance.recycle();
                    throw th2;
                } catch (Throwable th3) {
                    codecOutputListNewInstance.recycle();
                    throw th3;
                }
            }
        } catch (DecoderException e12) {
            throw e12;
        } catch (Exception e13) {
            throw new DecoderException(e13);
        }
    }

    protected final void discardSomeReadBytes() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf == null || this.first || byteBuf.refCnt() != 1) {
            return;
        }
        this.cumulation.discardSomeReadBytes();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        if (this.decodeState == 1) {
            this.decodeState = (byte) 2;
            return;
        }
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            this.cumulation = null;
            this.numReads = 0;
            if (byteBuf.readableBytes() > 0) {
                channelHandlerContext.fireChannelRead(byteBuf);
                channelHandlerContext.fireChannelReadComplete();
            } else {
                byteBuf.release();
            }
        }
        handlerRemoved0(channelHandlerContext);
    }

    public boolean isSingleDecode() {
        return this.singleDecode;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof ChannelInputShutdownEvent) {
            channelInputClosed(channelHandlerContext, false);
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    protected ByteToMessageDecoder() {
        ensureNotSharable();
    }

    static ByteBuf expandCumulation(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
        int i10 = byteBuf.readableBytes();
        int i11 = byteBuf2.readableBytes();
        int i12 = i10 + i11;
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(byteBufAllocator.calculateNewCapacity(i12, Integer.MAX_VALUE));
        try {
            byteBufBuffer.setBytes(0, byteBuf, byteBuf.readerIndex(), i10).setBytes(i10, byteBuf2, byteBuf2.readerIndex(), i11).writerIndex(i12);
            byteBuf2.readerIndex(byteBuf2.writerIndex());
            byteBuf.release();
            return byteBufBuffer;
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }

    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        while (byteBuf.isReadable()) {
            try {
                int size = list.size();
                if (size > 0) {
                    fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    }
                }
                int i10 = byteBuf.readableBytes();
                decodeRemovalReentryProtection(channelHandlerContext, byteBuf, list);
                if (!channelHandlerContext.isRemoved()) {
                    if (list.isEmpty()) {
                        if (i10 == byteBuf.readableBytes()) {
                            return;
                        }
                    } else if (i10 != byteBuf.readableBytes()) {
                        if (isSingleDecode()) {
                            return;
                        }
                    } else {
                        throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() did not read anything but decoded a message.");
                    }
                } else {
                    return;
                }
            } catch (DecoderException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new DecoderException(e11);
            }
        }
    }

    protected void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.isReadable()) {
            decodeRemovalReentryProtection(channelHandlerContext, byteBuf, list);
        }
    }

    static void fireChannelRead(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            channelHandlerContext.fireChannelRead(codecOutputList.getUnsafe(i11));
        }
    }

    protected void handlerRemoved0(ChannelHandlerContext channelHandlerContext) {
    }

    void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            callDecode(channelHandlerContext, byteBuf, list);
            if (channelHandlerContext.isRemoved()) {
                return;
            }
            ByteBuf byteBuf2 = this.cumulation;
            if (byteBuf2 == null) {
                byteBuf2 = Unpooled.EMPTY_BUFFER;
            }
            decodeLast(channelHandlerContext, byteBuf2, list);
            return;
        }
        decodeLast(channelHandlerContext, Unpooled.EMPTY_BUFFER, list);
    }
}
