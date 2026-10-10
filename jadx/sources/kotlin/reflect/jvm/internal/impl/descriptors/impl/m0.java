package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class m0 extends k implements k1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected kotlin.reflect.jvm.internal.impl.types.g0 f12864e;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean A() {
        return false;
    }

    public x0 b0() {
        return null;
    }

    public x0 i0() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, a1 a1Var) {
        super(mVar, gVar, fVar, a1Var);
        if (mVar == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (fVar == null) {
            C(2);
        }
        if (a1Var == null) {
            C(3);
        }
        this.f12864e = g0Var;
    }

    public void B0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
        this.f12864e = g0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<j1> f() {
        List<j1> list = Collections.EMPTY_LIST;
        if (list == null) {
            C(6);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    public kotlin.reflect.jvm.internal.impl.types.g0 getType() {
        kotlin.reflect.jvm.internal.impl.types.g0 g0Var = this.f12864e;
        if (g0Var == null) {
            C(4);
        }
        return g0Var;
    }

    public List<f1> getTypeParameters() {
        List<f1> list = Collections.EMPTY_LIST;
        if (list == null) {
            C(8);
        }
        return list;
    }

    private static /* synthetic */ void C(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 10:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public kotlin.reflect.jvm.internal.impl.types.g0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.g0 type = getType();
        if (type == null) {
            C(10);
        }
        return type;
    }
}
