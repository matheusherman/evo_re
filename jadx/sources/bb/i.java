package bb;

import eb.j;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f1044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1045b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f1046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1047d;

    private void e(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1044a.append("\t");
        }
    }

    private void g(eb.a aVar) {
        this.f1044a.append(" ");
        String strC = this.f1046c.c(aVar.b());
        if (strC == null) {
            strC = aVar.b();
        }
        if (strC != null && !strC.isEmpty()) {
            StringBuilder sb2 = this.f1044a;
            sb2.append(strC);
            sb2.append(':');
        }
        String strA = gb.h.a(aVar.d());
        StringBuilder sb3 = this.f1044a;
        sb3.append(aVar.a());
        sb3.append('=');
        sb3.append('\"');
        sb3.append(strA);
        sb3.append('\"');
    }

    @Override // bb.h
    public void a(eb.f fVar) {
        this.f1046c.d(fVar);
    }

    @Override // bb.h
    public void b(j jVar) {
        if (this.f1047d) {
            this.f1044a.append(">\n");
        }
        int i10 = this.f1045b;
        this.f1045b = i10 + 1;
        e(i10);
        this.f1044a.append('<');
        if (jVar.c() != null) {
            String strC = this.f1046c.c(jVar.c());
            if (strC != null) {
                StringBuilder sb2 = this.f1044a;
                sb2.append(strC);
                sb2.append(":");
            } else {
                StringBuilder sb3 = this.f1044a;
                sb3.append(jVar.c());
                sb3.append(":");
            }
        }
        this.f1044a.append(jVar.b());
        List<g.b> listB = this.f1046c.b();
        if (!listB.isEmpty()) {
            for (g.b bVar : listB) {
                StringBuilder sb4 = this.f1044a;
                sb4.append(" xmlns:");
                sb4.append(bVar.c());
                sb4.append("=\"");
                sb4.append(bVar.d());
                sb4.append("\"");
            }
        }
        this.f1047d = true;
        for (eb.a aVar : jVar.a().g()) {
            g(aVar);
        }
    }

    @Override // bb.h
    public void c(eb.g gVar) {
        this.f1046c.a(gVar);
    }

    @Override // bb.h
    public void d(eb.h hVar) {
        int i10 = this.f1045b - 1;
        this.f1045b = i10;
        if (this.f1047d) {
            this.f1044a.append(" />\n");
        } else {
            e(i10);
            this.f1044a.append("</");
            if (hVar.b() != null) {
                String strC = this.f1046c.c(hVar.b());
                if (strC == null) {
                    strC = hVar.b();
                }
                StringBuilder sb2 = this.f1044a;
                sb2.append(strC);
                sb2.append(":");
            }
            this.f1044a.append(hVar.a());
            this.f1044a.append(">\n");
        }
        this.f1047d = false;
    }

    public String f() {
        return this.f1044a.toString();
    }

    public i() {
        StringBuilder sb2 = new StringBuilder();
        this.f1044a = sb2;
        sb2.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        this.f1046c = new g();
    }
}
