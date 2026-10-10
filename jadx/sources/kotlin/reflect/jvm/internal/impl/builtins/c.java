package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12458a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<ba.b> f12459b;

    static {
        Set<i> set = i.f12478b;
        ArrayList arrayList = new ArrayList(r.w(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(k.c((i) it.next()));
        }
        ba.c cVarL = k.a.f12612h.l();
        kotlin.jvm.internal.m.e(cVarL, "string.toSafe()");
        List listC0 = r.C0(arrayList, cVarL);
        ba.c cVarL2 = k.a.f12616j.l();
        kotlin.jvm.internal.m.e(cVarL2, "_boolean.toSafe()");
        List listC1 = r.C0(listC0, cVarL2);
        ba.c cVarL3 = k.a.f12634s.l();
        kotlin.jvm.internal.m.e(cVarL3, "_enum.toSafe()");
        List listC2 = r.C0(listC1, cVarL3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = listC2.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(ba.b.m((ba.c) it2.next()));
        }
        f12459b = linkedHashSet;
    }

    public final Set<ba.b> a() {
        return f12459b;
    }

    public final Set<ba.b> b() {
        return f12459b;
    }

    private c() {
    }
}
