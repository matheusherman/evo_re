package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l extends g8.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final g f11463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final ScheduledExecutorService f11464f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ThreadFactory f11465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f11466d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends g8.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f11467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h8.a f11468b = new h8.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f11469c;

        @Override // g8.h.c
        public h8.c c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f11469c) {
                return k8.b.INSTANCE;
            }
            j jVar = new j(p8.a.n(runnable), this.f11468b);
            this.f11468b.b(jVar);
            try {
                jVar.a(j10 <= 0 ? this.f11467a.submit((Callable) jVar) : this.f11467a.schedule((Callable) jVar, j10, timeUnit));
                return jVar;
            } catch (RejectedExecutionException e10) {
                dispose();
                p8.a.l(e10);
                return k8.b.INSTANCE;
            }
        }

        @Override // h8.c
        public void dispose() {
            if (this.f11469c) {
                return;
            }
            this.f11469c = true;
            this.f11468b.dispose();
        }

        @Override // h8.c
        public boolean f() {
            return this.f11469c;
        }

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f11467a = scheduledExecutorService;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f11464f = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f11463e = new g("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);
    }

    public l() {
        this(f11463e);
    }

    public l(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f11466d = atomicReference;
        this.f11465c = threadFactory;
        atomicReference.lazySet(g(threadFactory));
    }

    @Override // g8.h
    public g8.h.c c() {
        return new a(this.f11466d.get());
    }

    @Override // g8.h
    public h8.c e(Runnable runnable, long j10, TimeUnit timeUnit) {
        i iVar = new i(p8.a.n(runnable), true);
        try {
            iVar.b(j10 <= 0 ? this.f11466d.get().submit(iVar) : this.f11466d.get().schedule(iVar, j10, timeUnit));
            return iVar;
        } catch (RejectedExecutionException e10) {
            p8.a.l(e10);
            return k8.b.INSTANCE;
        }
    }

    static ScheduledExecutorService g(ThreadFactory threadFactory) {
        return k.a(threadFactory);
    }

    @Override // g8.h
    public h8.c f(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        Runnable runnableN = p8.a.n(runnable);
        if (j11 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f11466d.get();
            c cVar = new c(runnableN, scheduledExecutorService);
            try {
                if (j10 <= 0) {
                    futureSchedule = scheduledExecutorService.submit(cVar);
                } else {
                    futureSchedule = scheduledExecutorService.schedule(cVar, j10, timeUnit);
                }
                cVar.b(futureSchedule);
                return cVar;
            } catch (RejectedExecutionException e10) {
                p8.a.l(e10);
                return k8.b.INSTANCE;
            }
        }
        h hVar = new h(runnableN, true);
        try {
            hVar.b(this.f11466d.get().scheduleAtFixedRate(hVar, j10, j11, timeUnit));
            return hVar;
        } catch (RejectedExecutionException e11) {
            p8.a.l(e11);
            return k8.b.INSTANCE;
        }
    }
}
