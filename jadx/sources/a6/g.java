package a6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z5.b f139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private z5.a f140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private z5.c f141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f142d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f143e;

    public static boolean b(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public b a() {
        return this.f143e;
    }

    public void c(z5.a aVar) {
        this.f140b = aVar;
    }

    public void d(int i10) {
        this.f142d = i10;
    }

    public void e(b bVar) {
        this.f143e = bVar;
    }

    public void f(z5.b bVar) {
        this.f139a = bVar;
    }

    public void g(z5.c cVar) {
        this.f141c = cVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f139a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f140b);
        sb2.append("\n version: ");
        sb2.append(this.f141c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f142d);
        if (this.f143e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f143e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
