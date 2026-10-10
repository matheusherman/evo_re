package y3;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f22381a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f22382b = new StringBuilder();

    private int a(p3.a aVar, int[] iArr, StringBuilder sb2) throws h3.m {
        int[] iArr2 = this.f22381a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM = aVar.m();
        int iL = iArr[1];
        int i10 = 0;
        for (int i11 = 0; i11 < 2 && iL < iM; i11++) {
            int iJ = y.j(aVar, iArr2, iL, y.f22393h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i12 : iArr2) {
                iL += i12;
            }
            if (iJ >= 10) {
                i10 |= 1 << (1 - i11);
            }
            if (i11 != 1) {
                iL = aVar.l(aVar.k(iL));
            }
        }
        if (sb2.length() != 2) {
            throw h3.m.a();
        }
        if (Integer.parseInt(sb2.toString()) % 4 == i10) {
            return iL;
        }
        throw h3.m.a();
    }

    h3.q b(int i10, p3.a aVar, int[] iArr) throws h3.m {
        StringBuilder sb2 = this.f22382b;
        sb2.setLength(0);
        int iA = a(aVar, iArr, sb2);
        String string = sb2.toString();
        Map<h3.r, Object> mapC = c(string);
        float f10 = i10;
        h3.q qVar = new h3.q(string, null, new h3.s[]{new h3.s((iArr[0] + iArr[1]) / 2.0f, f10), new h3.s(iA, f10)}, h3.a.UPC_EAN_EXTENSION);
        if (mapC != null) {
            qVar.g(mapC);
        }
        return qVar;
    }

    v() {
    }

    private static Map<h3.r, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(h3.r.class);
        enumMap.put(h3.r.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }
}
