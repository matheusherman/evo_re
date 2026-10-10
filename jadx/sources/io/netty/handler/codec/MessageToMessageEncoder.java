package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class MessageToMessageEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, I i10, List<Object> list);

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        CodecOutputList codecOutputListNewInstance = null;
        try {
            try {
                if (acceptOutboundMessage(obj)) {
                    codecOutputListNewInstance = CodecOutputList.newInstance();
                    try {
                        encode(channelHandlerContext, obj, codecOutputListNewInstance);
                    } catch (Throwable th) {
                        ReferenceCountUtil.safeRelease(obj);
                        PlatformDependent.throwException(th);
                    }
                    ReferenceCountUtil.release(obj);
                    if (codecOutputListNewInstance.isEmpty()) {
                        throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                    }
                } else {
                    channelHandlerContext.write(obj, channelPromise);
                }
                if (codecOutputListNewInstance != null) {
                    try {
                        int size = codecOutputListNewInstance.size() - 1;
                        if (size == 0) {
                            channelHandlerContext.write(codecOutputListNewInstance.getUnsafe(0), channelPromise);
                        } else if (size > 0) {
                            if (channelPromise == channelHandlerContext.voidPromise()) {
                                writeVoidPromise(channelHandlerContext, codecOutputListNewInstance);
                            } else {
                                writePromiseCombiner(channelHandlerContext, codecOutputListNewInstance, channelPromise);
                            }
                        }
                    } finally {
                        codecOutputListNewInstance.recycle();
                    }
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        int size2 = codecOutputListNewInstance.size() - 1;
                        if (size2 == 0) {
                            channelHandlerContext.write(codecOutputListNewInstance.getUnsafe(0), channelPromise);
                        } else if (size2 > 0) {
                            if (channelPromise == channelHandlerContext.voidPromise()) {
                                writeVoidPromise(channelHandlerContext, null);
                            } else {
                                writePromiseCombiner(channelHandlerContext, null, channelPromise);
                            }
                        }
                    } finally {
                        codecOutputListNewInstance.recycle();
                    }
                }
                throw th2;
            }
        } catch (EncoderException e10) {
            throw e10;
        } catch (Throwable th3) {
            throw new EncoderException(th3);
        }
    }

    private static void writePromiseCombiner(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList, ChannelPromise channelPromise) {
        PromiseCombiner promiseCombiner = new PromiseCombiner(channelHandlerContext.executor());
        for (int i10 = 0; i10 < codecOutputList.size(); i10++) {
            promiseCombiner.add(channelHandlerContext.write(codecOutputList.getUnsafe(i10)));
        }
        promiseCombiner.finish(channelPromise);
    }

    public boolean acceptOutboundMessage(Object obj) {
        return this.matcher.match(obj);
    }

    protected MessageToMessageEncoder() {
    }

    private static void writeVoidPromise(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList) {
        ChannelPromise channelPromiseVoidPromise = channelHandlerContext.voidPromise();
        for (int i10 = 0; i10 < codecOutputList.size(); i10++) {
            channelHandlerContext.write(codecOutputList.getUnsafe(i10), channelPromiseVoidPromise);
        }
    }
}
