package g8;

import io.reactivex.rxjava3.internal.operators.observable.j;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c<T> implements f<T> {
    public final c<T> n(h hVar) {
        return o(hVar, false, e());
    }

    protected abstract void u(g<? super T> gVar);

    public static <T> c<T> g(e<T> eVar) {
        Objects.requireNonNull(eVar, "source is null");
        return p8.a.i(new io.reactivex.rxjava3.internal.operators.observable.b(eVar));
    }

    public static c<Long> l(long j10, long j11, TimeUnit timeUnit, h hVar) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(hVar, "scheduler is null");
        return p8.a.i(new io.reactivex.rxjava3.internal.operators.observable.e(Math.max(0L, j10), Math.max(0L, j11), timeUnit, hVar));
    }

    @Override // g8.f
    public final void c(g<? super T> gVar) {
        Objects.requireNonNull(gVar, "observer is null");
        try {
            g<? super T> gVarO = p8.a.o(this, gVar);
            Objects.requireNonNull(gVarO, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            u(gVarO);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            i8.b.b(th);
            p8.a.l(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <U> c<U> f(Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return (c<U>) m(l8.a.a(cls));
    }

    public final c<T> i(long j10, TimeUnit timeUnit, h hVar) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(hVar, "scheduler is null");
        return p8.a.i(new io.reactivex.rxjava3.internal.operators.observable.c(this, j10, timeUnit, hVar, null));
    }

    public final c<T> j(j8.f<? super T> fVar) {
        Objects.requireNonNull(fVar, "predicate is null");
        return p8.a.i(new io.reactivex.rxjava3.internal.operators.observable.d(this, fVar));
    }

    public final <R> c<R> m(j8.d<? super T, ? extends R> dVar) {
        Objects.requireNonNull(dVar, "mapper is null");
        return p8.a.i(new io.reactivex.rxjava3.internal.operators.observable.f(this, dVar));
    }

    public final c<T> o(h hVar, boolean z10, int i10) {
        Objects.requireNonNull(hVar, "scheduler is null");
        l8.b.a(i10, "bufferSize");
        return p8.a.i(new io.reactivex.rxjava3.internal.operators.observable.g(this, hVar, z10, i10));
    }

    public final <U> c<U> p(Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return j(l8.a.c(cls)).f(cls);
    }

    public final m8.a<T> q() {
        return p8.a.j(new io.reactivex.rxjava3.internal.operators.observable.h(this));
    }

    public final h8.c r(j8.c<? super T> cVar) {
        return t(cVar, l8.a.f15238f, l8.a.f15235c);
    }

    public final h8.c s(j8.c<? super T> cVar, j8.c<? super Throwable> cVar2) {
        return t(cVar, cVar2, l8.a.f15235c);
    }

    public final h8.c t(j8.c<? super T> cVar, j8.c<? super Throwable> cVar2, j8.a aVar) {
        Objects.requireNonNull(cVar, "onNext is null");
        Objects.requireNonNull(cVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        io.reactivex.rxjava3.internal.observers.c cVar3 = new io.reactivex.rxjava3.internal.observers.c(cVar, cVar2, aVar, l8.a.b());
        c(cVar3);
        return cVar3;
    }

    public final c<T> v(h hVar) {
        Objects.requireNonNull(hVar, "scheduler is null");
        return p8.a.i(new j(this, hVar));
    }

    public static int e() {
        return b.a();
    }

    public static c<Long> k(long j10, long j11, TimeUnit timeUnit) {
        return l(j10, j11, timeUnit, q8.a.a());
    }

    public final c<T> h(long j10, TimeUnit timeUnit) {
        return i(j10, timeUnit, q8.a.a());
    }

    public final c<T> w(long j10, TimeUnit timeUnit) {
        return h(j10, timeUnit);
    }
}
