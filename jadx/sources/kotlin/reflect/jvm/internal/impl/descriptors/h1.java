package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import na.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class h1<Type extends na.k> {
    public /* synthetic */ h1(kotlin.jvm.internal.g gVar) {
        this();
    }

    public abstract List<r8.p<ba.f, Type>> a();

    private h1() {
    }

    public final <Other extends na.k> h1<Other> b(c9.l<? super Type, ? extends Other> transform) {
        kotlin.jvm.internal.m.f(transform, "transform");
        if (this instanceof z) {
            z zVar = (z) this;
            return new z(zVar.c(), transform.invoke(zVar.d()));
        }
        if (!(this instanceof i0)) {
            throw new r8.n();
        }
        List<r8.p<ba.f, Type>> listA = a();
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            r8.p pVar = (r8.p) it.next();
            arrayList.add(r8.v.a((ba.f) pVar.a(), transform.invoke((na.k) pVar.b())));
        }
        return new i0(arrayList);
    }
}
