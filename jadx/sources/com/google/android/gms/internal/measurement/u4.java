package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class u4 extends ea<u4, a> implements qb {
    private static final u4 zzc;
    private static volatile xb<u4> zzd;
    private int zze;
    private String zzf = "";
    private na<z4> zzg = ea.G();
    private boolean zzh;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<u4, a> implements qb {
        /* synthetic */ a(h5 h5Var) {
            this();
        }

        private a() {
            super(u4.zzc);
        }
    }

    static {
        u4 u4Var = new u4();
        zzc = u4Var;
        ea.v(u4.class, u4Var);
    }

    public final String L() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        h5 h5Var = null;
        switch (e5.f2629a[i10 - 1]) {
            case 1:
                return new u4();
            case 2:
                return new a(h5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", z4.class, "zzh"});
            case 4:
                return zzc;
            case 5:
                xb<u4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (u4.class) {
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

    private u4() {
    }
}
