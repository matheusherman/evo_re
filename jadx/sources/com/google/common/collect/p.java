package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class p<E> extends o<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t0<Object> f4657b = new b(i0.f4616e, 0);
    private static final long serialVersionUID = -889275714;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a<E> extends o.a<E> {
        public a() {
            this(4);
        }

        public p<E> g() {
            this.f4655c = true;
            return p.o(this.f4653a, this.f4654b);
        }

        a(int i10) {
            super(i10);
        }

        public a<E> f(E e10) {
            super.b(e10);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b<E> extends com.google.common.collect.a<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final p<E> f4658c;

        @Override // com.google.common.collect.a
        protected E c(int i10) {
            return this.f4658c.get(i10);
        }

        b(p<E> pVar, int i10) {
            super(pVar.size(), i10);
            this.f4658c = pVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c<E> extends p<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient p<E> f4659c;

        @Override // com.google.common.collect.p, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.p, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f4659c.contains(obj);
        }

        @Override // com.google.common.collect.p, java.util.List
        public int indexOf(Object obj) {
            int iLastIndexOf = this.f4659c.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return D(iLastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.o
        boolean k() {
            return this.f4659c.k();
        }

        @Override // com.google.common.collect.p, java.util.List
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.f4659c.indexOf(obj);
            if (iIndexOf >= 0) {
                return D(iIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.p, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4659c.size();
        }

        @Override // com.google.common.collect.p
        public p<E> z() {
            return this.f4659c;
        }

        c(p<E> pVar) {
            this.f4659c = pVar;
        }

        private int D(int i10) {
            return (size() - 1) - i10;
        }

        private int E(int i10) {
            return size() - i10;
        }

        @Override // com.google.common.collect.p, java.util.List
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public p<E> subList(int i10, int i11) {
            com.google.common.base.m.m(i10, i11, size());
            return this.f4659c.subList(E(i11), E(i10)).z();
        }

        @Override // java.util.List
        public E get(int i10) {
            com.google.common.base.m.g(i10, size());
            return this.f4659c.get(D(i10));
        }

        @Override // com.google.common.collect.p, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.p, com.google.common.collect.o
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class d implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        Object readResolve() {
            return p.t(this.elements);
        }

        d(Object[] objArr) {
            this.elements = objArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e extends p<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient int f4660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final transient int f4661d;

        @Override // com.google.common.collect.o
        boolean k() {
            return true;
        }

        @Override // com.google.common.collect.p, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        e(int i10, int i11) {
            this.f4660c = i10;
            this.f4661d = i11;
        }

        @Override // com.google.common.collect.p, java.util.List
        /* JADX INFO: renamed from: B */
        public p<E> subList(int i10, int i11) {
            com.google.common.base.m.m(i10, i11, this.f4661d);
            p pVar = p.this;
            int i12 = this.f4660c;
            return pVar.subList(i10 + i12, i11 + i12);
        }

        @Override // com.google.common.collect.o
        Object[] g() {
            return p.this.g();
        }

        @Override // java.util.List
        public E get(int i10) {
            com.google.common.base.m.g(i10, this.f4661d);
            return p.this.get(i10 + this.f4660c);
        }

        @Override // com.google.common.collect.o
        int h() {
            return p.this.i() + this.f4660c + this.f4661d;
        }

        @Override // com.google.common.collect.o
        int i() {
            return p.this.i() + this.f4660c;
        }

        @Override // com.google.common.collect.p, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4661d;
        }

        @Override // com.google.common.collect.p, com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.p, com.google.common.collect.o
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    static <E> p<E> n(Object[] objArr) {
        return o(objArr, objArr.length);
    }

    public static <E> p<E> t(E[] eArr) {
        return eArr.length == 0 ? w() : r((Object[]) eArr.clone());
    }

    public static <E> p<E> x(E e10) {
        return r(e10);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public t0<E> listIterator() {
        return listIterator(0);
    }

    static <E> p<E> o(Object[] objArr, int i10) {
        return i10 == 0 ? w() : new i0(objArr, i10);
    }

    public static <E> a<E> q() {
        return new a<>();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> p<E> s(Collection<? extends E> collection) {
        if (!(collection instanceof o)) {
            return r(collection.toArray());
        }
        p<E> pVarE = ((o) collection).e();
        return pVarE.k() ? n(pVarE.toArray()) : pVarE;
    }

    public static <E> p<E> w() {
        return (p<E>) i0.f4616e;
    }

    @SafeVarargs
    public static <E> p<E> y(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e20, E e21, E... eArr) {
        com.google.common.base.m.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        objArr[6] = e16;
        objArr[7] = e17;
        objArr[8] = e18;
        objArr[9] = e19;
        objArr[10] = e20;
        objArr[11] = e21;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return r(objArr);
    }

    p<E> C(int i10, int i11) {
        return new e(i10, i11 - i10);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return x.b(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return x.d(this, obj);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.o
    Object writeReplace() {
        return new d(toArray());
    }

    p() {
    }

    public static <E> p<E> A(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.m.i(comparator);
        Object[] objArrC = v.c(iterable);
        f0.b(objArrC);
        Arrays.sort(objArrC, comparator);
        return n(objArrC);
    }

    private static <E> p<E> r(Object... objArr) {
        return n(f0.b(objArr));
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: B */
    public p<E> subList(int i10, int i11) {
        com.google.common.base.m.m(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return w();
        }
        return C(i10, i11);
    }

    @Override // com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return x.a(this, obj);
    }

    @Override // com.google.common.collect.o
    int f(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m */
    public s0<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public t0<E> listIterator(int i10) {
        com.google.common.base.m.k(i10, size());
        if (isEmpty()) {
            return (t0<E>) f4657b;
        }
        return new b(this, i10);
    }

    public p<E> z() {
        if (size() <= 1) {
            return this;
        }
        return new c(this);
    }

    @Override // com.google.common.collect.o
    @Deprecated
    public final p<E> e() {
        return this;
    }
}
