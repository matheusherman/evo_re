package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i6 extends ea<i6, a> implements qb {
    private static final i6 zzc;
    private static volatile xb<i6> zzd;
    private int zze;
    private na<j6> zzf = ea.G();
    private g6 zzg;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<i6, a> implements qb {
        /* synthetic */ a(m6 m6Var) {
            this();
        }

        private a() {
            super(i6.zzc);
        }
    }

    static {
        i6 i6Var = new i6();
        zzc = i6Var;
        ea.v(i6.class, i6Var);
    }

    public final g6 K() {
        g6 g6Var = this.zzg;
        return g6Var == null ? g6.L() : g6Var;
    }

    public final List<j6> M() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        m6 m6Var = null;
        switch (l6.f2822a[i10 - 1]) {
            case 1:
                return new i6();
            case 2:
                return new a(m6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", j6.class, "zzg"});
            case 4:
                return zzc;
            case 5:
                xb<i6> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (i6.class) {
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

    private i6() {
    }
}
