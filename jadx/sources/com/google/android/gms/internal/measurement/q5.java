package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class q5 extends ea<q5, a> implements qb {
    private static final q5 zzc;
    private static volatile xb<q5> zzd;
    private int zze;
    private long zzh;
    private float zzi;
    private double zzj;
    private String zzf = "";
    private String zzg = "";
    private na<q5> zzk = ea.G();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<q5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(q5.zzc);
        }

        public final String I() {
            return ((q5) this.f2633b).c0();
        }

        public final String K() {
            return ((q5) this.f2633b).d0();
        }

        public final int v() {
            return ((q5) this.f2633b).W();
        }

        public final a A(Iterable<? extends q5> iterable) {
            s();
            q5.Q((q5) this.f2633b, iterable);
            return this;
        }

        public final a C(String str) {
            s();
            q5.R((q5) this.f2633b, str);
            return this;
        }

        public final a D() {
            s();
            q5.L((q5) this.f2633b);
            return this;
        }

        public final a E(String str) {
            s();
            q5.U((q5) this.f2633b, str);
            return this;
        }

        public final a F() {
            s();
            q5.T((q5) this.f2633b);
            return this;
        }

        public final a G() {
            s();
            q5.X((q5) this.f2633b);
            return this;
        }

        public final a H() {
            s();
            q5.Z((q5) this.f2633b);
            return this;
        }

        public final a x(double d10) {
            s();
            q5.M((q5) this.f2633b, d10);
            return this;
        }

        public final a y(long j10) {
            s();
            q5.N((q5) this.f2633b, j10);
            return this;
        }

        public final a z(a aVar) {
            s();
            q5.O((q5) this.f2633b, (q5) ((ea) aVar.w()));
            return this;
        }
    }

    static {
        q5 q5Var = new q5();
        zzc = q5Var;
        ea.v(q5.class, q5Var);
    }

    static /* synthetic */ void L(q5 q5Var) {
        q5Var.zze &= -17;
        q5Var.zzj = 0.0d;
    }

    static /* synthetic */ void M(q5 q5Var, double d10) {
        q5Var.zze |= 16;
        q5Var.zzj = d10;
    }

    static /* synthetic */ void N(q5 q5Var, long j10) {
        q5Var.zze |= 4;
        q5Var.zzh = j10;
    }

    static /* synthetic */ void T(q5 q5Var) {
        q5Var.zze &= -5;
        q5Var.zzh = 0L;
    }

    static /* synthetic */ void Z(q5 q5Var) {
        q5Var.zze &= -3;
        q5Var.zzg = zzc.zzg;
    }

    public static a a0() {
        return zzc.A();
    }

    private final void k0() {
        na<q5> naVar = this.zzk;
        if (naVar.d()) {
            return;
        }
        this.zzk = ea.r(naVar);
    }

    public final double K() {
        return this.zzj;
    }

    public final float S() {
        return this.zzi;
    }

    public final int W() {
        return this.zzk.size();
    }

    public final long Y() {
        return this.zzh;
    }

    public final String c0() {
        return this.zzf;
    }

    public final String d0() {
        return this.zzg;
    }

    public final List<q5> e0() {
        return this.zzk;
    }

    public final boolean f0() {
        return (this.zze & 16) != 0;
    }

    public final boolean g0() {
        return (this.zze & 8) != 0;
    }

    public final boolean h0() {
        return (this.zze & 4) != 0;
    }

    public final boolean i0() {
        return (this.zze & 1) != 0;
    }

    public final boolean j0() {
        return (this.zze & 2) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new q5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", q5.class});
            case 4:
                return zzc;
            case 5:
                xb<q5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (q5.class) {
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

    private q5() {
    }

    static /* synthetic */ void O(q5 q5Var, q5 q5Var2) {
        q5Var2.getClass();
        q5Var.k0();
        q5Var.zzk.add(q5Var2);
    }

    static /* synthetic */ void Q(q5 q5Var, Iterable iterable) {
        q5Var.k0();
        n8.j(iterable, q5Var.zzk);
    }

    static /* synthetic */ void R(q5 q5Var, String str) {
        str.getClass();
        q5Var.zze |= 1;
        q5Var.zzf = str;
    }

    static /* synthetic */ void U(q5 q5Var, String str) {
        str.getClass();
        q5Var.zze |= 2;
        q5Var.zzg = str;
    }

    static /* synthetic */ void X(q5 q5Var) {
        q5Var.zzk = ea.G();
    }
}
