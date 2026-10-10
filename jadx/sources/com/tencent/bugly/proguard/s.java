package com.tencent.bugly.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.stub.StubApp;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.r.c;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9119a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static r f9120b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f9121c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f9122d = 300000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f9123e = 30000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f9124f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f9125g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f9126h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f9127i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f9128j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f9129k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Class<?> f9130l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f9131m = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BuglyStrategy f9133b;

        a(Context context, BuglyStrategy buglyStrategy) {
            this.f9132a = context;
            this.f9133b = buglyStrategy;
        }

        @Override // java.lang.Runnable
        public final void run() {
            s.c(this.f9132a, this.f9133b);
        }
    }

    public static void a(Context context, BuglyStrategy buglyStrategy) {
        long appReportDelay;
        if (f9119a) {
            return;
        }
        f9131m = aa.a(context).f8669f;
        f9120b = new r(context, f9131m);
        f9119a = true;
        if (buglyStrategy != null) {
            f9130l = buglyStrategy.getUserInfoActivity();
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        if (appReportDelay <= 0) {
            c(context, buglyStrategy);
        } else {
            ak.a().a(new a(context, buglyStrategy), appReportDelay);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            if (s.f9130l == null || s.f9130l.getName().equals(name)) {
                al.c(">>> %s onCreated <<<", name);
                aa aaVarB = aa.b();
                if (aaVarB != null) {
                    aaVarB.L.add(s.a(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f9130l == null || s.f9130l.getName().equals(name)) {
                al.c(">>> %s onDestroyed <<<", name);
                aa aaVarB = aa.b();
                if (aaVarB != null) {
                    aaVarB.L.add(s.a(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f9130l == null || s.f9130l.getName().equals(name)) {
                al.c(">>> %s onPaused <<<", name);
                aa aaVarB = aa.b();
                if (aaVarB == null) {
                    return;
                }
                aaVarB.L.add(s.a(name, "onPaused"));
                long jCurrentTimeMillis = System.currentTimeMillis();
                aaVarB.A = jCurrentTimeMillis;
                aaVarB.B = jCurrentTimeMillis - aaVarB.f8689z;
                long unused = s.f9126h = jCurrentTimeMillis;
                if (aaVarB.B < 0) {
                    aaVarB.B = 0L;
                }
                aaVarB.f8688y = "background";
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f9130l == null || s.f9130l.getName().equals(name)) {
                al.c(">>> %s onResumed <<<", name);
                aa aaVarB = aa.b();
                if (aaVarB != null) {
                    aaVarB.L.add(s.a(name, "onResumed"));
                    aaVarB.f8688y = name;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    aaVarB.f8689z = jCurrentTimeMillis;
                    aaVarB.C = jCurrentTimeMillis - s.f9127i;
                    long j10 = aaVarB.f8689z - s.f9126h;
                    if (j10 > (s.f9124f > 0 ? s.f9124f : s.f9123e)) {
                        aaVarB.c();
                        s.g();
                        al.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j10 / 1000), Long.valueOf(s.f9123e / 1000));
                        if (s.f9125g % s.f9121c == 0) {
                            s.f9120b.a(4, s.f9131m);
                            return;
                        }
                        s.f9120b.a(4, false);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (jCurrentTimeMillis2 - s.f9128j > s.f9122d) {
                            long unused = s.f9128j = jCurrentTimeMillis2;
                            al.a("add a timer to upload hot start user info", new Object[0]);
                            if (s.f9131m) {
                                ak.a().a(s.f9120b.new c(null, true), s.f9122d);
                            }
                        }
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            al.c(">>> %s onStart <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            al.c(">>> %s onStop <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    static /* synthetic */ int g() {
        int i10 = f9125g;
        f9125g = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean zIsEnableUserInfo;
        boolean zRecordUserInfoOnceADay;
        if (buglyStrategy != null) {
            zRecordUserInfoOnceADay = buglyStrategy.recordUserInfoOnceADay();
            zIsEnableUserInfo = buglyStrategy.isEnableUserInfo();
        } else {
            zIsEnableUserInfo = true;
            zRecordUserInfoOnceADay = false;
        }
        if (zRecordUserInfoOnceADay) {
            aa aaVarA = aa.a(context);
            List<UserInfoBean> listA = r.a(aaVarA.f8667d);
            if (listA != null) {
                for (int i10 = 0; i10 < listA.size(); i10++) {
                    UserInfoBean userInfoBean = listA.get(i10);
                    if (userInfoBean.f8568n.equals(aaVarA.f8678o) && userInfoBean.f8556b == 1) {
                        long jB = ap.b();
                        if (jB <= 0) {
                            break;
                        }
                        if (userInfoBean.f8559e >= jB) {
                            if (userInfoBean.f8560f <= 0) {
                                f9120b.b();
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            zIsEnableUserInfo = false;
        }
        aa aaVarB = aa.b();
        if (aaVarB != null && z.a()) {
            aaVarB.a(0, true);
        }
        if (zIsEnableUserInfo) {
            Application application = StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application ? (Application) StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
            if (application != null) {
                try {
                    if (f9129k == null) {
                        f9129k = new b();
                    }
                    application.registerActivityLifecycleCallbacks(f9129k);
                } catch (Exception e10) {
                    if (!al.a(e10)) {
                        e10.printStackTrace();
                    }
                }
            }
        }
        if (f9131m) {
            f9127i = System.currentTimeMillis();
            f9120b.a(1, false);
            al.a("[session] launch app, new start", new Object[0]);
            f9120b.a();
            f9120b.a(21600000L);
        }
    }

    public static void a(long j10) {
        if (j10 < 0) {
            j10 = ac.a().c().f8592p;
        }
        f9124f = j10;
    }

    public static void a(StrategyBean strategyBean, boolean z10) {
        r rVar = f9120b;
        if (rVar != null && !z10) {
            rVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j10 = strategyBean.f8592p;
        if (j10 > 0) {
            f9123e = j10;
        }
        int i10 = strategyBean.f8597u;
        if (i10 > 0) {
            f9121c = i10;
        }
        long j11 = strategyBean.f8598v;
        if (j11 > 0) {
            f9122d = j11;
        }
    }

    public static void a() {
        r rVar = f9120b;
        if (rVar != null) {
            rVar.a(2, false);
        }
    }

    public static void a(Context context) {
        if (!f9119a || context == null) {
            return;
        }
        Application application = StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application ? (Application) StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
        if (application != null) {
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f9129k;
                if (activityLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            } catch (Exception e10) {
                if (!al.a(e10)) {
                    e10.printStackTrace();
                }
            }
        }
        f9119a = false;
    }

    static /* synthetic */ String a(String str, String str2) {
        return ap.a() + "  " + str + "  " + str2 + "\n";
    }
}
