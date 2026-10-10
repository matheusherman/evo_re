package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class z0 extends d0 {
    public z0() {
    }

    public z0(g gVar) {
        super(gVar, false);
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        xVar.r(z10, 49, this.f10128a);
    }

    @Override // fc.z
    int s(boolean z10) {
        int iS = z10 ? 4 : 3;
        int length = this.f10128a.length;
        for (int i10 = 0; i10 < length; i10++) {
            iS += this.f10128a[i10].f().s(true);
        }
        return iS;
    }

    z0(boolean z10, f[] fVarArr) {
        super(z10, fVarArr);
    }
}
