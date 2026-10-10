package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.v0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.p;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.w;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.y;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.z;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import w9.q;
import w9.r;
import w9.s;
import w9.t;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.descriptors.impl.a implements kotlin.reflect.jvm.internal.impl.descriptors.m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final w9.c f14051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final y9.a f14052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a1 f14053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ba.b f14054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e0 f14055j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final u f14056k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.f f14057l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m f14058m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.i f14059n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final b f14060o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final y0<a> f14061p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final c f14062q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.m f14063r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ka.j<kotlin.reflect.jvm.internal.impl.descriptors.d> f14064s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ka.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.d>> f14065t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ka.j<kotlin.reflect.jvm.internal.impl.descriptors.e> f14066u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ka.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.e>> f14067v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ka.j<h1<o0>> f14068w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final y.a f14069x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f14070y;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class a extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.types.checker.g f14071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ka.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> f14072h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ka.i<Collection<g0>> f14073i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f14074j;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0258a extends o implements c9.a<List<? extends ba.f>> {
            final /* synthetic */ List<ba.f> $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0258a(List<ba.f> list) {
                super(0);
                this.$it = list;
            }

            @Override // c9.a
            public final List<? extends ba.f> invoke() {
                return this.$it;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class b extends o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.m>> {
            b() {
                super(0);
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke() {
                return a.this.j(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13978o, kotlin.reflect.jvm.internal.impl.resolve.scopes.h.f14001a.a(), r9.d.WHEN_GET_ALL_DESCRIPTORS);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class c extends kotlin.reflect.jvm.internal.impl.resolve.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ List<D> f14075a;

            c(List<D> list) {
                this.f14075a = list;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.reflect.jvm.internal.impl.resolve.j
            public void a(kotlin.reflect.jvm.internal.impl.descriptors.b fakeOverride) {
                kotlin.jvm.internal.m.f(fakeOverride, "fakeOverride");
                kotlin.reflect.jvm.internal.impl.resolve.k.K(fakeOverride, null);
                this.f14075a.add((D) fakeOverride);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.i
            protected void e(kotlin.reflect.jvm.internal.impl.descriptors.b fromSuper, kotlin.reflect.jvm.internal.impl.descriptors.b fromCurrent) {
                kotlin.jvm.internal.m.f(fromSuper, "fromSuper");
                kotlin.jvm.internal.m.f(fromCurrent, "fromCurrent");
                if (fromCurrent instanceof p) {
                    ((p) fromCurrent).Q0(v.f13081a, fromSuper);
                }
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d$a$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0259d extends o implements c9.a<Collection<? extends g0>> {
            C0259d() {
                super(0);
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<g0> invoke() {
                return a.this.f14071g.g(a.this.B());
            }
        }

        public a(d dVar, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f14074j = dVar;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.m mVarV0 = dVar.V0();
            List<w9.i> listH0 = dVar.W0().H0();
            kotlin.jvm.internal.m.e(listH0, "classProto.functionList");
            List<w9.n> listV0 = dVar.W0().V0();
            kotlin.jvm.internal.m.e(listV0, "classProto.propertyList");
            List<r> listD1 = dVar.W0().d1();
            kotlin.jvm.internal.m.e(listD1, "classProto.typeAliasList");
            List<Integer> listS0 = dVar.W0().S0();
            kotlin.jvm.internal.m.e(listS0, "classProto.nestedClassNameList");
            List<Integer> list = listS0;
            y9.c cVarG = dVar.V0().g();
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(w.b(cVarG, ((Number) it.next()).intValue()));
            }
            super(mVarV0, listH0, listV0, listD1, new C0258a(arrayList));
            this.f14071g = kotlinTypeRefiner;
            this.f14072h = p().h().c(new b());
            this.f14073i = p().h().c(new C0259d());
        }

        private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> void A(ba.f fVar, Collection<? extends D> collection, List<D> list) {
            p().c().m().a().v(fVar, collection, new ArrayList(list), B(), new c(list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final d B() {
            return this.f14074j;
        }

        public void C(ba.f name, r9.b location) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(location, "location");
            q9.a.a(p().c().o(), location, B(), name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Collection<u0> a(ba.f name, r9.b location) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(location, "location");
            C(name, location);
            return super.a(name, location);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Collection<z0> c(ba.f name, r9.b location) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(location, "location");
            C(name, location);
            return super.c(name, location);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarF;
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(location, "location");
            C(name, location);
            c cVar = B().f14062q;
            return (cVar == null || (eVarF = cVar.f(name)) == null) ? super.e(name, location) : eVarF;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
            kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
            kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
            return this.f14072h.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
        protected void i(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> result, c9.l<? super ba.f, Boolean> nameFilter) {
            kotlin.jvm.internal.m.f(result, "result");
            kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
            c cVar = B().f14062q;
            List listD = cVar != null ? cVar.d() : null;
            if (listD == null) {
                listD = kotlin.collections.r.l();
            }
            result.addAll(listD);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
        protected void k(ba.f name, List<z0> functions) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(functions, "functions");
            ArrayList arrayList = new ArrayList();
            Iterator<g0> it = this.f14073i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().n().c(name, r9.d.FOR_ALREADY_TRACKED));
            }
            functions.addAll(p().c().c().d(name, this.f14074j));
            A(name, arrayList, functions);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
        protected void l(ba.f name, List<u0> descriptors) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(descriptors, "descriptors");
            ArrayList arrayList = new ArrayList();
            Iterator<g0> it = this.f14073i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().n().a(name, r9.d.FOR_ALREADY_TRACKED));
            }
            A(name, arrayList, descriptors);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
        protected ba.b m(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            ba.b bVarD = this.f14074j.f14054i.d(name);
            kotlin.jvm.internal.m.e(bVarD, "classId.createNestedClassId(name)");
            return bVarD;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
        protected boolean x(z0 function) {
            kotlin.jvm.internal.m.f(function, "function");
            return p().c().s().b(this.f14074j, function);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
        protected Set<ba.f> s() {
            List<g0> listB = B().f14060o.b();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                Set<ba.f> setF = ((g0) it.next()).n().f();
                if (setF == null) {
                    return null;
                }
                kotlin.collections.r.C(linkedHashSet, setF);
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
        protected Set<ba.f> t() {
            List<g0> listB = B().f14060o.b();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                kotlin.collections.r.C(linkedHashSet, ((g0) it.next()).n().b());
            }
            linkedHashSet.addAll(p().c().c().e(this.f14074j));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h
        protected Set<ba.f> u() {
            List<g0> listB = B().f14060o.b();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                kotlin.collections.r.C(linkedHashSet, ((g0) it.next()).n().d());
            }
            return linkedHashSet;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b extends kotlin.reflect.jvm.internal.impl.types.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ka.i<List<f1>> f14076d;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends o implements c9.a<List<? extends f1>> {
            final /* synthetic */ d this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.this$0 = dVar;
            }

            @Override // c9.a
            public final List<? extends f1> invoke() {
                return g1.d(this.this$0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public boolean e() {
            return true;
        }

        public b() {
            super(d.this.V0().h());
            this.f14076d = d.this.V0().h().c(new a(d.this));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public List<f1> getParameters() {
            return this.f14076d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected Collection<g0> m() {
            String strF;
            ba.c cVarB;
            List<q> listO = y9.f.o(d.this.W0(), d.this.V0().j());
            d dVar = d.this;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listO, 10));
            Iterator<T> it = listO.iterator();
            while (it.hasNext()) {
                arrayList.add(dVar.V0().i().q((q) it.next()));
            }
            List listB0 = kotlin.collections.r.B0(arrayList, d.this.V0().c().c().c(d.this));
            ArrayList<k0.b> arrayList2 = new ArrayList();
            Iterator it2 = listB0.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = ((g0) it2.next()).J0().d();
                k0.b bVar = hVarD instanceof k0.b ? (k0.b) hVarD : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.q qVarI = d.this.V0().c().i();
                d dVar2 = d.this;
                ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(arrayList2, 10));
                for (k0.b bVar2 : arrayList2) {
                    ba.b bVarK = ea.c.k(bVar2);
                    if (bVarK == null || (cVarB = bVarK.b()) == null || (strF = cVarB.b()) == null) {
                        strF = bVar2.getName().f();
                    }
                    arrayList3.add(strF);
                }
                qVarI.b(dVar2, arrayList3);
            }
            return kotlin.collections.r.O0(listB0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected d1 q() {
            return d1.a.f12742a;
        }

        public String toString() {
            String string = d.this.getName().toString();
            kotlin.jvm.internal.m.e(string, "name.toString()");
            return string;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public d d() {
            return d.this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<ba.f, w9.g> f14078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ka.h<ba.f, kotlin.reflect.jvm.internal.impl.descriptors.e> f14079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ka.i<Set<ba.f>> f14080c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends o implements c9.l<ba.f, kotlin.reflect.jvm.internal.impl.descriptors.e> {
            final /* synthetic */ d this$1;

            /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            static final class C0260a extends o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
                final /* synthetic */ w9.g $proto;
                final /* synthetic */ d this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0260a(d dVar, w9.g gVar) {
                    super(0);
                    this.this$0 = dVar;
                    this.$proto = gVar;
                }

                @Override // c9.a
                public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
                    return kotlin.collections.r.O0(this.this$0.V0().c().d().g(this.this$0.a1(), this.$proto));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(1);
                this.this$1 = dVar;
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke(ba.f name) {
                kotlin.jvm.internal.m.f(name, "name");
                w9.g gVar = (w9.g) c.this.f14078a.get(name);
                if (gVar == null) {
                    return null;
                }
                d dVar = this.this$1;
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.n.H0(dVar.V0().h(), dVar, name, c.this.f14080c, new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a(dVar.V0().h(), new C0260a(dVar, gVar)), a1.f12668a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class b extends o implements c9.a<Set<? extends ba.f>> {
            b() {
                super(0);
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<ba.f> invoke() {
                return c.this.e();
            }
        }

        public c() {
            List<w9.g> listC0 = d.this.W0().C0();
            kotlin.jvm.internal.m.e(listC0, "classProto.enumEntryList");
            List<w9.g> list = listC0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(kotlin.collections.r.w(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(w.b(d.this.V0().g(), ((w9.g) obj).E()), obj);
            }
            this.f14078a = linkedHashMap;
            this.f14079b = d.this.V0().h().i(new a(d.this));
            this.f14080c = d.this.V0().h().c(new b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<ba.f> e() {
            HashSet hashSet = new HashSet();
            Iterator<g0> it = d.this.h().b().iterator();
            while (it.hasNext()) {
                for (kotlin.reflect.jvm.internal.impl.descriptors.m mVar : kotlin.reflect.jvm.internal.impl.resolve.scopes.k.a.a(it.next().n(), null, null, 3, null)) {
                    if ((mVar instanceof z0) || (mVar instanceof u0)) {
                        hashSet.add(mVar.getName());
                    }
                }
            }
            List<w9.i> listH0 = d.this.W0().H0();
            kotlin.jvm.internal.m.e(listH0, "classProto.functionList");
            d dVar = d.this;
            Iterator<T> it2 = listH0.iterator();
            while (it2.hasNext()) {
                hashSet.add(w.b(dVar.V0().g(), ((w9.i) it2.next()).d0()));
            }
            List<w9.n> listV0 = d.this.W0().V0();
            kotlin.jvm.internal.m.e(listV0, "classProto.propertyList");
            d dVar2 = d.this;
            Iterator<T> it3 = listV0.iterator();
            while (it3.hasNext()) {
                hashSet.add(w.b(dVar2.V0().g(), ((w9.n) it3.next()).c0()));
            }
            return v0.k(hashSet, hashSet);
        }

        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> d() {
            Set<ba.f> setKeySet = this.f14078a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarF = f((ba.f) it.next());
                if (eVarF != null) {
                    arrayList.add(eVarF);
                }
            }
            return arrayList;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.e f(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            return this.f14079b.invoke(name);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0261d extends o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        C0261d() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            return kotlin.collections.r.O0(d.this.V0().c().d().b(d.this.a1()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends o implements c9.a<kotlin.reflect.jvm.internal.impl.descriptors.e> {
        e() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke() {
            return d.this.P0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class f extends kotlin.jvm.internal.j implements c9.l<q, o0> {
        f(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "simpleType";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(kotlin.jvm.internal.m.a.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "computeValueClassRepresentation$simpleType(Lorg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;)Lorg/jetbrains/kotlin/types/SimpleType;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final o0 invoke(q p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.c0.n((kotlin.reflect.jvm.internal.impl.serialization.deserialization.c0) this.receiver, p10, false, 2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class g extends kotlin.jvm.internal.j implements c9.l<ba.f, o0> {
        g(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "getValueClassPropertyType";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(d.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final o0 invoke(ba.f p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return ((d) this.receiver).b1(p10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class h extends o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.d>> {
        h() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> invoke() {
            return d.this.Q0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class i extends kotlin.jvm.internal.j implements c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, a> {
        i(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(a.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final a invoke(kotlin.reflect.jvm.internal.impl.types.checker.g p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return new a((d) this.receiver, p10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class j extends o implements c9.a<kotlin.reflect.jvm.internal.impl.descriptors.d> {
        j() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke() {
            return d.this.R0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class k extends o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.e>> {
        k() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> invoke() {
            return d.this.T0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class l extends o implements c9.a<h1<o0>> {
        l() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h1<o0> invoke() {
            return d.this.U0();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(kotlin.reflect.jvm.internal.impl.serialization.deserialization.m outerContext, w9.c classProto, y9.c nameResolver, y9.a metadataVersion, a1 sourceElement) {
        super(outerContext.h(), w.a(nameResolver, classProto.E0()).j());
        kotlin.jvm.internal.m.f(outerContext, "outerContext");
        kotlin.jvm.internal.m.f(classProto, "classProto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.m.f(sourceElement, "sourceElement");
        this.f14051f = classProto;
        this.f14052g = metadataVersion;
        this.f14053h = sourceElement;
        this.f14054i = w.a(nameResolver, classProto.E0());
        z zVar = z.f14212a;
        this.f14055j = zVar.b(y9.b.f22498e.d(classProto.D0()));
        this.f14056k = a0.a(zVar, y9.b.f22497d.d(classProto.D0()));
        kotlin.reflect.jvm.internal.impl.descriptors.f fVarA = zVar.a(y9.b.f22499f.d(classProto.D0()));
        this.f14057l = fVarA;
        List<s> listG1 = classProto.g1();
        kotlin.jvm.internal.m.e(listG1, "classProto.typeParameterList");
        t tVarH1 = classProto.h1();
        kotlin.jvm.internal.m.e(tVarH1, "classProto.typeTable");
        y9.g gVar = new y9.g(tVarH1);
        y9.h.a aVar = y9.h.f22527b;
        w9.w wVarJ1 = classProto.j1();
        kotlin.jvm.internal.m.e(wVarJ1, "classProto.versionRequirementTable");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.m mVarA = outerContext.a(this, listG1, nameResolver, gVar, aVar.a(wVarJ1), metadataVersion);
        this.f14058m = mVarA;
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_CLASS;
        this.f14059n = fVarA == fVar ? new kotlin.reflect.jvm.internal.impl.resolve.scopes.l(mVarA.h(), this) : kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        this.f14060o = new b();
        this.f14061p = y0.f13084e.a(this, mVarA.h(), mVarA.c().m().c(), new i(this));
        this.f14062q = fVarA == fVar ? new c() : null;
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarE = outerContext.e();
        this.f14063r = mVarE;
        this.f14064s = mVarA.h().g(new j());
        this.f14065t = mVarA.h().c(new h());
        this.f14066u = mVarA.h().g(new e());
        this.f14067v = mVarA.h().c(new k());
        this.f14068w = mVarA.h().g(new l());
        y9.c cVarG = mVarA.g();
        y9.g gVarJ = mVarA.j();
        d dVar = mVarE instanceof d ? (d) mVarE : null;
        this.f14069x = new y.a(classProto, cVarG, gVarJ, sourceElement, dVar != null ? dVar.f14069x : null);
        this.f14070y = !y9.b.f22496c.d(classProto.D0()).booleanValue() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b() : new n(mVarA.h(), new C0261d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e P0() {
        if (!this.f14051f.k1()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarE = X0().e(w.b(this.f14058m.g(), this.f14051f.q0()), r9.d.FROM_DESERIALIZATION);
        if (hVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d R0() {
        Object next;
        if (this.f14057l.f()) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.f fVarL = kotlin.reflect.jvm.internal.impl.resolve.d.l(this, a1.f12668a);
            fVarL.c1(p());
            return fVarL;
        }
        List<w9.d> listT0 = this.f14051f.t0();
        kotlin.jvm.internal.m.e(listT0, "classProto.constructorList");
        Iterator<T> it = listT0.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (y9.b.f22506m.d(((w9.d) next).I()).booleanValue());
        w9.d dVar = (w9.d) next;
        if (dVar != null) {
            return this.f14058m.f().i(dVar, true);
        }
        return null;
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.d> S0() {
        List<w9.d> listT0 = this.f14051f.t0();
        kotlin.jvm.internal.m.e(listT0, "classProto.constructorList");
        ArrayList<w9.d> arrayList = new ArrayList();
        for (Object obj : listT0) {
            Boolean boolD = y9.b.f22506m.d(((w9.d) obj).I());
            kotlin.jvm.internal.m.e(boolD, "IS_SECONDARY.get(it.flags)");
            if (boolD.booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(arrayList, 10));
        for (w9.d it : arrayList) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.v vVarF = this.f14058m.f();
            kotlin.jvm.internal.m.e(it, "it");
            arrayList2.add(vVarF.i(it, false));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> T0() {
        if (this.f14055j != e0.SEALED) {
            return kotlin.collections.r.l();
        }
        List<Integer> fqNames = this.f14051f.W0();
        kotlin.jvm.internal.m.e(fqNames, "fqNames");
        if (fqNames.isEmpty()) {
            return kotlin.reflect.jvm.internal.impl.resolve.a.f13881a.a(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer index : fqNames) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.k kVarC = this.f14058m.c();
            y9.c cVarG = this.f14058m.g();
            kotlin.jvm.internal.m.e(index, "index");
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarB = kVarC.b(w.a(cVarG, index.intValue()));
            if (eVarB != null) {
                arrayList.add(eVarB);
            }
        }
        return arrayList;
    }

    private final a X0() {
        return (a) this.f14061p.c(this.f14058m.c().m().c());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public List<x0> C0() {
        List<q> listB = y9.f.b(this.f14051f, this.f14058m.j());
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(new f0(F0(), new ha.b(this, this.f14058m.i().q((q) it.next()), null, null), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> E() {
        return this.f14067v.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean E0() {
        Boolean boolD = y9.b.f22501h.d(this.f14051f.D0());
        kotlin.jvm.internal.m.e(boolD, "IS_DATA.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean F() {
        Boolean boolD = y9.b.f22504k.d(this.f14051f.D0());
        kotlin.jvm.internal.m.e(boolD, "IS_VALUE_CLASS.get(classProto.flags)");
        return boolD.booleanValue() && this.f14052g.c(1, 4, 2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    protected kotlin.reflect.jvm.internal.impl.resolve.scopes.h G(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f14061p.c(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        Boolean boolD = y9.b.f22503j.d(this.f14051f.D0());
        kotlin.jvm.internal.m.e(boolD, "IS_EXPECT_CLASS.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean J() {
        Boolean boolD = y9.b.f22500g.d(this.f14051f.D0());
        kotlin.jvm.internal.m.e(boolD, "IS_INNER.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d M() {
        return this.f14064s.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e P() {
        return this.f14066u.invoke();
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.m V0() {
        return this.f14058m;
    }

    public final w9.c W0() {
        return this.f14051f;
    }

    public final y9.a Y0() {
        return this.f14052g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.i N() {
        return this.f14059n;
    }

    public final y.a a1() {
        return this.f14069x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        return this.f14063r;
    }

    public final boolean c1(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        return X0().q().contains(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f g() {
        return this.f14057l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return this.f14070y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public a1 getSource() {
        return this.f14053h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q
    public u getVisibility() {
        return this.f14056k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.jvm.internal.impl.types.g1 h() {
        return this.f14060o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public e0 i() {
        return this.f14055j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        Boolean boolD = y9.b.f22502i.d(this.f14051f.D0());
        kotlin.jvm.internal.m.e(boolD, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        Boolean boolD = y9.b.f22504k.d(this.f14051f.D0());
        kotlin.jvm.internal.m.e(boolD, "IS_VALUE_CLASS.get(classProto.flags)");
        return boolD.booleanValue() && this.f14052g.e(1, 4, 1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        return this.f14065t.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<f1> r() {
        return this.f14058m.i().j();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean t() {
        return y9.b.f22499f.d(this.f14051f.D0()) == w9.c.EnumC0388c.COMPANION_OBJECT;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("deserialized ");
        sb2.append(I() ? "expect " : "");
        sb2.append("class ");
        sb2.append(getName());
        return sb2.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public h1<o0> v0() {
        return this.f14068w.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean x() {
        Boolean boolD = y9.b.f22505l.d(this.f14051f.D0());
        kotlin.jvm.internal.m.e(boolD, "IS_FUN_INTERFACE.get(classProto.flags)");
        return boolD.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> Q0() {
        return kotlin.collections.r.B0(kotlin.collections.r.B0(S0(), kotlin.collections.r.p(M())), this.f14058m.c().c().a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h1<o0> U0() {
        if (!isInline() && !F()) {
            return null;
        }
        h1<o0> h1VarA = kotlin.reflect.jvm.internal.impl.serialization.deserialization.e0.a(this.f14051f, this.f14058m.g(), this.f14058m.j(), new f(this.f14058m.i()), new g(this));
        if (h1VarA != null) {
            return h1VarA;
        }
        if (this.f14052g.c(1, 5, 1)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVarM = M();
        if (dVarM != null) {
            List<j1> listF = dVarM.f();
            kotlin.jvm.internal.m.e(listF, "constructor.valueParameters");
            ba.f name = ((j1) kotlin.collections.r.g0(listF)).getName();
            kotlin.jvm.internal.m.e(name, "constructor.valueParameters.first().name");
            o0 o0VarB1 = b1(name);
            if (o0VarB1 != null) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.z(name, o0VarB1);
            }
            throw new IllegalStateException(("Value class has no underlying property: " + this).toString());
        }
        throw new IllegalStateException(("Inline class has no primary constructor: " + this).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o0 b1(ba.f fVar) {
        Iterator<T> it = X0().a(fVar, r9.d.FROM_DESERIALIZATION).iterator();
        g0 type = null;
        boolean z10 = false;
        Object obj = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((u0) next).i0() == null) {
                    if (!z10) {
                        z10 = true;
                        obj = next;
                    }
                }
            } else {
                if (!z10) {
                    break;
                }
                break;
            }
            obj = null;
            break;
        }
        u0 u0Var = (u0) obj;
        if (u0Var != null) {
            type = u0Var.getType();
        }
        return (o0) type;
    }
}
