package com.live.evo.util;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class t1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static t1 f7362c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HandlerThread[] f7363a = {new HandlerThread("tortoise work thread #0")};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler[] f7364b = new Handler[1];

    public boolean b(Runnable runnable, int i10, long j10) {
        if (i10 < 1) {
            return this.f7364b[i10].postDelayed(runnable, j10);
        }
        throw new RuntimeException("trace not exists");
    }

    public boolean c(Runnable runnable, long j10) {
        return b(runnable, 0, j10);
    }

    public void d(Runnable runnable) {
        e(runnable, 0);
    }

    public void e(Runnable runnable, int i10) {
        if (i10 >= 1) {
            throw new RuntimeException("trace not exists");
        }
        this.f7364b[i10].removeCallbacks(runnable);
    }

    public static t1 a() {
        if (f7362c == null) {
            synchronized (t1.class) {
                try {
                    if (f7362c == null) {
                        f7362c = new t1();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7362c;
    }

    private t1() {
        this.f7363a[0].start();
        this.f7364b[0] = new Handler(this.f7363a[0].getLooper());
    }
}
