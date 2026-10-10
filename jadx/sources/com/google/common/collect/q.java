package com.google.common.collect;

import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class q<K, V> implements Map<K, V>, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map.Entry<?, ?>[] f4662d = new Map.Entry[0];
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RetainedWith
    private transient s<Map.Entry<K, V>> f4663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RetainedWith
    private transient s<K> f4664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @RetainedWith
    private transient o<V> f4665c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Comparator<? super V> f4666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object[] f4667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4668c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f4669d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        C0051a f4670e;

        /* JADX INFO: renamed from: com.google.common.collect.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0051a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f4671a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f4672b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Object f4673c;

            IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f4671a + "=" + this.f4672b + " and " + this.f4671a + "=" + this.f4673c);
            }

            C0051a(Object obj, Object obj2, Object obj3) {
                this.f4671a = obj;
                this.f4672b = obj2;
                this.f4673c = obj3;
            }
        }

        public a() {
            this(4);
        }

        public q<K, V> c() {
            return b(true);
        }

        a(int i10) {
            this.f4667b = new Object[i10 * 2];
            this.f4668c = 0;
            this.f4669d = false;
        }

        private q<K, V> b(boolean z10) {
            Object[] objArrE;
            C0051a c0051a;
            C0051a c0051a2;
            if (z10 && (c0051a2 = this.f4670e) != null) {
                throw c0051a2.a();
            }
            int length = this.f4668c;
            if (this.f4666a == null) {
                objArrE = this.f4667b;
            } else {
                if (this.f4669d) {
                    this.f4667b = Arrays.copyOf(this.f4667b, length * 2);
                }
                objArrE = this.f4667b;
                if (!z10) {
                    objArrE = e(objArrE, this.f4668c);
                    if (objArrE.length < this.f4667b.length) {
                        length = objArrE.length >>> 1;
                    }
                }
                j(objArrE, length, this.f4666a);
            }
            this.f4669d = true;
            j0 j0VarO = j0.o(length, objArrE, this);
            if (!z10 || (c0051a = this.f4670e) == null) {
                return j0VarO;
            }
            throw c0051a.a();
        }

        private void d(int i10) {
            int i11 = i10 * 2;
            Object[] objArr = this.f4667b;
            if (i11 > objArr.length) {
                this.f4667b = Arrays.copyOf(objArr, o.b.a(objArr.length, i11));
                this.f4669d = false;
            }
        }

        private Object[] e(Object[] objArr, int i10) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                Object obj = objArr[i11 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i11);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i10 - bitSet.cardinality()) * 2];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10 * 2) {
                if (bitSet.get(i12 >>> 1)) {
                    i12 += 2;
                } else {
                    int i14 = i13 + 1;
                    int i15 = i12 + 1;
                    Object obj2 = objArr[i12];
                    Objects.requireNonNull(obj2);
                    objArr2[i13] = obj2;
                    i13 += 2;
                    i12 += 2;
                    Object obj3 = objArr[i15];
                    Objects.requireNonNull(obj3);
                    objArr2[i14] = obj3;
                }
            }
            return objArr2;
        }

        static <V> void j(Object[] objArr, int i10, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 2;
                Object obj = objArr[i12];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i12 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i11] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i10, g0.a(comparator).e(z.d()));
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                objArr[i14] = entryArr[i13].getKey();
                objArr[i14 + 1] = entryArr[i13].getValue();
            }
        }

        public a<K, V> f(K k10, V v10) {
            d(this.f4668c + 1);
            g.a(k10, v10);
            Object[] objArr = this.f4667b;
            int i10 = this.f4668c;
            objArr[i10 * 2] = k10;
            objArr[(i10 * 2) + 1] = v10;
            this.f4668c = i10 + 1;
            return this;
        }

        public a<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                d(this.f4668c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        public q<K, V> a() {
            return c();
        }

        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a<K, V> i(Map<? extends K, ? extends V> map) {
            return h(map.entrySet());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        /* JADX WARN: Multi-variable type inference failed */
        final Object a() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            a<K, V> aVarB = b(objArr.length);
            for (int i10 = 0; i10 < objArr.length; i10++) {
                aVarB.f(objArr[i10], objArr2[i10]);
            }
            return aVarB.c();
        }

        a<K, V> b(int i10) {
            return new a<>(i10);
        }

        final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof s)) {
                return a();
            }
            s sVar = (s) obj;
            o oVar = (o) this.values;
            a aVar = (a<K, V>) b(sVar.size());
            s0 it = sVar.iterator();
            s0 it2 = oVar.iterator();
            while (it.hasNext()) {
                aVar.f(it.next(), it2.next());
            }
            return aVar.c();
        }

        b(q<K, V> qVar) {
            Object[] objArr = new Object[qVar.size()];
            Object[] objArr2 = new Object[qVar.size()];
            s0<Map.Entry<K, V>> it = qVar.entrySet().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i10] = next.getKey();
                objArr2[i10] = next.getValue();
                i10++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }
    }

    abstract s<Map.Entry<K, V>> c();

    abstract s<K> d();

    abstract o<V> e();

    @Override // java.util.Map
    public abstract V get(Object obj);

    public static <K, V> a<K, V> a() {
        return new a<>();
    }

    public static <K, V> q<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.h(iterable);
        return aVar.a();
    }

    public static <K, V> q<K, V> i() {
        return (q<K, V>) j0.f4619h;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public s<Map.Entry<K, V>> entrySet() {
        s<Map.Entry<K, V>> sVar = this.f4663a;
        if (sVar != null) {
            return sVar;
        }
        s<Map.Entry<K, V>> sVarC = c();
        this.f4663a = sVarC;
        return sVarC;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public s<K> keySet() {
        s<K> sVar = this.f4664b;
        if (sVar != null) {
            return sVar;
        }
        s<K> sVarD = d();
        this.f4664b = sVarD;
        return sVarD;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public o<V> values() {
        o<V> oVar = this.f4665c;
        if (oVar != null) {
            return oVar;
        }
        o<V> oVarE = e();
        this.f4665c = oVarE;
        return oVarE;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    Object writeReplace() {
        return new b(this);
    }

    q() {
    }

    public static <K, V> q<K, V> j(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        g.a(k10, v10);
        g.a(k11, v11);
        g.a(k12, v12);
        g.a(k13, v13);
        return j0.n(4, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13});
    }

    public static <K, V> q<K, V> k(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        g.a(k10, v10);
        g.a(k11, v11);
        g.a(k12, v12);
        g.a(k13, v13);
        g.a(k14, v14);
        return j0.n(5, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14});
    }

    @SafeVarargs
    public static <K, V> q<K, V> l(Map.Entry<? extends K, ? extends V>... entryArr) {
        return b(Arrays.asList(entryArr));
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return z.a(this, obj);
    }

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v10) {
        V v11 = get(obj);
        if (v11 != null) {
            return v11;
        }
        return v10;
    }

    @Override // java.util.Map
    public int hashCode() {
        return n0.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return z.c(this);
    }
}
