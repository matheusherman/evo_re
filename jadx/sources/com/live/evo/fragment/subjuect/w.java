package com.live.evo.fragment.subjuect;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.VerticalGridView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.fragment.y1;
import com.live.evo.util.k1;
import com.live.evo.util.q1;
import com.live.evo.util.r1;
import com.live.evo.util.s0;
import com.live.evo.util.u1;
import com.live.evo.util.x1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.greenrobot.eventbus.ThreadMode;
import x1.f1.lb.media.model.SubscribeItem;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0097\u0001\u0018\u0000 Ú\u00012\u00020\u00012\u00020\u0002:\u0001TB\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u0011J\u000f\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010\u0011J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010\u001dJ\u0019\u0010$\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b$\u0010\u0018J\u000f\u0010%\u001a\u00020\u000fH\u0002¢\u0006\u0004\b%\u0010\u0011J\u001f\u0010)\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000fH\u0002¢\u0006\u0004\b-\u0010\u0011J\u0017\u0010.\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b.\u0010,J'\u00103\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\fH\u0002¢\u0006\u0004\b3\u00104J'\u00107\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u00020\f2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J'\u0010=\u001a\u00020\u000f2\u0006\u0010:\u001a\u0002092\u0006\u00102\u001a\u00020\f2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J-\u0010E\u001a\u0004\u0018\u00010\u00152\u0006\u0010@\u001a\u00020?2\b\u0010B\u001a\u0004\u0018\u00010A2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u001aH\u0014¢\u0006\u0004\bH\u0010\u001dJ\u0015\u0010I\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\bI\u0010JJ\r\u0010K\u001a\u00020\u000f¢\u0006\u0004\bK\u0010\u0011J\u0017\u0010M\u001a\u00020\u000f2\b\b\u0002\u0010L\u001a\u00020;¢\u0006\u0004\bM\u0010NJ\u0017\u0010Q\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020OH\u0007¢\u0006\u0004\bQ\u0010RJ\r\u0010S\u001a\u00020\u000f¢\u0006\u0004\bS\u0010\u0011J\r\u0010T\u001a\u00020\u000f¢\u0006\u0004\bT\u0010\u0011J\r\u0010U\u001a\u00020\u000f¢\u0006\u0004\bU\u0010\u0011J\r\u0010V\u001a\u00020\u000f¢\u0006\u0004\bV\u0010\u0011J\r\u0010W\u001a\u00020\u000f¢\u0006\u0004\bW\u0010\u0011J\r\u0010X\u001a\u00020\u000f¢\u0006\u0004\bX\u0010\u0011J'\u0010\\\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020&2\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J\u0015\u0010_\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u001a¢\u0006\u0004\b_\u0010\u001dR\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020;0l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010v\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u0002090l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010mR\u0018\u0010y\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010fR\u0018\u0010|\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\f0l8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010mR\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008d\u0001R\u001a\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010{R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u009a\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001b\u0010£\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010¥\u0001\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¢\u0001R\u0019\u0010§\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010\u009c\u0001R\u0019\u0010©\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010\u009c\u0001R;\u0010\u00ad\u0001\u001a$\u0012\u0004\u0012\u00020;\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0ª\u0001\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R0\u0010¯\u0001\u001a\u0019\u0012\u0006\u0012\u0004\u0018\u00010;\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u000b\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¬\u0001R \u0010±\u0001\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b°\u0001\u0010mR\u001e\u0010³\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010l8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b²\u0001\u0010mR\u0019\u0010¶\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010·\u0001R\u001c\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020;0l8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¸\u0001\u0010mR\u001c\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020&0l8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bº\u0001\u0010mR\u0019\u0010½\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010\u009c\u0001R\u0019\u0010¿\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010\u009c\u0001R\u0019\u0010Á\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010\u009c\u0001R\u0019\u0010Ã\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010\u009c\u0001R\u0019\u0010Å\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010µ\u0001R\u001a\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÆ\u0001\u0010{R\u0019\u0010É\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010µ\u0001R\u0019\u0010Ë\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010µ\u0001R\u001a\u0010Î\u0001\u001a\u00030Ì\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010¸\u0001R\u001a\u0010Ð\u0001\u001a\u00030Ì\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010¸\u0001R\u001b\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010Õ\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bH\u0010Ô\u0001R\u0018\u0010Ù\u0001\u001a\u00030Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001¨\u0006Û\u0001"}, d2 = {"Lcom/live/evo/fragment/subjuect/w;", "Lcom/live/evo/fragment/d;", "Landroid/view/View$OnKeyListener;", "Lcom/live/evo/osd/persenter/a;", "presenter", "Lcom/live/evo/fragment/y1;", "onEventListener", "<init>", "(Lcom/live/evo/osd/persenter/a;Lcom/live/evo/fragment/y1;)V", "Lj5/f;", "response", "", "Lj5/c;", "L0", "(Lj5/f;)Ljava/util/List;", "Lr8/z;", "l1", "()V", "i1", "(Lj5/f;)V", "l", "Landroid/view/View;", "mRoot", "Q0", "(Landroid/view/View;)V", "P0", "", "isLoad", "y1", "(Z)V", "b1", "a1", "Z0", "isFocus", "R0", "view", "w1", "u1", "", "position", "isKeyUp", "m1", "(IZ)V", "W0", "(I)V", "n1", "f1", "Li5/p;", "bean", NotificationCompat.CATEGORY_STATUS, "subjectMatchProgramResponse", "A1", "(Li5/p;ILj5/c;)V", "Lx1/f1/lb/media/model/SubscribeItem;", "subscribeItem", "v1", "(Li5/p;Lj5/c;Lx1/f1/lb/media/model/SubscribeItem;)V", "Lj5/b;", "subjectMatchListResponse", "", "watchType", "g1", "(Lj5/b;Lj5/c;Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "visible", ExifInterface.LONGITUDE_WEST, "N0", "()Ljava/util/List;", "M0", TypedValues.TransitionType.S_FROM, "I0", "(Ljava/lang/String;)V", "Lq7/a;", NotificationCompat.CATEGORY_EVENT, "onFocusEvent", "(Lq7/a;)V", "b", "a", "U0", "S0", "d1", "k1", "i", "Landroid/view/KeyEvent;", "keyEvent", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "bStart", "h1", "Lq6/b;", "f", "Lq6/b;", "logger", "Landroidx/leanback/widget/VerticalGridView;", "g", "Landroidx/leanback/widget/VerticalGridView;", "subject_date_listview", "Lcom/live/evo/fragment/subjuect/e;", "h", "Lcom/live/evo/fragment/subjuect/e;", "subjectMatchDateAdapter", "", "Ljava/util/List;", "mList", "Landroidx/leanback/widget/HorizontalGridView;", "j", "Landroidx/leanback/widget/HorizontalGridView;", "subject_classification_listview", "Lcom/live/evo/fragment/subjuect/d;", "k", "Lcom/live/evo/fragment/subjuect/d;", "subjectMatchClassificationAdapter", "mListClassification", "m", "subject_match_listview", "n", "Landroid/view/View;", "subject_match_listview_empty", "Landroid/widget/TextView;", "o", "Landroid/widget/TextView;", "tv_nodata", "Lcom/live/evo/fragment/subjuect/c;", "p", "Lcom/live/evo/fragment/subjuect/c;", "subjectMatchAdapter", "q", "subjectMatchInfos", "Landroid/widget/Button;", "r", "Landroid/widget/Button;", "subject_matchback_layout", "Landroid/widget/RelativeLayout;", "s", "Landroid/widget/RelativeLayout;", "subject_classification_rl", "t", "livenewa_slv", "u", "mLoadingView", "Landroid/animation/ObjectAnimator;", "v", "Landroid/animation/ObjectAnimator;", "loadAnim", "com/live/evo/fragment/subjuect/w$c", "w", "Lcom/live/evo/fragment/subjuect/w$c;", "handler", "x", "I", "Lj5/g;", "y", "Lj5/g;", "subjectTypeResponse", "z", "Ljava/lang/String;", "subjectTypeId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mDate", "B", "mDatePos", "C", "classificationPos", "", "D", "Ljava/util/Map;", "gameClassificationMaps2", ExifInterface.LONGITUDE_EAST, "gameAllMaps", "F", "subjectMatchListResponses", "G", "subjectMatchProgramResponses", "H", "Z", "dataIsUpdate", "Lj5/f;", "J", "datesHasData", "K", "positions", "L", "matchPosition", "M", "dateType", "N", "todayMatchPos", "O", "todayLiveMatchPos", "P", "todayHasLiveMatch", "Q", "curFocusView", "R", "classificationIsChange", ExifInterface.LATITUDE_SOUTH, "isGetData", "", ExifInterface.GPS_DIRECTION_TRUE, "mStartShowTime", "U", "mClassifyStartTime", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/live/evo/osd/persenter/a;", "mPresenter", "Lcom/live/evo/fragment/y1;", "mOnEventListener", "Lcom/live/evo/osd/v;", "X", "Lcom/live/evo/osd/v;", "subscribeUpdateListener", "Y", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w extends com.live.evo.fragment.d implements View.OnKeyListener {
    private static String Z;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private String mDate;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private int mDatePos;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private int classificationPos;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private Map<String, ? extends Map<String, ? extends List<? extends j5.c>>> gameClassificationMaps2;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private Map<String, ? extends List<? extends j5.b>> gameAllMaps;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private List<? extends j5.b> subjectMatchListResponses;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private final List<j5.c> subjectMatchProgramResponses;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private boolean dataIsUpdate;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private j5.f response;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private final List<String> datesHasData;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private final List<Integer> positions;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private int matchPosition;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private int dateType;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private int todayMatchPos;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private int todayLiveMatchPos;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private boolean todayHasLiveMatch;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private View curFocusView;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private boolean classificationIsChange;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private boolean isGetData;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private long mStartShowTime;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    private long mClassifyStartTime;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    private com.live.evo.osd.persenter.a mPresenter;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    private y1 mOnEventListener;

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    private final com.live.evo.osd.v subscribeUpdateListener;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private VerticalGridView subject_date_listview;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private e subjectMatchDateAdapter;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<String> mList;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private HorizontalGridView subject_classification_listview;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.fragment.subjuect.d subjectMatchClassificationAdapter;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final List<j5.b> mListClassification;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private VerticalGridView subject_match_listview;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private View subject_match_listview_empty;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private TextView tv_nodata;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.fragment.subjuect.c subjectMatchAdapter;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final List<j5.c> subjectMatchInfos;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Button subject_matchback_layout;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout subject_classification_rl;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout livenewa_slv;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private View mLoadingView;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator loadAnim;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private c handler;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private j5.g subjectTypeResponse;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private String subjectTypeId;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.subjuect.SubjectMatchFragment$getData$1$1", f = "SubjectMatchFragment.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $from;
        final /* synthetic */ j5.f $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j5.f fVar, String str, v8.f<? super b> fVar2) {
            super(2, fVar2);
            this.$response = fVar;
            this.$from = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return w.this.new b(this.$response, this.$from, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String c(j5.c cVar) {
            String streamId;
            String strA = cVar.a();
            String str = "";
            if (strA != null && strA.length() != 0) {
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                String strA2 = cVar.a();
                kotlin.jvm.internal.m.e(strA2, "getChannelId(...)");
                ChannelStreamResponse channelStreamResponseJ = aVar.j(Integer.parseInt(strA2));
                if (channelStreamResponseJ != null && (streamId = channelStreamResponseJ.getStreamId()) != null) {
                    str = streamId;
                }
            }
            return str + "." + cVar.c() + "." + cVar.g();
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                List listL0 = w.this.L0(w.this.response);
                List listL1 = w.this.L0(this.$response);
                x1.f1.lb.media.j jVar = x1.f1.lb.media.j.f20845a;
                jVar.y("update_cache_to_UI[" + this.$from + "][" + w.this.subjectTypeId + "]", jVar.x(listL0, listL1, new c9.l() { // from class: com.live.evo.fragment.subjuect.x
                    @Override // c9.l
                    public final Object invoke(Object obj2) {
                        return w.b.c((j5.c) obj2);
                    }
                }));
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/fragment/subjuect/w$c", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "dispatchMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message msg) {
            int iIntValue;
            kotlin.jvm.internal.m.f(msg, "msg");
            int i10 = msg.what;
            if (i10 == 1) {
                if (!w.this.isGetData && s0.f7342a.d(w.this.subjectTypeId)) {
                    w.this.I0("auto");
                }
                w.this.l1();
                return;
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                Object obj = msg.obj;
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                com.live.evo.fragment.subjuect.c cVar = w.this.subjectMatchAdapter;
                kotlin.jvm.internal.m.c(cVar);
                cVar.c(w.this.subject_match_listview, Integer.valueOf(w.this.matchPosition), Boolean.TRUE);
                w wVar = w.this;
                wVar.m1(wVar.matchPosition, zBooleanValue);
                return;
            }
            e eVar = w.this.subjectMatchDateAdapter;
            kotlin.jvm.internal.m.c(eVar);
            eVar.c(w.this.subject_date_listview, w.this.mDatePos, true);
            int iIndexOf = w.this.datesHasData.indexOf(w.this.mDate);
            if (iIndexOf == 0) {
                iIntValue = 0;
            } else {
                iIntValue = (iIndexOf <= 0 || w.this.positions.size() <= iIndexOf) ? -1 : ((Number) w.this.positions.get(iIndexOf - 1)).intValue();
            }
            if (iIntValue >= 0) {
                com.live.evo.fragment.subjuect.c cVar2 = w.this.subjectMatchAdapter;
                kotlin.jvm.internal.m.c(cVar2);
                cVar2.c(w.this.subject_match_listview, Integer.valueOf(iIntValue), Boolean.FALSE);
                w.this.matchPosition = iIntValue;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/live/evo/fragment/subjuect/w$d", "Lcom/live/evo/dialog/x;", "Lr8/z;", "b", "()V", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements com.live.evo.dialog.x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.c0 f6763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SubscribeItem f6764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w f6765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i5.p f6766d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ j5.c f6767e;

        d(i5.c0 c0Var, SubscribeItem subscribeItem, w wVar, i5.p pVar, j5.c cVar) {
            this.f6763a = c0Var;
            this.f6764b = subscribeItem;
            this.f6765c = wVar;
            this.f6766d = pVar;
            this.f6767e = cVar;
        }

        @Override // com.live.evo.dialog.x
        public void b() {
            com.live.evo.osd.u.f7147a.r(this.f6763a, 1, this.f6764b);
            this.f6765c.v1(this.f6766d, this.f6767e, this.f6764b);
        }

        @Override // com.live.evo.dialog.x
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(w wVar) {
        wVar.R0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(w wVar) {
        wVar.R0(true);
        wVar.h1(true);
        HorizontalGridView horizontalGridView = wVar.subject_classification_listview;
        kotlin.jvm.internal.m.c(horizontalGridView);
        horizontalGridView.setSelectedPosition(wVar.classificationPos);
        wVar.b1();
        e eVar = wVar.subjectMatchDateAdapter;
        kotlin.jvm.internal.m.c(eVar);
        eVar.c(wVar.subject_date_listview, wVar.mDatePos, false);
        wVar.Z0();
        wVar.a();
        wVar.classificationIsChange = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(w wVar) {
        wVar.R0(true);
        wVar.w1(wVar.subject_classification_listview);
    }

    public final synchronized void h1(boolean bStart) {
        long jElapsedRealtime;
        try {
            HorizontalGridView horizontalGridView = this.subject_classification_listview;
            if (horizontalGridView != null) {
                kotlin.jvm.internal.m.c(horizontalGridView);
                if (horizontalGridView.getChildCount() > 0 && this.classificationPos < this.mListClassification.size()) {
                    u1.b().a();
                    if (bStart) {
                        this.mStartShowTime = SystemClock.elapsedRealtime();
                        this.mClassifyStartTime = u1.b().a();
                        jElapsedRealtime = 0;
                    } else {
                        jElapsedRealtime = SystemClock.elapsedRealtime() - this.mStartShowTime;
                    }
                    if (jElapsedRealtime >= 2000) {
                        this.mClassifyStartTime = u1.b().a();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static {
        String CLASSIFICATION_ALL = com.live.evo.fragment.subjuect.b.f6640k;
        kotlin.jvm.internal.m.e(CLASSIFICATION_ALL, "CLASSIFICATION_ALL");
        Z = CLASSIFICATION_ALL;
    }

    private final void A1(i5.p bean, int status, j5.c subjectMatchProgramResponse) {
        String str = this.subjectTypeId;
        if (str == null) {
            str = "";
        }
        Long lF = bean.f();
        kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
        long jLongValue = lF.longValue();
        Long lG = bean.g();
        kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
        long jLongValue2 = lG.longValue();
        String strE = bean.e();
        kotlin.jvm.internal.m.e(strE, "getProgramName(...)");
        String strA = bean.a();
        kotlin.jvm.internal.m.e(strA, "getDesc(...)");
        SubscribeItem subscribeItem = new SubscribeItem(str, jLongValue, jLongValue2, strE, strA, true);
        if (status <= 0) {
            v1(bean, subjectMatchProgramResponse, subscribeItem);
            return;
        }
        i5.c0 c0VarJ = s0.f7342a.J(bean, subjectMatchProgramResponse.a());
        if (c0VarJ != null) {
            com.live.evo.osd.u.f7147a.o(bean, c0VarJ, new d(c0VarJ, subscribeItem, this, bean, subjectMatchProgramResponse));
        } else {
            v1(bean, subjectMatchProgramResponse, subscribeItem);
        }
    }

    public static /* synthetic */ void J0(w wVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "ui";
        }
        wVar.I0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z K0(w wVar, String str, j5.f fVar) {
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, wVar.new b(fVar, str, null), 3, null);
        }
        if (fVar == null || fVar.k() == null) {
            wVar.a();
            wVar.isGetData = false;
        } else {
            wVar.i1(fVar);
            wVar.response = fVar;
        }
        if (bVar.t()) {
            wVar.logger.debug("update_cache_to_UI[" + str + "][" + wVar.subjectTypeId + "]: complete", new Object[0]);
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<j5.c> L0(j5.f response) {
        List<j5.e> listL;
        j5.a aVarK;
        ArrayList arrayList = new ArrayList();
        if (response == null || (aVarK = response.k()) == null || (listL = aVarK.l()) == null) {
            listL = kotlin.collections.r.l();
        }
        Iterator<j5.e> it = listL.iterator();
        while (it.hasNext()) {
            Iterator<j5.b> it2 = it.next().a().iterator();
            while (it2.hasNext()) {
                for (j5.c cVar : it2.next().d()) {
                    kotlin.jvm.internal.m.c(cVar);
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(w wVar) {
        RelativeLayout relativeLayout = wVar.livenewa_slv;
        if (relativeLayout != null) {
            kotlin.jvm.internal.m.c(relativeLayout);
            relativeLayout.setVisibility(8);
        }
        ObjectAnimator objectAnimator = wVar.loadAnim;
        if (objectAnimator != null) {
            kotlin.jvm.internal.m.c(objectAnimator);
            if (objectAnimator.isRunning()) {
                ObjectAnimator objectAnimator2 = wVar.loadAnim;
                kotlin.jvm.internal.m.c(objectAnimator2);
                objectAnimator2.cancel();
            }
        }
        wVar.y1(false);
    }

    private final void P0() {
        if (this.subject_matchback_layout != null) {
            String strI = com.live.evo.l.n().i("dualmeet_back_top_button", x1.j(R$string.back_to_top));
            Button button = this.subject_matchback_layout;
            kotlin.jvm.internal.m.c(button);
            button.setText(strI);
        }
    }

    private final void R0(boolean isFocus) {
        com.live.evo.fragment.subjuect.d dVar = this.subjectMatchClassificationAdapter;
        kotlin.jvm.internal.m.c(dVar);
        dVar.d(this.subject_classification_listview, this.classificationPos, isFocus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(w wVar) {
        com.live.evo.fragment.subjuect.c cVar = wVar.subjectMatchAdapter;
        kotlin.jvm.internal.m.c(cVar);
        cVar.notifyDataSetChanged();
    }

    private final void W0(int position) {
        if (this.classificationPos == position || !this.dataIsUpdate) {
            return;
        }
        this.classificationIsChange = false;
        List<? extends j5.b> list = this.subjectMatchListResponses;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() <= position || position < 0) {
                return;
            }
            h1(false);
            this.classificationPos = position;
            List<? extends j5.b> list2 = this.subjectMatchListResponses;
            kotlin.jvm.internal.m.c(list2);
            Z = list2.get(this.classificationPos).b();
            if (this.gameClassificationMaps2 != null) {
                b();
                k1.f7250a.b(new Runnable() { // from class: com.live.evo.fragment.subjuect.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.X0(this.f6729a);
                    }
                });
            }
        }
    }

    private final void Z0() {
        this.subjectMatchInfos.clear();
        List<j5.c> list = this.subjectMatchProgramResponses;
        if (list != null) {
            List<j5.c> list2 = list;
            if (!list2.isEmpty()) {
                this.subjectMatchInfos.addAll(list2);
            }
        }
        com.live.evo.fragment.subjuect.c cVar = this.subjectMatchAdapter;
        kotlin.jvm.internal.m.c(cVar);
        cVar.b(this.subject_match_listview, Integer.valueOf(this.matchPosition), this.subjectMatchInfos);
        if (this.subjectMatchInfos.size() == 0) {
            View view = this.subject_match_listview_empty;
            kotlin.jvm.internal.m.c(view);
            view.setVisibility(0);
        } else {
            View view2 = this.subject_match_listview_empty;
            kotlin.jvm.internal.m.c(view2);
            view2.setVisibility(8);
        }
    }

    private final void a1() {
        this.mListClassification.clear();
        List<? extends j5.b> list = this.subjectMatchListResponses;
        if (list != null) {
            List<j5.b> list2 = this.mListClassification;
            kotlin.jvm.internal.m.c(list);
            list2.addAll(list);
        }
        com.live.evo.fragment.subjuect.d dVar = this.subjectMatchClassificationAdapter;
        kotlin.jvm.internal.m.c(dVar);
        dVar.c(this.subject_classification_listview, this.mListClassification, this.classificationPos);
    }

    private final void b1() {
        e eVar = this.subjectMatchDateAdapter;
        kotlin.jvm.internal.m.c(eVar);
        eVar.b(this.subject_date_listview, this.mList, this.mDatePos, this.datesHasData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(w wVar) {
        VerticalGridView verticalGridView = wVar.subject_match_listview;
        if (verticalGridView != null) {
            verticalGridView.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(w wVar) {
        if (wVar.subjectMatchInfos.size() > 0) {
            wVar.w1(wVar.subject_match_listview);
        } else {
            wVar.R0(true);
            wVar.w1(wVar.subject_classification_listview);
        }
    }

    private final void f1(int position) {
        j5.c cVar;
        i5.h hVar;
        if (!x1.m(500L) && position >= 0) {
            List<j5.c> list = this.subjectMatchInfos;
            kotlin.jvm.internal.m.c(list);
            if (position >= list.size() || (cVar = this.subjectMatchInfos.get(position)) == null || TextUtils.isEmpty(cVar.a())) {
                return;
            }
            long jB = q1.b();
            long jG = cVar.g();
            long jH = cVar.h();
            i5.p pVar = new i5.p(null, cVar.c(), 0L, cVar.f(), Long.valueOf(cVar.g()), Long.valueOf(cVar.h()), cVar.b(), cVar.a() + cVar.g(), false);
            if (jG > jB) {
                q1.f(jB, 7);
                if (com.live.evo.k.b().n()) {
                    A1(pVar, !s0.f7342a.O(pVar, cVar.a()) ? 1 : 0, cVar);
                    List<? extends j5.b> list2 = this.subjectMatchListResponses;
                    kotlin.jvm.internal.m.c(list2);
                    j5.b bVar = list2.get(this.classificationPos);
                    String SUBJECT_WATCHTYPE_SUBSCRIBLE = com.live.evo.fragment.subjuect.b.f6637h;
                    kotlin.jvm.internal.m.e(SUBJECT_WATCHTYPE_SUBSCRIBLE, "SUBJECT_WATCHTYPE_SUBSCRIBLE");
                    g1(bVar, cVar, SUBJECT_WATCHTYPE_SUBSCRIBLE);
                    return;
                }
                return;
            }
            if (jB > jH) {
                if (!s0.f7342a.M(cVar.c(), cVar.a(), Long.valueOf(jG))) {
                    r1.c(getContext(), x1.j(R$string.not_supported_playback));
                    return;
                }
                com.live.evo.osd.persenter.a aVar = this.mPresenter;
                if (aVar == null) {
                    return;
                }
                kotlin.jvm.internal.m.c(aVar);
                aVar.b("subjectMatch", pVar, cVar.a());
                List<? extends j5.b> list3 = this.subjectMatchListResponses;
                kotlin.jvm.internal.m.c(list3);
                j5.b bVar2 = list3.get(this.classificationPos);
                String SUBJECT_WATCHTYPE_CATCHUP = com.live.evo.fragment.subjuect.b.f6638i;
                kotlin.jvm.internal.m.e(SUBJECT_WATCHTYPE_CATCHUP, "SUBJECT_WATCHTYPE_CATCHUP");
                g1(bVar2, cVar, SUBJECT_WATCHTYPE_CATCHUP);
                return;
            }
            Map<String, i5.h> mapU = s0.f7342a.u();
            if (mapU == null || (hVar = mapU.get(cVar.a())) == null) {
                return;
            }
            int i10 = hVar.i();
            com.live.evo.osd.persenter.a aVar2 = this.mPresenter;
            if (aVar2 == null) {
                return;
            }
            kotlin.jvm.internal.m.c(aVar2);
            if (aVar2.g() == i10) {
                g0 g0Var = g0.f12340a;
                kotlin.jvm.internal.m.e(String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(i10 + 1)}, 1)), "format(...)");
                r1.c(getActivity(), x1.j(R$string.is_playing));
                return;
            }
            com.live.evo.fragment.subjuect.b.f6641l = true;
            com.live.evo.osd.persenter.a aVar3 = this.mPresenter;
            kotlin.jvm.internal.m.c(aVar3);
            aVar3.o(0, i10, i10, "subjectMatch");
            com.live.evo.osd.persenter.a aVar4 = this.mPresenter;
            kotlin.jvm.internal.m.c(aVar4);
            aVar4.hide();
            List<? extends j5.b> list4 = this.subjectMatchListResponses;
            kotlin.jvm.internal.m.c(list4);
            j5.b bVar3 = list4.get(this.classificationPos);
            String SUBJECT_WATCHTYPE_LIVE = com.live.evo.fragment.subjuect.b.f6639j;
            kotlin.jvm.internal.m.e(SUBJECT_WATCHTYPE_LIVE, "SUBJECT_WATCHTYPE_LIVE");
            g1(bVar3, cVar, SUBJECT_WATCHTYPE_LIVE);
        }
    }

    private final void l() {
        this.mList.clear();
        Z = com.live.evo.fragment.subjuect.b.f6640k;
        List<j5.g> listF = com.live.evo.fragment.subjuect.b.c().f();
        if (listF != null) {
            this.subjectTypeResponse = listF.get(this.position);
        }
        j5.g gVar = this.subjectTypeResponse;
        if (gVar != null) {
            kotlin.jvm.internal.m.c(gVar);
            this.subjectTypeId = gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        this.handler.removeMessages(1);
        Message messageObtainMessage = this.handler.obtainMessage(1);
        kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
        this.handler.sendMessageDelayed(messageObtainMessage, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0058  */
    public final void m1(int position, boolean isKeyUp) {
        int iIndexOf;
        String str;
        int iIndexOf2;
        int iIndexOf3;
        int i10;
        if (isKeyUp) {
            int i11 = position + 1;
            if (!this.positions.contains(Integer.valueOf(i11)) || (iIndexOf = this.positions.indexOf(Integer.valueOf(i11))) < 0 || this.datesHasData.size() <= iIndexOf) {
                str = null;
            } else {
                str = this.datesHasData.get(iIndexOf);
            }
        } else if (!this.positions.contains(Integer.valueOf(position)) || (iIndexOf3 = this.positions.indexOf(Integer.valueOf(position))) < 0 || this.datesHasData.size() <= (i10 = iIndexOf3 + 1)) {
            str = null;
        } else {
            str = this.datesHasData.get(i10);
        }
        if (str != null && (iIndexOf2 = this.mList.indexOf(str)) >= 0 && this.mList.size() > iIndexOf2) {
            this.mDatePos = iIndexOf2;
            this.mDate = this.mList.get(iIndexOf2);
            e eVar = this.subjectMatchDateAdapter;
            kotlin.jvm.internal.m.c(eVar);
            eVar.c(this.subject_date_listview, this.mDatePos, false);
        }
    }

    private final void n1() {
        Button button = this.subject_matchback_layout;
        kotlin.jvm.internal.m.c(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.fragment.subjuect.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.o1(view);
            }
        });
        Button button2 = this.subject_matchback_layout;
        kotlin.jvm.internal.m.c(button2);
        button2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.subjuect.q
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                w.p1(this.f6735a, view, z10);
            }
        });
        VerticalGridView verticalGridView = this.subject_date_listview;
        if (verticalGridView != null) {
            verticalGridView.setOnKeyInterceptListener(new BaseGridView.OnKeyInterceptListener() { // from class: com.live.evo.fragment.subjuect.r
                @Override // androidx.leanback.widget.BaseGridView.OnKeyInterceptListener
                public final boolean onInterceptKeyEvent(KeyEvent keyEvent) {
                    return w.r1(this.f6736a, keyEvent);
                }
            });
        }
        VerticalGridView verticalGridView2 = this.subject_match_listview;
        kotlin.jvm.internal.m.c(verticalGridView2);
        verticalGridView2.setOnKeyInterceptListener(new BaseGridView.OnKeyInterceptListener() { // from class: com.live.evo.fragment.subjuect.s
            @Override // androidx.leanback.widget.BaseGridView.OnKeyInterceptListener
            public final boolean onInterceptKeyEvent(KeyEvent keyEvent) {
                return w.s1(this.f6737a, keyEvent);
            }
        });
        Button button3 = this.subject_matchback_layout;
        kotlin.jvm.internal.m.c(button3);
        button3.setOnKeyListener(this);
        HorizontalGridView horizontalGridView = this.subject_classification_listview;
        kotlin.jvm.internal.m.c(horizontalGridView);
        horizontalGridView.setOnKeyInterceptListener(new BaseGridView.OnKeyInterceptListener() { // from class: com.live.evo.fragment.subjuect.t
            @Override // androidx.leanback.widget.BaseGridView.OnKeyInterceptListener
            public final boolean onInterceptKeyEvent(KeyEvent keyEvent) {
                return w.t1(this.f6738a, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(final w wVar, View view, boolean z10) {
        if (z10) {
            new Handler().postDelayed(new Runnable() { // from class: com.live.evo.fragment.subjuect.h
                @Override // java.lang.Runnable
                public final void run() {
                    w.q1(this.f6727a);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r1(w wVar, KeyEvent event) {
        String str;
        int iIndexOf;
        kotlin.jvm.internal.m.f(event, "event");
        int size = 0;
        if (event.getAction() == 1) {
            return false;
        }
        switch (event.getKeyCode()) {
            case 19:
            case 20:
                int iIndexOf2 = wVar.datesHasData.indexOf(wVar.mDate);
                if (iIndexOf2 >= 0 && iIndexOf2 < wVar.datesHasData.size()) {
                    if (event.getKeyCode() != 20) {
                        size = iIndexOf2 == 0 ? wVar.datesHasData.size() - 1 : iIndexOf2 - 1;
                    } else if (iIndexOf2 != wVar.datesHasData.size() - 1) {
                        size = iIndexOf2 + 1;
                    }
                    if (size >= wVar.datesHasData.size() || (iIndexOf = wVar.mList.indexOf((str = wVar.datesHasData.get(size)))) < 0) {
                        return true;
                    }
                    wVar.mDate = str;
                    wVar.mDatePos = iIndexOf;
                    wVar.handler.removeMessages(2);
                    Message messageObtainMessage = wVar.handler.obtainMessage(2);
                    kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
                    wVar.handler.sendMessage(messageObtainMessage);
                }
                return true;
            case 22:
                e eVar = wVar.subjectMatchDateAdapter;
                kotlin.jvm.internal.m.c(eVar);
                eVar.c(wVar.subject_date_listview, wVar.mDatePos, false);
                if (wVar.subjectMatchInfos.size() <= 0) {
                    wVar.w1(wVar.subject_matchback_layout);
                    break;
                } else {
                    wVar.w1(wVar.subject_match_listview);
                    return true;
                }
            case 21:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final boolean s1(w wVar, KeyEvent event) {
        int selectedPosition;
        kotlin.jvm.internal.m.f(event, "event");
        if (event.getAction() == 1) {
            switch (event.getKeyCode()) {
                case 19:
                case 20:
                case 21:
                case 22:
                    return true;
                default:
                    return false;
            }
        }
        int keyCode = event.getKeyCode();
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                    boolean z10 = event.getKeyCode() == 19;
                    if (z10) {
                        VerticalGridView verticalGridView = wVar.subject_match_listview;
                        kotlin.jvm.internal.m.c(verticalGridView);
                        selectedPosition = verticalGridView.getSelectedPosition() - 1;
                    } else {
                        VerticalGridView verticalGridView2 = wVar.subject_match_listview;
                        kotlin.jvm.internal.m.c(verticalGridView2);
                        selectedPosition = verticalGridView2.getSelectedPosition() + 1;
                    }
                    if (selectedPosition > -1 && selectedPosition < wVar.subjectMatchInfos.size()) {
                        wVar.matchPosition = selectedPosition;
                        wVar.handler.removeMessages(3);
                        Message messageObtainMessage = wVar.handler.obtainMessage(3);
                        kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
                        messageObtainMessage.obj = Boolean.valueOf(z10);
                        wVar.handler.sendMessage(messageObtainMessage);
                    }
                    if (selectedPosition == wVar.subjectMatchInfos.size() && selectedPosition > 0) {
                        return true;
                    }
                    if (selectedPosition == -1) {
                        wVar.R0(true);
                        wVar.w1(wVar.subject_classification_listview);
                        com.live.evo.fragment.subjuect.c cVar = wVar.subjectMatchAdapter;
                        kotlin.jvm.internal.m.c(cVar);
                        VerticalGridView verticalGridView3 = wVar.subject_match_listview;
                        kotlin.jvm.internal.m.c(verticalGridView3);
                        cVar.c(verticalGridView3, Integer.valueOf(verticalGridView3.getSelectedPosition()), Boolean.FALSE);
                        return true;
                    }
                    return false;
                case 21:
                    VerticalGridView verticalGridView4 = wVar.subject_date_listview;
                    wVar.curFocusView = verticalGridView4;
                    if (verticalGridView4 != null) {
                        verticalGridView4.requestFocus();
                    }
                    e eVar = wVar.subjectMatchDateAdapter;
                    kotlin.jvm.internal.m.c(eVar);
                    eVar.c(wVar.subject_date_listview, wVar.mDatePos, true);
                    com.live.evo.fragment.subjuect.c cVar2 = wVar.subjectMatchAdapter;
                    kotlin.jvm.internal.m.c(cVar2);
                    VerticalGridView verticalGridView5 = wVar.subject_match_listview;
                    kotlin.jvm.internal.m.c(verticalGridView5);
                    cVar2.c(verticalGridView5, Integer.valueOf(verticalGridView5.getSelectedPosition()), Boolean.FALSE);
                    return false;
                case 22:
                    wVar.w1(wVar.subject_matchback_layout);
                    com.live.evo.fragment.subjuect.c cVar3 = wVar.subjectMatchAdapter;
                    kotlin.jvm.internal.m.c(cVar3);
                    VerticalGridView verticalGridView6 = wVar.subject_match_listview;
                    kotlin.jvm.internal.m.c(verticalGridView6);
                    cVar3.c(verticalGridView6, Integer.valueOf(verticalGridView6.getSelectedPosition()), Boolean.FALSE);
                    return true;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        VerticalGridView verticalGridView7 = wVar.subject_match_listview;
        if (verticalGridView7 != null) {
            int selectedPosition2 = verticalGridView7.getSelectedPosition();
            com.live.evo.fragment.subjuect.c cVar4 = wVar.subjectMatchAdapter;
            if (cVar4 != null && cVar4.getItemCount() > 0 && selectedPosition2 >= 0) {
                wVar.f1(selectedPosition2);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t1(w wVar, KeyEvent event) {
        kotlin.jvm.internal.m.f(event, "event");
        if (event.getAction() == 1) {
            return false;
        }
        switch (event.getKeyCode()) {
            case 19:
                wVar.R0(false);
                y1 y1Var = wVar.mOnEventListener;
                kotlin.jvm.internal.m.c(y1Var);
                y1Var.a(wVar.position + 2);
                return false;
            case 20:
                List<j5.c> list = wVar.subjectMatchInfos;
                kotlin.jvm.internal.m.c(list);
                if (list.size() > 0) {
                    wVar.w1(wVar.subject_match_listview);
                    wVar.R0(false);
                }
                return true;
            case 21:
                if (wVar.classificationIsChange) {
                    int i10 = wVar.classificationPos;
                    if (i10 == 0) {
                        wVar.W0(wVar.mListClassification.size() - 1);
                    } else {
                        wVar.W0(i10 - 1);
                    }
                }
                return true;
            case 22:
                if (wVar.classificationIsChange) {
                    if (wVar.classificationPos == wVar.mListClassification.size() - 1) {
                        wVar.W0(0);
                    } else {
                        wVar.W0(wVar.classificationPos + 1);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    private final void u1() {
        int i10;
        String str;
        int iIndexOf;
        List<j5.c> list = this.subjectMatchProgramResponses;
        kotlin.jvm.internal.m.c(list);
        list.clear();
        this.datesHasData.clear();
        this.positions.clear();
        this.dateType = 0;
        this.todayMatchPos = 0;
        this.matchPosition = 0;
        this.todayLiveMatchPos = 0;
        this.todayHasLiveMatch = false;
        int iIndexOf2 = this.mList.indexOf(q1.k());
        this.mDatePos = iIndexOf2;
        this.mDate = (iIndexOf2 < 0 || iIndexOf2 >= this.mList.size()) ? "" : this.mList.get(this.mDatePos);
        if (this.gameClassificationMaps2 != null) {
            new ArrayMap();
            Map<String, ? extends Map<String, ? extends List<? extends j5.c>>> map = this.gameClassificationMaps2;
            kotlin.jvm.internal.m.c(map);
            Map<String, ? extends List<? extends j5.c>> map2 = map.get(Z);
            if (map2 != null) {
                boolean z10 = true;
                int size = 0;
                long j10 = 0;
                boolean z11 = true;
                boolean z12 = false;
                for (String str2 : map2.keySet()) {
                    List<j5.c> list2 = this.subjectMatchProgramResponses;
                    List<? extends j5.c> list3 = map2.get(str2);
                    kotlin.jvm.internal.m.c(list3);
                    list2.addAll(list3);
                    this.datesHasData.add(str2);
                    long jB = q1.b();
                    List<? extends j5.c> list4 = map2.get(str2);
                    kotlin.jvm.internal.m.c(list4);
                    int size2 = list4.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size2 || z12) {
                            map2 = map2;
                            break;
                        }
                        List<? extends j5.c> list5 = map2.get(str2);
                        kotlin.jvm.internal.m.c(list5);
                        if (list5.get(i11).h() >= jB) {
                            List<? extends j5.c> list6 = map2.get(str2);
                            kotlin.jvm.internal.m.c(list6);
                            if (list6.get(i11).g() <= jB) {
                                this.todayMatchPos = size;
                                this.todayLiveMatchPos = i11;
                                this.todayHasLiveMatch = z10;
                                z12 = true;
                                break;
                            }
                        }
                        List<? extends j5.c> list7 = map2.get(str2);
                        kotlin.jvm.internal.m.c(list7);
                        Map<String, ? extends List<? extends j5.c>> map3 = map2;
                        long jG = list7.get(i11).g() - jB;
                        long jAbs = (long) Math.abs(jG);
                        if (i11 == 0 && z11) {
                            this.todayMatchPos = size;
                            this.todayLiveMatchPos = i11;
                            j10 = jAbs;
                            z11 = false;
                        }
                        if (jG < 0) {
                            if (j10 >= jAbs) {
                                this.todayMatchPos = size;
                                this.todayLiveMatchPos = i11;
                                j10 = jAbs;
                            }
                        } else if (j10 > jAbs) {
                            this.todayMatchPos = size;
                            this.todayLiveMatchPos = i11;
                            j10 = jAbs;
                        }
                        this.todayHasLiveMatch = true;
                        i11++;
                        map2 = map3;
                        z10 = true;
                    }
                    List<? extends j5.c> list8 = map2.get(str2);
                    kotlin.jvm.internal.m.c(list8);
                    size += list8.size();
                    this.positions.add(Integer.valueOf(size));
                    z10 = true;
                }
                if (this.datesHasData.size() > 0) {
                    int i12 = this.todayMatchPos;
                    if (i12 == 0) {
                        String str3 = this.datesHasData.get(0);
                        this.mDate = str3;
                        int iIndexOf3 = this.mList.indexOf(str3);
                        if (iIndexOf3 < 0 || iIndexOf3 >= this.mList.size()) {
                            return;
                        }
                        this.mDatePos = iIndexOf3;
                        this.matchPosition = this.todayLiveMatchPos;
                        return;
                    }
                    int iIndexOf4 = this.positions.indexOf(Integer.valueOf(i12));
                    if (iIndexOf4 < 0 || this.positions.size() <= (i10 = iIndexOf4 + 1) || (iIndexOf = this.mList.indexOf((str = this.datesHasData.get(i10)))) < 0 || iIndexOf >= this.mList.size()) {
                        return;
                    }
                    this.mDate = str;
                    this.mDatePos = iIndexOf;
                    this.matchPosition = this.todayMatchPos + this.todayLiveMatchPos;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1(i5.p bean, j5.c subjectMatchProgramResponse, SubscribeItem subscribeItem) {
        i5.h hVar;
        Map<String, i5.h> mapU = s0.f7342a.u();
        if (mapU == null || (hVar = mapU.get(subjectMatchProgramResponse.a())) == null) {
            return;
        }
        com.live.evo.osd.u uVar = com.live.evo.osd.u.f7147a;
        String strE = hVar.e();
        kotlin.jvm.internal.m.e(strE, "getDname(...)");
        uVar.s(strE, hVar.g(), hVar.i(), bean, subjectMatchProgramResponse.a(), "subjectMatch", this.subscribeUpdateListener, subscribeItem);
    }

    private final void w1(View view) {
        com.live.evo.fragment.subjuect.c cVar;
        this.curFocusView = view;
        if (kotlin.jvm.internal.m.a(view, this.subject_match_listview) && (cVar = this.subjectMatchAdapter) != null) {
            cVar.c(this.subject_match_listview, Integer.valueOf(this.matchPosition), Boolean.TRUE);
        }
        if (view != null) {
            view.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(w wVar) {
        RelativeLayout relativeLayout = wVar.livenewa_slv;
        if (relativeLayout != null) {
            kotlin.jvm.internal.m.c(relativeLayout);
            relativeLayout.setVisibility(0);
        }
        ObjectAnimator objectAnimator = wVar.loadAnim;
        if (objectAnimator != null) {
            kotlin.jvm.internal.m.c(objectAnimator);
            if (!objectAnimator.isRunning()) {
                ObjectAnimator objectAnimator2 = wVar.loadAnim;
                kotlin.jvm.internal.m.c(objectAnimator2);
                objectAnimator2.start();
            }
        }
        wVar.y1(true);
    }

    private final void y1(boolean isLoad) {
        if (isLoad) {
            TextView textView = this.tv_nodata;
            if (textView != null) {
                textView.setText(x1.j(2131952318));
                return;
            }
            return;
        }
        TextView textView2 = this.tv_nodata;
        if (textView2 != null) {
            textView2.setText(x1.j(R$string.not_data));
        }
    }

    public final void I0(final String from) {
        kotlin.jvm.internal.m.f(from, "from");
        b();
        this.isGetData = true;
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("update_cache_to_UI[" + from + "][" + this.subjectTypeId + "]: start", new Object[0]);
        }
        s0 s0Var = s0.f7342a;
        String str = this.subjectTypeId;
        kotlin.jvm.internal.m.c(str);
        s0Var.H(str, com.live.evo.fragment.subjuect.b.c().b(this.subjectTypeId), new c9.l() { // from class: com.live.evo.fragment.subjuect.g
            @Override // c9.l
            public final Object invoke(Object obj) {
                return w.K0(this.f6725a, from, (j5.f) obj);
            }
        });
    }

    public final void M0() {
        j5.f fVar = this.response;
        if ((fVar == null || fVar.k() == null || fVar.k().l() == null || fVar.k().l().size() <= 0) && !this.isGetData) {
            J0(this, null, 1, null);
        }
    }

    public final List<j5.c> N0() {
        return this.subjectMatchInfos;
    }

    public final void S0() {
        k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.subjuect.u
            @Override // java.lang.Runnable
            public final void run() {
                w.T0(this.f6739a);
            }
        });
    }

    public final void U0() {
        if (this.subjectMatchInfos.size() == 0) {
            return;
        }
        k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.subjuect.n
            @Override // java.lang.Runnable
            public final void run() {
                w.V0(this.f6733a);
            }
        });
    }

    public final void d1() {
        k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.subjuect.v
            @Override // java.lang.Runnable
            public final void run() {
                w.e1(this.f6740a);
            }
        });
    }

    public final void k1() {
        w1(this.curFocusView);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.subject_match_fragment, container, false);
        this.position = requireArguments().getInt("position");
        kotlin.jvm.internal.m.c(viewInflate);
        Q0(viewInflate);
        l();
        P0();
        n1();
        b1();
        a1();
        Z0();
        J0(this, null, 1, null);
        l1();
        return viewInflate;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onFocusEvent(q7.a event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (kotlin.jvm.internal.m.a(event.getAndroidx.constraintlayout.core.motion.utils.TypedValues.TransitionType.S_TO java.lang.String(), w.class.getName())) {
            this.handler.postDelayed(new Runnable() { // from class: com.live.evo.fragment.subjuect.f
                @Override // java.lang.Runnable
                public final void run() {
                    w.c1(this.f6724a);
                }
            }, 100L);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.m.f(view, "view");
        kotlin.jvm.internal.m.f(keyEvent, "keyEvent");
        if (keyEvent.getAction() != 0) {
            return false;
        }
        try {
            Fragment parentFragment = getParentFragment();
            kotlin.jvm.internal.m.d(parentFragment, "null cannot be cast to non-null type com.live.evo.fragment.subjuect.SubjectMenuFragment");
            ((y) parentFragment).e0();
        } catch (Exception unused) {
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19) {
            if (keyCode != 21 || view != this.subject_matchback_layout) {
                return false;
            }
            List<j5.c> list = this.subjectMatchInfos;
            kotlin.jvm.internal.m.c(list);
            if (list.size() > 0) {
                w1(this.subject_match_listview);
                return true;
            }
            if (this.datesHasData.size() > 0) {
                w1(this.subject_date_listview);
            }
        }
        return true;
    }

    public w(com.live.evo.osd.persenter.a aVar, y1 y1Var) {
        q6.b bVarD = q6.c.d(c0.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.mList = new ArrayList();
        this.mListClassification = new ArrayList();
        this.subjectMatchInfos = new ArrayList();
        this.handler = new c(Looper.getMainLooper());
        this.mDate = "";
        this.gameClassificationMaps2 = new HashMap();
        this.gameAllMaps = new HashMap();
        this.subjectMatchListResponses = new ArrayList();
        this.subjectMatchProgramResponses = new ArrayList();
        this.datesHasData = new ArrayList();
        this.positions = new ArrayList();
        this.classificationIsChange = true;
        this.mPresenter = aVar;
        this.mOnEventListener = y1Var;
        this.subscribeUpdateListener = new com.live.evo.osd.v() { // from class: com.live.evo.fragment.subjuect.o
            @Override // com.live.evo.osd.v
            public final void onUpdate() {
                w.z1(this.f6734a);
            }
        };
    }

    private final void Q0(View mRoot) {
        this.subject_date_listview = (VerticalGridView) mRoot.findViewById(R$id.subject_date_listview);
        this.subject_classification_listview = (HorizontalGridView) mRoot.findViewById(R$id.subject_classification_listview);
        this.subject_match_listview = (VerticalGridView) mRoot.findViewById(R$id.subject_match_listview);
        this.subject_matchback_layout = (Button) mRoot.findViewById(R$id.subject_matchback_btn);
        this.subject_classification_rl = (RelativeLayout) mRoot.findViewById(R$id.subject_classification_rl);
        this.subject_match_listview_empty = mRoot.findViewById(R$id.subject_match_listview_empty);
        this.livenewa_slv = (RelativeLayout) mRoot.findViewById(R$id.livenewa_slv);
        this.mLoadingView = mRoot.findViewById(R$id.iv_load);
        this.tv_nodata = (TextView) mRoot.findViewById(R$id.tv_nodata);
        e eVar = new e(getActivity(), this.mList, this.datesHasData);
        this.subjectMatchDateAdapter = eVar;
        VerticalGridView verticalGridView = this.subject_date_listview;
        if (verticalGridView != null) {
            verticalGridView.setAdapter(eVar);
        }
        com.live.evo.fragment.subjuect.d dVar = new com.live.evo.fragment.subjuect.d(getActivity(), this.mListClassification);
        this.subjectMatchClassificationAdapter = dVar;
        HorizontalGridView horizontalGridView = this.subject_classification_listview;
        if (horizontalGridView != null) {
            horizontalGridView.setAdapter(dVar);
        }
        com.live.evo.fragment.subjuect.c cVar = new com.live.evo.fragment.subjuect.c(getActivity(), this.subjectMatchInfos);
        this.subjectMatchAdapter = cVar;
        VerticalGridView verticalGridView2 = this.subject_match_listview;
        if (verticalGridView2 != null) {
            verticalGridView2.setAdapter(cVar);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mLoadingView, Key.ROTATION, 0.0f, 360.0f);
        this.loadAnim = objectAnimatorOfFloat;
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.setDuration(800L);
        }
        ObjectAnimator objectAnimator = this.loadAnim;
        if (objectAnimator != null) {
            objectAnimator.setRepeatMode(1);
        }
        ObjectAnimator objectAnimator2 = this.loadAnim;
        if (objectAnimator2 != null) {
            objectAnimator2.setInterpolator(new LinearInterpolator());
        }
        ObjectAnimator objectAnimator3 = this.loadAnim;
        if (objectAnimator3 != null) {
            objectAnimator3.setRepeatCount(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(final w wVar) {
        wVar.u1();
        wVar.requireActivity().runOnUiThread(new Runnable() { // from class: com.live.evo.fragment.subjuect.m
            @Override // java.lang.Runnable
            public final void run() {
                w.Y0(this.f6732a);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i1(j5.f response) {
        String str;
        FragmentActivity activity;
        List<String> listD = com.live.evo.fragment.subjuect.b.c().d(response.k());
        int iIndexOf = listD.indexOf(q1.k());
        this.mDatePos = iIndexOf;
        if (iIndexOf > 0 && iIndexOf < listD.size()) {
            String str2 = listD.get(this.mDatePos);
            kotlin.jvm.internal.m.c(str2);
            str = str2;
        } else {
            str = "";
        }
        this.mDate = str;
        this.mList.clear();
        List<String> list = this.mList;
        kotlin.jvm.internal.m.c(listD);
        list.addAll(listD);
        Map<String, List<j5.b>> mapG = com.live.evo.fragment.subjuect.b.c().g(response.k(), this.subjectTypeId);
        this.gameAllMaps = mapG;
        if (mapG != null) {
            kotlin.jvm.internal.m.c(mapG);
            this.subjectMatchListResponses = mapG.get(this.subjectTypeId);
        }
        this.gameClassificationMaps2 = com.live.evo.fragment.subjuect.b.c().h(this.subjectMatchListResponses);
        int i10 = this.classificationPos;
        List<? extends j5.b> list2 = this.subjectMatchListResponses;
        kotlin.jvm.internal.m.c(list2);
        if (i10 >= list2.size()) {
            this.classificationPos = 0;
        }
        List<? extends j5.b> list3 = this.subjectMatchListResponses;
        if (list3 != null) {
            kotlin.jvm.internal.m.c(list3);
            if (list3.size() > this.classificationPos) {
                List<? extends j5.b> list4 = this.subjectMatchListResponses;
                kotlin.jvm.internal.m.c(list4);
                Z = list4.get(this.classificationPos).b();
            }
        }
        u1();
        this.dataIsUpdate = true;
        this.isGetData = false;
        if (getActivity() != null && (activity = getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.live.evo.fragment.subjuect.l
                @Override // java.lang.Runnable
                public final void run() {
                    w.j1(this.f6731a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(w wVar) {
        wVar.b1();
        wVar.a1();
        wVar.Z0();
        wVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(w wVar) {
        wVar.U0();
    }

    @Override // com.live.evo.fragment.c
    protected void W(boolean visible) {
        super.onHiddenChanged(visible);
        this.handler.removeMessages(1);
        if (visible) {
            l1();
            com.live.evo.fragment.subjuect.c cVar = this.subjectMatchAdapter;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
            }
        }
    }

    public final void a() {
        if (getActivity() == null) {
            return;
        }
        requireActivity().runOnUiThread(new Runnable() { // from class: com.live.evo.fragment.subjuect.k
            @Override // java.lang.Runnable
            public final void run() {
                w.O0(this.f6730a);
            }
        });
    }

    public final void b() {
        if (getActivity() == null) {
            return;
        }
        requireActivity().runOnUiThread(new Runnable() { // from class: com.live.evo.fragment.subjuect.i
            @Override // java.lang.Runnable
            public final void run() {
                w.x1(this.f6728a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(View view) {
    }

    private final void g1(j5.b subjectMatchListResponse, j5.c subjectMatchProgramResponse, String watchType) {
    }
}
