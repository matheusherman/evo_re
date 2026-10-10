package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class p implements o<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f13611a = new p();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13612a;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.builtins.i.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.builtins.i.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f13612a = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.o
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public n d(n possiblyPrimitiveType) {
        kotlin.jvm.internal.m.f(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (!(possiblyPrimitiveType instanceof n.d)) {
            return possiblyPrimitiveType;
        }
        n.d dVar = (n.d) possiblyPrimitiveType;
        if (dVar.i() == null) {
            return possiblyPrimitiveType;
        }
        String strF = fa.d.c(dVar.i().m()).f();
        kotlin.jvm.internal.m.e(strF, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return c(strF);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.o
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public n b(String representation) {
        fa.e eVar;
        kotlin.jvm.internal.m.f(representation, "representation");
        representation.length();
        char cCharAt = representation.charAt(0);
        fa.e[] eVarArrValues = fa.e.values();
        int length = eVarArrValues.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                eVar = null;
                break;
            }
            eVar = eVarArrValues[i10];
            if (eVar.j().charAt(0) == cCharAt) {
                break;
            }
            i10++;
        }
        if (eVar != null) {
            return new n.d(eVar);
        }
        if (cCharAt == 'V') {
            return new n.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = representation.substring(1);
            kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            return new n.a(b(strSubstring));
        }
        if (cCharAt == 'L') {
            ua.n.R(representation, ';', false, 2, null);
        }
        String strSubstring2 = representation.substring(1, representation.length() - 1);
        kotlin.jvm.internal.m.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return new n.c(strSubstring2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.o
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public n.c c(String internalName) {
        kotlin.jvm.internal.m.f(internalName, "internalName");
        return new n.c(internalName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.o
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public n f(kotlin.reflect.jvm.internal.impl.builtins.i primitiveType) {
        kotlin.jvm.internal.m.f(primitiveType, "primitiveType");
        switch (a.f13612a[primitiveType.ordinal()]) {
            case 1:
                return n.f13599a.a();
            case 2:
                return n.f13599a.c();
            case 3:
                return n.f13599a.b();
            case 4:
                return n.f13599a.h();
            case 5:
                return n.f13599a.f();
            case 6:
                return n.f13599a.e();
            case 7:
                return n.f13599a.g();
            case 8:
                return n.f13599a.d();
            default:
                throw new r8.n();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.o
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public n e() {
        return c("java/lang/Class");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.o
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public String a(n type) {
        String strJ;
        kotlin.jvm.internal.m.f(type, "type");
        if (type instanceof n.a) {
            return '[' + a(((n.a) type).i());
        }
        if (type instanceof n.d) {
            fa.e eVarI = ((n.d) type).i();
            return (eVarI == null || (strJ = eVarI.j()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : strJ;
        }
        if (!(type instanceof n.c)) {
            throw new r8.n();
        }
        return 'L' + ((n.c) type).i() + ';';
    }

    private p() {
    }
}
