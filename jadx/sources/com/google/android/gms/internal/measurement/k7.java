package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k7 implements j7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("GservicesLoader.class")
    private static k7 f2802d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentObserver f2804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("GservicesLoader.class")
    private boolean f2805c;

    private k7() {
        this.f2805c = false;
        this.f2803a = null;
        this.f2804b = null;
    }

    static k7 a(Context context) {
        k7 k7Var;
        synchronized (k7.class) {
            try {
                if (f2802d == null) {
                    f2802d = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new k7(context) : new k7();
                }
                k7 k7Var2 = f2802d;
                if (k7Var2 != null && k7Var2.f2804b != null && !k7Var2.f2805c) {
                    try {
                        context.getContentResolver().registerContentObserver(o6.f2911a, true, f2802d.f2804b);
                        ((k7) com.google.common.base.m.i(f2802d)).f2805c = true;
                    } catch (SecurityException e10) {
                        Log.e("GservicesLoader", "Unable to register Gservices content observer", e10);
                    }
                }
                k7Var = (k7) com.google.common.base.m.i(f2802d);
            } catch (Throwable th) {
                throw th;
            }
        }
        return k7Var;
    }

    static synchronized void c() {
        Context context;
        try {
            k7 k7Var = f2802d;
            if (k7Var != null && (context = k7Var.f2803a) != null && k7Var.f2804b != null && k7Var.f2805c) {
                context.getContentResolver().unregisterContentObserver(f2802d.f2804b);
            }
            f2802d = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.j7
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String i(final String str) {
        Context context = this.f2803a;
        if (context != null && !a7.b(context)) {
            try {
                return (String) i7.a(new l7() { // from class: com.google.android.gms.internal.measurement.n7
                    @Override // com.google.android.gms.internal.measurement.l7
                    public final Object b() {
                        return p6.a(((Context) com.google.common.base.m.i(this.f2893a.f2803a)).getContentResolver(), str, null);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e10) {
                Log.e("GservicesLoader", "Unable to read GServices for: " + str, e10);
            }
        }
        return null;
    }

    private k7(Context context) {
        this.f2805c = false;
        this.f2803a = context;
        this.f2804b = new m7(this, null);
    }
}
