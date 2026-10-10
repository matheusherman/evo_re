package pa;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f17453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f17454b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(this.f17453a, aVar.f17453a) && m.a(this.f17454b, aVar.f17454b);
    }

    public final T a() {
        return this.f17453a;
    }

    public final T b() {
        return this.f17454b;
    }

    public final T c() {
        return this.f17453a;
    }

    public final T d() {
        return this.f17454b;
    }

    public int hashCode() {
        T t10 = this.f17453a;
        int iHashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        T t11 = this.f17454b;
        return iHashCode + (t11 != null ? t11.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.f17453a + ", upper=" + this.f17454b + ')';
    }

    public a(T t10, T t11) {
        this.f17453a = t10;
        this.f17454b = t11;
    }
}
