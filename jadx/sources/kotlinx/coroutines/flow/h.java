package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"kotlinx/coroutines/flow/i", "kotlinx/coroutines/flow/j", "kotlinx/coroutines/flow/k", "kotlinx/coroutines/flow/l", "kotlinx/coroutines/flow/m", "kotlinx/coroutines/flow/n", "kotlinx/coroutines/flow/o", "kotlinx/coroutines/flow/p", "kotlinx/coroutines/flow/q", "kotlinx/coroutines/flow/r", "kotlinx/coroutines/flow/s", "kotlinx/coroutines/flow/t"}, d2 = {}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class h {
    public static final <T, R> f<R> A(f<? extends T> fVar, c9.p<? super T, ? super v8.f<? super R>, ? extends Object> pVar) {
        return q.c(fVar, pVar);
    }

    public static final <T> f<T> B(f<? extends T> fVar, c9.q<? super g<? super T>, ? super Throwable, ? super v8.f<? super r8.z>, ? extends Object> qVar) {
        return n.d(fVar, qVar);
    }

    public static final <T> f<T> C(f<? extends T> fVar, c9.p<? super T, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        return t.b(fVar, pVar);
    }

    public static final <T> f<T> D(f<? extends T> fVar, c9.p<? super g<? super T>, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        return n.e(fVar, pVar);
    }

    public static final <T, R> f<R> E(f<? extends T> fVar, R r10, c9.q<? super R, ? super T, ? super v8.f<? super R>, ? extends Object> qVar) {
        return t.c(fVar, r10, qVar);
    }

    public static final <T> f<T> F(f<? extends T> fVar, c9.q<? super T, ? super T, ? super v8.f<? super T>, ? extends Object> qVar) {
        return t.d(fVar, qVar);
    }

    public static final <T, R> f<R> G(f<? extends T> fVar, R r10, c9.q<? super R, ? super T, ? super v8.f<? super R>, ? extends Object> qVar) {
        return t.e(fVar, r10, qVar);
    }

    public static final <T, R> f<R> H(f<? extends T> fVar, c9.q<? super g<? super R>, ? super T, ? super v8.f<? super r8.z>, ? extends Object> qVar) {
        return q.d(fVar, qVar);
    }

    public static final <T> f<IndexedValue<T>> I(f<? extends T> fVar) {
        return t.f(fVar);
    }

    public static final <T> z<T> a(u<T> uVar) {
        return s.a(uVar);
    }

    public static final <T> d0<T> b(v<T> vVar) {
        return s.b(vVar);
    }

    public static final <T> f<T> c(f<? extends T> fVar, int i10, kotlinx.coroutines.channels.a aVar) {
        return l.a(fVar, i10, aVar);
    }

    public static final <T> f<T> e(c9.p<? super kotlinx.coroutines.channels.s<? super T>, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        return i.a(pVar);
    }

    public static final <T> f<T> f(f<? extends T> fVar, c9.q<? super g<? super T>, ? super Throwable, ? super v8.f<? super r8.z>, ? extends Object> qVar) {
        return o.a(fVar, qVar);
    }

    public static final <T> Object g(f<? extends T> fVar, g<? super T> gVar, v8.f<? super Throwable> fVar2) {
        return o.b(fVar, gVar, fVar2);
    }

    public static final <T> f<T> h(c9.p<? super kotlinx.coroutines.channels.s<? super T>, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        return i.b(pVar);
    }

    public static final Object i(f<?> fVar, v8.f<? super r8.z> fVar2) {
        return k.a(fVar, fVar2);
    }

    public static final <T> Object j(f<? extends T> fVar, c9.p<? super T, ? super v8.f<? super r8.z>, ? extends Object> pVar, v8.f<? super r8.z> fVar2) {
        return k.b(fVar, pVar, fVar2);
    }

    public static final <T> f<T> k(f<? extends T> fVar) {
        return l.d(fVar);
    }

    public static final <T> f<T> l(kotlinx.coroutines.channels.u<? extends T> uVar) {
        return j.b(uVar);
    }

    public static final <T> f<T> m(f<? extends T> fVar) {
        return m.a(fVar);
    }

    public static final <T> f<T> n(f<? extends T> fVar, int i10) {
        return p.a(fVar, i10);
    }

    public static final <T> Object o(g<? super T> gVar, kotlinx.coroutines.channels.u<? extends T> uVar, v8.f<? super r8.z> fVar) {
        return j.c(gVar, uVar, fVar);
    }

    public static final <T> Object p(g<? super T> gVar, f<? extends T> fVar, v8.f<? super r8.z> fVar2) {
        return k.c(gVar, fVar, fVar2);
    }

    public static final void q(g<?> gVar) {
        n.b(gVar);
    }

    public static final <T> f<T> r(f<? extends T> fVar) {
        return t.a(fVar);
    }

    public static final <T> Object s(f<? extends T> fVar, v8.f<? super T> fVar2) {
        return r.a(fVar, fVar2);
    }

    public static final <T, R> f<R> t(f<? extends T> fVar, c9.p<? super T, ? super v8.f<? super f<? extends R>>, ? extends Object> pVar) {
        return q.a(fVar, pVar);
    }

    public static final <T> f<T> u(f<? extends f<? extends T>> fVar) {
        return q.b(fVar);
    }

    public static final <T> f<T> v(c9.p<? super g<? super T>, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        return i.c(pVar);
    }

    public static final <T> f<T> w(T t10) {
        return i.d(t10);
    }

    public static final <T> f<T> x(T... tArr) {
        return i.e(tArr);
    }

    public static final <T> f<T> y(f<? extends T> fVar, v8.j jVar) {
        return l.e(fVar, jVar);
    }

    public static final <T> u1 z(f<? extends T> fVar, l0 l0Var) {
        return k.d(fVar, l0Var);
    }
}
