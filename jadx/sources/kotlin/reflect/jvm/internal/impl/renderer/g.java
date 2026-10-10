package kotlin.reflect.jvm.internal.impl.renderer;

import e9.ObservableProperty;
import java.lang.reflect.Field;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g implements f {
    static final /* synthetic */ i9.k<Object>[] X = {c0.e(new q(c0.b(g.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), c0.e(new q(c0.b(g.class), "withDefinedIn", "getWithDefinedIn()Z")), c0.e(new q(c0.b(g.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), c0.e(new q(c0.b(g.class), "modifiers", "getModifiers()Ljava/util/Set;")), c0.e(new q(c0.b(g.class), "startFromName", "getStartFromName()Z")), c0.e(new q(c0.b(g.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), c0.e(new q(c0.b(g.class), "debugMode", "getDebugMode()Z")), c0.e(new q(c0.b(g.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), c0.e(new q(c0.b(g.class), "verbose", "getVerbose()Z")), c0.e(new q(c0.b(g.class), "unitReturnType", "getUnitReturnType()Z")), c0.e(new q(c0.b(g.class), "withoutReturnType", "getWithoutReturnType()Z")), c0.e(new q(c0.b(g.class), "enhancedTypes", "getEnhancedTypes()Z")), c0.e(new q(c0.b(g.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), c0.e(new q(c0.b(g.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), c0.e(new q(c0.b(g.class), "renderDefaultModality", "getRenderDefaultModality()Z")), c0.e(new q(c0.b(g.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), c0.e(new q(c0.b(g.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), c0.e(new q(c0.b(g.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), c0.e(new q(c0.b(g.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), c0.e(new q(c0.b(g.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), c0.e(new q(c0.b(g.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), c0.e(new q(c0.b(g.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), c0.e(new q(c0.b(g.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), c0.e(new q(c0.b(g.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), c0.e(new q(c0.b(g.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), c0.e(new q(c0.b(g.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), c0.e(new q(c0.b(g.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), c0.e(new q(c0.b(g.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), c0.e(new q(c0.b(g.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), c0.e(new q(c0.b(g.class), "receiverAfterName", "getReceiverAfterName()Z")), c0.e(new q(c0.b(g.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), c0.e(new q(c0.b(g.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), c0.e(new q(c0.b(g.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), c0.e(new q(c0.b(g.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), c0.e(new q(c0.b(g.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), c0.e(new q(c0.b(g.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), c0.e(new q(c0.b(g.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), c0.e(new q(c0.b(g.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), c0.e(new q(c0.b(g.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), c0.e(new q(c0.b(g.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), c0.e(new q(c0.b(g.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), c0.e(new q(c0.b(g.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), c0.e(new q(c0.b(g.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), c0.e(new q(c0.b(g.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), c0.e(new q(c0.b(g.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), c0.e(new q(c0.b(g.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), c0.e(new q(c0.b(g.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), c0.e(new q(c0.b(g.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    private final e9.d A;
    private final e9.d B;
    private final e9.d C;
    private final e9.d D;
    private final e9.d E;
    private final e9.d F;
    private final e9.d G;
    private final e9.d H;
    private final e9.d I;
    private final e9.d J;
    private final e9.d K;
    private final e9.d L;
    private final e9.d M;
    private final e9.d N;
    private final e9.d O;
    private final e9.d P;
    private final e9.d Q;
    private final e9.d R;
    private final e9.d S;
    private final e9.d T;
    private final e9.d U;
    private final e9.d V;
    private final e9.d W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e9.d f13835b = m0(kotlin.reflect.jvm.internal.impl.renderer.b.c.f13783a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e9.d f13836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e9.d f13837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e9.d f13838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e9.d f13839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e9.d f13840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e9.d f13841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e9.d f13842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e9.d f13843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final e9.d f13844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final e9.d f13845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final e9.d f13846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final e9.d f13847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final e9.d f13848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final e9.d f13849p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final e9.d f13850q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final e9.d f13851r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final e9.d f13852s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final e9.d f13853t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final e9.d f13854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final e9.d f13855v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final e9.d f13856w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final e9.d f13857x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final e9.d f13858y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final e9.d f13859z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.l<j1, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13860a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(j1 it) {
            kotlin.jvm.internal.m.f(it, "it");
            return "...";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b<T> extends ObservableProperty<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f13861b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, g gVar) {
            super(obj);
            this.f13861b = gVar;
        }

        @Override // e9.ObservableProperty
        protected boolean b(i9.k<?> property, T t10, T t11) {
            kotlin.jvm.internal.m.f(property, "property");
            if (this.f13861b.k0()) {
                throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.l<g0, g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13862a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(g0 it) {
            kotlin.jvm.internal.m.f(it, "it");
            return it;
        }
    }

    public final void l0() {
        this.f13834a = true;
    }

    private final <T> e9.d<g, T> m0(T t10) {
        e9.a aVar = e9.a.f9906a;
        return new b(t10, this);
    }

    public boolean A() {
        return ((Boolean) this.R.getValue(this, X[42])).booleanValue();
    }

    public boolean D() {
        return ((Boolean) this.f13854u.getValue(this, X[19])).booleanValue();
    }

    public boolean E() {
        return ((Boolean) this.W.getValue(this, X[47])).booleanValue();
    }

    public Set<e> F() {
        return (Set) this.f13838e.getValue(this, X[3]);
    }

    public boolean G() {
        return ((Boolean) this.f13847n.getValue(this, X[12])).booleanValue();
    }

    public j H() {
        return (j) this.A.getValue(this, X[25]);
    }

    public k I() {
        return (k) this.D.getValue(this, X[28]);
    }

    public boolean J() {
        return ((Boolean) this.S.getValue(this, X[43])).booleanValue();
    }

    public boolean K() {
        return ((Boolean) this.U.getValue(this, X[45])).booleanValue();
    }

    public l L() {
        return (l) this.G.getValue(this, X[31]);
    }

    public boolean M() {
        return ((Boolean) this.E.getValue(this, X[29])).booleanValue();
    }

    public boolean N() {
        return ((Boolean) this.F.getValue(this, X[30])).booleanValue();
    }

    public boolean O() {
        return ((Boolean) this.f13850q.getValue(this, X[15])).booleanValue();
    }

    public boolean P() {
        return ((Boolean) this.O.getValue(this, X[39])).booleanValue();
    }

    public boolean Q() {
        return ((Boolean) this.H.getValue(this, X[32])).booleanValue();
    }

    public boolean R() {
        return ((Boolean) this.f13849p.getValue(this, X[14])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.f13848o.getValue(this, X[13])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.f13851r.getValue(this, X[16])).booleanValue();
    }

    public boolean U() {
        return ((Boolean) this.Q.getValue(this, X[41])).booleanValue();
    }

    public boolean V() {
        return ((Boolean) this.P.getValue(this, X[40])).booleanValue();
    }

    public boolean W() {
        return ((Boolean) this.f13859z.getValue(this, X[24])).booleanValue();
    }

    public boolean X() {
        return ((Boolean) this.f13840g.getValue(this, X[5])).booleanValue();
    }

    public boolean Y() {
        return ((Boolean) this.f13839f.getValue(this, X[4])).booleanValue();
    }

    public m Z() {
        return (m) this.C.getValue(this, X[27]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void a(Set<ba.c> set) {
        kotlin.jvm.internal.m.f(set, "<set-?>");
        this.K.setValue(this, X[35], set);
    }

    public c9.l<g0, g0> a0() {
        return (c9.l) this.f13857x.getValue(this, X[22]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void b(boolean z10) {
        this.f13839f.setValue(this, X[4], Boolean.valueOf(z10));
    }

    public boolean b0() {
        return ((Boolean) this.f13853t.getValue(this, X[18])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void c(Set<? extends e> set) {
        kotlin.jvm.internal.m.f(set, "<set-?>");
        this.f13838e.setValue(this, X[3], set);
    }

    public boolean c0() {
        return ((Boolean) this.f13844k.getValue(this, X[9])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void d(k kVar) {
        kotlin.jvm.internal.m.f(kVar, "<set-?>");
        this.D.setValue(this, X[28], kVar);
    }

    public kotlin.reflect.jvm.internal.impl.renderer.c.l d0() {
        return (kotlin.reflect.jvm.internal.impl.renderer.c.l) this.B.getValue(this, X[26]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void e(boolean z10) {
        this.f13836c.setValue(this, X[1], Boolean.valueOf(z10));
    }

    public boolean e0() {
        return ((Boolean) this.f13843j.getValue(this, X[8])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public boolean f() {
        return ((Boolean) this.f13846m.getValue(this, X[11])).booleanValue();
    }

    public boolean f0() {
        return ((Boolean) this.f13836c.getValue(this, X[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void g(kotlin.reflect.jvm.internal.impl.renderer.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "<set-?>");
        this.f13835b.setValue(this, X[0], bVar);
    }

    public boolean g0() {
        return ((Boolean) this.f13837d.getValue(this, X[2])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void h(boolean z10) {
        this.f13856w.setValue(this, X[21], Boolean.valueOf(z10));
    }

    public boolean h0() {
        return ((Boolean) this.f13845l.getValue(this, X[10])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void i(boolean z10) {
        this.f13841h.setValue(this, X[6], Boolean.valueOf(z10));
    }

    public boolean i0() {
        return ((Boolean) this.f13856w.getValue(this, X[21])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void j(boolean z10) {
        this.F.setValue(this, X[30], Boolean.valueOf(z10));
    }

    public boolean j0() {
        return ((Boolean) this.f13855v.getValue(this, X[20])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void k(boolean z10) {
        this.E.setValue(this, X[29], Boolean.valueOf(z10));
    }

    public final boolean k0() {
        return this.f13834a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void l(m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<set-?>");
        this.C.setValue(this, X[27], mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public Set<ba.c> m() {
        return (Set) this.K.getValue(this, X[35]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public boolean n() {
        return ((Boolean) this.f13841h.getValue(this, X[6])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public kotlin.reflect.jvm.internal.impl.renderer.a o() {
        return (kotlin.reflect.jvm.internal.impl.renderer.a) this.M.getValue(this, X[37]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.f
    public void p(boolean z10) {
        this.f13855v.setValue(this, X[20], Boolean.valueOf(z10));
    }

    public final g q() {
        g gVar = new g();
        Field[] declaredFields = g.class.getDeclaredFields();
        kotlin.jvm.internal.m.e(declaredFields, "this::class.java.declaredFields");
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                ObservableProperty observableProperty = obj instanceof ObservableProperty ? (ObservableProperty) obj : null;
                if (observableProperty != null) {
                    String name = field.getName();
                    kotlin.jvm.internal.m.e(name, "field.name");
                    ua.n.I(name, "is", false, 2, null);
                    i9.d dVarB = c0.b(g.class);
                    String name2 = field.getName();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("get");
                    String name3 = field.getName();
                    kotlin.jvm.internal.m.e(name3, "field.name");
                    if (name3.length() > 0) {
                        char upperCase = Character.toUpperCase(name3.charAt(0));
                        String strSubstring = name3.substring(1);
                        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                        name3 = upperCase + strSubstring;
                    }
                    sb2.append(name3);
                    field.set(gVar, gVar.m0(observableProperty.getValue(this, new w(dVarB, name2, sb2.toString()))));
                }
            }
        }
        return gVar;
    }

    public boolean r() {
        return ((Boolean) this.f13852s.getValue(this, X[17])).booleanValue();
    }

    public boolean s() {
        return ((Boolean) this.N.getValue(this, X[38])).booleanValue();
    }

    public c9.l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> t() {
        return (c9.l) this.L.getValue(this, X[36]);
    }

    public boolean u() {
        return ((Boolean) this.V.getValue(this, X[46])).booleanValue();
    }

    public boolean v() {
        return ((Boolean) this.f13842i.getValue(this, X[7])).booleanValue();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.b w() {
        return (kotlin.reflect.jvm.internal.impl.renderer.b) this.f13835b.getValue(this, X[0]);
    }

    public c9.l<j1, String> x() {
        return (c9.l) this.f13858y.getValue(this, X[23]);
    }

    public boolean y() {
        return ((Boolean) this.I.getValue(this, X[33])).booleanValue();
    }

    public Set<ba.c> z() {
        return (Set) this.J.getValue(this, X[34]);
    }

    public g() {
        Boolean bool = Boolean.TRUE;
        this.f13836c = m0(bool);
        this.f13837d = m0(bool);
        this.f13838e = m0(e.f13817b);
        Boolean bool2 = Boolean.FALSE;
        this.f13839f = m0(bool2);
        this.f13840g = m0(bool2);
        this.f13841h = m0(bool2);
        this.f13842i = m0(bool2);
        this.f13843j = m0(bool2);
        this.f13844k = m0(bool);
        this.f13845l = m0(bool2);
        this.f13846m = m0(bool2);
        this.f13847n = m0(bool2);
        this.f13848o = m0(bool);
        this.f13849p = m0(bool);
        this.f13850q = m0(bool2);
        this.f13851r = m0(bool2);
        this.f13852s = m0(bool2);
        this.f13853t = m0(bool2);
        this.f13854u = m0(bool2);
        this.f13855v = m0(bool2);
        this.f13856w = m0(bool2);
        this.f13857x = m0(c.f13862a);
        this.f13858y = m0(a.f13860a);
        this.f13859z = m0(bool);
        this.A = m0(j.RENDER_OPEN);
        this.B = m0(kotlin.reflect.jvm.internal.impl.renderer.c.l.a.f13806a);
        this.C = m0(m.PLAIN);
        this.D = m0(k.ALL);
        this.E = m0(bool2);
        this.F = m0(bool2);
        this.G = m0(l.DEBUG);
        this.H = m0(bool2);
        this.I = m0(bool2);
        this.J = m0(v0.e());
        this.K = m0(h.f13863a.a());
        this.L = m0(null);
        this.M = m0(kotlin.reflect.jvm.internal.impl.renderer.a.NO_ARGUMENTS);
        this.N = m0(bool2);
        this.O = m0(bool);
        this.P = m0(bool);
        this.Q = m0(bool2);
        this.R = m0(bool);
        this.S = m0(bool);
        this.T = m0(bool2);
        this.U = m0(bool2);
        this.V = m0(bool2);
        this.W = m0(bool);
    }

    public boolean B() {
        return f.a.a(this);
    }

    public boolean C() {
        return f.a.b(this);
    }
}
