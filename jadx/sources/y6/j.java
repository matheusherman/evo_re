package y6;

import androidx.core.view.PointerIconCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j extends a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static q6.b f22418q = q6.c.d(j.class);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f22422m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private l f22425p;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f22419j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private z6.a<String, Integer> f22420k = new z6.a<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f22421l = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Object f22423n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private z6.b<String, k> f22424o = new z6.b<>();

    @Override // y6.a
    public byte[] j(int i10, String str) {
        return null;
    }

    @Override // y6.a
    public InputStream k() {
        return null;
    }

    @Override // y6.a
    public void n() {
        this.f22403f = true;
        l lVar = this.f22425p;
        if (lVar != null) {
            lVar.stop();
        }
    }

    @Override // y6.a
    public void o() {
        this.f22419j = null;
        this.f22420k.clear();
        this.f22422m = 0;
        this.f22399b = null;
        this.f22424o.clear();
    }

    public synchronized void r(int i10, String str) {
        if (ac.g.f(str)) {
            return;
        }
        int iIntValue = this.f22420k.get(str).intValue();
        this.f22424o.putIfAbsent(str, new k(v6.b.BLOCK, i10, this.f22404g, iIntValue, str));
        this.f22401d.d(iIntValue, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        while (!this.f22403f) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.f22421l > 0) {
                    t();
                }
                for (k kVar : this.f22424o.values()) {
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

    /* JADX WARN: Code duplicated, block: B:31:0x0089  */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0045: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:70), block:B:17:0x0045 */
    private void u() throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Exception e10;
        InputStream inputStream;
        k kVar = this.f22399b;
        if (kVar == null || !kVar.q() || !this.f22420k.isEmpty()) {
            return;
        }
        InputStream inputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(this.f22399b.f());
                try {
                    Iterator<String> it = i7.a.a(byteArrayInputStream).iterator();
                    int i10 = 0;
                    while (it.hasNext()) {
                        i10++;
                        this.f22420k.put(it.next(), Integer.valueOf(i10));
                    }
                    f22418q.a("[{}][{}] total [{}] blocks.", this.f22404g, this.f22399b.i(), Integer.valueOf(this.f22420k.size()));
                    yb.e.b(byteArrayInputStream);
                } catch (Exception e11) {
                    e10 = e11;
                    f22418q.error("Parser index error.", e10);
                    if (byteArrayInputStream != null) {
                        yb.e.b(byteArrayInputStream);
                    }
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    yb.e.b(inputStream2);
                }
                throw th;
            }
        } catch (Exception e12) {
            byteArrayInputStream = null;
            e10 = e12;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                yb.e.b(inputStream2);
            }
            throw th;
        }
    }

    private void v() {
        if (!ac.g.f(this.f22419j)) {
            final int iIntValue = this.f22420k.get(this.f22419j).intValue();
            final int size = iIntValue + 5;
            if (size > this.f22420k.size()) {
                size = this.f22420k.size();
            }
            Map map = (Map) this.f22420k.entrySet().stream().filter(new Predicate() { // from class: y6.f
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return j.p(iIntValue, size, (Map.Entry) obj);
                }
            }).collect(Collectors.toMap(new Function() { // from class: y6.g
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return (String) ((Map.Entry) obj).getKey();
                }
            }, new Function() { // from class: y6.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return (Integer) ((Map.Entry) obj).getValue();
                }
            }));
            if (map != null) {
                Iterator<Map.Entry<String, k>> it = this.f22424o.entrySet().iterator();
                while (it.hasNext()) {
                    if (!map.containsKey(it.next().getValue().e())) {
                        it.remove();
                    }
                }
            }
        }
        if (this.f22424o.size() >= 5) {
            return;
        }
        String key = null;
        if (!this.f22424o.isEmpty()) {
            String key2 = null;
            for (Map.Entry<String, k> entry : this.f22424o.entrySet()) {
                if (!entry.getValue().q()) {
                    return;
                }
                if (key2 == null) {
                    key2 = entry.getKey();
                }
                if (this.f22420k.get(entry.getKey()).intValue() > this.f22420k.get(key2).intValue()) {
                    key2 = entry.getKey();
                }
            }
            int iIntValue2 = this.f22420k.get(key2).intValue() + 1;
            if (iIntValue2 > this.f22420k.size()) {
                return;
            }
            for (Map.Entry<String, Integer> entry2 : this.f22420k.entrySet()) {
                if (entry2.getValue().intValue() == iIntValue2) {
                    key = entry2.getKey();
                    break;
                }
            }
        } else {
            for (Map.Entry<String, Integer> entry3 : this.f22420k.entrySet()) {
                if (entry3.getValue().intValue() == 1) {
                    key = entry3.getKey();
                    break;
                }
            }
        }
        String str = key;
        if (ac.g.f(str)) {
            return;
        }
        try {
            byte[] bArrG = g(this.f22422m, str, false);
            if (bArrG != null) {
                this.f22424o.put(str, new k(v6.b.BLOCK, this.f22422m, this.f22404g, this.f22420k.get(str).intValue(), str, bArrG));
            } else {
                r(this.f22422m, str);
                f22418q.a("[BK]BK cache left[{}],request[{}]", this.f22424o.keySet(), str);
            }
        } catch (Exception unused) {
            f22418q.a("[BK][{}]get block cache [{}] error.", this.f22404g, str);
        }
    }

    @Override // y6.a
    public void a(int i10, int i11, String str, int i12, int i13, byte[] bArr, boolean z10) {
        if (i10 != this.f22422m) {
            return;
        }
        k kVar = this.f22424o.get(str);
        if (kVar == null) {
            f22418q.warn("Not exits blocks [{}]", str);
            return;
        }
        synchronized (this.f22423n) {
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
                    this.f22425p.b(v6.b.BLOCK, kVar.i().intValue(), kVar.c(), kVar.e(), kVar.f());
                    v();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y6.a
    public void b(int i10, String str, byte[] bArr) {
        if (i10 != this.f22422m) {
            return;
        }
        k kVar = this.f22424o.get(str);
        if (kVar == null || !kVar.q()) {
            int iIntValue = this.f22420k.get(str).intValue();
            v6.b bVar = v6.b.BLOCK;
            k kVar2 = new k(bVar, i10, this.f22404g, iIntValue, str, bArr);
            this.f22424o.put(str, kVar2);
            this.f22402e.f22409b.getAndIncrement();
            this.f22401d.c(this.f22402e, kVar2.j(), kVar2.c(), kVar2.d(), kVar2.l(), kVar2.n(), kVar2.h() - kVar2.k());
            this.f22425p.b(bVar, kVar2.i().intValue(), kVar2.c(), kVar2.e(), kVar2.f());
            v();
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
        if (this.f22399b.q()) {
            this.f22425p.b(v6.b.INDEX, this.f22399b.i().intValue(), this.f22399b.c(), this.f22399b.e(), this.f22399b.f());
            this.f22421l = -1L;
            this.f22402e.f22408a.getAndIncrement();
            u();
            v();
        }
    }

    @Override // y6.a
    public void d(int i10, int i11, String str, byte[] bArr) throws Throwable {
        v6.b bVar = v6.b.INDEX;
        k kVar = new k(bVar, i10, this.f22404g, 0, str, bArr);
        this.f22399b = kVar;
        this.f22425p.b(bVar, kVar.i().intValue(), this.f22399b.c(), this.f22399b.e(), this.f22399b.f());
        this.f22421l = -1L;
        u();
        v();
    }

    @Override // y6.a
    public byte[] g(int i10, String str, boolean z10) throws b7.a {
        if (i10 != this.f22422m) {
            throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
        }
        int iIntValue = this.f22420k.get(str).intValue();
        if (z10) {
            this.f22419j = str;
        }
        k kVar = this.f22424o.get(str);
        if (kVar != null) {
            if (!kVar.q()) {
                return null;
            }
            if (z10) {
                v();
            }
            return kVar.f();
        }
        l lVar = this.f22425p;
        v6.b bVar = v6.b.BLOCK;
        byte[] bArrA = lVar.a(bVar, i10, iIntValue, str);
        if (bArrA == null) {
            if (z10) {
                r(i10, str);
            }
            return null;
        }
        if (z10) {
            this.f22424o.put(str, new k(bVar, i10, this.f22404g, iIntValue, str, bArrA));
            v();
        }
        return bArrA;
    }

    @Override // y6.a
    public byte[] h(int i10) throws Throwable {
        if (i10 != this.f22422m) {
            throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
        }
        k kVar = this.f22399b;
        if (kVar != null) {
            if (kVar.q()) {
                return this.f22399b.f();
            }
            t();
            return null;
        }
        l lVar = this.f22425p;
        v6.b bVar = v6.b.INDEX;
        byte[] bArrA = lVar.a(bVar, i10, 0, "index.m3u8");
        if (bArrA == null) {
            t();
            return null;
        }
        this.f22399b = new k(bVar, i10, this.f22404g, 0, "index.m3u8", bArrA);
        u();
        v();
        return bArrA;
    }

    @Override // y6.a
    public void m(String str, int i10) {
        this.f22404g = str;
        this.f22422m = i10;
    }

    public j(a7.a aVar, c cVar) {
        this.f22398a = aVar;
        l lVar = aVar.f144a;
        this.f22425p = lVar;
        if (lVar != null) {
            lVar.start();
        }
        this.f22402e = new b();
        this.f22401d = cVar;
        new Thread(new Runnable() { // from class: y6.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f22417a.s();
            }
        }, "cache-loop").start();
    }

    public static /* synthetic */ boolean p(int i10, int i11, Map.Entry entry) {
        if (((Integer) entry.getValue()).intValue() >= i10 && ((Integer) entry.getValue()).intValue() <= i11) {
            return true;
        }
        return false;
    }

    public void t() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f22421l < this.f22405h) {
            return;
        }
        k kVar = this.f22399b;
        if (kVar == null) {
            k kVar2 = new k(v6.b.INDEX, this.f22422m, this.f22404g, 0, "index.m3u8");
            this.f22399b = kVar2;
            this.f22401d.e(kVar2.m());
        } else if (jCurrentTimeMillis - kVar.h() > this.f22405h) {
            this.f22401d.e(this.f22399b.m());
        }
        this.f22421l = jCurrentTimeMillis;
    }

    @Override // y6.a
    public void f(int i10, String str, byte[] bArr) {
    }

    @Override // y6.a
    public void e(int i10, String str, int i11, int i12, byte[] bArr) {
    }
}
