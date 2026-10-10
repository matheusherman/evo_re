package x1.f1.lb.widget.videoview;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b$\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001bR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b%\u0010\u001bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b)\u0010/R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b,\u00100\u001a\u0004\b1\u00102R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b4\u0010\u001bR\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b\u001e\u00106R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u001a\u00107\u001a\u0004\b\u0018\u00108R\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b3\u0010!\"\u0004\b9\u0010#R$\u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010;\u001a\u0004\b-\u0010<\"\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lx1/f1/lb/widget/videoview/f;", "", "", "uid", "", "loginTime", "videoName", "Lv6/c;", "playType", "playPositionPersistenceKey", "playerArgs", "mediaId", "routeId", "", "mediaMode", "", "isFree", "subtitleMediaId", "Ljava/util/concurrent/atomic/AtomicBoolean;", "forceToStart", "Lx1/f1/lb/widget/videoview/c0$d;", "flowCreator", "<init>", "(Ljava/lang/String;JLjava/lang/String;Lv6/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;Lx1/f1/lb/widget/videoview/c0$d;)V", "a", "Ljava/lang/String;", "m", "()Ljava/lang/String;", "s", "(Ljava/lang/String;)V", "b", "J", "c", "()J", "p", "(J)V", "n", "d", "Lv6/c;", "g", "()Lv6/c;", "e", "f", "h", "j", "i", "I", "()I", "Z", "o", "()Z", "k", "l", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "Lx1/f1/lb/widget/videoview/c0$d;", "()Lx1/f1/lb/widget/videoview/c0$d;", "r", "session", "Ljava/lang/Long;", "()Ljava/lang/Long;", "q", "(Ljava/lang/Long;)V", "preSetSeekPosition", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String uid;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long loginTime;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String videoName;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final v6.c playType;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String playPositionPersistenceKey;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String playerArgs;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String mediaId;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String routeId;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mediaMode;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean isFree;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final String subtitleMediaId;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean forceToStart;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final c0.d flowCreator;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long session;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Long preSetSeekPosition;

    public f(String uid, long j10, String videoName, v6.c playType, String playPositionPersistenceKey, String str, String mediaId, String routeId, int i10, boolean z10, String subtitleMediaId, AtomicBoolean forceToStart, c0.d flowCreator) {
        kotlin.jvm.internal.m.f(uid, "uid");
        kotlin.jvm.internal.m.f(videoName, "videoName");
        kotlin.jvm.internal.m.f(playType, "playType");
        kotlin.jvm.internal.m.f(playPositionPersistenceKey, "playPositionPersistenceKey");
        kotlin.jvm.internal.m.f(mediaId, "mediaId");
        kotlin.jvm.internal.m.f(routeId, "routeId");
        kotlin.jvm.internal.m.f(subtitleMediaId, "subtitleMediaId");
        kotlin.jvm.internal.m.f(forceToStart, "forceToStart");
        kotlin.jvm.internal.m.f(flowCreator, "flowCreator");
        this.uid = uid;
        this.loginTime = j10;
        this.videoName = videoName;
        this.playType = playType;
        this.playPositionPersistenceKey = playPositionPersistenceKey;
        this.playerArgs = str;
        this.mediaId = mediaId;
        this.routeId = routeId;
        this.mediaMode = i10;
        this.isFree = z10;
        this.subtitleMediaId = subtitleMediaId;
        this.forceToStart = forceToStart;
        this.flowCreator = flowCreator;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final c0.d getFlowCreator() {
        return this.flowCreator;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final AtomicBoolean getForceToStart() {
        return this.forceToStart;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getLoginTime() {
        return this.loginTime;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getMediaMode() {
        return this.mediaMode;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getPlayPositionPersistenceKey() {
        return this.playPositionPersistenceKey;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final v6.c getPlayType() {
        return this.playType;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getPlayerArgs() {
        return this.playerArgs;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final Long getPreSetSeekPosition() {
        return this.preSetSeekPosition;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final long getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getSubtitleMediaId() {
        return this.subtitleMediaId;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getVideoName() {
        return this.videoName;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final boolean getIsFree() {
        return this.isFree;
    }

    public final void p(long j10) {
        this.loginTime = j10;
    }

    public final void q(Long l10) {
        this.preSetSeekPosition = l10;
    }

    public final void r(long j10) {
        this.session = j10;
    }

    public final void s(String str) {
        kotlin.jvm.internal.m.f(str, "<set-?>");
        this.uid = str;
    }
}
