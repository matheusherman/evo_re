package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l {
    public static final h1 a(kotlin.reflect.jvm.internal.impl.descriptors.e from, kotlin.reflect.jvm.internal.impl.descriptors.e to) {
        m.f(from, "from");
        m.f(to, "to");
        from.r().size();
        to.r().size();
        h1.a aVar = h1.f14318c;
        List<f1> listR = from.r();
        m.e(listR, "from.declaredTypeParameters");
        List<f1> list = listR;
        ArrayList arrayList = new ArrayList(r.w(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((f1) it.next()).h());
        }
        List<f1> listR2 = to.r();
        m.e(listR2, "to.declaredTypeParameters");
        List<f1> list2 = listR2;
        ArrayList arrayList2 = new ArrayList(r.w(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            o0 o0VarP = ((f1) it2.next()).p();
            m.e(o0VarP, "it.defaultType");
            arrayList2.add(oa.a.a(o0VarP));
        }
        return h1.a.e(aVar, n0.q(r.W0(arrayList, arrayList2)), false, 2, null);
    }
}
