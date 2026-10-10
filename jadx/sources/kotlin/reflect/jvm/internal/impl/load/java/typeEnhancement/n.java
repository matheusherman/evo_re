package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.u1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class n extends a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.a f13470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.b f13473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f13474e;

    public /* synthetic */ n(kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z10, kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, kotlin.reflect.jvm.internal.impl.load.java.b bVar, boolean z11, int i10, kotlin.jvm.internal.g gVar2) {
        this(aVar, z10, gVar, bVar, (i10 & 16) != 0 ? false : z11);
    }

    public n(kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z10, kotlin.reflect.jvm.internal.impl.load.java.lazy.g containerContext, kotlin.reflect.jvm.internal.impl.load.java.b containerApplicabilityType, boolean z11) {
        kotlin.jvm.internal.m.f(containerContext, "containerContext");
        kotlin.jvm.internal.m.f(containerApplicabilityType, "containerApplicabilityType");
        this.f13470a = aVar;
        this.f13471b = z10;
        this.f13472c = containerContext;
        this.f13473d = containerApplicabilityType;
        this.f13474e = z11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public boolean A(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        return ((g0) iVar).M0() instanceof g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public boolean h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, na.i iVar) {
        kotlin.jvm.internal.m.f(cVar, "<this>");
        if ((cVar instanceof s9.g) && ((s9.g) cVar).g()) {
            return true;
        }
        if ((cVar instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e) && !p() && (((kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e) cVar).k() || m() == kotlin.reflect.jvm.internal.impl.load.java.b.TYPE_PARAMETER_BOUNDS)) {
            return true;
        }
        return iVar != null && kotlin.reflect.jvm.internal.impl.builtins.h.q0((g0) iVar) && i().m(cVar) && !this.f13472c.a().q().c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.load.java.d i() {
        return this.f13472c.a().a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public g0 q(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        return u1.a((g0) iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public na.r v() {
        return kotlin.reflect.jvm.internal.impl.types.checker.q.f14258a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> j(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        return ((g0) iVar).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> l() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar = this.f13470a;
        return (aVar == null || (annotations = aVar.getAnnotations()) == null) ? kotlin.collections.r.l() : annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public kotlin.reflect.jvm.internal.impl.load.java.b m() {
        return this.f13473d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public y n() {
        return this.f13472c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public boolean o() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar = this.f13470a;
        return (aVar instanceof j1) && ((j1) aVar).h0() != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public boolean p() {
        return this.f13472c.a().q().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public ba.d s(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarF = s1.f((g0) iVar);
        if (eVarF != null) {
            return kotlin.reflect.jvm.internal.impl.resolve.e.m(eVarF);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public boolean u() {
        return this.f13474e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public boolean w(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        return kotlin.reflect.jvm.internal.impl.builtins.h.e0((g0) iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public boolean x() {
        return this.f13471b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public boolean y(na.i iVar, na.i other) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        kotlin.jvm.internal.m.f(other, "other");
        return this.f13472c.a().k().b((g0) iVar, (g0) other);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a
    public boolean z(na.o oVar) {
        kotlin.jvm.internal.m.f(oVar, "<this>");
        return oVar instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n;
    }
}
