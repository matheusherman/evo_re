package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class i<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f4593j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Object f4594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient int[] f4595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient Object[] f4596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient Object[] f4597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient int f4598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f4599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient Set<K> f4600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f4601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient Collection<V> f4602i;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends i<K, V>.e<K> {
        a() {
            super(i.this, null);
        }

        @Override // com.google.common.collect.i.e
        K d(int i10) {
            return (K) i.this.H(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends i<K, V>.e<Map.Entry<K, V>> {
        b() {
            super(i.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.i.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> d(int i10) {
            return new g(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends i<K, V>.e<V> {
        c() {
            super(i.this, null);
        }

        @Override // com.google.common.collect.i.e
        V d(int i10) {
            return (V) i.this.X(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends AbstractSet<Map.Entry<K, V>> {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> mapX = i.this.x();
            if (mapX != null) {
                return mapX.entrySet().contains(obj);
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int iE = i.this.E(entry.getKey());
                if (iE != -1 && com.google.common.base.k.a(i.this.X(iE), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return i.this.z();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iC;
            int iF;
            Map<K, V> mapX = i.this.x();
            if (mapX != null) {
                return mapX.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (i.this.K() || (iF = j.f(entry.getKey(), entry.getValue(), (iC = i.this.C()), i.this.O(), i.this.M(), i.this.N(), i.this.P())) == -1) {
                return false;
            }
            i.this.J(iF, iC);
            i.e(i.this);
            i.this.D();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4609c;

        private e() {
            this.f4607a = i.this.f4598e;
            this.f4608b = i.this.A();
            this.f4609c = -1;
        }

        abstract T d(int i10);

        private void c() {
            if (i.this.f4598e != this.f4607a) {
                throw new ConcurrentModificationException();
            }
        }

        void e() {
            this.f4607a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4608b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            c();
            if (hasNext()) {
                int i10 = this.f4608b;
                this.f4609c = i10;
                T tD = d(i10);
                this.f4608b = i.this.B(this.f4608b);
                return tD;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z10;
            c();
            if (this.f4609c >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.collect.g.c(z10);
            e();
            i iVar = i.this;
            iVar.remove(iVar.H(this.f4609c));
            this.f4608b = i.this.p(this.f4608b, this.f4609c);
            this.f4609c = -1;
        }

        /* synthetic */ e(i iVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f extends AbstractSet<K> {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return i.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return i.this.I();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> mapX = i.this.x();
            if (mapX != null) {
                return mapX.keySet().remove(obj);
            }
            return i.this.L(obj) != i.f4593j;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class g extends com.google.common.collect.c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f4612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4613b;

        g(int i10) {
            this.f4612a = (K) i.this.H(i10);
            this.f4613b = i10;
        }

        private void a() {
            int i10 = this.f4613b;
            if (i10 == -1 || i10 >= i.this.size() || !com.google.common.base.k.a(this.f4612a, i.this.H(this.f4613b))) {
                this.f4613b = i.this.E(this.f4612a);
            }
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public K getKey() {
            return this.f4612a;
        }

        @Override // com.google.common.collect.c, java.util.Map.Entry
        public V getValue() {
            Map<K, V> mapX = i.this.x();
            if (mapX != null) {
                return (V) e0.a(mapX.get(this.f4612a));
            }
            a();
            int i10 = this.f4613b;
            return i10 == -1 ? (V) e0.b() : (V) i.this.X(i10);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            Map<K, V> mapX = i.this.x();
            if (mapX != null) {
                return (V) e0.a(mapX.put(this.f4612a, v10));
            }
            a();
            int i10 = this.f4613b;
            if (i10 == -1) {
                i.this.put(this.f4612a, v10);
                return (V) e0.b();
            }
            V v11 = (V) i.this.X(i10);
            i.this.W(this.f4613b, v10);
            return v11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h extends AbstractCollection<V> {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return i.this.Y();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return i.this.size();
        }
    }

    void F(int i10) {
        com.google.common.base.m.e(i10 >= 0, "Expected size must be >= 0");
        this.f4598e = g2.c.b(i10, 1, 1073741823);
    }

    void G(int i10, K k10, V v10, int i11, int i12) {
        T(i10, j.d(i11, 0, i12));
        V(i10, k10);
        W(i10, v10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C() {
        return (1 << (this.f4598e & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] M() {
        int[] iArr = this.f4595b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] N() {
        Object[] objArr = this.f4596c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object O() {
        Object obj = this.f4594a;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] P() {
        Object[] objArr = this.f4597d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    static /* synthetic */ int e(i iVar) {
        int i10 = iVar.f4599f;
        iVar.f4599f = i10 - 1;
        return i10;
    }

    public static <K, V> i<K, V> s() {
        return new i<>();
    }

    int B(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.f4599f) {
            return i11;
        }
        return -1;
    }

    void D() {
        this.f4598e += 32;
    }

    boolean K() {
        return this.f4594a == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f4601h;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setT = t();
        this.f4601h = setT;
        return setT;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f4600g;
        if (set != null) {
            return set;
        }
        Set<K> setV = v();
        this.f4600g = setV;
        return setV;
    }

    int p(int i10, int i11) {
        return i10 - 1;
    }

    Set<Map.Entry<K, V>> t() {
        return new d();
    }

    Map<K, V> u(int i10) {
        return new LinkedHashMap(i10, 1.0f);
    }

    Set<K> v() {
        return new f();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f4602i;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionW = w();
        this.f4602i = collectionW;
        return collectionW;
    }

    Collection<V> w() {
        return new h();
    }

    Map<K, V> x() {
        Object obj = this.f4594a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    i() {
        F(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E(Object obj) {
        if (K()) {
            return -1;
        }
        int iC = n.c(obj);
        int iC2 = C();
        int iH = j.h(O(), iC & iC2);
        if (iH == 0) {
            return -1;
        }
        int iB = j.b(iC, iC2);
        do {
            int i10 = iH - 1;
            int iY = y(i10);
            if (j.b(iY, iC2) == iB && com.google.common.base.k.a(obj, H(i10))) {
                return i10;
            }
            iH = j.c(iY, iC2);
        } while (iH != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K H(int i10) {
        return (K) N()[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object L(Object obj) {
        if (K()) {
            return f4593j;
        }
        int iC = C();
        int iF = j.f(obj, null, iC, O(), M(), N(), null);
        if (iF == -1) {
            return f4593j;
        }
        V vX = X(iF);
        J(iF, iC);
        this.f4599f--;
        D();
        return vX;
    }

    private void R(int i10) {
        int iMin;
        int length = M().length;
        if (i10 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            Q(iMin);
        }
    }

    private int S(int i10, int i11, int i12, int i13) {
        Object objA = j.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            j.i(objA, i12 & i14, i13 + 1);
        }
        Object objO = O();
        int[] iArrM = M();
        for (int i15 = 0; i15 <= i10; i15++) {
            int iH = j.h(objO, i15);
            while (iH != 0) {
                int i16 = iH - 1;
                int i17 = iArrM[i16];
                int iB = j.b(i17, i10) | i15;
                int i18 = iB & i14;
                int iH2 = j.h(objA, i18);
                j.i(objA, i18, iH);
                iArrM[i16] = j.d(iB, iH2, i14);
                iH = j.c(i17, i10);
            }
        }
        this.f4594a = objA;
        U(i14);
        return i14;
    }

    private void T(int i10, int i11) {
        M()[i10] = i11;
    }

    private void U(int i10) {
        this.f4598e = j.d(this.f4598e, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private void V(int i10, K k10) {
        N()[i10] = k10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i10, V v10) {
        P()[i10] = v10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V X(int i10) {
        return (V) P()[i10];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i10 = objectInputStream.readInt();
        if (i10 >= 0) {
            F(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + i10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> itZ = z();
        while (itZ.hasNext()) {
            Map.Entry<K, V> next = itZ.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    private int y(int i10) {
        return M()[i10];
    }

    int A() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    Iterator<K> I() {
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.keySet().iterator();
        }
        return new a();
    }

    void J(int i10, int i11) {
        Object objO = O();
        int[] iArrM = M();
        Object[] objArrN = N();
        Object[] objArrP = P();
        int size = size();
        int i12 = size - 1;
        if (i10 < i12) {
            Object obj = objArrN[i12];
            objArrN[i10] = obj;
            objArrP[i10] = objArrP[i12];
            objArrN[i12] = null;
            objArrP[i12] = null;
            iArrM[i10] = iArrM[i12];
            iArrM[i12] = 0;
            int iC = n.c(obj) & i11;
            int iH = j.h(objO, iC);
            if (iH == size) {
                j.i(objO, iC, i10 + 1);
                return;
            }
            while (true) {
                int i13 = iH - 1;
                int i14 = iArrM[i13];
                int iC2 = j.c(i14, i11);
                if (iC2 == size) {
                    iArrM[i13] = j.d(i14, i10 + 1, i11);
                    return;
                }
                iH = iC2;
            }
        } else {
            objArrN[i10] = null;
            objArrP[i10] = null;
            iArrM[i10] = 0;
        }
    }

    void Q(int i10) {
        this.f4595b = Arrays.copyOf(M(), i10);
        this.f4596c = Arrays.copyOf(N(), i10);
        this.f4597d = Arrays.copyOf(P(), i10);
    }

    Iterator<V> Y() {
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.values().iterator();
        }
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (K()) {
            return;
        }
        D();
        Map<K, V> mapX = x();
        if (mapX != null) {
            this.f4598e = g2.c.b(size(), 3, 1073741823);
            mapX.clear();
            this.f4594a = null;
            this.f4599f = 0;
            return;
        }
        Arrays.fill(N(), 0, this.f4599f, (Object) null);
        Arrays.fill(P(), 0, this.f4599f, (Object) null);
        j.g(O());
        Arrays.fill(M(), 0, this.f4599f, 0);
        this.f4599f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.containsKey(obj);
        }
        if (E(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f4599f; i10++) {
            if (com.google.common.base.k.a(obj, X(i10))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.get(obj);
        }
        int iE = E(obj);
        if (iE == -1) {
            return null;
        }
        o(iE);
        return X(iE);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        if (K()) {
            q();
        }
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.put(k10, v10);
        }
        int[] iArrM = M();
        Object[] objArrN = N();
        Object[] objArrP = P();
        int i10 = this.f4599f;
        int i11 = i10 + 1;
        int iC = n.c(k10);
        int iC2 = C();
        int i12 = iC & iC2;
        int iH = j.h(O(), i12);
        if (iH == 0) {
            if (i11 > iC2) {
                iC2 = S(iC2, j.e(iC2), iC, i10);
            } else {
                j.i(O(), i12, i11);
            }
        } else {
            int iB = j.b(iC, iC2);
            int i13 = 0;
            while (true) {
                int i14 = iH - 1;
                int i15 = iArrM[i14];
                if (j.b(i15, iC2) == iB && com.google.common.base.k.a(k10, objArrN[i14])) {
                    V v11 = (V) objArrP[i14];
                    objArrP[i14] = v10;
                    o(i14);
                    return v11;
                }
                int iC3 = j.c(i15, iC2);
                i13++;
                if (iC3 == 0) {
                    if (i13 >= 9) {
                        return r().put(k10, v10);
                    }
                    if (i11 > iC2) {
                        iC2 = S(iC2, j.e(iC2), iC, i10);
                        break;
                    }
                    iArrM[i14] = j.d(i15, i11, iC2);
                    break;
                }
                k10 = k10;
                v10 = v10;
                iH = iC3;
            }
        }
        int i16 = iC2;
        R(i11);
        G(i10, k10, v10, iC, i16);
        this.f4599f = i11;
        D();
        return null;
    }

    int q() {
        com.google.common.base.m.o(K(), "Arrays already allocated");
        int i10 = this.f4598e;
        int iJ = j.j(i10);
        this.f4594a = j.a(iJ);
        U(iJ - 1);
        this.f4595b = new int[i10];
        this.f4596c = new Object[i10];
        this.f4597d = new Object[i10];
        return i10;
    }

    Map<K, V> r() {
        Map<K, V> mapU = u(C() + 1);
        int iA = A();
        while (iA >= 0) {
            mapU.put(H(iA), X(iA));
            iA = B(iA);
        }
        this.f4594a = mapU;
        this.f4595b = null;
        this.f4596c = null;
        this.f4597d = null;
        D();
        return mapU;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.remove(obj);
        }
        V v10 = (V) L(obj);
        if (v10 == f4593j) {
            return null;
        }
        return v10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.size();
        }
        return this.f4599f;
    }

    Iterator<Map.Entry<K, V>> z() {
        Map<K, V> mapX = x();
        if (mapX != null) {
            return mapX.entrySet().iterator();
        }
        return new b();
    }

    void o(int i10) {
    }
}
