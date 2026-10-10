package m2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0<?> f15575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15577c;

    private r(Class<?> cls, int i10, int i11) {
        this((e0<?>) e0.b(cls), i10, i11);
    }

    private r(e0<?> e0Var, int i10, int i11) {
        this.f15575a = (e0) d0.c(e0Var, "Null dependency anInterface.");
        this.f15576b = i10;
        this.f15577c = i11;
    }

    private static String a(int i10) {
        if (i10 == 0) {
            return "direct";
        }
        if (i10 == 1) {
            return "provider";
        }
        if (i10 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i10);
    }

    public static r g(Class<?> cls) {
        return new r(cls, 0, 1);
    }

    public static r h(Class<?> cls) {
        return new r(cls, 1, 0);
    }

    public static r i(e0<?> e0Var) {
        return new r(e0Var, 1, 0);
    }

    public static r j(Class<?> cls) {
        return new r(cls, 1, 1);
    }

    public static r k(Class<?> cls) {
        return new r(cls, 2, 0);
    }

    public e0<?> b() {
        return this.f15575a;
    }

    public boolean c() {
        return this.f15577c == 2;
    }

    public boolean d() {
        return this.f15577c == 0;
    }

    public boolean e() {
        return this.f15576b == 1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f15575a.equals(rVar.f15575a) && this.f15576b == rVar.f15576b && this.f15577c == rVar.f15577c) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f15576b == 2;
    }

    public int hashCode() {
        return ((((this.f15575a.hashCode() ^ 1000003) * 1000003) ^ this.f15576b) * 1000003) ^ this.f15577c;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f15575a);
        sb2.append(", type=");
        int i10 = this.f15576b;
        if (i10 == 1) {
            str = "required";
        } else {
            str = i10 == 0 ? "optional" : "set";
        }
        sb2.append(str);
        sb2.append(", injection=");
        sb2.append(a(this.f15577c));
        sb2.append("}");
        return sb2.toString();
    }
}
