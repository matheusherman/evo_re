package x1.f1.lb.streaming.server;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.n0;
import org.apache.log4j.Priority;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b2\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010!\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R\u0017\u0010#\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b\u0011\u0010\u0017R\u0017\u0010&\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u0017\u0010)\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u0017\u0010,\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017R\u0017\u0010.\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0017\u00100\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b+\u0010\u0015\u001a\u0004\b/\u0010\u0017R\u0017\u00102\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b1\u0010\u0017R\u0017\u00104\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u00105\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b1\u0010\u0015\u001a\u0004\b\"\u0010\u0017R\u0017\u00106\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b$\u0010\u0017R\u0017\u00107\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b3\u0010\u0017R\u0017\u00108\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b*\u0010\u0017R\u0017\u00109\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b-\u0010\u0017R\u0017\u0010<\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b;\u0010\u0017R\u0017\u0010=\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b;\u0010\u0015\u001a\u0004\b:\u0010\u0017R\u0017\u0010>\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u0017\u0010?\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010@\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017¨\u0006A"}, d2 = {"Lx1/f1/lb/streaming/server/r;", "", "<init>", "()V", "", "len", "", "y", "(I)Ljava/lang/String;", "params", "", "a", "(Ljava/lang/String;)Ljava/util/Map;", "x", "()I", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "startEngine", "d", "r", "stopEngine", "e", "q", "startPlay", "f", "s", "stopPlay", "g", "addPlayer", "h", "m", "removePlayer", "i", "v", "isConnected", "j", "l", "refreshToken", "k", "getSubtitle", "w", "isEngineRunning", "o", "startCatchup", "n", "catchupTs", "liveM3u8", "liveTs", "sessionKey", "paramsKey", "playerKey", "t", "u", "typeKey", "tokenKey", "mediaIdKey", "langKey", "catchupParamKey", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f21132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String startEngine;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final String stopEngine;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final String startPlay;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final String stopPlay;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final String addPlayer;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final String removePlayer;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final String isConnected;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final String refreshToken;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final String getSubtitle;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final String isEngineRunning;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final String startCatchup;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static final String catchupTs;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static final String liveM3u8;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static final String liveTs;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static final String sessionKey;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static final String paramsKey;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static final String playerKey;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static final String typeKey;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private static final String tokenKey;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private static final String mediaIdKey;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private static final String langKey;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private static final String catchupParamKey;

    static {
        r rVar = new r();
        f21132a = rVar;
        logger = q6.c.d(rVar.getClass());
        startEngine = rVar.y(1);
        stopEngine = rVar.y(2);
        startPlay = rVar.y(3);
        stopPlay = rVar.y(4);
        addPlayer = rVar.y(5);
        removePlayer = rVar.y(6);
        isConnected = rVar.y(7);
        refreshToken = rVar.y(8);
        getSubtitle = rVar.y(9);
        isEngineRunning = rVar.y(10);
        startCatchup = rVar.y(11);
        catchupTs = rVar.y(1);
        liveM3u8 = rVar.y(2);
        liveTs = rVar.y(3);
        sessionKey = rVar.y(1);
        paramsKey = rVar.y(2);
        playerKey = rVar.y(3);
        typeKey = rVar.y(4);
        tokenKey = rVar.y(5);
        mediaIdKey = rVar.y(6);
        langKey = rVar.y(7);
        catchupParamKey = rVar.y(8);
    }

    private final String y(int len) {
        StringBuilder sb2 = new StringBuilder();
        double d10 = 25;
        sb2.append((char) (((int) (Math.random() * d10)) + 97));
        for (int i10 = 1; i10 < len; i10++) {
            if (Math.random() > 0.5d) {
                sb2.append((char) (((int) (Math.random() * d10)) + 97));
            } else {
                sb2.append((char) (48 + ((int) (Math.random() * ((double) 9)))));
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    public final Map<String, String> a(String params) {
        List listL;
        kotlin.jvm.internal.m.f(params, "params");
        if (params.length() == 0) {
            return n0.i();
        }
        String strV = x1.f1.lb.streaming.a.f20960a.v(params);
        List<String> listG = new ua.l("&").g(strV, 0);
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
        String[] strArr = (String[]) listL.toArray(new String[0]);
        HashMap map = new HashMap();
        for (String str : strArr) {
            try {
                List listZ0 = ua.n.z0(str, new String[]{"="}, false, 0, 6, null);
                map.put(listZ0.get(0), listZ0.get(1));
            } catch (Throwable th) {
                logger.error("split failure: \"" + strArr + "\" of \"" + strV + "\"", th);
            }
        }
        return map;
    }

    public final String b() {
        return addPlayer;
    }

    public final String c() {
        return catchupParamKey;
    }

    public final String d() {
        return catchupTs;
    }

    public final String e() {
        return getSubtitle;
    }

    public final String f() {
        return langKey;
    }

    public final String g() {
        return liveM3u8;
    }

    public final String h() {
        return liveTs;
    }

    public final String i() {
        return mediaIdKey;
    }

    public final String j() {
        return paramsKey;
    }

    public final String k() {
        return playerKey;
    }

    public final String l() {
        return refreshToken;
    }

    public final String m() {
        return removePlayer;
    }

    public final String n() {
        return sessionKey;
    }

    public final String o() {
        return startCatchup;
    }

    public final String p() {
        return startEngine;
    }

    public final String q() {
        return startPlay;
    }

    public final String r() {
        return stopEngine;
    }

    public final String s() {
        return stopPlay;
    }

    public final String t() {
        return tokenKey;
    }

    public final String u() {
        return typeKey;
    }

    public final String v() {
        return isConnected;
    }

    public final String w() {
        return isEngineRunning;
    }

    private r() {
    }

    public final int x() {
        return ((int) (Math.random() * ((double) Priority.FATAL_INT))) + 1024;
    }
}
