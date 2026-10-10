package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class gc<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f2719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<K, V> f2721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile mc f2723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<K, V> f2724f;

    /* synthetic */ gc(pc pcVar) {
        this();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gc)) {
            return super.equals(obj);
        }
        gc gcVar = (gc) obj;
        int size = size();
        if (size != gcVar.size()) {
            return false;
        }
        int i10 = this.f2720b;
        if (i10 != gcVar.f2720b) {
            return entrySet().equals(gcVar.entrySet());
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!f(i11).equals(gcVar.f(i11))) {
                return false;
            }
        }
        if (i10 != size) {
            return this.f2721c.equals(gcVar.f2721c);
        }
        return true;
    }

    private gc() {
        Map<K, V> map = Collections.EMPTY_MAP;
        this.f2721c = map;
        this.f2724f = map;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    /* JADX WARN: Code duplicated, block: B:21:0x003b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0038 A[SYNTHETIC] */
    private final int c(K k10) {
        int i10;
        int i11;
        int i12;
        int iCompareTo;
        int i13 = this.f2720b;
        int i14 = i13 - 1;
        if (i14 < 0) {
            i10 = 0;
            while (i10 <= i14) {
                i12 = (i10 + i14) / 2;
                iCompareTo = k10.compareTo((Comparable) ((kc) this.f2719a[i12]).getKey());
                if (iCompareTo < 0) {
                    i14 = i12 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i12;
                    }
                    i10 = i12 + 1;
                }
            }
            i11 = i10 + 1;
        } else {
            int iCompareTo2 = k10.compareTo((Comparable) ((kc) this.f2719a[i14]).getKey());
            if (iCompareTo2 > 0) {
                i11 = i13 + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i14;
                }
                i10 = 0;
                while (i10 <= i14) {
                    i12 = (i10 + i14) / 2;
                    iCompareTo = k10.compareTo((Comparable) ((kc) this.f2719a[i12]).getKey());
                    if (iCompareTo < 0) {
                        i14 = i12 - 1;
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
    public final void r() {
        if (this.f2722d) {
            throw new UnsupportedOperationException();
        }
    }

    public final int a() {
        return this.f2720b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return c(comparable) >= 0 || this.f2721c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f2723e == null) {
            this.f2723e = new mc(this, null);
        }
        return this.f2723e;
    }

    public final Map.Entry<K, V> f(int i10) {
        if (i10 < this.f2720b) {
            return (kc) this.f2719a[i10];
        }
        throw new ArrayIndexOutOfBoundsException(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iC = c(comparable);
        return iC >= 0 ? (V) ((kc) this.f2719a[iC]).getValue() : this.f2721c.get(comparable);
    }

    public final Iterable<Map.Entry<K, V>> h() {
        return this.f2721c.isEmpty() ? Collections.EMPTY_SET : this.f2721c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i10 = this.f2720b;
        int iHashCode = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode += this.f2719a[i11].hashCode();
        }
        return this.f2721c.size() > 0 ? iHashCode + this.f2721c.hashCode() : iHashCode;
    }

    final Set<Map.Entry<K, V>> l() {
        return new lc(this, null);
    }

    public void m() {
        if (this.f2722d) {
            return;
        }
        this.f2721c = this.f2721c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f2721c);
        this.f2724f = this.f2724f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f2724f);
        this.f2722d = true;
    }

    public final boolean o() {
        return this.f2722d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f2720b + this.f2721c.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V i(int i10) {
        r();
        V v10 = (V) ((kc) this.f2719a[i10]).getValue();
        Object[] objArr = this.f2719a;
        System.arraycopy(objArr, i10 + 1, objArr, i10, (this.f2720b - i10) - 1);
        this.f2720b--;
        if (!this.f2721c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = q().entrySet().iterator();
            this.f2719a[this.f2720b] = new kc(this, it.next());
            this.f2720b++;
            it.remove();
        }
        return v10;
    }

    private final SortedMap<K, V> q() {
        r();
        if (this.f2721c.isEmpty() && !(this.f2721c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2721c = treeMap;
            this.f2724f = treeMap.descendingMap();
        }
        return (SortedMap) this.f2721c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        r();
        if (this.f2720b != 0) {
            this.f2719a = null;
            this.f2720b = 0;
        }
        if (!this.f2721c.isEmpty()) {
            this.f2721c.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final V put(K k10, V v10) {
        r();
        int iC = c(k10);
        if (iC >= 0) {
            return (V) ((kc) this.f2719a[iC]).setValue(v10);
        }
        r();
        if (this.f2719a == null) {
            this.f2719a = new Object[16];
        }
        int i10 = -(iC + 1);
        if (i10 >= 16) {
            return q().put(k10, v10);
        }
        int i11 = this.f2720b;
        if (i11 == 16) {
            kc kcVar = (kc) this.f2719a[15];
            this.f2720b = i11 - 1;
            q().put((Comparable) kcVar.getKey(), kcVar.getValue());
        }
        Object[] objArr = this.f2719a;
        System.arraycopy(objArr, i10, objArr, i10 + 1, (objArr.length - i10) - 1);
        this.f2719a[i10] = new kc(this, k10, v10);
        this.f2720b++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        r();
        Comparable comparable = (Comparable) obj;
        int iC = c(comparable);
        if (iC >= 0) {
            return i(iC);
        }
        if (this.f2721c.isEmpty()) {
            return null;
        }
        return this.f2721c.remove(comparable);
    }
}
