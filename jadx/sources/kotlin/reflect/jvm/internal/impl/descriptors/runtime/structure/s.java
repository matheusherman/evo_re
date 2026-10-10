package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class s extends f implements u9.o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f13053c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(ba.f fVar, Object value) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(value, "value");
        this.f13053c = value;
    }

    @Override // u9.o
    public Object getValue() {
        return this.f13053c;
    }
}
