package fd;

import fc.c0;
import fc.s;
import fc.u1;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fc.p f10322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final rc.a f10325d;

    public l(int i10, int i11, rc.a aVar) {
        this.f10322a = new fc.p(0L);
        this.f10323b = i10;
        this.f10324c = i11;
        this.f10325d = aVar;
    }

    private l(c0 c0Var) {
        this.f10322a = fc.p.z(c0Var.A(0));
        this.f10323b = fc.p.z(c0Var.A(1)).D();
        this.f10324c = fc.p.z(c0Var.A(2)).D();
        this.f10325d = rc.a.n(c0Var.A(3));
    }

    public static l n(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(this.f10322a);
        gVar.a(new fc.p(this.f10323b));
        gVar.a(new fc.p(this.f10324c));
        gVar.a(this.f10325d);
        return new u1(gVar);
    }

    public int m() {
        return this.f10323b;
    }

    public int o() {
        return this.f10324c;
    }

    public rc.a q() {
        return this.f10325d;
    }
}
