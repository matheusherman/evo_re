package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class y0<T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f13086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, T> f13087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f13088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.i f13089d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f13085f = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(y0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13084e = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final <T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.h> y0<T> a(e classDescriptor, ka.n storageManager, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefinerForOwnerModule, c9.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends T> scopeFactory) {
            kotlin.jvm.internal.m.f(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.m.f(storageManager, "storageManager");
            kotlin.jvm.internal.m.f(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            kotlin.jvm.internal.m.f(scopeFactory, "scopeFactory");
            return new y0<>(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<T> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.g $kotlinTypeRefiner;
        final /* synthetic */ y0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(y0<T> y0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            super(0);
            this.this$0 = y0Var;
            this.$kotlinTypeRefiner = gVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T invoke() {
            return (T) ((y0) this.this$0).f13087b.invoke(this.$kotlinTypeRefiner);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.a<T> {
        final /* synthetic */ y0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(y0<T> y0Var) {
            super(0);
            this.this$0 = y0Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T invoke() {
            return (T) ((y0) this.this$0).f13087b.invoke(((y0) this.this$0).f13088c);
        }
    }

    public /* synthetic */ y0(e eVar, ka.n nVar, c9.l lVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, kotlin.jvm.internal.g gVar2) {
        this(eVar, nVar, lVar, gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private y0(e eVar, ka.n nVar, c9.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends T> lVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        this.f13086a = eVar;
        this.f13087b = lVar;
        this.f13088c = gVar;
        this.f13089d = nVar.c(new c(this));
    }

    private final T d() {
        return (T) ka.m.a(this.f13089d, this, f13085f[0]);
    }

    public final T c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.d(ea.c.p(this.f13086a))) {
            return (T) d();
        }
        kotlin.reflect.jvm.internal.impl.types.g1 g1VarH = this.f13086a.h();
        kotlin.jvm.internal.m.e(g1VarH, "classDescriptor.typeConstructor");
        return !kotlinTypeRefiner.e(g1VarH) ? (T) d() : (T) kotlinTypeRefiner.c(this.f13086a, new b(this, kotlinTypeRefiner));
    }
}
