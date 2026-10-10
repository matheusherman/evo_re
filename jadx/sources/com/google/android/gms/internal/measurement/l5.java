package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class l5 extends ea<l5, a> implements qb {
    private static final l5 zzc;
    private static volatile xb<l5> zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<l5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(l5.zzc);
        }

        public final a A(boolean z10) {
            s();
            l5.T((l5) this.f2633b, z10);
            return this;
        }

        public final a C(boolean z10) {
            s();
            l5.W((l5) this.f2633b, z10);
            return this;
        }

        public final a D(boolean z10) {
            s();
            l5.Y((l5) this.f2633b, z10);
            return this;
        }

        public final a v(boolean z10) {
            s();
            l5.L((l5) this.f2633b, z10);
            return this;
        }

        public final a x(boolean z10) {
            s();
            l5.N((l5) this.f2633b, z10);
            return this;
        }

        public final a y(boolean z10) {
            s();
            l5.Q((l5) this.f2633b, z10);
            return this;
        }

        public final a z(boolean z10) {
            s();
            l5.R((l5) this.f2633b, z10);
            return this;
        }
    }

    static {
        l5 l5Var = new l5();
        zzc = l5Var;
        ea.v(l5.class, l5Var);
    }

    public static a K() {
        return zzc.A();
    }

    static /* synthetic */ void L(l5 l5Var, boolean z10) {
        l5Var.zze |= 32;
        l5Var.zzk = z10;
    }

    static /* synthetic */ void N(l5 l5Var, boolean z10) {
        l5Var.zze |= 16;
        l5Var.zzj = z10;
    }

    public static l5 O() {
        return zzc;
    }

    static /* synthetic */ void Q(l5 l5Var, boolean z10) {
        l5Var.zze |= 1;
        l5Var.zzf = z10;
    }

    static /* synthetic */ void R(l5 l5Var, boolean z10) {
        l5Var.zze |= 64;
        l5Var.zzl = z10;
    }

    static /* synthetic */ void T(l5 l5Var, boolean z10) {
        l5Var.zze |= 2;
        l5Var.zzg = z10;
    }

    static /* synthetic */ void W(l5 l5Var, boolean z10) {
        l5Var.zze |= 4;
        l5Var.zzh = z10;
    }

    static /* synthetic */ void Y(l5 l5Var, boolean z10) {
        l5Var.zze |= 8;
        l5Var.zzi = z10;
    }

    public final boolean S() {
        return this.zzk;
    }

    public final boolean U() {
        return this.zzj;
    }

    public final boolean X() {
        return this.zzf;
    }

    public final boolean Z() {
        return this.zzl;
    }

    public final boolean a0() {
        return this.zzg;
    }

    public final boolean b0() {
        return this.zzh;
    }

    public final boolean c0() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new l5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
            case 4:
                return zzc;
            case 5:
                xb<l5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (l5.class) {
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

    private l5() {
    }
}
