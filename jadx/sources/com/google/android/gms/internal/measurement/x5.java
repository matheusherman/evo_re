package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class x5 extends ea<x5, a> implements qb {
    private static final x5 zzc;
    private static volatile xb<x5> zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<x5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(x5.zzc);
        }

        public final a v(b bVar) {
            s();
            x5.L((x5) this.f2633b, bVar);
            return this;
        }

        public final a x(c cVar) {
            s();
            x5.M((x5) this.f2633b, cVar);
            return this;
        }

        public final a y(d dVar) {
            s();
            x5.N((x5) this.f2633b, dVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum b implements ja {
        CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN(0),
        CLIENT_UPLOAD_ELIGIBLE(1),
        MEASUREMENT_SERVICE_NOT_ENABLED(2),
        ANDROID_TOO_OLD(3),
        NON_PLAY_MODE(4),
        SDK_TOO_OLD(5),
        MISSING_JOB_SCHEDULER(6),
        NOT_ENABLED_IN_MANIFEST(7),
        CLIENT_FLAG_OFF(8),
        SERVICE_FLAG_OFF(20),
        PINNED_TO_SERVICE_UPLOAD(21),
        MISSING_SGTM_SERVER_URL(22);

        private final int zzn;

        public static ia f() {
            return d6.f2605a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zzn;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + '>';
        }

        b(int i10) {
            this.zzn = i10;
        }

        public static b a(int i10) {
            switch (i10) {
                case 0:
                    return CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN;
                case 1:
                    return CLIENT_UPLOAD_ELIGIBLE;
                case 2:
                    return MEASUREMENT_SERVICE_NOT_ENABLED;
                case 3:
                    return ANDROID_TOO_OLD;
                case 4:
                    return NON_PLAY_MODE;
                case 5:
                    return SDK_TOO_OLD;
                case 6:
                    return MISSING_JOB_SCHEDULER;
                case 7:
                    return NOT_ENABLED_IN_MANIFEST;
                case 8:
                    return CLIENT_FLAG_OFF;
                default:
                    switch (i10) {
                        case 20:
                            return SERVICE_FLAG_OFF;
                        case 21:
                            return PINNED_TO_SERVICE_UPLOAD;
                        case 22:
                            return MISSING_SGTM_SERVER_URL;
                        default:
                            return null;
                    }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum c implements ja {
        SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN(0),
        SERVICE_UPLOAD_ELIGIBLE(1),
        NOT_IN_ROLLOUT(2),
        MISSING_SGTM_SETTINGS(3),
        MISSING_SGTM_PROXY_INFO(4),
        NON_PLAY_MISSING_SGTM_SERVER_URL(5);

        private final int zzh;

        public static c a(int i10) {
            if (i10 == 0) {
                return SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN;
            }
            if (i10 == 1) {
                return SERVICE_UPLOAD_ELIGIBLE;
            }
            if (i10 == 2) {
                return NOT_IN_ROLLOUT;
            }
            if (i10 == 3) {
                return MISSING_SGTM_SETTINGS;
            }
            if (i10 == 4) {
                return MISSING_SGTM_PROXY_INFO;
            }
            if (i10 != 5) {
                return null;
            }
            return NON_PLAY_MISSING_SGTM_SERVER_URL;
        }

        public static ia f() {
            return e6.f2630a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zzh;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + c.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
        }

        c(int i10) {
            this.zzh = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum d implements ja {
        UPLOAD_TYPE_UNKNOWN(0),
        GA_UPLOAD(1),
        SDK_CLIENT_UPLOAD(2),
        PACKAGE_SERVICE_UPLOAD(3),
        SDK_SERVICE_UPLOAD(4);

        private final int zzg;

        public static d a(int i10) {
            if (i10 == 0) {
                return UPLOAD_TYPE_UNKNOWN;
            }
            if (i10 == 1) {
                return GA_UPLOAD;
            }
            if (i10 == 2) {
                return SDK_CLIENT_UPLOAD;
            }
            if (i10 == 3) {
                return PACKAGE_SERVICE_UPLOAD;
            }
            if (i10 != 4) {
                return null;
            }
            return SDK_SERVICE_UPLOAD;
        }

        public static ia f() {
            return f6.f2688a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zzg;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + d.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        d(int i10) {
            this.zzg = i10;
        }
    }

    static {
        x5 x5Var = new x5();
        zzc = x5Var;
        ea.v(x5.class, x5Var);
    }

    public static a K() {
        return zzc.A();
    }

    public static x5 T() {
        return zzc;
    }

    public final b O() {
        b bVarA = b.a(this.zzg);
        return bVarA == null ? b.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : bVarA;
    }

    public final c Q() {
        c cVarA = c.a(this.zzh);
        return cVarA == null ? c.SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN : cVarA;
    }

    public final d R() {
        d dVarA = d.a(this.zzf);
        return dVarA == null ? d.UPLOAD_TYPE_UNKNOWN : dVarA;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new x5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zze", "zzf", d.f(), "zzg", b.f(), "zzh", c.f()});
            case 4:
                return zzc;
            case 5:
                xb<x5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (x5.class) {
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

    private x5() {
    }

    static /* synthetic */ void L(x5 x5Var, b bVar) {
        x5Var.zzg = bVar.b();
        x5Var.zze |= 2;
    }

    static /* synthetic */ void M(x5 x5Var, c cVar) {
        x5Var.zzh = cVar.b();
        x5Var.zze |= 4;
    }

    static /* synthetic */ void N(x5 x5Var, d dVar) {
        x5Var.zzf = dVar.b();
        x5Var.zze |= 1;
    }
}
