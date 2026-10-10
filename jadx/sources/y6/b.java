package y6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final q6.b f22407h = q6.c.d(b.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22411d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicInteger f22408a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicInteger f22409b = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicInteger f22410c = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22412e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<Integer> f22413f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f22414g = -1;

    public void a(int i10) {
        this.f22413f.add(Integer.valueOf(i10));
        int iIntValue = 0;
        if (this.f22413f.size() > 20) {
            this.f22413f.remove(0);
        }
        Iterator<Integer> it = this.f22413f.iterator();
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        this.f22411d = iIntValue / this.f22413f.size();
    }

    public int b() {
        return this.f22411d;
    }
}
