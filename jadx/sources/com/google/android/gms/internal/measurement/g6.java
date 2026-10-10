package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g6 extends ea<g6, a> implements qb {
    private static final g6 zzc;
    private static volatile xb<g6> zzd;
    private na<h6> zze = ea.G();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<g6, a> implements qb {
        /* synthetic */ a(m6 m6Var) {
            this();
        }

        private a() {
            super(g6.zzc);
        }
    }

    static {
        g6 g6Var = new g6();
        zzc = g6Var;
        ea.v(g6.class, g6Var);
    }

    public static g6 L() {
        return zzc;
    }

    public final List<h6> M() {
        return this.zze;
    }

    public final int n() {
        return this.zze.size();
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        m6 m6Var = null;
        switch (l6.f2822a[i10 - 1]) {
            case 1:
                return new g6();
            case 2:
                return new a(m6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", h6.class});
            case 4:
                return zzc;
            case 5:
                xb<g6> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (g6.class) {
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

    private g6() {
    }
}
