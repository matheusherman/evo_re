package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.d0;
import okhttp3.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/a;", "Lokhttp3/w;", "<init>", "()V", "Lokhttp3/w$a;", "chain", "Lokhttp3/d0;", "a", "(Lokhttp3/w$a;)Lokhttp3/d0;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16790a = new a();

    @Override // okhttp3.w
    public d0 a(w.a chain) {
        m.f(chain, "chain");
        lb.g gVar = (lb.g) chain;
        return lb.g.d(gVar, 0, gVar.getAndroidx.core.app.NotificationCompat.CATEGORY_CALL java.lang.String().t(gVar), null, 0, 0, 0, 61, null).a(gVar.j());
    }

    private a() {
    }
}
