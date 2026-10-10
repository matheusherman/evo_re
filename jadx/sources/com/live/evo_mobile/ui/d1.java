package com.live.evo_mobile.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.blankj.utilcode.util.ToastUtils;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$mipmap;
import com.live.evo.R$string;
import com.live.evo_mobile.ui.login.LoginTypeActivity;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import com.tvc.lib.mobile.ui.widget.MyVideoView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import u7.LiveSearchListData;
import u7.MessageEventData;
import u7.StoryListData;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u009b\u0001\u0018\u0000 ®\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002¯\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u0010J+\u0010&\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J#\u0010/\u001a\u00020\u00122\u0006\u0010,\u001a\u00020(2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u0010\u0005J!\u00102\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b2\u00103J3\u00104\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\r2\u0006\u00106\u001a\u00020\rH\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\rH\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\u0005J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\b¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bE\u0010FJ\u001d\u0010I\u001a\u00020H2\u0006\u0010,\u001a\u00020(2\u0006\u0010G\u001a\u00020\u0012¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\u00062\u0006\u0010D\u001a\u00020KH\u0007¢\u0006\u0004\bL\u0010MJ\u0017\u0010L\u001a\u00020\u00062\u0006\u0010D\u001a\u00020NH\u0007¢\u0006\u0004\bL\u0010OJ\u0017\u0010Q\u001a\u00020\u00062\u0006\u0010D\u001a\u00020PH\u0007¢\u0006\u0004\bQ\u0010RJ\u0015\u0010T\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\r¢\u0006\u0004\bT\u0010\u0010J\u0017\u0010V\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bV\u0010\u0015J\u000f\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020\u0006H\u0016¢\u0006\u0004\bX\u0010\u0005J\u000f\u0010Y\u001a\u00020\u0006H\u0016¢\u0006\u0004\bY\u0010\u0005J\u000f\u0010Z\u001a\u00020\rH\u0016¢\u0006\u0004\bZ\u0010:J\u000f\u0010[\u001a\u00020\u0006H\u0016¢\u0006\u0004\b[\u0010\u0005J\u0017\u0010]\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\bH\u0016¢\u0006\u0004\b]\u0010\u000bJ\u0017\u0010_\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b_\u0010\u0015R\u001c\u0010d\u001a\n a*\u0004\u0018\u00010`0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010i\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010fR\u0018\u0010m\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010fR\u0018\u0010p\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR*\u0010t\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020-\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u001e\u0010x\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u001e\u0010{\u001a\n\u0012\u0004\u0012\u00020y\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010wR\u0016\u0010~\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0080\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010}R\u0018\u0010\u0082\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010}R\u0019\u0010\u0085\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010}R\u0019\u0010\u0089\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0084\u0001R\u0019\u0010\u008b\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0084\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0084\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0092\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010}R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0019\u0010\u0098\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b<\u0010\u0097\u0001R\u001a\u0010\u009a\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0097\u0001R\u0018\u0010\u009e\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R!\u0010¤\u0001\u001a\u00030\u009f\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R\u001a\u0010¨\u0001\u001a\u00030¥\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001f\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030ª\u00010©\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001¨\u0006°\u0001"}, d2 = {"Lcom/live/evo_mobile/ui/d1;", "Lcom/tvc/lib/mobile/ui/base/d;", "Lz4/u0;", "", "<init>", "()V", "Lr8/z;", "T0", "", "increase", "O0", "(Z)V", "v1", "", "position", "u1", "(I)V", "i1", "", NotificationCompat.CATEGORY_MESSAGE, "z1", "(Ljava/lang/String;)V", "Lv7/c;", "dialog", "N0", "(Lv7/c;)V", "Lcom/tvc/lib/mobile/ui/widget/MyVideoView;", "videoView", "c1", "(Lcom/tvc/lib/mobile/ui/widget/MyVideoView;)V", "R0", "Y0", "index", "q1", "Landroidx/fragment/app/Fragment;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "tag", "w1", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "x1", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)V", "response", "Lz1/b1/lb/m/meta/EPGProgramme;", "epgProgramme", "C1", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;Lz1/b1/lb/m/meta/EPGProgramme;)Ljava/lang/String;", "o1", "n1", "(Lcom/tvc/lib/mobile/ui/widget/MyVideoView;Lz1/b1/lb/m/meta/ChannelStreamResponse;)V", "l1", "(Ljava/lang/Integer;Lz1/b1/lb/m/meta/ChannelStreamResponse;Lz1/b1/lb/m/meta/EPGProgramme;)V", "key", "B1", "(I)I", ExifInterface.LONGITUDE_WEST, "()I", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "y", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "g1", "()Z", "Lu7/h;", NotificationCompat.CATEGORY_EVENT, "onMessageEvent", "(Lu7/h;)V", "epgContent", "Lu7/f;", "y1", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;Ljava/lang/String;)Lu7/f;", "Lnf/d;", "OnEvent", "(Lnf/d;)V", "Lnf/b;", "(Lnf/b;)V", "Lnf/m;", "onEvent", "(Lnf/m;)V", "resId", "r1", "str", "s1", "onResume", "onPause", "onStop", "R", "onDestroy", "hidden", "onHiddenChanged", "streamId", "Q0", "Lq6/b;", "kotlin.jvm.PlatformType", "e", "Lq6/b;", "logger", "f", "Landroidx/fragment/app/Fragment;", "mCurrFragment", "g", "mChannelListFragment", "h", "mSubscribeFragment", "i", "mEpgListFragment", "j", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "lastChannelStreamResponse", "Lr8/u;", "k", "Lr8/u;", "lastCatchup", "", "l", "Ljava/util/List;", "channelList", "Lu7/i;", "m", "lastStoryList", "n", "Z", "isFullScreen", "o", "isFirstPlayAfterInit", "p", "isPause", "q", "I", "videoHeight", "r", "isChannelListInitComplete", "s", "mPreIndex", "t", "playType", "u", "playingEpgPos", "v", "Ljava/lang/String;", "playingEpgDateText", "w", "isHidden", "x", "Ljava/lang/Boolean;", "lastIsHidden", "", "J", "lastResumePlayTime", "z", "lastPlayVideoTime", "com/live/evo_mobile/ui/d1$g", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/live/evo_mobile/ui/d1$g;", "mH", "Landroid/media/AudioManager;", "B", "Lr8/i;", "S0", "()Landroid/media/AudioManager;", "audioManager", "Landroid/view/GestureDetector;", "C", "Landroid/view/GestureDetector;", "volumeGestureDetector", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "D", "Landroidx/activity/result/ActivityResultLauncher;", "jumpForResult", ExifInterface.LONGITUDE_EAST, "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d1 extends com.tvc.lib.mobile.ui.base.d<z4.u0> {

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private GestureDetector volumeGestureDetector;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> jumpForResult;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Fragment mCurrFragment;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Fragment mChannelListFragment;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Fragment mSubscribeFragment;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Fragment mEpgListFragment;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ChannelStreamResponse lastChannelStreamResponse;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private r8.u<Integer, ? extends ChannelStreamResponse, ? extends EPGProgramme> lastCatchup;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private List<? extends ChannelStreamResponse> channelList;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<StoryListData> lastStoryList;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isFullScreen;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isPause;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int videoHeight;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isChannelListInitComplete;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int mPreIndex;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean isHidden;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private Boolean lastIsHidden;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private long lastResumePlayTime;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private long lastPlayVideoTime;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(d1.class);

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstPlayAfterInit = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int playType = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int playingEpgPos = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private String playingEpgDateText = t.INSTANCE.b();

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final g mH = new g(Looper.getMainLooper());

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private final r8.i audioManager = r8.j.a(new c9.a() { // from class: com.live.evo_mobile.ui.a1
        @Override // c9.a
        public final Object invoke() {
            return d1.P0(this.f7874a);
        }
    });

    /* JADX INFO: renamed from: com.live.evo_mobile.ui.d1$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/live/evo_mobile/ui/d1$a;", "", "<init>", "()V", "Lcom/live/evo_mobile/ui/d1;", "a", "()Lcom/live/evo_mobile/ui/d1;", "", "CHANNEL_LAST_PLAY_STREAM_ID", "Ljava/lang/String;", "", "TYPE_PLAYBACK", "I", "TYPE_LIVE", "TYPE_SUBSCRIBE", "PLAYING_EPG_POS_DEFAULT", "PLAYING_EPG_POS_NONE", "PLAY_ACTION", "VOLUME_ACTION", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final d1 a() {
            return new d1();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/live/evo_mobile/ui/d1$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "distanceX", "distanceY", "", "onScroll", "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z", "e", "onSingleTapConfirmed", "(Landroid/view/MotionEvent;)Z", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e10, MotionEvent e11, float distanceX, float distanceY) {
            kotlin.jvm.internal.m.f(e11, "e2");
            if (d1.this.isFullScreen) {
                int i10 = d1.this.requireActivity().getApplication().getResources().getDisplayMetrics().widthPixels / 2;
                if (Math.abs(distanceY) > Math.abs(distanceX)) {
                    boolean z10 = distanceY > 0.0f;
                    int i11 = (e10 != null ? Float.valueOf(e10.getX()) : 0).intValue() < i10 ? 1 : 2;
                    if (d1.this.playType == 1 && i11 == 1) {
                        return false;
                    }
                    d1.this.mH.removeMessages(i11);
                    Message messageObtainMessage = d1.this.mH.obtainMessage(i11);
                    kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
                    messageObtainMessage.obj = Boolean.valueOf(z10);
                    d1.this.mH.sendMessageDelayed(messageObtainMessage, 100L);
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e10) {
            kotlin.jvm.internal.m.f(e10, "e");
            d1.this.T().f22996i.r0();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/d1$c", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements x1.f1.lb.util.m<Integer> {
        public void c(int v10) {
            if (v10 == 1) {
                d1.this.i1();
                return;
            }
            if (v10 == 3 || v10 == 4) {
                String string = d1.this.getString(t.v.c.i.a.f18646a.i().length() == 0 ? 2131952588 : 2131952137);
                kotlin.jvm.internal.m.e(string, "getString(...)");
                d1.this.z1(string);
            } else {
                if (v10 != 5) {
                    return;
                }
                FragmentActivity activity = d1.this.getActivity();
                if (activity instanceof MainViewActivity) {
                    ((MainViewActivity) activity).g0();
                }
            }
        }

        c() {
        }

        @Override // x1.f1.lb.util.m
        public /* bridge */ /* synthetic */ void a(Integer num) {
            c(num.intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo_mobile/ui/d1$d", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lr8/z;", "onGlobalLayout", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d1 d1Var = d1.this;
            d1Var.videoHeight = d1Var.T().f22996i.getHeight();
            d1.this.T().f22996i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo_mobile/ui/d1$e", "Lcom/live/evo_mobile/adapter/n$a;", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "", "position", "Lr8/z;", "a", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements com.live.evo_mobile.adapter.n.a {
        e() {
        }

        @Override // com.live.evo_mobile.adapter.n.a
        public void a(ChannelStreamResponse response, int position) {
            kotlin.jvm.internal.m.f(response, "response");
            d1 d1Var = d1.this;
            d1Var.mPreIndex = !(d1Var.mCurrFragment instanceof n) ? 1 : 0;
            Fragment fragment = d1.this.mChannelListFragment;
            kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo_mobile.ui.ChannelListFragment");
            if (kotlin.jvm.internal.m.a(((n) fragment).u0(), response.getStreamId())) {
                Fragment fragment2 = d1.this.mEpgListFragment;
                kotlin.jvm.internal.m.d(fragment2, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
                ((t) fragment2).J0(d1.this.playingEpgPos);
                Fragment fragment3 = d1.this.mEpgListFragment;
                kotlin.jvm.internal.m.d(fragment3, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
                ((t) fragment3).I0(d1.this.playingEpgDateText);
            } else {
                Fragment fragment4 = d1.this.mEpgListFragment;
                kotlin.jvm.internal.m.d(fragment4, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
                ((t) fragment4).J0(-2);
                Fragment fragment5 = d1.this.mEpgListFragment;
                kotlin.jvm.internal.m.d(fragment5, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
                ((t) fragment5).I0(t.INSTANCE.a());
            }
            Fragment fragment6 = d1.this.mEpgListFragment;
            kotlin.jvm.internal.m.d(fragment6, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
            ((t) fragment6).G0(response);
            Fragment fragment7 = d1.this.mEpgListFragment;
            kotlin.jvm.internal.m.d(fragment7, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
            ((t) fragment7).D0();
            d1.this.T().f22995h.setText(d1.D1(d1.this, response, null, 2, null));
            d1.this.q1(2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/live/evo_mobile/ui/d1$f", "Lcom/live/evo_mobile/ui/t$b;", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "Lz1/b1/lb/m/meta/EPGProgramme;", "epgProgramme", "", IjkMediaMeta.IJKM_KEY_TYPE, "position", "Lr8/z;", "a", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;Lz1/b1/lb/m/meta/EPGProgramme;II)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements t.b {
        f() {
        }

        @Override // com.live.evo_mobile.ui.t.b
        public void a(ChannelStreamResponse response, EPGProgramme epgProgramme, int type, int position) {
            kotlin.jvm.internal.m.f(response, "response");
            kotlin.jvm.internal.m.f(epgProgramme, "epgProgramme");
            if (type != 1) {
                return;
            }
            try {
                r8.u uVar = d1.this.lastCatchup;
                if (kotlin.jvm.internal.m.a(uVar != null ? (ChannelStreamResponse) uVar.e() : null, response)) {
                    r8.u uVar2 = d1.this.lastCatchup;
                    if (kotlin.jvm.internal.m.a(uVar2 != null ? (EPGProgramme) uVar2.f() : null, epgProgramme) && d1.this.playType == 1 && d1.this.T().f22996i.getViewBinding().f17385d.z()) {
                        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                        String string = d1.this.getString(R$string.is_playing);
                        kotlin.jvm.internal.m.e(string, "getString(...)");
                        g1Var.e(string);
                        return;
                    }
                }
                if (y4.a.f22397a.booleanValue()) {
                    d1.this.logger.a("start_catchup", new Object[0]);
                }
                d1.this.l1(Integer.valueOf(position), response, epgProgramme);
            } catch (Exception e10) {
                d1.this.logger.error("play failure", e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo_mobile/ui/d1$g", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g extends Handler {
        g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            super.handleMessage(msg);
            int i10 = msg.what;
            if (i10 == 1) {
                Object obj = msg.obj;
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
                d1.this.v1(((Boolean) obj).booleanValue());
                return;
            }
            if (i10 != 2) {
                return;
            }
            Object obj2 = msg.obj;
            kotlin.jvm.internal.m.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            d1.this.O0(((Boolean) obj2).booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.MainTVFragment$onEvent$dialog$1$1", f = "MainTVFragment.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ ChannelStreamResponse $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(ChannelStreamResponse channelStreamResponse, v8.f<? super h> fVar) {
            super(2, fVar);
            this.$response = channelStreamResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return d1.this.new h(this.$response, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((h) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            MainViewActivity mainViewActivity;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                FragmentActivity activity = d1.this.getActivity();
                if (activity instanceof MainViewActivity) {
                    mainViewActivity = (MainViewActivity) activity;
                } else {
                    mainViewActivity = null;
                }
                if (mainViewActivity != null) {
                    mainViewActivity.b0();
                }
                if (d1.this.mChannelListFragment != null) {
                    Fragment fragment = d1.this.mChannelListFragment;
                    kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo_mobile.ui.ChannelListFragment");
                    ((n) fragment).q0(this.$response);
                }
                d1.this.x1(this.$response);
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.MainTVFragment$playCatchup$1", f = "MainTVFragment.kt", l = {956}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class i extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ ChannelStreamResponse $channel;
        final /* synthetic */ EPGProgramme $epg;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.MainTVFragment$playCatchup$1$1", f = "MainTVFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ d1 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d1 d1Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = d1Var;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                return new a(this.this$0, fVar).invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.this$0.lastCatchup = null;
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f7921a = new b<>();

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                return r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }

            b() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(ChannelStreamResponse channelStreamResponse, EPGProgramme ePGProgramme, v8.f<? super i> fVar) {
            super(2, fVar);
            this.$channel = channelStreamResponse;
            this.$epg = ePGProgramme;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return d1.this.new i(this.$channel, this.$epg, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((i) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(d1.this.T().f22996i.getViewBinding().f17385d.I(this.$channel, this.$epg), new a(d1.this, null));
                    kotlinx.coroutines.flow.g gVar = b.f7921a;
                    this.label = 1;
                    if (fVarF.collect(gVar, this) == objC) {
                        return objC;
                    }
                }
            } catch (Exception e10) {
                d1.this.logger.error("play failure", e10);
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.MainTVFragment$playVideo$1", f = "MainTVFragment.kt", l = {917}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ ChannelStreamResponse $response;
        final /* synthetic */ MyVideoView $videoView;
        int label;
        final /* synthetic */ d1 this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.MainTVFragment$playVideo$1$1", f = "MainTVFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                return new a(fVar).invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ChannelStreamResponse f7922a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d1 f7923b;

            b(ChannelStreamResponse channelStreamResponse, d1 d1Var) {
                this.f7922a = channelStreamResponse;
                this.f7923b = d1Var;
            }

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                com.tvc.lib.mobile.ui.base.a.INSTANCE.b(this.f7922a.getStreamId());
                if (!this.f7923b.isFirstPlayAfterInit) {
                    this.f7923b.isFirstPlayAfterInit = false;
                }
                return r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(ChannelStreamResponse channelStreamResponse, MyVideoView myVideoView, d1 d1Var, v8.f<? super j> fVar) {
            super(2, fVar);
            this.$response = channelStreamResponse;
            this.$videoView = myVideoView;
            this.this$0 = d1Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new j(this.$response, this.$videoView, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((j) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                x1.f1.lb.util.a1.i(x1.f1.lb.util.a1.f21305a, "LIVE_PLAYER_ZAPPING_TIME", "2." + this.$response.getStreamId() + ".video_view_start", false, 4, null);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(this.$videoView.getViewBinding().f17385d.H(this.$response), new a(null));
                b bVar = new b(this.$response, this.this$0);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(boolean increase) {
        S0().adjustStreamVolume(3, increase ? 1 : -1, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x0073  */
    public final void l1(Integer position, ChannelStreamResponse response, EPGProgramme epgProgramme) {
        boolean z10;
        if (position == null) {
            r8.u<Integer, ? extends ChannelStreamResponse, ? extends EPGProgramme> uVar = this.lastCatchup;
            position = uVar != null ? uVar.d() : null;
            if (position == null) {
                return;
            }
        }
        int iIntValue = position.intValue();
        if (response == null) {
            r8.u<Integer, ? extends ChannelStreamResponse, ? extends EPGProgramme> uVar2 = this.lastCatchup;
            response = uVar2 != null ? uVar2.e() : null;
            if (response == null) {
                return;
            }
        }
        if (epgProgramme == null) {
            r8.u<Integer, ? extends ChannelStreamResponse, ? extends EPGProgramme> uVar3 = this.lastCatchup;
            epgProgramme = uVar3 != null ? uVar3.f() : null;
            if (epgProgramme == null) {
                return;
            }
        }
        r8.u<Integer, ? extends ChannelStreamResponse, ? extends EPGProgramme> uVar4 = this.lastCatchup;
        if (uVar4 == null || iIntValue != uVar4.d().intValue()) {
            this.lastCatchup = new r8.u<>(Integer.valueOf(iIntValue), response, epgProgramme);
            z10 = true;
        } else {
            r8.u<Integer, ? extends ChannelStreamResponse, ? extends EPGProgramme> uVar5 = this.lastCatchup;
            if (kotlin.jvm.internal.m.a(response, uVar5 != null ? uVar5.e() : null)) {
                r8.u<Integer, ? extends ChannelStreamResponse, ? extends EPGProgramme> uVar6 = this.lastCatchup;
                if (kotlin.jvm.internal.m.a(epgProgramme, uVar6 != null ? uVar6.f() : null)) {
                    z10 = false;
                } else {
                    this.lastCatchup = new r8.u<>(Integer.valueOf(iIntValue), response, epgProgramme);
                    z10 = true;
                }
            } else {
                this.lastCatchup = new r8.u<>(Integer.valueOf(iIntValue), response, epgProgramme);
                z10 = true;
            }
        }
        this.playType = 1;
        this.playingEpgPos = iIntValue;
        Fragment fragment = this.mEpgListFragment;
        kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
        this.playingEpgDateText = ((t) fragment).getPlayingEpgDateText();
        Fragment fragment2 = this.mEpgListFragment;
        kotlin.jvm.internal.m.d(fragment2, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
        ((t) fragment2).s0(this.playingEpgPos);
        T().f22996i.setPlayBackMode(true);
        T().f22996i.o0(z10);
        T().f22996i.getViewBinding().f17405x.setText(C1(response, epgProgramme));
        this.lastPlayVideoTime = x1.f1.lb.util.d1.c();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new i(response, epgProgramme, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(int index) {
        if (index == 0) {
            w1(this.mCurrFragment, this.mChannelListFragment, T().f22997j.getText().toString());
            this.mCurrFragment = this.mChannelListFragment;
            T().f22997j.setTypeface(null, 1);
            T().f22998k.setTypeface(null, 0);
            return;
        }
        if (index == 1) {
            w1(this.mCurrFragment, this.mSubscribeFragment, T().f22997j.getText().toString());
            this.mCurrFragment = this.mSubscribeFragment;
            T().f22997j.setTypeface(null, 0);
            T().f22998k.setTypeface(null, 1);
            return;
        }
        if (index != 2) {
            return;
        }
        w1(this.mCurrFragment, this.mEpgListFragment, T().f22997j.getText().toString());
        this.mCurrFragment = this.mEpgListFragment;
        T().f22994g.setVisibility(0);
        T().f22993f.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(String str) {
        ToastUtils.t(str, new Object[0]);
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.d event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (event.d()) {
            Fragment fragment = this.mChannelListFragment;
            if ((fragment instanceof n) && n.w0((n) fragment, null, 1, null)) {
                this.isChannelListInitComplete = true;
            }
        } else if (!this.isChannelListInitComplete && getContext() != null) {
            ToastUtils.r(getString(2131952014) + "\n" + event.c(), new Object[0]);
        }
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z A1(d1 d1Var) {
        d1Var.startActivity(new Intent(d1Var.getActivity(), (Class<?>) LoginTypeActivity.class));
        return r8.z.f17874a;
    }

    private final int B1(int key) {
        boolean zL0 = t.v.c.i.a.f18646a.L0(key);
        if (zL0) {
            com.tvc.lib.mobile.ext.h.f(getString(2131952453), S());
        } else {
            com.tvc.lib.mobile.ext.h.f(getString(2131952458), S());
        }
        if (zL0) {
            return R$mipmap.main_home_video_love2;
        }
        return 2131755034;
    }

    private final String C1(ChannelStreamResponse response, EPGProgramme epgProgramme) {
        if (epgProgramme == null) {
            return t.v.c.i.a.f18646a.b(response) + " " + response.getStreamName();
        }
        return t.v.c.i.a.f18646a.b(response) + " " + response.getStreamName() + "\n" + epgProgramme.getTitle();
    }

    static /* synthetic */ String D1(d1 d1Var, ChannelStreamResponse channelStreamResponse, EPGProgramme ePGProgramme, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            ePGProgramme = null;
        }
        return d1Var.C1(channelStreamResponse, ePGProgramme);
    }

    private final void R0() {
        if (this.isFullScreen) {
            S().setRequestedOrientation(1);
            T().f22996i.getViewBinding().f17399r.setVisibility(8);
        } else {
            S().setRequestedOrientation(0);
        }
        this.isFullScreen = !this.isFullScreen;
        T().f22996i.setFullScreenModel(this.isFullScreen);
    }

    private final AudioManager S0() {
        return (AudioManager) this.audioManager.getValue();
    }

    private final void T0() {
        this.volumeGestureDetector = new GestureDetector(requireContext(), new b());
        T().f22996i.setOnTouchListener(new View.OnTouchListener() { // from class: com.live.evo_mobile.ui.u0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return d1.U0(this.f8202a, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U0(d1 d1Var, View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector = d1Var.volumeGestureDetector;
        if (gestureDetector == null) {
            kotlin.jvm.internal.m.v("volumeGestureDetector");
            gestureDetector = null;
        }
        if (!gestureDetector.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            view.performClick();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z W0(d1 d1Var, p7.g gVar, View it) {
        kotlin.jvm.internal.m.f(it, "it");
        if (!kotlin.jvm.internal.m.a(it, d1Var.T().f22996i)) {
            if (kotlin.jvm.internal.m.a(it, d1Var.T().f22999l)) {
                d1Var.jumpForResult.launch(new Intent(d1Var.getActivity(), (Class<?>) SearchLiveActivity.class));
            } else if (kotlin.jvm.internal.m.a(it, gVar.f17392k)) {
                ChannelStreamResponse channelStreamResponse = d1Var.lastChannelStreamResponse;
                if (channelStreamResponse == null) {
                    String string = d1Var.getString(2131952000);
                    kotlin.jvm.internal.m.e(string, "getString(...)");
                    com.tvc.lib.mobile.ext.h.e(string, d1Var.S());
                    return r8.z.f17874a;
                }
                AppCompatImageView appCompatImageView = gVar.f17392k;
                kotlin.jvm.internal.m.c(channelStreamResponse);
                appCompatImageView.setImageResource(d1Var.B1(channelStreamResponse.getKey()));
                com.tvc.lib.mobile.ext.f.b(4113, null, null, 6, null);
                d1Var.T().f22996i.q0();
            } else if (kotlin.jvm.internal.m.a(it, gVar.f17391j) || kotlin.jvm.internal.m.a(it, gVar.f17390i)) {
                d1Var.T().f22996i.q0();
                d1Var.R0();
            } else if (!kotlin.jvm.internal.m.a(it, gVar.f17406y)) {
                kotlin.jvm.internal.m.a(it, gVar.f17403v);
            }
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(d1 d1Var, g0.d adapter, View view, int i10) {
        kotlin.jvm.internal.m.f(adapter, "adapter");
        kotlin.jvm.internal.m.f(view, "view");
        d1Var.u1(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z b1(d1 d1Var) {
        if (d1Var.playType == 1) {
            MyVideoView myVideoView = d1Var.T().f22996i;
            kotlin.jvm.internal.m.e(myVideoView, "myVideoView");
            d1Var.n1(myVideoView, d1Var.lastChannelStreamResponse);
        }
        return r8.z.f17874a;
    }

    private final void c1(final MyVideoView videoView) {
        videoView.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() { // from class: com.live.evo_mobile.ui.q0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                d1.d1(this.f8166a, videoView, iMediaPlayer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(final d1 d1Var, final MyVideoView myVideoView, IMediaPlayer iMediaPlayer) {
        if (d1Var.playType == 1) {
            Context context = d1Var.getContext();
            v7.c cVar = new v7.c(context != null ? context.getString(R$string.catchup_finished_hint) : null, new c9.a() { // from class: com.live.evo_mobile.ui.t0
                @Override // c9.a
                public final Object invoke() {
                    return d1.e1(this.f8197a, myVideoView);
                }
            });
            cVar.f0(false);
            cVar.b0();
            cVar.a0();
            FragmentManager childFragmentManager = d1Var.getChildFragmentManager();
            kotlin.jvm.internal.m.e(childFragmentManager, "getChildFragmentManager(...)");
            cVar.X(childFragmentManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z e1(d1 d1Var, MyVideoView myVideoView) {
        if (d1Var.playType == 1) {
            d1Var.n1(myVideoView, d1Var.lastChannelStreamResponse);
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1() {
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        if (aVar.Z().length() != 0) {
            String string = getString(2131952077);
            kotlin.jvm.internal.m.e(string, "getString(...)");
            v7.c cVar = new v7.c(string, new c9.a() { // from class: com.live.evo_mobile.ui.p0
                @Override // c9.a
                public final Object invoke() {
                    return d1.k1(this.f8164a);
                }
            });
            String string2 = getString(2131953061);
            kotlin.jvm.internal.m.e(string2, "getString(...)");
            cVar.setTitle(string2);
            N0(cVar);
            FragmentManager childFragmentManager = getChildFragmentManager();
            kotlin.jvm.internal.m.e(childFragmentManager, "getChildFragmentManager(...)");
            cVar.X(childFragmentManager);
            return;
        }
        if (aVar.i().length() != 0) {
            String string3 = getString(2131952588);
            kotlin.jvm.internal.m.e(string3, "getString(...)");
            z1(string3);
            return;
        }
        int iT = aVar.T();
        String string4 = iT > 1 ? getString(2131951942, Integer.valueOf(iT)) : getString(2131951940);
        kotlin.jvm.internal.m.c(string4);
        v7.c cVar2 = new v7.c(string4, new c9.a() { // from class: com.live.evo_mobile.ui.o0
            @Override // c9.a
            public final Object invoke() {
                return d1.j1(this.f8162a);
            }
        });
        String string5 = getString(2131953060);
        kotlin.jvm.internal.m.e(string5, "getString(...)");
        cVar2.setTitle(string5);
        N0(cVar2);
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        kotlin.jvm.internal.m.e(childFragmentManager2, "getChildFragmentManager(...)");
        cVar2.X(childFragmentManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z j1(d1 d1Var) {
        Intent intent = new Intent(d1Var.getActivity(), (Class<?>) LoginTypeActivity.class);
        intent.putExtra("loginFrom", 3);
        d1Var.startActivity(intent);
        return r8.z.f17874a;
    }

    static /* synthetic */ void m1(d1 d1Var, Integer num, ChannelStreamResponse channelStreamResponse, EPGProgramme ePGProgramme, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            channelStreamResponse = null;
        }
        if ((i10 & 4) != 0) {
            ePGProgramme = null;
        }
        d1Var.l1(num, channelStreamResponse, ePGProgramme);
    }

    private final void n1(MyVideoView videoView, ChannelStreamResponse response) {
        if (response == null) {
            return;
        }
        if (!response.c()) {
            videoView.getViewBinding().f17392k.setEnabled(true);
            videoView.getViewBinding().f17392k.setImageResource(t.v.c.i.a.f18646a.m0(response.getKey()) ? R$mipmap.main_home_video_love2 : 2131755034);
        } else {
            if (!u5.i.INSTANCE.a()) {
                if (y4.a.f22397a.booleanValue()) {
                    this.logger.debug("playVideo " + response.getStreamId() + " ignored", new Object[0]);
                    return;
                }
                return;
            }
            videoView.getViewBinding().f17392k.setEnabled(false);
            videoView.getViewBinding().f17392k.setImageResource(R$mipmap.main_home_video_love3);
        }
        videoView.getViewBinding().f17405x.setText(D1(this, response, null, 2, null));
        this.playType = 2;
        videoView.setPlayBackMode(false);
        MyVideoView.p0(videoView, false, 1, null);
        this.lastPlayVideoTime = x1.f1.lb.util.d1.c();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new j(response, videoView, this, null), 3, null);
    }

    private final void o1() {
        if (this.isHidden) {
            return;
        }
        long jC = x1.f1.lb.util.d1.c();
        if (jC < this.lastResumePlayTime + ((long) 2000)) {
            return;
        }
        this.lastResumePlayTime = jC;
        this.mH.postDelayed(new Runnable() { // from class: com.live.evo_mobile.ui.m0
            @Override // java.lang.Runnable
            public final void run() {
                d1.p1(this.f8129a);
            }
        }, 600L);
    }

    private final void u1(int position) {
        List<? extends ChannelStreamResponse> list = this.channelList;
        if (list != null && position >= 0 && position < list.size()) {
            ChannelStreamResponse channelStreamResponse = list.get(position);
            n nVar = (n) this.mChannelListFragment;
            if (nVar != null) {
                nVar.q0(channelStreamResponse);
            }
            x1(channelStreamResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:4:0x0006  */
    public final void v1(boolean increase) {
        int size;
        if (this.lastChannelStreamResponse != null) {
            List<? extends ChannelStreamResponse> list = this.channelList;
            if (list == null) {
                size = -1;
            } else {
                int size2 = list.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size2) {
                        size = 0;
                        break;
                    }
                    String streamId = list.get(i10).getStreamId();
                    ChannelStreamResponse channelStreamResponse = this.lastChannelStreamResponse;
                    if (kotlin.jvm.internal.m.a(streamId, channelStreamResponse != null ? channelStreamResponse.getStreamId() : null)) {
                        size = increase ? i10 + 1 : i10 - 1;
                        break;
                    }
                    i10++;
                }
                if (size < 0) {
                    size = 0;
                } else if (size >= list.size()) {
                    size = list.size() - 1;
                }
            }
        } else {
            size = 0;
        }
        RecyclerView recyclerView = T().f22996i.getViewBinding().f17399r;
        kotlin.jvm.internal.m.c(recyclerView);
        if (recyclerView.getVisibility() == 8) {
            recyclerView.setVisibility(0);
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        kotlin.jvm.internal.m.d(adapter, "null cannot be cast to non-null type com.live.evo_mobile.adapter.LiveSearchAdapter");
        com.live.evo_mobile.adapter.g gVar = (com.live.evo_mobile.adapter.g) adapter;
        int i11 = 0;
        for (LiveSearchListData liveSearchListData : gVar.m()) {
            int i12 = i11 + 1;
            if (i11 == size) {
                liveSearchListData.a(true);
                gVar.notifyItemChanged(i11);
            } else if (liveSearchListData.getSelected()) {
                liveSearchListData.a(false);
                gVar.notifyItemChanged(i11);
            }
            i11 = i12;
        }
        if (size > 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            kotlin.jvm.internal.m.d(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(size - 1, 0);
        } else {
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 != null) {
                layoutManager2.scrollToPosition(Math.max(size, 0));
            }
        }
        u1(size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(ChannelStreamResponse channel) {
        this.lastChannelStreamResponse = channel;
        x1.f1.lb.util.w0 w0Var = x1.f1.lb.util.w0.f21452a;
        String streamId = channel.getStreamId();
        kotlin.jvm.internal.m.e(streamId, "getStreamId(...)");
        w0Var.t("last_play_stream_id", streamId);
        Fragment fragment = this.mChannelListFragment;
        if (fragment != null) {
            kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo_mobile.ui.ChannelListFragment");
            String streamId2 = channel.getStreamId();
            kotlin.jvm.internal.m.e(streamId2, "getStreamId(...)");
            ((n) fragment).J0(streamId2);
        }
        MyVideoView myVideoView = T().f22996i;
        kotlin.jvm.internal.m.e(myVideoView, "myVideoView");
        n1(myVideoView, channel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(String msg) {
        v7.c cVar = new v7.c(msg, new c9.a() { // from class: com.live.evo_mobile.ui.r0
            @Override // c9.a
            public final Object invoke() {
                return d1.A1(this.f8171a);
            }
        });
        String string = getString(2131953058);
        kotlin.jvm.internal.m.e(string, "getString(...)");
        cVar.setTitle(string);
        N0(cVar);
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.m.e(childFragmentManager, "getChildFragmentManager(...)");
        cVar.X(childFragmentManager);
    }

    public final void Q0(String streamId) {
        if (!(this.mCurrFragment instanceof n)) {
            RelativeLayout mainRl = T().f22994g;
            kotlin.jvm.internal.m.e(mainRl, "mainRl");
            if (mainRl.getVisibility() == 0) {
                T().f22994g.setVisibility(8);
                T().f22993f.setVisibility(0);
                q1(0);
            } else {
                T().f22993f.check(R$id.rb_channel);
            }
        }
        if (streamId != null) {
            Fragment fragment = this.mChannelListFragment;
            kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo_mobile.ui.ChannelListFragment");
            ((n) fragment).z0(streamId);
        }
    }

    public final boolean g1() {
        if (!this.isFullScreen) {
            return false;
        }
        R0();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.m.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation != 1) {
            T().f22996i.getLayoutParams().height = -1;
            T().f22996i.getLayoutParams().height = -1;
            T().f22990c.setVisibility(8);
            T().f22993f.setVisibility(8);
            T().f22989b.setVisibility(8);
            return;
        }
        T().f22996i.getLayoutParams().height = this.videoHeight;
        T().f22990c.setVisibility(0);
        if (kotlin.jvm.internal.m.a(this.mCurrFragment, this.mEpgListFragment)) {
            T().f22993f.setVisibility(4);
        } else {
            T().f22993f.setVisibility(0);
        }
        T().f22989b.setVisibility(0);
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.m event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (this.isPause) {
            this.logger.warn("activity is paused, can't display the subscribe event[{}]", event);
            return;
        }
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        final ChannelStreamResponse channelStreamResponseK = aVar.k(event.getKey());
        if (channelStreamResponseK == null) {
            this.logger.warn("no stream to display the subscribe event[{}]", event);
            return;
        }
        String streamId = channelStreamResponseK.getStreamId();
        ChannelStreamResponse channelStreamResponse = this.lastChannelStreamResponse;
        if (kotlin.jvm.internal.m.a(streamId, channelStreamResponse != null ? channelStreamResponse.getStreamId() : null)) {
            r1(2131953020);
            return;
        }
        if (!(aVar.e0() && u5.i.INSTANCE.a()) && (channelStreamResponseK.getType() == 1 || channelStreamResponseK.getType() == 3)) {
            r1(2131953005);
            this.logger.warn("family mode should not display the adult subscribe event[{}]", event);
            return;
        }
        String strH = x1.f1.lb.util.n.n().h(1, event.e());
        x1.f1.lb.util.n nVarN = x1.f1.lb.util.n.n();
        Long lF = event.f();
        kotlin.jvm.internal.m.e(lF, "getStopTime(...)");
        String strH2 = nVarN.h(1, lF.longValue());
        String strD = event.d();
        v7.c cVar = new v7.c(event.c() + "\n" + strH + " -- " + strH2 + ": " + strD, new c9.a() { // from class: com.live.evo_mobile.ui.c1
            @Override // c9.a
            public final Object invoke() {
                return d1.h1(this.f7883a, channelStreamResponseK);
            }
        });
        String string = getString(2131953028);
        kotlin.jvm.internal.m.e(string, "getString(...)");
        cVar.setTitle(string);
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.m.e(childFragmentManager, "getChildFragmentManager(...)");
        cVar.X(childFragmentManager);
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(MessageEventData event) {
        ChannelStreamResponse channelStreamResponse;
        kotlin.jvm.internal.m.f(event, "event");
        if (event.getCode() == 65552 || event.getCode() == 65554) {
            Object data = event.getData();
            kotlin.jvm.internal.m.d(data, "null cannot be cast to non-null type kotlin.collections.List<com.tvc.lib.mobile.model.StoryListData>");
            List<StoryListData> list = (List) data;
            String msg = event.getMsg();
            Integer numN = msg != null ? ua.n.n(msg) : null;
            if (numN == null || numN.intValue() < 0 || numN.intValue() >= list.size()) {
                this.logger.warn("channel[" + event.getMsg() + "] not found in list", new Object[0]);
                return;
            }
            if (!kotlin.jvm.internal.m.a(this.lastStoryList, list)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (StoryListData storyListData : list) {
                    arrayList.add(storyListData.getResponse());
                    arrayList2.add(y1(storyListData.getResponse(), storyListData.getEpgContent()));
                }
                this.channelList = arrayList;
                this.lastStoryList = list;
                RecyclerView.Adapter adapter = T().f22996i.getViewBinding().f17399r.getAdapter();
                kotlin.jvm.internal.m.d(adapter, "null cannot be cast to non-null type com.live.evo_mobile.adapter.LiveSearchAdapter");
                ((com.live.evo_mobile.adapter.g) adapter).U(arrayList2, numN);
            }
            List<? extends ChannelStreamResponse> list2 = this.channelList;
            if (list2 == null || (channelStreamResponse = list2.get(numN.intValue())) == null) {
                return;
            }
            ChannelStreamResponse channelStreamResponse2 = this.lastChannelStreamResponse;
            if (channelStreamResponse2 != null && channelStreamResponse.getKey() == channelStreamResponse2.getKey() && this.playType == 2) {
                if (event.getCode() == 65554) {
                    x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                    String string = getString(R$string.is_playing);
                    kotlin.jvm.internal.m.e(string, "getString(...)");
                    g1Var.e(string);
                }
            } else {
                x1(channelStreamResponse);
            }
        }
    }

    public final void s1(final String str) {
        this.mH.post(new Runnable() { // from class: com.live.evo_mobile.ui.n0
            @Override // java.lang.Runnable
            public final void run() {
                d1.t1(str);
            }
        });
    }

    public final LiveSearchListData y1(ChannelStreamResponse response, String epgContent) {
        kotlin.jvm.internal.m.f(response, "response");
        kotlin.jvm.internal.m.f(epgContent, "epgContent");
        String streamName = response.getStreamName();
        kotlin.jvm.internal.m.e(streamName, "getStreamName(...)");
        String iconUrl = response.getIconUrl();
        kotlin.jvm.internal.m.e(iconUrl, "getIconUrl(...)");
        String streamId = response.getStreamId();
        kotlin.jvm.internal.m.e(streamId, "getStreamId(...)");
        return new LiveSearchListData(streamName, iconUrl, streamId, response.getKey(), t.v.c.i.a.f18646a.b(response), epgContent, false, 64, null);
    }

    public d1() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.live.evo_mobile.ui.b1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                d1.f1(this.f7878a, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.m.e(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.jumpForResult = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioManager P0(d1 d1Var) {
        Object systemService = d1Var.requireContext().getSystemService("audio");
        kotlin.jvm.internal.m.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(d1 d1Var, RadioGroup radioGroup, int i10) {
        switch (i10) {
            case R$id.rb_channel /* 2131429046 */:
                d1Var.q1(0);
                break;
            case R$id.rb_favorite /* 2131429047 */:
                d1Var.q1(1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(d1 d1Var, View view) {
        d1Var.T().f22994g.setVisibility(8);
        d1Var.T().f22993f.setVisibility(0);
        d1Var.q1(d1Var.mPreIndex);
    }

    private final void Y0() {
        RecyclerView recyclerView = T().f22996i.getViewBinding().f17399r;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        com.live.evo_mobile.adapter.g gVar = new com.live.evo_mobile.adapter.g();
        recyclerView.setAdapter(gVar);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new com.tvc.lib.mobile.ui.widget.q(0, 0, z7.p.a(0, requireActivity()), 0));
        }
        gVar.C(new g0.d.InterfaceC0181d() { // from class: com.live.evo_mobile.ui.v0
            @Override // g0.d.InterfaceC0181d
            public final void b(g0.d dVar, View view, int i10) {
                d1.Z0(this.f8205a, dVar, view, i10);
            }
        });
        T().f22996i.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.live.evo_mobile.ui.w0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                return d1.a1(this.f8207a, iMediaPlayer, i10, i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a1(final d1 d1Var, IMediaPlayer iMediaPlayer, int i10, int i11) {
        if (d1Var.T().f22996i.getIsPlayBack()) {
            String strB = z7.p.b(R$string.mb_catchup_play_error);
            String strB2 = z7.p.b(R$string.error_message);
            kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
            String str = String.format("%d - %d", Arrays.copyOf(new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}, 2));
            kotlin.jvm.internal.m.e(str, "format(...)");
            v7.c cVar = new v7.c(ua.n.j("\n                    " + strB + "\n                    " + strB2 + "\n                    " + str + "\n                    "), new c9.a() { // from class: com.live.evo_mobile.ui.s0
                @Override // c9.a
                public final Object invoke() {
                    return d1.b1(this.f8174a);
                }
            });
            cVar.b0();
            cVar.a0();
            FragmentManager childFragmentManager = d1Var.getChildFragmentManager();
            kotlin.jvm.internal.m.e(childFragmentManager, "getChildFragmentManager(...)");
            cVar.X(childFragmentManager);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(d1 d1Var, ActivityResult activityResult) {
        String stringExtra;
        if (activityResult.getResultCode() == 3 && activityResult.getData() != null) {
            Intent data = activityResult.getData();
            if (data != null) {
                stringExtra = data.getStringExtra("channelId");
            } else {
                stringExtra = null;
            }
            d1Var.Q0(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z h1(d1 d1Var, ChannelStreamResponse channelStreamResponse) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, d1Var.new h(channelStreamResponse, null), 3, null);
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z k1(d1 d1Var) {
        MainViewActivity mainViewActivity;
        FragmentActivity activity = d1Var.getActivity();
        if (activity instanceof MainViewActivity) {
            mainViewActivity = (MainViewActivity) activity;
        } else {
            mainViewActivity = null;
        }
        if (mainViewActivity != null) {
            mainViewActivity.c0();
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(d1 d1Var) {
        if (x1.f1.lb.util.d1.c() >= d1Var.lastPlayVideoTime + ((long) 2000)) {
            if (d1Var.playType != 1 || !d1Var.T().f22996i.c0()) {
                if (d1Var.playType == 1 && d1Var.lastCatchup != null) {
                    m1(d1Var, null, null, null, 7, null);
                    return;
                }
                ChannelStreamResponse channelStreamResponse = d1Var.lastChannelStreamResponse;
                if (channelStreamResponse != null) {
                    MyVideoView myVideoView = d1Var.T().f22996i;
                    kotlin.jvm.internal.m.e(myVideoView, "myVideoView");
                    d1Var.n1(myVideoView, channelStreamResponse);
                }
            }
        }
    }

    private final void w1(Fragment from, Fragment to, String tag) {
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        if (to != null && to.isAdded()) {
            if (from != null) {
                fragmentTransactionBeginTransaction.hide(from);
            }
            fragmentTransactionBeginTransaction.show(to).commit();
        } else {
            if (from != null) {
                fragmentTransactionBeginTransaction.hide(from);
            }
            if (to != null) {
                fragmentTransactionBeginTransaction.add(2131427772, to, tag).commit();
            }
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int R() {
        return R$color.color_focused;
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void V() {
        T().f22996i.getViewTreeObserver().addOnGlobalLayoutListener(new d());
        Y0();
        this.mChannelListFragment = n.INSTANCE.a();
        this.mSubscribeFragment = n2.INSTANCE.a();
        this.mEpgListFragment = t.INSTANCE.c();
        Fragment fragment = this.mChannelListFragment;
        kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo_mobile.ui.ChannelListFragment");
        ((n) fragment).L0(new e());
        Fragment fragment2 = this.mEpgListFragment;
        kotlin.jvm.internal.m.d(fragment2, "null cannot be cast to non-null type com.live.evo_mobile.ui.EpgListFragment");
        ((t) fragment2).H0(new f());
        q1(0);
        if (t.v.c.i.a.f18646a.g0()) {
            Z();
        }
        T0();
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public int W() {
        return R$layout.fragment_main_tv;
    }

    @Override // com.tvc.lib.mobile.ui.base.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        T().f22996i.getViewBinding().f17385d.J(true);
        com.tvc.lib.mobile.ext.f.d(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.lastIsHidden = Boolean.valueOf(this.isHidden);
        this.isHidden = hidden;
        if (hidden) {
            T().f22996i.getViewBinding().f17385d.J(true);
        } else {
            o1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPause = true;
        T().f22996i.getViewBinding().f17385d.J(true);
    }

    @Override // com.tvc.lib.mobile.ui.base.d, androidx.fragment.app.Fragment
    public void onResume() {
        n nVar;
        super.onResume();
        if (this.isPause) {
            this.isPause = false;
            o1();
        }
        if (!kotlin.jvm.internal.m.a(this.lastIsHidden, Boolean.valueOf(this.isHidden))) {
            this.lastIsHidden = Boolean.valueOf(this.isHidden);
            if (this.playType == 2 && (nVar = (n) this.mChannelListFragment) != null) {
                n.w0(nVar, null, 1, null);
            }
        }
        com.tvc.lib.mobile.ext.f.c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        T().f22996i.getViewBinding().f17385d.J(true);
    }

    public final void r1(int resId) {
        s1(getString(resId));
    }

    @Override // com.tvc.lib.mobile.ui.base.d
    public void y() {
        T().f22993f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.live.evo_mobile.ui.x0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
                d1.V0(this.f8210a, radioGroup, i10);
            }
        });
        MyVideoView myVideoView = T().f22996i;
        kotlin.jvm.internal.m.e(myVideoView, "myVideoView");
        c1(myVideoView);
        final p7.g viewBinding = T().f22996i.getViewBinding();
        AppCompatImageView appCompatImageView = viewBinding.f17392k;
        com.tvc.lib.mobile.ext.d.f(new View[]{appCompatImageView, appCompatImageView, viewBinding.f17391j, viewBinding.f17390i, viewBinding.f17406y, viewBinding.f17403v, T().f22999l, T().f22996i}, 0L, new c9.l() { // from class: com.live.evo_mobile.ui.y0
            @Override // c9.l
            public final Object invoke(Object obj) {
                return d1.W0(this.f8214a, viewBinding, (View) obj);
            }
        }, 2, null);
        T().f22992e.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d1.X0(this.f8217a, view);
            }
        });
        T().f22996i.setNoSignalListener(new c());
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.b event) {
        kotlin.jvm.internal.m.f(event, "event");
        Intent launchIntentForPackage = S().getPackageManager().getLaunchIntentForPackage(S().getPackageName());
        kotlin.jvm.internal.m.c(launchIntentForPackage);
        launchIntentForPackage.addFlags(268468224);
        startActivity(launchIntentForPackage);
        S().finish();
        Process.killProcess(Process.myPid());
    }

    private final void N0(v7.c dialog) {
    }
}
