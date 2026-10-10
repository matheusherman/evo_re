package g7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static q6.b f10501o = q6.c.d(a.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10504c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10506e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10505d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<Long> f10507f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicInteger f10508g = new AtomicInteger(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicInteger f10509h = new AtomicInteger(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicInteger f10510i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AtomicInteger f10511j = new AtomicInteger(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AtomicInteger f10512k = new AtomicInteger(0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AtomicInteger f10513l = new AtomicInteger(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AtomicInteger f10514m = new AtomicInteger(0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AtomicInteger f10515n = new AtomicInteger(0);

    public void a(long j10) {
        this.f10507f.add(Long.valueOf(j10));
        if (this.f10507f.size() > 20) {
            this.f10507f.remove(0);
        }
        Iterator<Long> it = this.f10507f.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        this.f10506e = jLongValue / ((long) this.f10507f.size());
    }

    public void b(b bVar, boolean z10, long j10) {
        if (j10 - this.f10505d >= 10000) {
            bVar.c(this.f10504c, String.format("[PR][{%s}][{%s}-{%s}]Connected:[{%d}],IDX [req:{%d},resp:{%d}],BK [req:{%d},resp:{%d}], SUB [req:{%d},resp:{%d}], HB:[req:{%d},resp:{%d}],rtt:[{%d}]", this.f10504c, this.f10502a, this.f10503b, Integer.valueOf(z10 ? 1 : 0), Integer.valueOf(this.f10508g.getAndSet(0)), Integer.valueOf(this.f10509h.getAndSet(0)), Integer.valueOf(this.f10510i.getAndSet(0)), Integer.valueOf(this.f10511j.getAndSet(0)), Integer.valueOf(this.f10512k.getAndSet(0)), Integer.valueOf(this.f10513l.getAndSet(0)), Integer.valueOf(this.f10514m.getAndSet(0)), Integer.valueOf(this.f10515n.getAndSet(0)), Long.valueOf(this.f10506e)));
            this.f10505d = j10;
        }
    }

    public long c() {
        return this.f10506e;
    }

    public a(String str, String str2, String str3) {
        this.f10502a = str;
        this.f10503b = str2;
        this.f10504c = str3;
    }
}
