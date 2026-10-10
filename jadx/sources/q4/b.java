package q4;

import com.koushikdutta.async.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements q4.a<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    JSONObject f17636a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements p4.c<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o4.a f17637a;

        a(o4.a aVar) {
            this.f17637a = aVar;
        }

        @Override // p4.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Exception exc, JSONObject jSONObject) {
            b.this.f17636a = jSONObject;
            this.f17637a.c(exc);
        }
    }

    @Override // q4.a
    public boolean n() {
        return true;
    }

    @Override // q4.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject get() {
        return this.f17636a;
    }

    @Override // q4.a
    public void l(n nVar, o4.a aVar) {
        new t4.c().a(nVar).m(new a(aVar));
    }
}
