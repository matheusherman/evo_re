package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface e extends g, i {
    List<x0> C0();

    Collection<e> E();

    boolean E0();

    boolean F();

    x0 F0();

    d M();

    kotlin.reflect.jvm.internal.impl.resolve.scopes.h N();

    e P();

    kotlin.reflect.jvm.internal.impl.resolve.scopes.h W(kotlin.reflect.jvm.internal.impl.types.n1 n1Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    e a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    m b();

    f g();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q
    u getVisibility();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    e0 i();

    boolean isInline();

    Collection<d> k();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    kotlin.reflect.jvm.internal.impl.types.o0 p();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    List<f1> r();

    boolean t();

    kotlin.reflect.jvm.internal.impl.resolve.scopes.h u0();

    h1<kotlin.reflect.jvm.internal.impl.types.o0> v0();

    boolean x();

    kotlin.reflect.jvm.internal.impl.resolve.scopes.h z0();
}
