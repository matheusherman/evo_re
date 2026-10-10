package d4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9616e = -1;

    boolean h(int i10) {
        return i10 != -1 && this.f9614c == (i10 % 3) * 3;
    }

    int a() {
        return this.f9614c;
    }

    int b() {
        return this.f9613b;
    }

    int c() {
        return this.f9616e;
    }

    int d() {
        return this.f9612a;
    }

    int e() {
        return this.f9615d;
    }

    int f() {
        return this.f9613b - this.f9612a;
    }

    boolean g() {
        return h(this.f9616e);
    }

    void i(int i10) {
        this.f9616e = i10;
    }

    void j() {
        this.f9616e = ((this.f9615d / 30) * 3) + (this.f9614c / 3);
    }

    public String toString() {
        return this.f9616e + "|" + this.f9615d;
    }

    d(int i10, int i11, int i12, int i13) {
        this.f9612a = i10;
        this.f9613b = i11;
        this.f9614c = i12;
        this.f9615d = i13;
    }
}
