package xe;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class b implements Runnable, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f22188a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f22189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f22190c;

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                try {
                    j jVarC = this.f22188a.c(1000);
                    if (jVarC == null) {
                        synchronized (this) {
                            jVarC = this.f22188a.b();
                            if (jVarC == null) {
                                this.f22190c = false;
                                this.f22190c = false;
                                return;
                            }
                        }
                    }
                    this.f22189b.g(jVarC);
                } catch (InterruptedException e10) {
                    this.f22189b.e().b(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e10);
                    this.f22190c = false;
                    return;
                }
            } catch (Throwable th) {
                this.f22190c = false;
                throw th;
            }
        }
    }

    b(c cVar) {
        this.f22189b = cVar;
    }

    @Override // xe.l
    public void a(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            try {
                this.f22188a.a(jVarA);
                if (!this.f22190c) {
                    this.f22190c = true;
                    this.f22189b.d().execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
