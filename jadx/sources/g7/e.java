package g7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10538a = 20;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, List<Integer>> f10539b = new z6.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10540c = -1;

    public void a(int i10, int i11) {
        if (!this.f10539b.containsKey(Integer.valueOf(i10))) {
            this.f10539b.put(Integer.valueOf(i10), new ArrayList());
        }
        List<Integer> list = this.f10539b.get(Integer.valueOf(i10));
        list.add(Integer.valueOf(i11));
        if (list.size() > this.f10538a) {
            Iterator<Integer> it = list.iterator();
            if (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    public int b(int i10) {
        List<Integer> list;
        List<Integer> list2;
        List<Integer> list3 = this.f10539b.get(Integer.valueOf(i10));
        if (list3 != null && !list3.isEmpty() && list3.size() >= this.f10538a) {
            int iD = d(i10);
            int i11 = i10 - 8;
            if (iD <= 30) {
                if (i11 < 16 || (list2 = this.f10539b.get(Integer.valueOf(i11))) == null || list2.isEmpty() || list2.size() < this.f10538a || iD - d(i11) <= 5) {
                    int i12 = i10 + 8;
                    if (i12 <= 64 && ((list = this.f10539b.get(Integer.valueOf(i12))) == null || list.isEmpty() || list.size() < this.f10538a)) {
                        return i12;
                    }
                }
                return i11;
            }
            if (i11 >= 16) {
                return i11;
            }
        }
        return i10;
    }

    public long c() {
        return this.f10540c;
    }

    public int d(int i10) {
        List<Integer> list = this.f10539b.get(Integer.valueOf(i10));
        if (list == null || list.isEmpty()) {
            return -1;
        }
        Iterator<Integer> it = list.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue / list.size();
    }

    public void e(long j10) {
        this.f10540c = j10;
    }
}
