package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/f;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/a;", "Lv8/j;", "parentContext", "Ljava/lang/Thread;", "blockedThread", "Lkotlinx/coroutines/e1;", "eventLoop", "<init>", "(Lv8/j;Ljava/lang/Thread;Lkotlinx/coroutines/e1;)V", "", "state", "Lr8/z;", "F", "(Ljava/lang/Object;)V", "M0", "()Ljava/lang/Object;", "d", "Ljava/lang/Thread;", "e", "Lkotlinx/coroutines/e1;", "", "g0", "()Z", "isScopedCoroutine", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class f<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Thread blockedThread;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final e1 eventLoop;

    public f(v8.j jVar, Thread thread, e1 e1Var) {
        super(jVar, true, true);
        this.blockedThread = thread;
        this.eventLoop = e1Var;
    }

    @Override // kotlinx.coroutines.c2
    protected boolean g0() {
        return true;
    }

    @Override // kotlinx.coroutines.c2
    protected void F(Object state) {
        if (!kotlin.jvm.internal.m.a(Thread.currentThread(), this.blockedThread)) {
            Thread thread = this.blockedThread;
            c.a();
            LockSupport.unpark(thread);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T M0() throws Throwable {
        long jM;
        c.a();
        try {
            e1 e1Var = this.eventLoop;
            b0 b0Var = null;
            if (e1Var != null) {
                e1.F(e1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    e1 e1Var2 = this.eventLoop;
                    if (e1Var2 != null) {
                        jM = e1Var2.M();
                    } else {
                        jM = LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                    if (!f0()) {
                        c.a();
                        LockSupport.parkNanos(this, jM);
                    } else {
                        e1 e1Var3 = this.eventLoop;
                        if (e1Var3 != null) {
                            e1.o(e1Var3, false, 1, null);
                        }
                        c.a();
                        T t10 = (T) d2.h(b0());
                        if (t10 instanceof b0) {
                            b0Var = (b0) t10;
                        }
                        if (b0Var == null) {
                            return t10;
                        }
                        throw b0Var.cause;
                    }
                } catch (Throwable th) {
                    e1 e1Var4 = this.eventLoop;
                    if (e1Var4 != null) {
                        e1.o(e1Var4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            I(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            c.a();
            throw th2;
        }
    }
}
