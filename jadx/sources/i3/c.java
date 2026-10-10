package i3;

import h3.g;
import h3.u;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c implements u {
    @Override // h3.u
    public p3.b a(String str, h3.a aVar, int i10, int i11, Map<g, ?> map) {
        Charset charset;
        int i12;
        int i13;
        if (map != null) {
            g gVar = g.CHARACTER_SET;
            Charset charsetForName = map.containsKey(gVar) ? Charset.forName(map.get(gVar).toString()) : null;
            g gVar2 = g.ERROR_CORRECTION;
            int i14 = map.containsKey(gVar2) ? Integer.parseInt(map.get(gVar2).toString()) : 33;
            g gVar3 = g.AZTEC_LAYERS;
            if (map.containsKey(gVar3)) {
                int i15 = Integer.parseInt(map.get(gVar3).toString());
                str = str;
                aVar = aVar;
                i10 = i10;
                i11 = i11;
                charset = charsetForName;
                i12 = i14;
                i13 = i15;
            } else {
                charset = charsetForName;
                i12 = i14;
            }
            return b(str, aVar, i10, i11, charset, i12, i13);
        }
        charset = null;
        i12 = 33;
        i13 = 0;
        return b(str, aVar, i10, i11, charset, i12, i13);
    }

    private static p3.b b(String str, h3.a aVar, int i10, int i11, Charset charset, int i12, int i13) {
        if (aVar == h3.a.AZTEC) {
            return c(l3.c.d(str, i12, i13, charset), i10, i11);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + aVar);
    }

    private static p3.b c(l3.a aVar, int i10, int i11) {
        p3.b bVarA = aVar.a();
        if (bVarA != null) {
            int iN = bVarA.n();
            int iK = bVarA.k();
            int iMax = Math.max(i10, iN);
            int iMax2 = Math.max(i11, iK);
            int iMin = Math.min(iMax / iN, iMax2 / iK);
            int i12 = (iMax - (iN * iMin)) / 2;
            int i13 = (iMax2 - (iK * iMin)) / 2;
            p3.b bVar = new p3.b(iMax, iMax2);
            int i14 = 0;
            while (i14 < iK) {
                int i15 = i12;
                int i16 = 0;
                while (i16 < iN) {
                    if (bVarA.h(i16, i14)) {
                        bVar.t(i15, i13, iMin, iMin);
                    }
                    i16++;
                    i15 += iMin;
                }
                i14++;
                i13 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
