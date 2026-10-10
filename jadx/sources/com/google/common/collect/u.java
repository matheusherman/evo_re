package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class u<E> extends s<E> implements NavigableSet<E>, p0<E> {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Comparator<? super E> f4686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient u<E> f4687d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a<E> extends s.a<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Comparator<? super E> f4688f;

        @Override // com.google.common.collect.s.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public u<E> i() {
            u<E> uVarA = u.A(this.f4688f, this.f4654b, this.f4653a);
            this.f4654b = uVarA.size();
            this.f4655c = true;
            return uVarA;
        }

        public a(Comparator<? super E> comparator) {
            this.f4688f = (Comparator) com.google.common.base.m.i(comparator);
        }

        @Override // com.google.common.collect.s.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a<E> f(E e10) {
            super.f(e10);
            return this;
        }

        public a<E> k(E... eArr) {
            super.g(eArr);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            return new a(this.comparator).k(this.elements).i();
        }

        public b(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }
    }

    abstract u<E> D();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: E */
    public abstract s0<E> descendingIterator();

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public u<E> headSet(E e10) {
        return headSet(e10, false);
    }

    abstract u<E> L(E e10, boolean z10);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public u<E> subSet(E e10, E e11) {
        return subSet(e10, true, e11, false);
    }

    abstract u<E> O(E e10, boolean z10, E e11, boolean z11);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public u<E> tailSet(E e10) {
        return tailSet(e10, true);
    }

    abstract u<E> S(E e10, boolean z10);

    public E ceiling(E e10) {
        return (E) v.b(tailSet(e10, true), null);
    }

    public E floor(E e10) {
        return (E) w.c(headSet(e10, true).descendingIterator(), null);
    }

    public E higher(E e10) {
        return (E) v.b(tailSet(e10, false), null);
    }

    public E lower(E e10) {
        return (E) w.c(headSet(e10, false).descendingIterator(), null);
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m */
    public abstract s0<E> iterator();

    /* JADX WARN: Multi-variable type inference failed */
    static <E> u<E> A(Comparator<? super E> comparator, int i10, E... eArr) {
        if (i10 == 0) {
            return I(comparator);
        }
        f0.c(eArr, i10);
        Arrays.sort(eArr, 0, i10, comparator);
        int i11 = 1;
        for (int i12 = 1; i12 < i10; i12++) {
            a0.f.a aVar = (Object) eArr[i12];
            if (comparator.compare(aVar, (Object) eArr[i11 - 1]) != 0) {
                eArr[i11] = aVar;
                i11++;
            }
        }
        Arrays.fill(eArr, i11, i10, (Object) null);
        if (i11 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i11);
        }
        return new l0(p.o(eArr, i11), comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public u<E> descendingSet() {
        u<E> uVar = this.f4687d;
        if (uVar != null) {
            return uVar;
        }
        u<E> uVarD = D();
        this.f4687d = uVarD;
        uVarD.f4687d = this;
        return uVarD;
    }

    int T(Object obj, Object obj2) {
        return U(this.f4686c, obj, obj2);
    }

    @Override // java.util.SortedSet, com.google.common.collect.p0
    public Comparator<? super E> comparator() {
        return this.f4686c;
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o
    Object writeReplace() {
        return new b(this.f4686c, toArray());
    }

    u(Comparator<? super E> comparator) {
        this.f4686c = comparator;
    }

    public static <E> u<E> B(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.m.i(comparator);
        if (q0.b(comparator, iterable) && (iterable instanceof u)) {
            u<E> uVar = (u) iterable;
            if (!uVar.k()) {
                return uVar;
            }
        }
        Object[] objArrC = v.c(iterable);
        return A(comparator, objArrC.length, objArrC);
    }

    public static <E> u<E> C(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return B(comparator, collection);
    }

    static <E> l0<E> I(Comparator<? super E> comparator) {
        if (g0.c().equals(comparator)) {
            return (l0<E>) l0.f4643f;
        }
        return new l0<>(p.w(), comparator);
    }

    static int U(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public u<E> headSet(E e10, boolean z10) {
        return L(com.google.common.base.m.i(e10), z10);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public u<E> subSet(E e10, boolean z10, E e11, boolean z11) {
        boolean z12;
        com.google.common.base.m.i(e10);
        com.google.common.base.m.i(e11);
        if (this.f4686c.compare(e10, e11) <= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        com.google.common.base.m.d(z12);
        return O(e10, z10, e11, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public u<E> tailSet(E e10, boolean z10) {
        return S(com.google.common.base.m.i(e10), z10);
    }

    public E first() {
        return iterator().next();
    }

    public E last() {
        return descendingIterator().next();
    }
}
