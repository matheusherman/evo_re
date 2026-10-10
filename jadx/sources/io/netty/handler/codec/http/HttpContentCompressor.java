package io.netty.handler.codec.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import io.netty.util.internal.ObjectUtil;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class HttpContentCompressor extends HttpContentEncoder {
    private final int compressionLevel;
    private final int contentSizeThreshold;
    private ChannelHandlerContext ctx;
    private final Map<String, CompressionEncoderFactory> factories;
    private final int memLevel;
    private final boolean supportsCompressionOptions;
    private final int windowBits;

    public HttpContentCompressor() {
        this(6);
    }

    /* JADX INFO: renamed from: io.netty.handler.codec.http.HttpContentCompressor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Deprecated
    public HttpContentCompressor(int i10) {
        this(i10, 15, 8, 0);
    }

    @Override // io.netty.handler.codec.http.HttpContentEncoder
    protected HttpContentEncoder.Result beginEncode(HttpResponse httpResponse, String str) {
        String str2;
        if ((this.contentSizeThreshold > 0 && (httpResponse instanceof HttpContent) && ((HttpContent) httpResponse).content().readableBytes() < this.contentSizeThreshold) || httpResponse.headers().get(HttpHeaderNames.CONTENT_ENCODING) != null) {
            return null;
        }
        if (this.supportsCompressionOptions) {
            String strDetermineEncoding = determineEncoding(str);
            if (strDetermineEncoding == null) {
                return null;
            }
            CompressionEncoderFactory compressionEncoderFactory = this.factories.get(strDetermineEncoding);
            if (compressionEncoderFactory != null) {
                return new HttpContentEncoder.Result(strDetermineEncoding, new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), compressionEncoderFactory.createEncoder()));
            }
            throw new Error();
        }
        ZlibWrapper zlibWrapperDetermineWrapper = determineWrapper(str);
        if (zlibWrapperDetermineWrapper == null) {
            return null;
        }
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapperDetermineWrapper.ordinal()];
        if (i10 == 1) {
            str2 = "gzip";
        } else {
            if (i10 != 2) {
                throw new Error();
            }
            str2 = "deflate";
        }
        return new HttpContentEncoder.Result(str2, new EmbeddedChannel(this.ctx.channel().id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibEncoder(zlibWrapperDetermineWrapper, this.compressionLevel, this.windowBits, this.memLevel)));
    }

    protected String determineEncoding(String str) {
        float f10;
        float f11 = -1.0f;
        float f12 = -1.0f;
        float f13 = -1.0f;
        float f14 = -1.0f;
        for (String str2 : str.split(",")) {
            int iIndexOf = str2.indexOf(61);
            if (iIndexOf != -1) {
                try {
                    f10 = Float.parseFloat(str2.substring(iIndexOf + 1));
                } catch (NumberFormatException unused) {
                    f10 = 0.0f;
                }
            } else {
                f10 = 1.0f;
            }
            if (!str2.contains("*")) {
                if (str2.contains("br") && f10 > f11) {
                    f11 = f10;
                } else if (str2.contains("zstd") && f10 > f12) {
                    f12 = f10;
                } else if (str2.contains("gzip") && f10 > f13) {
                    f13 = f10;
                } else if (str2.contains("deflate") && f10 > f14) {
                    f14 = f10;
                }
            }
        }
        return null;
    }

    @Deprecated
    protected ZlibWrapper determineWrapper(String str) {
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        int i10 = 0;
        float f10 = -1.0f;
        float f11 = -1.0f;
        float f12 = -1.0f;
        while (true) {
            float f13 = 0.0f;
            if (i10 >= length) {
                break;
            }
            String str2 = strArrSplit[i10];
            int iIndexOf = str2.indexOf(61);
            if (iIndexOf != -1) {
                try {
                    f13 = Float.parseFloat(str2.substring(iIndexOf + 1));
                } catch (NumberFormatException unused) {
                }
            } else {
                f13 = 1.0f;
            }
            if (str2.contains("*")) {
                f12 = f13;
            } else if (str2.contains("gzip") && f13 > f10) {
                f10 = f13;
            } else if (str2.contains("deflate") && f13 > f11) {
                f11 = f13;
            }
            i10++;
        }
        if (f10 > 0.0f || f11 > 0.0f) {
            return f10 >= f11 ? ZlibWrapper.GZIP : ZlibWrapper.ZLIB;
        }
        if (f12 <= 0.0f) {
            return null;
        }
        if (f10 == -1.0f) {
            return ZlibWrapper.GZIP;
        }
        if (f11 == -1.0f) {
            return ZlibWrapper.ZLIB;
        }
        return null;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    @Deprecated
    public HttpContentCompressor(int i10, int i11, int i12, int i13) {
        this.compressionLevel = ObjectUtil.checkInRange(i10, 0, 9, "compressionLevel");
        this.windowBits = ObjectUtil.checkInRange(i11, 9, 15, "windowBits");
        this.memLevel = ObjectUtil.checkInRange(i12, 1, 9, "memLevel");
        this.contentSizeThreshold = ObjectUtil.checkPositiveOrZero(i13, "contentSizeThreshold");
        this.factories = null;
        this.supportsCompressionOptions = false;
    }
}
