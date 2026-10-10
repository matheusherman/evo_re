package y9;

import w9.j;
import w9.k;
import w9.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b {
    public static final C0480b A;
    public static final C0480b B;
    public static final C0480b C;
    public static final C0480b D;
    public static final C0480b E;
    public static final C0480b F;
    public static final C0480b G;
    public static final C0480b H;
    public static final C0480b I;
    public static final C0480b J;
    public static final C0480b K;
    public static final C0480b L;
    public static final C0480b M;
    public static final C0480b N;
    public static final C0480b O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0480b f22494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0480b f22495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0480b f22496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d<x> f22497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d<k> f22498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d<w9.c.EnumC0388c> f22499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0480b f22500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0480b f22501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0480b f22502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0480b f22503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0480b f22504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0480b f22505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0480b f22506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0480b f22507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d<j> f22508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0480b f22509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final C0480b f22510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0480b f22511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0480b f22512s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final C0480b f22513t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final C0480b f22514u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final C0480b f22515v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final C0480b f22516w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final C0480b f22517x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final C0480b f22518y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final C0480b f22519z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: y9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class C0480b extends d<Boolean> {
        public C0480b(int i10) {
            super(i10, 1, null);
        }

        @Override // y9.b.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i10) {
            return Boolean.valueOf((i10 & (1 << this.f22521a)) != 0);
        }

        @Override // y9.b.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f22521a;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c<E extends kotlin.reflect.jvm.internal.impl.protobuf.j.a> extends d<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final E[] f22520c;

        private static /* synthetic */ void f(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i10 = 31; i10 >= 0; i10--) {
                if (((1 << i10) & length) != 0) {
                    return i10 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // y9.b.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public E d(int i10) {
            int i11 = (1 << this.f22522b) - 1;
            int i12 = this.f22521a;
            int i13 = (i10 & (i11 << i12)) >> i12;
            for (E e10 : this.f22520c) {
                if (e10.h() == i13) {
                    return e10;
                }
            }
            return null;
        }

        public c(int i10, E[] eArr) {
            super(i10, g(eArr), null);
            this.f22520c = eArr;
        }

        @Override // y9.b.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(E e10) {
            return e10.h() << this.f22521a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22522b;

        /* synthetic */ d(int i10, int i11, a aVar) {
            this(i10, i11);
        }

        public abstract E d(int i10);

        public abstract int e(E e10);

        private d(int i10, int i11) {
            this.f22521a = i10;
            this.f22522b = i11;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/j$a;>(Ly9/b$d<*>;[TE;)Ly9/b$d<TE;>; */
        public static d a(d dVar, kotlin.reflect.jvm.internal.impl.protobuf.j.a[] aVarArr) {
            return new c(dVar.f22521a + dVar.f22522b, aVarArr);
        }

        public static C0480b b(d<?> dVar) {
            return new C0480b(dVar.f22521a + dVar.f22522b);
        }

        public static C0480b c() {
            return new C0480b(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021  */
    /* JADX WARN: Code duplicated, block: B:18:0x002b  */
    private static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1) {
            objArr[0] = "modality";
        } else if (i10 == 2) {
            objArr[0] = "kind";
        } else if (i10 == 5) {
            objArr[0] = "modality";
        } else if (i10 == 6) {
            objArr[0] = "memberKind";
        } else if (i10 == 8) {
            objArr[0] = "modality";
        } else if (i10 == 9) {
            objArr[0] = "memberKind";
        } else if (i10 != 11) {
            objArr[0] = "visibility";
        } else {
            objArr[0] = "modality";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i10) {
            case 3:
                objArr[2] = "getConstructorFlags";
                break;
            case 4:
            case 5:
            case 6:
                objArr[2] = "getFunctionFlags";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "getPropertyFlags";
                break;
            case 10:
            case 11:
                objArr[2] = "getAccessorFlags";
                break;
            default:
                objArr[2] = "getClassFlags";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static int b(boolean z10, x xVar, k kVar, boolean z11, boolean z12, boolean z13) {
        if (xVar == null) {
            a(10);
        }
        if (kVar == null) {
            a(11);
        }
        return f22496c.e(Boolean.valueOf(z10)) | f22498e.e(kVar) | f22497d.e(xVar) | J.e(Boolean.valueOf(z11)) | K.e(Boolean.valueOf(z12)) | L.e(Boolean.valueOf(z13));
    }

    static {
        C0480b c0480bC = d.c();
        f22494a = c0480bC;
        f22495b = d.b(c0480bC);
        C0480b c0480bC2 = d.c();
        f22496c = c0480bC2;
        d<x> dVarA = d.a(c0480bC2, x.values());
        f22497d = dVarA;
        d<k> dVarA2 = d.a(dVarA, k.values());
        f22498e = dVarA2;
        d<w9.c.EnumC0388c> dVarA3 = d.a(dVarA2, w9.c.EnumC0388c.values());
        f22499f = dVarA3;
        C0480b c0480bB = d.b(dVarA3);
        f22500g = c0480bB;
        C0480b c0480bB2 = d.b(c0480bB);
        f22501h = c0480bB2;
        C0480b c0480bB3 = d.b(c0480bB2);
        f22502i = c0480bB3;
        C0480b c0480bB4 = d.b(c0480bB3);
        f22503j = c0480bB4;
        C0480b c0480bB5 = d.b(c0480bB4);
        f22504k = c0480bB5;
        f22505l = d.b(c0480bB5);
        C0480b c0480bB6 = d.b(dVarA);
        f22506m = c0480bB6;
        f22507n = d.b(c0480bB6);
        d<j> dVarA4 = d.a(dVarA2, j.values());
        f22508o = dVarA4;
        C0480b c0480bB7 = d.b(dVarA4);
        f22509p = c0480bB7;
        C0480b c0480bB8 = d.b(c0480bB7);
        f22510q = c0480bB8;
        C0480b c0480bB9 = d.b(c0480bB8);
        f22511r = c0480bB9;
        C0480b c0480bB10 = d.b(c0480bB9);
        f22512s = c0480bB10;
        C0480b c0480bB11 = d.b(c0480bB10);
        f22513t = c0480bB11;
        C0480b c0480bB12 = d.b(c0480bB11);
        f22514u = c0480bB12;
        C0480b c0480bB13 = d.b(c0480bB12);
        f22515v = c0480bB13;
        f22516w = d.b(c0480bB13);
        C0480b c0480bB14 = d.b(dVarA4);
        f22517x = c0480bB14;
        C0480b c0480bB15 = d.b(c0480bB14);
        f22518y = c0480bB15;
        C0480b c0480bB16 = d.b(c0480bB15);
        f22519z = c0480bB16;
        C0480b c0480bB17 = d.b(c0480bB16);
        A = c0480bB17;
        C0480b c0480bB18 = d.b(c0480bB17);
        B = c0480bB18;
        C0480b c0480bB19 = d.b(c0480bB18);
        C = c0480bB19;
        C0480b c0480bB20 = d.b(c0480bB19);
        D = c0480bB20;
        C0480b c0480bB21 = d.b(c0480bB20);
        E = c0480bB21;
        F = d.b(c0480bB21);
        C0480b c0480bB22 = d.b(c0480bC2);
        G = c0480bB22;
        C0480b c0480bB23 = d.b(c0480bB22);
        H = c0480bB23;
        I = d.b(c0480bB23);
        C0480b c0480bB24 = d.b(dVarA2);
        J = c0480bB24;
        C0480b c0480bB25 = d.b(c0480bB24);
        K = c0480bB25;
        L = d.b(c0480bB25);
        C0480b c0480bC3 = d.c();
        M = c0480bC3;
        N = d.b(c0480bC3);
        O = d.c();
    }
}
