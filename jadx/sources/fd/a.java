package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f10250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f10251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f10252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f10253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f10254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f10255g;

    public a(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, b bVar) {
        this.f10249a = i10;
        if (i10 != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f10250b = re.a.d(bArr);
        this.f10251c = re.a.d(bArr2);
        this.f10252d = re.a.d(bArr3);
        this.f10253e = re.a.d(bArr4);
        this.f10254f = re.a.d(bArr5);
        this.f10255g = bVar;
    }

    private a(c0 c0Var) {
        int iA = re.b.a(fc.p.z(c0Var.A(0)).A());
        this.f10249a = iA;
        if (iA != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f10250b = re.a.d(v.z(c0Var.A(1)).A());
        this.f10251c = re.a.d(v.z(c0Var.A(2)).A());
        this.f10252d = re.a.d(v.z(c0Var.A(3)).A());
        this.f10253e = re.a.d(v.z(c0Var.A(4)).A());
        this.f10254f = re.a.d(v.z(c0Var.A(5)).A());
        if (c0Var.size() == 7) {
            this.f10255g = b.m(c0Var.A(6));
        }
    }

    public static a r(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(new fc.p(this.f10249a));
        gVar.a(new q1(this.f10250b));
        gVar.a(new q1(this.f10251c));
        gVar.a(new q1(this.f10252d));
        gVar.a(new q1(this.f10253e));
        gVar.a(new q1(this.f10254f));
        b bVar = this.f10255g;
        if (bVar != null) {
            gVar.a(new b(bVar.n()));
        }
        return new u1(gVar);
    }

    public byte[] m() {
        return re.a.d(this.f10253e);
    }

    public byte[] n() {
        return re.a.d(this.f10251c);
    }

    public byte[] o() {
        return re.a.d(this.f10250b);
    }

    public byte[] q() {
        return re.a.d(this.f10252d);
    }

    public byte[] s() {
        return re.a.d(this.f10254f);
    }
}
