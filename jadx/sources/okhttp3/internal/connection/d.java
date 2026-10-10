package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import nb.n;
import okhttp3.f0;
import okhttp3.r;
import okhttp3.v;
import r8.z;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u0015\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'J\r\u0010$\u001a\u00020\u0011¢\u0006\u0004\b$\u0010(J\u0015\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010-R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u00100R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00101R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00102R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00107R\u0016\u0010:\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u00109R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00109R\u0016\u0010=\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00109R\u0018\u0010@\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lokhttp3/internal/connection/d;", "", "Lokhttp3/internal/connection/g;", "connectionPool", "Lokhttp3/a;", "address", "Lokhttp3/internal/connection/e;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/r;", "eventListener", "<init>", "(Lokhttp3/internal/connection/g;Lokhttp3/a;Lokhttp3/internal/connection/e;Lokhttp3/r;)V", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lokhttp3/internal/connection/f;", "c", "(IIIIZZ)Lokhttp3/internal/connection/f;", "b", "(IIIIZ)Lokhttp3/internal/connection/f;", "Lokhttp3/f0;", "f", "()Lokhttp3/f0;", "Lokhttp3/z;", "client", "Llb/g;", "chain", "Llb/d;", "a", "(Lokhttp3/z;Llb/g;)Llb/d;", "Ljava/io/IOException;", "e", "Lr8/z;", "h", "(Ljava/io/IOException;)V", "()Z", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "g", "(Lokhttp3/v;)Z", "Lokhttp3/internal/connection/g;", "Lokhttp3/a;", "d", "()Lokhttp3/a;", "Lokhttp3/internal/connection/e;", "Lokhttp3/r;", "Lokhttp3/internal/connection/j$b;", "Lokhttp3/internal/connection/j$b;", "routeSelection", "Lokhttp3/internal/connection/j;", "Lokhttp3/internal/connection/j;", "routeSelector", "I", "refusedStreamCount", "connectionShutdownCount", "i", "otherFailureCount", "j", "Lokhttp3/f0;", "nextRouteToTry", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final g connectionPool;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final okhttp3.a address;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final e call;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final r eventListener;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private j.b routeSelection;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private j routeSelector;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int refusedStreamCount;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int connectionShutdownCount;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int otherFailureCount;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private f0 nextRouteToTry;

    public d(g connectionPool, okhttp3.a address, e call, r eventListener) {
        m.f(connectionPool, "connectionPool");
        m.f(address, "address");
        m.f(call, "call");
        m.f(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x012c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0146  */
    /* JADX WARN: Code duplicated, block: B:76:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final f b(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled) throws IOException {
        List<f0> listA;
        f fVar;
        Socket socketY;
        if (this.call.getCanceled()) {
            throw new IOException("Canceled");
        }
        f connection = this.call.getConnection();
        if (connection != null) {
            synchronized (connection) {
                try {
                    socketY = (connection.getNoNewExchanges() || !g(connection.getRoute().getAddress().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String())) ? this.call.y() : null;
                    z zVar = z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.call.getConnection() != null) {
                if (socketY == null) {
                    return connection;
                }
                throw new IllegalStateException("Check failed.");
            }
            if (socketY != null) {
                hb.d.n(socketY);
            }
            this.eventListener.k(this.call, connection);
        }
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.a(this.address, this.call, null, false)) {
            f connection2 = this.call.getConnection();
            m.c(connection2);
            this.eventListener.j(this.call, connection2);
            return connection2;
        }
        f0 f0VarC = this.nextRouteToTry;
        try {
            if (f0VarC == null) {
                j.b bVar = this.routeSelection;
                if (bVar != null) {
                    m.c(bVar);
                    if (bVar.b()) {
                        j.b bVar2 = this.routeSelection;
                        m.c(bVar2);
                        f0VarC = bVar2.c();
                    }
                    fVar = new f(this.connectionPool, f0VarC);
                    this.call.A(fVar);
                    fVar.g(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
                    this.call.A(null);
                    this.call.getClient().getRouteDatabase().a(fVar.getRoute());
                    if (this.connectionPool.a(this.address, this.call, listA, true)) {
                        f connection3 = this.call.getConnection();
                        m.c(connection3);
                        this.nextRouteToTry = f0VarC;
                        hb.d.n(fVar.E());
                        this.eventListener.j(this.call, connection3);
                        return connection3;
                    }
                    synchronized (fVar) {
                        this.connectionPool.e(fVar);
                        this.call.d(fVar);
                        z zVar2 = z.f17874a;
                    }
                    this.eventListener.j(this.call, fVar);
                    return fVar;
                }
                j jVar = this.routeSelector;
                if (jVar == null) {
                    jVar = new j(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                    this.routeSelector = jVar;
                }
                j.b bVarC = jVar.c();
                this.routeSelection = bVarC;
                listA = bVarC.a();
                if (this.call.getCanceled()) {
                    throw new IOException("Canceled");
                }
                if (this.connectionPool.a(this.address, this.call, listA, false)) {
                    f connection4 = this.call.getConnection();
                    m.c(connection4);
                    this.eventListener.j(this.call, connection4);
                    return connection4;
                }
                f0VarC = bVarC.c();
                fVar = new f(this.connectionPool, f0VarC);
                this.call.A(fVar);
                fVar.g(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
                this.call.A(null);
                this.call.getClient().getRouteDatabase().a(fVar.getRoute());
                if (this.connectionPool.a(this.address, this.call, listA, true)) {
                    f connection5 = this.call.getConnection();
                    m.c(connection5);
                    this.nextRouteToTry = f0VarC;
                    hb.d.n(fVar.E());
                    this.eventListener.j(this.call, connection5);
                    return connection5;
                }
                synchronized (fVar) {
                    this.connectionPool.e(fVar);
                    this.call.d(fVar);
                    z zVar3 = z.f17874a;
                    this.eventListener.j(this.call, fVar);
                    return fVar;
                }
            }
            m.c(f0VarC);
            this.nextRouteToTry = null;
            fVar.g(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
            this.call.A(null);
            this.call.getClient().getRouteDatabase().a(fVar.getRoute());
            if (this.connectionPool.a(this.address, this.call, listA, true)) {
                f connection6 = this.call.getConnection();
                m.c(connection6);
                this.nextRouteToTry = f0VarC;
                hb.d.n(fVar.E());
                this.eventListener.j(this.call, connection6);
                return connection6;
            }
            synchronized (fVar) {
                this.connectionPool.e(fVar);
                this.call.d(fVar);
                z zVar4 = z.f17874a;
                this.eventListener.j(this.call, fVar);
                return fVar;
            }
        } catch (Throwable th2) {
            this.call.A(null);
            throw th2;
        }
        listA = null;
        fVar = new f(this.connectionPool, f0VarC);
        this.call.A(fVar);
    }

    private final f0 f() {
        f connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount() != 0) {
                return null;
            }
            if (hb.d.j(connection.getRoute().getAddress().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String(), this.address.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String())) {
                return connection.getRoute();
            }
            return null;
        }
    }

    public final lb.d a(okhttp3.z client, lb.g chain) {
        m.f(client, "client");
        m.f(chain, "chain");
        try {
            try {
                return c(chain.getConnectTimeoutMillis(), chain.getReadTimeoutMillis(), chain.getWriteTimeoutMillis(), client.getPingIntervalMillis(), client.getRetryOnConnectionFailure(), !m.a(chain.j().getMethod(), IMediaPlayer.DRM_REQ_GET)).x(client, chain);
            } catch (IOException e10) {
                e = e10;
                IOException iOException = e;
                h(iOException);
                throw new i(iOException);
            } catch (i e11) {
                e = e11;
                i iVar = e;
                h(iVar.getLastConnectException());
                throw iVar;
            }
        } catch (IOException e12) {
            e = e12;
        } catch (i e13) {
            e = e13;
        }
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final okhttp3.a getAddress() {
        return this.address;
    }

    public final boolean e() {
        j jVar;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        f0 f0VarF = f();
        if (f0VarF != null) {
            this.nextRouteToTry = f0VarF;
            return true;
        }
        j.b bVar = this.routeSelection;
        if ((bVar == null || !bVar.b()) && (jVar = this.routeSelector) != null) {
            return jVar.a();
        }
        return true;
    }

    public final boolean g(v url) {
        m.f(url, "url");
        v url2 = this.address.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String();
        return url.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String() == url2.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String() && m.a(url.getHost(), url2.getHost());
    }

    public final void h(IOException e10) {
        m.f(e10, "e");
        this.nextRouteToTry = null;
        if ((e10 instanceof n) && ((n) e10).errorCode == nb.b.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (e10 instanceof nb.a) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }

    private final f c(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, boolean doExtensiveHealthChecks) throws IOException {
        boolean zB;
        while (true) {
            f fVarB = b(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled);
            boolean z10 = connectionRetryEnabled;
            int i10 = pingIntervalMillis;
            int i11 = writeTimeout;
            int i12 = readTimeout;
            int i13 = connectTimeout;
            if (fVarB.v(doExtensiveHealthChecks)) {
                return fVarB;
            }
            fVarB.z();
            if (this.nextRouteToTry == null) {
                j.b bVar = this.routeSelection;
                boolean zA = true;
                if (bVar != null) {
                    zB = bVar.b();
                } else {
                    zB = true;
                }
                if (zB) {
                    continue;
                } else {
                    j jVar = this.routeSelector;
                    if (jVar != null) {
                        zA = jVar.a();
                    }
                    if (!zA) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
            connectTimeout = i13;
            readTimeout = i12;
            writeTimeout = i11;
            pingIntervalMillis = i10;
            connectionRetryEnabled = z10;
        }
    }
}
