package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class w4 extends ea<w4, a> implements qb {
    private static final w4 zzc;
    private static volatile xb<w4> zzd;
    private int zze;
    private long zzf;
    private int zzh;
    private boolean zzm;
    private t4 zzr;
    private y4 zzs;
    private b5 zzt;
    private z4 zzu;
    private x4 zzv;
    private String zzg = "";
    private na<a5> zzi = ea.G();
    private na<v4> zzj = ea.G();
    private na<l4> zzk = ea.G();
    private String zzl = "";
    private na<i6> zzn = ea.G();
    private na<u4> zzo = ea.G();
    private String zzp = "";
    private String zzq = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<w4, a> implements qb {
        /* synthetic */ a(h5 h5Var) {
            this();
        }

        private a() {
            super(w4.zzc);
        }

        public final String C() {
            return ((w4) this.f2633b).Y();
        }

        public final List<l4> D() {
            return Collections.unmodifiableList(((w4) this.f2633b).Z());
        }

        public final List<u4> E() {
            return Collections.unmodifiableList(((w4) this.f2633b).a0());
        }

        public final int v() {
            return ((w4) this.f2633b).N();
        }

        public final v4 x(int i10) {
            return ((w4) this.f2633b).K(i10);
        }

        public final a A() {
            s();
            w4.O((w4) this.f2633b);
            return this;
        }

        public final a y(int i10, v4.a aVar) {
            s();
            w4.M((w4) this.f2633b, i10, (v4) ((ea) aVar.w()));
            return this;
        }

        public final a z() {
            s();
            w4.L((w4) this.f2633b);
            return this;
        }
    }

    static {
        w4 w4Var = new w4();
        zzc = w4Var;
        ea.v(w4.class, w4Var);
    }

    public static a S() {
        return zzc.A();
    }

    public static w4 U() {
        return zzc;
    }

    public final v4 K(int i10) {
        return this.zzj.get(i10);
    }

    public final int N() {
        return this.zzj.size();
    }

    public final long Q() {
        return this.zzf;
    }

    public final t4 R() {
        t4 t4Var = this.zzr;
        return t4Var == null ? t4.L() : t4Var;
    }

    public final b5 W() {
        b5 b5Var = this.zzt;
        return b5Var == null ? b5.L() : b5Var;
    }

    public final String X() {
        return this.zzg;
    }

    public final String Y() {
        return this.zzp;
    }

    public final List<l4> Z() {
        return this.zzk;
    }

    public final List<u4> a0() {
        return this.zzo;
    }

    public final List<i6> b0() {
        return this.zzn;
    }

    public final List<a5> c0() {
        return this.zzi;
    }

    public final boolean d0() {
        return (this.zze & 128) != 0;
    }

    public final boolean e0() {
        return (this.zze & 2) != 0;
    }

    public final boolean f0() {
        return (this.zze & 512) != 0;
    }

    public final boolean g0() {
        return (this.zze & 1) != 0;
    }

    public final int n() {
        return this.zzn.size();
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        h5 h5Var = null;
        switch (e5.f2629a[i10 - 1]) {
            case 1:
                return new w4();
            case 2:
                return new a(h5Var);
            case 3:
                return ea.t(zzc, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", a5.class, "zzj", v4.class, "zzk", l4.class, "zzl", "zzm", "zzn", i6.class, "zzo", u4.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv"});
            case 4:
                return zzc;
            case 5:
                xb<w4> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (w4.class) {
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

    private w4() {
    }

    static /* synthetic */ void L(w4 w4Var) {
        w4Var.zzk = ea.G();
    }

    static /* synthetic */ void M(w4 w4Var, int i10, v4 v4Var) {
        v4Var.getClass();
        na<v4> naVar = w4Var.zzj;
        if (!naVar.d()) {
            w4Var.zzj = ea.r(naVar);
        }
        w4Var.zzj.set(i10, v4Var);
    }

    static /* synthetic */ void O(w4 w4Var) {
        w4Var.zzn = ea.G();
    }
}
