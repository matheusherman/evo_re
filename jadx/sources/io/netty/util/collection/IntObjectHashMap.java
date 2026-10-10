package io.netty.util.collection;

import io.netty.util.internal.MathUtil;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class IntObjectHashMap<V> implements IntObjectMap<V> {
    private static final Object NULL_VALUE = new Object();
    private final Iterable<IntObjectMap.PrimitiveEntry<V>> entries;
    private final Set<Map.Entry<Integer, V>> entrySet;
    private final Set<Integer> keySet;
    private int[] keys;
    private final float loadFactor;
    private int mask;
    private int maxSize;
    private int size;
    private V[] values;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class EntrySet extends AbstractSet<Map.Entry<Integer, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Integer, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntObjectHashMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class KeySet extends AbstractSet<Integer> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            IntObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return IntObjectHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() { // from class: io.netty.util.collection.IntObjectHashMap.KeySet.1
                private final Iterator<Map.Entry<Integer, V>> iter;

                {
                    this.iter = IntObjectHashMap.this.entrySet.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Integer next() {
                    return this.iter.next().getKey();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.iter.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return IntObjectHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Iterator<IntObjectMap.PrimitiveEntry<V>> it = IntObjectHashMap.this.entries().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                if (!collection.contains(Integer.valueOf(it.next().key()))) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntObjectHashMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class MapEntry implements Map.Entry<Integer, V> {
        private final int entryIndex;

        MapEntry(int i10) {
            this.entryIndex = i10;
        }

        private void verifyExists() {
            if (IntObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public Integer getKey() {
            verifyExists();
            return Integer.valueOf(IntObjectHashMap.this.keys[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            verifyExists();
            return (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            verifyExists();
            V v11 = (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
            IntObjectHashMap.this.values[this.entryIndex] = IntObjectHashMap.toInternal(v10);
            return v11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class MapIterator implements Iterator<Map.Entry<Integer, V>> {
        private final IntObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<Integer, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.iter.next();
            return new MapEntry(((PrimitiveIterator) this.iter).entryIndex);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class PrimitiveIterator implements Iterator<IntObjectMap.PrimitiveEntry<V>>, IntObjectMap.PrimitiveEntry<V> {
        private int entryIndex;
        private int nextIndex;
        private int prevIndex;

        private PrimitiveIterator() {
            this.prevIndex = -1;
            this.nextIndex = -1;
            this.entryIndex = -1;
        }

        private void scanNext() {
            do {
                int i10 = this.nextIndex + 1;
                this.nextIndex = i10;
                if (i10 == IntObjectHashMap.this.values.length) {
                    return;
                }
            } while (IntObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != IntObjectHashMap.this.values.length;
        }

        @Override // io.netty.util.collection.IntObjectMap.PrimitiveEntry
        public int key() {
            return IntObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // java.util.Iterator
        public IntObjectMap.PrimitiveEntry<V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.prevIndex = this.nextIndex;
            scanNext();
            this.entryIndex = this.prevIndex;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i10 = this.prevIndex;
            if (i10 == -1) {
                throw new IllegalStateException("next must be called before each remove.");
            }
            if (IntObjectHashMap.this.removeAt(i10)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        @Override // io.netty.util.collection.IntObjectMap.PrimitiveEntry
        public V value() {
            return (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
        }
    }

    public IntObjectHashMap() {
        this(8, 0.5f);
    }

    private static int hashCode(int i10) {
        return i10;
    }

    public boolean containsKey(int i10) {
        return indexOf(i10) >= 0;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntObjectMap)) {
            return false;
        }
        IntObjectMap intObjectMap = (IntObjectMap) obj;
        if (this.size != intObjectMap.size()) {
            return false;
        }
        int i10 = 0;
        while (true) {
            V[] vArr = this.values;
            if (i10 >= vArr.length) {
                return true;
            }
            V v10 = vArr[i10];
            if (v10 != null) {
                Object obj2 = intObjectMap.get(this.keys[i10]);
                if (v10 == NULL_VALUE) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (!v10.equals(obj2)) {
                    return false;
                }
            }
            i10++;
        }
    }

    @Override // io.netty.util.collection.IntObjectMap
    public V get(int i10) {
        int iIndexOf = indexOf(i10);
        if (iIndexOf == -1) {
            return null;
        }
        return (V) toExternal(this.values[iIndexOf]);
    }

    public V remove(int i10) {
        int iIndexOf = indexOf(i10);
        if (iIndexOf == -1) {
            return null;
        }
        V v10 = this.values[iIndexOf];
        removeAt(iIndexOf);
        return (V) toExternal(v10);
    }

    public IntObjectHashMap(int i10, float f10) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<IntObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.IntObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<IntObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (f10 <= 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
        }
        this.loadFactor = f10;
        int iSafeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i10);
        this.mask = iSafeFindNextPositivePowerOfTwo - 1;
        this.keys = new int[iSafeFindNextPositivePowerOfTwo];
        this.values = (V[]) new Object[iSafeFindNextPositivePowerOfTwo];
        this.maxSize = calcMaxSize(iSafeFindNextPositivePowerOfTwo);
    }

    private int calcMaxSize(int i10) {
        return Math.min(i10 - 1, (int) (i10 * this.loadFactor));
    }

    private void growSize() {
        int i10 = this.size + 1;
        this.size = i10;
        if (i10 > this.maxSize) {
            int[] iArr = this.keys;
            if (iArr.length != Integer.MAX_VALUE) {
                rehash(iArr.length << 1);
                return;
            }
            throw new IllegalStateException("Max capacity reached at size=" + this.size);
        }
    }

    private int objectToKey(Object obj) {
        return ((Integer) obj).intValue();
    }

    private int probeNext(int i10) {
        return (i10 + 1) & this.mask;
    }

    private void rehash(int i10) {
        V[] vArr;
        int[] iArr = this.keys;
        V[] vArr2 = this.values;
        this.keys = new int[i10];
        this.values = (V[]) new Object[i10];
        this.maxSize = calcMaxSize(i10);
        this.mask = i10 - 1;
        for (int i11 = 0; i11 < vArr2.length; i11++) {
            V v10 = vArr2[i11];
            if (v10 != null) {
                int i12 = iArr[i11];
                int iHashIndex = hashIndex(i12);
                while (true) {
                    vArr = this.values;
                    if (vArr[iHashIndex] == null) {
                        break;
                    } else {
                        iHashIndex = probeNext(iHashIndex);
                    }
                }
                this.keys[iHashIndex] = i12;
                vArr[iHashIndex] = v10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeAt(int i10) {
        this.size--;
        this.keys[i10] = 0;
        this.values[i10] = null;
        int iProbeNext = probeNext(i10);
        V v10 = this.values[iProbeNext];
        int i11 = i10;
        while (v10 != null) {
            int i12 = this.keys[iProbeNext];
            int iHashIndex = hashIndex(i12);
            if ((iProbeNext < iHashIndex && (iHashIndex <= i11 || i11 <= iProbeNext)) || (iHashIndex <= i11 && i11 <= iProbeNext)) {
                int[] iArr = this.keys;
                iArr[i11] = i12;
                V[] vArr = this.values;
                vArr[i11] = v10;
                iArr[iProbeNext] = 0;
                vArr[iProbeNext] = null;
                i11 = iProbeNext;
            }
            V[] vArr2 = this.values;
            iProbeNext = probeNext(iProbeNext);
            v10 = vArr2[iProbeNext];
        }
        return i11 != i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toExternal(T t10) {
        if (t10 == NULL_VALUE) {
            return null;
        }
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toInternal(T t10) {
        return t10 == null ? (T) NULL_VALUE : t10;
    }

    @Override // java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return containsKey(objectToKey(obj));
    }

    public Iterable<IntObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Integer, V>> entrySet() {
        return this.entrySet;
    }

    @Override // java.util.Map
    public int hashCode() {
        int iHashCode = this.size;
        for (int i10 : this.keys) {
            iHashCode ^= hashCode(i10);
        }
        return iHashCode;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public Set<Integer> keySet() {
        return this.keySet;
    }

    public V put(int i10, V v10) {
        int iHashIndex = hashIndex(i10);
        int iProbeNext = iHashIndex;
        do {
            Object[] objArr = this.values;
            Object obj = objArr[iProbeNext];
            if (obj == null) {
                this.keys[iProbeNext] = i10;
                objArr[iProbeNext] = toInternal(v10);
                growSize();
                return null;
            }
            if (this.keys[iProbeNext] == i10) {
                objArr[iProbeNext] = toInternal(v10);
                return (V) toExternal(obj);
            }
            iProbeNext = probeNext(iProbeNext);
        } while (iProbeNext != iHashIndex);
        throw new IllegalStateException("Unable to insert");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends V> map) {
        if (!(map instanceof IntObjectHashMap)) {
            for (Map.Entry<? extends Integer, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), (Object) entry.getValue());
            }
            return;
        }
        IntObjectHashMap intObjectHashMap = (IntObjectHashMap) map;
        int i10 = 0;
        while (true) {
            V[] vArr = intObjectHashMap.values;
            if (i10 >= vArr.length) {
                return;
            }
            V v10 = vArr[i10];
            if (v10 != null) {
                put(intObjectHashMap.keys[i10], v10);
            }
            i10++;
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new AbstractCollection<V>() { // from class: io.netty.util.collection.IntObjectHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: io.netty.util.collection.IntObjectHashMap.2.1
                    final IntObjectHashMap<V>.PrimitiveIterator iter;

                    {
                        this.iter = new PrimitiveIterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.iter.next().value();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.iter.remove();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return IntObjectHashMap.this.size;
            }
        };
    }

    private int hashIndex(int i10) {
        return hashCode(i10) & this.mask;
    }

    private int indexOf(int i10) {
        int iHashIndex = hashIndex(i10);
        int iProbeNext = iHashIndex;
        while (this.values[iProbeNext] != null) {
            if (i10 == this.keys[iProbeNext]) {
                return iProbeNext;
            }
            iProbeNext = probeNext(iProbeNext);
            if (iProbeNext == iHashIndex) {
                return -1;
            }
        }
        return -1;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Object internal = toInternal(obj);
        for (V v10 : this.values) {
            if (v10 != null && v10.equals(internal)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return get(objectToKey(obj));
    }

    protected String keyToString(int i10) {
        return Integer.toString(i10);
    }

    public String toString() {
        Object external;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.size * 4);
        sb2.append('{');
        boolean z10 = true;
        int i10 = 0;
        while (true) {
            V[] vArr = this.values;
            if (i10 < vArr.length) {
                V v10 = vArr[i10];
                if (v10 != null) {
                    if (!z10) {
                        sb2.append(", ");
                    }
                    sb2.append(keyToString(this.keys[i10]));
                    sb2.append('=');
                    if (v10 == this) {
                        external = "(this Map)";
                    } else {
                        external = toExternal(v10);
                    }
                    sb2.append(external);
                    z10 = false;
                }
                i10++;
            } else {
                sb2.append('}');
                return sb2.toString();
            }
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return remove(objectToKey(obj));
    }

    @Override // java.util.Map
    public V put(Integer num, V v10) {
        return put(objectToKey(num), v10);
    }
}
