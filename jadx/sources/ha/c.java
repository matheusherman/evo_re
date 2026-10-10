package ha;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c extends a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f10904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ba.f f10905d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(kotlin.reflect.jvm.internal.impl.descriptors.a declarationDescriptor, g0 receiverType, ba.f fVar, g gVar) {
        super(receiverType, gVar);
        m.f(declarationDescriptor, "declarationDescriptor");
        m.f(receiverType, "receiverType");
        this.f10904c = declarationDescriptor;
        this.f10905d = fVar;
    }

    @Override // ha.f
    public ba.f a() {
        return this.f10905d;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.a d() {
        return this.f10904c;
    }

    public String toString() {
        return "Cxt { " + d() + " }";
    }
}
