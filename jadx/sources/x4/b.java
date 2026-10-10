package x4;

import androidx.core.util.Pair;
import i5.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<i5.h> f21808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Pair<List<p>, Boolean>> f21809b;

    public i5.h a(int i10) {
        return this.f21808a.get(i10);
    }

    public int b() {
        return this.f21808a.size();
    }

    public List<i5.h> c() {
        return this.f21808a;
    }

    public p d(int i10, int i11) {
        List<p> list;
        if (this.f21809b.size() <= i10 || i11 < 0 || (list = this.f21809b.get(i10).first) == null || list.isEmpty()) {
            return null;
        }
        return list.size() > i11 ? list.get(i11) : list.get(list.size() - 1);
    }

    public Pair<List<p>, Boolean> e(int i10) {
        if (this.f21809b.size() > i10) {
            return this.f21809b.get(i10);
        }
        return null;
    }

    public List<Pair<List<p>, Boolean>> f() {
        return this.f21809b;
    }

    public int g(int i10) {
        Pair<List<p>, Boolean> pair = this.f21809b.size() > i10 ? this.f21809b.get(i10) : null;
        if (pair == null) {
            return 0;
        }
        return pair.first.size();
    }

    public boolean h() {
        return !this.f21808a.isEmpty();
    }

    public void i(int i10) {
        this.f21809b.set(i10, new Pair<>(new ArrayList(), Boolean.FALSE));
    }
}
