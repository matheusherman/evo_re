package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.load.java.a0;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import kotlin.reflect.jvm.internal.impl.load.java.f0;
import kotlin.reflect.jvm.internal.impl.load.java.h0;
import kotlin.reflect.jvm.internal.impl.load.java.i0;
import kotlin.reflect.jvm.internal.impl.load.java.j0;
import kotlin.reflect.jvm.internal.impl.load.java.p;
import kotlin.reflect.jvm.internal.impl.load.java.s;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.r1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import u9.q;
import u9.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g extends kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f13314n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final u9.g f13315o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f13316p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ka.i<List<kotlin.reflect.jvm.internal.impl.descriptors.d>> f13317q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ka.i<Set<ba.f>> f13318r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ka.i<Set<ba.f>> f13319s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ka.i<Map<ba.f, u9.n>> f13320t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ka.h<ba.f, kotlin.reflect.jvm.internal.impl.descriptors.e> f13321u;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.l<q, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13322a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(!it.O());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class b extends kotlin.jvm.internal.j implements c9.l<ba.f, Collection<? extends z0>> {
        b(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(g.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Collection<z0> invoke(ba.f p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return ((g) this.receiver).J0(p10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class c extends kotlin.jvm.internal.j implements c9.l<ba.f, Collection<? extends z0>> {
        c(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(g.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Collection<z0> invoke(ba.f p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return ((g) this.receiver).K0(p10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends o implements c9.l<ba.f, Collection<? extends z0>> {
        d() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<z0> invoke(ba.f it) {
            kotlin.jvm.internal.m.f(it, "it");
            return g.this.J0(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends o implements c9.l<ba.f, Collection<? extends z0>> {
        e() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<z0> invoke(ba.f it) {
            kotlin.jvm.internal.m.f(it, "it");
            return g.this.K0(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.d>> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.g $c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar) {
            super(0);
            this.$c = gVar;
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.d> invoke() {
            Collection<u9.k> collectionK = g.this.f13315o.k();
            ArrayList arrayList = new ArrayList(collectionK.size());
            Iterator<u9.k> it = collectionK.iterator();
            while (it.hasNext()) {
                arrayList.add(g.this.H0(it.next()));
            }
            if (g.this.f13315o.q()) {
                kotlin.reflect.jvm.internal.impl.descriptors.d dVarF0 = g.this.f0();
                String strC = x.c(dVarF0, false, false, 2, null);
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            arrayList.add(dVarF0);
                            this.$c.a().h().c(g.this.f13315o, dVarF0);
                            break;
                        }
                    } while (!kotlin.jvm.internal.m.a(x.c((kotlin.reflect.jvm.internal.impl.descriptors.d) it2.next(), false, false, 2, null), strC));
                } else {
                    arrayList.add(dVarF0);
                    this.$c.a().h().c(g.this.f13315o, dVarF0);
                    break;
                }
            }
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar = this.$c;
            gVar.a().w().a(gVar, g.this.C(), arrayList);
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l lVarR = this.$c.a().r();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar2 = this.$c;
            g gVar3 = g.this;
            boolean zIsEmpty = arrayList.isEmpty();
            List listP = arrayList;
            if (zIsEmpty) {
                listP = r.p(gVar3.e0());
            }
            return r.O0(lVarR.g(gVar2, listP));
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0230g extends o implements c9.a<Map<ba.f, ? extends u9.n>> {
        C0230g() {
            super(0);
        }

        @Override // c9.a
        public final Map<ba.f, ? extends u9.n> invoke() {
            Collection<u9.n> collectionA = g.this.f13315o.A();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionA) {
                if (((u9.n) obj).D()) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(r.w(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((u9.n) obj2).getName(), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class h extends o implements c9.a<Set<? extends ba.f>> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.g $c;
        final /* synthetic */ g this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, g gVar2) {
            super(0);
            this.$c = gVar;
            this.this$0 = gVar2;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<ba.f> invoke() {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar = this.$c;
            return r.S0(gVar.a().w().g(gVar, this.this$0.C()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class i extends o implements c9.l<ba.f, Collection<? extends z0>> {
        final /* synthetic */ z0 $function;
        final /* synthetic */ g this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(z0 z0Var, g gVar) {
            super(1);
            this.$function = z0Var;
            this.this$0 = gVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<z0> invoke(ba.f accessorName) {
            kotlin.jvm.internal.m.f(accessorName, "accessorName");
            return kotlin.jvm.internal.m.a(this.$function.getName(), accessorName) ? r.e(this.$function) : r.B0(this.this$0.J0(accessorName), this.this$0.K0(accessorName));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class j extends o implements c9.a<Set<? extends ba.f>> {
        j() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<ba.f> invoke() {
            return r.S0(g.this.f13315o.I());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class k extends o implements c9.l<ba.f, kotlin.reflect.jvm.internal.impl.descriptors.e> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.g $c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends o implements c9.a<Set<? extends ba.f>> {
            final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(0);
                this.this$0 = gVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set<ba.f> invoke() {
                return v0.k(this.this$0.b(), this.this$0.d());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar) {
            super(1);
            this.$c = gVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            if (((Set) g.this.f13318r.invoke()).contains(name)) {
                p pVarD = this.$c.a().d();
                ba.b bVarK = ea.c.k(g.this.C());
                kotlin.jvm.internal.m.c(bVarK);
                ba.b bVarD = bVarK.d(name);
                kotlin.jvm.internal.m.e(bVarD, "ownerDescriptor.classId!…createNestedClassId(name)");
                u9.g gVarA = pVarD.a(new p.a(bVarD, null, g.this.f13315o, 2, null));
                if (gVarA == null) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar = this.$c;
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f(gVar, g.this.C(), gVarA, null, 8, null);
                gVar.a().e().a(fVar);
                return fVar;
            }
            if (!((Set) g.this.f13319s.invoke()).contains(name)) {
                u9.n nVar = (u9.n) ((Map) g.this.f13320t.invoke()).get(name);
                if (nVar == null) {
                    return null;
                }
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.n.H0(this.$c.e(), g.this.C(), name, this.$c.e().c(new a(g.this)), kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(this.$c, nVar), this.$c.a().t().a(nVar));
            }
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar2 = this.$c;
            g gVar3 = g.this;
            List<kotlin.reflect.jvm.internal.impl.descriptors.e> listC = r.c();
            gVar2.a().w().c(gVar2, gVar3.C(), name, listC);
            List listA = r.a(listC);
            int size = listA.size();
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.e) r.F0(listA);
            }
            throw new IllegalStateException(("Multiple classes with same name are generated: " + listA).toString());
        }
    }

    public /* synthetic */ g(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, u9.g gVar2, boolean z10, g gVar3, int i10, kotlin.jvm.internal.g gVar4) {
        this(gVar, eVar, gVar2, z10, (i10 & 16) != 0 ? null : gVar3);
    }

    private final boolean B0(z0 z0Var, y yVar) {
        String strC = x.c(z0Var, false, false, 2, null);
        y yVarA = yVar.a();
        kotlin.jvm.internal.m.e(yVarA, "builtinWithErasedParameters.original");
        return kotlin.jvm.internal.m.a(strC, x.c(yVarA, false, false, 2, null)) && !p0(z0Var, yVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, kotlin.reflect.jvm.internal.impl.descriptors.e ownerDescriptor, u9.g jClass, boolean z10, g gVar) {
        super(c10, gVar);
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(ownerDescriptor, "ownerDescriptor");
        kotlin.jvm.internal.m.f(jClass, "jClass");
        this.f13314n = ownerDescriptor;
        this.f13315o = jClass;
        this.f13316p = z10;
        this.f13317q = c10.e().c(new f(c10));
        this.f13318r = c10.e().c(new j());
        this.f13319s = c10.e().c(new h(c10, this));
        this.f13320t = c10.e().c(new C0230g());
        this.f13321u = c10.e().i(new k(c10));
    }

    private final s9.e I0(w wVar) {
        s9.e eVarL1 = s9.e.l1(C(), kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(w(), wVar), wVar.getName(), w().a().t().a(wVar), true);
        kotlin.jvm.internal.m.e(eVarL1, "createJavaMethod(\n      …omponent), true\n        )");
        eVarL1.k1(null, z(), r.l(), r.l(), r.l(), w().g().o(wVar.getType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, false, false, null, 6, null)), e0.f12743a.a(false, false, true), t.f13068e, null);
        eVarL1.o1(false, false);
        w().a().h().b(wVar, eVarL1);
        return eVarL1;
    }

    private final boolean L0(z0 z0Var) {
        kotlin.reflect.jvm.internal.impl.load.java.f fVar = kotlin.reflect.jvm.internal.impl.load.java.f.f13199n;
        ba.f name = z0Var.getName();
        kotlin.jvm.internal.m.e(name, "name");
        if (!fVar.l(name)) {
            return false;
        }
        ba.f name2 = z0Var.getName();
        kotlin.jvm.internal.m.e(name2, "name");
        Set<z0> setY0 = y0(name2);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setY0.iterator();
        while (it.hasNext()) {
            y yVarK = kotlin.reflect.jvm.internal.impl.load.java.f.k((z0) it.next());
            if (yVarK != null) {
                arrayList.add(yVarK);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (B0(z0Var, (y) it2.next())) {
                return true;
            }
        }
        return false;
    }

    private final void V(List<j1> list, kotlin.reflect.jvm.internal.impl.descriptors.l lVar, int i10, u9.r rVar, g0 g0Var, g0 g0Var2) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarB = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
        ba.f name = rVar.getName();
        g0 g0VarN = s1.n(g0Var);
        kotlin.jvm.internal.m.e(g0VarN, "makeNotNullable(returnType)");
        list.add(new l0(lVar, null, i10, gVarB, name, g0VarN, rVar.J(), false, false, g0Var2 != null ? s1.n(g0Var2) : null, w().a().t().a(rVar)));
    }

    private final Collection<g0> c0() {
        if (!this.f13316p) {
            return w().a().k().c().g(C());
        }
        Collection<g0> collectionB = C().h().b();
        kotlin.jvm.internal.m.e(collectionB, "ownerDescriptor.typeConstructor.supertypes");
        return collectionB;
    }

    private final List<j1> d0(kotlin.reflect.jvm.internal.impl.descriptors.impl.f fVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.f fVar2;
        r8.p pVar;
        Collection<u9.r> collectionK = this.f13315o.K();
        ArrayList arrayList = new ArrayList(collectionK.size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVarB = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, true, false, null, 6, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : collectionK) {
            if (kotlin.jvm.internal.m.a(((u9.r) obj).getName(), b0.f13111c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        r8.p pVar2 = new r8.p(arrayList2, arrayList3);
        List list = (List) pVar2.a();
        List<u9.r> list2 = (List) pVar2.b();
        list.size();
        u9.r rVar = (u9.r) r.i0(list);
        if (rVar != null) {
            u9.x returnType = rVar.getReturnType();
            if (returnType instanceof u9.f) {
                u9.f fVar3 = (u9.f) returnType;
                pVar = new r8.p(w().g().k(fVar3, aVarB, true), w().g().o(fVar3.m(), aVarB));
            } else {
                pVar = new r8.p(w().g().o(returnType, aVarB), null);
            }
            g0 g0Var = (g0) pVar.a();
            g0 g0Var2 = (g0) pVar.b();
            fVar2 = fVar;
            V(arrayList, fVar2, 0, rVar, g0Var, g0Var2);
        } else {
            fVar2 = fVar;
        }
        int i10 = 0;
        int i11 = rVar == null ? 0 : 1;
        for (u9.r rVar2 : list2) {
            V(arrayList, fVar2, i10 + i11, rVar2, w().g().o(rVar2.getReturnType(), aVarB), null);
            i10++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d e0() {
        boolean zO = this.f13315o.o();
        if ((this.f13315o.F() || !this.f13315o.r()) && !zO) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarC = C();
        s9.b bVarP1 = s9.b.p1(eVarC, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), true, w().a().t().a(this.f13315o));
        kotlin.jvm.internal.m.e(bVarP1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<j1> listD0 = zO ? d0(bVarP1) : Collections.EMPTY_LIST;
        bVarP1.V0(false);
        bVarP1.m1(listD0, w0(eVarC));
        bVarP1.U0(true);
        bVarP1.c1(eVarC.p());
        w().a().h().c(this.f13315o, bVarP1);
        return bVarP1;
    }

    private final z0 g0(z0 z0Var, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<? extends z0> collection) {
        Collection<? extends z0> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return z0Var;
        }
        for (z0 z0Var2 : collection2) {
            if (!kotlin.jvm.internal.m.a(z0Var, z0Var2) && z0Var2.Z() == null && p0(z0Var2, aVar)) {
                y yVarBuild = z0Var.q().q().build();
                kotlin.jvm.internal.m.c(yVarBuild);
                return (z0) yVarBuild;
            }
        }
        return z0Var;
    }

    private final s9.f j0(u9.r rVar, g0 g0Var, e0 e0Var) {
        g gVar;
        g0 g0VarQ;
        s9.f fVarB1 = s9.f.b1(C(), kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(w(), rVar), e0Var, j0.d(rVar.getVisibility()), false, rVar.getName(), w().a().t().a(rVar), false);
        kotlin.jvm.internal.m.e(fVarB1, "create(\n            owne…inal = */ false\n        )");
        d0 d0VarD = kotlin.reflect.jvm.internal.impl.resolve.d.d(fVarB1, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b());
        kotlin.jvm.internal.m.e(d0VarD, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        fVarB1.Q0(d0VarD, null);
        if (g0Var == null) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVarF = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.f(w(), fVarB1, rVar, 0, 4, null);
            gVar = this;
            g0VarQ = gVar.q(rVar, gVarF);
        } else {
            gVar = this;
            g0VarQ = g0Var;
        }
        fVarB1.X0(g0VarQ, r.l(), gVar.z(), null, r.l());
        d0VarD.M0(g0VarQ);
        return fVarB1;
    }

    static /* synthetic */ s9.f k0(g gVar, u9.r rVar, g0 g0Var, e0 e0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            g0Var = null;
        }
        return gVar.j0(rVar, g0Var, e0Var);
    }

    private final List<j1> l0(kotlin.reflect.jvm.internal.impl.descriptors.impl.f fVar) {
        Collection<w> collectionI = this.f13315o.i();
        ArrayList arrayList = new ArrayList(collectionI.size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVarB = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, false, false, null, 6, null);
        int i10 = 0;
        for (w wVar : collectionI) {
            int i11 = i10 + 1;
            g0 g0VarO = w().g().o(wVar.getType(), aVarB);
            arrayList.add(new l0(fVar, null, i10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), wVar.getName(), g0VarO, false, false, false, wVar.a() ? w().a().m().l().k(g0VarO) : null, w().a().t().a(wVar)));
            i10 = i11;
        }
        return arrayList;
    }

    private final boolean p0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        kotlin.reflect.jvm.internal.impl.resolve.k.i.a aVarC = kotlin.reflect.jvm.internal.impl.resolve.k.f13933f.F(aVar2, aVar, true).c();
        kotlin.jvm.internal.m.e(aVarC, "DEFAULT.isOverridableByW…iptor, this, true).result");
        return aVarC == kotlin.reflect.jvm.internal.impl.resolve.k.i.a.OVERRIDABLE && !kotlin.reflect.jvm.internal.impl.load.java.t.f13424a.a(aVar2, aVar);
    }

    private final boolean q0(z0 z0Var) {
        i0.a aVar = i0.f13217a;
        ba.f name = z0Var.getName();
        kotlin.jvm.internal.m.e(name, "name");
        ba.f fVarB = aVar.b(name);
        if (fVarB == null) {
            return false;
        }
        Set<z0> setY0 = y0(fVarB);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setY0) {
            if (h0.a((z0) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        z0 z0VarM0 = m0(z0Var, fVarB);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (r0((z0) it.next(), z0VarM0)) {
                return true;
            }
        }
        return false;
    }

    private final boolean r0(z0 z0Var, y yVar) {
        if (kotlin.reflect.jvm.internal.impl.load.java.e.f13195n.k(z0Var)) {
            yVar = yVar.a();
        }
        kotlin.jvm.internal.m.e(yVar, "if (superDescriptor.isRe…iginal else subDescriptor");
        return p0(yVar, z0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected boolean G(s9.e eVar) {
        kotlin.jvm.internal.m.f(eVar, "<this>");
        if (this.f13315o.o()) {
            return false;
        }
        return C0(eVar);
    }

    public void G0(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        q9.a.a(w().a().l(), location, C(), name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j.a H(u9.r method, List<? extends f1> methodTypeParameters, g0 returnType, List<? extends j1> valueParameters) {
        kotlin.jvm.internal.m.f(method, "method");
        kotlin.jvm.internal.m.f(methodTypeParameters, "methodTypeParameters");
        kotlin.jvm.internal.m.f(returnType, "returnType");
        kotlin.jvm.internal.m.f(valueParameters, "valueParameters");
        kotlin.reflect.jvm.internal.impl.load.java.components.j.b bVarB = w().a().s().b(method, C(), returnType, null, valueParameters, methodTypeParameters);
        kotlin.jvm.internal.m.e(bVarB, "c.components.signaturePr…dTypeParameters\n        )");
        g0 g0VarD = bVarB.d();
        kotlin.jvm.internal.m.e(g0VarD, "propagated.returnType");
        g0 g0VarC = bVarB.c();
        List<j1> listF = bVarB.f();
        kotlin.jvm.internal.m.e(listF, "propagated.valueParameters");
        List<f1> listE = bVarB.e();
        kotlin.jvm.internal.m.e(listE, "propagated.typeParameters");
        boolean zG = bVarB.g();
        List<String> listB = bVarB.b();
        kotlin.jvm.internal.m.e(listB, "propagated.errors");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j.a(g0VarD, g0VarC, listF, listE, zG, listB);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        G0(name, location);
        return super.a(name, location);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<ba.f> n(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        Collection<g0> collectionB = C().h().b();
        kotlin.jvm.internal.m.e(collectionB, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<ba.f> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = collectionB.iterator();
        while (it.hasNext()) {
            r.C(linkedHashSet, ((g0) it.next()).n().b());
        }
        linkedHashSet.addAll(y().invoke().a());
        linkedHashSet.addAll(y().invoke().e());
        linkedHashSet.addAll(l(kindFilter, lVar));
        linkedHashSet.addAll(w().a().w().b(w(), C()));
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a p() {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a(this.f13315o, a.f13322a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        G0(name, location);
        return super.c(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        ka.h<ba.f, kotlin.reflect.jvm.internal.impl.descriptors.e> hVar;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarInvoke;
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        G0(name, location);
        g gVar = (g) B();
        return (gVar == null || (hVar = gVar.f13321u) == null || (eVarInvoke = hVar.invoke(name)) == null) ? this.f13321u.invoke(name) : eVarInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected Set<ba.f> l(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        return v0.k(this.f13318r.invoke(), this.f13320t.invoke().keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void o(Collection<z0> result, ba.f name) {
        kotlin.jvm.internal.m.f(result, "result");
        kotlin.jvm.internal.m.f(name, "name");
        if (this.f13315o.q() && y().invoke().c(name) != null) {
            Collection<z0> collection = result;
            if (collection.isEmpty()) {
                w wVarC = y().invoke().c(name);
                kotlin.jvm.internal.m.c(wVarC);
                result.add(I0(wVarC));
            } else {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((z0) it.next()).f().isEmpty()) {
                    }
                }
                w wVarC2 = y().invoke().c(name);
                kotlin.jvm.internal.m.c(wVarC2);
                result.add(I0(wVarC2));
            }
        }
        w().a().w().e(w(), C(), name, result);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void r(Collection<z0> result, ba.f name) {
        kotlin.jvm.internal.m.f(result, "result");
        kotlin.jvm.internal.m.f(name, "name");
        Set<z0> setY0 = y0(name);
        if (!i0.f13217a.k(name) && !kotlin.reflect.jvm.internal.impl.load.java.f.f13199n.l(name)) {
            if (!androidx.view.k.a(setY0) || !setY0.isEmpty()) {
                Iterator<T> it = setY0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((y) it.next()).isSuspend()) {
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : setY0) {
                if (C0((z0) obj)) {
                    arrayList.add(obj);
                }
            }
            W(result, name, arrayList, false);
            return;
        }
        sa.g gVarA = sa.g.f18524c.a();
        Collection<? extends z0> collectionD = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(name, setY0, r.l(), C(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.q.f14188a, w().a().k().a());
        kotlin.jvm.internal.m.e(collectionD, "resolveOverridesForNonSt….overridingUtil\n        )");
        X(name, result, collectionD, result, new b(this));
        X(name, result, collectionD, gVarA, new c(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setY0) {
            if (C0((z0) obj2)) {
                arrayList2.add(obj2);
            }
        }
        W(result, name, r.B0(arrayList2, gVarA), true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void s(ba.f name, Collection<u0> result) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(result, "result");
        if (this.f13315o.o()) {
            Z(name, result);
        }
        Set<u0> setA0 = A0(name);
        if (setA0.isEmpty()) {
            return;
        }
        sa.g.b bVar = sa.g.f18524c;
        sa.g gVarA = bVar.a();
        sa.g gVarA2 = bVar.a();
        Y(setA0, result, gVarA, new d());
        Y(v0.i(setA0, gVarA), gVarA2, null, new e());
        Collection<? extends u0> collectionD = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(name, v0.k(setA0, gVarA2), result, C(), w().a().c(), w().a().k().a());
        kotlin.jvm.internal.m.e(collectionD, "resolveOverridesForNonSt…rridingUtil\n            )");
        result.addAll(collectionD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected Set<ba.f> t(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        if (this.f13315o.o()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(y().invoke().f());
        Collection<g0> collectionB = C().h().b();
        kotlin.jvm.internal.m.e(collectionB, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = collectionB.iterator();
        while (it.hasNext()) {
            r.C(linkedHashSet, ((g0) it.next()).n().d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    public String toString() {
        return "Lazy Java member scope for " + this.f13315o.d();
    }

    public final ka.i<List<kotlin.reflect.jvm.internal.impl.descriptors.d>> x0() {
        return this.f13317q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e C() {
        return this.f13314n;
    }

    private final Set<u0> A0(ba.f fVar) {
        Collection<g0> collectionC0 = c0();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionC0.iterator();
        while (it.hasNext()) {
            Collection<? extends u0> collectionA = ((g0) it.next()).n().a(fVar, r9.d.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(r.w(collectionA, 10));
            Iterator<T> it2 = collectionA.iterator();
            while (it2.hasNext()) {
                arrayList2.add((u0) it2.next());
            }
            r.C(arrayList, arrayList2);
        }
        return r.S0(arrayList);
    }

    private final boolean C0(z0 z0Var) {
        ba.f name = z0Var.getName();
        kotlin.jvm.internal.m.e(name, "function.name");
        List<ba.f> listA = f0.a(name);
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                Set<u0> setA0 = A0((ba.f) it.next());
                if (!androidx.view.k.a(setA0) || !setA0.isEmpty()) {
                    for (u0 u0Var : setA0) {
                        if (o0(u0Var, new i(z0Var, this))) {
                            if (!u0Var.f0()) {
                                String strF = z0Var.getName().f();
                                kotlin.jvm.internal.m.e(strF, "function.name.asString()");
                                if (!a0.d(strF)) {
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        if (q0(z0Var) || L0(z0Var) || s0(z0Var)) {
            return false;
        }
        return true;
    }

    private final z0 D0(z0 z0Var, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar, Collection<? extends z0> collection) {
        z0 z0VarH0;
        y yVarK = kotlin.reflect.jvm.internal.impl.load.java.f.k(z0Var);
        if (yVarK != null && (z0VarH0 = h0(yVarK, lVar)) != null) {
            if (!C0(z0VarH0)) {
                z0VarH0 = null;
            }
            if (z0VarH0 != null) {
                return g0(z0VarH0, yVarK, collection);
            }
        }
        return null;
    }

    private final z0 E0(z0 z0Var, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar, ba.f fVar, Collection<? extends z0> collection) {
        z0 z0Var2 = (z0) h0.d(z0Var);
        if (z0Var2 == null) {
            return null;
        }
        String strB = h0.b(z0Var2);
        kotlin.jvm.internal.m.c(strB);
        ba.f fVarL = ba.f.l(strB);
        kotlin.jvm.internal.m.e(fVarL, "identifier(nameInJava)");
        Iterator<? extends z0> it = lVar.invoke(fVarL).iterator();
        while (it.hasNext()) {
            z0 z0VarM0 = m0(it.next(), fVar);
            if (r0(z0Var2, z0VarM0)) {
                return g0(z0VarM0, z0Var2, collection);
            }
        }
        return null;
    }

    private final z0 F0(z0 z0Var, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        if (!z0Var.isSuspend()) {
            return null;
        }
        ba.f name = z0Var.getName();
        kotlin.jvm.internal.m.e(name, "descriptor.name");
        Iterator<T> it = lVar.invoke(name).iterator();
        while (it.hasNext()) {
            z0 z0VarN0 = n0((z0) it.next());
            if (z0VarN0 == null || !p0(z0VarN0, z0Var)) {
                z0VarN0 = null;
            }
            if (z0VarN0 != null) {
                return z0VarN0;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s9.b H0(u9.k kVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarC = C();
        s9.b bVarP1 = s9.b.p1(eVarC, kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(w(), kVar), false, w().a().t().a(kVar));
        kotlin.jvm.internal.m.e(bVarP1, "createJavaConstructor(\n …ce(constructor)\n        )");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVarE = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.e(w(), bVarP1, kVar, eVarC.r().size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j.b bVarK = K(gVarE, bVarP1, kVar.f());
        List<f1> listR = eVarC.r();
        kotlin.jvm.internal.m.e(listR, "classDescriptor.declaredTypeParameters");
        List<f1> list = listR;
        List<u9.y> typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(r.w(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            f1 f1VarA = gVarE.f().a((u9.y) it.next());
            kotlin.jvm.internal.m.c(f1VarA);
            arrayList.add(f1VarA);
        }
        bVarP1.n1(bVarK.a(), j0.d(kVar.getVisibility()), r.B0(list, arrayList));
        bVarP1.U0(false);
        bVarP1.V0(bVarK.b());
        bVarP1.c1(eVarC.p());
        gVarE.a().h().c(kVar, bVarP1);
        return bVarP1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<z0> J0(ba.f fVar) {
        Collection<u9.r> collectionB = y().invoke().b(fVar);
        ArrayList arrayList = new ArrayList(r.w(collectionB, 10));
        Iterator<T> it = collectionB.iterator();
        while (it.hasNext()) {
            arrayList.add(I((u9.r) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<z0> K0(ba.f fVar) {
        Set<z0> setY0 = y0(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setY0) {
            z0 z0Var = (z0) obj;
            if (!h0.a(z0Var) && kotlin.reflect.jvm.internal.impl.load.java.f.k(z0Var) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void W(Collection<z0> collection, ba.f fVar, Collection<? extends z0> collection2, boolean z10) {
        Collection<? extends z0> collectionD = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(fVar, collection2, collection, C(), w().a().c(), w().a().k().a());
        kotlin.jvm.internal.m.e(collectionD, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (!z10) {
            collection.addAll(collectionD);
            return;
        }
        Collection<? extends z0> collection3 = collectionD;
        List listB0 = r.B0(collection, collection3);
        ArrayList arrayList = new ArrayList(r.w(collection3, 10));
        for (z0 resolvedOverride : collection3) {
            z0 z0Var = (z0) h0.e(resolvedOverride);
            if (z0Var == null) {
                kotlin.jvm.internal.m.e(resolvedOverride, "resolvedOverride");
            } else {
                kotlin.jvm.internal.m.e(resolvedOverride, "resolvedOverride");
                resolvedOverride = g0(resolvedOverride, z0Var, listB0);
            }
            arrayList.add(resolvedOverride);
        }
        collection.addAll(arrayList);
    }

    private final void X(ba.f fVar, Collection<? extends z0> collection, Collection<? extends z0> collection2, Collection<z0> collection3, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        for (z0 z0Var : collection2) {
            sa.a.a(collection3, E0(z0Var, lVar, fVar, collection));
            sa.a.a(collection3, D0(z0Var, lVar, collection));
            sa.a.a(collection3, F0(z0Var, lVar));
        }
    }

    private final void Y(Set<? extends u0> set, Collection<u0> collection, Set<u0> set2, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        for (u0 u0Var : set) {
            s9.f fVarI0 = i0(u0Var, lVar);
            if (fVarI0 != null) {
                collection.add(fVarI0);
                if (set2 != null) {
                    set2.add(u0Var);
                    return;
                }
                return;
            }
        }
    }

    private final void Z(ba.f fVar, Collection<u0> collection) {
        u9.r rVar = (u9.r) r.G0(y().invoke().b(fVar));
        if (rVar == null) {
            return;
        }
        collection.add(k0(this, rVar, null, e0.FINAL, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d f0() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarC = C();
        s9.b bVarP1 = s9.b.p1(eVarC, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), true, w().a().t().a(this.f13315o));
        kotlin.jvm.internal.m.e(bVarP1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<j1> listL0 = l0(bVarP1);
        bVarP1.V0(false);
        bVarP1.m1(listL0, w0(eVarC));
        bVarP1.U0(false);
        bVarP1.c1(eVarC.p());
        return bVarP1;
    }

    private final z0 h0(y yVar, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        Object next;
        ba.f name = yVar.getName();
        kotlin.jvm.internal.m.e(name, "overridden.name");
        Iterator<T> it = lVar.invoke(name).iterator();
        do {
            if (it.hasNext()) {
                next = it.next();
            } else {
                next = null;
                break;
            }
        } while (!B0((z0) next, yVar));
        z0 z0Var = (z0) next;
        if (z0Var == null) {
            return null;
        }
        y.a<? extends z0> aVarQ = z0Var.q();
        List<j1> listF = yVar.f();
        kotlin.jvm.internal.m.e(listF, "overridden.valueParameters");
        List<j1> list = listF;
        ArrayList arrayList = new ArrayList(r.w(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((j1) it2.next()).getType());
        }
        List<j1> listF2 = z0Var.f();
        kotlin.jvm.internal.m.e(listF2, "override.valueParameters");
        aVarQ.b(s9.h.a(arrayList, listF2, yVar));
        aVarQ.t();
        aVarQ.e();
        aVarQ.m(s9.e.H, Boolean.TRUE);
        return (z0) aVarQ.build();
    }

    private final s9.f i0(u0 u0Var, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        z0 z0VarV0;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0VarM = null;
        if (!o0(u0Var, lVar)) {
            return null;
        }
        z0 z0VarU0 = u0(u0Var, lVar);
        kotlin.jvm.internal.m.c(z0VarU0);
        if (u0Var.f0()) {
            z0VarV0 = v0(u0Var, lVar);
            kotlin.jvm.internal.m.c(z0VarV0);
        } else {
            z0VarV0 = null;
        }
        if (z0VarV0 != null) {
            z0VarV0.i();
            z0VarU0.i();
        }
        s9.d dVar = new s9.d(C(), z0VarU0, z0VarV0, u0Var);
        g0 returnType = z0VarU0.getReturnType();
        kotlin.jvm.internal.m.c(returnType);
        dVar.X0(returnType, r.l(), z(), null, r.l());
        d0 d0VarK = kotlin.reflect.jvm.internal.impl.resolve.d.k(dVar, z0VarU0.getAnnotations(), false, false, false, z0VarU0.getSource());
        d0VarK.J0(z0VarU0);
        d0VarK.M0(dVar.getType());
        kotlin.jvm.internal.m.e(d0VarK, "createGetter(\n          …escriptor.type)\n        }");
        if (z0VarV0 != null) {
            List<j1> listF = z0VarV0.f();
            kotlin.jvm.internal.m.e(listF, "setterMethod.valueParameters");
            j1 j1Var = (j1) r.i0(listF);
            if (j1Var != null) {
                e0VarM = kotlin.reflect.jvm.internal.impl.resolve.d.m(dVar, z0VarV0.getAnnotations(), j1Var.getAnnotations(), false, false, false, z0VarV0.getVisibility(), z0VarV0.getSource());
                e0VarM.J0(z0VarV0);
            } else {
                throw new AssertionError("No parameter found for " + z0VarV0);
            }
        }
        dVar.Q0(d0VarK, e0VarM);
        return dVar;
    }

    private final z0 m0(z0 z0Var, ba.f fVar) {
        y.a<? extends z0> aVarQ = z0Var.q();
        aVarQ.o(fVar);
        aVarQ.t();
        aVarQ.e();
        y yVarBuild = aVarQ.build();
        kotlin.jvm.internal.m.c(yVarBuild);
        return (z0) yVarBuild;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    private final z0 n0(z0 z0Var) {
        ba.c cVarL;
        ba.d dVarM;
        List<j1> valueParameters = z0Var.f();
        kotlin.jvm.internal.m.e(valueParameters, "valueParameters");
        j1 j1Var = (j1) r.u0(valueParameters);
        if (j1Var != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = j1Var.getType().J0().d();
            if (hVarD != null && (dVarM = ea.c.m(hVarD)) != null) {
                if (!dVarM.f()) {
                    dVarM = null;
                }
                if (dVarM != null) {
                    cVarL = dVarM.l();
                } else {
                    cVarL = null;
                }
            } else {
                cVarL = null;
            }
            if (!kotlin.jvm.internal.m.a(cVarL, kotlin.reflect.jvm.internal.impl.builtins.k.f12588q)) {
                j1Var = null;
            }
            if (j1Var != null) {
                y.a<? extends z0> aVarQ = z0Var.q();
                List<j1> valueParameters2 = z0Var.f();
                kotlin.jvm.internal.m.e(valueParameters2, "valueParameters");
                z0 z0Var2 = (z0) aVarQ.b(r.d0(valueParameters2, 1)).f(j1Var.getType().H0().get(0).getType()).build();
                kotlin.reflect.jvm.internal.impl.descriptors.impl.g0 g0Var = (kotlin.reflect.jvm.internal.impl.descriptors.impl.g0) z0Var2;
                if (g0Var == null) {
                    return z0Var2;
                }
                g0Var.d1(true);
                return z0Var2;
            }
        }
        return null;
    }

    private final boolean o0(u0 u0Var, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        if (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(u0Var)) {
            return false;
        }
        z0 z0VarU0 = u0(u0Var, lVar);
        z0 z0VarV0 = v0(u0Var, lVar);
        if (z0VarU0 == null) {
            return false;
        }
        if (!u0Var.f0()) {
            return true;
        }
        if (z0VarV0 == null || z0VarV0.i() != z0VarU0.i()) {
            return false;
        }
        return true;
    }

    private final boolean s0(z0 z0Var) {
        z0 z0VarN0 = n0(z0Var);
        if (z0VarN0 == null) {
            return false;
        }
        ba.f name = z0Var.getName();
        kotlin.jvm.internal.m.e(name, "name");
        Set<z0> setY0 = y0(name);
        if (androidx.view.k.a(setY0) && setY0.isEmpty()) {
            return false;
        }
        for (z0 z0Var2 : setY0) {
            if (z0Var2.isSuspend() && p0(z0VarN0, z0Var2)) {
                return true;
            }
        }
        return false;
    }

    private final z0 t0(u0 u0Var, String str, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        z0 z0Var;
        boolean zD;
        ba.f fVarL = ba.f.l(str);
        kotlin.jvm.internal.m.e(fVarL, "identifier(getterName)");
        Iterator<T> it = lVar.invoke(fVarL).iterator();
        do {
            z0Var = null;
            if (!it.hasNext()) {
                break;
            }
            z0 z0Var2 = (z0) it.next();
            if (z0Var2.f().size() == 0) {
                kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f14235a;
                g0 returnType = z0Var2.getReturnType();
                if (returnType == null) {
                    zD = false;
                } else {
                    zD = eVar.d(returnType, u0Var.getType());
                }
                if (zD) {
                    z0Var = z0Var2;
                }
            }
        } while (z0Var == null);
        return z0Var;
    }

    private final z0 u0(u0 u0Var, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.v0 v0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.v0 getter = u0Var.getGetter();
        String strA = null;
        if (getter != null) {
            v0Var = (kotlin.reflect.jvm.internal.impl.descriptors.v0) h0.d(getter);
        } else {
            v0Var = null;
        }
        if (v0Var != null) {
            strA = kotlin.reflect.jvm.internal.impl.load.java.i.f13215a.a(v0Var);
        }
        if (strA != null && !h0.f(C(), v0Var)) {
            return t0(u0Var, strA, lVar);
        }
        String strF = u0Var.getName().f();
        kotlin.jvm.internal.m.e(strF, "name.asString()");
        return t0(u0Var, a0.b(strF), lVar);
    }

    private final z0 v0(u0 u0Var, c9.l<? super ba.f, ? extends Collection<? extends z0>> lVar) {
        z0 z0Var;
        g0 returnType;
        String strF = u0Var.getName().f();
        kotlin.jvm.internal.m.e(strF, "name.asString()");
        ba.f fVarL = ba.f.l(a0.e(strF));
        kotlin.jvm.internal.m.e(fVarL, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = lVar.invoke(fVarL).iterator();
        do {
            z0Var = null;
            if (!it.hasNext()) {
                break;
            }
            z0 z0Var2 = (z0) it.next();
            if (z0Var2.f().size() == 1 && (returnType = z0Var2.getReturnType()) != null && kotlin.reflect.jvm.internal.impl.builtins.h.C0(returnType)) {
                kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f14235a;
                List<j1> listF = z0Var2.f();
                kotlin.jvm.internal.m.e(listF, "descriptor.valueParameters");
                if (eVar.b(((j1) r.F0(listF)).getType(), u0Var.getType())) {
                    z0Var = z0Var2;
                }
            }
        } while (z0Var == null);
        return z0Var;
    }

    private final u w0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        u visibility = eVar.getVisibility();
        kotlin.jvm.internal.m.e(visibility, "classDescriptor.visibility");
        if (kotlin.jvm.internal.m.a(visibility, s.f13421b)) {
            u PROTECTED_AND_PACKAGE = s.f13422c;
            kotlin.jvm.internal.m.e(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
            return PROTECTED_AND_PACKAGE;
        }
        return visibility;
    }

    private final Set<z0> y0(ba.f fVar) {
        Collection<g0> collectionC0 = c0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = collectionC0.iterator();
        while (it.hasNext()) {
            r.C(linkedHashSet, ((g0) it.next()).n().c(fVar, r9.d.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected x0 z() {
        return kotlin.reflect.jvm.internal.impl.resolve.e.l(C());
    }
}
