package q4;

import com.koushikdutta.async.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f implements q4.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f17651a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements p4.c<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o4.a f17652a;

        a(o4.a aVar) {
            this.f17652a = aVar;
        }

        @Override // p4.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Exception exc, String str) {
            f.this.f17651a = str;
            this.f17652a.c(exc);
        }
    }

    @Override // q4.a
    public boolean n() {
        return true;
    }

    @Override // q4.a
    public void l(n nVar, o4.a aVar) {
        new t4.e().b(nVar).m(new a(aVar));
    }

    public String toString() {
        return this.f17651a;
    }

    @Override // q4.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String get() {
        return toString();
    }
}
