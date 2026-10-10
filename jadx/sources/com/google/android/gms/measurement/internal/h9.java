package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzeb;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@MainThread
@VisibleForTesting
final class h9 implements Application.ActivityLifecycleCallbacks, b2.z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ z7 f3691a;

    h9(z7 z7Var) {
        this.f3691a = z7Var;
    }

    static /* synthetic */ void f(h9 h9Var, boolean z10, Uri uri, String str, String str2) {
        Bundle bundleD;
        Bundle bundleD2;
        h9Var.f3691a.n();
        try {
            wc wcVarJ = h9Var.f3691a.j();
            if (TextUtils.isEmpty(str2)) {
                bundleD = null;
            } else if (str2.contains("gclid") || str2.contains("gbraid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id")) {
                bundleD = wcVarJ.D(Uri.parse("https://google.com/search?" + str2));
                if (bundleD != null) {
                    bundleD.putString("_cis", "referrer");
                }
            } else {
                wcVarJ.l().G().a("Activity created with data 'referrer' without required params");
                bundleD = null;
            }
            if (z10 && (bundleD2 = h9Var.f3691a.j().D(uri)) != null) {
                bundleD2.putString("_cis", "intent");
                if (!bundleD2.containsKey("gclid") && bundleD != null && bundleD.containsKey("gclid")) {
                    bundleD2.putString("_cer", String.format("gclid=%s", bundleD.getString("gclid")));
                }
                h9Var.f3691a.h1(str, "_cmp", bundleD2);
                h9Var.f3691a.f4267r.b(str, bundleD2);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            h9Var.f3691a.l().G().b("Activity created with referrer", str2);
            if (h9Var.f3691a.d().u(g0.F0)) {
                if (bundleD != null) {
                    h9Var.f3691a.h1(str, "_cmp", bundleD);
                    h9Var.f3691a.f4267r.b(str, bundleD);
                } else {
                    h9Var.f3691a.l().G().b("Referrer does not contain valid parameters", str2);
                }
                h9Var.f3691a.s0("auto", "_ldl", null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                h9Var.f3691a.l().G().a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                h9Var.f3691a.s0("auto", "_ldl", str2, true);
            }
        } catch (RuntimeException e10) {
            h9Var.f3691a.l().H().b("Throwable caught in handleReferrerForOnActivityCreated", e10);
        }
    }

    @Override // b2.z0
    public final void a(zzeb zzebVar) {
        this.f3691a.u().G(zzebVar);
    }

    @Override // b2.z0
    @MainThread
    public final void b(zzeb zzebVar) {
        ib ibVarW = this.f3691a.w();
        ibVarW.a().E(new hb(ibVarW, ibVarW.c().b()));
        this.f3691a.u().T(zzebVar);
    }

    @Override // b2.z0
    @MainThread
    public final void c(zzeb zzebVar) {
        this.f3691a.u().R(zzebVar);
        ib ibVarW = this.f3691a.w();
        ibVarW.a().E(new kb(ibVarW, ibVarW.c().b()));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004a  */
    @Override // b2.z0
    public final void d(zzeb zzebVar, Bundle bundle) throws Throwable {
        h9 h9Var;
        try {
            this.f3691a.l().L().a("onActivityCreated");
            Intent intent = zzebVar.f3348c;
            if (intent == null) {
                this.f3691a.u().H(zzebVar, bundle);
                return;
            }
            Uri data = intent.getData();
            if (data == null || !data.isHierarchical()) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString("com.android.vending.referral_url");
                    if (TextUtils.isEmpty(string)) {
                        data = null;
                    } else {
                        data = Uri.parse(string);
                    }
                } else {
                    data = null;
                }
            }
            Uri uri = data;
            if (uri == null || !uri.isHierarchical()) {
                this.f3691a.u().H(zzebVar, bundle);
                return;
            }
            this.f3691a.j();
            String str = wc.h0(intent) ? "gs" : "auto";
            String queryParameter = uri.getQueryParameter("referrer");
            h9Var = this;
            try {
                try {
                    this.f3691a.a().E(new i9(h9Var, bundle == null, uri, str, queryParameter));
                    h9Var.f3691a.u().H(zzebVar, bundle);
                    return;
                } catch (RuntimeException e10) {
                    e = e10;
                    h9Var.f3691a.l().H().b("Throwable caught in onActivityCreated", e);
                    h9Var.f3691a.u().H(zzebVar, bundle);
                }
            } catch (Throwable th) {
                th = th;
                h9Var.f3691a.u().H(zzebVar, bundle);
                throw th;
            }
        } catch (RuntimeException e11) {
            e = e11;
            h9Var = this;
        } catch (Throwable th2) {
            th = th2;
            h9Var = this;
            h9Var.f3691a.u().H(zzebVar, bundle);
            throw th;
        }
        h9Var.f3691a.l().H().b("Throwable caught in onActivityCreated", e);
        h9Var.f3691a.u().H(zzebVar, bundle);
    }

    @Override // b2.z0
    public final void e(zzeb zzebVar, Bundle bundle) {
        this.f3691a.u().S(zzebVar, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) throws Throwable {
        d(zzeb.J(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(zzeb.J(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityPaused(Activity activity) {
        c(zzeb.J(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityResumed(Activity activity) {
        b(zzeb.J(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        e(zzeb.J(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
