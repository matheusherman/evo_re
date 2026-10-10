package s9;

import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.util.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class e extends g0 implements s9.a {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<j1> G = new a();
    public static final kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<Boolean> H = new b();
    private c E;
    private final boolean F;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum c {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void a(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        public static c f(boolean z10, boolean z11) {
            c cVar;
            if (z10) {
                cVar = z11 ? STABLE_SYNTHESIZED : STABLE_DECLARED;
            } else {
                cVar = z11 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            }
            if (cVar == null) {
                a(0);
            }
            return cVar;
        }

        c(boolean z10, boolean z11) {
            this.isStable = z10;
            this.isSynthesized = z11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<j1> {
        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b implements kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<Boolean> {
        b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected e(m mVar, z0 z0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var, boolean z10) {
        super(mVar, z0Var, gVar, fVar, aVar, a1Var);
        if (mVar == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (fVar == null) {
            C(2);
        }
        if (aVar == null) {
            C(3);
        }
        if (a1Var == null) {
            C(4);
        }
        this.E = null;
        this.F = z10;
    }

    private static /* synthetic */ void C(int i10) {
        String str = (i10 == 13 || i10 == 18 || i10 == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 13 || i10 == 18 || i10 == 21) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 13) {
            objArr[1] = "initialize";
        } else if (i10 == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 21:
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 13 && i10 != 18 && i10 != 21) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static e l1(m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, a1 a1Var, boolean z10) {
        if (mVar == null) {
            C(5);
        }
        if (gVar == null) {
            C(6);
        }
        if (fVar == null) {
            C(7);
        }
        if (a1Var == null) {
            C(8);
        }
        return new e(mVar, null, gVar, fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, a1Var, z10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean A() {
        return this.E.isSynthesized;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    public boolean M0() {
        return this.E.isStable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g0
    public g0 k1(x0 x0Var, x0 x0Var2, List<x0> list, List<? extends f1> list2, List<j1> list3, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, e0 e0Var, u uVar, Map<? extends kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> map) {
        if (list == null) {
            C(9);
        }
        if (list2 == null) {
            C(10);
        }
        if (list3 == null) {
            C(11);
        }
        if (uVar == null) {
            C(12);
        }
        g0 g0VarK1 = super.k1(x0Var, x0Var2, list, list2, list3, g0Var, e0Var, uVar, map);
        b1(p.f14433a.a(g0VarK1).a());
        if (g0VarK1 == null) {
            C(13);
        }
        return g0VarK1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g0, kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public e H0(m mVar, y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a1 a1Var) {
        if (mVar == null) {
            C(14);
        }
        if (aVar == null) {
            C(15);
        }
        if (gVar == null) {
            C(16);
        }
        if (a1Var == null) {
            C(17);
        }
        z0 z0Var = (z0) yVar;
        if (fVar == null) {
            fVar = getName();
        }
        e eVar = new e(mVar, z0Var, gVar, fVar, aVar, a1Var, this.F);
        eVar.o1(M0(), A());
        return eVar;
    }

    @Override // s9.a
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public e u(kotlin.reflect.jvm.internal.impl.types.g0 g0Var, List<kotlin.reflect.jvm.internal.impl.types.g0> list, kotlin.reflect.jvm.internal.impl.types.g0 g0Var2, r8.p<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> pVar) {
        if (list == null) {
            C(19);
        }
        if (g0Var2 == null) {
            C(20);
        }
        e eVar = (e) q().b(h.a(list, f(), this)).f(g0Var2).j(g0Var == null ? null : kotlin.reflect.jvm.internal.impl.resolve.d.i(this, g0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b())).a().e().build();
        if (pVar != null) {
            eVar.Q0(pVar.c(), pVar.d());
        }
        if (eVar == null) {
            C(21);
        }
        return eVar;
    }

    public void o1(boolean z10, boolean z11) {
        this.E = c.f(z10, z11);
    }
}
