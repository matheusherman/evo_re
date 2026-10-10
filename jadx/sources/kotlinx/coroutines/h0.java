package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001a\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u00020\u0016H\u0080\u0010¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/l0;", "Lv8/j;", "context", "d", "(Lkotlinx/coroutines/l0;Lv8/j;)Lv8/j;", "addedContext", "e", "(Lv8/j;Lv8/j;)Lv8/j;", "", "c", "(Lv8/j;)Z", "originalContext", "appendContext", "isNewCoroutine", "a", "(Lv8/j;Lv8/j;Z)Lv8/j;", "Lv8/f;", "", "oldValue", "Lkotlinx/coroutines/v2;", "g", "(Lv8/f;Lv8/j;Ljava/lang/Object;)Lkotlinx/coroutines/v2;", "Lkotlin/coroutines/jvm/internal/e;", "f", "(Lkotlin/coroutines/jvm/internal/e;)Lkotlinx/coroutines/v2;", "", "b", "(Lv8/j;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class h0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lv8/j;", "result", "Lv8/j$b;", "element", "a", "(Lv8/j;Lv8/j$b;)Lv8/j;"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.p<v8.j, v8.j.b, v8.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14804a = new a();

        a() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v8.j invoke(v8.j jVar, v8.j.b bVar) {
            return bVar instanceof g0 ? jVar.plus(((g0) bVar).p()) : jVar.plus(bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lv8/j;", "result", "Lv8/j$b;", "element", "a", "(Lv8/j;Lv8/j$b;)Lv8/j;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.p<v8.j, v8.j.b, v8.j> {
        final /* synthetic */ boolean $isNewCoroutine;
        final /* synthetic */ kotlin.jvm.internal.b0<v8.j> $leftoverContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.jvm.internal.b0<v8.j> b0Var, boolean z10) {
            super(2);
            this.$leftoverContext = b0Var;
            this.$isNewCoroutine = z10;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, v8.j] */
        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v8.j invoke(v8.j jVar, v8.j.b bVar) {
            if (!(bVar instanceof g0)) {
                return jVar.plus(bVar);
            }
            v8.j.b bVar2 = this.$leftoverContext.element.get(bVar.getKey());
            if (bVar2 != null) {
                kotlin.jvm.internal.b0<v8.j> b0Var = this.$leftoverContext;
                b0Var.element = b0Var.element.minusKey(bVar.getKey());
                return jVar.plus(((g0) bVar).k(bVar2));
            }
            g0 g0VarP = (g0) bVar;
            if (this.$isNewCoroutine) {
                g0VarP = g0VarP.p();
            }
            return jVar.plus(g0VarP);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "result", "Lv8/j$b;", "it", "a", "(ZLv8/j$b;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class c extends kotlin.jvm.internal.o implements c9.p<Boolean, v8.j.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14805a = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z10, v8.j.b bVar) {
            return Boolean.valueOf(z10 || (bVar instanceof g0));
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, v8.j.b bVar) {
            return a(bool.booleanValue(), bVar);
        }
    }

    public static final String b(v8.j jVar) {
        return null;
    }

    private static final boolean c(v8.j jVar) {
        return ((Boolean) jVar.fold(Boolean.FALSE, c.f14805a)).booleanValue();
    }

    public static final v2<?> f(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof w0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof v2) {
                return (v2) eVar;
            }
        }
        return null;
    }

    public static final v2<?> g(v8.f<?> fVar, v8.j jVar, Object obj) {
        if (!(fVar instanceof kotlin.coroutines.jvm.internal.e) || jVar.get(w2.f14945a) == null) {
            return null;
        }
        v2<?> v2VarF = f((kotlin.coroutines.jvm.internal.e) fVar);
        if (v2VarF != null) {
            v2VarF.N0(jVar, obj);
        }
        return v2VarF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final v8.j a(v8.j jVar, v8.j jVar2, boolean z10) {
        boolean zC = c(jVar);
        boolean zC2 = c(jVar2);
        if (!zC && !zC2) {
            return jVar.plus(jVar2);
        }
        kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        b0Var.element = jVar2;
        v8.k kVar = v8.k.f19724a;
        v8.j jVar3 = (v8.j) jVar.fold(kVar, new b(b0Var, z10));
        if (zC2) {
            b0Var.element = ((v8.j) b0Var.element).fold(kVar, a.f14804a);
        }
        return jVar3.plus((v8.j) b0Var.element);
    }

    public static final v8.j d(l0 l0Var, v8.j jVar) {
        v8.j jVarA = a(l0Var.getCoroutineContext(), jVar, true);
        if (jVarA != a1.a() && jVarA.get(v8.g.INSTANCE) == null) {
            return jVarA.plus(a1.a());
        }
        return jVarA;
    }

    public static final v8.j e(v8.j jVar, v8.j jVar2) {
        if (!c(jVar2)) {
            return jVar.plus(jVar2);
        }
        return a(jVar, jVar2, false);
    }
}
