package e8;

import g8.h;
import i8.b;
import j8.d;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d<Callable<h>, h> f9904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d<h, h> f9905b;

    public static h d(Callable<h> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        d<Callable<h>, h> dVar = f9904a;
        return dVar == null ? c(callable) : b(dVar, callable);
    }

    public static h e(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        d<h, h> dVar = f9905b;
        return dVar == null ? hVar : (h) a(dVar, hVar);
    }

    static <T, R> R a(d<T, R> dVar, T t10) {
        try {
            return dVar.apply(t10);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    static h b(d<Callable<h>, h> dVar, Callable<h> callable) {
        h hVar = (h) a(dVar, callable);
        if (hVar != null) {
            return hVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static h c(Callable<h> callable) {
        try {
            h hVarCall = callable.call();
            if (hVarCall != null) {
                return hVarCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }
}
