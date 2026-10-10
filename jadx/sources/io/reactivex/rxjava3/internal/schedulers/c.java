package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c implements Callable<Void>, h8.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final FutureTask<Void> f11428f = new FutureTask<>(l8.a.f15234b, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Runnable f11429a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ExecutorService f11432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Thread f11433e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<Future<?>> f11431c = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<Future<?>> f11430b = new AtomicReference<>();

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f11431c.get();
            if (future2 == f11428f) {
                future.cancel(this.f11433e != Thread.currentThread());
                return;
            }
        } while (!androidx.p000lifecycle.h.a(this.f11431c, future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f11430b.get();
            if (future2 == f11428f) {
                future.cancel(this.f11433e != Thread.currentThread());
                return;
            }
        } while (!androidx.p000lifecycle.h.a(this.f11430b, future2, future));
    }

    @Override // h8.c
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f11431c;
        FutureTask<Void> futureTask = f11428f;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.f11433e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f11430b.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.f11433e != Thread.currentThread());
    }

    @Override // h8.c
    public boolean f() {
        return this.f11431c.get() == f11428f;
    }

    c(Runnable runnable, ExecutorService executorService) {
        this.f11429a = runnable;
        this.f11432d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f11433e = Thread.currentThread();
        try {
            this.f11429a.run();
            this.f11433e = null;
            c(this.f11432d.submit(this));
            return null;
        } catch (Throwable th) {
            this.f11433e = null;
            p8.a.l(th);
            throw th;
        }
    }
}
