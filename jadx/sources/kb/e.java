package kb;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0003\u001a\u001f\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010#R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010(R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010,¨\u0006."}, d2 = {"Lkb/e;", "", "Lkb/e$a;", "backend", "<init>", "(Lkb/e$a;)V", "Lkb/a;", "task", "Lr8/z;", "e", "(Lkb/a;)V", "j", "", "delayNanos", "c", "(Lkb/a;J)V", "Lkb/d;", "taskQueue", "h", "(Lkb/d;)V", "d", "()Lkb/a;", "i", "()Lkb/d;", "f", "()V", "a", "Lkb/e$a;", "g", "()Lkb/e$a;", "", "b", "I", "nextQueueName", "", "Z", "coordinatorWaiting", "J", "coordinatorWakeUpAt", "", "Ljava/util/List;", "busyQueues", "readyQueues", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f12223i = new e(new c(hb.d.M(hb.d.f10921i + " TaskRunner", true)));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Logger f12224j;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a backend;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int nextQueueName;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean coordinatorWaiting;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long coordinatorWakeUpAt;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<kb.d> busyQueues;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<kb.d> readyQueues;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Runnable runnable;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkb/e$a;", "", "", "c", "()J", "Lkb/e;", "taskRunner", "Lr8/z;", "a", "(Lkb/e;)V", "nanos", "b", "(Lkb/e;J)V", "Ljava/lang/Runnable;", "runnable", "execute", "(Ljava/lang/Runnable;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface a {
        void a(e taskRunner);

        void b(e taskRunner, long nanos);

        long c();

        void execute(Runnable runnable);
    }

    /* JADX INFO: renamed from: kb.e$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkb/e$b;", "", "<init>", "()V", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "a", "()Ljava/util/logging/Logger;", "Lkb/e;", "INSTANCE", "Lkb/e;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        public final Logger a() {
            return e.f12224j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkb/e$c;", "Lkb/e$a;", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "", "c", "()J", "Lkb/e;", "taskRunner", "Lr8/z;", "a", "(Lkb/e;)V", "nanos", "b", "(Lkb/e;J)V", "Ljava/lang/Runnable;", "runnable", "execute", "(Ljava/lang/Runnable;)V", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ThreadPoolExecutor executor;

        public c(ThreadFactory threadFactory) {
            m.f(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // kb.e.a
        public void a(e taskRunner) {
            m.f(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // kb.e.a
        public void b(e taskRunner, long nanos) throws InterruptedException {
            m.f(taskRunner, "taskRunner");
            long j10 = nanos / 1000000;
            long j11 = nanos - (1000000 * j10);
            if (j10 > 0 || nanos > 0) {
                taskRunner.wait(j10, (int) j11);
            }
        }

        @Override // kb.e.a
        public void execute(Runnable runnable) {
            m.f(runnable, "runnable");
            this.executor.execute(runnable);
        }

        @Override // kb.e.a
        public long c() {
            return System.nanoTime();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kb/e$d", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            kb.a aVarD;
            long jC;
            while (true) {
                e eVar = e.this;
                synchronized (eVar) {
                    aVarD = eVar.d();
                }
                if (aVarD == null) {
                    return;
                }
                kb.d queue = aVarD.getQueue();
                m.c(queue);
                e eVar2 = e.this;
                boolean zIsLoggable = e.INSTANCE.a().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jC = queue.getTaskRunner().getBackend().c();
                    b.c(aVarD, queue, "starting");
                } else {
                    jC = -1;
                }
                try {
                    eVar2.j(aVarD);
                    try {
                        z zVar = z.f17874a;
                        if (zIsLoggable) {
                            b.c(aVarD, queue, "finished run in " + b.b(queue.getTaskRunner().getBackend().c() - jC));
                        }
                    } catch (Throwable th) {
                        if (zIsLoggable) {
                            b.c(aVarD, queue, "failed a run in " + b.b(queue.getTaskRunner().getBackend().c() - jC));
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    eVar2.getBackend().execute(this);
                    throw th2;
                }
            }
        }
    }

    public final kb.d i() {
        int i10;
        synchronized (this) {
            i10 = this.nextQueueName;
            this.nextQueueName = i10 + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('Q');
        sb2.append(i10);
        return new kb.d(this, sb2.toString());
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        m.e(logger, "getLogger(TaskRunner::class.java.name)");
        f12224j = logger;
    }

    public e(a backend) {
        m.f(backend, "backend");
        this.backend = backend;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new d();
    }

    private final void c(kb.a task, long delayNanos) {
        if (hb.d.f10920h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        kb.d queue = task.getQueue();
        m.c(queue);
        if (queue.getActiveTask() != task) {
            throw new IllegalStateException("Check failed.");
        }
        boolean cancelActiveTask = queue.getCancelActiveTask();
        queue.m(false);
        queue.l(null);
        this.busyQueues.remove(queue);
        if (delayNanos != -1 && !cancelActiveTask && !queue.getShutdown()) {
            queue.k(task, delayNanos, true);
        }
        if (queue.e().isEmpty()) {
            return;
        }
        this.readyQueues.add(queue);
    }

    private final void e(kb.a task) {
        if (hb.d.f10920h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        task.g(-1L);
        kb.d queue = task.getQueue();
        m.c(queue);
        queue.e().remove(task);
        this.readyQueues.remove(queue);
        queue.l(task);
        this.busyQueues.add(queue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(kb.a task) {
        if (hb.d.f10920h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(task.getName());
        try {
            long jF = task.f();
            synchronized (this) {
                c(task, jF);
                z zVar = z.f17874a;
            }
        } finally {
            synchronized (this) {
                c(task, -1L);
                z zVar2 = z.f17874a;
                threadCurrentThread.setName(name);
            }
        }
    }

    public final kb.a d() {
        boolean z10;
        if (hb.d.f10920h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (!this.readyQueues.isEmpty()) {
            long jC = this.backend.c();
            Iterator<kb.d> it = this.readyQueues.iterator();
            long jMin = LocationRequestCompat.PASSIVE_INTERVAL;
            kb.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                kb.a aVar2 = it.next().e().get(0);
                long jMax = Math.max(0L, aVar2.getNextExecuteNanoTime() - jC);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z10 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                e(aVar);
                if (z10 || (!this.coordinatorWaiting && !this.readyQueues.isEmpty())) {
                    this.backend.execute(this.runnable);
                }
                return aVar;
            }
            if (this.coordinatorWaiting) {
                if (jMin < this.coordinatorWakeUpAt - jC) {
                    this.backend.a(this);
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = jC + jMin;
            try {
                try {
                    this.backend.b(this, jMin);
                } catch (InterruptedException unused) {
                    f();
                }
                this.coordinatorWaiting = false;
            } catch (Throwable th) {
                this.coordinatorWaiting = false;
                throw th;
            }
        }
        return null;
    }

    public final void f() {
        int size = this.busyQueues.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                this.busyQueues.get(size).b();
            }
        }
        for (int size2 = this.readyQueues.size() - 1; -1 < size2; size2--) {
            kb.d dVar = this.readyQueues.get(size2);
            dVar.b();
            if (dVar.e().isEmpty()) {
                this.readyQueues.remove(size2);
            }
        }
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final a getBackend() {
        return this.backend;
    }

    public final void h(kb.d taskQueue) {
        m.f(taskQueue, "taskQueue");
        if (hb.d.f10920h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (taskQueue.getActiveTask() == null) {
            if (taskQueue.e().isEmpty()) {
                this.readyQueues.remove(taskQueue);
            } else {
                hb.d.c(this.readyQueues, taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.a(this);
        } else {
            this.backend.execute(this.runnable);
        }
    }
}
