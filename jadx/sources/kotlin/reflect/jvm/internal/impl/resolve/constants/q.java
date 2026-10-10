package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class q extends g<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13915b = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final g<?> a(g0 argumentType) {
            kotlin.jvm.internal.m.f(argumentType, "argumentType");
            if (i0.a(argumentType)) {
                return null;
            }
            g0 type = argumentType;
            int i10 = 0;
            while (kotlin.reflect.jvm.internal.impl.builtins.h.c0(type)) {
                type = ((k1) kotlin.collections.r.F0(type.H0())).getType();
                kotlin.jvm.internal.m.e(type, "type.arguments.single().type");
                i10++;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = type.J0().d();
            if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                ba.b bVarK = ea.c.k(hVarD);
                return bVarK == null ? new q(new b.a(argumentType)) : new q(bVarK, i10);
            }
            if (!(hVarD instanceof f1)) {
                return null;
            }
            ba.b bVarM = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.f12600b.l());
            kotlin.jvm.internal.m.e(bVarM, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new q(bVarM, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class b {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final g0 f13916a;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.m.a(this.f13916a, ((a) obj).f13916a);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g0 type) {
                super(null);
                kotlin.jvm.internal.m.f(type, "type");
                this.f13916a = type;
            }

            public final g0 a() {
                return this.f13916a;
            }

            public int hashCode() {
                return this.f13916a.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.f13916a + ')';
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.constants.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0254b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final f f13917a;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0254b) && kotlin.jvm.internal.m.a(this.f13917a, ((C0254b) obj).f13917a);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0254b(f value) {
                super(null);
                kotlin.jvm.internal.m.f(value, "value");
                this.f13917a = value;
            }

            public final int a() {
                return this.f13917a.c();
            }

            public final ba.b b() {
                return this.f13917a.d();
            }

            public final f c() {
                return this.f13917a;
            }

            public int hashCode() {
                return this.f13917a.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.f13917a + ')';
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(b value) {
        super(value);
        kotlin.jvm.internal.m.f(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(f value) {
        this(new b.C0254b(value));
        kotlin.jvm.internal.m.f(value, "value");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    public g0 a(h0 module) {
        kotlin.jvm.internal.m.f(module, "module");
        c1 c1VarH = c1.f14231b.h();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarE = module.l().E();
        kotlin.jvm.internal.m.e(eVarE, "module.builtIns.kClass");
        return kotlin.reflect.jvm.internal.impl.types.h0.g(c1VarH, eVarE, kotlin.collections.r.e(new m1(c(module))));
    }

    public final g0 c(h0 module) {
        kotlin.jvm.internal.m.f(module, "module");
        b bVarB = b();
        if (bVarB instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (!(bVarB instanceof b.C0254b)) {
            throw new r8.n();
        }
        f fVarC = ((b.C0254b) b()).c();
        ba.b bVarA = fVarC.a();
        int iB = fVarC.b();
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = kotlin.reflect.jvm.internal.impl.descriptors.x.a(module, bVarA);
        if (eVarA == null) {
            la.j jVar = la.j.f15301f;
            String string = bVarA.toString();
            kotlin.jvm.internal.m.e(string, "classId.toString()");
            return la.k.d(jVar, string, String.valueOf(iB));
        }
        o0 o0VarP = eVarA.p();
        kotlin.jvm.internal.m.e(o0VarP, "descriptor.defaultType");
        g0 g0VarY = oa.a.y(o0VarP);
        for (int i10 = 0; i10 < iB; i10++) {
            g0VarY = module.l().l(w1.INVARIANT, g0VarY);
            kotlin.jvm.internal.m.e(g0VarY, "module.builtIns.getArray…Variance.INVARIANT, type)");
        }
        return g0VarY;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(ba.b classId, int i10) {
        this(new f(classId, i10));
        kotlin.jvm.internal.m.f(classId, "classId");
    }
}
