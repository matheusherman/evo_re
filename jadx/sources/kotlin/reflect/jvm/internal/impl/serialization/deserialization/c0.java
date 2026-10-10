package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.b1;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.s0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.u0;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f14036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c0 f14037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c9.l<Integer, kotlin.reflect.jvm.internal.impl.descriptors.h> f14040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c9.l<Integer, kotlin.reflect.jvm.internal.impl.descriptors.h> f14041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Integer, f1> f14042g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<Integer, kotlin.reflect.jvm.internal.impl.descriptors.h> {
        a() {
            super(1);
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.h a(int i10) {
            return c0.this.d(i10);
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.h invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        final /* synthetic */ w9.q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(w9.q qVar) {
            super(0);
            this.$proto = qVar;
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            return c0.this.f14036a.c().d().a(this.$proto, c0.this.f14036a.g());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<Integer, kotlin.reflect.jvm.internal.impl.descriptors.h> {
        c() {
            super(1);
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.h a(int i10) {
            return c0.this.f(i10);
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.h invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class d extends kotlin.jvm.internal.j implements c9.l<ba.b, ba.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14043a = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.b(ba.b.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final ba.b invoke(ba.b p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return p10.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends kotlin.jvm.internal.o implements c9.l<w9.q, w9.q> {
        e() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w9.q invoke(w9.q it) {
            kotlin.jvm.internal.m.f(it, "it");
            return y9.f.j(it, c0.this.f14036a.j());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends kotlin.jvm.internal.o implements c9.l<w9.q, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f14044a = new f();

        f() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(w9.q it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Integer.valueOf(it.U());
        }
    }

    public c0(m c10, c0 c0Var, List<w9.s> typeParameterProtos, String debugName, String containerPresentableName) {
        Map<Integer, f1> linkedHashMap;
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.m.f(debugName, "debugName");
        kotlin.jvm.internal.m.f(containerPresentableName, "containerPresentableName");
        this.f14036a = c10;
        this.f14037b = c0Var;
        this.f14038c = debugName;
        this.f14039d = containerPresentableName;
        this.f14040e = c10.h().i(new a());
        this.f14041f = c10.h().i(new c());
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = n0.i();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i10 = 0;
            for (w9.s sVar : typeParameterProtos) {
                linkedHashMap.put(Integer.valueOf(sVar.L()), new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m(this.f14036a, sVar, i10));
                i10++;
            }
        }
        this.f14042g = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.h d(int i10) {
        ba.b bVarA = w.a(this.f14036a.g(), i10);
        return bVarA.k() ? this.f14036a.c().b(bVarA) : kotlin.reflect.jvm.internal.impl.descriptors.x.b(this.f14036a.c().p(), bVarA);
    }

    private final o0 e(int i10) {
        if (w.a(this.f14036a.g(), i10).k()) {
            return this.f14036a.c().n().a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.h f(int i10) {
        ba.b bVarA = w.a(this.f14036a.g(), i10);
        if (bVarA.k()) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.x.d(this.f14036a.c().p(), bVarA);
    }

    private final o0 i(c1 c1Var, g1 g1Var, List<? extends k1> list, boolean z10) {
        o0 o0VarJ = h0.j(c1Var, g1Var, list, z10, null, 16, null);
        if (kotlin.reflect.jvm.internal.impl.builtins.g.p(o0VarJ)) {
            return p(o0VarJ);
        }
        return null;
    }

    private final f1 k(int i10) {
        f1 f1Var = this.f14042g.get(Integer.valueOf(i10));
        if (f1Var != null) {
            return f1Var;
        }
        c0 c0Var = this.f14037b;
        if (c0Var != null) {
            return c0Var.k(i10);
        }
        return null;
    }

    public static /* synthetic */ o0 n(c0 c0Var, w9.q qVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return c0Var.l(qVar, z10);
    }

    private final c1 o(List<? extends b1> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, g1 g1Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        List<? extends b1> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((b1) it.next()).a(gVar, g1Var, mVar));
        }
        return c1.f14231b.g(kotlin.collections.r.y(arrayList));
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.e t(c0 c0Var, w9.q qVar, int i10) {
        ba.b bVarA = w.a(c0Var.f14036a.g(), i10);
        List<Integer> listQ = ta.k.Q(ta.k.J(ta.k.o(qVar, c0Var.new e()), f.f14044a));
        int iW = ta.k.w(ta.k.o(bVarA, d.f14043a));
        while (listQ.size() < iW) {
            listQ.add(0);
        }
        return c0Var.f14036a.c().q().d(bVarA, listQ);
    }

    public final List<f1> j() {
        return kotlin.collections.r.O0(this.f14042g.values());
    }

    public final o0 l(w9.q proto, boolean z10) {
        o0 o0VarC;
        o0 o0VarJ;
        kotlin.jvm.internal.m.f(proto, "proto");
        o0 o0VarE = proto.l0() ? e(proto.W()) : proto.t0() ? e(proto.g0()) : null;
        if (o0VarE != null) {
            return o0VarE;
        }
        g1 g1VarS = s(proto);
        if (la.k.m(g1VarS.d())) {
            return la.k.f15326a.c(la.j.U1, g1VarS, g1VarS.toString());
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a aVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.a(this.f14036a.h(), new b(proto));
        c1 c1VarO = o(this.f14036a.c().v(), aVar, g1VarS, this.f14036a.e());
        List<w9.q.b> listM = m(proto, this);
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listM, 10));
        int i10 = 0;
        for (Object obj : listM) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            List<f1> parameters = g1VarS.getParameters();
            kotlin.jvm.internal.m.e(parameters, "constructor.parameters");
            arrayList.add(r((f1) kotlin.collections.r.j0(parameters, i10), (w9.q.b) obj));
            i10 = i11;
        }
        List<? extends k1> listO0 = kotlin.collections.r.O0(arrayList);
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g1VarS.d();
        if (z10 && (hVarD instanceof e1)) {
            o0 o0VarB = h0.b((e1) hVarD, listO0);
            o0VarC = o0VarB.N0(i0.b(o0VarB) || proto.d0()).P0(o(this.f14036a.c().v(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.a(kotlin.collections.r.z0(aVar, o0VarB.getAnnotations())), g1VarS, this.f14036a.e()));
        } else {
            Boolean boolD = y9.b.f22494a.d(proto.Z());
            kotlin.jvm.internal.m.e(boolD, "SUSPEND_TYPE.get(proto.flags)");
            if (boolD.booleanValue()) {
                o0VarC = h(c1VarO, g1VarS, listO0, proto.d0());
            } else {
                o0 o0VarJ2 = h0.j(c1VarO, g1VarS, listO0, proto.d0(), null, 16, null);
                Boolean boolD2 = y9.b.f22495b.d(proto.Z());
                kotlin.jvm.internal.m.e(boolD2, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (boolD2.booleanValue()) {
                    o0VarC = kotlin.reflect.jvm.internal.impl.types.p.a.c(kotlin.reflect.jvm.internal.impl.types.p.f14347d, o0VarJ2, true, false, 4, null);
                    if (o0VarC == null) {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + o0VarJ2 + '\'').toString());
                    }
                } else {
                    o0VarC = o0VarJ2;
                }
            }
        }
        w9.q qVarA = y9.f.a(proto, this.f14036a.j());
        if (qVarA != null && (o0VarJ = s0.j(o0VarC, l(qVarA, false))) != null) {
            o0VarC = o0VarJ;
        }
        return proto.l0() ? this.f14036a.c().t().a(w.a(this.f14036a.g(), proto.W()), o0VarC) : o0VarC;
    }

    public final g0 q(w9.q proto) {
        kotlin.jvm.internal.m.f(proto, "proto");
        if (!proto.n0()) {
            return l(proto, true);
        }
        String string = this.f14036a.g().getString(proto.a0());
        o0 o0VarN = n(this, proto, false, 2, null);
        w9.q qVarF = y9.f.f(proto, this.f14036a.j());
        kotlin.jvm.internal.m.c(qVarF);
        return this.f14036a.c().l().a(proto, string, o0VarN, n(this, qVarF, false, 2, null));
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f14038c);
        if (this.f14037b == null) {
            str = "";
        } else {
            str = ". Child of " + this.f14037b.f14038c;
        }
        sb2.append(str);
        return sb2.toString();
    }

    private final o0 g(g0 g0Var, g0 g0Var2) {
        kotlin.reflect.jvm.internal.impl.builtins.h hVarI = oa.a.i(g0Var);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = g0Var.getAnnotations();
        g0 g0VarJ = kotlin.reflect.jvm.internal.impl.builtins.g.j(g0Var);
        List<g0> listE = kotlin.reflect.jvm.internal.impl.builtins.g.e(g0Var);
        List listD0 = kotlin.collections.r.d0(kotlin.reflect.jvm.internal.impl.builtins.g.l(g0Var), 1);
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listD0, 10));
        Iterator it = listD0.iterator();
        while (it.hasNext()) {
            arrayList.add(((k1) it.next()).getType());
        }
        return kotlin.reflect.jvm.internal.impl.builtins.g.b(hVarI, annotations, g0VarJ, listE, arrayList, null, g0Var2, true).N0(g0Var.K0());
    }

    private final o0 h(c1 c1Var, g1 g1Var, List<? extends k1> list, boolean z10) {
        List<? extends k1> list2;
        o0 o0VarI;
        int size;
        int size2 = g1Var.getParameters().size() - list.size();
        if (size2 != 0) {
            o0VarI = null;
            if (size2 != 1 || (size = list.size() - 1) < 0) {
                list2 = list;
            } else {
                g1 g1VarH = g1Var.l().X(size).h();
                kotlin.jvm.internal.m.e(g1VarH, "functionTypeConstructor.…on(arity).typeConstructor");
                list2 = list;
                o0VarI = h0.j(c1Var, g1VarH, list2, z10, null, 16, null);
            }
        } else {
            list2 = list;
            o0VarI = i(c1Var, g1Var, list2, z10);
        }
        if (o0VarI == null) {
            return la.k.f15326a.f(la.j.N, list2, g1Var, new String[0]);
        }
        return o0VarI;
    }

    private static final List<w9.q.b> m(w9.q qVar, c0 c0Var) {
        List<w9.q.b> listL;
        List<w9.q.b> argumentList = qVar.V();
        kotlin.jvm.internal.m.e(argumentList, "argumentList");
        List<w9.q.b> list = argumentList;
        w9.q qVarJ = y9.f.j(qVar, c0Var.f14036a.j());
        if (qVarJ != null) {
            listL = m(qVarJ, c0Var);
        } else {
            listL = null;
        }
        if (listL == null) {
            listL = kotlin.collections.r.l();
        }
        return kotlin.collections.r.B0(list, listL);
    }

    private final o0 p(g0 g0Var) {
        g0 type;
        ba.c cVarL;
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar;
        k1 k1Var = (k1) kotlin.collections.r.u0(kotlin.reflect.jvm.internal.impl.builtins.g.l(g0Var));
        ba.c cVarH = null;
        if (k1Var == null || (type = k1Var.getType()) == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = type.J0().d();
        if (hVarD != null) {
            cVarL = ea.c.l(hVarD);
        } else {
            cVarL = null;
        }
        if (type.H0().size() == 1 && (kotlin.jvm.internal.m.a(cVarL, kotlin.reflect.jvm.internal.impl.builtins.k.f12588q) || kotlin.jvm.internal.m.a(cVarL, d0.f14048a))) {
            g0 type2 = ((k1) kotlin.collections.r.F0(type.H0())).getType();
            kotlin.jvm.internal.m.e(type2, "continuationArgumentType.arguments.single().type");
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarE = this.f14036a.e();
            if (mVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) {
                aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) mVarE;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                cVarH = ea.c.h(aVar);
            }
            if (kotlin.jvm.internal.m.a(cVarH, b0.f14034a)) {
                return g(g0Var, type2);
            }
            return g(g0Var, type2);
        }
        return (o0) g0Var;
    }

    private final k1 r(f1 f1Var, w9.q.b bVar) {
        if (bVar.w() == w9.q.b.c.STAR) {
            if (f1Var == null) {
                return new t0(this.f14036a.c().p().l());
            }
            return new u0(f1Var);
        }
        z zVar = z.f14212a;
        w9.q.b.c cVarW = bVar.w();
        kotlin.jvm.internal.m.e(cVarW, "typeArgumentProto.projection");
        w1 w1VarC = zVar.c(cVarW);
        w9.q qVarP = y9.f.p(bVar, this.f14036a.j());
        if (qVarP == null) {
            return new m1(la.k.d(la.j.Z1, bVar.toString()));
        }
        return new m1(w1VarC, q(qVarP));
    }

    private final g1 s(w9.q qVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarInvoke;
        Object next;
        if (qVar.l0()) {
            hVarInvoke = this.f14040e.invoke(Integer.valueOf(qVar.W()));
            if (hVarInvoke == null) {
                hVarInvoke = t(this, qVar, qVar.W());
            }
        } else if (qVar.u0()) {
            hVarInvoke = k(qVar.h0());
            if (hVarInvoke == null) {
                return la.k.f15326a.e(la.j.L, String.valueOf(qVar.h0()), this.f14039d);
            }
        } else if (qVar.v0()) {
            String string = this.f14036a.g().getString(qVar.i0());
            Iterator<T> it = j().iterator();
            do {
                if (it.hasNext()) {
                    next = it.next();
                } else {
                    next = null;
                    break;
                }
            } while (!kotlin.jvm.internal.m.a(((f1) next).getName().f(), string));
            hVarInvoke = (f1) next;
            if (hVarInvoke == null) {
                return la.k.f15326a.e(la.j.M, string, this.f14036a.e().toString());
            }
        } else if (qVar.t0()) {
            hVarInvoke = this.f14041f.invoke(Integer.valueOf(qVar.g0()));
            if (hVarInvoke == null) {
                hVarInvoke = t(this, qVar, qVar.g0());
            }
        } else {
            return la.k.f15326a.e(la.j.P, new String[0]);
        }
        g1 g1VarH = hVarInvoke.h();
        kotlin.jvm.internal.m.e(g1VarH, "classifier.typeConstructor");
        return g1VarH;
    }
}
