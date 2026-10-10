package com.live.evo.fragment.subjuect;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.fragment.y1;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;
import x1.f1.lb.util.e0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 q2\u00020\u0001:\u0001rB%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J-\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010\u0010J\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010\u0010J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010\u0016J\r\u0010$\u001a\u00020\f¢\u0006\u0004\b$\u0010\u0010J\r\u0010%\u001a\u00020\f¢\u0006\u0004\b%\u0010\u0010J\u0019\u0010(\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\f¢\u0006\u0004\b*\u0010\u0010J\u0017\u0010+\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b+\u0010,R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010F\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010BR\u0018\u0010I\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u0004\u0018\u00010S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010f\u001a\u00020_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010aR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006s"}, d2 = {"Lcom/live/evo/fragment/subjuect/c0;", "Lcom/live/evo/fragment/d;", "Lcom/live/evo/osd/persenter/a;", "presenter", "Lcom/live/evo/fragment/y1;", "onEventListener", "Lb5/b;", "callEvent", "<init>", "(Lcom/live/evo/osd/persenter/a;Lcom/live/evo/fragment/y1;Lb5/b;)V", "Landroid/view/View;", "mRoot", "Lr8/z;", "h0", "(Landroid/view/View;)V", "q0", "()V", "g0", "f0", "", "bVisible", "m0", "(Z)V", "o0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "onDestroyView", "isVisibleToUser", "setUserVisibleHint", "j0", "r0", "Lb5/j;", NotificationCompat.CATEGORY_EVENT, "onSubjectUpdateEvent", "(Lb5/j;)V", "l0", "n0", "(Lb5/b;)V", "Lq6/b;", "f", "Lq6/b;", "logger", "Landroid/widget/FrameLayout;", "g", "Landroid/widget/FrameLayout;", "subject_match_fl", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "kidsmode_show_tv", "Lcom/live/evo/fragment/subjuect/w;", "i", "Lcom/live/evo/fragment/subjuect/w;", "subjectMatchFragment", "", "j", "I", "position", "k", "Z", "isFirst", "l", "m", "isFocusRecomment", "n", "Lcom/live/evo/osd/persenter/a;", "mPresenter", "o", "Lcom/live/evo/fragment/y1;", "mOnEventListener", "p", "Lb5/b;", "mCallEvent", "q", "Landroid/view/View;", "mView", "Landroid/os/Handler;", "r", "Landroid/os/Handler;", "mHandle", "Ljava/util/TimerTask;", "s", "Ljava/util/TimerTask;", "hideTask", "Ljava/util/Timer;", "t", "Ljava/util/Timer;", "mTimer", "", "u", "J", "getTIME_DATA_UPDATE", "()J", "setTIME_DATA_UPDATE", "(J)V", "TIME_DATA_UPDATE", "Lj5/g;", "v", "Lj5/g;", "mSubjectTypeResponse", "w", "mStartShowTime", "Ljava/lang/Runnable;", "x", "Ljava/lang/Runnable;", "mRequestDataRunnable", "y", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c0 extends com.live.evo.fragment.d {

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f6675z = "position";

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private FrameLayout subject_match_fl;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView kidsmode_show_tv;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private w subjectMatchFragment;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isFirst;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isVisibleToUser;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isFocusRecomment;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.persenter.a mPresenter;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private y1 mOnEventListener;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private b5.b mCallEvent;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private View mView;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Handler mHandle;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private TimerTask hideTask;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Timer mTimer;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private long TIME_DATA_UPDATE;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private j5.g mSubjectTypeResponse;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private long mStartShowTime;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final Runnable mRequestDataRunnable;

    /* JADX INFO: renamed from: com.live.evo.fragment.subjuect.c0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/live/evo/fragment/subjuect/c0$a;", "", "<init>", "()V", "", "SUBJECT_POSITION", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final String a() {
            return c0.f6675z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/fragment/subjuect/c0$b", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (c0.this.subjectMatchFragment != null) {
                w wVar = c0.this.subjectMatchFragment;
                kotlin.jvm.internal.m.c(wVar);
                wVar.U0();
            }
        }
    }

    private final void g0() {
        this.mSubjectTypeResponse = null;
        List<j5.g> listF = com.live.evo.fragment.subjuect.b.c().f();
        if (listF != null) {
            int size = listF.size();
            int i10 = this.position;
            if (size > i10) {
                this.mSubjectTypeResponse = listF.get(i10);
            }
        }
    }

    private final void h0(View mRoot) {
        this.subject_match_fl = mRoot != null ? (FrameLayout) mRoot.findViewById(R$id.subject_match_fl) : null;
        this.kidsmode_show_tv = mRoot != null ? (TextView) mRoot.findViewById(R$id.kidsmode_show_tv) : null;
        long jH = com.live.evo.l.n().h("update_dualmeet_list_int", this.TIME_DATA_UPDATE);
        this.TIME_DATA_UPDATE = jH < 600 ? this.TIME_DATA_UPDATE : jH * ((long) 1000);
        q0();
    }

    private final void f0() {
        this.subjectMatchFragment = new w(this.mPresenter, this.mOnEventListener);
        Bundle bundle = new Bundle();
        bundle.putInt(f6675z, this.position);
        w wVar = this.subjectMatchFragment;
        kotlin.jvm.internal.m.c(wVar);
        wVar.setArguments(bundle);
        try {
            FragmentManager childFragmentManager = getChildFragmentManager();
            kotlin.jvm.internal.m.e(childFragmentManager, "getChildFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            w wVar2 = this.subjectMatchFragment;
            kotlin.jvm.internal.m.c(wVar2);
            fragmentTransactionBeginTransaction.replace(R$id.subject_match_fl, wVar2);
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(c0 c0Var) {
        w wVar = c0Var.subjectMatchFragment;
        if (wVar != null) {
            kotlin.jvm.internal.m.c(wVar);
            w.J0(wVar, null, 1, null);
            c0Var.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(c0 c0Var) {
        w wVar = c0Var.subjectMatchFragment;
        if (wVar != null) {
            kotlin.jvm.internal.m.c(wVar);
            wVar.M0();
            c0Var.o0();
        }
    }

    private final void m0(boolean bVisible) {
        if (this.mSubjectTypeResponse != null) {
            if (bVisible) {
                this.mStartShowTime = SystemClock.elapsedRealtime();
            } else {
                if (!this.isVisibleToUser || bVisible) {
                    return;
                }
                SystemClock.elapsedRealtime();
            }
        }
    }

    private final void o0() {
        Handler handler = this.mHandle;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(this.mRequestDataRunnable);
        long jH = com.live.evo.l.n().h("subject_refresh_time", TimeUnit.HOURS.toMillis(2L));
        if (jH <= 1800000) {
            jH = 1800000;
        }
        this.mHandle.postDelayed(this.mRequestDataRunnable, jH);
    }

    private final void q0() {
        if (this.kidsmode_show_tv == null || this.subject_match_fl == null) {
            return;
        }
        if (a5.b.a().b()) {
            TextView textView = this.kidsmode_show_tv;
            kotlin.jvm.internal.m.c(textView);
            if (textView.getVisibility() != 0) {
                TextView textView2 = this.kidsmode_show_tv;
                kotlin.jvm.internal.m.c(textView2);
                textView2.setVisibility(0);
            }
            FrameLayout frameLayout = this.subject_match_fl;
            kotlin.jvm.internal.m.c(frameLayout);
            if (frameLayout.getVisibility() != 8) {
                FrameLayout frameLayout2 = this.subject_match_fl;
                kotlin.jvm.internal.m.c(frameLayout2);
                frameLayout2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView3 = this.kidsmode_show_tv;
        kotlin.jvm.internal.m.c(textView3);
        if (textView3.getVisibility() != 8) {
            TextView textView4 = this.kidsmode_show_tv;
            kotlin.jvm.internal.m.c(textView4);
            textView4.setVisibility(8);
        }
        FrameLayout frameLayout3 = this.subject_match_fl;
        kotlin.jvm.internal.m.c(frameLayout3);
        if (frameLayout3.getVisibility() != 0) {
            FrameLayout frameLayout4 = this.subject_match_fl;
            kotlin.jvm.internal.m.c(frameLayout4);
            frameLayout4.setVisibility(0);
        }
    }

    public final void j0() {
        TimerTask timerTask = this.hideTask;
        if (timerTask != null) {
            kotlin.jvm.internal.m.c(timerTask);
            timerTask.cancel();
            this.hideTask = null;
        }
        b bVar = new b();
        this.hideTask = bVar;
        this.mTimer.schedule(bVar, this.TIME_DATA_UPDATE);
    }

    public final void l0() {
        w wVar = this.subjectMatchFragment;
        if (wVar != null) {
            kotlin.jvm.internal.m.c(wVar);
            List<j5.c> listN0 = wVar.N0();
            kotlin.jvm.internal.m.c(listN0);
            if (listN0.size() > 0) {
                w wVar2 = this.subjectMatchFragment;
                kotlin.jvm.internal.m.c(wVar2);
                wVar2.d1();
                this.isFocusRecomment = false;
                return;
            }
        }
        w wVar3 = this.subjectMatchFragment;
        kotlin.jvm.internal.m.c(wVar3);
        wVar3.d1();
        this.isFocusRecomment = false;
    }

    public final void n0(b5.b event) {
        if (event != null) {
            Locale locale = Locale.ROOT;
            String lowerCase = "subject_channel".toLowerCase(locale);
            kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
            String strB = event.b();
            kotlin.jvm.internal.m.e(strB, "getTopicTitle(...)");
            String lowerCase2 = strB.toLowerCase(locale);
            kotlin.jvm.internal.m.e(lowerCase2, "toLowerCase(...)");
            if (kotlin.jvm.internal.m.a(lowerCase, lowerCase2)) {
                w wVar = this.subjectMatchFragment;
                if (wVar == null || wVar == null) {
                    return;
                }
                wVar.k1();
                return;
            }
        }
        w wVar2 = this.subjectMatchFragment;
        if (wVar2 == null || this.isFocusRecomment || wVar2 == null) {
            return;
        }
        wVar2.k1();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        this.mView = inflater.inflate(R$layout.menu_fragment_subject, container, false);
        this.position = requireArguments().getInt(f6675z);
        h0(this.mView);
        g0();
        f0();
        Handler handler = this.mHandle;
        kotlin.jvm.internal.m.c(handler);
        handler.postDelayed(new Runnable() { // from class: com.live.evo.fragment.subjuect.a0
            @Override // java.lang.Runnable
            public final void run() {
                c0.k0(this.f6635a);
            }
        }, 1000L);
        return this.mView;
    }

    public final void r0() {
        TimerTask timerTask = this.hideTask;
        if (timerTask != null) {
            kotlin.jvm.internal.m.c(timerTask);
            timerTask.cancel();
            this.hideTask = null;
        }
    }

    public c0(com.live.evo.osd.persenter.a aVar, y1 y1Var, b5.b bVar) {
        q6.b bVarD = q6.c.d(c0.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        this.logger = bVarD;
        this.isFirst = true;
        this.mPresenter = aVar;
        this.mOnEventListener = y1Var;
        this.mCallEvent = bVar;
        this.mHandle = new Handler();
        this.mTimer = new Timer();
        this.TIME_DATA_UPDATE = 600000L;
        this.mRequestDataRunnable = new Runnable() { // from class: com.live.evo.fragment.subjuect.b0
            @Override // java.lang.Runnable
            public final void run() {
                c0.i0(this.f6648a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(c0 c0Var) {
        c0Var.q0();
        if (!a5.b.a().b()) {
            w wVar = c0Var.subjectMatchFragment;
            if (wVar != null) {
                kotlin.jvm.internal.m.c(wVar);
                wVar.S0();
            }
            w wVar2 = c0Var.subjectMatchFragment;
            if (wVar2 != null) {
                kotlin.jvm.internal.m.c(wVar2);
                wVar2.M0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.mRequestDataRunnable);
        }
        e0.f21385a.b(this);
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e0.f21385a.a(this);
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (!this.isFirst) {
                Handler handler = this.mHandle;
                kotlin.jvm.internal.m.c(handler);
                handler.post(new Runnable() { // from class: com.live.evo.fragment.subjuect.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.p0(this.f6785a);
                    }
                });
            } else {
                this.isFirst = false;
            }
        }
        m0(isVisibleToUser);
        w wVar = this.subjectMatchFragment;
        if (wVar != null && (isVisibleToUser || (this.isVisibleToUser && !isVisibleToUser))) {
            kotlin.jvm.internal.m.c(wVar);
            wVar.h1(isVisibleToUser);
        }
        if (isVisibleToUser) {
            j0();
        } else {
            r0();
        }
        this.isVisibleToUser = isVisibleToUser;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onSubjectUpdateEvent(b5.j event) {
    }
}
