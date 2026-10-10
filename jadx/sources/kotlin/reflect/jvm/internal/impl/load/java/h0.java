package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13212a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(i.f13215a.b(ea.c.s(it)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13213a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(e.f13195n.j((z0) it));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13214a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(kotlin.reflect.jvm.internal.impl.builtins.h.g0(it) && f.m(it) != null);
        }
    }

    public static final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "<this>");
        return d(bVar) != null;
    }

    public static final String b(kotlin.reflect.jvm.internal.impl.descriptors.b callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarS;
        ba.f fVarI;
        kotlin.jvm.internal.m.f(callableMemberDescriptor, "callableMemberDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarC = c(callableMemberDescriptor);
        if (bVarC != null && (bVarS = ea.c.s(bVarC)) != null) {
            if (bVarS instanceof u0) {
                return i.f13215a.a(bVarS);
            }
            if ((bVarS instanceof z0) && (fVarI = e.f13195n.i((z0) bVarS)) != null) {
                return fVarI.f();
            }
        }
        return null;
    }

    public static final <T extends kotlin.reflect.jvm.internal.impl.descriptors.b> T d(T t10) {
        kotlin.jvm.internal.m.f(t10, "<this>");
        if (!i0.f13217a.g().contains(t10.getName()) && !g.f13202a.d().contains(ea.c.s(t10).getName())) {
            return null;
        }
        if (t10 instanceof u0 ? true : t10 instanceof t0) {
            return (T) ea.c.f(t10, false, a.f13212a, 1, null);
        }
        if (t10 instanceof z0) {
            return (T) ea.c.f(t10, false, b.f13213a, 1, null);
        }
        return null;
    }

    public static final <T extends kotlin.reflect.jvm.internal.impl.descriptors.b> T e(T t10) {
        kotlin.jvm.internal.m.f(t10, "<this>");
        T t11 = (T) d(t10);
        if (t11 != null) {
            return t11;
        }
        f fVar = f.f13199n;
        ba.f name = t10.getName();
        kotlin.jvm.internal.m.e(name, "name");
        if (fVar.l(name)) {
            return (T) ea.c.f(t10, false, c.f13214a, 1, null);
        }
        return null;
    }

    public static final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.a specialCallableDescriptor) {
        kotlin.jvm.internal.m.f(eVar, "<this>");
        kotlin.jvm.internal.m.f(specialCallableDescriptor, "specialCallableDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = specialCallableDescriptor.b();
        kotlin.jvm.internal.m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        o0 o0VarP = ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB).p();
        kotlin.jvm.internal.m.e(o0VarP, "specialCallableDescripto…ssDescriptor).defaultType");
        for (kotlin.reflect.jvm.internal.impl.descriptors.e eVarS = kotlin.reflect.jvm.internal.impl.resolve.e.s(eVar); eVarS != null; eVarS = kotlin.reflect.jvm.internal.impl.resolve.e.s(eVarS)) {
            if (!(eVarS instanceof s9.c) && kotlin.reflect.jvm.internal.impl.types.checker.u.b(eVarS.p(), o0VarP) != null) {
                return !kotlin.reflect.jvm.internal.impl.builtins.h.g0(eVarS);
            }
        }
        return false;
    }

    public static final boolean g(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "<this>");
        return ea.c.s(bVar).b() instanceof s9.c;
    }

    public static final boolean h(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "<this>");
        return g(bVar) || kotlin.reflect.jvm.internal.impl.builtins.h.g0(bVar);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.b c(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        if (kotlin.reflect.jvm.internal.impl.builtins.h.g0(bVar)) {
            return d(bVar);
        }
        return null;
    }
}
