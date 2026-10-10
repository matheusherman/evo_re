package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class av implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f8875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f8876i = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f8877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final as f8878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final ac f8879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final aa f8880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f8881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f8882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f8883g = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8884j;

    private static void c() {
        al.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void a() {
        if (this.f8884j >= 10) {
            al.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f8883g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (av.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                al.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f8882f = defaultUncaughtExceptionHandler;
                this.f8881e = defaultUncaughtExceptionHandler;
            } else {
                al.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f8881e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f8884j++;
        al.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.f8883g = false;
        al.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            al.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f8881e);
            this.f8884j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f8876i) {
            a(thread, th, true, null, null, this.f8880d.Q);
        }
    }

    public av(Context context, as asVar, ac acVar, aa aaVar) {
        this.f8877a = context;
        this.f8878b = asVar;
        this.f8879c = acVar;
        this.f8880d = aaVar;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0106  */
    /* JADX WARN: Code duplicated, block: B:33:0x010e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0111 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:23:0x00fc, B:30:0x0109, B:35:0x0111, B:37:0x011f, B:38:0x0121), top: B:42:0x00fc }] */
    /* JADX WARN: Code duplicated, block: B:37:0x011f A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:23:0x00fc, B:30:0x0109, B:35:0x0111, B:37:0x011f, B:38:0x0121), top: B:42:0x00fc }] */
    private CrashDetailBean b(Thread thread, Throwable th, boolean z10, String str, byte[] bArr, boolean z11) {
        boolean z12;
        boolean z13;
        if (th == null) {
            al.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f8618r = System.currentTimeMillis();
        crashDetailBean.C = ab.j();
        crashDetailBean.D = ab.f();
        crashDetailBean.E = ab.l();
        crashDetailBean.F = this.f8880d.k();
        crashDetailBean.G = this.f8880d.j();
        crashDetailBean.H = this.f8880d.l();
        if (!z10 && aa.B() >= 31) {
            crashDetailBean.I = 0L;
        } else {
            crashDetailBean.I = ab.b(this.f8877a);
        }
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        byte[] bArrA = ao.a();
        crashDetailBean.f8625y = bArrA;
        al.a("user log size:%d", Integer.valueOf(bArrA == null ? 0 : bArrA.length));
        crashDetailBean.f8602b = z10 ? 0 : 2;
        crashDetailBean.f8605e = this.f8880d.g();
        aa aaVar = this.f8880d;
        crashDetailBean.f8606f = aaVar.f8678o;
        crashDetailBean.f8607g = aaVar.q();
        crashDetailBean.f8613m = this.f8880d.f();
        crashDetailBean.f8626z = ap.a(z11, at.f8832h);
        crashDetailBean.A = this.f8880d.f8667d;
        crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.L = this.f8880d.s();
        crashDetailBean.f8608h = this.f8880d.p();
        crashDetailBean.f8609i = this.f8880d.A();
        aa aaVar2 = this.f8880d;
        crashDetailBean.Q = aaVar2.f8657a;
        crashDetailBean.R = aaVar2.a();
        a(crashDetailBean, th, z10);
        if (!z10) {
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (bArr != null || bArr.length <= 0) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (z12) {
                        HashMap map = new HashMap(1);
                        crashDetailBean.S = map;
                        map.put("UserData", str);
                    }
                    if (z13) {
                        crashDetailBean.Y = bArr;
                    }
                } catch (Throwable th2) {
                    al.e("handle crash error %s", th2.toString());
                    return crashDetailBean;
                }
            } else {
                z12 = false;
                if (bArr != null) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if (z12) {
                    HashMap map2 = new HashMap(1);
                    crashDetailBean.S = map2;
                    map2.put("UserData", str);
                }
                if (z13) {
                    crashDetailBean.Y = bArr;
                }
            }
        }
        crashDetailBean.U = this.f8880d.z();
        aa aaVar3 = this.f8880d;
        crashDetailBean.V = aaVar3.f8687x;
        crashDetailBean.W = aaVar3.t();
        crashDetailBean.X = this.f8880d.y();
        return crashDetailBean;
    }

    private static void a(CrashDetailBean crashDetailBean, Throwable th, boolean z10) {
        String strA;
        String name = th.getClass().getName();
        String strA2 = a(th);
        al.e("stack frame :%d, has cause %b", Integer.valueOf(th.getStackTrace().length), Boolean.valueOf(th.getCause() != null));
        String str = "";
        String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause != null && cause != th) {
            crashDetailBean.f8614n = cause.getClass().getName();
            crashDetailBean.f8615o = a(cause);
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.f8616p = cause.getStackTrace()[0].toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name);
            sb2.append(":");
            sb2.append(strA2);
            sb2.append("\n");
            sb2.append(string);
            sb2.append("\n......");
            sb2.append("\nCaused by:\n");
            sb2.append(crashDetailBean.f8614n);
            sb2.append(":");
            sb2.append(crashDetailBean.f8615o);
            sb2.append("\n");
            strA = a(cause, at.f8832h);
            sb2.append(strA);
            crashDetailBean.f8617q = sb2.toString();
        } else {
            crashDetailBean.f8614n = name;
            if (at.a().i() && z10) {
                al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f8615o = strA2 + str;
            crashDetailBean.f8616p = string;
            strA = a(th, at.f8832h);
            crashDetailBean.f8617q = strA;
        }
        crashDetailBean.f8621u = ap.c(crashDetailBean.f8617q.getBytes());
        crashDetailBean.f8626z.put(crashDetailBean.B, strA);
    }

    private static boolean a(Thread thread) {
        synchronized (f8876i) {
            try {
                if (f8875h != null && thread.getName().equals(f8875h)) {
                    return true;
                }
                f8875h = thread.getName();
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Thread thread, Throwable th, boolean z10, String str, byte[] bArr, boolean z11) {
        if (z10) {
            al.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                al.a("this class has handled this exception", new Object[0]);
                if (this.f8882f != null) {
                    al.a("call system handler", new Object[0]);
                    this.f8882f.uncaughtException(thread, th);
                } else {
                    c();
                }
            }
        } else {
            al.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f8883g) {
                al.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f8881e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f8881e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f8882f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f8882f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f8879c.b()) {
                al.d("no remote but still store!", new Object[0]);
            }
            if (!this.f8879c.c().f8582f && this.f8879c.b()) {
                al.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(z10 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.f8880d.f8667d, thread.getName(), ap.a(th), null);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f8881e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f8881e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f8882f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f8882f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean crashDetailBeanB = b(thread, th, z10, str, bArr, z11);
            if (crashDetailBeanB == null) {
                al.e("pkg crash datas fail!", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f8881e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f8881e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f8882f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f8882f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            as.a(z10 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.f8880d.f8667d, thread.getName(), ap.a(th), crashDetailBeanB);
            if (!this.f8878b.a(crashDetailBeanB, z10)) {
                this.f8878b.b(crashDetailBeanB, z10);
            }
            if (z10) {
                this.f8878b.a(crashDetailBeanB);
            }
            if (z10) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f8881e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    al.e("sys default last handle start!", new Object[0]);
                    this.f8881e.uncaughtException(thread, th);
                    al.e("sys default last handle end!", new Object[0]);
                } else if (this.f8882f != null) {
                    al.e("system handle start!", new Object[0]);
                    this.f8882f.uncaughtException(thread, th);
                    al.e("system handle end!", new Object[0]);
                } else {
                    al.e("crashreport last handle start!", new Object[0]);
                    c();
                    al.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f8881e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f8881e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f8882f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f8882f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f8881e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f8881e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f8882f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f8882f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z10 = strategyBean.f8582f;
            if (z10 != this.f8883g) {
                al.a("java changed to %b", Boolean.valueOf(z10));
                if (strategyBean.f8582f) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i10) {
        if (th == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i10 > 0 && sb2.length() >= i10) {
                        sb2.append("\n[Stack over limit size :" + i10 + " , has been cutted !]");
                        return sb2.toString();
                    }
                    sb2.append(stackTraceElement.toString());
                    sb2.append("\n");
                }
            }
        } catch (Throwable th2) {
            al.e("gen stack error %s", th2.toString());
        }
        return sb2.toString();
    }

    private static String a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
