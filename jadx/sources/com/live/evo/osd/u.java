package com.live.evo.osd;

import android.app.Activity;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.live.evo.dialog.w;
import com.live.evo.dialog.x;
import com.live.evo.util.q1;
import com.live.evo.util.s0;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import i5.c0;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;
import x1.f1.lb.media.model.SubscribeItem;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001TB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J+\u0010\u0014\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0003J+\u0010\u001b\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\u0003J[\u0010+\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00172\b\u0010&\u001a\u0004\u0018\u00010\"2\b\u0010'\u001a\u0004\u0018\u00010\"2\b\u0010\u0013\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J+\u0010/\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020\u001d2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b/\u00100R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010LR\u0016\u0010O\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010QR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010Q¨\u0006U"}, d2 = {"Lcom/live/evo/osd/u;", "", "<init>", "()V", "Lr8/z;", "j", "Li5/c0;", "bean", "k", "(Li5/c0;)V", "Landroid/app/Activity;", "g", "()Landroid/app/Activity;", "i", "q", "liveActivity", "Landroid/os/Handler;", "handler", "Lcom/live/evo/osd/u$a;", "listener", "h", "(Landroid/app/Activity;Landroid/os/Handler;Lcom/live/evo/osd/u$a;)V", "m", "Li5/p;", "newBean", "oldBean", "Lcom/live/evo/dialog/x;", "o", "(Li5/p;Li5/c0;Lcom/live/evo/dialog/x;)V", "", "index", "l", "(I)V", "p", "", "channelName", "icon", "inAllPos", "channelId", "subscribeType", "Lcom/live/evo/osd/v;", "Lx1/f1/lb/media/model/SubscribeItem;", "subscribeItem", "s", "(Ljava/lang/String;Ljava/lang/String;ILi5/p;Ljava/lang/String;Ljava/lang/String;Lcom/live/evo/osd/v;Lx1/f1/lb/media/model/SubscribeItem;)V", "subscribeBean", NotificationCompat.CATEGORY_STATUS, "r", "(Li5/c0;ILx1/f1/lb/media/model/SubscribeItem;)V", "Lq6/b;", "b", "Lq6/b;", "logger", "Ljava/lang/ref/SoftReference;", "c", "Ljava/lang/ref/SoftReference;", "mLiveActivitySoftReference", "d", "Landroid/os/Handler;", "mHandler", "Lcom/live/evo/dialog/w;", "e", "Lcom/live/evo/dialog/w;", "switchDialog", "", "f", "Ljava/util/List;", "mSubscribeList", "Li5/c0;", "mSubscribeBean", "Ljava/util/Timer;", "Ljava/util/Timer;", "mSubscribeTimer", "Ljava/util/TimerTask;", "Ljava/util/TimerTask;", "mTimerTask", "Lcom/live/evo/osd/u$a;", "subscribeManagerListener", "I", "playIndex", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "showPopupWindowRunnable", "dismissPopupWindowRunnable", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f7147a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static SoftReference<Activity> mLiveActivitySoftReference;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static Handler mHandler;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static w switchDialog;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final List<c0> mSubscribeList;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static c0 mSubscribeBean;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static Timer mSubscribeTimer;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static TimerTask mTimerTask;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static a subscribeManagerListener;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static int playIndex;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final Runnable showPopupWindowRunnable;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final Runnable dismissPopupWindowRunnable;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/live/evo/osd/u$a;", "", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.osd.SubscribeManager$removeSubscribeBean$1", f = "SubscribeManager.kt", l = {110}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ c0 $bean;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(c0 c0Var, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$bean = c0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$bean, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                String strA = this.$bean.a();
                kotlin.jvm.internal.m.e(strA, "getChannelId(...)");
                int i11 = Integer.parseInt(strA);
                Long lH = this.$bean.h();
                kotlin.jvm.internal.m.e(lH, "getStartTime(...)");
                long jLongValue = lH.longValue();
                String strD = this.$bean.d();
                kotlin.jvm.internal.m.e(strD, "getEpgId(...)");
                this.label = 1;
                if (t.v.c.i.a.K0(aVar, i11, jLongValue, strD, null, this, 8, null) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/osd/u$c", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler handler = u.mHandler;
            kotlin.jvm.internal.m.c(handler);
            handler.post(u.showPopupWindowRunnable);
        }
    }

    static {
        q6.b bVarD = q6.c.d(u.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        mSubscribeList = new ArrayList();
        showPopupWindowRunnable = new Runnable() { // from class: com.live.evo.osd.r
            @Override // java.lang.Runnable
            public final void run() {
                u.n();
            }
        };
        dismissPopupWindowRunnable = new Runnable() { // from class: com.live.evo.osd.s
            @Override // java.lang.Runnable
            public final void run() {
                u.f();
            }
        };
    }

    private final Activity g() {
        SoftReference<Activity> softReference = mLiveActivitySoftReference;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    private final void j() {
        try {
            c0 c0Var = mSubscribeBean;
            if (c0Var != null) {
                kotlin.jvm.internal.m.c(c0Var);
                k(c0Var);
            }
        } catch (Exception e10) {
            logger.error("removeSubscribeBean error", e10);
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        u uVar = f7147a;
        Activity activityG = uVar.g();
        c0 c0Var = mSubscribeBean;
        kotlin.jvm.internal.m.c(c0Var);
        if (c0Var.f() != playIndex || (activityG != null && !com.live.evo.util.b.a(activityG, activityG.getClass().getName()))) {
            uVar.m();
        }
        uVar.j();
    }

    private final void q() {
        try {
            Timer timer = mSubscribeTimer;
            if (timer != null) {
                kotlin.jvm.internal.m.c(timer);
                timer.cancel();
                Timer timer2 = mSubscribeTimer;
                kotlin.jvm.internal.m.c(timer2);
                timer2.purge();
                mSubscribeTimer = null;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z u(v vVar, c0 subscribeBean) {
        kotlin.jvm.internal.m.f(subscribeBean, "subscribeBean");
        if (vVar != null) {
            vVar.onUpdate();
        }
        return z.f17874a;
    }

    public final void h(Activity liveActivity, Handler handler, a listener) {
        mLiveActivitySoftReference = new SoftReference<>(liveActivity);
        mHandler = handler;
        subscribeManagerListener = listener;
        i();
    }

    public final void l(int index) {
        playIndex = index;
    }

    public final void o(i5.p newBean, c0 oldBean, x listener) {
        w wVar = switchDialog;
        if (wVar == null) {
            return;
        }
        wVar.g(newBean, oldBean);
        if (!wVar.e() && com.live.evo.util.b.b(g())) {
            wVar.f(listener);
            wVar.h();
        }
    }

    public final void r(c0 subscribeBean, int status, SubscribeItem subscribeItem) {
        if (subscribeBean == null) {
            return;
        }
        s0.f7342a.X(subscribeBean, subscribeItem);
    }

    public final void s(String channelName, String icon, int inAllPos, i5.p bean, String channelId, String subscribeType, final v listener, SubscribeItem subscribeItem) {
        kotlin.jvm.internal.m.f(channelName, "channelName");
        if (bean == null || channelId == null) {
            return;
        }
        s0 s0Var = s0.f7342a;
        if (icon == null) {
            icon = "";
        }
        s0Var.W(channelName, icon, inAllPos, bean, channelId, MessageOriginChannel.MESSAGE_ORIGIN_TYPE, new c9.l() { // from class: com.live.evo.osd.t
            @Override // c9.l
            public final Object invoke(Object obj) {
                return u.u(listener, (c0) obj);
            }
        }, subscribeItem);
    }

    private u() {
    }

    private final void i() {
        Activity activityG = g();
        if (activityG == null) {
            return;
        }
        switchDialog = new w(activityG);
    }

    private final void k(c0 bean) {
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new b(bean, null), 3, null);
    }

    public final void m() {
        xe.c.c().o(new b5.k(mSubscribeBean));
    }

    public final void p() {
        try {
            q();
            List<c0> list = mSubscribeList;
            kotlin.jvm.internal.m.c(list);
            if (!list.isEmpty()) {
                c0 c0Var = list.get(0);
                mSubscribeBean = c0Var;
                kotlin.jvm.internal.m.c(c0Var);
                Long lH = c0Var.h();
                c0 c0Var2 = mSubscribeBean;
                kotlin.jvm.internal.m.c(c0Var2);
                c0Var2.j();
                long jLongValue = lH.longValue() - q1.b();
                long j10 = 1000;
                if (jLongValue > 0) {
                    long j11 = jLongValue - ((long) 120000);
                    if (j11 > 0) {
                        j10 = j11;
                    }
                }
                mSubscribeTimer = new Timer();
                TimerTask timerTask = mTimerTask;
                if (timerTask != null) {
                    kotlin.jvm.internal.m.c(timerTask);
                    timerTask.cancel();
                }
                mTimerTask = new c();
                Timer timer = mSubscribeTimer;
                kotlin.jvm.internal.m.c(timer);
                timer.schedule(mTimerTask, j10);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
    }
}
