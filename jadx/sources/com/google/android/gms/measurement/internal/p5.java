package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class p5 extends u7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private char f3886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private String f3888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final r5 f3889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final r5 f3890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final r5 f3891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r5 f3892i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final r5 f3893j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final r5 f3894k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final r5 f3895l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final r5 f3896m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final r5 f3897n;

    @VisibleForTesting
    private final String Q() {
        String str;
        synchronized (this) {
            try {
                if (this.f3888e == null) {
                    this.f3888e = this.f3965a.S() != null ? this.f3965a.S() : "FA";
                }
                m1.g.k(this.f3888e);
                str = this.f3888e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    protected final void A(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z10 && D(i10)) {
            z(i10, y(false, str, obj, obj2, obj3));
        }
        if (z11 || i10 < 5) {
            return;
        }
        m1.g.k(str);
        p6 p6VarI = this.f3965a.I();
        if (p6VarI == null) {
            z(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!p6VarI.t()) {
                z(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i10 < 0) {
                i10 = 0;
            }
            p6VarI.E(new o5(this, i10 >= 9 ? 8 : i10, str, obj, obj2, obj3));
        }
    }

    @Override // com.google.android.gms.measurement.internal.u7
    protected final boolean u() {
        return false;
    }

    protected static Object w(String str) {
        if (str == null) {
            return null;
        }
        return new q5(str);
    }

    @VisibleForTesting
    private static String x(boolean z10, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z10) {
                return String.valueOf(obj);
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l10.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof q5) {
                return ((q5) obj).f3932a;
            }
            return z10 ? "-" : String.valueOf(obj);
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z10 ? th.getClass().getName() : th.toString());
        String strF = F(s6.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && F(className).equals(strF)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
        }
        return sb2.toString();
    }

    static String y(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strX = x(z10, obj);
        String strX2 = x(z10, obj2);
        String strX3 = x(z10, obj3);
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strX)) {
            sb2.append(str2);
            sb2.append(strX);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strX2)) {
            str3 = str2;
        } else {
            sb2.append(str2);
            sb2.append(strX2);
        }
        if (!TextUtils.isEmpty(strX3)) {
            sb2.append(str3);
            sb2.append(strX3);
        }
        return sb2.toString();
    }

    public final r5 G() {
        return this.f3896m;
    }

    public final r5 H() {
        return this.f3889f;
    }

    public final r5 I() {
        return this.f3891h;
    }

    public final r5 J() {
        return this.f3890g;
    }

    public final r5 K() {
        return this.f3895l;
    }

    public final r5 L() {
        return this.f3897n;
    }

    public final r5 M() {
        return this.f3892i;
    }

    public final r5 N() {
        return this.f3894k;
    }

    public final r5 O() {
        return this.f3893j;
    }

    p5(s6 s6Var) {
        super(s6Var);
        this.f3886c = (char) 0;
        this.f3887d = -1L;
        this.f3889f = new r5(this, 6, false, false);
        this.f3890g = new r5(this, 6, true, false);
        this.f3891h = new r5(this, 6, false, true);
        this.f3892i = new r5(this, 5, false, false);
        this.f3893j = new r5(this, 5, true, false);
        this.f3894k = new r5(this, 5, false, true);
        this.f3895l = new r5(this, 4, false, false);
        this.f3896m = new r5(this, 3, false, false);
        this.f3897n = new r5(this, 2, false, false);
    }

    @VisibleForTesting
    private static String F(String str) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(46)) == -1) {
            return "";
        }
        return str.substring(0, iLastIndexOf);
    }

    protected final boolean D(int i10) {
        return Log.isLoggable(Q(), i10);
    }

    public final String P() {
        Pair<String, Long> pairA;
        if (h().f3371f == null || (pairA = h().f3371f.a()) == null || pairA == a6.B) {
            return null;
        }
        return String.valueOf(pairA.second) + ":" + ((String) pairA.first);
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

    @VisibleForTesting
    protected final void z(int i10, String str) {
        Log.println(i10, Q(), str);
    }
}
