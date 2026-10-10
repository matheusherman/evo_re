package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import androidx.view.k;
import c9.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.r1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x;
import la.j;
import r8.p;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g extends n1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13404e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f13405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a f13406g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f13407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j1 f13408d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a $attr;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e $declaration;
        final /* synthetic */ o0 $type;
        final /* synthetic */ g this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, g gVar, o0 o0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
            super(1);
            this.$declaration = eVar;
            this.this$0 = gVar;
            this.$type = o0Var;
            this.$attr = aVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            ba.b bVarK;
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarB;
            m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar = this.$declaration;
            if (!k.a(eVar)) {
                eVar = null;
            }
            if (eVar == null || (bVarK = ea.c.k(eVar)) == null || (eVarB = kotlinTypeRefiner.b(bVarK)) == null || m.a(eVarB, this.$declaration)) {
                return null;
            }
            return (o0) this.this$0.j(this.$type, eVarB, this.$attr).c();
        }
    }

    public g(j1 j1Var) {
        f fVar = new f();
        this.f13407c = fVar;
        this.f13408d = j1Var == null ? new j1(fVar, null, 2, null) : j1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public boolean f() {
        return false;
    }

    static {
        r1 r1Var = r1.COMMON;
        f13405f = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1Var, false, true, null, 5, null).l(c.FLEXIBLE_LOWER_BOUND);
        f13406g = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r1Var, false, true, null, 5, null).l(c.FLEXIBLE_UPPER_BOUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p<o0, Boolean> j(o0 o0Var, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        if (o0Var.J0().getParameters().isEmpty()) {
            return v.a(o0Var, Boolean.FALSE);
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.h.c0(o0Var)) {
            k1 k1Var = o0Var.H0().get(0);
            w1 w1VarA = k1Var.a();
            g0 type = k1Var.getType();
            m.e(type, "componentTypeProjection.type");
            return v.a(h0.j(o0Var.I0(), o0Var.J0(), r.e(new m1(w1VarA, k(type, aVar))), o0Var.K0(), null, 16, null), Boolean.FALSE);
        }
        if (i0.a(o0Var)) {
            return v.a(la.k.d(j.I, o0Var.J0().toString()), Boolean.FALSE);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarW = eVar.W(this);
        m.e(hVarW, "declaration.getMemberScope(this)");
        c1 c1VarI0 = o0Var.I0();
        g1 g1VarH = eVar.h();
        m.e(g1VarH, "declaration.typeConstructor");
        List<f1> parameters = eVar.h().getParameters();
        m.e(parameters, "declaration.typeConstructor.parameters");
        List<f1> list = parameters;
        ArrayList arrayList = new ArrayList(r.w(list, 10));
        for (f1 parameter : list) {
            f fVar = this.f13407c;
            m.e(parameter, "parameter");
            arrayList.add(x.b(fVar, parameter, aVar, this.f13408d, null, 8, null));
        }
        return v.a(h0.l(c1VarI0, g1VarH, arrayList, o0Var.K0(), hVarW, new b(eVar, this, o0Var, aVar)), Boolean.TRUE);
    }

    static /* synthetic */ g0 l(g gVar, g0 g0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a(r1.COMMON, null, false, false, null, null, 62, null);
        }
        return gVar.k(g0Var, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public m1 e(g0 key) {
        m.f(key, "key");
        return new m1(l(this, key, null, 2, null));
    }

    private final g0 k(g0 g0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        if (hVarD instanceof f1) {
            return k(this.f13408d.c((f1) hVarD, aVar.j(true)), aVar);
        }
        if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD2 = d0.d(g0Var).J0().d();
            if (hVarD2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                p<o0, Boolean> pVarJ = j(d0.c(g0Var), (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD, f13405f);
                o0 o0VarA = pVarJ.a();
                boolean zBooleanValue = pVarJ.b().booleanValue();
                p<o0, Boolean> pVarJ2 = j(d0.d(g0Var), (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD2, f13406g);
                o0 o0VarA2 = pVarJ2.a();
                boolean zBooleanValue2 = pVarJ2.b().booleanValue();
                if (!zBooleanValue && !zBooleanValue2) {
                    return h0.d(o0VarA, o0VarA2);
                }
                return new h(o0VarA, o0VarA2);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + hVarD2 + "\" while for lower it's \"" + hVarD + '\"').toString());
        }
        throw new IllegalStateException(("Unexpected declaration kind: " + hVarD).toString());
    }

    public /* synthetic */ g(j1 j1Var, int i10, kotlin.jvm.internal.g gVar) {
        this((i10 & 1) != 0 ? null : j1Var);
    }
}
