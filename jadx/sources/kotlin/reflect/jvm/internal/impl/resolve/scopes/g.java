package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g extends kotlin.reflect.jvm.internal.impl.resolve.scopes.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ka.i<h> f14000b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<h> {
        final /* synthetic */ c9.a<h> $getScope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(c9.a<? extends h> aVar) {
            super(0);
            this.$getScope = aVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            h hVarInvoke = this.$getScope.invoke();
            return hVarInvoke instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.a ? ((kotlin.reflect.jvm.internal.impl.resolve.scopes.a) hVarInvoke).h() : hVarInvoke;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(c9.a<? extends h> getScope) {
        this(null, getScope, 1, 0 == true ? 1 : 0);
        kotlin.jvm.internal.m.f(getScope, "getScope");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ g(ka.n NO_LOCKS, c9.a aVar, int i10, kotlin.jvm.internal.g gVar) {
        if ((i10 & 1) != 0) {
            NO_LOCKS = ka.f.f12182e;
            kotlin.jvm.internal.m.e(NO_LOCKS, "NO_LOCKS");
        }
        this(NO_LOCKS, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a
    protected h i() {
        return this.f14000b.invoke();
    }

    public g(ka.n storageManager, c9.a<? extends h> getScope) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(getScope, "getScope");
        this.f14000b = storageManager.c(new a(getScope));
    }
}
