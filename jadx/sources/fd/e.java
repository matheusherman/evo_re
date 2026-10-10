package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f10269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f10270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f10271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f10272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f10273g;

    public e(int i10, int i11, oe.b bVar, oe.i iVar, oe.h hVar, oe.h hVar2, oe.a aVar) {
        this.f10267a = i10;
        this.f10268b = i11;
        this.f10269c = bVar.e();
        this.f10270d = iVar.h();
        this.f10271e = aVar.c();
        this.f10272f = hVar.a();
        this.f10273g = hVar2.a();
    }

    private e(c0 c0Var) {
        this.f10267a = ((fc.p) c0Var.A(0)).D();
        this.f10268b = ((fc.p) c0Var.A(1)).D();
        this.f10269c = ((v) c0Var.A(2)).A();
        this.f10270d = ((v) c0Var.A(3)).A();
        this.f10272f = ((v) c0Var.A(4)).A();
        this.f10273g = ((v) c0Var.A(5)).A();
        this.f10271e = ((v) c0Var.A(6)).A();
    }

    public static e o(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(new fc.p(this.f10267a));
        gVar.a(new fc.p(this.f10268b));
        gVar.a(new q1(this.f10269c));
        gVar.a(new q1(this.f10270d));
        gVar.a(new q1(this.f10272f));
        gVar.a(new q1(this.f10273g));
        gVar.a(new q1(this.f10271e));
        return new u1(gVar);
    }

    public oe.b m() {
        return new oe.b(this.f10269c);
    }

    public oe.i n() {
        return new oe.i(m(), this.f10270d);
    }

    public int q() {
        return this.f10268b;
    }

    public int r() {
        return this.f10267a;
    }

    public oe.h s() {
        return new oe.h(this.f10272f);
    }

    public oe.h t() {
        return new oe.h(this.f10273g);
    }

    public oe.a u() {
        return new oe.a(this.f10271e);
    }
}
