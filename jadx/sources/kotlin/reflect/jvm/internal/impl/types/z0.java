package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface z0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14399a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.types.z0
        public void a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotation) {
            kotlin.jvm.internal.m.f(annotation, "annotation");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.z0
        public void b(kotlin.reflect.jvm.internal.impl.descriptors.e1 typeAlias, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, g0 substitutedArgument) {
            kotlin.jvm.internal.m.f(typeAlias, "typeAlias");
            kotlin.jvm.internal.m.f(substitutedArgument, "substitutedArgument");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.z0
        public void c(p1 substitutor, g0 unsubstitutedArgument, g0 argument, kotlin.reflect.jvm.internal.impl.descriptors.f1 typeParameter) {
            kotlin.jvm.internal.m.f(substitutor, "substitutor");
            kotlin.jvm.internal.m.f(unsubstitutedArgument, "unsubstitutedArgument");
            kotlin.jvm.internal.m.f(argument, "argument");
            kotlin.jvm.internal.m.f(typeParameter, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.z0
        public void d(kotlin.reflect.jvm.internal.impl.descriptors.e1 typeAlias) {
            kotlin.jvm.internal.m.f(typeAlias, "typeAlias");
        }

        private a() {
        }
    }

    void a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar);

    void b(kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, g0 g0Var);

    void c(p1 p1Var, g0 g0Var, g0 g0Var2, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var);

    void d(kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var);
}
