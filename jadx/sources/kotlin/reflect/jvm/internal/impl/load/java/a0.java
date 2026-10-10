package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f13097a = new a0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ba.c f13098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ba.b f13099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ba.b f13100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ba.b f13101e;

    static {
        ba.c cVar = new ba.c("kotlin.jvm.JvmField");
        f13098b = cVar;
        ba.b bVarM = ba.b.m(cVar);
        kotlin.jvm.internal.m.e(bVarM, "topLevel(JVM_FIELD_ANNOTATION_FQ_NAME)");
        f13099c = bVarM;
        ba.b bVarM2 = ba.b.m(new ba.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        kotlin.jvm.internal.m.e(bVarM2, "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
        f13100d = bVarM2;
        ba.b bVarE = ba.b.e("kotlin/jvm/internal/RepeatableContainer");
        kotlin.jvm.internal.m.e(bVarE, "fromString(\"kotlin/jvm/i…nal/RepeatableContainer\")");
        f13101e = bVarE;
    }

    public static final String b(String propertyName) {
        kotlin.jvm.internal.m.f(propertyName, "propertyName");
        if (f(propertyName)) {
            return propertyName;
        }
        return "get" + qa.a.a(propertyName);
    }

    public static final boolean c(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        return ua.n.I(name, "get", false, 2, null) || ua.n.I(name, "is", false, 2, null);
    }

    public static final boolean d(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        return ua.n.I(name, "set", false, 2, null);
    }

    public static final String e(String propertyName) {
        String strA;
        kotlin.jvm.internal.m.f(propertyName, "propertyName");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set");
        if (f(propertyName)) {
            strA = propertyName.substring(2);
            kotlin.jvm.internal.m.e(strA, "this as java.lang.String).substring(startIndex)");
        } else {
            strA = qa.a.a(propertyName);
        }
        sb2.append(strA);
        return sb2.toString();
    }

    public static final boolean f(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        if (!ua.n.I(name, "is", false, 2, null) || name.length() == 2) {
            return false;
        }
        char cCharAt = name.charAt(2);
        return kotlin.jvm.internal.m.h(97, cCharAt) > 0 || kotlin.jvm.internal.m.h(cCharAt, 122) > 0;
    }

    public final ba.b a() {
        return f13101e;
    }

    private a0() {
    }
}
