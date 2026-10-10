package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final oe.a f10276c;

    public f(int i10, int i11, oe.a aVar) {
        this.f10274a = i10;
        this.f10275b = i11;
        this.f10276c = new oe.a(aVar);
    }

    private f(c0 c0Var) {
        this.f10274a = ((fc.p) c0Var.A(0)).D();
        this.f10275b = ((fc.p) c0Var.A(1)).D();
        this.f10276c = new oe.a(((v) c0Var.A(2)).A());
    }

    public static f n(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(new fc.p(this.f10274a));
        gVar.a(new fc.p(this.f10275b));
        gVar.a(new q1(this.f10276c.c()));
        return new u1(gVar);
    }

    public oe.a m() {
        return new oe.a(this.f10276c);
    }

    public int o() {
        return this.f10274a;
    }

    public int q() {
        return this.f10275b;
    }
}
