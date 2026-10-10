package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c extends j implements x0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        super(gVar, ba.h.f950i);
        if (gVar == null) {
            C(0);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean A() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public x0 b0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public x0 i0() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar) {
        super(gVar, fVar);
        if (gVar == null) {
            C(1);
        }
        if (fVar == null) {
            C(2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c1
    public x0 c(p1 p1Var) {
        if (p1Var == null) {
            C(3);
        }
        if (!p1Var.k()) {
            kotlin.reflect.jvm.internal.impl.types.g0 g0VarP = b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? p1Var.p(getType(), w1.OUT_VARIANCE) : p1Var.p(getType(), w1.INVARIANT);
            if (g0VarP == null) {
                return null;
            }
            if (g0VarP != getType()) {
                return new f0(b(), new ha.j(g0VarP), getAnnotations());
            }
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> e() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            C(8);
        }
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<j1> f() {
        List<j1> list = Collections.EMPTY_LIST;
        if (list == null) {
            C(7);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public a1 getSource() {
        a1 a1Var = a1.f12668a;
        if (a1Var == null) {
            C(11);
        }
        return a1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<f1> getTypeParameters() {
        List<f1> list = Collections.EMPTY_LIST;
        if (list == null) {
            C(5);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.jvm.internal.impl.descriptors.t.f13069f;
        if (uVar == null) {
            C(9);
        }
        return uVar;
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
            case 11:
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
            case 11:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "substitutor";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 5:
                objArr[1] = "getTypeParameters";
                break;
            case 6:
                objArr[1] = "getType";
                break;
            case 7:
                objArr[1] = "getValueParameters";
                break;
            case 8:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 9:
                objArr[1] = "getVisibility";
                break;
            case 10:
                objArr[1] = "getOriginal";
                break;
            case 11:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i10) {
            case 3:
                objArr[2] = "substitute";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
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
            case 11:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.l(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.jvm.internal.impl.types.g0 getReturnType() {
        return getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    public kotlin.reflect.jvm.internal.impl.types.g0 getType() {
        kotlin.reflect.jvm.internal.impl.types.g0 type = getValue().getType();
        if (type == null) {
            C(6);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j, kotlin.reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public r0 a() {
        return this;
    }
}
