package kotlin.reflect.jvm.internal.impl.builtins;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.taobao.sophix.PatchStatus;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.x;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.apache.log4j.net.SyslogAppender;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ba.f f12462g = ba.f.o("<built-ins module>");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private x f12463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ka.i<x> f12464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.i<e> f12465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.i<Collection<q0>> f12466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.g<ba.f, kotlin.reflect.jvm.internal.impl.descriptors.e> f12467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ka.n f12468f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements c9.a<Collection<q0>> {
        a() {
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<q0> invoke() {
            return Arrays.asList(h.this.r().U(k.f12593v), h.this.r().U(k.f12595x), h.this.r().U(k.f12596y), h.this.r().U(k.f12594w));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements c9.a<e> {
        b() {
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e invoke() {
            EnumMap enumMap = new EnumMap(i.class);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (i iVar : i.values()) {
                o0 o0VarQ = h.this.q(iVar.k().f());
                o0 o0VarQ2 = h.this.q(iVar.i().f());
                enumMap.put(iVar, o0VarQ2);
                map.put(o0VarQ, o0VarQ2);
                map2.put(o0VarQ2, o0VarQ);
            }
            return new e(enumMap, map, map2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements c9.l<ba.f, kotlin.reflect.jvm.internal.impl.descriptors.e> {
        c() {
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.e invoke(ba.f fVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarE = h.this.s().e(fVar, r9.d.FROM_BUILTINS);
            if (hVarE == null) {
                throw new AssertionError("Built-in class " + k.f12593v.c(fVar) + " is not found");
            }
            if (hVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarE;
            }
            throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + hVarE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements c9.a<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f12472a;

        d(x xVar) {
            this.f12472a = xVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke() {
            if (h.this.f12463a == null) {
                h.this.f12463a = this.f12472a;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + h.this.f12463a + " (attempting to reset to " + this.f12472a + ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<i, o0> f12474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<g0, o0> f12475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<o0, o0> f12476c;

        /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i10 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private e(Map<i, o0> map, Map<g0, o0> map2, Map<o0, o0> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.f12474a = map;
            this.f12475b = map2;
            this.f12476c = map3;
        }
    }

    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i11 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 72:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 76:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case 143:
            case 146:
            case 147:
            case 149:
            case 157:
            case 158:
            case 159:
            case SyslogAppender.LOG_LOCAL4 /* 160 */:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case PatchStatus.CODE_LOAD_LIB_UNZIP /* 135 */:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 53:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case PatchStatus.CODE_LOAD_LIB_UNDEFINED /* 131 */:
            case PatchStatus.CODE_LOAD_LIB_CPUABIS /* 132 */:
            case PatchStatus.CODE_LOAD_LIB_JSON /* 133 */:
            case PatchStatus.CODE_LOAD_LIB_LOST /* 134 */:
            case 136:
            case PatchStatus.CODE_LOAD_LIB_NS /* 137 */:
            case 138:
            case 139:
            case ModuleDescriptor.MODULE_VERSION /* 140 */:
            case 141:
            case 142:
            case 144:
            case 145:
            case 148:
            case 150:
            case 151:
            case SyslogAppender.LOG_LOCAL3 /* 152 */:
            case 153:
            case 154:
            case 155:
            case 156:
            case 162:
                objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case 67:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 161:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i10) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKCallable";
                break;
            case 23:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case 27:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case 31:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case 35:
                objArr[1] = "getMutableCollection";
                break;
            case 36:
                objArr[1] = "getList";
                break;
            case 37:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case 39:
                objArr[1] = "getMutableSet";
                break;
            case 40:
                objArr[1] = "getMap";
                break;
            case 41:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case 44:
                objArr[1] = "getListIterator";
                break;
            case 45:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case 49:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case 51:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 55:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case 65:
                objArr[1] = "getStringType";
                break;
            case 66:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 53:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 67:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 76:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case PatchStatus.CODE_LOAD_LIB_UNDEFINED /* 131 */:
                objArr[2] = "isULongArray";
                break;
            case PatchStatus.CODE_LOAD_LIB_CPUABIS /* 132 */:
                objArr[2] = "isUnsignedArrayType";
                break;
            case PatchStatus.CODE_LOAD_LIB_JSON /* 133 */:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case PatchStatus.CODE_LOAD_LIB_LOST /* 134 */:
            case PatchStatus.CODE_LOAD_LIB_UNZIP /* 135 */:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case PatchStatus.CODE_LOAD_LIB_NS /* 137 */:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case ModuleDescriptor.MODULE_VERSION /* 140 */:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "mayReturnNonUnitValue";
                break;
            case 144:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 145:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 146:
                objArr[2] = "isMemberOfAny";
                break;
            case 147:
            case 148:
                objArr[2] = "isEnum";
                break;
            case 149:
            case 150:
                objArr[2] = "isComparable";
                break;
            case 151:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case SyslogAppender.LOG_LOCAL3 /* 152 */:
                objArr[2] = "isListOrNullableList";
                break;
            case 153:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 154:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 155:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 156:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 157:
                objArr[2] = "isThrowable";
                break;
            case 158:
                objArr[2] = "isKClass";
                break;
            case 159:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case SyslogAppender.LOG_LOCAL4 /* 160 */:
                objArr[2] = "isCloneable";
                break;
            case 161:
                objArr[2] = "isDeprecated";
                break;
            case 162:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    protected h(ka.n nVar) {
        if (nVar == null) {
            a(0);
        }
        this.f12468f = nVar;
        this.f12466d = nVar.c(new a());
        this.f12465c = nVar.c(new b());
        this.f12467e = nVar.f(new c());
    }

    private static g0 A(g0 g0Var, h0 h0Var) {
        ba.b bVarK;
        ba.b bVarA;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA;
        if (g0Var == null) {
            a(71);
        }
        if (h0Var == null) {
            a(72);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        if (hVarD == null) {
            return null;
        }
        o oVar = o.f12661a;
        if (!oVar.b(hVarD.getName()) || (bVarK = ea.c.k(hVarD)) == null || (bVarA = oVar.a(bVarK)) == null || (eVarA = kotlin.reflect.jvm.internal.impl.descriptors.x.a(h0Var, bVarA)) == null) {
            return null;
        }
        return eVarA.p();
    }

    public static boolean A0(g0 g0Var) {
        if (g0Var == null) {
            a(129);
        }
        return i0(g0Var, k.a.E0.j());
    }

    public static boolean B0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(10);
        }
        while (mVar != null) {
            if (mVar instanceof l0) {
                return ((l0) mVar).d().i(k.f12592u);
            }
            mVar = mVar.b();
        }
        return false;
    }

    public static boolean C0(g0 g0Var) {
        if (g0Var == null) {
            a(142);
        }
        return m0(g0Var, k.a.f12608f);
    }

    public static boolean D0(g0 g0Var) {
        if (g0Var == null) {
            a(PatchStatus.CODE_LOAD_LIB_CPUABIS);
        }
        return x0(g0Var) || A0(g0Var) || y0(g0Var) || z0(g0Var);
    }

    public static i N(g0 g0Var) {
        if (g0Var == null) {
            a(92);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        if (hVarD == null) {
            return null;
        }
        return P(hVarD);
    }

    public static i P(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(77);
        }
        if (k.a.I0.contains(mVar.getName())) {
            return k.a.K0.get(kotlin.reflect.jvm.internal.impl.resolve.e.m(mVar));
        }
        return null;
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.e Q(i iVar) {
        if (iVar == null) {
            a(16);
        }
        return p(iVar.k().f());
    }

    public static i S(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(76);
        }
        if (k.a.H0.contains(mVar.getName())) {
            return k.a.J0.get(kotlin.reflect.jvm.internal.impl.resolve.e.m(mVar));
        }
        return null;
    }

    public static boolean a0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(108);
        }
        return e(eVar, k.a.f12600b);
    }

    public static boolean b0(g0 g0Var) {
        if (g0Var == null) {
            a(139);
        }
        return h0(g0Var, k.a.f12600b);
    }

    public static boolean c0(g0 g0Var) {
        if (g0Var == null) {
            a(88);
        }
        return h0(g0Var, k.a.f12614i);
    }

    public static boolean d0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(89);
        }
        return e(eVar, k.a.f12614i) || P(eVar) != null;
    }

    private static boolean e(kotlin.reflect.jvm.internal.impl.descriptors.h hVar, ba.d dVar) {
        if (hVar == null) {
            a(103);
        }
        if (dVar == null) {
            a(104);
        }
        return hVar.getName().equals(dVar.i()) && dVar.equals(kotlin.reflect.jvm.internal.impl.resolve.e.m(hVar));
    }

    public static boolean e0(g0 g0Var) {
        if (g0Var == null) {
            a(90);
        }
        return c0(g0Var) || q0(g0Var);
    }

    public static boolean f0(g0 g0Var) {
        if (g0Var == null) {
            a(110);
        }
        return i0(g0Var, k.a.f12616j);
    }

    public static boolean g0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(9);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.e.r(mVar, kotlin.reflect.jvm.internal.impl.builtins.b.class, false) != null;
    }

    private static boolean h0(g0 g0Var, ba.d dVar) {
        if (g0Var == null) {
            a(97);
        }
        if (dVar == null) {
            a(98);
        }
        return w0(g0Var.J0(), dVar);
    }

    private static boolean i0(g0 g0Var, ba.d dVar) {
        if (g0Var == null) {
            a(PatchStatus.CODE_LOAD_LIB_LOST);
        }
        if (dVar == null) {
            a(PatchStatus.CODE_LOAD_LIB_UNZIP);
        }
        return h0(g0Var, dVar) && !g0Var.K0();
    }

    public static boolean j0(g0 g0Var) {
        if (g0Var == null) {
            a(141);
        }
        return p0(g0Var);
    }

    public static boolean k0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(161);
        }
        if (mVar.a().getAnnotations().F(k.a.f12646y)) {
            return true;
        }
        if (mVar instanceof u0) {
            u0 u0Var = (u0) mVar;
            boolean zF0 = u0Var.f0();
            v0 getter = u0Var.getGetter();
            w0 setter = u0Var.getSetter();
            if (getter != null && k0(getter) && (!zF0 || (setter != null && k0(setter)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean l0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(158);
        }
        return e(eVar, k.a.f12617j0);
    }

    private static boolean m0(g0 g0Var, ba.d dVar) {
        if (g0Var == null) {
            a(105);
        }
        if (dVar == null) {
            a(106);
        }
        return !g0Var.K0() && h0(g0Var, dVar);
    }

    public static boolean n0(g0 g0Var) {
        if (g0Var == null) {
            a(136);
        }
        return o0(g0Var) && !s1.l(g0Var);
    }

    public static boolean o0(g0 g0Var) {
        if (g0Var == null) {
            a(138);
        }
        return h0(g0Var, k.a.f12602c);
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.e p(String str) {
        if (str == null) {
            a(14);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarInvoke = this.f12467e.invoke(ba.f.l(str));
        if (eVarInvoke == null) {
            a(15);
        }
        return eVarInvoke;
    }

    public static boolean p0(g0 g0Var) {
        if (g0Var == null) {
            a(ModuleDescriptor.MODULE_VERSION);
        }
        return b0(g0Var) && g0Var.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o0 q(String str) {
        if (str == null) {
            a(46);
        }
        o0 o0VarP = p(str).p();
        if (o0VarP == null) {
            a(47);
        }
        return o0VarP;
    }

    public static boolean q0(g0 g0Var) {
        if (g0Var == null) {
            a(91);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        return (hVarD == null || P(hVarD) == null) ? false : true;
    }

    public static boolean r0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(96);
        }
        return S(eVar) != null;
    }

    public static boolean s0(g0 g0Var) {
        if (g0Var == null) {
            a(94);
        }
        return !g0Var.K0() && t0(g0Var);
    }

    public static boolean t0(g0 g0Var) {
        if (g0Var == null) {
            a(95);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        return (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && r0((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD);
    }

    public static boolean u0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(107);
        }
        return e(eVar, k.a.f12600b) || e(eVar, k.a.f12602c);
    }

    public static boolean v0(g0 g0Var) {
        return g0Var != null && m0(g0Var, k.a.f12612h);
    }

    public static boolean w0(g1 g1Var, ba.d dVar) {
        if (g1Var == null) {
            a(101);
        }
        if (dVar == null) {
            a(102);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g1Var.d();
        return (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && e(hVarD, dVar);
    }

    public static boolean x0(g0 g0Var) {
        if (g0Var == null) {
            a(128);
        }
        return i0(g0Var, k.a.D0.j());
    }

    public static boolean y0(g0 g0Var) {
        if (g0Var == null) {
            a(130);
        }
        return i0(g0Var, k.a.F0.j());
    }

    public static boolean z0(g0 g0Var) {
        if (g0Var == null) {
            a(PatchStatus.CODE_LOAD_LIB_UNDEFINED);
        }
        return i0(g0Var, k.a.G0.j());
    }

    public o0 B() {
        o0 o0VarR = R(i.FLOAT);
        if (o0VarR == null) {
            a(60);
        }
        return o0VarR;
    }

    public o0 D() {
        o0 o0VarR = R(i.INT);
        if (o0VarR == null) {
            a(58);
        }
        return o0VarR;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e E() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = o(k.a.f12617j0.l());
        if (eVarO == null) {
            a(21);
        }
        return eVarO;
    }

    public void E0(x xVar) {
        if (xVar == null) {
            a(1);
        }
        this.f12468f.a(new d(xVar));
    }

    public o0 F() {
        o0 o0VarR = R(i.LONG);
        if (o0VarR == null) {
            a(59);
        }
        return o0VarR;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e G() {
        return p("Nothing");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e K() {
        return p("Number");
    }

    protected n9.c M() {
        n9.c.b bVar = n9.c.b.f16097a;
        if (bVar == null) {
            a(4);
        }
        return bVar;
    }

    public o0 O(i iVar) {
        if (iVar == null) {
            a(73);
        }
        o0 o0Var = this.f12465c.invoke().f12474a.get(iVar);
        if (o0Var == null) {
            a(74);
        }
        return o0Var;
    }

    public o0 R(i iVar) {
        if (iVar == null) {
            a(53);
        }
        o0 o0VarP = Q(iVar).p();
        if (o0VarP == null) {
            a(54);
        }
        return o0VarP;
    }

    public o0 T() {
        o0 o0VarR = R(i.SHORT);
        if (o0VarR == null) {
            a(57);
        }
        return o0VarR;
    }

    protected ka.n U() {
        ka.n nVar = this.f12468f;
        if (nVar == null) {
            a(6);
        }
        return nVar;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e V() {
        return p("String");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e X(int i10) {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = o(k.f12585n.c(ba.f.l(k.d(i10))));
        if (eVarO == null) {
            a(18);
        }
        return eVarO;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e Y() {
        return p("Unit");
    }

    protected void f(boolean z10) {
        x xVar = new x(f12462g, this.f12468f, this, null);
        this.f12463a = xVar;
        xVar.O0(kotlin.reflect.jvm.internal.impl.builtins.a.f12454a.a().a(this.f12468f, this.f12463a, v(), M(), g(), z10));
        x xVar2 = this.f12463a;
        xVar2.U0(xVar2);
    }

    protected n9.a g() {
        n9.a.C0311a c0311a = n9.a.C0311a.f16095a;
        if (c0311a == null) {
            a(3);
        }
        return c0311a;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e h() {
        return p("Any");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e j() {
        return p("Array");
    }

    public g0 k(g0 g0Var) {
        g0 g0VarA;
        if (g0Var == null) {
            a(67);
        }
        if (c0(g0Var)) {
            if (g0Var.H0().size() != 1) {
                throw new IllegalStateException();
            }
            g0 type = g0Var.H0().get(0).getType();
            if (type == null) {
                a(68);
            }
            return type;
        }
        g0 g0VarN = s1.n(g0Var);
        o0 o0Var = this.f12465c.invoke().f12476c.get(g0VarN);
        if (o0Var != null) {
            return o0Var;
        }
        h0 h0VarI = kotlin.reflect.jvm.internal.impl.resolve.e.i(g0VarN);
        if (h0VarI != null && (g0VarA = A(g0VarN, h0VarI)) != null) {
            return g0VarA;
        }
        throw new IllegalStateException("not array: " + g0Var);
    }

    public o0 l(w1 w1Var, g0 g0Var) {
        if (w1Var == null) {
            a(82);
        }
        if (g0Var == null) {
            a(83);
        }
        o0 o0VarM = m(w1Var, g0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b());
        if (o0VarM == null) {
            a(84);
        }
        return o0VarM;
    }

    public o0 m(w1 w1Var, g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (w1Var == null) {
            a(78);
        }
        if (g0Var == null) {
            a(79);
        }
        if (gVar == null) {
            a(80);
        }
        o0 o0VarG = kotlin.reflect.jvm.internal.impl.types.h0.g(d1.b(gVar), j(), Collections.singletonList(new m1(w1Var, g0Var)));
        if (o0VarG == null) {
            a(81);
        }
        return o0VarG;
    }

    public o0 n() {
        o0 o0VarR = R(i.BOOLEAN);
        if (o0VarR == null) {
            a(63);
        }
        return o0VarR;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e o(ba.c cVar) {
        if (cVar == null) {
            a(12);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarD = s.d(r(), cVar, r9.d.FROM_BUILTINS);
        if (eVarD == null) {
            a(13);
        }
        return eVarD;
    }

    public x r() {
        if (this.f12463a == null) {
            this.f12463a = this.f12464b.invoke();
        }
        x xVar = this.f12463a;
        if (xVar == null) {
            a(7);
        }
        return xVar;
    }

    public o0 t() {
        o0 o0VarR = R(i.BYTE);
        if (o0VarR == null) {
            a(56);
        }
        return o0VarR;
    }

    public o0 u() {
        o0 o0VarR = R(i.CHAR);
        if (o0VarR == null) {
            a(62);
        }
        return o0VarR;
    }

    protected Iterable<n9.b> v() {
        List listSingletonList = Collections.singletonList(new m9.a(this.f12468f, r()));
        if (listSingletonList == null) {
            a(5);
        }
        return listSingletonList;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e w() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = o(k.a.V);
        if (eVarO == null) {
            a(34);
        }
        return eVarO;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e x() {
        return p("Comparable");
    }

    public o0 z() {
        o0 o0VarR = R(i.DOUBLE);
        if (o0VarR == null) {
            a(61);
        }
        return o0VarR;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.e C(int i10) {
        return p(k.b(i10));
    }

    public o0 H() {
        o0 o0VarP = G().p();
        if (o0VarP == null) {
            a(48);
        }
        return o0VarP;
    }

    public o0 I() {
        o0 o0VarQ0 = i().N0(true);
        if (o0VarQ0 == null) {
            a(51);
        }
        return o0VarQ0;
    }

    public o0 J() {
        o0 o0VarQ0 = H().N0(true);
        if (o0VarQ0 == null) {
            a(49);
        }
        return o0VarQ0;
    }

    public o0 L() {
        o0 o0VarP = K().p();
        if (o0VarP == null) {
            a(55);
        }
        return o0VarP;
    }

    public o0 W() {
        o0 o0VarP = V().p();
        if (o0VarP == null) {
            a(65);
        }
        return o0VarP;
    }

    public o0 Z() {
        o0 o0VarP = Y().p();
        if (o0VarP == null) {
            a(64);
        }
        return o0VarP;
    }

    public o0 i() {
        o0 o0VarP = h().p();
        if (o0VarP == null) {
            a(50);
        }
        return o0VarP;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h s() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = r().U(k.f12593v).n();
        if (hVarN == null) {
            a(11);
        }
        return hVarN;
    }

    public o0 y() {
        o0 o0VarI = I();
        if (o0VarI == null) {
            a(52);
        }
        return o0VarI;
    }
}
