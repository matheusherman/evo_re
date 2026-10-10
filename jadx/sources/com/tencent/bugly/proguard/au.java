package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static au f8863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ac f8864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private aa f8865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private as f8866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f8867e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            au.a(au.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Thread f8869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f8872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f8873e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f8874f;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (au.f8863a == null) {
                    al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                } else {
                    au.a(au.f8863a, this.f8869a, this.f8870b, this.f8871c, this.f8872d, this.f8873e, this.f8874f);
                }
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Crash error %s %s %s", this.f8871c, this.f8872d, this.f8873e);
            }
        }

        b(Thread thread, int i10, String str, String str2, String str3, Map map) {
            this.f8869a = thread;
            this.f8870b = i10;
            this.f8871c = str;
            this.f8872d = str2;
            this.f8873e = str3;
            this.f8874f = map;
        }
    }

    public static au a(Context context) {
        if (f8863a == null) {
            f8863a = new au(context);
        }
        return f8863a;
    }

    private au(Context context) {
        at atVarA = at.a();
        if (atVarA == null) {
            return;
        }
        this.f8864b = ac.a();
        this.f8865c = aa.a(context);
        this.f8866d = atVarA.f8844s;
        this.f8867e = context;
        ak.a().a(new a());
    }

    public static void a(Thread thread, int i10, String str, String str2, String str3, Map<String, String> map) {
        ak.a().a(new b(thread, i10, str, str2, str3, map));
    }

    static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            auVar.f8865c.getClass();
            ap.a(cls, "sdkPackageName", "com.tencent.bugly");
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    static /* synthetic */ void a(au auVar, Thread thread, int i10, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        Thread threadCurrentThread = thread == null ? Thread.currentThread() : thread;
        if (i10 == 4) {
            str4 = "Unity";
        } else if (i10 == 5 || i10 == 6) {
            str4 = "Cocos";
        } else {
            if (i10 != 8) {
                al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i10));
                return;
            }
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!auVar.f8864b.b()) {
                al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean strategyBeanC = auVar.f8864b.c();
            if (!strategyBeanC.f8582f && auVar.f8864b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(str4, ap.a(), auVar.f8865c.f8667d, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i10 != 5 && i10 != 6) {
                if (i10 == 8 && !strategyBeanC.f8588l) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!strategyBeanC.f8587k) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i11 = i10 != 8 ? i10 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = auVar.f8865c.k();
            crashDetailBean.G = auVar.f8865c.j();
            crashDetailBean.H = auVar.f8865c.l();
            crashDetailBean.I = ab.b(auVar.f8867e);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.f8602b = i11;
            crashDetailBean.f8605e = auVar.f8865c.g();
            aa aaVar = auVar.f8865c;
            crashDetailBean.f8606f = aaVar.f8678o;
            crashDetailBean.f8607g = aaVar.q();
            crashDetailBean.f8613m = auVar.f8865c.f();
            crashDetailBean.f8614n = String.valueOf(str);
            crashDetailBean.f8615o = String.valueOf(str2);
            String str6 = "";
            if (str3 == null) {
                str5 = "";
            } else {
                String[] strArrSplit = str3.split("\n");
                if (strArrSplit.length > 0) {
                    str6 = strArrSplit[0];
                }
                str5 = str3;
            }
            crashDetailBean.f8616p = str6;
            crashDetailBean.f8617q = str5;
            crashDetailBean.f8618r = System.currentTimeMillis();
            crashDetailBean.f8621u = ap.c(crashDetailBean.f8617q.getBytes());
            crashDetailBean.f8626z = ap.a(auVar.f8865c.Q, at.f8832h);
            crashDetailBean.A = auVar.f8865c.f8667d;
            crashDetailBean.B = threadCurrentThread.getName() + "(" + threadCurrentThread.getId() + ")";
            crashDetailBean.L = auVar.f8865c.s();
            crashDetailBean.f8608h = auVar.f8865c.p();
            aa aaVar2 = auVar.f8865c;
            crashDetailBean.Q = aaVar2.f8657a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = auVar.f8865c.z();
            aa aaVar3 = auVar.f8865c;
            crashDetailBean.V = aaVar3.f8687x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = auVar.f8865c.y();
            crashDetailBean.f8625y = ao.a();
            if (crashDetailBean.S == null) {
                crashDetailBean.S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.S.putAll(map);
            }
            as.a(str4, ap.a(), auVar.f8865c.f8667d, threadCurrentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!auVar.f8866d.a(crashDetailBean, !at.a().C)) {
                auVar.f8866d.b(crashDetailBean, false);
            }
            al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}
