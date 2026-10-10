package com.live.evo.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;
import t.v.c.widget.videoview.PlayerView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0002OSB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\rJ\r\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\rJ\u000f\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010\rJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020 H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0012H\u0016¢\u0006\u0004\b'\u0010\u0014J\u000f\u0010(\u001a\u00020 H\u0016¢\u0006\u0004\b(\u0010\"J\u000f\u0010)\u001a\u00020\u0012H\u0016¢\u0006\u0004\b)\u0010\u0014J\u000f\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b*\u0010\u0014J\u000f\u0010+\u001a\u00020\u0012H\u0016¢\u0006\u0004\b+\u0010\u0014J\u000f\u0010,\u001a\u00020 H\u0016¢\u0006\u0004\b,\u0010\"J\u0017\u0010/\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0012H\u0014¢\u0006\u0004\b1\u0010\u0014J\u001f\u00103\u001a\u00020\u00122\u0006\u00102\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020\u00122\u0006\u00102\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b5\u00104J\r\u00106\u001a\u00020\n¢\u0006\u0004\b6\u0010\rJ\u0017\u00109\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020 H\u0014¢\u0006\u0004\b;\u0010\"J\u0019\u0010>\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u00010<H\u0004¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\nH\u0004¢\u0006\u0004\b@\u0010\rJ\u000f\u0010A\u001a\u00020\u000fH\u0014¢\u0006\u0004\bA\u0010\u0011J\u0019\u0010D\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010BH\u0014¢\u0006\u0004\bD\u0010EJ\u0011\u0010F\u001a\u0004\u0018\u00010<H\u0014¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u0004\u0018\u00010<H\u0014¢\u0006\u0004\bH\u0010GJ\u0011\u0010J\u001a\u0004\u0018\u00010IH\u0014¢\u0006\u0004\bJ\u0010KJ#\u0010L\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010=\u001a\u0004\u0018\u00010<H\u0014¢\u0006\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR$\u0010Y\u001a\u0004\u0018\u00010R8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010hR\u0018\u0010p\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\"\u0010w\u001a\u00020 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bt\u0010L\u001a\u0004\bu\u0010\"\"\u0004\bv\u0010&R\u0016\u0010z\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010yR\u0016\u0010}\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010yR\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010\u007fR\u0017\u0010\u0083\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b6\u0010\u0082\u0001R\u0017\u0010\u0086\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0018\u0010\u0085\u0001R\u0017\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001a\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010\u008f\u0001R\u0017\u0010\u0091\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010\u000eR\u0017\u0010\u0094\u0001\u001a\u00030\u0092\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010\u0093\u0001¨\u0006\u0096\u0001"}, d2 = {"Lcom/live/evo/widget/k;", "Landroid/widget/FrameLayout;", "Landroid/widget/MediaController$MediaPlayerControl;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lr8/z;", "v", "n", "()V", "J", "", "getBufferedLeading", "()J", "", "t", "()Z", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "forward", "q", "(Landroid/view/KeyEvent;Z)Z", "r", "G", "F", "getAndPlay", "start", "pause", "", "getDuration", "()I", "getCurrentPosition", "pos", "seekTo", "(I)V", "isPlaying", "getBufferPercentage", "canPause", "canSeekBackward", "canSeekForward", "getAudioSessionId", "Lcom/live/evo/widget/ijkmedia/a;", "controller", "setMediaController", "(Lcom/live/evo/widget/ijkmedia/a;)V", "o", "keyCode", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onKeyUp", "p", "Lcom/live/evo/widget/k$b;", "playEventListener", "setPlayEventListener", "(Lcom/live/evo/widget/k$b;)V", "getLayoutId", "", "message", "H", "(Ljava/lang/String;)V", "u", "getUidRxBytes", "Lkotlinx/coroutines/flow/f;", "Lx4/c;", "getCatchUpPlayInfo", "()Lkotlinx/coroutines/flow/f;", "getConnectingMsg", "()Ljava/lang/String;", "getLoadingMsg", "Lcom/live/evo/widget/n;", "getPlayerSettings", "()Lcom/live/evo/widget/n;", "I", "(Landroid/content/Context;Ljava/lang/String;)V", "Lq6/b;", "a", "Lq6/b;", "logger", "Landroid/app/Activity;", "b", "Landroid/app/Activity;", "getMContext", "()Landroid/app/Activity;", "setMContext", "(Landroid/app/Activity;)V", "mContext", "Lt/v/c/widget/videoview/PlayerView;", "c", "Lt/v/c/widget/videoview/PlayerView;", "mVideoView", "Landroid/view/View;", "d", "Landroid/view/View;", "mLoadingIcon", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mLoadingHint", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mLoadingMsg", "g", "mLoadingSpeed", "h", "mDebugInfo", "i", "Lcom/live/evo/widget/ijkmedia/a;", "mMediaController", "j", "Lcom/live/evo/widget/k$b;", "mPlayEventListener", "k", "getMRT_RETRY_LIMIT", "setMRT_RETRY_LIMIT", "MRT_RETRY_LIMIT", "l", "Z", "mIsDebugViewVisible", "m", "mIsLoadingViewVisible", "mInLowLevelBuffering", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mOnLowLevelBufferingEndAction", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "mOnPreparedListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "mOnInfoListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "mOnCompletionListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "s", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "mOnErrorListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "mOnSeekCompleteListener", "mForwardRewindPosition", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "w", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class k extends FrameLayout implements MediaController.MediaPlayerControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Activity mContext;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private PlayerView mVideoView;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mLoadingIcon;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mLoadingHint;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mLoadingMsg;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mLoadingSpeed;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mDebugInfo;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.widget.ijkmedia.a mMediaController;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private b mPlayEventListener;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int MRT_RETRY_LIMIT;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean mIsDebugViewVisible;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLoadingViewVisible;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean mInLowLevelBuffering;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Runnable mOnLowLevelBufferingEndAction;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final IMediaPlayer.OnPreparedListener mOnPreparedListener;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final IMediaPlayer.OnInfoListener mOnInfoListener;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final IMediaPlayer.OnCompletionListener mOnCompletionListener;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final IMediaPlayer.OnErrorListener mOnErrorListener;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private long mForwardRewindPosition;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandler;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u0006J3\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/live/evo/widget/k$b;", "", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "mediaPlayer", "Lr8/z;", "onPrepared", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "", "what", "extra", "", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;II)Z", "onCompletion", "", "info", "b", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;IILjava/lang/String;)Z", "", "throwable", "c", "(Ljava/lang/Throwable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        boolean a(IMediaPlayer mediaPlayer, int what, int extra);

        boolean b(IMediaPlayer mediaPlayer, int what, int extra, String info);

        void c(Throwable throwable);

        void onCompletion(IMediaPlayer mediaPlayer);

        void onPrepared(IMediaPlayer mediaPlayer);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.widget.CatchUpVideoView$getAndPlay$1", f = "CatchUpVideoView.kt", l = {144}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.f<x4.c> $flow;
        int label;
        final /* synthetic */ k this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.widget.CatchUpVideoView$getAndPlay$1$1", f = "CatchUpVideoView.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lx4/c;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super x4.c>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ k this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(k kVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = kVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super x4.c> gVar, Throwable th, v8.f<? super z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    this.this$0.logger.error("prepare error", th);
                    if (this.this$0.mPlayEventListener != null) {
                        b bVar = this.this$0.mPlayEventListener;
                        if (bVar != null) {
                            bVar.c(th);
                        }
                    } else {
                        k kVar = this.this$0;
                        kVar.I(kVar.getMContext(), "prepare error," + th.getMessage());
                    }
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f7624a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class a<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final a<T> f7625a = new a<>();

                public final Object b(long j10, v8.f<? super z> fVar) {
                    return z.f17874a;
                }

                @Override // kotlinx.coroutines.flow.g
                public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                    return b(((Number) obj).longValue(), fVar);
                }

                a() {
                }
            }

            /* JADX INFO: renamed from: com.live.evo.widget.k$c$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.widget.CatchUpVideoView$getAndPlay$1$2", f = "CatchUpVideoView.kt", l = {159}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0118b extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0118b(b<? super T> bVar, v8.f<? super C0118b> fVar) {
                    super(fVar);
                    this.this$0 = bVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            b(k kVar) {
                this.f7624a = kVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(x4.c cVar, v8.f<? super z> fVar) {
                C0118b c0118b;
                b<T> bVar;
                if (fVar instanceof C0118b) {
                    c0118b = (C0118b) fVar;
                    int i10 = c0118b.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0118b.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0118b = new C0118b(this, fVar);
                    }
                } else {
                    c0118b = new C0118b(this, fVar);
                }
                Object obj = c0118b.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0118b.label;
                if (i11 == 0) {
                    r8.r.b(obj);
                    if (cVar == null) {
                        k kVar = this.f7624a;
                        Activity mContext = kVar.getMContext();
                        Activity mContext2 = this.f7624a.getMContext();
                        kVar.I(mContext, mContext2 != null ? mContext2.getString(R$string.catchup_no_next_program) : null);
                        return z.f17874a;
                    }
                    try {
                        String strB = cVar.b();
                        kotlin.jvm.internal.m.e(strB, "getChannelKey(...)");
                        ChannelStreamResponse channelStreamResponseJ = t.v.c.i.a.f18646a.j(Integer.parseInt(strB));
                        EPGProgramme ePGProgramme = new EPGProgramme();
                        ePGProgramme.setStart(cVar.a());
                        ePGProgramme.setStop(cVar.g());
                        ePGProgramme.setChannel(cVar.h());
                        ePGProgramme.setTitle(cVar.f());
                        ePGProgramme.setDesc(cVar.e());
                        PlayerView playerView = this.f7624a.mVideoView;
                        if (playerView != null) {
                            kotlin.jvm.internal.m.c(channelStreamResponseJ);
                            kotlinx.coroutines.flow.f<Long> fVarI = playerView.I(channelStreamResponseJ, ePGProgramme);
                            if (fVarI != null) {
                                a<T> aVar = a.f7625a;
                                c0118b.L$0 = this;
                                c0118b.label = 1;
                                if (fVarI.collect(aVar, c0118b) == objC) {
                                    return objC;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bVar = this;
                        k kVar2 = bVar.f7624a;
                        kVar2.I(kVar2.getMContext(), "prepare error," + th.getMessage());
                        z zVar = z.f17874a;
                    }
                    return z.f17874a;
                }
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (b) c0118b.L$0;
                try {
                    r8.r.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    k kVar3 = bVar.f7624a;
                    kVar3.I(kVar3.getMContext(), "prepare error," + th.getMessage());
                    z zVar2 = z.f17874a;
                }
                z zVar3 = z.f17874a;
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(kotlinx.coroutines.flow.f<? extends x4.c> fVar, k kVar, v8.f<? super c> fVar2) {
            super(2, fVar2);
            this.$flow = fVar;
            this.this$0 = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$flow, this.this$0, fVar);
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
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(this.$flow, new a(this.this$0, null));
                b bVar = new b(this.this$0);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context) {
        super(context);
        kotlin.jvm.internal.m.f(context, "context");
        q6.b bVarD = q6.c.d(k.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.MRT_RETRY_LIMIT = 100;
        this.mOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.live.evo.widget.a
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                k.D(this.f7568a, iMediaPlayer);
            }
        };
        this.mOnInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.live.evo.widget.b
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
                return k.C(this.f7569a, iMediaPlayer, i10, i11, str);
            }
        };
        this.mOnCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.live.evo.widget.c
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                k.A(this.f7570a, iMediaPlayer);
            }
        };
        this.mOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.live.evo.widget.d
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                return k.B(this.f7571a, iMediaPlayer, i10, i11);
            }
        };
        this.mOnSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.live.evo.widget.e
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
                k.E(iMediaPlayer);
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.live.evo.widget.f
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return k.z(this.f7572a, message);
            }
        });
        v(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(k kVar, IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
        if (i10 != 3) {
            switch (i10) {
                case 700:
                    kVar.logger.a("OnInfoListener MEDIA_INFO_VIDEO_TRACK_LAGGING [{}]", Integer.valueOf(i11));
                    break;
                case 701:
                    kVar.mHandler.sendEmptyMessage(i10);
                    break;
                case 702:
                    kVar.mHandler.sendEmptyMessage(i10);
                    break;
                case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                    kVar.logger.a("OnInfoListener MEDIA_INFO_NETWORK_BANDWIDTH [{}]", Integer.valueOf(i11));
                    break;
                default:
                    kVar.logger.a("onPlayerInfo: what[{}] extra[{}]", Integer.valueOf(i10), Integer.valueOf(i11));
                    break;
            }
        }
        b bVar = kVar.mPlayEventListener;
        if (bVar == null) {
            return true;
        }
        kotlin.jvm.internal.m.c(bVar);
        return bVar.a(iMediaPlayer, i10, i11);
    }

    private final void F() {
        this.mInLowLevelBuffering = false;
        Runnable runnable = this.mOnLowLevelBufferingEndAction;
        if (runnable != null) {
            kotlin.jvm.internal.m.c(runnable);
            runnable.run();
            this.mOnLowLevelBufferingEndAction = null;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    protected kotlinx.coroutines.flow.f<x4.c> getCatchUpPlayInfo() {
        return null;
    }

    protected boolean o() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(k kVar, IMediaPlayer iMediaPlayer) {
        b bVar = kVar.mPlayEventListener;
        if (bVar != null) {
            kotlin.jvm.internal.m.c(bVar);
            bVar.onCompletion(iMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(k kVar, IMediaPlayer iMediaPlayer, int i10, int i11) {
        b bVar = kVar.mPlayEventListener;
        if (bVar == null) {
            return true;
        }
        kotlin.jvm.internal.m.c(bVar);
        return bVar.b(iMediaPlayer, i10, i11, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(k kVar, IMediaPlayer iMediaPlayer) {
        b bVar = kVar.mPlayEventListener;
        if (bVar != null) {
            kotlin.jvm.internal.m.c(bVar);
            bVar.onPrepared(iMediaPlayer);
        }
    }

    private final void G() {
        H("");
        this.mInLowLevelBuffering = true;
    }

    private final void J() {
        TextView textView = this.mDebugInfo;
        kotlin.jvm.internal.m.c(textView);
        if (textView.getVisibility() == 0) {
            TextView textView2 = this.mDebugInfo;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setVisibility(8);
            this.mIsDebugViewVisible = false;
            return;
        }
        TextView textView3 = this.mDebugInfo;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setVisibility(0);
        this.mIsDebugViewVisible = true;
    }

    private final long getBufferedLeading() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        long downloadThousand = playerView.getDownloadThousand();
        PlayerView playerView2 = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView2);
        long duration = (downloadThousand * playerView2.getDuration()) / ((long) 1000);
        PlayerView playerView3 = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView3);
        return duration - playerView3.getPosition();
    }

    private final void n() {
        com.live.evo.widget.ijkmedia.a aVar = this.mMediaController;
        if (aVar != null) {
            aVar.setMediaPlayer(this);
            aVar.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            PlayerView playerView = this.mVideoView;
            boolean z10 = false;
            if (playerView != null && playerView.z()) {
                z10 = true;
            }
            aVar.setEnabled(z10);
        }
    }

    private final boolean q(KeyEvent event, boolean forward) {
        com.live.evo.widget.ijkmedia.a aVar = this.mMediaController;
        kotlin.jvm.internal.m.c(aVar);
        if (!aVar.isShowing()) {
            com.live.evo.widget.ijkmedia.a aVar2 = this.mMediaController;
            kotlin.jvm.internal.m.c(aVar2);
            aVar2.show();
        }
        com.live.evo.widget.ijkmedia.a aVar3 = this.mMediaController;
        kotlin.jvm.internal.m.c(aVar3);
        if (!aVar3.b()) {
            com.live.evo.widget.ijkmedia.a aVar4 = this.mMediaController;
            kotlin.jvm.internal.m.c(aVar4);
            aVar4.d();
            this.mForwardRewindPosition = getCurrentPosition();
        }
        long duration = getDuration();
        long j10 = duration / 240;
        if (j10 < 1000) {
            j10 = 1000;
        }
        if (event.getRepeatCount() > 10) {
            j10 *= (long) 2;
        }
        if (duration <= 0) {
            return true;
        }
        long jMin = (long) (forward ? Math.min(duration, this.mForwardRewindPosition + j10) : Math.max(0.0d, this.mForwardRewindPosition - j10));
        this.mForwardRewindPosition = jMin;
        long j11 = (jMin * 1000) / duration;
        com.live.evo.widget.ijkmedia.a aVar5 = this.mMediaController;
        kotlin.jvm.internal.m.c(aVar5);
        aVar5.setTrackingProgress((int) j11);
        return true;
    }

    private final boolean r() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                k.s(this.f7573a);
            }
        }, 500L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(k kVar) {
        com.live.evo.widget.ijkmedia.a aVar = kVar.mMediaController;
        kotlin.jvm.internal.m.c(aVar);
        if (aVar.b()) {
            com.live.evo.widget.ijkmedia.a aVar2 = kVar.mMediaController;
            kotlin.jvm.internal.m.c(aVar2);
            aVar2.c();
            kVar.mHandler.sendEmptyMessage(701);
        }
    }

    private final void v(Context context) {
        kotlin.jvm.internal.m.d(context, "null cannot be cast to non-null type android.app.Activity");
        this.mContext = (Activity) context;
        View.inflate(context, getLayoutId(), this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mVideoView = (PlayerView) findViewById(R$id.video_view);
        this.mLoadingIcon = findViewById(R$id.loading_icon);
        this.mLoadingHint = (ViewGroup) findViewById(R$id.loading_hint);
        this.mLoadingMsg = (TextView) findViewById(R$id.loading_msg);
        this.mLoadingSpeed = (TextView) findViewById(R$id.loading_speed);
        this.mDebugInfo = (TextView) findViewById(R$id.debug_info);
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.setOnPreparedListener(this.mOnPreparedListener);
        }
        PlayerView playerView2 = this.mVideoView;
        if (playerView2 != null) {
            playerView2.setOnInfoListener(this.mOnInfoListener);
        }
        PlayerView playerView3 = this.mVideoView;
        if (playerView3 != null) {
            playerView3.setOnCompletionListener(this.mOnCompletionListener);
        }
        PlayerView playerView4 = this.mVideoView;
        if (playerView4 != null) {
            playerView4.setOnErrorListener(this.mOnErrorListener);
        }
        PlayerView playerView5 = this.mVideoView;
        if (playerView5 != null) {
            playerView5.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
        }
        PlayerView playerView6 = this.mVideoView;
        if (playerView6 != null) {
            playerView6.setLoadingListener(new c9.p() { // from class: com.live.evo.widget.h
                @Override // c9.p
                public final Object invoke(Object obj, Object obj2) {
                    return k.w(this.f7574a, ((Boolean) obj).booleanValue(), (String) obj2);
                }
            });
        }
        PlayerView playerView7 = this.mVideoView;
        if (playerView7 != null) {
            playerView7.setNoSignalListener(new c9.p() { // from class: com.live.evo.widget.i
                @Override // c9.p
                public final Object invoke(Object obj, Object obj2) {
                    return k.x(this.f7575a, ((Integer) obj).intValue(), (String) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z w(k kVar, boolean z10, String loadingTip) {
        kotlin.jvm.internal.m.f(loadingTip, "loadingTip");
        if (z10) {
            kVar.H(kVar.getLoadingMsg());
        } else {
            kVar.u();
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z x(final k kVar, int i10, String desc) {
        kotlin.jvm.internal.m.f(desc, "desc");
        if (i10 == 1) {
            kVar.post(new Runnable() { // from class: com.live.evo.widget.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.y(this.f7600a);
                }
            });
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(k kVar) {
        b5.i iVar = new b5.i();
        iVar.f915a = 1;
        xe.c.c().o(iVar);
        Activity activityA = c5.a.a(kVar);
        if (activityA != null) {
            activityA.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(k kVar, Message msg) {
        kotlin.jvm.internal.m.f(msg, "msg");
        int i10 = msg.what;
        if (i10 == 701) {
            kVar.G();
            return false;
        }
        if (i10 != 702) {
            return false;
        }
        kVar.F();
        return false;
    }

    protected final void H(String message) {
        View view = this.mLoadingIcon;
        kotlin.jvm.internal.m.c(view);
        view.setVisibility(0);
        ViewGroup viewGroup = this.mLoadingHint;
        kotlin.jvm.internal.m.c(viewGroup);
        viewGroup.setVisibility(0);
        this.mIsLoadingViewVisible = true;
        TextView textView = this.mLoadingMsg;
        kotlin.jvm.internal.m.c(textView);
        textView.setText(message);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        return playerView.A();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        return playerView.v();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        return playerView.w();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        return playerView.getDownloadThousand() / 10;
    }

    protected String getConnectingMsg() {
        return "Connecting...";
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        return (int) playerView.getPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        return (int) playerView.getDuration();
    }

    protected String getLoadingMsg() {
        return "Loading...";
    }

    protected final Activity getMContext() {
        return this.mContext;
    }

    protected final int getMRT_RETRY_LIMIT() {
        return this.MRT_RETRY_LIMIT;
    }

    protected n getPlayerSettings() {
        return new l();
    }

    protected long getUidRxBytes() {
        return 0L;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        return playerView.z();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        com.live.evo.widget.ijkmedia.a aVar;
        kotlin.jvm.internal.m.f(event, "event");
        boolean z10 = (keyCode == 4 || keyCode == 24 || keyCode == 25 || keyCode == 164 || keyCode == 82 || keyCode == 5 || keyCode == 6) ? false : true;
        if (keyCode == 16 && event.getRepeatCount() == 5) {
            if (o()) {
                J();
                return true;
            }
        } else if (keyCode == 20 && event.getRepeatCount() == 0) {
            PlayerView playerView = this.mVideoView;
            kotlin.jvm.internal.m.c(playerView);
            if (playerView.z() && (aVar = this.mMediaController) != null) {
                kotlin.jvm.internal.m.c(aVar);
                aVar.show();
                return true;
            }
        } else if ((keyCode != 87 || event.getRepeatCount() != 0) && ((keyCode != 88 || event.getRepeatCount() != 0) && z10 && this.mMediaController != null)) {
            if (keyCode != 66 && keyCode != 79 && keyCode != 85) {
                if (keyCode != 86) {
                    if (keyCode != 89) {
                        if (keyCode != 90) {
                            if (keyCode == 126) {
                                if (!isPlaying()) {
                                    start();
                                    com.live.evo.widget.ijkmedia.a aVar2 = this.mMediaController;
                                    kotlin.jvm.internal.m.c(aVar2);
                                    aVar2.hide();
                                }
                                return true;
                            }
                            if (keyCode != 127) {
                                switch (keyCode) {
                                }
                            }
                        }
                        return q(event, true);
                    }
                    return q(event, false);
                }
                if (isPlaying()) {
                    pause();
                    com.live.evo.widget.ijkmedia.a aVar3 = this.mMediaController;
                    kotlin.jvm.internal.m.c(aVar3);
                    aVar3.show();
                }
                return true;
            }
            if (event.getRepeatCount() == 0) {
                return t();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        kotlin.jvm.internal.m.f(event, "event");
        if (keyCode == 24 || keyCode == 25 || keyCode == 82 || keyCode == 5 || keyCode == 6 || this.mMediaController == null || event.getAction() != 1) {
            return false;
        }
        com.live.evo.widget.ijkmedia.a aVar = this.mMediaController;
        kotlin.jvm.internal.m.c(aVar);
        if (aVar.b()) {
            return r();
        }
        return false;
    }

    public final void p() {
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            try {
                playerView.J(true);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        playerView.B();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int pos) {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        playerView.E(pos);
    }

    protected final void setMContext(Activity activity) {
        this.mContext = activity;
    }

    protected final void setMRT_RETRY_LIMIT(int i10) {
        this.MRT_RETRY_LIMIT = i10;
    }

    public final void setMediaController(com.live.evo.widget.ijkmedia.a controller) {
        this.mMediaController = controller;
        n();
    }

    public final void setPlayEventListener(b playEventListener) {
        this.mPlayEventListener = playEventListener;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        PlayerView playerView = this.mVideoView;
        kotlin.jvm.internal.m.c(playerView);
        playerView.G();
    }

    protected final void u() {
        TextView textView = this.mLoadingMsg;
        kotlin.jvm.internal.m.c(textView);
        textView.setText("");
        View view = this.mLoadingIcon;
        kotlin.jvm.internal.m.c(view);
        view.setVisibility(8);
        ViewGroup viewGroup = this.mLoadingHint;
        kotlin.jvm.internal.m.c(viewGroup);
        viewGroup.setVisibility(8);
        this.mIsLoadingViewVisible = false;
    }

    private final boolean t() {
        if (isPlaying()) {
            pause();
            com.live.evo.widget.ijkmedia.a aVar = this.mMediaController;
            kotlin.jvm.internal.m.c(aVar);
            aVar.a();
            u();
            return true;
        }
        start();
        com.live.evo.widget.ijkmedia.a aVar2 = this.mMediaController;
        kotlin.jvm.internal.m.c(aVar2);
        if (aVar2.isShowing()) {
            com.live.evo.widget.ijkmedia.a aVar3 = this.mMediaController;
            kotlin.jvm.internal.m.c(aVar3);
            aVar3.show();
        }
        getBufferedLeading();
        return true;
    }

    public final void getAndPlay() {
        kotlinx.coroutines.flow.f<x4.c> catchUpPlayInfo = getCatchUpPlayInfo();
        if (catchUpPlayInfo == null) {
            I(this.mContext, "no catchup play info provider!");
            b bVar = this.mPlayEventListener;
            if (bVar != null) {
                if (bVar != null) {
                    bVar.c(new RuntimeException("No play info provider!"));
                    return;
                }
                return;
            }
            I(this.mContext, "Prepare error,no play info provider!");
            return;
        }
        H(getConnectingMsg());
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new c(catchUpPlayInfo, this, null), 3, null);
    }

    protected int getLayoutId() {
        return R$layout.catch_up_video_view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.f(context, "context");
        q6.b bVarD = q6.c.d(k.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.MRT_RETRY_LIMIT = 100;
        this.mOnPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.live.evo.widget.a
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                k.D(this.f7568a, iMediaPlayer);
            }
        };
        this.mOnInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.live.evo.widget.b
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
                return k.C(this.f7569a, iMediaPlayer, i10, i11, str);
            }
        };
        this.mOnCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.live.evo.widget.c
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                k.A(this.f7570a, iMediaPlayer);
            }
        };
        this.mOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.live.evo.widget.d
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                return k.B(this.f7571a, iMediaPlayer, i10, i11);
            }
        };
        this.mOnSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.live.evo.widget.e
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
                k.E(iMediaPlayer);
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.live.evo.widget.f
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return k.z(this.f7572a, message);
            }
        });
        v(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(IMediaPlayer iMediaPlayer) {
    }

    protected void I(Context context, String message) {
    }
}
