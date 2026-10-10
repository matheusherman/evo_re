package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class a extends AtomicReference<Future<?>> implements h8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final FutureTask<Void> f11412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final FutureTask<Void> f11413b;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final boolean interruptOnCancel;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        Runnable runnable = l8.a.f15234b;
        f11412a = new FutureTask<>(runnable, null);
        f11413b = new FutureTask<>(runnable, null);
    }

    private void a(Future<?> future) {
        if (this.runner == Thread.currentThread()) {
            future.cancel(false);
        } else {
            future.cancel(this.interruptOnCancel);
        }
    }

    a(Runnable runnable, boolean z10) {
        this.runnable = runnable;
        this.interruptOnCancel = z10;
    }

    public final void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 != f11412a) {
                if (future2 == f11413b) {
                    a(future);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // h8.c
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future != f11412a && future != (futureTask = f11413b) && compareAndSet(future, futureTask) && future != null) {
            a(future);
        }
    }

    @Override // h8.c
    public final boolean f() {
        Future<?> future = get();
        if (future != f11412a && future != f11413b) {
            return false;
        }
        return true;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        String str;
        Future<?> future = get();
        if (future == f11412a) {
            str = "Finished";
        } else if (future == f11413b) {
            str = "Disposed";
        } else if (this.runner != null) {
            str = "Running on " + this.runner;
        } else {
            str = "Waiting";
        }
        return getClass().getSimpleName() + "[" + str + "]";
    }
}
