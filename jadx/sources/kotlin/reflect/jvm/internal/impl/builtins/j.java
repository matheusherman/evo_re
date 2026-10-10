package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0 f12490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r8.i f12491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f12492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f12493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f12494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f12495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f12496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f12497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a f12498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f12499j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f12489l = {c0.g(new w(c0.b(j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), c0.g(new w(c0.b(j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), c0.g(new w(c0.b(j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), c0.g(new w(c0.b(j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), c0.g(new w(c0.b(j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), c0.g(new w(c0.b(j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), c0.g(new w(c0.b(j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), c0.g(new w(c0.b(j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f12488k = new b(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12500a;

        public final kotlin.reflect.jvm.internal.impl.descriptors.e a(j types, i9.k<?> property) {
            kotlin.jvm.internal.m.f(types, "types");
            kotlin.jvm.internal.m.f(property, "property");
            return types.b(qa.a.a(property.getName()), this.f12500a);
        }

        public a(int i10) {
            this.f12500a = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }

        public final g0 a(h0 module) {
            kotlin.jvm.internal.m.f(module, "module");
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = x.a(module, k.a.f12637t0);
            if (eVarA == null) {
                return null;
            }
            c1 c1VarH = c1.f14231b.h();
            List<f1> parameters = eVarA.h().getParameters();
            kotlin.jvm.internal.m.e(parameters, "kPropertyClass.typeConstructor.parameters");
            Object objF0 = r.F0(parameters);
            kotlin.jvm.internal.m.e(objF0, "kPropertyClass.typeConstructor.parameters.single()");
            return kotlin.reflect.jvm.internal.impl.types.h0.g(c1VarH, eVarA, r.e(new u0((f1) objF0)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
        final /* synthetic */ h0 $module;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(h0 h0Var) {
            super(0);
            this.$module = h0Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
            return this.$module.U(k.f12590s).n();
        }
    }

    public j(h0 module, k0 notFoundClasses) {
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        this.f12490a = notFoundClasses;
        this.f12491b = r8.j.b(r8.m.PUBLICATION, new c(module));
        this.f12492c = new a(1);
        this.f12493d = new a(1);
        this.f12494e = new a(1);
        this.f12495f = new a(2);
        this.f12496g = new a(3);
        this.f12497h = new a(1);
        this.f12498i = new a(2);
        this.f12499j = new a(3);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h d() {
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h) this.f12491b.getValue();
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e c() {
        return this.f12492c.a(this, f12489l[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e b(String str, int i10) {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar;
        ba.f fVarL = ba.f.l(str);
        kotlin.jvm.internal.m.e(fVarL, "identifier(className)");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarE = d().e(fVarL, r9.d.FROM_REFLECTION);
        if (hVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarE;
        } else {
            eVar = null;
        }
        if (eVar == null) {
            return this.f12490a.d(new ba.b(k.f12590s, fVarL), r.e(Integer.valueOf(i10)));
        }
        return eVar;
    }
}
