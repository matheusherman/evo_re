package m2;

import androidx.annotation.NonNull;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends Annotation> f15534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<T> f15535b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private @interface a {
    }

    @NonNull
    public static <T> e0<T> a(Class<? extends Annotation> cls, Class<T> cls2) {
        return new e0<>(cls, cls2);
    }

    @NonNull
    public static <T> e0<T> b(Class<T> cls) {
        return new e0<>(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e0.class != obj.getClass()) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (this.f15535b.equals(e0Var.f15535b)) {
            return this.f15534a.equals(e0Var.f15534a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f15535b.hashCode() * 31) + this.f15534a.hashCode();
    }

    public String toString() {
        if (this.f15534a == a.class) {
            return this.f15535b.getName();
        }
        return "@" + this.f15534a.getName() + " " + this.f15535b.getName();
    }

    public e0(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f15534a = cls;
        this.f15535b = cls2;
    }
}
