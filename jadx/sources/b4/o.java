package b4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f888d;

    o(int i10, String str) {
        super(i10);
        this.f886b = str;
        this.f888d = false;
        this.f887c = 0;
    }

    String b() {
        return this.f886b;
    }

    int c() {
        return this.f887c;
    }

    boolean d() {
        return this.f888d;
    }

    o(int i10, String str, int i11) {
        super(i10);
        this.f888d = true;
        this.f887c = i11;
        this.f886b = str;
    }
}
