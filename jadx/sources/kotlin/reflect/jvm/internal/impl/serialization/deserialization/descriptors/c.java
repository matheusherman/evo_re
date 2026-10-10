package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c extends kotlin.reflect.jvm.internal.impl.descriptors.impl.f implements b {
    private final w9.d F;
    private final y9.c G;
    private final y9.g H;
    private final y9.h I;
    private final f J;

    public /* synthetic */ c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, w9.d dVar, y9.c cVar, y9.g gVar2, y9.h hVar, f fVar, a1 a1Var, int i10, kotlin.jvm.internal.g gVar3) {
        this(eVar, lVar, gVar, z10, aVar, dVar, cVar, gVar2, hVar, fVar, (i10 & 1024) != 0 ? null : a1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean L() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(kotlin.reflect.jvm.internal.impl.descriptors.e containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, w9.d proto, y9.c nameResolver, y9.g typeTable, y9.h versionRequirementTable, f fVar, a1 a1Var) {
        super(containingDeclaration, lVar, annotations, z10, kind, a1Var == null ? a1.f12668a : a1Var);
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(versionRequirementTable, "versionRequirementTable");
        this.F = proto;
        this.G = nameResolver;
        this.H = typeTable;
        this.I = versionRequirementTable;
        this.J = fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public y9.g O() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public y9.c V() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public f Y() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.f
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public c H0(kotlin.reflect.jvm.internal.impl.descriptors.m newOwner, y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, a1 source) {
        kotlin.jvm.internal.m.f(newOwner, "newOwner");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(source, "source");
        c cVar = new c((kotlin.reflect.jvm.internal.impl.descriptors.e) newOwner, (kotlin.reflect.jvm.internal.impl.descriptors.l) yVar, annotations, this.E, kind, y(), V(), O(), q1(), Y(), source);
        cVar.U0(M0());
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public w9.d y() {
        return this.F;
    }

    public y9.h q1() {
        return this.I;
    }
}
