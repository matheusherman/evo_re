package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import r8.z;
import u9.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l extends m {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final u9.g f13364n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final s9.c f13365o;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.l<q, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13366a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(it.O());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements c9.l<kotlin.reflect.jvm.internal.impl.resolve.scopes.h, Collection<? extends u0>> {
        final /* synthetic */ ba.f $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ba.f fVar) {
            super(1);
            this.$name = fVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<? extends u0> invoke(kotlin.reflect.jvm.internal.impl.resolve.scopes.h it) {
            kotlin.jvm.internal.m.f(it, "it");
            return it.a(this.$name, r9.d.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.l<kotlin.reflect.jvm.internal.impl.resolve.scopes.h, Collection<? extends ba.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13367a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<ba.f> invoke(kotlin.reflect.jvm.internal.impl.resolve.scopes.h it) {
            kotlin.jvm.internal.m.f(it, "it");
            return it.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class e extends sa.b.AbstractC0358b<kotlin.reflect.jvm.internal.impl.descriptors.e, z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e f13369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<R> f13370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c9.l<kotlin.reflect.jvm.internal.impl.resolve.scopes.h, Collection<R>> f13371c;

        /* JADX WARN: Multi-variable type inference failed */
        e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Set<R> set, c9.l<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.h, ? extends Collection<? extends R>> lVar) {
            this.f13369a = eVar;
            this.f13370b = set;
            this.f13371c = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // sa.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e current) {
            kotlin.jvm.internal.m.f(current, "current");
            if (current == this.f13369a) {
                return true;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = current.N();
            kotlin.jvm.internal.m.e(hVarN, "current.staticScope");
            if (!(hVarN instanceof m)) {
                return true;
            }
            this.f13370b.addAll((Collection<? extends R>) ((Collection) this.f13371c.invoke(hVarN)));
            return false;
        }

        @Override // sa.b.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return z.f17874a;
        }

        public void e() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends o implements c9.l<g0, kotlin.reflect.jvm.internal.impl.descriptors.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f13368a = new d();

        d() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke(g0 g0Var) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
            if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD;
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, u9.g jClass, s9.c ownerDescriptor) {
        super(c10);
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(jClass, "jClass");
        kotlin.jvm.internal.m.f(ownerDescriptor, "ownerDescriptor");
        this.f13364n = jClass;
        this.f13365o = ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a p() {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a(this.f13364n, a.f13366a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public s9.c C() {
        return this.f13365o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected Set<ba.f> l(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        return v0.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected Set<ba.f> n(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        Set<ba.f> setR0 = r.R0(y().invoke().a());
        l lVarB = s9.h.b(C());
        Set<ba.f> setB = lVarB != null ? lVarB.b() : null;
        if (setB == null) {
            setB = v0.e();
        }
        setR0.addAll(setB);
        if (this.f13364n.y()) {
            setR0.addAll(r.o(kotlin.reflect.jvm.internal.impl.builtins.k.f12577f, kotlin.reflect.jvm.internal.impl.builtins.k.f12575d));
        }
        setR0.addAll(w().a().w().f(w(), C()));
        return setR0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void o(Collection<z0> result, ba.f name) {
        kotlin.jvm.internal.m.f(result, "result");
        kotlin.jvm.internal.m.f(name, "name");
        w().a().w().d(w(), C(), name, result);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void r(Collection<z0> result, ba.f name) {
        kotlin.jvm.internal.m.f(result, "result");
        kotlin.jvm.internal.m.f(name, "name");
        Collection<? extends z0> collectionE = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(name, S(name, C()), result, C(), w().a().c(), w().a().k().a());
        kotlin.jvm.internal.m.e(collectionE, "resolveOverridesForStati…rridingUtil\n            )");
        result.addAll(collectionE);
        if (this.f13364n.y()) {
            if (kotlin.jvm.internal.m.a(name, kotlin.reflect.jvm.internal.impl.builtins.k.f12577f)) {
                z0 z0VarG = kotlin.reflect.jvm.internal.impl.resolve.d.g(C());
                kotlin.jvm.internal.m.e(z0VarG, "createEnumValueOfMethod(ownerDescriptor)");
                result.add(z0VarG);
            } else if (kotlin.jvm.internal.m.a(name, kotlin.reflect.jvm.internal.impl.builtins.k.f12575d)) {
                z0 z0VarH = kotlin.reflect.jvm.internal.impl.resolve.d.h(C());
                kotlin.jvm.internal.m.e(z0VarH, "createEnumValuesMethod(ownerDescriptor)");
                result.add(z0VarH);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.m, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void s(ba.f name, Collection<u0> result) {
        ba.f fVar;
        Collection<u0> collection;
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(result, "result");
        Set setO = O(C(), new LinkedHashSet(), new b(name));
        if (result.isEmpty()) {
            fVar = name;
            collection = result;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : setO) {
                u0 u0VarR = R((u0) obj);
                Object arrayList = linkedHashMap.get(u0VarR);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(u0VarR, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Collection collectionE = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(fVar, (Collection) ((Map.Entry) it.next()).getValue(), collection, C(), w().a().c(), w().a().k().a());
                kotlin.jvm.internal.m.e(collectionE, "resolveOverridesForStati…ingUtil\n                )");
                r.C(arrayList2, collectionE);
            }
            collection.addAll(arrayList2);
        } else {
            Collection<? extends u0> collectionE2 = kotlin.reflect.jvm.internal.impl.load.java.components.a.e(name, setO, result, C(), w().a().c(), w().a().k().a());
            fVar = name;
            collection = result;
            kotlin.jvm.internal.m.e(collectionE2, "resolveOverridesForStati…ingUtil\n                )");
            collection.addAll(collectionE2);
        }
        if (this.f13364n.y() && kotlin.jvm.internal.m.a(fVar, kotlin.reflect.jvm.internal.impl.builtins.k.f12576e)) {
            sa.a.a(collection, kotlin.reflect.jvm.internal.impl.resolve.d.f(C()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected Set<ba.f> t(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        Set<ba.f> setR0 = r.R0(y().invoke().f());
        O(C(), setR0, c.f13367a);
        if (this.f13364n.y()) {
            setR0.add(kotlin.reflect.jvm.internal.impl.builtins.k.f12576e);
        }
        return setR0;
    }

    private final <R> Set<R> O(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Set<R> set, c9.l<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.h, ? extends Collection<? extends R>> lVar) {
        sa.b.b(r.e(eVar), k.f13363a, new e(eVar, set, lVar));
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable P(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        Collection<g0> collectionB = eVar.h().b();
        kotlin.jvm.internal.m.e(collectionB, "it.typeConstructor.supertypes");
        return ta.k.u(ta.k.K(r.Z(collectionB), d.f13368a));
    }

    private final u0 R(u0 u0Var) {
        if (u0Var.g().a()) {
            return u0Var;
        }
        Collection<? extends u0> collectionE = u0Var.e();
        kotlin.jvm.internal.m.e(collectionE, "this.overriddenDescriptors");
        Collection<? extends u0> collection = collectionE;
        ArrayList arrayList = new ArrayList(r.w(collection, 10));
        for (u0 it : collection) {
            kotlin.jvm.internal.m.e(it, "it");
            arrayList.add(R(it));
        }
        return (u0) r.F0(r.b0(arrayList));
    }

    private final Set<z0> S(ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        l lVarB = s9.h.b(eVar);
        if (lVarB == null) {
            return v0.e();
        }
        return r.S0(lVarB.c(fVar, r9.d.WHEN_GET_SUPER_MEMBERS));
    }
}
