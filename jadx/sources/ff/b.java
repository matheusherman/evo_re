package ff;

import com.google.gson.e;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.c0;
import okhttp3.x;
import retrofit2.i;
import tb.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class b<T> implements i<T, c0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final x f10352c = x.e("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Charset f10353d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f10354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.x<T> f10355b;

    @Override // retrofit2.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c0 a(T t10) throws IOException {
        d dVar = new d();
        g3.c cVarU = this.f10354a.u(new OutputStreamWriter(dVar.o(), f10353d));
        this.f10355b.d(cVarU, t10);
        cVarU.close();
        return c0.d(f10352c, dVar.p());
    }

    b(e eVar, com.google.gson.x<T> xVar) {
        this.f10354a = eVar;
        this.f10355b = xVar;
    }
}
