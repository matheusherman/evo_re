package fc;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class h0 extends z implements f, p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f10162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f10163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f10164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final f f10165d;

    h0(int i10, int i11, int i12, f fVar) {
        if (fVar == null) {
            throw new NullPointerException("'obj' cannot be null");
        }
        if (i11 == 0 || (i11 & RsaOaep.DerParser.PRIVATE) != i11) {
            throw new IllegalArgumentException("invalid tag class: " + i11);
        }
        this.f10162a = i10;
        this.f10163b = i11;
        this.f10164c = i12;
        this.f10165d = fVar;
    }

    abstract c0 K(z zVar);

    protected h0(boolean z10, int i10, int i11, f fVar) {
        this(z10 ? 1 : 2, i10, i11, fVar);
    }

    static z A(int i10, int i11, byte[] bArr) {
        m2 m2Var = new m2(4, i10, i11, new q1(bArr));
        return i10 != 64 ? m2Var : new c2(m2Var);
    }

    public static h0 D(Object obj) {
        if (obj == null || (obj instanceof h0)) {
            return (h0) obj;
        }
        if (obj instanceof f) {
            z zVarF = ((f) obj).f();
            if (zVarF instanceof h0) {
                return (h0) zVarF;
            }
        } else if (obj instanceof byte[]) {
            try {
                return x(z.u((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    private static h0 x(z zVar) {
        if (zVar instanceof h0) {
            return (h0) zVar;
        }
        throw new IllegalStateException("unexpected object: " + zVar.getClass().getName());
    }

    z B(boolean z10, m0 m0Var) {
        if (z10) {
            if (J()) {
                return m0Var.a(this.f10165d.f());
            }
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        if (1 == this.f10162a) {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        z zVarF = this.f10165d.f();
        int i10 = this.f10162a;
        if (i10 == 3) {
            return m0Var.c(K(zVarF));
        }
        if (i10 != 4) {
            return m0Var.a(zVarF);
        }
        return zVarF instanceof c0 ? m0Var.c((c0) zVarF) : m0Var.d((q1) zVarF);
    }

    public z E() {
        if (128 == H()) {
            return this.f10165d.f();
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public int H() {
        return this.f10163b;
    }

    public int I() {
        return this.f10164c;
    }

    public boolean J() {
        int i10 = this.f10162a;
        return i10 == 1 || i10 == 3;
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return (((this.f10163b * 7919) ^ this.f10164c) ^ (J() ? 15 : 240)) ^ this.f10165d.f().hashCode();
    }

    @Override // fc.z
    final boolean m(z zVar) {
        if (!(zVar instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) zVar;
        if (this.f10164c != h0Var.f10164c || this.f10163b != h0Var.f10163b) {
            return false;
        }
        if (this.f10162a != h0Var.f10162a && J() != h0Var.J()) {
            return false;
        }
        z zVarF = this.f10165d.f();
        z zVarF2 = h0Var.f10165d.f();
        if (zVarF == zVarF2) {
            return true;
        }
        if (J()) {
            return zVarF.m(zVarF2);
        }
        try {
            return re.a.a(getEncoded(), h0Var.getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    public String toString() {
        return n0.a(this.f10163b, this.f10164c) + this.f10165d;
    }

    @Override // fc.z
    z v() {
        return new x1(this.f10162a, this.f10163b, this.f10164c, this.f10165d);
    }

    @Override // fc.z
    z w() {
        return new m2(this.f10162a, this.f10163b, this.f10164c, this.f10165d);
    }

    protected h0(boolean z10, int i10, f fVar) {
        this(z10, 128, i10, fVar);
    }

    static z y(int i10, int i11, g gVar) {
        m2 m2Var;
        if (gVar.f() == 1) {
            m2Var = new m2(3, i10, i11, gVar.d(0));
        } else {
            m2Var = new m2(4, i10, i11, g2.a(gVar));
        }
        if (i10 != 64) {
            return m2Var;
        }
        return new c2(m2Var);
    }

    static z z(int i10, int i11, g gVar) {
        b1 b1Var;
        if (gVar.f() == 1) {
            b1Var = new b1(3, i10, i11, gVar.d(0));
        } else {
            b1Var = new b1(4, i10, i11, u0.a(gVar));
        }
        if (i10 != 64) {
            return b1Var;
        }
        return new q0(b1Var);
    }

    public s C() {
        if (J()) {
            f fVar = this.f10165d;
            if (fVar instanceof s) {
                return (s) fVar;
            }
            return fVar.f();
        }
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    @Override // fc.p2
    public final z i() {
        return this;
    }
}
