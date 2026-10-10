package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ZlibCodecFactory {
    private static final InternalLogger logger;
    private static final boolean noJdkZlibDecoder;
    private static final boolean noJdkZlibEncoder;
    private static final boolean supportsWindowSizeAndMemLevel;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ZlibCodecFactory.class);
        logger = internalLoggerFactory;
        boolean z10 = true;
        boolean z11 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibDecoder", PlatformDependent.javaVersion() < 7);
        noJdkZlibDecoder = z11;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibDecoder: {}", Boolean.valueOf(z11));
        boolean z12 = SystemPropertyUtil.getBoolean("io.netty.noJdkZlibEncoder", false);
        noJdkZlibEncoder = z12;
        internalLoggerFactory.debug("-Dio.netty.noJdkZlibEncoder: {}", Boolean.valueOf(z12));
        if (!z11 && PlatformDependent.javaVersion() < 7) {
            z10 = false;
        }
        supportsWindowSizeAndMemLevel = z10;
    }

    private ZlibCodecFactory() {
    }

    public static ZlibEncoder newZlibEncoder(ZlibWrapper zlibWrapper, int i10, int i11, int i12) {
        if (PlatformDependent.javaVersion() >= 7 && !noJdkZlibEncoder && i11 == 15 && i12 == 8) {
            return new JdkZlibEncoder(zlibWrapper, i10);
        }
        return new JZlibEncoder(zlibWrapper, i10, i11, i12);
    }
}
