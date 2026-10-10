package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f12934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ha.e f12935d;

    private static /* synthetic */ void C(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i10 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i10 == 1) {
            objArr[1] = "getValue";
        } else if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b());
        if (eVar == null) {
            C(0);
        }
        this.f12934c = eVar;
        this.f12935d = new ha.e(eVar, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = this.f12934c;
        if (eVar == null) {
            C(2);
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    public ha.g getValue() {
        ha.e eVar = this.f12935d;
        if (eVar == null) {
            C(1);
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        return "class " + this.f12934c.getName() + "::this";
    }
}
