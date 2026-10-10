package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f12942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p1 f12943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private p1 f12944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<f1> f12945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<f1> f12946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g1 f12947g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements c9.l<f1, Boolean> {
        a() {
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(f1 f1Var) {
            return Boolean.valueOf(!f1Var.k0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements c9.l<o0, o0> {
        b() {
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o0 invoke(o0 o0Var) {
            return s.this.I0(o0Var);
        }
    }

    private p1 G0() {
        if (this.f12944d == null) {
            if (this.f12943c.k()) {
                this.f12944d = this.f12943c;
            } else {
                List<f1> parameters = this.f12942b.h().getParameters();
                this.f12945e = new ArrayList(parameters.size());
                this.f12944d = kotlin.reflect.jvm.internal.impl.types.t.b(parameters, this.f12943c.j(), this, this.f12945e);
                this.f12946f = kotlin.collections.r.e0(this.f12945e, new a());
            }
        }
        return this.f12944d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o0 I0(o0 o0Var) {
        return (o0Var == null || this.f12943c.k()) ? o0Var : (o0) G0().p(o0Var, w1.INVARIANT);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0051  */
    /* JADX WARN: Code duplicated, block: B:35:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005b  */
    private static /* synthetic */ void w0(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 8 || i10 == 10 || i10 == 13 || i10 == 23) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 8 || i10 == 10 || i10 == 13 || i10 == 23) ? 3 : 2];
        if (i10 == 2) {
            objArr[0] = "typeArguments";
        } else if (i10 == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i10 == 5) {
            objArr[0] = "typeSubstitution";
        } else if (i10 == 6) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i10 == 8) {
            objArr[0] = "typeArguments";
        } else if (i10 == 10) {
            objArr[0] = "typeSubstitution";
        } else if (i10 == 13) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i10 != 23) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        } else {
            objArr[0] = "substitutor";
        }
        switch (i10) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 23:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getContextReceivers";
                break;
            case 18:
                objArr[1] = "getConstructors";
                break;
            case 19:
                objArr[1] = "getAnnotations";
                break;
            case 20:
                objArr[1] = "getName";
                break;
            case 21:
                objArr[1] = "getOriginal";
                break;
            case 22:
                objArr[1] = "getContainingDeclaration";
                break;
            case 24:
                objArr[1] = "substitute";
                break;
            case 25:
                objArr[1] = "getKind";
                break;
            case 26:
                objArr[1] = "getModality";
                break;
            case 27:
                objArr[1] = "getVisibility";
                break;
            case 28:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 29:
                objArr[1] = "getSource";
                break;
            case 30:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 31:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        if (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 8 || i10 == 10) {
            objArr[2] = "getMemberScope";
        } else if (i10 == 13) {
            objArr[2] = "getUnsubstitutedMemberScope";
        } else if (i10 == 23) {
            objArr[2] = "substitute";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 5 && i10 != 6 && i10 != 8 && i10 != 10 && i10 != 13 && i10 != 23) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return this.f12942b.A0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h C(n1 n1Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (n1Var == null) {
            w0(5);
        }
        if (gVar == null) {
            w0(6);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarC = this.f12942b.C(n1Var, gVar);
        if (!this.f12943c.k()) {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.m(hVarC, G0());
        }
        if (hVarC == null) {
            w0(7);
        }
        return hVarC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public List<x0> C0() {
        List<x0> list = Collections.EMPTY_LIST;
        if (list == null) {
            w0(17);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> E() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> collectionE = this.f12942b.E();
        if (collectionE == null) {
            w0(31);
        }
        return collectionE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean E0() {
        return this.f12942b.E0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean F() {
        return this.f12942b.F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public x0 F0() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h G(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            w0(13);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarG = this.f12942b.G(gVar);
        if (!this.f12943c.k()) {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.m(hVarG, G0());
        }
        if (hVarG == null) {
            w0(14);
        }
        return hVarG;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e c(p1 p1Var) {
        if (p1Var == null) {
            w0(23);
        }
        return p1Var.k() ? this : new s(this, p1.h(p1Var.j(), G0().j()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return this.f12942b.I();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean J() {
        return this.f12942b.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d M() {
        return this.f12942b.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h N() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = this.f12942b.N();
        if (hVarN == null) {
            w0(15);
        }
        return hVarN;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e P() {
        return this.f12942b.P();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h W(n1 n1Var) {
        if (n1Var == null) {
            w0(10);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarC = C(n1Var, ea.c.o(kotlin.reflect.jvm.internal.impl.resolve.e.g(this)));
        if (hVarC == null) {
            w0(11);
        }
        return hVarC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = this.f12942b.b();
        if (mVarB == null) {
            w0(22);
        }
        return mVarB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f g() {
        kotlin.reflect.jvm.internal.impl.descriptors.f fVarG = this.f12942b.g();
        if (fVarG == null) {
            w0(25);
        }
        return fVarG;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = this.f12942b.getAnnotations();
        if (annotations == null) {
            w0(19);
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    public ba.f getName() {
        ba.f name = this.f12942b.getName();
        if (name == null) {
            w0(20);
        }
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public a1 getSource() {
        a1 a1Var = a1.f12668a;
        if (a1Var == null) {
            w0(29);
        }
        return a1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u visibility = this.f12942b.getVisibility();
        if (visibility == null) {
            w0(27);
        }
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public g1 h() {
        g1 g1VarH = this.f12942b.h();
        if (this.f12943c.k()) {
            if (g1VarH == null) {
                w0(0);
            }
            return g1VarH;
        }
        if (this.f12947g == null) {
            p1 p1VarG0 = G0();
            Collection<kotlin.reflect.jvm.internal.impl.types.g0> collectionB = g1VarH.b();
            ArrayList arrayList = new ArrayList(collectionB.size());
            Iterator<kotlin.reflect.jvm.internal.impl.types.g0> it = collectionB.iterator();
            while (it.hasNext()) {
                arrayList.add(p1VarG0.p(it.next(), w1.INVARIANT));
            }
            this.f12947g = new kotlin.reflect.jvm.internal.impl.types.l(this, this.f12945e, arrayList, ka.f.f12182e);
        }
        g1 g1Var = this.f12947g;
        if (g1Var == null) {
            w0(1);
        }
        return g1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public kotlin.reflect.jvm.internal.impl.descriptors.e0 i() {
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0VarI = this.f12942b.i();
        if (e0VarI == null) {
            w0(26);
        }
        return e0VarI;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean isExternal() {
        return this.f12942b.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return this.f12942b.isInline();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> collectionK = this.f12942b.k();
        ArrayList arrayList = new ArrayList(collectionK.size());
        for (kotlin.reflect.jvm.internal.impl.descriptors.d dVar : collectionK) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.d) dVar.q().g(dVar.a()).c(dVar.i()).n(dVar.getVisibility()).r(dVar.g()).i(false).build()).c(G0()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean t() {
        return this.f12942b.t();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h u0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarU0 = this.f12942b.u0();
        if (hVarU0 == null) {
            w0(28);
        }
        return hVarU0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public h1<o0> v0() {
        h1<o0> h1VarV0 = this.f12942b.v0();
        if (h1VarV0 == null) {
            return null;
        }
        return h1VarV0.b(new b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean x() {
        return this.f12942b.x();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h z0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarG = G(ea.c.o(kotlin.reflect.jvm.internal.impl.resolve.e.g(this.f12942b)));
        if (hVarG == null) {
            w0(12);
        }
        return hVarG;
    }

    public s(t tVar, p1 p1Var) {
        this.f12942b = tVar;
        this.f12943c = p1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.a(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.e a() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = this.f12942b.a();
        if (eVarA == null) {
            w0(21);
        }
        return eVarA;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.h
    public o0 p() {
        o0 o0VarK = kotlin.reflect.jvm.internal.impl.types.h0.k(kotlin.reflect.jvm.internal.impl.types.o.f14346a.a(getAnnotations(), null, null), h(), s1.g(h().getParameters()), false, z0());
        if (o0VarK == null) {
            w0(16);
        }
        return o0VarK;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<f1> r() {
        G0();
        List<f1> list = this.f12946f;
        if (list == null) {
            w0(30);
        }
        return list;
    }
}
