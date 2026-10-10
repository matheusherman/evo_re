package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f14049b = {c0.g(new w(c0.b(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ka.i f14050a;

    public a(ka.n storageManager, c9.a<? extends List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> compute) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(compute, "compute");
        this.f14050a = storageManager.c(compute);
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> e() {
        return (List) ka.m.a(this.f14050a, this, f14049b[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean F(ba.c cVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.b.b(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return e().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        return e().iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c j(ba.c cVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.b.a(this, cVar);
    }
}
