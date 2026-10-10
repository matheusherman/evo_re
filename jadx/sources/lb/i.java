package lb;

import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.v;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Llb/i;", "", "<init>", "()V", "Lokhttp3/b0;", "request", "Ljava/net/Proxy$Type;", "proxyType", "", "b", "(Lokhttp3/b0;Ljava/net/Proxy$Type;)Z", "", "a", "(Lokhttp3/b0;Ljava/net/Proxy$Type;)Ljava/lang/String;", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "c", "(Lokhttp3/v;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f15353a = new i();

    public final String a(b0 request, Proxy.Type proxyType) {
        m.f(request, "request");
        m.f(proxyType, "proxyType");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.getMethod());
        sb2.append(' ');
        i iVar = f15353a;
        if (iVar.b(request, proxyType)) {
            sb2.append(request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String());
        } else {
            sb2.append(iVar.c(request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String()));
        }
        sb2.append(" HTTP/1.1");
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String c(v url) {
        m.f(url, "url");
        String strD = url.d();
        String strF = url.f();
        if (strF == null) {
            return strD;
        }
        return strD + '?' + strF;
    }

    private i() {
    }

    private final boolean b(b0 request, Proxy.Type proxyType) {
        if (!request.f() && proxyType == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }
}
