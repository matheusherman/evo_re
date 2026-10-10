package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class x4 extends ea<x4, a> implements qb {
    private static final x4 zzc;
    private static volatile xb<x4> zzd;
    private na<String> zze = ea.G();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<x4, a> implements qb {
        /* synthetic */ a(h5 h5Var) {
            this();
        }

        private a() {
            super(x4.zzc);
        }
    }

    static {
        x4 x4Var = new x4();
        zzc = x4Var;
        ea.v(x4.class, x4Var);
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        h5 h5Var = null;
        switch (e5.f2629a[i10 - 1]) {
            case 1:
                return new x4();
            case 2:
                return new a(h5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                xb<x4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (x4.class) {
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

    private x4() {
    }
}
