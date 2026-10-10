package y6;

import androidx.core.view.PointerIconCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o extends y6.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final q6.b f22449u = q6.c.d(o.class);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f22455o;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f22450j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CountDownLatch f22451k = new CountDownLatch(0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private LinkedHashMap<Integer, String> f22452l = new LinkedHashMap<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LinkedHashMap<String, String> f22453m = new LinkedHashMap<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private z6.b<String, k> f22454n = new z6.b<>(new a());

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private PipedInputStream f22456p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PipedOutputStream f22457q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f22458r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Object f22459s = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f22460t = -1;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iIntValue = o.t(str).intValue();
            int iIntValue2 = o.t(str2).intValue();
            if (iIntValue >= 10 && iIntValue2 >= 10) {
                return Integer.compare(iIntValue, iIntValue2);
            }
            return str.compareTo(str2);
        }
    }

    @Override // y6.a
    public byte[] j(int i10, String str) {
        return null;
    }

    public synchronized void r(int i10, String str) {
        if (ac.g.f(str)) {
            return;
        }
        if (this.f22454n.containsKey(str)) {
            return;
        }
        int iIntValue = t(str).intValue();
        this.f22450j = str;
        this.f22454n.putIfAbsent(str, new k(v6.b.BLOCK, i10, this.f22404g, iIntValue, str));
        this.f22401d.d(iIntValue, str, null);
        f22449u.debug("[BK][{}]Request block [{}] ", this.f22404g, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        char c10;
        while (!this.f22403f) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.f22400c > 0) {
                    u();
                }
                Iterator<Map.Entry<String, k>> it = this.f22454n.entrySet().iterator();
                while (this.f22454n.size() > 6) {
                    k value = it.next().getValue();
                    if (!value.q() && !value.s()) {
                        break;
                    } else {
                        it.remove();
                    }
                }
                Iterator<Map.Entry<String, String>> it2 = this.f22453m.entrySet().iterator();
                while (this.f22453m.size() > 5) {
                    it2.next();
                    it2.remove();
                }
                Iterator<Map.Entry<String, k>> it3 = this.f22454n.entrySet().iterator();
                while (it3.hasNext()) {
                    k value2 = it3.next().getValue();
                    if (!value2.q() && !value2.s()) {
                        if (jCurrentTimeMillis - value2.k() > 10000) {
                            value2.C(true);
                            it3.remove();
                            this.f22402e.f22410c.getAndIncrement();
                            c10 = 0;
                            try {
                                f22449u.warn("[BK][{}][{}] timeout.StartTime:[{}] Length:[{}],[{}/{}],resend count[{}]", this.f22404g, value2.e(), Long.valueOf(value2.k()), Integer.valueOf(value2.d()), value2.o() == null ? "-1" : Integer.valueOf(value2.o().cardinality()), Integer.valueOf(value2.p()), Integer.valueOf(value2.l()));
                                this.f22453m.put(value2.e(), value2.e());
                            } catch (Exception e10) {
                                e = e10;
                                q6.b bVar = f22449u;
                                Object[] objArr = new Object[1];
                                objArr[c10] = e;
                                bVar.error("cacheLoop error.", objArr);
                            }
                        } else if (value2.g() >= value2.h()) {
                            if (jCurrentTimeMillis - value2.g() > 800) {
                                this.f22401d.d(value2.c(), value2.e(), value2.m());
                                value2.x(jCurrentTimeMillis);
                                value2.w(jCurrentTimeMillis);
                                value2.a();
                            }
                        } else if (jCurrentTimeMillis - value2.h() > this.f22405h) {
                            this.f22401d.d(value2.c(), value2.e(), value2.m());
                            value2.x(jCurrentTimeMillis);
                            value2.w(jCurrentTimeMillis);
                            value2.a();
                        }
                    }
                }
                Thread.sleep(10L);
            } catch (Exception e11) {
                e = e11;
                c10 = 0;
            }
        }
        this.f22451k.countDown();
        f22449u.a("[BK][{}]cacheLoop stopped.", this.f22404g);
    }

    public static Integer t(String str) {
        int iIndexOf = str.indexOf(LocationInfo.NA);
        if (iIndexOf > 0) {
            str = str.substring(0, iIndexOf);
        }
        String strB = yb.d.b(str);
        try {
            String[] strArrSplit = strB.split("_");
            if (strArrSplit.length > 1) {
                return Integer.valueOf(Integer.parseInt(strArrSplit[strArrSplit.length - 1]));
            }
        } catch (Exception unused) {
            f22449u.warn("[BK]Error in parse trackChuckSeq. [{}]", strB);
        }
        return -1;
    }

    private void v() throws Throwable {
        k kVar = this.f22399b;
        if (kVar == null || !kVar.q()) {
            return;
        }
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(this.f22399b.f());
                try {
                    for (String str : i7.a.a(byteArrayInputStream2)) {
                        linkedHashMap.put(t(str), str);
                    }
                    this.f22452l = linkedHashMap;
                    yb.e.b(byteArrayInputStream2);
                } catch (Exception e10) {
                    e = e10;
                    byteArrayInputStream = byteArrayInputStream2;
                    f22449u.error("[BK]Parser index error.", e);
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
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        while (!this.f22403f) {
            try {
                if (this.f22457q != null) {
                    for (k kVar : this.f22454n.values()) {
                        if (!kVar.s() && !kVar.r()) {
                            w(kVar);
                            break;
                        }
                    }
                }
                Thread.sleep(10L);
            } catch (Exception e10) {
                f22449u.error("push loop error.", e10);
            }
        }
        this.f22451k.countDown();
        f22449u.a("[BK][{}]push loop stopped.", this.f22404g);
    }

    private void y() {
        if (this.f22454n.isEmpty()) {
            if (this.f22457q == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f22452l.entrySet());
            r(this.f22455o, (String) ((Map.Entry) arrayList.get(arrayList.size() >= 2 ? arrayList.size() - 2 : arrayList.size() - 1)).getValue());
            return;
        }
        int iA = this.f22398a.a();
        Iterator<k> it = this.f22454n.values().iterator();
        boolean z10 = false;
        int i10 = 0;
        while (it.hasNext()) {
            if (!it.next().q()) {
                i10++;
            }
        }
        if (i10 >= iA) {
            return;
        }
        Iterator<Map.Entry<Integer, String>> it2 = this.f22452l.entrySet().iterator();
        while (it2.hasNext()) {
            if (it2.next().getValue().equals(this.f22450j)) {
                z10 = true;
                break;
            }
        }
        if (it2.hasNext()) {
            while (it2.hasNext()) {
                String value = it2.next().getValue();
                if (i10 >= iA) {
                    return;
                }
                if (!this.f22453m.containsKey(value) && this.f22454n.get(value) == null) {
                    r(this.f22455o, value);
                    i10++;
                }
            }
            return;
        }
        if (this.f22457q == null || z10) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(this.f22452l.entrySet());
        String str = (String) ((Map.Entry) arrayList2.get(arrayList2.size() >= 2 ? arrayList2.size() - 2 : arrayList2.size() - 1)).getValue();
        if (this.f22453m.containsKey(str)) {
            return;
        }
        r(this.f22455o, str);
    }

    @Override // y6.a
    public void a(int i10, int i11, String str, int i12, int i13, byte[] bArr, boolean z10) {
        if (i10 != this.f22455o) {
            return;
        }
        k kVar = this.f22454n.get(str);
        if (kVar == null) {
            if (this.f22399b == null) {
                this.f22454n.putIfAbsent(str, new k(v6.b.BLOCK, i10, this.f22404g, i11, str));
                kVar = this.f22454n.get(str);
            } else {
                String str2 = this.f22452l.get(Integer.valueOf(i11));
                if (this.f22453m.containsKey(str)) {
                    return;
                }
                if (str2 == null || !str2.equals(str)) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.f22460t > 3000) {
                        f22449u.error("[BK][{}]Unknown blocks[{}]", this.f22404g, Integer.valueOf(i11));
                        this.f22460t = jCurrentTimeMillis;
                        return;
                    }
                    return;
                }
                this.f22454n.putIfAbsent(str, new k(v6.b.BLOCK, i10, this.f22404g, i11, str));
                kVar = this.f22454n.get(str);
            }
        }
        k kVar2 = kVar;
        synchronized (this.f22459s) {
            try {
                if (kVar2.o() == null) {
                    kVar2.B(i13);
                    kVar2.A(new BitSet(i13));
                    kVar2.z(new BitSet(i13));
                    kVar2.v(new byte[i13 * 1128]);
                }
                if (kVar2.q()) {
                    return;
                }
                kVar2.b(i12, bArr, z10, this.f22406i, this.f22405h);
                if (kVar2.q()) {
                    this.f22402e.a(kVar2.n());
                    this.f22402e.f22409b.getAndIncrement();
                    this.f22401d.c(this.f22402e, kVar2.j(), kVar2.c(), kVar2.d(), kVar2.l(), kVar2.n(), kVar2.h() - kVar2.k());
                    y();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y6.a
    public void b(int i10, String str, byte[] bArr) {
        if (i10 != this.f22455o) {
            return;
        }
        k kVar = this.f22454n.get(str);
        if (kVar == null || !kVar.q()) {
            k kVar2 = new k(v6.b.BLOCK, i10, this.f22404g, t(str).intValue(), str, bArr);
            this.f22454n.put(str, kVar2);
            this.f22402e.f22409b.getAndIncrement();
            this.f22401d.c(this.f22402e, kVar2.j(), kVar2.c(), kVar2.d(), kVar2.l(), kVar2.n(), kVar2.h() - kVar2.k());
            y();
        }
    }

    @Override // y6.a
    public void c(int i10, int i11, String str, int i12, int i13, byte[] bArr, boolean z10) throws Throwable {
        String str2;
        int i14;
        int i15;
        int i16;
        if (this.f22399b == null) {
            str2 = str;
            i14 = i13;
            i15 = i10;
            i16 = i11;
            this.f22399b = new k(v6.b.INDEX, i10, this.f22404g, i11, str2, i14);
        } else {
            str2 = str;
            i14 = i13;
            i15 = i10;
            i16 = i11;
        }
        if (this.f22399b.c() != i16) {
            k kVar = new k(v6.b.INDEX, i15, this.f22404g, i16, str2, i14);
            this.f22399b = kVar;
            kVar.b(i12, bArr, z10, this.f22406i, this.f22405h);
        } else if (this.f22399b.q()) {
            return;
        } else {
            this.f22399b.b(i12, bArr, z10, this.f22406i, this.f22405h);
        }
        if (this.f22399b.q()) {
            this.f22401d.a(this.f22399b.c(), this.f22399b.e(), this.f22399b.f());
            this.f22402e.f22408a.getAndIncrement();
            v();
            y();
        }
    }

    @Override // y6.a
    public void d(int i10, int i11, String str, byte[] bArr) throws Throwable {
        k kVar = new k(v6.b.INDEX, i10, this.f22404g, t(str).intValue(), str, bArr);
        this.f22399b = kVar;
        this.f22401d.a(kVar.c(), this.f22399b.e(), this.f22399b.f());
        v();
        y();
    }

    @Override // y6.a
    public byte[] g(int i10, String str, boolean z10) throws b7.a {
        if (i10 != this.f22455o) {
            throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
        }
        if (this.f22453m.containsKey(str)) {
            throw new b7.a(2001, "Expired Block.");
        }
        k kVar = this.f22454n.get(str);
        if (kVar == null) {
            if (z10) {
                r(i10, str);
            }
            return null;
        }
        if (!kVar.q()) {
            return null;
        }
        kVar.y(true);
        return kVar.f();
    }

    @Override // y6.a
    public byte[] h(int i10) throws b7.a {
        if (i10 != this.f22455o) {
            throw new b7.a(PointerIconCompat.TYPE_CONTEXT_MENU, "Error media id,not matched.");
        }
        k kVar = this.f22399b;
        if (kVar == null) {
            u();
            return null;
        }
        if (kVar.q()) {
            return this.f22399b.f();
        }
        u();
        return null;
    }

    @Override // y6.a
    public InputStream k() {
        PipedInputStream pipedInputStream = this.f22456p;
        if (pipedInputStream == null) {
            this.f22456p = new PipedInputStream(10485760);
            this.f22457q = new PipedOutputStream(this.f22456p);
        } else if (pipedInputStream.available() == 0) {
            yb.e.b(this.f22456p);
            yb.e.c(this.f22457q);
            this.f22456p = new PipedInputStream(10485760);
            this.f22457q = new PipedOutputStream(this.f22456p);
            f22449u.warn("create new pipedInputStream[{}], pipedOutputStream[{}]", this.f22404g, Integer.valueOf(this.f22456p.hashCode()), Integer.valueOf(this.f22457q.hashCode()));
        }
        return this.f22456p;
    }

    @Override // y6.a
    public void m(String str, int i10) {
        this.f22404g = str;
        this.f22455o = i10;
        this.f22403f = false;
        this.f22400c = -1L;
        this.f22458r = 0L;
        PipedInputStream pipedInputStream = this.f22456p;
        if (pipedInputStream != null) {
            yb.e.b(pipedInputStream);
            this.f22456p = null;
        }
        PipedOutputStream pipedOutputStream = this.f22457q;
        if (pipedOutputStream != null) {
            yb.e.c(pipedOutputStream);
            this.f22457q = null;
        }
        new Thread(new Runnable() { // from class: y6.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f22447a.s();
            }
        }, "cache-loop").start();
        new Thread(new Runnable() { // from class: y6.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f22448a.x();
            }
        }, "push-loop").start();
        this.f22451k = new CountDownLatch(2);
    }

    @Override // y6.a
    public void o() {
        this.f22450j = "";
        this.f22455o = 0;
        this.f22399b = null;
        this.f22454n.clear();
        this.f22452l.clear();
        this.f22453m.clear();
        this.f22403f = true;
        try {
            this.f22451k.await(this.f22458r, TimeUnit.MILLISECONDS);
            yb.e.b(this.f22456p);
            yb.e.c(this.f22457q);
            this.f22457q = null;
            this.f22456p = null;
        } catch (InterruptedException e10) {
            f22449u.error("stop play[{}] error.", this.f22404g, e10);
        }
    }

    public o(a7.a aVar, c cVar) {
        this.f22398a = aVar;
        this.f22401d = cVar;
        this.f22402e = new b();
    }

    private void w(k kVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f22457q != null) {
            if (this.f22398a.b() == v6.d.TS) {
                kVar.t(this.f22457q);
            } else if (this.f22398a.b() == v6.d.UDP) {
                kVar.u(this.f22457q);
            } else if (this.f22398a.b() == v6.d.GOP) {
                kVar.t(this.f22457q);
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (jCurrentTimeMillis2 > 100) {
                f22449u.warn("[BK][{}]write block[{}] to pipedOutputStream slow, cost[{}]ms", this.f22404g, kVar.e(), Long.valueOf(jCurrentTimeMillis2));
            }
            if (jCurrentTimeMillis2 > this.f22458r) {
                this.f22458r = jCurrentTimeMillis2;
            }
        }
    }

    @Override // y6.a
    public void n() {
        o();
    }

    public void u() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f22400c >= this.f22405h) {
            k kVar = this.f22399b;
            if (kVar == null) {
                this.f22401d.e(null);
            } else {
                if (kVar.q()) {
                    return;
                }
                if (jCurrentTimeMillis - this.f22399b.h() > this.f22405h) {
                    this.f22401d.e(this.f22399b.m());
                }
                this.f22400c = jCurrentTimeMillis;
            }
        }
    }

    @Override // y6.a
    public void f(int i10, String str, byte[] bArr) {
    }

    @Override // y6.a
    public void e(int i10, String str, int i11, int i12, byte[] bArr) {
    }
}
