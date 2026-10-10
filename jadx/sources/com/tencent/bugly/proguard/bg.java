package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.p000lifecycle.CoroutineLiveDataKt;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bg extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bf f8943a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f8949g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8945c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8946d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8947e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8948f = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8944b = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
    }

    public final boolean a() {
        this.f8945c = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e10) {
            al.b(e10);
        }
        al.d("MainHandlerChecker is reset to null.", new Object[0]);
        this.f8943a = null;
        return true;
    }

    public final synchronized void c() {
        this.f8946d = false;
        al.c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void d() {
        this.f8947e = true;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bf bfVar = this.f8943a;
        if (bfVar != null) {
            bfVar.f8937b = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        } else {
            this.f8943a = new bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e10) {
            al.b(e10);
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!this.f8945c) {
            try {
                bf bfVar = this.f8943a;
                boolean z10 = false;
                if (bfVar == null) {
                    al.c("Main handler checker is null. Stop thread monitor.", new Object[0]);
                    return;
                }
                if (bfVar.f8938c) {
                    bfVar.f8938c = false;
                    bfVar.f8939d = SystemClock.uptimeMillis();
                    bfVar.f8936a.post(bfVar);
                }
                a(bfVar);
                if (this.f8944b && this.f8946d) {
                    long jB = bfVar.b();
                    if (jB > 1510 && jB < 199990) {
                        boolean z11 = true;
                        if (jB <= 5010) {
                            this.f8948f = 1;
                            al.c("timeSinceMsgSent in [2s, 5s], record stack", new Object[0]);
                            z10 = true;
                        } else {
                            int i10 = this.f8948f;
                            int i11 = i10 + 1;
                            this.f8948f = i11;
                            if ((i10 & i11) != 0) {
                                z11 = false;
                            }
                            if (z11) {
                                al.c("timeSinceMsgSent in (5s, 200s), should record stack:true", new Object[0]);
                            }
                            z10 = z11;
                        }
                    }
                }
                if (z10) {
                    bfVar.d();
                }
                if (this.f8949g != null && this.f8946d) {
                    bfVar.a();
                    bfVar.b();
                }
                ap.b(500 - ((System.currentTimeMillis() - jCurrentTimeMillis) % 500));
            } catch (Exception e10) {
                al.b(e10);
            } catch (OutOfMemoryError e11) {
                al.b(e11);
            }
        }
    }

    private synchronized void a(bf bfVar) {
        if (this.f8946d) {
            return;
        }
        if (this.f8947e && !bfVar.a()) {
            al.c("Restart getting main stack trace.", new Object[0]);
            this.f8946d = true;
            this.f8947e = false;
        }
    }
}
