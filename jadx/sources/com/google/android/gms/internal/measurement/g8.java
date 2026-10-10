package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g8 implements j7 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, g8> f2710g = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f2711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f2712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f2713c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Map<String, ?> f2715e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f2714d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private final List<h7> f2716f = new ArrayList();

    static synchronized void c() {
        try {
            for (g8 g8Var : f2710g.values()) {
                g8Var.f2711a.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) com.google.common.base.m.i(g8Var.f2713c));
            }
            f2710g.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void d(g8 g8Var, SharedPreferences sharedPreferences, String str) {
        synchronized (g8Var.f2714d) {
            g8Var.f2715e = null;
            g8Var.f2712b.run();
        }
        synchronized (g8Var) {
            try {
                Iterator<h7> it = g8Var.f2716f.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.j7
    public final Object i(String str) {
        Map<String, ?> map = this.f2715e;
        if (map == null) {
            synchronized (this.f2714d) {
                try {
                    map = this.f2715e;
                    if (map == null) {
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            Map<String, ?> all = this.f2711a.getAll();
                            this.f2715e = all;
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            map = all;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private g8(SharedPreferences sharedPreferences, Runnable runnable) {
        this.f2711a = sharedPreferences;
        this.f2712b = runnable;
    }

    private static SharedPreferences a(Context context, String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (a7.a()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return z1.a(context, str.substring(12), 0, v1.f3160a);
            }
            return z1.a(context, str, 0, v1.f3160a);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static g8 b(Context context, String str, Runnable runnable) {
        boolean zC;
        final g8 g8Var;
        if (a7.a() && !str.startsWith("direct_boot:")) {
            zC = a7.c(context);
        } else {
            zC = true;
        }
        if (!zC) {
            return null;
        }
        synchronized (g8.class) {
            try {
                Map<String, g8> map = f2710g;
                g8Var = map.get(str);
                if (g8Var == null) {
                    g8Var = new g8(a(context, str), runnable);
                    SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.measurement.f8
                        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                            g8.d(this.f2690a, sharedPreferences, str2);
                        }
                    };
                    g8Var.f2713c = onSharedPreferenceChangeListener;
                    g8Var.f2711a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                    map.put(str, g8Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return g8Var;
    }
}
