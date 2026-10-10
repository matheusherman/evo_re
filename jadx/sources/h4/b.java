package h4;

import h3.u;
import i4.f;
import java.util.Map;
import k4.c;
import k4.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements u {
    public static p3.b b(g gVar, int i10, int i11, int i12) {
        k4.b bVarA = gVar.a();
        if (bVarA != null) {
            int iE = bVarA.e();
            int iD = bVarA.d();
            int i13 = i12 * 2;
            int i14 = iE + i13;
            int i15 = i13 + iD;
            int iMax = Math.max(i10, i14);
            int iMax2 = Math.max(i11, i15);
            int iMin = Math.min(iMax / i14, iMax2 / i15);
            int i16 = (iMax - (iE * iMin)) / 2;
            int i17 = (iMax2 - (iD * iMin)) / 2;
            p3.b bVar = new p3.b(iMax, iMax2);
            int i18 = 0;
            while (i18 < iD) {
                int i19 = i16;
                int i20 = 0;
                while (i20 < iE) {
                    if (bVarA.b(i20, i18) == 1) {
                        bVar.t(i19, i17, iMin, iMin);
                    }
                    i20++;
                    i19 += iMin;
                }
                i18++;
                i17 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // h3.u
    public p3.b a(String str, h3.a aVar, int i10, int i11, Map<h3.g, ?> map) {
        if (!str.isEmpty()) {
            if (aVar == h3.a.QR_CODE) {
                if (i10 >= 0 && i11 >= 0) {
                    f fVarValueOf = f.L;
                    int i12 = 4;
                    if (map != null) {
                        h3.g gVar = h3.g.ERROR_CORRECTION;
                        if (map.containsKey(gVar)) {
                            fVarValueOf = f.valueOf(map.get(gVar).toString());
                        }
                        h3.g gVar2 = h3.g.MARGIN;
                        if (map.containsKey(gVar2)) {
                            i12 = Integer.parseInt(map.get(gVar2).toString());
                        }
                    }
                    return b(c.n(str, fVarValueOf, map), i10, i11, i12);
                }
                throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + 'x' + i11);
            }
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
