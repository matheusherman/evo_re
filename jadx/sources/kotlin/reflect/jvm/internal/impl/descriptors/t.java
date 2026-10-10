package kotlin.reflect.jvm.internal.impl.descriptors;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f13064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f13065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f13066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f13067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f13068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u f13069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u f13070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f13071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u f13072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<u> f13073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<u, Integer> f13074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u f13075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ha.g f13076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ha.g f13077n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Deprecated
    public static final ha.g f13078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.util.l f13079p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Map<n1, u> f13080q;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements ha.g {
        @Override // ha.g
        public kotlin.reflect.jvm.internal.impl.types.g0 getType() {
            throw new IllegalStateException("This method should not be called");
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b implements ha.g {
        @Override // ha.g
        public kotlin.reflect.jvm.internal.impl.types.g0 getType() {
            throw new IllegalStateException("This method should not be called");
        }

        b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class c implements ha.g {
        @Override // ha.g
        public kotlin.reflect.jvm.internal.impl.types.g0 getType() {
            throw new IllegalStateException("This method should not be called");
        }

        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class f extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            } else if (i10 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i10 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i10 == 2 || i10 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.e) kotlin.reflect.jvm.internal.impl.resolve.e.q(qVar, kotlin.reflect.jvm.internal.impl.descriptors.e.class);
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar3 = (kotlin.reflect.jvm.internal.impl.descriptors.e) kotlin.reflect.jvm.internal.impl.resolve.e.r(mVar, kotlin.reflect.jvm.internal.impl.descriptors.e.class, false);
            if (eVar3 == null) {
                return false;
            }
            if (eVar2 != null && kotlin.reflect.jvm.internal.impl.resolve.e.x(eVar2) && (eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) kotlin.reflect.jvm.internal.impl.resolve.e.q(eVar2, kotlin.reflect.jvm.internal.impl.descriptors.e.class)) != null && kotlin.reflect.jvm.internal.impl.resolve.e.H(eVar3, eVar)) {
                return true;
            }
            q qVarM = kotlin.reflect.jvm.internal.impl.resolve.e.M(qVar);
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar4 = (kotlin.reflect.jvm.internal.impl.descriptors.e) kotlin.reflect.jvm.internal.impl.resolve.e.q(qVarM, kotlin.reflect.jvm.internal.impl.descriptors.e.class);
            if (eVar4 == null) {
                return false;
            }
            if (kotlin.reflect.jvm.internal.impl.resolve.e.H(eVar3, eVar4) && h(gVar, qVarM, eVar3)) {
                return true;
            }
            return e(gVar, qVar, eVar3.b(), z10);
        }

        private boolean h(ha.g gVar, q qVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            if (qVar == null) {
                g(2);
            }
            if (eVar == null) {
                g(3);
            }
            if (gVar == t.f13078o) {
                return false;
            }
            if (!(qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) || (qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) || gVar == t.f13077n) {
                return true;
            }
            if (gVar == t.f13076m || gVar == null) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.types.g0 g0VarB = gVar instanceof ha.h ? ((ha.h) gVar).b() : gVar.getType();
            return kotlin.reflect.jvm.internal.impl.resolve.e.I(g0VarB, eVar) || kotlin.reflect.jvm.internal.impl.types.w.a(g0VarB);
        }

        f(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class h extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return true;
        }

        h(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class i extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }

        i(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class j extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }

        j(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class d extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "what";
            } else if (i10 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(m mVar) {
            if (mVar == null) {
                g(0);
            }
            return kotlin.reflect.jvm.internal.impl.resolve.e.j(mVar) != b1.f12738a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == 0) {
                g(1);
            }
            if (mVar == null) {
                g(2);
            }
            if (kotlin.reflect.jvm.internal.impl.resolve.e.J(qVar) && h(mVar)) {
                return t.f(qVar, mVar);
            }
            if (qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) {
                kotlin.reflect.jvm.internal.impl.descriptors.i iVarB = ((kotlin.reflect.jvm.internal.impl.descriptors.l) qVar).b();
                if (z10 && kotlin.reflect.jvm.internal.impl.resolve.e.G(iVarB) && kotlin.reflect.jvm.internal.impl.resolve.e.J(iVarB) && (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) && kotlin.reflect.jvm.internal.impl.resolve.e.J(mVar.b()) && t.f(qVar, mVar)) {
                    return true;
                }
            }
            while (qVar != 0) {
                qVar = qVar.b();
                if (((qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && !kotlin.reflect.jvm.internal.impl.resolve.e.x(qVar)) || (qVar instanceof l0)) {
                    break;
                }
            }
            if (qVar == 0) {
                return false;
            }
            while (mVar != null) {
                if (qVar == mVar) {
                    return true;
                }
                if (mVar instanceof l0) {
                    return (qVar instanceof l0) && ((l0) qVar).d().equals(((l0) mVar).d()) && kotlin.reflect.jvm.internal.impl.resolve.e.b(mVar, qVar);
                }
                mVar = mVar.b();
            }
            return false;
        }

        d(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class e extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            m mVarQ;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (t.f13064a.e(gVar, qVar, mVar, z10)) {
                if (gVar == t.f13077n) {
                    return true;
                }
                if (gVar != t.f13076m && (mVarQ = kotlin.reflect.jvm.internal.impl.resolve.e.q(qVar, kotlin.reflect.jvm.internal.impl.descriptors.e.class)) != null && (gVar instanceof ha.i)) {
                    return ((ha.i) gVar).o().a().equals(mVarQ.a());
                }
            }
            return false;
        }

        e(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class g extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (kotlin.reflect.jvm.internal.impl.resolve.e.g(mVar).a0(kotlin.reflect.jvm.internal.impl.resolve.e.g(qVar))) {
                return t.f13079p.a(qVar, mVar);
            }
            return false;
        }

        g(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class k extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }

        k(n1 n1Var) {
            super(n1Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class l extends r {
        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(ha.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }

        l(n1 n1Var) {
            super(n1Var);
        }
    }

    static {
        d dVar = new d(m1.e.f12992c);
        f13064a = dVar;
        e eVar = new e(m1.f.f12993c);
        f13065b = eVar;
        f fVar = new f(m1.g.f12994c);
        f13066c = fVar;
        g gVar = new g(m1.b.f12989c);
        f13067d = gVar;
        h hVar = new h(m1.h.f12995c);
        f13068e = hVar;
        i iVar = new i(m1.d.f12991c);
        f13069f = iVar;
        j jVar = new j(m1.a.f12988c);
        f13070g = jVar;
        k kVar = new k(m1.c.f12990c);
        f13071h = kVar;
        l lVar = new l(m1.i.f12996c);
        f13072i = lVar;
        f13073j = Collections.unmodifiableSet(kotlin.collections.v0.h(dVar, eVar, gVar, iVar));
        HashMap mapE = sa.a.e(4);
        mapE.put(eVar, 0);
        mapE.put(dVar, 0);
        mapE.put(gVar, 1);
        mapE.put(fVar, 1);
        mapE.put(hVar, 2);
        f13074k = Collections.unmodifiableMap(mapE);
        f13075l = hVar;
        f13076m = new a();
        f13077n = new b();
        f13078o = new c();
        Iterator it = ServiceLoader.load(kotlin.reflect.jvm.internal.impl.util.l.class, kotlin.reflect.jvm.internal.impl.util.l.class.getClassLoader()).iterator();
        f13079p = it.hasNext() ? (kotlin.reflect.jvm.internal.impl.util.l) it.next() : kotlin.reflect.jvm.internal.impl.util.l.a.f14426a;
        f13080q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003a  */
    private static /* synthetic */ void a(int i10) {
        String str = i10 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 16 ? 3 : 2];
        if (i10 != 1 && i10 != 3 && i10 != 5 && i10 != 7) {
            switch (i10) {
                case 9:
                    objArr[0] = TypedValues.TransitionType.S_FROM;
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        } else {
            objArr[0] = TypedValues.TransitionType.S_FROM;
        }
        if (i10 != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i10) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 16) {
            throw new IllegalStateException(str2);
        }
    }

    public static Integer d(u uVar, u uVar2) {
        if (uVar == null) {
            a(12);
        }
        if (uVar2 == null) {
            a(13);
        }
        Integer numA = uVar.a(uVar2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = uVar2.a(uVar);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    public static q e(ha.g gVar, q qVar, m mVar, boolean z10) {
        q qVarE;
        if (qVar == null) {
            a(8);
        }
        if (mVar == null) {
            a(9);
        }
        for (q qVar2 = (q) qVar.a(); qVar2 != null && qVar2.getVisibility() != f13069f; qVar2 = (q) kotlin.reflect.jvm.internal.impl.resolve.e.q(qVar2, q.class)) {
            if (!qVar2.getVisibility().e(gVar, qVar2, mVar, z10)) {
                return qVar2;
            }
        }
        if (!(qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.i0) || (qVarE = e(gVar, ((kotlin.reflect.jvm.internal.impl.descriptors.impl.i0) qVar).l0(), mVar, z10)) == null) {
            return null;
        }
        return qVarE;
    }

    public static boolean f(m mVar, m mVar2) {
        if (mVar == null) {
            a(6);
        }
        if (mVar2 == null) {
            a(7);
        }
        b1 b1VarJ = kotlin.reflect.jvm.internal.impl.resolve.e.j(mVar2);
        if (b1VarJ != b1.f12738a) {
            return b1VarJ.equals(kotlin.reflect.jvm.internal.impl.resolve.e.j(mVar));
        }
        return false;
    }

    public static boolean g(u uVar) {
        if (uVar == null) {
            a(14);
        }
        return uVar == f13064a || uVar == f13065b;
    }

    public static boolean h(q qVar, m mVar, boolean z10) {
        if (qVar == null) {
            a(2);
        }
        if (mVar == null) {
            a(3);
        }
        return e(f13077n, qVar, mVar, z10) == null;
    }

    private static void i(u uVar) {
        f13080q.put(uVar.b(), uVar);
    }

    public static u j(n1 n1Var) {
        if (n1Var == null) {
            a(15);
        }
        u uVar = f13080q.get(n1Var);
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + n1Var);
    }
}
