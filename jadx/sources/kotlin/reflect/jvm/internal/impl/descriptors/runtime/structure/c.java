package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13017a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f13018b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f13019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f13020b;

        public final Method a() {
            return this.f13020b;
        }

        public final Method b() {
            return this.f13019a;
        }

        public a(Method method, Method method2) {
            this.f13019a = method;
            this.f13020b = method2;
        }
    }

    public final a a(Member member) {
        kotlin.jvm.internal.m.f(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", null), d.e(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List<String> b(Member member) throws IllegalAccessException, InvocationTargetException {
        Method methodA;
        kotlin.jvm.internal.m.f(member, "member");
        a aVarA = f13018b;
        if (aVarA == null) {
            synchronized (this) {
                aVarA = f13018b;
                if (aVarA == null) {
                    aVarA = f13017a.a(member);
                    f13018b = aVarA;
                }
            }
        }
        Method methodB = aVarA.b();
        if (methodB == null || (methodA = aVarA.a()) == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(member, null);
        kotlin.jvm.internal.m.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object objInvoke2 = methodA.invoke(obj, null);
            kotlin.jvm.internal.m.d(objInvoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }

    private c() {
    }
}
