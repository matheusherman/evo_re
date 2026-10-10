package x1.f1.lb.streaming.server;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0018\u0006B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u001c\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lx1/f1/lb/streaming/server/i;", "Ls4/n;", "Lx1/f1/lb/streaming/server/f;", "<init>", "()V", "", "b", "()I", "Lr8/z;", "c", "Lx6/c;", "k", "()Lx6/c;", "", "l", "()J", "Lx1/f1/lb/streaming/server/i$a;", "keyStoreProvider", "n", "(Lx1/f1/lb/streaming/server/i$a;)V", "Ls4/c;", "request", "Ls4/e;", "response", "a", "(Ls4/c;Ls4/e;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ExecutorService;", NotificationCompat.CATEGORY_SERVICE, "Ls4/b;", "d", "Ls4/b;", "server", "Lx1/f1/lb/streaming/server/d;", "e", "Lx1/f1/lb/streaming/server/d;", "httpServiceWrapper", "f", "I", "listenPort", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i implements s4.n, f {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static s4.b server;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f21095a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(i.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ExecutorService service = x1.f1.lb.util.n.f21413l;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final x1.f1.lb.streaming.server.d httpServiceWrapper = new x1.f1.lb.streaming.server.d();

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int listenPort = r.f21132a.x();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lx1/f1/lb/streaming/server/i$a;", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\fj\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lx1/f1/lb/streaming/server/i$b;", "", "", "requestStatus", "", "description", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "I", "i", "()I", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "a", "b", "c", "d", "e", "g", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum b {
        REQUEST_OK(200, "请求成功"),
        REQUEST_NO_CONTENT(204, "No Content"),
        REQUEST_ERROR(500, "Internal Server Error"),
        REQUEST_ERROR_API(TypedValues.PositionType.TYPE_TRANSITION_EASING, "无效的请求接口"),
        REQUEST_ERROR_CMD(TypedValues.PositionType.TYPE_DRAWPATH, "无效命令"),
        REQUEST_ERROR_DEVICE_ID(TypedValues.PositionType.TYPE_PERCENT_WIDTH, "不匹配的设备ID"),
        REQUEST_ERROR_ENV(TypedValues.PositionType.TYPE_PERCENT_HEIGHT, "不匹配的服务环境");


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ w8.a f21109i = w8.b.a(a());
        private final String description;
        private final int requestStatus;

        /* JADX INFO: renamed from: f, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: i, reason: from getter */
        public final int getRequestStatus() {
            return this.requestStatus;
        }

        b(int i10, String str) {
            this.requestStatus = i10;
            this.description = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J!\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"x1/f1/lb/streaming/server/i$c", "Lx1/f1/lb/streaming/server/d$a;", "Lcom/koushikdutta/async/http/k;", "params", "", "key", "c", "(Lcom/koushikdutta/async/http/k;Ljava/lang/String;)Ljava/lang/String;", "", "statusCode", "", "content", "contentType", "Lr8/z;", "a", "(I[BLjava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements x1.f1.lb.streaming.server.d.a<com.koushikdutta.async.http.k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0<Integer> f21110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f21111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ s4.c f21112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ s4.e f21114e;

        c(b0<Integer> b0Var, long j10, s4.c cVar, String str, s4.e eVar) {
            this.f21110a = b0Var;
            this.f21111b = j10;
            this.f21112c = cVar;
            this.f21113d = str;
            this.f21114e = eVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Integer] */
        @Override // x1.f1.lb.streaming.server.d.a
        public void a(int statusCode, byte[] content, String contentType) {
            kotlin.jvm.internal.m.f(content, "content");
            kotlin.jvm.internal.m.f(contentType, "contentType");
            this.f21110a.element = Integer.valueOf(statusCode);
            if (x1.f1.lb.config.b.f20643a.t()) {
                i.logger.a("nio_proxy rsp[{}][{}][{}][{} ms]", this.f21112c.m(), this.f21113d, Integer.valueOf(statusCode), Long.valueOf(d1.d() - this.f21111b));
            }
            if (ua.n.w("HEAD", this.f21112c.m(), true)) {
                this.f21114e.r(statusCode).d("");
                return;
            }
            byte[] bArr = new byte[content.length];
            System.arraycopy(content, 0, bArr, 0, content.length);
            this.f21114e.r(statusCode).j(contentType, bArr);
        }

        @Override // x1.f1.lb.streaming.server.d.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String b(com.koushikdutta.async.http.k params, String key) {
            String str;
            kotlin.jvm.internal.m.f(key, "key");
            List<String> list = params != null ? params.get(key) : null;
            if (list == null || (str = list.get(0)) == null) {
                str = "";
            }
            String string = Objects.toString(str);
            kotlin.jvm.internal.m.e(string, "toString(...)");
            return string;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.NIOHttpServer$startServer$1", f = "NIOHttpServer.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ a $keyStoreProvider;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"x1/f1/lb/streaming/server/i$d$a", "Lo4/c;", "Ljava/lang/Exception;", "ex", "Lr8/z;", "c", "(Ljava/lang/Exception;)V", "Lcom/koushikdutta/async/h;", "socket", "o", "(Lcom/koushikdutta/async/h;)V", "Lcom/koushikdutta/async/g;", "v", "(Lcom/koushikdutta/async/g;)V", "a", "Lo4/c;", "mListenCallback", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements o4.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final o4.c mListenCallback;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f21116b;

            a(a aVar) {
                this.f21116b = aVar;
                s4.b bVar = i.server;
                this.mListenCallback = bVar != null ? bVar.g() : null;
            }

            @Override // o4.a
            public void c(Exception ex) {
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("local https server on complete, port[" + i.listenPort + "]", ex);
                }
                i.listenPort++;
                i.f21095a.n(this.f21116b);
            }

            @Override // o4.c
            public void o(com.koushikdutta.async.h socket) {
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("local https server on accept", new Object[0]);
                }
                o4.c cVar = this.mListenCallback;
                if (cVar != null) {
                    cVar.o(socket);
                }
            }

            @Override // o4.c
            public void v(com.koushikdutta.async.g socket) {
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("local https server on listening", new Object[0]);
                }
                o4.c cVar = this.mListenCallback;
                if (cVar != null) {
                    cVar.v(socket);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(a aVar, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$keyStoreProvider = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return i.this.new d(this.$keyStoreProvider, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            s4.b bVar;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("try to start local http server on port[" + i.listenPort + "]", new Object[0]);
                }
                i.httpServiceWrapper.t(i.f21095a);
                if (i.server != null && (bVar = i.server) != null) {
                    bVar.p();
                }
                s4.b bVar2 = new s4.b();
                i.server = bVar2;
                s4.b bVar3 = i.server;
                if (bVar3 != null) {
                    bVar3.a("OPTIONS", "[\\d\\D]*", i.this);
                }
                s4.b bVar4 = i.server;
                if (bVar4 != null) {
                    bVar4.a("HEAD", "[\\d\\D]*", i.this);
                }
                s4.b bVar5 = i.server;
                if (bVar5 != null) {
                    bVar5.d("[\\d\\D]*", i.this);
                }
                s4.b bVar6 = i.server;
                if (bVar6 != null) {
                    bVar6.e("[\\d\\D]*", i.this);
                }
                InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", i.listenPort);
                com.koushikdutta.async.f.g().i(inetSocketAddress.getAddress(), inetSocketAddress.getPort(), new a(this.$keyStoreProvider));
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(s4.c cVar, s4.e eVar) {
        String path = cVar.getPath();
        com.koushikdutta.async.http.k kVarD = cVar.b().d();
        long jD = d1.d();
        b0 b0Var = new b0();
        try {
            try {
                if (TextUtils.isEmpty(path)) {
                    throw new RuntimeException("request uri is empty");
                }
                Locale locale = Locale.getDefault();
                kotlin.jvm.internal.m.e(locale, "getDefault(...)");
                String lowerCase = "OPTIONS".toLowerCase(locale);
                kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
                String strM = cVar.m();
                kotlin.jvm.internal.m.e(strM, "getMethod(...)");
                Locale locale2 = Locale.getDefault();
                kotlin.jvm.internal.m.e(locale2, "getDefault(...)");
                String lowerCase2 = strM.toLowerCase(locale2);
                kotlin.jvm.internal.m.e(lowerCase2, "toLowerCase(...)");
                if (kotlin.jvm.internal.m.a(lowerCase, lowerCase2)) {
                    long jD2 = d1.d() - jD;
                    if (jD2 > 2000) {
                        logger.a("proxy[" + jD + "][" + path + "] response[" + b0Var.element + "] more than[" + jD2 + " ms]", new Object[0]);
                        return;
                    }
                    return;
                }
                q4.a aVarQ = cVar.q();
                kotlin.jvm.internal.m.d(aVarQ, "null cannot be cast to non-null type com.koushikdutta.async.http.body.AsyncHttpRequestBody<com.koushikdutta.async.http.Multimap?>");
                com.koushikdutta.async.http.k kVarG = (com.koushikdutta.async.http.k) aVarQ.get();
                if (kVarG == null) {
                    kVarG = cVar.g();
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.a("nio_proxy rqt[{}][{}][{}][{}]", cVar.m(), path, kVarD, kVarG);
                }
                x1.f1.lb.streaming.server.d dVar = httpServiceWrapper;
                kotlin.jvm.internal.m.c(path);
                dVar.z(path, kVarG, new c(b0Var, jD, cVar, path, eVar));
                long jD3 = d1.d() - jD;
                if (jD3 > 2000) {
                    logger.a("proxy[" + jD + "][" + path + "] response[" + b0Var.element + "] more than[" + jD3 + " ms]", new Object[0]);
                    return;
                }
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            q6.b bVar = logger;
            bVar.error("http server on response failure[" + path + "]", th);
            b bVar2 = b.REQUEST_ERROR;
            eVar.r(bVar2.getRequestStatus()).d(bVar2.getDescription());
            long jD4 = d1.d() - jD;
            if (jD4 > 2000) {
                bVar.a("proxy[" + jD + "][" + path + "] response[" + b0Var.element + "] more than[" + jD4 + " ms]", new Object[0]);
            }
        } catch (Throwable th3) {
            long jD5 = d1.d() - jD;
            if (jD5 > 2000) {
                logger.a("proxy[" + jD + "][" + path + "] response[" + b0Var.element + "] more than[" + jD5 + " ms]", new Object[0]);
            }
            throw th3;
        }
    }

    @Override // s4.n
    public void a(final s4.c request, final s4.e response) {
        kotlin.jvm.internal.m.f(request, "request");
        kotlin.jvm.internal.m.f(response, "response");
        service.execute(new Runnable() { // from class: x1.f1.lb.streaming.server.h
            @Override // java.lang.Runnable
            public final void run() {
                i.m(request, response);
            }
        });
    }

    @Override // x1.f1.lb.streaming.server.f
    public int b() {
        return listenPort;
    }

    @Override // x1.f1.lb.streaming.server.f
    public void c() {
        httpServiceWrapper.H();
    }

    public final x6.c k() {
        return httpServiceWrapper.q();
    }

    public final long l() {
        return httpServiceWrapper.r();
    }

    private i() {
    }

    public final void n(a keyStoreProvider) {
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new d(keyStoreProvider, null), 3, null);
    }
}
