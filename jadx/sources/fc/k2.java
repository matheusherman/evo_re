package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k2 extends d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10182d;

    public k2() {
        this.f10182d = -1;
    }

    public k2(g gVar) {
        super(gVar, false);
        this.f10182d = -1;
    }

    private int C() {
        if (this.f10182d < 0) {
            int length = this.f10128a.length;
            int iS = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iS += this.f10128a[i10].f().w().s(true);
            }
            this.f10182d = iS;
        }
        return this.f10182d;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        xVar.s(z10, 49);
        h2 h2VarE = xVar.e();
        int length = this.f10128a.length;
        int i10 = 0;
        if (this.f10182d >= 0 || length > 16) {
            xVar.k(C());
            while (i10 < length) {
                h2VarE.u(this.f10128a[i10].f(), true);
                i10++;
            }
            return;
        }
        z[] zVarArr = new z[length];
        int iS = 0;
        for (int i11 = 0; i11 < length; i11++) {
            z zVarW = this.f10128a[i11].f().w();
            zVarArr[i11] = zVarW;
            iS += zVarW.s(true);
        }
        this.f10182d = iS;
        xVar.k(iS);
        while (i10 < length) {
            h2VarE.u(zVarArr[i10], true);
            i10++;
        }
    }

    k2(boolean z10, f[] fVarArr) {
        super(z10, fVarArr);
        this.f10182d = -1;
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, C());
    }

    @Override // fc.d0, fc.z
    z w() {
        return this;
    }
}
