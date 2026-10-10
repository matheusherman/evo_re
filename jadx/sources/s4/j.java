package s4;

import android.text.TextUtils;
import com.koushikdutta.async.y;
import com.pengrad.telegrambot.model.request.InlineQueryResultVideo;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.koushikdutta.async.h f18301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f18302d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    com.koushikdutta.async.p f18304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    o4.e f18305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f18306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f18307i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    o4.a f18310l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.koushikdutta.async.http.h f18299a = new com.koushikdutta.async.http.h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f18300b = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f18303e = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f18308j = 200;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f18309k = "HTTP/1.1";

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.f18307i = true;
    }

    public static /* synthetic */ void g(final j jVar, boolean z10, Exception exc) {
        if (exc != null) {
            jVar.q(exc);
            return;
        }
        if (z10) {
            r4.c cVar = new r4.c(jVar.f18301c);
            cVar.h(0);
            jVar.f18304f = cVar;
        } else {
            jVar.f18304f = jVar.f18301c;
        }
        jVar.f18304f.i(jVar.f18310l);
        jVar.f18310l = null;
        jVar.f18304f.p(jVar.f18305g);
        jVar.f18305g = null;
        if (jVar.f18306h) {
            jVar.end();
        } else {
            jVar.a().n(new Runnable() { // from class: s4.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.f(this.f18298a);
                }
            });
        }
    }

    @Override // com.koushikdutta.async.p
    public com.koushikdutta.async.f a() {
        return this.f18301c.a();
    }

    @Override // s4.e
    public int code() {
        return this.f18308j;
    }

    @Override // s4.e
    public void d(String str) {
        String strC = this.f18299a.c("Content-Type");
        if (strC == null) {
            strC = "text/html; charset=utf-8";
        }
        u(strC, str);
    }

    @Override // s4.e, com.koushikdutta.async.p
    public void end() {
        if (this.f18306h) {
            return;
        }
        this.f18306h = true;
        boolean z10 = this.f18303e;
        if (z10 && this.f18304f == null) {
            return;
        }
        if (!z10) {
            this.f18299a.e("Transfer-Encoding");
        }
        com.koushikdutta.async.p pVar = this.f18304f;
        if (pVar instanceof r4.c) {
            pVar.end();
            return;
        }
        if (this.f18303e) {
            m();
        } else if (!this.f18302d.m().equalsIgnoreCase("HEAD")) {
            u(InlineQueryResultVideo.MIME_TEXT_HTML, "");
        } else {
            w();
            m();
        }
    }

    public c h() {
        return this.f18302d;
    }

    @Override // com.koushikdutta.async.p
    public void i(o4.a aVar) {
        com.koushikdutta.async.p pVar = this.f18304f;
        if (pVar != null) {
            pVar.i(aVar);
        } else {
            this.f18310l = aVar;
        }
    }

    @Override // s4.e
    public void j(String str, byte[] bArr) {
        t(str, new com.koushikdutta.async.l(bArr));
    }

    void k() {
        final boolean z10;
        if (this.f18303e) {
            return;
        }
        this.f18303e = true;
        String strC = this.f18299a.c("Transfer-Encoding");
        if ("".equals(strC)) {
            this.f18299a.f("Transfer-Encoding");
        }
        boolean z11 = ("Chunked".equalsIgnoreCase(strC) || strC == null) && !"close".equalsIgnoreCase(this.f18299a.c("Connection"));
        if (this.f18300b < 0) {
            String strC2 = this.f18299a.c("Content-Length");
            if (!TextUtils.isEmpty(strC2)) {
                this.f18300b = Long.valueOf(strC2).longValue();
            }
        }
        if (this.f18300b >= 0 || !z11) {
            z10 = false;
        } else {
            this.f18299a.g("Transfer-Encoding", "Chunked");
            z10 = true;
        }
        y.c(this.f18301c, this.f18299a.h(String.format(Locale.ENGLISH, "%s %s %s", this.f18309k, Integer.valueOf(this.f18308j), b.h(this.f18308j))).getBytes(), new o4.a() { // from class: s4.f
            @Override // o4.a
            public final void c(Exception exc) {
                j.g(this.f18292a, z10, exc);
            }
        });
    }

    @Override // com.koushikdutta.async.p
    public o4.e l() {
        com.koushikdutta.async.p pVar = this.f18304f;
        return pVar != null ? pVar.l() : this.f18305g;
    }

    @Override // com.koushikdutta.async.p
    public void n(com.koushikdutta.async.l lVar) {
        com.koushikdutta.async.p pVar;
        if (!this.f18303e) {
            k();
        }
        if (lVar.A() == 0 || (pVar = this.f18304f) == null) {
            return;
        }
        pVar.n(lVar);
    }

    @Override // com.koushikdutta.async.p
    public void p(o4.e eVar) {
        com.koushikdutta.async.p pVar = this.f18304f;
        if (pVar != null) {
            pVar.p(eVar);
        } else {
            this.f18305g = eVar;
        }
    }

    @Override // s4.e
    public e r(int i10) {
        this.f18308j = i10;
        return this;
    }

    @Override // s4.e
    public String s() {
        return this.f18309k;
    }

    public String toString() {
        return this.f18299a == null ? super.toString() : this.f18299a.h(String.format(Locale.ENGLISH, "%s %s %s", this.f18309k, Integer.valueOf(this.f18308j), b.h(this.f18308j)));
    }

    public void u(String str, String str2) {
        try {
            j(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    j(com.koushikdutta.async.h hVar, d dVar) {
        this.f18301c = hVar;
        this.f18302d = dVar;
        if (com.koushikdutta.async.http.j.c(com.koushikdutta.async.http.m.f5099b, dVar.b())) {
            this.f18299a.g("Connection", "Keep-Alive");
        }
    }

    public static /* synthetic */ void e(final j jVar, com.koushikdutta.async.l lVar, String str) {
        jVar.getClass();
        long jA = lVar.A();
        jVar.f18300b = jA;
        jVar.f18299a.g("Content-Length", Long.toString(jA));
        if (str != null) {
            jVar.f18299a.g("Content-Type", str);
        }
        y.b(jVar, lVar, new o4.a() { // from class: s4.h
            @Override // o4.a
            public final void c(Exception exc) {
                this.f18297a.m();
            }
        });
    }

    public static /* synthetic */ void f(j jVar) {
        o4.e eVarL = jVar.l();
        if (eVarL != null) {
            eVarL.a();
        }
    }

    @Override // o4.a
    public void c(Exception exc) {
        end();
    }

    public void t(final String str, final com.koushikdutta.async.l lVar) {
        a().n(new Runnable() { // from class: s4.g
            @Override // java.lang.Runnable
            public final void run() {
                j.e(this.f18294a, lVar, str);
            }
        });
    }

    public void w() {
        k();
    }

    protected void q(Exception exc) {
    }
}
