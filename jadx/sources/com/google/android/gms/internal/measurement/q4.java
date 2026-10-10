package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class q4 extends ea<q4, a> implements qb {
    private static final q4 zzc;
    private static volatile xb<q4> zzd;
    private int zze;
    private int zzf;
    private boolean zzh;
    private String zzg = "";
    private na<String> zzi = ea.G();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<q4, a> implements qb {
        /* synthetic */ a(d5 d5Var) {
            this();
        }

        private a() {
            super(q4.zzc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum b implements ja {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);

        private final int zzi;

        public static ia f() {
            return s4.f3026a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zzi;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
        }

        b(int i10) {
            this.zzi = i10;
        }

        public static b a(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }
    }

    static {
        q4 q4Var = new q4();
        zzc = q4Var;
        ea.v(q4.class, q4Var);
    }

    public static q4 M() {
        return zzc;
    }

    public final b K() {
        b bVarA = b.a(this.zzf);
        return bVarA == null ? b.UNKNOWN_MATCH_TYPE : bVarA;
    }

    public final String N() {
        return this.zzg;
    }

    public final List<String> O() {
        return this.zzi;
    }

    public final boolean Q() {
        return this.zzh;
    }

    public final boolean R() {
        return (this.zze & 4) != 0;
    }

    public final boolean S() {
        return (this.zze & 2) != 0;
    }

    public final boolean T() {
        return (this.zze & 1) != 0;
    }

    public final int n() {
        return this.zzi.size();
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        d5 d5Var = null;
        switch (k4.f2801a[i10 - 1]) {
            case 1:
                return new q4();
            case 2:
                return new a(d5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", b.f(), "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                xb<q4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (q4.class) {
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

    private q4() {
    }
}
