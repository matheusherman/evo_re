package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f10259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f10260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f10261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private rc.a f10262f;

    public c(int i10, int i11, oe.b bVar, oe.i iVar, oe.h hVar, rc.a aVar) {
        this.f10257a = i10;
        this.f10258b = i11;
        this.f10259c = bVar.e();
        this.f10260d = iVar.h();
        this.f10261e = hVar.a();
        this.f10262f = aVar;
    }

    private c(c0 c0Var) {
        this.f10257a = ((fc.p) c0Var.A(0)).D();
        this.f10258b = ((fc.p) c0Var.A(1)).D();
        this.f10259c = ((v) c0Var.A(2)).A();
        this.f10260d = ((v) c0Var.A(3)).A();
        this.f10261e = ((v) c0Var.A(4)).A();
        this.f10262f = rc.a.n(c0Var.A(5));
    }

    public static c q(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(new fc.p(this.f10257a));
        gVar.a(new fc.p(this.f10258b));
        gVar.a(new q1(this.f10259c));
        gVar.a(new q1(this.f10260d));
        gVar.a(new q1(this.f10261e));
        gVar.a(this.f10262f);
        return new u1(gVar);
    }

    public rc.a m() {
        return this.f10262f;
    }

    public oe.b n() {
        return new oe.b(this.f10259c);
    }

    public oe.i o() {
        return new oe.i(n(), this.f10260d);
    }

    public int r() {
        return this.f10258b;
    }

    public int s() {
        return this.f10257a;
    }

    public oe.h t() {
        return new oe.h(this.f10261e);
    }
}
