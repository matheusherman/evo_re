package ka;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lock f12179b;

    public d(Lock lock) {
        kotlin.jvm.internal.m.f(lock, "lock");
        this.f12179b = lock;
    }

    public /* synthetic */ d(Lock lock, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? new ReentrantLock() : lock);
    }

    protected final Lock a() {
        return this.f12179b;
    }

    @Override // ka.k
    public void lock() {
        this.f12179b.lock();
    }

    @Override // ka.k
    public void unlock() {
        this.f12179b.unlock();
    }
}
