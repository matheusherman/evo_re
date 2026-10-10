package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class j6 extends ea<j6, b> implements qb {
    private static final j6 zzc;
    private static volatile xb<j6> zzd;
    private int zze;
    private int zzf;
    private na<j6> zzg = ea.G();
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private double zzk;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a implements ja {
        UNKNOWN(0),
        STRING(1),
        NUMBER(2),
        BOOLEAN(3),
        STATEMENT(4);

        private final int zzg;

        public static a a(int i10) {
            if (i10 == 0) {
                return UNKNOWN;
            }
            if (i10 == 1) {
                return STRING;
            }
            if (i10 == 2) {
                return NUMBER;
            }
            if (i10 == 3) {
                return BOOLEAN;
            }
            if (i10 != 4) {
                return null;
            }
            return STATEMENT;
        }

        public static ia f() {
            return n6.f2892a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zzg;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        a(int i10) {
            this.zzg = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends ea.b<j6, b> implements qb {
        /* synthetic */ b(m6 m6Var) {
            this();
        }

        private b() {
            super(j6.zzc);
        }
    }

    static {
        j6 j6Var = new j6();
        zzc = j6Var;
        ea.v(j6.class, j6Var);
    }

    public final double K() {
        return this.zzk;
    }

    public final a L() {
        a aVarA = a.a(this.zzf);
        return aVarA == null ? a.UNKNOWN : aVarA;
    }

    public final String N() {
        return this.zzh;
    }

    public final String O() {
        return this.zzi;
    }

    public final List<j6> Q() {
        return this.zzg;
    }

    public final boolean R() {
        return this.zzj;
    }

    public final boolean S() {
        return (this.zze & 8) != 0;
    }

    public final boolean T() {
        return (this.zze & 16) != 0;
    }

    public final boolean U() {
        return (this.zze & 4) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        m6 m6Var = null;
        switch (l6.f2822a[i10 - 1]) {
            case 1:
                return new j6();
            case 2:
                return new b(m6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", a.f(), "zzg", j6.class, "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                xb<j6> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (j6.class) {
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

    private j6() {
    }
}
