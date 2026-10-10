package f3;

import com.google.gson.internal.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? super T> f10016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f10017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10018c;

    protected a() {
        Type typeE = e();
        this.f10017b = typeE;
        this.f10016a = (Class<? super T>) b.k(typeE);
        this.f10018c = typeE.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    public final Class<? super T> c() {
        return this.f10016a;
    }

    public final Type d() {
        return this.f10017b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f10017b, ((a) obj).f10017b);
    }

    public final int hashCode() {
        return this.f10018c;
    }

    public final String toString() {
        return b.t(this.f10017b);
    }

    private Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                return b.b(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    private a(Type type) {
        Objects.requireNonNull(type);
        Type typeB = b.b(type);
        this.f10017b = typeB;
        this.f10016a = (Class<? super T>) b.k(typeB);
        this.f10018c = typeB.hashCode();
    }
}
