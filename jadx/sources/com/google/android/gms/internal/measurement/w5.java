package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class w5 extends ea<w5, a> implements qb {
    private static final w5 zzc;
    private static volatile xb<w5> zzd;
    private int zze;
    private int zzf;
    private ka zzg = ea.F();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<w5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(w5.zzc);
        }

        public final a v(int i10) {
            s();
            w5.L((w5) this.f2633b, i10);
            return this;
        }

        public final a x(Iterable<? extends Long> iterable) {
            s();
            w5.M((w5) this.f2633b, iterable);
            return this;
        }
    }

    static {
        w5 w5Var = new w5();
        zzc = w5Var;
        ea.v(w5.class, w5Var);
    }

    static /* synthetic */ void L(w5 w5Var, int i10) {
        w5Var.zze |= 1;
        w5Var.zzf = i10;
    }

    static /* synthetic */ void M(w5 w5Var, Iterable iterable) {
        ka kaVar = w5Var.zzg;
        if (!kaVar.d()) {
            w5Var.zzg = ea.q(kaVar);
        }
        n8.j(iterable, w5Var.zzg);
    }

    public static a O() {
        return zzc.A();
    }

    public final long K(int i10) {
        return this.zzg.l(i10);
    }

    public final int N() {
        return this.zzf;
    }

    public final List<Long> R() {
        return this.zzg;
    }

    public final boolean S() {
        return (this.zze & 1) != 0;
    }

    public final int n() {
        return this.zzg.size();
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new w5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                xb<w5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (w5.class) {
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

    private w5() {
    }
}
