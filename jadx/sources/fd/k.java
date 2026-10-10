package fd;

import fc.c0;
import fc.s;
import fc.u1;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fc.p f10319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final rc.a f10321c;

    public k(int i10, rc.a aVar) {
        this.f10319a = new fc.p(0L);
        this.f10320b = i10;
        this.f10321c = aVar;
    }

    private k(c0 c0Var) {
        this.f10319a = fc.p.z(c0Var.A(0));
        this.f10320b = fc.p.z(c0Var.A(1)).D();
        this.f10321c = rc.a.n(c0Var.A(2));
    }

    public static k n(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(this.f10319a);
        gVar.a(new fc.p(this.f10320b));
        gVar.a(this.f10321c);
        return new u1(gVar);
    }

    public int m() {
        return this.f10320b;
    }

    public rc.a o() {
        return this.f10321c;
    }
}
