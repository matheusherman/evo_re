package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.IndexedValue;
import kotlin.collections.n0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.load.java.j0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.r1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import r8.p;
import r8.v;
import u9.b0;
import u9.r;
import u9.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class j extends kotlin.reflect.jvm.internal.impl.resolve.scopes.i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f13342m = {c0.g(new w(c0.b(j.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), c0.g(new w(c0.b(j.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), c0.g(new w(c0.b(j.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f13344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> f13345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.i<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b> f13346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ka.g<ba.f, Collection<z0>> f13347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ka.h<ba.f, u0> f13348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ka.g<ba.f, Collection<z0>> f13349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ka.i f13350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ka.i f13351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ka.i f13352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ka.g<ba.f, List<u0>> f13353l;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g0 f13354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g0 f13355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<j1> f13356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<f1> f13357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f13358e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<String> f13359f;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.m.a(this.f13354a, aVar.f13354a) && kotlin.jvm.internal.m.a(this.f13355b, aVar.f13355b) && kotlin.jvm.internal.m.a(this.f13356c, aVar.f13356c) && kotlin.jvm.internal.m.a(this.f13357d, aVar.f13357d) && this.f13358e == aVar.f13358e && kotlin.jvm.internal.m.a(this.f13359f, aVar.f13359f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(g0 returnType, g0 g0Var, List<? extends j1> valueParameters, List<? extends f1> typeParameters, boolean z10, List<String> errors) {
            kotlin.jvm.internal.m.f(returnType, "returnType");
            kotlin.jvm.internal.m.f(valueParameters, "valueParameters");
            kotlin.jvm.internal.m.f(typeParameters, "typeParameters");
            kotlin.jvm.internal.m.f(errors, "errors");
            this.f13354a = returnType;
            this.f13355b = g0Var;
            this.f13356c = valueParameters;
            this.f13357d = typeParameters;
            this.f13358e = z10;
            this.f13359f = errors;
        }

        public final List<String> a() {
            return this.f13359f;
        }

        public final boolean b() {
            return this.f13358e;
        }

        public final g0 c() {
            return this.f13355b;
        }

        public final g0 d() {
            return this.f13354a;
        }

        public final List<f1> e() {
            return this.f13357d;
        }

        public final List<j1> f() {
            return this.f13356c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        public int hashCode() {
            int iHashCode = this.f13354a.hashCode() * 31;
            g0 g0Var = this.f13355b;
            int iHashCode2 = (((((iHashCode + (g0Var == null ? 0 : g0Var.hashCode())) * 31) + this.f13356c.hashCode()) * 31) + this.f13357d.hashCode()) * 31;
            boolean z10 = this.f13358e;
            ?? r10 = z10;
            if (z10) {
                r10 = 1;
            }
            return ((iHashCode2 + r10) * 31) + this.f13359f.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.f13354a + ", receiverType=" + this.f13355b + ", valueParameters=" + this.f13356c + ", typeParameters=" + this.f13357d + ", hasStableParameterNames=" + this.f13358e + ", errors=" + this.f13359f + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<j1> f13360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f13361b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends j1> descriptors, boolean z10) {
            kotlin.jvm.internal.m.f(descriptors, "descriptors");
            this.f13360a = descriptors;
            this.f13361b = z10;
        }

        public final List<j1> a() {
            return this.f13360a;
        }

        public final boolean b() {
            return this.f13361b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.m>> {
        c() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke() {
            return j.this.m(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13978o, kotlin.reflect.jvm.internal.impl.resolve.scopes.h.f14001a.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends o implements c9.a<Set<? extends ba.f>> {
        d() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<ba.f> invoke() {
            return j.this.l(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13983t, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends o implements c9.l<ba.f, u0> {
        e() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u0 invoke(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            if (j.this.B() != null) {
                return (u0) j.this.B().f13348g.invoke(name);
            }
            u9.n nVarD = j.this.y().invoke().d(name);
            if (nVarD == null || nVarD.D()) {
                return null;
            }
            return j.this.J(nVarD);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends o implements c9.l<ba.f, Collection<? extends z0>> {
        f() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<z0> invoke(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            if (j.this.B() != null) {
                return (Collection) j.this.B().f13347f.invoke(name);
            }
            ArrayList arrayList = new ArrayList();
            for (r rVar : j.this.y().invoke().b(name)) {
                s9.e eVarI = j.this.I(rVar);
                if (j.this.G(eVarI)) {
                    j.this.w().a().h().b(rVar, eVarI);
                    arrayList.add(eVarI);
                }
            }
            j.this.o(arrayList, name);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class g extends o implements c9.a<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b> {
        g() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b invoke() {
            return j.this.p();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class h extends o implements c9.a<Set<? extends ba.f>> {
        h() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<ba.f> invoke() {
            return j.this.n(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13985v, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class i extends o implements c9.l<ba.f, Collection<? extends z0>> {
        i() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<z0> invoke(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) j.this.f13347f.invoke(name));
            j.this.L(linkedHashSet);
            j.this.r(linkedHashSet, name);
            return kotlin.collections.r.O0(j.this.w().a().r().g(j.this.w(), linkedHashSet));
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0232j extends o implements c9.l<ba.f, List<? extends u0>> {
        C0232j() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<u0> invoke(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            ArrayList arrayList = new ArrayList();
            sa.a.a(arrayList, j.this.f13348g.invoke(name));
            j.this.s(name, arrayList);
            return kotlin.reflect.jvm.internal.impl.resolve.e.t(j.this.C()) ? kotlin.collections.r.O0(arrayList) : kotlin.collections.r.O0(j.this.w().a().r().g(j.this.w(), arrayList));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class k extends o implements c9.a<Set<? extends ba.f>> {
        k() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<ba.f> invoke() {
            return j.this.t(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13986w, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class l extends o implements c9.a<ka.j<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> {
        final /* synthetic */ u9.n $field;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 $propertyDescriptor;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends o implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {
            final /* synthetic */ u9.n $field;
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 $propertyDescriptor;
            final /* synthetic */ j this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(j jVar, u9.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 c0Var) {
                super(0);
                this.this$0 = jVar;
                this.$field = nVar;
                this.$propertyDescriptor = c0Var;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> invoke() {
                return this.this$0.w().a().g().a(this.$field, this.$propertyDescriptor);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(u9.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 c0Var) {
            super(0);
            this.$field = nVar;
            this.$propertyDescriptor = c0Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> invoke() {
            return j.this.w().e().g(new a(j.this, this.$field, this.$propertyDescriptor));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class m extends o implements c9.l<z0, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f13362a = new m();

        m() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(z0 selectMostSpecificInEachOverridableGroup) {
            kotlin.jvm.internal.m.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
            return selectMostSpecificInEachOverridableGroup;
        }
    }

    public /* synthetic */ j(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, j jVar, int i10, kotlin.jvm.internal.g gVar2) {
        this(gVar, (i10 & 2) != 0 ? null : jVar);
    }

    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.m C();

    protected abstract a H(r rVar, List<? extends f1> list, g0 g0Var, List<? extends j1> list2);

    protected abstract Set<ba.f> l(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, c9.l<? super ba.f, Boolean> lVar);

    protected abstract Set<ba.f> n(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, c9.l<? super ba.f, Boolean> lVar);

    protected abstract kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b p();

    protected abstract void r(Collection<z0> collection, ba.f fVar);

    protected abstract void s(ba.f fVar, Collection<u0> collection);

    protected abstract Set<ba.f> t(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, c9.l<? super ba.f, Boolean> lVar);

    protected abstract x0 z();

    public j(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, j jVar) {
        kotlin.jvm.internal.m.f(c10, "c");
        this.f13343b = c10;
        this.f13344c = jVar;
        this.f13345d = c10.e().e(new c(), kotlin.collections.r.l());
        this.f13346e = c10.e().c(new g());
        this.f13347f = c10.e().f(new f());
        this.f13348g = c10.e().i(new e());
        this.f13349h = c10.e().f(new i());
        this.f13350i = c10.e().c(new h());
        this.f13351j = c10.e().c(new k());
        this.f13352k = c10.e().c(new d());
        this.f13353l = c10.e().f(new C0232j());
    }

    private final Set<ba.f> A() {
        return (Set) ka.m.a(this.f13350i, this, f13342m[0]);
    }

    private final Set<ba.f> D() {
        return (Set) ka.m.a(this.f13351j, this, f13342m[1]);
    }

    private final g0 E(u9.n nVar) {
        g0 g0VarO = this.f13343b.g().o(nVar.getType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, false, false, null, 7, null));
        if ((!kotlin.reflect.jvm.internal.impl.builtins.h.s0(g0VarO) && !kotlin.reflect.jvm.internal.impl.builtins.h.v0(g0VarO)) || !F(nVar) || !nVar.M()) {
            return g0VarO;
        }
        g0 g0VarN = s1.n(g0VarO);
        kotlin.jvm.internal.m.e(g0VarN, "makeNotNullable(propertyType)");
        return g0VarN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(Set<z0> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strC = x.c((z0) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strC, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                List list2 = list;
                Collection<? extends z0> collectionA = kotlin.reflect.jvm.internal.impl.resolve.m.a(list2, m.f13362a);
                set.removeAll(list2);
                set.addAll(collectionA);
            }
        }
    }

    private final Set<ba.f> x() {
        return (Set) ka.m.a(this.f13352k, this, f13342m[2]);
    }

    protected final j B() {
        return this.f13344c;
    }

    protected boolean G(s9.e eVar) {
        kotlin.jvm.internal.m.f(eVar, "<this>");
        return true;
    }

    protected final s9.e I(r method) {
        kotlin.jvm.internal.m.f(method, "method");
        s9.e eVarL1 = s9.e.l1(C(), kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(this.f13343b, method), method.getName(), this.f13343b.a().t().a(method), this.f13346e.invoke().c(method.getName()) != null && method.f().isEmpty());
        kotlin.jvm.internal.m.e(eVarL1, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVarF = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.f(this.f13343b, eVarL1, method, 0, 4, null);
        List<y> typeParameters = method.getTypeParameters();
        List<? extends f1> arrayList = new ArrayList<>(kotlin.collections.r.w(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            f1 f1VarA = gVarF.f().a((y) it.next());
            kotlin.jvm.internal.m.c(f1VarA);
            arrayList.add(f1VarA);
        }
        b bVarK = K(gVarF, eVarL1, method.f());
        a aVarH = H(method, arrayList, q(method, gVarF), bVarK.a());
        g0 g0VarC = aVarH.c();
        eVarL1.k1(g0VarC != null ? kotlin.reflect.jvm.internal.impl.resolve.d.i(eVarL1, g0VarC, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b()) : null, z(), kotlin.collections.r.l(), aVarH.e(), aVarH.f(), aVarH.d(), e0.f12743a.a(false, method.isAbstract(), !method.isFinal()), j0.d(method.getVisibility()), aVarH.c() != null ? n0.f(v.a(s9.e.G, kotlin.collections.r.g0(bVarK.a()))) : n0.i());
        eVarL1.o1(aVarH.b(), bVarK.b());
        if (!aVarH.a().isEmpty()) {
            gVarF.a().s().a(eVarL1, aVarH.a());
        }
        return eVarL1;
    }

    protected final b K(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, List<? extends b0> jValueParameters) {
        p pVarA;
        ba.f name;
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.reflect.jvm.internal.impl.descriptors.y function = yVar;
        kotlin.jvm.internal.m.f(function, "function");
        kotlin.jvm.internal.m.f(jValueParameters, "jValueParameters");
        Iterable<IndexedValue> iterableU0 = kotlin.collections.r.U0(jValueParameters);
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(iterableU0, 10));
        boolean z10 = false;
        for (IndexedValue indexedValue : iterableU0) {
            int index = indexedValue.getIndex();
            b0 b0Var = (b0) indexedValue.b();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarA = kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(c10, b0Var);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVarB = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, false, false, null, 7, null);
            if (b0Var.a()) {
                u9.x type = b0Var.getType();
                u9.f fVar = type instanceof u9.f ? (u9.f) type : null;
                if (fVar == null) {
                    throw new AssertionError("Vararg parameter should be an array: " + b0Var);
                }
                g0 g0VarK = c10.g().k(fVar, aVarB, true);
                pVarA = v.a(g0VarK, c10.d().l().k(g0VarK));
            } else {
                pVarA = v.a(c10.g().o(b0Var.getType(), aVarB), null);
            }
            g0 g0Var = (g0) pVarA.a();
            g0 g0Var2 = (g0) pVarA.b();
            if (kotlin.jvm.internal.m.a(function.getName().f(), "equals") && jValueParameters.size() == 1 && kotlin.jvm.internal.m.a(c10.d().l().I(), g0Var)) {
                name = ba.f.l(TransactionPartnerType.OTHER);
            } else {
                name = b0Var.getName();
                if (name == null) {
                    z10 = true;
                }
                if (name == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('p');
                    sb2.append(index);
                    name = ba.f.l(sb2.toString());
                    kotlin.jvm.internal.m.e(name, "identifier(\"p$index\")");
                }
            }
            boolean z11 = z10;
            kotlin.jvm.internal.m.e(name, "if (function.name.asStri…(\"p$index\")\n            }");
            arrayList.add(new l0(function, null, index, gVarA, name, g0Var, false, false, false, g0Var2, c10.a().t().a(b0Var)));
            function = yVar;
            z10 = z11;
        }
        return new b(kotlin.collections.r.O0(arrayList), z10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return !d().contains(name) ? kotlin.collections.r.l() : this.f13353l.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return !b().contains(name) ? kotlin.collections.r.l() : this.f13349h.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return this.f13345d.invoke();
    }

    protected final List<kotlin.reflect.jvm.internal.impl.descriptors.m> m(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        r9.d dVar = r9.d.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.c())) {
            for (ba.f fVar : l(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar).booleanValue()) {
                    sa.a.a(linkedHashSet, e(fVar, dVar));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.d()) && !kindFilter.l().contains(kotlin.reflect.jvm.internal.impl.resolve.scopes.c.a.f13963a)) {
            for (ba.f fVar2 : n(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar2).booleanValue()) {
                    linkedHashSet.addAll(c(fVar2, dVar));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.i()) && !kindFilter.l().contains(kotlin.reflect.jvm.internal.impl.resolve.scopes.c.a.f13963a)) {
            for (ba.f fVar3 : t(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar3).booleanValue()) {
                    linkedHashSet.addAll(a(fVar3, dVar));
                }
            }
        }
        return kotlin.collections.r.O0(linkedHashSet);
    }

    protected void o(Collection<z0> result, ba.f name) {
        kotlin.jvm.internal.m.f(result, "result");
        kotlin.jvm.internal.m.f(name, "name");
    }

    protected final g0 q(r method, kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10) {
        kotlin.jvm.internal.m.f(method, "method");
        kotlin.jvm.internal.m.f(c10, "c");
        return c10.g().o(method.getReturnType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, method.N().o(), false, null, 6, null));
    }

    public String toString() {
        return "Lazy scope for " + C();
    }

    protected final ka.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> v() {
        return this.f13345d;
    }

    protected final kotlin.reflect.jvm.internal.impl.load.java.lazy.g w() {
        return this.f13343b;
    }

    protected final ka.i<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b> y() {
        return this.f13346e;
    }

    private final boolean F(u9.n nVar) {
        if (nVar.isFinal() && nVar.O()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final u0 J(u9.n nVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 c0VarU = u(nVar);
        c0VarU.R0(null, null, null, null);
        c0VarU.X0(E(nVar), kotlin.collections.r.l(), z(), null, kotlin.collections.r.l());
        if (kotlin.reflect.jvm.internal.impl.resolve.e.K(c0VarU, c0VarU.getType())) {
            c0VarU.H0(new l(nVar, c0VarU));
        }
        this.f13343b.a().h().d(nVar, c0VarU);
        return c0VarU;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.c0 u(u9.n nVar) {
        s9.f fVarB1 = s9.f.b1(C(), kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(this.f13343b, nVar), e0.FINAL, j0.d(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), this.f13343b.a().t().a(nVar), F(nVar));
        kotlin.jvm.internal.m.e(fVarB1, "create(\n            owne…d.isFinalStatic\n        )");
        return fVarB1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        return A();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        return D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        return x();
    }
}
