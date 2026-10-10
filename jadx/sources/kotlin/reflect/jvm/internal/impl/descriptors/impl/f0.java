package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f0 extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.m f12835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ha.g f12836d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, ha.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        this(mVar, gVar, gVar2, ba.h.f950i);
        if (mVar == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (gVar2 == null) {
            C(2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, ha.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2, ba.f fVar) {
        super(gVar2, fVar);
        if (mVar == null) {
            C(3);
        }
        if (gVar == null) {
            C(4);
        }
        if (gVar2 == null) {
            C(5);
        }
        if (fVar == null) {
            C(6);
        }
        this.f12835c = mVar;
        this.f12836d = gVar;
    }

    private static /* synthetic */ void C(int i10) {
        String str = (i10 == 7 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 7 || i10 == 8) ? 2 : 3];
        switch (i10) {
            case 1:
            case 4:
                objArr[0] = "value";
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = "name";
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i10 == 7) {
            objArr[1] = "getValue";
        } else if (i10 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i10) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = "copy";
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 7 && i10 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar = this.f12835c;
        if (mVar == null) {
            C(8);
        }
        return mVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    public ha.g getValue() {
        ha.g gVar = this.f12836d;
        if (gVar == null) {
            C(7);
        }
        return gVar;
    }
}
