package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j0 extends p implements i0 {
    private final ka.n E;
    private final e1 F;
    private final ka.j G;
    private kotlin.reflect.jvm.internal.impl.descriptors.d H;
    static final /* synthetic */ i9.k<Object>[] J = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(j0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    public static final a I = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final i0 b(ka.n storageManager, e1 typeAliasDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.d constructor) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVarC;
            List<x0> listL;
            kotlin.jvm.internal.m.f(storageManager, "storageManager");
            kotlin.jvm.internal.m.f(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.m.f(constructor, "constructor");
            p1 p1VarC = c(typeAliasDescriptor);
            if (p1VarC == null || (dVarC = constructor.c(p1VarC)) == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = constructor.getAnnotations();
            kotlin.reflect.jvm.internal.impl.descriptors.b.a aVarG = constructor.g();
            kotlin.jvm.internal.m.e(aVarG, "constructor.kind");
            a1 source = typeAliasDescriptor.getSource();
            kotlin.jvm.internal.m.e(source, "typeAliasDescriptor.source");
            j0 j0Var = new j0(storageManager, typeAliasDescriptor, dVarC, null, annotations, aVarG, source, null);
            List<j1> listK0 = p.K0(j0Var, constructor.f(), p1VarC);
            if (listK0 == null) {
                return null;
            }
            o0 o0VarC = kotlin.reflect.jvm.internal.impl.types.d0.c(dVarC.getReturnType().M0());
            o0 o0VarP = typeAliasDescriptor.p();
            kotlin.jvm.internal.m.e(o0VarP, "typeAliasDescriptor.defaultType");
            o0 o0VarJ = s0.j(o0VarC, o0VarP);
            x0 x0VarB0 = constructor.b0();
            x0 x0VarI = x0VarB0 != null ? kotlin.reflect.jvm.internal.impl.resolve.d.i(j0Var, p1VarC.n(x0VarB0.getType(), w1.INVARIANT), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b()) : null;
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = typeAliasDescriptor.o();
            if (eVarO != null) {
                List<x0> listN0 = constructor.n0();
                kotlin.jvm.internal.m.e(listN0, "constructor.contextReceiverParameters");
                List<x0> list = listN0;
                listL = new ArrayList<>(kotlin.collections.r.w(list, 10));
                int i10 = 0;
                for (Object obj : list) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        kotlin.collections.r.v();
                    }
                    x0 x0Var = (x0) obj;
                    kotlin.reflect.jvm.internal.impl.types.g0 g0VarN = p1VarC.n(x0Var.getType(), w1.INVARIANT);
                    ha.g value = x0Var.getValue();
                    kotlin.jvm.internal.m.d(value, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
                    listL.add(kotlin.reflect.jvm.internal.impl.resolve.d.c(eVarO, g0VarN, ((ha.f) value).a(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), i10));
                    i10 = i11;
                }
            } else {
                listL = kotlin.collections.r.l();
            }
            j0Var.N0(x0VarI, null, listL, typeAliasDescriptor.r(), listK0, o0VarJ, kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL, typeAliasDescriptor.getVisibility());
            return j0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final p1 c(e1 e1Var) {
            if (e1Var.o() == null) {
                return null;
            }
            return p1.f(e1Var.R());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<j0> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d $underlyingConstructorDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            super(0);
            this.$underlyingConstructorDescriptor = dVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j0 invoke() {
            ka.n nVarD0 = j0.this.d0();
            e1 e1VarK1 = j0.this.k1();
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.$underlyingConstructorDescriptor;
            j0 j0Var = j0.this;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = dVar.getAnnotations();
            kotlin.reflect.jvm.internal.impl.descriptors.b.a aVarG = this.$underlyingConstructorDescriptor.g();
            kotlin.jvm.internal.m.e(aVarG, "underlyingConstructorDescriptor.kind");
            a1 source = j0.this.k1().getSource();
            kotlin.jvm.internal.m.e(source, "typeAliasDescriptor.source");
            j0 j0Var2 = new j0(nVarD0, e1VarK1, dVar, j0Var, annotations, aVarG, source, null);
            j0 j0Var3 = j0.this;
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = this.$underlyingConstructorDescriptor;
            p1 p1VarC = j0.I.c(j0Var3.k1());
            if (p1VarC == null) {
                return null;
            }
            x0 x0VarB0 = dVar2.b0();
            x0 x0VarC = x0VarB0 != null ? x0VarB0.c(p1VarC) : null;
            List<x0> listN0 = dVar2.n0();
            kotlin.jvm.internal.m.e(listN0, "underlyingConstructorDes…contextReceiverParameters");
            List<x0> list = listN0;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((x0) it.next()).c(p1VarC));
            }
            j0Var2.N0(null, x0VarC, arrayList, j0Var3.k1().r(), j0Var3.f(), j0Var3.getReturnType(), kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL, j0Var3.k1().getVisibility());
            return j0Var2;
        }
    }

    public /* synthetic */ j0(ka.n nVar, e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, i0 i0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var, kotlin.jvm.internal.g gVar2) {
        this(nVar, e1Var, dVar, i0Var, gVar, aVar, a1Var);
    }

    private j0(ka.n nVar, e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, i0 i0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var) {
        super(e1Var, i0Var, gVar, ba.h.f951j, aVar, a1Var);
        this.E = nVar;
        this.F = e1Var;
        R0(k1().A0());
        this.G = nVar.g(new b(dVar));
        this.H = dVar;
    }

    public final ka.n d0() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public i0 g0(kotlin.reflect.jvm.internal.impl.descriptors.m newOwner, kotlin.reflect.jvm.internal.impl.descriptors.e0 modality, kotlin.reflect.jvm.internal.impl.descriptors.u visibility, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, boolean z10) {
        kotlin.jvm.internal.m.f(newOwner, "newOwner");
        kotlin.jvm.internal.m.f(modality, "modality");
        kotlin.jvm.internal.m.f(visibility, "visibility");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.reflect.jvm.internal.impl.descriptors.y yVarBuild = q().p(newOwner).c(modality).n(visibility).r(kind).i(z10).build();
        kotlin.jvm.internal.m.d(yVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (i0) yVarBuild;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public j0 H0(kotlin.reflect.jvm.internal.impl.descriptors.m newOwner, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a kind, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, a1 source) {
        kotlin.jvm.internal.m.f(newOwner, "newOwner");
        kotlin.jvm.internal.m.f(kind, "kind");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(source, "source");
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION;
        if (kind != aVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar2 = kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED;
        }
        return new j0(this.E, k1(), l0(), this, annotations, aVar, source);
    }

    public e1 k1() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.i0
    public kotlin.reflect.jvm.internal.impl.descriptors.d l0() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.c1
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public i0 c(p1 substitutor) {
        kotlin.jvm.internal.m.f(substitutor, "substitutor");
        kotlin.reflect.jvm.internal.impl.descriptors.y yVarC = super.c(substitutor);
        kotlin.jvm.internal.m.d(yVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        j0 j0Var = (j0) yVarC;
        p1 p1VarF = p1.f(j0Var.getReturnType());
        kotlin.jvm.internal.m.e(p1VarF, "create(substitutedTypeAliasConstructor.returnType)");
        kotlin.reflect.jvm.internal.impl.descriptors.d dVarC = l0().a().c(p1VarF);
        if (dVarC == null) {
            return null;
        }
        j0Var.H = dVarC;
        return j0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.jvm.internal.impl.types.g0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.g0 returnType = super.getReturnType();
        kotlin.jvm.internal.m.c(returnType);
        return returnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public e1 b() {
        return k1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public i0 a() {
        kotlin.reflect.jvm.internal.impl.descriptors.y yVarA = super.a();
        kotlin.jvm.internal.m.d(yVarA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (i0) yVarA;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l
    public boolean v() {
        return l0().v();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l
    public kotlin.reflect.jvm.internal.impl.descriptors.e w() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarW = l0().w();
        kotlin.jvm.internal.m.e(eVarW, "underlyingConstructorDescriptor.constructedClass");
        return eVarW;
    }
}
