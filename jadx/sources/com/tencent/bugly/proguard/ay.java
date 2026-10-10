package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ay {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ay f8892f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityManager f8894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final aa f8895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ak f8896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f8897e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f8898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ac f8899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final as f8900i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private FileObserver f8902k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private bg f8904m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8905n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f8893a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f8901j = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8903l = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f8906o = 0;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a extends FileObserver {

        /* JADX INFO: renamed from: com.tencent.bugly.proguard.ay$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        final class RunnableC0158a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8908a;

            RunnableC0158a(String str) {
                this.f8908a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ay ayVar = ay.this;
                String str = this.f8908a;
                if (ayVar.a(true)) {
                    try {
                        al.c("read trace first dump for create time!", new Object[0]);
                        TraceFileHelper.a firstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                        long jCurrentTimeMillis = firstDumpInfo != null ? firstDumpInfo.f8629c : -1L;
                        if (jCurrentTimeMillis == -1) {
                            al.d("trace dump fail could not get time!", new Object[0]);
                            jCurrentTimeMillis = System.currentTimeMillis();
                        }
                        if (ayVar.a(jCurrentTimeMillis)) {
                            return;
                        }
                        ayVar.a(jCurrentTimeMillis, str);
                    } catch (Throwable th) {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        al.e("handle anr error %s", th.getClass().toString());
                    }
                }
            }
        }

        a(String str) {
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i10, String str) {
            if (str == null) {
                return;
            }
            String strConcat = "/data/anr/".concat(str);
            al.d("watching file %s", strConcat);
            if (strConcat.contains("trace")) {
                ay.this.f8896d.a(new RunnableC0158a(strConcat));
            } else {
                al.d("not anr file %s", strConcat);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ay.a(ay.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class c extends FileObserver {
        c(String str) {
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i10, String str) {
            if (str == null) {
                return;
            }
            al.d("observe file, dir:%s fileName:%s", ay.this.f8897e, str);
            if (!str.startsWith("manual_bugly_trace_") || !str.endsWith(".txt")) {
                al.c("not manual trace file, ignore.", new Object[0]);
                return;
            }
            if (!ay.this.f8893a.get()) {
                al.c("proc is not in anr, just ignore", new Object[0]);
                return;
            }
            if (ay.this.f8895c.a()) {
                al.c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                NativeCrashHandler.getInstance().resendSigquit();
                long jA = am.a(str, "manual_bugly_trace_", ".txt");
                ay.this.a(jA, ay.this.f8897e + "/" + str);
                al.c("Finish handling one anr.", new Object[0]);
                return;
            }
            al.c("Found background anr, resend sigquit later.", new Object[0]);
            long jA2 = am.a(str, "manual_bugly_trace_", ".txt");
            ay.this.a(jA2, ay.this.f8897e + "/" + str);
            al.c("Finish handling one anr, now resend sigquit.", new Object[0]);
            NativeCrashHandler.getInstance().resendSigquit();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ay.a(ay.this);
        }
    }

    private synchronized void c() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        a aVar = new a("/data/anr/");
        this.f8902k = aVar;
        try {
            aVar.startWatching();
            al.a("start anr monitor!", new Object[0]);
            this.f8896d.a(new b());
        } catch (Throwable th) {
            this.f8902k = null;
            al.d("start anr monitor failed!", new Object[0]);
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void d() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f8902k.stopWatching();
            this.f8902k = null;
            al.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            al.d("stop anr monitor failed!", new Object[0]);
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean e() {
        return this.f8902k != null;
    }

    private synchronized boolean f() {
        return this.f8903l;
    }

    private synchronized void g() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f8897e)) {
            return;
        }
        synchronized (this.f8901j) {
            try {
                bg bgVar = this.f8904m;
                if (bgVar == null || !bgVar.isAlive()) {
                    bg bgVar2 = new bg();
                    this.f8904m = bgVar2;
                    boolean z10 = this.f8895c.S;
                    bgVar2.f8944b = z10;
                    al.c("set record stack trace enable:".concat(String.valueOf(z10)), new Object[0]);
                    bg bgVar3 = this.f8904m;
                    StringBuilder sb2 = new StringBuilder("Bugly-ThreadMonitor");
                    int i10 = this.f8905n;
                    this.f8905n = i10 + 1;
                    sb2.append(i10);
                    bgVar3.setName(sb2.toString());
                    this.f8904m.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c cVar = new c(this.f8897e);
        this.f8902k = cVar;
        try {
            cVar.startWatching();
            al.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f8897e);
            this.f8896d.a(new d());
        } catch (Throwable th2) {
            this.f8902k = null;
            al.d("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (al.a(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    private synchronized void h() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f8901j) {
            try {
                bg bgVar = this.f8904m;
                if (bgVar != null) {
                    bgVar.a();
                    this.f8904m = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        al.a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f8902k.stopWatching();
            this.f8902k = null;
            al.d("close anr monitor!", new Object[0]);
        } catch (Throwable th2) {
            al.d("stop anr monitor failed!", new Object[0]);
            if (al.a(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public final void b(boolean z10) {
        d(z10);
        boolean zF = f();
        ac acVarA = ac.a();
        if (acVarA != null) {
            zF = zF && acVarA.c().f8582f;
        }
        if (zF != e()) {
            al.a("anr changed to %b", Boolean.valueOf(zF));
            c(zF);
        }
    }

    public static synchronized ay a() {
        return f8892f;
    }

    public ay(Context context, ac acVar, aa aaVar, ak akVar, as asVar) {
        Context contextA = ap.a(context);
        this.f8898g = contextA;
        this.f8894b = (ActivityManager) contextA.getSystemService("activity");
        if (ap.b(NativeCrashHandler.getDumpFilePath())) {
            this.f8897e = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.f8897e = NativeCrashHandler.getDumpFilePath();
        }
        this.f8895c = aaVar;
        this.f8896d = akVar;
        this.f8899h = acVar;
        this.f8900i = asVar;
    }

    private CrashDetailBean a(ax axVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = this.f8895c.k();
            crashDetailBean.G = this.f8895c.j();
            crashDetailBean.H = this.f8895c.l();
            crashDetailBean.I = ab.b(this.f8898g);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.f8602b = 3;
            crashDetailBean.f8605e = this.f8895c.g();
            aa aaVar = this.f8895c;
            crashDetailBean.f8606f = aaVar.f8678o;
            crashDetailBean.f8607g = aaVar.q();
            crashDetailBean.f8613m = this.f8895c.f();
            crashDetailBean.f8614n = "ANR_EXCEPTION";
            crashDetailBean.f8615o = axVar.f8890f;
            crashDetailBean.f8617q = axVar.f8891g;
            HashMap map = new HashMap();
            crashDetailBean.T = map;
            map.put("BUGLY_CR_01", axVar.f8889e);
            String str = crashDetailBean.f8617q;
            int iIndexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.f8616p = iIndexOf > 0 ? crashDetailBean.f8617q.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.f8618r = axVar.f8887c;
            String str2 = crashDetailBean.f8617q;
            if (str2 != null) {
                crashDetailBean.f8621u = ap.c(str2.getBytes());
            }
            crashDetailBean.f8626z = axVar.f8886b;
            crashDetailBean.A = axVar.f8885a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.L = this.f8895c.s();
            crashDetailBean.f8608h = this.f8895c.p();
            crashDetailBean.f8609i = this.f8895c.A();
            crashDetailBean.f8622v = axVar.f8888d;
            aa aaVar2 = this.f8895c;
            crashDetailBean.P = aaVar2.f8684u;
            crashDetailBean.Q = aaVar2.f8657a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = this.f8895c.z();
            aa aaVar3 = this.f8895c;
            crashDetailBean.V = aaVar3.f8687x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.f8895c.y();
            crashDetailBean.f8625y = ao.a();
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return crashDetailBean;
        }
    }

    public final synchronized void b() {
        al.d("customer decides whether to open or close.", new Object[0]);
    }

    private synchronized void d(boolean z10) {
        if (this.f8903l != z10) {
            al.a("user change anr %b", Boolean.valueOf(z10));
            this.f8903l = z10;
        }
    }

    private synchronized void c(boolean z10) {
        try {
            if (z10) {
                g();
            } else {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static boolean a(String str, String str2, String str3) throws Throwable {
        Map<String, String[]> map;
        TraceFileHelper.a targetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (targetDumpInfo != null && (map = targetDumpInfo.f8630d) != null && !map.isEmpty()) {
            StringBuilder sb2 = new StringBuilder(1024);
            String[] strArr = targetDumpInfo.f8630d.get("main");
            if (strArr != null && strArr.length >= 3) {
                sb2.append("\"main\" tid=");
                sb2.append(strArr[2]);
                sb2.append(" :\n");
                sb2.append(strArr[0]);
                sb2.append("\n");
                sb2.append(strArr[1]);
                sb2.append("\n\n");
            }
            for (Map.Entry<String, String[]> entry : targetDumpInfo.f8630d.entrySet()) {
                if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                    sb2.append("\"");
                    sb2.append(entry.getKey());
                    sb2.append("\" tid=");
                    sb2.append(entry.getValue()[2]);
                    sb2.append(" :\n");
                    sb2.append(entry.getValue()[0]);
                    sb2.append("\n");
                    sb2.append(entry.getValue()[1]);
                    sb2.append("\n\n");
                }
            }
            return am.a(str2, sb2.toString(), sb2.length() * 2);
        }
        al.e("not found trace dump for %s", str3);
        return false;
    }

    private static String a(List<ba> list, long j10) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder(4096);
            sb2.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n");
            sb2.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
            for (int i10 = 0; i10 < list.size(); i10++) {
                ba baVar = list.get(i10);
                sb2.append("Thread name:");
                sb2.append(baVar.f8913a);
                sb2.append("\n");
                long j11 = baVar.f8914b - j10;
                String str = j11 <= 0 ? "before " : "after ";
                sb2.append("Got ");
                sb2.append(str);
                sb2.append("anr:");
                sb2.append(Math.abs(j11));
                sb2.append("ms\n");
                sb2.append(baVar.f8915c);
                sb2.append("\n");
                if (sb2.length() * 2 >= 101376) {
                    break;
                }
            }
            sb2.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
            return sb2.toString();
        }
        return "main thread stack not enable";
    }

    public final boolean a(boolean z10) {
        boolean zCompareAndSet = this.f8893a.compareAndSet(!z10, z10);
        al.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z10), Boolean.valueOf(zCompareAndSet));
        return zCompareAndSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j10, String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoA;
        List<ba> listC;
        try {
            al.c("anr time:%s", Long.valueOf(j10));
            synchronized (this.f8901j) {
                try {
                    if (this.f8904m != null) {
                        al.c("Disable record main stack trace.", new Object[0]);
                        this.f8904m.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            String strA = ap.a(Looper.getMainLooper().getThread());
            Map<String, String> mapA = ap.a(this.f8895c.R, at.f8832h);
            if (this.f8895c.a()) {
                boolean z10 = ab.o() || ab.p();
                al.c("isAnrCrashDevice:%s", Boolean.valueOf(z10));
                if (!z10) {
                    processErrorStateInfoA = az.a(this.f8894b, 21000L);
                } else {
                    processErrorStateInfoA = az.a(this.f8894b, 0L);
                }
            } else {
                processErrorStateInfoA = az.a(this.f8894b, 0L);
            }
            if (processErrorStateInfoA == null) {
                al.c("proc state is invisible or not my proc!", new Object[0]);
                a(false);
                return;
            }
            ax axVar = new ax();
            axVar.f8887c = j10;
            axVar.f8885a = processErrorStateInfoA.processName;
            axVar.f8890f = processErrorStateInfoA.shortMsg;
            axVar.f8889e = processErrorStateInfoA.longMsg;
            axVar.f8886b = mapA;
            axVar.f8891g = strA;
            if (TextUtils.isEmpty(strA)) {
                axVar.f8891g = "main stack is null , some error may be encountered.";
            }
            Long lValueOf = Long.valueOf(axVar.f8887c);
            String str2 = axVar.f8888d;
            String str3 = axVar.f8885a;
            String str4 = axVar.f8891g;
            String str5 = axVar.f8890f;
            String str6 = axVar.f8889e;
            Map<String, String> map = axVar.f8886b;
            al.c("anr time:%d\ntrace file:%s\nproc:%s\nmain stack:%s\nshort msg:%s\nlong msg:%s\n threads:%d", lValueOf, str2, str3, str4, str5, str6, Integer.valueOf(map == null ? 0 : map.size()));
            al.a("found visible anr , start to upload!", new Object[0]);
            al.c("trace file:%s", str);
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                File file = new File(this.f8897e, "bugly_trace_" + j10 + ".txt");
                al.c("trace file exists", new Object[0]);
                if (str.startsWith("/data/anr/")) {
                    al.a("backup trace isOK:%s", Boolean.valueOf(a(str, file.getAbsolutePath(), axVar.f8885a)));
                } else {
                    al.a("trace file rename :%s", Boolean.valueOf(new File(str).renameTo(file)));
                }
                synchronized (this.f8901j) {
                    try {
                        bg bgVar = this.f8904m;
                        listC = bgVar != null ? bgVar.f8943a.c() : null;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (listC != null) {
                    String strA2 = a(listC, j10);
                    al.c("save main stack trace", new Object[0]);
                    am.a(file, strA2, 2147483647L, true);
                }
                axVar.f8888d = file.getAbsolutePath();
            } else {
                al.c("trace file is null or not exists, just ignore", new Object[0]);
            }
            CrashDetailBean crashDetailBeanA = a(axVar);
            at.a().a(crashDetailBeanA);
            if (crashDetailBeanA.f8600a >= 0) {
                al.a("backup anr record success!", new Object[0]);
            } else {
                al.d("backup anr record fail!", new Object[0]);
            }
            as.a("ANR", ap.a(j10), axVar.f8885a, "main", axVar.f8891g, crashDetailBeanA);
            if (!this.f8900i.a(crashDetailBeanA, !ab.r())) {
                this.f8900i.b(crashDetailBeanA, true);
            }
            this.f8900i.a(crashDetailBeanA);
            synchronized (this.f8901j) {
                try {
                    if (this.f8904m != null) {
                        al.c("Finish anr process.", new Object[0]);
                        this.f8904m.d();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            a(false);
        } catch (Throwable th4) {
            try {
                al.b(th4);
            } finally {
                a(false);
            }
        }
    }

    public final boolean a(long j10) {
        if (Math.abs(j10 - this.f8906o) < 10000) {
            al.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.f8906o = j10;
        return false;
    }

    static /* synthetic */ void a(ay ayVar) {
        long jCurrentTimeMillis = (at.f8834j + System.currentTimeMillis()) - ap.b();
        am.a(ayVar.f8897e, "bugly_trace_", ".txt", jCurrentTimeMillis);
        am.a(ayVar.f8897e, "manual_bugly_trace_", ".txt", jCurrentTimeMillis);
        am.a(ayVar.f8897e, "main_stack_record_", ".txt", jCurrentTimeMillis);
        am.a(ayVar.f8897e, "main_stack_record_", ".txt.merged", jCurrentTimeMillis);
    }
}
