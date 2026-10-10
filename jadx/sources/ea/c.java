package ea;

import ba.d;
import ba.f;
import c9.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.r;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.checker.p;
import kotlin.reflect.jvm.internal.impl.types.checker.x;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import ta.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f9910a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class a extends j implements l<j1, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9911a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return c0.b(j1.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(j1 p10) {
            m.f(p10, "p0");
            return Boolean.valueOf(p10.q0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends sa.b.AbstractC0358b<kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0<kotlin.reflect.jvm.internal.impl.descriptors.b> f9912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> f9913b;

        /* JADX WARN: Multi-variable type inference failed */
        b(b0<kotlin.reflect.jvm.internal.impl.descriptors.b> b0Var, l<? super kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> lVar) {
            this.f9912a = b0Var;
            this.f9913b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sa.b.AbstractC0358b, sa.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(kotlin.reflect.jvm.internal.impl.descriptors.b current) {
            m.f(current, "current");
            if (this.f9912a.element == null && this.f9913b.invoke(current).booleanValue()) {
                this.f9912a.element = current;
            }
        }

        @Override // sa.b.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(kotlin.reflect.jvm.internal.impl.descriptors.b current) {
            m.f(current, "current");
            return this.f9912a.element == null;
        }

        @Override // sa.b.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.b a() {
            return this.f9912a.element;
        }
    }

    /* JADX INFO: renamed from: ea.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0176c extends o implements l<kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0176c f9914a = new C0176c();

        C0176c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.m invoke(kotlin.reflect.jvm.internal.impl.descriptors.m it) {
            m.f(it, "it");
            return it.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable g(boolean z10, kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        if (z10) {
            bVar = bVar != null ? bVar.a() : null;
        }
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collectionE = bVar != null ? bVar.e() : null;
        return collectionE == null ? r.l() : collectionE;
    }

    public static final ba.b k(h hVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB;
        ba.b bVarK;
        if (hVar != null && (mVarB = hVar.b()) != null) {
            if (mVarB instanceof l0) {
                return new ba.b(((l0) mVarB).d(), hVar.getName());
            }
            if ((mVarB instanceof i) && (bVarK = k((h) mVarB)) != null) {
                return bVarK.d(hVar.getName());
            }
        }
        return null;
    }

    public static final z<o0> n(e eVar) {
        h1<o0> h1VarV0 = eVar != null ? eVar.v0() : null;
        if (h1VarV0 instanceof z) {
            return (z) h1VarV0;
        }
        return null;
    }

    static {
        f fVarL = f.l("value");
        m.e(fVarL, "identifier(\"value\")");
        f9910a = fVarL;
    }

    public static final boolean c(j1 j1Var) {
        m.f(j1Var, "<this>");
        Boolean boolE = sa.b.e(r.e(j1Var), ea.a.f9908a, a.f9911a);
        m.e(boolE, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return boolE.booleanValue();
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.b e(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, boolean z10, l<? super kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> predicate) {
        m.f(bVar, "<this>");
        m.f(predicate, "predicate");
        return (kotlin.reflect.jvm.internal.impl.descriptors.b) sa.b.b(r.e(bVar), new ea.b(z10), new b(new b0(), predicate));
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.b f(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return e(bVar, z10, lVar);
    }

    public static final ba.c h(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        d dVarM = m(mVar);
        if (!dVarM.f()) {
            dVarM = null;
        }
        if (dVarM != null) {
            return dVarM.l();
        }
        return null;
    }

    public static final e i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        m.f(cVar, "<this>");
        h hVarD = cVar.getType().J0().d();
        if (hVarD instanceof e) {
            return (e) hVarD;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.h j(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return p(mVar).l();
    }

    public static final ba.c l(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        ba.c cVarN = kotlin.reflect.jvm.internal.impl.resolve.e.n(mVar);
        m.e(cVarN, "getFqNameSafe(this)");
        return cVarN;
    }

    public static final d m(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        d dVarM = kotlin.reflect.jvm.internal.impl.resolve.e.m(mVar);
        m.e(dVarM, "getFqName(this)");
        return dVarM;
    }

    public static final g o(h0 h0Var) {
        m.f(h0Var, "<this>");
        p pVar = (p) h0Var.D0(kotlin.reflect.jvm.internal.impl.types.checker.h.a());
        x xVar = pVar != null ? (x) pVar.a() : null;
        return xVar instanceof x.a ? ((x.a) xVar).b() : g.a.f14237a;
    }

    public static final h0 p(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        h0 h0VarG = kotlin.reflect.jvm.internal.impl.resolve.e.g(mVar);
        m.e(h0VarG, "getContainingModule(this)");
        return h0VarG;
    }

    public static final ta.h<kotlin.reflect.jvm.internal.impl.descriptors.m> q(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return k.x(r(mVar), 1);
    }

    public static final ta.h<kotlin.reflect.jvm.internal.impl.descriptors.m> r(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return k.o(mVar, C0176c.f9914a);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.b s(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        m.f(bVar, "<this>");
        if (!(bVar instanceof t0)) {
            return bVar;
        }
        u0 correspondingProperty = ((t0) bVar).x0();
        m.e(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    public static final e t(e eVar) {
        m.f(eVar, "<this>");
        for (g0 g0Var : eVar.p().J0().b()) {
            if (!kotlin.reflect.jvm.internal.impl.builtins.h.b0(g0Var)) {
                h hVarD = g0Var.J0().d();
                if (kotlin.reflect.jvm.internal.impl.resolve.e.w(hVarD)) {
                    m.d(hVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (e) hVarD;
                }
            }
        }
        return null;
    }

    public static final boolean u(h0 h0Var) {
        x xVar;
        m.f(h0Var, "<this>");
        p pVar = (p) h0Var.D0(kotlin.reflect.jvm.internal.impl.types.checker.h.a());
        return (pVar == null || (xVar = (x) pVar.a()) == null || !xVar.a()) ? false : true;
    }

    public static final e v(h0 h0Var, ba.c topLevelClassFqName, r9.b location) {
        m.f(h0Var, "<this>");
        m.f(topLevelClassFqName, "topLevelClassFqName");
        m.f(location, "location");
        topLevelClassFqName.d();
        ba.c cVarE = topLevelClassFqName.e();
        m.e(cVarE, "topLevelClassFqName.parent()");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = h0Var.U(cVarE).n();
        f fVarG = topLevelClassFqName.g();
        m.e(fVarG, "topLevelClassFqName.shortName()");
        h hVarE = hVarN.e(fVarG, location);
        if (hVarE instanceof e) {
            return (e) hVarE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable d(j1 j1Var) {
        Collection<j1> collectionE = j1Var.e();
        ArrayList arrayList = new ArrayList(r.w(collectionE, 10));
        Iterator<T> it = collectionE.iterator();
        while (it.hasNext()) {
            arrayList.add(((j1) it.next()).a());
        }
        return arrayList;
    }
}
