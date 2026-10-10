package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fa.c f13386a;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.i
    public kotlin.reflect.jvm.internal.impl.descriptors.e a(u9.g javaClass) {
        m.f(javaClass, "javaClass");
        return b().b(javaClass);
    }

    public final fa.c b() {
        fa.c cVar = this.f13386a;
        if (cVar != null) {
            return cVar;
        }
        m.v("resolver");
        return null;
    }

    public final void c(fa.c cVar) {
        m.f(cVar, "<set-?>");
        this.f13386a = cVar;
    }
}
