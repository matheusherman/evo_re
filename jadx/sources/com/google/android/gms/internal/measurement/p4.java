package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class p4 extends ea<p4, a> implements qb {
    private static final p4 zzc;
    private static volatile xb<p4> zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private n4 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<p4, a> implements qb {
        /* synthetic */ a(d5 d5Var) {
            this();
        }

        private a() {
            super(p4.zzc);
        }

        public final a v(String str) {
            s();
            p4.K((p4) this.f2633b, str);
            return this;
        }
    }

    static {
        p4 p4Var = new p4();
        zzc = p4Var;
        ea.v(p4.class, p4Var);
    }

    public static a M() {
        return zzc.A();
    }

    public final n4 L() {
        n4 n4Var = this.zzh;
        return n4Var == null ? n4.M() : n4Var;
    }

    public final String O() {
        return this.zzg;
    }

    public final boolean Q() {
        return this.zzi;
    }

    public final boolean R() {
        return this.zzj;
    }

    public final boolean S() {
        return this.zzk;
    }

    public final boolean T() {
        return (this.zze & 1) != 0;
    }

    public final boolean U() {
        return (this.zze & 32) != 0;
    }

    public final int n() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        d5 d5Var = null;
        switch (k4.f2801a[i10 - 1]) {
            case 1:
                return new p4();
            case 2:
                return new a(d5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                xb<p4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (p4.class) {
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

    private p4() {
    }

    static /* synthetic */ void K(p4 p4Var, String str) {
        str.getClass();
        p4Var.zze |= 2;
        p4Var.zzg = str;
    }
}
