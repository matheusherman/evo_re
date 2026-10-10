package x1.f1.lb.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Printer;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010\"R\u001c\u0010'\u001a\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lx1/f1/lb/util/c;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lr8/z;", "p", "(Landroid/content/Context;)V", "t", "", "milliSeconds", "s", "(I)V", "frames", "r", "Landroid/app/Application;", "application", "n", "(Landroid/app/Application;)V", "Landroid/app/Activity;", "j", "()Landroid/app/Activity;", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "k", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "i", "(Landroid/content/Context;)Landroid/app/Activity;", "Landroid/view/View;", "view", "", "m", "(Landroid/view/View;)Ljava/lang/String;", "l", "(Landroid/view/View;)Landroid/view/View;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Landroid/app/Application$ActivityLifecycleCallbacks;", "c", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "Ljava/lang/ref/SoftReference;", "d", "Ljava/lang/ref/SoftReference;", "currentActivity", "Lx1/f1/lb/util/j0$a;", "e", "Lx1/f1/lb/util/j0$a;", "currentIFirebaseAnalyticsProvider", "f", "I", "gtMainThreadBlockIntervalMilliSecondsLog", "g", "gtDroppedFramesLog", "", "h", "Z", "o", "()Z", "q", "(Z)V", "isActivityResumed", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f21341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Application.ActivityLifecycleCallbacks callback;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static SoftReference<Activity> currentActivity;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static j0.a currentIFirebaseAnalyticsProvider;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int gtMainThreadBlockIntervalMilliSecondsLog;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int gtDroppedFramesLog;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isActivityResumed;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"x1/f1/lb/util/c$a", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "p0", "Landroid/os/Bundle;", "p1", "Lr8/z;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "onActivityDestroyed", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity p10, Bundle p11) {
            kotlin.jvm.internal.m.f(p10, "p0");
            if (p11 != null) {
                c.f21341a.p(p10);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity p10) {
            SoftReference softReference;
            kotlin.jvm.internal.m.f(p10, "p0");
            SoftReference softReference2 = c.currentActivity;
            if (!kotlin.jvm.internal.m.a(softReference2 != null ? (Activity) softReference2.get() : null, p10) || (softReference = c.currentActivity) == null) {
                return;
            }
            softReference.clear();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            c.f21341a.q(false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            c cVar = c.f21341a;
            c.currentActivity = new SoftReference(p10);
            c.f21341a.q(true);
            if (p10 instanceof j0.a) {
                c.currentIFirebaseAnalyticsProvider = (j0.a) p10;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity p10, Bundle p11) {
            kotlin.jvm.internal.m.f(p10, "p0");
            kotlin.jvm.internal.m.f(p11, "p1");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"x1/f1/lb/util/c$b", "Landroid/util/Printer;", "", "x", "Lr8/z;", "println", "(Ljava/lang/String;)V", "", "a", "J", "getStartWorkMillis", "()J", "setStartWorkMillis", "(J)V", "startWorkMillis", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long startWorkMillis;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicLong f21350b;

        b(AtomicLong atomicLong) {
            this.f21350b = atomicLong;
        }

        @Override // android.util.Printer
        public void println(String x10) {
            kotlin.jvm.internal.m.f(x10, "x");
            if (ua.n.I(x10, ">>>>> Dispatching to Handler", false, 2, null)) {
                this.startWorkMillis = d1.c();
                return;
            }
            if (this.startWorkMillis <= 0 || !ua.n.I(x10, "<<<<< Finished to Handler", false, 2, null)) {
                return;
            }
            long jC = d1.c();
            long jC2 = d1.c() - this.startWorkMillis;
            if (jC2 <= c.gtMainThreadBlockIntervalMilliSecondsLog || jC - this.f21350b.get() <= 2000) {
                return;
            }
            this.f21350b.set(jC);
            q6.b bVar = c.logger;
            kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
            String str = String.format("main thread execution time is too long: [{} ms] task: %s", Arrays.copyOf(new Object[]{x10}, 1));
            kotlin.jvm.internal.m.e(str, "format(...)");
            bVar.a(str, Long.valueOf(jC2));
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.util.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"x1/f1/lb/util/c$c", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "Lr8/z;", "doFrame", "(J)V", "a", "J", "lastFrameTimeNanos", "b", "idealFrameDurationNanos", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChoreographerFrameCallbackC0465c implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long lastFrameTimeNanos;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long idealFrameDurationNanos = TimeUnit.MILLISECONDS.toNanos(16);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicLong f21353c;

        ChoreographerFrameCallbackC0465c(AtomicLong atomicLong) {
            this.f21353c = atomicLong;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            String strName;
            String streamId;
            int i10;
            Activity activity;
            Window window;
            Activity activity2;
            Activity activity3;
            if (this.lastFrameTimeNanos != 0) {
                long jC = d1.c();
                if (jC - this.f21353c.get() > 2000) {
                    this.f21353c.set(jC);
                    long j10 = frameTimeNanos - this.lastFrameTimeNanos;
                    long j11 = this.idealFrameDurationNanos;
                    long j12 = ((j10 - j11) / j11) - 1;
                    if (j12 > c.gtDroppedFramesLog) {
                        SoftReference softReference = c.currentActivity;
                        View decorView = null;
                        String canonicalName = (softReference == null || (activity3 = (Activity) softReference.get()) == null) ? null : activity3.getClass().getCanonicalName();
                        c cVar = c.f21341a;
                        SoftReference softReference2 = c.currentActivity;
                        String strM = cVar.m((softReference2 == null || (activity2 = (Activity) softReference2.get()) == null) ? null : activity2.getCurrentFocus());
                        SoftReference softReference3 = c.currentActivity;
                        if (softReference3 != null && (activity = (Activity) softReference3.get()) != null && (window = activity.getWindow()) != null) {
                            decorView = window.getDecorView();
                        }
                        String strM2 = cVar.m(cVar.l(decorView));
                        boolean z10 = x1.f1.lb.widget.videoview.k.f21604a.g() != null;
                        x1.f1.lb.metric.monitor.f fVar = x1.f1.lb.metric.monitor.f.f20907a;
                        tf.d dVarI = fVar.i();
                        String strJ = "";
                        if (dVarI != null) {
                            streamId = dVarI.getStreamId();
                            strName = dVarI.s().name();
                        } else {
                            strName = "";
                            streamId = strName;
                        }
                        tf.c cVarH = fVar.h();
                        if (cVarH != null) {
                            int iD = cVarH.d();
                            strJ = cVarH.j();
                            i10 = iD;
                        } else {
                            i10 = -1;
                        }
                        c.logger.warn("FrameDropMonitor Dropped frames[" + j12 + "] [" + z10 + "][" + ((Object) strName) + "/" + ((Object) streamId) + "/" + ((Object) strJ) + "(" + i10 + ")] [" + canonicalName + "] tv[" + strM2 + "] fv[" + strM + "]", new Object[0]);
                    }
                }
            }
            this.lastFrameTimeNanos = frameTimeNanos;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    static {
        c cVar = new c();
        f21341a = cVar;
        logger = q6.c.d(cVar.getClass());
        gtMainThreadBlockIntervalMilliSecondsLog = 300;
        gtDroppedFramesLog = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Context context) {
        if (context == null) {
            return;
        }
        logger.a("restartApp triggered by: " + context.getClass().getSimpleName(), new Object[0]);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268468224);
            context.startActivity(launchIntentForPackage);
            if (context instanceof Activity) {
                ((Activity) context).finishAffinity();
            }
            Process.killProcess(Process.myPid());
        }
    }

    private final void t() {
        AtomicLong atomicLong = new AtomicLong(0L);
        Looper.getMainLooper().setMessageLogging(new b(atomicLong));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: x1.f1.lb.util.b
            @Override // java.lang.Runnable
            public final void run() {
                c.u();
            }
        });
        Choreographer.getInstance().postFrameCallback(new ChoreographerFrameCallbackC0465c(atomicLong));
    }

    public final Activity i(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final Activity j() {
        SoftReference<Activity> softReference = currentActivity;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public final FirebaseAnalytics k() {
        j0.a aVar = currentIFirebaseAnalyticsProvider;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public final View l(View view) {
        View viewL;
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (-1 < childCount) {
                    viewL = l(viewGroup.getChildAt(childCount));
                }
            } while (viewL == null);
            return viewL;
        }
        return view;
    }

    public final String m(View view) {
        String str = "";
        if (view == null) {
            return "";
        }
        try {
            String canonicalName = view.getClass().getCanonicalName();
            if (canonicalName != null) {
                str = canonicalName;
            }
            String resourceEntryName = view.getResources().getResourceEntryName(view.getId());
            kotlin.jvm.internal.m.c(resourceEntryName);
            if (resourceEntryName.length() > 0) {
                return str + "#" + resourceEntryName;
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public final void n(Application application) {
        kotlin.jvm.internal.m.f(application, "application");
        a aVar = new a();
        callback = aVar;
        application.registerActivityLifecycleCallbacks(aVar);
        t();
    }

    public final boolean o() {
        return isActivityResumed;
    }

    public final void q(boolean z10) {
        isActivityResumed = z10;
    }

    public final void r(int frames) {
        gtDroppedFramesLog = frames;
    }

    public final void s(int milliSeconds) {
        gtMainThreadBlockIntervalMilliSecondsLog = milliSeconds;
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0004 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0000, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void u() {
        while (true) {
            Looper.loop();
        }
    }
}
