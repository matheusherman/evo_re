package x1.f1.lb.streaming.server;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpChunkedInput;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.stream.ChunkedStream;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.InputStream;
import java.net.URI;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lx1/f1/lb/streaming/server/k;", "Lio/netty/channel/SimpleChannelInboundHandler;", "Lio/netty/handler/codec/http/HttpRequest;", "<init>", "()V", "Ljava/net/URI;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "", "", "e", "(Ljava/net/URI;)Ljava/util/Map;", "Lio/netty/channel/ChannelHandlerContext;", "ctx", "Lr8/z;", "d", "(Lio/netty/channel/ChannelHandlerContext;)V", "request", "b", "(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/http/HttpRequest;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "a", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k extends SimpleChannelInboundHandler<HttpRequest> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static InputStream f21120c;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(k.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f21121d = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(k kVar, InputStream inputStream, Future future) {
        synchronized (Companion.class) {
            kVar.logger.a("[" + kVar.hashCode() + "] live_server on stream_complete [" + future.isSuccess() + "] [" + future.isDone() + "], inputStream[" + inputStream.hashCode() + "]", new Object[0]);
            hb.d.m(inputStream);
            f21120c = null;
            z zVar = z.f17874a;
        }
    }

    private final void d(ChannelHandlerContext ctx) {
        DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND);
        defaultHttpResponse.headers().set((CharSequence) HttpHeaderNames.CONTENT_LENGTH, (Object) 0);
        ctx.writeAndFlush(defaultHttpResponse).addListener2(ChannelFutureListener.CLOSE);
    }

    private final Map<String, String> e(URI url) {
        List listL;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            String query = url.getQuery();
            kotlin.jvm.internal.m.c(query);
            List<String> listG = new ua.l("&").g(query, 0);
            if (listG.isEmpty()) {
                listL = kotlin.collections.r.l();
                break;
            }
            ListIterator<String> listIterator = listG.listIterator(listG.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listL = kotlin.collections.r.l();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                    break;
                }
            }
            for (String str : (String[]) listL.toArray(new String[0])) {
                int iB0 = ua.n.b0(str, "=", 0, false, 6, null);
                String strSubstring = str.substring(0, iB0);
                kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
                String strDecode = URLDecoder.decode(strSubstring, "UTF-8");
                String strSubstring2 = str.substring(iB0 + 1);
                kotlin.jvm.internal.m.e(strSubstring2, "substring(...)");
                linkedHashMap.put(strDecode, URLDecoder.decode(strSubstring2, "UTF-8"));
            }
            return linkedHashMap;
        } catch (Throwable th) {
            this.logger.error("[" + hashCode() + "] live_server parse query param failure [" + url + "]", th);
            return linkedHashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.SimpleChannelInboundHandler
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void channelRead0(ChannelHandlerContext ctx, HttpRequest request) {
        kotlin.jvm.internal.m.f(ctx, "ctx");
        kotlin.jvm.internal.m.f(request, "request");
        i iVar = i.f21095a;
        x6.c cVarK = iVar.k();
        if (cVarK == null) {
            this.logger.warn("[" + hashCode() + "] live_server enginMgr is null [" + request.uri() + "]", new Object[0]);
            d(ctx);
            return;
        }
        try {
            URI uri = new URI(request.uri());
            q6.b bVar = this.logger;
            int iHashCode = hashCode();
            HttpHeaders httpHeadersHeaders = request.headers();
            bVar.a("[" + iHashCode + "] live_server on request[" + (httpHeadersHeaders != null ? httpHeadersHeaders.get("User-Agent") : null) + "][" + uri + "]", new Object[0]);
            String path = uri.getPath();
            kotlin.jvm.internal.m.c(path);
            if (!ua.n.v(path, ".ts", false, 2, null)) {
                d(ctx);
                return;
            }
            if (x1.f1.lb.user.f.f21202a.T0()) {
                d(ctx);
                return;
            }
            Map<String, String> mapE = e(uri);
            r rVar = r.f21132a;
            String str = mapE.get(rVar.j());
            if (str == null) {
                str = "";
            }
            Map<String, String> mapA = rVar.a(str);
            if (mapA.isEmpty()) {
                this.logger.error("[" + hashCode() + "] live_server without params [" + request.uri() + "]", new Object[0]);
                d(ctx);
                return;
            }
            String str2 = mapA.get("mediaId");
            String str3 = mapE.get(rVar.n());
            if (str3 == null) {
                str3 = "0";
            }
            long jL = iVar.l();
            if (Long.parseLong(str3) != jL) {
                this.logger.error("[" + hashCode() + "] live_server mismatch [" + str2 + "] [" + str3 + " vs. " + jL + "] [" + request.uri() + "]", new Object[0]);
                d(ctx);
                return;
            }
            synchronized (Companion.class) {
                try {
                    InputStream inputStream = f21120c;
                    if (inputStream != null) {
                        this.logger.warn("[" + hashCode() + "] live_server close last stream [" + inputStream.hashCode() + "]", new Object[0]);
                        hb.d.m(inputStream);
                    }
                    final InputStream inputStreamP = cVarK.p(str2);
                    f21120c = inputStreamP;
                    if (inputStreamP == null) {
                        this.logger.error("[" + hashCode() + "] live_server get stream [null] [" + str2 + "] [" + str3 + " vs. " + jL + "] [" + request.uri() + "]", new Object[0]);
                        d(ctx);
                        return;
                    }
                    this.logger.a("[" + hashCode() + "] live_server get stream [" + inputStreamP.hashCode() + "] [" + str2 + "] [" + str3 + " vs. " + jL + "] [" + request.uri() + "]", new Object[0]);
                    if (str2 != null) {
                        f21121d = str2;
                    }
                    DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
                    defaultHttpResponse.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
                    defaultHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "video/mp2ts");
                    defaultHttpResponse.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
                    ctx.writeAndFlush(defaultHttpResponse);
                    ctx.writeAndFlush(new HttpChunkedInput(new ChunkedStream(new g(inputStreamP)))).addListener2(new GenericFutureListener() { // from class: x1.f1.lb.streaming.server.j
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public final void operationComplete(Future future) {
                            k.c(this.f21117a, inputStreamP, future);
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            this.logger.error("[" + hashCode() + "] live_server failure [" + request.uri() + "}]", th2);
            d(ctx);
        }
    }
}
