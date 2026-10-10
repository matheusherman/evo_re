package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class u1 extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10237c;

    public u1(f fVar) {
        super(fVar);
        this.f10237c = -1;
    }

    public u1(g gVar) {
        super(gVar);
        this.f10237c = -1;
    }

    private int J() {
        if (this.f10237c < 0) {
            int length = this.f10121a.length;
            int iS = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iS += this.f10121a[i10].f().v().s(true);
            }
            this.f10237c = iS;
        }
        return this.f10237c;
    }

    @Override // fc.c0
    c C() {
        return new h1(s0.D(x()), false);
    }

    @Override // fc.c0
    j D() {
        return new i1(this);
    }

    @Override // fc.c0
    v E() {
        return new q1(v0.B(y()));
    }

    @Override // fc.c0
    d0 H() {
        return new k2(false, I());
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        xVar.s(z10, 48);
        s1 s1VarD = xVar.d();
        int length = this.f10121a.length;
        int i10 = 0;
        if (this.f10237c >= 0 || length > 16) {
            xVar.k(J());
            while (i10 < length) {
                this.f10121a[i10].f().v().n(s1VarD, true);
                i10++;
            }
            return;
        }
        z[] zVarArr = new z[length];
        int iS = 0;
        for (int i11 = 0; i11 < length; i11++) {
            z zVarV = this.f10121a[i11].f().v();
            zVarArr[i11] = zVarV;
            iS += zVarV.s(true);
        }
        this.f10237c = iS;
        xVar.k(iS);
        while (i10 < length) {
            zVarArr[i10].n(s1VarD, true);
            i10++;
        }
    }

    u1(f[] fVarArr, boolean z10) {
        super(fVarArr, z10);
        this.f10237c = -1;
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, J());
    }

    @Override // fc.c0, fc.z
    z v() {
        return this;
    }

    @Override // fc.c0, fc.z
    z w() {
        return this;
    }
}
