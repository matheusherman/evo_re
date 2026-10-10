package k4;

import i4.h;
import i4.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f12162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i4.f f12163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f12164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12165d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f12166e;

    public static boolean b(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public b a() {
        return this.f12166e;
    }

    public void c(i4.f fVar) {
        this.f12163b = fVar;
    }

    public void d(int i10) {
        this.f12165d = i10;
    }

    public void e(b bVar) {
        this.f12166e = bVar;
    }

    public void f(h hVar) {
        this.f12162a = hVar;
    }

    public void g(j jVar) {
        this.f12164c = jVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f12162a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f12163b);
        sb2.append("\n version: ");
        sb2.append(this.f12164c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f12165d);
        if (this.f12166e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f12166e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
