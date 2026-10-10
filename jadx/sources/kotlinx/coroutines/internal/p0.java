package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.r2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R$\u0010\u0016\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/p0;", "", "Lv8/j;", "context", "", "n", "<init>", "(Lv8/j;I)V", "Lkotlinx/coroutines/r2;", "element", "value", "Lr8/z;", "a", "(Lkotlinx/coroutines/r2;Ljava/lang/Object;)V", "b", "(Lv8/j;)V", "Lv8/j;", "", "[Ljava/lang/Object;", "values", "c", "[Lkotlinx/coroutines/r2;", "elements", "d", "I", "i", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final v8.j context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Object[] values;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final r2<Object>[] elements;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int i;

    public final void a(r2<?> element, Object value) {
        Object[] objArr = this.values;
        int i10 = this.i;
        objArr[i10] = value;
        r2<Object>[] r2VarArr = this.elements;
        this.i = i10 + 1;
        kotlin.jvm.internal.m.d(element, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        r2VarArr[i10] = element;
    }

    public final void b(v8.j context) {
        int length = this.elements.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            r2<Object> r2Var = this.elements[length];
            kotlin.jvm.internal.m.c(r2Var);
            r2Var.f(context, this.values[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }

    public p0(v8.j jVar, int i10) {
        this.context = jVar;
        this.values = new Object[i10];
        this.elements = new r2[i10];
    }
}
