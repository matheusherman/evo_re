package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class m extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10189b = new a(m.class, 25);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f10190a;

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
            return m.x(q1Var.A());
        }
    }

    static m x(byte[] bArr) {
        return new m1(bArr, false);
    }

    @Override // fc.z, fc.s
    public final int hashCode() {
        return re.a.l(this.f10190a);
    }

    @Override // fc.z
    final boolean m(z zVar) {
        if (zVar instanceof m) {
            return re.a.a(this.f10190a, ((m) zVar).f10190a);
        }
        return false;
    }

    @Override // fc.z
    final void n(x xVar, boolean z10) {
        xVar.o(z10, 25, this.f10190a);
    }

    @Override // fc.z
    final int s(boolean z10) {
        return x.g(z10, this.f10190a.length);
    }

    m(byte[] bArr, boolean z10) {
        if (bArr != null) {
            this.f10190a = z10 ? re.a.d(bArr) : bArr;
            return;
        }
        throw new NullPointerException("'contents' cannot be null");
    }
}
