package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzeb;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.spi.Configurator;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class s9 extends m5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile q9 f4032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile q9 f4033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    protected q9 f4034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Integer, q9> f4035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("activityLock")
    private zzeb f4036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("activityLock")
    private volatile boolean f4037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile q9 f4038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private q9 f4039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("activityLock")
    private boolean f4040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f4041l;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:50:0x00ad  */
    @WorkerThread
    public final void J(q9 q9Var, q9 q9Var2, long j10, boolean z10, Bundle bundle) {
        long j11;
        n();
        boolean z11 = false;
        boolean z12 = (q9Var2 != null && q9Var2.f3944c == q9Var.f3944c && Objects.equals(q9Var2.f3943b, q9Var.f3943b) && Objects.equals(q9Var2.f3942a, q9Var.f3942a)) ? false : true;
        if (z10 && this.f4034e != null) {
            z11 = true;
        }
        if (z12) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            wc.Y(q9Var, bundle2, true);
            if (q9Var2 != null) {
                String str = q9Var2.f3942a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = q9Var2.f3943b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", q9Var2.f3944c);
            }
            if (z11) {
                long jA = w().f3721f.a(j10);
                if (jA > 0) {
                    j().N(bundle2, jA);
                }
            }
            if (!d().Y()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = q9Var.f3946e ? "app" : "auto";
            long jA2 = c().a();
            if (q9Var.f3946e) {
                long j12 = q9Var.f3947f;
                if (j12 != 0) {
                    j11 = j12;
                } else {
                    j11 = jA2;
                }
            } else {
                j11 = jA2;
            }
            s().l0(str3, "_vs", j11, bundle2);
        }
        if (z11) {
            K(this.f4034e, true, j10);
        }
        this.f4034e = q9Var;
        if (q9Var.f3946e) {
            this.f4039j = q9Var;
        }
        v().O(q9Var);
    }

    @Override // com.google.android.gms.measurement.internal.m5
    protected final boolean y() {
        return false;
    }

    static /* synthetic */ void L(s9 s9Var, Bundle bundle, q9 q9Var, q9 q9Var2, long j10) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        s9Var.J(q9Var, q9Var2, j10, true, s9Var.j().G(null, "screen_view", bundle, null, false));
    }

    @MainThread
    private final void P(String str, q9 q9Var, boolean z10) {
        q9 q9Var2;
        q9 q9Var3 = this.f4032c == null ? this.f4033d : this.f4032c;
        if (q9Var.f3943b == null) {
            q9Var2 = new q9(q9Var.f3942a, str != null ? p(str, "Activity") : null, q9Var.f3944c, q9Var.f3946e, q9Var.f3947f);
        } else {
            q9Var2 = q9Var;
        }
        this.f4033d = this.f4032c;
        this.f4032c = q9Var2;
        a().E(new u9(this, q9Var2, q9Var3, c().b(), z10));
    }

    @VisibleForTesting
    private final String p(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String[] strArrSplit = str.split("\\.");
        String str3 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str3.length() > d().s(null, false) ? str3.substring(0, d().s(null, false)) : str3;
    }

    public final void F(Bundle bundle, long j10) {
        String str;
        synchronized (this.f4041l) {
            try {
                if (!this.f4040k) {
                    l().N().a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String strP = null;
                if (bundle != null) {
                    String string = bundle.getString("screen_name");
                    if (string != null && (string.length() <= 0 || string.length() > d().s(null, false))) {
                        l().N().b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                        return;
                    }
                    String string2 = bundle.getString("screen_class");
                    if (string2 != null && (string2.length() <= 0 || string2.length() > d().s(null, false))) {
                        l().N().b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                        return;
                    } else {
                        strP = string2;
                        str = string;
                    }
                } else {
                    str = null;
                }
                if (strP == null) {
                    zzeb zzebVar = this.f4036g;
                    strP = zzebVar != null ? p(zzebVar.f3347b, "Activity") : "Activity";
                }
                String str2 = strP;
                q9 q9Var = this.f4032c;
                if (this.f4037h && q9Var != null) {
                    this.f4037h = false;
                    boolean zEquals = Objects.equals(q9Var.f3943b, str2);
                    boolean zEquals2 = Objects.equals(q9Var.f3942a, str);
                    if (zEquals && zEquals2) {
                        l().N().a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                l().L().c("Logging screen view with name, class", str == null ? Configurator.NULL : str, str2 == null ? Configurator.NULL : str2);
                q9 q9Var2 = this.f4032c == null ? this.f4033d : this.f4032c;
                q9 q9Var3 = new q9(str, str2, j().R0(), true, j10);
                this.f4032c = q9Var3;
                this.f4033d = q9Var2;
                this.f4038i = q9Var3;
                a().E(new r9(this, bundle, q9Var3, q9Var2, c().b()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @MainThread
    public final void G(zzeb zzebVar) {
        synchronized (this.f4041l) {
            try {
                if (Objects.equals(this.f4036g, zzebVar)) {
                    this.f4036g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (d().Y()) {
            this.f4035f.remove(Integer.valueOf(zzebVar.f3346a));
        }
    }

    public final q9 Q() {
        return this.f4032c;
    }

    @MainThread
    public final void R(zzeb zzebVar) {
        synchronized (this.f4041l) {
            this.f4040k = false;
            this.f4037h = true;
        }
        long jB = c().b();
        if (!d().Y()) {
            this.f4032c = null;
            a().E(new w9(this, jB));
        } else {
            q9 q9VarU = U(zzebVar);
            this.f4033d = this.f4032c;
            this.f4032c = null;
            a().E(new v9(this, q9VarU, jB));
        }
    }

    @MainThread
    public final void T(zzeb zzebVar) {
        synchronized (this.f4041l) {
            this.f4040k = true;
            if (!Objects.equals(zzebVar, this.f4036g)) {
                synchronized (this.f4041l) {
                    this.f4036g = zzebVar;
                    this.f4037h = false;
                }
                if (d().Y()) {
                    this.f4038i = null;
                    a().E(new y9(this));
                }
            }
        }
        if (!d().Y()) {
            this.f4032c = this.f4038i;
            a().E(new t9(this));
            return;
        }
        P(zzebVar.f3347b, U(zzebVar), false);
        w wVarO = o();
        wVarO.a().E(new t0(wVarO, wVarO.c().b()));
    }

    public s9(s6 s6Var) {
        super(s6Var);
        this.f4041l = new Object();
        this.f4035f = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void K(q9 q9Var, boolean z10, long j10) {
        boolean z11;
        o().x(c().b());
        if (q9Var != null && q9Var.f3945d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (w().G(z11, z10, j10) && q9Var != null) {
            q9Var.f3945d = false;
        }
    }

    @MainThread
    private final q9 U(@NonNull zzeb zzebVar) {
        m1.g.k(zzebVar);
        q9 q9Var = this.f4035f.get(Integer.valueOf(zzebVar.f3346a));
        if (q9Var == null) {
            q9 q9Var2 = new q9(null, p(zzebVar.f3347b, "Activity"), j().R0());
            this.f4035f.put(Integer.valueOf(zzebVar.f3346a), q9Var2);
            q9Var = q9Var2;
        }
        if (this.f4038i != null) {
            return this.f4038i;
        }
        return q9Var;
    }

    @WorkerThread
    public final q9 E(boolean z10) {
        z();
        n();
        if (!z10) {
            return this.f4034e;
        }
        q9 q9Var = this.f4034e;
        if (q9Var != null) {
            return q9Var;
        }
        return this.f4039j;
    }

    @MainThread
    public final void H(zzeb zzebVar, Bundle bundle) {
        Bundle bundle2;
        if (!d().Y() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f4035f.put(Integer.valueOf(zzebVar.f3346a), new q9(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(IjkMediaMeta.IJKM_KEY_TRACK_ID)));
    }

    @Deprecated
    public final void I(@NonNull zzeb zzebVar, @Size(max = 36, min = 1) String str, @Size(max = 36, min = 1) String str2) {
        String str3;
        if (!d().Y()) {
            l().N().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        q9 q9Var = this.f4032c;
        if (q9Var == null) {
            l().N().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f4035f.get(Integer.valueOf(zzebVar.f3346a)) == null) {
            l().N().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = p(zzebVar.f3347b, "Activity");
        }
        boolean zEquals = Objects.equals(q9Var.f3943b, str2);
        boolean zEquals2 = Objects.equals(q9Var.f3942a, str);
        if (zEquals && zEquals2) {
            l().N().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > d().s(null, false))) {
            l().N().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > d().s(null, false))) {
            l().N().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        r5 r5VarL = l().L();
        if (str == null) {
            str3 = Configurator.NULL;
        } else {
            str3 = str;
        }
        r5VarL.c("Setting current screen to name, class", str3, str2);
        q9 q9Var2 = new q9(str, str2, j().R0());
        this.f4035f.put(Integer.valueOf(zzebVar.f3346a), q9Var2);
        P(zzebVar.f3347b, q9Var2, true);
    }

    @MainThread
    public final void S(zzeb zzebVar, Bundle bundle) {
        q9 q9Var;
        if (!d().Y() || bundle == null || (q9Var = this.f4035f.get(Integer.valueOf(zzebVar.f3346a))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(IjkMediaMeta.IJKM_KEY_TRACK_ID, q9Var.f3944c);
        bundle2.putString("name", q9Var.f3942a);
        bundle2.putString("referrer_name", q9Var.f3943b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
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

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ w o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ h5 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ j5 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ z7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ o9 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ s9 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ x9 v() {
        return super.v();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ ib w() {
        return super.w();
    }
}
