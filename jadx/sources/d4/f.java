package d4;

import java.util.Formatter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g[] f9628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f9629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9630d;

    private static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    private void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).g(this.f9627a);
        }
    }

    private static int c(int i10, int i11, d dVar) {
        if (dVar == null || dVar.g()) {
            return i11;
        }
        if (!dVar.h(i10)) {
            return i11 + 1;
        }
        dVar.i(i10);
        return 0;
    }

    private void e(int i10, int i11, d[] dVarArr) {
        d dVar = dVarArr[i11];
        d[] dVarArrD = this.f9628b[i10 - 1].d();
        g gVar = this.f9628b[i10 + 1];
        d[] dVarArrD2 = gVar != null ? gVar.d() : dVarArrD;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = dVarArrD[i11];
        dVarArr2[3] = dVarArrD2[i11];
        if (i11 > 0) {
            int i12 = i11 - 1;
            dVarArr2[0] = dVarArr[i12];
            dVarArr2[4] = dVarArrD[i12];
            dVarArr2[5] = dVarArrD2[i12];
        }
        if (i11 > 1) {
            int i13 = i11 - 2;
            dVarArr2[8] = dVarArr[i13];
            dVarArr2[10] = dVarArrD[i13];
            dVarArr2[11] = dVarArrD2[i13];
        }
        if (i11 < dVarArr.length - 1) {
            int i14 = i11 + 1;
            dVarArr2[1] = dVarArr[i14];
            dVarArr2[6] = dVarArrD[i14];
            dVarArr2[7] = dVarArrD2[i14];
        }
        if (i11 < dVarArr.length - 2) {
            int i15 = i11 + 2;
            dVarArr2[9] = dVarArr[i15];
            dVarArr2[12] = dVarArrD[i15];
            dVarArr2[13] = dVarArrD2[i15];
        }
        for (int i16 = 0; i16 < 14 && !b(dVar, dVarArr2[i16]); i16++) {
        }
    }

    private void g() {
        g[] gVarArr = this.f9628b;
        g gVar = gVarArr[0];
        if (gVar == null || gVarArr[this.f9630d + 1] == null) {
            return;
        }
        d[] dVarArrD = gVar.d();
        d[] dVarArrD2 = this.f9628b[this.f9630d + 1].d();
        for (int i10 = 0; i10 < dVarArrD.length; i10++) {
            d dVar = dVarArrD[i10];
            if (dVar != null && dVarArrD2[i10] != null && dVar.c() == dVarArrD2[i10].c()) {
                for (int i11 = 1; i11 <= this.f9630d; i11++) {
                    d dVar2 = this.f9628b[i11].d()[i10];
                    if (dVar2 != null) {
                        dVar2.i(dVarArrD[i10].c());
                        if (!dVar2.g()) {
                            this.f9628b[i11].d()[i10] = null;
                        }
                    }
                }
            }
        }
    }

    private int h() {
        g gVar = this.f9628b[0];
        if (gVar == null) {
            return 0;
        }
        d[] dVarArrD = gVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < dVarArrD.length; i11++) {
            d dVar = dVarArrD[i11];
            if (dVar != null) {
                int iC = dVar.c();
                int iC2 = 0;
                for (int i12 = 1; i12 < this.f9630d + 1 && iC2 < 2; i12++) {
                    d dVar2 = this.f9628b[i12].d()[i11];
                    if (dVar2 != null) {
                        iC2 = c(iC, iC2, dVar2);
                        if (!dVar2.g()) {
                            i10++;
                        }
                    }
                }
            }
        }
        return i10;
    }

    private int i() {
        g[] gVarArr = this.f9628b;
        int i10 = this.f9630d;
        if (gVarArr[i10 + 1] == null) {
            return 0;
        }
        d[] dVarArrD = gVarArr[i10 + 1].d();
        int i11 = 0;
        for (int i12 = 0; i12 < dVarArrD.length; i12++) {
            d dVar = dVarArrD[i12];
            if (dVar != null) {
                int iC = dVar.c();
                int iC2 = 0;
                for (int i13 = this.f9630d + 1; i13 > 0 && iC2 < 2; i13--) {
                    d dVar2 = this.f9628b[i13].d()[i12];
                    if (dVar2 != null) {
                        iC2 = c(iC, iC2, dVar2);
                        if (!dVar2.g()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    int j() {
        return this.f9630d;
    }

    int k() {
        return this.f9627a.b();
    }

    int l() {
        return this.f9627a.c();
    }

    c m() {
        return this.f9629c;
    }

    g n(int i10) {
        return this.f9628b[i10];
    }

    g[] o() {
        a(this.f9628b[0]);
        a(this.f9628b[this.f9630d + 1]);
        int i10 = 928;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i10) {
                break;
            }
            i10 = iD;
        }
        return this.f9628b;
    }

    void p(c cVar) {
        this.f9629c = cVar;
    }

    void q(int i10, g gVar) {
        this.f9628b[i10] = gVar;
    }

    public String toString() {
        g[] gVarArr = this.f9628b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.f9630d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < gVar.d().length; i10++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i10));
                for (int i11 = 0; i11 < this.f9630d + 2; i11++) {
                    g gVar2 = this.f9628b[i11];
                    if (gVar2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = gVar2.d()[i10];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    formatter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    f(a aVar, c cVar) {
        this.f9627a = aVar;
        int iA = aVar.a();
        this.f9630d = iA;
        this.f9629c = cVar;
        this.f9628b = new g[iA + 2];
    }

    private int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i10 = 1; i10 < this.f9630d + 1; i10++) {
            d[] dVarArrD = this.f9628b[i10].d();
            for (int i11 = 0; i11 < dVarArrD.length; i11++) {
                d dVar = dVarArrD[i11];
                if (dVar != null && !dVar.g()) {
                    e(i10, i11, dVarArrD);
                }
            }
        }
        return iF;
    }

    private int f() {
        g();
        return h() + i();
    }
}
