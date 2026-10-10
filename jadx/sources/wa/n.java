package wa;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u00020\u00162\n\u0010\n\u001a\u00060\bj\u0002`\t2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u001f*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010\u001eJ!\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\r¢\u0006\u0004\b$\u0010%J)\u0010&\u001a\u00020\u00162\n\u0010\n\u001a\u00060\bj\u0002`\t2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b'\u0010\u001eJ\u0015\u0010)\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0019¢\u0006\u0004\b)\u0010*R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010,R\u0014\u00100\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u000b\u00104\u001a\u0002038\u0002X\u0082\u0004R\u000b\u00105\u001a\u0002038\u0002X\u0082\u0004R\u0013\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004068\u0002X\u0082\u0004R\u000b\u00108\u001a\u0002038\u0002X\u0082\u0004¨\u00069"}, d2 = {"Lwa/n;", "", "<init>", "()V", "Lwa/h;", "task", "b", "(Lwa/h;)Lwa/h;", "", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "l", "(I)Lwa/h;", "", "onlyBlocking", "k", "(Z)Lwa/h;", "index", "m", "(IZ)Lwa/h;", "Lkotlin/jvm/internal/b0;", "stolenTaskRef", "", "o", "(ILkotlin/jvm/internal/b0;)J", "Lwa/d;", "queue", "j", "(Lwa/d;)Z", "i", "()Lwa/h;", "Lr8/z;", "c", "(Lwa/h;)V", "g", "fair", "a", "(Lwa/h;Z)Lwa/h;", "n", "h", "globalQueue", "f", "(Lwa/d;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "d", "()I", "bufferSize", "e", "size", "Lkotlinx/atomicfu/AtomicInt;", "blockingTasksInBuffer", "consumerIndex", "Lkotlinx/atomicfu/AtomicRef;", "lastScheduledTask", "producerIndex", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f20449b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f20450c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f20451d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f20452e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AtomicReferenceArray<h> buffer = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final h h() {
        return k(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long n(int stealingMode, b0<h> stolenTaskRef) {
        h hVarL;
        T t10;
        h hVarI;
        if (stealingMode == 3) {
            hVarI = i();
        } else {
            hVarL = l(stealingMode);
        }
        if (t10 == 0) {
            t10 = hVarL;
            t10 = hVarI;
            return o(stealingMode, stolenTaskRef);
        }
        t10 = hVarL;
        t10 = hVarI;
        stolenTaskRef.element = t10;
        return -1L;
    }

    private final void c(h hVar) {
        if (hVar == null || hVar.taskContext.getTaskMode() != 1) {
            return;
        }
        f20452e.decrementAndGet(this);
    }

    private final int d() {
        return f20450c.get(this) - f20451d.get(this);
    }

    private final h i() {
        h andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20451d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f20450c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (andSet = this.buffer.getAndSet(i11, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    private final h k(boolean onlyBlocking) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f20449b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar != null) {
                if ((hVar.taskContext.getTaskMode() == 1) == onlyBlocking) {
                }
            }
            int i10 = f20451d.get(this);
            int i11 = f20450c.get(this);
            while (i10 != i11) {
                if (onlyBlocking && f20452e.get(this) == 0) {
                    return null;
                }
                i11--;
                h hVarM = m(i11, onlyBlocking);
                if (hVarM != null) {
                    return hVarM;
                }
            }
            return null;
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, hVar, null));
        return hVar;
    }

    private final h l(int stealingMode) {
        int i10 = f20451d.get(this);
        int i11 = f20450c.get(this);
        boolean z10 = stealingMode == 1;
        while (i10 != i11) {
            if (z10 && f20452e.get(this) == 0) {
                return null;
            }
            int i12 = i10 + 1;
            h hVarM = m(i10, z10);
            if (hVarM != null) {
                return hVarM;
            }
            i10 = i12;
        }
        return null;
    }

    private final h m(int index, boolean onlyBlocking) {
        int i10 = index & 127;
        h hVar = this.buffer.get(i10);
        if (hVar != null) {
            if ((hVar.taskContext.getTaskMode() == 1) == onlyBlocking && kotlinx.coroutines.channels.i.a(this.buffer, i10, hVar, null)) {
                if (onlyBlocking) {
                    f20452e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, wa.h] */
    private final long o(int stealingMode, b0<h> stolenTaskRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r10;
        do {
            atomicReferenceFieldUpdater = f20449b;
            r10 = (h) atomicReferenceFieldUpdater.get(this);
            if (r10 == 0) {
                return -2L;
            }
            if (((r10.taskContext.getTaskMode() != 1 ? 2 : 1) & stealingMode) == 0) {
                return -2L;
            }
            long jA = l.f20445f.a() - r10.submissionTime;
            long j10 = l.f20441b;
            if (jA < j10) {
                return j10 - jA;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, r10, null));
        stolenTaskRef.element = r10;
        return -1L;
    }

    public final h a(h task, boolean fair) {
        if (fair) {
            return b(task);
        }
        h hVar = (h) f20449b.getAndSet(this, task);
        if (hVar == null) {
            return null;
        }
        return b(hVar);
    }

    public final int e() {
        return f20449b.get(this) != null ? d() + 1 : d();
    }

    public final void f(d globalQueue) {
        h hVar = (h) f20449b.getAndSet(this, null);
        if (hVar != null) {
            globalQueue.a(hVar);
        }
        while (j(globalQueue)) {
        }
    }

    public final h g() {
        h hVar = (h) f20449b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    private final h b(h task) {
        if (d() == 127) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 1) {
            f20452e.incrementAndGet(this);
        }
        int i10 = f20450c.get(this) & 127;
        while (this.buffer.get(i10) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i10, task);
        f20450c.incrementAndGet(this);
        return null;
    }

    private final boolean j(d queue) {
        h hVarI = i();
        if (hVarI == null) {
            return false;
        }
        queue.a(hVarI);
        return true;
    }
}
