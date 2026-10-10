package io.netty.channel;

import io.netty.util.internal.InternalThreadLocalMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class ChannelHandlerAdapter implements ChannelHandler {
    boolean added;

    protected void ensureNotSharable() {
        if (!isSharable()) {
            return;
        }
        throw new IllegalStateException("ChannelHandler " + getClass().getName() + " is not allowed to be shared");
    }

    @Override // io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    @Deprecated
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.fireExceptionCaught(th);
    }

    public boolean isSharable() {
        Class<?> cls = getClass();
        Map<Class<?>, Boolean> mapHandlerSharableCache = InternalThreadLocalMap.get().handlerSharableCache();
        Boolean boolValueOf = mapHandlerSharableCache.get(cls);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(cls.isAnnotationPresent(ChannelHandler.a.class));
            mapHandlerSharableCache.put(cls, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
    }
}
