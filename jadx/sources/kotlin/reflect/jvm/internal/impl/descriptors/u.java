package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class u {
    public abstract n1 b();

    public abstract String c();

    public abstract boolean e(ha.g gVar, q qVar, m mVar, boolean z10);

    public abstract u f();

    public final Integer a(u visibility) {
        kotlin.jvm.internal.m.f(visibility, "visibility");
        return b().a(visibility.b());
    }

    protected u() {
    }

    public final boolean d() {
        return b().c();
    }

    public final String toString() {
        return b().toString();
    }
}
