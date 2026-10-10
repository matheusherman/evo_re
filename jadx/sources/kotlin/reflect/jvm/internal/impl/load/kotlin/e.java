package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e {
    public static final d a(h0 module, k0 notFoundClasses, ka.n storageManager, q kotlinClassFinder, aa.e jvmMetadataVersion) {
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.m.f(jvmMetadataVersion, "jvmMetadataVersion");
        d dVar = new d(module, notFoundClasses, storageManager, kotlinClassFinder);
        dVar.N(jvmMetadataVersion);
        return dVar;
    }
}
