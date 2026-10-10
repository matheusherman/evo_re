package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class o5 extends ea<o5, a> implements qb {
    private static final o5 zzc;
    private static volatile xb<o5> zzd;
    private int zze;
    private na<q5> zzf = ea.G();
    private String zzg = "";
    private long zzh;
    private long zzi;
    private int zzj;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<o5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(o5.zzc);
        }

        public final long G() {
            return ((o5) this.f2633b).W();
        }

        public final q5 I(int i10) {
            return ((o5) this.f2633b).K(i10);
        }

        public final long K() {
            return ((o5) this.f2633b).X();
        }

        public final String N() {
            return ((o5) this.f2633b).a0();
        }

        public final List<q5> O() {
            return Collections.unmodifiableList(((o5) this.f2633b).b0());
        }

        public final boolean Q() {
            return ((o5) this.f2633b).e0();
        }

        public final int v() {
            return ((o5) this.f2633b).T();
        }

        public final a A(long j10) {
            s();
            o5.O((o5) this.f2633b, j10);
            return this;
        }

        public final a C(q5.a aVar) {
            s();
            o5.Q((o5) this.f2633b, (q5) ((ea) aVar.w()));
            return this;
        }

        public final a D(q5 q5Var) {
            s();
            o5.Q((o5) this.f2633b, q5Var);
            return this;
        }

        public final a E(Iterable<? extends q5> iterable) {
            s();
            o5.R((o5) this.f2633b, iterable);
            return this;
        }

        public final a F(String str) {
            s();
            o5.S((o5) this.f2633b, str);
            return this;
        }

        public final a H(long j10) {
            s();
            o5.U((o5) this.f2633b, j10);
            return this;
        }

        public final a L() {
            s();
            o5.L((o5) this.f2633b);
            return this;
        }

        public final a x(int i10) {
            s();
            o5.M((o5) this.f2633b, i10);
            return this;
        }

        public final a y(int i10, q5.a aVar) {
            s();
            o5.N((o5) this.f2633b, i10, (q5) ((ea) aVar.w()));
            return this;
        }

        public final a z(int i10, q5 q5Var) {
            s();
            o5.N((o5) this.f2633b, i10, q5Var);
            return this;
        }
    }

    static {
        o5 o5Var = new o5();
        zzc = o5Var;
        ea.v(o5.class, o5Var);
    }

    static /* synthetic */ void O(o5 o5Var, long j10) {
        o5Var.zze |= 4;
        o5Var.zzi = j10;
    }

    static /* synthetic */ void U(o5 o5Var, long j10) {
        o5Var.zze |= 2;
        o5Var.zzh = j10;
    }

    public static a Y() {
        return zzc.A();
    }

    private final void f0() {
        na<q5> naVar = this.zzf;
        if (naVar.d()) {
            return;
        }
        this.zzf = ea.r(naVar);
    }

    public final q5 K(int i10) {
        return this.zzf.get(i10);
    }

    public final int T() {
        return this.zzf.size();
    }

    public final long W() {
        return this.zzi;
    }

    public final long X() {
        return this.zzh;
    }

    public final String a0() {
        return this.zzg;
    }

    public final List<q5> b0() {
        return this.zzf;
    }

    public final boolean c0() {
        return (this.zze & 8) != 0;
    }

    public final boolean d0() {
        return (this.zze & 4) != 0;
    }

    public final boolean e0() {
        return (this.zze & 2) != 0;
    }

    public final int n() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new o5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", q5.class, "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                xb<o5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (o5.class) {
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

    private o5() {
    }

    static /* synthetic */ void L(o5 o5Var) {
        o5Var.zzf = ea.G();
    }

    static /* synthetic */ void M(o5 o5Var, int i10) {
        o5Var.f0();
        o5Var.zzf.remove(i10);
    }

    static /* synthetic */ void N(o5 o5Var, int i10, q5 q5Var) {
        q5Var.getClass();
        o5Var.f0();
        o5Var.zzf.set(i10, q5Var);
    }

    static /* synthetic */ void Q(o5 o5Var, q5 q5Var) {
        q5Var.getClass();
        o5Var.f0();
        o5Var.zzf.add(q5Var);
    }

    static /* synthetic */ void R(o5 o5Var, Iterable iterable) {
        o5Var.f0();
        n8.j(iterable, o5Var.zzf);
    }

    static /* synthetic */ void S(o5 o5Var, String str) {
        str.getClass();
        o5Var.zze |= 1;
        o5Var.zzg = str;
    }
}
