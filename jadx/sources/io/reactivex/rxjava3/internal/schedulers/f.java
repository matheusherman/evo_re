package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends g8.h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f11456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f11457b;

    @Override // g8.h.c
    public h8.c b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // g8.h.c
    public h8.c c(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f11457b ? k8.b.INSTANCE : e(runnable, j10, timeUnit, null);
    }

    @Override // h8.c
    public void dispose() {
        if (this.f11457b) {
            return;
        }
        this.f11457b = true;
        this.f11456a.shutdownNow();
    }

    @Override // h8.c
    public boolean f() {
        return this.f11457b;
    }

    public h8.c g(Runnable runnable, long j10, TimeUnit timeUnit) {
        i iVar = new i(p8.a.n(runnable), true);
        try {
            iVar.b(j10 <= 0 ? this.f11456a.submit(iVar) : this.f11456a.schedule(iVar, j10, timeUnit));
            return iVar;
        } catch (RejectedExecutionException e10) {
            p8.a.l(e10);
            return k8.b.INSTANCE;
        }
    }

    public void j() {
        if (this.f11457b) {
            return;
        }
        this.f11457b = true;
        this.f11456a.shutdown();
    }

    public f(ThreadFactory threadFactory) {
        this.f11456a = k.a(threadFactory);
    }

    public j e(Runnable runnable, long j10, TimeUnit timeUnit, h8.d dVar) {
        Future<?> futureSchedule;
        j jVar = new j(p8.a.n(runnable), dVar);
        if (dVar != null && !dVar.b(jVar)) {
            return jVar;
        }
        try {
            if (j10 <= 0) {
                futureSchedule = this.f11456a.submit((Callable) jVar);
            } else {
                futureSchedule = this.f11456a.schedule((Callable) jVar, j10, timeUnit);
            }
            jVar.a(futureSchedule);
            return jVar;
        } catch (RejectedExecutionException e10) {
            if (dVar != null) {
                dVar.a(jVar);
            }
            p8.a.l(e10);
            return jVar;
        }
    }

    public h8.c h(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Future<?> futureSchedule;
        Runnable runnableN = p8.a.n(runnable);
        if (j11 <= 0) {
            c cVar = new c(runnableN, this.f11456a);
            try {
                if (j10 <= 0) {
                    futureSchedule = this.f11456a.submit(cVar);
                } else {
                    futureSchedule = this.f11456a.schedule(cVar, j10, timeUnit);
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
            hVar.b(this.f11456a.scheduleAtFixedRate(hVar, j10, j11, timeUnit));
            return hVar;
        } catch (RejectedExecutionException e11) {
            p8.a.l(e11);
            return k8.b.INSTANCE;
        }
    }
}
