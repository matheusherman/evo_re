package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13007a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f13008b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f13009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f13010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f13011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f13012d;

        public final Method a() {
            return this.f13010b;
        }

        public final Method b() {
            return this.f13012d;
        }

        public final Method c() {
            return this.f13011c;
        }

        public final Method d() {
            return this.f13009a;
        }

        public a(Method method, Method method2, Method method3, Method method4) {
            this.f13009a = method;
            this.f13010b = method2;
            this.f13011c = method3;
            this.f13012d = method4;
        }
    }

    private final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    private final a b() {
        a aVar = f13008b;
        if (aVar != null) {
            return aVar;
        }
        a aVarA = a();
        f13008b = aVarA;
        return aVarA;
    }

    public final Class<?>[] c(Class<?> clazz) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.m.f(clazz, "clazz");
        Method methodA = b().a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(clazz, null);
        kotlin.jvm.internal.m.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) objInvoke;
    }

    public final Object[] d(Class<?> clazz) {
        kotlin.jvm.internal.m.f(clazz, "clazz");
        Method methodB = b().b();
        if (methodB == null) {
            return null;
        }
        return (Object[]) methodB.invoke(clazz, null);
    }

    public final Boolean e(Class<?> clazz) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.m.f(clazz, "clazz");
        Method methodC = b().c();
        if (methodC == null) {
            return null;
        }
        Object objInvoke = methodC.invoke(clazz, null);
        kotlin.jvm.internal.m.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }

    public final Boolean f(Class<?> clazz) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.m.f(clazz, "clazz");
        Method methodD = b().d();
        if (methodD == null) {
            return null;
        }
        Object objInvoke = methodD.invoke(clazz, null);
        kotlin.jvm.internal.m.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }

    private b() {
    }
}
