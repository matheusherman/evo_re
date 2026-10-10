package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.internal.measurement.ef;
import com.google.android.gms.measurement.internal.z7;
import com.google.android.gms.measurement.internal.zzpb;
import com.stub.StubApp;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import org.apache.log4j.helpers.FileWatchdog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class z7 extends m5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private h9 f4252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b2.k0 f4253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<b2.m0> f4254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<String> f4256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f4257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private v f4260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private v f4261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PriorityQueue<zzow> f4262m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f4263n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @GuardedBy("consentLock")
    private v7 f4264o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicLong f4265p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f4266q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final ad f4267r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @VisibleForTesting
    private boolean f4268s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private v f4269t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f4270u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private v f4271v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final vc f4272w;

    public final void L(long j10) {
        Z0(null);
        a().E(new u8(this, j10));
    }

    @WorkerThread
    protected final void m0(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        long j11;
        String str4;
        long j12;
        int length;
        String str5 = str;
        m1.g.e(str5);
        m1.g.k(bundle);
        n();
        z();
        if (!this.f3965a.s()) {
            l().G().a("Event not sent since app measurement is disabled");
            return;
        }
        List<String> listK = q().K();
        if (listK != null && !listK.contains(str2)) {
            l().G().c("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        if (!this.f4255f) {
            this.f4255f = true;
            try {
                try {
                    (!this.f3965a.w() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, b().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, b());
                } catch (Exception e10) {
                    l().M().b("Failed to invoke Tag Manager's initialize() method", e10);
                }
            } catch (ClassNotFoundException unused) {
                l().K().a("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            r0("auto", "_lgclid", bundle.getString("gclid"), c().a());
        }
        z7 z7Var = this;
        if (z10 && wc.L0(str2)) {
            z7Var.j().O(bundle, z7Var.h().A.a());
        }
        if (!z12 && !"_iap".equals(str2)) {
            wc wcVarP = z7Var.f3965a.P();
            int i10 = 2;
            if (wcVarP.E0(NotificationCompat.CATEGORY_EVENT, str2)) {
                if (!wcVarP.q0(NotificationCompat.CATEGORY_EVENT, b2.j0.f696a, b2.j0.f697b, str2)) {
                    i10 = 13;
                } else if (wcVarP.k0(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                    i10 = 0;
                }
            }
            if (i10 != 0) {
                z7Var.l().I().b("Invalid public event name. Event will not be logged (FE)", z7Var.g().c(str2));
                z7Var.f3965a.P();
                String strK = wc.K(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                z7Var.f3965a.P();
                wc.Z(z7Var.f4272w, i10, "_ev", strK, length);
                return;
            }
        }
        q9 q9VarE = z7Var.u().E(false);
        if (q9VarE != null && !bundle.containsKey("_sc")) {
            q9VarE.f3945d = true;
        }
        wc.Y(q9VarE, bundle, z10 && !z12);
        boolean zEquals = "am".equals(str5);
        boolean zI0 = wc.I0(str2);
        if (z10 && z7Var.f4253d != null && !zI0 && !zEquals) {
            z7Var.l().G().c("Passing event to registered event handler (FE)", z7Var.g().c(str2), z7Var.g().a(bundle));
            m1.g.k(z7Var.f4253d);
            z7Var.f4253d.a(str5, str2, bundle, j10);
            return;
        }
        long j13 = j10;
        if (z7Var.f3965a.v()) {
            int iW = z7Var.j().w(str2);
            if (iW != 0) {
                z7Var.l().I().b("Invalid event name. Event will not be logged (FE)", z7Var.g().c(str2));
                z7Var.j();
                String strK2 = wc.K(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                z7Var.f3965a.P();
                wc.a0(z7Var.f4272w, str3, iW, "_ev", strK2, length);
                return;
            }
            Bundle bundleG = z7Var.j().G(str3, str2, bundle, com.google.android.gms.common.util.e.b("_o", "_sn", "_sc", "_si"), z12);
            m1.g.k(bundleG);
            if (z7Var.u().E(false) == null || !"_ae".equals(str2)) {
                j11 = 0;
            } else {
                ob obVar = z7Var.w().f3721f;
                j11 = 0;
                long jB = obVar.f3877d.c().b();
                long j14 = jB - obVar.f3875b;
                obVar.f3875b = jB;
                if (j14 > 0) {
                    z7Var.j().N(bundleG, j14);
                }
            }
            if (!"auto".equals(str5) && "_ssr".equals(str2)) {
                wc wcVarJ = z7Var.j();
                String string = bundleG.getString("_ffr");
                if (com.google.android.gms.common.util.q.a(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, wcVarJ.h().f3389x.a())) {
                    wcVarJ.l().G().a("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                wcVarJ.h().f3389x.b(string);
            } else if ("_ae".equals(str2)) {
                String strA = z7Var.j().h().f3389x.a();
                if (!TextUtils.isEmpty(strA)) {
                    bundleG.putString("_ffr", strA);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleG);
            boolean zH = z7Var.d().u(g0.f3552b1) ? z7Var.w().H() : z7Var.h().f3386u.b();
            if (z7Var.h().f3383r.a() > j11 && z7Var.h().z(j13) && zH) {
                z7Var.l().L().a("Current session is expired, remove the session number, ID, and engagement time");
                str4 = "_ae";
                j12 = j11;
                r0("auto", "_sid", null, z7Var.c().a());
                r0("auto", "_sno", null, c().a());
                r0("auto", "_se", null, c().a());
                z7Var = this;
                z7Var.h().f3384s.b(j12);
            } else {
                str4 = "_ae";
                j12 = j11;
            }
            if (bundleG.getLong("extend_session", j12) == 1) {
                z7Var.l().L().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                z7Var.f3965a.O().f3720e.b(j13, true);
            }
            ArrayList arrayList2 = new ArrayList(bundleG.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                String str6 = (String) obj;
                if (str6 != null) {
                    z7Var.j();
                    Bundle[] bundleArrZ0 = wc.z0(bundleG.get(str6));
                    if (bundleArrZ0 != null) {
                        bundleG.putParcelableArray(str6, bundleArrZ0);
                    }
                }
            }
            int i12 = 0;
            while (i12 < arrayList.size()) {
                Bundle bundleF = (Bundle) arrayList.get(i12);
                String str7 = i12 != 0 ? "_ep" : str2;
                bundleF.putString("_o", str5);
                if (z11) {
                    bundleF = z7Var.j().F(bundleF, null);
                }
                String str8 = str5;
                Bundle bundle2 = bundleF;
                z7Var.v().N(new zzbj(str7, new zzbi(bundleF), str8, j13), str3);
                if (!zEquals) {
                    Iterator<b2.m0> it = z7Var.f4254e.iterator();
                    while (it.hasNext()) {
                        it.next().a(str, str2, new Bundle(bundle2), j10);
                    }
                }
                i12++;
                str5 = str;
                j13 = j10;
            }
            if (z7Var.u().E(false) == null || !str4.equals(str2)) {
                return;
            }
            z7Var.w().G(true, true, z7Var.c().b());
        }
    }

    @Override // com.google.android.gms.measurement.internal.m5
    protected final boolean y() {
        return false;
    }

    private final b2.d1 H(final zzoz zzozVar) {
        try {
            URL url = new URI(zzozVar.f4308c).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String strI = q().I();
            l().L().d("[sgtm] Uploading data from app. row_id, url, uncompressed size", Long.valueOf(zzozVar.f4306a), zzozVar.f4308c, Integer.valueOf(zzozVar.f4307b.length));
            if (!TextUtils.isEmpty(zzozVar.f4312g)) {
                l().L().c("[sgtm] Uploading data from app. row_id", Long.valueOf(zzozVar.f4306a), zzozVar.f4312g);
            }
            HashMap map = new HashMap();
            for (String str : zzozVar.f4309d.keySet()) {
                String string = zzozVar.f4309d.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    map.put(str, string);
                }
            }
            l9 l9VarI = i();
            byte[] bArr = zzozVar.f4307b;
            j9 j9Var = new j9() { // from class: com.google.android.gms.measurement.internal.d8
                @Override // com.google.android.gms.measurement.internal.j9
                public final void a(String str2, int i10, Throwable th, byte[] bArr2, Map map2) {
                    z7.f0(this.f3485a, atomicReference, zzozVar, str2, i10, th, bArr2, map2);
                }
            };
            l9VarI.q();
            m1.g.k(url);
            m1.g.k(bArr);
            m1.g.k(j9Var);
            l9VarI.a().A(new n9(l9VarI, strI, url, bArr, map, j9Var));
            try {
                wc wcVarJ = j();
                long jA = wcVarJ.c().a();
                long j10 = jA + FileWatchdog.DEFAULT_DELAY;
                synchronized (atomicReference) {
                    for (long jA2 = FileWatchdog.DEFAULT_DELAY; atomicReference.get() == null && jA2 > 0; jA2 = j10 - wcVarJ.c().a()) {
                        try {
                            atomicReference.wait(jA2);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (InterruptedException unused) {
                l().M().a("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? b2.d1.UNKNOWN : (b2.d1) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e10) {
            l().H().d("[sgtm] Bad upload url for row_id", zzozVar.f4308c, Long.valueOf(zzozVar.f4306a), e10);
            return b2.d1.FAILURE;
        }
    }

    static /* synthetic */ void W0(z7 z7Var, int i10) {
        if (z7Var.f4260k == null) {
            z7Var.f4260k = new k8(z7Var, z7Var.f3965a);
        }
        z7Var.f4260k.b(((long) i10) * 1000);
    }

    static /* synthetic */ void X0(z7 z7Var, Bundle bundle) {
        z7Var.n();
        z7Var.z();
        m1.g.k(bundle);
        String strE = m1.g.e(bundle.getString("name"));
        if (!z7Var.f3965a.s()) {
            z7Var.l().L().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            z7Var.v().M(new zzai(bundle.getString("app_id"), "", new zzpy(strE, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), z7Var.j().I(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void g1(z7 z7Var, Bundle bundle) {
        z7Var.n();
        z7Var.z();
        m1.g.k(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        m1.g.e(string);
        m1.g.e(string2);
        m1.g.k(bundle.get("value"));
        if (!z7Var.f3965a.s()) {
            z7Var.l().L().a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzpy zzpyVar = new zzpy(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            zzbj zzbjVarI = z7Var.j().I(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            z7Var.v().M(new zzai(bundle.getString("app_id"), string2, zzpyVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), z7Var.j().I(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), zzbjVarI, bundle.getLong("time_to_live"), z7Var.j().I(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final String A0() {
        return this.f4256g.get();
    }

    public final String B0() {
        q9 q9VarQ = this.f3965a.M().Q();
        if (q9VarQ != null) {
            return q9VarQ.f3943b;
        }
        return null;
    }

    public final String C0() {
        q9 q9VarQ = this.f3965a.M().Q();
        if (q9VarQ != null) {
            return q9VarQ.f3942a;
        }
        return null;
    }

    public final String D0() {
        if (this.f3965a.Q() != null) {
            return this.f3965a.Q();
        }
        try {
            return new b2.y(b(), this.f3965a.T()).b("google_app_id");
        } catch (IllegalStateException e10) {
            this.f3965a.l().H().b("getGoogleAppId failed with exception", e10);
            return null;
        }
    }

    public final String E0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) a().w(atomicReference, 15000L, "String test flag value", new q8(this, atomicReference));
    }

    @TargetApi(30)
    final PriorityQueue<zzow> F0() {
        if (this.f4262m == null) {
            b2.q0.a();
            this.f4262m = b2.p0.a(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.c8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzow) obj).f4304b);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.b8
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.f4262m;
    }

    public final void P(Bundle bundle, long j10) {
        m1.g.k(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            l().M().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        m1.g.k(bundle2);
        b2.f0.a(bundle2, "app_id", String.class, null);
        b2.f0.a(bundle2, "origin", String.class, null);
        b2.f0.a(bundle2, "name", String.class, null);
        b2.f0.a(bundle2, "value", Object.class, null);
        b2.f0.a(bundle2, "trigger_event_name", String.class, null);
        b2.f0.a(bundle2, "trigger_timeout", Long.class, 0L);
        b2.f0.a(bundle2, "timed_out_event_name", String.class, null);
        b2.f0.a(bundle2, "timed_out_event_params", Bundle.class, null);
        b2.f0.a(bundle2, "triggered_event_name", String.class, null);
        b2.f0.a(bundle2, "triggered_event_params", Bundle.class, null);
        b2.f0.a(bundle2, "time_to_live", Long.class, 0L);
        b2.f0.a(bundle2, "expired_event_name", String.class, null);
        b2.f0.a(bundle2, "expired_event_params", Bundle.class, null);
        m1.g.e(bundle2.getString("name"));
        m1.g.e(bundle2.getString("origin"));
        m1.g.k(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j10);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (j().s0(string) != 0) {
            l().H().b("Invalid conditional user property name", g().g(string));
            return;
        }
        if (j().x(string, obj) != 0) {
            l().H().c("Invalid conditional user property value", g().g(string), obj);
            return;
        }
        Object objC0 = j().C0(string, obj);
        if (objC0 == null) {
            l().H().c("Unable to normalize conditional user property value", g().g(string), obj);
            return;
        }
        b2.f0.b(bundle2, objC0);
        long j11 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j11 > 15552000000L || j11 < 1)) {
            l().H().c("Invalid conditional user property timeout", g().g(string), Long.valueOf(j11));
            return;
        }
        long j12 = bundle2.getLong("time_to_live");
        if (j12 > 15552000000L || j12 < 1) {
            l().H().c("Invalid conditional user property time to live", g().g(string), Long.valueOf(j12));
        } else {
            a().E(new t8(this, bundle2));
        }
    }

    final boolean P0() {
        return this.f4263n;
    }

    final void T(y yVar, boolean z10) {
        d9 d9Var = new d9(this, yVar);
        if (!z10) {
            a().E(d9Var);
        } else {
            n();
            d9Var.run();
        }
    }

    public final void T0(Bundle bundle) {
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        a().E(new Runnable() { // from class: b2.t0
            @Override // java.lang.Runnable
            public final void run() {
                z7.Y(this.f722a, bundle2);
            }
        });
    }

    final void Z0(String str) {
        this.f4256g.set(str);
    }

    public final void e1(Bundle bundle, long j10) {
        O(bundle, -20, j10);
    }

    public final void k0(final String str, long j10) {
        if (str != null && TextUtils.isEmpty(str)) {
            this.f3965a.l().M().a("User ID must be non-empty or null");
        } else {
            a().E(new Runnable() { // from class: b2.s0
                @Override // java.lang.Runnable
                public final void run() {
                    z7.c0(this.f720a, str);
                }
            });
            t0(null, "_id", str, true, j10);
        }
    }

    public final void q0(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (Objects.equals(str2, "screen_view")) {
            u().F(bundle2, j10);
        } else {
            a1(str3, str2, j10, bundle2, z11, !z11 || this.f4253d == null || wc.I0(str2), z10, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    public final void t0(String str, String str2, Object obj, boolean z10, long j10) {
        int iS0;
        int length;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z10) {
            iS0 = j().s0(str2);
        } else {
            wc wcVarJ = j();
            if (!wcVarJ.E0("user property", str2)) {
                iS0 = 6;
            } else if (!wcVarJ.p0("user property", b2.l0.f706a, str2)) {
                iS0 = 15;
            } else if (wcVarJ.k0("user property", 24, str2)) {
                iS0 = 0;
            } else {
                iS0 = 6;
            }
        }
        if (iS0 != 0) {
            j();
            String strK = wc.K(str2, 24, true);
            length = str2 != null ? str2.length() : 0;
            this.f3965a.P();
            wc.Z(this.f4272w, iS0, "_ev", strK, length);
            return;
        }
        if (obj == null) {
            n0(str3, str2, j10, null);
            return;
        }
        int iX = j().x(str2, obj);
        if (iX == 0) {
            Object objC0 = j().C0(str2, obj);
            if (objC0 != null) {
                n0(str3, str2, j10, objC0);
                return;
            }
            return;
        }
        j();
        String strK2 = wc.K(str2, 24, true);
        length = ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0;
        this.f3965a.P();
        wc.Z(this.f4272w, iX, "_ev", strK2, length);
    }

    public final b2.z0 v0() {
        return this.f4252c;
    }

    public final Boolean w0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) a().w(atomicReference, 15000L, "boolean test flag value", new e8(this, atomicReference));
    }

    public final Double x0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) a().w(atomicReference, 15000L, "double test flag value", new b9(this, atomicReference));
    }

    public final Integer y0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) a().w(atomicReference, 15000L, "int test flag value", new c9(this, atomicReference));
    }

    public final Long z0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) a().w(atomicReference, 15000L, "long test flag value", new z8(this, atomicReference));
    }

    protected z7(s6 s6Var) {
        super(s6Var);
        this.f4254e = new CopyOnWriteArraySet();
        this.f4257h = new Object();
        this.f4258i = false;
        this.f4259j = 1;
        this.f4268s = true;
        this.f4272w = new a9(this);
        this.f4256g = new AtomicReference<>();
        this.f4264o = v7.f4111c;
        this.f4266q = -1L;
        this.f4265p = new AtomicLong(0L);
        this.f4267r = new ad(s6Var);
    }

    static /* synthetic */ int E(z7 z7Var, Throwable th) {
        String message = th.getMessage();
        z7Var.f4263n = false;
        if (message != null) {
            if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                    return 3;
                }
                return 2;
            }
            if (message.contains("Background")) {
                z7Var.f4263n = true;
            }
            return 1;
        }
        return 2;
    }

    public static int G(String str) {
        m1.g.e(str);
        return 25;
    }

    @VisibleForTesting
    private final void O(Bundle bundle, int i10, long j10) {
        String str;
        z();
        String strK = v7.k(bundle);
        if (strK != null) {
            l().N().b("Ignoring invalid consent setting", strK);
            l().N().a("Valid consent values are 'granted', 'denied'");
        }
        boolean zL = a().L();
        v7 v7VarF = v7.f(bundle, i10);
        if (v7VarF.y()) {
            V(v7VarF, zL);
        }
        y yVarB = y.b(bundle, i10);
        if (yVarB.k()) {
            T(yVarB, zL);
        }
        Boolean boolE = y.e(bundle);
        if (boolE != null) {
            if (i10 == -30) {
                str = "tcf";
            } else {
                str = "app";
            }
            String str2 = str;
            if (zL) {
                r0(str2, "allow_personalized_ads", boolE.toString(), j10);
            } else {
                t0(str2, "allow_personalized_ads", boolE.toString(), false, j10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void Q0() {
        z7 z7Var;
        long j10;
        n();
        String strA = h().f3380o.a();
        if (strA != null) {
            if ("unset".equals(strA)) {
                z7Var = this;
                z7Var.r0("app", "_npa", null, c().a());
            } else {
                if ("true".equals(strA)) {
                    j10 = 1;
                } else {
                    j10 = 0;
                }
                r0("app", "_npa", Long.valueOf(j10), c().a());
                z7Var = this;
            }
        } else {
            z7Var = this;
        }
        if (z7Var.f3965a.s() && z7Var.f4268s) {
            l().G().a("Recording app launch after enabling measurement for the first time (FE)");
            H0();
            w().f3720e.a();
            a().E(new n8(this));
            return;
        }
        l().G().a("Updating Scion state (FE)");
        v().k0();
    }

    public static /* synthetic */ void X(z7 z7Var, SharedPreferences sharedPreferences, String str) {
        if (!z7Var.d().u(g0.f3582l1)) {
            if (!Objects.equals(str, "IABTCF_TCString")) {
                return;
            }
        } else if (!Objects.equals(str, "IABTCF_TCString") && !Objects.equals(str, "IABTCF_gdprApplies") && !Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            return;
        }
        z7Var.l().L().a("IABTCF_TCString change picked up in listener.");
        ((v) m1.g.k(z7Var.f4271v)).b(500L);
    }

    public static /* synthetic */ void Y(z7 z7Var, Bundle bundle) {
        Bundle bundle2;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            bundle2 = new Bundle(z7Var.h().A.a());
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    z7Var.j();
                    if (wc.j0(obj)) {
                        z7Var.j();
                        wc.Z(z7Var.f4272w, 27, null, null, 0);
                    }
                    z7Var.l().N().c("Invalid default event parameter type. Name, value", str, obj);
                } else if (wc.I0(str)) {
                    z7Var.l().N().b("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundle2.remove(str);
                } else if (z7Var.j().m0("param", str, z7Var.d().s(null, false), obj)) {
                    z7Var.j().P(bundle2, str, obj);
                }
            }
            z7Var.j();
            if (wc.i0(bundle2, z7Var.d().B())) {
                z7Var.j();
                wc.Z(z7Var.f4272w, 26, null, null, 0);
                z7Var.l().N().a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        z7Var.h().A.b(bundle2);
        if (bundle.isEmpty() && !z7Var.d().u(g0.f3561e1)) {
            return;
        }
        z7Var.v().E(bundle2);
    }

    public static /* synthetic */ void Z(z7 z7Var, Bundle bundle, long j10) {
        if (TextUtils.isEmpty(z7Var.q().J())) {
            z7Var.O(bundle, 0, j10);
        } else {
            z7Var.l().N().a("Using developer consent only; google app id found");
        }
    }

    static /* synthetic */ void a0(z7 z7Var, v7 v7Var, long j10, boolean z10, boolean z11) {
        z7Var.n();
        z7Var.z();
        v7 v7VarO = z7Var.h().O();
        if (j10 <= z7Var.f4266q && v7.l(v7VarO.b(), v7Var.b())) {
            z7Var.l().K().b("Dropped out-of-date consent setting, proposed settings", v7Var);
            return;
        }
        if (z7Var.h().B(v7Var)) {
            z7Var.l().L().b("Setting storage consent(FE)", v7Var);
            z7Var.f4266q = j10;
            if (z7Var.v().o0()) {
                z7Var.v().t0(z10);
            } else {
                z7Var.v().b0(z10);
            }
            if (z11) {
                z7Var.v().W(new AtomicReference<>());
                return;
            }
            return;
        }
        z7Var.l().K().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(v7Var.b()));
    }

    private final void a1(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        a().E(new o8(this, str, str2, j10, wc.E(bundle), z10, z11, z12, str3));
    }

    public static /* synthetic */ void c0(z7 z7Var, String str) {
        if (z7Var.q().N(str)) {
            z7Var.q().L();
        }
    }

    public static /* synthetic */ void d0(z7 z7Var, List list) {
        z7Var.n();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> sparseArrayM = z7Var.h().M();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzow zzowVar = (zzow) it.next();
                if (!sparseArrayM.contains(zzowVar.f4305c) || sparseArrayM.get(zzowVar.f4305c).longValue() < zzowVar.f4304b) {
                    z7Var.F0().add(zzowVar);
                }
            }
            z7Var.N0();
        }
    }

    public static /* synthetic */ void e0(z7 z7Var, AtomicReference atomicReference) {
        Bundle bundleA = z7Var.h().f3381p.a();
        x9 x9VarV = z7Var.v();
        if (bundleA == null) {
            bundleA = new Bundle();
        }
        x9VarV.X(atomicReference, bundleA);
    }

    public static /* synthetic */ void f0(z7 z7Var, AtomicReference atomicReference, zzoz zzozVar, String str, int i10, Throwable th, byte[] bArr, Map map) {
        b2.d1 d1Var;
        z7Var.n();
        if ((i10 == 200 || i10 == 204 || i10 == 304) && th == null) {
            z7Var.l().L().b("[sgtm] Upload succeeded for row_id", Long.valueOf(zzozVar.f4306a));
            d1Var = b2.d1.SUCCESS;
        } else {
            z7Var.l().M().d("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzozVar.f4306a), Integer.valueOf(i10), th);
            if (Arrays.asList(g0.f3603u.a(null).split(",")).contains(String.valueOf(i10))) {
                d1Var = b2.d1.BACKOFF;
            } else {
                d1Var = b2.d1.FAILURE;
            }
        }
        z7Var.v().L(new zzag(zzozVar.f4306a, d1Var.b(), zzozVar.f4311f));
        z7Var.l().L().c("[sgtm] Updated status for row_id", Long.valueOf(zzozVar.f4306a), d1Var);
        synchronized (atomicReference) {
            atomicReference.set(d1Var);
            atomicReference.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void i0(Boolean bool, boolean z10) {
        n();
        z();
        l().G().b("Setting app measurement enabled (FE)", bool);
        h().w(bool);
        if (z10) {
            h().G(bool);
        }
        if (!this.f3965a.t() && (bool == null || bool.booleanValue())) {
            return;
        }
        Q0();
    }

    private final void n0(String str, String str2, long j10, Object obj) {
        a().E(new r8(this, str, str2, obj, j10));
    }

    @WorkerThread
    public final void G0() {
        n();
        z();
        x9 x9VarV = v();
        x9VarV.n();
        x9VarV.z();
        if (!x9VarV.p0() || x9VarV.j().J0() >= 242600) {
            v().e0();
        }
    }

    @WorkerThread
    public final void H0() {
        n();
        z();
        if (this.f3965a.v()) {
            Boolean boolH = d().H("google_analytics_deferred_deep_link_enabled");
            if (boolH != null && boolH.booleanValue()) {
                l().G().a("Deferred Deep Link feature enabled.");
                a().E(new Runnable() { // from class: b2.x0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f738a.L0();
                    }
                });
            }
            v().f0();
            this.f4268s = false;
            String strS = h().S();
            if (!TextUtils.isEmpty(strS)) {
                f().q();
                if (!strS.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", strS);
                    h1("auto", "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    final void I0() {
        n();
        v vVar = this.f4261l;
        if (vVar != null) {
            vVar.a();
        }
    }

    public final ArrayList<Bundle> J(String str, String str2) {
        if (a().L()) {
            l().H().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (e.a()) {
            l().H().a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f3965a.a().w(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get conditional user properties", new v8(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            l().H().b("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return wc.u0(list);
    }

    public final void J0() {
        if ((StubApp.getOrigApplicationContext(b().getApplicationContext()) instanceof Application) && this.f4252c != null) {
            ((Application) StubApp.getOrigApplicationContext(b().getApplicationContext())).unregisterActivityLifecycleCallbacks(this.f4252c);
        }
    }

    public final Map<String, Object> K(String str, String str2, boolean z10) {
        if (a().L()) {
            l().H().a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if (e.a()) {
            l().H().a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f3965a.a().w(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get user properties", new y8(this, atomicReference, null, str, str2, z10));
        List<zzpy> list = (List) atomicReference.get();
        if (list == null) {
            l().H().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
            return Collections.EMPTY_MAP;
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzpy zzpyVar : list) {
            Object objJ = zzpyVar.J();
            if (objJ != null) {
                arrayMap.put(zzpyVar.f4316b, objJ);
            }
        }
        return arrayMap;
    }

    final void K0() {
        if (ef.a() && d().u(g0.W0)) {
            if (a().L()) {
                l().H().a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (e.a()) {
                l().H().a("Cannot get trigger URIs from main thread");
                return;
            }
            z();
            l().L().a("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            a().w(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: b2.r0
                @Override // java.lang.Runnable
                public final void run() {
                    z7.e0(this.f718a, atomicReference);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                l().H().a("Timed out waiting for get trigger URIs");
            } else {
                a().E(new Runnable() { // from class: b2.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        z7.d0(this.f725a, list);
                    }
                });
            }
        }
    }

    @WorkerThread
    public final void L0() {
        n();
        if (h().f3387v.b()) {
            l().G().a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jA = h().f3388w.a();
        h().f3388w.b(1 + jA);
        if (jA >= 5) {
            l().M().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            h().f3387v.a(true);
        } else {
            if (this.f4269t == null) {
                this.f4269t = new s8(this, this.f3965a);
            }
            this.f4269t.b(0L);
        }
    }

    @WorkerThread
    public final void M(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            l().K().a("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter != null && queryParameter.equals("1")) {
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (!TextUtils.isEmpty(queryParameter2)) {
                l().K().b("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
                d().O(queryParameter2);
                return;
            }
            return;
        }
        l().K().a("[sgtm] Preview Mode was not enabled.");
        d().O(null);
    }

    @WorkerThread
    public final void M0() {
        pb pbVar;
        pb pbVar2;
        n();
        l().G().a("Handle tcf update.");
        SharedPreferences sharedPreferencesJ = h().J();
        HashMap map = new HashMap();
        f5<Boolean> f5Var = g0.f3582l1;
        if (f5Var.a(null).booleanValue()) {
            pbVar = new pb(new rb(sharedPreferencesJ).c());
        } else {
            String strE = rb.e(sharedPreferencesJ, "IABTCF_VendorConsents");
            if (!"".equals(strE) && strE.length() > 754) {
                map.put("GoogleConsent", String.valueOf(strE.charAt(754)));
            }
            int iA = rb.a(sharedPreferencesJ, "IABTCF_gdprApplies");
            if (iA != -1) {
                map.put("gdprApplies", String.valueOf(iA));
            }
            int iA2 = rb.a(sharedPreferencesJ, "IABTCF_EnableAdvertiserConsentMode");
            if (iA2 != -1) {
                map.put("EnableAdvertiserConsentMode", String.valueOf(iA2));
            }
            int iA3 = rb.a(sharedPreferencesJ, "IABTCF_PolicyVersion");
            if (iA3 != -1) {
                map.put("PolicyVersion", String.valueOf(iA3));
            }
            String strE2 = rb.e(sharedPreferencesJ, "IABTCF_PurposeConsents");
            if (!"".equals(strE2)) {
                map.put("PurposeConsents", strE2);
            }
            int iA4 = rb.a(sharedPreferencesJ, "IABTCF_CmpSdkID");
            if (iA4 != -1) {
                map.put("CmpSdkID", String.valueOf(iA4));
            }
            pbVar = new pb(map);
        }
        l().L().b("Tcf preferences read", pbVar);
        if (d().u(f5Var)) {
            String strD = h().D();
            HashMap map2 = new HashMap();
            if (TextUtils.isEmpty(strD)) {
                pbVar2 = new pb(map2);
            } else {
                for (String str : strD.split(";")) {
                    String[] strArrSplit = str.split("=");
                    if (strArrSplit.length >= 2 && rb.f3978o.contains(strArrSplit[0])) {
                        map2.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                pbVar2 = new pb(map2);
            }
            if (h().C(pbVar)) {
                Bundle bundleA = pbVar.a();
                l().L().b("Consent generated from Tcf", bundleA);
                if (bundleA != Bundle.EMPTY) {
                    O(bundleA, -30, c().a());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfm", pbVar.b(pbVar2));
                bundle.putString("_tcfd2", pbVar.c());
                bundle.putString("_tcfd", pbVar.d());
                h1("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        if (h().C(pbVar)) {
            Bundle bundleA2 = pbVar.a();
            l().L().b("Consent generated from Tcf", bundleA2);
            if (bundleA2 != Bundle.EMPTY) {
                O(bundleA2, -30, c().a());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfd", pbVar.d());
            h1("auto", "_tcf", bundle2);
        }
    }

    public final void N(Bundle bundle) {
        P(bundle, c().a());
    }

    @TargetApi(30)
    @WorkerThread
    final void N0() {
        zzow zzowVarPoll;
        MeasurementManagerFutures measurementManagerFuturesS0;
        n();
        this.f4263n = false;
        if (!F0().isEmpty() && !this.f4258i && (zzowVarPoll = F0().poll()) != null && (measurementManagerFuturesS0 = j().S0()) != null) {
            this.f4258i = true;
            l().L().b("Registering trigger URI", zzowVarPoll.f4303a);
            h2.d<r8.z> dVarRegisterTriggerAsync = measurementManagerFuturesS0.registerTriggerAsync(Uri.parse(zzowVarPoll.f4303a));
            if (dVarRegisterTriggerAsync == null) {
                this.f4258i = false;
                F0().add(zzowVarPoll);
            } else {
                h2.b.a(dVarRegisterTriggerAsync, new h8(this, zzowVarPoll), new i8(this));
            }
        }
    }

    @WorkerThread
    public final void O0() {
        n();
        l().G().a("Register tcfPrefChangeListener.");
        if (this.f4270u == null) {
            this.f4271v = new p8(this, this.f3965a);
            this.f4270u = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: b2.y0
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    z7.X(this.f741a, sharedPreferences, str);
                }
            };
        }
        h().J().registerOnSharedPreferenceChangeListener(this.f4270u);
    }

    @WorkerThread
    public final void Q(b2.k0 k0Var) {
        b2.k0 k0Var2;
        boolean z10;
        n();
        z();
        if (k0Var != null && k0Var != (k0Var2 = this.f4253d)) {
            if (k0Var2 == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            m1.g.p(z10, "EventInterceptor already set.");
        }
        this.f4253d = k0Var;
    }

    public final void R(b2.m0 m0Var) {
        z();
        m1.g.k(m0Var);
        if (!this.f4254e.add(m0Var)) {
            l().M().a("OnEventListener already registered");
        }
    }

    public final void S(com.google.android.gms.internal.measurement.u2 u2Var) {
        a().E(new x8(this, u2Var));
    }

    @WorkerThread
    final void S0(long j10) {
        n();
        z();
        l().G().a("Resetting analytics data (FE)");
        ib ibVarW = w();
        ibVarW.n();
        ibVarW.f3721f.b();
        q().L();
        boolean zS = this.f3965a.s();
        a6 a6VarH = h();
        a6VarH.f3372g.b(j10);
        if (!TextUtils.isEmpty(a6VarH.h().f3389x.a())) {
            a6VarH.f3389x.b(null);
        }
        a6VarH.f3383r.b(0L);
        a6VarH.f3384s.b(0L);
        if (!a6VarH.d().Z()) {
            a6VarH.I(!zS);
        }
        a6VarH.f3390y.b(null);
        a6VarH.f3391z.b(0L);
        a6VarH.A.b(null);
        v().i0();
        w().f3720e.a();
        this.f4268s = !zS;
    }

    @WorkerThread
    final void U(v7 v7Var) {
        boolean z10;
        n();
        if ((v7Var.x() && v7Var.w()) || v().n0()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 != this.f3965a.t()) {
            this.f3965a.y(z10);
            Boolean boolQ = h().Q();
            if (!z10 || boolQ == null || boolQ.booleanValue()) {
                i0(Boolean.valueOf(z10), false);
            }
        }
    }

    public final void U0(final Bundle bundle, final long j10) {
        a().H(new Runnable() { // from class: b2.v0
            @Override // java.lang.Runnable
            public final void run() {
                z7.Z(this.f729a, bundle, j10);
            }
        });
    }

    public final void V(v7 v7Var, boolean z10) {
        boolean z11;
        boolean zS;
        boolean z12;
        v7 v7Var2;
        z();
        int iB = v7Var.b();
        if (iB != -10) {
            b2.g0 g0VarR = v7Var.r();
            b2.g0 g0Var = b2.g0.UNINITIALIZED;
            if (g0VarR == g0Var && v7Var.t() == g0Var) {
                l().N().a("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.f4257h) {
            try {
                z11 = false;
                if (v7.l(iB, this.f4264o.b())) {
                    zS = v7Var.s(this.f4264o);
                    if (v7Var.x() && !this.f4264o.x()) {
                        z11 = true;
                    }
                    v7Var = v7Var.o(this.f4264o);
                    this.f4264o = v7Var;
                    z12 = z11;
                    z11 = true;
                } else {
                    zS = false;
                    z12 = false;
                }
                v7Var2 = v7Var;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z11) {
            l().K().b("Ignoring lower-priority consent settings, proposed settings", v7Var2);
            return;
        }
        long andIncrement = this.f4265p.getAndIncrement();
        if (zS) {
            Z0(null);
            g9 g9Var = new g9(this, v7Var2, andIncrement, z12);
            if (z10) {
                n();
                g9Var.run();
                return;
            } else {
                a().H(g9Var);
                return;
            }
        }
        f9 f9Var = new f9(this, v7Var2, andIncrement, z12);
        if (z10) {
            n();
            f9Var.run();
        } else if (iB != 30 && iB != -10) {
            a().E(f9Var);
        } else {
            a().H(f9Var);
        }
    }

    public final void V0(b2.m0 m0Var) {
        z();
        m1.g.k(m0Var);
        if (!this.f4254e.remove(m0Var)) {
            l().M().a("OnEventListener had not been registered");
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    public final void b1(String str, String str2, Bundle bundle) {
        q0(str, str2, bundle, true, true, c().a());
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    public final void c1(boolean z10) {
        if (StubApp.getOrigApplicationContext(b().getApplicationContext()) instanceof Application) {
            Application application = (Application) StubApp.getOrigApplicationContext(b().getApplicationContext());
            if (this.f4252c == null) {
                this.f4252c = new h9(this);
            }
            if (z10) {
                application.unregisterActivityLifecycleCallbacks(this.f4252c);
                application.registerActivityLifecycleCallbacks(this.f4252c);
                l().L().a("Registered activity lifecycle callback");
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    @WorkerThread
    final void d1(long j10) {
        n();
        if (this.f4261l == null) {
            this.f4261l = new g8(this, this.f3965a);
        }
        this.f4261l.b(j10);
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

    public final void h0(Boolean bool) {
        z();
        a().E(new e9(this, bool));
    }

    @WorkerThread
    final void h1(String str, String str2, Bundle bundle) {
        n();
        l0(str, str2, c().a(), bundle);
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    public final void i1(boolean z10) {
        z();
        a().E(new j8(this, z10));
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    final void j0(Runnable runnable) {
        if (!d().u(g0.R0)) {
            return;
        }
        z();
        if (a().L()) {
            l().H().a("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        if (a().K()) {
            l().H().a("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        if (e.a()) {
            l().H().a("Cannot retrieve and upload batches from main thread");
            return;
        }
        l().L().a("[sgtm] Started client-side batch upload work.");
        boolean z10 = false;
        int size = 0;
        int i10 = 0;
        while (!z10) {
            l().L().a("[sgtm] Getting upload batches from service (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            a().w(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: b2.w0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f734a.v().Y(atomicReference, zzpb.J(c1.SGTM_CLIENT));
                }
            });
            zzpd zzpdVar = (zzpd) atomicReference.get();
            if (zzpdVar == null || zzpdVar.f4314a.isEmpty()) {
                break;
            }
            l().L().b("[sgtm] Retrieved upload batches. count", Integer.valueOf(zzpdVar.f4314a.size()));
            size += zzpdVar.f4314a.size();
            Iterator<zzoz> it = zzpdVar.f4314a.iterator();
            while (it.hasNext()) {
                b2.d1 d1VarH = H(it.next());
                if (d1VarH == b2.d1.SUCCESS) {
                    i10++;
                } else if (d1VarH == b2.d1.BACKOFF) {
                    z10 = true;
                    break;
                }
            }
        }
        l().L().c("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(size), Integer.valueOf(i10));
        runnable.run();
    }

    public final void j1(long j10) {
        a().E(new l8(this, j10));
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @WorkerThread
    final void l0(String str, String str2, long j10, Bundle bundle) {
        boolean z10;
        n();
        if (this.f4253d != null && !wc.I0(str2)) {
            z10 = false;
        } else {
            z10 = true;
        }
        m0(str, str2, j10, bundle, true, z10, true, null);
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

    public final void o0(String str, String str2, Bundle bundle) {
        long jA = c().a();
        m1.g.e(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jA);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        a().E(new w8(this, bundle2));
    }

    public final void p0(String str, String str2, Bundle bundle, String str3) {
        m();
        a1(str, str2, c().a(), bundle, false, true, true, str3);
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ h5 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ j5 r() {
        return super.r();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    @WorkerThread
    final void r0(String str, String str2, Object obj, long j10) {
        long j11;
        m1.g.e(str);
        m1.g.e(str2);
        n();
        z();
        if ("allow_personalized_ads".equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "false";
                    if ("false".equals(str3.toLowerCase(Locale.ENGLISH))) {
                        j11 = 1;
                    } else {
                        j11 = 0;
                    }
                    Long lValueOf = Long.valueOf(j11);
                    d6 d6Var = h().f3380o;
                    if (lValueOf.longValue() == 1) {
                        str4 = "true";
                    }
                    d6Var.b(str4);
                    obj = lValueOf;
                } else if (obj == null) {
                    h().f3380o.b("unset");
                }
                str2 = "_npa";
            } else if (obj == null) {
                h().f3380o.b("unset");
                str2 = "_npa";
            }
            l().L().c("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str5 = str2;
        Object obj2 = obj;
        if (!this.f3965a.s()) {
            l().L().a("User property not set since app measurement is disabled");
        } else {
            if (!this.f3965a.v()) {
                return;
            }
            v().U(new zzpy(str5, j10, obj2, str));
        }
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ z7 s() {
        return super.s();
    }

    public final void s0(String str, String str2, Object obj, boolean z10) {
        t0(str, str2, obj, z10, c().a());
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ o9 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ s9 u() {
        return super.u();
    }

    @WorkerThread
    public final zzan u0() {
        n();
        return v().c0();
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
