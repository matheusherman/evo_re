package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9099a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<o> f9100b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f9101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static w f9102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f9103e;

    private static boolean a(aa aaVar) {
        List<String> list = aaVar.f8685v;
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        a(context, null);
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (f9103e) {
            al.d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            Log.w(al.f8762b, "[init] context of init() is null, check it.");
            return;
        }
        aa aaVarA = aa.a(context);
        if (a(aaVarA)) {
            f9099a = false;
            return;
        }
        String strE = aaVarA.e();
        if (strE == null) {
            Log.e(al.f8762b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
        } else {
            a(context, strE, aaVarA.D, buglyStrategy);
        }
    }

    public static synchronized void a(o oVar) {
        if (!f9100b.contains(oVar)) {
            f9100b.add(oVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    public static synchronized void a(Context context, String str, boolean z10, BuglyStrategy buglyStrategy) {
        ?? r16;
        ?? r17;
        byte[] bArr;
        char c10;
        if (f9103e) {
            al.d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == 0) {
            Log.w(al.f8762b, "[init] context is null, check it.");
            return;
        }
        if (str == null) {
            Log.e(al.f8762b, "init arg 'crashReportAppID' should not be null!");
            return;
        }
        f9103e = true;
        if (z10) {
            f9101c = true;
            al.f8763c = true;
            al.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
            al.e("--------------------------------------------------------------------------------------------", new Object[0]);
            al.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
            al.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
            al.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
            al.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
            al.e("--------------------------------------------------------------------------------------------", new Object[0]);
            al.b("[init] Open debug mode of Bugly.", new Object[0]);
        }
        al.a(" crash report start initializing...", new Object[0]);
        al.b("[init] Bugly start initializing...", new Object[0]);
        al.a("[init] Bugly complete version: v%s", "4.1.9.3");
        Context contextA = ap.a((Context) context);
        aa aaVarA = aa.a(contextA);
        aaVarA.o();
        ao.a(contextA);
        f9102d = w.a(contextA, f9100b);
        ai.a(contextA);
        ac.a(contextA, f9100b);
        u uVarA = u.a(contextA);
        if (a(aaVarA)) {
            f9099a = false;
            return;
        }
        aaVarA.f8681r = str;
        aaVarA.b("APP_ID", str);
        al.a("[param] Set APP ID:%s", str);
        if (buglyStrategy != null) {
            String appVersion = buglyStrategy.getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                if (appVersion.length() > 100) {
                    String strSubstring = appVersion.substring(0, 100);
                    al.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, strSubstring);
                    appVersion = strSubstring;
                }
                aaVarA.f8678o = appVersion;
                al.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
            }
            try {
                try {
                    if (buglyStrategy.isReplaceOldChannel()) {
                        String appChannel = buglyStrategy.getAppChannel();
                        if (TextUtils.isEmpty(appChannel)) {
                            context = 2;
                        } else {
                            if (appChannel.length() > 100) {
                                String strSubstring2 = appChannel.substring(0, 100);
                                c10 = 2;
                                al.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, strSubstring2);
                                appChannel = strSubstring2;
                            } else {
                                c10 = 2;
                            }
                            f9102d.a(556, "app_channel", appChannel.getBytes(), false);
                            aaVarA.f8682s = appChannel;
                            context = c10;
                        }
                    } else {
                        context = 2;
                        context = 2;
                        context = 2;
                        Map<String, byte[]> mapA = f9102d.a(556, (v) null);
                        if (mapA != null && (bArr = mapA.get("app_channel")) != null) {
                            aaVarA.f8682s = new String(bArr);
                        }
                    }
                    al.a("[param] Set App channel: %s", aaVarA.f8682s);
                    r17 = context;
                } catch (Exception e10) {
                    e = e10;
                    r16 = context;
                    r17 = r16;
                    if (f9101c) {
                        e.printStackTrace();
                        r17 = r16;
                    }
                }
            } catch (Exception e11) {
                e = e11;
                r16 = 2;
            }
            String appPackageName = buglyStrategy.getAppPackageName();
            if (!TextUtils.isEmpty(appPackageName)) {
                if (appPackageName.length() > 100) {
                    String strSubstring3 = appPackageName.substring(0, 100);
                    Object[] objArr = new Object[3];
                    objArr[0] = appPackageName;
                    objArr[1] = 100;
                    objArr[r17] = strSubstring3;
                    al.d("appPackageName %s length is over limit %d substring to %s", objArr);
                    appPackageName = strSubstring3;
                }
                aaVarA.f8666c = appPackageName;
                al.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
            }
            String deviceID = buglyStrategy.getDeviceID();
            if (deviceID != null) {
                if (deviceID.length() > 100) {
                    String strSubstring4 = deviceID.substring(0, 100);
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = deviceID;
                    objArr2[1] = 100;
                    objArr2[r17] = strSubstring4;
                    al.d("deviceId %s length is over limit %d substring to %s", objArr2);
                    deviceID = strSubstring4;
                }
                aaVarA.a(deviceID);
                al.a("[param] Set device ID: %s", deviceID);
            }
            String deviceModel = buglyStrategy.getDeviceModel();
            if (deviceModel != null) {
                aaVarA.b(deviceModel);
                al.a("[param] Set device model: %s", deviceModel);
            }
            aaVarA.f8669f = buglyStrategy.isUploadProcess();
            ao.f8768b = buglyStrategy.isBuglyLogUpload();
        }
        for (int i10 = 0; i10 < f9100b.size(); i10++) {
            try {
                if (uVarA.b(f9100b.get(i10).f9098id)) {
                    f9100b.get(i10).init(contextA, z10, buglyStrategy);
                }
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        s.a(contextA, buglyStrategy);
        long appReportDelay = buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L;
        final ac acVarA = ac.a();
        acVarA.f8697c.a(new Thread() { // from class: com.tencent.bugly.proguard.ac.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> mapA2 = w.a().a(ac.f8693a, (v) null);
                    if (mapA2 != null) {
                        byte[] bArr2 = mapA2.get("device");
                        byte[] bArr3 = mapA2.get("gateway");
                        if (bArr2 != null) {
                            aa.a(ac.this.f8701h).d(new String(bArr2));
                        }
                        if (bArr3 != null) {
                            aa.a(ac.this.f8701h).c(new String(bArr3));
                        }
                    }
                    ac.this.f8700g = ac.d();
                    if (ac.this.f8700g != null) {
                        if (ap.b(ac.f8696i) || !ap.d(ac.f8696i)) {
                            ac.this.f8700g.f8593q = StrategyBean.f8577a;
                            ac.this.f8700g.f8594r = StrategyBean.f8578b;
                        } else {
                            ac.this.f8700g.f8593q = ac.f8696i;
                            ac.this.f8700g.f8594r = ac.f8696i;
                        }
                    }
                } catch (Throwable th2) {
                    if (!al.a(th2)) {
                        th2.printStackTrace();
                    }
                }
                ac acVar = ac.this;
                acVar.a(acVar.f8700g, false);
            }
        }, appReportDelay);
        al.b("[init] Bugly initialization finished.", new Object[0]);
    }
}
