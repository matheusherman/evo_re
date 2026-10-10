package n2;

import androidx.annotation.GuardedBy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class l implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f15845f = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f15846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("queue")
    private final Deque<Runnable> f15847b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("queue")
    private c f15848c = c.IDLE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("queue")
    private long f15849d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f15850e = new b(this, null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f15851a;

        a(Runnable runnable) {
            this.f15851a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15851a.run();
        }

        public String toString() {
            return this.f15851a.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Runnable f15853a;

        private b() {
        }

        /* JADX WARN: Code duplicated, block: B:46:0x003d A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        
            if (r1 == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        
            r8.f15853a.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
        
            n2.l.f15845f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.f15853a, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        
            r8.f15853a = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a() {
            Runnable runnable;
            boolean z10 = false;
            boolean zInterrupted = false;
            while (true) {
                try {
                    synchronized (l.this.f15847b) {
                        if (z10) {
                            runnable = (Runnable) l.this.f15847b.poll();
                            this.f15853a = runnable;
                            if (runnable == null) {
                                l.this.f15848c = c.IDLE;
                            }
                        } else {
                            c cVar = l.this.f15848c;
                            c cVar2 = c.RUNNING;
                            if (cVar != cVar2) {
                                l.d(l.this);
                                l.this.f15848c = cVar2;
                                z10 = true;
                                runnable = (Runnable) l.this.f15847b.poll();
                                this.f15853a = runnable;
                                if (runnable == null) {
                                    l.this.f15848c = c.IDLE;
                                }
                            }
                        }
                    }
                    if (zInterrupted) {
                        break;
                    } else {
                        return;
                    }
                    this.f15853a = null;
                } catch (Throwable th) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            Thread.currentThread().interrupt();
        }

        /* synthetic */ b(l lVar, a aVar) {
            this();
        }

        public String toString() {
            Runnable runnable = this.f15853a;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + l.this.f15848c + "}";
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (l.this.f15847b) {
                    l.this.f15848c = c.IDLE;
                    throw e10;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    static /* synthetic */ long d(l lVar) {
        long j10 = lVar.f15849d;
        lVar.f15849d = 1 + j10;
        return j10;
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f15846a + "}";
    }

    l(Executor executor) {
        this.f15846a = (Executor) m1.g.k(executor);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0061  */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c cVar;
        boolean z10;
        m1.g.k(runnable);
        synchronized (this.f15847b) {
            c cVar2 = this.f15848c;
            if (cVar2 != c.RUNNING && cVar2 != (cVar = c.QUEUED)) {
                long j10 = this.f15849d;
                a aVar = new a(runnable);
                this.f15847b.add(aVar);
                c cVar3 = c.QUEUING;
                this.f15848c = cVar3;
                try {
                    this.f15846a.execute(this.f15850e);
                    if (this.f15848c != cVar3) {
                        return;
                    }
                    synchronized (this.f15847b) {
                        try {
                            if (this.f15849d == j10 && this.f15848c == cVar3) {
                                this.f15848c = cVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e10) {
                    synchronized (this.f15847b) {
                        try {
                            c cVar4 = this.f15848c;
                            if (cVar4 == c.IDLE || cVar4 == c.QUEUING) {
                                if (this.f15847b.removeLastOccurrence(aVar)) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                            } else {
                                z10 = false;
                            }
                            if (!(e10 instanceof RejectedExecutionException) || z10) {
                                throw e10;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                }
            }
            this.f15847b.add(runnable);
        }
    }
}
