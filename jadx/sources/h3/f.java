package h3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10780b;

    public int a() {
        return this.f10780b;
    }

    public int b() {
        return this.f10779a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f10779a == fVar.f10779a && this.f10780b == fVar.f10780b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f10779a * 32713) + this.f10780b;
    }

    public String toString() {
        return this.f10779a + "x" + this.f10780b;
    }
}
