package lb;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Llb/f;", "", "<init>", "()V", "", "method", "", "d", "(Ljava/lang/String;)Z", "a", "c", "b", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f15340a = new f();

    public static final boolean a(String method) {
        m.f(method, "method");
        return (m.a(method, IMediaPlayer.DRM_REQ_GET) || m.a(method, "HEAD")) ? false : true;
    }

    public static final boolean d(String method) {
        m.f(method, "method");
        return m.a(method, IMediaPlayer.DRM_REQ_POST) || m.a(method, "PUT") || m.a(method, "PATCH") || m.a(method, "PROPPATCH") || m.a(method, "REPORT");
    }

    public final boolean b(String method) {
        m.f(method, "method");
        return !m.a(method, "PROPFIND");
    }

    public final boolean c(String method) {
        m.f(method, "method");
        return m.a(method, "PROPFIND");
    }

    private f() {
    }
}
