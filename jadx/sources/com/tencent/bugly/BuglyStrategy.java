package com.tencent.bugly;

import com.tencent.bugly.proguard.aa;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BuglyStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8533i;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private a f8545u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8534j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8535k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8536l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8537m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f8538n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Class<?> f8539o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f8540p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8541q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f8542r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8543s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f8544t = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f8525a = 31;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f8526b = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f8546v = false;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i10, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i10, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        String str = this.f8528d;
        if (str != null) {
            return str;
        }
        return aa.b().f8682s;
    }

    public synchronized String getAppPackageName() {
        String str = this.f8529e;
        if (str != null) {
            return str;
        }
        return aa.b().f8666c;
    }

    public synchronized long getAppReportDelay() {
        return this.f8530f;
    }

    public synchronized String getAppVersion() {
        String str = this.f8527c;
        if (str != null) {
            return str;
        }
        return aa.b().f8678o;
    }

    public synchronized int getCallBackType() {
        return this.f8525a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f8526b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f8545u;
    }

    public synchronized String getDeviceID() {
        return this.f8532h;
    }

    public synchronized String getDeviceModel() {
        return this.f8533i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f8531g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f8539o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f8540p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f8535k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f8536l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f8534j;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f8538n;
    }

    public synchronized boolean isUploadProcess() {
        return this.f8542r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f8543s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f8544t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f8528d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f8529e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j10) {
        this.f8530f = j10;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f8527c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z10) {
        this.f8540p = z10;
        return this;
    }

    public synchronized void setCallBackType(int i10) {
        this.f8525a = i10;
    }

    public synchronized void setCloseErrorCallback(boolean z10) {
        this.f8526b = z10;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f8545u = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f8532h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f8533i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z10) {
        this.f8535k = z10;
        return this;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z10) {
        this.f8534j = z10;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z10) {
        this.f8538n = z10;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f8531g = str;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z10) {
        this.f8544t = z10;
        return this;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z10) {
        this.f8542r = z10;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z10) {
        this.f8543s = z10;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f8539o = cls;
        return this;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f8537m;
    }

    public boolean isMerged() {
        return this.f8546v;
    }

    public boolean isReplaceOldChannel() {
        return this.f8541q;
    }

    public void setEnableCatchAnrTrace(boolean z10) {
        this.f8536l = z10;
    }

    public void setEnableRecordAnrMainStack(boolean z10) {
        this.f8537m = z10;
    }

    @Deprecated
    public void setMerged(boolean z10) {
        this.f8546v = z10;
    }

    public void setReplaceOldChannel(boolean z10) {
        this.f8541q = z10;
    }
}
