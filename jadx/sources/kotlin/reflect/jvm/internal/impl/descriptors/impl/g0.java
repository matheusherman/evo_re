package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g0 extends p implements z0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected g0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, z0 z0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var) {
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
    }

    private static /* synthetic */ void C(int i10) {
        String str = (i10 == 13 || i10 == 18 || i10 == 23 || i10 == 24 || i10 == 29 || i10 == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 13 || i10 == 18 || i10 == 23 || i10 == 24 || i10 == 29 || i10 == 30) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 27:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 26:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 28:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case 21:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 17:
            case 22:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 14:
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 25:
                objArr[0] = "newOwner";
                break;
        }
        if (i10 == 13 || i10 == 18 || i10 == 23) {
            objArr[1] = "initialize";
        } else if (i10 == 24) {
            objArr[1] = "getOriginal";
        } else if (i10 == 29) {
            objArr[1] = "copy";
        } else if (i10 != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                break;
            case 25:
            case 26:
            case 27:
            case 28:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 13 && i10 != 18 && i10 != 23 && i10 != 24 && i10 != 29 && i10 != 30) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static g0 h1(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var) {
        if (mVar == null) {
            C(5);
        }
        if (gVar == null) {
            C(6);
        }
        if (fVar == null) {
            C(7);
        }
        if (aVar == null) {
            C(8);
        }
        if (a1Var == null) {
            C(9);
        }
        return new g0(mVar, null, gVar, fVar, aVar, a1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    protected p H0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a1 a1Var) {
        if (mVar == null) {
            C(25);
        }
        if (aVar == null) {
            C(26);
        }
        if (gVar == null) {
            C(27);
        }
        if (a1Var == null) {
            C(28);
        }
        z0 z0Var = (z0) yVar;
        if (fVar == null) {
            fVar = getName();
        }
        return new g0(mVar, z0Var, gVar, fVar, aVar, a1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public g0 N0(x0 x0Var, x0 x0Var2, List<x0> list, List<? extends f1> list2, List<j1> list3, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        if (list == null) {
            C(14);
        }
        if (list2 == null) {
            C(15);
        }
        if (list3 == null) {
            C(16);
        }
        if (uVar == null) {
            C(17);
        }
        g0 g0VarK1 = k1(x0Var, x0Var2, list, list2, list3, g0Var, e0Var, uVar, null);
        if (g0VarK1 == null) {
            C(18);
        }
        return g0VarK1;
    }

    public g0 k1(x0 x0Var, x0 x0Var2, List<x0> list, List<? extends f1> list2, List<j1> list3, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, Map<? extends kotlin.reflect.jvm.internal.impl.descriptors.a.InterfaceC0217a<?>, ?> map) {
        if (list == null) {
            C(19);
        }
        if (list2 == null) {
            C(20);
        }
        if (list3 == null) {
            C(21);
        }
        if (uVar == null) {
            C(22);
        }
        super.N0(x0Var, x0Var2, list, list2, list3, g0Var, e0Var, uVar);
        if (map != null && !map.isEmpty()) {
            this.D = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public z0 g0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z10) {
        z0 z0Var = (z0) super.g0(mVar, e0Var, uVar, aVar, z10);
        if (z0Var == null) {
            C(29);
        }
        return z0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public z0 a() {
        z0 z0Var = (z0) super.a();
        if (z0Var == null) {
            C(24);
        }
        return z0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.z0
    public kotlin.reflect.jvm.internal.impl.descriptors.y.a<? extends z0> q() {
        kotlin.reflect.jvm.internal.impl.descriptors.y.a aVarQ = super.q();
        if (aVarQ == null) {
            C(30);
        }
        return aVarQ;
    }
}
