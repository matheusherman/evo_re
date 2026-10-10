package io.reactivex.rxjava3.internal.operators.observable;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f<T, U> extends io.reactivex.rxjava3.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j8.d<? super T, ? extends U> f11394b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<T, U> extends io.reactivex.rxjava3.internal.observers.a<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final j8.d<? super T, ? extends U> f11395f;

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // g8.g
        public void a(T t10) {
            if (this.f11371d) {
                return;
            }
            if (this.f11372e != 0) {
                this.f11368a.a(null);
                return;
            }
            try {
                U uApply = this.f11395f.apply(t10);
                Objects.requireNonNull(uApply, "The mapper function returned a null value.");
                this.f11368a.a((Object) uApply);
            } catch (Throwable th) {
                g(th);
            }
        }

        @Override // o8.c
        public U poll() {
            T tPoll = this.f11370c.poll();
            if (tPoll == null) {
                return null;
            }
            U uApply = this.f11395f.apply(tPoll);
            Objects.requireNonNull(uApply, "The mapper function returned a null value.");
            return uApply;
        }

        a(g8.g<? super U> gVar, j8.d<? super T, ? extends U> dVar) {
            super(gVar);
            this.f11395f = dVar;
        }

        @Override // o8.b
        public int j(int i10) {
            return h(i10);
        }
    }

    @Override // g8.c
    public void u(g8.g<? super U> gVar) {
        this.f11373a.c(new a(gVar, this.f11394b));
    }

    public f(g8.f<T> fVar, j8.d<? super T, ? extends U> dVar) {
        super(fVar);
        this.f11394b = dVar;
    }
}
