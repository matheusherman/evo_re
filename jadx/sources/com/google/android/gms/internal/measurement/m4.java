package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class m4 extends ea<m4, a> implements qb {
    private static final m4 zzc;
    private static volatile xb<m4> zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private na<n4> zzh = ea.G();
    private boolean zzi;
    private o4 zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<m4, a> implements qb {
        /* synthetic */ a(d5 d5Var) {
            this();
        }

        private a() {
            super(m4.zzc);
        }

        public final String A() {
            return ((m4) this.f2633b).S();
        }

        public final int v() {
            return ((m4) this.f2633b).n();
        }

        public final n4 z(int i10) {
            return ((m4) this.f2633b).K(i10);
        }

        public final a x(int i10, n4 n4Var) {
            s();
            m4.L((m4) this.f2633b, i10, n4Var);
            return this;
        }

        public final a y(String str) {
            s();
            m4.M((m4) this.f2633b, str);
            return this;
        }
    }

    static {
        m4 m4Var = new m4();
        zzc = m4Var;
        ea.v(m4.class, m4Var);
    }

    public static a O() {
        return zzc.A();
    }

    public final n4 K(int i10) {
        return this.zzh.get(i10);
    }

    public final int N() {
        return this.zzf;
    }

    public final o4 R() {
        o4 o4Var = this.zzj;
        return o4Var == null ? o4.M() : o4Var;
    }

    public final String S() {
        return this.zzg;
    }

    public final List<n4> T() {
        return this.zzh;
    }

    public final boolean U() {
        return this.zzk;
    }

    public final boolean W() {
        return this.zzl;
    }

    public final boolean X() {
        return this.zzm;
    }

    public final boolean Y() {
        return (this.zze & 8) != 0;
    }

    public final boolean Z() {
        return (this.zze & 1) != 0;
    }

    public final boolean a0() {
        return (this.zze & 64) != 0;
    }

    public final int n() {
        return this.zzh.size();
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        d5 d5Var = null;
        switch (k4.f2801a[i10 - 1]) {
            case 1:
                return new m4();
            case 2:
                return new a(d5Var);
            case 3:
                return ea.t(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", n4.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
            case 4:
                return zzc;
            case 5:
                xb<m4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (m4.class) {
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

    private m4() {
    }

    static /* synthetic */ void L(m4 m4Var, int i10, n4 n4Var) {
        n4Var.getClass();
        na<n4> naVar = m4Var.zzh;
        if (!naVar.d()) {
            m4Var.zzh = ea.r(naVar);
        }
        m4Var.zzh.set(i10, n4Var);
    }

    static /* synthetic */ void M(m4 m4Var, String str) {
        str.getClass();
        m4Var.zze |= 2;
        m4Var.zzg = str;
    }
}
