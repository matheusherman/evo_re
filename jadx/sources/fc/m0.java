package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class m0 extends i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g0 f10191b;

    final z a(z zVar) {
        if (this.f10166a.isInstance(zVar)) {
            return zVar;
        }
        throw new IllegalStateException("unexpected object: " + zVar.getClass().getName());
    }

    z c(c0 c0Var) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    z d(q1 q1Var) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    final z e(h0 h0Var, boolean z10) {
        if (128 == h0Var.H()) {
            return a(h0Var.B(z10, this));
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    m0(Class cls, int i10) {
        super(cls);
        this.f10191b = g0.a(0, i10);
    }

    final z b(byte[] bArr) {
        return a(z.u(bArr));
    }
}
