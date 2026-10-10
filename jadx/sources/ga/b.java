package ga;

import ka.n;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterable<Object> f10557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ka.b<e, o0> f10558b;

    public b(n storageManager, Iterable<? extends Object> samWithReceiverResolvers) {
        m.f(storageManager, "storageManager");
        m.f(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.f10557a = samWithReceiverResolvers;
        this.f10558b = storageManager.b();
    }
}
