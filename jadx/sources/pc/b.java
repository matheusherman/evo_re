package pc;

import fc.c;
import fc.c0;
import fc.d0;
import fc.f;
import fc.g;
import fc.h0;
import fc.h1;
import fc.p;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.x1;
import fc.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f17567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private rc.a f17568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private v f17569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d0 f17570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f17571e;

    private b(c0 c0Var) {
        Enumeration enumerationB = c0Var.B();
        p pVarZ = p.z(enumerationB.nextElement());
        this.f17567a = pVarZ;
        int iR = r(pVarZ);
        this.f17568b = rc.a.n(enumerationB.nextElement());
        this.f17569c = v.z(enumerationB.nextElement());
        int i10 = -1;
        while (enumerationB.hasMoreElements()) {
            h0 h0Var = (h0) enumerationB.nextElement();
            int I = h0Var.I();
            if (I <= i10) {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            if (I == 0) {
                this.f17570d = d0.y(h0Var, false);
            } else {
                if (I != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                }
                if (iR < 1) {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                this.f17571e = h1.H(h0Var, false);
            }
            i10 = I;
        }
    }

    public b(rc.a aVar, f fVar) {
        this(aVar, fVar, null, null);
    }

    public static b n(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        g gVar = new g(5);
        gVar.a(this.f17567a);
        gVar.a(this.f17568b);
        gVar.a(this.f17569c);
        d0 d0Var = this.f17570d;
        if (d0Var != null) {
            gVar.a(new x1(false, 0, d0Var));
        }
        c cVar = this.f17571e;
        if (cVar != null) {
            gVar.a(new x1(false, 1, cVar));
        }
        return new u1(gVar);
    }

    public d0 m() {
        return this.f17570d;
    }

    public rc.a o() {
        return this.f17568b;
    }

    public c q() {
        return this.f17571e;
    }

    public f s() {
        return z.u(this.f17569c.A());
    }

    public b(rc.a aVar, f fVar, d0 d0Var) {
        this(aVar, fVar, d0Var, null);
    }

    private static int r(p pVar) {
        int iD = pVar.D();
        if (iD >= 0 && iD <= 1) {
            return iD;
        }
        throw new IllegalArgumentException("invalid version for private key info");
    }

    public b(rc.a aVar, f fVar, d0 d0Var, byte[] bArr) {
        this.f17567a = new p(bArr != null ? re.b.f17929b : re.b.f17928a);
        this.f17568b = aVar;
        this.f17569c = new q1(fVar);
        this.f17570d = d0Var;
        this.f17571e = bArr == null ? null : new h1(bArr);
    }
}
