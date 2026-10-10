package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class u5 extends ea<u5, a> implements qb {
    private static final u5 zzc;
    private static volatile xb<u5> zzd;
    private int zze;
    private int zzf = 1;
    private na<p5> zzg = ea.G();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<u5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(u5.zzc);
        }

        public final a v(p5.a aVar) {
            s();
            u5.L((u5) this.f2633b, (p5) ((ea) aVar.w()));
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum b implements ja {
        RADS(1),
        PROVISIONING(2);

        private final int zzd;

        public static b a(int i10) {
            if (i10 == 1) {
                return RADS;
            }
            if (i10 != 2) {
                return null;
            }
            return PROVISIONING;
        }

        public static ia f() {
            return c6.f2582a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zzd;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
        }

        b(int i10) {
            this.zzd = i10;
        }
    }

    static {
        u5 u5Var = new u5();
        zzc = u5Var;
        ea.v(u5.class, u5Var);
    }

    public static a K() {
        return zzc.A();
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new u5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zze", "zzf", b.f(), "zzg", p5.class});
            case 4:
                return zzc;
            case 5:
                xb<u5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (u5.class) {
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

    private u5() {
    }

    static /* synthetic */ void L(u5 u5Var, p5 p5Var) {
        p5Var.getClass();
        na<p5> naVar = u5Var.zzg;
        if (!naVar.d()) {
            u5Var.zzg = ea.r(naVar);
        }
        u5Var.zzg.add(p5Var);
    }
}
