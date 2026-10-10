package y3;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f22383c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f22384a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f22385b = new StringBuilder();

    private static int c(int i10) throws h3.m {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f22383c[i11]) {
                return i11;
            }
        }
        throw h3.m.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    private static String e(String str) {
        String str2;
        byte b10 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt != '5') {
            str2 = "";
            if (cCharAt == '9') {
                switch (str.hashCode()) {
                    case 54118329:
                        if (!str.equals("90000")) {
                            b10 = -1;
                        }
                        break;
                    case 54395376:
                        if (!str.equals("99990")) {
                            b10 = -1;
                        } else {
                            b10 = 1;
                        }
                        break;
                    case 54395377:
                        if (!str.equals("99991")) {
                            b10 = -1;
                        } else {
                            b10 = 2;
                        }
                        break;
                    default:
                        b10 = -1;
                        break;
                }
                switch (b10) {
                    case 0:
                        return null;
                    case 1:
                        return "Used";
                    case 2:
                        return "0.00";
                }
            }
        } else {
            str2 = "$";
        }
        int i10 = Integer.parseInt(str.substring(1));
        String strValueOf = String.valueOf(i10 / 100);
        int i11 = i10 % 100;
        return str2 + strValueOf + '.' + (i11 < 10 ? "0" + i11 : String.valueOf(i11));
    }

    private int a(p3.a aVar, int[] iArr, StringBuilder sb2) throws h3.m {
        int[] iArr2 = this.f22384a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM = aVar.m();
        int iL = iArr[1];
        int i10 = 0;
        for (int i11 = 0; i11 < 5 && iL < iM; i11++) {
            int iJ = y.j(aVar, iArr2, iL, y.f22393h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i12 : iArr2) {
                iL += i12;
            }
            if (iJ >= 10) {
                i10 |= 1 << (4 - i11);
            }
            if (i11 != 4) {
                iL = aVar.l(aVar.k(iL));
            }
        }
        if (sb2.length() != 5) {
            throw h3.m.a();
        }
        if (d(sb2.toString()) == c(i10)) {
            return iL;
        }
        throw h3.m.a();
    }

    h3.q b(int i10, p3.a aVar, int[] iArr) throws h3.m {
        StringBuilder sb2 = this.f22385b;
        sb2.setLength(0);
        int iA = a(aVar, iArr, sb2);
        String string = sb2.toString();
        Map<h3.r, Object> mapF = f(string);
        float f10 = i10;
        h3.q qVar = new h3.q(string, null, new h3.s[]{new h3.s((iArr[0] + iArr[1]) / 2.0f, f10), new h3.s(iA, f10)}, h3.a.UPC_EAN_EXTENSION);
        if (mapF != null) {
            qVar.g(mapF);
        }
        return qVar;
    }

    w() {
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i10 = length - 2; i10 >= 0; i10 -= 2) {
            iCharAt += charSequence.charAt(i10) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
            iCharAt2 += charSequence.charAt(i11) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static Map<h3.r, Object> f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(h3.r.class);
        enumMap.put(h3.r.SUGGESTED_PRICE, strE);
        return enumMap;
    }
}
