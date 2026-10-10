package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class p6 extends u7 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final AtomicLong f3898l = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private t6 f3899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private t6 f3900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PriorityBlockingQueue<q6<?>> f3901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue<q6<?>> f3902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f3903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f3904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f3905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Semaphore f3906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f3907k;

    @Override // com.google.android.gms.measurement.internal.u7
    protected final boolean u() {
        return false;
    }

    @Nullable
    final <T> T w(AtomicReference<T> atomicReference, long j10, String str, Runnable runnable) {
        synchronized (atomicReference) {
            a().E(runnable);
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                l().M().a("Interrupted waiting for " + str);
                return null;
            }
        }
        T t10 = atomicReference.get();
        if (t10 == null) {
            l().M().a("Timed out waiting for " + str);
        }
        return t10;
    }

    private final void z(q6<?> q6Var) {
        synchronized (this.f3905i) {
            try {
                this.f3901e.add(q6Var);
                t6 t6Var = this.f3899c;
                if (t6Var == null) {
                    t6 t6Var2 = new t6(this, "Measurement Worker", this.f3901e);
                    this.f3899c = t6Var2;
                    t6Var2.setUncaughtExceptionHandler(this.f3903g);
                    this.f3899c.start();
                } else {
                    t6Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    p6(s6 s6Var) {
        super(s6Var);
        this.f3905i = new Object();
        this.f3906j = new Semaphore(2);
        this.f3901e = new PriorityBlockingQueue<>();
        this.f3902f = new LinkedBlockingQueue();
        this.f3903g = new r6(this, "Thread death: Uncaught exception on worker thread");
        this.f3904h = new r6(this, "Thread death: Uncaught exception on network thread");
    }

    public final void A(Runnable runnable) {
        q();
        m1.g.k(runnable);
        q6<?> q6Var = new q6<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f3905i) {
            try {
                this.f3902f.add(q6Var);
                t6 t6Var = this.f3900d;
                if (t6Var == null) {
                    t6 t6Var2 = new t6(this, "Measurement Network", this.f3902f);
                    this.f3900d = t6Var2;
                    t6Var2.setUncaughtExceptionHandler(this.f3904h);
                    this.f3900d.start();
                } else {
                    t6Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <V> Future<V> C(Callable<V> callable) {
        q();
        m1.g.k(callable);
        q6<?> q6Var = new q6<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f3899c) {
            q6Var.run();
            return q6Var;
        }
        z(q6Var);
        return q6Var;
    }

    public final void E(Runnable runnable) {
        q();
        m1.g.k(runnable);
        z(new q6<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final void H(Runnable runnable) {
        q();
        m1.g.k(runnable);
        z(new q6<>(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean K() {
        if (Thread.currentThread() == this.f3900d) {
            return true;
        }
        return false;
    }

    public final boolean L() {
        if (Thread.currentThread() == this.f3899c) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ e e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a0 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ k5 g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a6 h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final void k() {
        if (Thread.currentThread() == this.f3900d) {
        } else {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final void n() {
        if (Thread.currentThread() == this.f3899c) {
        } else {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> x(Callable<V> callable) {
        q();
        m1.g.k(callable);
        q6<?> q6Var = new q6<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f3899c) {
            if (!this.f3901e.isEmpty()) {
                l().M().a("Callable skipped the worker queue.");
            }
            q6Var.run();
            return q6Var;
        }
        z(q6Var);
        return q6Var;
    }
}
