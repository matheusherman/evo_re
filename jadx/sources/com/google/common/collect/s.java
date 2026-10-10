package com.google.common.collect;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class s<E> extends o<E> implements Set<E> {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RetainedWith
    private transient p<E> f4681b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a<E> extends o.a<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object[] f4682d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4683e;

        public a() {
            super(4);
        }

        private void h(E e10) {
            Objects.requireNonNull(this.f4682d);
            int length = this.f4682d.length - 1;
            int iHashCode = e10.hashCode();
            int iB = n.b(iHashCode);
            while (true) {
                int i10 = iB & length;
                Object[] objArr = this.f4682d;
                Object obj = objArr[i10];
                if (obj == null) {
                    objArr[i10] = e10;
                    this.f4683e += iHashCode;
                    super.b(e10);
                    return;
                } else if (obj.equals(e10)) {
                    return;
                } else {
                    iB = i10 + 1;
                }
            }
        }

        public a<E> g(E... eArr) {
            if (this.f4682d == null) {
                super.c(eArr);
                return this;
            }
            for (E e10 : eArr) {
                f(e10);
            }
            return this;
        }

        public s<E> i() {
            s<E> sVarR;
            int i10 = this.f4654b;
            if (i10 == 0) {
                return s.w();
            }
            if (i10 == 1) {
                Object obj = this.f4653a[0];
                Objects.requireNonNull(obj);
                return s.x(obj);
            }
            if (this.f4682d == null || s.q(i10) != this.f4682d.length) {
                sVarR = s.r(this.f4654b, this.f4653a);
                this.f4654b = sVarR.size();
            } else {
                Object[] objArrCopyOf = s.z(this.f4654b, this.f4653a.length) ? Arrays.copyOf(this.f4653a, this.f4654b) : this.f4653a;
                int i11 = this.f4683e;
                Object[] objArr = this.f4682d;
                sVarR = new k0<>(objArrCopyOf, i11, objArr, objArr.length - 1, this.f4654b);
            }
            this.f4655c = true;
            this.f4682d = null;
            return sVarR;
        }

        public a<E> f(E e10) {
            com.google.common.base.m.i(e10);
            if (this.f4682d != null && s.q(this.f4654b) <= this.f4682d.length) {
                h(e10);
                return this;
            }
            this.f4682d = null;
            super.b(e10);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        Object readResolve() {
            return s.t(this.elements);
        }

        b(Object[] objArr) {
            this.elements = objArr;
        }
    }

    static int q(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax >= 751619276) {
            com.google.common.base.m.e(iMax < 1073741824, "collection too large");
            return BasicMeasure.EXACTLY;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static <E> s<E> t(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? r(eArr.length, (Object[]) eArr.clone()) : x(eArr[0]);
        }
        return w();
    }

    public static <E> s<E> y(E e10, E e11, E e12) {
        return r(3, e10, e11, e12);
    }

    @Override // com.google.common.collect.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m */
    public abstract s0<E> iterator();

    boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> s<E> r(int i10, Object... objArr) {
        if (i10 == 0) {
            return w();
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return x(obj);
        }
        int iQ = q(i10);
        Object[] objArr2 = new Object[iQ];
        int i11 = iQ - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object objA = f0.a(objArr[i14], i14);
            int iHashCode = objA.hashCode();
            int iB = n.b(iHashCode);
            while (true) {
                int i15 = iB & i11;
                Object obj2 = objArr2[i15];
                if (obj2 == null) {
                    objArr[i13] = objA;
                    objArr2[i15] = objA;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iB++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new o0(obj3);
        }
        if (q(i13) < iQ / 2) {
            return r(i13, objArr);
        }
        if (z(i13, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new k0(objArr, i12, objArr2, i11, i13);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> s<E> s(Collection<? extends E> collection) {
        if ((collection instanceof s) && !(collection instanceof SortedSet)) {
            s<E> sVar = (s) collection;
            if (!sVar.k()) {
                return sVar;
            }
        }
        Object[] array = collection.toArray();
        return r(array.length, array);
    }

    public static <E> s<E> w() {
        return k0.f4633i;
    }

    public static <E> s<E> x(E e10) {
        return new o0(e10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean z(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    @Override // com.google.common.collect.o
    public p<E> e() {
        p<E> pVar = this.f4681b;
        if (pVar != null) {
            return pVar;
        }
        p<E> pVarU = u();
        this.f4681b = pVarU;
        return pVarU;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof s) && v() && ((s) obj).v() && hashCode() != obj.hashCode()) {
            return false;
        }
        return n0.a(this, obj);
    }

    @Override // com.google.common.collect.o
    Object writeReplace() {
        return new b(toArray());
    }

    s() {
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return n0.b(this);
    }

    p<E> u() {
        return p.n(toArray());
    }
}
