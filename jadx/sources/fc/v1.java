package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v1 extends d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10245d;

    public v1() {
        this.f10245d = -1;
    }

    v1(boolean z10, f[] fVarArr) {
        super(C(z10), fVarArr);
        this.f10245d = -1;
    }

    private static boolean C(boolean z10) {
        if (z10) {
            return z10;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    private int D() {
        if (this.f10245d < 0) {
            int length = this.f10128a.length;
            int iS = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iS += this.f10128a[i10].f().v().s(true);
            }
            this.f10245d = iS;
        }
        return this.f10245d;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        xVar.s(z10, 49);
        s1 s1VarD = xVar.d();
        int length = this.f10128a.length;
        int i10 = 0;
        if (this.f10245d >= 0 || length > 16) {
            xVar.k(D());
            while (i10 < length) {
                this.f10128a[i10].f().v().n(s1VarD, true);
                i10++;
            }
            return;
        }
        z[] zVarArr = new z[length];
        int iS = 0;
        for (int i11 = 0; i11 < length; i11++) {
            z zVarV = this.f10128a[i11].f().v();
            zVarArr[i11] = zVarV;
            iS += zVarV.s(true);
        }
        this.f10245d = iS;
        xVar.k(iS);
        while (i10 < length) {
            zVarArr[i10].n(s1VarD, true);
            i10++;
        }
    }

    @Override // fc.d0, fc.z
    z v() {
        return this.f10129b ? this : super.v();
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, D());
    }

    @Override // fc.d0, fc.z
    z w() {
        return this;
    }
}
