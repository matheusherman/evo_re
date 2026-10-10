package g1;

import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@VisibleForTesting
final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<a> f10427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final CountDownLatch f10429c = new CountDownLatch(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f10430d = false;

    private final void a() {
        a aVar = this.f10427a.get();
        if (aVar != null) {
            aVar.c();
            this.f10430d = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.f10429c.await(this.f10428b, TimeUnit.MILLISECONDS)) {
                return;
            }
            a();
        } catch (InterruptedException unused) {
            a();
        }
    }

    public c(a aVar, long j10) {
        this.f10427a = new WeakReference<>(aVar);
        this.f10428b = j10;
        start();
    }
}
