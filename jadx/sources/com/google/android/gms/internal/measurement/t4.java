package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class t4 extends ea<t4, b> implements qb {
    private static final t4 zzc;
    private static volatile xb<t4> zzd;
    private int zze;
    private boolean zzi;
    private na<a> zzf = ea.G();
    private na<c> zzg = ea.G();
    private na<f> zzh = ea.G();
    private na<a> zzj = ea.G();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea<a, C0047a> implements qb {
        private static final a zzc;
        private static volatile xb<a> zzd;
        private int zze;
        private int zzf;
        private int zzg;

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.t4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0047a extends ea.b<a, C0047a> implements qb {
            /* synthetic */ C0047a(h5 h5Var) {
                this();
            }

            private C0047a() {
                super(a.zzc);
            }
        }

        static {
            a aVar = new a();
            zzc = aVar;
            ea.v(a.class, aVar);
        }

        public final d L() {
            d dVarA = d.a(this.zzg);
            return dVarA == null ? d.CONSENT_STATUS_UNSPECIFIED : dVarA;
        }

        public final e M() {
            e eVarA = e.a(this.zzf);
            return eVarA == null ? e.CONSENT_TYPE_UNSPECIFIED : eVarA;
        }

        @Override // com.google.android.gms.internal.measurement.ea
        protected final Object s(int i10, Object obj, Object obj2) {
            xb aVar;
            h5 h5Var = null;
            switch (e5.f2629a[i10 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0047a(h5Var);
                case 3:
                    return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", e.f(), "zzg", d.f()});
                case 4:
                    return zzc;
                case 5:
                    xb<a> xbVar = zzd;
                    if (xbVar != null) {
                        return xbVar;
                    }
                    synchronized (a.class) {
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

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends ea.b<t4, b> implements qb {
        /* synthetic */ b(h5 h5Var) {
            this();
        }

        private b() {
            super(t4.zzc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends ea<c, a> implements qb {
        private static final c zzc;
        private static volatile xb<c> zzd;
        private int zze;
        private int zzf;
        private int zzg;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class a extends ea.b<c, a> implements qb {
            /* synthetic */ a(h5 h5Var) {
                this();
            }

            private a() {
                super(c.zzc);
            }
        }

        static {
            c cVar = new c();
            zzc = cVar;
            ea.v(c.class, cVar);
        }

        public final e L() {
            e eVarA = e.a(this.zzg);
            return eVarA == null ? e.CONSENT_TYPE_UNSPECIFIED : eVarA;
        }

        public final e M() {
            e eVarA = e.a(this.zzf);
            return eVarA == null ? e.CONSENT_TYPE_UNSPECIFIED : eVarA;
        }

        @Override // com.google.android.gms.internal.measurement.ea
        protected final Object s(int i10, Object obj, Object obj2) {
            xb aVar;
            h5 h5Var = null;
            switch (e5.f2629a[i10 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a(h5Var);
                case 3:
                    return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", e.f(), "zzg", e.f()});
                case 4:
                    return zzc;
                case 5:
                    xb<c> xbVar = zzd;
                    if (xbVar != null) {
                        return xbVar;
                    }
                    synchronized (c.class) {
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

        private c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum d implements ja {
        CONSENT_STATUS_UNSPECIFIED(0),
        GRANTED(1),
        DENIED(2);

        private final int zze;

        public static d a(int i10) {
            if (i10 == 0) {
                return CONSENT_STATUS_UNSPECIFIED;
            }
            if (i10 == 1) {
                return GRANTED;
            }
            if (i10 != 2) {
                return null;
            }
            return DENIED;
        }

        public static ia f() {
            return f5.f2687a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zze;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + d.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
        }

        d(int i10) {
            this.zze = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum e implements ja {
        CONSENT_TYPE_UNSPECIFIED(0),
        AD_STORAGE(1),
        ANALYTICS_STORAGE(2),
        AD_USER_DATA(3),
        AD_PERSONALIZATION(4);

        private final int zzg;

        public static e a(int i10) {
            if (i10 == 0) {
                return CONSENT_TYPE_UNSPECIFIED;
            }
            if (i10 == 1) {
                return AD_STORAGE;
            }
            if (i10 == 2) {
                return ANALYTICS_STORAGE;
            }
            if (i10 == 3) {
                return AD_USER_DATA;
            }
            if (i10 != 4) {
                return null;
            }
            return AD_PERSONALIZATION;
        }

        public static ia f() {
            return g5.f2708a;
        }

        @Override // com.google.android.gms.internal.measurement.ja
        public final int b() {
            return this.zzg;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + e.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        e(int i10) {
            this.zzg = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class f extends ea<f, a> implements qb {
        private static final f zzc;
        private static volatile xb<f> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class a extends ea.b<f, a> implements qb {
            /* synthetic */ a(h5 h5Var) {
                this();
            }

            private a() {
                super(f.zzc);
            }
        }

        static {
            f fVar = new f();
            zzc = fVar;
            ea.v(f.class, fVar);
        }

        public final String L() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.measurement.ea
        protected final Object s(int i10, Object obj, Object obj2) {
            xb aVar;
            h5 h5Var = null;
            switch (e5.f2629a[i10 - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a(h5Var);
                case 3:
                    return ea.t(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    xb<f> xbVar = zzd;
                    if (xbVar != null) {
                        return xbVar;
                    }
                    synchronized (f.class) {
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

        private f() {
        }
    }

    static {
        t4 t4Var = new t4();
        zzc = t4Var;
        ea.v(t4.class, t4Var);
    }

    public static t4 L() {
        return zzc;
    }

    public final List<f> M() {
        return this.zzh;
    }

    public final List<a> N() {
        return this.zzf;
    }

    public final List<c> O() {
        return this.zzg;
    }

    public final List<a> Q() {
        return this.zzj;
    }

    public final boolean R() {
        return this.zzi;
    }

    public final boolean S() {
        return (this.zze & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        h5 h5Var = null;
        switch (e5.f2629a[i10 - 1]) {
            case 1:
                return new t4();
            case 2:
                return new b(h5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", a.class, "zzg", c.class, "zzh", f.class, "zzi", "zzj", a.class});
            case 4:
                return zzc;
            case 5:
                xb<t4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (t4.class) {
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

    private t4() {
    }
}
