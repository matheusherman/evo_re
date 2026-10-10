package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class q extends f implements u9.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Enum<?> f13051c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(ba.f fVar, Enum<?> value) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(value, "value");
        this.f13051c = value;
    }

    @Override // u9.m
    public ba.b b() {
        Class<?> enumClass = this.f13051c.getClass();
        if (!enumClass.isEnum()) {
            enumClass = enumClass.getEnclosingClass();
        }
        kotlin.jvm.internal.m.e(enumClass, "enumClass");
        return d.a(enumClass);
    }

    @Override // u9.m
    public ba.f d() {
        return ba.f.l(this.f13051c.name());
    }
}
