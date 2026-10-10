package ka;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f12177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c9.l<InterruptedException, z> f12178d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(Lock lock, Runnable checkCancelled, c9.l<? super InterruptedException, z> interruptedExceptionHandler) {
        super(lock);
        kotlin.jvm.internal.m.f(lock, "lock");
        kotlin.jvm.internal.m.f(checkCancelled, "checkCancelled");
        kotlin.jvm.internal.m.f(interruptedExceptionHandler, "interruptedExceptionHandler");
        this.f12177c = checkCancelled;
        this.f12178d = interruptedExceptionHandler;
    }

    @Override // ka.d, ka.k
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f12177c.run();
            } catch (InterruptedException e10) {
                this.f12178d.invoke(e10);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Runnable checkCancelled, c9.l<? super InterruptedException, z> interruptedExceptionHandler) {
        this(new ReentrantLock(), checkCancelled, interruptedExceptionHandler);
        kotlin.jvm.internal.m.f(checkCancelled, "checkCancelled");
        kotlin.jvm.internal.m.f(interruptedExceptionHandler, "interruptedExceptionHandler");
    }
}
