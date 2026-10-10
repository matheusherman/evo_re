package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a extends kotlin.reflect.jvm.internal.impl.descriptors.impl.f {
        private static /* synthetic */ void C(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, a1 a1Var, boolean z10) {
            super(eVar, null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), true, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, a1Var);
            if (eVar == null) {
                C(0);
            }
            if (a1Var == null) {
                C(1);
            }
            m1(Collections.EMPTY_LIST, e.k(eVar, z10));
        }
    }

    private static /* synthetic */ void a(int i10) {
        String str = (i10 == 12 || i10 == 23 || i10 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 12 || i10 == 23 || i10 == 25) ? 2 : 3];
        switch (i10) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 31:
            case 33:
            case 35:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
            case 26:
                objArr[0] = "enumClass";
                break;
            case 27:
            case 28:
            case 29:
                objArr[0] = "descriptor";
                break;
            case 30:
            case 32:
            case 34:
                objArr[0] = "owner";
                break;
        }
        if (i10 == 12) {
            objArr[1] = "createSetter";
        } else if (i10 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i10 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "createEnumEntriesProperty";
                break;
            case 27:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 28:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 29:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 30:
            case 31:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 32:
            case 33:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case 34:
            case 35:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 12 && i10 != 23 && i10 != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static x0 b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, g0 g0Var, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, int i10) {
        if (aVar == null) {
            a(32);
        }
        if (gVar == null) {
            a(33);
        }
        if (g0Var == null) {
            return null;
        }
        return new f0(aVar, new ha.c(aVar, g0Var, fVar, null), gVar, ba.g.a(i10));
    }

    public static x0 c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, g0 g0Var, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, int i10) {
        if (eVar == null) {
            a(34);
        }
        if (gVar == null) {
            a(35);
        }
        if (g0Var == null) {
            return null;
        }
        return new f0(eVar, new ha.b(eVar, g0Var, fVar, null), gVar, ba.g.a(i10));
    }

    public static d0 d(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (u0Var == null) {
            a(13);
        }
        if (gVar == null) {
            a(14);
        }
        return j(u0Var, gVar, true, false, false);
    }

    public static e0 e(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        if (u0Var == null) {
            a(0);
        }
        if (gVar == null) {
            a(1);
        }
        if (gVar2 == null) {
            a(2);
        }
        return n(u0Var, gVar, gVar2, true, false, false, u0Var.getSource());
    }

    public static u0 f(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(26);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = x.a(e.g(eVar), ba.i.f960a.i());
        if (eVarA == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarB = aVar.b();
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var = kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL;
        u uVar = t.f13068e;
        ba.f fVar = kotlin.reflect.jvm.internal.impl.builtins.k.f12576e;
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar2 = kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED;
        c0 c0VarK0 = c0.K0(eVar, gVarB, e0Var, uVar, false, fVar, aVar2, eVar.getSource(), false, false, false, false, false, false);
        d0 d0Var = new d0(c0VarK0, aVar.b(), e0Var, uVar, false, false, false, aVar2, null, eVar.getSource());
        c0VarK0.Q0(d0Var, null);
        o0 o0VarH = h0.h(c1.f14231b.h(), eVarA.h(), Collections.singletonList(new m1(eVar.p())), false);
        List<? extends f1> list = Collections.EMPTY_LIST;
        c0VarK0.X0(o0VarH, list, null, null, list);
        d0Var.M0(c0VarK0.getReturnType());
        return c0VarK0;
    }

    public static z0 g(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(24);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.g0 g0VarH1 = kotlin.reflect.jvm.internal.impl.descriptors.impl.g0.h1(eVar, aVar.b(), kotlin.reflect.jvm.internal.impl.builtins.k.f12577f, kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED, eVar.getSource());
        l0 l0Var = new l0(g0VarH1, null, 0, aVar.b(), ba.f.l("value"), ea.c.j(eVar).W(), false, false, false, null, eVar.getSource());
        List<x0> list = Collections.EMPTY_LIST;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.g0 g0VarJ1 = g0VarH1.N0(null, null, list, list, Collections.singletonList(l0Var), eVar.p(), kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL, t.f13068e);
        if (g0VarJ1 == null) {
            a(25);
        }
        return g0VarJ1;
    }

    public static z0 h(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(22);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.impl.g0 g0VarH1 = kotlin.reflect.jvm.internal.impl.descriptors.impl.g0.h1(eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b(), kotlin.reflect.jvm.internal.impl.builtins.k.f12575d, kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED, eVar.getSource());
        List<x0> list = Collections.EMPTY_LIST;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.g0 g0VarJ1 = g0VarH1.N0(null, null, list, list, list, ea.c.j(eVar).l(w1.INVARIANT, eVar.p()), kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL, t.f13068e);
        if (g0VarJ1 == null) {
            a(23);
        }
        return g0VarJ1;
    }

    public static x0 i(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (aVar == null) {
            a(30);
        }
        if (gVar == null) {
            a(31);
        }
        if (g0Var == null) {
            return null;
        }
        return new f0(aVar, new ha.d(aVar, g0Var, null), gVar);
    }

    public static d0 j(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, boolean z11, boolean z12) {
        if (u0Var == null) {
            a(15);
        }
        if (gVar == null) {
            a(16);
        }
        return k(u0Var, gVar, z10, z11, z12, u0Var.getSource());
    }

    public static d0 k(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, boolean z11, boolean z12, a1 a1Var) {
        if (u0Var == null) {
            a(17);
        }
        if (gVar == null) {
            a(18);
        }
        if (a1Var == null) {
            a(19);
        }
        return new d0(u0Var, gVar, u0Var.i(), u0Var.getVisibility(), z10, z11, z12, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, null, a1Var);
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.impl.f l(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, a1 a1Var) {
        if (eVar == null) {
            a(20);
        }
        if (a1Var == null) {
            a(21);
        }
        return new a(eVar, a1Var, false);
    }

    public static e0 m(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2, boolean z10, boolean z11, boolean z12, u uVar, a1 a1Var) {
        if (u0Var == null) {
            a(7);
        }
        if (gVar == null) {
            a(8);
        }
        if (gVar2 == null) {
            a(9);
        }
        if (uVar == null) {
            a(10);
        }
        if (a1Var == null) {
            a(11);
        }
        e0 e0Var = new e0(u0Var, gVar, u0Var.i(), uVar, z10, z11, z12, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, null, a1Var);
        e0Var.N0(e0.L0(e0Var, u0Var.getType(), gVar2));
        return e0Var;
    }

    public static e0 n(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2, boolean z10, boolean z11, boolean z12, a1 a1Var) {
        if (u0Var == null) {
            a(3);
        }
        if (gVar == null) {
            a(4);
        }
        if (gVar2 == null) {
            a(5);
        }
        if (a1Var == null) {
            a(6);
        }
        return m(u0Var, gVar, gVar2, z10, z11, z12, u0Var.getVisibility(), a1Var);
    }

    private static boolean o(y yVar) {
        if (yVar == null) {
            a(29);
        }
        return yVar.g() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED && e.A(yVar.b());
    }

    public static boolean p(y yVar) {
        if (yVar == null) {
            a(28);
        }
        return yVar.getName().equals(kotlin.reflect.jvm.internal.impl.builtins.k.f12577f) && o(yVar);
    }

    public static boolean q(y yVar) {
        if (yVar == null) {
            a(27);
        }
        return yVar.getName().equals(kotlin.reflect.jvm.internal.impl.builtins.k.f12575d) && o(yVar);
    }
}
