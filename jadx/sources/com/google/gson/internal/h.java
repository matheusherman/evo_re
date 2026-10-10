package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<Comparable> f4892a = new a();
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private h<K, V>.b entrySet;
    final e<K, V> header;
    private h<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return c();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class c extends AbstractSet<K> {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends h<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return c().f4906f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.h(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e<K, V> f4897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<K, V> f4898b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4899c;

        d() {
            this.f4897a = h.this.header.f4904d;
            this.f4899c = h.this.modCount;
        }

        final e<K, V> c() {
            e<K, V> eVar = this.f4897a;
            h hVar = h.this;
            if (eVar == hVar.header) {
                throw new NoSuchElementException();
            }
            if (hVar.modCount != this.f4899c) {
                throw new ConcurrentModificationException();
            }
            this.f4897a = eVar.f4904d;
            this.f4898b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4897a != h.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f4898b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f4898b = null;
            this.f4899c = h.this.modCount;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e<K, V> f4901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<K, V> f4902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e<K, V> f4903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e<K, V> f4904d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e<K, V> f4905e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f4906f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f4907g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        V f4908h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f4909i;

        e(boolean z10) {
            this.f4906f = null;
            this.f4907g = z10;
            this.f4905e = this;
            this.f4904d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f4902b; eVar2 != null; eVar2 = eVar2.f4902b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f4903c; eVar2 != null; eVar2 = eVar2.f4903c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k10 = this.f4906f;
                if (k10 != null ? k10.equals(entry.getKey()) : entry.getKey() == null) {
                    V v10 = this.f4908h;
                    if (v10 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v10.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4906f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4908h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f4906f;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f4908h;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (v10 == null && !this.f4907g) {
                throw new NullPointerException("value == null");
            }
            V v11 = this.f4908h;
            this.f4908h = v10;
            return v11;
        }

        public String toString() {
            return this.f4906f + "=" + this.f4908h;
        }

        e(boolean z10, e<K, V> eVar, K k10, e<K, V> eVar2, e<K, V> eVar3) {
            this.f4901a = eVar;
            this.f4906f = k10;
            this.f4907g = z10;
            this.f4909i = 1;
            this.f4904d = eVar2;
            this.f4905e = eVar3;
            eVar3.f4904d = this;
            eVar2.f4905e = this;
        }
    }

    public h() {
        this(f4892a, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f4905e = eVar;
        eVar.f4904d = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj != 0) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public h(boolean z10) {
        this(f4892a, z10);
    }

    private void e(e<K, V> eVar, boolean z10) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f4902b;
            e<K, V> eVar3 = eVar.f4903c;
            int i10 = eVar2 != null ? eVar2.f4909i : 0;
            int i11 = eVar3 != null ? eVar3.f4909i : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                e<K, V> eVar4 = eVar3.f4902b;
                e<K, V> eVar5 = eVar3.f4903c;
                int i13 = (eVar4 != null ? eVar4.f4909i : 0) - (eVar5 != null ? eVar5.f4909i : 0);
                if (i13 == -1 || (i13 == 0 && !z10)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 2) {
                e<K, V> eVar6 = eVar2.f4902b;
                e<K, V> eVar7 = eVar2.f4903c;
                int i14 = (eVar6 != null ? eVar6.f4909i : 0) - (eVar7 != null ? eVar7.f4909i : 0);
                if (i14 == 1 || (i14 == 0 && !z10)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 0) {
                eVar.f4909i = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f4909i = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f4901a;
        }
    }

    private void i(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f4901a;
        eVar.f4901a = null;
        if (eVar2 != null) {
            eVar2.f4901a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f4902b == eVar) {
            eVar3.f4902b = eVar2;
        } else {
            eVar3.f4903c = eVar2;
        }
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f4902b;
        e<K, V> eVar3 = eVar.f4903c;
        e<K, V> eVar4 = eVar3.f4902b;
        e<K, V> eVar5 = eVar3.f4903c;
        eVar.f4903c = eVar4;
        if (eVar4 != null) {
            eVar4.f4901a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f4902b = eVar;
        eVar.f4901a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f4909i : 0, eVar4 != null ? eVar4.f4909i : 0) + 1;
        eVar.f4909i = iMax;
        eVar3.f4909i = Math.max(iMax, eVar5 != null ? eVar5.f4909i : 0) + 1;
    }

    private void k(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f4902b;
        e<K, V> eVar3 = eVar.f4903c;
        e<K, V> eVar4 = eVar2.f4902b;
        e<K, V> eVar5 = eVar2.f4903c;
        eVar.f4902b = eVar5;
        if (eVar5 != null) {
            eVar5.f4901a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f4903c = eVar;
        eVar.f4901a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f4909i : 0, eVar5 != null ? eVar5.f4909i : 0) + 1;
        eVar.f4909i = iMax;
        eVar2.f4909i = Math.max(iMax, eVar4 != null ? eVar4.f4909i : 0) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    e<K, V> b(K k10, boolean z10) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == f4892a ? (Comparable) k10 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f4906f) : comparator.compare(k10, eVar2.f4906f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f4902b : eVar2.f4903c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        e<K, V> eVar4 = eVar2;
        if (!z10) {
            return null;
        }
        e<K, V> eVar5 = this.header;
        if (eVar4 != null) {
            eVar = new e<>(this.allowNullValues, eVar4, k10, eVar5, eVar5.f4905e);
            if (iCompareTo < 0) {
                eVar4.f4902b = eVar;
            } else {
                eVar4.f4903c = eVar;
            }
            e(eVar4, true);
        } else {
            if (comparator == f4892a && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(this.allowNullValues, eVar4, k10, eVar5, eVar5.f4905e);
            this.root = eVar;
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z10) {
        int i10;
        if (z10) {
            e<K, V> eVar2 = eVar.f4905e;
            eVar2.f4904d = eVar.f4904d;
            eVar.f4904d.f4905e = eVar2;
        }
        e<K, V> eVar3 = eVar.f4902b;
        e<K, V> eVar4 = eVar.f4903c;
        e<K, V> eVar5 = eVar.f4901a;
        int i11 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                i(eVar, eVar3);
                eVar.f4902b = null;
            } else if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f4903c = null;
            } else {
                i(eVar, null);
            }
            e(eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e<K, V> eVarB = eVar3.f4909i > eVar4.f4909i ? eVar3.b() : eVar4.a();
        f(eVarB, false);
        e<K, V> eVar6 = eVar.f4902b;
        if (eVar6 != null) {
            i10 = eVar6.f4909i;
            eVarB.f4902b = eVar6;
            eVar6.f4901a = eVarB;
            eVar.f4902b = null;
        } else {
            i10 = 0;
        }
        e<K, V> eVar7 = eVar.f4903c;
        if (eVar7 != null) {
            i11 = eVar7.f4909i;
            eVarB.f4903c = eVar7;
            eVar7.f4901a = eVarB;
            eVar.f4903c = null;
        }
        eVarB.f4909i = Math.max(i10, i11) + 1;
        i(eVar, eVarB);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        if (v10 == null && !this.allowNullValues) {
            throw new NullPointerException("value == null");
        }
        e<K, V> eVarB = b(k10, true);
        V v11 = eVarB.f4908h;
        eVarB.f4908h = v10;
        return v11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public h(Comparator<? super K> comparator, boolean z10) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? f4892a : comparator;
        this.allowNullValues = z10;
        this.header = new e<>(z10);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> eVarD = d(entry.getKey());
        if (eVarD != null && a(eVarD.f4908h, entry.getValue())) {
            return eVarD;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (d(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f4908h;
        }
        return null;
    }

    e<K, V> h(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarH = h(obj);
        if (eVarH != null) {
            return eVarH.f4908h;
        }
        return null;
    }
}
