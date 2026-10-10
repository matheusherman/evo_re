package io.reactivex.rxjava3.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d<T> extends io.reactivex.rxjava3.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j8.f<? super T> f11388b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<T> extends io.reactivex.rxjava3.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final j8.f<? super T> f11389f;

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // g8.g
        public void a(T t10) {
            if (this.f11372e != 0) {
                this.f11368a.a(null);
                return;
            }
            try {
                if (this.f11389f.test(t10)) {
                    this.f11368a.a((Object) t10);
                }
            } catch (Throwable th) {
                g(th);
            }
        }

        @Override // o8.c
        public T poll() {
            T tPoll;
            do {
                tPoll = this.f11370c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f11389f.test(tPoll));
            return tPoll;
        }

        a(g8.g<? super T> gVar, j8.f<? super T> fVar) {
            super(gVar);
            this.f11389f = fVar;
        }

        @Override // o8.b
        public int j(int i10) {
            return h(i10);
        }
    }

    @Override // g8.c
    public void u(g8.g<? super T> gVar) {
        this.f11373a.c(new a(gVar, this.f11388b));
    }

    public d(g8.f<T> fVar, j8.f<? super T> fVar2) {
        super(fVar);
        this.f11388b = fVar2;
    }
}
