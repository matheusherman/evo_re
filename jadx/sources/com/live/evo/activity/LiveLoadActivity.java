package com.live.evo.activity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p000lifecycle.Lifecycle;
import com.live.evo.MyApplication;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.activity.base.LoginBaseActivity;
import com.live.evo.widget.SpeedTextView;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;
import t.v.c.widget.videoview.VideoView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ã\u00012\u00020\u00012\u00020\u0002:\u0002ä\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b%\u0010\u0012J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010\u0012J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0004J\u001f\u0010+\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u000fH\u0002¢\u0006\u0004\b+\u0010,J)\u00100\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0014H\u0002¢\u0006\u0004\b0\u00101J3\u00104\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0005H\u0002¢\u0006\u0004\b6\u0010\u0004J!\u0010:\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u0001022\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J)\u0010>\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u0001022\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0014H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0005H\u0002¢\u0006\u0004\b@\u0010\u0004J\u000f\u0010A\u001a\u00020\u0005H\u0002¢\u0006\u0004\bA\u0010\u0004J\u0017\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0014H\u0002¢\u0006\u0004\bC\u0010\u0017J\u0017\u0010D\u001a\u00020\u00052\u0006\u00107\u001a\u000202H\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0005H\u0002¢\u0006\u0004\bF\u0010\u0004J\u000f\u0010G\u001a\u00020\u0005H\u0002¢\u0006\u0004\bG\u0010\u0004J\u000f\u0010H\u001a\u00020\u0005H\u0002¢\u0006\u0004\bH\u0010\u0004J\u000f\u0010I\u001a\u00020\u0005H\u0002¢\u0006\u0004\bI\u0010\u0004J\u0011\u0010K\u001a\u0004\u0018\u00010JH\u0002¢\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\bN\u0010EJ\u000f\u0010O\u001a\u00020\u0005H\u0002¢\u0006\u0004\bO\u0010\u0004J\u000f\u0010P\u001a\u00020\u0005H\u0002¢\u0006\u0004\bP\u0010\u0004J\u000f\u0010Q\u001a\u00020\u0005H\u0002¢\u0006\u0004\bQ\u0010\u0004J\u0017\u0010S\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\nH\u0002¢\u0006\u0004\bS\u0010\rJ\u000f\u0010T\u001a\u00020\u0005H\u0002¢\u0006\u0004\bT\u0010\u0004J\u000f\u0010U\u001a\u00020\u0005H\u0002¢\u0006\u0004\bU\u0010\u0004J\u0019\u0010X\u001a\u00020\u00052\b\u0010W\u001a\u0004\u0018\u00010VH\u0014¢\u0006\u0004\bX\u0010YJ\r\u0010[\u001a\u00020Z¢\u0006\u0004\b[\u0010\\J\r\u0010]\u001a\u00020\u0005¢\u0006\u0004\b]\u0010\u0004J\r\u0010^\u001a\u00020\u0005¢\u0006\u0004\b^\u0010\u0004J\r\u0010_\u001a\u00020\u0005¢\u0006\u0004\b_\u0010\u0004J\u0017\u0010`\u001a\u00020\u00052\u0006\u0010W\u001a\u00020VH\u0014¢\u0006\u0004\b`\u0010YJ\u000f\u0010a\u001a\u00020\u0005H\u0014¢\u0006\u0004\ba\u0010\u0004J\u000f\u0010b\u001a\u00020\u0005H\u0014¢\u0006\u0004\bb\u0010\u0004J'\u0010h\u001a\u00020\n2\u0006\u0010d\u001a\u00020c2\u0006\u0010e\u001a\u00020\u00142\u0006\u0010g\u001a\u00020fH\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\u0005H\u0014¢\u0006\u0004\bj\u0010\u0004J\u000f\u0010k\u001a\u00020\u0005H\u0014¢\u0006\u0004\bk\u0010\u0004J\u0017\u0010m\u001a\u00020\u00052\u0006\u0010l\u001a\u00020VH\u0014¢\u0006\u0004\bm\u0010YJ\u000f\u0010n\u001a\u00020\u0005H\u0014¢\u0006\u0004\bn\u0010\u0004J/\u0010t\u001a\u00020\u00052\u0006\u0010o\u001a\u00020\u00142\u000e\u0010q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0p2\u0006\u0010s\u001a\u00020rH\u0016¢\u0006\u0004\bt\u0010uJ\r\u0010v\u001a\u00020\u0005¢\u0006\u0004\bv\u0010\u0004J\u000f\u0010w\u001a\u00020\u0005H\u0016¢\u0006\u0004\bw\u0010\u0004J\u0019\u0010z\u001a\u00020\u00052\b\u0010y\u001a\u0004\u0018\u00010xH\u0007¢\u0006\u0004\bz\u0010{J\u0019\u0010}\u001a\u00020\u00052\b\u0010g\u001a\u0004\u0018\u00010|H\u0007¢\u0006\u0004\b}\u0010~R \u0010\u0083\u0001\u001a\u000b \u0080\u0001*\u0004\u0018\u00010\u007f0\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0019\u0010\u0099\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010¡\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u0019\u0010²\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u0098\u0001R\u001a\u0010´\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bd\u0010³\u0001R\u001c\u0010¸\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010º\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010\u0098\u0001R\u001c\u0010¾\u0001\u001a\u0005\u0018\u00010»\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001c\u0010Ä\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010 \u0001R\u001c\u0010È\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u0017\u0010Ê\u0001\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\b\n\u0006\bÉ\u0001\u0010³\u0001R\u0017\u0010Ì\u0001\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\b\n\u0006\bË\u0001\u0010³\u0001R\u001b\u0010Ï\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u0019\u0010Ñ\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010\u0098\u0001R\u0017\u0010Ô\u0001\u001a\u00020Z8\u0002X\u0083\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u0018\u0010Ø\u0001\u001a\u00030Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u001b\u0010Ú\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010³\u0001R\u001c\u0010Þ\u0001\u001a\u0005\u0018\u00010Û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u0019\u0010à\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010³\u0001R\u0019\u0010â\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010Ù\u0001¨\u0006å\u0001"}, d2 = {"Lcom/live/evo/activity/LiveLoadActivity;", "Lcom/live/evo/activity/base/LoginBaseActivity;", "Landroid/view/View$OnKeyListener;", "<init>", "()V", "Lr8/z;", "N1", "V1", "J1", "U0", "", "silenced", "M0", "(Z)V", "e1", "", "message", "s1", "(Ljava/lang/String;)V", "m1", "", "resId", "p1", "(I)V", "showData", "q1", "X1", "r1", "n1", "V0", "(Lv8/f;)Ljava/lang/Object;", "Q0", "()Ljava/lang/String;", "X0", "l1", "K1", NotificationCompat.CATEGORY_MESSAGE, "j1", "username", "k1", "E1", IjkMediaMeta.IJKM_KEY_TYPE, "code", "T1", "(ILjava/lang/String;)V", "errorMessage", "showBack", "showTab", "P1", "(Ljava/lang/String;ZI)V", "Landroidx/fragment/app/Fragment;", "originView", "Q1", "(Ljava/lang/String;ZILandroidx/fragment/app/Fragment;)V", "T0", TransactionPartnerType.FRAGMENT, "Li5/a;", "accountBean", "U1", "(Landroidx/fragment/app/Fragment;Li5/a;)V", "toRecharge", "registerType", "S1", "(Landroidx/fragment/app/Fragment;ZI)V", "A1", "I1", "remindType", "O1", "R1", "(Landroidx/fragment/app/Fragment;)V", "y1", "D1", "B1", "F1", "Landroidx/fragment/app/FragmentManager;", "K0", "()Landroidx/fragment/app/FragmentManager;", "prvFragment", "o1", "O0", "L0", "Y0", "hideVideoView", "L1", "R0", "x1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/os/Handler;", "S0", "()Landroid/os/Handler;", "d1", "w1", "W0", "onRestoreInstanceState", "onResume", "onStart", "Landroid/view/View;", "v", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "onPause", "onStop", "outState", "onSaveInstanceState", "onDestroy", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "C1", "onBackPressed", "Li5/x;", "noticeItem", "onNotice", "(Li5/x;)V", "Lnf/d;", "onChannelUpdateEvent", "(Lnf/d;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "h", "Lq6/b;", "logger", "Lcom/tvc/lib/mobile/ui/widget/b;", "i", "Lcom/tvc/lib/mobile/ui/widget/b;", "loadingView", "j", "Landroidx/fragment/app/FragmentManager;", "mFm", "Lcom/live/evo/fragment/t1$b;", "k", "Lcom/live/evo/fragment/t1$b;", "mNetworkTester", "Lcom/live/evo/dialog/m;", "l", "Lcom/live/evo/dialog/m;", "mExitDialog", "Lcom/live/evo/widget/SpeedTextView;", "m", "Lcom/live/evo/widget/SpeedTextView;", "mNoticeView", "n", "Z", "mBackPressedAgain", "Lt/v/c/widget/videoview/VideoView;", "o", "Lt/v/c/widget/videoview/VideoView;", "mVideoView", "Landroid/widget/TextView;", "p", "Landroid/widget/TextView;", "mVersion", "Landroid/widget/ImageView;", "q", "Landroid/widget/ImageView;", "mImageVideoCurtain", "Landroid/graphics/drawable/Drawable;", "r", "Landroid/graphics/drawable/Drawable;", "mCurtainDrawable", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "mMainRoot", "t", "Landroid/view/View;", "mRoot", "u", "mBootWithVideo", "Ljava/lang/String;", "mBootVideoUri", "Lcom/live/evo/dialog/q;", "w", "Lcom/live/evo/dialog/q;", "noticeAlertDialog", "x", "mHasStartLive", "Landroid/widget/LinearLayout;", "y", "Landroid/widget/LinearLayout;", "mAdSkipLayout", "Landroid/widget/ImageButton;", "z", "Landroid/widget/ImageButton;", "mAdIv", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mAdSkipTip", "Lv4/d;", "B", "Lv4/d;", "adNewViewManager", "C", "icon_free_trail", "D", "icon_normal", ExifInterface.LONGITUDE_EAST, "Ljava/lang/Integer;", "startType", "F", "isOnSavedState", "G", "Landroid/os/Handler;", "mHandler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "H", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInChecking", "I", "apkFile", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "J", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "upgradeInfo", "K", "lastVersion", "L", "lastProgress", "M", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CustomSplashScreen"})
public final class LiveLoadActivity extends LoginBaseActivity implements View.OnKeyListener {

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String N;
    private static final String O;
    private static final String P;
    private static final String Q;
    private static final String R;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private TextView mAdSkipTip;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private v4.d adNewViewManager;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private Integer startType;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private boolean isOnSavedState;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private UpgradeInfo upgradeInfo;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private int lastProgress;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tvc.lib.mobile.ui.widget.b loadingView;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private FragmentManager mFm;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.fragment.t1.b mNetworkTester;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.dialog.m mExitDialog;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private SpeedTextView mNoticeView;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean mBackPressedAgain;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private VideoView mVideoView;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView mVersion;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private ImageView mImageVideoCurtain;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Drawable mCurtainDrawable;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mMainRoot;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private View mRoot;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean mBootWithVideo;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private String mBootVideoUri;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.dialog.q noticeAlertDialog;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean mHasStartLive;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAdSkipLayout;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private ImageButton mAdIv;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(LiveLoadActivity.class);

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private final String icon_free_trail = "com.live.evo.freetrial";

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private final String icon_normal = "com.live.evo.normal";

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    @SuppressLint({"HandlerLeak"})
    private final Handler mHandler = new f();

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private final AtomicBoolean isInChecking = new AtomicBoolean(false);

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private String apkFile = "";

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private String lastVersion = "";

    /* JADX INFO: renamed from: com.live.evo.activity.LiveLoadActivity$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/live/evo/activity/LiveLoadActivity$a;", "", "<init>", "()V", "", "TIP_NOT_SURPORT_VERSION", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final String a() {
            return LiveLoadActivity.R;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$checkUpdate$1", f = "LiveLoadActivity.kt", l = {745}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ boolean $silenced;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/activity/LiveLoadActivity$b$a", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveLoadActivity f5269a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f5270b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f5271c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f5272d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Integer f5273e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ nf.a0 f5274f;

            a(LiveLoadActivity liveLoadActivity, String str, String str2, boolean z10, Integer num, nf.a0 a0Var) {
                this.f5269a = liveLoadActivity;
                this.f5270b = str;
                this.f5271c = str2;
                this.f5272d = z10;
                this.f5273e = num;
                this.f5274f = a0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f5269a.isDestroyed()) {
                    UpgradeInfo upgradeInfo = this.f5269a.upgradeInfo;
                    if (upgradeInfo == null || TextUtils.isEmpty(this.f5270b)) {
                        return;
                    }
                    xe.c.c().o(new nf.z(upgradeInfo, this.f5270b));
                    return;
                }
                if (!kotlin.jvm.internal.m.a(this.f5269a.lastVersion, this.f5271c) && !TextUtils.isEmpty(this.f5271c)) {
                    this.f5269a.lastVersion = this.f5271c;
                    if (!this.f5272d) {
                        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                        kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
                        String str = String.format("%s:%s", Arrays.copyOf(new Object[]{this.f5269a.getString(R$string.new_version), this.f5271c}, 2));
                        kotlin.jvm.internal.m.e(str, "format(...)");
                        g1Var.c(str);
                    }
                }
                int i10 = this.f5269a.lastProgress;
                Integer num = this.f5273e;
                boolean z10 = num == null || i10 != num.intValue();
                if (this.f5273e != null && z10) {
                    if (y4.a.f22397a.booleanValue()) {
                        this.f5269a.logger.debug("upgrade download " + this.f5273e + " " + this.f5269a.lastProgress + " " + z10 + "%", new Object[0]);
                    }
                    this.f5269a.lastProgress = this.f5273e.intValue();
                    if (!this.f5272d) {
                        UpgradeInfo upgradeInfo2 = this.f5269a.upgradeInfo;
                        String versionName = upgradeInfo2 != null ? upgradeInfo2.getVersionName() : null;
                        this.f5269a.X1(versionName + " " + this.f5269a.getString(R$string.downloading, this.f5273e.toString()));
                    }
                }
                if (!TextUtils.isEmpty(this.f5270b)) {
                    if (y4.a.f22397a.booleanValue()) {
                        this.f5269a.logger.debug("upgrade ready " + this.f5270b, new Object[0]);
                    }
                    this.f5269a.apkFile = this.f5270b;
                    if (!this.f5272d) {
                        LiveLoadActivity liveLoadActivity = this.f5269a;
                        String string = liveLoadActivity.getString(2131952556);
                        kotlin.jvm.internal.m.e(string, "getString(...)");
                        liveLoadActivity.X1(string);
                        this.f5269a.e1();
                    }
                }
                nf.a0 a0Var = this.f5274f;
                if (a0Var != null && !this.f5272d) {
                    x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
                    String strA = a0Var.a();
                    kotlin.jvm.internal.m.e(strA, "getErrMsg(...)");
                    g1Var2.c(strA);
                }
                this.f5269a.isInChecking.set(false);
            }
        }

        /* JADX INFO: renamed from: com.live.evo.activity.LiveLoadActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$checkUpdate$1$2", f = "LiveLoadActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0064b extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super UpgradeInfo>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LiveLoadActivity this$0;

            /* JADX INFO: renamed from: com.live.evo.activity.LiveLoadActivity$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$checkUpdate$1$2$1", f = "LiveLoadActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ LiveLoadActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(LiveLoadActivity liveLoadActivity, Throwable th, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = liveLoadActivity;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$it, fVar);
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
                        x1.f1.lb.util.g1.f21390a.c(this.this$0.getString(R$string.check_failed) + ":" + this.$it.getMessage());
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0064b(LiveLoadActivity liveLoadActivity, v8.f<? super C0064b> fVar) {
                super(3, fVar);
                this.this$0 = liveLoadActivity;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super UpgradeInfo> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                C0064b c0064b = new C0064b(this.this$0, fVar);
                c0064b.L$0 = th;
                return c0064b.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.this$0, th, null), 3, null);
                    this.this$0.logger.error("check upgrade failure", th);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class c<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveLoadActivity f5275a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f5276b;

            c(LiveLoadActivity liveLoadActivity, boolean z10) {
                this.f5275a = liveLoadActivity;
                this.f5276b = z10;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(UpgradeInfo upgradeInfo, v8.f<? super r8.z> fVar) {
                String versionName;
                this.f5275a.upgradeInfo = upgradeInfo;
                this.f5275a.isInChecking.set(false);
                if (this.f5275a.isDestroyed()) {
                    return r8.z.f17874a;
                }
                if (!this.f5276b) {
                    if (upgradeInfo == null) {
                        this.f5275a.K1();
                        return r8.z.f17874a;
                    }
                    LiveLoadActivity liveLoadActivity = this.f5275a;
                    UpgradeInfo upgradeInfo2 = liveLoadActivity.upgradeInfo;
                    if (upgradeInfo2 == null || (versionName = upgradeInfo2.getVersionName()) == null) {
                        versionName = "";
                    }
                    liveLoadActivity.q1(versionName);
                }
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z10, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$silenced = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveLoadActivity.this.new b(this.$silenced, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z c(LiveLoadActivity liveLoadActivity, boolean z10, String str, Integer num, String str2, nf.a0 a0Var) {
            liveLoadActivity.mHandler.post(new a(liveLoadActivity, str2, str, z10, num, a0Var));
            return r8.z.f17874a;
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
                Lifecycle lifecycle = LiveLoadActivity.this.getLifecycle();
                final LiveLoadActivity liveLoadActivity = LiveLoadActivity.this;
                final boolean z10 = this.$silenced;
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(aVar.c(lifecycle, new c9.r() { // from class: com.live.evo.activity.a0
                    @Override // c9.r
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return LiveLoadActivity.b.c(liveLoadActivity, z10, (String) obj2, (Integer) obj3, (String) obj4, (nf.a0) obj5);
                    }
                }), new C0064b(LiveLoadActivity.this, null));
                c cVar = new c(LiveLoadActivity.this, this.$silenced);
                this.label = 1;
                if (fVarF.collect(cVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$initData$1", f = "LiveLoadActivity.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        c(v8.f<? super c> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveLoadActivity.this.new c(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                if (!LiveLoadActivity.this.isFinishing() && !LiveLoadActivity.this.isDestroyed() && !LiveLoadActivity.this.isOnSavedState) {
                    try {
                        com.live.evo.util.m.b("liveLoadInitData");
                        LiveLoadActivity liveLoadActivity = LiveLoadActivity.this;
                        liveLoadActivity.mNetworkTester = com.live.evo.fragment.t1.INSTANCE.a(liveLoadActivity);
                        LiveLoadActivity liveLoadActivity2 = LiveLoadActivity.this;
                        liveLoadActivity2.mExitDialog = new com.live.evo.dialog.m(liveLoadActivity2);
                        FragmentManager supportFragmentManager = LiveLoadActivity.this.getSupportFragmentManager();
                        kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
                        if (!supportFragmentManager.isDestroyed()) {
                            LiveLoadActivity.this.mFm = supportFragmentManager;
                            return r8.z.f17874a;
                        }
                        LiveLoadActivity.this.mHandler.sendEmptyMessage(620908586);
                        return r8.z.f17874a;
                    } catch (Throwable th) {
                        LiveLoadActivity.this.logger.error("init failure", th);
                    }
                } else {
                    return r8.z.f17874a;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$initRuntimeEnv$1", f = "LiveLoadActivity.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        d(v8.f<? super d> fVar) {
            super(2, fVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g() {
            com.live.evo.boot.b.f5537a.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(final LiveLoadActivity liveLoadActivity) {
            com.live.evo.util.m.c("showNetworkDlg", 1L);
            com.live.evo.fragment.t1.INSTANCE.f(liveLoadActivity, liveLoadActivity.mNetworkTester, new c9.l() { // from class: com.live.evo.activity.d0
                @Override // c9.l
                public final Object invoke(Object obj) {
                    return LiveLoadActivity.d.k(liveLoadActivity, ((Boolean) obj).booleanValue());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z k(LiveLoadActivity liveLoadActivity, boolean z10) {
            if (z10) {
                liveLoadActivity.mHandler.sendEmptyMessage(620908546);
            } else {
                liveLoadActivity.s1(com.live.evo.util.x1.j(2131952547));
            }
            return r8.z.f17874a;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveLoadActivity.this.new d(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                zf.f fVarE = zf.f.e();
                if (fVarE != null) {
                    fVarE.u();
                }
                String strQ0 = LiveLoadActivity.this.Q0();
                LiveLoadActivity.this.getIntent().removeExtra("channelId");
                LiveLoadActivity.this.logger.a("extraChannelId = " + strQ0, new Object[0]);
                com.live.evo.boot.a.a(new Runnable() { // from class: com.live.evo.activity.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveLoadActivity.d.g();
                    }
                });
                com.live.evo.util.n1.a();
                zf.f fVarE2 = zf.f.e();
                if (fVarE2 != null && fVarE2.n()) {
                    com.live.evo.util.m.c("showNetworkDlg", 0L);
                    kotlin.coroutines.jvm.internal.b.a(LiveLoadActivity.this.mHandler.sendEmptyMessage(620908546));
                } else {
                    com.live.evo.util.k1 k1Var = com.live.evo.util.k1.f7250a;
                    final LiveLoadActivity liveLoadActivity = LiveLoadActivity.this;
                    k1Var.c(new Runnable() { // from class: com.live.evo.activity.c0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveLoadActivity.d.j(liveLoadActivity);
                        }
                    });
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/activity/LiveLoadActivity$e", "Lcom/live/evo/dialog/y$d;", "Lr8/z;", "a", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e extends com.live.evo.dialog.y.d {
        e() {
        }

        @Override // com.live.evo.dialog.y.e
        public void a() {
            LiveLoadActivity.this.O0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/live/evo/activity/LiveLoadActivity$f", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "", "a", "Z", "isFirstLogin", "()Z", "setFirstLogin", "(Z)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isFirstLogin;

        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            switch (msg.what) {
                case 620908546:
                    LiveLoadActivity.this.M0(true);
                    sendEmptyMessage(620908583);
                    break;
                case 620908561:
                    com.live.evo.util.m.b("liveLoadActivate");
                    LiveLoadActivity.this.A1();
                    break;
                case 620908570:
                    com.live.evo.util.m.b("liveLoadRemind");
                    if (!this.isFirstLogin) {
                        LiveLoadActivity.this.I1();
                    } else {
                        sendEmptyMessage(620908586);
                    }
                    break;
                case 620908574:
                    LiveLoadActivity.this.J1();
                    break;
                case 620908577:
                    if (!MyApplication.a().d()) {
                        sendEmptyMessageDelayed(620908577, 50L);
                    } else {
                        LiveLoadActivity.this.p1(R$string.init_env);
                        com.live.evo.util.m.b("liveLoadReqPermisson");
                        LiveLoadActivity.this.n1();
                    }
                    break;
                case 620908582:
                    com.live.evo.util.m.b("liveLoadInitRuntimeEnv");
                    LiveLoadActivity.this.X0();
                    break;
                case 620908583:
                    com.live.evo.util.m.b("liveLoadQueryLogin");
                    LiveLoadActivity.this.l1();
                    break;
                case 620908584:
                    com.live.evo.util.m.b("liveLoadLogin");
                    LiveLoadActivity.this.p1(R$string.account_login_title);
                    LiveLoadActivity.this.E1();
                    break;
                case 620908586:
                    com.live.evo.util.m.b("liveLoadFixDst");
                    LiveLoadActivity.this.p1(2131952318);
                    LiveLoadActivity.this.y1();
                    break;
                case 620908588:
                    com.live.evo.util.m.b("liveLoadShowWelcom");
                    this.isFirstLogin = true;
                    LiveLoadActivity.this.V1();
                    break;
                case 620908589:
                    LiveLoadActivity.this.N1();
                    break;
                case 620908590:
                    LiveLoadActivity.this.W0();
                    break;
                case 620908591:
                    LiveLoadActivity.this.mBackPressedAgain = false;
                    break;
                case 620908593:
                    LiveLoadActivity.this.R0();
                    break;
                case 620908597:
                    LiveLoadActivity.this.w1();
                    break;
                case 620908602:
                    LiveLoadActivity.this.F1();
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$onCreate$1", f = "LiveLoadActivity.kt", l = {194}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveLoadActivity$g$a", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Z)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements x1.f1.lb.util.m<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveLoadActivity f5280a;

            a(LiveLoadActivity liveLoadActivity) {
                this.f5280a = liveLoadActivity;
            }

            @Override // x1.f1.lb.util.m
            public /* bridge */ /* synthetic */ void a(Boolean bool) {
                c(bool.booleanValue());
            }

            public void c(boolean v10) {
                this.f5280a.mHandler.sendEmptyMessage(620908597);
            }
        }

        g(v8.f<? super g> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveLoadActivity.this.new g(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((g) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                LiveLoadActivity liveLoadActivity = LiveLoadActivity.this;
                this.label = 1;
                if (liveLoadActivity.V0(this) == objC) {
                    return objC;
                }
            }
            v4.b.o().v(new a(LiveLoadActivity.this));
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveLoadActivity$h", "Lx1/f1/lb/util/w0$a;", "", "value", "Lr8/z;", "e", "(Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements x1.f1.lb.util.w0.a<String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f5282b;

        h(String str) {
            this.f5282b = str;
        }

        @Override // x1.f1.lb.util.w0.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(final String value) {
            kotlin.jvm.internal.m.f(value, "value");
            final LiveLoadActivity liveLoadActivity = LiveLoadActivity.this;
            final String str = this.f5282b;
            liveLoadActivity.runOnUiThread(new Runnable() { // from class: com.live.evo.activity.e0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveLoadActivity.h.f(value, str, liveLoadActivity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(String str, String str2, final LiveLoadActivity liveLoadActivity) {
            if (str.length() != 0 && !kotlin.jvm.internal.m.a(str, str2)) {
                liveLoadActivity.K1();
                return;
            }
            if (str.length() == 0) {
                x1.f1.lb.util.w0.f21452a.t(LiveLoadActivity.INSTANCE.a(), str2);
            }
            String string = liveLoadActivity.getString(R$string.force_logout_not_support_version, t.v.c.i.a.f18646a.N());
            kotlin.jvm.internal.m.e(string, "getString(...)");
            com.live.evo.dialog.b.i(liveLoadActivity, string, liveLoadActivity.getString(2131951877), liveLoadActivity.getString(2131952019), new Runnable() { // from class: com.live.evo.activity.f0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveLoadActivity.h.g(liveLoadActivity);
                }
            }, new Runnable() { // from class: com.live.evo.activity.g0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveLoadActivity.h.h(liveLoadActivity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(LiveLoadActivity liveLoadActivity) {
            if (!TextUtils.isEmpty(liveLoadActivity.apkFile)) {
                liveLoadActivity.e1();
            } else {
                LiveLoadActivity.N0(liveLoadActivity, false, 1, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(LiveLoadActivity liveLoadActivity) {
            liveLoadActivity.O0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$startLogin$1", f = "LiveLoadActivity.kt", l = {1166}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class i extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$startLogin$1$1", f = "LiveLoadActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LiveLoadActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LiveLoadActivity liveLoadActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = liveLoadActivity;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    this.this$0.logger.error("loginFlow error", th);
                    LiveLoadActivity liveLoadActivity = this.this$0;
                    String message = th.getMessage();
                    if (message == null) {
                        message = this.this$0.getString(2131953089);
                        kotlin.jvm.internal.m.e(message, "getString(...)");
                    }
                    liveLoadActivity.j1(message);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveLoadActivity f5283a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveLoadActivity$startLogin$1$2$1", f = "LiveLoadActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ LiveLoadActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(LiveLoadActivity liveLoadActivity, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = liveLoadActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, fVar);
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
                        this.this$0.mHandler.sendEmptyMessage(620908570);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(LiveLoadActivity liveLoadActivity) {
                this.f5283a = liveLoadActivity;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final r8.z d(LiveLoadActivity liveLoadActivity, boolean z10) {
                if (z10) {
                    liveLoadActivity.logger.a("network is resume try login again", new Object[0]);
                    liveLoadActivity.mHandler.sendEmptyMessage(620908584);
                } else {
                    liveLoadActivity.r1(2131952547);
                }
                return r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                if (uVar.d().booleanValue()) {
                    Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.c(), new a(this.f5283a, null), fVar);
                    if (objG == kotlin.coroutines.intrinsics.b.c()) {
                        return objG;
                    }
                    return r8.z.f17874a;
                }
                Integer numE = uVar.e();
                if (numE == null || numE.intValue() != -3) {
                    this.f5283a.k1(t.v.c.i.a.f18646a.Z());
                    this.f5283a.logger.error("loginFlow error:{}", uVar);
                } else {
                    com.live.evo.fragment.t1.Companion companion = com.live.evo.fragment.t1.INSTANCE;
                    LiveLoadActivity liveLoadActivity = this.f5283a;
                    com.live.evo.fragment.t1.b bVar = liveLoadActivity.mNetworkTester;
                    final LiveLoadActivity liveLoadActivity2 = this.f5283a;
                    companion.f(liveLoadActivity, bVar, new c9.l() { // from class: com.live.evo.activity.h0
                        @Override // c9.l
                        public final Object invoke(Object obj) {
                            return LiveLoadActivity.i.b.d(liveLoadActivity2, ((Boolean) obj).booleanValue());
                        }
                    });
                }
                return r8.z.f17874a;
            }
        }

        i(v8.f<? super i> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveLoadActivity.this.new i(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((i) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                LiveLoadActivity.this.p1(2131952330);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(kotlinx.coroutines.flow.h.y(t.v.c.i.a.f18646a.x0(), kotlinx.coroutines.a1.b()), new a(LiveLoadActivity.this, null));
                b bVar = new b(LiveLoadActivity.this);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/live/evo/activity/LiveLoadActivity$j", "Le5/f;", "Landroidx/fragment/app/Fragment;", "rechargeRemindFragment", "Lr8/z;", "a", "(Landroidx/fragment/app/Fragment;)V", "b", "", "showTab", "c", "(Landroidx/fragment/app/Fragment;I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j implements e5.f {
        j() {
        }

        @Override // e5.f
        public void a(Fragment rechargeRemindFragment) {
            kotlin.jvm.internal.m.f(rechargeRemindFragment, "rechargeRemindFragment");
            LiveLoadActivity.this.o1(rechargeRemindFragment);
            LiveLoadActivity.this.mHandler.sendEmptyMessage(620908586);
        }

        @Override // e5.f
        public void b(Fragment rechargeRemindFragment) {
            kotlin.jvm.internal.m.f(rechargeRemindFragment, "rechargeRemindFragment");
            LiveLoadActivity.this.R1(rechargeRemindFragment);
        }

        @Override // e5.f
        public void c(Fragment rechargeRemindFragment, int showTab) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionHide;
            kotlin.jvm.internal.m.f(rechargeRemindFragment, "rechargeRemindFragment");
            FragmentManager fragmentManagerK0 = LiveLoadActivity.this.K0();
            if (fragmentManagerK0 != null && (fragmentTransactionBeginTransaction = fragmentManagerK0.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(rechargeRemindFragment)) != null) {
                fragmentTransactionHide.commitAllowingStateLoss();
            }
            LiveLoadActivity.this.Q1("", true, showTab, rechargeRemindFragment);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/live/evo/activity/LiveLoadActivity$k", "Lcom/live/evo/fragment/login/d$a;", "Lr8/z;", "a", "()V", "next", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k implements com.live.evo.fragment.login.d.a {
        k() {
        }

        @Override // com.live.evo.fragment.login.d.a
        public void a() {
            LiveLoadActivity.this.o1(null);
            LiveLoadActivity.this.O0();
        }

        @Override // com.live.evo.fragment.login.d.a
        public void next() {
            LiveLoadActivity.this.o1(null);
            LiveLoadActivity.this.mHandler.sendEmptyMessage(620908584);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveLoadActivity$l", "Lcom/live/evo/fragment/login/h$b;", "Landroidx/fragment/app/Fragment;", TransactionPartnerType.FRAGMENT, "Lr8/z;", "a", "(Landroidx/fragment/app/Fragment;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l implements com.live.evo.fragment.login.h.b {
        l() {
        }

        @Override // com.live.evo.fragment.login.h.b
        public void a(Fragment fragment) {
            kotlin.jvm.internal.m.f(fragment, "fragment");
            LiveLoadActivity.this.o1(fragment);
            LiveLoadActivity.this.mHandler.sendEmptyMessage(620908561);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"com/live/evo/activity/LiveLoadActivity$m", "Le5/c;", "Landroidx/fragment/app/Fragment;", TransactionPartnerType.FRAGMENT, "Lr8/z;", "b", "(Landroidx/fragment/app/Fragment;)V", "d", "Li5/a;", "accountBean", "e", "(Landroidx/fragment/app/Fragment;Li5/a;)V", "f", "a", "c", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m implements e5.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f5288b;

        m(Fragment fragment) {
            this.f5288b = fragment;
        }

        @Override // e5.c
        public void a(Fragment f10) {
            FragmentManager fragmentManagerK0;
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionShow;
            FragmentTransaction fragmentTransactionBeginTransaction2;
            FragmentTransaction fragmentTransactionHide;
            kotlin.jvm.internal.m.f(f10, "f");
            FragmentManager fragmentManagerK1 = LiveLoadActivity.this.K0();
            if (fragmentManagerK1 != null && (fragmentTransactionBeginTransaction2 = fragmentManagerK1.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction2.hide(f10)) != null) {
                fragmentTransactionHide.commitAllowingStateLoss();
            }
            if (this.f5288b == null || (fragmentManagerK0 = LiveLoadActivity.this.K0()) == null || (fragmentTransactionBeginTransaction = fragmentManagerK0.beginTransaction()) == null || (fragmentTransactionShow = fragmentTransactionBeginTransaction.show(this.f5288b)) == null) {
                return;
            }
            fragmentTransactionShow.commitAllowingStateLoss();
        }

        @Override // e5.c
        public void b(Fragment fragment) {
            kotlin.jvm.internal.m.f(fragment, "fragment");
            LiveLoadActivity liveLoadActivity = LiveLoadActivity.this;
            String strJ = com.live.evo.util.x1.j(2131952318);
            kotlin.jvm.internal.m.e(strJ, "getString(...)");
            liveLoadActivity.q1(strJ);
            LiveLoadActivity.this.o1(fragment);
            LiveLoadActivity.this.mHandler.sendEmptyMessage(620908561);
        }

        @Override // e5.c
        public void c(Fragment fragment) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionHide;
            kotlin.jvm.internal.m.f(fragment, "fragment");
            FragmentManager fragmentManager = LiveLoadActivity.this.mFm;
            if (fragmentManager != null && (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(fragment)) != null) {
                fragmentTransactionHide.commitAllowingStateLoss();
            }
            LiveLoadActivity.this.T1(40, t.v.c.i.a.f18646a.r());
        }

        @Override // e5.c
        public void d(Fragment fragment) {
            kotlin.jvm.internal.m.f(fragment, "fragment");
            LiveLoadActivity.this.S1(fragment, true, 2);
        }

        @Override // e5.c
        public void e(Fragment fragment, i5.a accountBean) {
            kotlin.jvm.internal.m.f(fragment, "fragment");
            kotlin.jvm.internal.m.f(accountBean, "accountBean");
            LiveLoadActivity.this.U1(fragment, accountBean);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/live/evo/activity/LiveLoadActivity$n", "Lcom/live/evo/fragment/login/k;", "Landroidx/fragment/app/Fragment;", "rechargeFragment", "Lr8/z;", "b", "(Landroidx/fragment/app/Fragment;)V", "f", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class n implements com.live.evo.fragment.login.k {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveLoadActivity$n$a", "Lcom/live/evo/fragment/login/h$b;", "Landroidx/fragment/app/Fragment;", "loginFinishFragment", "Lr8/z;", "a", "(Landroidx/fragment/app/Fragment;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements com.live.evo.fragment.login.h.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveLoadActivity f5290a;

            a(LiveLoadActivity liveLoadActivity) {
                this.f5290a = liveLoadActivity;
            }

            @Override // com.live.evo.fragment.login.h.b
            public void a(Fragment loginFinishFragment) {
                kotlin.jvm.internal.m.f(loginFinishFragment, "loginFinishFragment");
                this.f5290a.o1(loginFinishFragment);
                this.f5290a.mHandler.sendEmptyMessage(620908586);
            }
        }

        n() {
        }

        @Override // com.live.evo.fragment.login.k
        public void a(Fragment f10) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionShow;
            FragmentTransaction fragmentTransactionBeginTransaction2;
            FragmentTransaction fragmentTransactionHide;
            kotlin.jvm.internal.m.f(f10, "f");
            FragmentManager fragmentManagerK0 = LiveLoadActivity.this.K0();
            Fragment fragmentFindFragmentByTag = fragmentManagerK0 != null ? fragmentManagerK0.findFragmentByTag("RechargeRemindFragment") : null;
            FragmentManager fragmentManagerK1 = LiveLoadActivity.this.K0();
            if (fragmentManagerK1 != null && (fragmentTransactionBeginTransaction2 = fragmentManagerK1.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction2.hide(f10)) != null) {
                fragmentTransactionHide.commitAllowingStateLoss();
            }
            if (fragmentFindFragmentByTag == null) {
                LiveLoadActivity.this.P1("", false, 0);
                return;
            }
            FragmentManager fragmentManagerK2 = LiveLoadActivity.this.K0();
            if (fragmentManagerK2 == null || (fragmentTransactionBeginTransaction = fragmentManagerK2.beginTransaction()) == null || (fragmentTransactionShow = fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag)) == null) {
                return;
            }
            fragmentTransactionShow.commitAllowingStateLoss();
        }

        @Override // com.live.evo.fragment.login.k
        public void b(Fragment rechargeFragment) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionHide;
            kotlin.jvm.internal.m.f(rechargeFragment, "rechargeFragment");
            FragmentManager fragmentManager = LiveLoadActivity.this.mFm;
            if (fragmentManager != null && (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(rechargeFragment)) != null) {
                fragmentTransactionHide.commitAllowingStateLoss();
            }
            com.live.evo.fragment.login.h.X(LiveLoadActivity.this.K0(), R$id.root, t.v.c.i.a.f18646a.Z().length() == 0 ? 9 : 0, new a(LiveLoadActivity.this));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/live/evo/activity/LiveLoadActivity$o", "Le5/h;", "Landroidx/fragment/app/Fragment;", "f", "Lr8/z;", "b", "(Landroidx/fragment/app/Fragment;)V", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o implements e5.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f5292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f5293c;

        o(boolean z10, Fragment fragment) {
            this.f5292b = z10;
            this.f5293c = fragment;
        }

        @Override // e5.h
        public void a(Fragment f10) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionHide;
            FragmentTransaction fragmentTransactionShow;
            kotlin.jvm.internal.m.f(f10, "f");
            if (this.f5293c == null) {
                LiveLoadActivity.this.P1("", false, 0);
                return;
            }
            FragmentManager fragmentManager = LiveLoadActivity.this.mFm;
            if (fragmentManager == null || (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) == null || (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(f10)) == null || (fragmentTransactionShow = fragmentTransactionHide.show(this.f5293c)) == null) {
                return;
            }
            fragmentTransactionShow.commitAllowingStateLoss();
        }

        @Override // e5.h
        public void b(Fragment f10) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionHide;
            kotlin.jvm.internal.m.f(f10, "f");
            FragmentManager fragmentManager = LiveLoadActivity.this.mFm;
            if (fragmentManager != null && (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(f10)) != null) {
                fragmentTransactionHide.commitAllowingStateLoss();
            }
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            if (!aVar.a0() || aVar.l0()) {
                LiveLoadActivity.this.O1(10);
            } else if (this.f5292b) {
                LiveLoadActivity.this.O1(7);
            } else {
                LiveLoadActivity.this.O1(3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/live/evo/activity/LiveLoadActivity$p", "Lcom/live/evo/fragment/login/r$c;", "Landroidx/fragment/app/Fragment;", TransactionPartnerType.FRAGMENT, "Lr8/z;", "a", "(Landroidx/fragment/app/Fragment;)V", "c", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p implements com.live.evo.fragment.login.r.c {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"com/live/evo/activity/LiveLoadActivity$p$a", "Lcom/live/evo/osd/a;", "Lr8/z;", "c", "()V", "e", "a", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements com.live.evo.osd.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveLoadActivity f5295a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Fragment f5296b;

            a(LiveLoadActivity liveLoadActivity, Fragment fragment) {
                this.f5295a = liveLoadActivity;
                this.f5296b = fragment;
            }

            @Override // com.live.evo.osd.a
            public void c() {
                LiveLoadActivity liveLoadActivity = this.f5295a;
                String strJ = com.live.evo.util.x1.j(2131952318);
                kotlin.jvm.internal.m.e(strJ, "getString(...)");
                liveLoadActivity.q1(strJ);
                this.f5295a.o1(this.f5296b);
                this.f5295a.mHandler.sendEmptyMessage(620908561);
            }

            @Override // com.live.evo.osd.p
            public void e() {
                LiveLoadActivity liveLoadActivity = this.f5295a;
                String strJ = com.live.evo.util.x1.j(2131952318);
                kotlin.jvm.internal.m.e(strJ, "getString(...)");
                liveLoadActivity.q1(strJ);
                this.f5295a.o1(this.f5296b);
                this.f5295a.mHandler.sendEmptyMessage(620908561);
            }

            @Override // com.live.evo.osd.p
            public void a() {
            }

            @Override // com.live.evo.osd.p
            public void b() {
            }
        }

        p() {
        }

        @Override // com.live.evo.fragment.login.r.c
        public void a(Fragment fragment) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionHide;
            kotlin.jvm.internal.m.f(fragment, "fragment");
            FragmentManager fragmentManager = LiveLoadActivity.this.mFm;
            if (fragmentManager != null && (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(fragment)) != null) {
                fragmentTransactionHide.commitAllowingStateLoss();
            }
            LiveLoadActivity.this.P1("", false, 3);
        }

        @Override // com.live.evo.fragment.login.r.c
        public void b(Fragment fragment) {
            kotlin.jvm.internal.m.f(fragment, "fragment");
            com.live.evo.fragment.login.j.g0(LiveLoadActivity.this.mFm, 25, new a(LiveLoadActivity.this, fragment));
        }

        @Override // com.live.evo.fragment.login.r.c
        public void c(Fragment fragment) {
            kotlin.jvm.internal.m.f(fragment, "fragment");
            LiveLoadActivity liveLoadActivity = LiveLoadActivity.this;
            String strJ = com.live.evo.util.x1.j(2131952318);
            kotlin.jvm.internal.m.e(strJ, "getString(...)");
            liveLoadActivity.q1(strJ);
            LiveLoadActivity.this.o1(fragment);
            LiveLoadActivity.this.mHandler.sendEmptyMessage(620908561);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/live/evo/activity/LiveLoadActivity$q", "Le5/j;", "Landroidx/fragment/app/Fragment;", TransactionPartnerType.FRAGMENT, "Lr8/z;", "b", "(Landroidx/fragment/app/Fragment;)V", "resetFragment", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class q implements e5.j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f5298b;

        q(Fragment fragment) {
            this.f5298b = fragment;
        }

        @Override // e5.j
        public void a(Fragment resetFragment) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionHide;
            FragmentTransaction fragmentTransactionShow;
            kotlin.jvm.internal.m.f(resetFragment, "resetFragment");
            if (this.f5298b == null) {
                LiveLoadActivity.this.P1("", false, 0);
                return;
            }
            FragmentManager fragmentManager = LiveLoadActivity.this.mFm;
            if (fragmentManager == null || (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) == null || (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(resetFragment)) == null || (fragmentTransactionShow = fragmentTransactionHide.show(this.f5298b)) == null) {
                return;
            }
            fragmentTransactionShow.commitAllowingStateLoss();
        }

        @Override // e5.j
        public void b(Fragment fragment) {
            FragmentTransaction fragmentTransactionBeginTransaction;
            FragmentTransaction fragmentTransactionHide;
            kotlin.jvm.internal.m.f(fragment, "fragment");
            FragmentManager fragmentManager = LiveLoadActivity.this.mFm;
            if (fragmentManager != null && (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(fragment)) != null) {
                fragmentTransactionHide.commitAllowingStateLoss();
            }
            LiveLoadActivity.this.O1(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(String errorMessage, boolean showBack, int showTab) {
        Q1(errorMessage, showBack, showTab, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V1() {
        L1(true);
        com.live.evo.fragment.login.w.U(K0(), R$id.root, new com.live.evo.fragment.login.i() { // from class: com.live.evo.activity.s
            @Override // com.live.evo.fragment.login.i
            public final void a(Fragment fragment) {
                LiveLoadActivity.W1(this.f5506a, fragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b1(LiveLoadActivity liveLoadActivity, IMediaPlayer iMediaPlayer, int i10, int i11) {
        liveLoadActivity.L1(true);
        ImageView imageView = liveLoadActivity.mImageVideoCurtain;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(LiveLoadActivity liveLoadActivity, IMediaPlayer iMediaPlayer) {
        View view;
        liveLoadActivity.L1(true);
        Drawable drawableW = com.live.evo.util.o0.p().w();
        if (drawableW == null || (view = liveLoadActivity.mRoot) == null) {
            return;
        }
        view.setBackground(drawableW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(final String message) {
        com.live.evo.util.m.a(-1, message);
        runOnUiThread(new Runnable() { // from class: com.live.evo.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.u1(message, this);
            }
        });
        runOnUiThread(new Runnable() { // from class: com.live.evo.activity.m
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.v1(this.f5470a);
            }
        });
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    @Override // com.live.evo.activity.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);

    static {
        StubApp.interface11(11769);
        INSTANCE = new Companion(null);
        N = "LiveLoadActivity";
        O = "load_startLive";
        P = "start_live";
        Q = "upgrade_check_state";
        R = "tip_not_support_version";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1() {
        this.mHandler.sendEmptyMessage(620908586);
    }

    private final void B1() {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutInt;
        com.live.evo.util.m.b("liveLoadStartLive");
        com.live.evo.util.s0.f7342a.Q();
        SharedPreferences sharedPreferences = getSharedPreferences(O, 0);
        if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorPutInt = editorEdit.putInt(P, 2)) != null) {
            editorPutInt.apply();
        }
        F1();
    }

    private final void D1() {
        com.live.evo.util.m.b("liveLoadLoadChannel");
        B1();
        if (v4.g.e() != null && v4.g.e().c()) {
            v4.g.e().k();
        }
        com.live.evo.fragment.subjuect.b.c().e();
        v4.b.o().u();
        x1.f1.lb.ad.b.f20540a.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1() {
        runOnUiThread(new Runnable() { // from class: com.live.evo.activity.w
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.G1(this.f5520a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(final LiveLoadActivity liveLoadActivity) {
        if (t.v.c.i.a.o(t.v.c.i.a.f18646a, null, null, 3, null).isEmpty()) {
            liveLoadActivity.mHandler.sendEmptyMessageDelayed(620908602, 1000L);
            return;
        }
        liveLoadActivity.mHasStartLive = true;
        liveLoadActivity.startActivity(new Intent(liveLoadActivity, (Class<?>) LiveNewActivity.class));
        liveLoadActivity.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.o
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.H1(this.f5488a);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1() {
        int i10;
        String str;
        int i11;
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        aVar.U();
        long jI = aVar.I();
        long jA = com.live.evo.util.u1.b().a();
        com.live.evo.util.b2.c(this);
        com.live.evo.util.q1.h();
        if (aVar.g()) {
            i10 = aVar.Z().length() == 0 ? 10 : 1;
        } else {
            i10 = -1;
        }
        if (i10 == -1 && aVar.h()) {
            int iJ = com.live.evo.util.q1.j(jA, jI);
            if (iJ <= 1) {
                str = iJ + " " + com.live.evo.util.x1.j(R$string.hour);
            } else {
                str = iJ + " " + com.live.evo.util.x1.j(R$string.hours);
            }
            i11 = 1;
        } else {
            str = "";
            i11 = i10;
        }
        String str2 = str;
        com.live.evo.util.m.c("remindType", i11);
        if (i11 == -1) {
            this.mHandler.sendEmptyMessage(620908586);
        } else if (i11 != 5) {
            e5.e.a(K0(), getWindow(), R$id.root, i11, str2, 30, new j());
        } else {
            S1(null, false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentManager K0() {
        com.tvc.lib.mobile.ui.widget.b bVar = this.loadingView;
        if (bVar != null) {
            bVar.a();
        }
        FragmentManager fragmentManager = this.mFm;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
        return supportFragmentManager;
    }

    private final void L0() {
        if (this.noticeAlertDialog == null) {
            this.noticeAlertDialog = new com.live.evo.dialog.q(this);
        }
    }

    private final void L1(final boolean hideVideoView) {
        this.mHandler.post(new Runnable() { // from class: com.live.evo.activity.t
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.M1(this.f5509a, hideVideoView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(boolean silenced) {
        if (this.isInChecking.compareAndSet(false, true)) {
            p1(R$string.checking);
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(silenced, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(LiveLoadActivity liveLoadActivity, boolean z10) {
        x1.f1.lb.widget.videoview.z0 videoViewHandler;
        VideoView videoView;
        x1.f1.lb.widget.videoview.z0 videoViewHandler2;
        VideoView videoView2 = liveLoadActivity.mVideoView;
        if (videoView2 != null && (videoViewHandler = videoView2.getVideoViewHandler()) != null && videoViewHandler.K1() && (videoView = liveLoadActivity.mVideoView) != null && (videoViewHandler2 = videoView.getVideoViewHandler()) != null) {
            videoViewHandler2.N2(true);
        }
        if (z10) {
            TextView textView = liveLoadActivity.mVersion;
            if (textView != null) {
                textView.setVisibility(8);
            }
            VideoView videoView3 = liveLoadActivity.mVideoView;
            if (videoView3 != null) {
                videoView3.setVisibility(8);
            }
        }
        ImageView imageView = liveLoadActivity.mImageVideoCurtain;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    static /* synthetic */ void N0(LiveLoadActivity liveLoadActivity, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        liveLoadActivity.M0(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.u
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.P0(this.f5513a);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(String errorMessage, boolean showBack, int showTab, Fragment originView) {
        com.live.evo.util.m.b("liveLoadShowLogin");
        L1(true);
        T0();
        e5.b.a(K0(), getWindow(), R$id.root, showBack, errorMessage, showTab, new m(originView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionHide;
        FragmentManager fragmentManager = this.mFm;
        if (fragmentManager != null && (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(fragment)) != null) {
            fragmentTransactionHide.commitAllowingStateLoss();
        }
        e5.d.a(K0(), getWindow(), R$id.root, new n());
    }

    private final void T0() {
        x1.f1.lb.widget.videoview.z0 videoViewHandler;
        VideoView videoView;
        x1.f1.lb.widget.videoview.z0 videoViewHandler2;
        VideoView videoView2 = this.mVideoView;
        if (videoView2 == null || (videoViewHandler = videoView2.getVideoViewHandler()) == null || !videoViewHandler.K1() || (videoView = this.mVideoView) == null || (videoViewHandler2 = videoView.getVideoViewHandler()) == null) {
            return;
        }
        x1.f1.lb.widget.videoview.z0.P2(videoViewHandler2, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(int type, String code) {
        com.live.evo.util.m.b("liveLoadToRechargeFragment");
        L1(true);
        T0();
        if (type == 42) {
            List<i5.a0> listD = com.live.evo.util.b1.d("user_properties", "code_bind_remind_status");
            kotlin.jvm.internal.m.e(listD, "getProperties(...)");
            if (!listD.isEmpty() && kotlin.jvm.internal.m.a(listD.get(0).b(), "1")) {
                this.mHandler.sendEmptyMessage(620908561);
                String strJ = com.live.evo.util.x1.j(2131952318);
                kotlin.jvm.internal.m.e(strJ, "getString(...)");
                q1(strJ);
                o1(null);
                return;
            }
        }
        com.live.evo.fragment.login.r.b0(K0(), R$id.root, code, type, new p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(Fragment fragment, i5.a accountBean) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionHide;
        if (fragment != null && (fragmentManager = this.mFm) != null && (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(fragment)) != null) {
            fragmentTransactionHide.commitAllowingStateLoss();
        }
        e5.i.a(K0(), getWindow(), R$id.root, accountBean, false, new q(fragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object V0(v8.f<? super r8.z> fVar) {
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        bVar.L(v6.d.UDP);
        bVar.z(!kotlin.jvm.internal.m.a(of.a.f16585a.f(), "code"));
        bVar.C(true);
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(LiveLoadActivity liveLoadActivity, Fragment fragment) {
        com.tvc.lib.mobile.ui.widget.b bVar = liveLoadActivity.loadingView;
        if (bVar != null) {
            bVar.a();
        }
        com.live.evo.util.b2.e(liveLoadActivity, Boolean.FALSE);
        liveLoadActivity.mHandler.sendEmptyMessage(620908584);
    }

    private final void Y0() {
        x1.f1.lb.widget.videoview.z0 videoViewHandler;
        VideoView videoView = this.mVideoView;
        if (videoView == null || (videoViewHandler = videoView.getVideoViewHandler()) == null) {
            return;
        }
        videoViewHandler.w2(new IMediaPlayer.OnInfoListener() { // from class: com.live.evo.activity.x
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
                return LiveLoadActivity.Z0(this.f5522a, iMediaPlayer, i10, i11, str);
            }
        });
        videoViewHandler.v2(new IMediaPlayer.OnErrorListener() { // from class: com.live.evo.activity.y
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                return LiveLoadActivity.b1(this.f5524a, iMediaPlayer, i10, i11);
            }
        });
        videoViewHandler.u2(new IMediaPlayer.OnCompletionListener() { // from class: com.live.evo.activity.z
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                LiveLoadActivity.c1(this.f5526a, iMediaPlayer);
            }
        });
        videoViewHandler.F2("", this.mBootVideoUri, null, v6.c.VOD, com.live.evo.util.q1.b());
        VideoView videoView2 = this.mVideoView;
        if (videoView2 != null) {
            videoView2.requestFocus();
        }
        videoViewHandler.H2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z0(final LiveLoadActivity liveLoadActivity, IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
        ImageView imageView = liveLoadActivity.mImageVideoCurtain;
        if (imageView != null && imageView.getVisibility() == 8) {
            return true;
        }
        liveLoadActivity.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.n
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.a1(this.f5475a);
            }
        }, 200L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(LiveLoadActivity liveLoadActivity) {
        ImageView imageView = liveLoadActivity.mImageVideoCurtain;
        if (imageView == null || imageView.getVisibility() != 8) {
            ImageView imageView2 = liveLoadActivity.mImageVideoCurtain;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            TextView textView = liveLoadActivity.mVersion;
            if (textView != null) {
                textView.setVisibility(0);
            }
            String strT = x1.f1.lb.util.k.f21398a.t();
            TextView textView2 = liveLoadActivity.mVersion;
            if (textView2 != null) {
                kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
                String str = String.format("%s %s", Arrays.copyOf(new Object[]{liveLoadActivity.getText(R$string.version), strT}, 2));
                kotlin.jvm.internal.m.e(str, "format(...)");
                textView2.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        final UpgradeInfo upgradeInfo;
        final String str = this.apkFile;
        if (str == null || (upgradeInfo = this.upgradeInfo) == null) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.live.evo.activity.q
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.f1(this.f5498a, str, upgradeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(LiveLoadActivity liveLoadActivity, String str, UpgradeInfo upgradeInfo) {
        q5.c.f17661a.g(liveLoadActivity, str, upgradeInfo, liveLoadActivity.new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1() {
        t.v.c.i.a.f18646a.u0(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(String username) {
        P1("", false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        if (com.live.evo.util.x0.a(this, com.live.evo.util.x0.f7377a)) {
            com.live.evo.util.m.c("hasPermission", 1L);
            this.mHandler.sendEmptyMessage(620908582);
        } else {
            com.live.evo.util.m.c("hasPermission", 0L);
            com.live.evo.util.x0.b(this, com.live.evo.util.x0.f7377a, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(Fragment prvFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentManager fragmentManager = this.mFm;
        if (fragmentManager == null || (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) == null) {
            return;
        }
        if (prvFragment != null) {
            fragmentTransactionBeginTransaction.hide(prvFragment);
        }
        com.tvc.lib.mobile.ui.widget.b bVar = this.loadingView;
        if (bVar != null) {
            bVar.a();
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(final int resId) {
        runOnUiThread(new Runnable() { // from class: com.live.evo.activity.p
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.t1(this.f5492a, resId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(String str, LiveLoadActivity liveLoadActivity) {
        if (str != null) {
            liveLoadActivity.q1(str);
        }
        liveLoadActivity.L1(true);
    }

    private final void x1() {
        com.live.evo.util.m.b("liveLoadStartCoreProcess");
        this.mHandler.sendEmptyMessage(620908583);
    }

    public final void C1() {
        com.live.evo.util.m.b("liveLoadStartLoad");
        int intExtra = getIntent().getIntExtra("startType", 0);
        String stringExtra = getIntent().getStringExtra("message");
        com.live.evo.util.a0.o();
        if (intExtra != 1) {
            this.mHandler.sendEmptyMessage(620908577);
            return;
        }
        getIntent().removeExtra("startType");
        getIntent().removeExtra("message");
        P1(stringExtra, false, 0);
    }

    /* JADX INFO: renamed from: S0, reason: from getter */
    public final Handler getMHandler() {
        return this.mHandler;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        com.live.evo.dialog.m mVar;
        FragmentManager fragmentManager = this.mFm;
        if (fragmentManager == null || e5.a.b(fragmentManager) || (mVar = this.mExitDialog) == null) {
            return;
        }
        if (mVar.g()) {
            mVar.c();
        } else {
            mVar.h(new com.live.evo.dialog.n() { // from class: com.live.evo.activity.v
                @Override // com.live.evo.dialog.n
                public final void a() {
                    LiveLoadActivity.g1(this.f5516a);
                }
            });
            mVar.i();
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onChannelUpdateEvent(nf.d event) {
        if (event == null || event.d()) {
            return;
        }
        com.live.evo.dialog.b.i(this, getString(R$string.load_fail) + ":\n" + event.c() + "(" + event.getCode() + ")", getString(2131952869), getString(2131952019), new Runnable() { // from class: com.live.evo.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.h1();
            }
        }, new Runnable() { // from class: com.live.evo.activity.r
            @Override // java.lang.Runnable
            public final void run() {
                LiveLoadActivity.i1(this.f5504a);
            }
        });
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        m1();
        v4.b.o().j();
        super.onDestroy();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v10, int keyCode, KeyEvent event) {
        kotlin.jvm.internal.m.f(v10, "v");
        kotlin.jvm.internal.m.f(event, "event");
        if (com.live.evo.util.x1.m(300L)) {
            return true;
        }
        if ((v10.getId() != 2131428561 && v10.getId() != 2131428555) || event.getAction() != 0 || keyCode != 22 || !v4.b.o().s() || this.adNewViewManager == null || !v4.b.o().y()) {
            return false;
        }
        v4.d dVar = this.adNewViewManager;
        if (dVar != null) {
            dVar.y();
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        this.mFm = getSupportFragmentManager();
        this.isOnSavedState = false;
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.m.f(outState, "outState");
        super.onSaveInstanceState(outState);
        this.isOnSavedState = true;
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.live.evo.dialog.q qVar = this.noticeAlertDialog;
        if (qVar != null && qVar.f()) {
            qVar.c();
        }
        SharedPreferences sharedPreferences = getSharedPreferences(O, 0);
        if (sharedPreferences != null) {
            String str = P;
            if (sharedPreferences.getInt(str, 0) != 2) {
                sharedPreferences.edit().putInt(str, 1).apply();
            }
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1() {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new i(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(LiveLoadActivity liveLoadActivity) {
        liveLoadActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        if (com.live.evo.l.n().E()) {
            this.mHandler.sendEmptyMessage(620908589);
            return;
        }
        if (com.live.evo.l.n().q() == 1 && com.live.evo.util.b2.d(this).booleanValue()) {
            com.live.evo.util.m.c("showWelcomeDlg", 1L);
            this.mHandler.sendEmptyMessage(620908588);
        } else {
            com.live.evo.util.m.c("showWelcomeDlg", 0L);
            this.mHandler.sendEmptyMessage(620908584);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1() {
        com.live.evo.fragment.login.d.U(K0(), R$id.root, new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(int remindType) {
        com.live.evo.fragment.login.h.X(K0(), R$id.root, remindType, new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(LiveLoadActivity liveLoadActivity) {
        liveLoadActivity.finish();
        System.exit(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Q0() {
        Uri data;
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("channelId");
        this.logger.a("getIntentChannelId channelid=" + stringExtra, new Object[0]);
        String action = intent.getAction();
        this.logger.a("getIntentChannelId action=" + action, new Object[0]);
        if (intent.getScheme() != null && kotlin.jvm.internal.m.a("livetvcontent", intent.getScheme()) && (data = intent.getData()) != null) {
            return data.getQueryParameter("channelId");
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0() {
        x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(Fragment fragment, boolean toRecharge, int registerType) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionHide;
        T0();
        if (fragment != null && (fragmentManager = this.mFm) != null && (fragmentTransactionBeginTransaction = fragmentManager.beginTransaction()) != null && (fragmentTransactionHide = fragmentTransactionBeginTransaction.hide(fragment)) != null) {
            fragmentTransactionHide.commitAllowingStateLoss();
        }
        e5.g.a(K0(), getWindow(), R$id.root, registerType, false, false, null, new o(toRecharge, fragment));
    }

    private final void U0() {
        v4.g.g(StubApp.getOrigApplicationContext(MyApplication.a().getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0() {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(String showData) {
        com.tvc.lib.mobile.ui.widget.b bVar;
        if (showData.length() > 0 && (bVar = this.loadingView) != null) {
            bVar.c(showData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(LiveLoadActivity liveLoadActivity) {
        liveLoadActivity.O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(LiveLoadActivity liveLoadActivity) {
        liveLoadActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(String msg) {
        s1(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        com.live.evo.util.a0.o();
        U0();
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        if (aVar.o0()) {
            if (aVar.M() == 2) {
                x1.f1.lb.util.w0.f21452a.n(R, new h(x1.f1.lb.util.k.f21398a.t()), "");
                return;
            } else {
                P1("", false, 0);
                return;
            }
        }
        K1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1(int resId) {
        String string = getString(resId);
        kotlin.jvm.internal.m.e(string, "getString(...)");
        q1(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(String showData) {
        if (showData.length() == 0) {
            showData = getString(2131952317);
            kotlin.jvm.internal.m.e(showData, "getString(...)");
        }
        com.tvc.lib.mobile.ui.widget.b bVar = this.loadingView;
        if (bVar != null) {
            bVar.c(showData);
        }
        com.tvc.lib.mobile.ui.widget.b bVar2 = this.loadingView;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(LiveLoadActivity liveLoadActivity, int i10) {
        liveLoadActivity.s1(MyApplication.a().getString(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(LiveLoadActivity liveLoadActivity) {
        liveLoadActivity.e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1() {
        Pair<Boolean, Boolean> pairG = com.live.evo.util.l.d().g();
        kotlin.jvm.internal.m.e(pairG, "needChangeSystem(...)");
        if (((Boolean) pairG.second).booleanValue()) {
            com.live.evo.util.l.d().h(this, new Runnable() { // from class: com.live.evo.activity.k
                @Override // java.lang.Runnable
                public final void run() {
                    LiveLoadActivity.z1(this.f5460a);
                }
            });
            return;
        }
        if (((Boolean) pairG.first).booleanValue()) {
            com.live.evo.util.l.d().i(this);
        }
        D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(LiveLoadActivity liveLoadActivity) {
        liveLoadActivity.D1();
    }

    public final void W0() {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new c(null), 3, null);
    }

    public final void d1() {
        boolean z10;
        String className;
        Integer numValueOf = Integer.valueOf(getIntent().getIntExtra("startType", 0));
        this.startType = numValueOf;
        if (numValueOf.intValue() != 1 && com.live.evo.util.o0.p().z()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mBootWithVideo = z10;
        if (z10) {
            this.mBootVideoUri = com.live.evo.util.o0.p().x();
            this.mCurtainDrawable = com.live.evo.util.o0.p().v();
        }
        setContentView(R$layout.activity_load);
        this.mMainRoot = (ViewGroup) findViewById(R$id.loada_rl_parent);
        this.mRoot = findViewById(R$id.root);
        this.mNoticeView = (SpeedTextView) findViewById(R$id.loada_tv_notice);
        this.mVideoView = (VideoView) findViewById(R$id.loada_video_view);
        this.mVersion = (TextView) findViewById(R$id.loada_tv_version);
        this.mImageVideoCurtain = (ImageView) findViewById(R$id.loada_iv_video_curtain);
        this.mAdSkipLayout = (LinearLayout) findViewById(R$id.loada_ad_canskip);
        this.mAdIv = (ImageButton) findViewById(R$id.loada_iv_ad);
        this.mAdSkipTip = (TextView) findViewById(R$id.loada_ad_canskip_tv2);
        VideoView videoView = this.mVideoView;
        if (videoView != null) {
            videoView.setOnKeyListener(this);
        }
        ImageButton imageButton = this.mAdIv;
        if (imageButton != null) {
            imageButton.setOnKeyListener(this);
        }
        if (getIntent() != null && getIntent().getComponent() != null) {
            ComponentName component = getIntent().getComponent();
            String className2 = null;
            if (component != null) {
                className = component.getClassName();
            } else {
                className = null;
            }
            if (kotlin.jvm.internal.m.a(className, this.icon_free_trail)) {
                com.live.evo.util.x1.a(true);
            } else {
                ComponentName component2 = getIntent().getComponent();
                if (component2 != null) {
                    className2 = component2.getClassName();
                }
                if (kotlin.jvm.internal.m.a(className2, this.icon_normal)) {
                    com.live.evo.util.x1.a(false);
                }
            }
        }
        TextView textView = (TextView) findViewById(R$id.versionTextView);
        String strT = x1.f1.lb.util.k.f21398a.t();
        kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
        String str = String.format("%s %s", Arrays.copyOf(new Object[]{getText(R$string.version), strT}, 2));
        kotlin.jvm.internal.m.e(str, "format(...)");
        textView.setText(str);
        com.tvc.lib.mobile.ui.widget.b bVarI = z7.j.i(z7.j.f23105a, R$id.loading_layout, R$color.color_focused, getWindow().getDecorView().getRootView(), 0, 8, null);
        bVarI.b();
        this.loadingView = bVarI;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onNotice(i5.x noticeItem) {
        L0();
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        x1.f1.lb.util.e0.f21385a.b(this);
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        x1.f1.lb.util.e0.f21385a.a(this);
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    public final void w1() {
        Integer num;
        if (v4.b.o().s() && (((num = this.startType) == null || num.intValue() != 1) && !t.v.c.i.a.f18646a.o0())) {
            this.adNewViewManager = v4.d.s(this);
            com.live.evo.util.m.b("liveLoadShowAd");
            v4.d dVar = this.adNewViewManager;
            if (dVar != null) {
                dVar.z();
                return;
            }
            return;
        }
        if (this.mBootWithVideo && !t.v.c.i.a.f18646a.o0()) {
            VideoView videoView = this.mVideoView;
            if (videoView != null) {
                videoView.setVisibility(0);
            }
            ImageView imageView = this.mImageVideoCurtain;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mImageVideoCurtain;
            if (imageView2 != null) {
                imageView2.setBackground(this.mCurtainDrawable);
            }
            Y0();
            return;
        }
        VideoView videoView2 = this.mVideoView;
        if (videoView2 != null) {
            videoView2.setVisibility(8);
        }
        ImageView imageView3 = this.mImageVideoCurtain;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1() {
    }

    private final void m1() {
    }
}
