package t3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f18871b;

    byte[] a() {
        return this.f18871b;
    }

    int c() {
        return this.f18870a;
    }

    private b(int i10, byte[] bArr) {
        this.f18870a = i10;
        this.f18871b = bArr;
    }

    static b[] b(byte[] bArr, e eVar) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        e.c cVarD = eVar.d();
        e.b[] bVarArrA = cVarD.a();
        int iA = 0;
        for (e.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        b[] bVarArr = new b[iA];
        int i13 = 0;
        for (e.b bVar2 : bVarArrA) {
            int i14 = 0;
            while (i14 < bVar2.a()) {
                int iB = bVar2.b();
                bVarArr[i13] = new b(iB, new byte[cVarD.b() + iB]);
                i14++;
                i13++;
            }
        }
        int length = bVarArr[0].f18871b.length - cVarD.b();
        int i15 = length - 1;
        int i16 = 0;
        for (int i17 = 0; i17 < i15; i17++) {
            int i18 = 0;
            while (i18 < i13) {
                bVarArr[i18].f18871b[i17] = bArr[i16];
                i18++;
                i16++;
            }
        }
        if (eVar.i() == 24) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = 8;
        } else {
            i10 = i13;
        }
        int i19 = 0;
        while (i19 < i10) {
            bVarArr[i19].f18871b[i15] = bArr[i16];
            i19++;
            i16++;
        }
        int length2 = bVarArr[0].f18871b.length;
        while (length < length2) {
            int i20 = 0;
            while (i20 < i13) {
                if (z10) {
                    i11 = (i20 + 8) % i13;
                } else {
                    i11 = i20;
                }
                if (z10 && i11 > 7) {
                    i12 = length - 1;
                } else {
                    i12 = length;
                }
                bVarArr[i11].f18871b[i12] = bArr[i16];
                i20++;
                i16++;
            }
            length++;
        }
        if (i16 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }
}
