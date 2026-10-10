package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzdz;
import com.google.android.gms.internal.measurement.zzeb;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    s6 f3357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("listenerMap")
    private final Map<Integer, b2.m0> f3358b = new ArrayMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements b2.m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.gms.internal.measurement.z2 f3359a;

        a(com.google.android.gms.internal.measurement.z2 z2Var) {
            this.f3359a = z2Var;
        }

        @Override // b2.m0
        public final void a(String str, String str2, Bundle bundle, long j10) {
            try {
                this.f3359a.J(str, str2, bundle, j10);
            } catch (RemoteException e10) {
                s6 s6Var = AppMeasurementDynamiteService.this.f3357a;
                if (s6Var != null) {
                    s6Var.l().M().b("Event listener threw exception", e10);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements b2.k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.gms.internal.measurement.z2 f3361a;

        b(com.google.android.gms.internal.measurement.z2 z2Var) {
            this.f3361a = z2Var;
        }

        @Override // b2.k0
        public final void a(String str, String str2, Bundle bundle, long j10) {
            try {
                this.f3361a.J(str, str2, bundle, j10);
            } catch (RemoteException e10) {
                s6 s6Var = AppMeasurementDynamiteService.this.f3357a;
                if (s6Var != null) {
                    s6Var.l().M().b("Event interceptor threw exception", e10);
                }
            }
        }
    }

    private final void f() {
        if (this.f3357a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void initialize(u1.a aVar, zzdz zzdzVar, long j10) {
        s6 s6Var = this.f3357a;
        if (s6Var == null) {
            this.f3357a = s6.d((Context) m1.g.k((Context) u1.b.g(aVar)), zzdzVar, Long.valueOf(j10));
        } else {
            s6Var.l().M().a("Attempting to initialize multiple times");
        }
    }

    public static /* synthetic */ void $r8$lambda$W3cgi1t5N0SU6fYxM9Fsh5qQfPc(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.v2 v2Var) {
        try {
            v2Var.O();
        } catch (RemoteException e10) {
            ((s6) m1.g.k(appMeasurementDynamiteService.f3357a)).l().M().b("Failed to call IDynamiteUploadBatchesCallback", e10);
        }
    }

    private final void g(com.google.android.gms.internal.measurement.u2 u2Var, String str) {
        f();
        this.f3357a.P().T(u2Var, str);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void beginAdUnitExposure(@NonNull String str, long j10) {
        f();
        this.f3357a.A().B(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        f();
        this.f3357a.J().o0(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void clearMeasurementEnabled(long j10) {
        f();
        this.f3357a.J().h0(null);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void endAdUnitExposure(@NonNull String str, long j10) {
        f();
        this.f3357a.A().F(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void generateEventId(com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        long jR0 = this.f3357a.P().R0();
        f();
        this.f3357a.P().R(u2Var, jR0);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getAppInstanceId(com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        this.f3357a.a().E(new x7(this, u2Var));
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        g(u2Var, this.f3357a.J().A0());
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        this.f3357a.a().E(new db(this, u2Var, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        g(u2Var, this.f3357a.J().B0());
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        g(u2Var, this.f3357a.J().C0());
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getGmpAppId(com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        g(u2Var, this.f3357a.J().D0());
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        this.f3357a.J();
        z7.G(str);
        f();
        this.f3357a.P().Q(u2Var, 25);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getSessionId(com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        this.f3357a.J().S(u2Var);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getTestFlag(com.google.android.gms.internal.measurement.u2 u2Var, int i10) {
        f();
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            return;
                        }
                        this.f3357a.P().V(u2Var, this.f3357a.J().w0().booleanValue());
                        return;
                    }
                    this.f3357a.P().Q(u2Var, this.f3357a.J().y0().intValue());
                    return;
                }
                wc wcVarP = this.f3357a.P();
                double dDoubleValue = this.f3357a.J().x0().doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", dDoubleValue);
                try {
                    u2Var.m(bundle);
                    return;
                } catch (RemoteException e10) {
                    wcVarP.f3965a.l().M().b("Error returning double value to wrapper", e10);
                    return;
                }
            }
            this.f3357a.P().R(u2Var, this.f3357a.J().z0().longValue());
            return;
        }
        this.f3357a.P().T(u2Var, this.f3357a.J().E0());
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void getUserProperties(String str, String str2, boolean z10, com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        this.f3357a.a().E(new k9(this, u2Var, str, str2, z10));
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void initForTests(@NonNull Map map) {
        f();
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.u2 u2Var) {
        f();
        this.f3357a.a().E(new ca(this, u2Var));
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z10, boolean z11, long j10) {
        f();
        this.f3357a.J().q0(str, str2, bundle, z10, z11, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.u2 u2Var, long j10) {
        Bundle bundle2;
        f();
        m1.g.e(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.f3357a.a().E(new a7(this, u2Var, new zzbj(str2, new zzbi(bundle), "app", j10), str));
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void logHealthData(int i10, @NonNull String str, @NonNull u1.a aVar, @NonNull u1.a aVar2, @NonNull u1.a aVar3) {
        Object objG;
        Object objG2;
        f();
        Object objG3 = null;
        if (aVar == null) {
            objG = null;
        } else {
            objG = u1.b.g(aVar);
        }
        if (aVar2 == null) {
            objG2 = null;
        } else {
            objG2 = u1.b.g(aVar2);
        }
        if (aVar3 != null) {
            objG3 = u1.b.g(aVar3);
        }
        this.f3357a.l().A(i10, true, false, str, objG, objG2, objG3);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityCreated(@NonNull u1.a aVar, @NonNull Bundle bundle, long j10) {
        f();
        onActivityCreatedByScionActivityInfo(zzeb.J((Activity) m1.g.k((Activity) u1.b.g(aVar))), bundle, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityCreatedByScionActivityInfo(zzeb zzebVar, Bundle bundle, long j10) {
        f();
        b2.z0 z0VarV0 = this.f3357a.J().v0();
        if (z0VarV0 != null) {
            this.f3357a.J().J0();
            z0VarV0.d(zzebVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityDestroyed(@NonNull u1.a aVar, long j10) {
        f();
        onActivityDestroyedByScionActivityInfo(zzeb.J((Activity) m1.g.k((Activity) u1.b.g(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityDestroyedByScionActivityInfo(zzeb zzebVar, long j10) {
        f();
        b2.z0 z0VarV0 = this.f3357a.J().v0();
        if (z0VarV0 != null) {
            this.f3357a.J().J0();
            z0VarV0.a(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityPaused(@NonNull u1.a aVar, long j10) {
        f();
        onActivityPausedByScionActivityInfo(zzeb.J((Activity) m1.g.k((Activity) u1.b.g(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityPausedByScionActivityInfo(zzeb zzebVar, long j10) {
        f();
        b2.z0 z0VarV0 = this.f3357a.J().v0();
        if (z0VarV0 != null) {
            this.f3357a.J().J0();
            z0VarV0.c(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityResumed(@NonNull u1.a aVar, long j10) {
        f();
        onActivityResumedByScionActivityInfo(zzeb.J((Activity) m1.g.k((Activity) u1.b.g(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityResumedByScionActivityInfo(zzeb zzebVar, long j10) {
        f();
        b2.z0 z0VarV0 = this.f3357a.J().v0();
        if (z0VarV0 != null) {
            this.f3357a.J().J0();
            z0VarV0.b(zzebVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivitySaveInstanceState(u1.a aVar, com.google.android.gms.internal.measurement.u2 u2Var, long j10) {
        f();
        onActivitySaveInstanceStateByScionActivityInfo(zzeb.J((Activity) m1.g.k((Activity) u1.b.g(aVar))), u2Var, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivitySaveInstanceStateByScionActivityInfo(zzeb zzebVar, com.google.android.gms.internal.measurement.u2 u2Var, long j10) {
        f();
        b2.z0 z0VarV0 = this.f3357a.J().v0();
        Bundle bundle = new Bundle();
        if (z0VarV0 != null) {
            this.f3357a.J().J0();
            z0VarV0.e(zzebVar, bundle);
        }
        try {
            u2Var.m(bundle);
        } catch (RemoteException e10) {
            this.f3357a.l().M().b("Error returning bundle value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityStarted(@NonNull u1.a aVar, long j10) {
        f();
        onActivityStartedByScionActivityInfo(zzeb.J((Activity) m1.g.k((Activity) u1.b.g(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityStartedByScionActivityInfo(zzeb zzebVar, long j10) {
        f();
        if (this.f3357a.J().v0() != null) {
            this.f3357a.J().J0();
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityStopped(@NonNull u1.a aVar, long j10) {
        f();
        onActivityStoppedByScionActivityInfo(zzeb.J((Activity) m1.g.k((Activity) u1.b.g(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void onActivityStoppedByScionActivityInfo(zzeb zzebVar, long j10) {
        f();
        if (this.f3357a.J().v0() != null) {
            this.f3357a.J().J0();
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.u2 u2Var, long j10) {
        f();
        u2Var.m(null);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.z2 z2Var) {
        b2.m0 aVar;
        f();
        synchronized (this.f3358b) {
            try {
                aVar = this.f3358b.get(Integer.valueOf(z2Var.b()));
                if (aVar == null) {
                    aVar = new a(z2Var);
                    this.f3358b.put(Integer.valueOf(z2Var.b()), aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3357a.J().R(aVar);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void resetAnalyticsData(long j10) {
        f();
        this.f3357a.J().L(j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.v2 v2Var) {
        f();
        if (!this.f3357a.B().K(null, g0.R0)) {
            return;
        }
        this.f3357a.J().j0(new Runnable() { // from class: b2.v
            @Override // java.lang.Runnable
            public final void run() {
                AppMeasurementDynamiteService.$r8$lambda$W3cgi1t5N0SU6fYxM9Fsh5qQfPc(this.f727a, v2Var);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j10) {
        f();
        if (bundle == null) {
            this.f3357a.l().H().a("Conditional user property must not be null");
        } else {
            this.f3357a.J().P(bundle, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setConsent(@NonNull Bundle bundle, long j10) {
        f();
        this.f3357a.J().U0(bundle, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setConsentThirdParty(@NonNull Bundle bundle, long j10) {
        f();
        this.f3357a.J().e1(bundle, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setCurrentScreen(@NonNull u1.a aVar, @NonNull String str, @NonNull String str2, long j10) {
        f();
        setCurrentScreenByScionActivityInfo(zzeb.J((Activity) m1.g.k((Activity) u1.b.g(aVar))), str, str2, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setCurrentScreenByScionActivityInfo(zzeb zzebVar, String str, String str2, long j10) {
        f();
        this.f3357a.M().I(zzebVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setDataCollectionEnabled(boolean z10) {
        f();
        this.f3357a.J().i1(z10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        f();
        this.f3357a.J().T0(bundle);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setEventInterceptor(com.google.android.gms.internal.measurement.z2 z2Var) {
        f();
        b bVar = new b(z2Var);
        if (this.f3357a.a().L()) {
            this.f3357a.J().Q(bVar);
        } else {
            this.f3357a.a().E(new m8(this, bVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.a3 a3Var) {
        f();
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setMeasurementEnabled(boolean z10, long j10) {
        f();
        this.f3357a.J().h0(Boolean.valueOf(z10));
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setMinimumSessionDuration(long j10) {
        f();
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setSessionTimeoutDuration(long j10) {
        f();
        this.f3357a.J().j1(j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setSgtmDebugInfo(@NonNull Intent intent) {
        f();
        this.f3357a.J().M(intent);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setUserId(@NonNull String str, long j10) {
        f();
        this.f3357a.J().k0(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull u1.a aVar, boolean z10, long j10) {
        f();
        this.f3357a.J().t0(str, str2, u1.b.g(aVar), z10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.p2
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.z2 z2Var) {
        b2.m0 m0VarRemove;
        f();
        synchronized (this.f3358b) {
            m0VarRemove = this.f3358b.remove(Integer.valueOf(z2Var.b()));
        }
        if (m0VarRemove == null) {
            m0VarRemove = new a(z2Var);
        }
        this.f3357a.J().V0(m0VarRemove);
    }
}
