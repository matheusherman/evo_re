package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class MessageToByteEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean preferDirect;

    protected MessageToByteEncoder() {
        this(true);
    }

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, I i10, ByteBuf byteBuf);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        ReferenceCounted referenceCounted = null;
        try {
            try {
                if (!acceptOutboundMessage(obj)) {
                    channelHandlerContext.write(obj, channelPromise);
                    return;
                }
                ByteBuf byteBufAllocateBuffer = allocateBuffer(channelHandlerContext, obj, this.preferDirect);
                try {
                    encode(channelHandlerContext, obj, byteBufAllocateBuffer);
                    ReferenceCountUtil.release(obj);
                    if (byteBufAllocateBuffer.isReadable()) {
                        channelHandlerContext.write(byteBufAllocateBuffer, channelPromise);
                    } else {
                        byteBufAllocateBuffer.release();
                        channelHandlerContext.write(Unpooled.EMPTY_BUFFER, channelPromise);
                    }
                } catch (Throwable th) {
                    ReferenceCountUtil.release(obj);
                    throw th;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    referenceCounted.release();
                }
                throw th2;
            }
        } catch (EncoderException e10) {
            throw e10;
        } catch (Throwable th3) {
            throw new EncoderException(th3);
        }
    }

    protected MessageToByteEncoder(boolean z10) {
        this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
        this.preferDirect = z10;
    }

    public boolean acceptOutboundMessage(Object obj) {
        return this.matcher.match(obj);
    }

    protected ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, I i10, boolean z10) {
        return z10 ? channelHandlerContext.alloc().ioBuffer() : channelHandlerContext.alloc().heapBuffer();
    }
}
