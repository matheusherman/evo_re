package p4;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j<T> extends d implements p4.b, p4.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.koushikdutta.async.b f17342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Exception f17343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private T f17344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f17345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a<T> f17346j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected interface a<T> {
        void a(Exception exc, T t10, b bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Exception f17347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a f17349c;

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            while (true) {
                a aVar = this.f17349c;
                if (aVar == 0) {
                    return;
                }
                Exception exc = this.f17347a;
                Object obj = this.f17348b;
                this.f17349c = null;
                this.f17347a = null;
                this.f17348b = null;
                aVar.a(exc, obj, this);
            }
        }

        b() {
        }
    }

    public j() {
    }

    public static /* synthetic */ void j(j jVar, l lVar, Exception exc, Object obj, b bVar) {
        if (exc != null) {
            jVar.v(exc, null, bVar);
            return;
        }
        try {
            jVar.t(lVar.a(obj), bVar);
        } catch (Exception e10) {
            jVar.v(e10, null, bVar);
        }
    }

    private boolean v(Exception exc, T t10, b bVar) {
        synchronized (this) {
            try {
                if (!super.d()) {
                    return false;
                }
                this.f17344h = t10;
                this.f17343g = exc;
                r();
                p(bVar, q());
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return cancel();
    }

    @Override // java.util.concurrent.Future
    public T get() {
        synchronized (this) {
            if (!isCancelled() && !isDone()) {
                n().a();
                return o();
            }
            return o();
        }
    }

    @Override // p4.b
    public void m(final c<T> cVar) {
        if (cVar == null) {
            s(null, null);
        } else {
            s(null, new a() { // from class: p4.e
                @Override // p4.j.a
                public final void a(Exception exc, Object obj, j.b bVar) {
                    cVar.a(exc, obj);
                }
            });
        }
    }

    void s(b bVar, a<T> aVar) {
        synchronized (this) {
            try {
                this.f17346j = aVar;
                if (isDone() || isCancelled()) {
                    p(bVar, q());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean u(Exception exc) {
        return v(exc, null, null);
    }

    public boolean w(T t10) {
        return v(null, t10, null);
    }

    public j(T t10) {
        w(t10);
    }

    public static /* synthetic */ p4.b h(k kVar, Object obj) {
        return new j(kVar.a(obj));
    }

    private T o() throws ExecutionException {
        if (this.f17343g == null) {
            return this.f17344h;
        }
        throw new ExecutionException(this.f17343g);
    }

    private void p(b bVar, a<T> aVar) {
        boolean z10;
        if (this.f17345i || aVar == null) {
            return;
        }
        if (bVar == null) {
            bVar = new b();
            z10 = true;
        } else {
            z10 = false;
        }
        bVar.f17349c = aVar;
        bVar.f17347a = this.f17343g;
        bVar.f17348b = this.f17344h;
        if (z10) {
            bVar.a();
        }
    }

    private a<T> q() {
        a<T> aVar = this.f17346j;
        this.f17346j = null;
        return aVar;
    }

    @Override // p4.d, p4.a
    public boolean cancel() {
        return l(this.f17345i);
    }

    @Override // p4.b
    public <R> p4.b<R> f(final k<R, T> kVar) {
        return x(new l() { // from class: p4.f
            @Override // p4.l
            public final b a(Object obj) {
                return j.h(kVar, obj);
            }
        });
    }

    com.koushikdutta.async.b n() {
        if (this.f17342f == null) {
            this.f17342f = new com.koushikdutta.async.b();
        }
        return this.f17342f;
    }

    void r() {
        com.koushikdutta.async.b bVar = this.f17342f;
        if (bVar != null) {
            bVar.b();
            this.f17342f = null;
        }
    }

    public <R> p4.b<R> x(final l<R, T> lVar) {
        final j jVar = new j();
        jVar.e(this);
        s(null, new a() { // from class: p4.g
            @Override // p4.j.a
            public final void a(Exception exc, Object obj, j.b bVar) {
                j.j(this.f17336a, lVar, exc, obj, bVar);
            }
        });
        return jVar;
    }

    public static /* synthetic */ void i(j jVar, j jVar2, Exception exc, Object obj, b bVar) {
        CancellationException cancellationException;
        if (jVar.v(exc, obj, bVar)) {
            cancellationException = null;
        } else {
            cancellationException = new CancellationException();
        }
        jVar2.v(cancellationException, obj, bVar);
    }

    private boolean l(boolean z10) {
        a<T> aVarQ;
        if (!super.cancel()) {
            return false;
        }
        synchronized (this) {
            this.f17343g = new CancellationException();
            r();
            aVarQ = q();
            this.f17345i = z10;
        }
        p(null, aVarQ);
        return true;
    }

    private p4.b<T> t(p4.b<T> bVar, b bVar2) {
        e(bVar);
        final j jVar = new j();
        if (bVar instanceof j) {
            ((j) bVar).s(bVar2, new a() { // from class: p4.h
                @Override // p4.j.a
                public final void a(Exception exc, Object obj, j.b bVar3) {
                    j.i(this.f17338a, jVar, exc, obj, bVar3);
                }
            });
            return jVar;
        }
        bVar.m(new c() { // from class: p4.i
            @Override // p4.c
            public final void a(Exception exc, Object obj) {
                jVar.u(this.f17340a.v(exc, obj, null) ? null : new CancellationException());
            }
        });
        return jVar;
    }

    @Override // p4.d
    public boolean e(p4.a aVar) {
        return super.e(aVar);
    }

    @Override // java.util.concurrent.Future
    public T get(long j10, TimeUnit timeUnit) throws TimeoutException {
        synchronized (this) {
            if (!isCancelled() && !isDone()) {
                com.koushikdutta.async.b bVarN = n();
                if (bVarN.c(j10, timeUnit)) {
                    return o();
                }
                throw new TimeoutException();
            }
            return o();
        }
    }
}
