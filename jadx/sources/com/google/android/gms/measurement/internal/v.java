package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Handler f4106d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t7 f4107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f4108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f4109c;

    public abstract void d();

    private final Handler f() {
        Handler handler;
        if (f4106d != null) {
            return f4106d;
        }
        synchronized (v.class) {
            try {
                if (f4106d == null) {
                    f4106d = new com.google.android.gms.internal.measurement.n2(this.f4107a.b().getMainLooper());
                }
                handler = f4106d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    final void a() {
        this.f4109c = 0L;
        f().removeCallbacks(this.f4108b);
    }

    public final boolean e() {
        return this.f4109c != 0;
    }

    v(t7 t7Var) {
        m1.g.k(t7Var);
        this.f4107a = t7Var;
        this.f4108b = new z(this, t7Var);
    }

    public final void b(long j10) {
        a();
        if (j10 >= 0) {
            this.f4109c = this.f4107a.c().a();
            if (!f().postDelayed(this.f4108b, j10)) {
                this.f4107a.l().H().b("Failed to schedule delayed post. time", Long.valueOf(j10));
            }
        }
    }
}
