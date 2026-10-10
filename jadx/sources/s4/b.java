package s4;

import android.annotation.TargetApi;
import android.util.Log;
import com.koushikdutta.async.y;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.apache.log4j.varia.ExternallyRolledFileAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@TargetApi(5)
public class b extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Hashtable<Integer, String> f18262h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList<com.koushikdutta.async.g> f18263e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    o4.c f18264f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    o4.a f18265g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements o4.c {

        /* JADX INFO: renamed from: s4.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0351a extends l.a {
            final o4.d<Exception> A;
            final /* synthetic */ com.koushikdutta.async.h B;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            l.a f18267q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            n f18268r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            String f18269s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            String f18270t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            boolean f18271u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            boolean f18272v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            j f18273w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            boolean f18274x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            boolean f18275y;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            final Runnable f18276z;

            /* JADX INFO: renamed from: s4.b$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            class RunnableC0352a implements Runnable {
                RunnableC0352a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Log.i("HTTP", "Done");
                }
            }

            /* JADX INFO: renamed from: s4.b$a$a$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            class C0353b implements o4.d<Exception> {
                C0353b() {
                }
            }

            /* JADX INFO: renamed from: s4.b$a$a$c */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            class c implements o4.a {
                c() {
                }

                @Override // o4.a
                public void c(Exception exc) {
                    C0351a.this.f();
                    if (exc != null) {
                        C0351a.this.w(exc);
                        return;
                    }
                    C0351a c0351a = C0351a.this;
                    c0351a.f18274x = true;
                    c0351a.F();
                }
            }

            /* JADX INFO: renamed from: s4.b$a$a$d */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            class d extends j {
                d(com.koushikdutta.async.h hVar, s4.d dVar) {
                    super(hVar, dVar);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // s4.j
                public void m() {
                    C0351a.this.f18271u = true;
                    super.m();
                    this.f18301c.k(null);
                    b.this.m(h(), C0351a.this.f18273w);
                    C0351a.this.L();
                }

                @Override // s4.j
                protected void q(Exception exc) {
                    super.q(exc);
                    if (exc != null) {
                        C0351a.this.B.e(new o4.b.a());
                        C0351a.this.B.k(new o4.a.C0319a());
                        C0351a.this.B.close();
                    }
                }
            }

            /* JADX INFO: renamed from: s4.b$a$a$e */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            class e extends o4.b.a {
                e() {
                }

                @Override // o4.b.a, o4.b
                public void i(com.koushikdutta.async.n nVar, com.koushikdutta.async.l lVar) {
                    super.i(nVar, lVar);
                    C0351a.this.f18284i.close();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0351a(com.koushikdutta.async.h hVar) {
                super();
                this.B = hVar;
                this.f18267q = this;
                this.f18276z = new RunnableC0352a();
                this.A = new C0353b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void L() {
                if (this.f18272v && this.f18271u && !b.this.j(this.f18273w)) {
                    if (b.this.i(this.f18267q, this.f18273w)) {
                        a.this.o(this.B);
                    } else {
                        this.B.close();
                    }
                }
            }

            @Override // s4.d
            protected q4.a H(com.koushikdutta.async.http.h hVar) {
                return b.this.n(hVar);
            }

            void M() {
                b.this.k(this.f18268r, this, this.f18273w);
            }

            @Override // s4.d, o4.a
            public void c(Exception exc) {
                if (b.this.j(this.f18273w)) {
                    return;
                }
                this.f18272v = true;
                super.c(exc);
                this.f18284i.e(new e());
                if (exc != null) {
                    this.f18284i.close();
                    return;
                }
                L();
                if (!q().n() || this.f18275y) {
                    return;
                }
                M();
            }

            @Override // s4.c
            public com.koushikdutta.async.http.k g() {
                String[] strArrSplit = this.f18269s.split("\\?", 2);
                return strArrSplit.length < 2 ? new com.koushikdutta.async.http.k() : com.koushikdutta.async.http.k.o(strArrSplit[1]);
            }

            @Override // s4.c
            public String getPath() {
                return this.f18270t;
            }

            @Override // s4.d
            protected q4.a E(com.koushikdutta.async.http.h hVar) {
                String[] strArrSplit = D().split(" ");
                String str = strArrSplit[1];
                this.f18269s = str;
                String strDecode = URLDecoder.decode(str.split("\\?")[0]);
                this.f18270t = strDecode;
                String str2 = strArrSplit[0];
                this.f18288m = str2;
                l.d dVarB = b.this.b(str2, strDecode);
                if (dVarB == null) {
                    return null;
                }
                this.f18315o = dVarB.f18323c;
                this.f18268r = dVarB.f18324d;
                return null;
            }

            @Override // s4.d
            protected void F() {
                com.koushikdutta.async.http.h hVarB = b();
                if (!this.f18274x && "100-continue".equals(hVarB.c("Expect"))) {
                    pause();
                    y.c(this.f18284i, "HTTP/1.1 100 Continue\r\n\r\n".getBytes(), new c());
                    return;
                }
                d dVar = new d(this.B, this);
                this.f18273w = dVar;
                boolean zL = b.this.l(this, dVar);
                this.f18275y = zL;
                if (!zL) {
                    if (this.f18268r == null) {
                        this.f18273w.r(404);
                        this.f18273w.end();
                    } else {
                        if (q().n() && !this.f18272v) {
                            return;
                        }
                        M();
                    }
                }
            }
        }

        a() {
        }

        @Override // o4.a
        public void c(Exception exc) {
            b.this.o(exc);
        }

        @Override // o4.c
        public void o(com.koushikdutta.async.h hVar) {
            new C0351a(hVar).I(hVar);
            hVar.f();
        }

        @Override // o4.c
        public void v(com.koushikdutta.async.g gVar) {
            b.this.f18263e.add(gVar);
        }
    }

    protected boolean l(c cVar, e eVar) {
        return false;
    }

    static {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        f18262h = hashtable;
        hashtable.put(200, ExternallyRolledFileAppender.OK);
        f18262h.put(202, "Accepted");
        f18262h.put(206, "Partial Content");
        f18262h.put(101, "Switching Protocols");
        f18262h.put(301, "Moved Permanently");
        f18262h.put(302, "Found");
        f18262h.put(304, "Not Modified");
        f18262h.put(400, "Bad Request");
        f18262h.put(404, "Not Found");
        f18262h.put(500, "Internal Server Error");
    }

    public static String h(int i10) {
        String str = f18262h.get(Integer.valueOf(i10));
        return str == null ? "Unknown" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Exception exc) {
        o4.a aVar = this.f18265g;
        if (aVar != null) {
            aVar.c(exc);
        }
    }

    public o4.c g() {
        return this.f18264f;
    }

    protected void k(n nVar, c cVar, e eVar) {
        if (nVar != null) {
            try {
                nVar.a(cVar, eVar);
            } catch (Exception e10) {
                Log.e("AsyncHttpServer", "request callback raised uncaught exception. Catching versus crashing process", e10);
                eVar.r(500);
                eVar.end();
            }
        }
    }

    protected q4.a n(com.koushikdutta.async.http.h hVar) {
        return new q(hVar.c("Content-Type"));
    }

    public void p() {
        ArrayList<com.koushikdutta.async.g> arrayList = this.f18263e;
        if (arrayList != null) {
            Iterator<com.koushikdutta.async.g> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }

    protected boolean i(c cVar, e eVar) {
        return com.koushikdutta.async.http.j.d(eVar.s(), cVar.b());
    }

    protected boolean j(e eVar) {
        if (eVar.code() == 101) {
            return true;
        }
        return false;
    }

    protected void m(c cVar, e eVar) {
    }
}
