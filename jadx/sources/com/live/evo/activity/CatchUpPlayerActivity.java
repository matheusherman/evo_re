package com.live.evo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$id;
import com.live.evo.R$string;
import com.live.evo.widget.LiveCatchUpVideoView;
import com.live.evo.widget.SpeedTextView;
import com.live.evo.widget.sloading.SLoadingView;
import com.stub.StubApp;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnPageChangeListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import org.apache.log4j.spi.Configurator;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b:\u0018\u0000  2\u00020\u0001:\u0004Ç\u0001È\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJW\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u001b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u0019\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0014¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0004¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0006H\u0014¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0006H\u0014¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u0006H\u0014¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0006H\u0014¢\u0006\u0004\b0\u0010\u0003J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020'H\u0014¢\u0006\u0004\b2\u0010*J\u001f\u00106\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u0018¢\u0006\u0004\b8\u00109J\u0019\u0010<\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:H\u0007¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00062\u0006\u00105\u001a\u00020>H\u0007¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00062\u0006\u00105\u001a\u00020AH\u0007¢\u0006\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR0\u0010Q\u001a\u001c\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010i\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR \u0010u\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010hR\u0018\u0010{\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010cR\u0016\u0010\u007f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010cR\u0019\u0010\u0082\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010$R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0016\u0010\u0088\u0001\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010cR\u001a\u0010\u008a\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010\\R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001a\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010IR'\u0010\u0099\u0001\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b\u0095\u0001\u0010h\u001a\u0005\b\u0096\u0001\u00109\"\u0006\b\u0097\u0001\u0010\u0098\u0001R&\u0010\u009c\u0001\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0004\bc\u0010h\u001a\u0005\b\u009a\u0001\u00109\"\u0006\b\u009b\u0001\u0010\u0098\u0001R&\u0010\u009f\u0001\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0004\b$\u0010h\u001a\u0005\b\u009d\u0001\u00109\"\u0006\b\u009e\u0001\u0010\u0098\u0001R&\u0010¢\u0001\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0004\b\u001e\u0010h\u001a\u0005\b \u0001\u00109\"\u0006\b¡\u0001\u0010\u0098\u0001R%\u0010¤\u0001\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0014\n\u0004\b&\u0010h\u001a\u0004\bh\u00109\"\u0006\b£\u0001\u0010\u0098\u0001R(\u0010©\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0004\b\u000e\u0010$\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R)\u0010\u00ad\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\bª\u0001\u0010$\u001a\u0006\b«\u0001\u0010¦\u0001\"\u0006\b¬\u0001\u0010¨\u0001R)\u0010±\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b®\u0001\u0010$\u001a\u0006\b¯\u0001\u0010¦\u0001\"\u0006\b°\u0001\u0010¨\u0001R)\u0010µ\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b²\u0001\u0010$\u001a\u0006\b³\u0001\u0010¦\u0001\"\u0006\b´\u0001\u0010¨\u0001R)\u0010¹\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b¶\u0001\u0010$\u001a\u0006\b·\u0001\u0010¦\u0001\"\u0006\b¸\u0001\u0010¨\u0001R)\u0010¼\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\bº\u0001\u0010$\u001a\u0006\b²\u0001\u0010¦\u0001\"\u0006\b»\u0001\u0010¨\u0001R)\u0010¾\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b\u009a\u0001\u0010$\u001a\u0006\b®\u0001\u0010¦\u0001\"\u0006\b½\u0001\u0010¨\u0001R)\u0010À\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b\u009d\u0001\u0010$\u001a\u0006\b¶\u0001\u0010¦\u0001\"\u0006\b¿\u0001\u0010¨\u0001R)\u0010Â\u0001\u001a\u00030\u0080\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b¯\u0001\u0010$\u001a\u0006\bº\u0001\u0010¦\u0001\"\u0006\bÁ\u0001\u0010¨\u0001R'\u0010Å\u0001\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b¥\u0001\u0010c\u001a\u0006\bª\u0001\u0010Ã\u0001\"\u0005\bÄ\u0001\u0010\bR\u0017\u0010Æ\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010c¨\u0006É\u0001"}, d2 = {"Lcom/live/evo/activity/CatchUpPlayerActivity;", "Lcom/live/evo/activity/FontBaseActivity;", "<init>", "()V", "", "what", "Lr8/z;", "z0", "(I)V", "x0", "g0", "A0", "Lkotlinx/coroutines/flow/f;", "Lx4/c;", "M", "()Lkotlinx/coroutines/flow/f;", "cc", "", "message", "okText", "cancelText", "Ljava/lang/Runnable;", "okAction", "cancelAction", "", "showOKButton", "showCancelButton", "cancelAble", "y0", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/Runnable;ZZZ)V", "K", "j0", "X", "f0", ExifInterface.LONGITUDE_WEST, "catchUpPlayInfo", "J", "(Lx4/c;)Lx4/c;", "L", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Y", "onBackPressed", "onStart", "onResume", "onPause", "onStop", "outState", "onSaveInstanceState", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "b0", "()Z", "Li5/x;", "noticeItem", "onNotice", "(Li5/x;)V", "Lb5/k;", "onSubscribe", "(Lb5/k;)V", "Lnf/m;", "onEvent", "(Lnf/m;)V", "Lq6/b;", "i", "Lq6/b;", "logger", "j", "Ljava/lang/String;", "mPlayType", "k", "Lx4/c;", "mPlayInfo", "Lcom/blankj/utilcode/util/u$c;", "l", "Lcom/blankj/utilcode/util/u$c;", "mNextPlayInfoFunc", "Lcom/live/evo/widget/LiveCatchUpVideoView;", "m", "Lcom/live/evo/widget/LiveCatchUpVideoView;", "mVideoView", "Lcom/live/evo/catchup/player/a;", "n", "Lcom/live/evo/catchup/player/a;", "mMediaController", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "mBgFinishedIv", "Lcom/live/evo/dialog/b;", "p", "Lcom/live/evo/dialog/b;", "mConfirmDialog", "q", "I", "mCurrentCC", "r", "mLastStopPosition", "s", "Z", "mInitFromOnCreate", "Lcom/live/evo/dialog/q;", "t", "Lcom/live/evo/dialog/q;", "noticeAlertDialog", "Lcom/live/evo/widget/SpeedTextView;", "u", "Lcom/live/evo/widget/SpeedTextView;", "mNoticeView", "Lcom/youth/banner/Banner;", "v", "Lcom/youth/banner/Banner;", "mBanner", "w", "mShowBanner", "Lcom/live/evo/dialog/u;", "x", "Lcom/live/evo/dialog/u;", "subscribeDialog", "y", "browseCount", "z", "clickCount", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "browseDuration", "Lcom/live/evo/widget/sloading/SLoadingView;", "B", "Lcom/live/evo/widget/sloading/SLoadingView;", "mLoadingView", "C", "mPlayerType", "D", "mAdIv", "Landroid/widget/RelativeLayout;", ExifInterface.LONGITUDE_EAST, "Landroid/widget/RelativeLayout;", "mAdRl", "Landroid/widget/TextView;", "F", "Landroid/widget/TextView;", "mAdTv", "G", "mChannelId", "H", "c0", "s0", "(Z)V", "isPrepare", ExifInterface.LATITUDE_SOUTH, "q0", "hasFirstPrepareBuffering", ExifInterface.GPS_DIRECTION_TRUE, "r0", "hasSeeking", "a0", "setManualSeeking", "isManualSeeking", "k0", "isBufferingBySeek", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()J", "setSeekCompleteTime", "(J)V", "seekCompleteTime", "N", "getSeekFirstBuffingTime", "v0", "seekFirstBuffingTime", "O", "U", "u0", "prepareTime", "P", "getPrepareFirstBufferingTime", "t0", "prepareFirstBufferingTime", "Q", "getStartBufferingPosition", "w0", "startBufferingPosition", "R", "n0", "bufferingStartTime", "m0", "bufferingEndTime", "o0", "bufferingTime", "p0", "bufferingTotalTime", "()I", "l0", "bufferingCount", "curBannerItem", "b", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatchUpPlayerActivity extends FontBaseActivity {

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private long browseDuration;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private SLoadingView mLoadingView;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private final int mPlayerType;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private ImageView mAdIv;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private RelativeLayout mAdRl;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private TextView mAdTv;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private String mChannelId;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private boolean isPrepare;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private boolean hasFirstPrepareBuffering;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private boolean hasSeeking;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private boolean isManualSeeking;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private boolean isBufferingBySeek;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private long seekCompleteTime;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private long seekFirstBuffingTime;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private long prepareTime;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private long prepareFirstBufferingTime;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private long startBufferingPosition;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private long bufferingStartTime;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private long bufferingEndTime;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private long bufferingTime;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    private long bufferingTotalTime;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    private int bufferingCount;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    private int curBannerItem;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String mPlayType;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private x4.c mPlayInfo;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.blankj.utilcode.util.u.c<kotlinx.coroutines.flow.f<x4.c>, x4.c> mNextPlayInfoFunc;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LiveCatchUpVideoView mVideoView;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.catchup.player.a mMediaController;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private ImageView mBgFinishedIv;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.dialog.b mConfirmDialog;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int mCurrentCC;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int mLastStopPosition;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean mInitFromOnCreate;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.dialog.q noticeAlertDialog;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private SpeedTextView mNoticeView;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private Banner<?, ?> mBanner;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean mShowBanner;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.dialog.u subscribeDialog;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int browseCount;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int clickCount;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R<\u0010\u001a\u001a\u001c\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\f\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/live/evo/activity/CatchUpPlayerActivity$a;", "", "<init>", "()V", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "catchUpType", "Lx4/c;", "c", "Lx4/c;", "a", "()Lx4/c;", "e", "(Lx4/c;)V", "catchUpPlayInfo", "Lcom/blankj/utilcode/util/u$c;", "Lkotlinx/coroutines/flow/f;", "d", "Lcom/blankj/utilcode/util/u$c;", "()Lcom/blankj/utilcode/util/u$c;", "h", "(Lcom/blankj/utilcode/util/u$c;)V", "nextPlayInfoFunc", "g", "channelId", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5240a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static String catchUpType;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static x4.c catchUpPlayInfo;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static com.blankj.utilcode.util.u.c<kotlinx.coroutines.flow.f<x4.c>, x4.c> nextPlayInfoFunc;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static String channelId;

        public final x4.c a() {
            return catchUpPlayInfo;
        }

        public final String b() {
            return catchUpType;
        }

        public final String c() {
            return channelId;
        }

        public final com.blankj.utilcode.util.u.c<kotlinx.coroutines.flow.f<x4.c>, x4.c> d() {
            return nextPlayInfoFunc;
        }

        public final void e(x4.c cVar) {
            catchUpPlayInfo = cVar;
        }

        public final void f(String str) {
            catchUpType = str;
        }

        public final void g(String str) {
            channelId = str;
        }

        public final void h(com.blankj.utilcode.util.u.c<kotlinx.coroutines.flow.f<x4.c>, x4.c> cVar) {
            nextPlayInfoFunc = cVar;
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.live.evo.activity.CatchUpPlayerActivity$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JU\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2 \u0010\r\u001a\u001c\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/live/evo/activity/CatchUpPlayerActivity$b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "channelId", "catchUpType", "Lx4/c;", "catchUpPlayInfo", "Lcom/blankj/utilcode/util/u$c;", "Lkotlinx/coroutines/flow/f;", "nextPlayInfoFunc", "Lr8/z;", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lx4/c;Lcom/blankj/utilcode/util/u$c;)V", "KEY_LAST_POSITION", "Ljava/lang/String;", "KEY_PLAY_INFO", "", "CC_UNKNOWN", "I", "CC_EXIT", "CC_PLAY_ERROR", "CC_PLAY_FINISHED", "CC_PREPARE_ERROR", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final void a(Context context, String channelId, String catchUpType, x4.c catchUpPlayInfo, com.blankj.utilcode.util.u.c<kotlinx.coroutines.flow.f<x4.c>, x4.c> nextPlayInfoFunc) {
            kotlin.jvm.internal.m.f(context, "context");
            Intent intent = new Intent(context, (Class<?>) CatchUpPlayerActivity.class);
            a aVar = a.f5240a;
            aVar.f(catchUpType);
            aVar.e(catchUpPlayInfo);
            aVar.h(nextPlayInfoFunc);
            aVar.g(channelId);
            ((Activity) context).startActivityForResult(intent, 3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo/activity/CatchUpPlayerActivity$d", "Lcom/live/evo/dialog/u$a;", "", "pos", "Lr8/z;", "b", "(I)V", "a", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements com.live.evo.dialog.u.a {
        d() {
        }

        @Override // com.live.evo.dialog.u.a
        public void a() {
            com.live.evo.osd.u.f7147a.p();
        }

        @Override // com.live.evo.dialog.u.a
        public void b(int pos) {
            CatchUpPlayerActivity.this.setResult(pos + 1);
            CatchUpPlayerActivity.this.L();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.CatchUpPlayerActivity$onEvent$2", f = "CatchUpPlayerActivity.kt", l = {892}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ ChannelStreamResponse $channelResponse;
        final /* synthetic */ nf.m $event;
        int label;
        final /* synthetic */ CatchUpPlayerActivity this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.CatchUpPlayerActivity$onEvent$2$1", f = "CatchUpPlayerActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ i5.c0 $subscribeBean;
            int label;
            final /* synthetic */ CatchUpPlayerActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(CatchUpPlayerActivity catchUpPlayerActivity, i5.c0 c0Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = catchUpPlayerActivity;
                this.$subscribeBean = c0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, this.$subscribeBean, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    com.live.evo.dialog.u uVar = this.this$0.subscribeDialog;
                    if (uVar != null) {
                        uVar.p(this.$subscribeBean);
                    }
                    com.live.evo.dialog.u uVar2 = this.this$0.subscribeDialog;
                    if (uVar2 != null) {
                        uVar2.q();
                    }
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ChannelStreamResponse channelStreamResponse, nf.m mVar, CatchUpPlayerActivity catchUpPlayerActivity, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$channelResponse = channelStreamResponse;
            this.$event = mVar;
            this.this$0 = catchUpPlayerActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new e(this.$channelResponse, this.$event, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                String epgId = this.$channelResponse.getEpgId();
                kotlin.jvm.internal.m.e(epgId, "getEpgId(...)");
                long jE = this.$event.e() + 1;
                this.label = 1;
                obj = aVar.G(epgId, jE, this);
                if (obj == objC) {
                    return objC;
                }
            }
            EPGProgramme ePGProgramme = (EPGProgramme) obj;
            if (ePGProgramme == null) {
                return r8.z.f17874a;
            }
            com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.this$0, s0Var.e(0, s0Var.l(ePGProgramme), this.$channelResponse), null), 3, null);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo/activity/CatchUpPlayerActivity$f", "Lcom/live/evo/dialog/u$a;", "", "pos", "Lr8/z;", "b", "(I)V", "a", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements com.live.evo.dialog.u.a {
        f() {
        }

        @Override // com.live.evo.dialog.u.a
        public void a() {
            com.live.evo.osd.u.f7147a.p();
        }

        @Override // com.live.evo.dialog.u.a
        public void b(int pos) {
            if (CatchUpPlayerActivity.this.mShowBanner) {
                CatchUpPlayerActivity.this.z0(1);
            }
            CatchUpPlayerActivity.this.setResult(pos + 1);
            CatchUpPlayerActivity.this.L();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/live/evo/activity/CatchUpPlayerActivity$g", "Lcom/live/evo/widget/LiveCatchUpVideoView$a;", "", "bPlay", "Lr8/z;", "a", "(Z)V", "bFocus", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements LiveCatchUpVideoView.a {
        g() {
        }

        @Override // com.live.evo.widget.LiveCatchUpVideoView.a
        public void b(boolean bFocus) {
            boolean unused = CatchUpPlayerActivity.this.mShowBanner;
        }

        @Override // com.live.evo.widget.LiveCatchUpVideoView.a
        public void a(boolean bPlay) {
            v4.e.b().a(!bPlay);
            if (CatchUpPlayerActivity.this.mShowBanner) {
                CatchUpPlayerActivity.this.z0(bPlay ? 1 : 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J3\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"com/live/evo/activity/CatchUpPlayerActivity$h", "Lcom/live/evo/widget/k$b;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "mediaPlayer", "Lr8/z;", "onPrepared", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "", "what", "extra", "", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;II)Z", "onCompletion", "", "info", "b", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;IILjava/lang/String;)Z", "", "throwable", "c", "(Ljava/lang/Throwable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements com.live.evo.widget.k.b {
        h() {
        }

        @Override // com.live.evo.widget.k.b
        public boolean a(IMediaPlayer mediaPlayer, int what, int extra) {
            if (what == 701) {
                if (CatchUpPlayerActivity.this.getIsPrepare() && !CatchUpPlayerActivity.this.getHasFirstPrepareBuffering()) {
                    CatchUpPlayerActivity.this.q0(true);
                    CatchUpPlayerActivity.this.t0(SystemClock.elapsedRealtime() - CatchUpPlayerActivity.this.getPrepareTime());
                }
                if (CatchUpPlayerActivity.this.getHasSeeking()) {
                    CatchUpPlayerActivity.this.r0(false);
                    CatchUpPlayerActivity.this.v0(SystemClock.elapsedRealtime() - CatchUpPlayerActivity.this.getSeekCompleteTime());
                }
                CatchUpPlayerActivity.this.w0(mediaPlayer != null ? mediaPlayer.getCurrentPosition() : 0L);
                CatchUpPlayerActivity.this.n0(SystemClock.elapsedRealtime());
                if (CatchUpPlayerActivity.this.getIsManualSeeking()) {
                    CatchUpPlayerActivity.this.k0(true);
                } else {
                    CatchUpPlayerActivity.this.k0(false);
                    CatchUpPlayerActivity.this.l0(CatchUpPlayerActivity.this.getBufferingCount() + 1);
                }
            } else if (what == 702) {
                CatchUpPlayerActivity.this.m0(SystemClock.elapsedRealtime());
                CatchUpPlayerActivity catchUpPlayerActivity = CatchUpPlayerActivity.this;
                catchUpPlayerActivity.o0(catchUpPlayerActivity.getBufferingEndTime() - CatchUpPlayerActivity.this.getBufferingStartTime());
                CatchUpPlayerActivity catchUpPlayerActivity2 = CatchUpPlayerActivity.this;
                catchUpPlayerActivity2.p0(catchUpPlayerActivity2.getBufferingTotalTime() + CatchUpPlayerActivity.this.getBufferingTime());
                CatchUpPlayerActivity.this.getIsBufferingBySeek();
            }
            return false;
        }

        @Override // com.live.evo.widget.k.b
        public boolean b(IMediaPlayer mediaPlayer, int what, int extra, String info) {
            String str;
            SimpleDateFormat simpleDateFormatA = com.live.evo.util.o1.a("MM/dd-HH:mm");
            ImageView imageView = CatchUpPlayerActivity.this.mBgFinishedIv;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            CatchUpPlayerActivity catchUpPlayerActivity = CatchUpPlayerActivity.this;
            String strJ = com.live.evo.util.x1.j(R$string.catchup_play_error);
            String strJ2 = com.live.evo.util.x1.j(R$string.error_message);
            kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
            String str2 = String.format("%d - %d", Arrays.copyOf(new Object[]{Integer.valueOf(what), Integer.valueOf(extra)}, 2));
            kotlin.jvm.internal.m.e(str2, "format(...)");
            String strJ3 = ua.n.j("\n    " + strJ + "\n    " + strJ2 + str2 + "\n    \n    ");
            String strK = of.a.f16585a.k();
            x4.c cVar = CatchUpPlayerActivity.this.mPlayInfo;
            String strC = cVar != null ? cVar.c() : null;
            if (CatchUpPlayerActivity.this.mPlayInfo == null) {
                str = Configurator.NULL;
            } else {
                x4.c cVar2 = CatchUpPlayerActivity.this.mPlayInfo;
                str = simpleDateFormatA.format(new Date(cVar2 != null ? cVar2.a() : 0L));
            }
            String str3 = String.format("%s: %s[%s] %s", Arrays.copyOf(new Object[]{strK, strC, str, info}, 4));
            kotlin.jvm.internal.m.e(str3, "format(...)");
            String str4 = strJ3 + str3;
            String strJ4 = com.live.evo.util.x1.j(2131952869);
            kotlin.jvm.internal.m.e(strJ4, "getString(...)");
            String strJ5 = com.live.evo.util.x1.j(2131951835);
            kotlin.jvm.internal.m.e(strJ5, "getString(...)");
            final CatchUpPlayerActivity catchUpPlayerActivity2 = CatchUpPlayerActivity.this;
            Runnable runnable = new Runnable() { // from class: com.live.evo.activity.h
                @Override // java.lang.Runnable
                public final void run() {
                    CatchUpPlayerActivity.h.h(catchUpPlayerActivity2);
                }
            };
            final CatchUpPlayerActivity catchUpPlayerActivity3 = CatchUpPlayerActivity.this;
            catchUpPlayerActivity.y0(2, str4, strJ4, strJ5, runnable, new Runnable() { // from class: com.live.evo.activity.i
                @Override // java.lang.Runnable
                public final void run() {
                    CatchUpPlayerActivity.h.i(catchUpPlayerActivity3);
                }
            }, true, true, false);
            return true;
        }

        @Override // com.live.evo.widget.k.b
        public void c(Throwable throwable) {
            ImageView imageView = CatchUpPlayerActivity.this.mBgFinishedIv;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            CatchUpPlayerActivity catchUpPlayerActivity = CatchUpPlayerActivity.this;
            String strJ = ua.n.j("\n                    " + com.live.evo.util.x1.j(R$string.catchup_prepare_error) + "\n                    " + com.live.evo.util.x1.j(R$string.error_message) + "\n                    ");
            String strJ2 = com.live.evo.util.x1.j(2131952869);
            kotlin.jvm.internal.m.e(strJ2, "getString(...)");
            String strJ3 = com.live.evo.util.x1.j(R$string.catchupcancel_ok);
            kotlin.jvm.internal.m.e(strJ3, "getString(...)");
            final CatchUpPlayerActivity catchUpPlayerActivity2 = CatchUpPlayerActivity.this;
            Runnable runnable = new Runnable() { // from class: com.live.evo.activity.f
                @Override // java.lang.Runnable
                public final void run() {
                    CatchUpPlayerActivity.h.j(catchUpPlayerActivity2);
                }
            };
            final CatchUpPlayerActivity catchUpPlayerActivity3 = CatchUpPlayerActivity.this;
            catchUpPlayerActivity.y0(4, strJ, strJ2, strJ3, runnable, new Runnable() { // from class: com.live.evo.activity.g
                @Override // java.lang.Runnable
                public final void run() {
                    CatchUpPlayerActivity.h.k(catchUpPlayerActivity3);
                }
            }, false, true, false);
        }

        @Override // com.live.evo.widget.k.b
        public void onCompletion(IMediaPlayer mediaPlayer) {
            CatchUpPlayerActivity.this.g0();
        }

        @Override // com.live.evo.widget.k.b
        public void onPrepared(IMediaPlayer mediaPlayer) {
            if (!CatchUpPlayerActivity.this.getIsPrepare()) {
                CatchUpPlayerActivity.this.u0(SystemClock.elapsedRealtime());
            }
            CatchUpPlayerActivity.this.s0(true);
            ImageView imageView = CatchUpPlayerActivity.this.mBgFinishedIv;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            com.live.evo.catchup.player.a aVar = CatchUpPlayerActivity.this.mMediaController;
            if (aVar != null) {
                aVar.C(CatchUpPlayerActivity.this.mPlayInfo);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(CatchUpPlayerActivity catchUpPlayerActivity) {
            catchUpPlayerActivity.A0();
            ImageView imageView = catchUpPlayerActivity.mBgFinishedIv;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(CatchUpPlayerActivity catchUpPlayerActivity) {
            catchUpPlayerActivity.L();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(CatchUpPlayerActivity catchUpPlayerActivity) {
            catchUpPlayerActivity.A0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(CatchUpPlayerActivity catchUpPlayerActivity) {
            catchUpPlayerActivity.L();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"com/live/evo/activity/CatchUpPlayerActivity$i", "Lcom/youth/banner/listener/OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "Lr8/z;", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements OnPageChangeListener {
        i() {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageSelected(int position) {
            CatchUpPlayerActivity.this.curBannerItem = position;
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }

    private final void W() {
        this.browseCount = 0;
        this.clickCount = 0;
        this.browseDuration = 0L;
    }

    private final void X() {
        this.mShowBanner = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(CatchUpPlayerActivity catchUpPlayerActivity) {
        catchUpPlayerActivity.mCurrentCC = 0;
        ImageView imageView = catchUpPlayerActivity.mBgFinishedIv;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        catchUpPlayerActivity.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(int what) {
        Banner<?, ?> banner;
        if (what != 0) {
            if (what == 1 && (banner = this.mBanner) != null && banner.getVisibility() == 0) {
                Banner<?, ?> banner2 = this.mBanner;
                if (banner2 != null) {
                    banner2.setVisibility(8);
                }
                Banner<?, ?> banner3 = this.mBanner;
                if (banner3 != null) {
                    banner3.start();
                }
                this.browseDuration = com.live.evo.util.u1.b().a() - this.browseDuration;
                return;
            }
            return;
        }
        Banner<?, ?> banner4 = this.mBanner;
        if (banner4 == null || banner4.getVisibility() != 0) {
            W();
            this.browseCount++;
            this.browseDuration = com.live.evo.util.q1.b();
            Banner<?, ?> banner5 = this.mBanner;
            if (banner5 != null) {
                banner5.setVisibility(0);
            }
            Banner<?, ?> banner6 = this.mBanner;
            if (banner6 != null) {
                banner6.start();
            }
        }
    }

    public final boolean b0() {
        try {
            LiveCatchUpVideoView liveCatchUpVideoView = this.mVideoView;
            return liveCatchUpVideoView != null && liveCatchUpVideoView.isPlaying();
        } catch (Throwable unused) {
        }
    }

    @Override // com.live.evo.activity.FontBaseActivity, com.live.evo.activity.BaseActivity, com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/live/evo/activity/CatchUpPlayerActivity$c", "Lf3/a;", "Lx4/c;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends f3.a<x4.c> {
        c() {
        }
    }

    static {
        StubApp.interface11(11740);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        LiveCatchUpVideoView liveCatchUpVideoView = this.mVideoView;
        if (liveCatchUpVideoView != null) {
            liveCatchUpVideoView.getAndPlay();
        }
    }

    private final void K() {
        if (this.noticeAlertDialog == null) {
            this.noticeAlertDialog = new com.live.evo.dialog.q(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        LiveCatchUpVideoView liveCatchUpVideoView = this.mVideoView;
        if (liveCatchUpVideoView != null) {
            liveCatchUpVideoView.p();
        }
        finish();
    }

    private final kotlinx.coroutines.flow.f<x4.c> M() {
        x4.c cVarJ = J(this.mPlayInfo);
        this.mPlayInfo = cVarJ;
        return kotlinx.coroutines.flow.h.w(cVarJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(CatchUpPlayerActivity catchUpPlayerActivity) {
        if (catchUpPlayerActivity.mShowBanner) {
            catchUpPlayerActivity.z0(1);
        }
        v4.e.b().e();
        catchUpPlayerActivity.L();
    }

    private final void f0() {
        this.clickCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        ImageView imageView = this.mBgFinishedIv;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        String strJ = com.live.evo.util.x1.j(R$string.catchup_finished_hint);
        kotlin.jvm.internal.m.e(strJ, "getString(...)");
        String strJ2 = com.live.evo.util.x1.j(R$string.tv_continue);
        kotlin.jvm.internal.m.e(strJ2, "getString(...)");
        String strJ3 = com.live.evo.util.x1.j(2131952616);
        kotlin.jvm.internal.m.e(strJ3, "getString(...)");
        y0(3, strJ, strJ2, strJ3, new Runnable() { // from class: com.live.evo.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                CatchUpPlayerActivity.h0();
            }
        }, new Runnable() { // from class: com.live.evo.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                CatchUpPlayerActivity.i0(this.f5425a);
            }
        }, false, true, false);
    }

    private final void j0() {
        LiveCatchUpVideoView liveCatchUpVideoView;
        try {
            LiveCatchUpVideoView liveCatchUpVideoView2 = this.mVideoView;
            int currentPosition = -1;
            if (liveCatchUpVideoView2 != null && liveCatchUpVideoView2.isPlaying() && (liveCatchUpVideoView = this.mVideoView) != null) {
                currentPosition = liveCatchUpVideoView.getCurrentPosition();
            }
            this.mLastStopPosition = currentPosition;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(int cc2, String message, String okText, String cancelText, Runnable okAction, Runnable cancelAction, boolean showOKButton, boolean showCancelButton, boolean cancelAble) {
        com.live.evo.dialog.b bVar = this.mConfirmDialog;
        if ((bVar != null && bVar.isShowing()) || isFinishing() || isDestroyed() || this.mCurrentCC == 3) {
            return;
        }
        this.mCurrentCC = cc2;
        com.live.evo.dialog.b bVar2 = this.mConfirmDialog;
        if (bVar2 != null) {
            bVar2.h(message, okText, cancelText, okAction, cancelAction, showOKButton, showCancelButton, cancelAble);
        }
    }

    /* JADX INFO: renamed from: N, reason: from getter */
    protected final int getBufferingCount() {
        return this.bufferingCount;
    }

    /* JADX INFO: renamed from: O, reason: from getter */
    protected final long getBufferingEndTime() {
        return this.bufferingEndTime;
    }

    /* JADX INFO: renamed from: P, reason: from getter */
    protected final long getBufferingStartTime() {
        return this.bufferingStartTime;
    }

    /* JADX INFO: renamed from: Q, reason: from getter */
    protected final long getBufferingTime() {
        return this.bufferingTime;
    }

    /* JADX INFO: renamed from: R, reason: from getter */
    protected final long getBufferingTotalTime() {
        return this.bufferingTotalTime;
    }

    /* JADX INFO: renamed from: S, reason: from getter */
    protected final boolean getHasFirstPrepareBuffering() {
        return this.hasFirstPrepareBuffering;
    }

    /* JADX INFO: renamed from: T, reason: from getter */
    protected final boolean getHasSeeking() {
        return this.hasSeeking;
    }

    /* JADX INFO: renamed from: U, reason: from getter */
    protected final long getPrepareTime() {
        return this.prepareTime;
    }

    /* JADX INFO: renamed from: V, reason: from getter */
    protected final long getSeekCompleteTime() {
        return this.seekCompleteTime;
    }

    protected final void Y(Bundle savedInstanceState) {
        a aVar = a.f5240a;
        this.mPlayType = aVar.b();
        this.mPlayInfo = aVar.a();
        this.mNextPlayInfoFunc = aVar.d();
        this.mChannelId = aVar.c();
        aVar.e(null);
        aVar.h(null);
        aVar.g(null);
        if (savedInstanceState != null) {
            this.mLastStopPosition = savedInstanceState.getInt("key_last_position", 0);
            String string = savedInstanceState.getString("key_play_info", "");
            try {
                if (this.mPlayInfo == null && !TextUtils.isEmpty(string)) {
                    this.mPlayInfo = (x4.c) com.live.evo.util.w.a().o(string, new c().d());
                }
            } catch (Exception unused) {
            }
        }
        this.mInitFromOnCreate = true;
    }

    /* JADX INFO: renamed from: Z, reason: from getter */
    protected final boolean getIsBufferingBySeek() {
        return this.isBufferingBySeek;
    }

    /* JADX INFO: renamed from: a0, reason: from getter */
    protected final boolean getIsManualSeeking() {
        return this.isManualSeeking;
    }

    /* JADX INFO: renamed from: c0, reason: from getter */
    protected final boolean getIsPrepare() {
        return this.isPrepare;
    }

    protected final void k0(boolean z10) {
        this.isBufferingBySeek = z10;
    }

    protected final void l0(int i10) {
        this.bufferingCount = i10;
    }

    protected final void m0(long j10) {
        this.bufferingEndTime = j10;
    }

    protected final void n0(long j10) {
        this.bufferingStartTime = j10;
    }

    protected final void o0(long j10) {
        this.bufferingTime = j10;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.m event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (this.subscribeDialog == null) {
            this.subscribeDialog = new com.live.evo.dialog.u(this, new d());
        }
        ChannelStreamResponse channelStreamResponseJ = t.v.c.i.a.f18646a.j(event.getKey());
        if (channelStreamResponseJ == null) {
            return;
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new e(channelStreamResponseJ, event, this, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0080  */
    /* JADX WARN: Code duplicated, block: B:53:0x0086  */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Banner<?, ?> banner;
        Banner<?, ?> banner2;
        Banner<?, ?> banner3;
        kotlin.jvm.internal.m.f(event, "event");
        if (keyCode == 4) {
            if (event.getRepeatCount() == 0) {
                onBackPressed();
                return true;
            }
        } else if (keyCode == 23 || keyCode == 66) {
            if (event.getRepeatCount() == 0 && !b0() && (banner = this.mBanner) != null && banner.getVisibility() == 0 && (banner2 = this.mBanner) != null && banner2.isFocused()) {
                f0();
                return true;
            }
        } else if (keyCode != 111) {
            if (keyCode == 19) {
                event.getRepeatCount();
            } else if (keyCode != 20) {
                Banner<?, ?> banner4 = this.mBanner;
                if (banner4 != null && banner4.getVisibility() == 0) {
                    Banner<?, ?> banner5 = this.mBanner;
                    if (banner5 != null) {
                        banner5.setVisibility(8);
                    }
                    Banner<?, ?> banner6 = this.mBanner;
                    if (banner6 != null) {
                        banner6.stop();
                    }
                }
            } else if (event.getRepeatCount() == 0 && (banner3 = this.mBanner) != null && banner3.getVisibility() == 0) {
                Banner<?, ?> banner7 = this.mBanner;
                if (banner7 != null) {
                    banner7.clearFocus();
                }
                Banner<?, ?> banner8 = this.mBanner;
                if (banner8 != null) {
                    banner8.setFocusable(false);
                }
            }
        } else if (event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        LiveCatchUpVideoView liveCatchUpVideoView = this.mVideoView;
        if (liveCatchUpVideoView != null) {
            return liveCatchUpVideoView.onKeyDown(keyCode, event);
        }
        return false;
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.m.f(outState, "outState");
        super.onSaveInstanceState(outState);
        j0();
        outState.putInt("key_last_position", this.mLastStopPosition);
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onSubscribe(b5.k event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (this.subscribeDialog == null) {
            this.subscribeDialog = new com.live.evo.dialog.u(this, new f());
        }
        com.live.evo.dialog.u uVar = this.subscribeDialog;
        if (uVar != null) {
            uVar.p(event.f916a);
        }
        com.live.evo.dialog.u uVar2 = this.subscribeDialog;
        if (uVar2 != null) {
            uVar2.q();
        }
    }

    protected final void p0(long j10) {
        this.bufferingTotalTime = j10;
    }

    protected final void q0(boolean z10) {
        this.hasFirstPrepareBuffering = z10;
    }

    protected final void r0(boolean z10) {
        this.hasSeeking = z10;
    }

    protected final void s0(boolean z10) {
        this.isPrepare = z10;
    }

    protected final void t0(long j10) {
        this.prepareFirstBufferingTime = j10;
    }

    protected final void u0(long j10) {
        this.prepareTime = j10;
    }

    protected final void v0(long j10) {
        this.seekFirstBuffingTime = j10;
    }

    protected final void w0(long j10) {
        this.startBufferingPosition = j10;
    }

    public CatchUpPlayerActivity() {
        q6.b bVarD = q6.c.d(CatchUpPlayerActivity.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.mPlayType = "normal";
        this.mPlayerType = -1;
        this.startBufferingPosition = -1L;
    }

    private final void x0() {
        SLoadingView sLoadingView;
        List listL;
        SLoadingView sLoadingView2;
        SLoadingView sLoadingView3;
        SLoadingView sLoadingView4;
        LiveCatchUpVideoView liveCatchUpVideoView = (LiveCatchUpVideoView) findViewById(R$id.catchupplayera_vv_video_view);
        this.mVideoView = liveCatchUpVideoView;
        if (liveCatchUpVideoView != null) {
            liveCatchUpVideoView.setPlayInfoProvider(M());
        }
        this.mBgFinishedIv = (ImageView) findViewById(R$id.catchupplayera_iv_finished);
        this.mNoticeView = (SpeedTextView) findViewById(R$id.catchupplayera_iv_notice);
        this.mBanner = (Banner) findViewById(R$id.catchupplayera_bn_banner);
        com.live.evo.catchup.player.a aVar = new com.live.evo.catchup.player.a(this);
        this.mMediaController = aVar;
        LiveCatchUpVideoView liveCatchUpVideoView2 = this.mVideoView;
        if (liveCatchUpVideoView2 != null) {
            liveCatchUpVideoView2.setMediaController(aVar);
        }
        LiveCatchUpVideoView liveCatchUpVideoView3 = this.mVideoView;
        if (liveCatchUpVideoView3 != null) {
            sLoadingView = (SLoadingView) liveCatchUpVideoView3.findViewById(R$id.loading_icon);
        } else {
            sLoadingView = null;
        }
        this.mLoadingView = sLoadingView;
        this.mAdIv = (ImageView) findViewById(R$id.catchupplayera_ad_iv);
        this.mAdRl = (RelativeLayout) findViewById(R$id.catchupplayera_ad_rl);
        this.mAdTv = (TextView) findViewById(R$id.catchupplayera_ad_tv);
        v4.e.b().d(this.mAdIv, this.mAdRl, this.mAdTv, this);
        SLoadingView sLoadingView5 = this.mLoadingView;
        if (sLoadingView5 != null) {
            sLoadingView5.setLoadingBuilder(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        }
        String strQ = com.live.evo.util.o0.p().q();
        if (!TextUtils.isEmpty(strQ)) {
            kotlin.jvm.internal.m.c(strQ);
            List<String> listG = new ua.l(",").g(strQ, 0);
            if (!listG.isEmpty()) {
                ListIterator<String> listIterator = listG.listIterator(listG.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        listL = kotlin.collections.r.l();
                        break;
                    }
                }
            } else {
                listL = kotlin.collections.r.l();
                break;
            }
            String[] strArr = (String[]) listL.toArray(new String[0]);
            if (strArr.length == 2) {
                if (!TextUtils.isEmpty(strArr[0]) && Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strArr[0]) && (sLoadingView4 = this.mLoadingView) != null) {
                    sLoadingView4.setColorFilter(Color.parseColor(strArr[0]));
                }
                if (!TextUtils.isEmpty(strArr[1]) && Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strArr[1]) && (sLoadingView3 = this.mLoadingView) != null) {
                    sLoadingView3.setColorExtra(Color.parseColor(strArr[1]));
                }
            } else if (strArr.length == 1 && !TextUtils.isEmpty(strArr[0]) && Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strArr[0]) && (sLoadingView2 = this.mLoadingView) != null) {
                sLoadingView2.setColorFilter(Color.parseColor(strArr[0]));
            }
        }
        LiveCatchUpVideoView liveCatchUpVideoView4 = this.mVideoView;
        if (liveCatchUpVideoView4 != null) {
            liveCatchUpVideoView4.setPlayStatusListener(new g());
        }
        this.mConfirmDialog = new com.live.evo.dialog.b.e(this).d(false).c();
        LiveCatchUpVideoView liveCatchUpVideoView5 = this.mVideoView;
        if (liveCatchUpVideoView5 != null) {
            liveCatchUpVideoView5.setPlayEventListener(new h());
        }
        Banner<?, ?> banner = this.mBanner;
        if (banner != null) {
            banner.addOnPageChangeListener(new i());
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        String strJ = com.live.evo.util.x1.j(R$string.catchup_exit_hint);
        kotlin.jvm.internal.m.e(strJ, "getString(...)");
        String strJ2 = com.live.evo.util.x1.j(R$string.catchupexit_ok);
        kotlin.jvm.internal.m.e(strJ2, "getString(...)");
        String strJ3 = com.live.evo.util.x1.j(2131951835);
        kotlin.jvm.internal.m.e(strJ3, "getString(...)");
        y0(1, strJ, strJ2, strJ3, new Runnable() { // from class: com.live.evo.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                CatchUpPlayerActivity.d0(this.f5406a);
            }
        }, new Runnable() { // from class: com.live.evo.activity.c
            @Override // java.lang.Runnable
            public final void run() {
                CatchUpPlayerActivity.e0();
            }
        }, true, true, true);
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onNotice(i5.x noticeItem) {
        K();
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.logger.a("onPause", new Object[0]);
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.live.evo.activity.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.mInitFromOnCreate) {
            this.mInitFromOnCreate = false;
        } else {
            LiveCatchUpVideoView liveCatchUpVideoView = this.mVideoView;
            if (liveCatchUpVideoView != null) {
                liveCatchUpVideoView.start();
            }
        }
        K();
    }

    @Override // com.live.evo.activity.BaseActivity, com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.live.evo.dialog.q qVar;
        super.onStop();
        j0();
        LiveCatchUpVideoView liveCatchUpVideoView = this.mVideoView;
        if (liveCatchUpVideoView != null) {
            liveCatchUpVideoView.p();
        }
        com.live.evo.dialog.q qVar2 = this.noticeAlertDialog;
        if (qVar2 != null && qVar2.f() && (qVar = this.noticeAlertDialog) != null) {
            qVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0() {
    }

    private final x4.c J(x4.c catchUpPlayInfo) {
        return catchUpPlayInfo;
    }
}
