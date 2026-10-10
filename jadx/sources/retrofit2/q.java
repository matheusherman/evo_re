package retrofit2;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class q<T> implements retrofit2.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f18066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f18067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final okhttp3.e.a f18068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i<okhttp3.e0, T> f18069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f18070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private okhttp3.e f18071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Throwable f18072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18073h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements okhttp3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f18074a;

        a(d dVar) {
            this.f18074a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.f18074a.a(q.this, th);
            } catch (Throwable th2) {
                k0.s(th2);
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.f
        public void onResponse(okhttp3.e eVar, okhttp3.d0 d0Var) {
            try {
                try {
                    this.f18074a.b(q.this, q.this.e(d0Var));
                } catch (Throwable th) {
                    k0.s(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                k0.s(th2);
                a(th2);
            }
        }

        @Override // okhttp3.f
        public void onFailure(okhttp3.e eVar, IOException iOException) {
            a(iOException);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends okhttp3.e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final okhttp3.e0 f18076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final tb.f f18077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        IOException f18078e;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends tb.i {
            a(tb.z zVar) {
                super(zVar);
            }

            @Override // tb.i, tb.z
            public long D(tb.d dVar, long j10) throws IOException {
                try {
                    return super.D(dVar, j10);
                } catch (IOException e10) {
                    b.this.f18078e = e10;
                    throw e10;
                }
            }
        }

        @Override // okhttp3.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f18076c.close();
        }

        @Override // okhttp3.e0
        /* JADX INFO: renamed from: f */
        public long getContentLength() {
            return this.f18076c.getContentLength();
        }

        @Override // okhttp3.e0
        /* JADX INFO: renamed from: i */
        public okhttp3.x getF16696c() {
            return this.f18076c.getF16696c();
        }

        @Override // okhttp3.e0
        /* JADX INFO: renamed from: k */
        public tb.f getSource() {
            return this.f18077d;
        }

        void m() throws IOException {
            IOException iOException = this.f18078e;
            if (iOException != null) {
                throw iOException;
            }
        }

        b(okhttp3.e0 e0Var) {
            this.f18076c = e0Var;
            this.f18077d = tb.n.b(new a(e0Var.getSource()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends okhttp3.e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final okhttp3.x f18080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f18081d;

        @Override // okhttp3.e0
        /* JADX INFO: renamed from: f */
        public long getContentLength() {
            return this.f18081d;
        }

        @Override // okhttp3.e0
        /* JADX INFO: renamed from: i */
        public okhttp3.x getF16696c() {
            return this.f18080c;
        }

        @Override // okhttp3.e0
        /* JADX INFO: renamed from: k */
        public tb.f getSource() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }

        c(okhttp3.x xVar, long j10) {
            this.f18080c = xVar;
            this.f18081d = j10;
        }
    }

    @Override // retrofit2.b
    public void cancel() {
        okhttp3.e eVar;
        this.f18070e = true;
        synchronized (this) {
            eVar = this.f18071f;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // retrofit2.b
    public synchronized okhttp3.b0 f() {
        try {
        } catch (IOException e10) {
            throw new RuntimeException("Unable to create request.", e10);
        }
        return d().getOriginalRequest();
    }

    private okhttp3.e c() {
        okhttp3.e eVarA = this.f18068c.a(this.f18066a.a(this.f18067b));
        if (eVarA != null) {
            return eVarA;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private okhttp3.e d() throws IOException {
        okhttp3.e eVar = this.f18071f;
        if (eVar != null) {
            return eVar;
        }
        Throwable th = this.f18072g;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            okhttp3.e eVarC = c();
            this.f18071f = eVarC;
            return eVarC;
        } catch (IOException | Error | RuntimeException e10) {
            k0.s(e10);
            this.f18072g = e10;
            throw e10;
        }
    }

    @Override // retrofit2.b
    public void S(d<T> dVar) {
        okhttp3.e eVar;
        Throwable th;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            try {
                if (this.f18073h) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f18073h = true;
                eVar = this.f18071f;
                th = this.f18072g;
                if (eVar == null && th == null) {
                    try {
                        okhttp3.e eVarC = c();
                        this.f18071f = eVarC;
                        eVar = eVarC;
                    } catch (Throwable th2) {
                        th = th2;
                        k0.s(th);
                        this.f18072g = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.f18070e) {
            eVar.cancel();
        }
        eVar.J(new a(dVar));
    }

    @Override // retrofit2.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public q<T> clone() {
        return new q<>(this.f18066a, this.f18067b, this.f18068c, this.f18069d);
    }

    @Override // retrofit2.b
    public boolean r() {
        boolean z10 = true;
        if (this.f18070e) {
            return true;
        }
        synchronized (this) {
            try {
                okhttp3.e eVar = this.f18071f;
                if (eVar == null || !eVar.getCanceled()) {
                    z10 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    q(e0 e0Var, Object[] objArr, okhttp3.e.a aVar, i<okhttp3.e0, T> iVar) {
        this.f18066a = e0Var;
        this.f18067b = objArr;
        this.f18068c = aVar;
        this.f18069d = iVar;
    }

    f0<T> e(okhttp3.d0 d0Var) throws IOException {
        okhttp3.e0 body = d0Var.getBody();
        okhttp3.d0 d0VarC = d0Var.q().b(new c(body.getF16696c(), body.getContentLength())).c();
        int code = d0VarC.getCode();
        if (code >= 200 && code < 300) {
            if (code != 204 && code != 205) {
                b bVar = new b(body);
                try {
                    return f0.j(this.f18069d.a(bVar), d0VarC);
                } catch (RuntimeException e10) {
                    bVar.m();
                    throw e10;
                }
            }
            body.close();
            return f0.j(null, d0VarC);
        }
        try {
            return f0.c(k0.a(body), d0VarC);
        } finally {
            body.close();
        }
    }
}
