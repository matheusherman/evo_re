package lb;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011JM\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0003\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010#R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010$R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010)\u001a\u0004\b*\u0010\u001cR\u001a\u0010\r\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b+\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b,\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b-\u0010\u0018R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010$¨\u0006/"}, d2 = {"Llb/g;", "Lokhttp3/w$a;", "Lokhttp3/internal/connection/e;", NotificationCompat.CATEGORY_CALL, "", "Lokhttp3/w;", "interceptors", "", "index", "Lokhttp3/internal/connection/c;", "exchange", "Lokhttp3/b0;", "request", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "<init>", "(Lokhttp3/internal/connection/e;Ljava/util/List;ILokhttp3/internal/connection/c;Lokhttp3/b0;III)V", "c", "(ILokhttp3/internal/connection/c;Lokhttp3/b0;III)Llb/g;", "Lokhttp3/j;", "b", "()Lokhttp3/j;", "l", "()I", "Lokhttp3/e;", "()Lokhttp3/e;", "f", "()Lokhttp3/b0;", "Lokhttp3/d0;", "a", "(Lokhttp3/b0;)Lokhttp3/d0;", "Lokhttp3/internal/connection/e;", "e", "()Lokhttp3/internal/connection/e;", "Ljava/util/List;", "I", "d", "Lokhttp3/internal/connection/c;", "h", "()Lokhttp3/internal/connection/c;", "Lokhttp3/b0;", "j", "g", "i", "k", "calls", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class g implements w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final okhttp3.internal.connection.e call;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<w> interceptors;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final okhttp3.internal.connection.c exchange;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b0 request;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int connectTimeoutMillis;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int readTimeoutMillis;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int writeTimeoutMillis;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int calls;

    /* JADX WARN: Multi-variable type inference failed */
    public g(okhttp3.internal.connection.e call, List<? extends w> interceptors, int i10, okhttp3.internal.connection.c cVar, b0 request, int i11, int i12, int i13) {
        m.f(call, "call");
        m.f(interceptors, "interceptors");
        m.f(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i10;
        this.exchange = cVar;
        this.request = request;
        this.connectTimeoutMillis = i11;
        this.readTimeoutMillis = i12;
        this.writeTimeoutMillis = i13;
    }

    public static /* synthetic */ g d(g gVar, int i10, okhttp3.internal.connection.c cVar, b0 b0Var, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = gVar.index;
        }
        if ((i14 & 2) != 0) {
            cVar = gVar.exchange;
        }
        if ((i14 & 4) != 0) {
            b0Var = gVar.request;
        }
        if ((i14 & 8) != 0) {
            i11 = gVar.connectTimeoutMillis;
        }
        if ((i14 & 16) != 0) {
            i12 = gVar.readTimeoutMillis;
        }
        if ((i14 & 32) != 0) {
            i13 = gVar.writeTimeoutMillis;
        }
        int i15 = i12;
        int i16 = i13;
        return gVar.c(i10, cVar, b0Var, i11, i15, i16);
    }

    @Override // okhttp3.w.a
    public d0 a(b0 request) {
        m.f(request, "request");
        if (this.index >= this.interceptors.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.calls++;
        okhttp3.internal.connection.c cVar = this.exchange;
        if (cVar != null) {
            if (!cVar.getFinder().g(request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        g gVarD = d(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        w wVar = this.interceptors.get(this.index);
        d0 d0VarA = wVar.a(gVarD);
        if (d0VarA == null) {
            throw new NullPointerException("interceptor " + wVar + " returned null");
        }
        if (this.exchange != null && this.index + 1 < this.interceptors.size() && gVarD.calls != 1) {
            throw new IllegalStateException(("network interceptor " + wVar + " must call proceed() exactly once").toString());
        }
        if (d0VarA.getBody() != null) {
            return d0VarA;
        }
        throw new IllegalStateException(("interceptor " + wVar + " returned a response with no body").toString());
    }

    @Override // okhttp3.w.a
    public okhttp3.j b() {
        okhttp3.internal.connection.c cVar = this.exchange;
        if (cVar != null) {
            return cVar.getConnection();
        }
        return null;
    }

    public final g c(int index, okhttp3.internal.connection.c exchange, b0 request, int connectTimeoutMillis, int readTimeoutMillis, int writeTimeoutMillis) {
        m.f(request, "request");
        return new g(this.call, this.interceptors, index, exchange, request, connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis);
    }

    @Override // okhttp3.w.a
    public okhttp3.e call() {
        return this.call;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final okhttp3.internal.connection.e getCall() {
        return this.call;
    }

    @Override // okhttp3.w.a
    /* JADX INFO: renamed from: f, reason: from getter */
    public b0 getRequest() {
        return this.request;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final okhttp3.internal.connection.c getExchange() {
        return this.exchange;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final b0 j() {
        return this.request;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public int l() {
        return this.readTimeoutMillis;
    }
}
