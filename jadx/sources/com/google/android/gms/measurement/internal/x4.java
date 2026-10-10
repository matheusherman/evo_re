package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class x4 {

    @Nullable
    private Long A;

    @Nullable
    private Long B;
    private long C;

    @Nullable
    private String D;
    private int E;
    private int F;
    private long G;
    private String H;

    @Nullable
    private byte[] I;
    private int J;
    private long K;
    private long L;
    private long M;
    private long N;
    private long O;
    private long P;

    @Nullable
    private String Q;
    private boolean R;
    private long S;
    private long T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s6 f4166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f4168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private String f4169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f4170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f4171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f4172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f4173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f4174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private String f4175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f4176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private String f4177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f4178m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f4179n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f4180o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4181p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private String f4182q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private Boolean f4183r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f4184s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private List<String> f4185t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private String f4186u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f4187v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f4188w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f4189x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4190y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f4191z;

    @WorkerThread
    public final boolean A() {
        this.f4166a.a().n();
        return this.f4180o;
    }

    @WorkerThread
    public final long A0() {
        this.f4166a.a().n();
        return this.f4178m;
    }

    @WorkerThread
    public final boolean B() {
        this.f4166a.a().n();
        return this.R;
    }

    @WorkerThread
    public final void B0(long j10) {
        m1.g.a(j10 >= 0);
        this.f4166a.a().n();
        this.R |= this.f4172g != j10;
        this.f4172g = j10;
    }

    @WorkerThread
    public final boolean C() {
        this.f4166a.a().n();
        return this.f4187v;
    }

    @WorkerThread
    public final long C0() {
        this.f4166a.a().n();
        return this.G;
    }

    @WorkerThread
    public final boolean D() {
        this.f4166a.a().n();
        return this.f4191z;
    }

    @WorkerThread
    public final void D0(long j10) {
        this.f4166a.a().n();
        this.R |= this.f4173h != j10;
        this.f4173h = j10;
    }

    @Nullable
    @WorkerThread
    public final byte[] E() {
        this.f4166a.a().n();
        return this.I;
    }

    @WorkerThread
    public final long E0() {
        this.f4166a.a().n();
        return this.f4174i;
    }

    @WorkerThread
    public final int F() {
        this.f4166a.a().n();
        return this.J;
    }

    @WorkerThread
    public final void F0(long j10) {
        this.f4166a.a().n();
        this.R |= this.f4189x != j10;
        this.f4189x = j10;
    }

    @WorkerThread
    public final void G(int i10) {
        this.f4166a.a().n();
        this.R |= this.J != i10;
        this.J = i10;
    }

    @WorkerThread
    public final long G0() {
        this.f4166a.a().n();
        return this.f4172g;
    }

    @WorkerThread
    public final void H(long j10) {
        this.f4166a.a().n();
        this.R |= this.f4176k != j10;
        this.f4176k = j10;
    }

    @WorkerThread
    public final void H0(long j10) {
        this.f4166a.a().n();
        this.R |= this.f4188w != j10;
        this.f4188w = j10;
    }

    @WorkerThread
    public final void I(@Nullable Long l10) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.B, l10);
        this.B = l10;
    }

    @WorkerThread
    public final long I0() {
        this.f4166a.a().n();
        return this.f4173h;
    }

    @WorkerThread
    public final void J(@Nullable String str) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.f4168c, str);
        this.f4168c = str;
    }

    @WorkerThread
    public final long J0() {
        this.f4166a.a().n();
        return this.f4189x;
    }

    @WorkerThread
    public final void K(boolean z10) {
        this.f4166a.a().n();
        this.R |= this.f4180o != z10;
        this.f4180o = z10;
    }

    @WorkerThread
    public final long K0() {
        this.f4166a.a().n();
        return this.f4188w;
    }

    @WorkerThread
    public final int L() {
        this.f4166a.a().n();
        return this.F;
    }

    @Nullable
    @WorkerThread
    public final Boolean L0() {
        this.f4166a.a().n();
        return this.f4183r;
    }

    @WorkerThread
    public final void M(int i10) {
        this.f4166a.a().n();
        this.R |= this.F != i10;
        this.F = i10;
    }

    @Nullable
    @WorkerThread
    public final Long M0() {
        this.f4166a.a().n();
        return this.A;
    }

    @WorkerThread
    public final void N(long j10) {
        this.f4166a.a().n();
        this.R |= this.C != j10;
        this.C = j10;
    }

    @Nullable
    @WorkerThread
    public final Long N0() {
        this.f4166a.a().n();
        return this.B;
    }

    @WorkerThread
    public final void O(@Nullable String str) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.f4177l, str);
        this.f4177l = str;
    }

    @WorkerThread
    public final void P(boolean z10) {
        this.f4166a.a().n();
        this.R |= this.f4187v != z10;
        this.f4187v = z10;
    }

    @WorkerThread
    public final int Q() {
        this.f4166a.a().n();
        return this.E;
    }

    @WorkerThread
    public final void R(int i10) {
        this.f4166a.a().n();
        this.R |= this.E != i10;
        this.E = i10;
    }

    @WorkerThread
    public final void S(long j10) {
        this.f4166a.a().n();
        this.R |= this.S != j10;
        this.S = j10;
    }

    @WorkerThread
    public final void T(@Nullable String str) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.f4175j, str);
        this.f4175j = str;
    }

    @WorkerThread
    public final void U(boolean z10) {
        this.f4166a.a().n();
        this.R |= this.f4191z != z10;
        this.f4191z = z10;
    }

    @WorkerThread
    public final long V() {
        this.f4166a.a().n();
        return this.f4176k;
    }

    @WorkerThread
    public final void W(long j10) {
        this.f4166a.a().n();
        this.R |= this.N != j10;
        this.N = j10;
    }

    @WorkerThread
    public final void X(@Nullable String str) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.f4171f, str);
        this.f4171f = str;
    }

    @WorkerThread
    public final long Y() {
        this.f4166a.a().n();
        return this.C;
    }

    @WorkerThread
    public final void Z(long j10) {
        this.f4166a.a().n();
        this.R |= this.O != j10;
        this.O = j10;
    }

    @WorkerThread
    public final int a() {
        this.f4166a.a().n();
        return this.f4190y;
    }

    @WorkerThread
    public final void a0(@Nullable String str) {
        this.f4166a.a().n();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.R |= !Objects.equals(this.f4169d, str);
        this.f4169d = str;
    }

    @WorkerThread
    public final void b(int i10) {
        this.f4166a.a().n();
        this.R |= this.f4190y != i10;
        this.f4190y = i10;
    }

    @WorkerThread
    public final long b0() {
        this.f4166a.a().n();
        return this.S;
    }

    @WorkerThread
    public final void c(long j10) {
        this.f4166a.a().n();
        long j11 = this.f4172g + j10;
        if (j11 > 2147483647L) {
            this.f4166a.l().M().b("Bundle index overflow. appId", p5.w(this.f4167b));
            j11 = j10 - 1;
        }
        long j12 = this.G + 1;
        if (j12 > 2147483647L) {
            this.f4166a.l().M().b("Delivery index overflow. appId", p5.w(this.f4167b));
            j12 = 0;
        }
        this.R = true;
        this.f4172g = j11;
        this.G = j12;
    }

    @WorkerThread
    public final void c0(long j10) {
        this.f4166a.a().n();
        this.R |= this.M != j10;
        this.M = j10;
    }

    @WorkerThread
    public final void d(@Nullable Boolean bool) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.f4183r, bool);
        this.f4183r = bool;
    }

    @WorkerThread
    public final void d0(@Nullable String str) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.Q, str);
        this.Q = str;
    }

    @WorkerThread
    public final void e(@Nullable Long l10) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.A, l10);
        this.A = l10;
    }

    @WorkerThread
    public final long e0() {
        this.f4166a.a().n();
        return this.N;
    }

    @WorkerThread
    public final void f(@Nullable String str) {
        this.f4166a.a().n();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.R |= !Objects.equals(this.f4182q, str);
        this.f4182q = str;
    }

    @WorkerThread
    public final void f0(long j10) {
        this.f4166a.a().n();
        this.R |= this.L != j10;
        this.L = j10;
    }

    @WorkerThread
    public final void g(@Nullable List<String> list) {
        this.f4166a.a().n();
        if (Objects.equals(this.f4185t, list)) {
            return;
        }
        this.R = true;
        this.f4185t = list != null ? new ArrayList(list) : null;
    }

    @WorkerThread
    public final void g0(@Nullable String str) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.f4170e, str);
        this.f4170e = str;
    }

    @WorkerThread
    public final void h(boolean z10) {
        this.f4166a.a().n();
        this.R |= this.f4181p != z10;
        this.f4181p = z10;
    }

    @WorkerThread
    public final long h0() {
        this.f4166a.a().n();
        return this.O;
    }

    @WorkerThread
    public final void i(@Nullable byte[] bArr) {
        this.f4166a.a().n();
        this.R |= this.I != bArr;
        this.I = bArr;
    }

    @WorkerThread
    public final void i0(long j10) {
        this.f4166a.a().n();
        this.R |= this.P != j10;
        this.P = j10;
    }

    @Nullable
    @WorkerThread
    public final String j() {
        this.f4166a.a().n();
        return this.f4182q;
    }

    @WorkerThread
    public final void j0(String str) {
        this.f4166a.a().n();
        this.R |= this.H != str;
        this.H = str;
    }

    @Nullable
    @WorkerThread
    public final String k() {
        this.f4166a.a().n();
        String str = this.Q;
        d0(null);
        return str;
    }

    @WorkerThread
    public final long k0() {
        this.f4166a.a().n();
        return this.M;
    }

    @WorkerThread
    public final String l() {
        this.f4166a.a().n();
        return this.f4167b;
    }

    @WorkerThread
    public final void l0(long j10) {
        this.f4166a.a().n();
        this.R |= this.K != j10;
        this.K = j10;
    }

    @Nullable
    @WorkerThread
    public final String m() {
        this.f4166a.a().n();
        return this.f4168c;
    }

    @WorkerThread
    public final void m0(@Nullable String str) {
        this.f4166a.a().n();
        this.R |= !Objects.equals(this.f4186u, str);
        this.f4186u = str;
    }

    @Nullable
    @WorkerThread
    public final String n() {
        this.f4166a.a().n();
        return this.f4177l;
    }

    @WorkerThread
    public final long n0() {
        this.f4166a.a().n();
        return this.L;
    }

    @Nullable
    @WorkerThread
    public final String o() {
        this.f4166a.a().n();
        return this.f4175j;
    }

    @WorkerThread
    public final void o0(long j10) {
        this.f4166a.a().n();
        this.R |= this.f4179n != j10;
        this.f4179n = j10;
    }

    @Nullable
    @WorkerThread
    public final String p() {
        this.f4166a.a().n();
        return this.f4171f;
    }

    @WorkerThread
    public final void p0(@Nullable String str) {
        this.f4166a.a().n();
        this.R |= this.D != str;
        this.D = str;
    }

    @Nullable
    @WorkerThread
    public final String q() {
        this.f4166a.a().n();
        return this.f4169d;
    }

    @WorkerThread
    public final long q0() {
        this.f4166a.a().n();
        return this.P;
    }

    @Nullable
    @WorkerThread
    public final String r() {
        this.f4166a.a().n();
        return this.Q;
    }

    @WorkerThread
    public final void r0(long j10) {
        this.f4166a.a().n();
        this.R |= this.f4184s != j10;
        this.f4184s = j10;
    }

    @Nullable
    @WorkerThread
    public final String s() {
        this.f4166a.a().n();
        return this.f4170e;
    }

    @WorkerThread
    public final long s0() {
        this.f4166a.a().n();
        return this.K;
    }

    @WorkerThread
    public final String t() {
        this.f4166a.a().n();
        return this.H;
    }

    @WorkerThread
    public final void t0(long j10) {
        this.f4166a.a().n();
        this.R |= this.T != j10;
        this.T = j10;
    }

    @Nullable
    @WorkerThread
    public final String u() {
        this.f4166a.a().n();
        return this.f4186u;
    }

    @WorkerThread
    public final long u0() {
        this.f4166a.a().n();
        return this.f4179n;
    }

    @Nullable
    @WorkerThread
    public final String v() {
        this.f4166a.a().n();
        return this.D;
    }

    @WorkerThread
    public final void v0(long j10) {
        this.f4166a.a().n();
        this.R |= this.f4178m != j10;
        this.f4178m = j10;
    }

    @Nullable
    @WorkerThread
    public final List<String> w() {
        this.f4166a.a().n();
        return this.f4185t;
    }

    @WorkerThread
    public final long w0() {
        this.f4166a.a().n();
        return this.f4184s;
    }

    @WorkerThread
    public final void x() {
        this.f4166a.a().n();
        this.R = false;
    }

    @WorkerThread
    public final void x0(long j10) {
        this.f4166a.a().n();
        this.R |= this.G != j10;
        this.G = j10;
    }

    @WorkerThread
    public final void y() {
        this.f4166a.a().n();
        long j10 = this.f4172g + 1;
        if (j10 > 2147483647L) {
            this.f4166a.l().M().b("Bundle index overflow. appId", p5.w(this.f4167b));
            j10 = 0;
        }
        this.R = true;
        this.f4172g = j10;
    }

    @WorkerThread
    public final long y0() {
        this.f4166a.a().n();
        return this.T;
    }

    @WorkerThread
    public final boolean z() {
        this.f4166a.a().n();
        return this.f4181p;
    }

    @WorkerThread
    public final void z0(long j10) {
        this.f4166a.a().n();
        this.R |= this.f4174i != j10;
        this.f4174i = j10;
    }

    @WorkerThread
    x4(s6 s6Var, String str) {
        m1.g.k(s6Var);
        m1.g.e(str);
        this.f4166a = s6Var;
        this.f4167b = str;
        s6Var.a().n();
    }
}
