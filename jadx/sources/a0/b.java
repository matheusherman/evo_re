package a0;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class b implements f, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f32a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final f f33b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile e f34c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile e f35d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private f.a f36e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private f.a f37f;

    @GuardedBy("requestLock")
    private boolean k(e eVar) {
        f.a aVar = this.f36e;
        f.a aVar2 = f.a.FAILED;
        if (aVar != aVar2) {
            return eVar.equals(this.f34c);
        }
        if (!eVar.equals(this.f35d)) {
            return false;
        }
        f.a aVar3 = this.f37f;
        return aVar3 == f.a.SUCCESS || aVar3 == aVar2;
    }

    @GuardedBy("requestLock")
    private boolean l() {
        f fVar = this.f33b;
        return fVar == null || fVar.c(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        f fVar = this.f33b;
        return fVar == null || fVar.e(this);
    }

    @GuardedBy("requestLock")
    private boolean n() {
        f fVar = this.f33b;
        return fVar == null || fVar.f(this);
    }

    @Override // a0.f, a0.e
    public boolean a() {
        boolean z10;
        synchronized (this.f32a) {
            try {
                z10 = this.f34c.a() || this.f35d.a();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.f
    public void b(e eVar) {
        synchronized (this.f32a) {
            try {
                if (eVar.equals(this.f34c)) {
                    this.f36e = f.a.SUCCESS;
                } else if (eVar.equals(this.f35d)) {
                    this.f37f = f.a.SUCCESS;
                }
                f fVar = this.f33b;
                if (fVar != null) {
                    fVar.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.f
    public boolean c(e eVar) {
        boolean z10;
        synchronized (this.f32a) {
            try {
                z10 = l() && eVar.equals(this.f34c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.e
    public void clear() {
        synchronized (this.f32a) {
            try {
                f.a aVar = f.a.CLEARED;
                this.f36e = aVar;
                this.f34c.clear();
                if (this.f37f != aVar) {
                    this.f37f = aVar;
                    this.f35d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.e
    public boolean d(e eVar) {
        if (eVar instanceof b) {
            b bVar = (b) eVar;
            if (this.f34c.d(bVar.f34c) && this.f35d.d(bVar.f35d)) {
                return true;
            }
        }
        return false;
    }

    @Override // a0.f
    public boolean e(e eVar) {
        boolean z10;
        synchronized (this.f32a) {
            try {
                z10 = m() && k(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.f
    public boolean f(e eVar) {
        boolean zN;
        synchronized (this.f32a) {
            zN = n();
        }
        return zN;
    }

    @Override // a0.e
    public boolean g() {
        boolean z10;
        synchronized (this.f32a) {
            try {
                f.a aVar = this.f36e;
                f.a aVar2 = f.a.CLEARED;
                z10 = aVar == aVar2 && this.f37f == aVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.f
    public f getRoot() {
        f root;
        synchronized (this.f32a) {
            try {
                f fVar = this.f33b;
                root = fVar != null ? fVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // a0.e
    public void h() {
        synchronized (this.f32a) {
            try {
                f.a aVar = this.f36e;
                f.a aVar2 = f.a.RUNNING;
                if (aVar != aVar2) {
                    this.f36e = aVar2;
                    this.f34c.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.f
    public void i(e eVar) {
        synchronized (this.f32a) {
            try {
                if (eVar.equals(this.f35d)) {
                    this.f37f = f.a.FAILED;
                    f fVar = this.f33b;
                    if (fVar != null) {
                        fVar.i(this);
                    }
                    return;
                }
                this.f36e = f.a.FAILED;
                f.a aVar = this.f37f;
                f.a aVar2 = f.a.RUNNING;
                if (aVar != aVar2) {
                    this.f37f = aVar2;
                    this.f35d.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a0.e
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f32a) {
            try {
                f.a aVar = this.f36e;
                f.a aVar2 = f.a.RUNNING;
                z10 = aVar == aVar2 || this.f37f == aVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // a0.e
    public boolean j() {
        boolean z10;
        synchronized (this.f32a) {
            try {
                f.a aVar = this.f36e;
                f.a aVar2 = f.a.SUCCESS;
                z10 = aVar == aVar2 || this.f37f == aVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public void o(e eVar, e eVar2) {
        this.f34c = eVar;
        this.f35d = eVar2;
    }

    @Override // a0.e
    public void pause() {
        synchronized (this.f32a) {
            try {
                f.a aVar = this.f36e;
                f.a aVar2 = f.a.RUNNING;
                if (aVar == aVar2) {
                    this.f36e = f.a.PAUSED;
                    this.f34c.pause();
                }
                if (this.f37f == aVar2) {
                    this.f37f = f.a.PAUSED;
                    this.f35d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public b(Object obj, @Nullable f fVar) {
        f.a aVar = f.a.CLEARED;
        this.f36e = aVar;
        this.f37f = aVar;
        this.f32a = obj;
        this.f33b = fVar;
    }
}
