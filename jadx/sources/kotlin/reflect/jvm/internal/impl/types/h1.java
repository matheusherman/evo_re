package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class h1 extends n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14318c = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.h1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0271a extends h1 {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map<g1, k1> f14319d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f14320e;

            /* JADX WARN: Multi-variable type inference failed */
            C0271a(Map<g1, ? extends k1> map, boolean z10) {
                this.f14319d = map;
                this.f14320e = z10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.n1
            public boolean a() {
                return this.f14320e;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.n1
            public boolean f() {
                return this.f14319d.isEmpty();
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.h1
            public k1 k(g1 key) {
                kotlin.jvm.internal.m.f(key, "key");
                return this.f14319d.get(key);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ h1 e(a aVar, Map map, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.d(map, z10);
        }

        public final n1 a(g0 kotlinType) {
            kotlin.jvm.internal.m.f(kotlinType, "kotlinType");
            return b(kotlinType.J0(), kotlinType.H0());
        }

        public final n1 b(g1 typeConstructor, List<? extends k1> arguments) {
            kotlin.jvm.internal.m.f(typeConstructor, "typeConstructor");
            kotlin.jvm.internal.m.f(arguments, "arguments");
            List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters = typeConstructor.getParameters();
            kotlin.jvm.internal.m.e(parameters, "typeConstructor.parameters");
            kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var = (kotlin.reflect.jvm.internal.impl.descriptors.f1) kotlin.collections.r.u0(parameters);
            if (f1Var == null || !f1Var.k0()) {
                return new e0(parameters, arguments);
            }
            List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters2 = typeConstructor.getParameters();
            kotlin.jvm.internal.m.e(parameters2, "typeConstructor.parameters");
            List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list = parameters2;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.f1) it.next()).h());
            }
            return e(this, kotlin.collections.n0.q(kotlin.collections.r.W0(arrayList, arguments)), false, 2, null);
        }

        public final h1 c(Map<g1, ? extends k1> map) {
            kotlin.jvm.internal.m.f(map, "map");
            return e(this, map, false, 2, null);
        }

        public final h1 d(Map<g1, ? extends k1> map, boolean z10) {
            kotlin.jvm.internal.m.f(map, "map");
            return new C0271a(map, z10);
        }
    }

    public abstract k1 k(g1 g1Var);

    public static final n1 i(g1 g1Var, List<? extends k1> list) {
        return f14318c.b(g1Var, list);
    }

    public static final h1 j(Map<g1, ? extends k1> map) {
        return f14318c.c(map);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public k1 e(g0 key) {
        kotlin.jvm.internal.m.f(key, "key");
        return k(key.J0());
    }
}
