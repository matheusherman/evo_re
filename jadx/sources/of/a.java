package of;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u000fJ\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u000fJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u000fJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\u000fR\u001c\u0010$\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010#R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010%¨\u0006&"}, d2 = {"Lof/a;", "Lof/b;", "<init>", "()V", "paramsProvider", "Lr8/z;", "o", "(Lof/b;)V", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "Lokhttp3/b0$a;", "requestBuilder", "n", "(Ljava/lang/String;Lokhttp3/b0$a;)V", "b", "()Ljava/lang/String;", "m", "(Ljava/lang/String;)Ljava/lang/String;", "", "a", "()I", "", "i", "()J", "d", "l", "e", "k", "j", "h", "f", "g", "c", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Lof/b;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static b paramsProvider;

    static {
        a aVar = new a();
        f16585a = aVar;
        logger = q6.c.d(aVar.getClass());
    }

    @Override // of.b
    public int a() {
        b bVar = paramsProvider;
        if (bVar != null) {
            return bVar.a();
        }
        return 0;
    }

    @Override // of.b
    public String b() {
        String strB;
        b bVar = paramsProvider;
        return (bVar == null || (strB = bVar.b()) == null) ? "" : strB;
    }

    @Override // of.b
    public String c() {
        String strC;
        b bVar = paramsProvider;
        return (bVar == null || (strC = bVar.c()) == null) ? "stb" : strC;
    }

    @Override // of.b
    public int d() {
        b bVar = paramsProvider;
        if (bVar != null) {
            return bVar.d();
        }
        return 0;
    }

    @Override // of.b
    public String e() {
        String strE;
        b bVar = paramsProvider;
        return (bVar == null || (strE = bVar.e()) == null) ? "" : strE;
    }

    @Override // of.b
    public String f() {
        String strF;
        b bVar = paramsProvider;
        return (bVar == null || (strF = bVar.f()) == null) ? "0" : strF;
    }

    @Override // of.b
    public String g() {
        String strG;
        b bVar = paramsProvider;
        return (bVar == null || (strG = bVar.g()) == null) ? "" : strG;
    }

    @Override // of.b
    public int h() {
        b bVar = paramsProvider;
        if (bVar != null) {
            return bVar.h();
        }
        return 0;
    }

    @Override // of.b
    public long i() {
        b bVar = paramsProvider;
        if (bVar != null) {
            return bVar.i();
        }
        return 0L;
    }

    @Override // of.b
    public String j() {
        String strJ;
        b bVar = paramsProvider;
        return (bVar == null || (strJ = bVar.j()) == null) ? "" : strJ;
    }

    @Override // of.b
    public String k() {
        String strK;
        b bVar = paramsProvider;
        return (bVar == null || (strK = bVar.k()) == null) ? "" : strK;
    }

    @Override // of.b
    public String l() {
        String strL;
        b bVar = paramsProvider;
        return (bVar == null || (strL = bVar.l()) == null) ? "en" : strL;
    }

    @Override // of.b
    public String m(String url) {
        String strM;
        m.f(url, "url");
        b bVar = paramsProvider;
        return (bVar == null || (strM = bVar.m(url)) == null) ? "" : strM;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void n(String url, b0.a requestBuilder) {
        m.f(url, "url");
        m.f(requestBuilder, "requestBuilder");
        for (String str : x1.f1.lb.host.b.f20720a.d(url)) {
            switch (str.hashCode()) {
                case -1770905260:
                    if (str.equals("AD_SERVERS")) {
                    }
                    break;
                case -569682387:
                    if (str.equals("UPGRADE_SERVERS")) {
                    }
                    break;
                case 153924575:
                    if (str.equals("APP_METRIC_SERVERS")) {
                    }
                    break;
                case 753614558:
                    if (str.equals("MESSAGE_CENTER_SERVERS")) {
                    }
                    break;
                case 1020639408:
                    if (str.equals("SPORTS_SERVERS")) {
                    }
                    break;
                case 1503420948:
                    if (str.equals("CHANNEL_SERVERS")) {
                    }
                    break;
                case 1816241470:
                    if (str.equals("ACCOUNT_SERVERS")) {
                    }
                    break;
                case 2019390134:
                    if (str.equals("FEEDBACK_SERVERS")) {
                    }
                    break;
                default:
                    continue;
            }
            requestBuilder.a("X-Foxivid-Authorization", m(url));
            requestBuilder.a("X-Foxivid-App-Id", String.valueOf(a()));
            requestBuilder.a("X-Foxivid-App-Version", String.valueOf(i()));
            requestBuilder.a("X-Foxivid-Brand-Id", String.valueOf(d()));
            requestBuilder.a("X-Foxivid-Language", l());
            requestBuilder.a("X-Foxivid-Mac", e());
            try {
                requestBuilder.a("X-Foxivid-Uuid", k());
            } catch (Throwable th) {
                logger.error("fill X-Foxivid-Uuid failure", th);
            }
            requestBuilder.a("X-Foxivid-Tenant-Id", String.valueOf(h()));
            requestBuilder.a("X-Distribution-Channel", f());
            requestBuilder.a("X-App-Type", c());
            return;
        }
    }

    public final void o(b paramsProvider2) {
        m.f(paramsProvider2, "paramsProvider");
        paramsProvider = paramsProvider2;
    }

    private a() {
    }
}
