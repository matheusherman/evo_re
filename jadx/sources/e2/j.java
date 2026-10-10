package e2;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j {
    @NonNull
    @Deprecated
    public static <TResult> g<TResult> c(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        m1.g.l(executor, "Executor must not be null");
        m1.g.l(callable, "Callback must not be null");
        z zVar = new z();
        executor.execute(new a0(zVar, callable));
        return zVar;
    }

    @NonNull
    public static <TResult> g<TResult> d(TResult tresult) {
        z zVar = new z();
        zVar.m(tresult);
        return zVar;
    }

    private static void f(g gVar, m mVar) {
        Executor executor = i.f9835b;
        gVar.f(executor, mVar);
        gVar.e(executor, mVar);
        gVar.a(executor, mVar);
    }

    public static <TResult> TResult a(@NonNull g<TResult> gVar) throws InterruptedException {
        m1.g.i();
        m1.g.g();
        m1.g.l(gVar, "Task must not be null");
        if (gVar.j()) {
            return (TResult) e(gVar);
        }
        l lVar = new l(null);
        f(gVar, lVar);
        lVar.d();
        return (TResult) e(gVar);
    }

    public static <TResult> TResult b(@NonNull g<TResult> gVar, long j10, @NonNull TimeUnit timeUnit) throws TimeoutException {
        m1.g.i();
        m1.g.g();
        m1.g.l(gVar, "Task must not be null");
        m1.g.l(timeUnit, "TimeUnit must not be null");
        if (gVar.j()) {
            return (TResult) e(gVar);
        }
        l lVar = new l(null);
        f(gVar, lVar);
        if (lVar.e(j10, timeUnit)) {
            return (TResult) e(gVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    private static Object e(@NonNull g gVar) throws ExecutionException {
        if (gVar.k()) {
            return gVar.h();
        }
        if (gVar.i()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(gVar.g());
    }
}
