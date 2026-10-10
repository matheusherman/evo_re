package p9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f17452a = new m();

    public final String a(Constructor<?> constructor) {
        kotlin.jvm.internal.m.f(constructor, "constructor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        kotlin.jvm.internal.m.e(parameterTypes, "constructor.parameterTypes");
        for (Class<?> parameterType : parameterTypes) {
            kotlin.jvm.internal.m.e(parameterType, "parameterType");
            sb2.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(parameterType));
        }
        sb2.append(")V");
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "sb.toString()");
        return string;
    }

    public final String b(Field field) {
        kotlin.jvm.internal.m.f(field, "field");
        Class<?> type = field.getType();
        kotlin.jvm.internal.m.e(type, "field.type");
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(type);
    }

    public final String c(Method method) {
        kotlin.jvm.internal.m.f(method, "method");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.m.e(parameterTypes, "method.parameterTypes");
        for (Class<?> parameterType : parameterTypes) {
            kotlin.jvm.internal.m.e(parameterType, "parameterType");
            sb2.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(parameterType));
        }
        sb2.append(")");
        Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.m.e(returnType, "method.returnType");
        sb2.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(returnType));
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "sb.toString()");
        return string;
    }

    private m() {
    }
}
