package com.live.evo.fragment.login;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.a0;
import com.live.evo.util.p1;
import com.live.evo.util.x1;
import com.live.evo.util.z0;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x1.f1.lb.util.g1;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001a\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001&B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u0019\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0007J-\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u0007J\u001f\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\u0007J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0007J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010\u0007J\u000f\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010\u0007J\u000f\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010\u0007J\u001f\u0010.\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\fH\u0016¢\u0006\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u00105R\u0018\u00108\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010>R\u0018\u0010A\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00105R\u0018\u0010C\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00105R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00105R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00105R\u0018\u0010S\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010OR\u0018\u0010T\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u00105R\u0018\u0010V\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u00105R\u0018\u0010X\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010OR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006l"}, d2 = {"Lcom/live/evo/fragment/login/u;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lcom/live/evo/fragment/login/presenter/h;", "Landroid/view/View$OnFocusChangeListener;", "Le5/a$a;", "<init>", "()V", "Lr8/z;", "l", "e0", "f0", "", "isInBackground", "c0", "(Z)V", "h0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "hidden", "onHiddenChanged", "v", "onClick", "(Landroid/view/View;)V", "e", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, "errorCode", "i", "(Ljava/lang/String;Ljava/lang/String;)V", "b", "a", "data", "n", "(Ljava/lang/String;)V", "onPause", "onResume", "onDestroy", "hasFocus", "onFocusChange", "(Landroid/view/View;Z)V", "H", "()Z", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mRemind", "c", "mConfirm", "Lcom/live/evo/fragment/login/presenter/i;", "d", "Lcom/live/evo/fragment/login/presenter/i;", "mPresenter", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "mCardNum", "f", "mUserName", "g", "mRemindBottom", "Lcom/live/evo/fragment/login/k;", "h", "Lcom/live/evo/fragment/login/k;", "mRechargeListener", "mToLogin", "Lt5/a;", "j", "Lt5/a;", "loadingView", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "mBack", "mRechargeHint", "m", "mMemberQR", "mRefreshQRCode", "o", "mCheckPayment", "p", "mIcon", "Lziyi/kit/keyboard/b;", "q", "Lziyi/kit/keyboard/b;", "keyboardView", "Landroid/view/Window;", "r", "Landroid/view/Window;", "mWindow", "com/live/evo/fragment/login/u$c", "s", "Lcom/live/evo/fragment/login/u$c;", "handler", "Landroid/view/View$OnKeyListener;", "t", "Landroid/view/View$OnKeyListener;", "mFoucsKeyListener", "u", "Ljava/lang/String;", "lastQRUrl", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u extends Fragment implements View.OnClickListener, com.live.evo.fragment.login.presenter.h, View.OnFocusChangeListener, e5.a.InterfaceC0175a {

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static SoftReference<u> f6409w;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View view;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TextView mRemind;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private TextView mConfirm;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.fragment.login.presenter.i mPresenter;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private EditText mCardNum;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mUserName;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private TextView mRemindBottom;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private k mRechargeListener;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mToLogin;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private t5.a loadingView;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ImageView mBack;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mRechargeHint;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mMemberQR;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mRefreshQRCode;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private TextView mCheckPayment;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private ImageView mIcon;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private ziyi.kit.keyboard.b keyboardView;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Window mWindow;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final c handler = new c(Looper.getMainLooper());

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final View.OnKeyListener mFoucsKeyListener = new View.OnKeyListener() { // from class: com.live.evo.fragment.login.t
        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
            return u.g0(this.f6407a, view, i10, keyEvent);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private String lastQRUrl = "";

    /* JADX INFO: renamed from: com.live.evo.fragment.login.u$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/live/evo/fragment/login/u$a;", "", "<init>", "()V", "Lcom/live/evo/fragment/login/u;", "a", "()Lcom/live/evo/fragment/login/u;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroid/view/Window;", "window", "", "containerId", "Lcom/live/evo/fragment/login/k;", "listener", "Lr8/z;", "b", "(Landroidx/fragment/app/FragmentManager;Landroid/view/Window;ILcom/live/evo/fragment/login/k;)V", "", "TAG", "Ljava/lang/String;", "Ljava/lang/ref/SoftReference;", "INSTANCE", "Ljava/lang/ref/SoftReference;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final synchronized void b(FragmentManager fm, Window window, int containerId, k listener) {
            try {
                kotlin.jvm.internal.m.f(fm, "fm");
                u uVarA = a();
                if (uVarA == null) {
                    return;
                }
                uVarA.mRechargeListener = listener;
                uVarA.mWindow = window;
                Fragment fragmentFindFragmentByTag = fm.findFragmentByTag("ScanedRechargeFragment");
                FragmentTransaction fragmentTransactionBeginTransaction = fm.beginTransaction();
                kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                if (fragmentFindFragmentByTag == null) {
                    fragmentTransactionBeginTransaction.add(containerId, uVarA, "ScanedRechargeFragment").commitAllowingStateLoss();
                } else {
                    fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        private Companion() {
        }

        public final u a() {
            u.f6409w = new SoftReference(new u());
            SoftReference softReference = u.f6409w;
            if (softReference != null) {
                return (u) softReference.get();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.ScanedRechargeFragment$checkPayment$1", f = "ScanedRechargeFragment.kt", l = {323, 335}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ boolean $isInBackground;
        final /* synthetic */ long $nowExpireTS;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.ScanedRechargeFragment$checkPayment$1$1", f = "ScanedRechargeFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super z>, Object> {
            final /* synthetic */ boolean $isInBackground;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ u this$0;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.u$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.ScanedRechargeFragment$checkPayment$1$1$1", f = "ScanedRechargeFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0095a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ boolean $isInBackground;
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ u this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0095a(u uVar, boolean z10, Throwable th, v8.f<? super C0095a> fVar) {
                    super(2, fVar);
                    this.this$0 = uVar;
                    this.$isInBackground = z10;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0095a(this.this$0, this.$isInBackground, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0095a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    String message;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.this$0.isAdded()) {
                            TextView textView = this.this$0.mCheckPayment;
                            if (textView != null) {
                                textView.setText(x1.j(2131952883));
                            }
                            if (!this.$isInBackground && (message = this.$it.getMessage()) != null) {
                                g1.f21390a.c(message);
                            }
                            return z.f17874a;
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(u uVar, boolean z10, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = uVar;
                this.$isInBackground = z10;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super z> fVar) {
                a aVar = new a(this.this$0, this.$isInBackground, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.j.d(m0.b(), null, null, new C0095a(this.this$0, this.$isInBackground, (Throwable) this.L$0, null), 3, null);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.live.evo.fragment.login.u$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0096b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ u f6431a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f6432b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f6433c;

            /* JADX INFO: renamed from: com.live.evo.fragment.login.u$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.login.ScanedRechargeFragment$checkPayment$1$2$1", f = "ScanedRechargeFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ boolean $isInBackground;
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                final /* synthetic */ long $nowExpireTS;
                int label;
                final /* synthetic */ u this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(u uVar, r8.u<Boolean, Integer, String> uVar2, long j10, boolean z10, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = uVar;
                    this.$it = uVar2;
                    this.$nowExpireTS = j10;
                    this.$isInBackground = z10;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$it, this.$nowExpireTS, this.$isInBackground, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    String string;
                    k kVar;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.this$0.isAdded()) {
                            TextView textView = this.this$0.mCheckPayment;
                            if (textView != null) {
                                textView.setText(x1.j(2131952883));
                            }
                            if (this.$it.d().booleanValue()) {
                                this.this$0.h0();
                                if (this.$nowExpireTS != com.live.evo.l.n().l()) {
                                    t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                                    int iR = aVar.R();
                                    String strH = aVar.H();
                                    g1.f21390a.c(x1.j(R$string.remind_recharge_successfully) + "\n" + iR + " " + this.this$0.getString(R$string.days) + " / " + strH);
                                    if (this.this$0.mRechargeListener != null && (kVar = this.this$0.mRechargeListener) != null) {
                                        kVar.b(this.this$0);
                                    }
                                } else if (!this.$isInBackground) {
                                    g1 g1Var = g1.f21390a;
                                    String strJ = x1.j(R$string.user_not_available);
                                    kotlin.jvm.internal.m.e(strJ, "getString(...)");
                                    g1Var.c(strJ);
                                }
                            } else if (!this.$isInBackground) {
                                Integer numE = this.$it.e();
                                if (numE == null || (string = numE.toString()) == null) {
                                    string = "";
                                }
                                String strF = this.$it.f();
                                if (strF != null) {
                                    g1.f21390a.c(strF + "(" + string + ")");
                                }
                            }
                            return z.f17874a;
                        }
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            C0096b(u uVar, long j10, boolean z10) {
                this.f6431a = uVar;
                this.f6432b = j10;
                this.f6433c = z10;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                kotlinx.coroutines.j.d(m0.b(), null, null, new a(this.f6431a, uVar, this.f6432b, this.f6433c, null), 3, null);
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z10, long j10, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$isInBackground = z10;
            this.$nowExpireTS = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return u.this.new b(this.$isInBackground, this.$nowExpireTS, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
        
            if (r8.collect(r1, r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                }
                return z.f17874a;
            }
            r8.r.b(obj);
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            this.label = 1;
            obj = aVar.M0(this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(u.this, this.$isInBackground, null));
            C0096b c0096b = new C0096b(u.this, this.$nowExpireTS, this.$isInBackground);
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/fragment/login/u$c", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 1) {
                u.this.c0(true);
                sendEmptyMessageDelayed(1, ((long) t.v.c.i.a.f18646a.V()) * 1000);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo/fragment/login/u$d", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            kotlin.jvm.internal.m.f(s10, "s");
            if (TextUtils.isEmpty(s10) || s10.length() < 19) {
                EditText editText = u.this.mCardNum;
                kotlin.jvm.internal.m.c(editText);
                editText.setTextColor(x1.e(R$color.text_color_et_selector_focus));
                EditText editText2 = u.this.mCardNum;
                kotlin.jvm.internal.m.c(editText2);
                editText2.setBackground(x1.f(R$drawable.load_et_selector));
                TextView textView = u.this.mConfirm;
                kotlin.jvm.internal.m.c(textView);
                textView.setEnabled(false);
                TextView textView2 = u.this.mConfirm;
                kotlin.jvm.internal.m.c(textView2);
                textView2.setFocusable(false);
                return;
            }
            EditText editText3 = u.this.mCardNum;
            kotlin.jvm.internal.m.c(editText3);
            editText3.setBackground(x1.f(R$drawable.recharge_mini_full));
            EditText editText4 = u.this.mCardNum;
            kotlin.jvm.internal.m.c(editText4);
            editText4.setTextColor(x1.e(R$color.recharge_fill_text_color));
            TextView textView3 = u.this.mConfirm;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setEnabled(true);
            TextView textView4 = u.this.mConfirm;
            kotlin.jvm.internal.m.c(textView4);
            textView4.setFocusable(true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
            kotlin.jvm.internal.m.f(s10, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
            kotlin.jvm.internal.m.f(s10, "s");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/live/evo/fragment/login/u$e", "Lcom/live/evo/dialog/r$c;", "Lr8/z;", "a", "()V", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements com.live.evo.dialog.r.c {
        e() {
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            Editable text;
            EditText editText = u.this.mCardNum;
            if (editText != null) {
                editText.requestFocus();
            }
            EditText editText2 = u.this.mCardNum;
            if (editText2 != null) {
                EditText editText3 = u.this.mCardNum;
                editText2.setSelection((editText3 == null || (text = editText3.getText()) == null) ? 0 : text.length());
            }
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    static /* synthetic */ void d0(u uVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        uVar.c0(z10);
    }

    private final void e0() {
        EditText editText = this.mCardNum;
        kotlin.jvm.internal.m.c(editText);
        editText.setOnFocusChangeListener(this);
        TextView textView = this.mConfirm;
        kotlin.jvm.internal.m.c(textView);
        textView.setOnFocusChangeListener(this);
        TextView textView2 = this.mConfirm;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setOnFocusChangeListener(this);
        ImageView imageView = this.mBack;
        kotlin.jvm.internal.m.c(imageView);
        imageView.setOnClickListener(this);
        TextView textView3 = this.mConfirm;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setOnClickListener(this);
        TextView textView4 = this.mToLogin;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setOnClickListener(this);
        TextView textView5 = this.mRefreshQRCode;
        if (textView5 != null) {
            textView5.setOnClickListener(this);
        }
        TextView textView6 = this.mCheckPayment;
        if (textView6 != null) {
            textView6.setOnClickListener(this);
        }
        EditText editText2 = this.mCardNum;
        kotlin.jvm.internal.m.c(editText2);
        editText2.addTextChangedListener(new d());
        EditText editText3 = this.mCardNum;
        kotlin.jvm.internal.m.c(editText3);
        editText3.setOnKeyListener(this.mFoucsKeyListener);
        TextView textView7 = this.mRefreshQRCode;
        kotlin.jvm.internal.m.c(textView7);
        textView7.setOnKeyListener(this.mFoucsKeyListener);
        TextView textView8 = this.mCheckPayment;
        kotlin.jvm.internal.m.c(textView8);
        textView8.setOnKeyListener(this.mFoucsKeyListener);
    }

    private final void f0() {
        View view = this.view;
        ImageView imageView = view != null ? (ImageView) view.findViewById(R$id.rechargef_iv_icon) : null;
        this.mIcon = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), com.live.evo.a.f5198r, null));
        }
        View view2 = this.view;
        this.mRemind = view2 != null ? (TextView) view2.findViewById(R$id.rechargef_tv_remind) : null;
        View view3 = this.view;
        this.mConfirm = view3 != null ? (TextView) view3.findViewById(R$id.rechargef_tv_confirm) : null;
        View view4 = this.view;
        this.mUserName = view4 != null ? (TextView) view4.findViewById(R$id.rechargef_tv_username) : null;
        View view5 = this.view;
        this.mCardNum = view5 != null ? (EditText) view5.findViewById(R$id.rechargef_et_card_num) : null;
        View view6 = this.view;
        this.mRemindBottom = view6 != null ? (TextView) view6.findViewById(R$id.rechargef_tv_remind_bottom) : null;
        View view7 = this.view;
        this.mToLogin = view7 != null ? (TextView) view7.findViewById(R$id.rechargef_tv_how_to_recharge) : null;
        View view8 = this.view;
        this.mBack = view8 != null ? (ImageView) view8.findViewById(R$id.rechargef_iv_back) : null;
        View view9 = this.view;
        this.mRechargeHint = view9 != null ? (TextView) view9.findViewById(R$id.rechargef_tv_remind_hint) : null;
        View view10 = this.view;
        this.mMemberQR = view10 != null ? (ImageView) view10.findViewById(R$id.rechargef_iv_qr_membersite) : null;
        View view11 = this.view;
        this.mRefreshQRCode = view11 != null ? (TextView) view11.findViewById(R$id.rechargef_qrcode_refresh) : null;
        View view12 = this.view;
        this.mCheckPayment = view12 != null ? (TextView) view12.findViewById(R$id.rechargef_check_payment) : null;
        View view13 = this.view;
        LinearLayout linearLayout = view13 != null ? (LinearLayout) view13.findViewById(R$id.ll_scan_qr_code) : null;
        if (!com.live.evo.l.n().v() && linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        t5.a aVar = new t5.a(requireActivity());
        this.loadingView = aVar;
        aVar.f(com.live.evo.widget.sloading.c.TRANSLATE_CIRCLE);
        t5.a aVar2 = this.loadingView;
        if (aVar2 != null) {
            aVar2.g(R$color.sloading_color);
        }
        com.live.evo.util.t.b(this.mRemind);
        com.live.evo.util.t.d(this.mConfirm);
        com.live.evo.util.t.b(this.mUserName);
        com.live.evo.util.t.d(this.mCardNum);
        com.live.evo.util.t.b(this.mRemindBottom);
        ziyi.kit.keyboard.b bVar = this.keyboardView;
        if (bVar != null && bVar != null) {
            bVar.l(this.mCardNum);
        }
        EditText editText = this.mCardNum;
        if (editText != null) {
            editText.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g0(u uVar, View view, int i10, KeyEvent keyEvent) {
        EditText editText;
        ImageView imageView;
        if (uVar.keyboardView != null && keyEvent.getAction() == 0 && (i10 == 23 || i10 == 66)) {
            if (view.getId() == 2131429054) {
                ziyi.kit.keyboard.b bVar = uVar.keyboardView;
                kotlin.jvm.internal.m.c(bVar);
                bVar.m0();
                return true;
            }
        } else {
            if (uVar.keyboardView != null && keyEvent.getAction() == 1 && (i10 == 23 || i10 == 66)) {
                return view.getId() == 2131429054;
            }
            if (uVar.keyboardView != null && keyEvent.getAction() == 1 && (i10 == 4 || i10 == 111)) {
                if (view.getId() == 2131429054) {
                    ziyi.kit.keyboard.b bVar2 = uVar.keyboardView;
                    kotlin.jvm.internal.m.c(bVar2);
                    if (bVar2.getVisibility() == 0) {
                        ziyi.kit.keyboard.b bVar3 = uVar.keyboardView;
                        kotlin.jvm.internal.m.c(bVar3);
                        bVar3.p();
                        return true;
                    }
                }
            } else {
                if ((view.getId() == 2131429058 || view.getId() == 2131429053) && i10 == 22) {
                    if (keyEvent.getAction() == 1 && (editText = uVar.mCardNum) != null) {
                        editText.requestFocus();
                    }
                    return true;
                }
                if (view.getId() == 2131429058 && i10 == 19) {
                    if (keyEvent.getAction() == 1 && (imageView = uVar.mBack) != null) {
                        imageView.requestFocus();
                    }
                    return true;
                }
                if (view.getId() == 2131429054 && i10 == 20) {
                    TextView textView = uVar.mConfirm;
                    kotlin.jvm.internal.m.c(textView);
                    if (textView.isEnabled()) {
                        if (keyEvent.getAction() == 1) {
                            TextView textView2 = uVar.mConfirm;
                            kotlin.jvm.internal.m.c(textView2);
                            textView2.requestFocus();
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // e5.a.InterfaceC0175a
    public boolean H() {
        ImageView imageView = this.mBack;
        if (imageView == null || imageView == null || imageView.getVisibility() != 0) {
            return e5.a.a(this);
        }
        k kVar = this.mRechargeListener;
        if (kVar == null || kVar == null) {
            return true;
        }
        kVar.a(this);
        return true;
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void a() {
        t5.a aVar = this.loadingView;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void b() {
        t5.a aVar = this.loadingView;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void e() {
        EditText editText = this.mCardNum;
        if (editText != null) {
            editText.setText("");
        }
        k kVar = this.mRechargeListener;
        if (kVar == null || kVar == null) {
            return;
        }
        kVar.b(this);
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void i(String error, String errorCode) {
        String str;
        kotlin.jvm.internal.m.f(error, "error");
        kotlin.jvm.internal.m.f(errorCode, "errorCode");
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(getActivity(), new e());
        rVar.k(x1.j(R$string.recharge_fail));
        if (TextUtils.isEmpty(errorCode)) {
            str = "";
        } else {
            str = x1.j(2131952013) + errorCode;
        }
        rVar.j(error, str);
        rVar.l();
    }

    @Override // com.live.evo.fragment.login.presenter.h
    public void n(String data) {
        kotlin.jvm.internal.m.f(data, "data");
        if (com.live.evo.l.n().q() != 2 && com.live.evo.l.n().q() != 6) {
            TextView textView = this.mUserName;
            if (textView != null) {
                textView.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView2 = this.mUserName;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.mUserName;
        if (textView3 != null) {
            g0 g0Var = g0.f12340a;
            String str = String.format("%s %s", Arrays.copyOf(new Object[]{x1.j(R$string.email_id_2), data}, 2));
            kotlin.jvm.internal.m.e(str, "format(...)");
            textView3.setText(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0077  */
    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        String string;
        int iA;
        com.live.evo.fragment.login.presenter.i iVar;
        kotlin.jvm.internal.m.f(v10, "v");
        switch (v10.getId()) {
            case R$id.rechargef_check_payment /* 2131429053 */:
                d0(this, false, 1, null);
                break;
            case R$id.rechargef_iv_back /* 2131429055 */:
                k kVar = this.mRechargeListener;
                if (kVar != null && kVar != null) {
                    kVar.a(this);
                    break;
                }
                break;
            case R$id.rechargef_qrcode_refresh /* 2131429058 */:
                h0();
                break;
            case R$id.rechargef_tv_confirm /* 2131429060 */:
                TextView textView = this.mConfirm;
                if (textView != null && textView.isEnabled()) {
                    EditText editText = this.mCardNum;
                    String strValueOf = String.valueOf(editText != null ? editText.getText() : null);
                    int length = strValueOf.length() - 1;
                    int i10 = 0;
                    boolean z10 = false;
                    while (i10 <= length) {
                        boolean z11 = kotlin.jvm.internal.m.h(strValueOf.charAt(!z10 ? i10 : length), 32) <= 0;
                        if (z10) {
                            if (!z11) {
                                string = strValueOf.subSequence(i10, length + 1).toString();
                                com.live.evo.l.n().q();
                                iA = o5.a.c().a(com.live.evo.l.n().d());
                                iVar = this.mPresenter;
                                if (iVar != null) {
                                    iVar.A(ua.n.E(string, " ", "", false, 4, null), iA);
                                }
                            } else {
                                length--;
                            }
                            break;
                        } else if (z11) {
                            i10++;
                        } else {
                            z10 = true;
                        }
                    }
                    string = strValueOf.subSequence(i10, length + 1).toString();
                    com.live.evo.l.n().q();
                    iA = o5.a.c().a(com.live.evo.l.n().d());
                    iVar = this.mPresenter;
                    if (iVar != null) {
                        iVar.A(ua.n.E(string, " ", "", false, 4, null), iA);
                    }
                    break;
                }
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        this.view = inflater.inflate(R$layout.recharge_fragment, container, false);
        this.keyboardView = KeyUtils.t(this.mWindow, getContext(), this.view, getLifecycle(), false);
        com.live.evo.fragment.login.presenter.i iVar = new com.live.evo.fragment.login.presenter.i();
        this.mPresenter = iVar;
        kotlin.jvm.internal.m.c(iVar);
        iVar.B(this);
        f0();
        l();
        e0();
        a0.k(this, this.view);
        return this.view;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v10, boolean hasFocus) {
        kotlin.jvm.internal.m.f(v10, "v");
        if (hasFocus) {
            z0.d(v10);
        } else {
            z0.g(v10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        com.live.evo.fragment.login.presenter.i iVar = this.mPresenter;
        if (iVar != null && iVar != null) {
            iVar.u();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(boolean isInBackground) {
        CharSequence text;
        long jL = com.live.evo.l.n().l();
        String strJ = x1.j(R$string.checking);
        TextView textView = this.mCheckPayment;
        if (textView != null) {
            text = textView.getText();
        } else {
            text = null;
        }
        if (kotlin.jvm.internal.m.a(text, strJ)) {
            return;
        }
        TextView textView2 = this.mCheckPayment;
        if (textView2 != null) {
            textView2.setText(strJ);
        }
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new b(isInBackground, jL, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        Bitmap bitmapT;
        if (com.live.evo.l.n().j("member_qr_display", true)) {
            String strP = t.v.c.i.a.f18646a.P();
            if (!ac.g.d(strP, this.lastQRUrl)) {
                if (!TextUtils.isEmpty(strP) && (bitmapT = com.live.evo.l.n().t(strP)) != null) {
                    com.live.evo.util.v.b(getContext(), bitmapT, R$drawable.qr_placehodler, this.mMemberQR);
                }
                this.lastQRUrl = strP;
                return;
            }
            return;
        }
        ImageView imageView = this.mMemberQR;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    private final void l() {
        if (com.live.evo.l.n().v()) {
            this.handler.removeMessages(1);
            c cVar = this.handler;
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            cVar.sendEmptyMessageDelayed(1, ((long) aVar.V()) * 1000);
            String strA = p1.a("how_to_new_title", x1.j(R$string.how_to_renew));
            TextView textView = this.mRechargeHint;
            kotlin.jvm.internal.m.c(textView);
            textView.setText(Html.fromHtml(strA));
            String strJ = x1.j(R$string.recharge_code_scan_remind);
            TextView textView2 = this.mRemind;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setText(Html.fromHtml(strJ));
            String strA2 = p1.a("recharge_guide", x1.j(R$string.recharge_guide));
            String strN = aVar.N();
            String strV = aVar.v();
            kotlin.jvm.internal.m.c(strA2);
            String strE = ua.n.E(ua.n.E(ua.n.E(strA2, "${MS}", strN, false, 4, null), "${RS}", strN, false, 4, null), "${CS}", strV, false, 4, null);
            TextView textView3 = this.mRemindBottom;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setText(Html.fromHtml(strE));
        } else {
            String strI = com.live.evo.l.n().i("how_to_new_title", x1.j(R$string.how_to_buy_play));
            TextView textView4 = this.mRechargeHint;
            kotlin.jvm.internal.m.c(textView4);
            textView4.setText(Html.fromHtml(strI));
            String strJ2 = x1.j(R$string.recharge_code_remind);
            TextView textView5 = this.mRemind;
            kotlin.jvm.internal.m.c(textView5);
            textView5.setText(Html.fromHtml(strJ2));
            String strA3 = p1.a("recharge_guide", x1.j(R$string.payment_guide_rechargecode));
            t.v.c.i.a aVar2 = t.v.c.i.a.f18646a;
            String strN2 = aVar2.N();
            String strV2 = aVar2.v();
            kotlin.jvm.internal.m.c(strA3);
            String strE2 = ua.n.E(ua.n.E(ua.n.E(strA3, "${MS}", strN2, false, 4, null), "${RS}", strN2, false, 4, null), "${CS}", strV2, false, 4, null);
            TextView textView6 = this.mRemindBottom;
            kotlin.jvm.internal.m.c(textView6);
            textView6.setText(Html.fromHtml(strE2));
        }
        TextView textView7 = this.mToLogin;
        kotlin.jvm.internal.m.c(textView7);
        textView7.setText(Html.fromHtml("<u>" + x1.j(2131953058) + "</u>"));
        com.live.evo.fragment.login.presenter.i iVar = this.mPresenter;
        kotlin.jvm.internal.m.c(iVar);
        iVar.z();
        EditText editText = this.mCardNum;
        kotlin.jvm.internal.m.c(editText);
        editText.setText("");
        if (com.live.evo.l.n().q() != 2 && com.live.evo.l.n().q() != 6) {
            TextView textView8 = this.mUserName;
            kotlin.jvm.internal.m.c(textView8);
            textView8.setVisibility(4);
        } else {
            TextView textView9 = this.mUserName;
            kotlin.jvm.internal.m.c(textView9);
            textView9.setVisibility(0);
            TextView textView10 = this.mUserName;
            kotlin.jvm.internal.m.c(textView10);
            textView10.setText(t.v.c.i.a.f18646a.Z());
        }
        h0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f6409w = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            l();
        } else {
            this.handler.removeMessages(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.live.evo.fragment.login.presenter.i iVar = this.mPresenter;
        if (iVar != null && iVar != null) {
            iVar.B(this);
        }
        l();
    }
}
