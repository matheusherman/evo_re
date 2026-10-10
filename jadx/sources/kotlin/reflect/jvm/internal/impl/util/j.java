package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class j implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f14421a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14422b = "second parameter must be of type KProperty<*> or its supertype";

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public boolean b(y functionDescriptor) {
        kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
        j1 secondParameter = functionDescriptor.f().get(1);
        kotlin.reflect.jvm.internal.impl.builtins.j.b bVar = kotlin.reflect.jvm.internal.impl.builtins.j.f12488k;
        kotlin.jvm.internal.m.e(secondParameter, "secondParameter");
        g0 g0VarA = bVar.a(ea.c.p(secondParameter));
        if (g0VarA == null) {
            return false;
        }
        g0 type = secondParameter.getType();
        kotlin.jvm.internal.m.e(type, "secondParameter.type");
        return oa.a.r(g0VarA, oa.a.v(type));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String getDescription() {
        return f14422b;
    }

    private j() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }
}
