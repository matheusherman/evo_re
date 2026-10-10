package t.v.c.widget.videoview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import c9.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import t.v.c.R$drawable;
import t.v.c.R$id;
import t.v.c.R$layout;
import t.v.c.R$styleable;
import t.v.c.s.widget.SimpleSubtitleView;
import t.v.c.widget.FrameLayout;
import t.v.c.widget.ImageView;
import t.v.c.widget.LinearLayout;
import t.v.c.widget.MarqueeTextView;
import t.v.c.widget.TextView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import x1.f1.lb.util.a0;
import x1.f1.lb.widget.videoview.c0;
import x1.f1.lb.widget.videoview.z0;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ#\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010 J/\u0010%\u001a\u00020\r2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\r2\b\b\u0001\u0010'\u001a\u00020\n¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b,\u0010+J\u0015\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020\n¢\u0006\u0004\b.\u0010)J\u0015\u00100\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010/¢\u0006\u0004\b0\u00101J\u0015\u00103\u001a\u00020\r2\u0006\u00102\u001a\u00020\n¢\u0006\u0004\b3\u0010)J\r\u00104\u001a\u00020\n¢\u0006\u0004\b4\u0010\u0019J\r\u00105\u001a\u00020\n¢\u0006\u0004\b5\u0010\u0019J\u0015\u00106\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u001b\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u00109\u001a\u000208¢\u0006\u0004\b<\u0010=J#\u0010@\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u00109\u001a\u0002082\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020;¢\u0006\u0004\bB\u0010CJ\r\u0010E\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020D¢\u0006\u0004\bG\u0010FJ#\u0010J\u001a\u00020D2\b\b\u0002\u0010H\u001a\u00020\u000f2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010;¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020D¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020\r2\b\b\u0002\u0010N\u001a\u00020D¢\u0006\u0004\bO\u0010MJ\r\u0010P\u001a\u00020D¢\u0006\u0004\bP\u0010FJ\r\u0010Q\u001a\u00020D¢\u0006\u0004\bQ\u0010FJ\r\u0010!\u001a\u00020D¢\u0006\u0004\b!\u0010FJ\r\u0010R\u001a\u00020D¢\u0006\u0004\bR\u0010FJ\r\u0010S\u001a\u00020;¢\u0006\u0004\bS\u0010CJ\r\u0010T\u001a\u00020;¢\u0006\u0004\bT\u0010CJ\r\u0010U\u001a\u00020\n¢\u0006\u0004\bU\u0010\u0019J\r\u0010V\u001a\u00020\u000f¢\u0006\u0004\bV\u0010WJ\r\u0010X\u001a\u00020\u000f¢\u0006\u0004\bX\u0010WJ\u000f\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\bZ\u0010[J\u0015\u0010\\\u001a\u00020\r2\u0006\u0010I\u001a\u00020;¢\u0006\u0004\b\\\u0010]J\u0015\u0010`\u001a\u00020\r2\u0006\u0010_\u001a\u00020^¢\u0006\u0004\b`\u0010aJ\u0015\u0010d\u001a\u00020\r2\u0006\u0010c\u001a\u00020b¢\u0006\u0004\bd\u0010eJ\u0015\u0010h\u001a\u00020\r2\u0006\u0010g\u001a\u00020f¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u0004\u0018\u00010f¢\u0006\u0004\bj\u0010kJ\u0015\u0010n\u001a\u00020\r2\u0006\u0010m\u001a\u00020l¢\u0006\u0004\bn\u0010oJ\u0015\u0010r\u001a\u00020\r2\u0006\u0010q\u001a\u00020p¢\u0006\u0004\br\u0010sJ\u0015\u0010v\u001a\n\u0012\u0004\u0012\u00020u\u0018\u00010t¢\u0006\u0004\bv\u0010wJ'\u0010z\u001a\u00020\r2\u0018\u0010y\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0x¢\u0006\u0004\bz\u0010{J'\u0010|\u001a\u00020\r2\u0018\u0010y\u001a\u0014\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0x¢\u0006\u0004\b|\u0010{J\u001b\u0010~\u001a\u00020\r2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\r0}¢\u0006\u0004\b~\u0010\u007fR\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010\u008c\u0001R\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\"\u0010\u008c\u0001R\u001b\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0015\u0010\u0090\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0090\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0090\u0001¨\u0006\u0096\u0001"}, d2 = {"Lt/v/c/widget/videoview/PlayerView;", "Lt/v/c/widget/FrameLayout;", "Lx1/f1/lb/widget/videoview/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lr8/z;", "x", "", "mediaId", "lang", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "i", "()F", "l", "a", "()I", "dimensionType", "size", "g", "(IF)V", "y", "b", "(FF)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "imgResId", "setTrialImg", "(I)V", "getDecodeMode", "()Ljava/lang/Integer;", "getAspectRatioType", "aspectRatioType", "setAspectRatioType", "", "getSubtitles", "()Ljava/util/List;", "sizeInSp", "setSubtitleFontSize", "getVideoWidth", "getVideoHeight", "setSubtitle", "(Ljava/lang/String;)V", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "Lkotlinx/coroutines/flow/f;", "", "H", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)Lkotlinx/coroutines/flow/f;", "Lz1/b1/lb/m/meta/EPGProgramme;", "programme", "I", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;Lz1/b1/lb/m/meta/EPGProgramme;)Lkotlinx/coroutines/flow/f;", "getSession", "()J", "", "B", "()Z", "G", TypedValues.TransitionType.S_FROM, "position", "C", "(Ljava/lang/String;Ljava/lang/Long;)Z", "setZOrderOnTop", "(Z)V", "isTerminate", "J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", "z", "getPosition", "getDuration", "getDownloadThousand", "getSubtitleLang", "()Ljava/lang/String;", "getVideoName", "Lv6/c;", "getPlayType", "()Lv6/c;", ExifInterface.LONGITUDE_EAST, "(J)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "onInfoListener", "setOnInfoListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "onPreparedListener", "setOnPreparedListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "onCompletionListener", "setOnCompletionListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;)V", "getOnCompletionListener", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "onErrorListener", "setOnErrorListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "onSeekCompleteListener", "setOnSeekCompleteListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;)V", "", "Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "getTrackInfo", "()[Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "Lkotlin/Function2;", "listener", "setNoSignalListener", "(Lc9/p;)V", "setLoadingListener", "Lkotlin/Function0;", "setPlayCompleteListener", "(Lc9/a;)V", "Lt/v/c/widget/videoview/VideoView;", "d", "Lt/v/c/widget/videoview/VideoView;", "videoView", "Lx1/f1/lb/widget/videoview/c0;", "e", "Lx1/f1/lb/widget/videoview/c0;", "playerViewHandler", "Lt/v/c/s/widget/SimpleSubtitleView;", "f", "Lt/v/c/s/widget/SimpleSubtitleView;", "subtitleView", "Lt/v/c/widget/FrameLayout;", "playerTrialCorner", "noSignalView", "Lt/v/c/widget/ImageView;", "Lt/v/c/widget/ImageView;", "noSignalImg", "j", "dftCoverView", "k", "trialBgImg", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayerView extends FrameLayout implements x1.f1.lb.widget.videoview.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f18824m = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private VideoView videoView;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c0 playerViewHandler;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SimpleSubtitleView subtitleView;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private FrameLayout playerTrialCorner;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout noSignalView;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView noSignalImg;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ImageView dftCoverView;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ImageView trialBgImg;

    /* JADX INFO: renamed from: t.v.c.widget.videoview.PlayerView$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lt/v/c/widget/videoview/PlayerView$a;", "", "<init>", "()V", "", "setCustomDensity", "Z", "getSetCustomDensity", "()Z", "a", "(Z)V", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        public final void a(boolean z10) {
            PlayerView.f18824m = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"t/v/c/widget/videoview/PlayerView$b", "Lx1/f1/lb/widget/videoview/c0;", "", "visibility", "Lr8/z;", "g1", "(I)V", "k1", "r0", "()Ljava/lang/Integer;", "v1", "y1", "()V", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "z1", "(Ljava/lang/String;)V", "x1", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends c0 {
        final /* synthetic */ Context C;

        b(Context context) {
            this.C = context;
        }

        @Override // x1.f1.lb.widget.videoview.c0
        public void g1(int visibility) {
            ImageView imageView = PlayerView.this.dftCoverView;
            if (imageView != null) {
                imageView.setVisibility(visibility);
            }
        }

        @Override // x1.f1.lb.widget.videoview.c0
        public void k1(int visibility) {
            FrameLayout frameLayout = PlayerView.this.noSignalView;
            if (frameLayout != null) {
                frameLayout.setVisibility(visibility);
            }
        }

        @Override // x1.f1.lb.widget.videoview.c0
        public Integer r0() {
            FrameLayout frameLayout = PlayerView.this.noSignalView;
            if (frameLayout != null) {
                return Integer.valueOf(frameLayout.getVisibility());
            }
            return null;
        }

        @Override // x1.f1.lb.widget.videoview.c0
        public void v1(int visibility) {
            FrameLayout frameLayout = PlayerView.this.playerTrialCorner;
            if (frameLayout != null) {
                frameLayout.setVisibility(visibility);
            }
        }

        @Override // x1.f1.lb.widget.videoview.c0
        public void x1(String url) {
            if (url == null || url.length() == 0) {
                ImageView imageView = PlayerView.this.noSignalImg;
                if (imageView != null) {
                    imageView.setImageResource(R$drawable.vip_only);
                    return;
                }
                return;
            }
            ImageView imageView2 = PlayerView.this.noSignalImg;
            if (imageView2 != null) {
                com.bumptech.glide.c.t(this.C).u(url).b0(R$drawable.vip_only).E0(imageView2);
            }
        }

        @Override // x1.f1.lb.widget.videoview.c0
        public void y1() {
            ImageView imageView = PlayerView.this.noSignalImg;
            if (imageView != null) {
                imageView.setImageResource(R$drawable.no_signal);
            }
        }

        @Override // x1.f1.lb.widget.videoview.c0
        public void z1(String url) {
            if (url == null || url.length() == 0) {
                ImageView imageView = PlayerView.this.noSignalImg;
                if (imageView != null) {
                    imageView.setImageResource(R$drawable.member);
                    return;
                }
                return;
            }
            ImageView imageView2 = PlayerView.this.noSignalImg;
            if (imageView2 != null) {
                com.bumptech.glide.c.t(this.C).u(url).b0(R$drawable.member).E0(imageView2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "t.v.c.widget.videoview.PlayerView$init$3", f = "PlayerView.kt", l = {435}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "t.v.c.widget.videoview.PlayerView$init$3$1", f = "PlayerView.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends l implements q<kotlinx.coroutines.flow.g<? super Boolean>, Throwable, v8.f<? super z>, Object> {
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, Throwable th, v8.f<? super z> fVar) {
                return new a(fVar).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ PlayerView f18833a;

            b(PlayerView playerView) {
                this.f18833a = playerView;
            }

            public final Object b(boolean z10, v8.f<? super z> fVar) {
                c0 c0Var = this.f18833a.playerViewHandler;
                if (c0Var == null) {
                    m.v("playerViewHandler");
                    c0Var = null;
                }
                c0Var.u1();
                return z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Boolean) obj).booleanValue(), fVar);
            }
        }

        c(v8.f<? super c> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return PlayerView.this.new c(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                kotlinx.coroutines.flow.f fVarF = h.f(t.v.c.i.a.O0(t.v.c.i.a.f18646a, null, 1, null), new a(null));
                b bVar = new b(PlayerView.this);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context) {
        super(context);
        m.f(context, "context");
        y(this, context, null, 2, null);
    }

    public static /* synthetic */ boolean D(PlayerView playerView, String str, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "restart";
        }
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        return playerView.C(str, l10);
    }

    private final void x(Context context, AttributeSet attrs) {
        TextView textView;
        Drawable drawable;
        Drawable drawable2;
        TextView textView2;
        if (f18824m) {
            a0.f21295a.e(context);
        }
        LayoutInflater.from(context).inflate(R$layout.player_view, this);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.PlayerView);
            m.e(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                CharSequence text = typedArrayObtainStyledAttributes.getText(R$styleable.PlayerView_trial_corner_text);
                if (text == null || text.length() == 0) {
                    drawable2 = null;
                    textView2 = null;
                } else {
                    this.playerTrialCorner = (FrameLayout) findViewById(R$id.player_trial_corner);
                    this.trialBgImg = (ImageView) findViewById(R$id.trial_corner_bg);
                    drawable2 = typedArrayObtainStyledAttributes.getDrawable(R$styleable.PlayerView_trial_corner_drawable);
                    if (drawable2 == null) {
                        drawable2 = null;
                    }
                    textView2 = (TextView) findViewById(R$id.trail_corner_txt);
                    if (textView2 != null) {
                        textView2.setText(text);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
                drawable = drawable2;
                textView = textView2;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            textView = null;
            drawable = null;
        }
        this.videoView = (VideoView) findViewById(R$id.base_lib_player_video_view);
        this.noSignalView = (FrameLayout) findViewById(R$id.base_lib_player_no_signal_img);
        this.noSignalImg = (ImageView) findViewById(R$id.no_signal_img);
        this.dftCoverView = (ImageView) findViewById(R$id.base_lib_player_dft_cover_img);
        this.subtitleView = (SimpleSubtitleView) findViewById(R$id.base_lib_subtitle_view);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.base_lib_player_tip_layout);
        ImageView imageView = (ImageView) findViewById(R$id.base_lib_player_loading_img);
        TextView textView3 = (TextView) findViewById(R$id.base_lib_player_loading_txt);
        MarqueeTextView marqueeTextView = (MarqueeTextView) findViewById(R$id.base_lib_player_tip_txt);
        VideoView videoView = this.videoView;
        if (videoView == null) {
            m.v("videoView");
            videoView = null;
        }
        m.c(textView3);
        m.c(imageView);
        videoView.r(linearLayout, marqueeTextView, textView3, imageView);
        b bVar = new b(context);
        this.playerViewHandler = bVar;
        VideoView videoView2 = this.videoView;
        if (videoView2 == null) {
            m.v("videoView");
            videoView2 = null;
        }
        z0 videoViewHandler = videoView2.getVideoViewHandler();
        SimpleSubtitleView simpleSubtitleView = this.subtitleView;
        if (simpleSubtitleView == null) {
            m.v("subtitleView");
            simpleSubtitleView = null;
        }
        yf.a subtitleHandler = simpleSubtitleView.getSubtitleHandler();
        VideoView videoView3 = this.videoView;
        if (videoView3 == null) {
            m.v("videoView");
            videoView3 = null;
        }
        ViewTreeObserver viewTreeObserver = videoView3.getViewTreeObserver();
        m.c(marqueeTextView);
        bVar.J0(context, this, videoViewHandler, subtitleHandler, viewTreeObserver, marqueeTextView, textView3, imageView, this.trialBgImg, textView, drawable);
        j.d(m0.a(a1.b()), null, null, new c(null), 3, null);
    }

    static /* synthetic */ void y(PlayerView playerView, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        playerView.x(context, attributeSet);
    }

    public final boolean A() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.S0();
    }

    public final boolean B() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.a1();
    }

    public final boolean C(String from, Long position) {
        m.f(from, "from");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.c1(from, null, position);
    }

    public final void E(long position) {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.e1(position);
    }

    public final boolean G() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.D1();
    }

    public final kotlinx.coroutines.flow.f<Long> H(ChannelStreamResponse response) {
        m.f(response, "response");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.G1(response);
    }

    public final kotlinx.coroutines.flow.f<Long> I(ChannelStreamResponse response, EPGProgramme programme) {
        m.f(response, "response");
        m.f(programme, "programme");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.H1(response, programme);
    }

    public final void J(boolean isTerminate) {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.I1(isTerminate);
    }

    @Override // x1.f1.lb.widget.videoview.a
    public void b(float x10, float y10) {
        FrameLayout frameLayout = this.playerTrialCorner;
        if (frameLayout != null) {
            frameLayout.setX(x10);
        }
        FrameLayout frameLayout2 = this.playerTrialCorner;
        if (frameLayout2 != null) {
            frameLayout2.setY(y10);
        }
    }

    @Override // x1.f1.lb.widget.videoview.a
    public String c(String mediaId, String lang) {
        m.f(mediaId, "mediaId");
        m.f(lang, "lang");
        return t.v.c.i.a.f18646a.W(mediaId, lang);
    }

    @Override // x1.f1.lb.widget.videoview.a
    public void g(int dimensionType, float size) {
        SimpleSubtitleView simpleSubtitleView = this.subtitleView;
        if (simpleSubtitleView == null) {
            m.v("subtitleView");
            simpleSubtitleView = null;
        }
        simpleSubtitleView.setTextSize(dimensionType, size);
    }

    public final Integer getAspectRatioType() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return Integer.valueOf(c0Var.m0());
    }

    public final Integer getDecodeMode() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.n0();
    }

    public final int getDownloadThousand() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.o0();
    }

    public final long getDuration() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.p0();
    }

    public final IMediaPlayer.OnCompletionListener getOnCompletionListener() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.getOnCompletionListener();
    }

    public final v6.c getPlayType() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.t0();
    }

    public final long getPosition() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.u0();
    }

    public final long getSession() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.v0();
    }

    public final String getSubtitleLang() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.x0();
    }

    public final List<String> getSubtitles() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.z0();
    }

    public final ITrackInfo[] getTrackInfo() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.A0();
    }

    public final int getVideoHeight() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.B0();
    }

    public final String getVideoName() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.C0();
    }

    public final int getVideoWidth() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.D0();
    }

    public final void setAspectRatioType(int aspectRatioType) {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.f1(aspectRatioType);
    }

    public final void setLoadingListener(final p<? super Boolean, ? super String, z> listener) {
        m.f(listener, "listener");
        final ArrayList arrayList = new ArrayList();
        c0 c0Var = null;
        arrayList.add(null);
        p<? super Boolean, ? super String, z> pVar = new p() { // from class: t.v.c.widget.videoview.a
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return PlayerView.F(arrayList, listener, ((Boolean) obj).booleanValue(), (String) obj2);
            }
        };
        c0 c0Var2 = this.playerViewHandler;
        if (c0Var2 == null) {
            m.v("playerViewHandler");
        } else {
            c0Var = c0Var2;
        }
        c0Var.h1(pVar);
    }

    public final void setNoSignalListener(p<? super Integer, ? super String, z> listener) {
        m.f(listener, "listener");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.j1(listener);
    }

    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        m.f(onCompletionListener, "onCompletionListener");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.l1(onCompletionListener);
    }

    public final void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        m.f(onErrorListener, "onErrorListener");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.m1(onErrorListener);
    }

    public final void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        m.f(onInfoListener, "onInfoListener");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.n1(onInfoListener);
    }

    public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        m.f(onPreparedListener, "onPreparedListener");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.o1(onPreparedListener);
    }

    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        m.f(onSeekCompleteListener, "onSeekCompleteListener");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.p1(onSeekCompleteListener);
    }

    public final void setPlayCompleteListener(c9.a<z> listener) {
        m.f(listener, "listener");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.q1(listener);
    }

    public final void setSubtitle(String lang) {
        m.f(lang, "lang");
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.r1(lang);
    }

    public final void setSubtitleFontSize(int sizeInSp) {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.s1(sizeInSp);
    }

    public final void setTrialImg(@DrawableRes int imgResId) {
        ImageView imageView = this.trialBgImg;
        if (imageView != null) {
            imageView.setImageResource(imgResId);
        }
    }

    public final void setZOrderOnTop(boolean b10) {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        c0Var.w1(b10);
    }

    public final boolean v() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.U();
    }

    public final boolean w() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.V();
    }

    public final boolean z() {
        c0 c0Var = this.playerViewHandler;
        if (c0Var == null) {
            m.v("playerViewHandler");
            c0Var = null;
        }
        return c0Var.R0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.f(context, "context");
        x(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z F(List<Boolean> list, p<? super Boolean, ? super String, z> pVar, boolean z10, String str) {
        if (m.a(Boolean.valueOf(z10), kotlin.collections.r.i0(list))) {
            return z.f17874a;
        }
        list.set(0, Boolean.valueOf(z10));
        pVar.invoke(Boolean.valueOf(z10), str);
        return z.f17874a;
    }

    @Override // x1.f1.lb.widget.videoview.a
    public int a() {
        return getHeight();
    }

    @Override // x1.f1.lb.widget.videoview.a
    public float i() {
        return getX();
    }

    @Override // x1.f1.lb.widget.videoview.a
    public float l() {
        return getY();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.f(context, "context");
        x(context, attributeSet);
    }
}
