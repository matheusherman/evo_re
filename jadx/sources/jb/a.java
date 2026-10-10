package jb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import hb.d;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.e0;
import okhttp3.r;
import okhttp3.u;
import okhttp3.w;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ljb/a;", "Lokhttp3/w;", "Lokhttp3/c;", "cache", "<init>", "(Lokhttp3/c;)V", "Lokhttp3/w$a;", "chain", "Lokhttp3/d0;", "a", "(Lokhttp3/w$a;)Lokhttp3/d0;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: jb.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Ljb/a$a;", "", "<init>", "()V", "Lokhttp3/d0;", "response", "f", "(Lokhttp3/d0;)Lokhttp3/d0;", "Lokhttp3/u;", "cachedHeaders", "networkHeaders", "c", "(Lokhttp3/u;Lokhttp3/u;)Lokhttp3/u;", "", "fieldName", "", "e", "(Ljava/lang/String;)Z", "d", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final d0 f(d0 response) {
            return (response != null ? response.getBody() : null) != null ? response.q().b(null).c() : response;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final u c(u cachedHeaders, u networkHeaders) {
            u.a aVar = new u.a();
            int size = cachedHeaders.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strF = cachedHeaders.f(i10);
                String strK = cachedHeaders.k(i10);
                if ((!n.w("Warning", strF, true) || !n.I(strK, "1", false, 2, null)) && (d(strF) || !e(strF) || networkHeaders.e(strF) == null)) {
                    aVar.d(strF, strK);
                }
            }
            int size2 = networkHeaders.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String strF2 = networkHeaders.f(i11);
                if (!d(strF2) && e(strF2)) {
                    aVar.d(strF2, networkHeaders.k(i11));
                }
            }
            return aVar.f();
        }

        private final boolean d(String fieldName) {
            return n.w("Content-Length", fieldName, true) || n.w("Content-Encoding", fieldName, true) || n.w("Content-Type", fieldName, true);
        }

        private final boolean e(String fieldName) {
            return (n.w("Connection", fieldName, true) || n.w("Keep-Alive", fieldName, true) || n.w("Proxy-Authenticate", fieldName, true) || n.w("Proxy-Authorization", fieldName, true) || n.w("TE", fieldName, true) || n.w("Trailers", fieldName, true) || n.w("Transfer-Encoding", fieldName, true) || n.w("Upgrade", fieldName, true)) ? false : true;
        }
    }

    @Override // okhttp3.w
    public d0 a(w.a chain) {
        r eventListener;
        m.f(chain, "chain");
        e eVarCall = chain.call();
        b bVarB = new b.C0199b(System.currentTimeMillis(), chain.getRequest(), null).b();
        b0 b0VarB = bVarB.getNetworkRequest();
        d0 d0VarA = bVarB.getCacheResponse();
        okhttp3.internal.connection.e eVar = eVarCall instanceof okhttp3.internal.connection.e ? (okhttp3.internal.connection.e) eVarCall : null;
        if (eVar == null || (eventListener = eVar.getEventListener()) == null) {
            eventListener = r.f16946b;
        }
        if (b0VarB == null && d0VarA == null) {
            d0 d0VarC = new d0.a().r(chain.getRequest()).p(a0.HTTP_1_1).g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).m("Unsatisfiable Request (only-if-cached)").b(d.f10915c).s(-1L).q(System.currentTimeMillis()).c();
            eventListener.z(eVarCall, d0VarC);
            return d0VarC;
        }
        if (b0VarB == null) {
            m.c(d0VarA);
            d0 d0VarC2 = d0VarA.q().d(INSTANCE.f(d0VarA)).c();
            eventListener.b(eVarCall, d0VarC2);
            return d0VarC2;
        }
        if (d0VarA != null) {
            eventListener.a(eVarCall, d0VarA);
        }
        d0 d0VarA2 = chain.a(b0VarB);
        if (d0VarA != null) {
            if (d0VarA2 != null && d0VarA2.getCode() == 304) {
                d0.a aVarQ = d0VarA.q();
                Companion companion = INSTANCE;
                aVarQ.k(companion.c(d0VarA.getHeaders(), d0VarA2.getHeaders())).s(d0VarA2.getSentRequestAtMillis()).q(d0VarA2.getReceivedResponseAtMillis()).d(companion.f(d0VarA)).n(companion.f(d0VarA2)).c();
                e0 body = d0VarA2.getBody();
                m.c(body);
                body.close();
                m.c(null);
                throw null;
            }
            e0 body2 = d0VarA.getBody();
            if (body2 != null) {
                d.m(body2);
            }
        }
        m.c(d0VarA2);
        d0.a aVarQ2 = d0VarA2.q();
        Companion companion2 = INSTANCE;
        return aVarQ2.d(companion2.f(d0VarA)).n(companion2.f(d0VarA2)).c();
    }

    public a(c cVar) {
    }
}
