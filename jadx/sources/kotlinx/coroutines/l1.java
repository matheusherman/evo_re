package kotlinx.coroutines;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f*\u00020\u00072\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lkotlinx/coroutines/l1;", "Lkotlinx/coroutines/k1;", "Lkotlinx/coroutines/u0;", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lv8/j;", "context", "", "timeMillis", "Ljava/util/concurrent/ScheduledFuture;", "q", "(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;Lv8/j;J)Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "Lr8/z;", "d", "(Lv8/j;Ljava/util/concurrent/RejectedExecutionException;)V", "dispatch", "(Lv8/j;Ljava/lang/Runnable;)V", "Lkotlinx/coroutines/n;", "continuation", "b", "(JLkotlinx/coroutines/n;)V", "close", "()V", "", "toString", "()Ljava/lang/String;", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/concurrent/Executor;", "o", "()Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class l1 extends k1 implements u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Executor executor;

    private final void d(v8.j context, RejectedExecutionException exception) {
        y1.c(context, j1.a("The task was rejected", exception));
    }

    private final ScheduledFuture<?> q(ScheduledExecutorService scheduledExecutorService, Runnable runnable, v8.j jVar, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            d(jVar, e10);
            return null;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof l1) && ((l1) other).getExecutor() == getExecutor();
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public Executor getExecutor() {
        return this.executor;
    }

    public l1(Executor executor) {
        this.executor = executor;
        kotlinx.coroutines.internal.c.a(getExecutor());
    }

    @Override // kotlinx.coroutines.u0
    public void b(long timeMillis, n<? super r8.z> continuation) {
        ScheduledExecutorService scheduledExecutorService;
        long j10;
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFutureQ = null;
        if (executor instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            j10 = timeMillis;
            scheduledFutureQ = q(scheduledExecutorService, new n2(this, continuation), continuation.getContext(), j10);
        } else {
            j10 = timeMillis;
        }
        if (scheduledFutureQ != null) {
            y1.f(continuation, scheduledFutureQ);
        } else {
            q0.f14902g.b(j10, continuation);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ExecutorService executorService;
        Executor executor = getExecutor();
        if (executor instanceof ExecutorService) {
            executorService = (ExecutorService) executor;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(v8.j context, Runnable block) {
        try {
            Executor executor = getExecutor();
            c.a();
            executor.execute(block);
        } catch (RejectedExecutionException e10) {
            c.a();
            d(context, e10);
            a1.b().dispatch(context, block);
        }
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        return getExecutor().toString();
    }
}
