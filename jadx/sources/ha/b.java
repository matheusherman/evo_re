package ha;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f10902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ba.f f10903d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor, g0 receiverType, ba.f fVar, g gVar) {
        super(receiverType, gVar);
        m.f(classDescriptor, "classDescriptor");
        m.f(receiverType, "receiverType");
        this.f10902c = classDescriptor;
        this.f10903d = fVar;
    }

    @Override // ha.f
    public ba.f a() {
        return this.f10903d;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.f10902c + " }";
    }
}
