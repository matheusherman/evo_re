package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.o1;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import w9.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l extends kotlin.reflect.jvm.internal.impl.descriptors.impl.d implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ka.n f14119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r f14120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final y9.c f14121j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final y9.g f14122k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final y9.h f14123l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final f f14124m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Collection<? extends i0> f14125n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private o0 f14126o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private o0 f14127p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<? extends f1> f14128q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private o0 f14129r;

    /* JADX WARN: Illegal instructions before constructor call */
    public l(ka.n storageManager, kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, ba.f name, u visibility, r proto, y9.c nameResolver, y9.g typeTable, y9.h versionRequirementTable, f fVar) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(visibility, "visibility");
        kotlin.jvm.internal.m.f(proto, "proto");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(versionRequirementTable, "versionRequirementTable");
        a1 NO_SOURCE = a1.f12668a;
        kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
        super(containingDeclaration, annotations, name, NO_SOURCE, visibility);
        this.f14119h = storageManager;
        this.f14120i = proto;
        this.f14121j = nameResolver;
        this.f14122k = typeTable;
        this.f14123l = versionRequirementTable;
        this.f14124m = fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.d
    protected List<f1> I0() {
        List list = this.f14128q;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.m.v("typeConstructorParameters");
        return null;
    }

    public r K0() {
        return this.f14120i;
    }

    public y9.h L0() {
        return this.f14123l;
    }

    public final void M0(List<? extends f1> declaredTypeParameters, o0 underlyingType, o0 expandedType) {
        kotlin.jvm.internal.m.f(declaredTypeParameters, "declaredTypeParameters");
        kotlin.jvm.internal.m.f(underlyingType, "underlyingType");
        kotlin.jvm.internal.m.f(expandedType, "expandedType");
        J0(declaredTypeParameters);
        this.f14126o = underlyingType;
        this.f14127p = expandedType;
        this.f14128q = g1.d(this);
        this.f14129r = B0();
        this.f14125n = H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public e1 c(p1 substitutor) {
        kotlin.jvm.internal.m.f(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        ka.n nVarD0 = d0();
        kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration = b();
        kotlin.jvm.internal.m.e(containingDeclaration, "containingDeclaration");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = getAnnotations();
        kotlin.jvm.internal.m.e(annotations, "annotations");
        ba.f name = getName();
        kotlin.jvm.internal.m.e(name, "name");
        l lVar = new l(nVarD0, containingDeclaration, annotations, name, getVisibility(), K0(), V(), O(), L0(), Y());
        List<f1> listR = r();
        o0 o0VarC0 = c0();
        w1 w1Var = w1.INVARIANT;
        g0 g0VarN = substitutor.n(o0VarC0, w1Var);
        kotlin.jvm.internal.m.e(g0VarN, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        o0 o0VarA = o1.a(g0VarN);
        g0 g0VarN2 = substitutor.n(R(), w1Var);
        kotlin.jvm.internal.m.e(g0VarN2, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        lVar.M0(listR, o0VarA, o1.a(g0VarN2));
        return lVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public y9.g O() {
        return this.f14122k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public o0 R() {
        o0 o0Var = this.f14127p;
        if (o0Var != null) {
            return o0Var;
        }
        kotlin.jvm.internal.m.v("expandedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public y9.c V() {
        return this.f14121j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    public f Y() {
        return this.f14124m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public o0 c0() {
        o0 o0Var = this.f14126o;
        if (o0Var != null) {
            return o0Var;
        }
        kotlin.jvm.internal.m.v("underlyingType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.d
    protected ka.n d0() {
        return this.f14119h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public o0 p() {
        o0 o0Var = this.f14129r;
        if (o0Var != null) {
            return o0Var;
        }
        kotlin.jvm.internal.m.v("defaultTypeImpl");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public kotlin.reflect.jvm.internal.impl.descriptors.e o() {
        if (kotlin.reflect.jvm.internal.impl.types.i0.a(R())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = R().J0().d();
        if (!(hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
            return null;
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD;
    }
}
