package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class j extends z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final m0 f10168f = new a(j.class, 8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    u f10169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    p f10170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    z f10171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f10172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    z f10173e;

    j(u uVar, p pVar, z zVar, int i10, z zVar2) {
        this.f10169a = uVar;
        this.f10170b = pVar;
        this.f10171c = zVar;
        this.f10172d = y(i10);
        this.f10173e = z(i10, zVar2);
    }

    private static z z(int i10, z zVar) {
        m0 m0Var;
        if (i10 == 1) {
            m0Var = v.f10240b;
        } else {
            if (i10 != 2) {
                return zVar;
            }
            m0Var = c.f10117b;
        }
        return m0Var.a(zVar);
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (this == zVar) {
            return true;
        }
        if (!(zVar instanceof j)) {
            return false;
        }
        j jVar = (j) zVar;
        return re.e.a(this.f10169a, jVar.f10169a) && re.e.a(this.f10170b, jVar.f10170b) && re.e.a(this.f10171c, jVar.f10171c) && this.f10172d == jVar.f10172d && this.f10173e.t(jVar.f10173e);
    }

    @Override // fc.z
    boolean o() {
        return true;
    }

    abstract c0 x();

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z c(c0 c0Var) {
            return c0Var.D();
        }
    }

    j(c0 c0Var) {
        int i10 = 0;
        z zVarB = B(c0Var, 0);
        if (zVarB instanceof u) {
            this.f10169a = (u) zVarB;
            zVarB = B(c0Var, 1);
            i10 = 1;
        }
        if (zVarB instanceof p) {
            this.f10170b = (p) zVarB;
            i10++;
            zVarB = B(c0Var, i10);
        }
        if (!(zVarB instanceof h0)) {
            this.f10171c = zVarB;
            i10++;
            zVarB = B(c0Var, i10);
        }
        if (c0Var.size() != i10 + 1) {
            throw new IllegalArgumentException("input sequence too large");
        }
        if (!(zVarB instanceof h0)) {
            throw new IllegalArgumentException("No tagged object found in sequence. Structure doesn't seem to be of type External");
        }
        h0 h0Var = (h0) zVarB;
        this.f10172d = y(h0Var.I());
        this.f10173e = A(h0Var);
    }

    private static int y(int i10) {
        if (i10 >= 0 && i10 <= 2) {
            return i10;
        }
        throw new IllegalArgumentException("invalid encoding value: " + i10);
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return (((re.e.b(this.f10169a) ^ re.e.b(this.f10170b)) ^ re.e.b(this.f10171c)) ^ this.f10172d) ^ this.f10173e.hashCode();
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        xVar.s(z10, 40);
        x().n(xVar, false);
    }

    @Override // fc.z
    z v() {
        return new i1(this.f10169a, this.f10170b, this.f10171c, this.f10172d, this.f10173e);
    }

    @Override // fc.z
    z w() {
        return new f2(this.f10169a, this.f10170b, this.f10171c, this.f10172d, this.f10173e);
    }

    private static z A(h0 h0Var) {
        int iH = h0Var.H();
        int I = h0Var.I();
        if (128 == iH) {
            if (I != 0) {
                if (I != 1) {
                    if (I == 2) {
                        return c.z(h0Var, false);
                    }
                    throw new IllegalArgumentException("invalid tag: " + n0.a(iH, I));
                }
                return v.y(h0Var, false);
            }
            return h0Var.C().f();
        }
        throw new IllegalArgumentException("invalid tag: " + n0.a(iH, I));
    }

    private static z B(c0 c0Var, int i10) {
        if (c0Var.size() > i10) {
            return c0Var.A(i10).f();
        }
        throw new IllegalArgumentException("too few objects in input sequence");
    }

    @Override // fc.z
    int s(boolean z10) {
        return x().s(z10);
    }
}
