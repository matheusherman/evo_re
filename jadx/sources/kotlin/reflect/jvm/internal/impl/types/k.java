package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f14335a = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.d(k.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e9.c f14336b;

    static {
        e9.c cVarC = c1.f14231b.c(kotlin.jvm.internal.c0.b(j.class));
        kotlin.jvm.internal.m.d(cVarC, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        f14336b = cVarC;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a(c1 c1Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVarE;
        kotlin.jvm.internal.m.f(c1Var, "<this>");
        j jVarB = b(c1Var);
        return (jVarB == null || (gVarE = jVarB.e()) == null) ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b() : gVarE;
    }

    public static final j b(c1 c1Var) {
        kotlin.jvm.internal.m.f(c1Var, "<this>");
        return (j) f14336b.getValue(c1Var, f14335a[0]);
    }
}
