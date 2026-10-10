package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class k extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10178b = new a(k.class, 27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f10179a;

    @Override // fc.z
    final boolean o() {
        return false;
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return k.x(q1Var.A());
        }
    }

    static k x(byte[] bArr) {
        return new k1(bArr, false);
    }

    @Override // fc.z, fc.s
    public final int hashCode() {
        return re.a.l(this.f10179a);
    }

    @Override // fc.z
    final boolean m(z zVar) {
        if (zVar instanceof k) {
            return re.a.a(this.f10179a, ((k) zVar).f10179a);
        }
        return false;
    }

    @Override // fc.z
    final void n(x xVar, boolean z10) {
        xVar.o(z10, 27, this.f10179a);
    }

    @Override // fc.z
    final int s(boolean z10) {
        return x.g(z10, this.f10179a.length);
    }

    public final String y() {
        return re.h.b(this.f10179a);
    }

    k(byte[] bArr, boolean z10) {
        this.f10179a = z10 ? re.a.d(bArr) : bArr;
    }

    public String toString() {
        return y();
    }
}
