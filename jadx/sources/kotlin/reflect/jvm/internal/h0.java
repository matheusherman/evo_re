package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a<T> extends c<T> implements c9.a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c9.a<T> f12438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile SoftReference<Object> f12439c;

        private static /* synthetic */ void e(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        public a(T t10, c9.a<T> aVar) {
            if (aVar == null) {
                e(0);
            }
            this.f12439c = null;
            this.f12438b = aVar;
            if (t10 != null) {
                this.f12439c = new SoftReference<>(a(t10));
            }
        }

        @Override // kotlin.reflect.jvm.internal.h0.c, c9.a
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.f12439c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            T tInvoke = this.f12438b.invoke();
            this.f12439c = new SoftReference<>(a(tInvoke));
            return tInvoke;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c9.a<T> f12440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile Object f12441c;

        private static /* synthetic */ void e(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        public b(c9.a<T> aVar) {
            if (aVar == null) {
                e(0);
            }
            this.f12441c = null;
            this.f12440b = aVar;
        }

        @Override // kotlin.reflect.jvm.internal.h0.c, c9.a
        public T invoke() {
            Object obj = this.f12441c;
            if (obj != null) {
                return c(obj);
            }
            T tInvoke = this.f12440b.invoke();
            this.f12441c = a(tInvoke);
            return tInvoke;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Object f12442a = new a();

        public abstract T invoke();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a {
            a() {
            }
        }

        protected Object a(T t10) {
            return t10 == null ? f12442a : t10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T c(Object obj) {
            if (obj == f12442a) {
                return null;
            }
            return obj;
        }

        public final T b(Object obj, Object obj2) {
            return invoke();
        }
    }

    private static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i10 == 1 || i10 == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <T> b<T> b(c9.a<T> aVar) {
        if (aVar == null) {
            a(0);
        }
        return new b<>(aVar);
    }

    public static <T> a<T> c(c9.a<T> aVar) {
        if (aVar == null) {
            a(2);
        }
        return d(null, aVar);
    }

    public static <T> a<T> d(T t10, c9.a<T> aVar) {
        if (aVar == null) {
            a(1);
        }
        return new a<>(t10, aVar);
    }
}
