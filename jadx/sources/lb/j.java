package lb;

import androidx.core.app.NotificationCompat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.f0;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import ua.l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0007\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010%¨\u0006&"}, d2 = {"Llb/j;", "Lokhttp3/w;", "Lokhttp3/z;", "client", "<init>", "(Lokhttp3/z;)V", "Ljava/io/IOException;", "e", "Lokhttp3/internal/connection/e;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/b0;", "userRequest", "", "requestSendStarted", "(Ljava/io/IOException;Lokhttp3/internal/connection/e;Lokhttp3/b0;Z)Z", "f", "(Ljava/io/IOException;Lokhttp3/b0;)Z", "d", "(Ljava/io/IOException;Z)Z", "Lokhttp3/d0;", "userResponse", "Lokhttp3/internal/connection/c;", "exchange", "c", "(Lokhttp3/d0;Lokhttp3/internal/connection/c;)Lokhttp3/b0;", "", "method", "b", "(Lokhttp3/d0;Ljava/lang/String;)Lokhttp3/b0;", "", "defaultDelay", "g", "(Lokhttp3/d0;I)I", "Lokhttp3/w$a;", "chain", "a", "(Lokhttp3/w$a;)Lokhttp3/d0;", "Lokhttp3/z;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class j implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z client;

    private final b0 c(d0 userResponse, okhttp3.internal.connection.c exchange) throws ProtocolException {
        okhttp3.internal.connection.f fVarH;
        f0 route = (exchange == null || (fVarH = exchange.getConnection()) == null) ? null : fVarH.getRoute();
        int code = userResponse.getCode();
        String method = userResponse.getRequest().getMethod();
        if (code != 307 && code != 308) {
            if (code == 401) {
                return this.client.getAuthenticator().a(route, userResponse);
            }
            if (code == 421) {
                c0 body = userResponse.getRequest().getBody();
                if ((body != null && body.h()) || exchange == null || !exchange.l()) {
                    return null;
                }
                exchange.getConnection().y();
                return userResponse.getRequest();
            }
            if (code == 503) {
                d0 priorResponse = userResponse.getPriorResponse();
                if ((priorResponse == null || priorResponse.getCode() != 503) && g(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.getRequest();
                }
                return null;
            }
            if (code == 407) {
                m.c(route);
                if (route.getProxy().type() == Proxy.Type.HTTP) {
                    return this.client.getProxyAuthenticator().a(route, userResponse);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!this.client.getRetryOnConnectionFailure()) {
                    return null;
                }
                c0 body2 = userResponse.getRequest().getBody();
                if (body2 != null && body2.h()) {
                    return null;
                }
                d0 priorResponse2 = userResponse.getPriorResponse();
                if ((priorResponse2 == null || priorResponse2.getCode() != 408) && g(userResponse, 0) <= 0) {
                    return userResponse.getRequest();
                }
                return null;
            }
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return b(userResponse, method);
    }

    private final int g(d0 userResponse, int defaultDelay) {
        String strL = d0.l(userResponse, "Retry-After", null, 2, null);
        if (strL == null) {
            return defaultDelay;
        }
        if (!new l("\\d+").d(strL)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strL);
        m.e(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    public j(z client) {
        m.f(client, "client");
        this.client = client;
    }

    private final b0 b(d0 userResponse, String method) {
        String strL;
        v vVarS;
        if (!this.client.getFollowRedirects() || (strL = d0.l(userResponse, "Location", null, 2, null)) == null || (vVarS = userResponse.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().s(strL)) == null) {
            return null;
        }
        if (!m.a(vVarS.getScheme(), userResponse.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getScheme()) && !this.client.getFollowSslRedirects()) {
            return null;
        }
        b0.a aVarH = userResponse.getRequest().h();
        if (f.a(method)) {
            int code = userResponse.getCode();
            f fVar = f.f15340a;
            boolean z10 = fVar.c(method) || code == 308 || code == 307;
            if (!fVar.b(method) || code == 308 || code == 307) {
                aVarH.g(method, z10 ? userResponse.getRequest().getBody() : null);
            } else {
                aVarH.g(IMediaPlayer.DRM_REQ_GET, null);
            }
            if (!z10) {
                aVarH.i("Transfer-Encoding");
                aVarH.i("Content-Length");
                aVarH.i("Content-Type");
            }
        }
        if (!hb.d.j(userResponse.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String(), vVarS)) {
            aVarH.i("Authorization");
        }
        return aVarH.l(vVarS).b();
    }

    private final boolean d(IOException e10, boolean requestSendStarted) {
        if (e10 instanceof ProtocolException) {
            return false;
        }
        if (e10 instanceof InterruptedIOException) {
            return (e10 instanceof SocketTimeoutException) && !requestSendStarted;
        }
        return (((e10 instanceof SSLHandshakeException) && (e10.getCause() instanceof CertificateException)) || (e10 instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean e(IOException e10, okhttp3.internal.connection.e call, b0 userRequest, boolean requestSendStarted) {
        if (this.client.getRetryOnConnectionFailure()) {
            return !(requestSendStarted && f(e10, userRequest)) && d(e10, requestSendStarted) && call.z();
        }
        return false;
    }

    @Override // okhttp3.w
    public d0 a(w.a chain) {
        m.f(chain, "chain");
        g gVar = (g) chain;
        b0 b0VarJ = gVar.j();
        okhttp3.internal.connection.e call = gVar.getAndroidx.core.app.NotificationCompat.CATEGORY_CALL java.lang.String();
        List listL = r.l();
        d0 d0Var = null;
        boolean z10 = true;
        int i10 = 0;
        while (true) {
            call.j(b0VarJ, z10);
            try {
                if (call.getCanceled()) {
                    throw new IOException("Canceled");
                }
                try {
                    d0 d0VarA = gVar.a(b0VarJ);
                    if (d0Var != null) {
                        d0VarA = d0VarA.q().o(d0Var.q().b(null).c()).c();
                    }
                    d0Var = d0VarA;
                    okhttp3.internal.connection.c interceptorScopedExchange = call.getInterceptorScopedExchange();
                    b0 b0VarC = c(d0Var, interceptorScopedExchange);
                    if (b0VarC == null) {
                        if (interceptorScopedExchange != null && interceptorScopedExchange.getIsDuplex()) {
                            call.C();
                        }
                        call.k(false);
                        return d0Var;
                    }
                    c0 body = b0VarC.getBody();
                    if (body != null && body.h()) {
                        call.k(false);
                        return d0Var;
                    }
                    e0 body2 = d0Var.getBody();
                    if (body2 != null) {
                        hb.d.m(body2);
                    }
                    i10++;
                    if (i10 > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i10);
                    }
                    call.k(true);
                    b0VarJ = b0VarC;
                    z10 = true;
                } catch (IOException e10) {
                    if (!e(e10, call, b0VarJ, !(e10 instanceof nb.a))) {
                        throw hb.d.Y(e10, listL);
                    }
                    listL = r.C0(listL, e10);
                    call.k(true);
                    z10 = false;
                } catch (okhttp3.internal.connection.i e11) {
                    if (!e(e11.getLastConnectException(), call, b0VarJ, false)) {
                        throw hb.d.Y(e11.getFirstConnectException(), listL);
                    }
                    listL = r.C0(listL, e11.getFirstConnectException());
                    call.k(true);
                    z10 = false;
                }
            } catch (Throwable th) {
                call.k(true);
                throw th;
            }
        }
    }

    private final boolean f(IOException e10, b0 userRequest) {
        c0 body = userRequest.getBody();
        if ((body != null && body.h()) || (e10 instanceof FileNotFoundException)) {
            return true;
        }
        return false;
    }
}
