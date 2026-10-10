package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f14028c;

        static {
            int[] iArr = new int[w9.j.values().length];
            try {
                iArr[w9.j.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[w9.j.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[w9.j.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[w9.j.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f14026a = iArr;
            int[] iArr2 = new int[kotlin.reflect.jvm.internal.impl.descriptors.b.a.values().length];
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.b.a.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f14027b = iArr2;
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
            f14028c = iArr3;
        }
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.u a(z zVar, w9.x xVar) {
        kotlin.jvm.internal.m.f(zVar, "<this>");
        switch (xVar == null ? -1 : a.f14028c[xVar.ordinal()]) {
            case 1:
                kotlin.reflect.jvm.internal.impl.descriptors.u INTERNAL = kotlin.reflect.jvm.internal.impl.descriptors.t.f13067d;
                kotlin.jvm.internal.m.e(INTERNAL, "INTERNAL");
                return INTERNAL;
            case 2:
                kotlin.reflect.jvm.internal.impl.descriptors.u PRIVATE = kotlin.reflect.jvm.internal.impl.descriptors.t.f13064a;
                kotlin.jvm.internal.m.e(PRIVATE, "PRIVATE");
                return PRIVATE;
            case 3:
                kotlin.reflect.jvm.internal.impl.descriptors.u PRIVATE_TO_THIS = kotlin.reflect.jvm.internal.impl.descriptors.t.f13065b;
                kotlin.jvm.internal.m.e(PRIVATE_TO_THIS, "PRIVATE_TO_THIS");
                return PRIVATE_TO_THIS;
            case 4:
                kotlin.reflect.jvm.internal.impl.descriptors.u PROTECTED = kotlin.reflect.jvm.internal.impl.descriptors.t.f13066c;
                kotlin.jvm.internal.m.e(PROTECTED, "PROTECTED");
                return PROTECTED;
            case 5:
                kotlin.reflect.jvm.internal.impl.descriptors.u PUBLIC = kotlin.reflect.jvm.internal.impl.descriptors.t.f13068e;
                kotlin.jvm.internal.m.e(PUBLIC, "PUBLIC");
                return PUBLIC;
            case 6:
                kotlin.reflect.jvm.internal.impl.descriptors.u LOCAL = kotlin.reflect.jvm.internal.impl.descriptors.t.f13069f;
                kotlin.jvm.internal.m.e(LOCAL, "LOCAL");
                return LOCAL;
            default:
                kotlin.reflect.jvm.internal.impl.descriptors.u PRIVATE2 = kotlin.reflect.jvm.internal.impl.descriptors.t.f13064a;
                kotlin.jvm.internal.m.e(PRIVATE2, "PRIVATE");
                return PRIVATE2;
        }
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.b.a b(z zVar, w9.j jVar) {
        kotlin.jvm.internal.m.f(zVar, "<this>");
        int i10 = jVar == null ? -1 : a.f14026a[jVar.ordinal()];
        if (i10 == 1) {
            return kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION;
        }
        if (i10 == 2) {
            return kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE;
        }
        if (i10 != 3) {
            return i10 != 4 ? kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION : kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.b.a.DELEGATION;
    }
}
