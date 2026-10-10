package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class s5 extends ea<s5, a> implements qb {
    private static final s5 zzc;
    private static volatile xb<s5> zzd;
    private int zze;
    private na<t5> zzf = ea.G();
    private String zzg = "";
    private String zzh = "";
    private int zzi;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends ea.b<s5, a> implements qb {
        /* synthetic */ a(k6 k6Var) {
            this();
        }

        private a() {
            super(s5.zzc);
        }

        public final t5 C(int i10) {
            return ((s5) this.f2633b).L(i10);
        }

        public final String F() {
            return ((s5) this.f2633b).W();
        }

        public final List<t5> G() {
            return Collections.unmodifiableList(((s5) this.f2633b).Y());
        }

        public final int v() {
            return ((s5) this.f2633b).n();
        }

        public final a A(String str) {
            s();
            s5.Q((s5) this.f2633b, str);
            return this;
        }

        public final a D() {
            s();
            s5.S((s5) this.f2633b);
            return this;
        }

        public final a E(String str) {
            s();
            s5.T((s5) this.f2633b, str);
            return this;
        }

        public final a x(int i10, t5.a aVar) {
            s();
            s5.M((s5) this.f2633b, i10, (t5) ((ea) aVar.w()));
            return this;
        }

        public final a y(t5.a aVar) {
            s();
            s5.N((s5) this.f2633b, (t5) ((ea) aVar.w()));
            return this;
        }

        public final a z(Iterable<? extends t5> iterable) {
            s();
            s5.O((s5) this.f2633b, iterable);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum b implements ja {
        SDK(0),
        SGTM(1);

        private final int zzd;

        public static b a(int i10) {
            if (i10 == 0) {
                return SDK;
            }
            if (i10 != 1) {
                return null;
            }
            return SGTM;
        }

        public static ia f() {
            return b6.f2552a;
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
        s5 s5Var = new s5();
        zzc = s5Var;
        ea.v(s5.class, s5Var);
    }

    public static a K(s5 s5Var) {
        return zzc.o(s5Var);
    }

    public static a R() {
        return zzc.A();
    }

    private final void b0() {
        na<t5> naVar = this.zzf;
        if (naVar.d()) {
            return;
        }
        this.zzf = ea.r(naVar);
    }

    public final t5 L(int i10) {
        return this.zzf.get(i10);
    }

    public final String W() {
        return this.zzg;
    }

    public final String X() {
        return this.zzh;
    }

    public final List<t5> Y() {
        return this.zzf;
    }

    public final boolean Z() {
        return (this.zze & 1) != 0;
    }

    public final boolean a0() {
        return (this.zze & 2) != 0;
    }

    public final int n() {
        return this.zzf.size();
    }

    @Override // com.google.android.gms.internal.measurement.ea
    protected final Object s(int i10, Object obj, Object obj2) {
        xb aVar;
        k6 k6Var = null;
        switch (i5.f2771a[i10 - 1]) {
            case 1:
                return new s5();
            case 2:
                return new a(k6Var);
            case 3:
                return ea.t(zzc, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zze", "zzf", t5.class, "zzg", "zzh", "zzi", b.f()});
            case 4:
                return zzc;
            case 5:
                xb<s5> xbVar = zzd;
                if (xbVar != null) {
                    return xbVar;
                }
                synchronized (s5.class) {
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

    private s5() {
    }

    static /* synthetic */ void M(s5 s5Var, int i10, t5 t5Var) {
        t5Var.getClass();
        s5Var.b0();
        s5Var.zzf.set(i10, t5Var);
    }

    static /* synthetic */ void N(s5 s5Var, t5 t5Var) {
        t5Var.getClass();
        s5Var.b0();
        s5Var.zzf.add(t5Var);
    }

    static /* synthetic */ void O(s5 s5Var, Iterable iterable) {
        s5Var.b0();
        n8.j(iterable, s5Var.zzf);
    }

    static /* synthetic */ void Q(s5 s5Var, String str) {
        str.getClass();
        s5Var.zze |= 1;
        s5Var.zzg = str;
    }

    static /* synthetic */ void S(s5 s5Var) {
        s5Var.zzf = ea.G();
    }

    static /* synthetic */ void T(s5 s5Var, String str) {
        str.getClass();
        s5Var.zze |= 2;
        s5Var.zzh = str;
    }
}
