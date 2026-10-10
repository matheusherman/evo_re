package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final na.p f14289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f14290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f14291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayDeque<na.k> f14294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set<na.k> f14295j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.f1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0268a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f14296a;

            @Override // kotlin.reflect.jvm.internal.impl.types.f1.a
            public void a(c9.a<Boolean> block) {
                kotlin.jvm.internal.m.f(block, "block");
                if (this.f14296a) {
                    return;
                }
                this.f14296a = block.invoke().booleanValue();
            }

            public final boolean b() {
                return this.f14296a;
            }
        }

        void a(c9.a<Boolean> aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum b {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class c {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static abstract class a extends c {
            public a() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f14301a = new b();

            private b() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.f1.c
            public na.k a(f1 state, na.i type) {
                kotlin.jvm.internal.m.f(state, "state");
                kotlin.jvm.internal.m.f(type, "type");
                return state.j().M(type);
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.f1$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0269c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0269c f14302a = new C0269c();

            private C0269c() {
                super(null);
            }

            public Void b(f1 state, na.i type) {
                kotlin.jvm.internal.m.f(state, "state");
                kotlin.jvm.internal.m.f(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.f1.c
            public /* bridge */ /* synthetic */ na.k a(f1 f1Var, na.i iVar) {
                return (na.k) b(f1Var, iVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f14303a = new d();

            private d() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.f1.c
            public na.k a(f1 state, na.i type) {
                kotlin.jvm.internal.m.f(state, "state");
                kotlin.jvm.internal.m.f(type, "type");
                return state.j().d0(type);
            }
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }

        public abstract na.k a(f1 f1Var, na.i iVar);

        private c() {
        }
    }

    public final void k() {
        this.f14293h = true;
        if (this.f14294i == null) {
            this.f14294i = new ArrayDeque<>(4);
        }
        if (this.f14295j == null) {
            this.f14295j = sa.g.f18524c.a();
        }
    }

    public f1(boolean z10, boolean z11, boolean z12, na.p typeSystemContext, h kotlinTypePreparator, i kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.m.f(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f14286a = z10;
        this.f14287b = z11;
        this.f14288c = z12;
        this.f14289d = typeSystemContext;
        this.f14290e = kotlinTypePreparator;
        this.f14291f = kotlinTypeRefiner;
    }

    public static /* synthetic */ Boolean d(f1 f1Var, na.i iVar, na.i iVar2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return f1Var.c(iVar, iVar2, z10);
    }

    public Boolean c(na.i subType, na.i superType, boolean z10) {
        kotlin.jvm.internal.m.f(subType, "subType");
        kotlin.jvm.internal.m.f(superType, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<na.k> arrayDeque = this.f14294i;
        kotlin.jvm.internal.m.c(arrayDeque);
        arrayDeque.clear();
        Set<na.k> set = this.f14295j;
        kotlin.jvm.internal.m.c(set);
        set.clear();
        this.f14293h = false;
    }

    public boolean f(na.i subType, na.i superType) {
        kotlin.jvm.internal.m.f(subType, "subType");
        kotlin.jvm.internal.m.f(superType, "superType");
        return true;
    }

    public b g(na.k subType, na.d superType) {
        kotlin.jvm.internal.m.f(subType, "subType");
        kotlin.jvm.internal.m.f(superType, "superType");
        return b.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<na.k> h() {
        return this.f14294i;
    }

    public final Set<na.k> i() {
        return this.f14295j;
    }

    public final na.p j() {
        return this.f14289d;
    }

    public final boolean l(na.i type) {
        kotlin.jvm.internal.m.f(type, "type");
        return this.f14288c && this.f14289d.f0(type);
    }

    public final boolean m() {
        return this.f14286a;
    }

    public final boolean n() {
        return this.f14287b;
    }

    public final na.i o(na.i type) {
        kotlin.jvm.internal.m.f(type, "type");
        return this.f14290e.a(type);
    }

    public final na.i p(na.i type) {
        kotlin.jvm.internal.m.f(type, "type");
        return this.f14291f.a(type);
    }

    public boolean q(c9.l<? super a, r8.z> block) {
        kotlin.jvm.internal.m.f(block, "block");
        a.C0268a c0268a = new a.C0268a();
        block.invoke(c0268a);
        return c0268a.b();
    }
}
