package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b extends e {
    private static /* synthetic */ void C(int i10) {
        Object[] objArr = new Object[3];
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
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ka.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, w1 w1Var, boolean z10, int i10, a1 a1Var, d1 d1Var) {
        super(nVar, mVar, gVar, fVar, w1Var, z10, i10, a1Var, d1Var);
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
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        String str;
        String str2 = "";
        if (!z()) {
            str = "";
        } else {
            str = "reified ";
        }
        if (j() != w1.INVARIANT) {
            str2 = j() + " ";
        }
        return String.format("%s%s%s", str, str2, getName());
    }
}
