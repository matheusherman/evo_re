package e2;

import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class l<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f9836a = new CountDownLatch(1);

    @Override // e2.e
    public final void a(T t10) {
        this.f9836a.countDown();
    }

    @Override // e2.b
    public final void b() {
        this.f9836a.countDown();
    }

    @Override // e2.d
    public final void c(@NonNull Exception exc) {
        this.f9836a.countDown();
    }

    public final void d() throws InterruptedException {
        this.f9836a.await();
    }

    public final boolean e(long j10, TimeUnit timeUnit) {
        return this.f9836a.await(j10, timeUnit);
    }

    /* synthetic */ l(k kVar) {
    }
}
