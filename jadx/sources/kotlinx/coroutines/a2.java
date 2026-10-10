package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u0005*\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\f\u001a\u00020\u0005*\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u000e\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0005*\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/u1;", "parent", "Lkotlinx/coroutines/z;", "a", "(Lkotlinx/coroutines/u1;)Lkotlinx/coroutines/z;", "Lr8/z;", "e", "(Lkotlinx/coroutines/u1;Lv8/f;)Ljava/lang/Object;", "Lv8/j;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "c", "(Lv8/j;Ljava/util/concurrent/CancellationException;)V", "f", "(Lkotlinx/coroutines/u1;)V", "g", "(Lv8/j;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/JobKt")
public final /* synthetic */ class a2 {
    public static final Object e(u1 u1Var, v8.f<? super r8.z> fVar) {
        u1.a.a(u1Var, null, 1, null);
        Object objS = u1Var.s(fVar);
        return objS == kotlin.coroutines.intrinsics.b.c() ? objS : r8.z.f17874a;
    }

    public static final z a(u1 u1Var) {
        return new x1(u1Var);
    }

    public static /* synthetic */ z b(u1 u1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            u1Var = null;
        }
        return y1.a(u1Var);
    }

    public static final void c(v8.j jVar, CancellationException cancellationException) {
        u1 u1Var = (u1) jVar.get(u1.INSTANCE);
        if (u1Var != null) {
            u1Var.a(cancellationException);
        }
    }

    public static /* synthetic */ void d(v8.j jVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        y1.c(jVar, cancellationException);
    }

    public static final void g(v8.j jVar) {
        u1 u1Var = (u1) jVar.get(u1.INSTANCE);
        if (u1Var != null) {
            y1.g(u1Var);
        }
    }

    public static final void f(u1 u1Var) {
        if (u1Var.isActive()) {
        } else {
            throw u1Var.j();
        }
    }
}
