package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class n4 extends ea<n4, a> implements qb {
    private static final n4 zzc;
    private static volatile xb<n4> zzd;
    private int zze;
    private q4 zzf;
    private o4 zzg;
    private boolean zzh;
    private String zzi = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<n4, a> implements qb {
        /* synthetic */ a(d5 d5Var) {
            this();
        }

        private a() {
            super(n4.zzc);
        }

        public final a v(String str) {
            s();
            n4.L((n4) this.f2633b, str);
            return this;
        }
    }

    static {
        n4 n4Var = new n4();
        zzc = n4Var;
        ea.v(n4.class, n4Var);
    }

    public static n4 M() {
        return zzc;
    }

    public final o4 N() {
        o4 o4Var = this.zzg;
        return o4Var == null ? o4.M() : o4Var;
    }

    public final q4 O() {
        q4 q4Var = this.zzf;
        return q4Var == null ? q4.M() : q4Var;
    }

    public final String Q() {
        return this.zzi;
    }

    public final boolean R() {
        return this.zzh;
    }

    public final boolean S() {
        return (this.zze & 4) != 0;
    }

    public final boolean T() {
        return (this.zze & 2) != 0;
    }

    public final boolean U() {
        return (this.zze & 8) != 0;
    }

    public final boolean W() {
        return (this.zze & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        d5 d5Var = null;
        switch (k4.f2801a[i10 - 1]) {
            case 1:
                return new n4();
            case 2:
                return new a(d5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                xb<n4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (n4.class) {
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

    private n4() {
    }

    static /* synthetic */ void L(n4 n4Var, String str) {
        str.getClass();
        n4Var.zze |= 8;
        n4Var.zzi = str;
    }
}
