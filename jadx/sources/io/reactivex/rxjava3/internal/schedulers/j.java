package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, h8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Object f11458a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f11459b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f11460c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Object f11461d = new Object();
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public j(Runnable runnable, h8.d dVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, dVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f11461d) {
                return;
            }
            if (obj == f11459b) {
                future.cancel(false);
                return;
            } else if (obj == f11460c) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // h8.c
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f11461d || obj5 == (obj3 = f11459b) || obj5 == (obj4 = f11460c)) {
                break;
            }
            boolean z10 = get(2) != Thread.currentThread();
            if (z10) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 == null) {
                    break;
                }
                ((Future) obj5).cancel(z10);
                break;
            }
        }
        do {
            obj = get(0);
            if (obj == f11461d || obj == (obj2 = f11458a) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((h8.d) obj).c(this);
    }

    @Override // h8.c
    public boolean f() {
        Object obj = get(0);
        return obj == f11458a || obj == f11461d;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public String toString() {
        String str;
        Object obj = get(1);
        if (obj == f11461d) {
            str = "Finished";
        } else if (obj == f11459b) {
            str = "Disposed(Sync)";
        } else if (obj == f11460c) {
            str = "Disposed(Async)";
        } else {
            Object obj2 = get(2);
            if (obj2 == null) {
                str = "Waiting";
            } else {
                str = "Running on " + obj2;
            }
        }
        return j.class.getSimpleName() + "[" + str + "]";
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
            Object obj3 = get(0);
            if (obj3 != f11458a && compareAndSet(0, obj3, f11461d) && obj3 != null) {
                ((h8.d) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f11459b || obj2 == f11460c) {
                    break;
                }
            } while (!compareAndSet(1, obj2, f11461d));
            lazySet(2, null);
        } catch (Throwable th) {
            try {
                p8.a.l(th);
                throw th;
            } catch (Throwable th2) {
                Object obj4 = get(0);
                if (obj4 != f11458a && compareAndSet(0, obj4, f11461d) && obj4 != null) {
                    ((h8.d) obj4).c(this);
                }
                do {
                    obj = get(1);
                    if (obj == f11459b || obj == f11460c) {
                        break;
                    }
                } while (!compareAndSet(1, obj, f11461d));
                lazySet(2, null);
                throw th2;
            }
        }
    }
}
