package fd;

import fc.c0;
import fc.h0;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.x1;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f10328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f10329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f10330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f10331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f10332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f10333h;

    public m(long j10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f10326a = 0;
        this.f10327b = j10;
        this.f10329d = re.a.d(bArr);
        this.f10330e = re.a.d(bArr2);
        this.f10331f = re.a.d(bArr3);
        this.f10332g = re.a.d(bArr4);
        this.f10333h = re.a.d(bArr5);
        this.f10328c = -1L;
    }

    public m(long j10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, long j11) {
        this.f10326a = 1;
        this.f10327b = j10;
        this.f10329d = re.a.d(bArr);
        this.f10330e = re.a.d(bArr2);
        this.f10331f = re.a.d(bArr3);
        this.f10332g = re.a.d(bArr4);
        this.f10333h = re.a.d(bArr5);
        this.f10328c = j11;
    }

    public static m o(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(this.f10328c >= 0 ? new fc.p(1L) : new fc.p(0L));
        fc.g gVar2 = new fc.g();
        gVar2.a(new fc.p(this.f10327b));
        gVar2.a(new q1(this.f10329d));
        gVar2.a(new q1(this.f10330e));
        gVar2.a(new q1(this.f10331f));
        gVar2.a(new q1(this.f10332g));
        if (this.f10328c >= 0) {
            gVar2.a(new x1(false, 0, new fc.p(this.f10328c)));
        }
        gVar.a(new u1(gVar2));
        gVar.a(new x1(true, 0, new q1(this.f10333h)));
        return new u1(gVar);
    }

    public byte[] m() {
        return re.a.d(this.f10333h);
    }

    public long n() {
        return this.f10327b;
    }

    public long q() {
        return this.f10328c;
    }

    public byte[] r() {
        return re.a.d(this.f10331f);
    }

    public byte[] s() {
        return re.a.d(this.f10332g);
    }

    public byte[] t() {
        return re.a.d(this.f10330e);
    }

    public byte[] u() {
        return re.a.d(this.f10329d);
    }

    public int v() {
        return this.f10326a;
    }

    private m(c0 c0Var) {
        long jI;
        fc.p pVarZ = fc.p.z(c0Var.A(0));
        if (!pVarZ.B(0) && !pVarZ.B(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f10326a = pVarZ.D();
        if (c0Var.size() != 2 && c0Var.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        c0 c0VarZ = c0.z(c0Var.A(1));
        this.f10327b = fc.p.z(c0VarZ.A(0)).I();
        this.f10329d = re.a.d(v.z(c0VarZ.A(1)).A());
        this.f10330e = re.a.d(v.z(c0VarZ.A(2)).A());
        this.f10331f = re.a.d(v.z(c0VarZ.A(3)).A());
        this.f10332g = re.a.d(v.z(c0VarZ.A(4)).A());
        if (c0VarZ.size() == 6) {
            h0 h0VarD = h0.D(c0VarZ.A(5));
            if (h0VarD.I() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            jI = fc.p.y(h0VarD, false).I();
        } else {
            if (c0VarZ.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            jI = -1;
        }
        this.f10328c = jI;
        if (c0Var.size() == 3) {
            this.f10333h = re.a.d(v.y(h0.D(c0Var.A(2)), true).A());
        } else {
            this.f10333h = null;
        }
    }
}
