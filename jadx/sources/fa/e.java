package fa;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum e {
    BOOLEAN(i.BOOLEAN, TypedValues.Custom.S_BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(i.CHAR, "char", "C", "java.lang.Character"),
    BYTE(i.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(i.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short"),
    INT(i.INT, "int", "I", "java.lang.Integer"),
    FLOAT(i.FLOAT, TypedValues.Custom.S_FLOAT, "F", "java.lang.Float"),
    LONG(i.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(i.DOUBLE, "double", "D", "java.lang.Double");


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Set<ba.c> f10096i = new HashSet();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<String, e> f10097j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<i, e> f10098k = new EnumMap(i.class);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<String, e> f10099l = new HashMap();
    private final String desc;
    private final String name;
    private final i primitiveType;
    private final ba.c wrapperFqName;

    /* JADX WARN: Code duplicated, block: B:12:0x0017  */
    /* JADX WARN: Code duplicated, block: B:7:0x000c  */
    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 2 && i10 != 4) {
            switch (i10) {
                case 10:
                case 11:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 2 && i10 != 4) {
            switch (i10) {
                case 10:
                case 11:
                case 12:
                case 13:
                    i11 = 2;
                    break;
                default:
                    i11 = 3;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 7:
                objArr[0] = "name";
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            case 3:
                objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                break;
            case 5:
            case 8:
                objArr[0] = "desc";
                break;
            case 6:
                objArr[0] = "primitiveType";
                break;
            case 9:
                objArr[0] = "wrapperClassName";
                break;
            default:
                objArr[0] = "className";
                break;
        }
        if (i10 != 2 && i10 != 4) {
            switch (i10) {
                case 10:
                    objArr[1] = "getPrimitiveType";
                    break;
                case 11:
                    objArr[1] = "getJavaKeywordName";
                    break;
                case 12:
                    objArr[1] = "getDesc";
                    break;
                case 13:
                    objArr[1] = "getWrapperFqName";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                    break;
            }
        } else {
            objArr[1] = "get";
        }
        switch (i10) {
            case 1:
            case 3:
                objArr[2] = "get";
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 5:
                objArr[2] = "getByDesc";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "isWrapperClassName";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 4) {
            switch (i10) {
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    static {
        for (e eVar : values()) {
            f10096i.add(eVar.m());
            f10097j.put(eVar.k(), eVar);
            f10098k.put(eVar.l(), eVar);
            f10099l.put(eVar.j(), eVar);
        }
    }

    e(i iVar, String str, String str2, String str3) {
        if (iVar == null) {
            a(6);
        }
        if (str == null) {
            a(7);
        }
        if (str2 == null) {
            a(8);
        }
        if (str3 == null) {
            a(9);
        }
        this.primitiveType = iVar;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new ba.c(str3);
    }

    public static e f(String str) {
        if (str == null) {
            a(1);
        }
        e eVar = f10097j.get(str);
        if (eVar != null) {
            return eVar;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    public static e i(i iVar) {
        if (iVar == null) {
            a(3);
        }
        e eVar = f10098k.get(iVar);
        if (eVar == null) {
            a(4);
        }
        return eVar;
    }

    public String j() {
        String str = this.desc;
        if (str == null) {
            a(12);
        }
        return str;
    }

    public String k() {
        String str = this.name;
        if (str == null) {
            a(11);
        }
        return str;
    }

    public i l() {
        i iVar = this.primitiveType;
        if (iVar == null) {
            a(10);
        }
        return iVar;
    }

    public ba.c m() {
        ba.c cVar = this.wrapperFqName;
        if (cVar == null) {
            a(13);
        }
        return cVar;
    }
}
