package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h6 extends ea<h6, a> implements qb {
    private static final h6 zzc;
    private static volatile xb<h6> zzd;
    private int zze;
    private String zzf = "";
    private na<j6> zzg = ea.G();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<h6, a> implements qb {
        /* synthetic */ a(m6 m6Var) {
            this();
        }

        private a() {
            super(h6.zzc);
        }
    }

    static {
        h6 h6Var = new h6();
        zzc = h6Var;
        ea.v(h6.class, h6Var);
    }

    public final String L() {
        return this.zzf;
    }

    public final List<j6> M() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        m6 m6Var = null;
        switch (l6.f2822a[i10 - 1]) {
            case 1:
                return new h6();
            case 2:
                return new a(m6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", j6.class});
            case 4:
                return zzc;
            case 5:
                xb<h6> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (h6.class) {
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

    private h6() {
    }
}
