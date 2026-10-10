package n4;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static k f15935e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f15936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f15937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15938c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f15939d = new Object();

    private void a() {
        synchronized (this.f15939d) {
            try {
                if (this.f15936a == null) {
                    if (this.f15938c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f15937b = handlerThread;
                    handlerThread.start();
                    this.f15936a = new Handler(this.f15937b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static k d() {
        if (f15935e == null) {
            f15935e = new k();
        }
        return f15935e;
    }

    private void f() {
        synchronized (this.f15939d) {
            this.f15937b.quit();
            this.f15937b = null;
            this.f15936a = null;
        }
    }

    protected void b() {
        synchronized (this.f15939d) {
            try {
                int i10 = this.f15938c - 1;
                this.f15938c = i10;
                if (i10 == 0) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void c(Runnable runnable) {
        synchronized (this.f15939d) {
            a();
            this.f15936a.post(runnable);
        }
    }

    protected void e(Runnable runnable) {
        synchronized (this.f15939d) {
            this.f15938c++;
            c(runnable);
        }
    }

    private k() {
    }
}
