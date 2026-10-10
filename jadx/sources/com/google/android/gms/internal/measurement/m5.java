package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class m5 extends ea<m5, a> implements qb {
    private static final m5 zzc;
    private static volatile xb<m5> zzd;
    private int zze;
    private int zzf;
    private v5 zzg;
    private v5 zzh;
    private boolean zzi;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<m5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(m5.zzc);
        }

        public final a v(int i10) {
            s();
            m5.K((m5) this.f2633b, i10);
            return this;
        }

        public final a x(v5.a aVar) {
            s();
            m5.L((m5) this.f2633b, (v5) ((ea) aVar.w()));
            return this;
        }

        public final a y(v5 v5Var) {
            s();
            m5.O((m5) this.f2633b, v5Var);
            return this;
        }

        public final a z(boolean z10) {
            s();
            m5.M((m5) this.f2633b, z10);
            return this;
        }
    }

    static {
        m5 m5Var = new m5();
        zzc = m5Var;
        ea.v(m5.class, m5Var);
    }

    static /* synthetic */ void K(m5 m5Var, int i10) {
        m5Var.zze |= 1;
        m5Var.zzf = i10;
    }

    static /* synthetic */ void M(m5 m5Var, boolean z10) {
        m5Var.zze |= 8;
        m5Var.zzi = z10;
    }

    public static a N() {
        return zzc.A();
    }

    public final v5 R() {
        v5 v5Var = this.zzg;
        return v5Var == null ? v5.Z() : v5Var;
    }

    public final v5 S() {
        v5 v5Var = this.zzh;
        return v5Var == null ? v5.Z() : v5Var;
    }

    public final boolean T() {
        return this.zzi;
    }

    public final boolean U() {
        return (this.zze & 1) != 0;
    }

    public final boolean W() {
        return (this.zze & 8) != 0;
    }

    public final boolean X() {
        return (this.zze & 4) != 0;
    }

    public final int n() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new m5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                xb<m5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (m5.class) {
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

    private m5() {
    }

    static /* synthetic */ void L(m5 m5Var, v5 v5Var) {
        v5Var.getClass();
        m5Var.zzg = v5Var;
        m5Var.zze |= 2;
    }

    static /* synthetic */ void O(m5 m5Var, v5 v5Var) {
        v5Var.getClass();
        m5Var.zzh = v5Var;
        m5Var.zze |= 4;
    }
}
