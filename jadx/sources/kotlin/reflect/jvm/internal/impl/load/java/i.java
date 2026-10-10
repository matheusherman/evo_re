package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f13215a = new i();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13216a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(i.f13215a.b(it));
        }
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        if (kotlin.collections.r.a0(g.f13202a.c(), ea.c.h(bVar)) && bVar.f().isEmpty()) {
            return true;
        }
        if (!kotlin.reflect.jvm.internal.impl.builtins.h.g0(bVar)) {
            return false;
        }
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> overriddenDescriptors = bVar.e();
        kotlin.jvm.internal.m.e(overriddenDescriptors, "overriddenDescriptors");
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection = overriddenDescriptors;
        if (collection.isEmpty()) {
            return false;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.b it : collection) {
            i iVar = f13215a;
            kotlin.jvm.internal.m.e(it, "it");
            if (iVar.b(it)) {
                return true;
            }
        }
        return false;
    }

    public final String a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        ba.f fVar;
        kotlin.jvm.internal.m.f(bVar, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.h.g0(bVar);
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarF = ea.c.f(ea.c.s(bVar), false, a.f13216a, 1, null);
        if (bVarF == null || (fVar = g.f13202a.a().get(ea.c.l(bVarF))) == null) {
            return null;
        }
        return fVar.f();
    }

    public final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.b callableMemberDescriptor) {
        kotlin.jvm.internal.m.f(callableMemberDescriptor, "callableMemberDescriptor");
        if (g.f13202a.d().contains(callableMemberDescriptor.getName())) {
            return c(callableMemberDescriptor);
        }
        return false;
    }

    private i() {
    }
}
