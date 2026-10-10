package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.v1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class d extends k implements e1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.u f12813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<? extends f1> f12814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f12815g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> {
        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarF = gVar.f(d.this);
            if (hVarF != null) {
                return hVarF.p();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<v1, Boolean> {
        b() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0027  */
        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(v1 type) {
            boolean z10;
            kotlin.jvm.internal.m.e(type, "type");
            if (kotlin.reflect.jvm.internal.impl.types.i0.a(type)) {
                z10 = false;
            } else {
                d dVar = d.this;
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = type.J0().d();
                if (!(hVarD instanceof f1) || kotlin.jvm.internal.m.a(((f1) hVarD).b(), dVar)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c implements g1 {
        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public boolean e() {
            return true;
        }

        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public g1 c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public e1 d() {
            return d.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public List<f1> getParameters() {
            return d.this.I0();
        }

        public String toString() {
            return "[typealias " + d().getName().f() + ']';
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public Collection<kotlin.reflect.jvm.internal.impl.types.g0> b() {
            Collection<kotlin.reflect.jvm.internal.impl.types.g0> collectionB = d().c0().J0().b();
            kotlin.jvm.internal.m.e(collectionB, "declarationDescriptor.un…pe.constructor.supertypes");
            return collectionB;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public kotlin.reflect.jvm.internal.impl.builtins.h l() {
            return ea.c.j(d());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return false;
    }

    protected abstract List<f1> I0();

    protected abstract ka.n d0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, ba.f name, a1 sourceElement, kotlin.reflect.jvm.internal.impl.descriptors.u visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(sourceElement, "sourceElement");
        kotlin.jvm.internal.m.f(visibilityImpl, "visibilityImpl");
        this.f12813e = visibilityImpl;
        this.f12815g = new c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> visitor, D d10) {
        kotlin.jvm.internal.m.f(visitor, "visitor");
        return visitor.e(this, d10);
    }

    public final void J0(List<? extends f1> declaredTypeParameters) {
        kotlin.jvm.internal.m.f(declaredTypeParameters, "declaredTypeParameters");
        this.f12814f = declaredTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        return this.f12813e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public g1 h() {
        return this.f12815g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<f1> r() {
        List list = this.f12814f;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.m.v("declaredTypeParametersImpl");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        return "typealias " + getName().f();
    }

    protected final o0 B0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarZ0;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = o();
        if (eVarO == null || (hVarZ0 = eVarO.z0()) == null) {
            hVarZ0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        }
        o0 o0VarU = s1.u(this, hVarZ0, new a());
        kotlin.jvm.internal.m.e(o0VarU, "@OptIn(TypeRefinement::c…s)?.defaultType\n        }");
        return o0VarU;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public e1 a() {
        kotlin.reflect.jvm.internal.impl.descriptors.p pVarA = super.a();
        kotlin.jvm.internal.m.d(pVarA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (e1) pVarA;
    }

    public final Collection<i0> H0() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = o();
        if (eVarO == null) {
            return kotlin.collections.r.l();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> collectionK = eVarO.k();
        kotlin.jvm.internal.m.e(collectionK, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.d it : collectionK) {
            j0.a aVar = j0.I;
            ka.n nVarD0 = d0();
            kotlin.jvm.internal.m.e(it, "it");
            i0 i0VarB = aVar.b(nVarD0, this, it);
            if (i0VarB != null) {
                arrayList.add(i0VarB);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean J() {
        return s1.c(c0(), new b());
    }
}
