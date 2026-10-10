package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f5<V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f3526g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e5<V> f3528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final V f3529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f3530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("overrideLock")
    private volatile V f3531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("cachingLock")
    private volatile V f3532f;

    /* synthetic */ f5(String str, Object obj, Object obj2, e5 e5Var, b2.e eVar) {
        this(str, obj, obj2, e5Var);
    }

    private f5(String str, V v10, V v11, e5<V> e5Var) {
        this.f3530d = new Object();
        this.f3531e = null;
        this.f3532f = null;
        this.f3527a = str;
        this.f3529c = v10;
        this.f3528b = e5Var;
    }

    public final V a(V v10) {
        synchronized (this.f3530d) {
        }
        if (v10 != null) {
            return v10;
        }
        if (d5.f3478a == null) {
            return this.f3529c;
        }
        synchronized (f3526g) {
            try {
                if (e.a()) {
                    return this.f3532f == null ? this.f3529c : this.f3532f;
                }
                try {
                    for (f5 f5Var : g0.f3547a) {
                        if (e.a()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        V vB = null;
                        try {
                            e5<V> e5Var = f5Var.f3528b;
                            if (e5Var != null) {
                                vB = e5Var.b();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (f3526g) {
                            f5Var.f3532f = vB;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                e5<V> e5Var2 = this.f3528b;
                if (e5Var2 == null) {
                    return this.f3529c;
                }
                try {
                    return e5Var2.b();
                } catch (IllegalStateException unused3) {
                    return this.f3529c;
                } catch (SecurityException unused4) {
                    return this.f3529c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String b() {
        return this.f3527a;
    }
}
