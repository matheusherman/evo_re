package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f8767a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8768b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SimpleDateFormat f8769c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f8770d = 30720;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static StringBuilder f8771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static StringBuilder f8772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f8773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static a f8774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f8775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f8776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Context f8777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f8778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f8779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f8780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static ExecutorService f8781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f8782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Object f8783q = new Object();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8791c;

        b(String str, String str2, String str3) {
            this.f8789a = str;
            this.f8790b = str2;
            this.f8791c = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ao.d(this.f8789a, this.f8790b, this.f8791c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8794c;

        c(String str, String str2, String str3) {
            this.f8792a = str;
            this.f8793b = str2;
            this.f8794c = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ao.e(this.f8792a, this.f8793b, this.f8794c);
        }
    }

    public static synchronized void a(Context context) {
        if (f8779m || context == null || !f8768b) {
            return;
        }
        try {
            f8781o = Executors.newSingleThreadExecutor();
            f8772f = new StringBuilder(0);
            f8771e = new StringBuilder(0);
            f8777k = context;
            f8775i = aa.a(context).f8667d;
            f8776j = "";
            f8778l = f8777k.getFilesDir().getPath() + "/buglylog_" + f8775i + "_" + f8776j + ".txt";
            f8782p = Process.myPid();
        } catch (Throwable unused) {
        }
        f8779m = true;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f8784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        File f8785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8786c = 30720;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f8787d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f8788e;

        final boolean a() {
            try {
                File file = new File(this.f8787d);
                this.f8785b = file;
                if (file.exists() && !this.f8785b.delete()) {
                    this.f8784a = false;
                    return false;
                }
                if (this.f8785b.createNewFile()) {
                    return true;
                }
                this.f8784a = false;
                return false;
            } catch (Throwable th) {
                al.a(th);
                this.f8784a = false;
                return false;
            }
        }

        public a(String str) {
            if (str != null && !str.equals("")) {
                this.f8787d = str;
                this.f8784a = a();
            }
        }

        public final boolean a(String str) {
            if (!this.f8784a) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.f8785b, true);
                try {
                    byte[] bytes = str.getBytes("UTF-8");
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.f8788e += (long) bytes.length;
                    this.f8784a = true;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        al.a(th);
                        this.f8784a = false;
                        return false;
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    static {
        try {
            f8769c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            al.b(th.getCause());
        }
    }

    private static String b() {
        q qVar;
        try {
            aa aaVarB = aa.b();
            if (aaVarB == null || (qVar = aaVarB.N) == null) {
                return null;
            }
            return qVar.getLogFromNative();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c() {
        File file;
        if (!f8768b) {
            return null;
        }
        if (f8780n) {
            al.a("[LogUtil] Get user log from native.", new Object[0]);
            String strB = b();
            if (strB != null) {
                al.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(strB.length()));
                return ap.a(strB, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        synchronized (f8783q) {
            try {
                a aVar = f8774h;
                if (aVar != null && aVar.f8784a && (file = aVar.f8785b) != null && file.length() > 0) {
                    sb2.append(ap.a(f8774h.f8785b, 30720, true));
                }
                StringBuilder sb3 = f8772f;
                if (sb3 != null && sb3.length() > 0) {
                    sb2.append(f8772f.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ap.a(sb2.toString(), "BuglyLog.txt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(String str, String str2, String str3) {
        if (f8767a) {
            f(str, str2, str3);
        } else {
            g(str, str2, str3);
        }
    }

    private static synchronized void f(String str, String str2, String str3) {
        String strA = a(str, str2, str3, Process.myTid());
        synchronized (f8783q) {
            try {
                f8772f.append(strA);
                if (f8772f.length() >= f8770d) {
                    StringBuilder sb2 = f8772f;
                    f8772f = sb2.delete(0, sb2.indexOf("\u0001\r\n") + 1);
                }
            } catch (Throwable th) {
                try {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        String strA = a(str, str2, str3, Process.myTid());
        try {
            synchronized (f8783q) {
                try {
                    f8772f.append(strA);
                    if (f8772f.length() <= f8770d) {
                        return;
                    }
                    if (f8773g) {
                        return;
                    }
                    f8773g = true;
                    a aVar = f8774h;
                    if (aVar == null) {
                        f8774h = new a(f8778l);
                    } else {
                        File file = aVar.f8785b;
                        if (file == null || file.length() + ((long) f8772f.length()) > f8774h.f8786c) {
                            f8774h.a();
                        }
                    }
                    if (f8774h.a(f8772f.toString())) {
                        f8772f.setLength(0);
                        f8773g = false;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        q qVar;
        try {
            aa aaVarB = aa.b();
            if (aaVarB != null && (qVar = aaVarB.N) != null) {
                return qVar.appendLogToNative(str, str2, str3);
            }
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static void a(int i10) {
        synchronized (f8783q) {
            try {
                f8770d = i10;
                if (i10 < 0) {
                    f8770d = 0;
                } else if (i10 > 30720) {
                    f8770d = 30720;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + ap.b(th));
    }

    public static synchronized void a(String str, String str2, String str3) {
        if (f8779m && f8768b) {
            try {
                if (f8780n) {
                    f8781o.execute(new b(str, str2, str3));
                } else {
                    f8781o.execute(new c(str, str2, str3));
                }
            } catch (Exception e10) {
                al.b(e10);
            }
        }
    }

    private static String a(String str, String str2, String str3, long j10) {
        String string;
        f8771e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f8769c;
        if (simpleDateFormat != null) {
            string = simpleDateFormat.format(date);
        } else {
            string = date.toString();
        }
        StringBuilder sb2 = f8771e;
        sb2.append(string);
        sb2.append(" ");
        sb2.append(f8782p);
        sb2.append(" ");
        sb2.append(j10);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(str3);
        sb2.append("\u0001\r\n");
        return f8771e.toString();
    }

    public static byte[] a() {
        if (f8767a) {
            if (f8768b) {
                return ap.a(f8772f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return c();
    }
}
