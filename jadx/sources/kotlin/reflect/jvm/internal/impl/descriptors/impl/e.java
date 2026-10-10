package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class e extends k implements f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w1 f12819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f12820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f12821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ka.i<g1> f12822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ka.i<o0> f12823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ka.n f12824j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements c9.a<g1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ka.n f12825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d1 f12826b;

        a(ka.n nVar, d1 d1Var) {
            this.f12825a = nVar;
            this.f12826b = d1Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g1 invoke() {
            return new c(e.this, this.f12825a, this.f12826b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements c9.a<o0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ba.f f12828a;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
            a() {
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.n.j("Scope for type parameter " + b.this.f12828a.f(), e.this.getUpperBounds());
            }
        }

        b(ba.f fVar) {
            this.f12828a = fVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o0 invoke() {
            return kotlin.reflect.jvm.internal.impl.types.h0.k(c1.f14231b.h(), e.this.h(), Collections.EMPTY_LIST, false, new kotlin.reflect.jvm.internal.impl.resolve.scopes.g(new a()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class c extends kotlin.reflect.jvm.internal.impl.types.g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d1 f12831d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f12832e;

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public boolean e() {
            return true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, ka.n nVar, d1 d1Var) {
            super(nVar);
            if (nVar == null) {
                v(0);
            }
            this.f12832e = eVar;
            this.f12831d = d1Var;
        }

        private static /* synthetic */ void v(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i10 == 2) {
                objArr[1] = "getParameters";
            } else if (i10 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i10 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i10 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i10 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.m, kotlin.reflect.jvm.internal.impl.types.g1
        public kotlin.reflect.jvm.internal.impl.descriptors.h d() {
            e eVar = this.f12832e;
            if (eVar == null) {
                v(3);
            }
            return eVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public List<f1> getParameters() {
            List<f1> list = Collections.EMPTY_LIST;
            if (list == null) {
                v(2);
            }
            return list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.m
        protected boolean i(kotlin.reflect.jvm.internal.impl.descriptors.h hVar) {
            if (hVar == null) {
                v(9);
            }
            return (hVar instanceof f1) && kotlin.reflect.jvm.internal.impl.resolve.c.f13885a.h(this.f12832e, (f1) hVar, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g1
        public kotlin.reflect.jvm.internal.impl.builtins.h l() {
            kotlin.reflect.jvm.internal.impl.builtins.h hVarJ = ea.c.j(this.f12832e);
            if (hVarJ == null) {
                v(4);
            }
            return hVarJ;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected Collection<kotlin.reflect.jvm.internal.impl.types.g0> m() {
            List<kotlin.reflect.jvm.internal.impl.types.g0> listH0 = this.f12832e.H0();
            if (listH0 == null) {
                v(1);
            }
            return listH0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected kotlin.reflect.jvm.internal.impl.types.g0 n() {
            return la.k.d(la.j.f15318s, new String[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected d1 q() {
            d1 d1Var = this.f12831d;
            if (d1Var == null) {
                v(5);
            }
            return d1Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected List<kotlin.reflect.jvm.internal.impl.types.g0> s(List<kotlin.reflect.jvm.internal.impl.types.g0> list) {
            if (list == null) {
                v(7);
            }
            List<kotlin.reflect.jvm.internal.impl.types.g0> listB0 = this.f12832e.B0(list);
            if (listB0 == null) {
                v(8);
            }
            return listB0;
        }

        public String toString() {
            return this.f12832e.getName().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected void u(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
            if (g0Var == null) {
                v(6);
            }
            this.f12832e.G0(g0Var);
        }
    }

    protected abstract void G0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var);

    protected abstract List<kotlin.reflect.jvm.internal.impl.types.g0> H0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean k0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected e(ka.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, w1 w1Var, boolean z10, int i10, a1 a1Var, d1 d1Var) {
        super(mVar, gVar, fVar, a1Var);
        if (nVar == null) {
            C(0);
        }
        if (mVar == null) {
            C(1);
        }
        if (gVar == null) {
            C(2);
        }
        if (fVar == null) {
            C(3);
        }
        if (w1Var == null) {
            C(4);
        }
        if (a1Var == null) {
            C(5);
        }
        if (d1Var == null) {
            C(6);
        }
        this.f12819e = w1Var;
        this.f12820f = z10;
        this.f12821g = i10;
        this.f12822h = nVar.c(new a(nVar, d1Var));
        this.f12823i = nVar.c(new b(fVar));
        this.f12824j = nVar;
    }

    protected List<kotlin.reflect.jvm.internal.impl.types.g0> B0(List<kotlin.reflect.jvm.internal.impl.types.g0> list) {
        if (list == null) {
            C(12);
        }
        if (list == null) {
            C(13);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public ka.n d0() {
        ka.n nVar = this.f12824j;
        if (nVar == null) {
            C(14);
        }
        return nVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public int getIndex() {
        return this.f12821g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1, kotlin.reflect.jvm.internal.impl.descriptors.h
    public final g1 h() {
        g1 g1VarInvoke = this.f12822h.invoke();
        if (g1VarInvoke == null) {
            C(9);
        }
        return g1VarInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public w1 j() {
        w1 w1Var = this.f12819e;
        if (w1Var == null) {
            C(7);
        }
        return w1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public o0 p() {
        o0 o0VarInvoke = this.f12823i.invoke();
        if (o0VarInvoke == null) {
            C(10);
        }
        return o0VarInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean z() {
        return this.f12820f;
    }

    private static /* synthetic */ void C(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i10) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.m(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    public f1 a() {
        f1 f1Var = (f1) super.a();
        if (f1Var == null) {
            C(11);
        }
        return f1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public List<kotlin.reflect.jvm.internal.impl.types.g0> getUpperBounds() {
        List<kotlin.reflect.jvm.internal.impl.types.g0> listB = ((c) h()).b();
        if (listB == null) {
            C(8);
        }
        return listB;
    }
}
