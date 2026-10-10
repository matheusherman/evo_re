package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fc.p f10311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f10312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private fc.p f10313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[][] f10314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[][] f10315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f10316f;

    public i(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f10311a = new fc.p(0L);
        this.f10313c = new fc.p(i10);
        this.f10314d = ne.a.c(sArr);
        this.f10315e = ne.a.c(sArr2);
        this.f10316f = ne.a.a(sArr3);
    }

    private i(c0 c0Var) {
        if (c0Var.A(0) instanceof fc.p) {
            this.f10311a = fc.p.z(c0Var.A(0));
        } else {
            this.f10312b = u.C(c0Var.A(0));
        }
        this.f10313c = fc.p.z(c0Var.A(1));
        c0 c0VarZ = c0.z(c0Var.A(2));
        this.f10314d = new byte[c0VarZ.size()][];
        for (int i10 = 0; i10 < c0VarZ.size(); i10++) {
            this.f10314d[i10] = v.z(c0VarZ.A(i10)).A();
        }
        c0 c0Var2 = (c0) c0Var.A(3);
        this.f10315e = new byte[c0Var2.size()][];
        for (int i11 = 0; i11 < c0Var2.size(); i11++) {
            this.f10315e[i11] = v.z(c0Var2.A(i11)).A();
        }
        this.f10316f = v.z(((c0) c0Var.A(4)).A(0)).A();
    }

    public static i r(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        fc.f fVar = this.f10311a;
        if (fVar == null) {
            fVar = this.f10312b;
        }
        gVar.a(fVar);
        gVar.a(this.f10313c);
        fc.g gVar2 = new fc.g();
        for (int i10 = 0; i10 < this.f10314d.length; i10++) {
            gVar2.a(new q1(this.f10314d[i10]));
        }
        gVar.a(new u1(gVar2));
        fc.g gVar3 = new fc.g();
        for (int i11 = 0; i11 < this.f10315e.length; i11++) {
            gVar3.a(new q1(this.f10315e[i11]));
        }
        gVar.a(new u1(gVar3));
        fc.g gVar4 = new fc.g();
        gVar4.a(new q1(this.f10316f));
        gVar.a(new u1(gVar4));
        return new u1(gVar);
    }

    public short[][] m() {
        return ne.a.d(this.f10314d);
    }

    public short[] n() {
        return ne.a.b(this.f10316f);
    }

    public short[][] o() {
        return ne.a.d(this.f10315e);
    }

    public int q() {
        return this.f10313c.D();
    }
}
