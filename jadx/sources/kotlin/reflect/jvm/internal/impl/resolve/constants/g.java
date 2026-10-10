package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f13898a;

    public abstract g0 a(h0 h0Var);

    public T b() {
        return this.f13898a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        T tB = b();
        g gVar = obj instanceof g ? (g) obj : null;
        return kotlin.jvm.internal.m.a(tB, gVar != null ? gVar.b() : null);
    }

    public g(T t10) {
        this.f13898a = t10;
    }

    public int hashCode() {
        T tB = b();
        if (tB != null) {
            return tB.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(b());
    }
}
