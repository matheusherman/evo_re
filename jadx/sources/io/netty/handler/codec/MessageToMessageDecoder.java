package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class MessageToMessageDecoder<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, I i10, List<Object> list);

    public boolean acceptInboundMessage(Object obj) {
        return this.matcher.match(obj);
    }

    protected MessageToMessageDecoder() {
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        CodecOutputList codecOutputListNewInstance = CodecOutputList.newInstance();
        int i10 = 0;
        try {
            try {
                try {
                    if (acceptInboundMessage(obj)) {
                        try {
                            decode(channelHandlerContext, obj, codecOutputListNewInstance);
                            ReferenceCountUtil.release(obj);
                        } catch (Throwable th) {
                            ReferenceCountUtil.release(obj);
                            throw th;
                        }
                    } else {
                        codecOutputListNewInstance.add(obj);
                    }
                    try {
                        int size = codecOutputListNewInstance.size();
                        while (i10 < size) {
                            channelHandlerContext.fireChannelRead(codecOutputListNewInstance.getUnsafe(i10));
                            i10++;
                        }
                        codecOutputListNewInstance.recycle();
                    } catch (Throwable th2) {
                        codecOutputListNewInstance.recycle();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        int size2 = codecOutputListNewInstance.size();
                        while (i10 < size2) {
                            channelHandlerContext.fireChannelRead(codecOutputListNewInstance.getUnsafe(i10));
                            i10++;
                        }
                        codecOutputListNewInstance.recycle();
                        throw th3;
                    } catch (Throwable th4) {
                        codecOutputListNewInstance.recycle();
                        throw th4;
                    }
                }
            } catch (Exception e10) {
                throw new DecoderException(e10);
            }
        } catch (DecoderException e11) {
            throw e11;
        }
    }
}
