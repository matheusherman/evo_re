package b4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f879a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f880b = a.NUMERIC;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    int a() {
        return this.f879a;
    }

    void b(int i10) {
        this.f879a += i10;
    }

    boolean c() {
        return this.f880b == a.ALPHA;
    }

    boolean d() {
        return this.f880b == a.ISO_IEC_646;
    }

    void e() {
        this.f880b = a.ALPHA;
    }

    void f() {
        this.f880b = a.ISO_IEC_646;
    }

    void g() {
        this.f880b = a.NUMERIC;
    }

    void h(int i10) {
        this.f879a = i10;
    }

    m() {
    }
}
