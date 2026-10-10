package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class n5 extends ea<n5, a> implements qb {
    private static final n5 zzc;
    private static volatile xb<n5> zzd;
    private int zze;
    private int zzf;
    private long zzg;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<n5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(n5.zzc);
        }

        public final a v(int i10) {
            s();
            n5.K((n5) this.f2633b, i10);
            return this;
        }

        public final a x(long j10) {
            s();
            n5.L((n5) this.f2633b, j10);
            return this;
        }
    }

    static {
        n5 n5Var = new n5();
        zzc = n5Var;
        ea.v(n5.class, n5Var);
    }

    static /* synthetic */ void K(n5 n5Var, int i10) {
        n5Var.zze |= 1;
        n5Var.zzf = i10;
    }

    static /* synthetic */ void L(n5 n5Var, long j10) {
        n5Var.zze |= 2;
        n5Var.zzg = j10;
    }

    public static a N() {
        return zzc.A();
    }

    public final long M() {
        return this.zzg;
    }

    public final boolean Q() {
        return (this.zze & 2) != 0;
    }

    public final boolean R() {
        return (this.zze & 1) != 0;
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
                return new n5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                xb<n5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (n5.class) {
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

    private n5() {
    }
}
