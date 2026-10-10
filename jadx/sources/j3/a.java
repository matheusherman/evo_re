package j3;

import androidx.exifinterface.media.ExifInterface;
import h3.h;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.apache.log4j.spi.LocationInfo;
import p3.d;
import r3.c;
import r3.e;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f11569b = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f11570c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f11571d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f11572e = {"FLG(n)", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", LocationInfo.NA, "[", "]", "{", "}", "CTRL_UL"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f11573f = {"CTRL_PS", " ", "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Charset f11574g = StandardCharsets.ISO_8859_1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i3.a f11575a;

    /* JADX INFO: renamed from: j3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0197a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean[] f11576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f11578c;

        C0197a(boolean[] zArr, int i10, int i11) {
            this.f11576a = zArr;
            this.f11577b = i10;
            this.f11578c = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = h(zArr, i10 * 8);
        }
        return bArr;
    }

    private static String f(boolean[] zArr) throws h {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb2 = new StringBuilder((zArr.length - 5) / 4);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Charset charsetK = f11574g;
        int i10 = 0;
        b bVarG = bVar;
        while (i10 < length) {
            if (bVar != b.BINARY) {
                int i11 = bVar == b.DIGIT ? 4 : 5;
                if (length - i10 < i11) {
                    break;
                }
                int i12 = i(zArr, i10, i11);
                i10 += i11;
                String strE = e(bVar, i12);
                if ("FLG(n)".equals(strE)) {
                    if (length - i10 < 3) {
                        break;
                    }
                    int i13 = i(zArr, i10, 3);
                    i10 += 3;
                    try {
                        sb2.append(byteArrayOutputStream.toString(charsetK.name()));
                        byteArrayOutputStream.reset();
                        if (i13 == 0) {
                            sb2.append((char) 29);
                        } else {
                            if (i13 == 7) {
                                throw h.a();
                            }
                            if (length - i10 >= i13 * 4) {
                                int i14 = 0;
                                while (true) {
                                    int i15 = i13 - 1;
                                    if (i13 <= 0) {
                                        d dVarJ = d.j(i14);
                                        if (dVarJ == null) {
                                            throw h.a();
                                        }
                                        charsetK = dVarJ.k();
                                        break;
                                    }
                                    int i16 = i(zArr, i10, 4);
                                    i10 += 4;
                                    if (i16 < 2 || i16 > 11) {
                                        throw h.a();
                                    }
                                    i14 = (i14 * 10) + (i16 - 2);
                                    i13 = i15;
                                }
                            }
                        }
                    } catch (UnsupportedEncodingException e10) {
                        throw new IllegalStateException(e10);
                    }
                } else if (strE.startsWith("CTRL_")) {
                    bVarG = g(strE.charAt(5));
                    if (strE.charAt(6) != 'L') {
                        bVarG = bVar;
                        bVar = bVarG;
                    }
                } else {
                    byte[] bytes = strE.getBytes(StandardCharsets.US_ASCII);
                    byteArrayOutputStream.write(bytes, 0, bytes.length);
                }
                bVar = bVarG;
            } else {
                if (length - i10 < 5) {
                    break;
                }
                int i17 = i(zArr, i10, 5);
                int i18 = i10 + 5;
                if (i17 == 0) {
                    if (length - i18 < 11) {
                        break;
                    }
                    i17 = i(zArr, i18, 11) + 31;
                    i18 = i10 + 16;
                }
                int i19 = 0;
                while (true) {
                    if (i19 >= i17) {
                        i10 = i18;
                        break;
                    }
                    if (length - i18 < 8) {
                        i10 = length;
                        break;
                    }
                    byteArrayOutputStream.write((byte) i(zArr, i18, 8));
                    i18 += 8;
                    i19++;
                }
                bVar = bVarG;
            }
        }
        try {
            sb2.append(byteArrayOutputStream.toString(charsetK.name()));
            return sb2.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new IllegalStateException(e11);
        }
    }

    private static byte h(boolean[] zArr, int i10) {
        int length = zArr.length - i10;
        return (byte) (length >= 8 ? i(zArr, i10, 8) : i(zArr, i10, length) << (8 - length));
    }

    private static int i(boolean[] zArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i10 + i11; i13++) {
            i12 <<= 1;
            if (zArr[i13]) {
                i12 |= 1;
            }
        }
        return i12;
    }

    private C0197a b(boolean[] zArr) throws h {
        int i10;
        r3.a aVar;
        if (this.f11575a.e() <= 2) {
            aVar = r3.a.f17794j;
            i10 = 6;
        } else {
            i10 = 8;
            if (this.f11575a.e() <= 8) {
                aVar = r3.a.f17798n;
            } else if (this.f11575a.e() <= 22) {
                aVar = r3.a.f17793i;
                i10 = 10;
            } else {
                aVar = r3.a.f17792h;
                i10 = 12;
            }
        }
        int iD = this.f11575a.d();
        int length = zArr.length / i10;
        if (length < iD) {
            throw h.a();
        }
        int length2 = zArr.length % i10;
        int[] iArr = new int[length];
        int i11 = 0;
        while (i11 < length) {
            iArr[i11] = i(zArr, length2, i10);
            i11++;
            length2 += i10;
        }
        try {
            c cVar = new c(aVar);
            int i12 = length - iD;
            int iA = cVar.a(iArr, i12);
            int i13 = 1 << i10;
            int i14 = i13 - 1;
            int i15 = 0;
            for (int i16 = 0; i16 < iD; i16++) {
                int i17 = iArr[i16];
                if (i17 == 0 || i17 == i14) {
                    throw h.a();
                }
                if (i17 == 1 || i17 == i13 - 2) {
                    i15++;
                }
            }
            boolean[] zArr2 = new boolean[(iD * i10) - i15];
            int i18 = 0;
            for (int i19 = 0; i19 < iD; i19++) {
                int i20 = iArr[i19];
                if (i20 == 1 || i20 == i13 - 2) {
                    Arrays.fill(zArr2, i18, (i18 + i10) - 1, i20 > 1);
                    i18 += i10 - 1;
                } else {
                    int i21 = i10 - 1;
                    while (i21 >= 0) {
                        int i22 = i18 + 1;
                        zArr2[i18] = (i20 & (1 << i21)) != 0;
                        i21--;
                        i18 = i22;
                    }
                }
            }
            return new C0197a(zArr2, iA, (i12 * 100) / length);
        } catch (e e10) {
            throw h.b(e10);
        }
    }

    private boolean[] d(p3.b bVar) {
        boolean zF = this.f11575a.f();
        int iE = this.f11575a.e();
        int i10 = (zF ? 11 : 14) + (iE * 4);
        int[] iArr = new int[i10];
        boolean[] zArr = new boolean[j(iE, zF)];
        int i11 = 2;
        if (zF) {
            for (int i12 = 0; i12 < i10; i12++) {
                iArr[i12] = i12;
            }
        } else {
            int i13 = i10 / 2;
            int i14 = ((i10 + 1) + (((i13 - 1) / 15) * 2)) / 2;
            for (int i15 = 0; i15 < i13; i15++) {
                int i16 = (i15 / 15) + i15;
                iArr[(i13 - i15) - 1] = (i14 - i16) - 1;
                iArr[i13 + i15] = i16 + i14 + 1;
            }
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < iE) {
            int i19 = ((iE - i17) * 4) + (zF ? 9 : 12);
            int i20 = i17 * 2;
            int i21 = (i10 - 1) - i20;
            int i22 = 0;
            while (i22 < i19) {
                int i23 = i22 * 2;
                int i24 = 0;
                while (i24 < i11) {
                    int i25 = i20 + i24;
                    int i26 = i20 + i22;
                    zArr[i18 + i23 + i24] = bVar.h(iArr[i25], iArr[i26]);
                    int i27 = i21 - i24;
                    zArr[(i19 * 2) + i18 + i23 + i24] = bVar.h(iArr[i26], iArr[i27]);
                    int i28 = iArr[i27];
                    int i29 = i21 - i22;
                    zArr[(i19 * 4) + i18 + i23 + i24] = bVar.h(i28, iArr[i29]);
                    zArr[(i19 * 6) + i18 + i23 + i24] = bVar.h(iArr[i29], iArr[i25]);
                    i24++;
                    i11 = 2;
                }
                i22++;
                i11 = 2;
            }
            i18 += i19 * 8;
            i17++;
            i11 = 2;
        }
        return zArr;
    }

    private static b g(char c10) {
        if (c10 == 'B') {
            return b.BINARY;
        }
        if (c10 == 'D') {
            return b.DIGIT;
        }
        if (c10 == 'P') {
            return b.PUNCT;
        }
        if (c10 != 'L') {
            return c10 != 'M' ? b.UPPER : b.MIXED;
        }
        return b.LOWER;
    }

    private static int j(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }

    public p3.e c(i3.a aVar) throws h {
        this.f11575a = aVar;
        C0197a c0197aB = b(d(aVar.a()));
        p3.e eVar = new p3.e(a(c0197aB.f11576a), f(c0197aB.f11576a), null, String.format("%d%%", Integer.valueOf(c0197aB.f11578c)));
        eVar.o(c0197aB.f11576a.length);
        eVar.n(Integer.valueOf(c0197aB.f11577b));
        return eVar;
    }

    private static String e(b bVar, int i10) {
        int iOrdinal = bVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 4) {
                            return f11572e[i10];
                        }
                        throw new IllegalStateException("Bad table");
                    }
                    return f11573f[i10];
                }
                return f11571d[i10];
            }
            return f11570c[i10];
        }
        return f11569b[i10];
    }
}
