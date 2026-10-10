package y3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f22386c = {1, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f22387a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f22388b = new w();

    h3.q a(int i10, p3.a aVar, int i11) {
        int[] iArrN = y.n(aVar, i11, false, f22386c);
        try {
            return this.f22388b.b(i10, aVar, iArrN);
        } catch (h3.p unused) {
            return this.f22387a.b(i10, aVar, iArrN);
        }
    }

    x() {
    }
}
