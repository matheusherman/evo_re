package i4;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r3.c f11030a = new r3.c(r3.a.f17796l);

    private int a(byte[] bArr, int i10) throws h3.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            int iA = this.f11030a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
            return iA;
        } catch (r3.e unused) {
            throw h3.d.a();
        }
    }

    public p3.e c(p3.b bVar, Map<h3.e, ?> map) throws h3.d, h3.h {
        h3.d e10;
        a aVar = new a(bVar);
        h3.h hVar = null;
        try {
            return b(aVar, map);
        } catch (h3.d e11) {
            e10 = e11;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                p3.e eVarB = b(aVar, map);
                eVarB.p(new i(true));
                return eVarB;
            } catch (h3.d | h3.h unused) {
                if (hVar != null) {
                    throw hVar;
                }
                throw e10;
            }
        } catch (h3.h e12) {
            e10 = null;
            hVar = e12;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            p3.e eVarB2 = b(aVar, map);
            eVarB2.p(new i(true));
            return eVarB2;
        }
    }

    private p3.e b(a aVar, Map<h3.e, ?> map) throws h3.h {
        j jVarE = aVar.e();
        f fVarD = aVar.d().d();
        b[] bVarArrB = b.b(aVar.c(), jVarE, fVarD);
        int iC = 0;
        for (b bVar : bVarArrB) {
            iC += bVar.c();
        }
        byte[] bArr = new byte[iC];
        int iA = 0;
        int i10 = 0;
        for (b bVar2 : bVarArrB) {
            byte[] bArrA = bVar2.a();
            int iC2 = bVar2.c();
            iA += a(bArrA, iC2);
            int i11 = 0;
            while (i11 < iC2) {
                bArr[i10] = bArrA[i11];
                i11++;
                i10++;
            }
        }
        p3.e eVarA = d.a(bArr, jVarE, fVarD, map);
        eVarA.n(Integer.valueOf(iA));
        return eVarA;
    }
}
