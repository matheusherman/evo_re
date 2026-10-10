package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\n\u0010\u001a\u001a\u00060\u000bj\u0002`\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\n\u0010\u001a\u001a\u00060\u000bj\u0002`\fH\u0017¢\u0006\u0004\b\u001d\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010 R\u001e\u0010$\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010)\u001a\u00060%j\u0002`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u000b\u0010+\u001a\u00020*8\u0002X\u0082\u0004¨\u0006,"}, d2 = {"Lkotlinx/coroutines/internal/m;", "Lkotlinx/coroutines/i0;", "Lkotlinx/coroutines/u0;", "dispatcher", "", "parallelism", "<init>", "(Lkotlinx/coroutines/i0;I)V", "", "u", "()Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "q", "()Ljava/lang/Runnable;", "", "timeMillis", "Lkotlinx/coroutines/n;", "Lr8/z;", "continuation", "b", "(JLkotlinx/coroutines/n;)V", "limitedParallelism", "(I)Lkotlinx/coroutines/i0;", "Lv8/j;", "context", "block", "dispatch", "(Lv8/j;Ljava/lang/Runnable;)V", "dispatchYield", "a", "Lkotlinx/coroutines/i0;", "I", "Lkotlinx/coroutines/internal/r;", "d", "Lkotlinx/coroutines/internal/r;", "queue", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "e", "Ljava/lang/Object;", "workerAllocationLock", "Lkotlinx/atomicfu/AtomicInt;", "runningWorkers", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class m extends kotlinx.coroutines.i0 implements u0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f14845f = AtomicIntegerFieldUpdater.newUpdater(m.class, "runningWorkers");

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final kotlinx.coroutines.i0 dispatcher;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int parallelism;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ u0 f14848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final r<Runnable> queue;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object workerAllocationLock;
    private volatile int runningWorkers;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00060\u0001j\u0002`\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/internal/m$a;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "<init>", "(Lkotlinx/coroutines/internal/m;Ljava/lang/Runnable;)V", "Lr8/z;", "run", "()V", "a", "Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Runnable currentTask;

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.currentTask.run();
                } catch (Throwable th) {
                    kotlinx.coroutines.k0.a(v8.k.f19724a, th);
                }
                Runnable runnableQ = m.this.q();
                if (runnableQ == null) {
                    return;
                }
                this.currentTask = runnableQ;
                i10++;
                if (i10 >= 16 && m.this.dispatcher.isDispatchNeeded(m.this)) {
                    m.this.dispatcher.dispatch(m.this, this);
                    return;
                }
            }
        }

        public a(Runnable runnable) {
            this.currentTask = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable q() {
        while (true) {
            Runnable runnableD = this.queue.d();
            if (runnableD != null) {
                return runnableD;
            }
            synchronized (this.workerAllocationLock) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14845f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.queue.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean u() {
        synchronized (this.workerAllocationLock) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14845f;
            if (atomicIntegerFieldUpdater.get(this) >= this.parallelism) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.u0
    public void b(long timeMillis, kotlinx.coroutines.n<? super r8.z> continuation) {
        this.f14848c.b(timeMillis, continuation);
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(v8.j context, Runnable block) {
        Runnable runnableQ;
        this.queue.a(block);
        if (f14845f.get(this) >= this.parallelism || !u() || (runnableQ = q()) == null) {
            return;
        }
        this.dispatcher.dispatch(this, new a(runnableQ));
    }

    @Override // kotlinx.coroutines.i0
    public void dispatchYield(v8.j context, Runnable block) {
        Runnable runnableQ;
        this.queue.a(block);
        if (f14845f.get(this) >= this.parallelism || !u() || (runnableQ = q()) == null) {
            return;
        }
        this.dispatcher.dispatchYield(this, new a(runnableQ));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(kotlinx.coroutines.i0 i0Var, int i10) {
        u0 u0Var;
        this.dispatcher = i0Var;
        this.parallelism = i10;
        if (i0Var instanceof u0) {
            u0Var = (u0) i0Var;
        } else {
            u0Var = null;
        }
        this.f14848c = u0Var == null ? r0.a() : u0Var;
        this.queue = new r<>(false);
        this.workerAllocationLock = new Object();
    }

    @Override // kotlinx.coroutines.i0
    public kotlinx.coroutines.i0 limitedParallelism(int parallelism) {
        n.a(parallelism);
        if (parallelism >= this.parallelism) {
            return this;
        }
        return super.limitedParallelism(parallelism);
    }
}
