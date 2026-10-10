package q4;

import android.text.TextUtils;
import com.koushikdutta.async.http.k;
import com.koushikdutta.async.l;
import com.koushikdutta.async.n;
import com.koushikdutta.async.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s4.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends m implements q4.a<k> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    s f17639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    com.koushikdutta.async.http.h f17640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    l f17641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    d f17642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f17643m = "multipart/form-data";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<d> f17644n;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements s.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.async.http.h f17645a;

        /* JADX INFO: renamed from: q4.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0338a implements o4.b {
            C0338a() {
            }

            @Override // o4.b
            public void i(n nVar, l lVar) {
                lVar.f(c.this.f17641k);
            }
        }

        a(com.koushikdutta.async.http.h hVar) {
            this.f17645a = hVar;
        }

        @Override // com.koushikdutta.async.s.a
        public void a(String str) {
            if (!"\r".equals(str)) {
                this.f17645a.b(str);
                return;
            }
            c.this.E();
            c cVar = c.this;
            cVar.f17639i = null;
            cVar.e(null);
            d dVar = new d(this.f17645a);
            c.this.getClass();
            if (c.this.u() == null) {
                c cVar2 = c.this;
                cVar2.f17642l = dVar;
                cVar2.f17641k = new l();
                c.this.e(new C0338a());
            }
        }
    }

    @Override // q4.a
    public boolean n() {
        return false;
    }

    public void B(d dVar) {
        if (this.f17644n == null) {
            this.f17644n = new ArrayList<>();
        }
        this.f17644n.add(dVar);
    }

    @Override // q4.a
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public k get() {
        return new k(this.f17640j.d());
    }

    public List<d> D() {
        if (this.f17644n == null) {
            return null;
        }
        return new ArrayList(this.f17644n);
    }

    void E() {
        if (this.f17641k == null) {
            return;
        }
        if (this.f17640j == null) {
            this.f17640j = new com.koushikdutta.async.http.h();
        }
        String strT = this.f17641k.t();
        String strA = TextUtils.isEmpty(this.f17642l.a()) ? "unnamed" : this.f17642l.a();
        g gVar = new g(strA, strT);
        gVar.f17648a = this.f17642l.f17648a;
        B(gVar);
        this.f17640j.a(strA, strT);
        this.f17642l = null;
        this.f17641k = null;
    }

    @Override // s4.m
    protected void z() {
        com.koushikdutta.async.http.h hVar = new com.koushikdutta.async.http.h();
        s sVar = new s();
        this.f17639i = sVar;
        sVar.a(new a(hVar));
        e(this.f17639i);
    }

    public c(String str) {
        String strI = k.q(str).i("boundary");
        if (strI == null) {
            w(new Exception("No boundary found for multipart/form-data"));
        } else {
            A(strI);
        }
    }

    @Override // q4.a
    public void l(n nVar, o4.a aVar) {
        x(nVar);
        k(aVar);
    }

    public String toString() {
        Iterator<d> it = D().iterator();
        if (it.hasNext()) {
            return it.next().toString();
        }
        return "multipart content is empty";
    }

    @Override // s4.m
    protected void y() {
        super.y();
        E();
    }
}
