package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class p5 extends ea<p5, a> implements qb {
    private static final p5 zzc;
    private static volatile xb<p5> zzd;
    private int zze;
    private String zzf = "";
    private long zzg;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<p5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(p5.zzc);
        }

        public final a v(long j10) {
            s();
            p5.L((p5) this.f2633b, j10);
            return this;
        }

        public final a x(String str) {
            s();
            p5.M((p5) this.f2633b, str);
            return this;
        }
    }

    static {
        p5 p5Var = new p5();
        zzc = p5Var;
        ea.v(p5.class, p5Var);
    }

    public static a K() {
        return zzc.A();
    }

    static /* synthetic */ void L(p5 p5Var, long j10) {
        p5Var.zze |= 2;
        p5Var.zzg = j10;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new p5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                xb<p5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (p5.class) {
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

    private p5() {
    }

    static /* synthetic */ void M(p5 p5Var, String str) {
        str.getClass();
        p5Var.zze |= 1;
        p5Var.zzf = str;
    }
}
