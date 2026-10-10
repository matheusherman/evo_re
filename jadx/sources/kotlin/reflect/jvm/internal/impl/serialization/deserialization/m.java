package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f14171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y9.c f14172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.m f14173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y9.g f14174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y9.h f14175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y9.a f14176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f f14177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c0 f14178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final v f14179i;

    public m(k components, y9.c nameResolver, kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration, y9.g typeTable, y9.h versionRequirementTable, y9.a metadataVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar, c0 c0Var, List<w9.s> typeParameters) {
        String strC;
        kotlin.jvm.internal.m.f(components, "components");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.m.f(typeParameters, "typeParameters");
        this.f14171a = components;
        this.f14172b = nameResolver;
        this.f14173c = containingDeclaration;
        this.f14174d = typeTable;
        this.f14175e = versionRequirementTable;
        this.f14176f = metadataVersion;
        this.f14177g = fVar;
        this.f14178h = new c0(this, c0Var, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + '\"', (fVar == null || (strC = fVar.c()) == null) ? "[container not found]" : strC);
        this.f14179i = new v(this);
    }

    public static /* synthetic */ m b(m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2, List list, y9.c cVar, y9.g gVar, y9.h hVar, y9.a aVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cVar = mVar.f14172b;
        }
        y9.c cVar2 = cVar;
        if ((i10 & 8) != 0) {
            gVar = mVar.f14174d;
        }
        y9.g gVar2 = gVar;
        if ((i10 & 16) != 0) {
            hVar = mVar.f14175e;
        }
        y9.h hVar2 = hVar;
        if ((i10 & 32) != 0) {
            aVar = mVar.f14176f;
        }
        return mVar.a(mVar2, list, cVar2, gVar2, hVar2, aVar);
    }

    public final m a(kotlin.reflect.jvm.internal.impl.descriptors.m descriptor, List<w9.s> typeParameterProtos, y9.c nameResolver, y9.g typeTable, y9.h versionRequirementTable, y9.a metadataVersion) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.jvm.internal.m.f(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        return new m(this.f14171a, nameResolver, descriptor, typeTable, y9.i.b(metadataVersion) ? versionRequirementTable : this.f14175e, metadataVersion, this.f14177g, this.f14178h, typeParameterProtos);
    }

    public final k c() {
        return this.f14171a;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f d() {
        return this.f14177g;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.m e() {
        return this.f14173c;
    }

    public final v f() {
        return this.f14179i;
    }

    public final y9.c g() {
        return this.f14172b;
    }

    public final ka.n h() {
        return this.f14171a.u();
    }

    public final c0 i() {
        return this.f14178h;
    }

    public final y9.g j() {
        return this.f14174d;
    }

    public final y9.h k() {
        return this.f14175e;
    }
}
