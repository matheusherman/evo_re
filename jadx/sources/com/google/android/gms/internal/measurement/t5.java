package com.google.android.gms.internal.measurement;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t5 extends ea<t5, a> implements qb {
    private static final t5 zzc;
    private static volatile xb<t5> zzd;
    private long zzab;
    private int zzac;
    private boolean zzaf;
    private int zzai;
    private int zzaj;
    private int zzak;
    private long zzam;
    private long zzan;
    private int zzaq;
    private u5 zzas;
    private long zzau;
    private long zzav;
    private int zzay;
    private boolean zzaz;
    private boolean zzbb;
    private r5 zzbc;
    private long zzbg;
    private boolean zzbh;
    private boolean zzbj;
    private int zzbl;
    private l5 zzbn;
    private int zzbo;
    private j5 zzbp;
    private x5 zzbr;
    private long zzbs;
    private int zze;
    private int zzf;
    private int zzg;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private int zzs;
    private long zzw;
    private long zzx;
    private boolean zzz;
    private na<o5> zzh = ea.G();
    private na<y5> zzi = ea.G();
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private String zzy = "";
    private String zzaa = "";
    private String zzad = "";
    private String zzae = "";
    private na<m5> zzag = ea.G();
    private String zzah = "";
    private String zzal = "";
    private String zzao = "";
    private String zzap = "";
    private String zzar = "";
    private la zzat = ea.E();
    private String zzaw = "";
    private String zzax = "";
    private String zzba = "";
    private String zzbd = "";
    private na<String> zzbe = ea.G();
    private String zzbf = "";
    private String zzbi = "";
    private String zzbk = "";
    private String zzbm = "";
    private String zzbq = "";
    private String zzbt = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<t5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(t5.zzc);
        }

        public final String Q() {
            return ((t5) this.f2633b).q0();
        }

        public final List<o5> R() {
            return Collections.unmodifiableList(((t5) this.f2633b).u0());
        }

        public final y5 S0(int i10) {
            return ((t5) this.f2633b).C0(i10);
        }

        public final List<y5> T() {
            return Collections.unmodifiableList(((t5) this.f2633b).v0());
        }

        public final boolean U() {
            return ((t5) this.f2633b).x0();
        }

        public final boolean W() {
            return ((t5) this.f2633b).y0();
        }

        public final boolean X() {
            return ((t5) this.f2633b).A0();
        }

        public final int Y() {
            return ((t5) this.f2633b).B0();
        }

        public final int e0() {
            return ((t5) this.f2633b).B1();
        }

        public final int k0() {
            return ((t5) this.f2633b).W1();
        }

        public final String n1() {
            return ((t5) this.f2633b).c0();
        }

        public final String o1() {
            return ((t5) this.f2633b).d0();
        }

        public final String p1() {
            return ((t5) this.f2633b).g0();
        }

        public final long q0() {
            return ((t5) this.f2633b).r2();
        }

        public final String q1() {
            return ((t5) this.f2633b).i0();
        }

        public final String r1() {
            return ((t5) this.f2633b).m0();
        }

        public final String s1() {
            return ((t5) this.f2633b).o0();
        }

        public final int v() {
            return ((t5) this.f2633b).n();
        }

        public final long v0() {
            return ((t5) this.f2633b).A2();
        }

        public final o5 x(int i10) {
            return ((t5) this.f2633b).K(i10);
        }

        public final j5 z0() {
            return ((t5) this.f2633b).H2();
        }

        public final a A(int i10, y5 y5Var) {
            s();
            t5.O((t5) this.f2633b, i10, y5Var);
            return this;
        }

        public final a A0(int i10) {
            s();
            t5.J1((t5) this.f2633b, i10);
            return this;
        }

        public final a B0(long j10) {
            s();
            t5.P1((t5) this.f2633b, j10);
            return this;
        }

        public final a C(long j10) {
            s();
            t5.Q((t5) this.f2633b, j10);
            return this;
        }

        public final a C0(String str) {
            s();
            t5.Q1((t5) this.f2633b, str);
            return this;
        }

        public final a D(j5 j5Var) {
            s();
            t5.R((t5) this.f2633b, j5Var);
            return this;
        }

        public final a D0() {
            s();
            t5.D0((t5) this.f2633b);
            return this;
        }

        public final a E(l5 l5Var) {
            s();
            t5.S((t5) this.f2633b, l5Var);
            return this;
        }

        public final a E0(int i10) {
            s();
            t5.O1((t5) this.f2633b, 1);
            return this;
        }

        public final a F(o5.a aVar) {
            s();
            t5.T((t5) this.f2633b, (o5) ((ea) aVar.w()));
            return this;
        }

        public final a F0(long j10) {
            s();
            t5.U1((t5) this.f2633b, j10);
            return this;
        }

        public final a G(u5.a aVar) {
            s();
            t5.U((t5) this.f2633b, (u5) ((ea) aVar.w()));
            return this;
        }

        public final a G0(String str) {
            s();
            t5.V1((t5) this.f2633b, str);
            return this;
        }

        public final a H(x5 x5Var) {
            s();
            t5.W((t5) this.f2633b, x5Var);
            return this;
        }

        public final a H0() {
            s();
            t5.k1((t5) this.f2633b);
            return this;
        }

        public final a I(y5.a aVar) {
            s();
            t5.X((t5) this.f2633b, (y5) ((ea) aVar.w()));
            return this;
        }

        public final a I0(int i10) {
            s();
            t5.T1((t5) this.f2633b, i10);
            return this;
        }

        public final a J0(long j10) {
            s();
            t5.Z1((t5) this.f2633b, j10);
            return this;
        }

        public final a K(y5 y5Var) {
            s();
            t5.X((t5) this.f2633b, y5Var);
            return this;
        }

        public final a K0(String str) {
            s();
            t5.a2((t5) this.f2633b, str);
            return this;
        }

        public final a L(Iterable<? extends m5> iterable) {
            s();
            t5.Y((t5) this.f2633b, iterable);
            return this;
        }

        public final a L0() {
            s();
            t5.v1((t5) this.f2633b);
            return this;
        }

        public final a M0(int i10) {
            s();
            t5.Y1((t5) this.f2633b, i10);
            return this;
        }

        public final a N(String str) {
            s();
            t5.Z((t5) this.f2633b, str);
            return this;
        }

        public final a N0(long j10) {
            s();
            t5.d2((t5) this.f2633b, j10);
            return this;
        }

        public final a O(boolean z10) {
            s();
            t5.a0((t5) this.f2633b, z10);
            return this;
        }

        public final a O0(String str) {
            s();
            t5.e2((t5) this.f2633b, str);
            return this;
        }

        public final a P0() {
            s();
            t5.C1((t5) this.f2633b);
            return this;
        }

        public final a Q0(long j10) {
            s();
            t5.h2((t5) this.f2633b, j10);
            return this;
        }

        public final a R0(String str) {
            s();
            t5.i2((t5) this.f2633b, str);
            return this;
        }

        public final a T0() {
            s();
            t5.I1((t5) this.f2633b);
            return this;
        }

        public final a U0(long j10) {
            s();
            t5.l2((t5) this.f2633b, j10);
            return this;
        }

        public final a V0(String str) {
            s();
            t5.m2((t5) this.f2633b, str);
            return this;
        }

        public final a W0() {
            s();
            t5.N1((t5) this.f2633b);
            return this;
        }

        public final a X0(long j10) {
            s();
            t5.p2((t5) this.f2633b, j10);
            return this;
        }

        public final a Y0(String str) {
            s();
            t5.q2((t5) this.f2633b, str);
            return this;
        }

        public final a Z(int i10) {
            s();
            t5.M((t5) this.f2633b, i10);
            return this;
        }

        public final a Z0() {
            s();
            t5.S1((t5) this.f2633b);
            return this;
        }

        public final a a0(long j10) {
            s();
            t5.F0((t5) this.f2633b, j10);
            return this;
        }

        public final a a1(String str) {
            s();
            t5.t2((t5) this.f2633b, str);
            return this;
        }

        public final a b0(Iterable<? extends o5> iterable) {
            s();
            t5.G0((t5) this.f2633b, iterable);
            return this;
        }

        public final a b1() {
            s();
            t5.X1((t5) this.f2633b);
            return this;
        }

        public final a c0(String str) {
            s();
            t5.H0((t5) this.f2633b, str);
            return this;
        }

        public final a c1(String str) {
            s();
            t5.v2((t5) this.f2633b, str);
            return this;
        }

        public final a d0(boolean z10) {
            s();
            t5.I0((t5) this.f2633b, z10);
            return this;
        }

        public final a d1() {
            s();
            t5.c2((t5) this.f2633b);
            return this;
        }

        public final a e1(String str) {
            s();
            t5.x2((t5) this.f2633b, str);
            return this;
        }

        public final a f0(int i10) {
            s();
            t5.E0((t5) this.f2633b, i10);
            return this;
        }

        public final a f1() {
            s();
            t5.g2((t5) this.f2633b);
            return this;
        }

        public final a g0(long j10) {
            s();
            t5.m1((t5) this.f2633b, j10);
            return this;
        }

        public final a g1(String str) {
            s();
            t5.z2((t5) this.f2633b, str);
            return this;
        }

        public final a h0(Iterable<? extends Integer> iterable) {
            s();
            t5.n1((t5) this.f2633b, iterable);
            return this;
        }

        public final a h1() {
            s();
            t5.k2((t5) this.f2633b);
            return this;
        }

        public final a i0(String str) {
            s();
            t5.o1((t5) this.f2633b, str);
            return this;
        }

        public final a i1(String str) {
            s();
            t5.B2((t5) this.f2633b, str);
            return this;
        }

        public final a j0(boolean z10) {
            s();
            t5.p1((t5) this.f2633b, z10);
            return this;
        }

        public final a j1() {
            s();
            t5.o2((t5) this.f2633b);
            return this;
        }

        public final a k1(String str) {
            s();
            t5.D2((t5) this.f2633b, str);
            return this;
        }

        public final a l0(int i10) {
            s();
            t5.l1((t5) this.f2633b, i10);
            return this;
        }

        public final a l1() {
            s();
            t5.s2((t5) this.f2633b);
            return this;
        }

        public final a m0(long j10) {
            s();
            t5.x1((t5) this.f2633b, j10);
            return this;
        }

        public final a m1(String str) {
            s();
            t5.F2((t5) this.f2633b, str);
            return this;
        }

        public final a n0(Iterable<String> iterable) {
            s();
            t5.y1((t5) this.f2633b, iterable);
            return this;
        }

        public final a o0(String str) {
            s();
            t5.z1((t5) this.f2633b, str);
            return this;
        }

        public final a p0(boolean z10) {
            s();
            t5.A1((t5) this.f2633b, z10);
            return this;
        }

        public final a r0(int i10) {
            s();
            t5.w1((t5) this.f2633b, i10);
            return this;
        }

        public final a s0(long j10) {
            s();
            t5.E1((t5) this.f2633b, j10);
            return this;
        }

        public final a t0(Iterable<? extends y5> iterable) {
            s();
            t5.F1((t5) this.f2633b, iterable);
            return this;
        }

        public final a u0(String str) {
            s();
            t5.G1((t5) this.f2633b, str);
            return this;
        }

        public final a w0(int i10) {
            s();
            t5.D1((t5) this.f2633b, i10);
            return this;
        }

        public final a x0(long j10) {
            s();
            t5.K1((t5) this.f2633b, j10);
            return this;
        }

        public final a y(int i10, o5.a aVar) {
            s();
            t5.N((t5) this.f2633b, i10, (o5) ((ea) aVar.w()));
            return this;
        }

        public final a y0(String str) {
            s();
            t5.L1((t5) this.f2633b, str);
            return this;
        }

        public final a z(int i10, o5 o5Var) {
            s();
            t5.N((t5) this.f2633b, i10, o5Var);
            return this;
        }
    }

    static {
        t5 t5Var = new t5();
        zzc = t5Var;
        ea.v(t5.class, t5Var);
    }

    static /* synthetic */ void A1(t5 t5Var, boolean z10) {
        t5Var.zze |= 8388608;
        t5Var.zzaf = z10;
    }

    static /* synthetic */ void C1(t5 t5Var) {
        t5Var.zze &= Integer.MAX_VALUE;
        t5Var.zzao = zzc.zzao;
    }

    static /* synthetic */ void D0(t5 t5Var) {
        t5Var.zze &= -262145;
        t5Var.zzaa = zzc.zzaa;
    }

    static /* synthetic */ void D1(t5 t5Var, int i10) {
        t5Var.zze |= 1048576;
        t5Var.zzac = i10;
    }

    static /* synthetic */ void E1(t5 t5Var, long j10) {
        t5Var.zzf |= 16;
        t5Var.zzau = j10;
    }

    static /* synthetic */ void F0(t5 t5Var, long j10) {
        t5Var.zzf |= 32;
        t5Var.zzav = j10;
    }

    static /* synthetic */ void I0(t5 t5Var, boolean z10) {
        t5Var.zzf |= 262144;
        t5Var.zzbj = z10;
    }

    static /* synthetic */ void J1(t5 t5Var, int i10) {
        t5Var.zzf |= 8388608;
        t5Var.zzbo = i10;
    }

    public static a J2() {
        return zzc.A();
    }

    static /* synthetic */ void K1(t5 t5Var, long j10) {
        t5Var.zze |= 8;
        t5Var.zzl = j10;
    }

    public static a L(t5 t5Var) {
        return zzc.o(t5Var);
    }

    static /* synthetic */ void N1(t5 t5Var) {
        t5Var.zze &= -2097153;
        t5Var.zzad = zzc.zzad;
    }

    static /* synthetic */ void O1(t5 t5Var, int i10) {
        t5Var.zze |= 1;
        t5Var.zzg = 1;
    }

    static /* synthetic */ void P1(t5 t5Var, long j10) {
        t5Var.zze |= 16384;
        t5Var.zzw = j10;
    }

    static /* synthetic */ void Q(t5 t5Var, long j10) {
        t5Var.zzf |= 134217728;
        t5Var.zzbs = j10;
    }

    static /* synthetic */ void S1(t5 t5Var) {
        t5Var.zze &= -131073;
        t5Var.zzz = false;
    }

    static /* synthetic */ void T1(t5 t5Var, int i10) {
        t5Var.zzf |= 2;
        t5Var.zzaq = i10;
    }

    static /* synthetic */ void U1(t5 t5Var, long j10) {
        t5Var.zze |= 32;
        t5Var.zzn = j10;
    }

    static /* synthetic */ void X1(t5 t5Var) {
        t5Var.zze &= -33;
        t5Var.zzn = 0L;
    }

    static /* synthetic */ void Y(t5 t5Var, Iterable iterable) {
        na<m5> naVar = t5Var.zzag;
        if (!naVar.d()) {
            t5Var.zzag = ea.r(naVar);
        }
        n8.j(iterable, t5Var.zzag);
    }

    static /* synthetic */ void Y1(t5 t5Var, int i10) {
        t5Var.zze |= 1024;
        t5Var.zzs = i10;
    }

    static /* synthetic */ void Z1(t5 t5Var, long j10) {
        t5Var.zze |= 16;
        t5Var.zzm = j10;
    }

    static /* synthetic */ void a0(t5 t5Var, boolean z10) {
        t5Var.zzf |= 65536;
        t5Var.zzbh = z10;
    }

    static /* synthetic */ void c2(t5 t5Var) {
        t5Var.zze &= -17;
        t5Var.zzm = 0L;
    }

    static /* synthetic */ void d2(t5 t5Var, long j10) {
        t5Var.zze |= 4;
        t5Var.zzk = j10;
    }

    static /* synthetic */ void g2(t5 t5Var) {
        t5Var.zze &= -65537;
        t5Var.zzy = zzc.zzy;
    }

    static /* synthetic */ void h2(t5 t5Var, long j10) {
        t5Var.zzf |= 32768;
        t5Var.zzbg = j10;
    }

    static /* synthetic */ void k2(t5 t5Var) {
        t5Var.zzf &= -8193;
        t5Var.zzbd = zzc.zzbd;
    }

    static /* synthetic */ void l1(t5 t5Var, int i10) {
        t5Var.zzf |= 1048576;
        t5Var.zzbl = i10;
    }

    static /* synthetic */ void l2(t5 t5Var, long j10) {
        t5Var.zze |= 2;
        t5Var.zzj = j10;
    }

    static /* synthetic */ void m1(t5 t5Var, long j10) {
        t5Var.zze |= 536870912;
        t5Var.zzam = j10;
    }

    static /* synthetic */ void n1(t5 t5Var, Iterable iterable) {
        la laVar = t5Var.zzat;
        if (!laVar.d()) {
            t5Var.zzat = laVar.a(laVar.size() << 1);
        }
        n8.j(iterable, t5Var.zzat);
    }

    static /* synthetic */ void o2(t5 t5Var) {
        t5Var.zze &= -268435457;
        t5Var.zzal = zzc.zzal;
    }

    static /* synthetic */ void p1(t5 t5Var, boolean z10) {
        t5Var.zze |= 131072;
        t5Var.zzz = z10;
    }

    static /* synthetic */ void p2(t5 t5Var, long j10) {
        t5Var.zze |= 32768;
        t5Var.zzx = j10;
    }

    private final void s1() {
        na<o5> naVar = this.zzh;
        if (naVar.d()) {
            return;
        }
        this.zzh = ea.r(naVar);
    }

    static /* synthetic */ void s2(t5 t5Var) {
        t5Var.zze &= -3;
        t5Var.zzj = 0L;
    }

    private final void t1() {
        na<y5> naVar = this.zzi;
        if (naVar.d()) {
            return;
        }
        this.zzi = ea.r(naVar);
    }

    static /* synthetic */ void v1(t5 t5Var) {
        t5Var.zze &= -257;
        t5Var.zzq = zzc.zzq;
    }

    static /* synthetic */ void w1(t5 t5Var, int i10) {
        t5Var.zze |= 33554432;
        t5Var.zzai = i10;
    }

    static /* synthetic */ void x1(t5 t5Var, long j10) {
        t5Var.zze |= 524288;
        t5Var.zzab = j10;
    }

    static /* synthetic */ void y1(t5 t5Var, Iterable iterable) {
        na<String> naVar = t5Var.zzbe;
        if (!naVar.d()) {
            t5Var.zzbe = ea.r(naVar);
        }
        n8.j(iterable, t5Var.zzbe);
    }

    public final boolean A0() {
        return (this.zzf & 16777216) != 0;
    }

    public final long A2() {
        return this.zzk;
    }

    public final int B0() {
        return this.zzai;
    }

    public final int B1() {
        return this.zzh.size();
    }

    public final y5 C0(int i10) {
        return this.zzi.get(i10);
    }

    public final long C2() {
        return this.zzbg;
    }

    public final long E2() {
        return this.zzj;
    }

    public final long G2() {
        return this.zzx;
    }

    public final int H1() {
        return this.zzg;
    }

    public final j5 H2() {
        j5 j5Var = this.zzbp;
        return j5Var == null ? j5.a0() : j5Var;
    }

    public final l5 I2() {
        l5 l5Var = this.zzbn;
        return l5Var == null ? l5.O() : l5Var;
    }

    public final boolean J0() {
        return (this.zze & 33554432) != 0;
    }

    public final o5 K(int i10) {
        return this.zzh.get(i10);
    }

    public final boolean K0() {
        return (this.zzf & 4194304) != 0;
    }

    public final boolean L0() {
        return (this.zzf & 134217728) != 0;
    }

    public final x5 L2() {
        x5 x5Var = this.zzbr;
        return x5Var == null ? x5.T() : x5Var;
    }

    public final boolean M0() {
        return (this.zze & 1048576) != 0;
    }

    public final int M1() {
        return this.zzaq;
    }

    public final boolean N0() {
        return (this.zze & 536870912) != 0;
    }

    public final boolean O0() {
        return (this.zzf & 131072) != 0;
    }

    public final boolean P0() {
        return (this.zzf & 128) != 0;
    }

    public final boolean Q0() {
        return (this.zzf & 524288) != 0;
    }

    public final boolean R0() {
        return (this.zzf & 8388608) != 0;
    }

    public final int R1() {
        return this.zzs;
    }

    public final boolean S0() {
        return (this.zze & 524288) != 0;
    }

    public final boolean T0() {
        return (this.zze & Integer.MIN_VALUE) != 0;
    }

    public final boolean U0() {
        return (this.zzf & 16) != 0;
    }

    public final boolean V0() {
        return (this.zze & 8) != 0;
    }

    public final boolean W0() {
        return (this.zze & 16384) != 0;
    }

    public final int W1() {
        return this.zzi.size();
    }

    public final boolean X0() {
        return (this.zzf & 262144) != 0;
    }

    public final boolean Y0() {
        return (this.zze & 131072) != 0;
    }

    public final boolean Z0() {
        return (this.zze & 32) != 0;
    }

    public final boolean a1() {
        return (this.zze & 16) != 0;
    }

    public final String b0() {
        return this.zzar;
    }

    public final boolean b1() {
        return (this.zze & 1) != 0;
    }

    public final long b2() {
        return this.zzbs;
    }

    public final String c0() {
        return this.zzu;
    }

    public final boolean c1() {
        return (this.zzf & 2) != 0;
    }

    public final String d0() {
        return this.zzaa;
    }

    public final boolean d1() {
        return (this.zze & 8388608) != 0;
    }

    public final String e0() {
        return this.zzt;
    }

    public final boolean e1() {
        return (this.zzf & 8192) != 0;
    }

    public final String f0() {
        return this.zzv;
    }

    public final boolean f1() {
        return (this.zzf & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0;
    }

    public final long f2() {
        return this.zzam;
    }

    public final String g0() {
        return this.zzbi;
    }

    public final boolean g1() {
        return (this.zze & 4) != 0;
    }

    public final String h0() {
        return this.zzax;
    }

    public final boolean h1() {
        return (this.zzf & 32768) != 0;
    }

    public final String i0() {
        return this.zzbk;
    }

    public final boolean i1() {
        return (this.zze & 1024) != 0;
    }

    public final String j0() {
        return this.zzq;
    }

    public final int j1() {
        return this.zzac;
    }

    public final long j2() {
        return this.zzab;
    }

    public final String k0() {
        return this.zzao;
    }

    public final String l0() {
        return this.zzah;
    }

    public final String m0() {
        return this.zzae;
    }

    public final int n() {
        return this.zzbl;
    }

    public final String n0() {
        return this.zzad;
    }

    public final long n2() {
        return this.zzau;
    }

    public final String o0() {
        return this.zzp;
    }

    public final String p0() {
        return this.zzo;
    }

    public final String q0() {
        return this.zzy;
    }

    public final boolean q1() {
        return (this.zze & 2) != 0;
    }

    public final String r0() {
        return this.zzbd;
    }

    public final boolean r1() {
        return (this.zze & 32768) != 0;
    }

    public final long r2() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new t5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004B\u0000\u0002\u0001SB\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7Oဉ8Pဈ9Qဉ:Rဂ;Sဈ<", new Object[]{"zze", "zzf", "zzg", "zzh", o5.class, "zzi", y5.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzm", "zzaf", "zzag", m5.class, "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", "zzax", "zzay", a6.f(), "zzaz", "zzba", "zzbb", "zzbc", "zzbd", "zzbe", "zzbf", "zzbg", "zzbh", "zzbi", "zzbj", "zzbk", "zzbl", "zzbm", "zzbn", "zzbo", "zzbp", "zzbq", "zzbr", "zzbs", "zzbt"});
            case 4:
                return zzc;
            case 5:
                xb<t5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (t5.class) {
                    try {
                        aVar = zzd;
                        if (aVar == null) {
                            aVar = new ea.a(zzc);
                            zzd = aVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return aVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    public final String s0() {
        return this.zzr;
    }

    public final List<m5> t0() {
        return this.zzag;
    }

    public final List<o5> u0() {
        return this.zzh;
    }

    public final int u1() {
        return this.zzbo;
    }

    public final long u2() {
        return this.zzw;
    }

    public final List<y5> v0() {
        return this.zzi;
    }

    public final boolean w0() {
        return this.zzbh;
    }

    public final long w2() {
        return this.zzn;
    }

    public final boolean x0() {
        return this.zzbj;
    }

    public final boolean y0() {
        return this.zzz;
    }

    public final long y2() {
        return this.zzm;
    }

    public final boolean z0() {
        return this.zzaf;
    }

    private t5() {
    }

    static /* synthetic */ void B2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 65536;
        t5Var.zzy = str;
    }

    static /* synthetic */ void D2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zzf |= 8192;
        t5Var.zzbd = str;
    }

    static /* synthetic */ void E0(t5 t5Var, int i10) {
        t5Var.t1();
        t5Var.zzi.remove(i10);
    }

    static /* synthetic */ void F1(t5 t5Var, Iterable iterable) {
        t5Var.t1();
        n8.j(iterable, t5Var.zzi);
    }

    static /* synthetic */ void F2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 512;
        t5Var.zzr = str;
    }

    static /* synthetic */ void G0(t5 t5Var, Iterable iterable) {
        t5Var.s1();
        n8.j(iterable, t5Var.zzh);
    }

    static /* synthetic */ void G1(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 8192;
        t5Var.zzv = str;
    }

    static /* synthetic */ void H0(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 4096;
        t5Var.zzu = str;
    }

    static /* synthetic */ void I1(t5 t5Var) {
        t5Var.zzh = ea.G();
    }

    static /* synthetic */ void L1(t5 t5Var, String str) {
        str.getClass();
        t5Var.zzf |= 131072;
        t5Var.zzbi = str;
    }

    static /* synthetic */ void M(t5 t5Var, int i10) {
        t5Var.s1();
        t5Var.zzh.remove(i10);
    }

    static /* synthetic */ void N(t5 t5Var, int i10, o5 o5Var) {
        o5Var.getClass();
        t5Var.s1();
        t5Var.zzh.set(i10, o5Var);
    }

    static /* synthetic */ void O(t5 t5Var, int i10, y5 y5Var) {
        y5Var.getClass();
        t5Var.t1();
        t5Var.zzi.set(i10, y5Var);
    }

    static /* synthetic */ void Q1(t5 t5Var, String str) {
        str.getClass();
        t5Var.zzf |= 128;
        t5Var.zzax = str;
    }

    static /* synthetic */ void R(t5 t5Var, j5 j5Var) {
        j5Var.getClass();
        t5Var.zzbp = j5Var;
        t5Var.zzf |= 16777216;
    }

    static /* synthetic */ void S(t5 t5Var, l5 l5Var) {
        l5Var.getClass();
        t5Var.zzbn = l5Var;
        t5Var.zzf |= 4194304;
    }

    static /* synthetic */ void T(t5 t5Var, o5 o5Var) {
        o5Var.getClass();
        t5Var.s1();
        t5Var.zzh.add(o5Var);
    }

    static /* synthetic */ void U(t5 t5Var, u5 u5Var) {
        u5Var.getClass();
        t5Var.zzas = u5Var;
        t5Var.zzf |= 8;
    }

    static /* synthetic */ void V1(t5 t5Var, String str) {
        str.getClass();
        t5Var.zzf |= 524288;
        t5Var.zzbk = str;
    }

    static /* synthetic */ void W(t5 t5Var, x5 x5Var) {
        x5Var.getClass();
        t5Var.zzbr = x5Var;
        t5Var.zzf |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    }

    static /* synthetic */ void X(t5 t5Var, y5 y5Var) {
        y5Var.getClass();
        t5Var.t1();
        t5Var.zzi.add(y5Var);
    }

    static /* synthetic */ void Z(t5 t5Var, String str) {
        str.getClass();
        t5Var.zzf |= 4;
        t5Var.zzar = str;
    }

    static /* synthetic */ void a2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 256;
        t5Var.zzq = str;
    }

    static /* synthetic */ void e2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= Integer.MIN_VALUE;
        t5Var.zzao = str;
    }

    static /* synthetic */ void i2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zzf |= 16384;
        t5Var.zzbf = str;
    }

    static /* synthetic */ void k1(t5 t5Var) {
        t5Var.zzag = ea.G();
    }

    static /* synthetic */ void m2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zzf |= 268435456;
        t5Var.zzbt = str;
    }

    static /* synthetic */ void o1(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 262144;
        t5Var.zzaa = str;
    }

    static /* synthetic */ void q2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 16777216;
        t5Var.zzah = str;
    }

    static /* synthetic */ void t2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 4194304;
        t5Var.zzae = str;
    }

    static /* synthetic */ void v2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 2097152;
        t5Var.zzad = str;
    }

    static /* synthetic */ void x2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 128;
        t5Var.zzp = str;
    }

    static /* synthetic */ void z1(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 2048;
        t5Var.zzt = str;
    }

    static /* synthetic */ void z2(t5 t5Var, String str) {
        str.getClass();
        t5Var.zze |= 64;
        t5Var.zzo = str;
    }
}
