package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x1 extends h0 {
    x1(int i10, int i11, int i12, f fVar) {
        super(i10, i11, i12, fVar);
    }

    public x1(boolean z10, int i10, f fVar) {
        super(z10, i10, fVar);
    }

    @Override // fc.h0
    c0 K(z zVar) {
        return new u1(zVar);
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        z zVarV = this.f10165d.f().v();
        boolean zJ = J();
        if (z10) {
            int i10 = this.f10163b;
            if (zJ || zVarV.o()) {
                i10 |= 32;
            }
            xVar.t(true, i10, this.f10164c);
        }
        if (zJ) {
            xVar.k(zVarV.s(true));
        }
        zVarV.n(xVar.d(), zJ);
    }

    @Override // fc.z
    int s(boolean z10) {
        z zVarV = this.f10165d.f().v();
        boolean zJ = J();
        int iS = zVarV.s(zJ);
        if (zJ) {
            iS += x.f(iS);
        }
        return iS + (z10 ? x.h(this.f10164c) : 0);
    }

    @Override // fc.z
    boolean o() {
        if (!J() && !this.f10165d.f().v().o()) {
            return false;
        }
        return true;
    }

    @Override // fc.h0, fc.z
    z v() {
        return this;
    }

    @Override // fc.h0, fc.z
    z w() {
        return this;
    }
}
