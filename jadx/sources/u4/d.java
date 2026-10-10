package u4;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f19356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f19357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f19358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19363h;

    private void g(long j10) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                try {
                    if (this.f19357b < 0 || (this.f19356a.isEmpty() && this.f19357b != 0)) {
                        break;
                    }
                    if (this.f19357b > j10 && !this.f19356a.isEmpty()) {
                        Map.Entry<K, V> next = this.f19356a.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.f19356a.remove(key);
                        this.f19357b -= e(key, value);
                        this.f19361f++;
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            b(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    protected V a(K k10) {
        return null;
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        try {
            i10 = this.f19362g;
            i11 = this.f19363h + i10;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.ENGLISH, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Long.valueOf(this.f19358c), Integer.valueOf(this.f19362g), Integer.valueOf(this.f19363h), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0));
    }

    public final V c(K k10) {
        V vPut;
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                V v10 = this.f19356a.get(k10);
                if (v10 != null) {
                    this.f19362g++;
                    return v10;
                }
                this.f19363h++;
                V vA = a(k10);
                if (vA == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.f19360e++;
                        vPut = this.f19356a.put(k10, vA);
                        if (vPut != null) {
                            this.f19356a.put(k10, vPut);
                        } else {
                            this.f19357b += e(k10, vA);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (vPut != null) {
                    b(false, k10, vA, vPut);
                    return vPut;
                }
                g(this.f19358c);
                return vA;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final V d(K k10, V v10) {
        V vPut;
        if (k10 == null || v10 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f19359d++;
                this.f19357b += e(k10, v10);
                vPut = this.f19356a.put(k10, v10);
                if (vPut != null) {
                    this.f19357b -= e(k10, vPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (vPut != null) {
            b(false, k10, vPut, v10);
        }
        g(this.f19358c);
        return vPut;
    }

    protected long f(K k10, V v10) {
        return 1L;
    }

    public d(long j10) {
        if (j10 > 0) {
            this.f19358c = j10;
            this.f19356a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private long e(K k10, V v10) {
        long jF = f(k10, v10);
        if (jF >= 0) {
            return jF;
        }
        throw new IllegalStateException("Negative size: " + k10 + "=" + v10);
    }

    protected void b(boolean z10, K k10, V v10, V v11) {
    }
}
