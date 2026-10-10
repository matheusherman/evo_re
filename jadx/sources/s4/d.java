package s4;

import com.koushikdutta.async.s;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class d extends com.koushikdutta.async.q implements c, o4.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f18282g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    com.koushikdutta.async.h f18284i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f18288m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    q4.a f18289n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.koushikdutta.async.http.h f18283h = new com.koushikdutta.async.http.h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private HashMap<String, Object> f18285j = new HashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private o4.a f18286k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    s.a f18287l = new b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements o4.a {
        a() {
        }

        @Override // o4.a
        public void c(Exception exc) {
            d.this.c(exc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements s.a {
        b() {
        }

        @Override // com.koushikdutta.async.s.a
        public void a(String str) {
            if (d.this.f18282g == null) {
                d.this.f18282g = str;
                if (d.this.f18282g.contains("HTTP/")) {
                    return;
                }
                d.this.G();
                d.this.f18284i.e(new o4.b.a());
                d.this.w(new IOException("data/header received was not not http"));
                return;
            }
            if (!"\r".equals(str)) {
                d.this.f18283h.b(str);
                return;
            }
            d dVar = d.this;
            com.koushikdutta.async.n nVarB = com.koushikdutta.async.http.j.b(dVar.f18284i, com.koushikdutta.async.http.m.f5099b, dVar.f18283h, true);
            d dVar2 = d.this;
            dVar2.f18289n = dVar2.E(dVar2.f18283h);
            d dVar3 = d.this;
            if (dVar3.f18289n == null) {
                dVar3.f18289n = com.koushikdutta.async.http.j.a(nVarB, dVar3.f18286k, d.this.f18283h);
                d dVar4 = d.this;
                if (dVar4.f18289n == null) {
                    dVar4.f18289n = dVar4.H(dVar4.f18283h);
                    d dVar5 = d.this;
                    if (dVar5.f18289n == null) {
                        dVar5.f18289n = new q(dVar5.f18283h.c("Content-Type"));
                    }
                }
            }
            d dVar6 = d.this;
            dVar6.f18289n.l(nVarB, dVar6.f18286k);
            d.this.F();
        }
    }

    protected abstract q4.a E(com.koushikdutta.async.http.h hVar);

    protected abstract void F();

    protected abstract q4.a H(com.koushikdutta.async.http.h hVar);

    public String D() {
        return this.f18282g;
    }

    protected void G() {
        System.out.println("not http!");
    }

    void I(com.koushikdutta.async.h hVar) {
        this.f18284i = hVar;
        s sVar = new s();
        this.f18284i.e(sVar);
        sVar.a(this.f18287l);
        this.f18284i.k(new o4.a.C0319a());
    }

    @Override // s4.c
    public com.koushikdutta.async.http.h b() {
        return this.f18283h;
    }

    @Override // com.koushikdutta.async.o, com.koushikdutta.async.n
    public void e(o4.b bVar) {
        this.f18284i.e(bVar);
    }

    @Override // com.koushikdutta.async.n
    public void f() {
        this.f18284i.f();
    }

    @Override // s4.c
    public String m() {
        return this.f18288m;
    }

    @Override // com.koushikdutta.async.n
    public void pause() {
        this.f18284i.pause();
    }

    @Override // s4.c
    public q4.a q() {
        return this.f18289n;
    }

    @Override // com.koushikdutta.async.q, com.koushikdutta.async.n
    public boolean t() {
        return this.f18284i.t();
    }

    public String toString() {
        com.koushikdutta.async.http.h hVar = this.f18283h;
        return hVar == null ? super.toString() : hVar.h(this.f18282g);
    }

    @Override // com.koushikdutta.async.o, com.koushikdutta.async.n
    public o4.b u() {
        return this.f18284i.u();
    }

    public void c(Exception exc) {
        w(exc);
    }
}
