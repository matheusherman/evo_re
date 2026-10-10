package i4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p3.b f11013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f11014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f11015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11016d;

    void b() {
        int i10 = 0;
        while (i10 < this.f11013a.n()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f11013a.k(); i12++) {
                if (this.f11013a.h(i10, i12) != this.f11013a.h(i12, i10)) {
                    this.f11013a.g(i12, i10);
                    this.f11013a.g(i10, i12);
                }
            }
            i10 = i11;
        }
    }

    void g(boolean z10) {
        this.f11014b = null;
        this.f11015c = null;
        this.f11016d = z10;
    }

    private int a(int i10, int i11, int i12) {
        return this.f11016d ? this.f11013a.h(i11, i10) : this.f11013a.h(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    byte[] c() throws h3.h {
        g gVarD = d();
        j jVarE = e();
        c cVar = c.values()[gVarD.c()];
        int iK = this.f11013a.k();
        cVar.i(this.f11013a, iK);
        p3.b bVarA = jVarE.a();
        byte[] bArr = new byte[jVarE.h()];
        int i10 = iK - 1;
        boolean z10 = true;
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == 6) {
                i11--;
            }
            for (int i15 = 0; i15 < iK; i15++) {
                int i16 = z10 ? i10 - i15 : i15;
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i11 - i17;
                    if (!bVarA.h(i18, i16)) {
                        i13++;
                        i14 <<= 1;
                        if (this.f11013a.h(i18, i16)) {
                            i14 |= 1;
                        }
                        if (i13 == 8) {
                            bArr[i12] = (byte) i14;
                            i12++;
                            i13 = 0;
                            i14 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i11 -= 2;
        }
        if (i12 == jVarE.h()) {
            return bArr;
        }
        throw h3.h.a();
    }

    g d() throws h3.h {
        g gVar = this.f11015c;
        if (gVar != null) {
            return gVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i10 = 0; i10 < 6; i10++) {
            iA2 = a(i10, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i11 = 5; i11 >= 0; i11--) {
            iA3 = a(8, i11, iA3);
        }
        int iK = this.f11013a.k();
        int i12 = iK - 7;
        for (int i13 = iK - 1; i13 >= i12; i13--) {
            iA = a(8, i13, iA);
        }
        for (int i14 = iK - 8; i14 < iK; i14++) {
            iA = a(i14, 8, iA);
        }
        g gVarA = g.a(iA3, iA);
        this.f11015c = gVarA;
        if (gVarA != null) {
            return gVarA;
        }
        throw h3.h.a();
    }

    j e() throws h3.h {
        j jVar = this.f11014b;
        if (jVar != null) {
            return jVar;
        }
        int iK = this.f11013a.k();
        int i10 = (iK - 17) / 4;
        if (i10 <= 6) {
            return j.i(i10);
        }
        int i11 = iK - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i12 = 5; i12 >= 0; i12--) {
            for (int i13 = iK - 9; i13 >= i11; i13--) {
                iA2 = a(i13, i12, iA2);
            }
        }
        j jVarC = j.c(iA2);
        if (jVarC != null && jVarC.e() == iK) {
            this.f11014b = jVarC;
            return jVarC;
        }
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = iK - 9; i15 >= i11; i15--) {
                iA = a(i14, i15, iA);
            }
        }
        j jVarC2 = j.c(iA);
        if (jVarC2 == null || jVarC2.e() != iK) {
            throw h3.h.a();
        }
        this.f11014b = jVarC2;
        return jVarC2;
    }

    void f() {
        if (this.f11015c == null) {
            return;
        }
        c.values()[this.f11015c.c()].i(this.f11013a, this.f11013a.k());
    }

    a(p3.b bVar) throws h3.h {
        int iK = bVar.k();
        if (iK >= 21 && (iK & 3) == 1) {
            this.f11013a = bVar;
            return;
        }
        throw h3.h.a();
    }
}
