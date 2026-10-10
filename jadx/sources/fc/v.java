package fc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class v extends z implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10240b = new a(v.class, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final byte[] f10241c = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f10242a;

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z c(c0 c0Var) {
            return c0Var.E();
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return q1Var;
        }
    }

    static v x(byte[] bArr) {
        return new q1(bArr);
    }

    public static v y(h0 h0Var, boolean z10) {
        return (v) f10240b.e(h0Var, z10);
    }

    public static v z(Object obj) {
        if (obj == null || (obj instanceof v)) {
            return (v) obj;
        }
        if (obj instanceof f) {
            z zVarF = ((f) obj).f();
            if (zVarF instanceof v) {
                return (v) zVarF;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (v) f10240b.b((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public byte[] A() {
        return this.f10242a;
    }

    @Override // fc.w
    public InputStream e() {
        return new ByteArrayInputStream(this.f10242a);
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (zVar instanceof v) {
            return re.a.a(this.f10242a, ((v) zVar).f10242a);
        }
        return false;
    }

    public String toString() {
        return "#" + re.h.b(se.c.c(this.f10242a));
    }

    @Override // fc.z
    z v() {
        return new q1(this.f10242a);
    }

    @Override // fc.z
    z w() {
        return new q1(this.f10242a);
    }

    public v(byte[] bArr) {
        if (bArr != null) {
            this.f10242a = bArr;
            return;
        }
        throw new NullPointerException("'string' cannot be null");
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return re.a.l(A());
    }

    @Override // fc.p2
    public z i() {
        return f();
    }
}
