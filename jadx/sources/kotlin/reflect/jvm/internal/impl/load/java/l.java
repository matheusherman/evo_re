package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l implements kotlin.reflect.jvm.internal.impl.resolve.f {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13242a;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.resolve.k.i.a.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.resolve.k.i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f13242a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<j1, kotlin.reflect.jvm.internal.impl.types.g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13243a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.types.g0 invoke(j1 j1Var) {
            return j1Var.getType();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.f
    public kotlin.reflect.jvm.internal.impl.resolve.f.a a() {
        return kotlin.reflect.jvm.internal.impl.resolve.f.a.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.f
    public kotlin.reflect.jvm.internal.impl.resolve.f.b b(kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.m.f(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof s9.e) {
            s9.e eVar2 = (s9.e) subDescriptor;
            List<f1> typeParameters = eVar2.getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters, "subDescriptor.typeParameters");
            if (typeParameters.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.resolve.k.i iVarW = kotlin.reflect.jvm.internal.impl.resolve.k.w(superDescriptor, subDescriptor);
                if ((iVarW != null ? iVarW.c() : null) != null) {
                    return kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
                }
                List<j1> listF = eVar2.f();
                kotlin.jvm.internal.m.e(listF, "subDescriptor.valueParameters");
                ta.h hVarJ = ta.k.J(kotlin.collections.r.Z(listF), b.f13243a);
                kotlin.reflect.jvm.internal.impl.types.g0 returnType = eVar2.getReturnType();
                kotlin.jvm.internal.m.c(returnType);
                ta.h hVarM = ta.k.M(hVarJ, returnType);
                x0 x0VarI0 = eVar2.i0();
                for (kotlin.reflect.jvm.internal.impl.types.g0 g0Var : ta.k.L(hVarM, kotlin.collections.r.p(x0VarI0 != null ? x0VarI0.getType() : null))) {
                    if (!g0Var.H0().isEmpty() && !(g0Var.M0() instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.h)) {
                        return kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
                    }
                }
                kotlin.reflect.jvm.internal.impl.descriptors.a aVarC = superDescriptor.c(new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.g(null, 1, null).c());
                if (aVarC == null) {
                    return kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
                }
                if (aVarC instanceof z0) {
                    z0 z0Var = (z0) aVarC;
                    List<f1> typeParameters2 = z0Var.getTypeParameters();
                    kotlin.jvm.internal.m.e(typeParameters2, "erasedSuper.typeParameters");
                    if (!typeParameters2.isEmpty()) {
                        aVarC = z0Var.q().l(kotlin.collections.r.l()).build();
                        kotlin.jvm.internal.m.c(aVarC);
                    }
                }
                kotlin.reflect.jvm.internal.impl.resolve.k.i.a aVarC2 = kotlin.reflect.jvm.internal.impl.resolve.k.f13933f.F(aVarC, subDescriptor, false).c();
                kotlin.jvm.internal.m.e(aVarC2, "DEFAULT.isOverridableByW…Descriptor, false).result");
                return a.f13242a[aVarC2.ordinal()] == 1 ? kotlin.reflect.jvm.internal.impl.resolve.f.b.OVERRIDABLE : kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
            }
        }
        return kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
    }
}
