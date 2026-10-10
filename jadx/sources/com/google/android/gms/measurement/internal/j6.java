package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.internal.measurement.lg;
import com.google.android.gms.internal.measurement.pg;
import com.google.android.gms.internal.measurement.rg;
import com.google.android.gms.measurement.internal.j6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class j6 extends bc implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, Map<String, String>> f3729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private final Map<String, Set<String>> f3730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private final Map<String, Map<String, Boolean>> f3731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    private final Map<String, Map<String, Boolean>> f3732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, com.google.android.gms.internal.measurement.w4> f3733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f3734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @VisibleForTesting
    final LruCache<String, com.google.android.gms.internal.measurement.c0> f3735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final pg f3736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map<String, String> f3737l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Map<String, String> f3738m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map<String, String> f3739n;

    @Override // com.google.android.gms.measurement.internal.bc
    protected final boolean y() {
        return false;
    }

    public static /* synthetic */ com.google.android.gms.internal.measurement.n B(j6 j6Var) {
        return new lg(j6Var.f3736k);
    }

    @WorkerThread
    private final com.google.android.gms.internal.measurement.w4 D(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.w4.U();
        }
        try {
            com.google.android.gms.internal.measurement.w4 w4Var = (com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) ((com.google.android.gms.internal.measurement.w4.a) sc.H(com.google.android.gms.internal.measurement.w4.S(), bArr)).w());
            l().L().c("Parsed config. version, gmp_app_id", w4Var.g0() ? Long.valueOf(w4Var.Q()) : null, w4Var.e0() ? w4Var.X() : null);
            return w4Var;
        } catch (com.google.android.gms.internal.measurement.ma e10) {
            l().M().c("Unable to merge remote config. appId", p5.w(str), e10);
            return com.google.android.gms.internal.measurement.w4.U();
        } catch (RuntimeException e11) {
            l().M().c("Unable to merge remote config. appId", p5.w(str), e11);
            return com.google.android.gms.internal.measurement.w4.U();
        }
    }

    private static v7.a E(com.google.android.gms.internal.measurement.t4.e eVar) {
        int i10 = o6.f3857b[eVar.ordinal()];
        if (i10 == 1) {
            return v7.a.AD_STORAGE;
        }
        if (i10 == 2) {
            return v7.a.ANALYTICS_STORAGE;
        }
        if (i10 == 3) {
            return v7.a.AD_USER_DATA;
        }
        if (i10 != 4) {
            return null;
        }
        return v7.a.AD_PERSONALIZATION;
    }

    private static Map<String, String> F(com.google.android.gms.internal.measurement.w4 w4Var) {
        ArrayMap arrayMap = new ArrayMap();
        if (w4Var != null) {
            for (com.google.android.gms.internal.measurement.a5 a5Var : w4Var.c0()) {
                arrayMap.put(a5Var.L(), a5Var.M());
            }
        }
        return arrayMap;
    }

    private final void G(String str, com.google.android.gms.internal.measurement.w4.a aVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (aVar != null) {
            Iterator<com.google.android.gms.internal.measurement.u4> it = aVar.E().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().L());
            }
            for (int i10 = 0; i10 < aVar.v(); i10++) {
                com.google.android.gms.internal.measurement.v4.a aVarC = aVar.x(i10).C();
                if (aVarC.y().isEmpty()) {
                    l().M().a("EventConfig contained null event name");
                } else {
                    String strY = aVarC.y();
                    String strB = b2.j0.b(aVarC.y());
                    if (!TextUtils.isEmpty(strB)) {
                        aVarC = aVarC.x(strB);
                        aVar.y(i10, aVarC);
                    }
                    if (aVarC.C() && aVarC.z()) {
                        arrayMap.put(strY, Boolean.TRUE);
                    }
                    if (aVarC.D() && aVarC.A()) {
                        arrayMap2.put(aVarC.y(), Boolean.TRUE);
                    }
                    if (aVarC.E()) {
                        if (aVarC.v() < 2 || aVarC.v() > 65535) {
                            l().M().c("Invalid sampling rate. Event name, sample rate", aVarC.y(), Integer.valueOf(aVarC.v()));
                        } else {
                            arrayMap3.put(aVarC.y(), Integer.valueOf(aVarC.v()));
                        }
                    }
                }
            }
        }
        this.f3730e.put(str, hashSet);
        this.f3731f.put(str, arrayMap);
        this.f3732g.put(str, arrayMap2);
        this.f3734i.put(str, arrayMap3);
    }

    final boolean a0(String str) {
        return "1".equals(p(str, "measurement.upload.blacklist_internal"));
    }

    final boolean c0(String str) {
        return "1".equals(p(str, "measurement.upload.blacklist_public"));
    }

    @WorkerThread
    final long z(String str) {
        String strP = p(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strP)) {
            return 0L;
        }
        try {
            return Long.parseLong(strP);
        } catch (NumberFormatException e10) {
            l().M().c("Unable to parse timezone offset. appId", p5.w(str), e10);
            return 0L;
        }
    }

    j6(gc gcVar) {
        super(gcVar);
        this.f3729d = new ArrayMap();
        this.f3730e = new ArrayMap();
        this.f3731f = new ArrayMap();
        this.f3732g = new ArrayMap();
        this.f3733h = new ArrayMap();
        this.f3737l = new ArrayMap();
        this.f3738m = new ArrayMap();
        this.f3739n = new ArrayMap();
        this.f3734i = new ArrayMap();
        this.f3735j = new k6(this, 20);
        this.f3736k = new n6(this);
    }

    static /* synthetic */ com.google.android.gms.internal.measurement.c0 C(j6 j6Var, String str) {
        j6Var.v();
        m1.g.e(str);
        if (!j6Var.Z(str)) {
            return null;
        }
        if (j6Var.f3733h.containsKey(str) && j6Var.f3733h.get(str) != null) {
            j6Var.H(str, j6Var.f3733h.get(str));
        } else {
            j6Var.j0(str);
        }
        return j6Var.f3735j.snapshot().get(str);
    }

    @WorkerThread
    private final void H(final String str, com.google.android.gms.internal.measurement.w4 w4Var) {
        if (w4Var.n() == 0) {
            this.f3735j.remove(str);
            return;
        }
        l().L().b("EES programs found", Integer.valueOf(w4Var.n()));
        com.google.android.gms.internal.measurement.i6 i6Var = w4Var.b0().get(0);
        try {
            com.google.android.gms.internal.measurement.c0 c0Var = new com.google.android.gms.internal.measurement.c0();
            c0Var.d("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.i6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.wb("internal.remoteConfig", new m6(this.f3704a, str));
                }
            });
            c0Var.d("internal.appMetadata", new Callable() { // from class: b2.x
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final j6 j6Var = this.f736a;
                    final String str2 = str;
                    return new rg("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.l6
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            j6 j6Var2 = j6Var;
                            String str3 = str2;
                            x4 x4VarV0 = j6Var2.r().V0(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            map.put("gmp_version", 118003L);
                            if (x4VarV0 != null) {
                                String strO = x4VarV0.o();
                                if (strO != null) {
                                    map.put("app_version", strO);
                                }
                                map.put("app_version_int", Long.valueOf(x4VarV0.V()));
                                map.put("dynamite_version", Long.valueOf(x4VarV0.w0()));
                            }
                            return map;
                        }
                    });
                }
            });
            c0Var.d("internal.logger", new Callable() { // from class: b2.w
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return j6.B(this.f733a);
                }
            });
            c0Var.c(i6Var);
            this.f3735j.put(str, c0Var);
            l().L().c("EES program loaded for appId, activities", str, Integer.valueOf(i6Var.K().n()));
            Iterator<com.google.android.gms.internal.measurement.h6> it = i6Var.K().M().iterator();
            while (it.hasNext()) {
                l().L().b("EES program activity", it.next().L());
            }
        } catch (com.google.android.gms.internal.measurement.d1 unused) {
            l().H().b("Failed to load EES program. appId", str);
        }
    }

    static /* synthetic */ com.google.android.gms.internal.measurement.c0 K(j6 j6Var, String str) {
        j6Var.v();
        m1.g.e(str);
        n nVarW0 = j6Var.r().W0(str);
        if (nVarW0 == null) {
            return null;
        }
        j6Var.l().L().b("Populate EES config from database on cache miss. appId", str);
        j6Var.H(str, j6Var.D(str, nVarW0.f3827a));
        return j6Var.f3735j.snapshot().get(str);
    }

    @WorkerThread
    private final void j0(String str) {
        v();
        n();
        m1.g.e(str);
        if (this.f3733h.get(str) == null) {
            n nVarW0 = r().W0(str);
            if (nVarW0 == null) {
                this.f3729d.put(str, null);
                this.f3731f.put(str, null);
                this.f3730e.put(str, null);
                this.f3732g.put(str, null);
                this.f3733h.put(str, null);
                this.f3737l.put(str, null);
                this.f3738m.put(str, null);
                this.f3739n.put(str, null);
                this.f3734i.put(str, null);
                return;
            }
            com.google.android.gms.internal.measurement.w4.a aVarC = D(str, nVarW0.f3827a).C();
            G(str, aVarC);
            this.f3729d.put(str, F((com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) aVarC.w())));
            this.f3733h.put(str, (com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) aVarC.w()));
            H(str, (com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) aVarC.w()));
            this.f3737l.put(str, aVarC.C());
            this.f3738m.put(str, nVarW0.f3828b);
            this.f3739n.put(str, nVarW0.f3829c);
        }
    }

    @WorkerThread
    final b2.g0 A(String str, v7.a aVar) {
        n();
        j0(str);
        com.google.android.gms.internal.measurement.t4 t4VarL = L(str);
        if (t4VarL == null) {
            return b2.g0.UNINITIALIZED;
        }
        for (com.google.android.gms.internal.measurement.t4.a aVar2 : t4VarL.Q()) {
            if (E(aVar2.M()) == aVar) {
                int i10 = o6.f3858c[aVar2.L().ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        return b2.g0.UNINITIALIZED;
                    }
                    return b2.g0.GRANTED;
                }
                return b2.g0.DENIED;
            }
        }
        return b2.g0.UNINITIALIZED;
    }

    @WorkerThread
    protected final boolean I(String str, byte[] bArr, String str2, String str3) {
        v();
        n();
        m1.g.e(str);
        com.google.android.gms.internal.measurement.w4.a aVarC = D(str, bArr).C();
        if (aVarC == null) {
            return false;
        }
        G(str, aVarC);
        H(str, (com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) aVarC.w()));
        this.f3733h.put(str, (com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) aVarC.w()));
        this.f3737l.put(str, aVarC.C());
        this.f3738m.put(str, str2);
        this.f3739n.put(str, str3);
        this.f3729d.put(str, F((com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) aVarC.w())));
        r().h0(str, new ArrayList(aVarC.D()));
        try {
            aVarC.z();
            bArr = ((com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) aVarC.w())).m();
        } catch (RuntimeException e10) {
            l().M().c("Unable to serialize reduced-size config. Storing full config instead. appId", p5.w(str), e10);
        }
        m mVarR = r();
        m1.g.e(str);
        mVarR.n();
        mVarR.v();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (mVarR.C().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                mVarR.l().H().b("Failed to update remote config (got 0). appId", p5.w(str));
            }
        } catch (SQLiteException e11) {
            mVarR.l().H().c("Error storing remote config. appId", p5.w(str), e11);
        }
        if (d().u(g0.f3591o1)) {
            aVarC.A();
        }
        this.f3733h.put(str, (com.google.android.gms.internal.measurement.w4) ((com.google.android.gms.internal.measurement.ea) aVarC.w()));
        return true;
    }

    @WorkerThread
    final int J(String str, String str2) {
        Integer num;
        n();
        j0(str);
        Map<String, Integer> map = this.f3734i.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @WorkerThread
    final com.google.android.gms.internal.measurement.t4 L(String str) {
        n();
        j0(str);
        com.google.android.gms.internal.measurement.w4 w4VarO = O(str);
        if (w4VarO != null && w4VarO.d0()) {
            return w4VarO.R();
        }
        return null;
    }

    @WorkerThread
    final v7.a M(String str, v7.a aVar) {
        n();
        j0(str);
        com.google.android.gms.internal.measurement.t4 t4VarL = L(str);
        if (t4VarL == null) {
            return null;
        }
        for (com.google.android.gms.internal.measurement.t4.c cVar : t4VarL.O()) {
            if (aVar == E(cVar.M())) {
                return E(cVar.L());
            }
        }
        return null;
    }

    @WorkerThread
    protected final com.google.android.gms.internal.measurement.w4 O(String str) {
        v();
        n();
        m1.g.e(str);
        j0(str);
        return this.f3733h.get(str);
    }

    @WorkerThread
    final boolean P(String str, v7.a aVar) {
        n();
        j0(str);
        com.google.android.gms.internal.measurement.t4 t4VarL = L(str);
        if (t4VarL == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.t4.a aVar2 : t4VarL.N()) {
            if (aVar == E(aVar2.M())) {
                if (aVar2.L() == com.google.android.gms.internal.measurement.t4.d.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    @WorkerThread
    final boolean Q(String str, String str2) {
        Boolean bool;
        n();
        j0(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f3732g.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    protected final String R(String str) {
        n();
        return this.f3739n.get(str);
    }

    @WorkerThread
    final boolean S(String str, String str2) {
        Boolean bool;
        n();
        j0(str);
        if (a0(str) && wc.I0(str2)) {
            return true;
        }
        if (c0(str) && wc.K0(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f3731f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    protected final String T(String str) {
        n();
        return this.f3738m.get(str);
    }

    @WorkerThread
    final String U(String str) {
        n();
        j0(str);
        return this.f3737l.get(str);
    }

    @WorkerThread
    final Set<String> V(String str) {
        n();
        j0(str);
        return this.f3730e.get(str);
    }

    @WorkerThread
    final SortedSet<String> W(String str) {
        n();
        j0(str);
        TreeSet treeSet = new TreeSet();
        com.google.android.gms.internal.measurement.t4 t4VarL = L(str);
        if (t4VarL != null) {
            Iterator<com.google.android.gms.internal.measurement.t4.f> it = t4VarL.M().iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().L());
            }
        }
        return treeSet;
    }

    @WorkerThread
    protected final void X(String str) {
        n();
        this.f3738m.put(str, null);
    }

    @WorkerThread
    final void Y(String str) {
        n();
        this.f3733h.remove(str);
    }

    public final boolean Z(String str) {
        com.google.android.gms.internal.measurement.w4 w4Var;
        if (TextUtils.isEmpty(str) || (w4Var = this.f3733h.get(str)) == null || w4Var.n() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    @WorkerThread
    final boolean b0(String str) {
        n();
        j0(str);
        com.google.android.gms.internal.measurement.t4 t4VarL = L(str);
        if (t4VarL == null || !t4VarL.S() || t4VarL.R()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    @WorkerThread
    final boolean d0(String str) {
        n();
        j0(str);
        if (this.f3730e.get(str) != null && this.f3730e.get(str).contains("app_instance_id")) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ e e() {
        return super.e();
    }

    @WorkerThread
    final boolean e0(String str) {
        n();
        j0(str);
        if (this.f3730e.get(str) != null) {
            if (this.f3730e.get(str).contains("device_model") || this.f3730e.get(str).contains("device_info")) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a0 f() {
        return super.f();
    }

    @WorkerThread
    final boolean f0(String str) {
        n();
        j0(str);
        if (this.f3730e.get(str) != null && this.f3730e.get(str).contains("enhanced_user_id")) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ k5 g() {
        return super.g();
    }

    @WorkerThread
    final boolean g0(String str) {
        n();
        j0(str);
        if (this.f3730e.get(str) != null && this.f3730e.get(str).contains("google_signals")) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a6 h() {
        return super.h();
    }

    @WorkerThread
    final boolean h0(String str) {
        n();
        j0(str);
        if (this.f3730e.get(str) != null) {
            if (this.f3730e.get(str).contains("os_version") || this.f3730e.get(str).contains("device_info")) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    @WorkerThread
    final boolean i0(String str) {
        n();
        j0(str);
        if (this.f3730e.get(str) != null && this.f3730e.get(str).contains("user_id")) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ sc o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.k
    @WorkerThread
    public final String p(String str, String str2) {
        n();
        j0(str);
        Map<String, String> map = this.f3729d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ zc q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ m r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ j6 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ eb t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ ec u() {
        return super.u();
    }
}
