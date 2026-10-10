package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final oe.a f10265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final rc.a f10266d;

    public d(int i10, int i11, oe.a aVar, rc.a aVar2) {
        this.f10263a = i10;
        this.f10264b = i11;
        this.f10265c = new oe.a(aVar.c());
        this.f10266d = aVar2;
    }

    private d(c0 c0Var) {
        this.f10263a = ((fc.p) c0Var.A(0)).D();
        this.f10264b = ((fc.p) c0Var.A(1)).D();
        this.f10265c = new oe.a(((v) c0Var.A(2)).A());
        this.f10266d = rc.a.n(c0Var.A(3));
    }

    public static d o(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(new fc.p(this.f10263a));
        gVar.a(new fc.p(this.f10264b));
        gVar.a(new q1(this.f10265c.c()));
        gVar.a(this.f10266d);
        return new u1(gVar);
    }

    public rc.a m() {
        return this.f10266d;
    }

    public oe.a n() {
        return this.f10265c;
    }

    public int q() {
        return this.f10263a;
    }

    public int r() {
        return this.f10264b;
    }
}
