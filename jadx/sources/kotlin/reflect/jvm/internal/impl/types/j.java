package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j extends a1<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f14323a;

    public j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
        kotlin.jvm.internal.m.f(annotations, "annotations");
        this.f14323a = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    public i9.d<? extends j> b() {
        return kotlin.jvm.internal.c0.b(j.class);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public j a(j jVar) {
        return jVar == null ? this : new j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.i.a(this.f14323a, jVar.f14323a));
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g e() {
        return this.f14323a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return kotlin.jvm.internal.m.a(((j) obj).f14323a, this.f14323a);
        }
        return false;
    }

    public int hashCode() {
        return this.f14323a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public j c(j jVar) {
        if (kotlin.jvm.internal.m.a(jVar, this)) {
            return this;
        }
        return null;
    }
}
