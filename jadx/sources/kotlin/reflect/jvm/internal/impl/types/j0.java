package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j0 extends x1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ka.n f14324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c9.a<g0> f14325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.i<g0> f14326d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.a<g0> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.g $kotlinTypeRefiner;
        final /* synthetic */ j0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.types.checker.g gVar, j0 j0Var) {
            super(0);
            this.$kotlinTypeRefiner = gVar;
            this.this$0 = j0Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke() {
            return this.$kotlinTypeRefiner.a((na.i) this.this$0.f14325c.invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j0(ka.n storageManager, c9.a<? extends g0> computation) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(computation, "computation");
        this.f14324b = storageManager;
        this.f14325c = computation;
        this.f14326d = storageManager.c(computation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x1
    protected g0 N0() {
        return this.f14326d.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.x1
    public boolean O0() {
        return this.f14326d.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public j0 T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new j0(this.f14324b, new a(kotlinTypeRefiner, this));
    }
}
