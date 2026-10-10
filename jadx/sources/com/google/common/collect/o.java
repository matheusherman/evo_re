package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class o<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f4652a = new Object[0];
    private static final long serialVersionUID = 912559;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f4653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f4655c;

        public b<E> c(E... eArr) {
            d(eArr, eArr.length);
            return this;
        }

        private void e(int i10) {
            Object[] objArr = this.f4653a;
            if (objArr.length < i10) {
                this.f4653a = Arrays.copyOf(objArr, b.a(objArr.length, i10));
                this.f4655c = false;
            } else if (this.f4655c) {
                this.f4653a = (Object[]) objArr.clone();
                this.f4655c = false;
            }
        }

        a(int i10) {
            g.b(i10, "initialCapacity");
            this.f4653a = new Object[i10];
            this.f4654b = 0;
        }

        public a<E> b(E e10) {
            com.google.common.base.m.i(e10);
            e(this.f4654b + 1);
            Object[] objArr = this.f4653a;
            int i10 = this.f4654b;
            this.f4654b = i10 + 1;
            objArr[i10] = e10;
            return this;
        }

        final void d(Object[] objArr, int i10) {
            f0.c(objArr, i10);
            e(this.f4654b + i10);
            System.arraycopy(objArr, 0, this.f4653a, this.f4654b, i10);
            this.f4654b += i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class b<E> {
        static int a(int i10, int i11) {
            if (i11 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i10 + (i10 >> 1) + 1;
            if (iHighestOneBit < i11) {
                iHighestOneBit = Integer.highestOneBit(i11 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        b() {
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    Object[] g() {
        return null;
    }

    abstract boolean k();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public abstract s0<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f4652a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    int h() {
        throw new UnsupportedOperationException();
    }

    int i() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.m.i(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrG = g();
            if (objArrG != null) {
                return (T[]) h0.a(objArrG, i(), h(), tArr);
            }
            tArr = (T[]) f0.d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        f(tArr, 0);
        return tArr;
    }

    Object writeReplace() {
        return new p.d(toArray());
    }

    o() {
    }

    public p<E> e() {
        if (isEmpty()) {
            return p.w();
        }
        return p.n(toArray());
    }

    int f(Object[] objArr, int i10) {
        s0<E> it = iterator();
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return i10;
    }
}
