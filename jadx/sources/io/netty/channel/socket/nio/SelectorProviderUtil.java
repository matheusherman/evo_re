package io.netty.channel.socket.nio;

import c8.k;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class SelectorProviderUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelectorProviderUtil.class);

    static <C extends Channel> C newChannel(Method method, SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) throws IOException {
        if (internetProtocolFamily == null || method == null) {
            return null;
        }
        try {
            return (C) method.invoke(selectorProvider, ProtocolFamilyConverter.convert(internetProtocolFamily));
        } catch (IllegalAccessException e10) {
            throw new IOException(e10);
        } catch (InvocationTargetException e11) {
            throw new IOException(e11);
        }
    }

    private SelectorProviderUtil() {
    }

    static Method findOpenMethod(String str) {
        if (PlatformDependent.javaVersion() >= 15) {
            try {
                return SelectorProvider.class.getMethod(str, k.a());
            } catch (Throwable th) {
                logger.debug("SelectorProvider.{}(ProtocolFamily) not available, will use default", str, th);
                return null;
            }
        }
        return null;
    }
}
