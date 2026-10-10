package y5;

import a6.c;
import a6.g;
import java.util.Map;
import w5.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {
    private static b b(g gVar, int i10, int i11, int i12) {
        a6.b bVarA = gVar.a();
        if (bVarA != null) {
            int iE = bVarA.e();
            int iD = bVarA.d();
            int i13 = i12 * 2;
            int i14 = i13 + iE;
            int i15 = i13 + iD;
            int iMax = Math.max(i10, i14);
            int iMax2 = Math.max(i11, i15);
            int iMin = Math.min(iMax / i14, iMax2 / i15);
            int i16 = (iMax - (iE * iMin)) / 2;
            b bVar = new b(iMax, iMax2);
            int i17 = (iMax2 - (iD * iMin)) / 2;
            for (int i18 = 0; i18 < iD; i18++) {
                int i19 = i16;
                int i20 = 0;
                while (i20 < iE) {
                    if (bVarA.b(i20, i18) == 1) {
                        bVar.d(i19, i17, iMin, iMin);
                    }
                    i20++;
                    i19 += iMin;
                }
                i17 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    public b a(String str, v5.a aVar, int i10, int i11, Map map) {
        if (!str.isEmpty()) {
            if (aVar == v5.a.QR_CODE) {
                if (i10 >= 0 && i11 >= 0) {
                    z5.a aVar2 = z5.a.L;
                    if (map != null) {
                        z5.a aVar3 = (z5.a) map.get(v5.b.ERROR_CORRECTION);
                        if (aVar3 != null) {
                            aVar2 = aVar3;
                        }
                        Integer num = (Integer) map.get(v5.b.MARGIN);
                        if (num != null) {
                            return b(c.a(str, aVar2, map), i10, i11, num.intValue());
                        }
                    }
                    return b(c.a(str, aVar2, map), i10, i11, 4);
                }
                throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + 'x' + i11);
            }
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
