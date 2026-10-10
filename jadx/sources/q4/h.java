package q4;

import com.koushikdutta.async.http.k;
import com.koushikdutta.async.l;
import com.koushikdutta.async.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h implements q4.a<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f17655a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements o4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f17656a;

        a(l lVar) {
            this.f17656a = lVar;
        }

        @Override // o4.b
        public void i(n nVar, l lVar) {
            lVar.f(this.f17656a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements o4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f17658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o4.a f17659b;

        b(l lVar, o4.a aVar) {
            this.f17658a = lVar;
            this.f17659b = aVar;
        }

        @Override // o4.a
        public void c(Exception exc) {
            try {
                if (exc != null) {
                    throw exc;
                }
                h.this.f17655a = k.s(this.f17658a.w());
                this.f17659b.c(null);
            } catch (Exception e10) {
                this.f17659b.c(e10);
            }
        }
    }

    @Override // q4.a
    public boolean n() {
        return true;
    }

    @Override // q4.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return this.f17655a;
    }

    @Override // q4.a
    public void l(n nVar, o4.a aVar) {
        l lVar = new l();
        nVar.e(new a(lVar));
        nVar.k(new b(lVar, aVar));
    }
}
