package x1.f1.lb.widget.videoview;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \"2\u00020\u0001:\u0002&\u001dB1\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u000eJ\r\u0010'\u001a\u00020\u0006¢\u0006\u0004\b'\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010(R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010)R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010*R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010+R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010+R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010*R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010-R\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010*¨\u0006."}, d2 = {"Lx1/f1/lb/widget/videoview/j;", "", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "mediaPlayer", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "", "decodeMode", "", "hardwareDecodeFlag", "session", "<init>", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;Ljava/lang/String;IJJ)V", "f", "()I", NotificationCompat.CATEGORY_STATUS, "Lr8/z;", "j", "(I)V", "Lx1/f1/lb/widget/videoview/g0;", "videoInfo", "k", "(Lx1/f1/lb/widget/videoview/g0;)V", "h", "()Lx1/f1/lb/widget/videoview/g0;", "g", "()Ljava/lang/String;", "Lx1/f1/lb/widget/videoview/j$a;", "callback", "a", "(Lx1/f1/lb/widget/videoview/j$a;)V", "c", "()Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "i", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "e", "()J", "b", "d", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "Ljava/lang/String;", "I", "J", "playerId", "Lx1/f1/lb/widget/videoview/g0;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer mediaPlayer;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String url;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int decodeMode;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long hardwareDecodeFlag;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long session;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int playerId;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private g0 videoInfo;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lx1/f1/lb/widget/videoview/j$a;", "", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(IMediaPlayer player);
    }

    public j(IMediaPlayer iMediaPlayer, String url, int i10, long j10, long j11) {
        kotlin.jvm.internal.m.f(url, "url");
        this.mediaPlayer = iMediaPlayer;
        this.url = url;
        this.decodeMode = i10;
        this.hardwareDecodeFlag = j10;
        this.session = j11;
        this.playerId = iMediaPlayer != null ? iMediaPlayer.hashCode() : 0;
    }

    public final void a(a callback) {
        kotlin.jvm.internal.m.f(callback, "callback");
        IMediaPlayer iMediaPlayer = this.mediaPlayer;
        if (iMediaPlayer == null) {
            return;
        }
        try {
            callback.a(iMediaPlayer);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getDecodeMode() {
        return this.decodeMode;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final IMediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getPlayerId() {
        return this.playerId;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final long getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final g0 getVideoInfo() {
        return this.videoInfo;
    }

    public final void i(IMediaPlayer player) {
        this.mediaPlayer = player;
    }

    public final void j(int status) {
        this.status = status;
    }

    public final void k(g0 videoInfo) {
        kotlin.jvm.internal.m.f(videoInfo, "videoInfo");
        this.videoInfo = videoInfo;
    }
}
