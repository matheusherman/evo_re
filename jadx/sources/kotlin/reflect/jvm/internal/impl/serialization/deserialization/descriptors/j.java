package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j extends c0 implements b {
    private final w9.n C;
    private final y9.c D;
    private final y9.g E;
    private final y9.h F;
    private final f G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, e0 modality, u visibility, boolean z10, ba.f name, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, w9.n proto, y9.c nameResolver, y9.g typeTable, y9.h versionRequirementTable, f fVar) {
        super(containingDeclaration, u0Var, annotations, modality, visibility, z10, name, kind, a1.f12668a, z11, z12, z15, false, z13, z14);
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(modality, "modality");
        kotlin.jvm.internal.m.f(visibility, "visibility");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(versionRequirementTable, "versionRequirementTable");
        this.C = proto;
        this.D = nameResolver;
        this.E = typeTable;
        this.F = versionRequirementTable;
        this.G = fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0
    protected c0 L0(kotlin.reflect.jvm.internal.impl.descriptors.m newOwner, e0 newModality, u newVisibility, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, ba.f newName, a1 source) {
        kotlin.jvm.internal.m.f(newOwner, "newOwner");
        kotlin.jvm.internal.m.f(newModality, "newModality");
        kotlin.jvm.internal.m.f(newVisibility, "newVisibility");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(newName, "newName");
        kotlin.jvm.internal.m.f(source, "source");
        return new j(newOwner, u0Var, getAnnotations(), newModality, newVisibility, f0(), newName, kind, o0(), isConst(), isExternal(), K(), I(), y(), V(), O(), c1(), Y());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public y9.g O() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public y9.c V() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public f Y() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public w9.n y() {
        return this.C;
    }

    public y9.h c1() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        Boolean boolD = y9.b.D.d(y().a0());
        kotlin.jvm.internal.m.e(boolD, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return boolD.booleanValue();
    }
}
