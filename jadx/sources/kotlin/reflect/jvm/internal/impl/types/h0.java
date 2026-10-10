package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f14313a = new h0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> f14314b = a.f14315a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14315a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            kotlin.jvm.internal.m.f(gVar, "<anonymous parameter 0>");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o0 f14316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g1 f14317b;

        public final o0 a() {
            return this.f14316a;
        }

        public final g1 b() {
            return this.f14317b;
        }

        public b(o0 o0Var, g1 g1Var) {
            this.f14316a = o0Var;
            this.f14317b = g1Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> {
        final /* synthetic */ List<k1> $arguments;
        final /* synthetic */ c1 $attributes;
        final /* synthetic */ g1 $constructor;
        final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(g1 g1Var, List<? extends k1> list, c1 c1Var, boolean z10) {
            super(1);
            this.$constructor = g1Var;
            this.$arguments = list;
            this.$attributes = c1Var;
            this.$nullable = z10;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g refiner) {
            kotlin.jvm.internal.m.f(refiner, "refiner");
            b bVarF = h0.f14313a.f(this.$constructor, refiner, this.$arguments);
            if (bVarF == null) {
                return null;
            }
            o0 o0VarA = bVarF.a();
            if (o0VarA != null) {
                return o0VarA;
            }
            c1 c1Var = this.$attributes;
            g1 g1VarB = bVarF.b();
            kotlin.jvm.internal.m.c(g1VarB);
            return h0.i(c1Var, g1VarB, this.$arguments, this.$nullable, refiner);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> {
        final /* synthetic */ List<k1> $arguments;
        final /* synthetic */ c1 $attributes;
        final /* synthetic */ g1 $constructor;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.scopes.h $memberScope;
        final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(g1 g1Var, List<? extends k1> list, c1 c1Var, boolean z10, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar) {
            super(1);
            this.$constructor = g1Var;
            this.$arguments = list;
            this.$attributes = c1Var;
            this.$nullable = z10;
            this.$memberScope = hVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            b bVarF = h0.f14313a.f(this.$constructor, kotlinTypeRefiner, this.$arguments);
            if (bVarF == null) {
                return null;
            }
            o0 o0VarA = bVarF.a();
            if (o0VarA != null) {
                return o0VarA;
            }
            c1 c1Var = this.$attributes;
            g1 g1VarB = bVarF.b();
            kotlin.jvm.internal.m.c(g1VarB);
            return h0.k(c1Var, g1VarB, this.$arguments, this.$nullable, this.$memberScope);
        }
    }

    public static final o0 b(kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, List<? extends k1> arguments) {
        kotlin.jvm.internal.m.f(e1Var, "<this>");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        return new x0(z0.a.f14399a, false).i(y0.f14394e.a(null, e1Var, arguments), c1.f14231b.h());
    }

    public static final v1 d(o0 lowerBound, o0 upperBound) {
        kotlin.jvm.internal.m.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.m.f(upperBound, "upperBound");
        return kotlin.jvm.internal.m.a(lowerBound, upperBound) ? lowerBound : new b0(lowerBound, upperBound);
    }

    public static final o0 e(c1 attributes, kotlin.reflect.jvm.internal.impl.resolve.constants.n constructor, boolean z10) {
        kotlin.jvm.internal.m.f(attributes, "attributes");
        kotlin.jvm.internal.m.f(constructor, "constructor");
        return k(attributes, constructor, kotlin.collections.r.l(), z10, la.k.a(la.g.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }

    public static final o0 g(c1 attributes, kotlin.reflect.jvm.internal.impl.descriptors.e descriptor, List<? extends k1> arguments) {
        kotlin.jvm.internal.m.f(attributes, "attributes");
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        g1 g1VarH = descriptor.h();
        kotlin.jvm.internal.m.e(g1VarH, "descriptor.typeConstructor");
        return j(attributes, g1VarH, arguments, false, null, 16, null);
    }

    public static final o0 h(c1 attributes, g1 constructor, List<? extends k1> arguments, boolean z10) {
        kotlin.jvm.internal.m.f(attributes, "attributes");
        kotlin.jvm.internal.m.f(constructor, "constructor");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        return j(attributes, constructor, arguments, z10, null, 16, null);
    }

    public static final o0 i(c1 attributes, g1 constructor, List<? extends k1> arguments, boolean z10, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        kotlin.jvm.internal.m.f(attributes, "attributes");
        kotlin.jvm.internal.m.f(constructor, "constructor");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        if (!attributes.isEmpty() || !arguments.isEmpty() || z10 || constructor.d() == null) {
            return l(attributes, constructor, arguments, z10, f14313a.c(constructor, arguments, gVar), new c(constructor, arguments, attributes, z10));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = constructor.d();
        kotlin.jvm.internal.m.c(hVarD);
        o0 o0VarP = hVarD.p();
        kotlin.jvm.internal.m.e(o0VarP, "constructor.declarationDescriptor!!.defaultType");
        return o0VarP;
    }

    public static /* synthetic */ o0 j(c1 c1Var, g1 g1Var, List list, boolean z10, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            gVar = null;
        }
        return i(c1Var, g1Var, list, z10, gVar);
    }

    public static final o0 k(c1 attributes, g1 constructor, List<? extends k1> arguments, boolean z10, kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope) {
        kotlin.jvm.internal.m.f(attributes, "attributes");
        kotlin.jvm.internal.m.f(constructor, "constructor");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        kotlin.jvm.internal.m.f(memberScope, "memberScope");
        p0 p0Var = new p0(constructor, arguments, z10, memberScope, new d(constructor, arguments, attributes, z10, memberScope));
        return attributes.isEmpty() ? p0Var : new q0(p0Var, attributes);
    }

    public static final o0 l(c1 attributes, g1 constructor, List<? extends k1> arguments, boolean z10, kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope, c9.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends o0> refinedTypeFactory) {
        kotlin.jvm.internal.m.f(attributes, "attributes");
        kotlin.jvm.internal.m.f(constructor, "constructor");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        kotlin.jvm.internal.m.f(memberScope, "memberScope");
        kotlin.jvm.internal.m.f(refinedTypeFactory, "refinedTypeFactory");
        p0 p0Var = new p0(constructor, arguments, z10, memberScope, refinedTypeFactory);
        return attributes.isEmpty() ? p0Var : new q0(p0Var, attributes);
    }

    private h0() {
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h c(g1 g1Var, List<? extends k1> list, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g1Var.d();
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.f1) hVarD).p().n();
        }
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            if (gVar == null) {
                gVar = ea.c.o(ea.c.p(hVarD));
            }
            if (list.isEmpty()) {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.u.b((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD, gVar);
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.impl.u.a((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD, h1.f14318c.b(g1Var, list), gVar);
        }
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e1) {
            la.g gVar2 = la.g.SCOPE_FOR_ABBREVIATION_TYPE;
            String string = ((kotlin.reflect.jvm.internal.impl.descriptors.e1) hVarD).getName().toString();
            kotlin.jvm.internal.m.e(string, "descriptor.name.toString()");
            return la.k.a(gVar2, true, string);
        }
        if (g1Var instanceof f0) {
            return ((f0) g1Var).g();
        }
        throw new IllegalStateException("Unsupported classifier: " + hVarD + " for constructor: " + g1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b f(g1 g1Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, List<? extends k1> list) {
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarF;
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g1Var.d();
        if (hVarD == null || (hVarF = gVar.f(hVarD)) == null) {
            return null;
        }
        if (hVarF instanceof kotlin.reflect.jvm.internal.impl.descriptors.e1) {
            return new b(b((kotlin.reflect.jvm.internal.impl.descriptors.e1) hVarF, list), null);
        }
        g1 g1VarC = hVarF.h().c(gVar);
        kotlin.jvm.internal.m.e(g1VarC, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new b(null, g1VarC);
    }
}
