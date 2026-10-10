package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.p1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends p implements kotlin.reflect.jvm.internal.impl.descriptors.d {
    protected final boolean E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected f(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, a1 a1Var) {
        super(eVar, lVar, gVar, ba.h.f951j, aVar, a1Var);
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
        this.E = z10;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a  */
    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    private static /* synthetic */ void C(int i10) {
        String str;
        int i11;
        if (i10 != 21 && i10 != 27) {
            switch (i10) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 21 && i10 != 27) {
            switch (i10) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    i11 = 2;
                    break;
                default:
                    i11 = 3;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 5:
            case 8:
            case 25:
                objArr[0] = "annotations";
                break;
            case 2:
            case 24:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 9:
            case 26:
                objArr[0] = "source";
                break;
            case 4:
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 13:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
            case 14:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "typeParameterDescriptors";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
                objArr[0] = "overriddenDescriptors";
                break;
            case 23:
                objArr[0] = "newOwner";
                break;
        }
        if (i10 == 21) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 != 27) {
            switch (i10) {
                case 15:
                case 16:
                    objArr[1] = "calculateContextReceiverParameters";
                    break;
                case 17:
                    objArr[1] = "getContainingDeclaration";
                    break;
                case 18:
                    objArr[1] = "getConstructedClass";
                    break;
                case 19:
                    objArr[1] = "getOriginal";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "create";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSynthesized";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[2] = "initialize";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 27:
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 23:
            case 24:
            case 25:
            case 26:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 21 && i10 != 27) {
            switch (i10) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static f j1(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z10, a1 a1Var) {
        if (eVar == null) {
            C(4);
        }
        if (gVar == null) {
            C(5);
        }
        if (a1Var == null) {
            C(6);
        }
        return new f(eVar, null, gVar, z10, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, a1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> e() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            C(21);
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    /* JADX INFO: renamed from: k1, reason: merged with bridge method [inline-methods] */
    public f H0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a1 a1Var) {
        if (mVar == null) {
            C(23);
        }
        if (aVar == null) {
            C(24);
        }
        if (gVar == null) {
            C(25);
        }
        if (a1Var == null) {
            C(26);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar2 = kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION;
        if (aVar == aVar2 || aVar == kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED) {
            return new f((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar, this, gVar, this.E, aVar2, a1Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    public f m1(List<j1> list, kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        if (list == null) {
            C(13);
        }
        if (uVar == null) {
            C(14);
        }
        n1(list, uVar, b().r());
        return this;
    }

    public f n1(List<j1> list, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, List<f1> list2) {
        if (list == null) {
            C(10);
        }
        if (uVar == null) {
            C(11);
        }
        if (list2 == null) {
            C(12);
        }
        super.N0(null, h1(), g1(), list2, list, null, kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL, uVar);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.b
    public void t0(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        if (collection == null) {
            C(22);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l
    public boolean v() {
        return this.E;
    }

    private List<x0> g1() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarB = b();
        if (!eVarB.C0().isEmpty()) {
            List<x0> listC0 = eVarB.C0();
            if (listC0 == null) {
                C(15);
            }
            return listC0;
        }
        List<x0> list = Collections.EMPTY_LIST;
        if (list == null) {
            C(16);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.h(this, d10);
    }

    public x0 h1() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarB = b();
        if (eVarB.J()) {
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = eVarB.b();
            if (mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                return ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB).F0();
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.d g0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) super.g0(mVar, e0Var, uVar, aVar, z10);
        if (dVar == null) {
            C(27);
        }
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e b() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) super.b();
        if (eVar == null) {
            C(17);
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l
    public kotlin.reflect.jvm.internal.impl.descriptors.e w() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarB = b();
        if (eVarB == null) {
            C(18);
        }
        return eVarB;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.c1
    public kotlin.reflect.jvm.internal.impl.descriptors.d c(p1 p1Var) {
        if (p1Var == null) {
            C(20);
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) super.c(p1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    public kotlin.reflect.jvm.internal.impl.descriptors.d a() {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) super.a();
        if (dVar == null) {
            C(19);
        }
        return dVar;
    }
}
