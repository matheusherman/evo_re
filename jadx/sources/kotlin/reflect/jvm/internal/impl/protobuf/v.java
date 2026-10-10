package kotlin.reflect.jvm.internal.impl.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class v<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<v<K, V>.c> f13724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<K, V> f13725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile v<K, V>.e f13727e;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a<FieldDescriptorType> extends v<FieldDescriptorType, Object> {
        a(int i10) {
            super(i10, null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.p((h.b) obj, obj2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.v
        public void n() {
            if (!m()) {
                for (int i10 = 0; i10 < j(); i10++) {
                    Map.Entry<FieldDescriptorType, Object> entryI = i(i10);
                    if (((h.b) entryI.getKey()).E()) {
                        entryI.setValue(Collections.unmodifiableList((List) entryI.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : k()) {
                    if (((h.b) entry.getKey()).E()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f13728a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f13729b = new C0245b();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            a() {
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.v$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class C0245b implements Iterable<Object> {
            C0245b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f13728a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f13729b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class c implements Comparable<v<K, V>.c>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f13730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private V f13731b;

        c(v vVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return f(this.f13730a, entry.getKey()) && f(this.f13731b, entry.getValue());
        }

        c(K k10, V v10) {
            this.f13730a = k10;
            this.f13731b = v10;
        }

        private boolean f(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f13731b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f13730a;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f13731b;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f13730a;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            v.this.f();
            V v11 = this.f13731b;
            this.f13731b = v10;
            return v11;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f13730a);
            String strValueOf2 = String.valueOf(this.f13731b);
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
            sb2.append(strValueOf);
            sb2.append("=");
            sb2.append(strValueOf2);
            return sb2.toString();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(v<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class d implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f13735c;

        private d() {
            this.f13733a = -1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f13734b = true;
            int i10 = this.f13733a + 1;
            this.f13733a = i10;
            return i10 < v.this.f13724b.size() ? (Map.Entry) v.this.f13724b.get(this.f13733a) : c().next();
        }

        private Iterator<Map.Entry<K, V>> c() {
            if (this.f13735c == null) {
                this.f13735c = v.this.f13725c.entrySet().iterator();
            }
            return this.f13735c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13733a + 1 < v.this.f13724b.size() || c().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f13734b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f13734b = false;
            v.this.f();
            if (this.f13733a >= v.this.f13724b.size()) {
                c().remove();
                return;
            }
            v vVar = v.this;
            int i10 = this.f13733a;
            this.f13733a = i10 - 1;
            vVar.q(i10);
        }

        /* synthetic */ d(v vVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        /* synthetic */ e(v vVar, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = v.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(v.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            v.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (!contains(entry)) {
                v.this.p(entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }
    }

    /* synthetic */ v(int i10, a aVar) {
        this(i10);
    }

    private v(int i10) {
        this.f13723a = i10;
        this.f13724b = Collections.EMPTY_LIST;
        this.f13725c = Collections.EMPTY_MAP;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x003c A[SYNTHETIC] */
    private int e(K k10) {
        int i10;
        int i11;
        int i12;
        int iCompareTo;
        int size = this.f13724b.size();
        int i13 = size - 1;
        if (i13 < 0) {
            i10 = 0;
            while (i10 <= i13) {
                i12 = (i10 + i13) / 2;
                iCompareTo = k10.compareTo(this.f13724b.get(i12).getKey());
                if (iCompareTo < 0) {
                    i13 = i12 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i12;
                    }
                    i10 = i12 + 1;
                }
            }
            i11 = i10 + 1;
        } else {
            int iCompareTo2 = k10.compareTo(this.f13724b.get(i13).getKey());
            if (iCompareTo2 > 0) {
                i11 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i13;
                }
                i10 = 0;
                while (i10 <= i13) {
                    i12 = (i10 + i13) / 2;
                    iCompareTo = k10.compareTo(this.f13724b.get(i12).getKey());
                    if (iCompareTo < 0) {
                        i13 = i12 - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i12;
                        }
                        i10 = i12 + 1;
                    }
                }
                i11 = i10 + 1;
            }
        }
        return -i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f13726d) {
            throw new UnsupportedOperationException();
        }
    }

    static <FieldDescriptorType extends h.b<FieldDescriptorType>> v<FieldDescriptorType, Object> o(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f13725c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f13727e == null) {
            this.f13727e = new e(this, null);
        }
        return this.f13727e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        return iE >= 0 ? this.f13724b.get(iE).getValue() : this.f13725c.get(comparable);
    }

    public Map.Entry<K, V> i(int i10) {
        return this.f13724b.get(i10);
    }

    public int j() {
        return this.f13724b.size();
    }

    public Iterable<Map.Entry<K, V>> k() {
        return this.f13725c.isEmpty() ? b.b() : this.f13725c.entrySet();
    }

    public boolean m() {
        return this.f13726d;
    }

    public void n() {
        if (this.f13726d) {
            return;
        }
        this.f13725c = this.f13725c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f13725c);
        this.f13726d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f13724b.size() + this.f13725c.size();
    }

    private void h() {
        f();
        if (this.f13724b.isEmpty() && !(this.f13724b instanceof ArrayList)) {
            this.f13724b = new ArrayList(this.f13723a);
        }
    }

    private SortedMap<K, V> l() {
        f();
        if (this.f13725c.isEmpty() && !(this.f13725c instanceof TreeMap)) {
            this.f13725c = new TreeMap();
        }
        return (SortedMap) this.f13725c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V q(int i10) {
        f();
        V value = this.f13724b.remove(i10).getValue();
        if (!this.f13725c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = l().entrySet().iterator();
            this.f13724b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f13724b.isEmpty()) {
            this.f13724b.clear();
        }
        if (!this.f13725c.isEmpty()) {
            this.f13725c.clear();
        }
    }

    public V p(K k10, V v10) {
        f();
        int iE = e(k10);
        if (iE >= 0) {
            return this.f13724b.get(iE).setValue(v10);
        }
        h();
        int i10 = -(iE + 1);
        if (i10 >= this.f13723a) {
            return l().put(k10, v10);
        }
        int size = this.f13724b.size();
        int i11 = this.f13723a;
        if (size == i11) {
            v<K, V>.c cVarRemove = this.f13724b.remove(i11 - 1);
            l().put(cVarRemove.getKey(), cVarRemove.getValue());
        }
        this.f13724b.add(i10, new c(k10, v10));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        if (iE >= 0) {
            return q(iE);
        }
        if (this.f13725c.isEmpty()) {
            return null;
        }
        return this.f13725c.remove(comparable);
    }
}
