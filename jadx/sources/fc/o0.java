package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class o0 extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10198b = new a(o0.class, 21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f10199a;

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
            return o0.x(q1Var.A());
        }
    }

    static o0 x(byte[] bArr) {
        return new a2(bArr, false);
    }

    @Override // fc.z, fc.s
    public final int hashCode() {
        return re.a.l(this.f10199a);
    }

    @Override // fc.z
    final boolean m(z zVar) {
        if (zVar instanceof o0) {
            return re.a.a(this.f10199a, ((o0) zVar).f10199a);
        }
        return false;
    }

    @Override // fc.z
    final void n(x xVar, boolean z10) {
        xVar.o(z10, 21, this.f10199a);
    }

    @Override // fc.z
    final int s(boolean z10) {
        return x.g(z10, this.f10199a.length);
    }

    o0(byte[] bArr, boolean z10) {
        this.f10199a = z10 ? re.a.d(bArr) : bArr;
    }
}
