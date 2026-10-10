package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class t extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10223b = new a(t.class, 7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f10224a;

    static class a extends m0 {
        @Override // fc.m0
        z c(c0 c0Var) {
            return new t((m) m.f10189b.c(c0Var));
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return new t((m) m.f10189b.d(q1Var));
        }

        a(Class cls, int i10) {
            super(cls, i10);
        }
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        xVar.s(z10, 7);
        this.f10224a.n(xVar, false);
    }

    @Override // fc.z
    boolean o() {
        return false;
    }

    static t x(byte[] bArr) {
        return new t(m.x(bArr));
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return ~this.f10224a.hashCode();
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (zVar instanceof t) {
            return this.f10224a.m(((t) zVar).f10224a);
        }
        return false;
    }

    @Override // fc.z
    int s(boolean z10) {
        return this.f10224a.s(z10);
    }

    @Override // fc.z
    z v() {
        m mVar = (m) this.f10224a.v();
        return mVar == this.f10224a ? this : new t(mVar);
    }

    @Override // fc.z
    z w() {
        m mVar = (m) this.f10224a.w();
        return mVar == this.f10224a ? this : new t(mVar);
    }

    public t(m mVar) {
        if (mVar != null) {
            this.f10224a = mVar;
            return;
        }
        throw new NullPointerException("'baseGraphicString' cannot be null");
    }
}
