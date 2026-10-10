package fc;

import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class s1 extends h2 {
    @Override // fc.h2, fc.x
    void l(f[] fVarArr) {
        for (f fVar : fVarArr) {
            fVar.f().v().n(this, true);
        }
    }

    @Override // fc.h2, fc.x
    void v(z[] zVarArr) {
        for (z zVar : zVarArr) {
            zVar.v().n(this, true);
        }
    }

    s1(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // fc.h2, fc.x
    void u(z zVar, boolean z10) {
        zVar.v().n(this, z10);
    }

    @Override // fc.x
    s1 d() {
        return this;
    }
}
