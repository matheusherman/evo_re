package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class l0<E> extends u<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final l0<Comparable> f4643f = new l0<>(p.w(), g0.c());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient p<E> f4644e;

    @Override // com.google.common.collect.u
    u<E> L(E e10, boolean z10) {
        return V(0, W(e10, z10));
    }

    @Override // com.google.common.collect.u, java.util.NavigableSet
    public E ceiling(E e10) {
        int iX = X(e10, true);
        if (iX == size()) {
            return null;
        }
        return this.f4644e.get(iX);
    }

    @Override // com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Y(obj) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!q0.b(this.f4686c, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            s0<E> it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || T(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.common.collect.u, java.util.NavigableSet
    public E floor(E e10) {
        int iW = W(e10, true) - 1;
        if (iW == -1) {
            return null;
        }
        return this.f4644e.get(iW);
    }

    @Override // com.google.common.collect.u, java.util.NavigableSet
    public E higher(E e10) {
        int iX = X(e10, false);
        if (iX == size()) {
            return null;
        }
        return this.f4644e.get(iX);
    }

    @Override // com.google.common.collect.u, java.util.NavigableSet
    public E lower(E e10) {
        int iW = W(e10, false) - 1;
        if (iW == -1) {
            return null;
        }
        return this.f4644e.get(iW);
    }

    private int Y(Object obj) {
        return Collections.binarySearch(this.f4644e, obj, a0());
    }

    @Override // com.google.common.collect.u
    u<E> D() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.f4686c);
        return isEmpty() ? u.I(comparatorReverseOrder) : new l0(this.f4644e.z(), comparatorReverseOrder);
    }

    @Override // com.google.common.collect.u, java.util.NavigableSet
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public s0<E> descendingIterator() {
        return this.f4644e.z().iterator();
    }

    l0<E> V(int i10, int i11) {
        if (i10 == 0 && i11 == size()) {
            return this;
        }
        return i10 < i11 ? new l0<>(this.f4644e.subList(i10, i11), this.f4686c) : u.I(this.f4686c);
    }

    int W(E e10, boolean z10) {
        int iBinarySearch = Collections.binarySearch(this.f4644e, com.google.common.base.m.i(e10), comparator());
        if (iBinarySearch >= 0) {
            return z10 ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    int X(E e10, boolean z10) {
        int iBinarySearch = Collections.binarySearch(this.f4644e, com.google.common.base.m.i(e10), comparator());
        if (iBinarySearch >= 0) {
            return z10 ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }

    Comparator<Object> a0() {
        return this.f4686c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof c0) {
            collection = ((c0) collection).G();
        }
        if (!q0.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        s0<E> it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int iT = T(next2, next);
                if (iT < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iT == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iT > 0) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o
    public p<E> e() {
        return this.f4644e;
    }

    @Override // com.google.common.collect.o
    int f(Object[] objArr, int i10) {
        return this.f4644e.f(objArr, i10);
    }

    @Override // com.google.common.collect.o
    Object[] g() {
        return this.f4644e.g();
    }

    @Override // com.google.common.collect.o
    int h() {
        return this.f4644e.h();
    }

    @Override // com.google.common.collect.o
    int i() {
        return this.f4644e.i();
    }

    @Override // com.google.common.collect.o
    boolean k() {
        return this.f4644e.k();
    }

    @Override // com.google.common.collect.u, com.google.common.collect.s, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m */
    public s0<E> iterator() {
        return this.f4644e.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f4644e.size();
    }

    l0(p<E> pVar, Comparator<? super E> comparator) {
        super(comparator);
        this.f4644e = pVar;
    }

    @Override // com.google.common.collect.u
    u<E> O(E e10, boolean z10, E e11, boolean z11) {
        return S(e10, z10).L(e11, z11);
    }

    @Override // com.google.common.collect.u
    u<E> S(E e10, boolean z10) {
        return V(X(e10, z10), size());
    }

    @Override // com.google.common.collect.u, java.util.SortedSet
    public E first() {
        if (!isEmpty()) {
            return this.f4644e.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.u, java.util.SortedSet
    public E last() {
        if (!isEmpty()) {
            return this.f4644e.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.u, com.google.common.collect.s, com.google.common.collect.o
    Object writeReplace() {
        return super.writeReplace();
    }
}
