package p3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f17324a = Charset.defaultCharset();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f17325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f17326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Charset f17327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f17328e;

    /* JADX WARN: Code duplicated, block: B:88:0x00e1 A[PHI: r19
      0x00e1: PHI (r19v6 boolean) = (r19v5 boolean), (r19v5 boolean), (r19v5 boolean), (r19v7 boolean), (r19v7 boolean), (r19v7 boolean) binds: [B:90:0x00e7, B:92:0x00eb, B:94:0x00ef, B:82:0x00d5, B:83:0x00d7, B:85:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    public static Charset a(byte[] bArr, Map<h3.e, ?> map) {
        boolean z10;
        boolean z11;
        boolean z12;
        byte b10;
        byte[] bArr2 = bArr;
        if (map != null) {
            h3.e eVar = h3.e.CHARACTER_SET;
            if (map.containsKey(eVar)) {
                return Charset.forName(map.get(eVar).toString());
            }
        }
        boolean z13 = true;
        int i10 = 0;
        if (bArr2.length > 2 && (((b10 = bArr2[0]) == -2 && bArr2[1] == -1) || (b10 == -1 && bArr2[1] == -2))) {
            return StandardCharsets.UTF_16;
        }
        int length = bArr2.length;
        boolean z14 = f17325b != null;
        boolean z15 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z16 = z14;
        int i11 = 0;
        boolean z17 = true;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i12 < length && (z13 || z16 || z17)) {
            byte b11 = bArr2[i12];
            int i22 = b11 & 255;
            if (z17) {
                if (i13 <= 0) {
                    z10 = z13;
                    if ((b11 & 128) != 0) {
                        if ((b11 & 64) != 0) {
                            int i23 = i13 + 1;
                            if ((b11 & 32) == 0) {
                                i15++;
                            } else {
                                i23 = i13 + 2;
                                if ((b11 & 16) == 0) {
                                    i16++;
                                } else {
                                    i13 += 3;
                                    if ((b11 & 8) == 0) {
                                        i17++;
                                    }
                                }
                            }
                            i13 = i23;
                        }
                    }
                } else if ((b11 & 128) == 0) {
                    z10 = z13;
                } else {
                    i13--;
                    z10 = z13;
                }
                z17 = false;
            } else {
                z10 = z13;
            }
            if (!z10) {
                z11 = z10;
            } else if (i22 <= 127 || i22 >= 160) {
                if (i22 > 159 && (i22 < 192 || i22 == 215 || i22 == 247)) {
                    i19++;
                }
                z11 = z10;
            } else {
                z11 = false;
            }
            if (!z16) {
                z12 = z11;
            } else if (i14 > 0) {
                z12 = z11;
                if (i22 < 64 || i22 == 127 || i22 > 252) {
                    z16 = false;
                } else {
                    i14--;
                }
            } else {
                z12 = z11;
                if (i22 == 128 || i22 == 160 || i22 > 239) {
                    z16 = false;
                } else if (i22 <= 160 || i22 >= 224) {
                    if (i22 > 127) {
                        i14++;
                        int i24 = i20 + 1;
                        if (i24 > i10) {
                            i10 = i24;
                            i20 = i10;
                        } else {
                            i20 = i24;
                        }
                    } else {
                        i20 = 0;
                    }
                    i21 = 0;
                } else {
                    i11++;
                    int i25 = i21 + 1;
                    if (i25 > i18) {
                        i18 = i25;
                        i21 = i18;
                    } else {
                        i21 = i25;
                    }
                    i20 = 0;
                }
            }
            i12++;
            bArr2 = bArr;
            z13 = z12;
        }
        boolean z18 = z13;
        if (z17 && i13 > 0) {
            z17 = false;
        }
        if (z16 && i14 > 0) {
            z16 = false;
        }
        if (z17 && (z15 || i15 + i16 + i17 > 0)) {
            return StandardCharsets.UTF_8;
        }
        if (z16 && (f17328e || i18 >= 3 || i10 >= 3)) {
            return f17325b;
        }
        if (z18 && z16) {
            return (!(i18 == 2 && i11 == 2) && i19 * 10 < length) ? StandardCharsets.ISO_8859_1 : f17325b;
        }
        if (z18) {
            return StandardCharsets.ISO_8859_1;
        }
        if (z16) {
            return f17325b;
        }
        return z17 ? StandardCharsets.UTF_8 : f17324a;
    }

    static {
        Charset charsetForName;
        Charset charsetForName2;
        boolean z10;
        Charset charsetForName3 = null;
        try {
            charsetForName = Charset.forName("SJIS");
        } catch (UnsupportedCharsetException unused) {
            charsetForName = null;
        }
        f17325b = charsetForName;
        try {
            charsetForName2 = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused2) {
            charsetForName2 = null;
        }
        f17326c = charsetForName2;
        try {
            charsetForName3 = Charset.forName("EUC_JP");
        } catch (UnsupportedCharsetException unused3) {
        }
        f17327d = charsetForName3;
        Charset charset = f17325b;
        if ((charset != null && charset.equals(f17324a)) || (charsetForName3 != null && charsetForName3.equals(f17324a))) {
            z10 = true;
        } else {
            z10 = false;
        }
        f17328e = z10;
    }
}
