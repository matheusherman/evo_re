package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface c<R, T> {
    Type a();

    T b(b<R> bVar);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class a {
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, g0 g0Var);

        protected static Type b(int i10, ParameterizedType parameterizedType) {
            return k0.g(i10, parameterizedType);
        }

        protected static Class<?> c(Type type) {
            return k0.h(type);
        }
    }
}
