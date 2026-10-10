package g4;

import h3.v;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import p3.i;
import p3.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f10496c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f10494a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f10495b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f10497d = new byte[128];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Charset f10498e = StandardCharsets.ISO_8859_1;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f10500a;

        /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        @Override // p3.i
        public int a(int i10) {
            return -1;
        }

        @Override // p3.i
        public boolean b(int i10) {
            return false;
        }

        private b(String str) {
            this.f10500a = str;
        }

        @Override // p3.i
        public char charAt(int i10) {
            return this.f10500a.charAt(i10);
        }

        @Override // p3.i
        public int length() {
            return this.f10500a.length();
        }

        @Override // p3.i
        public CharSequence subSequence(int i10, int i11) {
            return this.f10500a.subSequence(i10, i11);
        }

        public String toString() {
            return this.f10500a;
        }
    }

    protected static void a(String str, int i10, String str2) throws v {
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (str.charAt(i11) > i10) {
                throw new v("Non-encodable character detected: " + str.charAt(i11) + " (Unicode: " + ((int) str.charAt(i11)) + ") at position #" + i11 + " - " + str2);
            }
        }
    }

    private static void e(byte[] bArr, int i10, int i11, int i12, StringBuilder sb2) {
        int i13;
        if (i11 == 1 && i12 == 0) {
            sb2.append((char) 913);
        } else if (i11 % 6 == 0) {
            sb2.append((char) 924);
        } else {
            sb2.append((char) 901);
        }
        if (i11 >= 6) {
            char[] cArr = new char[5];
            i13 = i10;
            while ((i10 + i11) - i13 >= 6) {
                long j10 = 0;
                for (int i14 = 0; i14 < 6; i14++) {
                    j10 = (j10 << 8) + ((long) (bArr[i13 + i14] & 255));
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    cArr[i15] = (char) (j10 % 900);
                    j10 /= 900;
                }
                for (int i16 = 4; i16 >= 0; i16--) {
                    sb2.append(cArr[i16]);
                }
                i13 += 6;
            }
        } else {
            i13 = i10;
        }
        while (i13 < i10 + i11) {
            sb2.append((char) (bArr[i13] & 255));
            i13++;
        }
    }

    private static void g(i iVar, int i10, int i11, int i12, StringBuilder sb2) throws v {
        int iMin = Math.min(i11 + i10, iVar.length());
        int i13 = i10;
        while (true) {
            if (i13 >= iMin || !iVar.b(i13)) {
                int i14 = i13;
                while (i14 < iMin && !iVar.b(i14)) {
                    i14++;
                }
                int i15 = i14 - i13;
                if (i15 <= 0) {
                    return;
                }
                e(q(iVar, i13, i14), 0, i15, i13 == i10 ? i12 : 1, sb2);
                i13 = i14;
            } else {
                j(iVar.a(i13), sb2);
                i13++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10499a;

        static {
            int[] iArr = new int[c.values().length];
            f10499a = iArr;
            try {
                iArr[c.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10499a[c.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10499a[c.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        byte[] bArr = new byte[128];
        f10496c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f10494a;
            if (i11 >= bArr2.length) {
                break;
            }
            byte b10 = bArr2[i11];
            if (b10 > 0) {
                f10496c[b10] = (byte) i11;
            }
            i11++;
        }
        Arrays.fill(f10497d, (byte) -1);
        while (true) {
            byte[] bArr3 = f10495b;
            if (i10 >= bArr3.length) {
                return;
            }
            byte b11 = bArr3[i10];
            if (b11 > 0) {
                f10497d[b11] = (byte) i10;
            }
            i10++;
        }
    }

    private static int b(i iVar, int i10, Charset charset) throws v {
        CharsetEncoder charsetEncoderNewEncoder = charset == null ? null : charset.newEncoder();
        int length = iVar.length();
        int i11 = i10;
        while (i11 < length) {
            int i12 = 0;
            int i13 = i11;
            while (i12 < 13 && !iVar.b(i13) && m(iVar.charAt(i13)) && (i13 = i11 + (i12 = i12 + 1)) < length) {
            }
            if (i12 >= 13) {
                return i11 - i10;
            }
            if (charsetEncoderNewEncoder != null && !charsetEncoderNewEncoder.canEncode(iVar.charAt(i11))) {
                char cCharAt = iVar.charAt(i11);
                throw new v("Non-encodable character detected: " + cCharAt + " (Unicode: " + ((int) cCharAt) + ')');
            }
            i11++;
        }
        return i11 - i10;
    }

    private static void h(i iVar, int i10, int i11, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder((i11 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i12 = 0;
        while (i12 < i11) {
            sb3.setLength(0);
            int iMin = Math.min(44, i11 - i12);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("1");
            int i13 = i10 + i12;
            sb4.append((Object) iVar.subSequence(i13, i13 + iMin));
            BigInteger bigInteger = new BigInteger(sb4.toString());
            do {
                sb3.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb3.length() - 1; length >= 0; length--) {
                sb2.append(sb3.charAt(length));
            }
            i12 += iMin;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x000f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x010b A[EDGE_INSN: B:80:0x010b->B:60:0x010b BREAK  A[LOOP:0: B:3:0x000f->B:98:0x000f], SYNTHETIC] */
    private static int i(i iVar, int i10, int i11, StringBuilder sb2, int i12) throws v {
        StringBuilder sb3 = new StringBuilder(i11);
        int i13 = i12;
        int i14 = 0;
        while (true) {
            int i15 = i10 + i14;
            if (!iVar.b(i15)) {
                char cCharAt = iVar.charAt(i15);
                if (i13 == 0) {
                    if (l(cCharAt)) {
                        if (cCharAt == ' ') {
                            sb3.append((char) 26);
                        } else {
                            sb3.append((char) (cCharAt - 'A'));
                        }
                    } else if (k(cCharAt)) {
                        sb3.append((char) 27);
                        i13 = 1;
                    } else if (n(cCharAt)) {
                        sb3.append((char) 28);
                        i13 = 2;
                    } else {
                        sb3.append((char) 29);
                        sb3.append((char) f10497d[cCharAt]);
                    }
                    i14++;
                    if (i14 >= i11) {
                        break;
                        break;
                    }
                } else {
                    if (i13 != 1) {
                        if (i13 != 2) {
                            if (o(cCharAt)) {
                                sb3.append((char) f10497d[cCharAt]);
                            } else {
                                sb3.append((char) 29);
                                i13 = 0;
                            }
                        } else if (n(cCharAt)) {
                            sb3.append((char) f10496c[cCharAt]);
                        } else if (l(cCharAt)) {
                            sb3.append((char) 28);
                            i13 = 0;
                        } else if (k(cCharAt)) {
                            sb3.append((char) 27);
                            i13 = 1;
                        } else {
                            int i16 = i15 + 1;
                            if (i16 >= i11 || iVar.b(i16) || !o(iVar.charAt(i16))) {
                                sb3.append((char) 29);
                                sb3.append((char) f10497d[cCharAt]);
                            } else {
                                sb3.append((char) 25);
                                i13 = 3;
                            }
                        }
                    } else if (k(cCharAt)) {
                        if (cCharAt == ' ') {
                            sb3.append((char) 26);
                        } else {
                            sb3.append((char) (cCharAt - 'a'));
                        }
                    } else if (l(cCharAt)) {
                        sb3.append((char) 27);
                        sb3.append((char) (cCharAt - 'A'));
                    } else if (n(cCharAt)) {
                        sb3.append((char) 28);
                        i13 = 2;
                    } else {
                        sb3.append((char) 29);
                        sb3.append((char) f10497d[cCharAt]);
                    }
                    i14++;
                    if (i14 >= i11) {
                        break;
                    }
                }
            } else {
                j(iVar.a(i15), sb2);
                i14++;
            }
        }
        int length = sb3.length();
        char cCharAt2 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (i17 % 2 != 0) {
                cCharAt2 = (char) ((cCharAt2 * 30) + sb3.charAt(i17));
                sb2.append(cCharAt2);
            } else {
                cCharAt2 = sb3.charAt(i17);
            }
        }
        if (length % 2 != 0) {
            sb2.append((char) ((cCharAt2 * 30) + 29));
        }
        return i13;
    }

    private static void j(int i10, StringBuilder sb2) throws v {
        if (i10 >= 0 && i10 < 900) {
            sb2.append((char) 927);
            sb2.append((char) i10);
            return;
        }
        if (i10 < 810900) {
            sb2.append((char) 926);
            sb2.append((char) ((i10 / 900) - 1));
            sb2.append((char) (i10 % 900));
        } else if (i10 < 811800) {
            sb2.append((char) 925);
            sb2.append((char) (810900 - i10));
        } else {
            throw new v("ECI number not in valid range from 0..811799, but was " + i10);
        }
    }

    private static boolean k(char c10) {
        if (c10 != ' ') {
            return c10 >= 'a' && c10 <= 'z';
        }
        return true;
    }

    private static boolean l(char c10) {
        if (c10 != ' ') {
            return c10 >= 'A' && c10 <= 'Z';
        }
        return true;
    }

    private static boolean m(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    private static boolean n(char c10) {
        return f10496c[c10] != -1;
    }

    private static boolean o(char c10) {
        return f10497d[c10] != -1;
    }

    private static boolean p(char c10) {
        if (c10 == '\t' || c10 == '\n' || c10 == '\r') {
            return true;
        }
        return c10 >= ' ' && c10 <= '~';
    }

    static byte[] q(i iVar, int i10, int i11) {
        byte[] bArr = new byte[i11 - i10];
        for (int i12 = i10; i12 < i11; i12++) {
            bArr[i12 - i10] = (byte) (iVar.charAt(i12) & 255);
        }
        return bArr;
    }

    private static int c(i iVar, int i10) {
        int length = iVar.length();
        int i11 = 0;
        if (i10 < length) {
            while (i10 < length && !iVar.b(i10) && m(iVar.charAt(i10))) {
                i11++;
                i10++;
            }
        }
        return i11;
    }

    private static int d(i iVar, int i10) {
        int length = iVar.length();
        int i11 = i10;
        while (i11 < length) {
            int i12 = 0;
            while (i12 < 13 && i11 < length && !iVar.b(i11) && m(iVar.charAt(i11))) {
                i12++;
                i11++;
            }
            if (i12 >= 13) {
                return (i11 - i10) - i12;
            }
            if (i12 <= 0) {
                if (iVar.b(i11) || !p(iVar.charAt(i11))) {
                    break;
                }
                i11++;
            }
        }
        return i11 - i10;
    }

    static String f(String str, c cVar, Charset charset, boolean z10) throws v {
        i bVar;
        p3.d dVarF;
        Charset charset2;
        byte[] bytes;
        if (!str.isEmpty()) {
            if (c.TEXT == cVar) {
                a(str, 127, "Consider specifying Compaction.AUTO instead of Compaction.TEXT");
            }
            if (charset == null && !z10) {
                a(str, 255, "Consider specifying EncodeHintType.PDF417_AUTO_ECI and/or EncodeTypeHint.CHARACTER_SET");
            }
            StringBuilder sb2 = new StringBuilder(str.length());
            a aVar = null;
            if (z10) {
                bVar = new n(str, charset, -1);
            } else {
                bVar = new b(str, aVar);
                if (charset == null) {
                    charset = f10498e;
                } else if (!f10498e.equals(charset) && (dVarF = p3.d.f(charset)) != null) {
                    j(dVarF.l(), sb2);
                }
            }
            int length = bVar.length();
            int i10 = a.f10499a[cVar.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        int i11 = 0;
                        int i12 = 0;
                        int i13 = 0;
                        while (i11 < length) {
                            while (i11 < length && bVar.b(i11)) {
                                j(bVar.a(i11), sb2);
                                i11++;
                            }
                            if (i11 >= length) {
                                break;
                            }
                            int iC = c(bVar, i11);
                            if (iC >= 13) {
                                sb2.append((char) 902);
                                h(bVar, i11, iC, sb2);
                                i11 += iC;
                                i12 = 0;
                                i13 = 2;
                            } else {
                                int iD = d(bVar, i11);
                                if (iD < 5 && iC != length) {
                                    if (z10) {
                                        charset2 = null;
                                    } else {
                                        charset2 = charset;
                                    }
                                    int iB = b(bVar, i11, charset2);
                                    if (iB == 0) {
                                        iB = 1;
                                    }
                                    if (z10) {
                                        bytes = null;
                                    } else {
                                        bytes = bVar.subSequence(i11, i11 + iB).toString().getBytes(charset);
                                    }
                                    if (((bytes == null && iB == 1) || (bytes != null && bytes.length == 1)) && i13 == 0) {
                                        if (z10) {
                                            g(bVar, i11, 1, 0, sb2);
                                        } else {
                                            e(bytes, 0, 1, 0, sb2);
                                        }
                                    } else {
                                        if (z10) {
                                            g(bVar, i11, i11 + iB, i13, sb2);
                                        } else {
                                            e(bytes, 0, bytes.length, i13, sb2);
                                        }
                                        i12 = 0;
                                        i13 = 1;
                                    }
                                    i11 += iB;
                                } else {
                                    if (i13 != 0) {
                                        sb2.append((char) 900);
                                        i12 = 0;
                                        i13 = 0;
                                    }
                                    i12 = i(bVar, i11, iD, sb2, i12);
                                    i11 += iD;
                                }
                            }
                        }
                    } else {
                        sb2.append((char) 902);
                        h(bVar, 0, length, sb2);
                    }
                } else if (z10) {
                    g(bVar, 0, bVar.length(), 0, sb2);
                } else {
                    byte[] bytes2 = bVar.toString().getBytes(charset);
                    e(bytes2, 0, bytes2.length, 1, sb2);
                }
            } else {
                i(bVar, 0, length, sb2, 0);
            }
            return sb2.toString();
        }
        throw new v("Empty message not allowed");
    }
}
