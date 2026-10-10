package e0;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b<K, V> extends ArrayMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9783a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f9783a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k10, V v10) {
        this.f9783a = 0;
        return (V) super.put(k10, v10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f9783a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i10) {
        this.f9783a = 0;
        return (V) super.removeAt(i10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i10, V v10) {
        this.f9783a = 0;
        return (V) super.setValueAt(i10, v10);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f9783a == 0) {
            this.f9783a = super.hashCode();
        }
        return this.f9783a;
    }
}
