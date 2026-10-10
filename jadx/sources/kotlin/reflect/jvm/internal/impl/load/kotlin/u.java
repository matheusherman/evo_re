package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.b1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class u implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f13616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.s<aa.e> f13617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e f13619e;

    public u(s binaryClass, kotlin.reflect.jvm.internal.impl.serialization.deserialization.s<aa.e> sVar, boolean z10, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e abiStability) {
        kotlin.jvm.internal.m.f(binaryClass, "binaryClass");
        kotlin.jvm.internal.m.f(abiStability, "abiStability");
        this.f13616b = binaryClass;
        this.f13617c = sVar;
        this.f13618d = z10;
        this.f13619e = abiStability;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public b1 a() {
        b1 NO_SOURCE_FILE = b1.f12738a;
        kotlin.jvm.internal.m.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f
    public String c() {
        return "Class '" + this.f13616b.e().b().b() + '\'';
    }

    public final s d() {
        return this.f13616b;
    }

    public String toString() {
        return u.class.getSimpleName() + ": " + this.f13616b;
    }
}
