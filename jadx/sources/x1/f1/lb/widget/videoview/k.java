package x1.f1.lb.widget.videoview;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJI\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b'\u0010(J?\u0010)\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040+¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0010¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0010¢\u0006\u0004\b0\u0010/J\u0015\u00101\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0006¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b5\u00106R\u001c\u0010:\u001a\n 8*\u0004\u0018\u000107078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u00109R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010<R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010<R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010@R2\u0010E\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010F¨\u0006H"}, d2 = {"Lx1/f1/lb/widget/videoview/k;", "", "<init>", "()V", "", "playerType", "", "playerId", "Lx1/f1/lb/widget/videoview/j;", "j", "(Ljava/lang/String;Ljava/lang/Integer;)Lx1/f1/lb/widget/videoview/j;", "playerName", "d", "(Ljava/lang/String;)I", "playUri", "decodeMode", "", "hardwareDecodeFlag", "playerArgs", "Lv6/c;", "playType", "session", "h", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Lv6/c;J)Lx1/f1/lb/widget/videoview/j;", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "ijkMediaPlayer", "Lr8/z;", "m", "(Lv6/c;Ltv/danmaku/ijk/media/player/IjkMediaPlayer;J)V", "o", "(Ltv/danmaku/ijk/media/player/IjkMediaPlayer;JLjava/lang/String;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "c", "(I)Ltv/danmaku/ijk/media/player/IMediaPlayer;", "playerInfo", "", "isRelease", "q", "(Lx1/f1/lb/widget/videoview/j;Z)V", "g", "()Lx1/f1/lb/widget/videoview/j;", "b", "(Ljava/lang/String;IJLjava/lang/String;Lv6/c;J)Lx1/f1/lb/widget/videoview/j;", "", "i", "()Ljava/util/Map;", "l", "()J", "e", "n", "(I)V", "f", "()I", "p", "(J)V", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "playInfoMap", "decodeModeMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInCreating", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "playerArgsMap", "Lv6/c;", "lastPlayType", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f21604a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(k.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, j> playInfoMap = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Integer> decodeModeMap = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isInCreating = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static HashMap<String, String> playerArgsMap = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static v6.c lastPlayType;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/k$b", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f21611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f21613c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerManager$stopPlayer$1$call$1", f = "PlayerManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ boolean $isRelease;
            final /* synthetic */ IMediaPlayer $player;
            final /* synthetic */ j $playerInfo;
            final /* synthetic */ int $status;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(j jVar, int i10, IMediaPlayer iMediaPlayer, boolean z10, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$playerInfo = jVar;
                this.$status = i10;
                this.$player = iMediaPlayer;
                this.$isRelease = z10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$playerInfo, this.$status, this.$player, this.$isRelease, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /* JADX WARN: Code duplicated, block: B:28:0x0048 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:29:0x004a  */
            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    k kVar = k.f21604a;
                    j jVar = this.$playerInfo;
                    int i10 = this.$status;
                    IMediaPlayer iMediaPlayer = this.$player;
                    boolean z10 = this.$isRelease;
                    synchronized (kVar) {
                        if (jVar.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String() == 6) {
                            return r8.z.f17874a;
                        }
                        if (i10 == 1 || i10 == 2 || i10 == 3) {
                            jVar.j(5);
                            try {
                                iMediaPlayer.stop();
                                if (!z10) {
                                    iMediaPlayer.reset();
                                    if (z10) {
                                        try {
                                            jVar.i(null);
                                            iMediaPlayer.release();
                                            jVar.j(6);
                                        } catch (Throwable th) {
                                            k.logger.error("release player failure", th);
                                        }
                                    }
                                    return r8.z.f17874a;
                                }
                                if (z10) {
                                    jVar.i(null);
                                    iMediaPlayer.release();
                                    jVar.j(6);
                                }
                                return r8.z.f17874a;
                            } catch (Throwable th2) {
                                k.logger.error("stop player failure", th2);
                            }
                        } else {
                            if (z10) {
                                jVar.i(null);
                                iMediaPlayer.release();
                                jVar.j(6);
                            }
                            return r8.z.f17874a;
                        }
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(j jVar, int i10, boolean z10) {
            this.f21611a = jVar;
            this.f21612b = i10;
            this.f21613c = z10;
        }

        @Override // x1.f1.lb.widget.videoview.j.a
        public void a(IMediaPlayer player) {
            kotlin.jvm.internal.m.f(player, "player");
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new a(this.f21611a, this.f21612b, player, this.f21613c, null), 3, null);
        }
    }

    private final IMediaPlayer c(int decodeMode) {
        IMediaPlayer ijkMediaPlayer;
        synchronized (this) {
            try {
                if (decodeMode == 3) {
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        logger.debug("start player[{}], decodeMode[{}]", AndroidMediaPlayer.class.getName(), Integer.valueOf(decodeMode));
                    }
                    ijkMediaPlayer = new AndroidMediaPlayer();
                } else {
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        logger.debug("start player[{}], decodeMode[{}]", IjkMediaPlayer.class.getName(), Integer.valueOf(decodeMode));
                    }
                    ijkMediaPlayer = new IjkMediaPlayer();
                    ijkMediaPlayer.reset();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ijkMediaPlayer;
    }

    private final j h(String playerName, String playUri, int decodeMode, long hardwareDecodeFlag, String playerArgs, v6.c playType, long session) {
        while (true) {
            if (isInCreating.compareAndSet(false, true)) {
                try {
                    break;
                } finally {
                    isInCreating.set(false);
                }
            }
            try {
                Thread.sleep(10L);
            } catch (Exception unused) {
            }
        }
        ConcurrentHashMap<String, j> concurrentHashMap = playInfoMap;
        j jVar = concurrentHashMap.get(playerName);
        concurrentHashMap.remove(playerName);
        if (jVar != null) {
            q(jVar, true);
            x1.f1.lb.streaming.client.a.f21004a.q(jVar.getSession(), jVar.getPlayerId());
        }
        IMediaPlayer iMediaPlayerC = c(decodeMode);
        if (iMediaPlayerC instanceof IjkMediaPlayer) {
            if (playType == v6.c.LIVE && kotlin.jvm.internal.m.a(x1.f1.lb.config.b.f20643a.l(), "TS")) {
                o((IjkMediaPlayer) iMediaPlayerC, hardwareDecodeFlag, playerArgs);
            } else {
                m(playType, (IjkMediaPlayer) iMediaPlayerC, hardwareDecodeFlag);
            }
        }
        j jVar2 = new j(iMediaPlayerC, playUri, decodeMode, hardwareDecodeFlag, session);
        concurrentHashMap.put(playerName, jVar2);
        x1.f1.lb.streaming.client.a.f21004a.g(session, jVar2.getPlayerId());
        return jVar2;
    }

    private final void o(IjkMediaPlayer ijkMediaPlayer, long hardwareDecodeFlag, String playerArgs) {
        HashMap<String, String> map;
        if (playerArgs == null || playerArgs.length() == 0) {
            map = playerArgsMap;
        } else {
            try {
                map = (HashMap) new com.google.gson.e().o(playerArgs, new a().d());
                playerArgsMap = map;
            } catch (Throwable th) {
                logger.error("setPlayerOption failure", th);
                map = playerArgsMap;
            }
        }
        ijkMediaPlayer.setOption(4, "mediacodec", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "mediacodec-hevc", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "mediacodec-avc", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "mediacodec-all-videos", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
        ijkMediaPlayer.setOption(4, "av-sync-type", 0L);
        ijkMediaPlayer.setOption(4, "start-on-prepared", 0L);
        ijkMediaPlayer.setOption(4, "framedrop", hardwareDecodeFlag == 0 ? 5L : 1L);
        ijkMediaPlayer.setOption(1, "flush_packets", 1L);
        ijkMediaPlayer.setOption(4, "packet-buffering", 1L);
        ijkMediaPlayer.setOption(2, "skip_loop_filter", 48L);
        ijkMediaPlayer.setOption(1, "dns_cache_clear", 1L);
        ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
        ijkMediaPlayer.setOption(1, "reconnect_streamed", 1L);
        ijkMediaPlayer.setOption(1, "reconnect", 1L);
        ijkMediaPlayer.setOption(1, "reconnect_at_eof", 1L);
        ijkMediaPlayer.setOption(1, "iformat", "mpegts");
        ijkMediaPlayer.setOption(1, "reconnect", 0L);
        try {
            String str = map.get("enlargeprobesize");
            long j10 = str != null ? Long.parseLong(str) : 0L;
            if (j10 > 0) {
                ijkMediaPlayer.setOption(1, "probesize", j10);
                ijkMediaPlayer.setOption(1, "analyzeduration", 5000000L);
            } else {
                String str2 = map.get("probesize");
                ijkMediaPlayer.setOption(1, "probesize", str2 != null ? Long.parseLong(str2) : 350000L);
            }
        } catch (Throwable unused) {
        }
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("zapping_time_opt set_params_to_player player[{}]", Integer.valueOf(ijkMediaPlayer.hashCode()));
        }
        ijkMediaPlayer.setOption(4, "opensles", 0L);
        ijkMediaPlayer.setOption(4, "live-quick-start ", 1L);
    }

    public final j g() {
        return k(this, "main_player", null, 2, null);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"x1/f1/lb/widget/videoview/k$a", "Lf3/a;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends f3.a<HashMap<String, String>> {
        a() {
        }
    }

    private final int d(String playerName) {
        Integer num = decodeModeMap.get(playerName);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    private final j j(String playerType, Integer playerId) {
        j jVar = playInfoMap.get(playerType);
        if (jVar == null) {
            return null;
        }
        if (playerId != null) {
            if (playerId.intValue() != jVar.getPlayerId()) {
                return null;
            }
        }
        return jVar;
    }

    static /* synthetic */ j k(k kVar, String str, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        return kVar.j(str, num);
    }

    private final void m(v6.c playType, IjkMediaPlayer ijkMediaPlayer, long hardwareDecodeFlag) {
        ijkMediaPlayer.setOption(4, "mediacodec", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "mediacodec-hevc", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", hardwareDecodeFlag);
        ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
        ijkMediaPlayer.setOption(4, "start-on-prepared", 0L);
        ijkMediaPlayer.setOption(4, "framedrop", hardwareDecodeFlag == 0 ? 5L : 1L);
        ijkMediaPlayer.setOption(1, "flush_packets", 1L);
        ijkMediaPlayer.setOption(4, "packet-buffering", 1L);
        ijkMediaPlayer.setOption(2, "skip_loop_filter", 0L);
        ijkMediaPlayer.setOption(1, "dns_cache_clear", 1L);
    }

    public final j b(String playUri, int decodeMode, long hardwareDecodeFlag, String playerArgs, v6.c playType, long session) {
        kotlin.jvm.internal.m.f(playUri, "playUri");
        kotlin.jvm.internal.m.f(playType, "playType");
        lastPlayType = playType;
        return h("main_player", playUri, decodeMode, hardwareDecodeFlag, playerArgs, playType, session);
    }

    public final int f() {
        return d("main_player");
    }

    public final Map<String, String> i() {
        return playerArgsMap;
    }

    public final void p(long session) {
        Enumeration<String> enumerationKeys = playInfoMap.keys();
        kotlin.jvm.internal.m.c(enumerationKeys);
        Iterator itZ = kotlin.collections.r.z(enumerationKeys);
        while (itZ.hasNext()) {
            String str = (String) itZ.next();
            ConcurrentHashMap<String, j> concurrentHashMap = playInfoMap;
            j jVar = concurrentHashMap.get(str);
            if (jVar != null && jVar.getSession() == session) {
                q(jVar, true);
                concurrentHashMap.remove(str);
            }
        }
    }

    private k() {
    }

    private final void q(j playerInfo, boolean isRelease) {
        try {
            int i10 = playerInfo.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String();
            if (i10 == 6) {
                return;
            }
            tf.d dVarC = x1.f1.lb.metric.monitor.h.f20952a.c();
            if (dVarC != null) {
                dVarC.f0(d1.c());
            } else {
                x1.f1.lb.metric.monitor.f.f20907a.n();
            }
            playerInfo.a(new b(playerInfo, i10, isRelease));
        } catch (Exception e10) {
            logger.error("stop player failure", e10);
        }
    }

    public final long e() {
        try {
            String str = playerArgsMap.get("enlargeprobesize");
            if (str == null) {
                return 5600000L;
            }
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 5600000L;
        }
    }

    public final long l() {
        try {
            String str = playerArgsMap.get("probesize");
            if (str == null) {
                return 350000L;
            }
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 350000L;
        }
    }

    public final void n(int decodeMode) {
        decodeModeMap.put("main_player", Integer.valueOf(decodeMode));
    }
}
