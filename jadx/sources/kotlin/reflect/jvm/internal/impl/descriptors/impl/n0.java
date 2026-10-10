package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class n0 extends m0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f12881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f12882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected c9.a<ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> f12883h;

    private static /* synthetic */ void C(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1) {
            objArr[0] = "annotations";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = "source";
        } else if (i10 == 4 || i10 == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i10 == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i10 != 5) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, ba.f fVar, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, boolean z10, a1 a1Var) {
        super(mVar, gVar, fVar, g0Var, a1Var);
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
        this.f12881f = z10;
    }

    public void G0(ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> jVar, c9.a<ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> aVar) {
        if (aVar == null) {
            C(5);
        }
        this.f12883h = aVar;
        if (jVar == null) {
            jVar = aVar.invoke();
        }
        this.f12882g = jVar;
    }

    public void H0(c9.a<ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> aVar) {
        if (aVar == null) {
            C(4);
        }
        G0(null, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k1
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> S() {
        ka.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> jVar = this.f12882g;
        if (jVar != null) {
            return jVar.invoke();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k1
    public boolean f0() {
        return this.f12881f;
    }
}
