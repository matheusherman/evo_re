package uf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x1.f1.lb.heartbeat.f;
import x1.f1.lb.media.d;
import x1.f1.lb.metric.monitor.e;
import x1.f1.lb.metric.monitor.h;
import x1.f1.lb.metric.monitor.i;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\t2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J3\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0010Jk\u0010\u001d\u001a\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J%\u0010\"\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010&\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010'J\r\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\t¢\u0006\u0004\b+\u0010\u0003J\r\u0010,\u001a\u00020\t¢\u0006\u0004\b,\u0010\u0003J-\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0005¢\u0006\u0004\b\r\u00100J\u0015\u00101\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b1\u00102JU\u00103\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b3\u00104J\u001f\u00109\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\t¢\u0006\u0004\b;\u0010\u0003J\u0015\u0010=\u001a\u00020\t2\u0006\u0010\b\u001a\u00020<¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\t2\u0006\u0010\b\u001a\u000205¢\u0006\u0004\b?\u0010@J%\u0010D\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\f¢\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u0005¢\u0006\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010JR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020M0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010NR&\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR&\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010QR$\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010QR\u0016\u0010V\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010UR\u0016\u0010W\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010UR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010XR0\u0010]\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010Zj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010\\R0\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010Zj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`[8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010^¨\u0006`"}, d2 = {"Luf/c;", "", "<init>", "()V", "", "", "map", "Lvf/f;", "metric", "Lr8/z;", "b", "(Ljava/util/Map;Lvf/f;)V", "", "k", "v", "h", "(Ljava/util/Map;Ljava/lang/String;I)V", "i", "a", "blockSize", "", "timeMs", "resendCount", "resendRate", "avgLossRate", "rtt", "minRtt", "maxRtt", "avgRtt", "u", "(Ljava/util/Map;IJIIIIIII)I", "t", "(Ljava/util/Map;)V", "", "e", "(Ljava/util/Map;)Ljava/lang/String;", "c", "()Ljava/util/Map;", "seconds", "(I)V", "", "g", "()Z", "p", "s", "errorType", "errorCode", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, "(Lvf/f;IILjava/lang/String;)V", "m", "(Lvf/f;)V", "n", "(IIIJIIIII)I", "Lvf/a;", "playMetric", "Lvf/b;", "stabilityMetric", "o", "(Lvf/a;Lvf/b;)V", "f", "Lvf/d;", "q", "(Lvf/d;)V", "l", "(Lvf/a;)V", "playSession", "videoName", "eventCode", "r", "(JLjava/lang/String;I)V", TypedValues.TransitionType.S_FROM, "j", "(Ljava/lang/String;)V", "Lq6/b;", "Lq6/b;", "logger", "Lx1/f1/lb/host/a;", "Luf/b;", "Lx1/f1/lb/host/a;", "serverProvider", "d", "Ljava/util/Map;", "heartBeatBeginMap", "heartBeatMap", "streamMap", "Z", "isStartupReported", "isClickCountReportedBefore", "I", "zappingTimeBotWhenGT", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "_baseMap", "()Ljava/util/HashMap;", "baseMap", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19486a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final x1.f1.lb.host.a<b> serverProvider;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static Map<String, Object> heartBeatBeginMap;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Map<String, Object> heartBeatMap;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Map<String, Integer> streamMap;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean isStartupReported;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isClickCountReportedBefore;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int zappingTimeBotWhenGT;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Object> _baseMap;

    public final void l(vf.a metric) {
        m.f(metric, "metric");
        Map<String, ? extends Object> mapC = c();
        mapC.put(MessageOriginChannel.MESSAGE_ORIGIN_TYPE, metric.g());
        mapC.put("streamId", metric.N());
        mapC.put("route", metric.I());
        mapC.put("session", Long.valueOf(metric.K()));
        mapC.put("eventTime", Long.valueOf(metric.K()));
        mapC.put("reportTime", Long.valueOf(d1.c()));
        mapC.put("playType", metric.u());
        mapC.put("mediaPlayMode", Integer.valueOf(metric.l()));
        mapC.put("isEcoMode", Integer.valueOf(metric.h()));
        mapC.put("playSq", Integer.valueOf(metric.t()));
        mapC.put("playMs", Long.valueOf(metric.s()));
        mapC.put("bufferingCnt", Integer.valueOf(metric.e()));
        mapC.put("bufferingMs", Long.valueOf(metric.O()));
        mapC.put("minBufferingMs", Long.valueOf(metric.n() == LocationRequestCompat.PASSIVE_INTERVAL ? 0L : metric.n()));
        mapC.put("maxBufferingMs", Long.valueOf(metric.j() != Long.MIN_VALUE ? metric.j() : 0L));
        mapC.put("nullBlockCnt", Integer.valueOf(metric.q()));
        mapC.put("skipBlockCnt", Integer.valueOf(metric.L()));
        mapC.put("requestPlaylistCnt", Integer.valueOf(metric.x()));
        mapC.put("playlistBlockCnt", Integer.valueOf(metric.r()));
        mapC.put("requestBlockCnt", Integer.valueOf(metric.v()));
        mapC.put("requestIndexDistribution", metric.w());
        mapC.put("bufferingDistribution", metric.f());
        mapC.put("noSignalCnt", Integer.valueOf(metric.p()));
        mapC.put("restartPlayerCnt", Integer.valueOf(metric.A()));
        mapC.put("restartPlayerDisorderTSSeqCnt", Integer.valueOf(metric.B()));
        mapC.put("restartPlayerBufferingTooLongCnt", Integer.valueOf(metric.z()));
        mapC.put("restartPlayerNoListRequestTooLongCnt", Integer.valueOf(metric.F()));
        mapC.put("restartPlayerNoListResponseTooLongCnt", Integer.valueOf(metric.G()));
        mapC.put("restartPlayerNoListUpdateTooLongCnt", Integer.valueOf(metric.H()));
        mapC.put("restartPlayerNoBlockResponseTooLongCnt", Integer.valueOf(metric.D()));
        mapC.put("restartPlayerNoBlockRequestTooLongCnt", Integer.valueOf(metric.C()));
        mapC.put("restartPlayerNoBlockUpdateTooLongCnt", Integer.valueOf(metric.E()));
        mapC.put("videoHeight", Integer.valueOf(metric.Q()));
        mapC.put("videoWidth", Integer.valueOf(metric.R()));
        mapC.put("resolutionType", metric.y());
        mapC.put("videoCodec", metric.P());
        mapC.put("audioCodec", metric.a());
        mapC.put("bps", Integer.valueOf(metric.d()));
        mapC.put("minBps", Integer.valueOf(metric.m()));
        mapC.put("maxBps", Integer.valueOf(metric.i()));
        mapC.put("avgBps", Integer.valueOf(metric.b()));
        mapC.put("rtt", Integer.valueOf(metric.J()));
        mapC.put("minRtt", Integer.valueOf(metric.o()));
        mapC.put("maxRtt", Integer.valueOf(metric.k()));
        mapC.put("avgRtt", Integer.valueOf(metric.c()));
        Map<String, AtomicInteger> mapM = metric.M();
        m.e(mapM, "getStreamEvent(...)");
        for (Map.Entry<String, AtomicInteger> entry : mapM.entrySet()) {
            mapC.put(entry.getKey(), Integer.valueOf(entry.getValue().get()));
        }
        if (f.f20678a.x0()) {
            logger.a("metricReport: liveChannelEndStability[{}]", mapC);
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("metricReport: liveChannelEndStability[{}]", mapC);
        }
        x1.f1.lb.metric.monitor.a.f20887a.o(metric);
        b bVar = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar != null) {
            bVar.d("liveChannelEndStability", mapC);
        }
    }

    static {
        q6.b bVarD = q6.c.d(c.class);
        m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        serverProvider = x1.f1.lb.host.b.f20720a.i();
        zappingTimeBotWhenGT = 8000;
        _baseMap = new HashMap<>();
    }

    private final void b(Map<String, Object> map, vf.f metric) {
        if (metric == null) {
            return;
        }
        map.put("zappingTimeMs", Long.valueOf(metric.x()));
        map.put("stopPlayerMs", Long.valueOf(metric.m()));
        map.put("stopEnginePlayMs", Long.valueOf(metric.c()));
        map.put("startEnginePlayMs", Long.valueOf(metric.b()));
        map.put("injectUrlMs", Long.valueOf(metric.n()));
        map.put("firstPlaylistRequestMs", Long.valueOf(metric.d()));
        map.put("firstPlaylistResponseMs", Long.valueOf(metric.e()));
        map.put("firstBlockRequestMs", Long.valueOf(metric.g()));
        map.put("firstBlockResponseMs", Long.valueOf(metric.h()));
        map.put("firstBlockIndexInPlaylist", Integer.valueOf(metric.f()));
        map.put("lastBlockResponseMs", Long.valueOf(metric.i()));
        map.put("blockCnt", Integer.valueOf(metric.q()));
        map.put("renderMs", Long.valueOf(metric.o()));
        Map<String, Integer> mapW = metric.w();
        m.e(mapW, "getStreamMap(...)");
        map.putAll(mapW);
        Map<String, AtomicInteger> mapU = metric.u();
        m.e(mapU, "getStreamEvent(...)");
        for (Map.Entry<String, AtomicInteger> entry : mapU.entrySet()) {
            map.put(entry.getKey(), Integer.valueOf(entry.getValue().get()));
        }
    }

    private final Map<String, Object> c() {
        HashMap map = new HashMap();
        map.putAll(d());
        z zVar = z.f21470a;
        map.put("isMobile", Boolean.valueOf(zVar.z()));
        map.put("uid", of.a.f16585a.b());
        List<String> listM = zVar.m();
        if (!listM.isEmpty()) {
            map.put("gateWay", listM);
        }
        List<String> listN = zVar.n();
        if (!listN.isEmpty()) {
            map.put("Ip/Mask", listN);
        }
        map.put("networkDesc", e.f20898a.a());
        map.put("reportTime", Long.valueOf(d1.d()));
        return map;
    }

    private final HashMap<String, Object> d() {
        HashMap<String, Object> map = _baseMap;
        if (map.isEmpty()) {
            of.a aVar = of.a.f16585a;
            map.put("appStartupUid", aVar.b());
            map.put("did", aVar.k());
            map.put("sn", aVar.j());
            map.put("appId", Integer.valueOf(aVar.a()));
            map.put("appDistributionChannel", aVar.f());
            map.put("tenantId", Integer.valueOf(aVar.h()));
            map.put("appVer", Long.valueOf(aVar.i()));
            map.put("brandId", Integer.valueOf(aVar.d()));
            map.put("loginSession", Long.valueOf(x1.f1.lb.user.f.f21202a.q0()));
        }
        return map;
    }

    private final String e(Map<String, ? extends Object> map) {
        String string;
        Object obj = map.get("networkDesc");
        return (obj == null || (string = obj.toString()) == null) ? "" : string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(Map<String, Object> map) {
        if (map == null) {
            map = c();
        }
        Map<String, Integer> map2 = streamMap;
        if (map2 != null) {
            synchronized ("stream") {
                try {
                    streamMap = null;
                    Integer num = map2.get("totalResendPktCnt");
                    int iIntValue = num != null ? num.intValue() : 0;
                    if (iIntValue > 0) {
                        Integer num2 = map2.get("blockCnt");
                        int iIntValue2 = num2 != null ? num2.intValue() : 0;
                        Integer num3 = map2.get("totalTimeMs");
                        int iIntValue3 = num3 != null ? num3.intValue() : 0;
                        Integer num4 = map2.get("totalSize");
                        int iIntValue4 = num4 != null ? num4.intValue() : 0;
                        if (iIntValue2 > 0) {
                            map2.put("avgTimeMs", Integer.valueOf(iIntValue3 / iIntValue2));
                        }
                        if (iIntValue3 > 0) {
                            map2.put("avgKbps", Integer.valueOf((iIntValue4 << 3) / iIntValue3));
                        }
                        Integer num5 = map2.get("totalPktCnt");
                        int iIntValue5 = num5 != null ? num5.intValue() : 0;
                        if (iIntValue5 > 0) {
                            map2.put("avgResendRate", Integer.valueOf((iIntValue * 100) / iIntValue5));
                            Integer num6 = map2.get("totalLossPktCnt");
                            map2.put("avgAvgLossRate", Integer.valueOf(((num6 != null ? num6.intValue() : 0) * 100) / iIntValue5));
                        }
                        map.putAll(map2);
                    }
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (f.f20678a.x0()) {
            logger.a("metricReport: liveHeartbeat[{}]", map);
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("metricReport: liveHeartbeat[{}]", map);
        }
        b bVar = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar != 0) {
            bVar.d("liveHeartbeat", map);
        }
    }

    private final int u(Map<String, Integer> map, int blockSize, long timeMs, int resendCount, int resendRate, int avgLossRate, int rtt, int minRtt, int maxRtt, int avgRtt) {
        int i10;
        a(map, "blockCnt", 1);
        a(map, "totalSize", blockSize);
        i(map, "minBlockSize", blockSize);
        h(map, "maxBlockSize", blockSize);
        int i11 = (int) timeMs;
        a(map, "totalTimeMs", i11);
        i(map, "minTimeMs", i11);
        h(map, "maxTimeMs", i11);
        if (i11 > 0) {
            i10 = (blockSize << 3) / i11;
            i(map, "minKbps", i10);
            h(map, "maxKbps", i10);
        } else {
            i10 = 0;
        }
        if (resendCount > 0 && resendRate > 0) {
            a(map, "totalResendPktCnt", resendCount);
            int i12 = (resendCount * 100) / resendRate;
            a(map, "totalPktCnt", i12);
            i(map, "minResendRate", resendRate);
            h(map, "maxResendRate", resendRate);
            a(map, "totalLossPktCnt", (i12 * avgLossRate) / 100);
            i(map, "minAvgLossRate", avgLossRate);
            h(map, "maxAvgLossRate", avgLossRate);
        }
        map.put("rtt", Integer.valueOf(rtt));
        map.put("minRTT", Integer.valueOf(minRtt));
        map.put("maxRTT", Integer.valueOf(maxRtt));
        map.put("avgRtt", Integer.valueOf(avgRtt));
        return i10;
    }

    public final void f() {
        Map<String, Object> map = heartBeatMap;
        if (map == null) {
            return;
        }
        t(map);
        heartBeatMap = null;
    }

    public final boolean g() {
        return isStartupReported;
    }

    public final void j(String from) {
        m.f(from, "from");
        Map<String, AtomicInteger> mapP = d.f20812a.p();
        if (isClickCountReportedBefore && mapP.isEmpty()) {
            return;
        }
        if (!isClickCountReportedBefore) {
            isClickCountReportedBefore = true;
        }
        Map<String, ? extends Object> mapC = c();
        mapC.put("report_from", from);
        mapC.putAll(mapP);
        logger.a("metricReport: userClickCount[{}]", mapC);
        b bVar = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar != null) {
            bVar.d("userClickCount", mapC);
        }
    }

    public final void k(vf.f metric, int errorType, int errorCode, String error) {
        m.f(metric, "metric");
        m.f(error, "error");
        Map<String, ? extends Object> mapC = c();
        long jC = d1.c();
        long jT = jC - metric.t();
        mapC.put(MessageOriginChannel.MESSAGE_ORIGIN_TYPE, metric.a());
        mapC.put("streamId", metric.v());
        mapC.put("route", metric.s());
        mapC.put("playSession", Long.valueOf(metric.t()));
        mapC.put("eventTime", Long.valueOf(metric.t()));
        mapC.put("reportTime", Long.valueOf(jC));
        mapC.put("playSq", Integer.valueOf(metric.k()));
        mapC.put("playType", metric.l());
        mapC.put("mediaPlayMode", Integer.valueOf(metric.j()));
        mapC.put("errorType", Integer.valueOf(errorType));
        mapC.put("errorCode", Integer.valueOf(errorCode));
        mapC.put("errorMsg", error);
        mapC.put("durationMs", Long.valueOf(jT));
        b(mapC, metric);
        if (f.f20678a.x0()) {
            logger.a("metricReport: liveChannelAbnormal[{}]", mapC);
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("metricReport: liveChannelAbnormal[{}]", mapC);
        }
        x1.f1.lb.metric.monitor.a.f20887a.m(mapC);
        b bVar = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar != null) {
            bVar.d("liveChannelAbnormal", mapC);
        }
    }

    public final void m(vf.f metric) {
        m.f(metric, "metric");
        Map<String, ? extends Object> mapC = c();
        mapC.put(MessageOriginChannel.MESSAGE_ORIGIN_TYPE, metric.a());
        mapC.put("streamId", metric.v());
        mapC.put("route", metric.s());
        mapC.put("playSession", Long.valueOf(metric.t()));
        mapC.put("eventTime", Long.valueOf(metric.t()));
        mapC.put("reportTime", Long.valueOf(d1.c()));
        mapC.put("playSq", Integer.valueOf(metric.k()));
        mapC.put("playType", metric.l());
        mapC.put("mediaPlayMode", Integer.valueOf(metric.j()));
        b(mapC, metric);
        tf.c cVarH = x1.f1.lb.metric.monitor.f.f20907a.h();
        if (metric.x() > zappingTimeBotWhenGT) {
            String strB = d1.b(metric.x(), null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[zapping time]\n");
            sb2.append("[");
            sb2.append(metric.l());
            sb2.append("]");
            sb2.append("[");
            sb2.append(metric.a());
            sb2.append("(");
            sb2.append(metric.v());
            sb2.append(")] ");
            sb2.append(strB);
            sb2.append("\n");
            sb2.append("start from: blk ");
            sb2.append(metric.f());
            if (metric.y()) {
                sb2.append("(hit)");
            }
            sb2.append(", blk cnt: ");
            sb2.append(metric.q());
            if (cVarH != null) {
                sb2.append("\nloss rate: ");
                sb2.append(cVarH.k());
                sb2.append(", resend rate: ");
                sb2.append(cVarH.w());
                sb2.append(", resend cnt: ");
                sb2.append(cVarH.v());
                sb2.append(", rtt: ");
                sb2.append(cVarH.G());
            }
            sb2.append("\n");
            sb2.append("1st idx: rq ");
            sb2.append(metric.d());
            sb2.append(" ms, rp ");
            sb2.append(metric.e());
            sb2.append(" ms\n");
            sb2.append("1st blk: rq ");
            sb2.append(metric.g());
            sb2.append(" ms, rp ");
            sb2.append(metric.h());
            sb2.append(" ms");
            String string = sb2.toString();
            m.e(string, "toString(...)");
            x1.f1.lb.bot.a.f20583a.n(string);
        }
        q6.b bVar = logger;
        bVar.a("stream[" + metric.v() + "] zappingTime[" + metric.x() + "] network[" + e(mapC) + "]", new Object[0]);
        if (f.f20678a.x0()) {
            bVar.a("metricReport: liveChannelZappingTime[{}]", mapC);
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            bVar.debug("metricReport: liveChannelZappingTime[{}]", mapC);
        }
        x1.f1.lb.metric.monitor.a.f20887a.n(metric);
        b bVar2 = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar2 != null) {
            bVar2.d("liveChannelZappingTime", mapC);
        }
    }

    public final int n(int blockSize, int resendCount, int resendRate, long timeMs, int avgLossRate, int rtt, int minRtt, int maxRtt, int avgRtt) {
        c cVar;
        int iU;
        Map<String, Integer> mapC;
        synchronized ("stream") {
            try {
                Map<String, Integer> map = streamMap;
                if (map == null) {
                    map = new HashMap<>();
                }
                Map<String, Integer> map2 = map;
                cVar = f19486a;
                iU = cVar.u(map2, blockSize, timeMs, resendCount, resendRate, avgLossRate, rtt, minRtt, maxRtt, avgRtt);
                streamMap = map2;
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        tf.d dVarC = h.f20952a.c();
        if (dVarC != null && (mapC = dVarC.C()) != null) {
            cVar.u(mapC, blockSize, timeMs, resendCount, resendRate, avgLossRate, rtt, minRtt, maxRtt, avgRtt);
        }
        return iU;
    }

    public final void o(vf.a playMetric, vf.b stabilityMetric) {
        long j10;
        m.f(stabilityMetric, "stabilityMetric");
        if (playMetric == null) {
            return;
        }
        synchronized (this) {
            String strN = playMetric.N();
            String strI = playMetric.I();
            long jK = playMetric.K();
            int iT = playMetric.t();
            String strU = playMetric.u();
            int iL = playMetric.l();
            int iE = playMetric.e();
            int iP = playMetric.p();
            int iL2 = playMetric.L();
            int iQ = playMetric.q();
            long jA = stabilityMetric.a();
            Map<String, Object> map = heartBeatBeginMap;
            if (map == null) {
                Map<String, Object> mapC = f19486a.c();
                mapC.put("streamId", strN);
                mapC.put("route", strI);
                mapC.put("playSession", Long.valueOf(jK));
                mapC.put("playSeq", Integer.valueOf(iT));
                mapC.put("mediaPlayMode", Integer.valueOf(iL));
                mapC.put("playType", strU);
                mapC.put("bufferingCnt", Integer.valueOf(iE));
                mapC.put("noSignalCnt", Integer.valueOf(iP));
                mapC.put("skipBlockCnt", Integer.valueOf(iL2));
                mapC.put("nullBlockCnt", Integer.valueOf(iQ));
                return;
            }
            Map<String, Object> mapC2 = heartBeatMap;
            if (m.a(map.get("streamId"), strN) && m.a(map.get("route"), strI)) {
                j10 = jK;
                if (m.a(map.get("playSession"), Long.valueOf(j10))) {
                    if (mapC2 == null) {
                        mapC2 = f19486a.c();
                        mapC2.put("streamId", strN);
                        mapC2.put("route", strI);
                        mapC2.put("playSession", Long.valueOf(j10));
                        mapC2.put("playSeq", Integer.valueOf(iT));
                        mapC2.put("mediaPlayMode", Integer.valueOf(iL));
                        mapC2.put("playType", strU);
                    }
                    Object obj = map.get("bufferingCnt");
                    m.d(obj, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = iE - ((Integer) obj).intValue();
                    Object obj2 = map.get("noSignalCnt");
                    m.d(obj2, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue2 = iP - ((Integer) obj2).intValue();
                    Object obj3 = map.get("skipBlockCnt");
                    m.d(obj3, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue3 = iL2 - ((Integer) obj3).intValue();
                    Object obj4 = map.get("nullBlockCnt");
                    m.d(obj4, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue4 = iQ - ((Integer) obj4).intValue();
                    if (iIntValue < 0) {
                        iIntValue = 0;
                    }
                    mapC2.put("bufferingCnt", Integer.valueOf(iIntValue));
                    if (iIntValue2 < 0) {
                        iIntValue2 = 0;
                    }
                    mapC2.put("noSignalCnt", Integer.valueOf(iIntValue2));
                    if (iIntValue3 < 0) {
                        iIntValue3 = 0;
                    }
                    mapC2.put("skipBlockCnt", Integer.valueOf(iIntValue3));
                    if (iIntValue4 < 0) {
                        iIntValue4 = 0;
                    }
                    mapC2.put("nullBlockCnt", Integer.valueOf(iIntValue4));
                    Object objValueOf = mapC2.get("maxBufferDuration");
                    if (objValueOf == null) {
                        objValueOf = Long.valueOf(jA);
                    }
                    m.d(objValueOf, "null cannot be cast to non-null type kotlin.Long");
                    long jLongValue = ((Long) objValueOf).longValue();
                    if (jLongValue < jA) {
                        jLongValue = jA;
                    }
                    mapC2.put("maxBufferDuration", Long.valueOf(jLongValue));
                    Object objValueOf2 = mapC2.get("minBufferDuration");
                    if (objValueOf2 == null) {
                        objValueOf2 = Long.valueOf(jA);
                    }
                    m.d(objValueOf2, "null cannot be cast to non-null type kotlin.Long");
                    long jLongValue2 = ((Long) objValueOf2).longValue();
                    if (jLongValue2 > jA) {
                        jLongValue2 = jA;
                    }
                    mapC2.put("minBufferDuration", Long.valueOf(jLongValue2));
                    Object obj5 = mapC2.get("totalBufferDuration");
                    if (obj5 == null) {
                        obj5 = 0L;
                    }
                    m.d(obj5, "null cannot be cast to non-null type kotlin.Long");
                    mapC2.put("totalBufferDuration", Long.valueOf(((Long) obj5).longValue() + jA));
                    heartBeatBeginMap = map;
                    heartBeatMap = mapC2;
                    r8.z zVar = r8.z.f17874a;
                    return;
                }
            } else {
                j10 = jK;
            }
            if (mapC2 != null) {
                f19486a.t(mapC2);
            }
            map.put("streamId", strN);
            map.put("route", strI);
            map.put("playSession", Long.valueOf(j10));
            map.put("playSeq", Integer.valueOf(iT));
            map.put("mediaPlayMode", Integer.valueOf(iL));
            map.put("playType", strU);
            map.put("bufferingCnt", Integer.valueOf(iE));
            map.put("noSignalCnt", Integer.valueOf(iP));
            map.put("skipBlockCnt", Integer.valueOf(iL2));
            map.put("nullBlockCnt", Integer.valueOf(iQ));
            heartBeatMap = null;
        }
    }

    public final void p() {
        vf.c cVarD = h.f20952a.d();
        if (cVarD == null) {
            return;
        }
        Map<String, ? extends Object> mapC = c();
        mapC.put("eventTime", Long.valueOf(cVarD.c()));
        mapC.put("reportTime", Long.valueOf(d1.c()));
        mapC.put("loginMs", Long.valueOf(cVarD.g()));
        mapC.put("loadChannelMs", Long.valueOf(cVarD.e()));
        mapC.put("startupEngineMs", Long.valueOf(cVarD.b()));
        mapC.put("loginFailure", cVarD.f());
        mapC.put("loadChannelFailure", cVarD.d());
        mapC.put("engineStartupFailure", cVarD.a());
        z zVar = z.f21470a;
        mapC.putAll(zVar.i());
        if (f.f20678a.x0()) {
            logger.a("metricReport: liveUserStartup[{}]", mapC);
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("metricReport: liveUserStartup[{}]", mapC);
        }
        x1.f1.lb.metric.monitor.a.f20887a.q(zVar.u(), x1.f1.lb.user.f.f21202a.q0());
        b bVar = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar != null) {
            bVar.d("liveUserStartup", mapC);
        }
        if (isStartupReported) {
            return;
        }
        isStartupReported = true;
    }

    public final void q(vf.d metric) {
        m.f(metric, "metric");
        Map<String, ? extends Object> mapC = c();
        mapC.put("streamId", metric.streamId);
        mapC.put("route", metric.route);
        mapC.put("playType", metric.playType);
        mapC.put("mediaPlayMode", Integer.valueOf(metric.mediaPlayMode));
        mapC.put("playSession", Long.valueOf(metric.session));
        mapC.put("eventTime", Long.valueOf(metric.session));
        mapC.put("reportTime", Long.valueOf(d1.c()));
        mapC.put("blockCnt", Integer.valueOf(metric.blockCnt));
        mapC.put("maxBlockSize", Integer.valueOf(metric.maxBlockSize));
        mapC.put("avgBlockSize", Integer.valueOf((int) metric.avgBlockSize));
        mapC.put("minBlockSize", Integer.valueOf(metric.minBlockSize));
        mapC.put("maxTime", Long.valueOf(metric.maxTime));
        mapC.put("avgTime", Integer.valueOf((int) metric.avgTime));
        mapC.put("minTime", Long.valueOf(metric.minTime));
        mapC.put("maxResendCnt", Integer.valueOf(metric.maxResendCnt));
        mapC.put("avgResendCnt", Integer.valueOf((int) metric.avgResendCnt));
        mapC.put("minResendCnt", Integer.valueOf(metric.minResendCnt));
        mapC.put("maxResendRate", Integer.valueOf(metric.maxResendRate));
        mapC.put("avgResendRate", Integer.valueOf((int) metric.avgResendRate));
        mapC.put("minResendRate", Integer.valueOf(metric.minResendRate));
        mapC.put("maxAvgLossRate", Integer.valueOf(metric.maxAvgLossRate));
        mapC.put("avgAvgLossRate", Integer.valueOf((int) metric.avgAvgLossRate));
        mapC.put("minAvgLossRate", Integer.valueOf(metric.minAvgLossRate));
        mapC.put("resendCntDistribution", metric.resendCntDistributionMap);
        mapC.put("resendRateDistribution", metric.resendRateDistributionMap);
        mapC.put("avgLossRateDistribution", metric.avgLossRateDistributionMap);
        mapC.put("timeDistribution", metric.timeDistribution);
        mapC.put("blockSizeDistribution", metric.sizeDistributionMap);
        if (f.f20678a.x0()) {
            logger.a("metricReport: liveStreamEndStability[{}]", mapC);
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("metricReport: liveStreamEndStability[{}]", mapC);
        }
        b bVar = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar != null) {
            bVar.d("liveStreamEndStability", mapC);
        }
    }

    public final void r(long playSession, String videoName, int eventCode) {
        m.f(videoName, "videoName");
        Map<String, ? extends Object> mapC = c();
        mapC.put("videoName", videoName);
        mapC.put("playSession", Long.valueOf(playSession));
        mapC.put("reportTime", Long.valueOf(d1.c()));
        mapC.put("eventCode", Integer.valueOf(eventCode));
        if (f.f20678a.x0()) {
            logger.a("metricReport: streamingEventMetric[{}]", mapC);
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("metricReport: streamingEventMetric[{}]", mapC);
        }
        b bVar = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar != null) {
            bVar.d("streamingEvent", mapC);
        }
    }

    public final void s() {
        vf.e eVarB = i.f20958a.b();
        if (eVarB == null) {
            return;
        }
        Map<String, ? extends Object> mapC = c();
        mapC.put("eventTime", Long.valueOf(eVarB.e()));
        mapC.put("reportTime", Long.valueOf(d1.c()));
        mapC.put("infoCompleteOverhead", Long.valueOf(eVarB.f()));
        mapC.put("infoFailureMsg", eVarB.g());
        mapC.put("apkDownloadOverhead", Long.valueOf(eVarB.b()));
        mapC.put("apkDownloadFailureMsg", eVarB.a());
        mapC.put("apkInstallStartTime", Long.valueOf(eVarB.d()));
        mapC.put("apkInstallFailureMsg", eVarB.c());
        if (f.f20678a.x0()) {
            logger.a("metricReport: liveUpgrade[{}]", mapC);
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("metricReport: liveUpgrade[{}]", mapC);
        }
        x1.f1.lb.metric.monitor.a.f20887a.d(eVarB);
        b bVar = (b) x1.f1.lb.host.a.b(serverProvider, 0, 1, null);
        if (bVar != null) {
            bVar.d("liveUpgrade", mapC);
        }
    }

    public final void v(int seconds) {
        zappingTimeBotWhenGT = seconds * 1000;
    }

    private c() {
    }

    private final void a(Map<String, Integer> map, String k10, int v10) {
        int iIntValue;
        Integer num = map.get(k10);
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            iIntValue = 0;
        }
        map.put(k10, Integer.valueOf(iIntValue + v10));
    }

    private final void h(Map<String, Integer> map, String k10, int v10) {
        Integer num = map.get(k10);
        if (num == null) {
            map.put(k10, Integer.valueOf(v10));
        } else if (num.intValue() < v10) {
            map.put(k10, Integer.valueOf(v10));
        }
    }

    private final void i(Map<String, Integer> map, String k10, int v10) {
        Integer num = map.get(k10);
        if (num == null) {
            map.put(k10, Integer.valueOf(v10));
        } else if (num.intValue() > v10) {
            map.put(k10, Integer.valueOf(v10));
        }
    }
}
