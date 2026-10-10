package b4;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class p extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f890c;

    int b() {
        return this.f889b;
    }

    int c() {
        return this.f890c;
    }

    boolean d() {
        return this.f889b == 10;
    }

    boolean e() {
        return this.f890c == 10;
    }

    p(int i10, int i11, int i12) throws h3.h {
        super(i10);
        if (i11 >= 0 && i11 <= 10 && i12 >= 0 && i12 <= 10) {
            this.f889b = i11;
            this.f890c = i12;
            return;
        }
        throw h3.h.a();
    }
}
