package a0;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class l implements f, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final f f88a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f89b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile e f90c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile e f91d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private f.a f92e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private f.a f93f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("requestLock")
    private boolean f94g;

    @GuardedBy("requestLock")
    private boolean k() {
        f fVar = this.f88a;
        return fVar == null || fVar.c(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        f fVar = this.f88a;
        return fVar == null || fVar.e(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        f fVar = this.f88a;
        return fVar == null || fVar.f(this);
    }

    @Override // a0.f, a0.e
    public boolean a() {
        boolean z10;
        synchronized (this.f89b) {
            try {
                z10 = this.f91d.a() || this.f90c.a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.f
    public void b(e eVar) {
        synchronized (this.f89b) {
            try {
                if (eVar.equals(this.f91d)) {
                    this.f93f = f.a.SUCCESS;
                    return;
                }
                this.f92e = f.a.SUCCESS;
                f fVar = this.f88a;
                if (fVar != null) {
                    fVar.b(this);
                }
                if (!this.f93f.a()) {
                    this.f91d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.f
    public boolean c(e eVar) {
        boolean z10;
        synchronized (this.f89b) {
            try {
                z10 = k() && eVar.equals(this.f90c) && this.f92e != f.a.PAUSED;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.e
    public void clear() {
        synchronized (this.f89b) {
            this.f94g = false;
            f.a aVar = f.a.CLEARED;
            this.f92e = aVar;
            this.f93f = aVar;
            this.f91d.clear();
            this.f90c.clear();
        }
    }

    @Override // a0.e
    public boolean d(e eVar) {
        if (eVar instanceof l) {
            l lVar = (l) eVar;
            if (this.f90c != null ? this.f90c.d(lVar.f90c) : lVar.f90c == null) {
                if (this.f91d == null) {
                    if (lVar.f91d == null) {
                        return true;
                    }
                } else if (this.f91d.d(lVar.f91d)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // a0.f
    public boolean e(e eVar) {
        boolean z10;
        synchronized (this.f89b) {
            try {
                z10 = l() && eVar.equals(this.f90c) && !a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.f
    public boolean f(e eVar) {
        boolean z10;
        synchronized (this.f89b) {
            try {
                z10 = m() && (eVar.equals(this.f90c) || this.f92e != f.a.SUCCESS);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.e
    public boolean g() {
        boolean z10;
        synchronized (this.f89b) {
            z10 = this.f92e == f.a.CLEARED;
        }
        return z10;
    }

    @Override // a0.f
    public f getRoot() {
        f root;
        synchronized (this.f89b) {
            try {
                f fVar = this.f88a;
                root = fVar != null ? fVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // a0.e
    public void h() {
        synchronized (this.f89b) {
            try {
                this.f94g = true;
                try {
                    if (this.f92e != f.a.SUCCESS) {
                        f.a aVar = this.f93f;
                        f.a aVar2 = f.a.RUNNING;
                        if (aVar != aVar2) {
                            this.f93f = aVar2;
                            this.f91d.h();
                        }
                    }
                    if (this.f94g) {
                        f.a aVar3 = this.f92e;
                        f.a aVar4 = f.a.RUNNING;
                        if (aVar3 != aVar4) {
                            this.f92e = aVar4;
                            this.f90c.h();
                        }
                    }
                    this.f94g = false;
                } catch (Throwable th) {
                    this.f94g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // a0.f
    public void i(e eVar) {
        synchronized (this.f89b) {
            try {
                if (!eVar.equals(this.f90c)) {
                    this.f93f = f.a.FAILED;
                    return;
                }
                this.f92e = f.a.FAILED;
                f fVar = this.f88a;
                if (fVar != null) {
                    fVar.i(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.e
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f89b) {
            z10 = this.f92e == f.a.RUNNING;
        }
        return z10;
    }

    @Override // a0.e
    public boolean j() {
        boolean z10;
        synchronized (this.f89b) {
            z10 = this.f92e == f.a.SUCCESS;
        }
        return z10;
    }

    public void n(e eVar, e eVar2) {
        this.f90c = eVar;
        this.f91d = eVar2;
    }

    @Override // a0.e
    public void pause() {
        synchronized (this.f89b) {
            try {
                if (!this.f93f.a()) {
                    this.f93f = f.a.PAUSED;
                    this.f91d.pause();
                }
                if (!this.f92e.a()) {
                    this.f92e = f.a.PAUSED;
                    this.f90c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public l(Object obj, @Nullable f fVar) {
        f.a aVar = f.a.CLEARED;
        this.f92e = aVar;
        this.f93f = aVar;
        this.f89b = obj;
        this.f88a = fVar;
    }
}
