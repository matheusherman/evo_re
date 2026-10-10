package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f14327f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f14328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i1 f14329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.f f14330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r8.i f14331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.g<b, g0> f14332e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:20:0x008a  */
        /* JADX WARN: Code duplicated, block: B:24:0x0094  */
        /* JADX WARN: Code duplicated, block: B:29:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:48:0x0122  */
        /* JADX WARN: Code duplicated, block: B:52:0x012c  */
        /* JADX WARN: Code duplicated, block: B:57:0x0142  */
        /* JADX WARN: Code duplicated, block: B:79:0x01c1  */
        /* JADX WARN: Code duplicated, block: B:83:0x01cb  */
        /* JADX WARN: Code duplicated, block: B:88:0x01e1  */
        public final g0 a(g0 g0Var, p1 substitutor, Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.f1> set, boolean z10) {
            v1 v1VarF;
            boolean z11;
            g0 type;
            boolean z12;
            g0 type2;
            boolean z13;
            g0 type3;
            kotlin.jvm.internal.m.f(g0Var, "<this>");
            kotlin.jvm.internal.m.f(substitutor, "substitutor");
            v1 v1VarM0 = g0Var.M0();
            if (v1VarM0 instanceof a0) {
                a0 a0Var = (a0) v1VarM0;
                o0 o0VarR0 = a0Var.R0();
                if (!o0VarR0.J0().getParameters().isEmpty() && o0VarR0.J0().d() != null) {
                    List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters = o0VarR0.J0().getParameters();
                    kotlin.jvm.internal.m.e(parameters, "constructor.parameters");
                    List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list = parameters;
                    ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var : list) {
                        k1 u0Var = (k1) kotlin.collections.r.j0(g0Var.H0(), f1Var.getIndex());
                        if (!z10 || u0Var == null || (type3 = u0Var.getType()) == null) {
                            if (set == null && set.contains(f1Var)) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (u0Var != null || z13) {
                                u0Var = new u0(f1Var);
                            } else {
                                n1 n1VarJ = substitutor.j();
                                g0 type4 = u0Var.getType();
                                kotlin.jvm.internal.m.e(type4, "argument.type");
                                if (n1VarJ.e(type4) == null) {
                                    u0Var = new u0(f1Var);
                                }
                            }
                        } else {
                            kotlin.jvm.internal.m.e(type3, "type");
                            if (oa.a.e(type3)) {
                                if (set == null) {
                                    z13 = false;
                                } else {
                                    z13 = false;
                                }
                                if (u0Var != null) {
                                    u0Var = new u0(f1Var);
                                } else {
                                    u0Var = new u0(f1Var);
                                }
                            }
                        }
                        arrayList.add(u0Var);
                    }
                    o0VarR0 = o1.f(o0VarR0, arrayList, null, 2, null);
                }
                o0 o0VarS0 = a0Var.S0();
                if (!o0VarS0.J0().getParameters().isEmpty() && o0VarS0.J0().d() != null) {
                    List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters2 = o0VarS0.J0().getParameters();
                    kotlin.jvm.internal.m.e(parameters2, "constructor.parameters");
                    List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list2 = parameters2;
                    ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list2, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var2 : list2) {
                        k1 u0Var2 = (k1) kotlin.collections.r.j0(g0Var.H0(), f1Var2.getIndex());
                        if (!z10 || u0Var2 == null || (type2 = u0Var2.getType()) == null) {
                            if (set == null && set.contains(f1Var2)) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (u0Var2 != null || z12) {
                                u0Var2 = new u0(f1Var2);
                            } else {
                                n1 n1VarJ2 = substitutor.j();
                                g0 type5 = u0Var2.getType();
                                kotlin.jvm.internal.m.e(type5, "argument.type");
                                if (n1VarJ2.e(type5) == null) {
                                    u0Var2 = new u0(f1Var2);
                                }
                            }
                        } else {
                            kotlin.jvm.internal.m.e(type2, "type");
                            if (oa.a.e(type2)) {
                                if (set == null) {
                                    z12 = false;
                                } else {
                                    z12 = false;
                                }
                                if (u0Var2 != null) {
                                    u0Var2 = new u0(f1Var2);
                                } else {
                                    u0Var2 = new u0(f1Var2);
                                }
                            }
                        }
                        arrayList2.add(u0Var2);
                    }
                    o0VarS0 = o1.f(o0VarS0, arrayList2, null, 2, null);
                }
                v1VarF = h0.d(o0VarR0, o0VarS0);
            } else {
                if (!(v1VarM0 instanceof o0)) {
                    throw new r8.n();
                }
                o0 o0Var = (o0) v1VarM0;
                if (o0Var.J0().getParameters().isEmpty() || o0Var.J0().d() == null) {
                    v1VarF = o0Var;
                } else {
                    List<kotlin.reflect.jvm.internal.impl.descriptors.f1> parameters3 = o0Var.J0().getParameters();
                    kotlin.jvm.internal.m.e(parameters3, "constructor.parameters");
                    List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list3 = parameters3;
                    ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(list3, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var3 : list3) {
                        k1 u0Var3 = (k1) kotlin.collections.r.j0(g0Var.H0(), f1Var3.getIndex());
                        if (!z10 || u0Var3 == null || (type = u0Var3.getType()) == null) {
                            if (set == null && set.contains(f1Var3)) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (u0Var3 != null || z11) {
                                u0Var3 = new u0(f1Var3);
                            } else {
                                n1 n1VarJ3 = substitutor.j();
                                g0 type6 = u0Var3.getType();
                                kotlin.jvm.internal.m.e(type6, "argument.type");
                                if (n1VarJ3.e(type6) == null) {
                                    u0Var3 = new u0(f1Var3);
                                }
                            }
                        } else {
                            kotlin.jvm.internal.m.e(type, "type");
                            if (oa.a.e(type)) {
                                if (set == null) {
                                    z11 = false;
                                } else {
                                    z11 = false;
                                }
                                if (u0Var3 != null) {
                                    u0Var3 = new u0(f1Var3);
                                } else {
                                    u0Var3 = new u0(f1Var3);
                                }
                            }
                        }
                        arrayList3.add(u0Var3);
                    }
                    v1VarF = o1.f(o0Var, arrayList3, null, 2, null);
                }
            }
            g0 g0VarN = substitutor.n(u1.b(v1VarF, v1VarM0), w1.OUT_VARIANCE);
            kotlin.jvm.internal.m.e(g0VarN, "substitutor.safeSubstitu…s, Variance.OUT_VARIANCE)");
            return g0VarN;
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.descriptors.f1 f14333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final y f14334b;

        public b(kotlin.reflect.jvm.internal.impl.descriptors.f1 typeParameter, y typeAttr) {
            kotlin.jvm.internal.m.f(typeParameter, "typeParameter");
            kotlin.jvm.internal.m.f(typeAttr, "typeAttr");
            this.f14333a = typeParameter;
            this.f14334b = typeAttr;
        }

        public final y a() {
            return this.f14334b;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.f1 b() {
            return this.f14333a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.jvm.internal.m.a(bVar.f14333a, this.f14333a) && kotlin.jvm.internal.m.a(bVar.f14334b, this.f14334b);
        }

        public int hashCode() {
            int iHashCode = this.f14333a.hashCode();
            return iHashCode + (iHashCode * 31) + this.f14334b.hashCode();
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.f14333a + ", typeAttr=" + this.f14334b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.a<la.h> {
        c() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la.h invoke() {
            return la.k.d(la.j.W1, j1.this.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.l<b, g0> {
        d() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(b bVar) {
            return j1.this.d(bVar.b(), bVar.a());
        }
    }

    public j1(x projectionComputer, i1 options) {
        kotlin.jvm.internal.m.f(projectionComputer, "projectionComputer");
        kotlin.jvm.internal.m.f(options, "options");
        this.f14328a = projectionComputer;
        this.f14329b = options;
        ka.f fVar = new ka.f("Type parameter upper bound erasure results");
        this.f14330c = fVar;
        this.f14331d = r8.j.a(new c());
        ka.g<b, g0> gVarF = fVar.f(new d());
        kotlin.jvm.internal.m.e(gVarF, "storage.createMemoizedFu…ameter, typeAttr) }\n    }");
        this.f14332e = gVarF;
    }

    private final la.h e() {
        return (la.h) this.f14331d.getValue();
    }

    public final g0 c(kotlin.reflect.jvm.internal.impl.descriptors.f1 typeParameter, y typeAttr) {
        kotlin.jvm.internal.m.f(typeParameter, "typeParameter");
        kotlin.jvm.internal.m.f(typeAttr, "typeAttr");
        g0 g0VarInvoke = this.f14332e.invoke(new b(typeParameter, typeAttr));
        kotlin.jvm.internal.m.e(g0VarInvoke, "getErasedUpperBound(Data…typeParameter, typeAttr))");
        return g0VarInvoke;
    }

    private final g0 b(y yVar) {
        g0 g0VarY;
        o0 o0VarA = yVar.a();
        if (o0VarA != null && (g0VarY = oa.a.y(o0VarA)) != null) {
            return g0VarY;
        }
        return e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g0 d(kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, y yVar) {
        k1 k1VarA;
        Set<kotlin.reflect.jvm.internal.impl.descriptors.f1> setC = yVar.c();
        if (setC != null && setC.contains(f1Var.a())) {
            return b(yVar);
        }
        o0 o0VarP = f1Var.p();
        kotlin.jvm.internal.m.e(o0VarP, "typeParameter.defaultType");
        Set<kotlin.reflect.jvm.internal.impl.descriptors.f1> setG = oa.a.g(o0VarP, setC);
        LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(kotlin.collections.n0.e(kotlin.collections.r.w(setG, 10)), 16));
        for (kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var2 : setG) {
            if (setC != null && setC.contains(f1Var2)) {
                k1VarA = s1.t(f1Var2, yVar);
                kotlin.jvm.internal.m.e(k1VarA, "makeStarProjection(it, typeAttr)");
            } else {
                k1VarA = this.f14328a.a(f1Var2, yVar, this, c(f1Var2, yVar.d(f1Var)));
            }
            r8.p pVarA = r8.v.a(f1Var2.h(), k1VarA);
            linkedHashMap.put(pVarA.c(), pVarA.d());
        }
        p1 p1VarG = p1.g(h1.a.e(h1.f14318c, linkedHashMap, false, 2, null));
        kotlin.jvm.internal.m.e(p1VarG, "create(TypeConstructorSu…ap(erasedTypeParameters))");
        List<g0> upperBounds = f1Var.getUpperBounds();
        kotlin.jvm.internal.m.e(upperBounds, "typeParameter.upperBounds");
        Set<g0> setF = f(p1VarG, upperBounds, yVar);
        if (!setF.isEmpty()) {
            if (!this.f14329b.a()) {
                if (setF.size() == 1) {
                    return (g0) kotlin.collections.r.E0(setF);
                }
                throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds");
            }
            List listO0 = kotlin.collections.r.O0(setF);
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listO0, 10));
            Iterator it = listO0.iterator();
            while (it.hasNext()) {
                arrayList.add(((g0) it.next()).M0());
            }
            return kotlin.reflect.jvm.internal.impl.types.checker.d.a(arrayList);
        }
        return b(yVar);
    }

    private final Set<g0> f(p1 p1Var, List<? extends g0> list, y yVar) {
        Set setB = kotlin.collections.v0.b();
        for (g0 g0Var : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
            if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                setB.add(f14327f.a(g0Var, p1Var, yVar.c(), this.f14329b.b()));
            } else if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
                Set<kotlin.reflect.jvm.internal.impl.descriptors.f1> setC = yVar.c();
                if (setC != null && setC.contains(hVarD)) {
                    setB.add(b(yVar));
                } else {
                    List<g0> upperBounds = ((kotlin.reflect.jvm.internal.impl.descriptors.f1) hVarD).getUpperBounds();
                    kotlin.jvm.internal.m.e(upperBounds, "declaration.upperBounds");
                    setB.addAll(f(p1Var, upperBounds, yVar));
                }
            }
            if (!this.f14329b.a()) {
                break;
            }
        }
        return kotlin.collections.v0.a(setB);
    }

    public /* synthetic */ j1(x xVar, i1 i1Var, int i10, kotlin.jvm.internal.g gVar) {
        this(xVar, (i10 & 2) != 0 ? new i1(false, false) : i1Var);
    }
}
