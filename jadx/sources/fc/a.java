package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a extends h0 implements f, p2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h0 f10108e;

    a(h0 h0Var) {
        super(h0Var.f10162a, L(h0Var.f10163b), h0Var.f10164c, h0Var.f10165d);
        this.f10108e = h0Var;
    }

    private static int L(int i10) {
        if (64 == i10) {
            return i10;
        }
        throw new IllegalArgumentException();
    }

    @Override // fc.h0
    c0 K(z zVar) {
        return this.f10108e.K(zVar);
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        this.f10108e.n(xVar, z10);
    }

    @Override // fc.z
    boolean o() {
        return this.f10108e.o();
    }

    @Override // fc.z
    int s(boolean z10) {
        return this.f10108e.s(z10);
    }

    @Override // fc.h0, fc.z
    z v() {
        return new f1((h0) this.f10108e.v());
    }

    @Override // fc.h0, fc.z
    z w() {
        return new c2((h0) this.f10108e.w());
    }
}
