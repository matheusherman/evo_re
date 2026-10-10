package fc;

import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class h2 extends x {
    @Override // fc.x
    void l(f[] fVarArr) {
        for (f fVar : fVarArr) {
            fVar.f().w().n(this, true);
        }
    }

    @Override // fc.x
    void v(z[] zVarArr) {
        for (z zVar : zVarArr) {
            zVar.w().n(this, true);
        }
    }

    h2(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // fc.x
    void u(z zVar, boolean z10) {
        zVar.w().n(this, z10);
    }

    @Override // fc.x
    h2 e() {
        return this;
    }
}
