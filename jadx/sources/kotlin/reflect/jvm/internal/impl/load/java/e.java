package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends i0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f13195n = new e();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {
        final /* synthetic */ z0 $functionDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(z0 z0Var) {
            super(1);
            this.$functionDescriptor = z0Var;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(i0.f13217a.j().containsKey(kotlin.reflect.jvm.internal.impl.load.kotlin.x.d(this.$functionDescriptor)));
        }
    }

    public final ba.f i(z0 functionDescriptor) {
        kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
        Map<String, ba.f> mapJ = i0.f13217a.j();
        String strD = kotlin.reflect.jvm.internal.impl.load.kotlin.x.d(functionDescriptor);
        if (strD == null) {
            return null;
        }
        return mapJ.get(strD);
    }

    public final boolean j(z0 functionDescriptor) {
        kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
        return kotlin.reflect.jvm.internal.impl.builtins.h.g0(functionDescriptor) && ea.c.f(functionDescriptor, false, new a(functionDescriptor), 1, null) != null;
    }

    public final boolean k(z0 z0Var) {
        kotlin.jvm.internal.m.f(z0Var, "<this>");
        return kotlin.jvm.internal.m.a(z0Var.getName().f(), "removeAt") && kotlin.jvm.internal.m.a(kotlin.reflect.jvm.internal.impl.load.kotlin.x.d(z0Var), i0.f13217a.h().b());
    }

    private e() {
    }
}
