package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class at {
    private static at D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f8826a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8827b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f8828d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f8829e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f8830f = 20480;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f8831g = 3000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f8832h = 20480;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f8833i = 209715200;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f8834j = 604800000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f8835k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f8836l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f8837m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f8838n = 5000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f8839o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f8840p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f8841q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f8842r;
    public Boolean A;
    public int B = 31;
    public boolean C = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f8843c;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final as f8844s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final av f8845t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final NativeCrashHandler f8846u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ac f8847v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ak f8848w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ay f8849x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BuglyStrategy.a f8850y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public aw f8851z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeCrashHandler.getInstance().unBlockSigquit(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeCrashHandler.getInstance().unBlockSigquit(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class c extends Thread {
        c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            List<CrashDetailBean> list;
            if (!ap.a(at.this.f8843c, "local_crash_lock")) {
                al.c("Failed to lock file for uploading local crash.", new Object[0]);
                return;
            }
            ag agVar = ag.a.f8708a;
            List<ag.b> listA = ag.a();
            if (listA == null || listA.isEmpty()) {
                al.c("sla local data is null", new Object[0]);
            } else {
                al.c("sla load local data list size:%s", Integer.valueOf(listA.size()));
                Iterator<ag.b> it = listA.iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    ag.b next = it.next();
                    if (next.f8710b < ap.b() - 604800000) {
                        al.c("sla local data is expired:%s", next.f8711c);
                        arrayList.add(next);
                        it.remove();
                    }
                }
                ag.d(arrayList);
                agVar.b(listA);
            }
            List<CrashDetailBean> listA2 = as.a();
            if (listA2 == null || listA2.size() <= 0) {
                al.c("no crash need to be uploaded at this start", new Object[0]);
            } else {
                al.c("Size of crash list: %s", Integer.valueOf(listA2.size()));
                int size = listA2.size();
                if (size > 20) {
                    ArrayList arrayList2 = new ArrayList();
                    Collections.sort(listA2);
                    for (int i10 = 0; i10 < 20; i10++) {
                        arrayList2.add(listA2.get((size - 1) - i10));
                    }
                    list = arrayList2;
                } else {
                    list = listA2;
                }
                at.this.f8844s.a(list, 0L, false, false, false);
            }
            ap.b(at.this.f8843c, "local_crash_lock");
        }
    }

    public final synchronized void c() {
        this.f8845t.b();
        d();
        g();
    }

    public final synchronized void h() {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i10 < 30) {
                try {
                    al.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i11));
                    ap.b(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                    i10 = i11;
                } catch (Throwable th) {
                    if (al.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public static synchronized at a(Context context, boolean z10, BuglyStrategy.a aVar) {
        try {
            if (D == null) {
                D = new at(context, ak.a(), z10, aVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return D;
    }

    public final synchronized void b() {
        this.f8845t.a();
        e();
        f();
    }

    public final void d() {
        this.f8846u.setUserOpened(false);
    }

    public final void e() {
        this.f8846u.setUserOpened(true);
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new a());
        this.f8849x.b(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new b());
        this.f8849x.b(false);
    }

    public final boolean i() {
        return this.f8849x.f8893a.get();
    }

    public final boolean j() {
        return (this.B & 16) > 0;
    }

    public final boolean k() {
        return (this.B & 8) > 0;
    }

    private at(Context context, ak akVar, boolean z10, BuglyStrategy.a aVar) {
        f8826a = 1004;
        Context contextA = ap.a(context);
        this.f8843c = contextA;
        ac acVarA = ac.a();
        this.f8847v = acVarA;
        this.f8848w = akVar;
        this.f8850y = aVar;
        this.f8851z = null;
        as asVar = new as(contextA, ai.a(), w.a(), acVarA, aVar);
        this.f8844s = asVar;
        aa aaVarA = aa.a(contextA);
        this.f8845t = new av(contextA, asVar, acVarA, aaVarA);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(contextA, aaVarA, asVar, acVarA, akVar, z10, null);
        this.f8846u = nativeCrashHandler;
        aaVarA.N = nativeCrashHandler;
        if (ay.f8892f == null) {
            ay.f8892f = new ay(contextA, acVarA, aaVarA, akVar, asVar);
        }
        this.f8849x = ay.f8892f;
    }

    public static synchronized at a() {
        return D;
    }

    public final synchronized void a(boolean z10, boolean z11, boolean z12) {
        this.f8846u.testNativeCrash(z10, z11, z12);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.f8844s.b(crashDetailBean);
    }

    public final void a(long j10) {
        ak.a().a(new c(), j10);
    }
}
