package com.live.evo.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.activity.LiveNewActivity;
import com.live.evo.widget.BaseButton;
import com.live.evo.widget.VodLoadAnimation;
import java.lang.ref.SoftReference;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0002t(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u0004J!\u0010\u001d\u001a\u00020\t2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010<R\u0018\u0010E\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010<R\u0018\u0010G\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010<R\u0018\u0010I\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010<R\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010<R\u0018\u0010Q\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010LR\u0018\u0010S\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010<R\u0018\u0010U\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010LR\u0018\u0010W\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u00108R\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010ZR\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010bR\u0016\u0010e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u001e\u0010n\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010q¨\u0006u"}, d2 = {"Lcom/live/evo/fragment/t1;", "Lcom/live/evo/fragment/b;", "Landroid/view/View$OnFocusChangeListener;", "<init>", "()V", "Landroid/view/View;", "v", "", "hasFocus", "Lr8/z;", "onFocusChange", "(Landroid/view/View;Z)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "F0", "Lkotlin/Function1;", "callback", "R0", "(Lc9/l;)V", "O0", "I0", "M0", "P0", "G0", "", "throwable", "S0", "(Ljava/lang/Throwable;)V", "b", "E0", "(Z)V", "Ljava/lang/Runnable;", "runnable", "Q0", "(Ljava/lang/Runnable;)V", "Lq6/b;", "c", "Lq6/b;", "logger", "d", "Landroid/view/View;", "rootView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvNetwork", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "imgBoxToHubL1", "g", "imgBoxToHubL2", "h", "imgHubToInternetL1", "i", "imgHubToInternetL2", "j", "imgInternetToServerL1", "k", "imgInternetToServerL2", "l", "imgBoxToHubStatus", "Lcom/live/evo/widget/VodLoadAnimation;", "m", "Lcom/live/evo/widget/VodLoadAnimation;", "aniBoxToHubLoading", "n", "imgHubToInternetStatus", "o", "aniHubToInternetLoading", "p", "imgInternetToServerStatus", "q", "aniInternetToServerLoading", "r", "txtTestResult", "Lcom/live/evo/widget/BaseButton;", "s", "Lcom/live/evo/widget/BaseButton;", "btnCheck", "t", "btnCancel", "Lcom/live/evo/fragment/t1$b;", "u", "Lcom/live/evo/fragment/t1$b;", "tester", "Lc9/l;", "w", "Z", "isConnected", "Ljava/util/Timer;", "x", "Ljava/util/Timer;", "timer", "Ljava/lang/ref/SoftReference;", "Landroidx/appcompat/app/AppCompatActivity;", "y", "Ljava/lang/ref/SoftReference;", "activityReference", "", "z", "I", "retryIntervalSeconds", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t1 extends com.live.evo.fragment.b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean B;
    private static SoftReference<t1> C;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvNetwork;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView imgBoxToHubL1;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ImageView imgBoxToHubL2;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView imgHubToInternetL1;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView imgHubToInternetL2;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ImageView imgInternetToServerL1;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ImageView imgInternetToServerL2;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ImageView imgBoxToHubStatus;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private VodLoadAnimation aniBoxToHubLoading;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ImageView imgHubToInternetStatus;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private VodLoadAnimation aniHubToInternetLoading;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private ImageView imgInternetToServerStatus;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private VodLoadAnimation aniInternetToServerLoading;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private TextView txtTestResult;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private BaseButton btnCheck;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private BaseButton btnCancel;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private b tester;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private c9.l<? super Boolean, r8.z> callback;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean isConnected;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private Timer timer;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private SoftReference<AppCompatActivity> activityReference;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int retryIntervalSeconds;

    /* JADX INFO: renamed from: com.live.evo.fragment.t1$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/live/evo/fragment/t1$a;", "", "<init>", "()V", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Lcom/live/evo/fragment/t1$b;", "tester", "Lcom/live/evo/fragment/t1;", "c", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/live/evo/fragment/t1$b;)Lcom/live/evo/fragment/t1;", "Landroid/app/Activity;", "a", "(Landroid/app/Activity;)Lcom/live/evo/fragment/t1$b;", "Lkotlin/Function1;", "", "Lr8/z;", "callback", "f", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/live/evo/fragment/t1$b;Lc9/l;)V", "isShow", "Z", "b", "()Z", "e", "(Z)V", "Ljava/lang/ref/SoftReference;", "dialogSrf", "Ljava/lang/ref/SoftReference;", "getDialogSrf", "()Ljava/lang/ref/SoftReference;", "d", "(Ljava/lang/ref/SoftReference;)V", "", "TAG", "Ljava/lang/String;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: renamed from: com.live.evo.fragment.t1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/live/evo/fragment/t1$a$a", "Lcom/live/evo/fragment/t1$b;", "Lkotlinx/coroutines/flow/f;", "", "a", "()Lkotlinx/coroutines/flow/f;", "b", "c", "isPlaying", "()Z", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0103a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f6812a;

            /* JADX INFO: renamed from: com.live.evo.fragment.t1$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.NetworkStatusDialogFragment$Companion$createNetworkTester$1$testBox2Internet$1", f = "NetworkStatusDialogFragment.kt", l = {64}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0104a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Boolean>, v8.f<? super r8.z>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                C0104a(v8.f<? super C0104a> fVar) {
                    super(2, fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    C0104a c0104a = new C0104a(fVar);
                    c0104a.L$0 = obj;
                    return c0104a;
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f<? super r8.z> fVar) {
                    return ((C0104a) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
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
                        kotlinx.coroutines.flow.g gVar = (kotlinx.coroutines.flow.g) this.L$0;
                        Boolean boolA = kotlin.coroutines.jvm.internal.b.a(of.e.f16588a.e().a(new okhttp3.b0.a().a("User-Agent", "stagefright/1.2 (Linux;Android 4.2.2)").k("https://www.bing.com").b()).execute().n());
                        this.label = 1;
                        if (gVar.emit(boolA, this) == objC) {
                            return objC;
                        }
                    }
                    return r8.z.f17874a;
                }
            }

            C0103a(Activity activity) {
                this.f6812a = activity;
            }

            @Override // com.live.evo.fragment.t1.b
            public kotlinx.coroutines.flow.f<Boolean> a() {
                return kotlinx.coroutines.flow.h.w(Boolean.valueOf(com.live.evo.util.t0.a(this.f6812a)));
            }

            @Override // com.live.evo.fragment.t1.b
            public kotlinx.coroutines.flow.f<Boolean> b() {
                return kotlinx.coroutines.flow.h.v(new C0104a(null));
            }

            @Override // com.live.evo.fragment.t1.b
            public kotlinx.coroutines.flow.f<Boolean> c() {
                return kotlinx.coroutines.flow.h.w(Boolean.TRUE);
            }

            @Override // com.live.evo.fragment.t1.b
            public boolean isPlaying() {
                Activity activity = this.f6812a;
                if (activity instanceof LiveNewActivity) {
                    return ((LiveNewActivity) activity).d3();
                }
                return false;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        private final t1 c(AppCompatActivity activity, b tester) {
            t1 t1Var = new t1();
            t1Var.tester = tester;
            t1Var.activityReference = new SoftReference(activity);
            d(new SoftReference<>(t1Var));
            return t1Var;
        }

        public final b a(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            return new C0103a(activity);
        }

        public final void f(AppCompatActivity activity, b tester, c9.l<? super Boolean, r8.z> callback) {
            kotlin.jvm.internal.m.f(activity, "activity");
            kotlin.jvm.internal.m.f(callback, "callback");
            if (x1.f1.lb.util.d0.f21360a.j() || tester == null || b()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag("NetworkStatusDialogFragment");
                if (fragmentFindFragmentByTag != null) {
                    fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
                }
                fragmentTransactionBeginTransaction.addToBackStack(null);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                FragmentTransaction fragmentTransactionBeginTransaction2 = supportFragmentManager.beginTransaction();
                t1 t1VarC = c(activity, tester);
                t1VarC.R0(callback);
                t1VarC.show(fragmentTransactionBeginTransaction2, "NetworkStatusDialogFragment");
                e(true);
                t1VarC.G0();
            } catch (IllegalStateException unused) {
            }
        }

        public final boolean b() {
            return t1.B;
        }

        public final void d(SoftReference<t1> softReference) {
            t1.C = softReference;
        }

        public final void e(boolean z10) {
            t1.B = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/live/evo/fragment/t1$b;", "", "Lkotlinx/coroutines/flow/f;", "", "a", "()Lkotlinx/coroutines/flow/f;", "b", "c", "isPlaying", "()Z", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        kotlinx.coroutines.flow.f<Boolean> a();

        kotlinx.coroutines.flow.f<Boolean> b();

        kotlinx.coroutines.flow.f<Boolean> c();

        boolean isPlaying();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.NetworkStatusDialogFragment$checkNetworkStatus$2", f = "NetworkStatusDialogFragment.kt", l = {477}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.NetworkStatusDialogFragment$checkNetworkStatus$2$1", f = "NetworkStatusDialogFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "t", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Boolean>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ t1 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(t1 t1Var, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = t1Var;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.this$0.S0((Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ t1 f6813a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.NetworkStatusDialogFragment$checkNetworkStatus$2$2$2", f = "NetworkStatusDialogFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "t", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Boolean>, Throwable, v8.f<? super r8.z>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ t1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(t1 t1Var, v8.f<? super a> fVar) {
                    super(3, fVar);
                    this.this$0 = t1Var;
                }

                @Override // c9.q
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                    a aVar = new a(this.this$0, fVar);
                    aVar.L$0 = th;
                    return aVar.invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        this.this$0.S0((Throwable) this.L$0);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.live.evo.fragment.t1$c$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0105b<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ t1 f6814a;

                /* JADX INFO: renamed from: com.live.evo.fragment.t1$c$b$b$a */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.NetworkStatusDialogFragment$checkNetworkStatus$2$2$3$2", f = "NetworkStatusDialogFragment.kt", l = {}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "t", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
                static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Boolean>, Throwable, v8.f<? super r8.z>, Object> {
                    /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ t1 this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    a(t1 t1Var, v8.f<? super a> fVar) {
                        super(3, fVar);
                        this.this$0 = t1Var;
                    }

                    @Override // c9.q
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                        a aVar = new a(this.this$0, fVar);
                        aVar.L$0 = th;
                        return aVar.invokeSuspend(r8.z.f17874a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        kotlin.coroutines.intrinsics.b.c();
                        if (this.label == 0) {
                            r8.r.b(obj);
                            this.this$0.S0((Throwable) this.L$0);
                            return r8.z.f17874a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* JADX INFO: renamed from: com.live.evo.fragment.t1$c$b$b$b, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                static final class C0106b<T> implements kotlinx.coroutines.flow.g {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ t1 f6815a;

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void d(boolean z10, t1 t1Var) {
                        try {
                            if (z10) {
                                ImageView imageView = t1Var.imgInternetToServerStatus;
                                if (imageView != null) {
                                    imageView.setVisibility(0);
                                }
                                VodLoadAnimation vodLoadAnimation = t1Var.aniInternetToServerLoading;
                                if (vodLoadAnimation != null) {
                                    vodLoadAnimation.setVisibility(8);
                                }
                                ImageView imageView2 = t1Var.imgInternetToServerStatus;
                                if (imageView2 != null) {
                                    imageView2.setImageResource(R$drawable.pass);
                                }
                                ImageView imageView3 = t1Var.imgInternetToServerL2;
                                if (imageView3 != null) {
                                    imageView3.setImageResource(R$drawable.detected);
                                }
                                TextView textView = t1Var.txtTestResult;
                                if (textView != null) {
                                    textView.setText(2131953047);
                                }
                                t1Var.retryIntervalSeconds = 6;
                                t1Var.I0();
                            } else {
                                ImageView imageView4 = t1Var.imgInternetToServerStatus;
                                if (imageView4 != null) {
                                    imageView4.setVisibility(0);
                                }
                                VodLoadAnimation vodLoadAnimation2 = t1Var.aniInternetToServerLoading;
                                if (vodLoadAnimation2 != null) {
                                    vodLoadAnimation2.setVisibility(8);
                                }
                                ImageView imageView5 = t1Var.imgInternetToServerStatus;
                                if (imageView5 != null) {
                                    imageView5.setImageResource(R$drawable.fail);
                                }
                                TextView textView2 = t1Var.txtTestResult;
                                if (textView2 != null) {
                                    textView2.setText(String.format("%s", com.live.evo.util.x1.j(2131952547)));
                                }
                                t1Var.P0();
                            }
                            BaseButton baseButton = t1Var.btnCheck;
                            if (baseButton != null) {
                                baseButton.setEnabled(true);
                            }
                            t1Var.isConnected = z10;
                        } catch (Exception e10) {
                            c5.b.c(t1Var.logger, e10, "show internetToServerStatus error");
                        }
                    }

                    C0106b(t1 t1Var) {
                        this.f6815a = t1Var;
                    }

                    public final Object c(final boolean z10, v8.f<? super r8.z> fVar) {
                        final t1 t1Var = this.f6815a;
                        t1Var.Q0(new Runnable() { // from class: com.live.evo.fragment.w1
                            @Override // java.lang.Runnable
                            public final void run() {
                                t1.c.b.C0105b.C0106b.d(z10, t1Var);
                            }
                        });
                        return r8.z.f17874a;
                    }

                    @Override // kotlinx.coroutines.flow.g
                    public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                        return c(((Boolean) obj).booleanValue(), fVar);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(boolean z10, t1 t1Var) {
                    try {
                        if (!z10) {
                            VodLoadAnimation vodLoadAnimation = t1Var.aniHubToInternetLoading;
                            if (vodLoadAnimation != null) {
                                vodLoadAnimation.setVisibility(8);
                            }
                            ImageView imageView = t1Var.imgHubToInternetStatus;
                            if (imageView != null) {
                                imageView.setVisibility(0);
                            }
                            ImageView imageView2 = t1Var.imgHubToInternetStatus;
                            if (imageView2 != null) {
                                imageView2.setImageResource(R$drawable.fail);
                            }
                            BaseButton baseButton = t1Var.btnCheck;
                            if (baseButton != null) {
                                baseButton.setEnabled(true);
                            }
                            t1Var.P0();
                            return;
                        }
                        VodLoadAnimation vodLoadAnimation2 = t1Var.aniHubToInternetLoading;
                        if (vodLoadAnimation2 != null) {
                            vodLoadAnimation2.setVisibility(8);
                        }
                        ImageView imageView3 = t1Var.imgHubToInternetStatus;
                        if (imageView3 != null) {
                            imageView3.setVisibility(0);
                        }
                        ImageView imageView4 = t1Var.imgHubToInternetStatus;
                        if (imageView4 != null) {
                            imageView4.setImageResource(R$drawable.pass);
                        }
                        ImageView imageView5 = t1Var.imgHubToInternetL2;
                        if (imageView5 != null) {
                            imageView5.setImageResource(R$drawable.detected);
                        }
                        ImageView imageView6 = t1Var.imgInternetToServerL1;
                        if (imageView6 != null) {
                            imageView6.setImageResource(R$drawable.detected);
                        }
                        ImageView imageView7 = t1Var.imgInternetToServerStatus;
                        if (imageView7 != null) {
                            imageView7.setVisibility(8);
                        }
                        VodLoadAnimation vodLoadAnimation3 = t1Var.aniInternetToServerLoading;
                        if (vodLoadAnimation3 != null) {
                            vodLoadAnimation3.setVisibility(0);
                        }
                    } catch (Exception e10) {
                        c5.b.c(t1Var.logger, e10, "show hubToInternetStatus error");
                    }
                }

                C0105b(t1 t1Var) {
                    this.f6814a = t1Var;
                }

                public final Object c(final boolean z10, v8.f<? super r8.z> fVar) {
                    b bVar;
                    kotlinx.coroutines.flow.f<Boolean> fVarC;
                    kotlinx.coroutines.flow.f fVarF;
                    final t1 t1Var = this.f6814a;
                    t1Var.Q0(new Runnable() { // from class: com.live.evo.fragment.v1
                        @Override // java.lang.Runnable
                        public final void run() {
                            t1.c.b.C0105b.d(z10, t1Var);
                        }
                    });
                    if (!z10 || (bVar = this.f6814a.tester) == null || (fVarC = bVar.c()) == null || (fVarF = kotlinx.coroutines.flow.h.f(fVarC, new a(this.f6814a, null))) == null) {
                        return r8.z.f17874a;
                    }
                    Object objCollect = fVarF.collect(new C0106b(this.f6814a), fVar);
                    return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
                }

                @Override // kotlinx.coroutines.flow.g
                public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                    return c(((Boolean) obj).booleanValue(), fVar);
                }
            }

            b(t1 t1Var) {
                this.f6813a = t1Var;
            }

            public final Object c(final boolean z10, v8.f<? super r8.z> fVar) {
                b bVar;
                kotlinx.coroutines.flow.f<Boolean> fVarB;
                kotlinx.coroutines.flow.f fVarF;
                final t1 t1Var = this.f6813a;
                t1Var.Q0(new Runnable() { // from class: com.live.evo.fragment.u1
                    @Override // java.lang.Runnable
                    public final void run() {
                        t1.c.b.d(t1Var, z10);
                    }
                });
                if (!z10 || (bVar = this.f6813a.tester) == null || (fVarB = bVar.b()) == null || (fVarF = kotlinx.coroutines.flow.h.f(fVarB, new a(this.f6813a, null))) == null) {
                    return r8.z.f17874a;
                }
                Object objCollect = fVarF.collect(new C0105b(this.f6813a), fVar);
                return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return c(((Boolean) obj).booleanValue(), fVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(t1 t1Var, boolean z10) {
                int i10;
                try {
                    VodLoadAnimation vodLoadAnimation = t1Var.aniBoxToHubLoading;
                    if (vodLoadAnimation != null) {
                        vodLoadAnimation.setVisibility(8);
                    }
                    ImageView imageView = t1Var.imgBoxToHubStatus;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    ImageView imageView2 = t1Var.imgBoxToHubStatus;
                    if (imageView2 != null) {
                        if (z10) {
                            i10 = R$drawable.pass;
                        } else {
                            i10 = R$drawable.fail;
                        }
                        imageView2.setImageResource(i10);
                    }
                    if (z10) {
                        ImageView imageView3 = t1Var.imgBoxToHubL2;
                        if (imageView3 != null) {
                            imageView3.setImageResource(R$drawable.detected);
                        }
                        ImageView imageView4 = t1Var.imgHubToInternetL1;
                        if (imageView4 != null) {
                            imageView4.setImageResource(R$drawable.detected);
                        }
                    } else {
                        BaseButton baseButton = t1Var.btnCheck;
                        if (baseButton != null) {
                            baseButton.setEnabled(true);
                        }
                        t1Var.P0();
                    }
                    ImageView imageView5 = t1Var.imgHubToInternetStatus;
                    if (imageView5 != null) {
                        imageView5.setVisibility(8);
                    }
                    VodLoadAnimation vodLoadAnimation2 = t1Var.aniHubToInternetLoading;
                    if (vodLoadAnimation2 != null) {
                        vodLoadAnimation2.setVisibility(0);
                    }
                } catch (Exception e10) {
                    c5.b.c(t1Var.logger, e10, "show boxToHubStatus error");
                }
            }
        }

        c(v8.f<? super c> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return t1.this.new c(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.f<Boolean> fVarA;
            kotlinx.coroutines.flow.f fVarF;
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
                b bVar = t1.this.tester;
                if (bVar != null && (fVarA = bVar.a()) != null && (fVarF = kotlinx.coroutines.flow.h.f(fVarA, new a(t1.this, null))) != null) {
                    b bVar2 = new b(t1.this);
                    this.label = 1;
                    if (fVarF.collect(bVar2, this) == objC) {
                        return objC;
                    }
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/fragment/t1$d", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f6816a;

        public d(e eVar) {
            this.f6816a = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f6816a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"com/live/evo/fragment/t1$e", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "", "a", "I", "getSeconds", "()I", "setSeconds", "(I)V", "seconds", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int seconds;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.NetworkStatusDialogFragment$retry$timerTask$1$run$1", f = "NetworkStatusDialogFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ t1 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(t1 t1Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = t1Var;
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
                    try {
                        this.this$0.dismissAllowingStateLoss();
                    } catch (Throwable unused) {
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
            b bVar = t1.this.tester;
            if (bVar != null && bVar.isPlaying()) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(t1.this, null), 3, null);
                return;
            }
            if (this.seconds != t1.this.retryIntervalSeconds) {
                final t1 t1Var = t1.this;
                t1Var.Q0(new Runnable() { // from class: com.live.evo.fragment.x1
                    @Override // java.lang.Runnable
                    public final void run() {
                        t1.e.b(t1Var, this);
                    }
                });
                this.seconds++;
            } else {
                if (t1.this.retryIntervalSeconds < 60) {
                    t1.this.retryIntervalSeconds += 6;
                }
                t1.this.G0();
                t1.this.M0();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(t1 t1Var, e eVar) {
            CharSequence text;
            BaseButton baseButton = t1Var.btnCheck;
            if (baseButton != null) {
                text = baseButton.getText();
            } else {
                text = null;
            }
            String strValueOf = String.valueOf(text);
            if (ua.n.b0(strValueOf, "(", 0, false, 6, null) > 0) {
                strValueOf = strValueOf.substring(0, ua.n.b0(strValueOf, "(", 0, false, 6, null));
                kotlin.jvm.internal.m.e(strValueOf, "substring(...)");
            }
            String str = strValueOf + "(" + (t1Var.retryIntervalSeconds - eVar.seconds) + ")";
            BaseButton baseButton2 = t1Var.btnCheck;
            if (baseButton2 != null) {
                baseButton2.setText(str);
            }
        }
    }

    private final synchronized void E0(boolean b10) {
        if (x1.f1.lb.util.d0.f21360a.j()) {
            I0();
            return;
        }
        c9.l<? super Boolean, r8.z> lVar = this.callback;
        if (lVar != null) {
            lVar.invoke(Boolean.valueOf(b10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(t1 t1Var) {
        try {
            t1Var.O0();
            ImageView imageView = t1Var.imgBoxToHubL1;
            if (imageView != null) {
                imageView.setImageResource(R$drawable.detected);
            }
            ImageView imageView2 = t1Var.imgBoxToHubStatus;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            VodLoadAnimation vodLoadAnimation = t1Var.aniBoxToHubLoading;
            if (vodLoadAnimation != null) {
                vodLoadAnimation.setVisibility(0);
            }
            TextView textView = t1Var.txtTestResult;
            if (textView != null) {
                textView.setText("......");
            }
            BaseButton baseButton = t1Var.btnCheck;
            if (baseButton != null) {
                baseButton.setEnabled(false);
            }
        } catch (Exception e10) {
            t1Var.logger.error("show init status error", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(t1 t1Var) {
        try {
            t1Var.dismiss();
            B = false;
            SoftReference<AppCompatActivity> softReference = t1Var.activityReference;
            AppCompatActivity appCompatActivity = softReference != null ? softReference.get() : null;
            if (appCompatActivity != null) {
                try {
                    if (!appCompatActivity.isFinishing() && !appCompatActivity.isDestroyed() && (appCompatActivity instanceof LiveNewActivity)) {
                        ((LiveNewActivity) appCompatActivity).Q3();
                    }
                } catch (Throwable th) {
                    c5.b.c(t1Var.logger, th, th.getMessage());
                    return;
                }
            }
            t1Var.E0(t1Var.isConnected);
        } catch (Exception e10) {
            t1Var.logger.error("close speed test dlg failure", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0() {
        Q0(new Runnable() { // from class: com.live.evo.fragment.n1
            @Override // java.lang.Runnable
            public final void run() {
                t1.H0(this.f6523a);
            }
        });
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0() {
        Q0(new Runnable() { // from class: com.live.evo.fragment.s1
            @Override // java.lang.Runnable
            public final void run() {
                t1.J0(this.f6627a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        Q0(new Runnable() { // from class: com.live.evo.fragment.r1
            @Override // java.lang.Runnable
            public final void run() {
                t1.N0(this.f6590a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(t1 t1Var) {
        BaseButton baseButton = t1Var.btnCheck;
        String strValueOf = String.valueOf(baseButton != null ? baseButton.getText() : null);
        if (ua.n.b0(strValueOf, "(", 0, false, 6, null) > 0) {
            String strSubstring = strValueOf.substring(0, ua.n.b0(strValueOf, "(", 0, false, 6, null));
            kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
            BaseButton baseButton2 = t1Var.btnCheck;
            if (baseButton2 != null) {
                baseButton2.setText(strSubstring);
            }
        }
    }

    private final void O0() {
        ImageView imageView = this.imgBoxToHubL1;
        if (imageView != null) {
            imageView.setImageResource(R$drawable.undetect);
        }
        ImageView imageView2 = this.imgBoxToHubL2;
        if (imageView2 != null) {
            imageView2.setImageResource(R$drawable.undetect);
        }
        ImageView imageView3 = this.imgHubToInternetL1;
        if (imageView3 != null) {
            imageView3.setImageResource(R$drawable.undetect);
        }
        ImageView imageView4 = this.imgHubToInternetL2;
        if (imageView4 != null) {
            imageView4.setImageResource(R$drawable.undetect);
        }
        ImageView imageView5 = this.imgInternetToServerL1;
        if (imageView5 != null) {
            imageView5.setImageResource(R$drawable.undetect);
        }
        ImageView imageView6 = this.imgInternetToServerL2;
        if (imageView6 != null) {
            imageView6.setImageResource(R$drawable.undetect);
        }
        ImageView imageView7 = this.imgBoxToHubStatus;
        if (imageView7 != null) {
            imageView7.setVisibility(0);
        }
        VodLoadAnimation vodLoadAnimation = this.aniBoxToHubLoading;
        if (vodLoadAnimation != null) {
            vodLoadAnimation.setVisibility(8);
        }
        ImageView imageView8 = this.imgBoxToHubStatus;
        if (imageView8 != null) {
            imageView8.setImageResource(R$drawable.unknown);
        }
        ImageView imageView9 = this.imgHubToInternetStatus;
        if (imageView9 != null) {
            imageView9.setVisibility(0);
        }
        VodLoadAnimation vodLoadAnimation2 = this.aniHubToInternetLoading;
        if (vodLoadAnimation2 != null) {
            vodLoadAnimation2.setVisibility(8);
        }
        ImageView imageView10 = this.imgHubToInternetStatus;
        if (imageView10 != null) {
            imageView10.setImageResource(R$drawable.unknown);
        }
        ImageView imageView11 = this.imgInternetToServerStatus;
        if (imageView11 != null) {
            imageView11.setVisibility(0);
        }
        VodLoadAnimation vodLoadAnimation3 = this.aniInternetToServerLoading;
        if (vodLoadAnimation3 != null) {
            vodLoadAnimation3.setVisibility(8);
        }
        ImageView imageView12 = this.imgInternetToServerStatus;
        if (imageView12 != null) {
            imageView12.setImageResource(R$drawable.unknown);
        }
        TextView textView = this.txtTestResult;
        if (textView != null) {
            textView.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        e eVar = new e();
        Timer timerA = u8.a.a("check_network", false);
        timerA.schedule(new d(eVar), 1000L, 1000L);
        this.timer = timerA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(final Throwable throwable) {
        Q0(new Runnable() { // from class: com.live.evo.fragment.q1
            @Override // java.lang.Runnable
            public final void run() {
                t1.T0(this.f6557a, throwable);
            }
        });
        c5.b.c(this.logger, throwable, "failed in network test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(t1 t1Var, Throwable th) {
        try {
            ImageView imageView = t1Var.imgInternetToServerStatus;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            VodLoadAnimation vodLoadAnimation = t1Var.aniInternetToServerLoading;
            if (vodLoadAnimation != null) {
                vodLoadAnimation.setVisibility(8);
            }
            ImageView imageView2 = t1Var.imgInternetToServerStatus;
            if (imageView2 != null) {
                imageView2.setImageResource(R$drawable.fail);
            }
            String str = String.format("%s:%s", th.getMessage(), com.live.evo.util.x1.j(2131952547));
            TextView textView = t1Var.txtTestResult;
            if (textView != null) {
                textView.setText(str);
            }
            BaseButton baseButton = t1Var.btnCheck;
            if (baseButton != null) {
                baseButton.setEnabled(true);
            }
            t1Var.isConnected = false;
            t1Var.P0();
        } catch (Exception e10) {
            c5.b.c(t1Var.logger, e10, "show check result error");
        }
    }

    public final void R0(c9.l<? super Boolean, r8.z> callback) {
        kotlin.jvm.internal.m.f(callback, "callback");
        this.callback = callback;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.network_status_dialog, container, false);
        this.rootView = viewInflate;
        this.tvNetwork = (TextView) viewInflate.findViewById(R$id.networkstatusdlg_tv_diagnostics);
        this.imgBoxToHubL1 = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_box_to_hub_l1);
        this.imgBoxToHubL2 = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_box_to_hub_l2);
        this.imgHubToInternetL1 = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_hub_to_internet_l1);
        this.imgHubToInternetL2 = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_hub_to_internet_l2);
        this.imgInternetToServerL1 = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_internet_to_server_l1);
        this.imgInternetToServerL2 = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_internet_to_server_l2);
        this.imgBoxToHubStatus = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_box_to_hub_status);
        this.imgHubToInternetStatus = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_hub_to_internet_status);
        this.imgInternetToServerStatus = (ImageView) viewInflate.findViewById(R$id.networkstatusdlg_iv_internet_to_server_status);
        this.aniBoxToHubLoading = (VodLoadAnimation) viewInflate.findViewById(R$id.networkstatusdlg_vla_box_to_hub_loading);
        this.aniHubToInternetLoading = (VodLoadAnimation) viewInflate.findViewById(R$id.networkstatusdlg_vla_hub_to_internet_loading);
        this.aniInternetToServerLoading = (VodLoadAnimation) viewInflate.findViewById(R$id.networkstatusdlg_vla_internet_to_server_loading);
        this.txtTestResult = (TextView) viewInflate.findViewById(R$id.networkstatusdlg_tv_test_result);
        this.btnCheck = (BaseButton) viewInflate.findViewById(R$id.networkstatusdlg_btn_check);
        BaseButton baseButton = (BaseButton) viewInflate.findViewById(R$id.networkstatusdlg_btn_cancel);
        this.btnCancel = baseButton;
        if (baseButton != null) {
            baseButton.setOnFocusChangeListener(this);
        }
        BaseButton baseButton2 = this.btnCheck;
        if (baseButton2 != null) {
            baseButton2.setOnFocusChangeListener(this);
        }
        BaseButton baseButton3 = this.btnCheck;
        if (baseButton3 != null) {
            baseButton3.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.fragment.o1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t1.K0(this.f6526a, view);
                }
            });
        }
        BaseButton baseButton4 = this.btnCancel;
        if (baseButton4 != null) {
            baseButton4.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.fragment.p1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t1.L0(this.f6530a, view);
                }
            });
        }
        BaseButton baseButton5 = this.btnCheck;
        if (baseButton5 != null) {
            baseButton5.setInputType(0);
        }
        BaseButton baseButton6 = this.btnCancel;
        if (baseButton6 != null) {
            baseButton6.setInputType(0);
        }
        com.live.evo.util.t.c(this.tvNetwork);
        com.live.evo.util.t.b(this.txtTestResult);
        com.live.evo.util.t.d(this.btnCheck);
        com.live.evo.util.t.d(this.btnCancel);
        kotlin.jvm.internal.m.c(viewInflate);
        return viewInflate;
    }

    @Override // com.live.evo.fragment.b, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        kotlin.jvm.internal.m.f(dialog, "dialog");
        B = false;
        super.onDismiss(dialog);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v10, boolean hasFocus) {
        if (hasFocus) {
            com.live.evo.util.z0.d(v10);
        } else {
            com.live.evo.util.z0.g(v10);
        }
    }

    public t1() {
        q6.b bVarD = q6.c.d(t1.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(t1 t1Var, View view) {
        t1Var.M0();
        t1Var.G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(t1 t1Var, View view) {
        t1Var.F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(Runnable runnable) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        try {
            activity.runOnUiThread(runnable);
        } catch (Throwable unused) {
        }
    }

    public final void F0() {
        M0();
        I0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, 0);
    }
}
