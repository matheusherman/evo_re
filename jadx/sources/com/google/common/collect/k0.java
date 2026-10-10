package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k0<E> extends s<E> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object[] f4632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final k0<Object> f4633i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f4634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f4635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient Object[] f4636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int f4637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f4638g;

    static {
        Object[] objArr = new Object[0];
        f4632h = objArr;
        f4633i = new k0<>(objArr, 0, objArr, 0, 0);
    }

    @Override // com.google.common.collect.o
    int i() {
        return 0;
    }

    @Override // com.google.common.collect.o
    boolean k() {
        return false;
    }

    @Override // com.google.common.collect.s
    boolean v() {
        return true;
    }

    @Override // com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f4636e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iC = n.c(obj);
        while (true) {
            int i10 = iC & this.f4637f;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iC = i10 + 1;
        }
    }

    @Override // com.google.common.collect.o
    int f(Object[] objArr, int i10) {
        System.arraycopy(this.f4634c, 0, objArr, i10, this.f4638g);
        return i10 + this.f4638g;
    }

    @Override // com.google.common.collect.o
    Object[] g() {
        return this.f4634c;
    }

    @Override // com.google.common.collect.o
    int h() {
        return this.f4638g;
    }

    @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f4635d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f4638g;
    }

    @Override // com.google.common.collect.s
    p<E> u() {
        return p.o(this.f4634c, this.f4638g);
    }

    k0(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.f4634c = objArr;
        this.f4635d = i10;
        this.f4636e = objArr2;
        this.f4637f = i11;
        this.f4638g = i12;
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m */
    public s0<E> iterator() {
        return e().iterator();
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o
    Object writeReplace() {
        return super.writeReplace();
    }
}
