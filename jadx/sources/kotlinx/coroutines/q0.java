package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00062\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0005R\u0014\u0010\u001c\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0005R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0014\u0010&\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\rR\u0014\u0010(\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\n¨\u0006)"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/f1;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "()V", "Lr8/z;", "x0", "Ljava/lang/Thread;", "t0", "()Ljava/lang/Thread;", "", "w0", "()Z", "s0", "task", "i0", "(Ljava/lang/Runnable;)V", "", "now", "Lkotlinx/coroutines/f1$b;", "delayedTask", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(JLkotlinx/coroutines/f1$b;)V", "shutdown", "run", "h", "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "debugStatus", "I", "u0", "isShutDown", "v0", "isShutdownRequested", ExifInterface.LATITUDE_SOUTH, "thread", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class q0 extends f1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q0 f14902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final long KEEP_ALIVE_NANOS;

    private final synchronized void s0() {
        if (v0()) {
            debugStatus = 3;
            n0();
            kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread t0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final synchronized boolean w0() {
        if (v0()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    @Override // kotlinx.coroutines.f1, kotlinx.coroutines.e1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    static {
        Long l10;
        q0 q0Var = new q0();
        f14902g = q0Var;
        e1.F(q0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l10.longValue());
    }

    private final boolean u0() {
        return debugStatus == 4;
    }

    private final boolean v0() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    private final void x0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.g1
    /* JADX INFO: renamed from: S */
    protected Thread getThread() {
        Thread thread = _thread;
        return thread == null ? t0() : thread;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zL0;
        t2.f14936a.d(this);
        c.a();
        try {
            if (!w0()) {
                if (zL0) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jM = M();
                if (jM == LocationRequestCompat.PASSIVE_INTERVAL) {
                    c.a();
                    long jNanoTime = System.nanoTime();
                    if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                        j10 = KEEP_ALIVE_NANOS + jNanoTime;
                    }
                    long j11 = j10 - jNanoTime;
                    if (j11 <= 0) {
                        if (zL0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    jM = h9.f.f(jM, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jM > 0) {
                    if (v0()) {
                        if (zL0) {
                            return;
                        } else {
                            return;
                        }
                    } else {
                        c.a();
                        LockSupport.parkNanos(this, jM);
                    }
                }
            }
        } finally {
            _thread = null;
            s0();
            c.a();
            if (!l0()) {
                getThread();
            }
        }
    }

    private q0() {
    }

    @Override // kotlinx.coroutines.g1
    protected void V(long now, f1.b delayedTask) {
        x0();
    }

    @Override // kotlinx.coroutines.f1
    public void i0(Runnable task) {
        if (u0()) {
            x0();
        }
        super.i0(task);
    }
}
