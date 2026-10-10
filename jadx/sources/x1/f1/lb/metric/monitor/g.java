package x1.f1.lb.metric.monitor;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import x1.f1.lb.streaming.server.n;
import x1.f1.lb.streaming.server.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J!\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J!\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b!\u0010\u0018J!\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010\u0018J\u000f\u0010#\u001a\u00020\u0015H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0015H\u0016¢\u0006\u0004\b'\u0010$J\u000f\u0010(\u001a\u00020\u0015H\u0016¢\u0006\u0004\b(\u0010$J\u000f\u0010)\u001a\u00020\u0015H\u0016¢\u0006\u0004\b)\u0010$J\u000f\u0010*\u001a\u00020\u0015H\u0016¢\u0006\u0004\b*\u0010$J\u000f\u0010+\u001a\u00020\u0015H\u0016¢\u0006\u0004\b+\u0010$J\u000f\u0010,\u001a\u00020\u0015H\u0016¢\u0006\u0004\b,\u0010$J\u000f\u0010-\u001a\u00020\u0015H\u0016¢\u0006\u0004\b-\u0010$J_\u00108\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016¢\u0006\u0004\b8\u00109R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010;RT\u0010A\u001aB\u0012\f\u0012\n >*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n >*\u0004\u0018\u00010\u000f0\u000f >* \u0012\f\u0012\n >*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n >*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010?0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010@RT\u0010B\u001aB\u0012\f\u0012\n >*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n >*\u0004\u0018\u00010\u00120\u0012 >* \u0012\f\u0012\n >*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n >*\u0004\u0018\u00010\u00120\u0012\u0018\u00010?0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010@R\u0016\u0010D\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010CR\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010ER\u0016\u00100\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010CR\u0016\u0010F\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010CR\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010ER\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010CR\u0016\u00105\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010CR\u0016\u00106\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010CR\u0016\u00107\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010C¨\u0006G"}, d2 = {"Lx1/f1/lb/metric/monitor/g;", "Lx1/f1/lb/metric/monitor/b;", "Lx1/f1/lb/metric/monitor/d;", "Lx1/f1/lb/streaming/server/b$c;", "<init>", "()V", "", "session", "Ltf/d;", "w", "(J)Ltf/d;", "Lr8/z;", "y", "(J)V", "z", "Lx1/f1/lb/streaming/server/o;", "x", "(J)Lx1/f1/lb/streaming/server/o;", "Lx1/f1/lb/streaming/server/n;", "v", "(J)Lx1/f1/lb/streaming/server/n;", "", "player", "b", "(JI)Ljava/lang/Long;", "r", "e", "q", "", "i", "(JI)Z", "j", "(JI)I", "f", "a", "l", "()I", "k", "()J", "o", "p", "m", "h", "d", "c", "g", "blockSize", "resendCount", "resendRate", "timeMs", "avgLossRate", "avgBps", "rtt", "minRtt", "maxRtt", "avgRtt", "n", "(JJIJIJIIII)V", "Lq6/b;", "Lq6/b;", "logger", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Map;", "playListHandlers", "blockHandlers", "I", "bps", "J", "lossRate", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g implements x1.f1.lb.metric.monitor.b, d, x1.f1.lb.streaming.server.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f20917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<Long, o> playListHandlers;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Map<Long, n> blockHandlers;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int bps;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long resendCount;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int resendRate;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int lossRate;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static long avgBps;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static int rtt;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static int minRtt;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static int maxRtt;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static int avgRtt;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0012*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010!R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0018\u0010&\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010!R\u0018\u0010)\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010*R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001a¨\u0006."}, d2 = {"x1/f1/lb/metric/monitor/g$a", "Lx1/f1/lb/streaming/server/o;", "", "player", "", "time", "Lr8/z;", "e", "(IJ)V", "millis", "bytes", "", "", "playlist", "c", "(IJJILjava/util/List;)V", "f", "(I)Ljava/lang/String;", "blockName", "b", "(ILjava/lang/String;)I", "d", "(I)Ljava/lang/Long;", "j", "h", "a", "I", "firstM3u8RequestCnt", "", "Z", "isFirstM3u8", "lastRequestPlayer", "lastResponseToPlayer", "Ljava/lang/Long;", "lastRequestTime", "lastResponseTime", "g", "lastUpdateToPlayer", "lastUpdateTime", "i", "Ljava/lang/String;", "endBlock", "Ljava/util/List;", "list", "k", "lastIndex", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int firstM3u8RequestCnt;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isFirstM3u8 = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int lastRequestPlayer;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastResponseToPlayer;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Long lastRequestTime;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private Long lastResponseTime;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int lastUpdateToPlayer;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private Long lastUpdateTime;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private String endBlock;

        /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
        private List<String> list;

        /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int lastIndex;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f20941l;

        @Override // x1.f1.lb.streaming.server.o
        public synchronized void c(int player, long time, long millis, int bytes, List<String> playlist) {
            try {
                m.f(playlist, "playlist");
                this.lastResponseToPlayer = player;
                this.lastResponseTime = Long.valueOf(time);
                tf.d dVarW = g.f20917a.w(this.f20941l);
                if (this.isFirstM3u8 && dVarW != null) {
                    dVarW.H(this.firstM3u8RequestCnt);
                }
                if (playlist.isEmpty()) {
                    f.f20907a.m(playlist, millis);
                    g.logger.warn("play list is empty [{}] [{}ms]", Long.valueOf(this.f20941l), Long.valueOf(millis));
                } else {
                    this.lastUpdateToPlayer = player;
                    this.lastUpdateTime = Long.valueOf(time);
                    this.isFirstM3u8 = false;
                    f fVar = f.f20907a;
                    fVar.m(playlist, millis);
                    if (dVarW != null && dVarW.g() == 0) {
                        dVarW.I(time);
                    }
                    tf.c cVarH = fVar.h();
                    if ((cVarH != null ? cVarH.t() : null) != v6.c.LIVE) {
                        this.endBlock = (String) r.s0(playlist);
                        this.list = playlist;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // x1.f1.lb.streaming.server.o
        public synchronized void e(int player, long time) {
            try {
                this.lastRequestPlayer = player;
                this.lastRequestTime = Long.valueOf(time);
                tf.d dVarW = g.f20917a.w(this.f20941l);
                if (dVarW != null && dVarW.h() == 0) {
                    dVarW.J(time);
                    dVarW.d0(String.valueOf(this.f20941l));
                }
                if (this.isFirstM3u8) {
                    this.firstM3u8RequestCnt++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        a(long j10) {
            this.f20941l = j10;
        }

        @Override // x1.f1.lb.streaming.server.o
        public int b(int player, String blockName) {
            List<String> list;
            m.f(blockName, "blockName");
            int i10 = 0;
            if (player != this.lastRequestPlayer || (list = this.list) == null) {
                return 0;
            }
            int i11 = this.lastIndex;
            while (i11 < list.size() && !ac.g.a(list.get(i11), blockName)) {
                i11++;
            }
            if (i11 == list.size() && !m.a(list.get(i11 - 1), blockName)) {
                while (i10 < this.lastIndex && !ac.g.a(list.get(i10), blockName)) {
                    i10++;
                }
                i11 = i10;
            }
            this.lastIndex = i11;
            return (i11 * 1000) / list.size();
        }

        @Override // x1.f1.lb.streaming.server.p
        public Long d(int player) {
            if (player == this.lastRequestPlayer) {
                return this.lastRequestTime;
            }
            return null;
        }

        @Override // x1.f1.lb.streaming.server.o
        public String f(int player) {
            if (player == this.lastRequestPlayer) {
                return this.endBlock;
            }
            return null;
        }

        @Override // x1.f1.lb.streaming.server.p
        public Long h(int player) {
            if (player == this.lastUpdateToPlayer) {
                return this.lastUpdateTime;
            }
            return null;
        }

        @Override // x1.f1.lb.streaming.server.p
        public Long j(int player) {
            if (player == this.lastResponseToPlayer) {
                return this.lastResponseTime;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJK\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010!R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0018\u0010(\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010!R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010)R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001e¨\u0006,"}, d2 = {"x1/f1/lb/metric/monitor/g$b", "Lx1/f1/lb/streaming/server/n;", "", "player", "", "time", "", "blockName", "Lr8/z;", "i", "(IJLjava/lang/String;)V", "millis", "bytes", "", TypedValues.TransitionType.S_DURATION, "", "isFromCache", "a", "(IJJLjava/lang/String;ILjava/lang/Double;Ljava/lang/Boolean;)V", "g", "(I)Z", "k", "(I)I", "d", "(I)Ljava/lang/Long;", "j", "h", "Z", "isFirstBlock", "b", "I", "lastRequestPlayer", "c", "Ljava/lang/Long;", "lastRequestTime", "lastResponseToPlayer", "e", "lastResponseTime", "f", "lastUpdateToPlayer", "lastUpdateTime", "Ljava/lang/String;", "lastBlock", "downloadThousand", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements n {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int lastRequestPlayer;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private Long lastRequestTime;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastResponseToPlayer;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Long lastResponseTime;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int lastUpdateToPlayer;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private Long lastUpdateTime;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int downloadThousand;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f20951j;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isFirstBlock = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private String lastBlock = "";

        @Override // x1.f1.lb.streaming.server.n
        public synchronized void a(int player, long time, long millis, String blockName, int bytes, Double duration, Boolean isFromCache) {
            try {
                m.f(blockName, "blockName");
                this.lastResponseToPlayer = player;
                this.lastResponseTime = Long.valueOf(time);
                if (bytes > 0) {
                    this.isFirstBlock = false;
                    this.lastUpdateToPlayer = player;
                    this.lastUpdateTime = Long.valueOf(time);
                }
                if (TextUtils.isEmpty(blockName)) {
                    return;
                }
                if (!m.a(this.lastBlock, blockName)) {
                    o oVar = (o) g.playListHandlers.get(Long.valueOf(this.f20951j));
                    this.downloadThousand = oVar != null ? oVar.b(player, blockName) : 0;
                }
                this.lastBlock = blockName;
                tf.d dVarW = g.f20917a.w(this.f20951j);
                f fVar = f.f20907a;
                tf.b bVarG = fVar.g(blockName);
                if (bVarG != null) {
                    bVarG.w(time);
                }
                if (bytes > 0) {
                    if (dVarW != null) {
                        if (dVarW.n() == 0) {
                            dVarW.Q(time);
                            dVarW.K(bytes);
                            dVarW.L(duration != null ? duration.doubleValue() : 0.0d);
                            dVarW.M(isFromCache != null ? isFromCache.booleanValue() : false);
                        }
                        dVarW.a0(dVarW.w() + 1);
                        dVarW.S(time);
                    }
                    if (bVarG != null) {
                        bVarG.o(false);
                    }
                }
                if (bVarG != null) {
                    bVarG.r(bVarG.g() + 1);
                }
                tf.c cVarH = fVar.h();
                if ((cVarH != null ? cVarH.t() : null) != v6.c.LIVE) {
                    fVar.d(blockName);
                }
                if (duration != null) {
                    g.logger.a("play block[{}] [{}/{}/{}] [{}ms]", blockName, Integer.valueOf(bytes), duration, isFromCache, Long.valueOf(millis));
                } else if (x1.f1.lb.config.b.f20643a.t()) {
                    g.logger.debug("play block[{}] [{}] [{}ms]", blockName, Integer.valueOf(bytes), Long.valueOf(millis));
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // x1.f1.lb.streaming.server.n
        public synchronized void i(int player, long time, String blockName) {
            try {
                m.f(blockName, "blockName");
                this.lastRequestPlayer = player;
                this.lastRequestTime = Long.valueOf(time);
                tf.b bVarP = f.f20907a.p(blockName);
                tf.d dVarW = g.f20917a.w(this.f20951j);
                if (dVarW == null) {
                    return;
                }
                if (this.isFirstBlock) {
                    dVarW.O(dVarW.l() + 1);
                    if (dVarW.m() == 0) {
                        dVarW.P(time);
                        dVarW.N(bVarP.k());
                    }
                }
                bVarP.p(dVarW.s().name());
                bVarP.n(dVarW.r());
                dVarW.R(time);
            } catch (Throwable th) {
                throw th;
            }
        }

        b(long j10) {
            this.f20951j = j10;
        }

        @Override // x1.f1.lb.streaming.server.p
        public Long d(int player) {
            if (player == this.lastRequestPlayer) {
                return this.lastRequestTime;
            }
            return null;
        }

        @Override // x1.f1.lb.streaming.server.n
        public boolean g(int player) {
            o oVar;
            String strF;
            return player == this.lastUpdateToPlayer && (oVar = (o) g.playListHandlers.get(Long.valueOf(this.f20951j))) != null && (strF = oVar.f(player)) != null && ua.n.O(strF, this.lastBlock, false, 2, null) && this.lastBlock.length() > 0;
        }

        @Override // x1.f1.lb.streaming.server.p
        public Long h(int player) {
            if (player == this.lastUpdateToPlayer) {
                return this.lastUpdateTime;
            }
            return null;
        }

        @Override // x1.f1.lb.streaming.server.p
        public Long j(int player) {
            if (player == this.lastResponseToPlayer) {
                return this.lastResponseTime;
            }
            return null;
        }

        @Override // x1.f1.lb.streaming.server.n
        public int k(int player) {
            if (player == this.lastUpdateToPlayer) {
                return this.downloadThousand;
            }
            return 0;
        }
    }

    static {
        g gVar = new g();
        f20917a = gVar;
        q6.b bVarD = q6.c.d(gVar.getClass());
        m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        playListHandlers = Collections.synchronizedMap(new HashMap());
        blockHandlers = Collections.synchronizedMap(new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final tf.d w(long session) {
        tf.d dVarC = h.f20952a.c();
        if (dVarC != null && dVarC.y() == session) {
            return dVarC;
        }
        return null;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public Long a(long session, int player) {
        n nVar = blockHandlers.get(Long.valueOf(session));
        if (nVar != null) {
            return nVar.h(player);
        }
        return null;
    }

    @Override // x1.f1.lb.metric.monitor.b
    public Long b(long session, int player) {
        o oVar = playListHandlers.get(Long.valueOf(session));
        if (oVar != null) {
            return oVar.d(player);
        }
        return null;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public int c() {
        return minRtt;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public int d() {
        return avgRtt;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public Long e(long session, int player) {
        o oVar = playListHandlers.get(Long.valueOf(session));
        if (oVar != null) {
            return oVar.h(player);
        }
        return null;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public Long f(long session, int player) {
        n nVar = blockHandlers.get(Long.valueOf(session));
        if (nVar != null) {
            return nVar.j(player);
        }
        return null;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public int g() {
        return maxRtt;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public int h() {
        return rtt;
    }

    @Override // x1.f1.lb.metric.monitor.b
    public boolean i(long session, int player) {
        n nVar = blockHandlers.get(Long.valueOf(session));
        if (nVar != null) {
            return nVar.g(player);
        }
        return false;
    }

    @Override // x1.f1.lb.metric.monitor.b
    public int j(long session, int player) {
        n nVar = blockHandlers.get(Long.valueOf(session));
        if (nVar != null) {
            return nVar.k(player);
        }
        return 0;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public long k() {
        return avgBps;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public int l() {
        return bps;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public int m() {
        return (int) resendCount;
    }

    @Override // x1.f1.lb.streaming.server.b.c
    public void n(long blockSize, long resendCount2, int resendRate2, long timeMs, int avgLossRate, long avgBps2, int rtt2, int minRtt2, int maxRtt2, int avgRtt2) {
        bps = uf.c.f19486a.n((int) blockSize, (int) resendCount2, resendRate2, timeMs, avgLossRate, rtt2, minRtt2, maxRtt2, avgRtt2) * 1000;
        resendCount = resendCount2;
        lossRate = avgLossRate;
        resendRate = resendRate2;
        avgBps = avgBps2;
        rtt = rtt2;
        minRtt = minRtt2;
        maxRtt = maxRtt2;
        avgRtt = avgRtt2;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public int o() {
        return resendRate;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public int p() {
        return lossRate;
    }

    @Override // x1.f1.lb.metric.monitor.b
    public Long q(long session, int player) {
        n nVar = blockHandlers.get(Long.valueOf(session));
        if (nVar != null) {
            return nVar.d(player);
        }
        return null;
    }

    @Override // x1.f1.lb.metric.monitor.d
    public Long r(long session, int player) {
        o oVar = playListHandlers.get(Long.valueOf(session));
        if (oVar != null) {
            return oVar.j(player);
        }
        return null;
    }

    public final n v(long session) {
        return blockHandlers.get(Long.valueOf(session));
    }

    public final o x(long session) {
        return playListHandlers.get(Long.valueOf(session));
    }

    public final void y(long session) {
        Map<Long, o> playListHandlers2 = playListHandlers;
        m.e(playListHandlers2, "playListHandlers");
        playListHandlers2.put(Long.valueOf(session), new a(session));
        Map<Long, n> blockHandlers2 = blockHandlers;
        m.e(blockHandlers2, "blockHandlers");
        blockHandlers2.put(Long.valueOf(session), new b(session));
    }

    public final void z(long session) {
        playListHandlers.remove(Long.valueOf(session));
        blockHandlers.remove(Long.valueOf(session));
    }

    private g() {
    }
}
