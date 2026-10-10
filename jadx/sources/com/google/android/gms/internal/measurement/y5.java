package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class y5 extends ea<y5, a> implements qb {
    private static final y5 zzc;
    private static volatile xb<y5> zzd;
    private int zze;
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private float zzj;
    private double zzk;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<y5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(y5.zzc);
        }

        public final a A() {
            s();
            y5.R((y5) this.f2633b);
            return this;
        }

        public final a C(long j10) {
            s();
            y5.S((y5) this.f2633b, j10);
            return this;
        }

        public final a D(String str) {
            s();
            y5.T((y5) this.f2633b, str);
            return this;
        }

        public final a E() {
            s();
            y5.W((y5) this.f2633b);
            return this;
        }

        public final a v() {
            s();
            y5.L((y5) this.f2633b);
            return this;
        }

        public final a x(double d10) {
            s();
            y5.M((y5) this.f2633b, d10);
            return this;
        }

        public final a y(long j10) {
            s();
            y5.N((y5) this.f2633b, j10);
            return this;
        }

        public final a z(String str) {
            s();
            y5.O((y5) this.f2633b, str);
            return this;
        }
    }

    static {
        y5 y5Var = new y5();
        zzc = y5Var;
        ea.v(y5.class, y5Var);
    }

    static /* synthetic */ void L(y5 y5Var) {
        y5Var.zze &= -33;
        y5Var.zzk = 0.0d;
    }

    static /* synthetic */ void M(y5 y5Var, double d10) {
        y5Var.zze |= 32;
        y5Var.zzk = d10;
    }

    static /* synthetic */ void N(y5 y5Var, long j10) {
        y5Var.zze |= 8;
        y5Var.zzi = j10;
    }

    static /* synthetic */ void R(y5 y5Var) {
        y5Var.zze &= -9;
        y5Var.zzi = 0L;
    }

    static /* synthetic */ void S(y5 y5Var, long j10) {
        y5Var.zze |= 1;
        y5Var.zzf = j10;
    }

    static /* synthetic */ void W(y5 y5Var) {
        y5Var.zze &= -5;
        y5Var.zzh = zzc.zzh;
    }

    public static a Y() {
        return zzc.A();
    }

    public final double K() {
        return this.zzk;
    }

    public final float Q() {
        return this.zzj;
    }

    public final long U() {
        return this.zzi;
    }

    public final long X() {
        return this.zzf;
    }

    public final String a0() {
        return this.zzg;
    }

    public final String b0() {
        return this.zzh;
    }

    public final boolean c0() {
        return (this.zze & 32) != 0;
    }

    public final boolean d0() {
        return (this.zze & 16) != 0;
    }

    public final boolean e0() {
        return (this.zze & 8) != 0;
    }

    public final boolean f0() {
        return (this.zze & 1) != 0;
    }

    public final boolean g0() {
        return (this.zze & 4) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new y5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                xb<y5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (y5.class) {
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

    private y5() {
    }

    static /* synthetic */ void O(y5 y5Var, String str) {
        str.getClass();
        y5Var.zze |= 2;
        y5Var.zzg = str;
    }

    static /* synthetic */ void T(y5 y5Var, String str) {
        str.getClass();
        y5Var.zze |= 4;
        y5Var.zzh = str;
    }
}
