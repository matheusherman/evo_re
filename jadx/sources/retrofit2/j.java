package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class j extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f18029a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements c<Object, retrofit2.b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f18030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f18031b;

        a(Type type, Executor executor) {
            this.f18030a = type;
            this.f18031b = executor;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f18030a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public retrofit2.b<Object> b(retrofit2.b<Object> bVar) {
            Executor executor = this.f18031b;
            return executor == null ? bVar : new b(executor, bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b<T> implements retrofit2.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Executor f18033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final retrofit2.b<T> f18034b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f18035a;

            a(d dVar) {
                this.f18035a = dVar;
            }

            public static /* synthetic */ void d(a aVar, d dVar, f0 f0Var) {
                if (b.this.f18034b.r()) {
                    dVar.a(b.this, new IOException("Canceled"));
                } else {
                    dVar.b(b.this, f0Var);
                }
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<T> bVar, final Throwable th) {
                Executor executor = b.this.f18033a;
                final d dVar = this.f18035a;
                executor.execute(new Runnable() { // from class: retrofit2.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.a(j.b.this, th);
                    }
                });
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<T> bVar, final f0<T> f0Var) {
                Executor executor = b.this.f18033a;
                final d dVar = this.f18035a;
                executor.execute(new Runnable() { // from class: retrofit2.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.b.a.d(this.f18038a, dVar, f0Var);
                    }
                });
            }
        }

        @Override // retrofit2.b
        public void S(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.f18034b.S(new a(dVar));
        }

        @Override // retrofit2.b
        public void cancel() {
            this.f18034b.cancel();
        }

        @Override // retrofit2.b
        public retrofit2.b<T> clone() {
            return new b(this.f18033a, this.f18034b.clone());
        }

        @Override // retrofit2.b
        public okhttp3.b0 f() {
            return this.f18034b.f();
        }

        @Override // retrofit2.b
        public boolean r() {
            return this.f18034b.r();
        }

        b(Executor executor, retrofit2.b<T> bVar) {
            this.f18033a = executor;
            this.f18034b = bVar;
        }
    }

    j(Executor executor) {
        this.f18029a = executor;
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, g0 g0Var) {
        Executor executor = null;
        if (c.a.c(type) != retrofit2.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type typeG = k0.g(0, (ParameterizedType) type);
            if (!k0.l(annotationArr, i0.class)) {
                executor = this.f18029a;
            }
            return new a(typeG, executor);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
