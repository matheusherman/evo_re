package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.p;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k extends g0 implements b {
    private final w9.i E;
    private final y9.c F;
    private final y9.g G;
    private final y9.h H;
    private final f I;

    public /* synthetic */ k(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, z0 z0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, w9.i iVar, y9.c cVar, y9.g gVar2, y9.h hVar, f fVar2, a1 a1Var, int i10, kotlin.jvm.internal.g gVar3) {
        this(mVar, z0Var, gVar, fVar, aVar, iVar, cVar, gVar2, hVar, fVar2, (i10 & 1024) != 0 ? null : a1Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration, z0 z0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, ba.f name, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, w9.i proto, y9.c nameResolver, y9.g typeTable, y9.h versionRequirementTable, f fVar, a1 a1Var) {
        super(containingDeclaration, z0Var, annotations, name, kind, a1Var == null ? a1.f12668a : a1Var);
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(versionRequirementTable, "versionRequirementTable");
        this.E = proto;
        this.F = nameResolver;
        this.G = typeTable;
        this.H = versionRequirementTable;
        this.I = fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g0, kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    protected p H0(kotlin.reflect.jvm.internal.impl.descriptors.m newOwner, y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, a1 source) {
        ba.f fVar2;
        kotlin.jvm.internal.m.f(newOwner, "newOwner");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(source, "source");
        z0 z0Var = (z0) yVar;
        if (fVar == null) {
            ba.f name = getName();
            kotlin.jvm.internal.m.e(name, "name");
            fVar2 = name;
        } else {
            fVar2 = fVar;
        }
        k kVar = new k(newOwner, z0Var, annotations, fVar2, kind, y(), V(), O(), m1(), Y(), source);
        kVar.U0(M0());
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public y9.g O() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public y9.c V() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public f Y() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public w9.i y() {
        return this.E;
    }

    public y9.h m1() {
        return this.H;
    }
}
