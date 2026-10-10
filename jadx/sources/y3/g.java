package y3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f22356c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f22357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f22358e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f22359a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f22360b = new int[6];

    private static char l(int i10) throws h3.m {
        int i11 = 0;
        while (true) {
            int[] iArr = f22357d;
            if (i11 >= iArr.length) {
                throw h3.m.a();
            }
            if (iArr[i11] == i10) {
                return f22356c[i11];
            }
            i11++;
        }
    }

    private static int m(int[] iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        int length = iArr.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int iRound = Math.round((iArr[i13] * 9.0f) / i10);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i13 & 1) == 0) {
                for (int i14 = 0; i14 < iRound; i14++) {
                    i12 = (i12 << 1) | 1;
                }
            } else {
                i12 <<= iRound;
            }
        }
        return i12;
    }

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, TypedValues.CycleType.TYPE_WAVE_OFFSET, TypedValues.CycleType.TYPE_EASING, 418, 404, TypedValues.CycleType.TYPE_VISIBILITY, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f22357d = iArr;
        f22358e = iArr[47];
    }

    private static void i(CharSequence charSequence, int i10, int i11) throws h3.d {
        int iIndexOf = 0;
        int i12 = 1;
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i13)) * i12;
            i12++;
            if (i12 > i11) {
                i12 = 1;
            }
        }
        if (charSequence.charAt(i10) != f22356c[iIndexOf % 47]) {
            throw h3.d.a();
        }
    }

    private static void h(CharSequence charSequence) throws h3.d {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    private static String j(CharSequence charSequence) throws h3.h {
        int i10;
        char c10;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                if (i11 < length - 1) {
                    i11++;
                    char cCharAt2 = charSequence.charAt(i11);
                    switch (cCharAt) {
                        case 'a':
                            if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                                i10 = cCharAt2 - '@';
                                c10 = (char) i10;
                                sb2.append(c10);
                            } else {
                                throw h3.h.a();
                            }
                            break;
                        case 'b':
                            if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                                i10 = cCharAt2 - '&';
                            } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                                i10 = cCharAt2 - 11;
                            } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                                i10 = cCharAt2 + 16;
                            } else {
                                if (cCharAt2 >= 'P' && cCharAt2 <= 'T') {
                                    i10 = cCharAt2 + '+';
                                } else if (cCharAt2 == 'U') {
                                    c10 = 0;
                                } else if (cCharAt2 == 'V') {
                                    c10 = '@';
                                } else if (cCharAt2 == 'W') {
                                    c10 = '`';
                                } else if (cCharAt2 >= 'X' && cCharAt2 <= 'Z') {
                                    c10 = 127;
                                } else {
                                    throw h3.h.a();
                                }
                                sb2.append(c10);
                            }
                            c10 = (char) i10;
                            sb2.append(c10);
                            break;
                        case 'c':
                            if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i10 = cCharAt2 - ' ';
                                c10 = (char) i10;
                            } else if (cCharAt2 == 'Z') {
                                c10 = ':';
                            } else {
                                throw h3.h.a();
                            }
                            sb2.append(c10);
                            break;
                        case 'd':
                            if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                                i10 = cCharAt2 + ' ';
                                c10 = (char) i10;
                                sb2.append(c10);
                            } else {
                                throw h3.h.a();
                            }
                            break;
                        default:
                            c10 = 0;
                            sb2.append(c10);
                            break;
                    }
                } else {
                    throw h3.h.a();
                }
            } else {
                sb2.append(cCharAt);
            }
            i11++;
        }
        return sb2.toString();
    }

    private int[] k(p3.a aVar) throws h3.m {
        int iM = aVar.m();
        int iK = aVar.k(0);
        Arrays.fill(this.f22360b, 0);
        int[] iArr = this.f22360b;
        int length = iArr.length;
        int i10 = iK;
        boolean z10 = false;
        int i11 = 0;
        while (iK < iM) {
            if (aVar.i(iK) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == length - 1) {
                    if (m(iArr) == f22358e) {
                        return new int[]{i10, iK};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i12 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i12);
                    iArr[i12] = 0;
                    iArr[i11] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            iK++;
        }
        throw h3.m.a();
    }

    @Override // y3.r
    public h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map) throws h3.d, h3.m {
        int[] iArrK = k(aVar);
        int iK = aVar.k(iArrK[1]);
        int iM = aVar.m();
        int[] iArr = this.f22360b;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f22359a;
        sb2.setLength(0);
        while (true) {
            r.f(aVar, iK, iArr);
            int iM2 = m(iArr);
            if (iM2 >= 0) {
                char cL = l(iM2);
                sb2.append(cL);
                int i11 = iK;
                for (int i12 : iArr) {
                    i11 += i12;
                }
                int iK2 = aVar.k(i11);
                if (cL == '*') {
                    sb2.deleteCharAt(sb2.length() - 1);
                    int i13 = 0;
                    for (int i14 : iArr) {
                        i13 += i14;
                    }
                    if (iK2 != iM && aVar.i(iK2)) {
                        if (sb2.length() >= 2) {
                            h(sb2);
                            sb2.setLength(sb2.length() - 2);
                            float f10 = i10;
                            h3.q qVar = new h3.q(j(sb2), null, new h3.s[]{new h3.s((iArrK[1] + iArrK[0]) / 2.0f, f10), new h3.s(iK + (i13 / 2.0f), f10)}, h3.a.CODE_93);
                            qVar.h(h3.r.SYMBOLOGY_IDENTIFIER, "]G0");
                            return qVar;
                        }
                        throw h3.m.a();
                    }
                    throw h3.m.a();
                }
                iK = iK2;
            } else {
                throw h3.m.a();
            }
        }
    }
}
