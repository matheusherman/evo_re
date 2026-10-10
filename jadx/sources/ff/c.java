package ff;

import com.google.gson.e;
import com.google.gson.l;
import com.google.gson.x;
import okhttp3.e0;
import retrofit2.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c<T> implements i<e0, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f10356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<T> f10357b;

    @Override // retrofit2.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(e0 e0Var) {
        g3.a aVarT = this.f10356a.t(e0Var.c());
        try {
            T tB = this.f10357b.b(aVarT);
            if (aVarT.B() != g3.b.END_DOCUMENT) {
                throw new l("JSON document was not fully consumed.");
            }
            e0Var.close();
            return tB;
        } catch (Throwable th) {
            e0Var.close();
            throw th;
        }
    }

    c(e eVar, x<T> xVar) {
        this.f10356a = eVar;
        this.f10357b = xVar;
    }
}
