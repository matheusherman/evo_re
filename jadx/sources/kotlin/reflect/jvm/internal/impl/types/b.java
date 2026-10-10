package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b extends g implements g1 {
    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    private static /* synthetic */ void v(int i10) {
        String str = (i10 == 1 || i10 == 3 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 3 || i10 == 4) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else if (i10 == 2) {
            objArr[0] = "classifier";
        } else if (i10 == 3 || i10 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else {
            objArr[0] = "storageManager";
        }
        if (i10 == 1) {
            objArr[1] = "getBuiltIns";
        } else if (i10 == 3 || i10 == 4) {
            objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        }
        if (i10 != 1) {
            if (i10 == 2) {
                objArr[2] = "isSameClassifier";
            } else if (i10 != 3 && i10 != 4) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 3 && i10 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX INFO: renamed from: w */
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.e d();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ka.n nVar) {
        super(nVar);
        if (nVar == null) {
            v(0);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    protected boolean i(kotlin.reflect.jvm.internal.impl.descriptors.h hVar) {
        if (hVar == null) {
            v(2);
        }
        return (hVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && g(d(), hVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.builtins.h l() {
        kotlin.reflect.jvm.internal.impl.builtins.h hVarJ = ea.c.j(d());
        if (hVarJ == null) {
            v(1);
        }
        return hVarJ;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g
    protected g0 n() {
        if (kotlin.reflect.jvm.internal.impl.builtins.h.u0(d())) {
            return null;
        }
        return l().i();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g
    protected Collection<g0> o(boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = d().b();
        if (!(mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
            List list = Collections.EMPTY_LIST;
            if (list == null) {
                v(3);
            }
            return list;
        }
        sa.f fVar = new sa.f();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB;
        fVar.add(eVar.p());
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarP = eVar.P();
        if (z10 && eVarP != null) {
            fVar.add(eVarP.p());
        }
        return fVar;
    }
}
