package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class j5 extends ea<j5, a> implements qb {
    private static final j5 zzc;
    private static volatile xb<j5> zzd;
    private int zze;
    private long zzi;
    private long zzm;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<j5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(j5.zzc);
        }

        public final long v() {
            return ((j5) this.f2633b).K();
        }

        public final long z() {
            return ((j5) this.f2633b).O();
        }

        public final a A(long j10) {
            s();
            j5.R((j5) this.f2633b, j10);
            return this;
        }

        public final a C(String str) {
            s();
            j5.S((j5) this.f2633b, str);
            return this;
        }

        public final a D() {
            s();
            j5.L((j5) this.f2633b);
            return this;
        }

        public final a E(String str) {
            s();
            j5.W((j5) this.f2633b, str);
            return this;
        }

        public final a F() {
            s();
            j5.Q((j5) this.f2633b);
            return this;
        }

        public final a G(String str) {
            s();
            j5.Z((j5) this.f2633b, str);
            return this;
        }

        public final a H() {
            s();
            j5.U((j5) this.f2633b);
            return this;
        }

        public final a I(String str) {
            s();
            j5.c0((j5) this.f2633b, str);
            return this;
        }

        public final a K() {
            s();
            j5.Y((j5) this.f2633b);
            return this;
        }

        public final a L(String str) {
            s();
            j5.f0((j5) this.f2633b, str);
            return this;
        }

        public final a N() {
            s();
            j5.b0((j5) this.f2633b);
            return this;
        }

        public final a O() {
            s();
            j5.e0((j5) this.f2633b);
            return this;
        }

        public final a x(long j10) {
            s();
            j5.M((j5) this.f2633b, j10);
            return this;
        }

        public final a y(String str) {
            s();
            j5.N((j5) this.f2633b, str);
            return this;
        }
    }

    static {
        j5 j5Var = new j5();
        zzc = j5Var;
        ea.v(j5.class, j5Var);
    }

    static /* synthetic */ void L(j5 j5Var) {
        j5Var.zze &= -5;
        j5Var.zzh = zzc.zzh;
    }

    static /* synthetic */ void M(j5 j5Var, long j10) {
        j5Var.zze |= 8;
        j5Var.zzi = j10;
    }

    static /* synthetic */ void Q(j5 j5Var) {
        j5Var.zze &= -3;
        j5Var.zzg = zzc.zzg;
    }

    static /* synthetic */ void R(j5 j5Var, long j10) {
        j5Var.zze |= 128;
        j5Var.zzm = j10;
    }

    public static a T() {
        return zzc.A();
    }

    static /* synthetic */ void U(j5 j5Var) {
        j5Var.zze &= -2;
        j5Var.zzf = zzc.zzf;
    }

    static /* synthetic */ void Y(j5 j5Var) {
        j5Var.zze &= -65;
        j5Var.zzl = zzc.zzl;
    }

    public static j5 a0() {
        return zzc;
    }

    static /* synthetic */ void b0(j5 j5Var) {
        j5Var.zze &= -33;
        j5Var.zzk = zzc.zzk;
    }

    static /* synthetic */ void e0(j5 j5Var) {
        j5Var.zze &= -17;
        j5Var.zzj = zzc.zzj;
    }

    public final long K() {
        return this.zzi;
    }

    public final long O() {
        return this.zzm;
    }

    public final String d0() {
        return this.zzh;
    }

    public final String g0() {
        return this.zzg;
    }

    public final String h0() {
        return this.zzf;
    }

    public final String i0() {
        return this.zzl;
    }

    public final String j0() {
        return this.zzk;
    }

    public final String k0() {
        return this.zzj;
    }

    public final boolean l0() {
        return (this.zze & 4) != 0;
    }

    public final boolean m0() {
        return (this.zze & 2) != 0;
    }

    public final boolean n0() {
        return (this.zze & 1) != 0;
    }

    public final boolean o0() {
        return (this.zze & 8) != 0;
    }

    public final boolean p0() {
        return (this.zze & 128) != 0;
    }

    public final boolean q0() {
        return (this.zze & 64) != 0;
    }

    public final boolean r0() {
        return (this.zze & 32) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new j5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
            case 4:
                return zzc;
            case 5:
                xb<j5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (j5.class) {
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

    public final boolean s0() {
        return (this.zze & 16) != 0;
    }

    private j5() {
    }

    static /* synthetic */ void N(j5 j5Var, String str) {
        str.getClass();
        j5Var.zze |= 4;
        j5Var.zzh = str;
    }

    static /* synthetic */ void S(j5 j5Var, String str) {
        str.getClass();
        j5Var.zze |= 2;
        j5Var.zzg = str;
    }

    static /* synthetic */ void W(j5 j5Var, String str) {
        str.getClass();
        j5Var.zze |= 1;
        j5Var.zzf = str;
    }

    static /* synthetic */ void Z(j5 j5Var, String str) {
        str.getClass();
        j5Var.zze |= 64;
        j5Var.zzl = str;
    }

    static /* synthetic */ void c0(j5 j5Var, String str) {
        str.getClass();
        j5Var.zze |= 32;
        j5Var.zzk = str;
    }

    static /* synthetic */ void f0(j5 j5Var, String str) {
        str.getClass();
        j5Var.zze |= 16;
        j5Var.zzj = str;
    }
}
