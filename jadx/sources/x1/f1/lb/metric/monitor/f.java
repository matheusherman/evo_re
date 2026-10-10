package x1.f1.lb.metric.monitor;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import nf.o;
import nf.p;
import nf.q;
import org.greenrobot.eventbus.ThreadMode;
import ua.n;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.e0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u001d\u0010\u0018\u001a\u00020\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0003J\r\u0010&\u001a\u00020\b¢\u0006\u0004\b&\u0010\u0003J\u0015\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u0004\u0018\u00010+¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\b2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b1\u0010.J\r\u00102\u001a\u00020\b¢\u0006\u0004\b2\u0010\u0003J#\u00106\u001a\u00020\b2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0004032\u0006\u00105\u001a\u00020\u0006¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020<H\u0007¢\u0006\u0004\b>\u0010?J\u0017\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020@H\u0007¢\u0006\u0004\b>\u0010AJ\u0017\u0010C\u001a\u00020\b2\u0006\u0010=\u001a\u00020BH\u0007¢\u0006\u0004\bC\u0010DJ\u0015\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u000208¢\u0006\u0004\bF\u0010;J\u0017\u0010G\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bG\u0010HJ\u0015\u0010I\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bI\u0010HJ\u0085\u0001\u0010Y\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u0002082\u0006\u0010O\u001a\u0002082\u0006\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u0002082\u0006\u0010S\u001a\u0002082\u0006\u0010T\u001a\u0002082\u0006\u0010U\u001a\u0002082\u0006\u0010V\u001a\u0002082\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0004¢\u0006\u0004\bY\u0010ZJ\u0015\u0010[\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b[\u0010\\R\u001c\u0010`\u001a\n ^*\u0004\u0018\u00010]0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010cR\u0016\u0010f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010eR$\u0010n\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010qR\u0016\u0010t\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010sR\"\u0010w\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010s\u001a\u0004\bh\u0010u\"\u0004\bv\u0010;¨\u0006x"}, d2 = {"Lx1/f1/lb/metric/monitor/f;", "", "<init>", "()V", "", "blockName", "", "now", "Lr8/z;", "a", "(Ljava/lang/String;J)V", "Lvf/b;", "stabilityMetric", "x", "(Lvf/b;)V", "Ltf/b;", "stabilityStat", "e", "(Ltf/b;)Lvf/b;", "l", "k", "", "list", "", "j", "(Ljava/util/Collection;)Z", "tsUrl", "w", "(Ljava/lang/String;)Ljava/lang/Long;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "newPlayList", "b", "(Ljava/util/LinkedHashSet;)V", "session", "q", "(J)V", "t", "v", "Lx1/f1/lb/metric/monitor/c;", "monitor", "s", "(Lx1/f1/lb/metric/monitor/c;)V", "Ltf/d;", "zappingStat", "r", "(Ltf/d;)V", "i", "()Ltf/d;", "c", "n", "", "playList", "millis", "m", "(Ljava/util/List;J)V", "", "eventCode", "o", "(I)V", "Lnf/p;", NotificationCompat.CATEGORY_EVENT, "OnEvent", "(Lnf/p;)V", "Lnf/o;", "(Lnf/o;)V", "Lnf/f;", "onEvent", "(Lnf/f;)V", "code", "u", "g", "(Ljava/lang/String;)Ltf/b;", "p", "bps", "avgBps", "minBps", "maxBps", "rtt", "minRtt", "maxRtt", "avgRtt", "resendCnt", "lossRate", "resendRate", "videoWith", "videoHeight", "vCodec", "aCodec", "y", "(JJJJIIIIIIIIILjava/lang/String;Ljava/lang/String;)V", "d", "(Ljava/lang/String;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Ltf/d;", "playerZappingStat", "Ltf/b;", "lastPlayStabilityStat", "J", "bufferingStartTime", "Ltf/c;", "f", "Ltf/c;", "h", "()Ltf/c;", "setPlayerMonitorStat", "(Ltf/c;)V", "playerMonitorStat", "Ljava/lang/String;", "playerZappingMetricTxt", "Lx1/f1/lb/metric/monitor/c;", "playerMonitor", "I", "latestRequestTsIndex", "()I", "setLatestPlayerFirstRequestBlkPosInIndexList", "latestPlayerFirstRequestBlkPosInIndexList", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static tf.d playerZappingStat;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static tf.b lastPlayStabilityStat;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long bufferingStartTime;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static tf.c playerMonitorStat;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static c playerMonitor;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20907a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(f.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String playerZappingMetricTxt = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int latestRequestTsIndex = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static int latestPlayerFirstRequestBlkPosInIndexList = 2;

    private final synchronized void k() {
        try {
            if (bufferingStartTime == 0) {
                return;
            }
            long jC = d1.c() - bufferingStartTime;
            logger.debug("buffering end duration[{}]", Long.valueOf(jC));
            tf.c cVar = playerMonitorStat;
            m.c(cVar);
            Collection<tf.b> collectionValues = cVar.u().values();
            m.e(collectionValues, "<get-values>(...)");
            for (tf.b bVar : r.D0(collectionValues)) {
                if (bVar.a() < bufferingStartTime) {
                    bVar.q(bVar.f() + jC);
                    break;
                }
            }
            tf.c cVar2 = playerMonitorStat;
            m.c(cVar2);
            cVar2.C0(cVar2.K() + jC);
            bufferingStartTime = 0L;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void l() {
        tf.c cVar = playerMonitorStat;
        m.c(cVar);
        cVar.W(cVar.f() + 1);
        bufferingStartTime = d1.c();
    }

    private final Long w(String tsUrl) {
        try {
            int iB0 = n.b0(tsUrl, ".ts", 0, false, 6, null);
            if (iB0 <= 0) {
                iB0 = tsUrl.length();
            }
            int i10 = iB0;
            int iG0 = n.g0(tsUrl, '_', i10, false, 4, null);
            if (iG0 >= 0 && i10 > iG0) {
                String strSubstring = tsUrl.substring(iG0 + 1, i10);
                m.e(strSubstring, "substring(...)");
                return Long.valueOf(Long.parseLong(strSubstring));
            }
            try {
                return Long.valueOf(Long.parseLong(tsUrl));
            } catch (Throwable unused) {
                logger.warn("no tsSeq found in [{}]", tsUrl);
                return null;
            }
        } catch (Throwable th) {
            logger.error("parse ts last seq failure", th);
            return null;
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.ASYNC)
    public final void OnEvent(p event) {
        m.f(event, "event");
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("buffering on start event", new Object[0]);
        }
        x1.f1.lb.streaming.client.a.f21004a.r();
        l();
        xe.c.c().s(event);
    }

    public final void y(long bps, long avgBps, long minBps, long maxBps, int rtt, int minRtt, int maxRtt, int avgRtt, int resendCnt, int lossRate, int resendRate, int videoWith, int videoHeight, String vCodec, String aCodec) {
        tf.c cVar;
        m.f(vCodec, "vCodec");
        m.f(aCodec, "aCodec");
        if (bps >= 1000 && (cVar = playerMonitorStat) != null) {
            cVar.V(bps);
            cVar.S(avgBps);
            cVar.l0(minBps);
            cVar.h0(maxBps);
            cVar.z0(rtt);
            cVar.m0(minRtt);
            cVar.j0(maxRtt);
            cVar.T(avgRtt);
            cVar.p0(resendCnt);
            cVar.g0(lossRate);
            cVar.q0(resendRate);
            cVar.H0(videoHeight);
            cVar.I0(videoWith);
            cVar.G0(vCodec);
            cVar.R(aCodec);
        }
    }

    private final void a(String blockName, long now) {
        String string;
        tf.c cVar = playerMonitorStat;
        if (cVar == null) {
            return;
        }
        Long lW = w(blockName);
        ConcurrentSkipListMap<String, tf.b> concurrentSkipListMapU = cVar.u();
        if (concurrentSkipListMapU != null) {
            int iD = cVar.d();
            cVar.U(iD + 1);
            concurrentSkipListMapU.put(blockName, new tf.b(blockName, lW, iD));
        }
        List<String> listR = cVar.r();
        if (lW == null || (string = lW.toString()) == null) {
            string = blockName;
        }
        listR.add(string);
        cVar.e0(blockName);
        cVar.f0(now);
    }

    private final vf.b e(tf.b stabilityStat) {
        return new vf.b(stabilityStat.c(), stabilityStat.h(), stabilityStat.e(), stabilityStat.d(), stabilityStat.m(), stabilityStat.k(), stabilityStat.g(), stabilityStat.l() - stabilityStat.j(), stabilityStat.f(), stabilityStat.b());
    }

    private final void q(long session) {
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("send-player-restart-event", new Object[0]);
        }
        xe.c.c().o(new q(session, 0, 1, "ts seq check"));
    }

    private final void x(vf.b stabilityMetric) {
        vf.a aVarO;
        tf.c cVar = playerMonitorStat;
        if (cVar == null || (aVarO = cVar.o()) == null) {
            return;
        }
        if (stabilityMetric.d()) {
            aVarO.i0(aVarO.q() + 1);
        }
        if (TextUtils.isEmpty(stabilityMetric.b())) {
            aVarO.B0(aVarO.L() + 1);
        }
        if (stabilityMetric.a() > 0) {
            aVarO.W(aVarO.e() + 1);
            long jA = stabilityMetric.a();
            if (aVarO.n() > jA) {
                aVarO.f0(jA);
            }
            if (aVarO.j() < jA) {
                aVarO.b0(jA);
            }
            long jPow = (long) Math.pow(10.0d, (long) Math.log10(jA));
            long j10 = (jA / jPow) * jPow;
            AtomicInteger atomicInteger = aVarO.f().get(Long.valueOf(j10));
            if (atomicInteger == null) {
                AtomicInteger atomicInteger2 = new AtomicInteger(1);
                Map<Long, AtomicInteger> mapF = aVarO.f();
                m.e(mapF, "getBufferingDistribution(...)");
                mapF.put(Long.valueOf(j10), atomicInteger2);
            } else {
                atomicInteger.incrementAndGet();
            }
        }
        int iC = stabilityMetric.c();
        AtomicInteger atomicInteger3 = aVarO.w().get(Integer.valueOf(iC));
        if (atomicInteger3 == null) {
            AtomicInteger atomicInteger4 = new AtomicInteger(1);
            Map<Integer, AtomicInteger> mapW = aVarO.w();
            m.e(mapW, "getRequestIndexDistribution(...)");
            mapW.put(Integer.valueOf(iC), atomicInteger4);
        } else {
            atomicInteger3.incrementAndGet();
        }
        aVarO.j0(d1.c() - aVarO.K());
    }

    public final void c(tf.d zappingStat) {
        m.f(zappingStat, "zappingStat");
        tf.c cVar = new tf.c();
        cVar.k0(zappingStat.r());
        cVar.o0(zappingStat.s());
        playerMonitorStat = cVar;
        zappingStat.monitorStat = cVar;
        vf.a aVarO = cVar.o();
        if (aVarO != null) {
            aVarO.X(zappingStat.getChannel());
            aVarO.y0(zappingStat.getRoute());
            aVarO.D0(zappingStat.getStreamId());
            aVarO.Z(zappingStat.q());
            aVarO.A0(zappingStat.y());
            aVarO.k0(zappingStat.getSeq());
            aVarO.d0(zappingStat.r());
            aVarO.l0(zappingStat.s().name());
        }
    }

    public final void d(String blockName) {
        tf.c cVar;
        ConcurrentSkipListMap<String, tf.b> concurrentSkipListMapU;
        ConcurrentSkipListMap<String, tf.b> concurrentSkipListMapU2;
        ConcurrentSkipListMap<String, tf.b> concurrentSkipListMapU3;
        ConcurrentSkipListMap<String, tf.b> concurrentSkipListMapU4;
        m.f(blockName, "blockName");
        tf.c cVar2 = playerMonitorStat;
        String strFirstKey = null;
        tf.b bVar = (cVar2 == null || (concurrentSkipListMapU4 = cVar2.u()) == null) ? null : concurrentSkipListMapU4.get(blockName);
        if (bVar != null) {
            vf.b bVarE = e(bVar);
            x(bVarE);
            uf.c cVar3 = uf.c.f19486a;
            tf.c cVar4 = playerMonitorStat;
            cVar3.o(cVar4 != null ? cVar4.o() : null, bVarE);
        }
        tf.c cVar5 = playerMonitorStat;
        if ((cVar5 != null ? cVar5.t() : null) == v6.c.LIVE) {
            tf.c cVar6 = playerMonitorStat;
            if (((cVar6 == null || (concurrentSkipListMapU3 = cVar6.u()) == null) ? 0 : concurrentSkipListMapU3.size()) <= 18 || (cVar = playerMonitorStat) == null || (concurrentSkipListMapU = cVar.u()) == null) {
                return;
            }
            tf.c cVar7 = playerMonitorStat;
            if (cVar7 != null && (concurrentSkipListMapU2 = cVar7.u()) != null) {
                strFirstKey = concurrentSkipListMapU2.firstKey();
            }
            concurrentSkipListMapU.remove(strFirstKey);
        }
    }

    public final int f() {
        return latestPlayerFirstRequestBlkPosInIndexList;
    }

    public final tf.b g(String blockName) {
        ConcurrentSkipListMap<String, tf.b> concurrentSkipListMapU;
        m.f(blockName, "blockName");
        tf.c cVar = playerMonitorStat;
        if (cVar == null || (concurrentSkipListMapU = cVar.u()) == null) {
            return null;
        }
        return concurrentSkipListMapU.get(blockName);
    }

    public final tf.c h() {
        return playerMonitorStat;
    }

    public final tf.d i() {
        return playerZappingStat;
    }

    public final void m(List<String> playList, long millis) {
        m.f(playList, "playList");
        tf.c cVar = playerMonitorStat;
        if (cVar == null) {
            return;
        }
        long jC = d1.c();
        cVar.D0(cVar.L() + 1);
        cVar.b0(jC - millis);
        cVar.c0(jC);
        Set<String> setG = cVar.g();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        cVar.r().clear();
        for (String str : playList) {
            int iB0 = n.b0(str, ".ts", 0, false, 6, null);
            if (iB0 > 0) {
                String strSubstring = str.substring(0, iB0);
                m.e(strSubstring, "substring(...)");
                linkedHashSet.add(strSubstring);
                if (!setG.contains(strSubstring)) {
                    a(strSubstring, jC);
                }
            }
        }
        for (String str2 : setG) {
            if (!linkedHashSet.contains(str2)) {
                m.c(str2);
                d(str2);
            }
        }
        cVar.X(linkedHashSet);
        cVar.Z(millis);
        if (linkedHashSet.size() > cVar.m()) {
            cVar.i0(linkedHashSet.size());
        }
        if (cVar.t() == v6.c.LIVE && !linkedHashSet.isEmpty()) {
            b(linkedHashSet);
        }
        String strH = cVar.h();
        m.e(strH, "getDisorderSeq(...)");
        if (strH.length() > 0) {
            if (j(linkedHashSet)) {
                logger.warn("playlist seq reset and out of order, disorderSeq[{}]", cVar.h());
                return;
            }
            q(cVar.o().K());
            logger.warn("playlist become in order, send player restart event, disorderSeq[{}]", cVar.h());
            cVar.Y("");
        }
    }

    public final void n() {
        vf.a aVarO;
        tf.c cVar = playerMonitorStat;
        if (cVar == null || (aVarO = cVar.o()) == null || !cVar.f19235a.compareAndSet(false, true)) {
            return;
        }
        aVarO.n0(cVar.L());
        aVarO.m0(cVar.J());
        aVarO.E0(cVar.K());
        aVarO.h0(cVar.s());
        aVarO.q0(cVar.H());
        aVarO.r0(cVar.z());
        aVarO.p0(cVar.y());
        aVarO.v0(cVar.D());
        aVarO.w0(cVar.E());
        aVarO.x0(cVar.F());
        aVarO.t0(cVar.B());
        aVarO.s0(cVar.A());
        aVarO.u0(cVar.C());
        aVarO.I0(cVar.Q());
        aVarO.H0(cVar.P());
        aVarO.o0(cVar.x());
        aVarO.G0(cVar.O());
        aVarO.S(cVar.a());
        aVarO.V((int) cVar.e());
        aVarO.T((int) cVar.b());
        aVarO.e0((int) cVar.p());
        aVarO.a0((int) cVar.l());
        aVarO.z0(cVar.G());
        aVarO.g0(cVar.q());
        aVarO.c0(cVar.n());
        aVarO.U(cVar.c());
        aVarO.F0(cVar.M());
        aVarO.C0(cVar.I());
        uf.c.f19486a.l(aVarO);
    }

    public final void o(int eventCode) {
        tf.c cVar = playerMonitorStat;
        if (cVar == null) {
            return;
        }
        cVar.A0(cVar.H() + 1);
        switch (eventCode) {
            case 0:
                cVar.s0(cVar.z() + 1);
                break;
            case 1:
                cVar.r0(cVar.y() + 1);
                break;
            case 2:
                cVar.w0(cVar.D() + 1);
                break;
            case 3:
                cVar.t0(cVar.A() + 1);
                break;
            case 4:
                cVar.x0(cVar.E() + 1);
                break;
            case 5:
                cVar.y0(cVar.F() + 1);
                break;
            case 6:
                cVar.u0(cVar.B() + 1);
                break;
            case 7:
                cVar.v0(cVar.C() + 1);
                break;
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.ASYNC)
    public final void onEvent(nf.f event) {
        m.f(event, "event");
        tf.c cVar = playerMonitorStat;
        if (cVar == null) {
            return;
        }
        cVar.o().Y(1);
    }

    public final tf.b p(String blockName) {
        ConcurrentSkipListMap<String, tf.b> concurrentSkipListMapU;
        ConcurrentSkipListMap<String, tf.b> concurrentSkipListMapU2;
        m.f(blockName, "blockName");
        tf.c cVar = playerMonitorStat;
        NavigableSet navigableSet = null;
        tf.b bVar = (cVar == null || (concurrentSkipListMapU2 = cVar.u()) == null) ? null : concurrentSkipListMapU2.get(blockName);
        if (bVar == null) {
            Long lW = w(blockName);
            tf.c cVar2 = playerMonitorStat;
            m.c(cVar2);
            int iD = cVar2.d();
            cVar2.U(iD + 1);
            tf.b bVar2 = new tf.b(blockName, lW, iD);
            if (x1.f1.lb.config.b.f20643a.t()) {
                q6.b bVar3 = logger;
                tf.c cVar3 = playerMonitorStat;
                if (cVar3 != null && (concurrentSkipListMapU = cVar3.u()) != null) {
                    navigableSet = (NavigableSet) concurrentSkipListMapU.keySet();
                }
                bVar3.debug("null stability stat on ts request\n{},{}", navigableSet, blockName);
            }
            bVar = bVar2;
        }
        long jC = d1.c();
        tf.c cVar4 = playerMonitorStat;
        if (cVar4 != null) {
            cVar4.a0(jC);
        }
        tf.c cVar5 = playerMonitorStat;
        m.c(cVar5);
        Set<String> setG = cVar5.g();
        m.e(setG, "getCurrentPlaylist(...)");
        int iK0 = r.k0(setG, blockName);
        if (bVar.i() == -1) {
            bVar.t(iK0);
            latestPlayerFirstRequestBlkPosInIndexList = iK0;
            bVar.v(iK0);
        } else {
            bVar.v(iK0);
        }
        if (bVar.j() == 0) {
            bVar.u(jC);
        }
        latestRequestTsIndex = iK0;
        tf.c cVar6 = playerMonitorStat;
        m.c(cVar6);
        int iJ = cVar6.J();
        cVar6.B0(iJ + 1);
        bVar.s(String.valueOf(iJ));
        lastPlayStabilityStat = bVar;
        return bVar;
    }

    public final void r(tf.d zappingStat) {
        playerZappingStat = zappingStat;
        if (zappingStat != null) {
            playerZappingMetricTxt = h.f20952a.h(zappingStat);
        }
    }

    public final void s(c monitor) {
        m.f(monitor, "monitor");
        playerMonitor = monitor;
    }

    public final void t() {
        e0.f21385a.a(this);
    }

    public final void u(int code) {
        tf.c cVar = playerMonitorStat;
        if (cVar != null) {
            if (code == 4003) {
                cVar.n0(cVar.s() + 1);
            }
            String str = "e_" + code;
            AtomicInteger atomicInteger = cVar.I().get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(0);
                Map<String, AtomicInteger> mapI = cVar.I();
                m.e(mapI, "getStreamEvent(...)");
                mapI.put(str, atomicInteger);
            }
            atomicInteger.incrementAndGet();
        }
    }

    public final void v() {
        e0.f21385a.b(this);
    }

    private f() {
    }

    private final void b(LinkedHashSet<String> newPlayList) {
        Long lW = w((String) r.r0(newPlayList));
        if (lW != null) {
            long jLongValue = lW.longValue();
            tf.c cVar = playerMonitorStat;
            if (cVar != null) {
                if (cVar.i() > jLongValue) {
                    cVar.F0(cVar.N() + 1);
                    cVar.Y(cVar.i() + ".ts");
                } else if (cVar.i() >= 0 && cVar.i() + 1 < jLongValue) {
                    long jI = cVar.i() + 1;
                    Iterator<String> it = newPlayList.iterator();
                    m.e(it, "iterator(...)");
                    while (it.hasNext()) {
                        String next = it.next();
                        m.e(next, "next(...)");
                        Long lW2 = w(next);
                        if (lW2 == null) {
                            break;
                        }
                        long jLongValue2 = lW2.longValue();
                        if (jLongValue2 > jI) {
                            cVar.E0(cVar.M() + 1);
                            jI = jLongValue2 + 1;
                        } else {
                            jI++;
                        }
                    }
                }
                cVar.d0(jLongValue);
            }
        }
    }

    private final boolean j(Collection<String> list) {
        for (String str : list) {
            tf.c cVar = playerMonitorStat;
            m.c(cVar);
            String strH = cVar.h();
            m.e(strH, "getDisorderSeq(...)");
            if (n.v(str, strH, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.ASYNC)
    public final void OnEvent(o event) {
        m.f(event, "event");
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("buffering on stop event", new Object[0]);
        }
        k();
        xe.c.c().s(event);
    }
}
