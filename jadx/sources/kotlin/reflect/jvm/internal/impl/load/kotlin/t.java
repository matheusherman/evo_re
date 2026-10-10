package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class t implements a1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h f13615b;

    public t(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h packageFragment) {
        kotlin.jvm.internal.m.f(packageFragment, "packageFragment");
        this.f13615b = packageFragment;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public b1 a() {
        b1 NO_SOURCE_FILE = b1.f12738a;
        kotlin.jvm.internal.m.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public String toString() {
        return this.f13615b + ": " + this.f13615b.J0().keySet();
    }
}
