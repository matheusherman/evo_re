package y6;

import androidx.core.view.PointerIconCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v extends a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static q6.b f22463v = q6.c.d(v.class);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f22468n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private l f22473s;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f22464j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f22465k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ConcurrentSkipListMap<Integer, String> f22466l = new z6.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f22467m = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Object f22469o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ConcurrentSkipListMap<String, k> f22470p = new z6.b(u());

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, k> f22471q = new z6.a();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<String, Long> f22472r = new z6.a();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f22474t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f22475u = -1;

    private synchronized void y() {
        Map.Entry<Integer, String> entryFirstEntry;
        try {
            int i10 = this.f22464j;
            if (i10 >= 0 && i10 < this.f22466l.size()) {
                int i11 = this.f22464j;
                int size = i11 + 5;
                ConcurrentSkipListMap<Integer, String> concurrentSkipListMap = this.f22466l;
                Integer numValueOf = Integer.valueOf(i11);
                if (size > this.f22466l.size()) {
                    size = this.f22466l.size();
                }
                ConcurrentNavigableMap<Integer, String> concurrentNavigableMapSubMap = concurrentSkipListMap.subMap(numValueOf, Integer.valueOf(size));
                if (concurrentNavigableMapSubMap != null) {
                    Iterator<Map.Entry<String, k>> it = this.f22470p.entrySet().iterator();
                    while (it.hasNext()) {
                        if (!concurrentNavigableMapSubMap.containsKey(Integer.valueOf(it.next().getValue().c()))) {
                            it.remove();
                        }
                    }
                }
            }
            if (this.f22470p.size() >= 5) {
                return;
            }
            if (this.f22470p.isEmpty()) {
                entryFirstEntry = this.f22466l.firstEntry();
            } else {
                k value = this.f22470p.lastEntry().getValue();
                if (!value.q()) {
                    return;
                } else {
                    entryFirstEntry = this.f22466l.higherEntry(v(value.e()));
                }
            }
            if (entryFirstEntry == null) {
                return;
            }
            String value2 = entryFirstEntry.getValue();
            try {
                byte[] bArrG = g(this.f22468n, value2, false);
                if (bArrG == null) {
                    s(this.f22468n, value2);
                    f22463v.a("[BK] cache left[{}],read [{}],request[{}]", this.f22470p.keySet(), Integer.valueOf(this.f22464j), value2);
                } else {
                    this.f22470p.put(value2, new k(v6.b.BLOCK, this.f22468n, this.f22404g, entryFirstEntry.getKey().intValue(), value2, bArrG));
                }
            } catch (Exception unused) {
                f22463v.a("[BK][{}]get block cache [{}] error.", this.f22404g, value2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // y6.a
    public InputStream k() {
        return null;
    }

    @Override // y6.a
    public void n() {
        this.f22403f = true;
        l lVar = this.f22473s;
        if (lVar != null) {
            lVar.stop();
        }
    }

    @Override // y6.a
    public void o() {
        this.f22464j = -1;
        this.f22465k = -1;
        this.f22466l.clear();
        this.f22468n = 0;
        this.f22399b = null;
        this.f22471q.clear();
        this.f22472r.clear();
        this.f22470p.clear();
    }

    public synchronized void s(int i10, String str) {
        try {
            if (ac.g.f(str)) {
                return;
            }
            int iIntValue = v(str).intValue();
            if (this.f22470p.containsKey(str)) {
                return;
            }
            int i11 = this.f22465k;
            if (i11 >= 0 && this.f22464j - i11 > 2) {
                this.f22470p.clear();
                f22463v.a("[VOD] jump block request[{}]. last:[]", str, Integer.valueOf(this.f22465k));
            }
            this.f22470p.putIfAbsent(str, new k(v6.b.BLOCK, i10, this.f22404g, iIntValue, str));
            this.f22401d.d(iIntValue, str, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void z(String str) {
        if (ac.g.f(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l10 = this.f22472r.get(str);
        if (l10 == null || jCurrentTimeMillis - l10.longValue() >= 800) {
            k kVar = this.f22471q.get(str);
            if (kVar == null) {
                this.f22471q.putIfAbsent(str, new k(v6.b.SUBTITLE, this.f22468n, this.f22404g, 0, str));
                this.f22401d.b(str, null);
                this.f22472r.put(str, Long.valueOf(jCurrentTimeMillis));
            } else {
                if (kVar.q()) {
                    return;
                }
                if (jCurrentTimeMillis - kVar.h() > 800) {
                    this.f22401d.b(str, kVar.m());
                    this.f22472r.put(str, Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        while (!this.f22403f) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.f22467m > 0) {
                    w();
                }
                for (k kVar : this.f22470p.values()) {
                    if (!kVar.q() && jCurrentTimeMillis - kVar.h() > 800) {
                        this.f22401d.d(kVar.c(), kVar.e(), kVar.m());
                        kVar.x(jCurrentTimeMillis);
                        kVar.a();
                    }
                }
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
    }

    private Comparator<String> u() {
        if (!this.f22474t) {
            return new Comparator() { // from class: y6.u
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return v.v((String) obj).compareTo(v.v((String) obj2));
                }
            };
        }
        try {
            return Comparator.comparingInt(new ToIntFunction() { // from class: y6.s
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    return v.v((String) obj).intValue();
                }
            });
        } catch (Throwable th) {
            f22463v.error("vod_cache_compare_key_with Comparator.comparingInt failure", th);
            this.f22474t = false;
            return new Comparator() { // from class: y6.t
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return v.v((String) obj).compareTo(v.v((String) obj2));
                }
            };
        }
    }

    private void x() throws Throwable {
        k kVar = this.f22399b;
        if (kVar == null || !kVar.q() || !this.f22466l.isEmpty()) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(kVar.f());
                try {
                    for (String str : i7.a.a(byteArrayInputStream2)) {
                        this.f22466l.put(v(str), str);
                    }
                    f22463v.a("[BK][{}][{}] total [{}] blocks.", this.f22404g, kVar.i(), Integer.valueOf(this.f22466l.size()));
                    yb.e.b(byteArrayInputStream2);
                } catch (Exception e10) {
                    e = e10;
                    byteArrayInputStream = byteArrayInputStream2;
                    f22463v.error("Parser index error.", e);
                    if (byteArrayInputStream != null) {
                        yb.e.b(byteArrayInputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    if (byteArrayInputStream != null) {
                        yb.e.b(byteArrayInputStream);
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // y6.a
    public void a(int i10, int i11, String str, int i12, int i13, byte[] bArr, boolean z10) {
        if (i10 != this.f22468n) {
            return;
        }
        k kVar = this.f22470p.get(str);
        if (kVar == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f22475u > 3000) {
                f22463v.error("[BK][][{}]Unknown blocks[{}]", this.f22404g, str);
                this.f22475u = jCurrentTimeMillis;
                return;
            }
            return;
        }
        synchronized (this.f22469o) {
            try {
                if (kVar.q()) {
                    return;
                }
                if (kVar.o() == null) {
                    kVar.B(i13);
                    kVar.A(new BitSet(i13));
                    kVar.z(new BitSet(i13));
                    kVar.v(new byte[i13 * 1128]);
                }
                kVar.b(i12, bArr, z10, this.f22406i, this.f22405h);
                if (kVar.q()) {
                    this.f22402e.a(kVar.n());
                    this.f22402e.f22409b.getAndIncrement();
                    this.f22401d.c(this.f22402e, kVar.j(), kVar.c(), kVar.d(), kVar.l(), kVar.n(), kVar.h() - kVar.k());
                    this.f22473s.b(v6.b.BLOCK, kVar.i().intValue(), kVar.c(), kVar.e(), kVar.f());
                    y();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y6.a
    public void b(int i10, String str, byte[] bArr) {
        if (i10 != this.f22468n) {
            return;
        }
        k kVar = this.f22470p.get(str);
        if (kVar == null || !kVar.q()) {
            v6.b bVar = v6.b.BLOCK;
            k kVar2 = new k(bVar, i10, this.f22404g, v(str).intValue(), str, bArr);
            this.f22470p.put(str, kVar2);
            this.f22402e.f22409b.getAndIncrement();
            this.f22401d.c(this.f22402e, kVar2.j(), kVar2.c(), kVar2.d(), kVar2.l(), kVar2.n(), kVar2.h() - kVar2.k());
            this.f22473s.b(bVar, kVar2.i().intValue(), kVar2.c(), kVar2.e(), kVar2.f());
            y();
        }
    }

    @Override // y6.a
    public void c(int i10, int i11, String str, int i12, int i13, byte[] bArr, boolean z10) throws Throwable {
        int i14;
        if (this.f22399b == null) {
            i14 = i13;
            this.f22399b = new k(v6.b.INDEX, i10, this.f22404g, 0, str, i14);
        } else {
            i14 = i13;
        }
        if (this.f22399b.o() == null) {
            this.f22399b.B(i14);
            this.f22399b.A(new BitSet(i14));
            this.f22399b.z(new BitSet(i14));
            this.f22399b.v(new byte[i14 * 1128]);
        }
        this.f22399b.b(i12, bArr, z10, this.f22406i, this.f22405h);
        if (this.f22399b.q() && this.f22466l.isEmpty()) {
            this.f22473s.b(v6.b.INDEX, this.f22399b.i().intValue(), this.f22399b.c(), this.f22399b.e(), this.f22399b.f());
            f22463v.a("[BK][{}][{}] disk cache", this.f22404g, this.f22399b.i());
            this.f22467m = -1L;
            this.f22402e.f22408a.getAndIncrement();
            x();
            y();
        }
    }

    @Override // y6.a
    public void d(int i10, int i11, String str, byte[] bArr) throws Throwable {
        v6.b bVar = v6.b.INDEX;
        k kVar = new k(bVar, i10, this.f22404g, 0, str, bArr);
        this.f22399b = kVar;
        this.f22473s.b(bVar, kVar.i().intValue(), this.f22399b.c(), this.f22399b.e(), this.f22399b.f());
        this.f22467m = -1L;
        x();
        y();
    }

    @Override // y6.a
    public void e(int i10, String str, int i11, int i12, byte[] bArr) {
        int i13;
        String str2 = str;
        if (i10 != this.f22468n) {
            return;
        }
        if (this.f22471q.get(str2) == null) {
            i13 = i12;
            str2 = str;
            this.f22471q.putIfAbsent(str2, new k(v6.b.SUBTITLE, i10, this.f22404g, 0, str, i13));
        } else {
            i13 = i12;
        }
        synchronized (this.f22469o) {
            try {
                k kVar = this.f22471q.get(str2);
                if (kVar.q()) {
                    return;
                }
                if (kVar.o() == null) {
                    kVar.B(i13);
                    kVar.A(new BitSet(i13));
                    kVar.z(new BitSet(i13));
                    kVar.v(new byte[i13 * 1128]);
                }
                kVar.b(i11, bArr, false, this.f22406i, this.f22405h);
                if (kVar.q()) {
                    this.f22473s.b(v6.b.SUBTITLE, kVar.i().intValue(), kVar.c(), str2, kVar.f());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y6.a
    public void f(int i10, String str, byte[] bArr) {
        String str2;
        k kVar = this.f22471q.get(str);
        if (kVar == null) {
            str2 = str;
            k kVar2 = new k(v6.b.SUBTITLE, i10, this.f22404g, 0, str2, bArr);
            this.f22471q.putIfAbsent(str2, kVar2);
            kVar = kVar2;
        } else {
            str2 = str;
        }
        this.f22473s.b(v6.b.SUBTITLE, kVar.i().intValue(), kVar.c(), str2, kVar.f());
        this.f22472r.put(str2, -1L);
    }

    @Override // y6.a
    public byte[] g(int i10, String str, boolean z10) throws b7.a {
        if (i10 != this.f22468n) {
            throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
        }
        int iIntValue = v(str).intValue();
        k kVar = this.f22470p.get(str);
        if (kVar != null) {
            if (!kVar.q()) {
                return null;
            }
            if (z10) {
                y();
                this.f22465k = this.f22464j;
                this.f22464j = iIntValue;
            }
            return kVar.f();
        }
        l lVar = this.f22473s;
        v6.b bVar = v6.b.BLOCK;
        byte[] bArrA = lVar.a(bVar, i10, iIntValue, str);
        if (bArrA == null) {
            if (z10) {
                s(i10, str);
            }
            return null;
        }
        if (z10) {
            this.f22470p.put(str, new k(bVar, i10, this.f22404g, iIntValue, str, bArrA));
            y();
            this.f22465k = this.f22464j;
            this.f22464j = iIntValue;
        }
        return bArrA;
    }

    @Override // y6.a
    public byte[] h(int i10) throws Throwable {
        if (i10 != this.f22468n) {
            throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
        }
        k kVar = this.f22399b;
        if (kVar != null) {
            if (kVar.q()) {
                return this.f22399b.f();
            }
            w();
            return null;
        }
        l lVar = this.f22473s;
        v6.b bVar = v6.b.INDEX;
        byte[] bArrA = lVar.a(bVar, i10, 0, "index.m3u8");
        if (bArrA == null) {
            w();
            return null;
        }
        this.f22399b = new k(bVar, i10, this.f22404g, 0, "index.m3u8", bArrA);
        x();
        y();
        return bArrA;
    }

    @Override // y6.a
    public byte[] j(int i10, String str) throws b7.a {
        if (i10 != this.f22468n) {
            throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
        }
        k kVar = this.f22471q.get(str);
        if (kVar != null) {
            if (kVar.q()) {
                return kVar.f();
            }
            z(str);
            return null;
        }
        l lVar = this.f22473s;
        v6.b bVar = v6.b.SUBTITLE;
        byte[] bArrA = lVar.a(bVar, i10, 0, str);
        if (bArrA == null) {
            z(str);
            return null;
        }
        k kVar2 = new k(bVar, i10, this.f22404g, 0, str, bArrA);
        this.f22471q.putIfAbsent(str, kVar2);
        return kVar2.f();
    }

    @Override // y6.a
    public void m(String str, int i10) {
        this.f22404g = str;
        this.f22468n = i10;
    }

    public v(a7.a aVar, c cVar) {
        this.f22398a = aVar;
        l lVar = aVar.f144a;
        this.f22473s = lVar;
        if (lVar != null) {
            lVar.start();
        }
        this.f22402e = new b();
        this.f22401d = cVar;
        new Thread(new Runnable() { // from class: y6.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f22462a.t();
            }
        }, "cache-loop").start();
    }

    public static Integer v(String str) {
        return Integer.valueOf(Integer.parseInt(yb.d.b(str)));
    }

    public void w() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f22467m < this.f22405h) {
            return;
        }
        k kVar = this.f22399b;
        if (kVar == null) {
            k kVar2 = new k(v6.b.INDEX, this.f22468n, this.f22404g, 0, "index.m3u8");
            this.f22399b = kVar2;
            this.f22401d.e(kVar2.m());
        } else if (jCurrentTimeMillis - kVar.h() > this.f22405h) {
            this.f22401d.e(this.f22399b.m());
        }
        this.f22467m = jCurrentTimeMillis;
    }
}
