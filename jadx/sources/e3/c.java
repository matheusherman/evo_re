package e3;

import com.google.gson.e;
import com.google.gson.x;
import com.google.gson.y;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class c extends x<Timestamp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final y f9870b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x<Date> f9871a;

    /* synthetic */ c(x xVar, a aVar) {
        this(xVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements y {
        a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(e eVar, f3.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() != Timestamp.class) {
                return null;
            }
            return new c(eVar.q(Date.class), aVar2);
        }
    }

    private c(x<Date> xVar) {
        this.f9871a = xVar;
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(g3.a aVar) {
        Date dateB = this.f9871a.b(aVar);
        if (dateB != null) {
            return new Timestamp(dateB.getTime());
        }
        return null;
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(g3.c cVar, Timestamp timestamp) {
        this.f9871a.d(cVar, timestamp);
    }
}
