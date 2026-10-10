package com.live.evo.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import androidx.p000lifecycle.Lifecycle;
import com.live.evo.R$dimen;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.widget.AdBannerView;
import com.live.evo.widget.BaseButton;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnPageChangeListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u0002:\u0002\u0088\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u001eJ\u0019\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u001eJ)\u0010+\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\tH\u0016¢\u0006\u0004\b/\u0010\u0004R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00106R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010>R\u0018\u0010E\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00106R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR$\u0010O\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010TR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010a\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u00106R\u0018\u0010b\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u00106R\u0018\u0010d\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u00106R\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020K0i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010z\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010TR%\u0010\u0082\u0001\u001a\u00020{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0086\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u0089\u0001"}, d2 = {"Lcom/live/evo/fragment/r0;", "Lcom/live/evo/fragment/f0;", "Landroid/view/View$OnKeyListener;", "<init>", "()V", "", "isShow", "", "delay", "Lr8/z;", "s0", "(ZI)V", "A0", "q0", "()Z", "r0", "u0", "p0", "w0", "v0", "t0", "R", "()I", "Landroid/view/View;", "view", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/view/View;)V", ExifInterface.GPS_DIRECTION_TRUE, "isVisible", "X", "(Z)V", "hidden", "onHiddenChanged", "Landroid/os/Bundle;", "savedInstanceState", ExifInterface.LATITUDE_SOUTH, "(Landroid/os/Bundle;)V", "hasFocus", ExifInterface.LONGITUDE_WEST, "v", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "onStop", "onDestroy", "onStart", "Lq6/b;", "f", "Lq6/b;", "logger", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "mTvVersion2", "h", "mTvNewVersion", "i", "mTvMac", "Lcom/live/evo/widget/BaseButton;", "j", "Lcom/live/evo/widget/BaseButton;", "mBtnUpdate", "k", "mProxyType", "l", "mBtnFeedback", "m", "mTvUpgradeTip", "Landroid/widget/LinearLayout;", "n", "Landroid/widget/LinearLayout;", "mLayoutBanner", "Lcom/youth/banner/Banner;", "", "Lcom/live/evo/catchup/player/b;", "o", "Lcom/youth/banner/Banner;", "mBanner", "p", "Z", "mShowBanner", "q", "I", "browseCount", "r", "clickCount", "", "s", "J", "browseDuration", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "customerServiceQrCodeImg", "u", "customerServiceQrCodeTip", "mInfo1", "w", "mInfo2", "Lcom/live/evo/widget/AdBannerView;", "x", "Lcom/live/evo/widget/AdBannerView;", "ad_banner", "", "y", "Ljava/util/List;", "newAdImages", "Landroid/os/Handler;", "z", "Landroid/os/Handler;", "mHandle", "Landroid/view/View$OnFocusChangeListener;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View$OnFocusChangeListener;", "mBtnFocusListener", "Landroid/view/View$OnClickListener;", "B", "Landroid/view/View$OnClickListener;", "mBtnClickListener", "C", "curBannerItem", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "getMRunnable", "()Ljava/lang/Runnable;", "setMRunnable", "(Ljava/lang/Runnable;)V", "mRunnable", "Ljava/util/concurrent/atomic/AtomicBoolean;", ExifInterface.LONGITUDE_EAST, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInChecking", "F", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r0 extends f0 implements View.OnKeyListener {

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static UpgradeInfo G;
    private static String H;
    private static boolean I;
    private static SoftReference<r0> J;
    private static com.live.evo.osd.persenter.a K;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final View.OnFocusChangeListener mBtnFocusListener;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private final View.OnClickListener mBtnClickListener;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private int curBannerItem;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private Runnable mRunnable;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private final AtomicBoolean isInChecking;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mTvVersion2;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mTvNewVersion;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTvMac;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private BaseButton mBtnUpdate;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private BaseButton mProxyType;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private BaseButton mBtnFeedback;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTvUpgradeTip;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mLayoutBanner;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Banner<String, com.live.evo.catchup.player.b> mBanner;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean mShowBanner;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int browseCount;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int clickCount;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private long browseDuration;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private ImageView customerServiceQrCodeImg;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private TextView customerServiceQrCodeTip;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private TextView mInfo1;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private TextView mInfo2;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private AdBannerView ad_banner;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final List<String> newAdImages;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandle;

    /* JADX INFO: renamed from: com.live.evo.fragment.r0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/live/evo/fragment/r0$a;", "", "<init>", "()V", "", "tag", "Lcom/live/evo/osd/persenter/a;", "presenter", "Lcom/live/evo/fragment/r0;", "c", "(Ljava/lang/String;Lcom/live/evo/osd/persenter/a;)Lcom/live/evo/fragment/r0;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "upgradeInfo", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "b", "()Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "g", "(Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;)V", "apkFile", "Ljava/lang/String;", "getApkFile", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "Ljava/lang/ref/SoftReference;", "srfInstance", "Ljava/lang/ref/SoftReference;", "a", "()Ljava/lang/ref/SoftReference;", "f", "(Ljava/lang/ref/SoftReference;)V", "mPresenter", "Lcom/live/evo/osd/persenter/a;", "getMPresenter", "()Lcom/live/evo/osd/persenter/a;", "e", "(Lcom/live/evo/osd/persenter/a;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final SoftReference<r0> a() {
            return r0.J;
        }

        public final UpgradeInfo b() {
            return r0.G;
        }

        public final r0 c(String tag, com.live.evo.osd.persenter.a presenter) {
            r0 r0Var;
            SoftReference<r0> softReferenceA = a();
            r0 r0Var2 = null;
            if (softReferenceA != null) {
                r0Var = softReferenceA.get();
            } else {
                r0Var = null;
            }
            if (r0Var != null) {
                return r0Var;
            }
            e(presenter);
            synchronized (Companion.class) {
                Companion companion = r0.INSTANCE;
                SoftReference<r0> softReferenceA2 = companion.a();
                if (softReferenceA2 != null) {
                    r0Var2 = softReferenceA2.get();
                }
                if (r0Var2 != null) {
                    return r0Var2;
                }
                r0 r0Var3 = new r0();
                Bundle bundle = new Bundle();
                bundle.putString("tag", tag);
                r0Var3.setArguments(bundle);
                companion.f(new SoftReference<>(r0Var3));
                return r0Var3;
            }
        }

        public final void d(String str) {
            r0.H = str;
        }

        public final void e(com.live.evo.osd.persenter.a aVar) {
            r0.K = aVar;
        }

        public final void f(SoftReference<r0> softReference) {
            r0.J = softReference;
        }

        public final void g(UpgradeInfo upgradeInfo) {
            r0.G = upgradeInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.InfoFragment$checkUpdate$1", f = "InfoFragment.kt", l = {663}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"com/live/evo/fragment/r0$b$a", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "", "a", "Ljava/lang/String;", "lastVersion", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final String lastVersion = "";

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ r0 f6582b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f6583c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ nf.a0 f6584d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f6585e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Integer f6586f;

            a(r0 r0Var, String str, nf.a0 a0Var, String str2, Integer num) {
                this.f6582b = r0Var;
                this.f6583c = str;
                this.f6584d = a0Var;
                this.f6585e = str2;
                this.f6586f = num;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.f6582b.isAdded()) {
                    if (TextUtils.isEmpty(this.f6583c)) {
                        if (this.f6584d != null) {
                            xe.c.c().o(this.f6584d);
                            return;
                        }
                        return;
                    } else {
                        Companion companion = r0.INSTANCE;
                        companion.d(this.f6583c);
                        UpgradeInfo upgradeInfoB = companion.b();
                        if (upgradeInfoB != null) {
                            xe.c.c().o(new nf.z(upgradeInfoB, this.f6583c));
                            return;
                        }
                        return;
                    }
                }
                if (!kotlin.jvm.internal.m.a(this.lastVersion, this.f6585e) && !TextUtils.isEmpty(this.f6585e)) {
                    TextView textView = this.f6582b.mTvNewVersion;
                    kotlin.jvm.internal.m.c(textView);
                    kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
                    String str = String.format("%s:%s", Arrays.copyOf(new Object[]{this.f6582b.getString(R$string.new_version), this.f6585e}, 2));
                    kotlin.jvm.internal.m.e(str, "format(...)");
                    textView.setText(str);
                }
                Integer num = this.f6586f;
                if (num != null) {
                    String string = this.f6582b.getString(R$string.downloading, num.toString());
                    kotlin.jvm.internal.m.e(string, "getString(...)");
                    BaseButton baseButton = this.f6582b.mBtnUpdate;
                    kotlin.jvm.internal.m.c(baseButton);
                    baseButton.setText(string);
                    BaseButton baseButton2 = this.f6582b.mBtnUpdate;
                    kotlin.jvm.internal.m.c(baseButton2);
                    baseButton2.setEnabled(false);
                }
                if (!TextUtils.isEmpty(this.f6583c)) {
                    Companion companion2 = r0.INSTANCE;
                    companion2.d(this.f6583c);
                    UpgradeInfo upgradeInfoB2 = companion2.b();
                    if (upgradeInfoB2 != null) {
                        xe.c.c().o(new nf.z(upgradeInfoB2, this.f6583c, true));
                    }
                    BaseButton baseButton3 = this.f6582b.mBtnUpdate;
                    if (baseButton3 != null) {
                        baseButton3.setText(R$string.install);
                    }
                    BaseButton baseButton4 = this.f6582b.mBtnUpdate;
                    kotlin.jvm.internal.m.c(baseButton4);
                    baseButton4.setEnabled(true);
                }
                if (this.f6584d != null) {
                    TextView textView2 = this.f6582b.mTvNewVersion;
                    kotlin.jvm.internal.m.c(textView2);
                    textView2.setText(this.f6584d.a());
                    BaseButton baseButton5 = this.f6582b.mBtnUpdate;
                    if (baseButton5 != null) {
                        baseButton5.setText(2131951877);
                    }
                    BaseButton baseButton6 = this.f6582b.mBtnUpdate;
                    kotlin.jvm.internal.m.c(baseButton6);
                    baseButton6.setEnabled(true);
                }
                this.f6582b.isInChecking.set(false);
            }
        }

        /* JADX INFO: renamed from: com.live.evo.fragment.r0$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.InfoFragment$checkUpdate$1$2", f = "InfoFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0097b extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super UpgradeInfo>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ r0 this$0;

            /* JADX INFO: renamed from: com.live.evo.fragment.r0$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.InfoFragment$checkUpdate$1$2$1", f = "InfoFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ r0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r0 r0Var, Throwable th, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = r0Var;
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

            /* JADX INFO: renamed from: com.live.evo.fragment.r0$b$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.InfoFragment$checkUpdate$1$2$2", f = "InfoFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0098b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ r0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0098b(r0 r0Var, v8.f<? super C0098b> fVar) {
                    super(2, fVar);
                    this.this$0 = r0Var;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0098b(this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0098b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        BaseButton baseButton = this.this$0.mBtnUpdate;
                        if (baseButton != null) {
                            baseButton.setText(2131951877);
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0097b(r0 r0Var, v8.f<? super C0097b> fVar) {
                super(3, fVar);
                this.this$0 = r0Var;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super UpgradeInfo> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                C0097b c0097b = new C0097b(this.this$0, fVar);
                c0097b.L$0 = th;
                return c0097b.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.this$0, th, null), 3, null);
                    this.this$0.logger.error("check upgrade failure", th);
                    this.this$0.isInChecking.set(false);
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new C0098b(this.this$0, null), 3, null);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class c<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ r0 f6587a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.InfoFragment$checkUpdate$1$3$1", f = "InfoFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ r0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(r0 r0Var, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = r0Var;
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
                        BaseButton baseButton = this.this$0.mBtnUpdate;
                        if (baseButton != null) {
                            baseButton.setText(2131951877);
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            c(r0 r0Var) {
                this.f6587a = r0Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(UpgradeInfo upgradeInfo, v8.f<? super r8.z> fVar) {
                r0.INSTANCE.g(upgradeInfo);
                if (!this.f6587a.isAdded()) {
                    return r8.z.f17874a;
                }
                this.f6587a.isInChecking.set(false);
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.f6587a, null), 3, null);
                if ((upgradeInfo != null ? upgradeInfo.getUpgradeStatus() : 0) == 0) {
                    com.live.evo.util.r1.a(this.f6587a.getContext(), R$string.up_to_date);
                } else {
                    com.live.evo.util.r1.a(this.f6587a.getContext(), R$string.update_msg);
                }
                return r8.z.f17874a;
            }
        }

        b(v8.f<? super b> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return r0.this.new b(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z c(r0 r0Var, String str, Integer num, String str2, nf.a0 a0Var) {
            r0Var.mHandle.post(new a(r0Var, str2, a0Var, str, num));
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
                Lifecycle lifecycle = r0.this.getLifecycle();
                final r0 r0Var = r0.this;
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(aVar.c(lifecycle, new c9.r() { // from class: com.live.evo.fragment.s0
                    @Override // c9.r
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return r0.b.c(r0Var, (String) obj2, (Integer) obj3, (String) obj4, (nf.a0) obj5);
                    }
                }), new C0097b(r0.this, null));
                c cVar = new c(r0.this);
                this.label = 1;
                if (fVarF.collect(cVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"com/live/evo/fragment/r0$d", "Lcom/youth/banner/listener/OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "Lr8/z;", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements OnPageChangeListener {
        d() {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageSelected(int position) {
            r0.this.curBannerItem = position;
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/live/evo/fragment/r0$e", "Lv4/b$f;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements v4.b.f {
        e() {
        }
    }

    private final void t0() {
        this.browseCount = 1;
        this.clickCount = 0;
        this.browseDuration = com.live.evo.util.u1.b().a();
    }

    private final void u0() {
        long jB;
        this.mShowBanner = false;
        try {
            i5.f fVarF = v4.g.e().f("4");
            if (fVarF == null || fVarF.a() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int dimension = (int) getResources().getDimension(R$dimen.banner_bg_width);
            int iB = com.live.evo.util.n.b();
            int size = fVarF.a().size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!TextUtils.isEmpty(fVarF.a().get(i10).d())) {
                    String strD = fVarF.a().get(i10).d();
                    kotlin.jvm.internal.m.e(strD, "getImageUrl(...)");
                    arrayList.add(strD);
                }
            }
            if (fVarF.a().get(0) != null) {
                float f10 = fVarF.a().get(0).f();
                float f11 = dimension;
                float f12 = f10 / f11;
                float fC = fVarF.a().get(0).c();
                float f13 = iB;
                if (f12 >= fC / f13) {
                    iB = (int) ((f11 / f10) * fC);
                } else {
                    dimension = (int) ((f13 / fC) * f10);
                }
                jB = fVarF.a().get(0).b();
                if (jB < 3000) {
                    jB = 3000;
                }
            } else {
                jB = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
            }
            boolean z10 = arrayList.size() > 0;
            this.mShowBanner = z10;
            if (z10) {
                Banner<String, com.live.evo.catchup.player.b> banner = this.mBanner;
                kotlin.jvm.internal.m.c(banner);
                banner.getLayoutParams().height = iB;
                Banner<String, com.live.evo.catchup.player.b> banner2 = this.mBanner;
                kotlin.jvm.internal.m.c(banner2);
                banner2.getLayoutParams().width = dimension;
                Banner<String, com.live.evo.catchup.player.b> banner3 = this.mBanner;
                kotlin.jvm.internal.m.c(banner3);
                banner3.setLoopTime(jB);
                Banner<String, com.live.evo.catchup.player.b> banner4 = this.mBanner;
                kotlin.jvm.internal.m.c(banner4);
                banner4.setDatas(arrayList);
                Banner<String, com.live.evo.catchup.player.b> banner5 = this.mBanner;
                kotlin.jvm.internal.m.c(banner5);
                banner5.setAdapter(new com.live.evo.catchup.player.b(getContext(), arrayList));
                Banner<String, com.live.evo.catchup.player.b> banner6 = this.mBanner;
                kotlin.jvm.internal.m.c(banner6);
                banner6.requestLayout();
                Banner<String, com.live.evo.catchup.player.b> banner7 = this.mBanner;
                kotlin.jvm.internal.m.c(banner7);
                banner7.start();
                if (v4.g.e().c()) {
                    LinearLayout linearLayout = this.mLayoutBanner;
                    kotlin.jvm.internal.m.c(linearLayout);
                    linearLayout.setVisibility(0);
                    Banner<String, com.live.evo.catchup.player.b> banner8 = this.mBanner;
                    kotlin.jvm.internal.m.c(banner8);
                    banner8.start();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean isVisible) {
        if (isVisible) {
            if (r0()) {
                LinearLayout linearLayout = this.mLayoutBanner;
                if (linearLayout != null) {
                    kotlin.jvm.internal.m.c(linearLayout);
                    if (linearLayout.getVisibility() != 0) {
                        LinearLayout linearLayout2 = this.mLayoutBanner;
                        kotlin.jvm.internal.m.c(linearLayout2);
                        linearLayout2.setVisibility(0);
                    }
                }
                t0();
                Banner<String, com.live.evo.catchup.player.b> banner = this.mBanner;
                kotlin.jvm.internal.m.c(banner);
                banner.start();
            } else {
                LinearLayout linearLayout3 = this.mLayoutBanner;
                if (linearLayout3 != null) {
                    kotlin.jvm.internal.m.c(linearLayout3);
                    if (linearLayout3.getVisibility() == 0) {
                        LinearLayout linearLayout4 = this.mLayoutBanner;
                        kotlin.jvm.internal.m.c(linearLayout4);
                        linearLayout4.setVisibility(8);
                        Banner<String, com.live.evo.catchup.player.b> banner2 = this.mBanner;
                        kotlin.jvm.internal.m.c(banner2);
                        banner2.stop();
                    }
                }
            }
            v0();
        } else {
            TextView textView = this.mTvUpgradeTip;
            kotlin.jvm.internal.m.c(textView);
            textView.setVisibility(8);
            if (r0()) {
                this.browseDuration = com.live.evo.util.u1.b().a() - this.browseDuration;
                t0();
            }
            if (this.mShowBanner) {
                Banner<String, com.live.evo.catchup.player.b> banner3 = this.mBanner;
                kotlin.jvm.internal.m.c(banner3);
                banner3.stop();
            }
        }
        I = isVisible;
        this.logger.debug("fragment_visible[{}]", Boolean.valueOf(isVisible));
        s0(isVisible, 1000);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/live/evo/fragment/r0$c", "Lf3/a;", "", "", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends f3.a<Map<String, ? extends String>> {
        c() {
        }
    }

    private final void A0() {
        this.clickCount++;
        i5.f fVarF = v4.g.e().f("4");
        if (fVarF == null || fVarF.a() == null || this.curBannerItem >= fVarF.a().size()) {
            return;
        }
        com.live.evo.util.b.c(getActivity(), fVarF.a().get(this.curBannerItem).e());
        com.live.evo.osd.persenter.a aVar = K;
        kotlin.jvm.internal.m.c(aVar);
        aVar.hide();
    }

    private final void p0() {
        if (this.isInChecking.compareAndSet(false, true)) {
            BaseButton baseButton = this.mBtnUpdate;
            if (baseButton != null) {
                baseButton.setText(getString(R$string.checking));
            }
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(null), 3, null);
        }
    }

    private final void v0() {
        if (this.mBtnUpdate != null) {
            TextView textView = this.mTvNewVersion;
            kotlin.jvm.internal.m.c(textView);
            textView.setText("");
        }
        String str = H;
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                BaseButton baseButton = this.mBtnUpdate;
                if (baseButton != null) {
                    baseButton.setText(getString(2131951877));
                }
            } else {
                BaseButton baseButton2 = this.mBtnUpdate;
                if (baseButton2 != null) {
                    baseButton2.setText(getString(R$string.install));
                }
            }
        }
        UpgradeInfo upgradeInfo = G;
        String versionName = upgradeInfo != null ? upgradeInfo.getVersionName() : null;
        if (TextUtils.isEmpty(versionName)) {
            TextView textView2 = this.mTvNewVersion;
            if (textView2 != null) {
                textView2.setText("");
                return;
            }
            return;
        }
        TextView textView3 = this.mTvNewVersion;
        if (textView3 != null) {
            kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
            String str2 = String.format("%s:%s", Arrays.copyOf(new Object[]{getString(R$string.new_version), versionName}, 2));
            kotlin.jvm.internal.m.e(str2, "format(...)");
            textView3.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(View view, boolean z10) {
        if (z10) {
            com.live.evo.util.z0.d(view);
        } else {
            com.live.evo.util.z0.g(view);
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x019b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, java.lang.String] */
    @Override // com.live.evo.fragment.f0
    protected void S(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        String string;
        String str4 = "";
        TextView textView = this.mTvVersion2;
        kotlin.jvm.internal.m.c(textView);
        kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
        String str5 = String.format("%s:%s", Arrays.copyOf(new Object[]{com.live.evo.util.x1.j(R$string.version), x1.f1.lb.util.k.f21398a.t()}, 2));
        kotlin.jvm.internal.m.e(str5, "format(...)");
        textView.setText(str5);
        of.a aVar = of.a.f16585a;
        String strE = aVar.e();
        if (TextUtils.isEmpty(strE)) {
            str = String.format("ID: %s", Arrays.copyOf(new Object[]{aVar.k()}, 1));
            kotlin.jvm.internal.m.e(str, "format(...)");
        } else {
            Locale locale = Locale.getDefault();
            kotlin.jvm.internal.m.e(locale, "getDefault(...)");
            String upperCase = strE.toUpperCase(locale);
            kotlin.jvm.internal.m.e(upperCase, "toUpperCase(...)");
            str = String.format("MAC: %s", Arrays.copyOf(new Object[]{upperCase}, 1));
            kotlin.jvm.internal.m.e(str, "format(...)");
        }
        TextView textView2 = this.mTvMac;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText(str);
        kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        ?? Y = t.v.c.i.a.f18646a.y();
        b0Var.element = Y;
        if (TextUtils.isEmpty((CharSequence) Y)) {
            ImageView imageView = this.customerServiceQrCodeImg;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            Context context = getContext();
            if (context != null) {
                try {
                    if (ua.n.I(ua.n.Q0((String) b0Var.element).toString(), "{", false, 2, null)) {
                        Object objO = new com.google.gson.e().o((String) b0Var.element, new c().d());
                        kotlin.jvm.internal.m.e(objO, "fromJson(...)");
                        Map map = (Map) objO;
                        String str6 = (String) map.get("qr");
                        if (str6 == null) {
                            str2 = "";
                        } else {
                            string = ua.n.Q0(str6).toString();
                            if (string == null) {
                                str2 = string;
                                str2 = "";
                            }
                        }
                        str2 = string;
                        int length = str2.length();
                        T t10 = str2;
                        if (length == 0 && (str3 = (String) map.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL)) == null) {
                            t10 = str3;
                            t10 = "";
                        }
                        t10 = str3;
                        b0Var.element = t10;
                        String str7 = (String) map.get("tip");
                        if (str7 != null) {
                            str4 = str7;
                        }
                    }
                } catch (Throwable th) {
                    this.logger.error("parse qrcode json failure", th);
                }
                ImageView imageView2 = this.customerServiceQrCodeImg;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                String str8 = (String) b0Var.element;
                Locale locale2 = Locale.ROOT;
                String lowerCase = str8.toLowerCase(locale2);
                kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
                if (ua.n.v(lowerCase, ".png", false, 2, null)) {
                    com.live.evo.util.v.c(context, (String) b0Var.element, R$drawable.qr_placehodler, this.customerServiceQrCodeImg);
                } else {
                    String lowerCase2 = ((String) b0Var.element).toLowerCase(locale2);
                    kotlin.jvm.internal.m.e(lowerCase2, "toLowerCase(...)");
                    if (ua.n.v(lowerCase2, ".webp", false, 2, null)) {
                        com.live.evo.util.v.c(context, (String) b0Var.element, R$drawable.qr_placehodler, this.customerServiceQrCodeImg);
                    } else {
                        String lowerCase3 = ((String) b0Var.element).toLowerCase(locale2);
                        kotlin.jvm.internal.m.e(lowerCase3, "toLowerCase(...)");
                        if (ua.n.v(lowerCase3, ".jpg", false, 2, null)) {
                            com.live.evo.util.v.c(context, (String) b0Var.element, R$drawable.qr_placehodler, this.customerServiceQrCodeImg);
                        } else {
                            String lowerCase4 = ((String) b0Var.element).toLowerCase(locale2);
                            kotlin.jvm.internal.m.e(lowerCase4, "toLowerCase(...)");
                            if (ua.n.v(lowerCase4, ".jpeg", false, 2, null)) {
                                com.live.evo.util.v.c(context, (String) b0Var.element, R$drawable.qr_placehodler, this.customerServiceQrCodeImg);
                            } else {
                                String lowerCase5 = ((String) b0Var.element).toLowerCase(locale2);
                                kotlin.jvm.internal.m.e(lowerCase5, "toLowerCase(...)");
                                if (ua.n.v(lowerCase5, ".gif", false, 2, null)) {
                                    com.live.evo.util.v.c(context, (String) b0Var.element, R$drawable.qr_placehodler, this.customerServiceQrCodeImg);
                                } else {
                                    Bitmap bitmapT = com.live.evo.l.n().t((String) b0Var.element);
                                    if (bitmapT != null) {
                                        com.live.evo.util.v.b(context, bitmapT, R$drawable.qr_placehodler, this.customerServiceQrCodeImg);
                                    }
                                }
                            }
                        }
                    }
                }
                if (str4.length() == 0) {
                    TextView textView3 = this.customerServiceQrCodeTip;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                } else {
                    TextView textView4 = this.customerServiceQrCodeTip;
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                    TextView textView5 = this.customerServiceQrCodeTip;
                    if (textView5 != null) {
                        textView5.setText(str4);
                    }
                }
            }
        }
        String strA = com.live.evo.util.p1.a("info_tip_second", com.live.evo.util.x1.j(2131952216));
        t.v.c.i.a aVar2 = t.v.c.i.a.f18646a;
        String strN = aVar2.N();
        String strV = aVar2.v();
        StringBuilder sb2 = new StringBuilder();
        if (com.live.evo.l.n().v() && !TextUtils.isEmpty(strN)) {
            sb2.append("Site: ");
            sb2.append(strN);
        }
        if (!TextUtils.isEmpty(strV)) {
            if (sb2.length() > 0) {
                sb2.append("<br/>");
            }
            sb2.append("Email: ");
            sb2.append(strV);
        }
        if (sb2.length() > 0) {
            String string2 = sb2.toString();
            kotlin.jvm.internal.m.e(string2, "toString(...)");
            TextView textView6 = this.mInfo1;
            kotlin.jvm.internal.m.c(textView6);
            textView6.setText(Html.fromHtml(string2));
        } else {
            TextView textView7 = this.mInfo1;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        TextView textView8 = this.mInfo2;
        kotlin.jvm.internal.m.c(textView8);
        textView8.setText(Html.fromHtml(strA));
        u0();
        v0();
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        BaseButton baseButton = this.mBtnUpdate;
        kotlin.jvm.internal.m.c(baseButton);
        baseButton.setOnFocusChangeListener(this.mBtnFocusListener);
        BaseButton baseButton2 = this.mBtnFeedback;
        if (baseButton2 != null) {
            baseButton2.setOnFocusChangeListener(this.mBtnFocusListener);
        }
        BaseButton baseButton3 = this.mBtnUpdate;
        kotlin.jvm.internal.m.c(baseButton3);
        baseButton3.setOnClickListener(this.mBtnClickListener);
        BaseButton baseButton4 = this.mBtnFeedback;
        if (baseButton4 != null) {
            baseButton4.setOnClickListener(this.mBtnClickListener);
        }
        BaseButton baseButton5 = this.mBtnUpdate;
        kotlin.jvm.internal.m.c(baseButton5);
        baseButton5.setOnKeyListener(this);
        BaseButton baseButton6 = this.mBtnFeedback;
        if (baseButton6 != null) {
            baseButton6.setOnKeyListener(this);
        }
        BaseButton baseButton7 = this.mProxyType;
        if (baseButton7 != null) {
            baseButton7.setOnKeyListener(this);
        }
        Banner<String, com.live.evo.catchup.player.b> banner = this.mBanner;
        kotlin.jvm.internal.m.c(banner);
        banner.setOnClickListener(this.mBtnClickListener);
        Banner<String, com.live.evo.catchup.player.b> banner2 = this.mBanner;
        kotlin.jvm.internal.m.c(banner2);
        banner2.addOnPageChangeListener(new d());
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        BaseButton baseButton;
        kotlin.jvm.internal.m.f(view, "view");
        this.mTvVersion2 = (TextView) view.findViewById(R$id.contactf_tv_version);
        this.mTvNewVersion = (TextView) view.findViewById(R$id.contactf_tv_new_version);
        this.mTvMac = (TextView) view.findViewById(R$id.contactf_tv_info_mac);
        this.mBtnUpdate = (BaseButton) view.findViewById(R$id.contactf_btn_info_upgrade);
        this.mBtnFeedback = (BaseButton) view.findViewById(R$id.contactf_btn_feedback);
        TextView textView = (TextView) view.findViewById(R$id.contactf_tv_info_upgrade_tip);
        this.mTvUpgradeTip = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.customerServiceQrCodeImg = (ImageView) view.findViewById(R$id.customer_service_qrcode);
        this.customerServiceQrCodeTip = (TextView) view.findViewById(R$id.customer_service_qrcode_tip);
        this.mInfo1 = (TextView) view.findViewById(R$id.contactf_tv_info_1);
        this.mInfo2 = (TextView) view.findViewById(R$id.contactf_tv_info_2);
        this.mLayoutBanner = (LinearLayout) view.findViewById(R$id.contactf_ll_info_banner_layout);
        this.mBanner = (Banner) view.findViewById(R$id.contactf_bn_info_banner);
        this.ad_banner = (AdBannerView) view.findViewById(R$id.ad_banner);
        if (!com.live.evo.k.b().e() && (baseButton = this.mBtnFeedback) != null) {
            baseButton.setVisibility(8);
        }
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.c(this.mTvVersion2);
            com.live.evo.util.t.c(this.mBtnUpdate);
            com.live.evo.util.t.c(this.mBtnFeedback);
            com.live.evo.util.t.b(this.mTvMac);
            com.live.evo.util.t.b(this.mInfo1);
            com.live.evo.util.t.b(this.mInfo2);
        } else {
            com.live.evo.util.t.a(this.mTvVersion2);
            com.live.evo.util.t.d(this.mBtnUpdate);
            com.live.evo.util.t.d(this.mBtnFeedback);
            com.live.evo.util.t.b(this.mTvMac);
            com.live.evo.util.t.b(this.mInfo1);
            com.live.evo.util.t.b(this.mInfo2);
        }
        s0(true, 0);
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean hasFocus) {
        BaseButton baseButton;
        BaseButton baseButton2 = this.mBtnUpdate;
        if (baseButton2 == null || baseButton2.getVisibility() != 0 || (baseButton = this.mBtnUpdate) == null) {
            return;
        }
        baseButton.requestFocus();
    }

    /* JADX WARN: Code duplicated, block: B:71:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00de  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:81:0x0102  */
    /* JADX WARN: Code duplicated, block: B:86:0x010d  */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f2, code lost:
    
        if (r4.isFocused() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0116, code lost:
    
        if (r4.isFocused() != false) goto L88;
     */
    @Override // android.view.View.OnKeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKey(View v10, int keyCode, KeyEvent event) {
        BaseButton baseButton;
        AdBannerView adBannerView;
        BaseButton baseButton2;
        LinearLayout linearLayout;
        BaseButton baseButton3;
        kotlin.jvm.internal.m.f(event, "event");
        BaseButton baseButton4 = this.mBtnUpdate;
        if (baseButton4 == null || (baseButton = this.mBtnFeedback) == null) {
            return true;
        }
        if (keyCode == 20) {
            kotlin.jvm.internal.m.c(baseButton4);
            if (baseButton4.isFocused()) {
                if (com.live.evo.k.b().e()) {
                    BaseButton baseButton5 = this.mBtnFeedback;
                    if (baseButton5 != null) {
                        baseButton5.requestFocus();
                    }
                    BaseButton baseButton6 = this.mBtnFeedback;
                    if (baseButton6 != null) {
                        baseButton6.setFocusable(true);
                    }
                } else {
                    BaseButton baseButton7 = this.mProxyType;
                    if (baseButton7 != null && baseButton7.getVisibility() == 0) {
                        BaseButton baseButton8 = this.mProxyType;
                        if (baseButton8 != null) {
                            baseButton8.requestFocus();
                        }
                        BaseButton baseButton9 = this.mProxyType;
                        if (baseButton9 != null) {
                            baseButton9.setFocusable(true);
                        }
                    }
                }
            }
            return true;
        }
        if (keyCode == 19) {
            if (baseButton == null || !baseButton.isFocused()) {
                BaseButton baseButton10 = this.mProxyType;
                if (baseButton10 != null && baseButton10.isFocused()) {
                    if (com.live.evo.k.b().e()) {
                        BaseButton baseButton11 = this.mBtnFeedback;
                        if (baseButton11 != null) {
                            baseButton11.requestFocus();
                        }
                        BaseButton baseButton12 = this.mBtnFeedback;
                        if (baseButton12 != null) {
                            baseButton12.setFocusable(true);
                        }
                    } else {
                        BaseButton baseButton13 = this.mBtnUpdate;
                        kotlin.jvm.internal.m.c(baseButton13);
                        baseButton13.requestFocus();
                        BaseButton baseButton14 = this.mBtnUpdate;
                        kotlin.jvm.internal.m.c(baseButton14);
                        baseButton14.setFocusable(true);
                    }
                }
            } else {
                BaseButton baseButton15 = this.mBtnUpdate;
                kotlin.jvm.internal.m.c(baseButton15);
                baseButton15.requestFocus();
                BaseButton baseButton16 = this.mBtnUpdate;
                kotlin.jvm.internal.m.c(baseButton16);
                baseButton16.setFocusable(true);
            }
            return true;
        }
        if (keyCode == 21 && event.getAction() == 0) {
            a2 a2Var = this.f5935e;
            if (a2Var != null) {
                a2Var.D(this);
            }
            return true;
        }
        if (keyCode != 22 || event.getAction() != 0) {
            return false;
        }
        if (q0()) {
            if (q0()) {
                linearLayout = this.mLayoutBanner;
                kotlin.jvm.internal.m.c(linearLayout);
                if (!linearLayout.isFocused()) {
                    Banner<String, com.live.evo.catchup.player.b> banner = this.mBanner;
                    kotlin.jvm.internal.m.c(banner);
                }
            }
            if (q0()) {
                baseButton2 = this.mBtnFeedback;
                if (baseButton2 != null) {
                    BaseButton baseButton17 = this.mBtnUpdate;
                    kotlin.jvm.internal.m.c(baseButton17);
                } else {
                    BaseButton baseButton18 = this.mBtnUpdate;
                    kotlin.jvm.internal.m.c(baseButton18);
                }
                Banner<String, com.live.evo.catchup.player.b> banner2 = this.mBanner;
                kotlin.jvm.internal.m.c(banner2);
                banner2.requestFocus();
                return true;
            }
            return this.newAdImages.size() <= 0 ? false : false;
        }
        BaseButton baseButton19 = this.mBtnUpdate;
        kotlin.jvm.internal.m.c(baseButton19);
        if (!baseButton19.isFocused() && ((baseButton3 = this.mBtnFeedback) == null || !baseButton3.isFocused())) {
            if (q0()) {
                linearLayout = this.mLayoutBanner;
                kotlin.jvm.internal.m.c(linearLayout);
                if (!linearLayout.isFocused()) {
                    Banner<String, com.live.evo.catchup.player.b> banner3 = this.mBanner;
                    kotlin.jvm.internal.m.c(banner3);
                }
            }
            if (q0()) {
                baseButton2 = this.mBtnFeedback;
                if (baseButton2 != null || !baseButton2.isFocused()) {
                    BaseButton baseButton110 = this.mBtnUpdate;
                    kotlin.jvm.internal.m.c(baseButton110);
                }
                Banner<String, com.live.evo.catchup.player.b> banner4 = this.mBanner;
                kotlin.jvm.internal.m.c(banner4);
                banner4.requestFocus();
                return true;
            }
            if (this.newAdImages.size() <= 0 && (adBannerView = this.ad_banner) != null) {
                kotlin.jvm.internal.m.c(adBannerView);
                if (adBannerView.getVisibility() != 0) {
                    return false;
                }
                Z(getView());
                return true;
            }
        }
        Z(getView());
        return true;
    }

    public r0() {
        q6.b bVarD = q6.c.d(r0.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.newAdImages = new ArrayList();
        this.mHandle = new Handler(Looper.getMainLooper());
        this.mBtnFocusListener = new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.o0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                r0.y0(view, z10);
            }
        };
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.live.evo.fragment.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.x0(this.f6529a, view);
            }
        };
        this.mRunnable = new Runnable() { // from class: com.live.evo.fragment.q0
            @Override // java.lang.Runnable
            public final void run() {
                r0.z0(this.f6556a);
            }
        };
        this.isInChecking = new AtomicBoolean(false);
    }

    private final boolean q0() {
        if (r0() && v4.g.e().d()) {
            return true;
        }
        return false;
    }

    private final boolean r0() {
        if (v4.g.e().c() && this.mShowBanner) {
            return true;
        }
        return false;
    }

    private final void s0(boolean isShow, int delay) {
        Handler handler;
        if (v4.b.o().r() && !TextUtils.isEmpty(v4.b.f19596o)) {
            if (isShow) {
                if (this.ad_banner != null && (handler = this.mHandle) != null) {
                    handler.postDelayed(this.mRunnable, delay);
                    return;
                }
                return;
            }
            if (this.ad_banner != null) {
                Handler handler2 = this.mHandle;
                kotlin.jvm.internal.m.c(handler2);
                handler2.removeCallbacks(this.mRunnable);
                AdBannerView adBannerView = this.ad_banner;
                kotlin.jvm.internal.m.c(adBannerView);
                adBannerView.c();
                AdBannerView adBannerView2 = this.ad_banner;
                kotlin.jvm.internal.m.c(adBannerView2);
                adBannerView2.setVisibility(8);
            }
        }
    }

    private final void w0() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        String str = H;
        kotlin.jvm.internal.m.c(str);
        aVar.E0(context, 2131953119, 2131953118, 2131953117, R$drawable.ic_launcher_foreground, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(r0 r0Var, View view) {
        switch (view.getId()) {
            case R$id.contactf_bn_info_banner /* 2131427760 */:
                r0Var.A0();
                break;
            case R$id.contactf_btn_feedback /* 2131427761 */:
                Context context = r0Var.getContext();
                if (context != null) {
                    context.sendBroadcast(new Intent("com.bb.action.feedback"));
                }
                break;
            case R$id.contactf_btn_info_upgrade /* 2131427762 */:
                if (!TextUtils.isEmpty(H)) {
                    r0Var.w0();
                } else {
                    r0Var.p0();
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(r0 r0Var) {
        v4.b.o().z("AD_INFO_BANNER_KEY", v4.b.f19596o, r0Var.new e());
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.newfragment_contact;
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        J = null;
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        boolean z10 = !hidden;
        I = z10;
        this.logger.debug("fragment_visible[{}]", Boolean.valueOf(z10));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        t0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
