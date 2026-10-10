package t4;

import com.koushikdutta.async.l;
import com.koushikdutta.async.n;
import p4.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: t4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0365a extends j<l> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ n f18899k;

        C0365a(n nVar) {
            this.f18899k = nVar;
        }

        @Override // p4.d
        protected void a() {
            this.f18899k.close();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements o4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f18901a;

        b(l lVar) {
            this.f18901a = lVar;
        }

        @Override // o4.b
        public void i(n nVar, l lVar) {
            lVar.f(this.f18901a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements o4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f18903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f18904b;

        c(j jVar, l lVar) {
            this.f18903a = jVar;
            this.f18904b = lVar;
        }

        @Override // o4.a
        public void c(Exception exc) {
            if (exc != null) {
                this.f18903a.u(exc);
                return;
            }
            try {
                this.f18903a.w(this.f18904b);
            } catch (Exception e10) {
                this.f18903a.u(e10);
            }
        }
    }

    public p4.b<l> a(n nVar) {
        l lVar = new l();
        C0365a c0365a = new C0365a(nVar);
        nVar.e(new b(lVar));
        nVar.k(new c(c0365a, lVar));
        return c0365a;
    }
}
