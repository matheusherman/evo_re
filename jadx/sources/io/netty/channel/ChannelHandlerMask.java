package io.netty.channel;

import androidx.core.app.FrameMetricsAggregator;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketAddress;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class ChannelHandlerMask {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelHandlerMask.class);
    private static final FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>> MASKS = new FastThreadLocal<Map<Class<? extends ChannelHandler>, Integer>>() { // from class: io.netty.channel.ChannelHandlerMask.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Map<Class<? extends ChannelHandler>, Integer> initialValue() {
            return new WeakHashMap(32);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface a {
    }

    private static boolean isSkippable(final Class<?> cls, final String str, final Class<?>... clsArr) {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() { // from class: io.netty.channel.ChannelHandlerMask.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedExceptionAction
            public Boolean run() {
                try {
                    return Boolean.valueOf(cls.getMethod(str, clsArr).isAnnotationPresent(a.class));
                } catch (NoSuchMethodException e10) {
                    if (ChannelHandlerMask.logger.isDebugEnabled()) {
                        ChannelHandlerMask.logger.debug("Class {} missing method {}, assume we can not skip execution", cls, str, e10);
                    }
                    return Boolean.FALSE;
                }
            }
        })).booleanValue();
    }

    static int mask(Class<? extends ChannelHandler> cls) {
        Map<Class<? extends ChannelHandler>, Integer> map = MASKS.get();
        Integer numValueOf = map.get(cls);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(mask0(cls));
            map.put(cls, numValueOf);
        }
        return numValueOf.intValue();
    }

    private static int mask0(Class<? extends ChannelHandler> cls) {
        int i10;
        int i11 = 1;
        try {
            if (ChannelInboundHandler.class.isAssignableFrom(cls)) {
                i10 = FrameMetricsAggregator.EVERY_DURATION;
                try {
                    if (isSkippable(cls, "channelRegistered", ChannelHandlerContext.class)) {
                        i10 = 509;
                    }
                    try {
                        if (isSkippable(cls, "channelUnregistered", ChannelHandlerContext.class)) {
                            i10 &= -5;
                        }
                        if (isSkippable(cls, "channelActive", ChannelHandlerContext.class)) {
                            i10 &= -9;
                        }
                        if (isSkippable(cls, "channelInactive", ChannelHandlerContext.class)) {
                            i10 &= -17;
                        }
                        if (isSkippable(cls, "channelRead", ChannelHandlerContext.class, Object.class)) {
                            i10 &= -33;
                        }
                        if (isSkippable(cls, "channelReadComplete", ChannelHandlerContext.class)) {
                            i10 &= -65;
                        }
                        if (isSkippable(cls, "channelWritabilityChanged", ChannelHandlerContext.class)) {
                            i10 &= -257;
                        }
                        if (isSkippable(cls, "userEventTriggered", ChannelHandlerContext.class, Object.class)) {
                            i10 &= -129;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        i11 = i10;
                        PlatformDependent.throwException(e);
                        return i11;
                    }
                } catch (Exception e11) {
                    e = e11;
                    i11 = FrameMetricsAggregator.EVERY_DURATION;
                    PlatformDependent.throwException(e);
                    return i11;
                }
            } else {
                i10 = 1;
            }
            if (ChannelOutboundHandler.class.isAssignableFrom(cls)) {
                i10 |= 130561;
                if (isSkippable(cls, "bind", ChannelHandlerContext.class, SocketAddress.class, ChannelPromise.class)) {
                    i10 &= -513;
                }
                if (isSkippable(cls, "connect", ChannelHandlerContext.class, SocketAddress.class, SocketAddress.class, ChannelPromise.class)) {
                    i10 &= -1025;
                }
                if (isSkippable(cls, "disconnect", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i10 &= -2049;
                }
                if (isSkippable(cls, "close", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i10 &= -4097;
                }
                if (isSkippable(cls, "deregister", ChannelHandlerContext.class, ChannelPromise.class)) {
                    i10 &= -8193;
                }
                if (isSkippable(cls, "read", ChannelHandlerContext.class)) {
                    i10 &= -16385;
                }
                if (isSkippable(cls, "write", ChannelHandlerContext.class, Object.class, ChannelPromise.class)) {
                    i10 = (-32769) & i10;
                }
                if (isSkippable(cls, "flush", ChannelHandlerContext.class)) {
                    i10 &= -65537;
                }
            }
            return isSkippable(cls, "exceptionCaught", ChannelHandlerContext.class, Throwable.class) ? i10 & (-2) : i10;
        } catch (Exception e12) {
            e = e12;
        }
    }

    private ChannelHandlerMask() {
    }
}
