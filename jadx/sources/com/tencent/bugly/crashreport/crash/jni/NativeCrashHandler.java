package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.q;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class NativeCrashHandler implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f8641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static NativeCrashHandler f8642b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f8643c = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f8644n = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f8645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final aa f8646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ak f8647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private NativeExceptionHandler f8648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f8649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8650i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8651j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8652k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8653l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private as f8654m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i10;
            if (!ap.a(NativeCrashHandler.this.f8645d, "native_record_lock")) {
                al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                return;
            }
            if (!NativeCrashHandler.f8644n) {
                NativeCrashHandler.a(NativeCrashHandler.this, "false");
            }
            CrashDetailBean crashDetailBeanA = be.a(NativeCrashHandler.this.f8645d, NativeCrashHandler.f8641a, NativeCrashHandler.this.f8648g);
            if (crashDetailBeanA != null) {
                al.a("[Native] Get crash from native record.", new Object[0]);
                if (!NativeCrashHandler.this.f8654m.a(crashDetailBeanA, true)) {
                    NativeCrashHandler.this.f8654m.b(crashDetailBeanA, false);
                }
                be.a(false, NativeCrashHandler.f8641a);
            }
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
            long jB = ap.b() - at.f8834j;
            long jB2 = ap.b() + 86400000;
            File file = new File(NativeCrashHandler.f8641a);
            if (file.exists() && file.isDirectory()) {
                try {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        Arrays.sort(fileArrListFiles, nativeCrashHandler.new b());
                        int length = fileArrListFiles.length;
                        long length2 = 0;
                        int i11 = 0;
                        int i12 = 0;
                        int i13 = 0;
                        while (i11 < length) {
                            File file2 = fileArrListFiles[i11];
                            long jLastModified = file2.lastModified();
                            length2 += file2.length();
                            if (jLastModified < jB || jLastModified >= jB2 || length2 >= at.f8833i) {
                                i10 = length;
                                al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                                i12++;
                                if (file2.delete()) {
                                    i13++;
                                }
                            } else {
                                i10 = length;
                            }
                            i11++;
                            length = i10;
                        }
                        al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i12), Integer.valueOf(i13));
                    }
                } catch (Throwable th) {
                    al.a(th);
                }
            }
            ap.b(NativeCrashHandler.this.f8645d, "native_record_lock");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class b implements Comparator<File> {
        b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            return Long.compare(file2.lastModified(), file.lastModified());
        }
    }

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z10, String str) {
        try {
            if (f8642b == null) {
                f8642b = new NativeCrashHandler(context, aaVar, asVar, akVar, z10, str);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8642b;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void disableCatchAnrTrace() {
        f8643c = 1;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public synchronized boolean isUserOpened() {
        return this.f8653l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            try {
                boolean z10 = strategyBean.f8582f;
                if (z10 != this.f8652k) {
                    al.d("server native changed to %b", Boolean.valueOf(z10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z11 = ac.a().c().f8582f && this.f8653l;
        if (z11 != this.f8652k) {
            al.a("native changed to %b", Boolean.valueOf(z11));
            b(z11);
        }
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z10, int i10);

    protected native String removeNativeKeyValue(String str);

    protected native void setNativeInfo(int i10, String str);

    public synchronized void setUserOpened(boolean z10) {
        try {
            c(z10);
            boolean zIsUserOpened = isUserOpened();
            ac acVarA = ac.a();
            if (acVarA != null) {
                zIsUserOpened = zIsUserOpened && acVarA.c().f8582f;
            }
            if (zIsUserOpened != this.f8652k) {
                al.a("native changed to %b", Boolean.valueOf(zIsUserOpened));
                b(zIsUserOpened);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void startNativeMonitor() {
        try {
            if (!this.f8651j && !this.f8650i) {
                boolean zB = ap.b(this.f8646e.f8683t);
                boolean z10 = !zB;
                if (at.f8827b) {
                    boolean zA = a(zB ? "Bugly_Native" : this.f8646e.f8683t, z10);
                    this.f8651j = zA;
                    if (!zA && zB) {
                        this.f8650i = a("NativeRQD", false);
                    }
                } else {
                    String str = "Bugly_Native";
                    aa aaVar = this.f8646e;
                    String str2 = aaVar.f8683t;
                    if (zB) {
                        aaVar.getClass();
                    } else {
                        str = str2;
                    }
                    this.f8651j = a(str, z10);
                }
                if (this.f8651j || this.f8650i) {
                    a(this.f8649h);
                    setNativeAppVersion(this.f8646e.f8678o);
                    setNativeAppChannel(this.f8646e.f8682s);
                    setNativeAppPackage(this.f8646e.f8666c);
                    setNativeUserId(this.f8646e.f());
                    setNativeIsAppForeground(this.f8646e.a());
                    setNativeLaunchTime(this.f8646e.f8657a);
                    return;
                }
                return;
            }
            a(this.f8649h);
        } catch (Throwable th) {
            throw th;
        }
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.f8651j) {
            testCrash();
        } else {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    protected native String unregist();

    private synchronized void c() {
        if (!this.f8652k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f8652k = false;
                return;
            }
            try {
                ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
                this.f8652k = false;
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
                return;
            } catch (Throwable unused) {
                al.c("[Native] Failed to close native crash report.", new Object[0]);
                this.f8651j = false;
                this.f8650i = false;
                return;
            }
        } catch (Throwable unused2) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        throw th;
    }

    public static synchronized String getDumpFilePath() {
        return f8641a;
    }

    public static boolean isShouldHandleInJava() {
        return f8644n;
    }

    public static synchronized void setDumpFilePath(String str) {
        f8641a = str;
    }

    public static void setShouldHandleInJava(boolean z10) {
        f8644n = z10;
        NativeCrashHandler nativeCrashHandler = f8642b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z10));
        }
    }

    @Override // com.tencent.bugly.proguard.q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f8650i || this.f8651j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f8651j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public void checkUploadRecordCrash() {
        this.f8647f.a(new a());
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        f8643c |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    @Override // com.tencent.bugly.proguard.q
    public String getLogFromNative() {
        if (!this.f8650i && !this.f8651j) {
            return null;
        }
        try {
            return this.f8651j ? getNativeLog() : (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f8648g;
    }

    public String getSystemProperty(String str) {
        return (this.f8651j || this.f8650i) ? getProperties(str) : "fail";
    }

    public boolean isEnableCatchAnrTrace() {
        return (f8643c & 2) == 2;
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f8650i || this.f8651j) && str != null && str2 != null) {
            try {
                if (this.f8651j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public void removeEmptyNativeRecordFiles() {
        be.c(f8641a);
    }

    public void resendSigquit() {
        a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    @Override // com.tencent.bugly.proguard.q
    public boolean setNativeIsAppForeground(boolean z10) {
        return a(14, z10 ? "true" : "false");
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public void unBlockSigquit(boolean z10) {
        if (z10) {
            a(21, "true");
        } else {
            a(21, "false");
        }
    }

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z10, String str) {
        this.f8645d = ap.a(context);
        if (ap.b(f8641a)) {
            try {
                if (ap.b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + aa.a(context).f8666c + "/app_bugly";
            }
            f8641a = str;
        }
        this.f8654m = asVar;
        this.f8646e = aaVar;
        this.f8647f = akVar;
        this.f8649h = z10;
        this.f8648g = new bd(context, aaVar, asVar, ac.a());
    }

    static /* synthetic */ boolean a(NativeCrashHandler nativeCrashHandler, String str) {
        return nativeCrashHandler.a(999, str);
    }

    private synchronized void b(boolean z10) {
        try {
            if (z10) {
                startNativeMonitor();
            } else {
                c();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public boolean setNativeLaunchTime(long j10) {
        try {
            return a(15, String.valueOf(j10));
        } catch (NumberFormatException e10) {
            if (!al.a(e10)) {
                e10.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private synchronized void a(boolean z10) {
        if (this.f8652k) {
            al.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f8651j) {
            try {
                String strRegist = regist(f8641a, z10, f8643c);
                if (strRegist != null) {
                    al.a("[Native] Native Crash Report enable.", new Object[0]);
                    this.f8646e.f8684u = strRegist;
                    String strConcat = "-".concat(strRegist);
                    if (!at.f8827b && !this.f8646e.f8671h.contains(strConcat)) {
                        aa aaVar = this.f8646e;
                        aaVar.f8671h = aaVar.f8671h.concat("-").concat(this.f8646e.f8684u);
                    }
                    al.a("comInfo.sdkVersion %s", this.f8646e.f8671h);
                    this.f8652k = true;
                    String runningCpuAbi = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi)) {
                        this.f8646e.e(runningCpuAbi);
                    }
                    return;
                }
            } catch (Throwable unused) {
                al.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f8650i) {
            try {
                Class cls = Integer.TYPE;
                String str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", new Class[]{String.class, String.class, cls, cls}, new Object[]{f8641a, ab.d(), Integer.valueOf(z10 ? 1 : 5), 1});
                if (str == null) {
                    String strD = ab.d();
                    aa.b();
                    str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f8641a, strD, Integer.valueOf(aa.B())});
                }
                if (str != null) {
                    this.f8652k = true;
                    this.f8646e.f8684u = str;
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z10 ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f8646e.e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f8651j = false;
        this.f8650i = false;
    }

    public static synchronized NativeCrashHandler getInstance() {
        return f8642b;
    }

    public void testNativeCrash(boolean z10, boolean z11, boolean z12) {
        a(16, String.valueOf(z10));
        a(17, String.valueOf(z11));
        a(18, String.valueOf(z12));
        testNativeCrash();
    }

    private synchronized void c(boolean z10) {
        if (this.f8653l != z10) {
            al.a("user change native %b", Boolean.valueOf(z10));
            this.f8653l = z10;
        }
    }

    private static boolean a(String str, boolean z10) {
        boolean z11;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z10) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z11 = true;
                al.d(th.getMessage(), new Object[0]);
                al.d("[Native] Failed to load so: %s", str);
                return z11;
            }
        } catch (Throwable th2) {
            th = th2;
            z11 = false;
        }
    }

    private boolean a(int i10, String str) {
        if (!this.f8651j) {
            return false;
        }
        try {
            setNativeInfo(i10, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
