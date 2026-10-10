package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d0 extends b0 implements v0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.types.g0 f12817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final v0 f12818n;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends v0> e() {
        Collection<t0> collectionH0 = super.H0(true);
        if (collectionH0 == null) {
            C(6);
        }
        return collectionH0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, v0 v0Var, a1 a1Var) {
        super(e0Var, uVar, u0Var, gVar, ba.f.o("<get-" + u0Var.getName() + ">"), z10, z11, z12, aVar, a1Var);
        if (u0Var == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (e0Var == null) {
            C(2);
        }
        if (uVar == null) {
            C(3);
        }
        if (aVar == null) {
            C(4);
        }
        if (a1Var == null) {
            C(5);
        }
        this.f12818n = v0Var != null ? v0Var : this;
    }

    private static /* synthetic */ void C(int i10) {
        String str = (i10 == 6 || i10 == 7 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 6 || i10 == 7 || i10 == 8) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i10 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i10 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b0, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public v0 a() {
        v0 v0Var = this.f12818n;
        if (v0Var == null) {
            C(8);
        }
        return v0Var;
    }

    public void M0(kotlin.reflect.jvm.internal.impl.types.g0 g0Var) {
        if (g0Var == null) {
            g0Var = x0().getType();
        }
        this.f12817m = g0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<j1> f() {
        List<j1> list = Collections.EMPTY_LIST;
        if (list == null) {
            C(7);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.jvm.internal.impl.types.g0 getReturnType() {
        return this.f12817m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.b(this, d10);
    }
}
