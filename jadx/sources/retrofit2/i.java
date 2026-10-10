package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface i<F, T> {
    T a(F f10);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class a {
        public i<?, okhttp3.c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, g0 g0Var) {
            return null;
        }

        public i<okhttp3.e0, ?> d(Type type, Annotation[] annotationArr, g0 g0Var) {
            return null;
        }

        public i<?, String> e(Type type, Annotation[] annotationArr, g0 g0Var) {
            return null;
        }

        protected static Type a(int i10, ParameterizedType parameterizedType) {
            return k0.g(i10, parameterizedType);
        }

        protected static Class<?> b(Type type) {
            return k0.h(type);
        }
    }
}
