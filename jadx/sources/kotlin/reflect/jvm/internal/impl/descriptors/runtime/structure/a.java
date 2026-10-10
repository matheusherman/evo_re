package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13002a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C0222a f13003b;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0222a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f13004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f13005b;

        public final Method a() {
            return this.f13005b;
        }

        public final Method b() {
            return this.f13004a;
        }

        public C0222a(Method method, Method method2) {
            this.f13004a = method;
            this.f13005b = method2;
        }
    }

    private final C0222a b(Object obj) {
        C0222a c0222a = f13003b;
        if (c0222a != null) {
            return c0222a;
        }
        C0222a c0222aA = a(obj);
        f13003b = c0222aA;
        return c0222aA;
    }

    public final Method c(Object recordComponent) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.m.f(recordComponent, "recordComponent");
        Method methodA = b(recordComponent).a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(recordComponent, null);
        kotlin.jvm.internal.m.d(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) objInvoke;
    }

    public final Class<?> d(Object recordComponent) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.m.f(recordComponent, "recordComponent");
        Method methodB = b(recordComponent).b();
        if (methodB == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(recordComponent, null);
        kotlin.jvm.internal.m.d(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) objInvoke;
    }

    private a() {
    }

    private final C0222a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C0222a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
        } catch (NoSuchMethodException unused) {
            return new C0222a(null, null);
        }
    }
}
