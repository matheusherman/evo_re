package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m extends f implements u9.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<?> f13047c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ba.f fVar, Class<?> klass) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(klass, "klass");
        this.f13047c = klass;
    }

    @Override // u9.h
    public u9.x c() {
        return z.f13060a.a(this.f13047c);
    }
}
