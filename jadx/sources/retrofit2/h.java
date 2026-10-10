package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@IgnoreJRERequirement
final class h extends retrofit2.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final retrofit2.c.a f18021a = new h();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @IgnoreJRERequirement
    private static final class a<R> implements retrofit2.c<R, CompletableFuture<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f18022a;

        /* JADX INFO: renamed from: retrofit2.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @IgnoreJRERequirement
        private class C0349a implements d<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CompletableFuture<R> f18023a;

            public C0349a(CompletableFuture<R> completableFuture) {
                this.f18023a = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th) {
                this.f18023a.completeExceptionally(th);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, f0<R> f0Var) {
                if (f0Var.f()) {
                    this.f18023a.complete(f0Var.a());
                } else {
                    this.f18023a.completeExceptionally(new m(f0Var));
                }
            }
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f18022a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> b(retrofit2.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.S(new C0349a(bVar2));
            return bVar2;
        }

        a(Type type) {
            this.f18022a = type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @IgnoreJRERequirement
    private static final class b<T> extends CompletableFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final retrofit2.b<?> f18025a;

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            if (z10) {
                this.f18025a.cancel();
            }
            return super.cancel(z10);
        }

        b(retrofit2.b<?> bVar) {
            this.f18025a = bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @IgnoreJRERequirement
    private static final class c<R> implements retrofit2.c<R, CompletableFuture<f0<R>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f18026a;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @IgnoreJRERequirement
        private class a implements d<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CompletableFuture<f0<R>> f18027a;

            public a(CompletableFuture<f0<R>> completableFuture) {
                this.f18027a = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th) {
                this.f18027a.completeExceptionally(th);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, f0<R> f0Var) {
                this.f18027a.complete(f0Var);
            }
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f18026a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<f0<R>> b(retrofit2.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.S(new a(bVar2));
            return bVar2;
        }

        c(Type type) {
            this.f18026a = type;
        }
    }

    h() {
    }

    @Override // retrofit2.c.a
    public retrofit2.c<?, ?> a(Type type, Annotation[] annotationArr, g0 g0Var) {
        if (retrofit2.c.a.c(type) != e.a()) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type typeB = retrofit2.c.a.b(0, (ParameterizedType) type);
            if (retrofit2.c.a.c(typeB) != f0.class) {
                return new a(typeB);
            }
            if (typeB instanceof ParameterizedType) {
                return new c(retrofit2.c.a.b(0, (ParameterizedType) typeB));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
