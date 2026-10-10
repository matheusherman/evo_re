package com.google.common.collect;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class i0<E> extends p<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final p<Object> f4616e = new i0(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f4617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f4618d;

    @Override // com.google.common.collect.o
    int i() {
        return 0;
    }

    @Override // com.google.common.collect.o
    boolean k() {
        return false;
    }

    @Override // com.google.common.collect.p, com.google.common.collect.o
    int f(Object[] objArr, int i10) {
        System.arraycopy(this.f4617c, 0, objArr, i10, this.f4618d);
        return i10 + this.f4618d;
    }

    @Override // com.google.common.collect.o
    Object[] g() {
        return this.f4617c;
    }

    @Override // java.util.List
    public E get(int i10) {
        com.google.common.base.m.g(i10, this.f4618d);
        E e10 = (E) this.f4617c[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @Override // com.google.common.collect.o
    int h() {
        return this.f4618d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f4618d;
    }

    i0(Object[] objArr, int i10) {
        this.f4617c = objArr;
        this.f4618d = i10;
    }

    @Override // com.google.common.collect.p, com.google.common.collect.o
    Object writeReplace() {
        return super.writeReplace();
    }
}
