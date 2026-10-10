package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f13589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f13590b;

    public j(q kotlinClassFinder, i deserializedDescriptorResolver) {
        kotlin.jvm.internal.m.f(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.m.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.f13589a = kotlinClassFinder;
        this.f13590b = deserializedDescriptorResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.h
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.g a(ba.b classId) {
        kotlin.jvm.internal.m.f(classId, "classId");
        s sVarA = r.a(this.f13589a, classId, sa.c.a(this.f13590b.d().g()));
        if (sVarA == null) {
            return null;
        }
        kotlin.jvm.internal.m.a(sVarA.e(), classId);
        return this.f13590b.j(sVarA);
    }
}
