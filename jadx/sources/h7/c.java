package h7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final q6.b f10874n = q6.c.d(c.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10876b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10878d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10877c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Long> f10879e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicInteger f10880f = new AtomicInteger(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicInteger f10881g = new AtomicInteger(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicInteger f10882h = new AtomicInteger(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicInteger f10883i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AtomicInteger f10884j = new AtomicInteger(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AtomicInteger f10885k = new AtomicInteger(0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AtomicInteger f10886l = new AtomicInteger(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AtomicInteger f10887m = new AtomicInteger(0);

    public void a(long j10) {
        this.f10879e.add(Long.valueOf(j10));
        if (this.f10879e.size() > 20) {
            this.f10879e.remove(0);
        }
        Iterator<Long> it = this.f10879e.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        this.f10878d = jLongValue / ((long) this.f10879e.size());
    }

    public void b(String str, boolean z10, long j10, d dVar) {
        if (j10 - this.f10877c >= 10000) {
            dVar.c(str, String.format("[TR][%s-%s]Con:[%d],AS[req:%d,resp:%d],AP[req:%d,resp:%d],An[req:%d,resp:%d],ex:[req:%d,resp:%d],rtt:[%d]", this.f10875a, this.f10876b, Integer.valueOf(z10 ? 1 : 0), Integer.valueOf(this.f10880f.getAndSet(0)), Integer.valueOf(this.f10882h.getAndSet(0)), Integer.valueOf(this.f10881g.getAndSet(0)), Integer.valueOf(this.f10883i.getAndSet(0)), Integer.valueOf(this.f10884j.getAndSet(0)), Integer.valueOf(this.f10885k.getAndSet(0)), Integer.valueOf(this.f10886l.getAndSet(0)), Integer.valueOf(this.f10887m.getAndSet(0)), Long.valueOf(this.f10878d)));
            this.f10877c = j10;
        }
    }

    public c(String str, String str2) {
        this.f10875a = str;
        this.f10876b = str2;
    }
}
