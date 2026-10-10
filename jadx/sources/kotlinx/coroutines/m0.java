package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001aJ\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/l0;", "b", "()Lkotlinx/coroutines/l0;", "R", "Lkotlin/Function2;", "Lv8/f;", "", "block", "c", "(Lc9/p;Lv8/f;)Ljava/lang/Object;", "Lv8/j;", "context", "a", "(Lv8/j;)Lkotlinx/coroutines/l0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class m0 {
    public static final l0 a(v8.j jVar) {
        if (jVar.get(u1.INSTANCE) == null) {
            jVar = jVar.plus(a2.b(null, 1, null));
        }
        return new CoroutineScope(jVar);
    }

    public static final l0 b() {
        return new CoroutineScope(q2.b(null, 1, null).plus(a1.c()));
    }

    public static final <R> Object c(c9.p<? super l0, ? super v8.f<? super R>, ? extends Object> pVar, v8.f<? super R> fVar) {
        kotlinx.coroutines.internal.b0 b0Var = new kotlinx.coroutines.internal.b0(fVar.getContext(), fVar);
        Object objB = va.b.b(b0Var, b0Var, pVar);
        if (objB == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objB;
    }
}
