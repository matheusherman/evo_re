package l;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f14952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<j.f, c> f14953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<p<?>> f14954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p.a f14955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f14956f;

    /* JADX INFO: renamed from: l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class ThreadFactoryC0296a implements ThreadFactory {

        /* JADX INFO: renamed from: l.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class RunnableC0297a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f14957a;

            RunnableC0297a(Runnable runnable) {
                this.f14957a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f14957a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0297a(runnable), "glide-active-resources");
        }

        ThreadFactoryC0296a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new ThreadFactoryC0296a()));
    }

    synchronized void a(j.f fVar, p<?> pVar) {
        c cVarPut = this.f14953c.put(fVar, new c(fVar, pVar, this.f14954d, this.f14951a));
        if (cVarPut != null) {
            cVarPut.a();
        }
    }

    void c(@NonNull c cVar) {
        v<?> vVar;
        synchronized (this) {
            this.f14953c.remove(cVar.f14960a);
            if (cVar.f14961b && (vVar = cVar.f14962c) != null) {
                this.f14955e.a(cVar.f14960a, new p<>(vVar, true, false, cVar.f14960a, this.f14955e));
            }
        }
    }

    synchronized void d(j.f fVar) {
        c cVarRemove = this.f14953c.remove(fVar);
        if (cVarRemove != null) {
            cVarRemove.a();
        }
    }

    @Nullable
    synchronized p<?> e(j.f fVar) {
        c cVar = this.f14953c.get(fVar);
        if (cVar == null) {
            return null;
        }
        p<?> pVar = cVar.get();
        if (pVar == null) {
            c(cVar);
        }
        return pVar;
    }

    void f(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f14955e = aVar;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static final class c extends WeakReference<p<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final j.f f14960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f14961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        v<?> f14962c;

        void a() {
            this.f14962c = null;
            clear();
        }

        c(@NonNull j.f fVar, @NonNull p<?> pVar, @NonNull ReferenceQueue<? super p<?>> referenceQueue, boolean z10) {
            v<?> vVar;
            super(pVar, referenceQueue);
            this.f14960a = (j.f) e0.k.d(fVar);
            if (pVar.d() && z10) {
                vVar = (v) e0.k.d(pVar.c());
            } else {
                vVar = null;
            }
            this.f14962c = vVar;
            this.f14961b = pVar.d();
        }
    }

    void b() {
        while (!this.f14956f) {
            try {
                c((c) this.f14954d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @VisibleForTesting
    a(boolean z10, Executor executor) {
        this.f14953c = new HashMap();
        this.f14954d = new ReferenceQueue<>();
        this.f14951a = z10;
        this.f14952b = executor;
        executor.execute(new b());
    }
}
