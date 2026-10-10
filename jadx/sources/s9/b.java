package s9;

import java.util.List;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.g0;
import r8.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.f implements a {
    private Boolean F;
    private Boolean G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, b bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var) {
        super(eVar, bVar, gVar, z10, aVar, a1Var);
        if (eVar == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (aVar == null) {
            C(2);
        }
        if (a1Var == null) {
            C(3);
        }
        this.F = null;
        this.G = null;
    }

    private static /* synthetic */ void C(int i10) {
        String str = (i10 == 11 || i10 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 11 || i10 == 18) ? 2 : 3];
        switch (i10) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 11 && i10 != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static b p1(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, a1 a1Var) {
        if (eVar == null) {
            C(4);
        }
        if (gVar == null) {
            C(5);
        }
        if (a1Var == null) {
            C(6);
        }
        return new b(eVar, null, gVar, z10, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, a1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean A() {
        return this.G.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    public boolean M0() {
        return this.F.booleanValue();
    }

    protected b o1(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, b bVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (eVar == null) {
            C(12);
        }
        if (aVar == null) {
            C(13);
        }
        if (a1Var == null) {
            C(14);
        }
        if (gVar == null) {
            C(15);
        }
        return new b(eVar, bVar, gVar, this.E, aVar, a1Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.f
    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public b H0(m mVar, y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a1 a1Var) {
        if (mVar == null) {
            C(7);
        }
        if (aVar == null) {
            C(8);
        }
        if (gVar == null) {
            C(9);
        }
        if (a1Var == null) {
            C(10);
        }
        if (aVar == kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION || aVar == kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED) {
            b bVarO1 = o1((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar, (b) yVar, aVar, a1Var, gVar);
            bVarO1.U0(M0());
            bVarO1.V0(A());
            return bVarO1;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    @Override // s9.a
    /* JADX INFO: renamed from: r1, reason: merged with bridge method [inline-methods] */
    public b u(g0 g0Var, List<g0> list, g0 g0Var2, p<kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> pVar) {
        if (list == null) {
            C(16);
        }
        if (g0Var2 == null) {
            C(17);
        }
        b bVarH0 = H0(b(), null, g(), null, getAnnotations(), getSource());
        bVarH0.N0(g0Var == null ? null : kotlin.reflect.jvm.internal.impl.resolve.d.i(bVarH0, g0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b()), b0(), r.l(), getTypeParameters(), h.a(list, f(), bVarH0), g0Var2, i(), getVisibility());
        if (pVar != null) {
            bVarH0.Q0(pVar.c(), pVar.d());
        }
        return bVarH0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    public void U0(boolean z10) {
        this.F = Boolean.valueOf(z10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    public void V0(boolean z10) {
        this.G = Boolean.valueOf(z10);
    }
}
