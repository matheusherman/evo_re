package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class v5 extends ea<v5, a> implements qb {
    private static final v5 zzc;
    private static volatile xb<v5> zzd;
    private ka zze = ea.F();
    private ka zzf = ea.F();
    private na<n5> zzg = ea.G();
    private na<w5> zzh = ea.G();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<v5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(v5.zzc);
        }

        public final a A() {
            s();
            v5.R((v5) this.f2633b);
            return this;
        }

        public final a C(Iterable<? extends w5> iterable) {
            s();
            v5.S((v5) this.f2633b, iterable);
            return this;
        }

        public final a D() {
            s();
            v5.U((v5) this.f2633b);
            return this;
        }

        public final a E(Iterable<? extends Long> iterable) {
            s();
            v5.W((v5) this.f2633b, iterable);
            return this;
        }

        public final a v() {
            s();
            v5.K((v5) this.f2633b);
            return this;
        }

        public final a x(Iterable<? extends n5> iterable) {
            s();
            v5.L((v5) this.f2633b, iterable);
            return this;
        }

        public final a y() {
            s();
            v5.N((v5) this.f2633b);
            return this;
        }

        public final a z(Iterable<? extends Long> iterable) {
            s();
            v5.O((v5) this.f2633b, iterable);
            return this;
        }
    }

    static {
        v5 v5Var = new v5();
        zzc = v5Var;
        ea.v(v5.class, v5Var);
    }

    static /* synthetic */ void L(v5 v5Var, Iterable iterable) {
        na<n5> naVar = v5Var.zzg;
        if (!naVar.d()) {
            v5Var.zzg = ea.r(naVar);
        }
        n8.j(iterable, v5Var.zzg);
    }

    static /* synthetic */ void O(v5 v5Var, Iterable iterable) {
        ka kaVar = v5Var.zzf;
        if (!kaVar.d()) {
            v5Var.zzf = ea.q(kaVar);
        }
        n8.j(iterable, v5Var.zzf);
    }

    static /* synthetic */ void S(v5 v5Var, Iterable iterable) {
        na<w5> naVar = v5Var.zzh;
        if (!naVar.d()) {
            v5Var.zzh = ea.r(naVar);
        }
        n8.j(iterable, v5Var.zzh);
    }

    static /* synthetic */ void W(v5 v5Var, Iterable iterable) {
        ka kaVar = v5Var.zze;
        if (!kaVar.d()) {
            v5Var.zze = ea.q(kaVar);
        }
        n8.j(iterable, v5Var.zze);
    }

    public static a X() {
        return zzc.A();
    }

    public static v5 Z() {
        return zzc;
    }

    public final int M() {
        return this.zzf.size();
    }

    public final int Q() {
        return this.zzh.size();
    }

    public final int T() {
        return this.zze.size();
    }

    public final List<n5> a0() {
        return this.zzg;
    }

    public final List<Long> b0() {
        return this.zzf;
    }

    public final List<w5> c0() {
        return this.zzh;
    }

    public final List<Long> d0() {
        return this.zze;
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
                return new v5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", n5.class, "zzh", w5.class});
            case 4:
                return zzc;
            case 5:
                xb<v5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (v5.class) {
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

    private v5() {
    }

    static /* synthetic */ void K(v5 v5Var) {
        v5Var.zzg = ea.G();
    }

    static /* synthetic */ void N(v5 v5Var) {
        v5Var.zzf = ea.F();
    }

    static /* synthetic */ void R(v5 v5Var) {
        v5Var.zzh = ea.G();
    }

    static /* synthetic */ void U(v5 v5Var) {
        v5Var.zze = ea.F();
    }
}
