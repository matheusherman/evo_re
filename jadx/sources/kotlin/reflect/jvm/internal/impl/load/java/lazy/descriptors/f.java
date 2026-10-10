package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import kotlin.reflect.jvm.internal.impl.load.java.j0;
import kotlin.reflect.jvm.internal.impl.load.java.s;
import kotlin.reflect.jvm.internal.impl.resolve.constants.v;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.r1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import u9.x;
import u9.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f extends kotlin.reflect.jvm.internal.impl.descriptors.impl.g implements s9.c {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f13294y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Set<String> f13295z = v0.h("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final u9.g f13297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f13298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final r8.i f13300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.f f13301n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final e0 f13302o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final n1 f13303p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f13304q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final b f13305r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final g f13306s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final y0<g> f13307t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.f f13308u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final l f13309v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f13310w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ka.i<List<f1>> f13311x;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b extends kotlin.reflect.jvm.internal.impl.types.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ka.i<List<f1>> f13312d;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends o implements c9.a<List<? extends f1>> {
            final /* synthetic */ f this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.this$0 = fVar;
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
            super(f.this.f13299l.e());
            this.f13312d = f.this.f13299l.e().c(new a(f.this));
        }

        private final ba.c y() {
            String strB;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = f.this.getAnnotations();
            ba.c PURELY_IMPLEMENTS_ANNOTATION = b0.f13125q;
            kotlin.jvm.internal.m.e(PURELY_IMPLEMENTS_ANNOTATION, "PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVarJ = annotations.j(PURELY_IMPLEMENTS_ANNOTATION);
            if (cVarJ == null) {
                return null;
            }
            Object objG0 = r.G0(cVarJ.a().values());
            v vVar = objG0 instanceof v ? (v) objG0 : null;
            if (vVar == null || (strB = vVar.b()) == null || !ba.e.e(strB)) {
                return null;
            }
            return new ba.c(strB);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public List<f1> getParameters() {
            return this.f13312d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected Collection<g0> m() {
            Collection<u9.j> collectionB = f.this.L0().b();
            ArrayList arrayList = new ArrayList(collectionB.size());
            ArrayList<x> arrayList2 = new ArrayList(0);
            g0 g0VarX = x();
            Iterator<u9.j> it = collectionB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                u9.j next = it.next();
                g0 g0VarH = f.this.f13299l.a().r().h(f.this.f13299l.g().o(next, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.SUPERTYPE, false, false, null, 7, null)), f.this.f13299l);
                if (g0VarH.J0().d() instanceof k0.b) {
                    arrayList2.add(next);
                }
                if (!kotlin.jvm.internal.m.a(g0VarH.J0(), g0VarX != null ? g0VarX.J0() : null) && !kotlin.reflect.jvm.internal.impl.builtins.h.b0(g0VarH)) {
                    arrayList.add(g0VarH);
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar = f.this.f13298k;
            sa.a.a(arrayList, eVar != null ? kotlin.reflect.jvm.internal.impl.builtins.jvm.l.a(eVar, f.this).c().p(eVar.p(), w1.INVARIANT) : null);
            sa.a.a(arrayList, g0VarX);
            if (!arrayList2.isEmpty()) {
                q qVarC = f.this.f13299l.a().c();
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarD = d();
                ArrayList arrayList3 = new ArrayList(r.w(arrayList2, 10));
                for (x xVar : arrayList2) {
                    kotlin.jvm.internal.m.d(xVar, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList3.add(((u9.j) xVar).n());
                }
                qVarC.b(eVarD, arrayList3);
            }
            return !arrayList.isEmpty() ? r.O0(arrayList) : r.e(f.this.f13299l.d().l().i());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected d1 q() {
            return f.this.f13299l.a().v();
        }

        public String toString() {
            String strF = f.this.getName().f();
            kotlin.jvm.internal.m.e(strF, "name.asString()");
            return strF;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.m, kotlin.reflect.jvm.internal.impl.types.g1
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.e d() {
            return f.this;
        }

        private final g0 x() {
            ba.c cVarB;
            ArrayList arrayList;
            ba.c cVarY = y();
            if (cVarY == null || cVarY.d() || !cVarY.i(kotlin.reflect.jvm.internal.impl.builtins.k.f12592u)) {
                cVarY = null;
            }
            if (cVarY == null) {
                cVarB = kotlin.reflect.jvm.internal.impl.load.java.m.f13410a.b(ea.c.l(f.this));
                if (cVarB == null) {
                    return null;
                }
            } else {
                cVarB = cVarY;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarV = ea.c.v(f.this.f13299l.d(), cVarB, r9.d.FROM_JAVA_LOADER);
            if (eVarV == null) {
                return null;
            }
            int size = eVarV.h().getParameters().size();
            List<f1> parameters = f.this.h().getParameters();
            kotlin.jvm.internal.m.e(parameters, "getTypeConstructor().parameters");
            int size2 = parameters.size();
            if (size2 == size) {
                List<f1> list = parameters;
                arrayList = new ArrayList(r.w(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new m1(w1.INVARIANT, ((f1) it.next()).p()));
                }
            } else {
                if (size2 != 1 || size <= 1 || cVarY != null) {
                    return null;
                }
                m1 m1Var = new m1(w1.INVARIANT, ((f1) r.F0(parameters)).p());
                h9.e eVar = new h9.e(1, size);
                ArrayList arrayList2 = new ArrayList(r.w(eVar, 10));
                Iterator<Integer> it2 = eVar.iterator();
                while (it2.hasNext()) {
                    ((kotlin.collections.k0) it2).nextInt();
                    arrayList2.add(m1Var);
                }
                arrayList = arrayList2;
            }
            return h0.g(c1.f14231b.h(), eVarV, arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.a<List<? extends f1>> {
        c() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends f1> invoke() {
            List<y> typeParameters = f.this.L0().getTypeParameters();
            f fVar = f.this;
            ArrayList arrayList = new ArrayList(r.w(typeParameters, 10));
            for (y yVar : typeParameters) {
                f1 f1VarA = fVar.f13299l.f().a(yVar);
                if (f1VarA == null) {
                    throw new AssertionError("Parameter " + yVar + " surely belongs to class " + fVar.L0() + ", so it must be resolved");
                }
                arrayList.add(f1VarA);
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a(ea.c.l((kotlin.reflect.jvm.internal.impl.descriptors.e) t10).b(), ea.c.l((kotlin.reflect.jvm.internal.impl.descriptors.e) t11).b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends o implements c9.a<List<? extends u9.a>> {
        e() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends u9.a> invoke() {
            ba.b bVarK = ea.c.k(f.this);
            if (bVarK != null) {
                return f.this.N0().a().f().a(bVarK);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0229f extends o implements c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, g> {
        C0229f() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g invoke(kotlin.reflect.jvm.internal.impl.types.checker.g it) {
            kotlin.jvm.internal.m.f(it, "it");
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar = f.this.f13299l;
            f fVar = f.this;
            return new g(gVar, fVar, fVar.L0(), f.this.f13298k != null, f.this.f13306s);
        }
    }

    public /* synthetic */ f(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, u9.g gVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, int i10, kotlin.jvm.internal.g gVar3) {
        this(gVar, mVar, gVar2, (i10 & 8) != 0 ? null : eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean E0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean F() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d M() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e P() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean t() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public h1<o0> v0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean x() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(kotlin.reflect.jvm.internal.impl.load.java.lazy.g outerContext, kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration, u9.g jClass, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar;
        e0 e0VarA;
        super(outerContext.e(), containingDeclaration, jClass.getName(), outerContext.a().t().a(jClass), false);
        kotlin.jvm.internal.m.f(outerContext, "outerContext");
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(jClass, "jClass");
        this.f13296i = outerContext;
        this.f13297j = jClass;
        this.f13298k = eVar;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVarD = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.d(outerContext, this, jClass, 0, 4, null);
        this.f13299l = gVarD;
        gVarD.a().h().a(jClass, this);
        jClass.G();
        this.f13300m = r8.j.a(new e());
        if (jClass.o()) {
            fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS;
        } else if (jClass.F()) {
            fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE;
        } else {
            fVar = jClass.y() ? kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_CLASS : kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS;
        }
        this.f13301n = fVar;
        if (jClass.o() || jClass.y()) {
            e0VarA = e0.FINAL;
        } else {
            e0VarA = e0.f12743a.a(jClass.B(), jClass.B() || jClass.isAbstract() || jClass.F(), !jClass.isFinal());
        }
        this.f13302o = e0VarA;
        this.f13303p = jClass.getVisibility();
        this.f13304q = (jClass.h() == null || jClass.O()) ? false : true;
        this.f13305r = new b();
        g gVar = new g(gVarD, this, jClass, eVar != null, null, 16, null);
        this.f13306s = gVar;
        this.f13307t = y0.f13084e.a(this, gVarD.e(), gVarD.a().k().c(), new C0229f());
        this.f13308u = new kotlin.reflect.jvm.internal.impl.resolve.scopes.f(gVar);
        this.f13309v = new l(gVarD, jClass, this);
        this.f13310w = kotlin.reflect.jvm.internal.impl.load.java.lazy.e.a(gVarD, jClass);
        this.f13311x = gVarD.e().c(new c());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> E() {
        if (this.f13302o != e0.SEALED) {
            return r.l();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVarB = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1.COMMON, false, false, null, 7, null);
        Collection<u9.j> collectionL = this.f13297j.L();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionL.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = this.f13299l.g().o((u9.j) it.next(), aVarB).J0().d();
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD : null;
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return r.J0(arrayList, new d());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean J() {
        return this.f13304q;
    }

    public final f J0(kotlin.reflect.jvm.internal.impl.load.java.components.g javaResolverCache, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(javaResolverCache, "javaResolverCache");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar = this.f13299l;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVarI = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.i(gVar, gVar.a().x(javaResolverCache));
        kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration = b();
        kotlin.jvm.internal.m.e(containingDeclaration, "containingDeclaration");
        return new f(gVarI, containingDeclaration, this.f13297j, eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        return this.f13306s.x0().invoke();
    }

    public final u9.g L0() {
        return this.f13297j;
    }

    public final List<u9.a> M0() {
        return (List) this.f13300m.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h N() {
        return this.f13309v;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.g N0() {
        return this.f13296i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public g G(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return (g) this.f13307t.c(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f g() {
        return this.f13301n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return this.f13310w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q
    public u getVisibility() {
        if (!kotlin.jvm.internal.m.a(this.f13303p, t.f13064a) || this.f13297j.h() != null) {
            return j0.d(this.f13303p);
        }
        u uVar = s.f13420a;
        kotlin.jvm.internal.m.e(uVar, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.jvm.internal.impl.types.g1 h() {
        return this.f13305r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public e0 i() {
        return this.f13302o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<f1> r() {
        return this.f13311x.invoke();
    }

    public String toString() {
        return "Lazy Java class " + ea.c.m(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h u0() {
        return this.f13308u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public g z0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarZ0 = super.z0();
        kotlin.jvm.internal.m.d(hVarZ0, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (g) hVarZ0;
    }
}
