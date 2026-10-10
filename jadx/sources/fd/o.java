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
public class o extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f10338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f10339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f10340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f10341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f10342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f10343h;

    public o(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f10336a = 0;
        this.f10337b = i10;
        this.f10338c = re.a.d(bArr);
        this.f10339d = re.a.d(bArr2);
        this.f10340e = re.a.d(bArr3);
        this.f10341f = re.a.d(bArr4);
        this.f10343h = re.a.d(bArr5);
        this.f10342g = -1;
    }

    public o(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i11) {
        this.f10336a = 1;
        this.f10337b = i10;
        this.f10338c = re.a.d(bArr);
        this.f10339d = re.a.d(bArr2);
        this.f10340e = re.a.d(bArr3);
        this.f10341f = re.a.d(bArr4);
        this.f10343h = re.a.d(bArr5);
        this.f10342g = i11;
    }

    public static o o(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(this.f10342g >= 0 ? new fc.p(1L) : new fc.p(0L));
        fc.g gVar2 = new fc.g();
        gVar2.a(new fc.p(this.f10337b));
        gVar2.a(new q1(this.f10338c));
        gVar2.a(new q1(this.f10339d));
        gVar2.a(new q1(this.f10340e));
        gVar2.a(new q1(this.f10341f));
        if (this.f10342g >= 0) {
            gVar2.a(new x1(false, 0, new fc.p(this.f10342g)));
        }
        gVar.a(new u1(gVar2));
        gVar.a(new x1(true, 0, new q1(this.f10343h)));
        return new u1(gVar);
    }

    public byte[] m() {
        return re.a.d(this.f10343h);
    }

    public int n() {
        return this.f10337b;
    }

    public int q() {
        return this.f10342g;
    }

    public byte[] r() {
        return re.a.d(this.f10340e);
    }

    public byte[] s() {
        return re.a.d(this.f10341f);
    }

    public byte[] t() {
        return re.a.d(this.f10339d);
    }

    public byte[] u() {
        return re.a.d(this.f10338c);
    }

    public int v() {
        return this.f10336a;
    }

    private o(c0 c0Var) {
        int iD;
        fc.p pVarZ = fc.p.z(c0Var.A(0));
        if (!pVarZ.B(0) && !pVarZ.B(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f10336a = pVarZ.D();
        if (c0Var.size() != 2 && c0Var.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        c0 c0VarZ = c0.z(c0Var.A(1));
        this.f10337b = fc.p.z(c0VarZ.A(0)).D();
        this.f10338c = re.a.d(v.z(c0VarZ.A(1)).A());
        this.f10339d = re.a.d(v.z(c0VarZ.A(2)).A());
        this.f10340e = re.a.d(v.z(c0VarZ.A(3)).A());
        this.f10341f = re.a.d(v.z(c0VarZ.A(4)).A());
        if (c0VarZ.size() == 6) {
            h0 h0VarD = h0.D(c0VarZ.A(5));
            if (h0VarD.I() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            iD = fc.p.y(h0VarD, false).D();
        } else {
            if (c0VarZ.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            iD = -1;
        }
        this.f10342g = iD;
        if (c0Var.size() == 3) {
            this.f10343h = re.a.d(v.y(h0.D(c0Var.A(2)), true).A());
        } else {
            this.f10343h = null;
        }
    }
}
