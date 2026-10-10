package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class v4 extends ea<v4, a> implements qb {
    private static final v4 zzc;
    private static volatile xb<v4> zzd;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private boolean zzh;
    private int zzi;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<v4, a> implements qb {
        /* synthetic */ a(h5 h5Var) {
            this();
        }

        private a() {
            super(v4.zzc);
        }

        public final boolean A() {
            return ((v4) this.f2633b).O();
        }

        public final boolean C() {
            return ((v4) this.f2633b).Q();
        }

        public final boolean D() {
            return ((v4) this.f2633b).R();
        }

        public final boolean E() {
            return ((v4) this.f2633b).S();
        }

        public final int v() {
            return ((v4) this.f2633b).n();
        }

        public final String y() {
            return ((v4) this.f2633b).M();
        }

        public final boolean z() {
            return ((v4) this.f2633b).N();
        }

        public final a x(String str) {
            s();
            v4.K((v4) this.f2633b, str);
            return this;
        }
    }

    static {
        v4 v4Var = new v4();
        zzc = v4Var;
        ea.v(v4.class, v4Var);
    }

    public final String M() {
        return this.zzf;
    }

    public final boolean N() {
        return this.zzg;
    }

    public final boolean O() {
        return this.zzh;
    }

    public final boolean Q() {
        return (this.zze & 2) != 0;
    }

    public final boolean R() {
        return (this.zze & 4) != 0;
    }

    public final boolean S() {
        return (this.zze & 8) != 0;
    }

    public final int n() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        h5 h5Var = null;
        switch (e5.f2629a[i10 - 1]) {
            case 1:
                return new v4();
            case 2:
                return new a(h5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                xb<v4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (v4.class) {
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

    private v4() {
    }

    static /* synthetic */ void K(v4 v4Var, String str) {
        str.getClass();
        v4Var.zze |= 1;
        v4Var.zzf = str;
    }
}
