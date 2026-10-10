package com.tvc.lib.mobile.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tvc.lib.R$color;
import com.tvc.lib.R$drawable;
import com.tvc.lib.R$id;
import com.tvc.lib.R$layout;
import com.tvc.lib.R$mipmap;
import com.tvc.lib.R$string;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;
import t.v.c.widget.MyButton;
import t.v.c.widget.MyRelativelayout;
import t.v.c.widget.MyRoundImageView;
import t.v.c.widget.TextView;
import t.v.c.widget.videoview.PlayerView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import x1.f1.lb.util.d0;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0012J!\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010\u001cJ\u0017\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0002¢\u0006\u0004\b$\u0010\u001cJ\u000f\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\b%\u0010\u001cJ\u000f\u0010&\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010\u001cJ\u001b\u0010)\u001a\u00020\u00192\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0004\b+\u0010\u001cJ\u000f\u0010,\u001a\u00020\u0019H\u0002¢\u0006\u0004\b,\u0010\u001cJ\u001b\u0010-\u001a\u00020\u00192\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00192\b\b\u0001\u0010/\u001a\u00020\t¢\u0006\u0004\b0\u0010#J\u001b\u00103\u001a\u00020\u00192\f\u00102\u001a\b\u0012\u0004\u0012\u00020\t01¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00192\b\b\u0002\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u000109¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\u00192\u0006\u0010<\u001a\u000205¢\u0006\u0004\b=\u00108J\u0015\u0010?\u001a\u00020\u00192\u0006\u0010>\u001a\u000205¢\u0006\u0004\b?\u00108J\u0015\u0010A\u001a\u00020\u00192\u0006\u0010@\u001a\u000205¢\u0006\u0004\bA\u00108J\r\u0010B\u001a\u00020\u0019¢\u0006\u0004\bB\u0010\u001cJ\r\u0010C\u001a\u00020\u0019¢\u0006\u0004\bC\u0010\u001cJ\r\u0010D\u001a\u000205¢\u0006\u0004\bD\u0010EJ\r\u0010G\u001a\u00020F¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u000205¢\u0006\u0004\bI\u0010EJ\r\u0010K\u001a\u00020J¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020F¢\u0006\u0004\bM\u0010HJ\r\u0010N\u001a\u000205¢\u0006\u0004\bN\u0010EJ\u0015\u0010Q\u001a\u00020\u00192\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bQ\u0010RJ\u0015\u0010U\u001a\u00020\u00192\u0006\u0010T\u001a\u00020S¢\u0006\u0004\bU\u0010VJ\r\u0010W\u001a\u00020\u0019¢\u0006\u0004\bW\u0010\u001cJ\r\u0010X\u001a\u00020\u0019¢\u0006\u0004\bX\u0010\u001cJ\u0019\u0010Y\u001a\u00020\u00192\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bY\u0010.J\u0015\u0010[\u001a\u00020\u00192\u0006\u00102\u001a\u00020Z¢\u0006\u0004\b[\u0010\\J\u0015\u0010^\u001a\u00020\u00192\u0006\u00102\u001a\u00020]¢\u0006\u0004\b^\u0010_R\u001c\u0010d\u001a\n a*\u0004\u0018\u00010`0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010>\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010@\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010oR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010v\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010sR\u0016\u0010y\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0017\u0010\u0080\u0001\u001a\u00020F8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010oR\u0018\u0010\u0084\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010oR\u0018\u0010\u0086\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010oR\u0016\u0010\u0088\u0001\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010 R\u0016\u0010\u008a\u0001\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010 R\u0016\u0010\u008c\u0001\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010 R\u0016\u0010\u008e\u0001\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010 R\u0018\u0010\u0090\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010 R\u0016\u0010\u0092\u0001\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010 R\u001b\u0010\u0096\u0001\u001a\u00020\t8\u0006¢\u0006\u000f\n\u0005\b\u0093\u0001\u0010 \u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0099\u0001\u001a\u00020\t8\u0006¢\u0006\u000f\n\u0005\b\u0097\u0001\u0010 \u001a\u0006\b\u0098\u0001\u0010\u0095\u0001R\u001b\u0010\u009c\u0001\u001a\u00020\t8\u0006¢\u0006\u000f\n\u0005\b\u009a\u0001\u0010 \u001a\u0006\b\u009b\u0001\u0010\u0095\u0001R\u001b\u0010\u009f\u0001\u001a\u00020\t8\u0006¢\u0006\u000f\n\u0005\b\u009d\u0001\u0010 \u001a\u0006\b\u009e\u0001\u0010\u0095\u0001R\u001b\u0010¢\u0001\u001a\u00020\t8\u0006¢\u0006\u000f\n\u0005\b \u0001\u0010 \u001a\u0006\b¡\u0001\u0010\u0095\u0001R\u001b\u0010¥\u0001\u001a\u00020\t8\u0006¢\u0006\u000f\n\u0005\b£\u0001\u0010 \u001a\u0006\b¤\u0001\u0010\u0095\u0001R\u001b\u0010¨\u0001\u001a\u00020\t8\u0006¢\u0006\u000f\n\u0005\b¦\u0001\u0010 \u001a\u0006\b§\u0001\u0010\u0095\u0001R\u0018\u0010ª\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b©\u0001\u0010\u001fR\u001b\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010¯\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010oR\u0016\u0010±\u0001\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b°\u0001\u0010\u001fR\u001b\u0010³\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010¬\u0001R\u0018\u0010µ\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b´\u0001\u0010\u001fR\u0018\u0010·\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¶\u0001\u0010\u001fR\u0017\u0010¸\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010oR\u0017\u0010¹\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010º\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010 R\u0019\u0010¼\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b&\u0010²\u0001R\u001b\u0010¿\u0001\u001a\u0005\u0018\u00010½\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b,\u0010¾\u0001R\u0017\u0010À\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010oR\u001e\u0010Ã\u0001\u001a\n\u0012\u0005\u0012\u00030»\u00010Á\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001a\u0010Â\u0001R\u0017\u0010Ä\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010 R!\u0010Ç\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001b\u0010Ê\u0001\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b$\u0010É\u0001R\u0018\u0010Ì\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bË\u0001\u0010\u001fR\u0018\u0010Î\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÍ\u0001\u0010\u001fR\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u0018\u0010Ø\u0001\u001a\u00030Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u001c\u0010Ü\u0001\u001a\u0005\u0018\u00010Ù\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010à\u0001\u001a\u00030Ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001¨\u0006á\u0001"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/MyVideoView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resId", "Landroid/view/View;", "N", "(I)Landroid/view/View;", "", "d0", "()J", "time", "", "K", "(J)Ljava/lang/String;", "getVideoDuration", "getVideoCurrentPosition", "Lr8/z;", "O", "P", "()V", "a0", "X", "J", "I", "visibility", "setCtrlVisibility", "(I)V", "R", "m0", "L", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "mediaPlayer", "setPlayCompleted", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "n0", "M", "setNoSignalImage", "(Ljava/lang/Integer;)V", "imgResId", "setTrialImg", "Lx1/f1/lb/util/m;", "listener", "setNoSignalListener", "(Lx1/f1/lb/util/m;)V", "", "isProgrammeChanged", "o0", "(Z)V", "Landroid/view/GestureDetector$OnGestureListener;", "setGestureListener", "(Landroid/view/GestureDetector$OnGestureListener;)V", "fullScreen", "setFullScreenModel", "isPlayBack", "setPlayBackMode", "isVod", "setVodMode", "r0", "q0", "c0", "()Z", "Lp7/g;", "getViewBinding", "()Lp7/g;", "b0", "Lt/v/c/widget/videoview/PlayerView;", "getVideoView", "()Lt/v/c/widget/videoview/PlayerView;", "getBinding", "getIsSlide", "Landroid/view/Window;", "window", "setWindow", "(Landroid/view/Window;)V", "Lcom/tvc/lib/mobile/ui/widget/MyVideoView$a;", "onVodMenuClickListener", "setOnMenuClickListener", "(Lcom/tvc/lib/mobile/ui/widget/MyVideoView$a;)V", "g0", "h0", "f0", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "setOnErrorListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "setOnCompletionListener", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "a", "Lq6/b;", "logger", "b", "Ljava/lang/Integer;", "lastVolume", "c", "Landroid/view/Window;", "Landroid/media/AudioManager;", "d", "Landroid/media/AudioManager;", "audioManager", "e", "Z", "f", "Lt/v/c/widget/TextView;", "g", "Lt/v/c/widget/TextView;", "startTime", "h", "endTime", "i", "Lt/v/c/widget/videoview/PlayerView;", "mVideoView", "Landroid/widget/SeekBar;", "j", "Landroid/widget/SeekBar;", "progressBar", "k", "Lp7/g;", "binding", "l", "isFullScreen", "m", "isPlayBackInit", "n", "isVodInit", "o", "stateIdle", "p", "statePlaying", "q", "statePlayCompleted", "r", "stateSeek", "s", "playState", "t", "messageBase", "u", "getMessageUpdateProgress", "()I", "messageUpdateProgress", "v", "getUpdatePlayBackUi", "updatePlayBackUi", "w", "getMessageHideCenterBox", "messageHideCenterBox", "x", "getUpdateVodUi", "updateVodUi", "y", "getHideCtrl", "hideCtrl", "z", "getNoNetwork", "noNetwork", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getNoSignal", "noSignal", "B", "seekBarPosition", "C", "Ljava/lang/Long;", "pausePosition", "D", "isPause", ExifInterface.LONGITUDE_EAST, "EXIT_MENU_TIME", "F", "lastPosition", "G", "lastDuration", "H", "lastTime", "isSlide", "volume", "mMaxVolume", "", "brightness", "Lw7/a;", "Lw7/a;", "mVolumeChangeObserver", "mVolumeChangeRegister", "", "Ljava/util/List;", "speedList", "speedIndex", "Q", "Lx1/f1/lb/util/m;", "noSignalListener", "Lcom/tvc/lib/mobile/ui/widget/b;", "Lcom/tvc/lib/mobile/ui/widget/b;", "iLoading", ExifInterface.LATITUDE_SOUTH, "lastPlayTime", ExifInterface.GPS_DIRECTION_TRUE, "tipNoSignalOrNoNetworkTime", "U", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "onErrorListener", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "onCompletionListener", "Lw7/a$c;", ExifInterface.LONGITUDE_WEST, "Lw7/a$c;", "mVolumeChangeListener", "Landroid/os/Handler;", "b1", "Landroid/os/Handler;", "mH", "Ljava/lang/Runnable;", "D1", "Ljava/lang/Runnable;", "mTask", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyVideoView extends FrameLayout {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final int noSignal;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private long seekBarPosition;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private Long pausePosition;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private boolean isPause;

    /* JADX INFO: renamed from: D1, reason: from kotlin metadata */
    private Runnable mTask;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private final long EXIT_MENU_TIME;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private Long lastPosition;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private long lastDuration;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private long lastTime;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private boolean isSlide;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private int volume;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private int mMaxVolume;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private float brightness;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private w7.a mVolumeChangeObserver;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private boolean mVolumeChangeRegister;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private final List<Float> speedList;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private int speedIndex;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private x1.f1.lb.util.m<Integer> noSignalListener;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private com.tvc.lib.mobile.ui.widget.b iLoading;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private long lastPlayTime;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private long tipNoSignalOrNoNetworkTime;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    private IMediaPlayer.OnErrorListener onErrorListener;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    private IMediaPlayer.OnCompletionListener onCompletionListener;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    private final w7.a.c mVolumeChangeListener;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Integer lastVolume;

    /* JADX INFO: renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private Handler mH;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Window window;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AudioManager audioManager;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayBack;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isVod;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView startTime;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView endTime;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PlayerView mVideoView;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private SeekBar progressBar;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private p7.g binding;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isFullScreen;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayBackInit;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isVodInit;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int stateIdle;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int statePlaying;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final int statePlayCompleted;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final int stateSeek;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int playState;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final int messageBase;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final int messageUpdateProgress;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final int updatePlayBackUi;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final int messageHideCenterBox;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final int updateVodUi;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final int hideCtrl;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final int noNetwork;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/tvc/lib/mobile/ui/widget/MyVideoView$a;", "", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"com/tvc/lib/mobile/ui/widget/MyVideoView$b", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "Lr8/z;", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "onStartTrackingTouch", "(Landroid/widget/SeekBar;)V", "p0", "onStopTrackingTouch", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                if (MyVideoView.this.playState == MyVideoView.this.statePlaying || MyVideoView.this.playState == MyVideoView.this.statePlayCompleted) {
                    Handler handler = MyVideoView.this.mH;
                    if (handler != null) {
                        handler.removeMessages(MyVideoView.this.getMessageUpdateProgress());
                    }
                    MyVideoView.this.seekBarPosition = (((long) progress) * MyVideoView.this.getVideoDuration()) / ((long) 1000);
                    TextView textView = MyVideoView.this.startTime;
                    if (textView != null) {
                        MyVideoView myVideoView = MyVideoView.this;
                        textView.setText(myVideoView.K(myVideoView.seekBarPosition));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            MyVideoView.this.seekBarPosition = -1L;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar p10) {
            if (MyVideoView.this.seekBarPosition != -1) {
                PlayerView playerView = null;
                if (MyVideoView.this.playState == MyVideoView.this.statePlayCompleted) {
                    PlayerView playerView2 = MyVideoView.this.mVideoView;
                    if (playerView2 == null) {
                        kotlin.jvm.internal.m.v("mVideoView");
                    } else {
                        playerView = playerView2;
                    }
                    playerView.C("seek_to_" + MyVideoView.this.seekBarPosition, Long.valueOf(MyVideoView.this.seekBarPosition));
                    return;
                }
                if (MyVideoView.this.seekBarPosition >= MyVideoView.this.getVideoDuration()) {
                    MyVideoView.j0(MyVideoView.this, null, 1, null);
                    return;
                }
                if (MyVideoView.this.seekBarPosition == 0) {
                    MyVideoView.this.seekBarPosition = 1L;
                }
                PlayerView playerView3 = MyVideoView.this.mVideoView;
                if (playerView3 == null) {
                    kotlin.jvm.internal.m.v("mVideoView");
                } else {
                    playerView = playerView3;
                }
                playerView.E(MyVideoView.this.seekBarPosition);
                Handler handler = MyVideoView.this.mH;
                if (handler != null) {
                    handler.sendEmptyMessage(MyVideoView.this.getMessageUpdateProgress());
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.widget.MyVideoView$initStreaming$2$1", f = "MyVideoView.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ int $reason;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i10, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$reason = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return MyVideoView.this.new c(this.$reason, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Message messageObtainMessage;
            Handler handler;
            Message messageObtainMessage2;
            Handler handler2;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                x1.f1.lb.util.m mVar = MyVideoView.this.noSignalListener;
                if (mVar != null) {
                    mVar.a(kotlin.coroutines.jvm.internal.b.b(this.$reason));
                }
                p7.g gVar = null;
                switch (this.$reason) {
                    case -1:
                        MyVideoView.this.g0();
                        MyVideoView.this.h0();
                        break;
                    case 0:
                    case 8:
                        com.tvc.lib.mobile.ui.widget.b bVar = MyVideoView.this.iLoading;
                        if (bVar != null) {
                            bVar.a();
                        }
                        MyVideoView.this.f0(kotlin.coroutines.jvm.internal.b.b(R$drawable.requesttimeout));
                        if (MyVideoView.this.lastPlayTime >= MyVideoView.this.tipNoSignalOrNoNetworkTime) {
                            MyVideoView.this.tipNoSignalOrNoNetworkTime = d1.d();
                            Handler handler3 = MyVideoView.this.mH;
                            if (handler3 != null && (messageObtainMessage = handler3.obtainMessage(MyVideoView.this.getNoNetwork())) != null && (handler = MyVideoView.this.mH) != null) {
                                kotlin.coroutines.jvm.internal.b.a(handler.sendMessage(messageObtainMessage));
                            }
                        }
                        break;
                    case 1:
                        p7.g gVar2 = MyVideoView.this.binding;
                        if (gVar2 == null) {
                            kotlin.jvm.internal.m.v("binding");
                            gVar2 = null;
                        }
                        gVar2.f17401t.setVisibility(0);
                        p7.g gVar3 = MyVideoView.this.binding;
                        if (gVar3 == null) {
                            kotlin.jvm.internal.m.v("binding");
                        } else {
                            gVar = gVar3;
                        }
                        gVar.f17401t.setText(MyVideoView.this.getContext().getString(R$string.media_not_free));
                        com.tvc.lib.mobile.ui.widget.b bVar2 = MyVideoView.this.iLoading;
                        if (bVar2 != null) {
                            bVar2.a();
                        }
                        break;
                    case 2:
                        com.tvc.lib.mobile.ui.widget.b bVar3 = MyVideoView.this.iLoading;
                        if (bVar3 != null) {
                            bVar3.a();
                        }
                        p7.g gVar4 = MyVideoView.this.binding;
                        if (gVar4 == null) {
                            kotlin.jvm.internal.m.v("binding");
                            gVar4 = null;
                        }
                        gVar4.f17401t.setVisibility(0);
                        p7.g gVar5 = MyVideoView.this.binding;
                        if (gVar5 == null) {
                            kotlin.jvm.internal.m.v("binding");
                        } else {
                            gVar = gVar5;
                        }
                        gVar.f17401t.setText(MyVideoView.this.getContext().getString(R$string.no_stream_server));
                        break;
                    case 3:
                    case 4:
                        p7.g gVar6 = MyVideoView.this.binding;
                        if (gVar6 == null) {
                            kotlin.jvm.internal.m.v("binding");
                            gVar6 = null;
                        }
                        gVar6.f17401t.setVisibility(0);
                        p7.g gVar7 = MyVideoView.this.binding;
                        if (gVar7 == null) {
                            kotlin.jvm.internal.m.v("binding");
                        } else {
                            gVar = gVar7;
                        }
                        gVar.f17401t.setText(MyVideoView.this.getContext().getString(R$string.kick_out_tip));
                        com.tvc.lib.mobile.ui.widget.b bVar4 = MyVideoView.this.iLoading;
                        if (bVar4 != null) {
                            bVar4.a();
                        }
                        break;
                    case 5:
                        com.tvc.lib.mobile.ui.widget.b bVar5 = MyVideoView.this.iLoading;
                        if (bVar5 != null) {
                            bVar5.a();
                        }
                        p7.g gVar8 = MyVideoView.this.binding;
                        if (gVar8 == null) {
                            kotlin.jvm.internal.m.v("binding");
                            gVar8 = null;
                        }
                        gVar8.f17401t.setVisibility(0);
                        p7.g gVar9 = MyVideoView.this.binding;
                        if (gVar9 == null) {
                            kotlin.jvm.internal.m.v("binding");
                        } else {
                            gVar = gVar9;
                        }
                        gVar.f17401t.setText(MyVideoView.this.getContext().getString(R$string.update_latest_version_to_continue));
                        break;
                    case 6:
                        com.tvc.lib.mobile.ui.widget.b bVar6 = MyVideoView.this.iLoading;
                        if (bVar6 != null) {
                            bVar6.a();
                        }
                        MyVideoView.this.f0(kotlin.coroutines.jvm.internal.b.b(R$drawable.no_signal));
                        if (MyVideoView.this.lastPlayTime >= MyVideoView.this.tipNoSignalOrNoNetworkTime) {
                            MyVideoView.this.tipNoSignalOrNoNetworkTime = d1.d();
                            Handler handler4 = MyVideoView.this.mH;
                            if (handler4 != null && (messageObtainMessage2 = handler4.obtainMessage(MyVideoView.this.getNoSignal())) != null && (handler2 = MyVideoView.this.mH) != null) {
                                kotlin.coroutines.jvm.internal.b.a(handler2.sendMessage(messageObtainMessage2));
                            }
                        }
                        break;
                    case 7:
                        com.tvc.lib.mobile.ui.widget.b bVar7 = MyVideoView.this.iLoading;
                        if (bVar7 != null) {
                            bVar7.a();
                        }
                        p7.g gVar10 = MyVideoView.this.binding;
                        if (gVar10 == null) {
                            kotlin.jvm.internal.m.v("binding");
                            gVar10 = null;
                        }
                        gVar10.f17401t.setVisibility(0);
                        p7.g gVar11 = MyVideoView.this.binding;
                        if (gVar11 == null) {
                            kotlin.jvm.internal.m.v("binding");
                        } else {
                            gVar = gVar11;
                        }
                        gVar.f17401t.setText(MyVideoView.this.getContext().getString(R$string.no_channel_to_switch_in_list));
                        break;
                }
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"com/tvc/lib/mobile/ui/widget/MyVideoView$d", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "", "a", "Z", "isNetworkConnected", "", "b", "Ljava/lang/Integer;", "lastRvChannelItemPosition", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isNetworkConnected;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Integer lastRvChannelItemPosition;

        d(Looper looper) {
            super(looper);
            this.isNetworkConnected = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            super.handleMessage(msg);
            int i10 = msg.what;
            if (i10 == MyVideoView.this.getMessageUpdateProgress()) {
                long j10 = 1000;
                sendMessageDelayed(obtainMessage(MyVideoView.this.getMessageUpdateProgress()), j10 - (MyVideoView.this.d0() % j10));
                return;
            }
            p7.g gVar = null;
            p7.g gVar2 = null;
            p7.g gVar3 = null;
            p7.g gVar4 = null;
            if (i10 == MyVideoView.this.getUpdatePlayBackUi()) {
                p7.g gVar5 = MyVideoView.this.binding;
                if (gVar5 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar5 = null;
                }
                SeekBar progressPlayback = gVar5.f17398q;
                kotlin.jvm.internal.m.e(progressPlayback, "progressPlayback");
                com.tvc.lib.mobile.ext.j.a(progressPlayback, MyVideoView.this.isPlayBack);
                p7.g gVar6 = MyVideoView.this.binding;
                if (gVar6 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar6 = null;
                }
                TextView startTime = gVar6.f17400s;
                kotlin.jvm.internal.m.e(startTime, "startTime");
                com.tvc.lib.mobile.ext.j.a(startTime, MyVideoView.this.isPlayBack);
                p7.g gVar7 = MyVideoView.this.binding;
                if (gVar7 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar7 = null;
                }
                TextView endTime = gVar7.f17388g;
                kotlin.jvm.internal.m.e(endTime, "endTime");
                com.tvc.lib.mobile.ext.j.a(endTime, MyVideoView.this.isPlayBack);
                p7.g gVar8 = MyVideoView.this.binding;
                if (gVar8 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar8 = null;
                }
                AppCompatImageView ivVideoSound = gVar8.f17393l;
                kotlin.jvm.internal.m.e(ivVideoSound, "ivVideoSound");
                com.tvc.lib.mobile.ext.j.a(ivVideoSound, true);
                p7.g gVar9 = MyVideoView.this.binding;
                if (gVar9 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar9 = null;
                }
                MyRelativelayout centerView = gVar9.f17384c;
                kotlin.jvm.internal.m.e(centerView, "centerView");
                com.tvc.lib.mobile.ext.j.a(centerView, MyVideoView.this.isPlayBack);
                p7.g gVar10 = MyVideoView.this.binding;
                if (gVar10 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar2 = gVar10;
                }
                AppCompatImageView ivVideoLove = gVar2.f17392k;
                kotlin.jvm.internal.m.e(ivVideoLove, "ivVideoLove");
                com.tvc.lib.mobile.ext.j.a(ivVideoLove, !MyVideoView.this.isPlayBack);
                return;
            }
            if (i10 == MyVideoView.this.getUpdateVodUi()) {
                p7.g gVar11 = MyVideoView.this.binding;
                if (gVar11 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar11 = null;
                }
                SeekBar progressPlayback2 = gVar11.f17398q;
                kotlin.jvm.internal.m.e(progressPlayback2, "progressPlayback");
                com.tvc.lib.mobile.ext.j.a(progressPlayback2, MyVideoView.this.isVod);
                p7.g gVar12 = MyVideoView.this.binding;
                if (gVar12 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar12 = null;
                }
                TextView startTime2 = gVar12.f17400s;
                kotlin.jvm.internal.m.e(startTime2, "startTime");
                com.tvc.lib.mobile.ext.j.a(startTime2, MyVideoView.this.isVod);
                p7.g gVar13 = MyVideoView.this.binding;
                if (gVar13 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar13 = null;
                }
                TextView endTime2 = gVar13.f17388g;
                kotlin.jvm.internal.m.e(endTime2, "endTime");
                com.tvc.lib.mobile.ext.j.a(endTime2, MyVideoView.this.isVod);
                p7.g gVar14 = MyVideoView.this.binding;
                if (gVar14 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar14 = null;
                }
                AppCompatImageView ivVideoSound2 = gVar14.f17393l;
                kotlin.jvm.internal.m.e(ivVideoSound2, "ivVideoSound");
                com.tvc.lib.mobile.ext.j.a(ivVideoSound2, !MyVideoView.this.isVod);
                p7.g gVar15 = MyVideoView.this.binding;
                if (gVar15 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar15 = null;
                }
                MyRelativelayout centerView2 = gVar15.f17384c;
                kotlin.jvm.internal.m.e(centerView2, "centerView");
                com.tvc.lib.mobile.ext.j.a(centerView2, MyVideoView.this.isVod);
                p7.g gVar16 = MyVideoView.this.binding;
                if (gVar16 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar16 = null;
                }
                AppCompatImageView ivVideoLove2 = gVar16.f17392k;
                kotlin.jvm.internal.m.e(ivVideoLove2, "ivVideoLove");
                com.tvc.lib.mobile.ext.j.a(ivVideoLove2, !MyVideoView.this.isVod);
                p7.g gVar17 = MyVideoView.this.binding;
                if (gVar17 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar3 = gVar17;
                }
                AppCompatImageView ivBack = gVar3.f17390i;
                kotlin.jvm.internal.m.e(ivBack, "ivBack");
                com.tvc.lib.mobile.ext.j.a(ivBack, MyVideoView.this.isVod);
                return;
            }
            if (i10 == MyVideoView.this.getMessageHideCenterBox()) {
                MyVideoView.this.isSlide = false;
                MyVideoView.this.N(R$id.app_video_volume_box).setVisibility(8);
                MyVideoView.this.N(R$id.app_video_brightness_box).setVisibility(8);
                MyVideoView.this.N(R$id.app_video_fastForward_box).setVisibility(8);
                return;
            }
            if (i10 == MyVideoView.this.getHideCtrl()) {
                p7.g gVar18 = MyVideoView.this.binding;
                if (gVar18 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar18 = null;
                }
                if (gVar18.f17399r.getVisibility() == 0) {
                    p7.g gVar19 = MyVideoView.this.binding;
                    if (gVar19 == null) {
                        kotlin.jvm.internal.m.v("binding");
                        gVar19 = null;
                    }
                    RecyclerView.LayoutManager layoutManager = gVar19.f17399r.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                    if (linearLayoutManager != null) {
                        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                        Integer num = this.lastRvChannelItemPosition;
                        if (num == null || iFindFirstVisibleItemPosition != num.intValue()) {
                            this.lastRvChannelItemPosition = Integer.valueOf(iFindFirstVisibleItemPosition);
                            MyVideoView.this.q0();
                            return;
                        }
                    }
                }
                MyVideoView.this.setCtrlVisibility(8);
                return;
            }
            if (i10 == MyVideoView.this.getNoNetwork()) {
                this.isNetworkConnected = false;
                PlayerView playerView = MyVideoView.this.mVideoView;
                if (playerView == null) {
                    kotlin.jvm.internal.m.v("mVideoView");
                    playerView = null;
                }
                if (playerView.z()) {
                    sendEmptyMessageDelayed(MyVideoView.this.getNoNetwork(), 2000L);
                    return;
                }
                if (d0.f21360a.j()) {
                    return;
                }
                p7.g gVar20 = MyVideoView.this.binding;
                if (gVar20 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar20 = null;
                }
                gVar20.f17383b.setVisibility(0);
                p7.g gVar21 = MyVideoView.this.binding;
                if (gVar21 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar4 = gVar21;
                }
                MyButton myButton = gVar4.f17383b;
                final MyVideoView myVideoView = MyVideoView.this;
                myButton.setOnClickListener(new View.OnClickListener() { // from class: com.tvc.lib.mobile.ui.widget.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MyVideoView.d.c(myVideoView, view);
                    }
                });
                return;
            }
            if (i10 == MyVideoView.this.getNoSignal()) {
                PlayerView playerView2 = MyVideoView.this.mVideoView;
                if (playerView2 == null) {
                    kotlin.jvm.internal.m.v("mVideoView");
                    playerView2 = null;
                }
                if (playerView2.z()) {
                    sendEmptyMessageDelayed(MyVideoView.this.getNoNetwork(), 2000L);
                    return;
                }
                if (d0.f21360a.j()) {
                    return;
                }
                p7.g gVar22 = MyVideoView.this.binding;
                if (gVar22 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar22 = null;
                }
                gVar22.f17383b.setVisibility(0);
                p7.g gVar23 = MyVideoView.this.binding;
                if (gVar23 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar = gVar23;
                }
                MyButton myButton2 = gVar.f17383b;
                final MyVideoView myVideoView2 = MyVideoView.this;
                myButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tvc.lib.mobile.ui.widget.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MyVideoView.d.d(myVideoView2, view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(MyVideoView myVideoView, View view) {
            PlayerView playerView = myVideoView.mVideoView;
            p7.g gVar = null;
            if (playerView == null) {
                kotlin.jvm.internal.m.v("mVideoView");
                playerView = null;
            }
            PlayerView.D(playerView, null, null, 3, null);
            myVideoView.g0();
            p7.g gVar2 = myVideoView.binding;
            if (gVar2 == null) {
                kotlin.jvm.internal.m.v("binding");
            } else {
                gVar = gVar2;
            }
            gVar.f17383b.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(MyVideoView myVideoView, View view) {
            PlayerView playerView = myVideoView.mVideoView;
            p7.g gVar = null;
            if (playerView == null) {
                kotlin.jvm.internal.m.v("mVideoView");
                playerView = null;
            }
            PlayerView.D(playerView, null, null, 3, null);
            myVideoView.g0();
            p7.g gVar2 = myVideoView.binding;
            if (gVar2 == null) {
                kotlin.jvm.internal.m.v("binding");
            } else {
                gVar = gVar2;
            }
            gVar.f17383b.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/tvc/lib/mobile/ui/widget/MyVideoView$e", "Lw7/a$c;", "", "volume", "Lr8/z;", "a", "(I)V", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements w7.a.c {
        @Override // w7.a.c
        public void a(int volume) {
            p7.g gVar = null;
            if (volume == 0) {
                p7.g gVar2 = MyVideoView.this.binding;
                if (gVar2 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar = gVar2;
                }
                gVar.f17393l.setImageResource(R$mipmap.voice_close);
            } else if (volume > 0) {
                p7.g gVar3 = MyVideoView.this.binding;
                if (gVar3 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar = gVar3;
                }
                gVar.f17393l.setImageResource(R$mipmap.voice_open);
            }
            MyVideoView.this.q0();
        }

        e() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.tvc.lib.mobile.ui.widget.MyVideoView$resetTipMsg$1", f = "MyVideoView.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        int label;

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return MyVideoView.this.new f(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                p7.g gVar = MyVideoView.this.binding;
                p7.g gVar2 = null;
                if (gVar == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar = null;
                }
                gVar.f17401t.setVisibility(8);
                p7.g gVar3 = MyVideoView.this.binding;
                if (gVar3 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar2 = gVar3;
                }
                gVar2.f17401t.setText("");
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyVideoView(Context context) {
        super(context);
        kotlin.jvm.internal.m.f(context, "context");
        this.logger = q6.c.d(MyVideoView.class);
        this.lastVolume = -1;
        this.stateIdle = -1;
        this.statePlaying = 1;
        this.statePlayCompleted = 2;
        this.stateSeek = 3;
        this.playState = -1;
        this.messageBase = 36864;
        this.messageUpdateProgress = 36864;
        int i10 = 36864 + 1;
        this.updatePlayBackUi = i10;
        this.messageHideCenterBox = i10 + 1;
        this.updateVodUi = i10 + 2;
        this.hideCtrl = i10 + 3;
        this.noNetwork = i10 + 4;
        this.noSignal = i10 + 5;
        this.seekBarPosition = -1L;
        this.pausePosition = 0L;
        this.EXIT_MENU_TIME = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.speedList = kotlin.collections.r.o(Float.valueOf(1.0f), Float.valueOf(1.5f), Float.valueOf(2.0f));
        this.mVolumeChangeListener = new e();
        this.mH = new d(Looper.getMainLooper());
        this.mTask = new Runnable() { // from class: com.tvc.lib.mobile.ui.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                MyVideoView.e0(this.f9311a);
            }
        };
        O(context, null);
    }

    private final void J() {
        this.volume = -1;
        this.brightness = -1.0f;
        Handler handler = this.mH;
        if (handler != null) {
            handler.removeMessages(this.messageHideCenterBox);
        }
        Handler handler2 = this.mH;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(this.messageHideCenterBox, 500L);
        }
    }

    private final void O(Context context, AttributeSet attrs) {
        try {
            this.binding = (p7.g) DataBindingUtil.inflate(LayoutInflater.from(context), R$layout.layout_my_video_view, this, true);
        } catch (Throwable th) {
            this.logger.error("inflater failure", th);
        }
        p7.g gVar = this.binding;
        p7.g gVar2 = null;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        this.mVideoView = gVar.f17385d;
        z7.j jVar = z7.j.f23105a;
        int i10 = R$id.loading_layout_tvc_lib;
        int i11 = R$color.white;
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar2 = gVar3;
        }
        this.iLoading = z7.j.i(jVar, i10, i11, gVar2.f17387f, 0, 8, null);
        Object systemService = getContext().getSystemService("audio");
        kotlin.jvm.internal.m.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        this.audioManager = audioManager;
        kotlin.jvm.internal.m.c(audioManager);
        this.mMaxVolume = audioManager.getStreamMaxVolume(3);
        P();
        a0();
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x007c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0085  */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0092  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    public static final boolean V(MyVideoView myVideoView, IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        p7.g gVar;
        if (i10 == 3) {
            myVideoView.playState = myVideoView.statePlaying;
            if (myVideoView.isPlayBack || myVideoView.isVod) {
                handler = myVideoView.mH;
                if (handler != null) {
                    handler.removeMessages(myVideoView.messageUpdateProgress);
                }
                handler2 = myVideoView.mH;
                if (handler2 != null) {
                    handler2.sendEmptyMessage(myVideoView.messageUpdateProgress);
                }
            }
            if (myVideoView.isVod) {
                gVar = myVideoView.binding;
                if (gVar == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar = null;
                }
                gVar.f17394m.setVisibility(0);
            }
            myVideoView.m0();
            if (myVideoView.speedIndex >= 0) {
                myVideoView.speedList.size();
            }
            handler3 = myVideoView.mH;
            if (handler3 != null) {
                handler3.removeCallbacks(myVideoView.mTask);
            }
            handler4 = myVideoView.mH;
            if (handler4 != null) {
                handler4.postDelayed(myVideoView.mTask, myVideoView.EXIT_MENU_TIME);
            }
        } else if (i10 == 701) {
            int i12 = myVideoView.playState;
            int i13 = myVideoView.statePlaying;
            if (i12 != i13 && i12 != myVideoView.stateIdle) {
                myVideoView.playState = i13;
                if (myVideoView.isPlayBack || myVideoView.isVod) {
                    Handler handler5 = myVideoView.mH;
                    if (handler5 != null) {
                        handler5.removeMessages(myVideoView.messageUpdateProgress);
                    }
                    Handler handler6 = myVideoView.mH;
                    if (handler6 != null) {
                        handler6.sendEmptyMessage(myVideoView.messageUpdateProgress);
                    }
                }
                myVideoView.m0();
                Handler handler7 = myVideoView.mH;
                if (handler7 != null) {
                    handler7.removeCallbacks(myVideoView.mTask);
                }
                Handler handler8 = myVideoView.mH;
                if (handler8 != null) {
                    handler8.postDelayed(myVideoView.mTask, myVideoView.EXIT_MENU_TIME);
                }
            }
        } else if (i10 == 904) {
            myVideoView.playState = myVideoView.statePlaying;
            if (myVideoView.isPlayBack) {
                handler = myVideoView.mH;
                if (handler != null) {
                    handler.removeMessages(myVideoView.messageUpdateProgress);
                }
                handler2 = myVideoView.mH;
                if (handler2 != null) {
                    handler2.sendEmptyMessage(myVideoView.messageUpdateProgress);
                }
            } else {
                handler = myVideoView.mH;
                if (handler != null) {
                    handler.removeMessages(myVideoView.messageUpdateProgress);
                }
                handler2 = myVideoView.mH;
                if (handler2 != null) {
                    handler2.sendEmptyMessage(myVideoView.messageUpdateProgress);
                }
            }
            if (myVideoView.isVod) {
                gVar = myVideoView.binding;
                if (gVar == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar = null;
                }
                gVar.f17394m.setVisibility(0);
            }
            myVideoView.m0();
            if (myVideoView.speedIndex >= 0) {
                myVideoView.speedList.size();
            }
            handler3 = myVideoView.mH;
            if (handler3 != null) {
                handler3.removeCallbacks(myVideoView.mTask);
            }
            handler4 = myVideoView.mH;
            if (handler4 != null) {
                handler4.postDelayed(myVideoView.mTask, myVideoView.EXIT_MENU_TIME);
            }
        } else if (i10 == 10008 && (myVideoView.isPlayBack || myVideoView.isVod)) {
            Handler handler9 = myVideoView.mH;
            if (handler9 != null) {
                handler9.removeMessages(myVideoView.messageUpdateProgress);
            }
            Handler handler10 = myVideoView.mH;
            if (handler10 != null) {
                handler10.sendEmptyMessage(myVideoView.messageUpdateProgress);
            }
        }
        return false;
    }

    public static /* synthetic */ void p0(MyVideoView myVideoView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        myVideoView.o0(z10);
    }

    private final void setPlayCompleted(final IMediaPlayer mediaPlayer) {
        TextView textView;
        this.isPause = true;
        Handler handler = this.mH;
        if (handler != null) {
            handler.removeMessages(this.messageUpdateProgress);
        }
        PlayerView playerView = this.mVideoView;
        p7.g gVar = null;
        if (playerView == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView = null;
        }
        playerView.J(true);
        this.playState = this.statePlayCompleted;
        TextView textView2 = this.startTime;
        if (textView2 != null && (textView = this.endTime) != null && textView2 != null) {
            textView2.setText(textView != null ? textView.getText() : null);
        }
        p7.g gVar2 = this.binding;
        if (gVar2 == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar2 = null;
        }
        gVar2.f17401t.setVisibility(0);
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar = gVar3;
        }
        gVar.f17401t.setText(getContext().getString(R$string.vod_play_complete));
        post(new Runnable() { // from class: com.tvc.lib.mobile.ui.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                MyVideoView.k0(this.f9307a, mediaPlayer);
            }
        });
    }

    private final void I() {
        p7.g gVar = null;
        if (this.isFullScreen) {
            p7.g gVar2 = this.binding;
            if (gVar2 == null) {
                kotlin.jvm.internal.m.v("binding");
            } else {
                gVar = gVar2;
            }
            gVar.f17382a.getVisibility();
            return;
        }
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar = gVar3;
        }
        gVar.f17382a.getVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String K(long time) {
        long j10 = time / ((long) 1000);
        long j11 = 60;
        long j12 = j10 % j11;
        long j13 = (j10 / j11) % j11;
        long j14 = j10 / ((long) 3600);
        if (j14 > 0) {
            g0 g0Var = g0.f12340a;
            String str = String.format(Locale.ENGLISH, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j14), Long.valueOf(j13), Long.valueOf(j12)}, 3));
            kotlin.jvm.internal.m.e(str, "format(...)");
            return str;
        }
        g0 g0Var2 = g0.f12340a;
        String str2 = String.format(Locale.ENGLISH, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j13), Long.valueOf(j12)}, 2));
        kotlin.jvm.internal.m.e(str2, "format(...)");
        return str2;
    }

    private final void L() {
        p7.g gVar = this.binding;
        p7.g gVar2 = null;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        gVar.f17384c.setVisibility(8);
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar2 = gVar3;
        }
        gVar2.f17382a.setVisibility(8);
        I();
    }

    private final void M() {
        p7.g gVar = this.binding;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        gVar.f17402u.setVisibility(8);
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.a("player_ctrl hideTopView", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View N(int resId) {
        p7.g gVar = this.binding;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        View viewFindViewById = gVar.f17389h.findViewById(resId);
        kotlin.jvm.internal.m.e(viewFindViewById, "findViewById(...)");
        return viewFindViewById;
    }

    private final void P() {
        AudioManager audioManager = this.audioManager;
        p7.g gVar = null;
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getStreamVolume(3)) : null;
        if (numValueOf != null && numValueOf.intValue() <= 0) {
            p7.g gVar2 = this.binding;
            if (gVar2 == null) {
                kotlin.jvm.internal.m.v("binding");
                gVar2 = null;
            }
            gVar2.f17393l.setImageResource(R$mipmap.voice_close);
        }
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar = gVar3;
        }
        gVar.f17393l.setOnClickListener(new View.OnClickListener() { // from class: com.tvc.lib.mobile.ui.widget.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyVideoView.Q(this.f9484a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(MyVideoView myVideoView, View view) {
        AudioManager audioManager = myVideoView.audioManager;
        p7.g gVar = null;
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getStreamVolume(3)) : null;
        if (numValueOf == null || numValueOf.intValue() > 0) {
            AudioManager audioManager2 = myVideoView.audioManager;
            myVideoView.lastVolume = audioManager2 != null ? Integer.valueOf(audioManager2.getStreamVolume(3)) : null;
            AudioManager audioManager3 = myVideoView.audioManager;
            if (audioManager3 != null) {
                audioManager3.setStreamVolume(3, 0, 0);
            }
            p7.g gVar2 = myVideoView.binding;
            if (gVar2 == null) {
                kotlin.jvm.internal.m.v("binding");
            } else {
                gVar = gVar2;
            }
            gVar.f17393l.setImageResource(R$mipmap.voice_close);
            return;
        }
        int iIntValue = (int) (((double) myVideoView.mMaxVolume) * 0.5d);
        Integer num = myVideoView.lastVolume;
        kotlin.jvm.internal.m.c(num);
        if (num.intValue() > 0) {
            Integer num2 = myVideoView.lastVolume;
            kotlin.jvm.internal.m.c(num2);
            iIntValue = num2.intValue();
        }
        int i10 = myVideoView.mMaxVolume;
        if (iIntValue > i10) {
            iIntValue = i10;
        } else if (iIntValue < 0) {
            iIntValue = 0;
        }
        AudioManager audioManager4 = myVideoView.audioManager;
        if (audioManager4 != null) {
            audioManager4.setStreamVolume(3, iIntValue, 0);
        }
        p7.g gVar3 = myVideoView.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar = gVar3;
        }
        gVar.f17393l.setImageResource(R$mipmap.voice_open);
    }

    private final void R() {
        p7.g gVar = this.binding;
        p7.g gVar2 = null;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        this.progressBar = gVar.f17398q;
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar3 = null;
        }
        this.startTime = gVar3.f17400s;
        p7.g gVar4 = this.binding;
        if (gVar4 == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar4 = null;
        }
        this.endTime = gVar4.f17388g;
        SeekBar seekBar = this.progressBar;
        if (seekBar != null) {
            seekBar.setMax(1000);
        }
        PlayerView playerView = this.mVideoView;
        if (playerView == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView = null;
        }
        playerView.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: com.tvc.lib.mobile.ui.widget.g
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
                return MyVideoView.V(this.f9476a, iMediaPlayer, i10, i11, str);
            }
        });
        PlayerView playerView2 = this.mVideoView;
        if (playerView2 == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView2 = null;
        }
        playerView2.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: com.tvc.lib.mobile.ui.widget.h
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                MyVideoView.W(this.f9477a, iMediaPlayer);
            }
        });
        PlayerView playerView3 = this.mVideoView;
        if (playerView3 == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView3 = null;
        }
        playerView3.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.tvc.lib.mobile.ui.widget.i
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                return MyVideoView.S(this.f9478a, iMediaPlayer, i10, i11);
            }
        });
        PlayerView playerView4 = this.mVideoView;
        if (playerView4 == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView4 = null;
        }
        playerView4.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() { // from class: com.tvc.lib.mobile.ui.widget.j
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                MyVideoView.T(this.f9479a, iMediaPlayer);
            }
        });
        SeekBar seekBar2 = this.progressBar;
        if (seekBar2 != null) {
            seekBar2.setOnSeekBarChangeListener(new b());
        }
        p7.g gVar5 = this.binding;
        if (gVar5 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar2 = gVar5;
        }
        gVar2.f17397p.setOnClickListener(new View.OnClickListener() { // from class: com.tvc.lib.mobile.ui.widget.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyVideoView.U(this.f9480a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S(MyVideoView myVideoView, IMediaPlayer iMediaPlayer, int i10, int i11) {
        IMediaPlayer.OnErrorListener onErrorListener = myVideoView.onErrorListener;
        if (onErrorListener == null) {
            return true;
        }
        onErrorListener.onError(iMediaPlayer, i10, i11);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(MyVideoView myVideoView, View view) {
        Resources resources;
        Resources resources2;
        int i10 = myVideoView.playState;
        if (i10 == myVideoView.statePlaying || i10 == myVideoView.statePlayCompleted) {
            PlayerView playerView = null;
            if (myVideoView.isPause) {
                p7.g gVar = myVideoView.binding;
                if (gVar == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar = null;
                }
                MyRoundImageView myRoundImageView = gVar.f17397p;
                Context context = myVideoView.getContext();
                myRoundImageView.setBackground((context == null || (resources = context.getResources()) == null) ? null : resources.getDrawable(R$mipmap.playback_pause_icon));
                if (myVideoView.playState == myVideoView.statePlayCompleted) {
                    if (myVideoView.mVideoView == null) {
                        kotlin.jvm.internal.m.v("mVideoView");
                    }
                    PlayerView playerView2 = myVideoView.mVideoView;
                    if (playerView2 == null) {
                        kotlin.jvm.internal.m.v("mVideoView");
                        playerView2 = null;
                    }
                    PlayerView.D(playerView2, "update view " + myVideoView.playState, null, 2, null);
                } else {
                    if (myVideoView.mVideoView == null) {
                        kotlin.jvm.internal.m.v("mVideoView");
                    }
                    PlayerView playerView3 = myVideoView.mVideoView;
                    if (playerView3 == null) {
                        kotlin.jvm.internal.m.v("mVideoView");
                    } else {
                        playerView = playerView3;
                    }
                    playerView.G();
                }
                Handler handler = myVideoView.mH;
                if (handler != null) {
                    handler.sendEmptyMessage(myVideoView.messageUpdateProgress);
                }
            } else {
                p7.g gVar2 = myVideoView.binding;
                if (gVar2 == null) {
                    kotlin.jvm.internal.m.v("binding");
                    gVar2 = null;
                }
                MyRoundImageView myRoundImageView2 = gVar2.f17397p;
                Context context2 = myVideoView.getContext();
                myRoundImageView2.setBackground((context2 == null || (resources2 = context2.getResources()) == null) ? null : resources2.getDrawable(R$mipmap.playback_play_icon));
                Handler handler2 = myVideoView.mH;
                if (handler2 != null) {
                    handler2.removeMessages(myVideoView.messageUpdateProgress);
                }
                PlayerView playerView4 = myVideoView.mVideoView;
                if (playerView4 == null) {
                    kotlin.jvm.internal.m.v("mVideoView");
                    playerView4 = null;
                }
                playerView4.B();
                PlayerView playerView5 = myVideoView.mVideoView;
                if (playerView5 == null) {
                    kotlin.jvm.internal.m.v("mVideoView");
                } else {
                    playerView = playerView5;
                }
                myVideoView.pausePosition = Long.valueOf(playerView.getPosition());
            }
            myVideoView.isPause = !myVideoView.isPause;
        }
    }

    private final void X() {
        PlayerView playerView = this.mVideoView;
        PlayerView playerView2 = null;
        if (playerView == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView = null;
        }
        playerView.setLoadingListener(new c9.p() { // from class: com.tvc.lib.mobile.ui.widget.d
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return MyVideoView.Y(this.f9309a, ((Boolean) obj).booleanValue(), (String) obj2);
            }
        });
        PlayerView playerView3 = this.mVideoView;
        if (playerView3 == null) {
            kotlin.jvm.internal.m.v("mVideoView");
        } else {
            playerView2 = playerView3;
        }
        playerView2.setNoSignalListener(new c9.p() { // from class: com.tvc.lib.mobile.ui.widget.e
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return MyVideoView.Z(this.f9310a, ((Integer) obj).intValue(), (String) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z Y(MyVideoView myVideoView, boolean z10, String loadingTip) {
        kotlin.jvm.internal.m.f(loadingTip, "loadingTip");
        if (z10) {
            com.tvc.lib.mobile.ui.widget.b bVar = myVideoView.iLoading;
            if (bVar != null) {
                bVar.b();
            }
        } else {
            com.tvc.lib.mobile.ui.widget.b bVar2 = myVideoView.iLoading;
            if (bVar2 != null) {
                bVar2.a();
            }
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z Z(MyVideoView myVideoView, int i10, String desc) {
        kotlin.jvm.internal.m.f(desc, "desc");
        kotlinx.coroutines.j.d(m0.b(), null, null, myVideoView.new c(i10, null), 3, null);
        return z.f17874a;
    }

    private final void a0() {
        Context context = getContext();
        kotlin.jvm.internal.m.e(context, "getContext(...)");
        w7.a aVar = new w7.a(context);
        this.mVolumeChangeObserver = aVar;
        kotlin.jvm.internal.m.c(aVar);
        aVar.e(this.mVolumeChangeListener);
        w7.a aVar2 = this.mVolumeChangeObserver;
        if (aVar2 == null || this.mVolumeChangeRegister) {
            return;
        }
        kotlin.jvm.internal.m.c(aVar2);
        aVar2.c();
        this.mVolumeChangeRegister = true;
    }

    private final long getVideoCurrentPosition() {
        PlayerView playerView = this.mVideoView;
        if (playerView == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView = null;
        }
        return playerView.getPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getVideoDuration() {
        PlayerView playerView = this.mVideoView;
        if (playerView == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView = null;
        }
        long duration = playerView.getDuration();
        return duration == 0 ? this.lastDuration : duration;
    }

    static /* synthetic */ void j0(MyVideoView myVideoView, IMediaPlayer iMediaPlayer, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iMediaPlayer = null;
        }
        myVideoView.setPlayCompleted(iMediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(MyVideoView myVideoView, IMediaPlayer iMediaPlayer) {
        IMediaPlayer.OnCompletionListener onCompletionListener = myVideoView.onCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(iMediaPlayer);
        }
    }

    private final void m0() {
        p7.g gVar = null;
        if (this.isPlayBack || this.isVod) {
            p7.g gVar2 = this.binding;
            if (gVar2 == null) {
                kotlin.jvm.internal.m.v("binding");
                gVar2 = null;
            }
            gVar2.f17384c.setVisibility(0);
        }
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar = gVar3;
        }
        gVar.f17382a.setVisibility(0);
        I();
    }

    private final void n0() {
        p7.g gVar = this.binding;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        gVar.f17402u.setVisibility(0);
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.a("player_ctrl showTopView", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCtrlVisibility(int visibility) {
        if (x1.f1.lb.config.b.f20643a.t()) {
            if (visibility == 0) {
                this.logger.a("player_ctrl showCtrlView", new Object[0]);
            } else {
                this.logger.a("player_ctrl hideCtrlView", new Object[0]);
            }
        }
        if (visibility == 0) {
            n0();
            m0();
        } else {
            M();
            L();
        }
        p7.g gVar = null;
        if (!this.isFullScreen) {
            p7.g gVar2 = this.binding;
            if (gVar2 == null) {
                kotlin.jvm.internal.m.v("binding");
                gVar2 = null;
            }
            gVar2.f17399r.setVisibility(8);
            if (this.isPlayBack) {
                p7.g gVar3 = this.binding;
                if (gVar3 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar = gVar3;
                }
                gVar.f17397p.setVisibility(visibility);
                return;
            }
            return;
        }
        if (!this.isPlayBack) {
            if (visibility == 8) {
                p7.g gVar4 = this.binding;
                if (gVar4 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar = gVar4;
                }
                gVar.f17399r.setVisibility(visibility);
                return;
            }
            return;
        }
        p7.g gVar5 = this.binding;
        if (gVar5 == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar5 = null;
        }
        gVar5.f17399r.setVisibility(8);
        p7.g gVar6 = this.binding;
        if (gVar6 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar = gVar6;
        }
        gVar.f17397p.setVisibility(visibility);
    }

    private final void setNoSignalImage(Integer resId) {
        p7.g gVar = this.binding;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        ImageView livenewaIvNoSignal = gVar.f17395n;
        kotlin.jvm.internal.m.e(livenewaIvNoSignal, "livenewaIvNoSignal");
        try {
            livenewaIvNoSignal.setImageResource(resId != null ? resId.intValue() : R$drawable.no_signal);
            livenewaIvNoSignal.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: b0, reason: from getter */
    public final boolean getIsPlayBack() {
        return this.isPlayBack;
    }

    public final boolean c0() {
        return this.playState == this.statePlayCompleted;
    }

    public final void f0(Integer resId) {
        PlayerView playerView = this.mVideoView;
        if (playerView == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView = null;
        }
        playerView.J(true);
        setNoSignalImage(resId);
    }

    public final void g0() {
        p7.g gVar = this.binding;
        p7.g gVar2 = null;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        if (gVar.f17395n.getVisibility() != 4) {
            p7.g gVar3 = this.binding;
            if (gVar3 == null) {
                kotlin.jvm.internal.m.v("binding");
                gVar3 = null;
            }
            gVar3.f17395n.setVisibility(4);
        }
        p7.g gVar4 = this.binding;
        if (gVar4 == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar4 = null;
        }
        if (gVar4.f17383b.getVisibility() == 0) {
            p7.g gVar5 = this.binding;
            if (gVar5 == null) {
                kotlin.jvm.internal.m.v("binding");
            } else {
                gVar2 = gVar5;
            }
            gVar2.f17383b.setVisibility(8);
        }
        this.lastPlayTime = d1.d();
    }

    public final p7.g getBinding() {
        p7.g gVar = this.binding;
        if (gVar != null) {
            return gVar;
        }
        kotlin.jvm.internal.m.v("binding");
        return null;
    }

    public final int getHideCtrl() {
        return this.hideCtrl;
    }

    public final boolean getIsSlide() {
        return this.isSlide;
    }

    public final int getMessageHideCenterBox() {
        return this.messageHideCenterBox;
    }

    public final int getMessageUpdateProgress() {
        return this.messageUpdateProgress;
    }

    public final int getNoNetwork() {
        return this.noNetwork;
    }

    public final int getNoSignal() {
        return this.noSignal;
    }

    public final int getUpdatePlayBackUi() {
        return this.updatePlayBackUi;
    }

    public final int getUpdateVodUi() {
        return this.updateVodUi;
    }

    public final PlayerView getVideoView() {
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            return playerView;
        }
        kotlin.jvm.internal.m.v("mVideoView");
        return null;
    }

    public final p7.g getViewBinding() {
        p7.g gVar = this.binding;
        if (gVar != null) {
            return gVar;
        }
        kotlin.jvm.internal.m.v("binding");
        return null;
    }

    public final void h0() {
        p7.g gVar = this.binding;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        if (gVar.f17401t.getVisibility() != 8) {
            kotlinx.coroutines.j.d(m0.b(), null, null, new f(null), 3, null);
        }
    }

    public final void q0() {
        Message messageObtainMessage;
        Handler handler;
        Handler handler2 = this.mH;
        if (handler2 != null) {
            handler2.removeMessages(this.hideCtrl);
        }
        Handler handler3 = this.mH;
        if (handler3 == null || (messageObtainMessage = handler3.obtainMessage(this.hideCtrl)) == null || (handler = this.mH) == null) {
            return;
        }
        handler.sendMessageDelayed(messageObtainMessage, 8000L);
    }

    public final void setFullScreenModel(boolean fullScreen) {
        this.isFullScreen = fullScreen;
        p7.g gVar = this.binding;
        p7.g gVar2 = null;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        AppCompatImageView ivBack = gVar.f17390i;
        kotlin.jvm.internal.m.e(ivBack, "ivBack");
        com.tvc.lib.mobile.ext.j.a(ivBack, this.isFullScreen);
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar3 = null;
        }
        gVar3.f17391j.setImageResource(this.isFullScreen ? R$drawable.player_exit_full_screen : R$drawable.player_enter_full_screen);
        if (this.isFullScreen) {
            p7.g gVar4 = this.binding;
            if (gVar4 == null) {
                kotlin.jvm.internal.m.v("binding");
                gVar4 = null;
            }
            String strE = ua.n.E(gVar4.f17405x.getText().toString(), "\n", " - ", false, 4, null);
            p7.g gVar5 = this.binding;
            if (gVar5 == null) {
                kotlin.jvm.internal.m.v("binding");
            } else {
                gVar2 = gVar5;
            }
            gVar2.f17405x.setText(strE);
            return;
        }
        p7.g gVar6 = this.binding;
        if (gVar6 == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar6 = null;
        }
        String strE2 = ua.n.E(gVar6.f17405x.getText().toString(), " - ", "\n", false, 4, null);
        p7.g gVar7 = this.binding;
        if (gVar7 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar2 = gVar7;
        }
        gVar2.f17405x.setText(strE2);
    }

    public final void setGestureListener(GestureDetector.OnGestureListener listener) {
        Context context = getContext();
        kotlin.jvm.internal.m.c(listener);
        final GestureDetector gestureDetector = new GestureDetector(context, listener);
        p7.g gVar = this.binding;
        p7.g gVar2 = null;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        gVar.f17387f.setClickable(true);
        p7.g gVar3 = this.binding;
        if (gVar3 == null) {
            kotlin.jvm.internal.m.v("binding");
        } else {
            gVar2 = gVar3;
        }
        gVar2.f17387f.setOnTouchListener(new View.OnTouchListener() { // from class: com.tvc.lib.mobile.ui.widget.m
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MyVideoView.i0(this.f9482a, gestureDetector, view, motionEvent);
            }
        });
    }

    public final void setNoSignalListener(x1.f1.lb.util.m<Integer> listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.noSignalListener = listener;
    }

    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.onCompletionListener = listener;
    }

    public final void setOnErrorListener(IMediaPlayer.OnErrorListener listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.onErrorListener = listener;
    }

    public final void setOnMenuClickListener(a onVodMenuClickListener) {
        kotlin.jvm.internal.m.f(onVodMenuClickListener, "onVodMenuClickListener");
    }

    public final void setPlayBackMode(boolean isPlayBack) {
        this.isPlayBack = isPlayBack;
        Handler handler = this.mH;
        if (handler != null) {
            handler.sendEmptyMessage(this.updatePlayBackUi);
        }
        if (!isPlayBack) {
            Handler handler2 = this.mH;
            if (handler2 != null) {
                handler2.removeMessages(this.messageUpdateProgress);
                return;
            }
            return;
        }
        this.playState = this.stateIdle;
        this.lastPosition = null;
        this.lastTime = 0L;
        Handler handler3 = this.mH;
        if (handler3 != null) {
            handler3.removeMessages(this.messageUpdateProgress);
        }
        Handler handler4 = this.mH;
        if (handler4 != null) {
            handler4.sendEmptyMessage(this.messageUpdateProgress);
        }
        if (this.isPlayBackInit) {
            return;
        }
        R();
        this.isPlayBackInit = true;
    }

    public final void setTrialImg(@DrawableRes int imgResId) {
        PlayerView playerView = this.mVideoView;
        if (playerView == null) {
            kotlin.jvm.internal.m.v("mVideoView");
            playerView = null;
        }
        playerView.setTrialImg(imgResId);
    }

    public final void setVodMode(boolean isVod) {
        this.isVod = isVod;
        if (isVod) {
            this.playState = this.stateIdle;
            p7.g gVar = null;
            this.lastPosition = null;
            this.lastTime = 0L;
            Handler handler = this.mH;
            if (handler != null) {
                handler.removeMessages(this.messageUpdateProgress);
            }
            Handler handler2 = this.mH;
            if (handler2 != null) {
                handler2.sendEmptyMessage(this.messageUpdateProgress);
            }
            if (!this.isVodInit) {
                R();
                p7.g gVar2 = this.binding;
                if (gVar2 == null) {
                    kotlin.jvm.internal.m.v("binding");
                } else {
                    gVar = gVar2;
                }
                gVar.f17394m.setOnClickListener(new View.OnClickListener() { // from class: com.tvc.lib.mobile.ui.widget.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MyVideoView.l0(this.f9481a, view);
                    }
                });
                this.isVodInit = true;
            }
        } else {
            Handler handler3 = this.mH;
            if (handler3 != null) {
                handler3.removeMessages(this.messageUpdateProgress);
            }
        }
        Handler handler4 = this.mH;
        if (handler4 != null) {
            handler4.sendEmptyMessage(this.updateVodUi);
        }
    }

    public final void setWindow(Window window) {
        kotlin.jvm.internal.m.f(window, "window");
        this.window = window;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(MyVideoView myVideoView, IMediaPlayer iMediaPlayer) {
        myVideoView.setPlayCompleted(iMediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(MyVideoView myVideoView, IMediaPlayer iMediaPlayer) {
        Handler handler;
        myVideoView.h0();
        if ((myVideoView.isPlayBack || myVideoView.isVod) && (handler = myVideoView.mH) != null) {
            handler.sendEmptyMessage(myVideoView.messageUpdateProgress);
        }
        myVideoView.lastPlayTime = d1.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long d0() {
        Resources resources;
        long videoCurrentPosition = getVideoCurrentPosition();
        Long l10 = this.lastPosition;
        if (l10 != null && videoCurrentPosition > l10.longValue() && d1.d() - this.lastTime <= 2000 && this.isPause && (this.isPlayBack || this.isVod)) {
            p7.g gVar = this.binding;
            Drawable drawable = null;
            if (gVar == null) {
                kotlin.jvm.internal.m.v("binding");
                gVar = null;
            }
            MyRoundImageView myRoundImageView = gVar.f17397p;
            Context context = getContext();
            if (context != null && (resources = context.getResources()) != null) {
                drawable = resources.getDrawable(R$mipmap.playback_pause_icon);
            }
            myRoundImageView.setBackground(drawable);
            this.isPause = !this.isPause;
        }
        long videoDuration = getVideoDuration();
        if (videoDuration > 0 && videoCurrentPosition > 0) {
            long j10 = (1000 * videoCurrentPosition) / videoDuration;
            SeekBar seekBar = this.progressBar;
            if (seekBar != null && seekBar != null) {
                seekBar.setProgress((int) j10);
            }
            TextView textView = this.startTime;
            if (textView != null && textView != null) {
                textView.setText(K(videoCurrentPosition));
            }
            TextView textView2 = this.endTime;
            if (textView2 != null && textView2 != null) {
                textView2.setText(K(videoDuration));
            }
            if (this.lastDuration != videoDuration) {
                this.lastDuration = videoDuration;
            }
            Long l11 = this.lastPosition;
            if (l11 == null || l11.longValue() != videoCurrentPosition) {
                this.lastPosition = Long.valueOf(videoCurrentPosition);
                h0();
            }
        }
        this.lastTime = d1.d();
        return videoCurrentPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(MyVideoView myVideoView) {
        myVideoView.L();
        myVideoView.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i0(MyVideoView myVideoView, GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            Handler handler = myVideoView.mH;
            if (handler != null) {
                handler.removeCallbacks(myVideoView.mTask);
            }
            Handler handler2 = myVideoView.mH;
            if (handler2 != null) {
                handler2.postDelayed(myVideoView.mTask, myVideoView.EXIT_MENU_TIME);
            }
        }
        if ((motionEvent.getAction() & 255) == 1) {
            myVideoView.J();
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(MyVideoView myVideoView, View view) {
        myVideoView.getClass();
    }

    public final void o0(boolean isProgrammeChanged) {
        g0();
        setCtrlVisibility(0);
        q0();
        h0();
        if (isProgrammeChanged) {
            SeekBar seekBar = this.progressBar;
            if (seekBar != null) {
                seekBar.setProgress(0);
            }
            TextView textView = this.startTime;
            if (textView != null) {
                textView.setText("00:00");
            }
            TextView textView2 = this.endTime;
            if (textView2 != null) {
                textView2.setText("--:--");
            }
            this.lastDuration = 0L;
            this.lastPosition = 0L;
        }
        p7.g gVar = this.binding;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        gVar.f17383b.setVisibility(8);
    }

    public final void r0() {
        int i10;
        q0();
        p7.g gVar = this.binding;
        if (gVar == null) {
            kotlin.jvm.internal.m.v("binding");
            gVar = null;
        }
        if (gVar.f17402u.getVisibility() == 0) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        setCtrlVisibility(i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.f(context, "context");
        this.logger = q6.c.d(MyVideoView.class);
        this.lastVolume = -1;
        this.stateIdle = -1;
        this.statePlaying = 1;
        this.statePlayCompleted = 2;
        this.stateSeek = 3;
        this.playState = -1;
        this.messageBase = 36864;
        this.messageUpdateProgress = 36864;
        int i10 = 36864 + 1;
        this.updatePlayBackUi = i10;
        this.messageHideCenterBox = i10 + 1;
        this.updateVodUi = i10 + 2;
        this.hideCtrl = i10 + 3;
        this.noNetwork = i10 + 4;
        this.noSignal = i10 + 5;
        this.seekBarPosition = -1L;
        this.pausePosition = 0L;
        this.EXIT_MENU_TIME = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.speedList = kotlin.collections.r.o(Float.valueOf(1.0f), Float.valueOf(1.5f), Float.valueOf(2.0f));
        this.mVolumeChangeListener = new e();
        this.mH = new d(Looper.getMainLooper());
        this.mTask = new Runnable() { // from class: com.tvc.lib.mobile.ui.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                MyVideoView.e0(this.f9311a);
            }
        };
        O(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.m.f(context, "context");
        this.logger = q6.c.d(MyVideoView.class);
        this.lastVolume = -1;
        this.stateIdle = -1;
        this.statePlaying = 1;
        this.statePlayCompleted = 2;
        this.stateSeek = 3;
        this.playState = -1;
        this.messageBase = 36864;
        this.messageUpdateProgress = 36864;
        int i11 = 36864 + 1;
        this.updatePlayBackUi = i11;
        this.messageHideCenterBox = i11 + 1;
        this.updateVodUi = i11 + 2;
        this.hideCtrl = i11 + 3;
        this.noNetwork = i11 + 4;
        this.noSignal = i11 + 5;
        this.seekBarPosition = -1L;
        this.pausePosition = 0L;
        this.EXIT_MENU_TIME = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.speedList = kotlin.collections.r.o(Float.valueOf(1.0f), Float.valueOf(1.5f), Float.valueOf(2.0f));
        this.mVolumeChangeListener = new e();
        this.mH = new d(Looper.getMainLooper());
        this.mTask = new Runnable() { // from class: com.tvc.lib.mobile.ui.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                MyVideoView.e0(this.f9311a);
            }
        };
        O(context, attributeSet);
    }
}
