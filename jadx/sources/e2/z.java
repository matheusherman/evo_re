package e2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class z<TResult> extends g<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f9860a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f9861b = new w();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f9863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Object f9864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Exception f9865f;

    private final void p() {
        m1.g.p(this.f9862c, "Task is not yet complete");
    }

    private final void q() {
        if (this.f9863d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void r() {
        if (this.f9862c) {
            throw a.a(this);
        }
    }

    private final void s() {
        synchronized (this.f9860a) {
            try {
                if (this.f9862c) {
                    this.f9861b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // e2.g
    @NonNull
    public final g<TResult> a(@NonNull Executor executor, @NonNull b bVar) {
        this.f9861b.a(new o(executor, bVar));
        s();
        return this;
    }

    @Override // e2.g
    @NonNull
    public final g<TResult> b(@NonNull c<TResult> cVar) {
        this.f9861b.a(new q(i.f9834a, cVar));
        s();
        return this;
    }

    @Override // e2.g
    @NonNull
    public final g<TResult> c(@NonNull Executor executor, @NonNull c<TResult> cVar) {
        this.f9861b.a(new q(executor, cVar));
        s();
        return this;
    }

    @Override // e2.g
    @NonNull
    public final g<TResult> d(@NonNull d dVar) {
        e(i.f9834a, dVar);
        return this;
    }

    @Override // e2.g
    @NonNull
    public final g<TResult> e(@NonNull Executor executor, @NonNull d dVar) {
        this.f9861b.a(new s(executor, dVar));
        s();
        return this;
    }

    @Override // e2.g
    @NonNull
    public final g<TResult> f(@NonNull Executor executor, @NonNull e<? super TResult> eVar) {
        this.f9861b.a(new u(executor, eVar));
        s();
        return this;
    }

    @Override // e2.g
    @Nullable
    public final Exception g() {
        Exception exc;
        synchronized (this.f9860a) {
            exc = this.f9865f;
        }
        return exc;
    }

    @Override // e2.g
    public final TResult h() {
        TResult tresult;
        synchronized (this.f9860a) {
            try {
                p();
                q();
                Exception exc = this.f9865f;
                if (exc != null) {
                    throw new f(exc);
                }
                tresult = (TResult) this.f9864e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    @Override // e2.g
    public final boolean i() {
        return this.f9863d;
    }

    @Override // e2.g
    public final boolean j() {
        boolean z10;
        synchronized (this.f9860a) {
            z10 = this.f9862c;
        }
        return z10;
    }

    @Override // e2.g
    public final boolean k() {
        boolean z10;
        synchronized (this.f9860a) {
            try {
                z10 = false;
                if (this.f9862c && !this.f9863d && this.f9865f == null) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public final void l(@NonNull Exception exc) {
        m1.g.l(exc, "Exception must not be null");
        synchronized (this.f9860a) {
            r();
            this.f9862c = true;
            this.f9865f = exc;
        }
        this.f9861b.b(this);
    }

    public final void m(@Nullable Object obj) {
        synchronized (this.f9860a) {
            r();
            this.f9862c = true;
            this.f9864e = obj;
        }
        this.f9861b.b(this);
    }

    public final boolean n(@NonNull Exception exc) {
        m1.g.l(exc, "Exception must not be null");
        synchronized (this.f9860a) {
            try {
                if (this.f9862c) {
                    return false;
                }
                this.f9862c = true;
                this.f9865f = exc;
                this.f9861b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean o(@Nullable Object obj) {
        synchronized (this.f9860a) {
            try {
                if (this.f9862c) {
                    return false;
                }
                this.f9862c = true;
                this.f9864e = obj;
                this.f9861b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    z() {
    }
}
