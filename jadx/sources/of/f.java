package of;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.z;
import retrofit2.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lof/f;", "", "<init>", "()V", "Lokhttp3/z;", "a", "()Lokhttp3/z;", "", "endPoint", "Lretrofit2/g0;", "b", "(Ljava/lang/String;)Lretrofit2/g0;", "c", "Lokhttp3/z;", "okHttpClient", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "clients", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f16593a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final z okHttpClient = e.f16588a.f();

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, g0> clients = new HashMap<>();

    public final synchronized g0 b(String endPoint) {
        g0 g0VarE;
        m.f(endPoint, "endPoint");
        HashMap<String, g0> map = clients;
        g0VarE = map.get(endPoint);
        if (g0VarE == null) {
            g0VarE = new g0.b().c(endPoint).a(k6.a.Companion.b(k6.a.INSTANCE, null, 1, null)).b(ff.a.f()).g(okHttpClient).e();
            map.put(endPoint, g0VarE);
        }
        return g0VarE;
    }

    public final synchronized g0 c(String endPoint) {
        g0 g0VarE;
        m.f(endPoint, "endPoint");
        HashMap<String, g0> map = clients;
        g0VarE = map.get(endPoint);
        if (g0VarE == null) {
            g0VarE = new g0.b().c(endPoint).a(k6.a.Companion.b(k6.a.INSTANCE, null, 1, null)).b(ff.a.f()).g(e.f16588a.e()).e();
            map.put(endPoint, g0VarE);
        }
        return g0VarE;
    }

    public final z a() {
        return okHttpClient;
    }

    private f() {
    }
}
