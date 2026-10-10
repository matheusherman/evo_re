package com.live.evo_mobile.ui;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.live.evo.R$color;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$mipmap;
import com.stub.StubApp;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import com.tvc.lib.mobile.ui.widget.TabBarBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002lmB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\n¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\nH\u0014¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\nH\u0014¢\u0006\u0004\b\"\u0010\u0004J\u0017\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010\u0004J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010\u0004J\r\u0010,\u001a\u00020\n¢\u0006\u0004\b,\u0010\u0004J\r\u0010-\u001a\u00020\n¢\u0006\u0004\b-\u0010\u0004J\r\u0010.\u001a\u00020\n¢\u0006\u0004\b.\u0010\u0004J\r\u0010/\u001a\u00020\n¢\u0006\u0004\b/\u0010\u0004J\u0017\u00102\u001a\u00020\n2\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00102\u001a\u00020\n2\u0006\u00101\u001a\u000204H\u0007¢\u0006\u0004\b2\u00105J\u0017\u00102\u001a\u00020\n2\u0006\u00101\u001a\u000206H\u0007¢\u0006\u0004\b2\u00107J\u000f\u00108\u001a\u00020\nH\u0014¢\u0006\u0004\b8\u0010\u0004J\u000f\u00109\u001a\u00020\u0013H\u0016¢\u0006\u0004\b9\u0010\u001bJ\u000f\u0010:\u001a\u00020\nH\u0014¢\u0006\u0004\b:\u0010\u0004J\u000f\u0010;\u001a\u00020\nH\u0014¢\u0006\u0004\b;\u0010\u0004J\u0015\u0010<\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b<\u0010\u0010R\u0018\u0010?\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010>R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR$\u0010W\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010]\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u00105R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR,\u0010j\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR,\u0010k\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010i¨\u0006n"}, d2 = {"Lcom/live/evo_mobile/ui/MainViewActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/u;", "<init>", "()V", "Landroidx/fragment/app/Fragment;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "", "tag", "Lr8/z;", "f0", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Landroid/view/View;", "view", "U", "(Landroid/view/View;)V", "X", "(Landroid/view/View;)Landroid/view/View;", "", ExifInterface.LONGITUDE_WEST, "(Landroid/view/View;)I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "x", "()I", "v", "", "w", "()Z", "b0", "onStop", "onDestroy", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "channelId", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)V", "onBackPressed", "c0", "e0", ExifInterface.LATITUDE_SOUTH, "g0", "Z", "Lnf/g;", NotificationCompat.CATEGORY_EVENT, "OnEvent", "(Lnf/g;)V", "Lnf/z;", "(Lnf/z;)V", "Lnf/a0;", "(Lnf/a0;)V", "onResume", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "onStart", "onPause", "paddingByNavBar", "k", "Landroidx/fragment/app/Fragment;", "mCurrFragment", "l", "mTvFragment", "m", "mMeFragment", "Landroidx/fragment/app/DialogFragment;", "n", "Landroidx/fragment/app/DialogFragment;", "upgradeDialog", "o", "I", "mLlMainHeight", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "p", "Landroidx/activity/result/ActivityResultLauncher;", "jumpForResult", "Ljava/util/Timer;", "q", "Ljava/util/Timer;", "getTimer", "()Ljava/util/Timer;", "setTimer", "(Ljava/util/Timer;)V", "timer", "r", "Lnf/z;", "getUpgradeEvent", "()Lnf/z;", "setUpgradeEvent", "upgradeEvent", "", "Lcom/live/evo_mobile/ui/MainViewActivity$b;", "s", "Ljava/util/List;", "navigationViewInfoList", "Landroid/view/View$OnApplyWindowInsetsListener;", "t", "Landroid/view/View$OnApplyWindowInsetsListener;", "onApplyWindowInsetsListener", "Lkotlin/Function3;", "u", "Lc9/q;", "actionMarginNavigation", "actionPaddingNavigation", "a", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainViewActivity extends BaseDataBindActivity<z4.u> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static String f7832x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static String f7833y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static String f7834z;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Fragment mCurrFragment;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Fragment mTvFragment;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Fragment mMeFragment;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private DialogFragment upgradeDialog;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int mLlMainHeight;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final ActivityResultLauncher<Intent> jumpForResult;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private Timer timer;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private nf.z upgradeEvent;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final List<b> navigationViewInfoList;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final View.OnApplyWindowInsetsListener onApplyWindowInsetsListener;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final c9.q<View, Integer, Integer, r8.z> actionMarginNavigation;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final c9.q<View, Integer, Integer, r8.z> actionPaddingNavigation;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R/\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/live/evo_mobile/ui/MainViewActivity$b;", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "hostRef", "viewRef", "", "rawBottom", "Lkotlin/Function3;", "Lr8/z;", "onNavHeightChangeListener", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;ILc9/q;)V", "a", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "b", "d", "c", "I", "()I", "Lc9/q;", "()Lc9/q;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<View> hostRef;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<View> viewRef;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int rawBottom;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final c9.q<View, Integer, Integer, r8.z> onNavHeightChangeListener;

        /* JADX WARN: Multi-variable type inference failed */
        public b(WeakReference<View> hostRef, WeakReference<View> viewRef, int i10, c9.q<? super View, ? super Integer, ? super Integer, r8.z> onNavHeightChangeListener) {
            kotlin.jvm.internal.m.f(hostRef, "hostRef");
            kotlin.jvm.internal.m.f(viewRef, "viewRef");
            kotlin.jvm.internal.m.f(onNavHeightChangeListener, "onNavHeightChangeListener");
            this.hostRef = hostRef;
            this.viewRef = viewRef;
            this.rawBottom = i10;
            this.onNavHeightChangeListener = onNavHeightChangeListener;
        }

        public final WeakReference<View> a() {
            return this.hostRef;
        }

        public final c9.q<View, Integer, Integer, r8.z> b() {
            return this.onNavHeightChangeListener;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getRawBottom() {
            return this.rawBottom;
        }

        public final WeakReference<View> d() {
            return this.viewRef;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.MainViewActivity$OnEvent$1$1", f = "MainViewActivity.kt", l = {390}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ nf.z $event;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.MainViewActivity$OnEvent$1$1$1", f = "MainViewActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ nf.z $event;
            final /* synthetic */ int $launcherIcon;
            int label;
            final /* synthetic */ MainViewActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MainViewActivity mainViewActivity, int i10, nf.z zVar, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = mainViewActivity;
                this.$launcherIcon = i10;
                this.$event = zVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, this.$launcherIcon, this.$event, fVar);
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
                    t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                    MainViewActivity mainViewActivity = this.this$0;
                    int i10 = this.$launcherIcon;
                    String strA = this.$event.a();
                    kotlin.jvm.internal.m.e(strA, "getApkFile(...)");
                    aVar.E0(mainViewActivity, 2131953119, 2131953118, 2131953117, i10, strA);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(nf.z zVar, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$event = zVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return MainViewActivity.this.new c(this.$event, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            int iV;
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
                tf.g gVarC = x1.f1.lb.metric.monitor.i.f20958a.c();
                if (MainViewActivity.this.V() == 0) {
                    iV = 2131231256;
                } else {
                    iV = MainViewActivity.this.V();
                }
                if (gVarC != null) {
                    gVarC.l(x1.f1.lb.util.d1.c());
                }
                kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                a aVar = new a(MainViewActivity.this, iV, this.$event, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(g2VarC, aVar, this) == objC) {
                    return objC;
                }
            }
            uf.c.f19486a.s();
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo_mobile/ui/MainViewActivity$d", "Lv7/c$a;", "Lr8/z;", "onCancel", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements v7.c.a {
        @Override // v7.c.a
        public void onCancel() {
            tf.g gVarC = x1.f1.lb.metric.monitor.i.f20958a.c();
            if (gVarC != null) {
                gVarC.m("User canceled");
            }
            uf.c.f19486a.s();
        }

        d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo_mobile/ui/MainViewActivity$e", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e extends TimerTask {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo_mobile.ui.MainViewActivity$refreshSubscriptionList$task$1$run$1", f = "MainViewActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ MainViewActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MainViewActivity mainViewActivity, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = mainViewActivity;
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
                    if (y4.a.f22397a.booleanValue()) {
                        this.this$0.getLogger().debug("refresh subscription list", new Object[0]);
                    }
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new a(MainViewActivity.this, null), 3, null);
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.g event) {
        kotlin.jvm.internal.m.f(event, "event");
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public boolean w() {
        return false;
    }

    static {
        StubApp.interface11(12851);
        INSTANCE = new Companion(null);
        f7832x = "VOD";
        f7833y = "TV";
        f7834z = "Profile";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z N(MainViewActivity mainViewActivity, nf.z zVar) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.n1.f14892a, kotlinx.coroutines.a1.b(), null, mainViewActivity.new c(zVar, null), 2, null);
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z O() {
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z Q(MainViewActivity mainViewActivity, View view, int i10, int i11) {
        kotlin.jvm.internal.m.f(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = i10 + i11;
            view.requestLayout();
            if (y4.a.f22397a.booleanValue()) {
                mainViewActivity.getLogger().debug("nav_height[" + i11 + "] in listener", new Object[0]);
            }
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z R(View view, int i10, int i11) {
        kotlin.jvm.internal.m.f(view, "view");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10 + i11);
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z Y(MainViewActivity mainViewActivity, TabBarBean.ItemBean it) {
        kotlin.jvm.internal.m.f(it, "it");
        String text = it.getText();
        if (kotlin.jvm.internal.m.a(text, f7833y)) {
            mainViewActivity.f0(mainViewActivity.mCurrFragment, mainViewActivity.mTvFragment, it.getText());
            mainViewActivity.mCurrFragment = mainViewActivity.mTvFragment;
        } else if (kotlin.jvm.internal.m.a(text, f7834z)) {
            mainViewActivity.f0(mainViewActivity.mCurrFragment, mainViewActivity.mMeFragment, it.getText());
            mainViewActivity.mCurrFragment = mainViewActivity.mMeFragment;
        }
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets d0(MainViewActivity mainViewActivity, View v10, WindowInsets insets) {
        kotlin.jvm.internal.m.f(v10, "v");
        kotlin.jvm.internal.m.f(insets, "insets");
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets, v10);
        kotlin.jvm.internal.m.e(windowInsetsCompat, "toWindowInsetsCompat(...)");
        int i10 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        Iterator<b> it = mainViewActivity.navigationViewInfoList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            View view = next.a().get();
            View view2 = next.d().get();
            if (view == null || view2 == null) {
                it.remove();
            } else if (kotlin.jvm.internal.m.a(view, v10)) {
                next.b().invoke(view2, Integer.valueOf(next.getRawBottom()), Integer.valueOf(i10));
            }
        }
        return insets;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(final nf.z event) {
        Dialog dialog;
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        DialogFragment dialogFragment = this.upgradeDialog;
        if (dialogFragment == null || (dialog = dialogFragment.getDialog()) == null || !dialog.isShowing()) {
            v7.c cVar = new v7.c(event.b().getMessage(), new c9.a() { // from class: com.live.evo_mobile.ui.j1
                @Override // c9.a
                public final Object invoke() {
                    return MainViewActivity.N(this.f7961a, event);
                }
            });
            this.upgradeDialog = cVar;
            v7.c.h0(cVar, new d(), false, 2, null);
            cVar.setTitle(getString(2131953120) + ":" + event.b().getVersionName());
            if (event.b().getForceUpgrade() == 1) {
                cVar.a0();
            }
            cVar.f0(false);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
            cVar.X(supportFragmentManager);
        }
    }

    public final void S() {
        if (this.timer == null) {
            return;
        }
        if (y4.a.f22397a.booleanValue()) {
            getLogger().debug("cancel timer to refresh subscription list", new Object[0]);
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.purge();
        }
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        this.timer = null;
    }

    public final void Z() {
        nf.z zVar = this.upgradeEvent;
        if (zVar != null) {
            OnEvent(zVar);
            return;
        }
        String apkFile = getApkFile();
        if (apkFile == null) {
            return;
        }
        t.v.c.i.a.f18646a.E0(this, 2131953119, 2131953118, 2131953117, V() == 0 ? 2131231256 : V(), apkFile);
    }

    public final void b0() {
        if (kotlin.jvm.internal.m.a(this.mCurrFragment, this.mTvFragment)) {
            return;
        }
        f0(this.mCurrFragment, this.mTvFragment, f7833y);
        this.mCurrFragment = this.mTvFragment;
    }

    public final void c0() {
        this.jumpForResult.launch(new Intent(this, (Class<?>) RenewActivity.class));
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment fragment = this.mCurrFragment;
        if (fragment instanceof d1) {
            kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo_mobile.ui.MainTVFragment");
            if (((d1) fragment).g1()) {
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity, androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        View decorView;
        View decorView2;
        kotlin.jvm.internal.m.f(newConfig, "newConfig");
        Context baseContext = getBaseContext();
        kotlin.jvm.internal.m.e(baseContext, "getBaseContext(...)");
        x1.f1.lb.util.n0.n(baseContext, newConfig);
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation != 1) {
            if (this.mLlMainHeight == 0) {
                this.mLlMainHeight = t().f22986b.getMeasuredHeight();
            }
            Window window = getWindow();
            if (window != null && (decorView = window.getDecorView()) != null) {
                decorView.setSystemUiVisibility(3847);
            }
            t().f22987c.setVisibility(8);
            t().f22986b.getLayoutParams().height = -1;
            return;
        }
        Window window2 = getWindow();
        if (window2 != null && (decorView2 = window2.getDecorView()) != null) {
            decorView2.setSystemUiVisibility(1792);
        }
        t().f22987c.setVisibility(0);
        if (this.mLlMainHeight > 0) {
            t().f22986b.getLayoutParams().height = this.mLlMainHeight;
        }
        LinearLayout llMain = t().f22986b;
        kotlin.jvm.internal.m.e(llMain, "llMain");
        U(llMain);
    }

    public final void paddingByNavBar(View view) {
        kotlin.jvm.internal.m.f(view, "view");
        int paddingBottom = view.getPaddingBottom();
        View viewX = X(view);
        if (viewX.isAttachedToWindow()) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), W(viewX) + paddingBottom);
        }
        this.navigationViewInfoList.add(new b(new WeakReference(viewX), new WeakReference(view), paddingBottom, this.actionPaddingNavigation));
        viewX.setOnApplyWindowInsetsListener(this.onApplyWindowInsetsListener);
    }

    public MainViewActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.live.evo_mobile.ui.e1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainViewActivity.a0(this.f7927a, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.m.e(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.jumpForResult = activityResultLauncherRegisterForActivityResult;
        this.navigationViewInfoList = new ArrayList();
        this.onApplyWindowInsetsListener = new View.OnApplyWindowInsetsListener() { // from class: com.live.evo_mobile.ui.f1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return MainViewActivity.d0(this.f7932a, view, windowInsets);
            }
        };
        this.actionMarginNavigation = new c9.q() { // from class: com.live.evo_mobile.ui.g1
            @Override // c9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainViewActivity.Q(this.f7953a, (View) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        };
        this.actionPaddingNavigation = new c9.q() { // from class: com.live.evo_mobile.ui.h1
            @Override // c9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainViewActivity.R((View) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        };
    }

    private final void U(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            return;
        }
        int i10 = marginLayoutParams.bottomMargin;
        View viewX = X(view);
        if (viewX.isAttachedToWindow()) {
            int iW = W(viewX);
            marginLayoutParams.bottomMargin = i10 + iW;
            view.requestLayout();
            if (y4.a.f22397a.booleanValue()) {
                getLogger().debug("nav_height[" + iW + "]", new Object[0]);
            }
        }
        this.navigationViewInfoList.add(new b(new WeakReference(viewX), new WeakReference(view), i10, this.actionMarginNavigation));
        viewX.setOnApplyWindowInsetsListener(this.onApplyWindowInsetsListener);
    }

    private final int W(View view) {
        Insets insets;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        if (rootWindowInsets != null) {
            insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars());
        } else {
            insets = null;
        }
        if (insets != null) {
            return insets.bottom;
        }
        return x1.f1.lb.util.a0.f21295a.c(this);
    }

    @SuppressLint({"ContextCast"})
    private final View X(View view) {
        ContextWrapper contextWrapper;
        Activity activity;
        View viewFindViewById;
        Context context = view.getContext();
        View rootView = null;
        if (context instanceof ContextWrapper) {
            contextWrapper = (ContextWrapper) context;
        } else {
            contextWrapper = null;
        }
        if (contextWrapper != null) {
            Context baseContext = contextWrapper.getBaseContext();
            if (baseContext instanceof Activity) {
                activity = (Activity) baseContext;
            } else {
                activity = null;
            }
            if (activity != null && (viewFindViewById = activity.findViewById(R.id.content)) != null) {
                rootView = viewFindViewById.getRootView();
            }
            if (rootView != null) {
                return rootView;
            }
        }
        View rootView2 = view.getRootView();
        kotlin.jvm.internal.m.e(rootView2, "getRootView(...)");
        return rootView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(MainViewActivity mainViewActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 1) {
            mainViewActivity.e0();
        }
    }

    private final void f0(Fragment from, Fragment to, String tag) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
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
                fragmentTransactionBeginTransaction.add(R$id.frame_content, to, tag).commit();
            }
        }
    }

    public final void T(String channelId) {
        t().f22987c.e(0);
        if (!(this.mCurrFragment instanceof d1)) {
            t().f22987c.e(1);
        }
        Fragment fragment = this.mTvFragment;
        kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo_mobile.ui.MainTVFragment");
        ((d1) fragment).Q0(channelId);
    }

    public int V() {
        return 2131231256;
    }

    public final void e0() {
        S();
        if (y4.a.f22397a.booleanValue()) {
            getLogger().debug("start timer to refresh subscription list", new Object[0]);
        }
        t.v.c.i.a.f18646a.I();
        this.timer = new Timer();
        e eVar = new e();
        Timer timer = this.timer;
        if (timer != null) {
            timer.schedule(eVar, 50L, 3000L);
        }
    }

    public final void g0() {
        if (!TextUtils.isEmpty(getApkFile())) {
            Z();
        } else {
            BaseDataBindActivity.m(this, null, 1, null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (xe.c.c().j(this)) {
            xe.c.c().u(this);
        }
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!xe.c.c().j(this)) {
            xe.c.c().q(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        com.tvc.lib.mobile.ext.a.c(this, R$color.tab_bg_color, Boolean.FALSE);
        f7832x = getString(2131952198);
        f7833y = getString(2131952197);
        f7834z = getString(2131952196);
        this.mTvFragment = d1.INSTANCE.a();
        this.mMeFragment = k0.INSTANCE.a();
        t().f22987c.d(new TabBarBean(Color.parseColor("#5A5E65"), ContextCompat.getColor(this, R$color.color_focused), Color.parseColor("#292934"), "white", kotlin.collections.r.g(new TabBarBean.ItemBean("1", false, f7833y, "", "", R$mipmap.main_tab_tv_check, R$mipmap.main_tab_tv_checked), new TabBarBean.ItemBean(ExifInterface.GPS_MEASUREMENT_2D, false, f7834z, "", "", R$mipmap.main_tab_me_check, R$mipmap.main_tab_me_checked))), new c9.l() { // from class: com.live.evo_mobile.ui.i1
            @Override // c9.l
            public final Object invoke(Object obj) {
                return MainViewActivity.Y(this.f7958a, (TabBarBean.ItemBean) obj);
            }
        });
        LinearLayout llMain = t().f22986b;
        kotlin.jvm.internal.m.e(llMain, "llMain");
        U(llMain);
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_view_main;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.a0 event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (event.c()) {
            v7.c cVar = new v7.c(event.b().getVersionName() + "\n" + event.a(), new c9.a() { // from class: com.live.evo_mobile.ui.k1
                @Override // c9.a
                public final Object invoke() {
                    return MainViewActivity.O();
                }
            });
            String string = getString(2131953114);
            kotlin.jvm.internal.m.e(string, "getString(...)");
            cVar.setTitle(string);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
            cVar.X(supportFragmentManager);
            return;
        }
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String strA = event.a();
        kotlin.jvm.internal.m.e(strA, "getErrMsg(...)");
        g1Var.c(strA);
    }
}
