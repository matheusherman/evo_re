package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Object f2346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2347b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f2348c;

    protected abstract void a(Object obj);

    protected abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f2346a;
                if (this.f2347b) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f2347b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f2346a = null;
        }
    }

    public q(b bVar, Object obj) {
        this.f2348c = bVar;
        this.f2346a = obj;
    }

    public final void e() {
        d();
        synchronized (this.f2348c.f2319r) {
            this.f2348c.f2319r.remove(this);
        }
    }
}
