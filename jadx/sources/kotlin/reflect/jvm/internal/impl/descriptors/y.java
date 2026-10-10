package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.p1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface y extends b {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a<D extends y> {
        a<D> a();

        a<D> b(List<j1> list);

        D build();

        a<D> c(e0 e0Var);

        a<D> d(x0 x0Var);

        a<D> e();

        a<D> f(kotlin.reflect.jvm.internal.impl.types.g0 g0Var);

        a<D> g(b bVar);

        a<D> h();

        a<D> i(boolean z10);

        a<D> j(x0 x0Var);

        a<D> k(kotlin.reflect.jvm.internal.impl.types.n1 n1Var);

        a<D> l(List<f1> list);

        <V> a<D> m(kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<V> interfaceC0217a, V v10);

        a<D> n(u uVar);

        a<D> o(ba.f fVar);

        a<D> p(m mVar);

        a<D> q();

        a<D> r(b.a aVar);

        a<D> s(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar);

        a<D> t();
    }

    boolean L();

    y Z();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.m
    y a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    m b();

    y c(p1 p1Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a
    Collection<? extends y> e();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    a<? extends y> q();

    boolean s0();

    boolean y0();
}
