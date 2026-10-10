package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class g extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ka.i<b> f14304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14305c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class a implements g1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.types.checker.g f14306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final r8.i f14307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f14308c;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0270a extends kotlin.jvm.internal.o implements c9.a<List<? extends g0>> {
            final /* synthetic */ g this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0270a(g gVar) {
                super(0);
                this.this$1 = gVar;
            }

            @Override // c9.a
            public final List<? extends g0> invoke() {
                return kotlin.reflect.jvm.internal.impl.types.checker.h.b(a.this.f14306a, this.this$1.b());
            }
        }

        public a(g gVar, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f14308c = gVar;
            this.f14306a = kotlinTypeRefiner;
            this.f14307b = r8.j.b(r8.m.PUBLICATION, new C0270a(gVar));
        }

        private final List<g0> h() {
            return (List) this.f14307b.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public g1 c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.f14308c.c(kotlinTypeRefiner);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public kotlin.reflect.jvm.internal.impl.descriptors.h d() {
            return this.f14308c.d();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public boolean e() {
            return this.f14308c.e();
        }

        public boolean equals(Object obj) {
            return this.f14308c.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public List<kotlin.reflect.jvm.internal.impl.descriptors.f1> getParameters() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters = this.f14308c.getParameters();
            kotlin.jvm.internal.m.e(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.f14308c.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public kotlin.reflect.jvm.internal.impl.builtins.h l() {
            kotlin.reflect.jvm.internal.impl.builtins.h hVarL = this.f14308c.l();
            kotlin.jvm.internal.m.e(hVarL, "this@AbstractTypeConstructor.builtIns");
            return hVarL;
        }

        public String toString() {
            return this.f14308c.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public List<g0> b() {
            return h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection<g0> f14309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<? extends g0> f14310b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends g0> allSupertypes) {
            kotlin.jvm.internal.m.f(allSupertypes, "allSupertypes");
            this.f14309a = allSupertypes;
            this.f14310b = kotlin.collections.r.e(la.k.f15326a.l());
        }

        public final Collection<g0> a() {
            return this.f14309a;
        }

        public final List<g0> b() {
            return this.f14310b;
        }

        public final void c(List<? extends g0> list) {
            kotlin.jvm.internal.m.f(list, "<set-?>");
            this.f14310b = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.a<b> {
        c() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(g.this.m());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.l<Boolean, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14311a = new d();

        d() {
            super(1);
        }

        public final b a(boolean z10) {
            return new b(kotlin.collections.r.e(la.k.f15326a.l()));
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return a(bool.booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends kotlin.jvm.internal.o implements c9.l<b, r8.z> {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends kotlin.jvm.internal.o implements c9.l<g1, Iterable<? extends g0>> {
            final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(1);
                this.this$0 = gVar;
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Iterable<g0> invoke(g1 it) {
                kotlin.jvm.internal.m.f(it, "it");
                return this.this$0.k(it, true);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class b extends kotlin.jvm.internal.o implements c9.l<g0, r8.z> {
            final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(g gVar) {
                super(1);
                this.this$0 = gVar;
            }

            public final void a(g0 it) {
                kotlin.jvm.internal.m.f(it, "it");
                this.this$0.t(it);
            }

            @Override // c9.l
            public /* bridge */ /* synthetic */ r8.z invoke(g0 g0Var) {
                a(g0Var);
                return r8.z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class c extends kotlin.jvm.internal.o implements c9.l<g1, Iterable<? extends g0>> {
            final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(g gVar) {
                super(1);
                this.this$0 = gVar;
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Iterable<g0> invoke(g1 it) {
                kotlin.jvm.internal.m.f(it, "it");
                return this.this$0.k(it, false);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class d extends kotlin.jvm.internal.o implements c9.l<g0, r8.z> {
            final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(g gVar) {
                super(1);
                this.this$0 = gVar;
            }

            public final void a(g0 it) {
                kotlin.jvm.internal.m.f(it, "it");
                this.this$0.u(it);
            }

            @Override // c9.l
            public /* bridge */ /* synthetic */ r8.z invoke(g0 g0Var) {
                a(g0Var);
                return r8.z.f17874a;
            }
        }

        e() {
            super(1);
        }

        public final void a(b supertypes) {
            kotlin.jvm.internal.m.f(supertypes, "supertypes");
            List listA = g.this.q().a(g.this, supertypes.a(), new c(g.this), new d(g.this));
            if (listA.isEmpty()) {
                g0 g0VarN = g.this.n();
                List listE = g0VarN != null ? kotlin.collections.r.e(g0VarN) : null;
                if (listE == null) {
                    listE = kotlin.collections.r.l();
                }
                listA = listE;
            }
            if (g.this.p()) {
                kotlin.reflect.jvm.internal.impl.descriptors.d1 d1VarQ = g.this.q();
                g gVar = g.this;
                d1VarQ.a(gVar, listA, new a(gVar), new b(g.this));
            }
            g gVar2 = g.this;
            List<g0> listO0 = listA instanceof List ? (List) listA : null;
            if (listO0 == null) {
                listO0 = kotlin.collections.r.O0(listA);
            }
            supertypes.c(gVar2.s(listO0));
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(b bVar) {
            a(bVar);
            return r8.z.f17874a;
        }
    }

    protected abstract Collection<g0> m();

    protected abstract g0 n();

    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.d1 q();

    public g(ka.n storageManager) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        this.f14304b = storageManager.h(new c(), d.f14311a, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<g0> k(g1 g1Var, boolean z10) {
        List listB0;
        g gVar = g1Var instanceof g ? (g) g1Var : null;
        if (gVar != null && (listB0 = kotlin.collections.r.B0(gVar.f14304b.invoke().a(), gVar.o(z10))) != null) {
            return listB0;
        }
        Collection<g0> supertypes = g1Var.b();
        kotlin.jvm.internal.m.e(supertypes, "supertypes");
        return supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public g1 c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    protected boolean p() {
        return this.f14305c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public List<g0> b() {
        return this.f14304b.invoke().b();
    }

    protected List<g0> s(List<g0> supertypes) {
        kotlin.jvm.internal.m.f(supertypes, "supertypes");
        return supertypes;
    }

    protected void t(g0 type) {
        kotlin.jvm.internal.m.f(type, "type");
    }

    protected void u(g0 type) {
        kotlin.jvm.internal.m.f(type, "type");
    }

    protected Collection<g0> o(boolean z10) {
        return kotlin.collections.r.l();
    }
}
