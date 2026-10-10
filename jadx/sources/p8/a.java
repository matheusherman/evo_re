package p8;

import g8.h;
import i8.e;
import io.reactivex.rxjava3.internal.util.b;
import j8.c;
import j8.d;
import j8.g;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile c<? super Throwable> f17424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile d<? super Runnable, ? extends Runnable> f17425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile d<? super g<h>, ? extends h> f17426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile d<? super g<h>, ? extends h> f17427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile d<? super g<h>, ? extends h> f17428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile d<? super g<h>, ? extends h> f17429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile d<? super h, ? extends h> f17430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static volatile d<? super h, ? extends h> f17431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static volatile d<? super g8.c, ? extends g8.c> f17432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static volatile d<? super m8.a, ? extends m8.a> f17433j;

    public static h d(g<h> gVar) {
        Objects.requireNonNull(gVar, "Scheduler Supplier can't be null");
        d<? super g<h>, ? extends h> dVar = f17426c;
        return dVar == null ? c(gVar) : b(dVar, gVar);
    }

    public static h e(g<h> gVar) {
        Objects.requireNonNull(gVar, "Scheduler Supplier can't be null");
        d<? super g<h>, ? extends h> dVar = f17428e;
        return dVar == null ? c(gVar) : b(dVar, gVar);
    }

    public static h f(g<h> gVar) {
        Objects.requireNonNull(gVar, "Scheduler Supplier can't be null");
        d<? super g<h>, ? extends h> dVar = f17429f;
        return dVar == null ? c(gVar) : b(dVar, gVar);
    }

    public static h g(g<h> gVar) {
        Objects.requireNonNull(gVar, "Scheduler Supplier can't be null");
        d<? super g<h>, ? extends h> dVar = f17427d;
        return dVar == null ? c(gVar) : b(dVar, gVar);
    }

    static boolean h(Throwable th) {
        return (th instanceof i8.c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof i8.a);
    }

    public static <T> g8.c<T> i(g8.c<T> cVar) {
        d<? super g8.c, ? extends g8.c> dVar = f17432i;
        return dVar != null ? (g8.c) a(dVar, cVar) : cVar;
    }

    public static <T> m8.a<T> j(m8.a<T> aVar) {
        d<? super m8.a, ? extends m8.a> dVar = f17433j;
        return dVar != null ? (m8.a) a(dVar, aVar) : aVar;
    }

    public static h k(h hVar) {
        d<? super h, ? extends h> dVar = f17430g;
        return dVar == null ? hVar : (h) a(dVar, hVar);
    }

    public static void l(Throwable th) {
        c<? super Throwable> cVar = f17424a;
        if (th == null) {
            th = b.a("onError called with a null Throwable.");
        } else if (!h(th)) {
            th = new e(th);
        }
        if (cVar != null) {
            try {
                cVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                p(th2);
            }
        }
        th.printStackTrace();
        p(th);
    }

    public static h m(h hVar) {
        d<? super h, ? extends h> dVar = f17431h;
        return dVar == null ? hVar : (h) a(dVar, hVar);
    }

    public static Runnable n(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        d<? super Runnable, ? extends Runnable> dVar = f17425b;
        return dVar == null ? runnable : (Runnable) a(dVar, runnable);
    }

    static <T, R> R a(d<T, R> dVar, T t10) {
        try {
            return dVar.apply(t10);
        } catch (Throwable th) {
            throw b.d(th);
        }
    }

    static h b(d<? super g<h>, ? extends h> dVar, g<h> gVar) {
        Object objA = a(dVar, gVar);
        Objects.requireNonNull(objA, "Scheduler Supplier result can't be null");
        return (h) objA;
    }

    static h c(g<h> gVar) {
        try {
            h hVar = gVar.get();
            Objects.requireNonNull(hVar, "Scheduler Supplier result can't be null");
            return hVar;
        } catch (Throwable th) {
            throw b.d(th);
        }
    }

    static void p(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static <T> g8.g<? super T> o(g8.c<T> cVar, g8.g<? super T> gVar) {
        return gVar;
    }
}
