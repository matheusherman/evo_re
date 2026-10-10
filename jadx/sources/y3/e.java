package y3;

import com.taobao.sophix.PatchStatus;
import java.util.Arrays;
import java.util.Map;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f22351e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, PatchStatus.CODE_LOAD_LIB_JSON, 388, 196, SyslogAppender.LOG_LOCAL5, 162, 138, 42};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f22352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f22353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f22354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f22355d;

    public e() {
        this(false);
    }

    private static char j(int i10) throws h3.m {
        int i11 = 0;
        while (true) {
            int[] iArr = f22351e;
            if (i11 >= iArr.length) {
                if (i10 == 148) {
                    return '*';
                }
                throw h3.m.a();
            }
            if (iArr[i11] == i10) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i11);
            }
            i11++;
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i10 = 0;
        while (true) {
            int i11 = Integer.MAX_VALUE;
            for (int i12 : iArr) {
                if (i12 < i11 && i12 > i10) {
                    i11 = i12;
                }
            }
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = iArr[i16];
                if (i17 > i11) {
                    i14 |= 1 << ((length - 1) - i16);
                    i13++;
                    i15 += i17;
                }
            }
            if (i13 == 3) {
                for (int i18 = 0; i18 < length && i13 > 0; i18++) {
                    int i19 = iArr[i18];
                    if (i19 > i11) {
                        i13--;
                        if (i19 * 2 >= i15) {
                            return -1;
                        }
                    }
                }
                return i14;
            }
            if (i13 <= 3) {
                return -1;
            }
            i10 = i11;
        }
    }

    public e(boolean z10) {
        this(z10, false);
    }

    @Override // y3.r
    public h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map) throws h3.d, h3.m {
        int[] iArr = this.f22355d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f22354c;
        sb2.setLength(0);
        int[] iArrI = i(aVar, iArr);
        int iK = aVar.k(iArrI[1]);
        int iM = aVar.m();
        while (true) {
            r.f(aVar, iK, iArr);
            int iK2 = k(iArr);
            if (iK2 < 0) {
                throw h3.m.a();
            }
            char cJ = j(iK2);
            sb2.append(cJ);
            int i11 = iK;
            for (int i12 : iArr) {
                i11 += i12;
            }
            int iK3 = aVar.k(i11);
            if (cJ == '*') {
                sb2.setLength(sb2.length() - 1);
                int i13 = 0;
                for (int i14 : iArr) {
                    i13 += i14;
                }
                int i15 = (iK3 - iK) - i13;
                if (iK3 != iM && i15 * 2 < i13) {
                    throw h3.m.a();
                }
                if (this.f22352a) {
                    int length = sb2.length() - 1;
                    int iIndexOf = 0;
                    for (int i16 = 0; i16 < length; i16++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f22354c.charAt(i16));
                    }
                    if (sb2.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw h3.d.a();
                    }
                    sb2.setLength(length);
                }
                if (sb2.length() == 0) {
                    throw h3.m.a();
                }
                float f10 = i10;
                h3.q qVar = new h3.q(this.f22353b ? h(sb2) : sb2.toString(), null, new h3.s[]{new h3.s((iArrI[1] + iArrI[0]) / 2.0f, f10), new h3.s(iK + (i13 / 2.0f), f10)}, h3.a.CODE_39);
                qVar.h(h3.r.SYMBOLOGY_IDENTIFIER, "]A0");
                return qVar;
            }
            iK = iK3;
        }
    }

    public e(boolean z10, boolean z11) {
        this.f22352a = z10;
        this.f22353b = z11;
        this.f22354c = new StringBuilder(20);
        this.f22355d = new int[9];
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    private static String h(CharSequence charSequence) throws h3.h {
        int i10;
        char c10;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt != '+' && cCharAt != '$' && cCharAt != '%' && cCharAt != '/') {
                sb2.append(cCharAt);
            } else {
                i11++;
                char cCharAt2 = charSequence.charAt(i11);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c10 = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i10 = cCharAt2 - ' ';
                            } else if (cCharAt2 == 'Z') {
                                c10 = ':';
                            } else {
                                throw h3.h.a();
                            }
                        } else if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                            i10 = cCharAt2 + ' ';
                        } else {
                            throw h3.h.a();
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i10 = cCharAt2 - '&';
                    } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                        i10 = cCharAt2 - 11;
                    } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                        i10 = cCharAt2 + 16;
                    } else if (cCharAt2 >= 'P' && cCharAt2 <= 'T') {
                        i10 = cCharAt2 + '+';
                    } else if (cCharAt2 == 'U') {
                        c10 = 0;
                    } else if (cCharAt2 == 'V') {
                        c10 = '@';
                    } else if (cCharAt2 == 'W') {
                        c10 = '`';
                    } else {
                        if (cCharAt2 != 'X' && cCharAt2 != 'Y' && cCharAt2 != 'Z') {
                            throw h3.h.a();
                        }
                        c10 = 127;
                    }
                    sb2.append(c10);
                } else if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                    i10 = cCharAt2 - '@';
                } else {
                    throw h3.h.a();
                }
                c10 = (char) i10;
                sb2.append(c10);
            }
            i11++;
        }
        return sb2.toString();
    }

    private static int[] i(p3.a aVar, int[] iArr) throws h3.m {
        int iM = aVar.m();
        int iK = aVar.k(0);
        int length = iArr.length;
        int i10 = iK;
        boolean z10 = false;
        int i11 = 0;
        while (iK < iM) {
            if (aVar.i(iK) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == length - 1) {
                    if (k(iArr) == 148 && aVar.o(Math.max(0, i10 - ((iK - i10) / 2)), i10, false)) {
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
}
