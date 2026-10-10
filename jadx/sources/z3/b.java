package z3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22657b;

    public final int a() {
        return this.f22657b;
    }

    public final int b() {
        return this.f22656a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f22656a == bVar.f22656a && this.f22657b == bVar.f22657b;
    }

    public final int hashCode() {
        return this.f22656a ^ this.f22657b;
    }

    public final String toString() {
        return this.f22656a + "(" + this.f22657b + ')';
    }

    public b(int i10, int i11) {
        this.f22656a = i10;
        this.f22657b = i11;
    }
}
