package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f14212a = new z();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f14215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f14216d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f14217e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f14218f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f14219g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f14220h;

        static {
            int[] iArr = new int[w9.k.values().length];
            try {
                iArr[w9.k.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[w9.k.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[w9.k.ABSTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[w9.k.SEALED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f14213a = iArr;
            int[] iArr2 = new int[kotlin.reflect.jvm.internal.impl.descriptors.e0.values().length];
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.e0.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.e0.ABSTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.e0.SEALED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f14214b = iArr2;
            int[] iArr3 = new int[w9.x.values().length];
            try {
                iArr3[w9.x.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[w9.x.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[w9.x.PRIVATE_TO_THIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[w9.x.PROTECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[w9.x.PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[w9.x.LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            f14215c = iArr3;
            int[] iArr4 = new int[w9.c.EnumC0388c.values().length];
            try {
                iArr4[w9.c.EnumC0388c.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[w9.c.EnumC0388c.INTERFACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[w9.c.EnumC0388c.ENUM_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr4[w9.c.EnumC0388c.ENUM_ENTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[w9.c.EnumC0388c.ANNOTATION_CLASS.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr4[w9.c.EnumC0388c.OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr4[w9.c.EnumC0388c.COMPANION_OBJECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            f14216d = iArr4;
            int[] iArr5 = new int[kotlin.reflect.jvm.internal.impl.descriptors.f.values().length];
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS.ordinal()] = 5;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.descriptors.f.OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused27) {
            }
            f14217e = iArr5;
            int[] iArr6 = new int[w9.s.c.values().length];
            try {
                iArr6[w9.s.c.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr6[w9.s.c.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr6[w9.s.c.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused30) {
            }
            f14218f = iArr6;
            int[] iArr7 = new int[w9.q.b.c.values().length];
            try {
                iArr7[w9.q.b.c.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr7[w9.q.b.c.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr7[w9.q.b.c.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr7[w9.q.b.c.STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused34) {
            }
            f14219g = iArr7;
            int[] iArr8 = new int[w1.values().length];
            try {
                iArr8[w1.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr8[w1.OUT_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr8[w1.INVARIANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            f14220h = iArr8;
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.f a(w9.c.EnumC0388c enumC0388c) {
        switch (enumC0388c == null ? -1 : a.f14216d[enumC0388c.ordinal()]) {
            case 1:
                return kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS;
            case 2:
                return kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE;
            case 3:
                return kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_CLASS;
            case 4:
                return kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY;
            case 5:
                return kotlin.reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS;
            case 6:
            case 7:
                return kotlin.reflect.jvm.internal.impl.descriptors.f.OBJECT;
            default:
                return kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS;
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e0 b(w9.k kVar) {
        int i10 = kVar == null ? -1 : a.f14213a[kVar.ordinal()];
        if (i10 == 1) {
            return kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL;
        }
        if (i10 == 2) {
            return kotlin.reflect.jvm.internal.impl.descriptors.e0.OPEN;
        }
        if (i10 != 3) {
            return i10 != 4 ? kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL : kotlin.reflect.jvm.internal.impl.descriptors.e0.SEALED;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.e0.ABSTRACT;
    }

    public final w1 c(w9.q.b.c projection) {
        kotlin.jvm.internal.m.f(projection, "projection");
        int i10 = a.f14219g[projection.ordinal()];
        if (i10 == 1) {
            return w1.IN_VARIANCE;
        }
        if (i10 == 2) {
            return w1.OUT_VARIANCE;
        }
        if (i10 == 3) {
            return w1.INVARIANT;
        }
        if (i10 != 4) {
            throw new r8.n();
        }
        throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + projection);
    }

    public final w1 d(w9.s.c variance) {
        kotlin.jvm.internal.m.f(variance, "variance");
        int i10 = a.f14218f[variance.ordinal()];
        if (i10 == 1) {
            return w1.IN_VARIANCE;
        }
        if (i10 == 2) {
            return w1.OUT_VARIANCE;
        }
        if (i10 == 3) {
            return w1.INVARIANT;
        }
        throw new r8.n();
    }

    private z() {
    }
}
