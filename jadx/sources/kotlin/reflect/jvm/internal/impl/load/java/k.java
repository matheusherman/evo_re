package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {
    private static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "companionObject";
        } else if (i10 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i10 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i10 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i10 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean c(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(1);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.e.x(mVar) && kotlin.reflect.jvm.internal.impl.resolve.e.w(mVar.b()) && !d((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar);
    }

    public static boolean e(u0 u0Var) {
        if (u0Var == null) {
            a(0);
        }
        if (u0Var.g() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE) {
            return false;
        }
        if (c(u0Var.b())) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.e.x(u0Var.b()) && b(u0Var);
    }

    public static boolean b(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.w wVarM0;
        if (bVar == null) {
            a(3);
        }
        if ((bVar instanceof u0) && (wVarM0 = ((u0) bVar).m0()) != null && wVarM0.getAnnotations().F(a0.f13098b)) {
            return true;
        }
        return bVar.getAnnotations().F(a0.f13098b);
    }

    public static boolean d(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(2);
        }
        return kotlin.reflect.jvm.internal.impl.builtins.d.a(kotlin.reflect.jvm.internal.impl.builtins.c.f12458a, eVar);
    }
}
