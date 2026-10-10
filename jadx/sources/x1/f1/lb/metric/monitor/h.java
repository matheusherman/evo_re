package x1.f1.lb.metric.monitor;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import r8.p;
import r8.u;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010\u000bJ\u000f\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010'R\u0016\u0010*\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010)R\u0016\u0010+\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010.¨\u00060"}, d2 = {"Lx1/f1/lb/metric/monitor/h;", "", "<init>", "()V", "Ltf/d;", "zappingStat", "Lvf/f;", "f", "(Ltf/d;)Lvf/f;", "Ltf/e;", "b", "()Ltf/e;", "Lv6/c;", "playType", "", "channelName", "streamId", "route", "", "session", "", "mediaPlayMode", "a", "(Lv6/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)Ltf/d;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "mediaPlayer", "Lr8/z;", "g", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "c", "()Ltf/d;", "e", "Lvf/c;", "d", "()Lvf/c;", "h", "(Ltf/d;)Ljava/lang/String;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "I", "PLAY_EVENT_SEQ", "RETRY", "Ltf/e;", "startupStat", "Ltf/d;", "playerZappingStat", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f20952a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(h.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int PLAY_EVENT_SEQ;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int RETRY;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static tf.e startupStat;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static tf.d playerZappingStat;

    public final String h(tf.d zappingStat) {
        String str;
        String str2;
        m.f(zappingStat, "zappingStat");
        vf.f fVarF = f(zappingStat);
        u uVar = new u(Long.valueOf(zappingStat.v()), Long.valueOf(fVarF.x()), "zapping time");
        u uVar2 = new u(Long.valueOf(zappingStat.getStart()), 0L, "start");
        u uVar3 = new u(Long.valueOf(zappingStat.A()), Long.valueOf(fVarF.c()), "engine stop play time");
        u uVar4 = new u(Long.valueOf(zappingStat.u()), Long.valueOf(fVarF.b()), "engine start play time");
        u uVar5 = new u(Long.valueOf(zappingStat.B()), Long.valueOf(fVarF.m()), "stop player time");
        u uVar6 = new u(Long.valueOf(zappingStat.t()), Long.valueOf(fVarF.n()), "player url injection time");
        u uVar7 = new u(Long.valueOf(zappingStat.h()), Long.valueOf(fVarF.d()), "first index request time, request cnt [ " + zappingStat.f() + " ]");
        u uVar8 = new u(Long.valueOf(zappingStat.g()), Long.valueOf(fVarF.e()), "first index response time");
        u uVar9 = new u(Long.valueOf(zappingStat.m()), Long.valueOf(fVarF.g()), "first ts request time, request cnt [ " + zappingStat.l() + " ], request at index [ " + zappingStat.k() + " ]");
        u uVar10 = new u(Long.valueOf(zappingStat.n()), Long.valueOf(fVarF.h()), "first ts response time");
        u uVar11 = new u(Long.valueOf(zappingStat.o()), Long.valueOf(fVarF.i()), "last ts response time, request ts qty [ " + zappingStat.w() + " ]  during player preparation");
        u uVar12 = new u(Long.valueOf(zappingStat.v()), Long.valueOf(fVarF.o()), "render time since 1 TS ready");
        u uVar13 = new u(Long.valueOf(zappingStat.v()), Long.valueOf(fVarF.p()), "render time since " + zappingStat.w() + " TS ready");
        int i10 = 13;
        int i11 = 1;
        int i12 = 2;
        u[] uVarArr = {uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7, uVar8, uVar9, uVar10, uVar11, uVar12, uVar13};
        StringBuilder sb2 = new StringBuilder();
        sb2.append("session[ ");
        sb2.append(zappingStat.z());
        if (fVarF.k() > 0) {
            sb2.append(" ] play_seq[ ");
            sb2.append(fVarF.k());
        }
        if (fVarF.r() > 0) {
            sb2.append(" ] retry[ ");
            sb2.append(fVarF.r());
        }
        String strC = zappingStat.c();
        if (strC != null && strC.length() != 0) {
            sb2.append(" ] err[ ");
            sb2.append(zappingStat.c());
        }
        sb2.append(" ]\n");
        sb2.append("--------------------------------------------------------------------------------------------------------------------\n");
        int i13 = 0;
        while (i13 < i10) {
            u uVar14 = uVarArr[i13];
            long jLongValue = ((Number) uVar14.a()).longValue();
            long jLongValue2 = ((Number) uVar14.b()).longValue();
            String str3 = (String) uVar14.c();
            if (i13 == 0) {
                int iR = zappingStat.r();
                if (iR == 0) {
                    str = "normal";
                } else if (iR == i11) {
                    str = "adult";
                } else if (iR != i12) {
                    str = iR != 3 ? "unknown play mode" : "adult, free";
                } else {
                    str = "normal, free";
                }
                x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
                if (fVar.O0()) {
                    x1.f1.lb.media.e eVar = x1.f1.lb.media.e.f20835a;
                    String streamId = zappingStat.getStreamId();
                    m.e(streamId, "getStreamId(...)");
                    str2 = "trial(" + eVar.f(streamId) + " / " + fVar.n0() + ")}";
                } else {
                    str2 = "plan";
                }
                sb2.append(str3);
                sb2.append(" [ ");
                sb2.append(jLongValue2);
                sb2.append(" ms ]");
                sb2.append("[ ");
                if (x1.f1.lb.config.b.f20643a.t()) {
                    sb2.append(zappingStat.getRoute());
                    sb2.append(", ");
                }
                sb2.append(zappingStat.getStreamId());
                sb2.append(", ");
                sb2.append(zappingStat.s().toString());
                sb2.append(", ");
                sb2.append(str);
                sb2.append(" ] [ ");
                sb2.append(str2);
                sb2.append(" ]\n");
            } else {
                if (jLongValue != 0) {
                    g0 g0Var = g0.f12340a;
                    String str4 = String.format(Locale.ENGLISH, "% 6d", Arrays.copyOf(new Object[]{Long.valueOf(jLongValue2)}, 1));
                    m.e(str4, "format(...)");
                    sb2.append("complete@[ ");
                    sb2.append(jLongValue);
                    sb2.append(" ] [ ");
                    sb2.append(str4);
                    sb2.append(" ms ] --> ");
                    sb2.append(str3);
                    sb2.append("\n");
                }
                i13++;
                i10 = 13;
                i11 = 1;
                i12 = 2;
            }
            i13++;
            i10 = 13;
            i11 = 1;
            i12 = 2;
        }
        String string = sb2.toString();
        m.e(string, "toString(...)");
        return string;
    }

    private final vf.f f(tf.d zappingStat) {
        p[] pVarArr = {new p(Long.valueOf(zappingStat.v()), Long.valueOf(zappingStat.getStart())), new p(Long.valueOf(zappingStat.getStart()), 0L), new p(Long.valueOf(zappingStat.A()), Long.valueOf(zappingStat.getStart())), new p(Long.valueOf(zappingStat.u()), Long.valueOf(zappingStat.A())), new p(Long.valueOf(zappingStat.B()), Long.valueOf(zappingStat.getStart())), new p(Long.valueOf(zappingStat.t()), Long.valueOf(Math.max(zappingStat.B(), zappingStat.u()))), new p(Long.valueOf(zappingStat.h()), Long.valueOf(zappingStat.t())), new p(Long.valueOf(zappingStat.g()), Long.valueOf(zappingStat.h())), new p(Long.valueOf(zappingStat.m()), Long.valueOf(zappingStat.g())), new p(Long.valueOf(zappingStat.n()), Long.valueOf(zappingStat.m())), new p(Long.valueOf(zappingStat.o()), Long.valueOf(zappingStat.p())), new p(Long.valueOf(zappingStat.v()), Long.valueOf(zappingStat.n())), new p(Long.valueOf(zappingStat.v()), Long.valueOf(zappingStat.p()))};
        long[] jArr = new long[13];
        for (int i10 = 0; i10 < 13; i10++) {
            p pVar = pVarArr[i10];
            if (((Number) pVar.c()).longValue() <= 0 || ((Number) pVar.d()).longValue() <= 0) {
                if (((Number) pVar.c()).longValue() > 0) {
                    for (int i11 = i10 - 1; -1 < i11; i11--) {
                        if (((Number) pVarArr[i11].d()).longValue() > 0) {
                            jArr[i10] = ((Number) pVar.c()).longValue() - ((Number) pVarArr[i11].d()).longValue();
                            break;
                        }
                    }
                }
            } else {
                jArr[i10] = ((Number) pVar.c()).longValue() - ((Number) pVar.d()).longValue();
            }
        }
        long j10 = jArr[0];
        for (int i12 = 1; i12 < 13; i12++) {
            if (jArr[i12] < 0) {
                jArr[i12] = 0;
            }
            long j11 = jArr[i12];
            if (j10 < j11) {
                j10 = j11;
            }
        }
        if (j10 > jArr[0]) {
            jArr[0] = j10;
        }
        long jQ = zappingStat.q();
        String channel = zappingStat.getChannel();
        String route = zappingStat.getRoute();
        String streamId = zappingStat.getStreamId();
        String strName = zappingStat.s().name();
        int seq = zappingStat.getSeq();
        long jY = zappingStat.y();
        int iR = zappingStat.r();
        int iX = zappingStat.x();
        long j12 = jArr[0];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = jArr[4];
        long j16 = jArr[5];
        long j17 = jArr[6];
        long j18 = jArr[7];
        long j19 = jArr[8];
        long j20 = jArr[9];
        int i13 = zappingStat.i();
        double dJ = zappingStat.j();
        boolean zD = zappingStat.D();
        int iK = zappingStat.k();
        long j21 = jArr[10];
        int iW = zappingStat.w();
        long j22 = jArr[11];
        long j23 = jArr[12];
        Map<String, Integer> mapC = zappingStat.C();
        tf.c cVar = zappingStat.monitorStat;
        return new vf.f(jQ, channel, route, streamId, strName, seq, jY, iR, iX, j12, j13, j14, j15, j16, j17, j18, j19, j20, i13, dJ, zD, iK, j21, iW, j22, j23, mapC, cVar != null ? cVar.I() : null);
    }

    public final tf.d a(v6.c playType, String channelName, String streamId, String route, long session, int mediaPlayMode) {
        AtomicBoolean atomicBoolean;
        m.f(playType, "playType");
        m.f(channelName, "channelName");
        m.f(streamId, "streamId");
        m.f(route, "route");
        tf.d dVar = playerZappingStat;
        if (dVar == null || dVar.v() > 0) {
            f.f20907a.n();
        } else {
            tf.c cVar = dVar.monitorStat;
            if (cVar != null && (atomicBoolean = cVar.f19235a) != null && atomicBoolean.compareAndSet(false, true)) {
                uf.c cVar2 = uf.c.f19486a;
                vf.f fVarF = f(dVar);
                int iE = dVar.e();
                int iD = dVar.d();
                String strC = dVar.c();
                m.e(strC, "getError(...)");
                cVar2.k(fVarF, iE, iD, strC);
            }
        }
        tf.d dVar2 = new tf.d();
        dVar2.V(playType);
        dVar2.U(mediaPlayMode);
        dVar2.T(x1.f1.lb.user.f.f21202a.q0());
        dVar2.setChannel(channelName);
        dVar2.setRoute(route);
        dVar2.setStreamId(streamId);
        int i10 = PLAY_EVENT_SEQ;
        PLAY_EVENT_SEQ = i10 + 1;
        dVar2.setSeq(i10);
        int i11 = RETRY;
        RETRY = i11 + 1;
        dVar2.b0(i11);
        dVar2.c0(session);
        dVar2.setChannel(channelName);
        playerZappingStat = dVar2;
        f fVar = f.f20907a;
        fVar.c(dVar2);
        fVar.r(dVar2);
        return dVar2;
    }

    public final tf.e b() {
        tf.e eVar = new tf.e();
        startupStat = eVar;
        return eVar;
    }

    public final tf.d c() {
        return playerZappingStat;
    }

    public final vf.c d() {
        tf.e eVar = startupStat;
        if (eVar == null) {
            return null;
        }
        return new vf.c(eVar.k(), eVar.j() - eVar.k(), eVar.f(), eVar.g() - eVar.j(), eVar.e(), eVar.a() - eVar.c(), eVar.d());
    }

    public final tf.e e() {
        return startupStat;
    }

    public final void g(IMediaPlayer mediaPlayer) {
        tf.d dVar = playerZappingStat;
        if (dVar == null) {
            return;
        }
        dVar.Z(d1.c());
        dVar.Y(mediaPlayer != null ? mediaPlayer.getClass().getSimpleName() : null);
        f.f20907a.r(dVar);
        uf.c.f19486a.m(f(dVar));
        RETRY = 0;
        playerZappingStat = null;
    }

    private h() {
    }
}
