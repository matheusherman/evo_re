package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o0<E> extends s<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient E f4656c;

    @Override // com.google.common.collect.o
    boolean k() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f4656c.equals(obj);
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o
    public p<E> e() {
        return p.x(this.f4656c);
    }

    @Override // com.google.common.collect.o
    int f(Object[] objArr, int i10) {
        objArr[i10] = this.f4656c;
        return i10 + 1;
    }

    @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f4656c.hashCode();
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m */
    public s0<E> iterator() {
        return w.d(this.f4656c);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f4656c.toString() + ']';
    }

    o0(E e10) {
        this.f4656c = (E) com.google.common.base.m.i(e10);
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o
    Object writeReplace() {
        return super.writeReplace();
    }
}
