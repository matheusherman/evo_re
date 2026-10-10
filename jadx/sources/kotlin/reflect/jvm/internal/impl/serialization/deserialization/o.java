package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class o extends kotlin.reflect.jvm.internal.impl.descriptors.impl.z {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ka.n f14181g;

    public abstract h B0();

    public abstract void H0(k kVar);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(ba.c fqName, ka.n storageManager, h0 module) {
        super(module, fqName);
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(module, "module");
        this.f14181g = storageManager;
    }

    public boolean G0(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = n();
        return (hVarN instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h) && ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h) hVarN).q().contains(name);
    }
}
