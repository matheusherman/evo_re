package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x0 extends c0 {
    public x0() {
    }

    public x0(f fVar) {
        super(fVar);
    }

    @Override // fc.c0
    c C() {
        return new s0(x());
    }

    @Override // fc.c0
    v E() {
        return new v0(y());
    }

    @Override // fc.c0
    d0 H() {
        return new z0(false, I());
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        xVar.r(z10, 48, this.f10121a);
    }

    @Override // fc.z
    int s(boolean z10) {
        int iS = z10 ? 4 : 3;
        int length = this.f10121a.length;
        for (int i10 = 0; i10 < length; i10++) {
            iS += this.f10121a[i10].f().s(true);
        }
        return iS;
    }

    public x0(g gVar) {
        super(gVar);
    }

    @Override // fc.c0
    j D() {
        return ((c0) w()).D();
    }
}
