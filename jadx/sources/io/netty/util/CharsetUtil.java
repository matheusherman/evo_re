package io.netty.util;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class CharsetUtil {
    private static final Charset[] CHARSETS;
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;

    public static CharsetEncoder encoder(Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2) {
        ObjectUtil.checkNotNull(charset, "charset");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction2);
        return charsetEncoderNewEncoder;
    }

    static {
        Charset charsetForName = Charset.forName("UTF-16");
        UTF_16 = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16BE");
        UTF_16BE = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16LE");
        UTF_16LE = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-8");
        UTF_8 = charsetForName4;
        Charset charsetForName5 = Charset.forName("ISO-8859-1");
        ISO_8859_1 = charsetForName5;
        Charset charsetForName6 = Charset.forName("US-ASCII");
        US_ASCII = charsetForName6;
        CHARSETS = new Charset[]{charsetForName, charsetForName2, charsetForName3, charsetForName4, charsetForName5, charsetForName6};
    }

    public static CharsetEncoder encoder(Charset charset) {
        ObjectUtil.checkNotNull(charset, "charset");
        Map<Charset, CharsetEncoder> mapCharsetEncoderCache = InternalThreadLocalMap.get().charsetEncoderCache();
        CharsetEncoder charsetEncoder = mapCharsetEncoderCache.get(charset);
        if (charsetEncoder != null) {
            CharsetEncoder charsetEncoderReset = charsetEncoder.reset();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            charsetEncoderReset.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
            return charsetEncoder;
        }
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderEncoder = encoder(charset, codingErrorAction2, codingErrorAction2);
        mapCharsetEncoderCache.put(charset, charsetEncoderEncoder);
        return charsetEncoderEncoder;
    }
}
