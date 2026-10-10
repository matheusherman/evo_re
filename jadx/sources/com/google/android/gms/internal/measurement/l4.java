package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class l4 extends ea<l4, a> implements qb {
    private static final l4 zzc;
    private static volatile xb<l4> zzd;
    private int zze;
    private int zzf;
    private na<p4> zzg = ea.G();
    private na<m4> zzh = ea.G();
    private boolean zzi;
    private boolean zzj;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<l4, a> implements qb {
        /* synthetic */ a(d5 d5Var) {
            this();
        }

        private a() {
            super(l4.zzc);
        }

        public final int A() {
            return ((l4) this.f2633b).Q();
        }

        public final p4 C(int i10) {
            return ((l4) this.f2633b).O(i10);
        }

        public final int v() {
            return ((l4) this.f2633b).N();
        }

        public final m4 z(int i10) {
            return ((l4) this.f2633b).K(i10);
        }

        public final a x(int i10, m4.a aVar) {
            s();
            l4.L((l4) this.f2633b, i10, (m4) ((ea) aVar.w()));
            return this;
        }

        public final a y(int i10, p4.a aVar) {
            s();
            l4.M((l4) this.f2633b, i10, (p4) ((ea) aVar.w()));
            return this;
        }
    }

    static {
        l4 l4Var = new l4();
        zzc = l4Var;
        ea.v(l4.class, l4Var);
    }

    public final m4 K(int i10) {
        return this.zzh.get(i10);
    }

    public final int N() {
        return this.zzh.size();
    }

    public final p4 O(int i10) {
        return this.zzg.get(i10);
    }

    public final int Q() {
        return this.zzg.size();
    }

    public final List<m4> S() {
        return this.zzh;
    }

    public final List<p4> T() {
        return this.zzg;
    }

    public final boolean U() {
        return (this.zze & 1) != 0;
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
                return new l4();
            case 2:
                return new a(d5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", p4.class, "zzh", m4.class, "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                xb<l4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (l4.class) {
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

    private l4() {
    }

    static /* synthetic */ void L(l4 l4Var, int i10, m4 m4Var) {
        m4Var.getClass();
        na<m4> naVar = l4Var.zzh;
        if (!naVar.d()) {
            l4Var.zzh = ea.r(naVar);
        }
        l4Var.zzh.set(i10, m4Var);
    }

    static /* synthetic */ void M(l4 l4Var, int i10, p4 p4Var) {
        p4Var.getClass();
        na<p4> naVar = l4Var.zzg;
        if (!naVar.d()) {
            l4Var.zzg = ea.r(naVar);
        }
        l4Var.zzg.set(i10, p4Var);
    }
}
