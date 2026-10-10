package c4;

import g4.e;
import h3.g;
import h3.u;
import h3.v;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d implements u {
    private static byte[][] d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int length = (bArr.length - i10) - 1;
            for (int i11 = 0; i11 < bArr[0].length; i11++) {
                bArr2[i11][length] = bArr[i10][i11];
            }
        }
        return bArr2;
    }

    private static p3.b b(byte[][] bArr, int i10) {
        int i11 = i10 * 2;
        p3.b bVar = new p3.b(bArr[0].length + i11, bArr.length + i11);
        bVar.c();
        int iK = (bVar.k() - i10) - 1;
        int i12 = 0;
        while (i12 < bArr.length) {
            byte[] bArr2 = bArr[i12];
            for (int i13 = 0; i13 < bArr[0].length; i13++) {
                if (bArr2[i13] == 1) {
                    bVar.s(i13 + i10, iK);
                }
            }
            i12++;
            iK--;
        }
        return bVar;
    }

    @Override // h3.u
    public p3.b a(String str, h3.a aVar, int i10, int i11, Map<g, ?> map) {
        int i12;
        int i13;
        boolean z10;
        if (aVar != h3.a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + aVar);
        }
        e eVar = new e();
        boolean z11 = false;
        if (map != null) {
            g gVar = g.PDF417_COMPACT;
            if (map.containsKey(gVar)) {
                eVar.h(Boolean.parseBoolean(map.get(gVar).toString()));
            }
            g gVar2 = g.PDF417_COMPACTION;
            if (map.containsKey(gVar2)) {
                eVar.i(g4.c.valueOf(map.get(gVar2).toString()));
            }
            g gVar3 = g.PDF417_DIMENSIONS;
            if (map.containsKey(gVar3)) {
                g4.d dVar = (g4.d) map.get(gVar3);
                eVar.j(dVar.a(), dVar.c(), dVar.b(), dVar.d());
            }
            g gVar4 = g.MARGIN;
            int i14 = map.containsKey(gVar4) ? Integer.parseInt(map.get(gVar4).toString()) : 30;
            g gVar5 = g.ERROR_CORRECTION;
            int i15 = map.containsKey(gVar5) ? Integer.parseInt(map.get(gVar5).toString()) : 2;
            g gVar6 = g.CHARACTER_SET;
            if (map.containsKey(gVar6)) {
                eVar.k(Charset.forName(map.get(gVar6).toString()));
            }
            g gVar7 = g.PDF417_AUTO_ECI;
            if (map.containsKey(gVar7) && Boolean.parseBoolean(map.get(gVar7).toString())) {
                z11 = true;
            }
            z10 = z11;
            i13 = i14;
            i12 = i15;
        } else {
            i12 = 2;
            i13 = 30;
            z10 = false;
        }
        return c(eVar, str, i12, i10, i11, i13, z10);
    }

    private static p3.b c(e eVar, String str, int i10, int i11, int i12, int i13, boolean z10) throws v {
        boolean z11;
        boolean z12;
        boolean z13;
        eVar.e(str, i10, z10);
        byte[][] bArrB = eVar.f().b(1, 4);
        if (i12 > i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (bArrB[0].length < bArrB.length) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 != z12) {
            bArrB = d(bArrB);
            z13 = true;
        } else {
            z13 = false;
        }
        int iMin = Math.min(i11 / bArrB[0].length, i12 / bArrB.length);
        if (iMin > 1) {
            byte[][] bArrB2 = eVar.f().b(iMin, iMin * 4);
            if (z13) {
                bArrB2 = d(bArrB2);
            }
            return b(bArrB2, i13);
        }
        return b(bArrB, i13);
    }
}
