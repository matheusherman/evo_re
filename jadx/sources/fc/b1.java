package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b1 extends h0 {
    @Override // fc.h0
    c0 K(z zVar) {
        return new x0(zVar);
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        z zVarF = this.f10165d.f();
        boolean zJ = J();
        if (z10) {
            int i10 = this.f10163b;
            if (zJ || zVarF.o()) {
                i10 |= 32;
            }
            xVar.t(true, i10, this.f10164c);
        }
        if (!zJ) {
            zVarF.n(xVar, false);
            return;
        }
        xVar.i(128);
        zVarF.n(xVar, true);
        xVar.i(0);
        xVar.i(0);
    }

    @Override // fc.z
    int s(boolean z10) {
        z zVarF = this.f10165d.f();
        boolean zJ = J();
        int iS = zVarF.s(zJ);
        if (zJ) {
            iS += 3;
        }
        return iS + (z10 ? x.h(this.f10164c) : 0);
    }

    b1(int i10, int i11, int i12, f fVar) {
        super(i10, i11, i12, fVar);
    }

    @Override // fc.z
    boolean o() {
        if (!J() && !this.f10165d.f().o()) {
            return false;
        }
        return true;
    }
}
