package io.netty.handler.codec;

import io.netty.handler.codec.Headers;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DefaultHeaders<K, V, T extends Headers<K, V, T>> implements Headers<K, V, T> {
    private final HeaderEntry<K, V>[] entries;
    private final byte hashMask;
    private final HashingStrategy<K> hashingStrategy;
    protected final HeaderEntry<K, V> head;
    private final NameValidator<K> nameValidator;
    int size;
    private final ValueConverter<V> valueConverter;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected static class HeaderEntry<K, V> implements Map.Entry<K, V> {
        protected HeaderEntry<K, V> after;
        protected HeaderEntry<K, V> before;
        protected final int hash;
        protected final K key;
        protected HeaderEntry<K, V> next;
        protected V value;

        HeaderEntry(int i10, K k10, V v10, HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
            this.hash = i10;
            this.key = k10;
            this.value = v10;
            this.next = headerEntry;
            this.after = headerEntry2;
            this.before = headerEntry2.before;
            pointNeighborsToThis();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
                if (getValue() == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (getValue().equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.key;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.value;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        protected final void pointNeighborsToThis() {
            this.before.after = this;
            this.after.before = this;
        }

        protected void remove() {
            HeaderEntry<K, V> headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v10) {
            ObjectUtil.checkNotNull(v10, "value");
            V v11 = this.value;
            this.value = v10;
            return v11;
        }

        public final String toString() {
            return this.key.toString() + '=' + this.value.toString();
        }

        HeaderEntry() {
            this.hash = -1;
            this.key = null;
            this.after = this;
            this.before = this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class HeaderIterator implements Iterator<Map.Entry<K, V>> {
        private HeaderEntry<K, V> current;

        private HeaderIterator() {
            this.current = DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current.after != DefaultHeaders.this.head;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            HeaderEntry<K, V> headerEntry = this.current.after;
            this.current = headerEntry;
            if (headerEntry != DefaultHeaders.this.head) {
                return headerEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("read only");
        }

        /* synthetic */ HeaderIterator(DefaultHeaders defaultHeaders, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface NameValidator<K> {
        public static final NameValidator NOT_NULL = new NameValidator() { // from class: io.netty.handler.codec.DefaultHeaders.NameValidator.1
            @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
            public void validateName(Object obj) {
                ObjectUtil.checkNotNull(obj, "name");
            }
        };

        void validateName(K k10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class ValueIterator implements Iterator<V> {
        private final int hash;
        private final K name;
        private HeaderEntry<K, V> next;
        private HeaderEntry<K, V> previous;
        private HeaderEntry<K, V> removalPrevious;

        ValueIterator(K k10) {
            this.name = (K) ObjectUtil.checkNotNull(k10, "name");
            int iHashCode = DefaultHeaders.this.hashingStrategy.hashCode(k10);
            this.hash = iHashCode;
            calculateNext(DefaultHeaders.this.entries[DefaultHeaders.this.index(iHashCode)]);
        }

        private void calculateNext(HeaderEntry<K, V> headerEntry) {
            while (headerEntry != null) {
                if (headerEntry.hash == this.hash && DefaultHeaders.this.hashingStrategy.equals(this.name, headerEntry.key)) {
                    this.next = headerEntry;
                    return;
                }
                headerEntry = headerEntry.next;
            }
            this.next = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            HeaderEntry<K, V> headerEntry = this.previous;
            if (headerEntry == null) {
                throw new IllegalStateException();
            }
            this.removalPrevious = DefaultHeaders.this.remove0(headerEntry, this.removalPrevious);
            this.previous = null;
        }

        @Override // java.util.Iterator
        public V next() {
            if (hasNext()) {
                HeaderEntry<K, V> headerEntry = this.previous;
                if (headerEntry != null) {
                    this.removalPrevious = headerEntry;
                }
                HeaderEntry<K, V> headerEntry2 = this.next;
                this.previous = headerEntry2;
                calculateNext(headerEntry2.next);
                return this.previous.value;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator) {
        this(hashingStrategy, valueConverter, nameValidator, 16);
    }

    private V remove0(int i10, int i11, K k10) {
        HeaderEntry<K, V> headerEntry = this.entries[i11];
        V v10 = null;
        if (headerEntry == null) {
            return null;
        }
        for (HeaderEntry<K, V> headerEntry2 = headerEntry.next; headerEntry2 != null; headerEntry2 = headerEntry.next) {
            if (headerEntry2.hash == i10 && this.hashingStrategy.equals(k10, headerEntry2.key)) {
                v10 = headerEntry2.value;
                headerEntry.next = headerEntry2.next;
                headerEntry2.remove();
                this.size--;
            } else {
                headerEntry = headerEntry2;
            }
        }
        HeaderEntry<K, V> headerEntry3 = this.entries[i11];
        if (headerEntry3.hash == i10 && this.hashingStrategy.equals(k10, headerEntry3.key)) {
            if (v10 == null) {
                v10 = headerEntry3.value;
            }
            this.entries[i11] = headerEntry3.next;
            headerEntry3.remove();
            this.size--;
        }
        return v10;
    }

    public boolean contains(K k10) {
        return get(k10) != null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return equals((Headers) obj, HashingStrategy.JAVA_HASHER);
        }
        return false;
    }

    public int hashCode() {
        return hashCode(HashingStrategy.JAVA_HASHER);
    }

    public T set(K k10, V v10) {
        this.nameValidator.validateName(k10);
        ObjectUtil.checkNotNull(v10, "value");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k10);
        add0(iHashCode, iIndex, k10, v10);
        return (T) thisT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T setObject(K k10, Object obj) {
        return (T) set(k10, ObjectUtil.checkNotNull(fromObject(k10, obj), "convertedValue"));
    }

    public DefaultHeaders(HashingStrategy<K> hashingStrategy, ValueConverter<V> valueConverter, NameValidator<K> nameValidator, int i10) {
        this.valueConverter = (ValueConverter) ObjectUtil.checkNotNull(valueConverter, "valueConverter");
        this.nameValidator = (NameValidator) ObjectUtil.checkNotNull(nameValidator, "nameValidator");
        this.hashingStrategy = (HashingStrategy) ObjectUtil.checkNotNull(hashingStrategy, "nameHashingStrategy");
        HeaderEntry<K, V>[] headerEntryArr = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i10, 128)))];
        this.entries = headerEntryArr;
        this.hashMask = (byte) (headerEntryArr.length - 1);
        this.head = new HeaderEntry<>();
    }

    private void add0(int i10, int i11, K k10, V v10) {
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        headerEntryArr[i11] = newHeaderEntry(i10, k10, v10, headerEntryArr[i11]);
        this.size++;
    }

    private V fromInt(K k10, int i10) {
        try {
            return this.valueConverter.convertInt(i10);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Failed to convert int value for header '" + k10 + '\'', e10);
        }
    }

    private V fromObject(K k10, Object obj) {
        try {
            return this.valueConverter.convertObject(ObjectUtil.checkNotNull(obj, "value"));
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Failed to convert object value for header '" + k10 + '\'', e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int index(int i10) {
        return i10 & this.hashMask;
    }

    public T add(K k10, V v10) {
        this.nameValidator.validateName(k10);
        ObjectUtil.checkNotNull(v10, "value");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        add0(iHashCode, index(iHashCode), k10, v10);
        return (T) thisT();
    }

    protected void addImpl(Headers<? extends K, ? extends V, ?> headers) {
        if (!(headers instanceof DefaultHeaders)) {
            for (Map.Entry<? extends K, ? extends V> entry : headers) {
                add(entry.getKey(), entry.getValue());
            }
            return;
        }
        DefaultHeaders defaultHeaders = (DefaultHeaders) headers;
        HeaderEntry<K, V> headerEntry = defaultHeaders.head.after;
        if (defaultHeaders.hashingStrategy == this.hashingStrategy && defaultHeaders.nameValidator == this.nameValidator) {
            while (headerEntry != defaultHeaders.head) {
                int i10 = headerEntry.hash;
                add0(i10, index(i10), headerEntry.key, headerEntry.value);
                headerEntry = headerEntry.after;
            }
        } else {
            while (headerEntry != defaultHeaders.head) {
                add(headerEntry.key, headerEntry.value);
                headerEntry = headerEntry.after;
            }
        }
    }

    public T clear() {
        Arrays.fill(this.entries, (Object) null);
        HeaderEntry<K, V> headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0;
        return (T) thisT();
    }

    public final boolean contains(K k10, V v10, HashingStrategy<? super V> hashingStrategy) {
        ObjectUtil.checkNotNull(k10, "name");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k10, headerEntry.key) && hashingStrategy.equals(v10, headerEntry.value)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.netty.handler.codec.Headers
    public V get(K k10) {
        ObjectUtil.checkNotNull(k10, "name");
        int iHashCode = this.hashingStrategy.hashCode(k10);
        V v10 = null;
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k10, headerEntry.key)) {
                v10 = headerEntry.value;
            }
        }
        return v10;
    }

    @Override // io.netty.handler.codec.Headers
    public List<V> getAll(K k10) {
        ObjectUtil.checkNotNull(k10, "name");
        LinkedList linkedList = new LinkedList();
        int iHashCode = this.hashingStrategy.hashCode(k10);
        for (HeaderEntry<K, V> headerEntry = this.entries[index(iHashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
            if (headerEntry.hash == iHashCode && this.hashingStrategy.equals(k10, headerEntry.key)) {
                linkedList.addFirst(headerEntry.getValue());
            }
        }
        return linkedList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getAndRemove(K k10) {
        int iHashCode = this.hashingStrategy.hashCode(k10);
        return (V) remove0(iHashCode, index(iHashCode), ObjectUtil.checkNotNull(k10, "name"));
    }

    public final int hashCode(HashingStrategy<V> hashingStrategy) {
        int iHashCode = -1028477387;
        for (K k10 : names()) {
            iHashCode = (iHashCode * 31) + this.hashingStrategy.hashCode(k10);
            List<V> all = getAll(k10);
            for (int i10 = 0; i10 < all.size(); i10++) {
                iHashCode = (iHashCode * 31) + hashingStrategy.hashCode(all.get(i10));
            }
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        HeaderEntry<K, V> headerEntry = this.head;
        return headerEntry == headerEntry.after;
    }

    @Override // io.netty.handler.codec.Headers, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new HeaderIterator(this, null);
    }

    protected HeaderEntry<K, V> newHeaderEntry(int i10, K k10, V v10, HeaderEntry<K, V> headerEntry) {
        return new HeaderEntry<>(i10, k10, v10, headerEntry, this.head);
    }

    @Override // io.netty.handler.codec.Headers
    public int size() {
        return this.size;
    }

    protected ValueConverter<V> valueConverter() {
        return this.valueConverter;
    }

    public Iterator<V> valueIterator(K k10) {
        return new ValueIterator(k10);
    }

    public T addObject(K k10, Object obj) {
        return (T) add(k10, fromObject(k10, obj));
    }

    public final boolean equals(Headers<K, V, ?> headers, HashingStrategy<V> hashingStrategy) {
        if (headers.size() != size()) {
            return false;
        }
        if (this == headers) {
            return true;
        }
        for (K k10 : names()) {
            List<V> all = headers.getAll(k10);
            List<V> all2 = getAll(k10);
            if (all.size() != all2.size()) {
                return false;
            }
            for (int i10 = 0; i10 < all.size(); i10++) {
                if (!hashingStrategy.equals(all.get(i10), all2.get(i10))) {
                    return false;
                }
            }
        }
        return true;
    }

    public Set<K> names() {
        if (isEmpty()) {
            return Collections.EMPTY_SET;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        for (HeaderEntry<K, V> headerEntry = this.head.after; headerEntry != this.head; headerEntry = headerEntry.after) {
            linkedHashSet.add(headerEntry.getKey());
        }
        return linkedHashSet;
    }

    public boolean remove(K k10) {
        if (getAndRemove(k10) != null) {
            return true;
        }
        return false;
    }

    public T setInt(K k10, int i10) {
        return (T) set(k10, fromInt(k10, i10));
    }

    public T setObject(K k10, Iterable<?> iterable) {
        Object next;
        this.nameValidator.validateName(k10);
        int iHashCode = this.hashingStrategy.hashCode(k10);
        int iIndex = index(iHashCode);
        remove0(iHashCode, iIndex, k10);
        Iterator<?> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            add0(iHashCode, iIndex, k10, fromObject(k10, next));
        }
        return (T) thisT();
    }

    public String toString() {
        return HeadersUtils.toString(getClass(), iterator(), size());
    }

    public T set(Headers<? extends K, ? extends V, ?> headers) {
        if (headers != this) {
            clear();
            addImpl(headers);
        }
        return (T) thisT();
    }

    HeaderEntry<K, V> remove0(HeaderEntry<K, V> headerEntry, HeaderEntry<K, V> headerEntry2) {
        int iIndex = index(headerEntry.hash);
        HeaderEntry<K, V>[] headerEntryArr = this.entries;
        HeaderEntry<K, V> headerEntry3 = headerEntryArr[iIndex];
        if (headerEntry3 == headerEntry) {
            headerEntry2 = headerEntry.next;
            headerEntryArr[iIndex] = headerEntry2;
        } else if (headerEntry2 == null) {
            for (HeaderEntry<K, V> headerEntry4 = headerEntry3.next; headerEntry4 != null && headerEntry4 != headerEntry; headerEntry4 = headerEntry4.next) {
                headerEntry3 = headerEntry4;
            }
            headerEntry3.next = headerEntry.next;
            headerEntry2 = headerEntry3;
        } else {
            headerEntry2.next = headerEntry.next;
        }
        headerEntry.remove();
        this.size--;
        return headerEntry2;
    }

    private T thisT() {
        return this;
    }
}
