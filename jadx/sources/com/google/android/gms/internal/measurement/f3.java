package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class f3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile f3 f2670j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.google.android.gms.common.util.d f2672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f2673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a2.a f2674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("listenerList")
    private final List<Pair<b2.m0, Object>> f2675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile p2 f2679i;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f2680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f2681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f2682c;

        a(f3 f3Var) {
            this(true);
        }

        abstract void a();

        a(boolean z10) {
            this.f2680a = f3.this.f2672b.a();
            this.f2681b = f3.this.f2672b.b();
            this.f2682c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f3.this.f2677g) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e10) {
                f3.this.q(e10, false, this.f2682c);
                b();
            }
        }

        protected void b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            f3.this.m(new d4(this, bundle, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            f3.this.m(new i4(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            f3.this.m(new h4(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            f3.this.m(new e4(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            q2 q2Var = new q2();
            f3.this.m(new j4(this, activity, q2Var));
            Bundle bundleF = q2Var.f(50L);
            if (bundleF != null) {
                bundle.putAll(bundleF);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            f3.this.m(new f4(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            f3.this.m(new g4(this, activity));
        }
    }

    private static boolean B(Context context) {
        try {
            return new b2.y(context, b2.y.a(context)).b("google_app_id") != null;
        } catch (IllegalStateException unused) {
        }
    }

    private final boolean J() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static f3 e(@NonNull Context context) {
        return f(context, null, null, null, null);
    }

    public final void A(String str, String str2, Bundle bundle) {
        u(str, str2, bundle, true, true, null);
    }

    public final void s(@NonNull String str, Bundle bundle) {
        u(null, str, bundle, false, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E(String str, String str2) {
        return (str2 == null || str == null || J()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(a aVar) {
        this.f2673c.execute(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Exception exc, boolean z10, boolean z11) {
        f3 f3Var;
        Exception exc2;
        this.f2677g |= z10;
        if (z10) {
            Log.w(this.f2671a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z11) {
            f3Var = this;
            exc2 = exc;
            f3Var.i(5, "Error with data collection. Data lost.", exc2, null, null);
        } else {
            f3Var = this;
            exc2 = exc;
        }
        Log.w(f3Var.f2671a, "Error with data collection. Data lost.", exc2);
    }

    private final void u(String str, String str2, Bundle bundle, boolean z10, boolean z11, Long l10) {
        m(new c4(this, l10, str, str2, bundle, z10, z11));
    }

    public final void C(String str) {
        m(new n3(this, str));
    }

    public final String F() {
        q2 q2Var = new q2();
        m(new r3(this, q2Var));
        return q2Var.X(50L);
    }

    public final String G() {
        q2 q2Var = new q2();
        m(new x3(this, q2Var));
        return q2Var.X(500L);
    }

    public final String H() {
        q2 q2Var = new q2();
        m(new t3(this, q2Var));
        return q2Var.X(500L);
    }

    public final String I() {
        q2 q2Var = new q2();
        m(new s3(this, q2Var));
        return q2Var.X(500L);
    }

    public final int a(String str) {
        q2 q2Var = new q2();
        m(new z3(this, str, q2Var));
        Integer num = (Integer) q2.g(q2Var.f(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long b() {
        q2 q2Var = new q2();
        m(new u3(this, q2Var));
        Long lW = q2Var.W(500L);
        if (lW != null) {
            return lW.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ this.f2672b.a()).nextLong();
        int i10 = this.f2676f + 1;
        this.f2676f = i10;
        return jNextLong + ((long) i10);
    }

    protected final p2 c(Context context, boolean z10) {
        try {
            return s2.asInterface(DynamiteModule.d(context, DynamiteModule.f2502e, ModuleDescriptor.MODULE_ID).c("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.a e10) {
            q(e10, true, false);
            return null;
        }
    }

    public final List<Bundle> g(String str, String str2) {
        q2 q2Var = new q2();
        m(new k3(this, str, str2, q2Var));
        List<Bundle> list = (List) q2.g(q2Var.f(CoroutineLiveDataKt.DEFAULT_TIMEOUT), List.class);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final Map<String, Object> h(String str, String str2, boolean z10) {
        q2 q2Var = new q2();
        m(new v3(this, str, str2, z10, q2Var));
        Bundle bundleF = q2Var.f(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        if (bundleF == null || bundleF.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(bundleF.size());
        for (String str3 : bundleF.keySet()) {
            Object obj = bundleF.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final void i(int i10, String str, Object obj, Object obj2, Object obj3) {
        m(new y3(this, false, 5, str, obj, null, null));
    }

    public final void k(Intent intent) {
        m(new b4(this, intent));
    }

    public final void l(Bundle bundle) {
        m(new j3(this, bundle));
    }

    public final void r(Runnable runnable) {
        m(new q3(this, runnable));
    }

    public final void t(String str, String str2, Bundle bundle) {
        m(new i3(this, str, str2, bundle));
    }

    public final void v(boolean z10) {
        m(new a4(this, z10));
    }

    public final a2.a x() {
        return this.f2674d;
    }

    public final void z(String str) {
        m(new o3(this, str));
    }

    private f3(Context context, String str, String str2, String str3, Bundle bundle) {
        boolean z10;
        if (str != null && E(str2, str3)) {
            this.f2671a = str;
        } else {
            this.f2671a = "FA";
        }
        this.f2672b = com.google.android.gms.common.util.g.d();
        this.f2673c = i2.a().a(new m3(this), 1);
        this.f2674d = new a2.a(this);
        this.f2675e = new ArrayList();
        if (B(context) && !J()) {
            this.f2678h = null;
            this.f2677g = true;
            Log.w(this.f2671a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!E(str2, str3)) {
            this.f2678h = "fa";
            if (str2 != null && str3 != null) {
                Log.v(this.f2671a, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            } else {
                if (str2 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10 ^ (str3 == null)) {
                    Log.w(this.f2671a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            }
        } else {
            this.f2678h = str2;
        }
        m(new h3(this, str2, str3, context, bundle));
        Application application = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (application == null) {
            Log.w(this.f2671a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new b());
        }
    }

    public static f3 f(Context context, String str, String str2, String str3, Bundle bundle) {
        m1.g.k(context);
        if (f2670j == null) {
            synchronized (f3.class) {
                try {
                    if (f2670j == null) {
                        f2670j = new f3(context, str, str2, str3, bundle);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f2670j;
    }

    public final void j(Activity activity, String str, String str2) {
        m(new l3(this, zzeb.J(activity), str, str2));
    }
}
