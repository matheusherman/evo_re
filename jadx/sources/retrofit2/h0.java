package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
abstract class h0<T> {
    abstract T a(Object[] objArr);

    h0() {
    }

    static <T> h0<T> b(g0 g0Var, Method method) {
        e0 e0VarB = e0.b(g0Var, method);
        Type genericReturnType = method.getGenericReturnType();
        if (!k0.j(genericReturnType)) {
            if (genericReturnType != Void.TYPE) {
                return n.f(g0Var, method, e0VarB);
            }
            throw k0.m(method, "Service methods cannot return void.", new Object[0]);
        }
        throw k0.m(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
    }
}
