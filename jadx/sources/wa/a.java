package wa;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.p0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0003C!<B+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0018\u00010\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\"J+\u0010$\u001a\u0004\u0018\u00010\f*\b\u0018\u00010\u0011R\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0018\u00010\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b&\u0010\u0013J)\u0010)\u001a\u00020\u00192\n\u0010\u0014\u001a\u00060\u0011R\u00020\u00002\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u00020\u000e2\n\u0010\u0014\u001a\u00060\u0011R\u00020\u0000¢\u0006\u0004\b+\u0010,J\u001b\u00100\u001a\u00020\u00192\n\u0010/\u001a\u00060-j\u0002`.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0019H\u0016¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0006¢\u0006\u0004\b5\u00106J-\u0010:\u001a\u00020\u00192\n\u00107\u001a\u00060-j\u0002`.2\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010#\u001a\u00020\u000e¢\u0006\u0004\b:\u0010;J!\u0010<\u001a\u00020\f2\n\u00107\u001a\u00060-j\u0002`.2\u0006\u00109\u001a\u000208¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u0019¢\u0006\u0004\b>\u00103J\u000f\u0010?\u001a\u00020\bH\u0016¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\bA\u0010BR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010DR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010ER\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010FR\u0014\u0010J\u001a\u00020G8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020G8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010IR\u001e\u0010O\u001a\f\u0012\b\u0012\u00060\u0011R\u00020\u00000L8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0011\u0010P\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bP\u0010 R\u000b\u0010R\u001a\u00020Q8\u0002X\u0082\u0004R\u000b\u0010T\u001a\u00020S8\u0002X\u0082\u0004R\u000b\u0010U\u001a\u00020S8\u0002X\u0082\u0004¨\u0006W"}, d2 = {"Lwa/a;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lwa/h;", "task", "", "b", "(Lwa/h;)Z", "Lwa/a$c;", "l", "()Lwa/a$c;", "worker", "k", "(Lwa/a$c;)I", "stateSnapshot", "skipUnpark", "Lr8/z;", "q", "(JZ)V", "state", "t", "(J)Z", "v", "()Z", "c", "()I", "tailDispatch", "s", "(Lwa/a$c;Lwa/h;Z)Lwa/h;", "f", "oldIndex", "newIndex", "n", "(Lwa/a$c;II)V", "m", "(Lwa/a$c;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "p", "(J)V", "block", "Lwa/i;", "taskContext", "i", "(Ljava/lang/Runnable;Lwa/i;Z)V", "d", "(Ljava/lang/Runnable;Lwa/i;)Lwa/h;", "r", "toString", "()Ljava/lang/String;", "o", "(Lwa/h;)V", "a", "I", "J", "Ljava/lang/String;", "Lwa/d;", "e", "Lwa/d;", "globalCpuQueue", "globalBlockingQueue", "Lkotlinx/coroutines/internal/a0;", "g", "Lkotlinx/coroutines/internal/a0;", "workers", "isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "_isTerminated", "Lkotlinx/atomicfu/AtomicLong;", "controlState", "parkedWorkersStack", "h", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f20400i = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f20401j = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f20402k = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f0 f20403l = new f0("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int corePoolSize;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int maxPoolSize;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long idleWorkerKeepAliveNs;
    private volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String schedulerName;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final wa.d globalCpuQueue;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final wa.d globalBlockingQueue;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final a0<c> workers;
    private volatile long parkedWorkersStack;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b \u0010\u001cJ\u001d\u0010#\u001a\u0004\u0018\u00010\u000f2\n\u0010\"\u001a\u00060\u0004j\u0002`!H\u0002¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\fJ\u0015\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0007¢\u0006\u0004\b.\u0010\u001fR*\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0015R\u0014\u00107\u001a\u0002048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u00109R\u0016\u0010<\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010>R$\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010>R\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00100R\u0016\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010IR\b\u0010K\u001a\u00020J8\u0006¨\u0006L"}, d2 = {"Lwa/a$c;", "Ljava/lang/Thread;", "<init>", "(Lwa/a;)V", "", "index", "(Lwa/a;I)V", "", "u", "()Z", "Lr8/z;", "r", "()V", "v", "n", "Lwa/h;", "task", "d", "(Lwa/h;)V", "taskMode", "c", "(I)V", "b", "p", "z", "mode", "m", "f", "()Lwa/h;", "scanLocalQueue", "e", "(Z)Lwa/h;", "q", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "x", "(I)Lwa/h;", "Lwa/a$d;", "newState", "w", "(Lwa/a$d;)Z", "run", "upperBound", "o", "(I)I", "mayHaveLocalTasks", "g", "indexInArray", "I", "h", "()I", "s", "Lwa/n;", "a", "Lwa/n;", "localQueue", "Lkotlin/jvm/internal/b0;", "Lkotlin/jvm/internal/b0;", "stolenTask", "Lwa/a$d;", "state", "", "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "j", "()Ljava/lang/Object;", "t", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "Lkotlinx/atomicfu/AtomicInt;", "workerCtl", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class c extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f20412i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final n localQueue;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final b0<h> stolenTask;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        public d state;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long terminationDeadline;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long minDelayUntilStealableTaskNs;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int rngState;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        public boolean mayHaveLocalTasks;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        private c() {
            setDaemon(true);
            this.localQueue = new n();
            this.stolenTask = new b0<>();
            this.state = d.DORMANT;
            this.nextParkedWorker = a.f20403l;
            this.rngState = f9.c.INSTANCE.b();
        }

        private final h q() {
            if (o(2) == 0) {
                h hVarD = a.this.globalCpuQueue.d();
                return hVarD != null ? hVarD : a.this.globalBlockingQueue.d();
            }
            h hVarD2 = a.this.globalBlockingQueue.d();
            return hVarD2 != null ? hVarD2 : a.this.globalCpuQueue.d();
        }

        private final void r() {
            loop0: while (true) {
                boolean z10 = false;
                while (true) {
                    if (a.this.isTerminated() || this.state == d.TERMINATED) {
                        break loop0;
                    }
                    h hVarG = g(this.mayHaveLocalTasks);
                    if (hVarG != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        d(hVarG);
                        break;
                    }
                    this.mayHaveLocalTasks = false;
                    if (this.minDelayUntilStealableTaskNs == 0) {
                        v();
                    } else {
                        if (z10) {
                            w(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                            break;
                        }
                        z10 = true;
                    }
                }
            }
            w(d.TERMINATED);
        }

        private final void b(int taskMode) {
            if (taskMode == 0) {
                return;
            }
            a.f20401j.addAndGet(a.this, -2097152L);
            if (this.state != d.TERMINATED) {
                this.state = d.DORMANT;
            }
        }

        private final void c(int taskMode) {
            if (taskMode != 0 && w(d.BLOCKING)) {
                a.this.r();
            }
        }

        private final void d(h task) {
            int taskMode = task.taskContext.getTaskMode();
            m(taskMode);
            c(taskMode);
            a.this.o(task);
            b(taskMode);
        }

        private final h e(boolean scanLocalQueue) {
            h hVarQ;
            h hVarQ2;
            if (scanLocalQueue) {
                boolean z10 = o(a.this.corePoolSize * 2) == 0;
                if (z10 && (hVarQ2 = q()) != null) {
                    return hVarQ2;
                }
                h hVarG = this.localQueue.g();
                if (hVarG != null) {
                    return hVarG;
                }
                if (!z10 && (hVarQ = q()) != null) {
                    return hVarQ;
                }
            } else {
                h hVarQ3 = q();
                if (hVarQ3 != null) {
                    return hVarQ3;
                }
            }
            return x(3);
        }

        private final h f() {
            h hVarH = this.localQueue.h();
            if (hVarH != null) {
                return hVarH;
            }
            h hVarD = a.this.globalBlockingQueue.d();
            return hVarD == null ? x(1) : hVarD;
        }

        public static final AtomicIntegerFieldUpdater k() {
            return f20412i;
        }

        private final void m(int mode) {
            this.terminationDeadline = 0L;
            if (this.state == d.PARKING) {
                this.state = d.BLOCKING;
            }
        }

        private final boolean n() {
            return this.nextParkedWorker != a.f20403l;
        }

        private final void p() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + a.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(a.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                z();
            }
        }

        private final boolean u() {
            long j10;
            if (this.state == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = a.f20401j;
            do {
                j10 = atomicLongFieldUpdater.get(aVar);
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    return false;
                }
            } while (!a.f20401j.compareAndSet(aVar, j10, j10 - 4398046511104L));
            this.state = d.CPU_ACQUIRED;
            return true;
        }

        private final h x(int stealingMode) {
            int i10 = (int) (a.f20401j.get(a.this) & 2097151);
            if (i10 < 2) {
                return null;
            }
            int iO = o(i10);
            a aVar = a.this;
            long jMin = Long.MAX_VALUE;
            for (int i11 = 0; i11 < i10; i11++) {
                iO++;
                if (iO > i10) {
                    iO = 1;
                }
                c cVarB = aVar.workers.b(iO);
                if (cVarB != null && cVarB != this) {
                    long jN = cVarB.localQueue.n(stealingMode, this.stolenTask);
                    if (jN == -1) {
                        b0<h> b0Var = this.stolenTask;
                        h hVar = b0Var.element;
                        b0Var.element = null;
                        return hVar;
                    }
                    if (jN > 0) {
                        jMin = Math.min(jMin, jN);
                    }
                }
            }
            if (jMin == LocationRequestCompat.PASSIVE_INTERVAL) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }

        private final void z() {
            a aVar = a.this;
            synchronized (aVar.workers) {
                try {
                    if (aVar.isTerminated()) {
                        return;
                    }
                    if (((int) (a.f20401j.get(aVar) & 2097151)) <= aVar.corePoolSize) {
                        return;
                    }
                    if (f20412i.compareAndSet(this, -1, 1)) {
                        int i10 = this.indexInArray;
                        s(0);
                        aVar.n(this, i10, 0);
                        int andDecrement = (int) (2097151 & a.f20401j.getAndDecrement(aVar));
                        if (andDecrement != i10) {
                            c cVarB = aVar.workers.b(andDecrement);
                            kotlin.jvm.internal.m.c(cVarB);
                            c cVar = cVarB;
                            aVar.workers.c(i10, cVar);
                            cVar.s(i10);
                            aVar.n(cVar, andDecrement, i10);
                        }
                        aVar.workers.c(andDecrement, null);
                        z zVar = z.f17874a;
                        this.state = d.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final int getIndexInArray() {
            return this.indexInArray;
        }

        /* JADX INFO: renamed from: j, reason: from getter */
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int o(int upperBound) {
            int i10 = this.rngState;
            int i11 = i10 ^ (i10 << 13);
            int i12 = i11 ^ (i11 >> 17);
            int i13 = i12 ^ (i12 << 5);
            this.rngState = i13;
            int i14 = upperBound - 1;
            return (i14 & upperBound) == 0 ? i13 & i14 : (i13 & Integer.MAX_VALUE) % upperBound;
        }

        public final void s(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.this.schedulerName);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void t(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean w(d newState) {
            d dVar = this.state;
            boolean z10 = dVar == d.CPU_ACQUIRED;
            if (z10) {
                a.f20401j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar != newState) {
                this.state = newState;
            }
            return z10;
        }

        private final void v() {
            if (!n()) {
                a.this.m(this);
                return;
            }
            f20412i.set(this, -1);
            while (n() && f20412i.get(this) == -1 && !a.this.isTerminated() && this.state != d.TERMINATED) {
                w(d.PARKING);
                Thread.interrupted();
                p();
            }
        }

        public final h g(boolean mayHaveLocalTasks) {
            if (u()) {
                return e(mayHaveLocalTasks);
            }
            return f();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            r();
        }

        public c(a aVar, int i10) {
            this();
            s(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lwa/a$d;", "", "<init>", "(Ljava/lang/String;I)V", "a", "b", "c", "d", "e", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        j(this, command, null, false, 6, null);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20411a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f20411a = iArr;
        }
    }

    private final boolean b(h task) {
        return task.taskContext.getTaskMode() == 1 ? this.globalBlockingQueue.a(task) : this.globalCpuQueue.a(task);
    }

    private final int c() {
        synchronized (this.workers) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f20401j;
                long j10 = atomicLongFieldUpdater.get(this);
                int i10 = (int) (j10 & 2097151);
                int iC = h9.f.c(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
                if (iC >= this.corePoolSize) {
                    return 0;
                }
                if (i10 >= this.maxPoolSize) {
                    return 0;
                }
                int i11 = ((int) (f20401j.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.workers.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i11);
                this.workers.c(i11, cVar);
                if (i11 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = iC + 1;
                cVar.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void j(a aVar, Runnable runnable, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = l.f20446g;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.i(runnable, iVar, z10);
    }

    private final c l() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f20400i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c cVarB = this.workers.b((int) (2097151 & j10));
            if (cVarB == null) {
                return null;
            }
            long j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            int iK = k(cVarB);
            if (iK >= 0 && f20400i.compareAndSet(this, j10, ((long) iK) | j11)) {
                cVarB.t(f20403l);
                return cVarB;
            }
        }
    }

    private final void q(long stateSnapshot, boolean skipUnpark) {
        if (skipUnpark || v() || t(stateSnapshot)) {
            return;
        }
        v();
    }

    private final h s(c cVar, h hVar, boolean z10) {
        if (cVar == null || cVar.state == d.TERMINATED) {
            return hVar;
        }
        if (hVar.taskContext.getTaskMode() == 0 && cVar.state == d.BLOCKING) {
            return hVar;
        }
        cVar.mayHaveLocalTasks = true;
        return cVar.localQueue.a(hVar, z10);
    }

    static /* synthetic */ boolean u(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f20401j.get(aVar);
        }
        return aVar.t(j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        p(10000L);
    }

    public final h d(Runnable block, i taskContext) {
        long jA = l.f20445f.a();
        if (!(block instanceof h)) {
            return new k(block, jA, taskContext);
        }
        h hVar = (h) block;
        hVar.submissionTime = jA;
        hVar.taskContext = taskContext;
        return hVar;
    }

    public final boolean isTerminated() {
        return f20402k.get(this) != 0;
    }

    public final void n(c worker, int oldIndex, int newIndex) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f20400i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int iK = (int) (2097151 & j10);
            long j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            if (iK == oldIndex) {
                iK = newIndex == 0 ? k(worker) : newIndex;
            }
            if (iK >= 0 && f20400i.compareAndSet(this, j10, j11 | ((long) iK))) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    public final void p(long timeout) throws InterruptedException {
        int i10;
        h hVarD;
        if (f20402k.compareAndSet(this, 0, 1)) {
            c cVarF = f();
            synchronized (this.workers) {
                i10 = (int) (f20401j.get(this) & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    c cVarB = this.workers.b(i11);
                    kotlin.jvm.internal.m.c(cVarB);
                    c cVar = cVarB;
                    if (cVar != cVarF) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(timeout);
                        }
                        cVar.localQueue.f(this.globalBlockingQueue);
                    }
                    if (i11 == i10) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            this.globalBlockingQueue.b();
            this.globalCpuQueue.b();
            while (true) {
                if (cVarF == null) {
                    hVarD = this.globalCpuQueue.d();
                    if (hVarD == null && (hVarD = this.globalBlockingQueue.d()) == null) {
                        break;
                    }
                } else {
                    hVarD = cVarF.g(true);
                    if (hVarD == null) {
                        hVarD = this.globalCpuQueue.d();
                        if (hVarD == null) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                o(hVarD);
            }
            if (cVarF != null) {
                cVarF.w(d.TERMINATED);
            }
            f20400i.set(this, 0L);
            f20401j.set(this, 0L);
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.workers.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iA; i15++) {
            c cVarB = this.workers.b(i15);
            if (cVarB != null) {
                int iE = cVarB.localQueue.e();
                int i16 = b.f20411a[cVarB.state.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iE);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(iE);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (iE > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(iE);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = f20401j.get(this);
        return this.schedulerName + '@' + p0.b(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.c() + ", global blocking queue size = " + this.globalBlockingQueue.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public a(int i10, int i11, long j10, String str) {
        this.corePoolSize = i10;
        this.maxPoolSize = i11;
        this.idleWorkerKeepAliveNs = j10;
        this.schedulerName = str;
        if (i10 >= 1) {
            if (i11 >= i10) {
                if (i11 <= 2097150) {
                    if (j10 > 0) {
                        this.globalCpuQueue = new wa.d();
                        this.globalBlockingQueue = new wa.d();
                        this.workers = new a0<>((i10 + 1) * 2);
                        this.controlState = ((long) i10) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
    }

    private final c f() {
        c cVar;
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof c) {
            cVar = (c) threadCurrentThread;
        } else {
            cVar = null;
        }
        if (cVar == null || !kotlin.jvm.internal.m.a(a.this, this)) {
            return null;
        }
        return cVar;
    }

    private final int k(c worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != f20403l) {
            if (nextParkedWorker == null) {
                return 0;
            }
            c cVar = (c) nextParkedWorker;
            int indexInArray = cVar.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = cVar.getNextParkedWorker();
        }
        return -1;
    }

    private final boolean t(long state) {
        if (h9.f.c(((int) (2097151 & state)) - ((int) ((state & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int iC = c();
            if (iC == 1 && this.corePoolSize > 1) {
                c();
            }
            if (iC > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean v() {
        c cVarL;
        do {
            cVarL = l();
            if (cVarL == null) {
                return false;
            }
        } while (!c.k().compareAndSet(cVarL, -1, 0));
        LockSupport.unpark(cVarL);
        return true;
    }

    public final void i(Runnable block, i taskContext, boolean tailDispatch) {
        boolean z10;
        long jAddAndGet;
        kotlinx.coroutines.c.a();
        h hVarD = d(block, taskContext);
        boolean z11 = false;
        if (hVarD.taskContext.getTaskMode() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            jAddAndGet = f20401j.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        } else {
            jAddAndGet = 0;
        }
        c cVarF = f();
        h hVarS = s(cVarF, hVarD, tailDispatch);
        if (hVarS != null && !b(hVarS)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        if (tailDispatch && cVarF != null) {
            z11 = true;
        }
        if (z10) {
            q(jAddAndGet, z11);
        } else {
            if (z11) {
                return;
            }
            r();
        }
    }

    public final boolean m(c worker) {
        long j10;
        long j11;
        int indexInArray;
        if (worker.getNextParkedWorker() != f20403l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f20400i;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            j11 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j10) & (-2097152);
            indexInArray = worker.getIndexInArray();
            worker.t(this.workers.b((int) (2097151 & j10)));
        } while (!f20400i.compareAndSet(this, j10, j11 | ((long) indexInArray)));
        return true;
    }

    public final void o(h task) {
        try {
            task.run();
            kotlinx.coroutines.c.a();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            } finally {
                kotlinx.coroutines.c.a();
            }
        }
    }

    public final void r() {
        if (v() || u(this, 0L, 1, null)) {
            return;
        }
        v();
    }
}
