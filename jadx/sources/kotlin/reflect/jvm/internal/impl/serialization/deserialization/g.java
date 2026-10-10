package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y9.c f14136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w9.c f14137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y9.a f14138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a1 f14139d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.m.a(this.f14136a, gVar.f14136a) && kotlin.jvm.internal.m.a(this.f14137b, gVar.f14137b) && kotlin.jvm.internal.m.a(this.f14138c, gVar.f14138c) && kotlin.jvm.internal.m.a(this.f14139d, gVar.f14139d);
    }

    public g(y9.c nameResolver, w9.c classProto, y9.a metadataVersion, a1 sourceElement) {
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(classProto, "classProto");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.m.f(sourceElement, "sourceElement");
        this.f14136a = nameResolver;
        this.f14137b = classProto;
        this.f14138c = metadataVersion;
        this.f14139d = sourceElement;
    }

    public final y9.c a() {
        return this.f14136a;
    }

    public final w9.c b() {
        return this.f14137b;
    }

    public final y9.a c() {
        return this.f14138c;
    }

    public final a1 d() {
        return this.f14139d;
    }

    public int hashCode() {
        return (((((this.f14136a.hashCode() * 31) + this.f14137b.hashCode()) * 31) + this.f14138c.hashCode()) * 31) + this.f14139d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.f14136a + ", classProto=" + this.f14137b + ", metadataVersion=" + this.f14138c + ", sourceElement=" + this.f14139d + ')';
    }
}
