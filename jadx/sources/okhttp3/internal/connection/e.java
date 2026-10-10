package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.p;
import okhttp3.r;
import okhttp3.v;
import okhttp3.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0001W\u0018\u00002\u00020\u0001:\u0002EIB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00028\u0000\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00028\u0000\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u000e\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u000e\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020!H\u0000¢\u0006\u0004\b(\u0010#J\u001d\u0010+\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b0\u00101J\u0015\u00104\u001a\u00020\n2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J;\u00109\u001a\u00028\u0000\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\r2\u0006\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00028\u0000H\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b;\u0010\u0010J\u0011\u0010=\u001a\u0004\u0018\u00010<H\u0000¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\n¢\u0006\u0004\b?\u0010\fJ\u0017\u0010A\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u0006H\u0000¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u0006¢\u0006\u0004\bC\u0010 J\u000f\u0010D\u001a\u00020\u0018H\u0000¢\u0006\u0004\bD\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010 R\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010PR\u001a\u0010V\u001a\u00020R8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010S\u001a\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010XR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010aR(\u00103\u001a\u0004\u0018\u0001022\b\u0010c\u001a\u0004\u0018\u0001028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010d\u001a\u0004\be\u0010fR\u0016\u0010g\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010MR(\u0010k\u001a\u0004\u0018\u00010/2\b\u0010c\u001a\u0004\u0018\u00010/8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bG\u0010h\u001a\u0004\bi\u0010jR\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010MR\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010MR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010o\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010MR\u0018\u00106\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010hR$\u0010r\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010d\u001a\u0004\bp\u0010f\"\u0004\bq\u00105¨\u0006s"}, d2 = {"Lokhttp3/internal/connection/e;", "Lokhttp3/e;", "Lokhttp3/z;", "client", "Lokhttp3/b0;", "originalRequest", "", "forWebSocket", "<init>", "(Lokhttp3/z;Lokhttp3/b0;Z)V", "Lr8/z;", "g", "()V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", "D", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "Lokhttp3/a;", "i", "(Lokhttp3/v;)Lokhttp3/a;", "", "()Ljava/lang/String;", "h", "()Lokhttp3/internal/connection/e;", "f", "()Lokhttp3/b0;", "cancel", "r", "()Z", "Lokhttp3/d0;", "execute", "()Lokhttp3/d0;", "Lokhttp3/f;", "responseCallback", "J", "(Lokhttp3/f;)V", "s", "request", "newExchangeFinder", "j", "(Lokhttp3/b0;Z)V", "Llb/g;", "chain", "Lokhttp3/internal/connection/c;", "t", "(Llb/g;)Lokhttp3/internal/connection/c;", "Lokhttp3/internal/connection/f;", "connection", "d", "(Lokhttp3/internal/connection/f;)V", "exchange", "requestDone", "responseDone", "u", "(Lokhttp3/internal/connection/c;ZZLjava/io/IOException;)Ljava/io/IOException;", "v", "Ljava/net/Socket;", "y", "()Ljava/net/Socket;", "C", "closeExchange", "k", "(Z)V", "z", "x", "a", "Lokhttp3/z;", "l", "()Lokhttp3/z;", "b", "Lokhttp3/b0;", "q", "c", "Z", "o", "Lokhttp3/internal/connection/g;", "Lokhttp3/internal/connection/g;", "connectionPool", "Lokhttp3/r;", "Lokhttp3/r;", "n", "()Lokhttp3/r;", "eventListener", "okhttp3/internal/connection/e$c", "Lokhttp3/internal/connection/e$c;", "timeout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "", "Ljava/lang/Object;", "callStackTrace", "Lokhttp3/internal/connection/d;", "Lokhttp3/internal/connection/d;", "exchangeFinder", "<set-?>", "Lokhttp3/internal/connection/f;", "m", "()Lokhttp3/internal/connection/f;", "timeoutEarlyExit", "Lokhttp3/internal/connection/c;", "p", "()Lokhttp3/internal/connection/c;", "interceptorScopedExchange", "requestBodyOpen", "responseBodyOpen", "expectMoreExchanges", "canceled", "getConnectionToCancel", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "connectionToCancel", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class e implements okhttp3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z client;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final b0 originalRequest;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean forWebSocket;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final g connectionPool;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final r eventListener;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c timeout;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean executed;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Object callStackTrace;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private d exchangeFinder;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private f connection;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean timeoutEarlyExit;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private okhttp3.internal.connection.c interceptorScopedExchange;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean requestBodyOpen;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean responseBodyOpen;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean expectMoreExchanges;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private volatile boolean canceled;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private volatile okhttp3.internal.connection.c exchange;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private volatile f connectionToCancel;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0000R\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u001d¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/connection/e$a;", "Ljava/lang/Runnable;", "Lokhttp3/f;", "responseCallback", "<init>", "(Lokhttp3/internal/connection/e;Lokhttp3/f;)V", "Lokhttp3/internal/connection/e;", TransactionPartnerType.OTHER, "Lr8/z;", "e", "(Lokhttp3/internal/connection/e$a;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "a", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "Lokhttp3/f;", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "()Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "", "d", "()Ljava/lang/String;", "host", "()Lokhttp3/internal/connection/e;", NotificationCompat.CATEGORY_CALL, "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final okhttp3.f responseCallback;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private volatile AtomicInteger callsPerHost;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f16843c;

        public a(e eVar, okhttp3.f responseCallback) {
            m.f(responseCallback, "responseCallback");
            this.f16843c = eVar;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void a(ExecutorService executorService) {
            m.f(executorService, "executorService");
            p dispatcher = this.f16843c.getClient().getDispatcher();
            if (hb.d.f10920h && Thread.holdsLock(dispatcher)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    this.f16843c.v(interruptedIOException);
                    this.responseCallback.onFailure(this.f16843c, interruptedIOException);
                    this.f16843c.getClient().getDispatcher().f(this);
                }
            } catch (Throwable th) {
                this.f16843c.getClient().getDispatcher().f(this);
                throw th;
            }
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final e getF16843c() {
            return this.f16843c;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String d() {
            return this.f16843c.q().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getHost();
        }

        public final void e(a other) {
            m.f(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            boolean z10;
            IOException e10;
            z client;
            String str = "OkHttp " + this.f16843c.x();
            e eVar = this.f16843c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                eVar.timeout.v();
                try {
                    try {
                        z10 = true;
                        try {
                            this.responseCallback.onResponse(eVar, eVar.s());
                            client = eVar.getClient();
                        } catch (IOException e11) {
                            e10 = e11;
                            if (z10) {
                                ob.m.INSTANCE.g().j("Callback failure for " + eVar.E(), 4, e10);
                            } else {
                                this.responseCallback.onFailure(eVar, e10);
                            }
                            client = eVar.getClient();
                        } catch (Throwable th2) {
                            th = th2;
                            eVar.cancel();
                            if (!z10) {
                                IOException iOException = new IOException("canceled due to " + th);
                                r8.a.a(iOException, th);
                                this.responseCallback.onFailure(eVar, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        eVar.getClient().getDispatcher().f(this);
                        throw th3;
                    }
                } catch (IOException e12) {
                    e10 = e12;
                    z10 = false;
                } catch (Throwable th4) {
                    th = th4;
                    z10 = false;
                }
                client.getDispatcher().f(this);
                threadCurrentThread.setName(name);
            } catch (Throwable th5) {
                threadCurrentThread.setName(name);
                throw th5;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/connection/e$b;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/e;", "referent", "", "callStackTrace", "<init>", "(Lokhttp3/internal/connection/e;Ljava/lang/Object;)V", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b extends WeakReference<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e referent, Object obj) {
            super(referent);
            m.f(referent, "referent");
            this.callStackTrace = obj;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"okhttp3/internal/connection/e$c", "Ltb/c;", "Lr8/z;", "B", "()V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c extends tb.c {
        c() {
        }

        @Override // tb.c
        protected void B() {
            e.this.cancel();
        }
    }

    public final void k(boolean closeExchange) {
        okhttp3.internal.connection.c cVar;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            r8.z zVar = r8.z.f17874a;
        }
        if (closeExchange && (cVar = this.exchange) != null) {
            cVar.d();
        }
        this.interceptorScopedExchange = null;
    }

    public final IOException v(IOException e10) {
        boolean z10;
        synchronized (this) {
            try {
                z10 = false;
                if (this.expectMoreExchanges) {
                    this.expectMoreExchanges = false;
                    if (!this.requestBodyOpen && !this.responseBodyOpen) {
                        z10 = true;
                    }
                }
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10 ? e(e10) : e10;
    }

    public e(z client, b0 originalRequest, boolean z10) {
        m.f(client, "client");
        m.f(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z10;
        this.connectionPool = client.getConnectionPool().getDelegate();
        this.eventListener = client.getEventListenerFactory().a(this);
        c cVar = new c();
        cVar.g(client.getCallTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = cVar;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    private final <E extends IOException> E D(E cause) {
        if (this.timeoutEarlyExit || !this.timeout.w()) {
            return cause;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String E() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getCanceled() ? "canceled " : "");
        sb2.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb2.append(" to ");
        sb2.append(x());
        return sb2.toString();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final <E extends IOException> E e(E e10) {
        Socket socketY;
        boolean z10 = hb.d.f10920h;
        if (z10 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        f fVar = this.connection;
        if (fVar != null) {
            if (z10 && Thread.holdsLock(fVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + fVar);
            }
            synchronized (fVar) {
                socketY = y();
            }
            if (this.connection == null) {
                if (socketY != null) {
                    hb.d.n(socketY);
                }
                this.eventListener.k(this, fVar);
            } else if (socketY != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        E e11 = (E) D(e10);
        if (e10 == null) {
            this.eventListener.c(this);
            return e11;
        }
        r rVar = this.eventListener;
        m.c(e11);
        rVar.d(this, e11);
        return e11;
    }

    private final void g() {
        this.callStackTrace = ob.m.INSTANCE.g().h("response.body().close()");
        this.eventListener.e(this);
    }

    public final void A(f fVar) {
        this.connectionToCancel = fVar;
    }

    public final void C() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.");
        }
        this.timeoutEarlyExit = true;
        this.timeout.w();
    }

    @Override // okhttp3.e
    public void J(okhttp3.f responseCallback) {
        m.f(responseCallback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        g();
        this.client.getDispatcher().a(new a(this, responseCallback));
    }

    @Override // okhttp3.e
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        okhttp3.internal.connection.c cVar = this.exchange;
        if (cVar != null) {
            cVar.b();
        }
        f fVar = this.connectionToCancel;
        if (fVar != null) {
            fVar.e();
        }
        this.eventListener.f(this);
    }

    public final void d(f connection) {
        m.f(connection, "connection");
        if (!hb.d.f10920h || Thread.holdsLock(connection)) {
            if (this.connection != null) {
                throw new IllegalStateException("Check failed.");
            }
            this.connection = connection;
            connection.o().add(new b(this, this.callStackTrace));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
    }

    @Override // okhttp3.e
    public d0 execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        this.timeout.v();
        g();
        try {
            this.client.getDispatcher().b(this);
            return s();
        } finally {
            this.client.getDispatcher().g(this);
        }
    }

    @Override // okhttp3.e
    /* JADX INFO: renamed from: f, reason: from getter */
    public b0 getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return new e(this.client, this.originalRequest, this.forWebSocket);
    }

    public final void j(b0 request, boolean newExchangeFinder) {
        m.f(request, "request");
        if (this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized (this) {
            if (this.responseBodyOpen) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            r8.z zVar = r8.z.f17874a;
        }
        if (newExchangeFinder) {
            this.exchangeFinder = new d(this.connectionPool, i(request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String()), this, this.eventListener);
        }
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final z getClient() {
        return this.client;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final r getEventListener() {
        return this.eventListener;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final okhttp3.internal.connection.c getInterceptorScopedExchange() {
        return this.interceptorScopedExchange;
    }

    public final b0 q() {
        return this.originalRequest;
    }

    @Override // okhttp3.e
    /* JADX INFO: renamed from: r, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    public final d0 s() {
        ArrayList arrayList = new ArrayList();
        kotlin.collections.r.C(arrayList, this.client.y());
        arrayList.add(new lb.j(this.client));
        arrayList.add(new lb.a(this.client.getCookieJar()));
        this.client.h();
        arrayList.add(new jb.a(null));
        arrayList.add(okhttp3.internal.connection.a.f16790a);
        if (!this.forWebSocket) {
            kotlin.collections.r.C(arrayList, this.client.A());
        }
        arrayList.add(new lb.b(this.forWebSocket));
        try {
            try {
                d0 d0VarA = new lb.g(this, arrayList, 0, null, this.originalRequest, this.client.getConnectTimeoutMillis(), this.client.getReadTimeoutMillis(), this.client.getWriteTimeoutMillis()).a(this.originalRequest);
                if (getCanceled()) {
                    hb.d.m(d0VarA);
                    throw new IOException("Canceled");
                }
                v(null);
                return d0VarA;
            } catch (IOException e10) {
                IOException iOExceptionV = v(e10);
                m.d(iOExceptionV, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionV;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                v(null);
            }
            throw th;
        }
    }

    public final okhttp3.internal.connection.c t(lb.g chain) throws IOException {
        m.f(chain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (this.responseBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            r8.z zVar = r8.z.f17874a;
        }
        d dVar = this.exchangeFinder;
        m.c(dVar);
        okhttp3.internal.connection.c cVar = new okhttp3.internal.connection.c(this, this.eventListener, dVar, dVar.a(this.client, chain));
        this.interceptorScopedExchange = cVar;
        this.exchange = cVar;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032  */
    public final <E extends IOException> E u(okhttp3.internal.connection.c exchange, boolean requestDone, boolean responseDone, E e10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        m.f(exchange, "exchange");
        if (m.a(exchange, this.exchange)) {
            synchronized (this) {
                z10 = false;
                if (requestDone) {
                    try {
                        if (this.requestBodyOpen) {
                            if (requestDone) {
                                this.requestBodyOpen = false;
                            }
                            if (responseDone) {
                                this.responseBodyOpen = false;
                            }
                            z12 = this.requestBodyOpen;
                            if (z12) {
                                z13 = false;
                            } else {
                                z13 = false;
                            }
                            if (!z12) {
                                z10 = true;
                            }
                            z11 = z10;
                            z10 = z13;
                        } else if (responseDone || !this.responseBodyOpen) {
                            z11 = false;
                        } else {
                            if (requestDone) {
                                this.requestBodyOpen = false;
                            }
                            if (responseDone) {
                                this.responseBodyOpen = false;
                            }
                            z12 = this.requestBodyOpen;
                            if (z12 || this.responseBodyOpen) {
                                z13 = false;
                            } else {
                                z13 = true;
                            }
                            if (!z12 && !this.responseBodyOpen && !this.expectMoreExchanges) {
                                z10 = true;
                            }
                            z11 = z10;
                            z10 = z13;
                        }
                        r8.z zVar = r8.z.f17874a;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (responseDone) {
                    }
                    z11 = false;
                    r8.z zVar2 = r8.z.f17874a;
                }
            }
            if (z10) {
                this.exchange = null;
                f fVar = this.connection;
                if (fVar != null) {
                    fVar.t();
                }
            }
            if (z11) {
                return (E) e(e10);
            }
        }
        return e10;
    }

    public final String x() {
        return this.originalRequest.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().r();
    }

    public final Socket y() {
        f fVar = this.connection;
        m.c(fVar);
        if (hb.d.f10920h && !Thread.holdsLock(fVar)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + fVar);
        }
        List<Reference<e>> listO = fVar.o();
        Iterator<Reference<e>> it = listO.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (m.a(it.next().get(), this)) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        listO.remove(i10);
        this.connection = null;
        if (listO.isEmpty()) {
            fVar.C(System.nanoTime());
            if (this.connectionPool.c(fVar)) {
                return fVar.E();
            }
        }
        return null;
    }

    public final boolean z() {
        d dVar = this.exchangeFinder;
        m.c(dVar);
        return dVar.e();
    }

    private final okhttp3.a i(v url) {
        SSLSocketFactory sSLSocketFactoryN;
        HostnameVerifier hostnameVerifier;
        okhttp3.g certificatePinner;
        if (url.getIsHttps()) {
            sSLSocketFactoryN = this.client.N();
            hostnameVerifier = this.client.getHostnameVerifier();
            certificatePinner = this.client.getCertificatePinner();
        } else {
            sSLSocketFactoryN = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new okhttp3.a(url.getHost(), url.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String(), this.client.getDns(), this.client.getSocketFactory(), sSLSocketFactoryN, hostnameVerifier, certificatePinner, this.client.getProxyAuthenticator(), this.client.getProxy(), this.client.E(), this.client.n(), this.client.getProxySelector());
    }
}
