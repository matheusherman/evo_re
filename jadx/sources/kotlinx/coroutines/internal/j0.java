package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.r2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r\"*\u0010\u0012\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011\"2\u0010\u0014\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00130\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011\"&\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u0018"}, d2 = {"Lv8/j;", "context", "", "b", "(Lv8/j;)Ljava/lang/Object;", "countOrElement", "c", "(Lv8/j;Ljava/lang/Object;)Ljava/lang/Object;", "oldState", "Lr8/z;", "a", "(Lv8/j;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/f0;", "Lkotlinx/coroutines/internal/f0;", "NO_THREAD_ELEMENTS", "Lkotlin/Function2;", "Lv8/j$b;", "Lc9/p;", "countAll", "Lkotlinx/coroutines/r2;", "findOne", "Lkotlinx/coroutines/internal/p0;", "d", "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f14832a = new f0("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c9.p<Object, v8.j.b, Object> f14833b = a.f14836a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c9.p<r2<?>, v8.j.b, r2<?>> f14834c = b.f14837a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final c9.p<p0, v8.j.b, p0> f14835d = c.f14838a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "countOrElement", "Lv8/j$b;", "element", "a", "(Ljava/lang/Object;Lv8/j$b;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.p<Object, v8.j.b, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14836a = new a();

        a() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, v8.j.b bVar) {
            if (!(bVar instanceof r2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\f\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/r2;", "found", "Lv8/j$b;", "element", "a", "(Lkotlinx/coroutines/r2;Lv8/j$b;)Lkotlinx/coroutines/r2;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.p<r2<?>, v8.j.b, r2<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14837a = new b();

        b() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r2<?> invoke(r2<?> r2Var, v8.j.b bVar) {
            if (r2Var != null) {
                return r2Var;
            }
            if (bVar instanceof r2) {
                return (r2) bVar;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/internal/p0;", "state", "Lv8/j$b;", "element", "a", "(Lkotlinx/coroutines/internal/p0;Lv8/j$b;)Lkotlinx/coroutines/internal/p0;"}, k = 3, mv = {1, 8, 0})
    static final class c extends kotlin.jvm.internal.o implements c9.p<p0, v8.j.b, p0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14838a = new c();

        c() {
            super(2);
        }

        @Override // c9.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p0 invoke(p0 p0Var, v8.j.b bVar) {
            if (bVar instanceof r2) {
                r2<?> r2Var = (r2) bVar;
                p0Var.a(r2Var, r2Var.t(p0Var.context));
            }
            return p0Var;
        }
    }

    public static final Object b(v8.j jVar) {
        Object objFold = jVar.fold(0, f14833b);
        kotlin.jvm.internal.m.c(objFold);
        return objFold;
    }

    public static final void a(v8.j jVar, Object obj) {
        if (obj == f14832a) {
            return;
        }
        if (obj instanceof p0) {
            ((p0) obj).b(jVar);
            return;
        }
        Object objFold = jVar.fold(null, f14834c);
        kotlin.jvm.internal.m.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((r2) objFold).f(jVar, obj);
    }

    public static final Object c(v8.j jVar, Object obj) {
        if (obj == null) {
            obj = b(jVar);
        }
        if (obj == 0) {
            return f14832a;
        }
        if (obj instanceof Integer) {
            return jVar.fold(new p0(jVar, ((Number) obj).intValue()), f14835d);
        }
        kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((r2) obj).t(jVar);
    }
}
