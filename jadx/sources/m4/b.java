package m4;

import android.graphics.Bitmap;
import h3.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected h3.q f15619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected q f15620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15621c = 2;

    public static List<s> e(List<s> list, q qVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<s> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(qVar.f(it.next()));
        }
        return arrayList;
    }

    public h3.a a() {
        return this.f15619a.b();
    }

    public Bitmap b() {
        return this.f15620b.b(null, 2);
    }

    public byte[] c() {
        return this.f15619a.c();
    }

    public Map<h3.r, Object> d() {
        return this.f15619a.d();
    }

    public String toString() {
        return this.f15619a.f();
    }

    public b(h3.q qVar, q qVar2) {
        this.f15619a = qVar;
        this.f15620b = qVar2;
    }
}
