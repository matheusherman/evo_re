package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i2 extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10167c;

    public i2() {
        this.f10167c = -1;
    }

    public i2(f fVar) {
        super(fVar);
        this.f10167c = -1;
    }

    private int J() {
        if (this.f10167c < 0) {
            int length = this.f10121a.length;
            int iS = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iS += this.f10121a[i10].f().w().s(true);
            }
            this.f10167c = iS;
        }
        return this.f10167c;
    }

    @Override // fc.c0
    c C() {
        return new d2(s0.D(x()), false);
    }

    @Override // fc.c0
    j D() {
        return new f2(this);
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
        h2 h2VarE = xVar.e();
        int length = this.f10121a.length;
        int i10 = 0;
        if (this.f10167c >= 0 || length > 16) {
            xVar.k(J());
            while (i10 < length) {
                h2VarE.u(this.f10121a[i10].f(), true);
                i10++;
            }
            return;
        }
        z[] zVarArr = new z[length];
        int iS = 0;
        for (int i11 = 0; i11 < length; i11++) {
            z zVarW = this.f10121a[i11].f().w();
            zVarArr[i11] = zVarW;
            iS += zVarW.s(true);
        }
        this.f10167c = iS;
        xVar.k(iS);
        while (i10 < length) {
            h2VarE.u(zVarArr[i10], true);
            i10++;
        }
    }

    public i2(g gVar) {
        super(gVar);
        this.f10167c = -1;
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, J());
    }

    i2(f[] fVarArr, boolean z10) {
        super(fVarArr, z10);
        this.f10167c = -1;
    }

    @Override // fc.c0, fc.z
    z w() {
        return this;
    }
}
