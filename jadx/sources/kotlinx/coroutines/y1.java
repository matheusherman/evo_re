package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"kotlinx/coroutines/z1", "kotlinx/coroutines/a2"}, d2 = {}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class y1 {
    public static final z a(u1 u1Var) {
        return a2.a(u1Var);
    }

    public static final void c(v8.j jVar, CancellationException cancellationException) {
        a2.c(jVar, cancellationException);
    }

    public static final Object e(u1 u1Var, v8.f<? super r8.z> fVar) {
        return a2.e(u1Var, fVar);
    }

    public static final void f(n<?> nVar, Future<?> future) {
        z1.a(nVar, future);
    }

    public static final void g(u1 u1Var) {
        a2.f(u1Var);
    }

    public static final void h(v8.j jVar) {
        a2.g(jVar);
    }
}
