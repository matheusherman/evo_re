package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.au;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CrashModule extends o {
    public static final int MODULE_ID = 1004;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f8547c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static CrashModule f8548e = new CrashModule();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BuglyStrategy.a f8550b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8551d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        try {
            String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                aa.a(context).f8683t = libBuglySOFilePath;
                al.a("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.f8550b = buglyStrategy.getCrashHandleCallback();
                al.a("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                long appReportDelay = buglyStrategy.getAppReportDelay();
                this.f8549a = appReportDelay;
                al.a("setted delay: %d", Long.valueOf(appReportDelay));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean hasInitialized() {
        return this.f8551d;
    }

    @Override // com.tencent.bugly.proguard.o
    public synchronized void init(Context context, boolean z10, BuglyStrategy buglyStrategy) {
        if (context != null) {
            try {
                if (!this.f8551d) {
                    al.a("Initializing crash module.", new Object[0]);
                    u uVarA = u.a();
                    int i10 = f8547c + 1;
                    f8547c = i10;
                    uVarA.a(i10);
                    this.f8551d = true;
                    CrashReport.setContext(context);
                    a(context, buglyStrategy);
                    at atVarA = at.a(context, z10, this.f8550b);
                    atVarA.f8845t.a();
                    if (buglyStrategy != null) {
                        atVarA.B = buglyStrategy.getCallBackType();
                        atVarA.C = buglyStrategy.getCloseErrorCallback();
                        at.f8839o = buglyStrategy.isUploadSpotCrash();
                        aa.a(context).S = buglyStrategy.isEnableRecordAnrMainStack();
                        if (buglyStrategy.isEnableCatchAnrTrace()) {
                            atVarA.f8846u.enableCatchAnrTrace();
                        } else {
                            atVarA.f8846u.disableCatchAnrTrace();
                        }
                    } else {
                        atVarA.f8846u.enableCatchAnrTrace();
                    }
                    if (aa.b().f8667d.equals(z.a(atVarA.f8843c))) {
                        atVarA.f8846u.removeEmptyNativeRecordFiles();
                    }
                    if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                        atVarA.e();
                    } else {
                        al.a("[crash] Closed native crash monitor!", new Object[0]);
                        atVarA.d();
                    }
                    if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                        atVarA.f();
                    } else {
                        al.a("[crash] Closed ANR monitor!", new Object[0]);
                        atVarA.g();
                    }
                    if (buglyStrategy != null) {
                        at.f8829e = buglyStrategy.isMerged();
                    }
                    atVarA.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                    atVarA.f8846u.checkUploadRecordCrash();
                    au.a(context);
                    aq aqVarA = aq.a();
                    aqVarA.a("android.net.conn.CONNECTIVITY_CHANGE");
                    aqVarA.a(context);
                    u uVarA2 = u.a();
                    int i11 = f8547c - 1;
                    f8547c = i11;
                    uVarA2.a(i11);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f8548e;
        crashModule.f9098id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.proguard.o
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    @Override // com.tencent.bugly.proguard.o
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        at atVarA;
        if (strategyBean == null || (atVarA = at.a()) == null) {
            return;
        }
        atVarA.f8845t.a(strategyBean);
        atVarA.f8846u.onStrategyChanged(strategyBean);
        atVarA.f8849x.b();
    }
}
