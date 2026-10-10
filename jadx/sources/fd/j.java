package fd;

import fc.c0;
import fc.s;
import fc.u1;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fc.p f10317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final rc.a f10318b;

    private j(c0 c0Var) {
        this.f10317a = fc.p.z(c0Var.A(0));
        this.f10318b = rc.a.n(c0Var.A(1));
    }

    public j(rc.a aVar) {
        this.f10317a = new fc.p(0L);
        this.f10318b = aVar;
    }

    public static final j m(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        gVar.a(this.f10317a);
        gVar.a(this.f10318b);
        return new u1(gVar);
    }

    public rc.a n() {
        return this.f10318b;
    }
}
