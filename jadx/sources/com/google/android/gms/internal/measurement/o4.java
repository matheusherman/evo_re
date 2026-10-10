package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class o4 extends ea<o4, a> implements qb {
    private static final o4 zzc;
    private static volatile xb<o4> zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<o4, a> implements qb {
        /* synthetic */ a(d5 d5Var) {
            this();
        }

        private a() {
            super(o4.zzc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum b implements ja {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);

        private final int zzg;

        public static b a(int i10) {
            if (i10 == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i10 == 1) {
                return LESS_THAN;
            }
            if (i10 == 2) {
                return GREATER_THAN;
            }
            if (i10 == 3) {
                return EQUAL;
            }
            if (i10 != 4) {
                return null;
            }
            return BETWEEN;
        }

        public static ia f() {
            return r4.f2980a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zzg;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        b(int i10) {
            this.zzg = i10;
        }
    }

    static {
        o4 o4Var = new o4();
        zzc = o4Var;
        ea.v(o4.class, o4Var);
    }

    public static o4 M() {
        return zzc;
    }

    public final b K() {
        b bVarA = b.a(this.zzf);
        return bVarA == null ? b.UNKNOWN_COMPARISON_TYPE : bVarA;
    }

    public final String N() {
        return this.zzh;
    }

    public final String O() {
        return this.zzj;
    }

    public final String Q() {
        return this.zzi;
    }

    public final boolean R() {
        return this.zzg;
    }

    public final boolean S() {
        return (this.zze & 1) != 0;
    }

    public final boolean T() {
        return (this.zze & 4) != 0;
    }

    public final boolean U() {
        return (this.zze & 2) != 0;
    }

    public final boolean W() {
        return (this.zze & 16) != 0;
    }

    public final boolean X() {
        return (this.zze & 8) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        d5 d5Var = null;
        switch (k4.f2801a[i10 - 1]) {
            case 1:
                return new o4();
            case 2:
                return new a(d5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", b.f(), "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                xb<o4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (o4.class) {
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

    private o4() {
    }
}
