package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14277a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f14278b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<f1.a, r8.z> {
        final /* synthetic */ f1 $state;
        final /* synthetic */ na.k $superType;
        final /* synthetic */ List<na.k> $supertypesWithSameConstructor;
        final /* synthetic */ na.p $this_with;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends kotlin.jvm.internal.o implements c9.a<Boolean> {
            final /* synthetic */ f1 $state;
            final /* synthetic */ na.k $subTypeArguments;
            final /* synthetic */ na.k $superType;
            final /* synthetic */ na.p $this_with;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c9.a
            public final Boolean invoke() {
                return Boolean.valueOf(f.f14277a.q(this.$state, this.$this_with.w0(this.$subTypeArguments), this.$superType));
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f1 f1Var, na.p pVar, na.k kVar, na.k kVar2) {
                super(0);
                this.$state = f1Var;
                this.$this_with = pVar;
                this.$subTypeArguments = kVar;
                this.$superType = kVar2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends na.k> list, f1 f1Var, na.p pVar, na.k kVar) {
            super(1);
            this.$supertypesWithSameConstructor = list;
            this.$state = f1Var;
            this.$this_with = pVar;
            this.$superType = kVar;
        }

        public final void a(f1.a runForkingPoint) {
            kotlin.jvm.internal.m.f(runForkingPoint, "$this$runForkingPoint");
            Iterator<na.k> it = this.$supertypesWithSameConstructor.iterator();
            while (it.hasNext()) {
                runForkingPoint.a(new a(this.$state, this.$this_with, it.next(), this.$superType));
            }
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(f1.a aVar) {
            a(aVar);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14280b;

        static {
            int[] iArr = new int[na.u.values().length];
            try {
                iArr[na.u.INV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[na.u.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[na.u.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14279a = iArr;
            int[] iArr2 = new int[f1.b.values().length];
            try {
                iArr2[f1.b.CHECK_ONLY_LOWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[f1.b.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[f1.b.SKIP_LOWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f14280b = iArr2;
        }
    }

    private static final boolean b(na.p pVar, na.k kVar) {
        if (!(kVar instanceof na.d)) {
            return false;
        }
        na.m mVarP0 = pVar.p0(pVar.k((na.d) kVar));
        return !pVar.o(mVarP0) && pVar.B(pVar.d0(pVar.m(mVarP0)));
    }

    public static /* synthetic */ boolean t(f fVar, f1 f1Var, na.i iVar, na.i iVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return fVar.s(f1Var, iVar, iVar2, z10);
    }

    private final boolean u(f1 f1Var, na.k kVar, na.k kVar2) {
        na.i iVarM;
        na.p pVarJ = f1Var.j();
        if (f14278b) {
            if (!pVarJ.b(kVar) && !pVarJ.x(pVarJ.f(kVar))) {
                f1Var.l(kVar);
            }
            if (!pVarJ.b(kVar2)) {
                f1Var.l(kVar2);
            }
        }
        if (!c.f14228a.d(f1Var, kVar, kVar2)) {
            return false;
        }
        f fVar = f14277a;
        Boolean boolA = fVar.a(f1Var, pVarJ.M(kVar), pVarJ.d0(kVar2));
        if (boolA != null) {
            boolean zBooleanValue = boolA.booleanValue();
            f1.d(f1Var, kVar, kVar2, false, 4, null);
            return zBooleanValue;
        }
        na.n nVarF = pVarJ.f(kVar2);
        if ((pVarJ.S(pVarJ.f(kVar), nVarF) && pVarJ.c0(nVarF) == 0) || pVarJ.z(pVarJ.f(kVar2))) {
            return true;
        }
        List<na.k> listL = fVar.l(f1Var, kVar, nVarF);
        int i10 = 10;
        ArrayList<na.k> arrayList = new ArrayList(kotlin.collections.r.w(listL, 10));
        for (na.k kVar3 : listL) {
            na.k kVarA = pVarJ.a(f1Var.o(kVar3));
            if (kVarA != null) {
                kVar3 = kVarA;
            }
            arrayList.add(kVar3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return f14277a.n(f1Var, kVar);
        }
        if (size == 1) {
            return f14277a.q(f1Var, pVarJ.w0((na.k) kotlin.collections.r.g0(arrayList)), kVar2);
        }
        na.a aVar = new na.a(pVarJ.c0(nVarF));
        int iC0 = pVarJ.c0(nVarF);
        int i11 = 0;
        boolean z10 = false;
        while (i11 < iC0) {
            z10 = z10 || pVarJ.H(pVarJ.u0(nVarF, i11)) != na.u.OUT;
            if (!z10) {
                ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(arrayList, i10));
                for (na.k kVar4 : arrayList) {
                    na.m mVarV = pVarJ.V(kVar4, i11);
                    if (mVarV != null) {
                        if (pVarJ.h(mVarV) != na.u.INV) {
                            mVarV = null;
                        }
                        if (mVarV != null && (iVarM = pVarJ.m(mVarV)) != null) {
                            arrayList2.add(iVarM);
                        }
                    }
                    throw new IllegalStateException(("Incorrect type: " + kVar4 + ", subType: " + kVar + ", superType: " + kVar2).toString());
                }
                aVar.add(pVarJ.w(pVarJ.F(arrayList2)));
            }
            i11++;
            i10 = 10;
        }
        if (z10 || !f14277a.q(f1Var, aVar, kVar2)) {
            return f1Var.q(new b(arrayList, f1Var, pVarJ, kVar2));
        }
        return true;
    }

    public final na.u j(na.u declared, na.u useSite) {
        kotlin.jvm.internal.m.f(declared, "declared");
        kotlin.jvm.internal.m.f(useSite, "useSite");
        na.u uVar = na.u.INV;
        if (declared == uVar) {
            return useSite;
        }
        if (useSite == uVar || declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean k(f1 state, na.i a10, na.i b10) {
        kotlin.jvm.internal.m.f(state, "state");
        kotlin.jvm.internal.m.f(a10, "a");
        kotlin.jvm.internal.m.f(b10, "b");
        na.p pVarJ = state.j();
        if (a10 == b10) {
            return true;
        }
        f fVar = f14277a;
        if (fVar.o(pVarJ, a10) && fVar.o(pVarJ, b10)) {
            na.i iVarO = state.o(state.p(a10));
            na.i iVarO2 = state.o(state.p(b10));
            na.k kVarM = pVarJ.M(iVarO);
            if (!pVarJ.S(pVarJ.y0(iVarO), pVarJ.y0(iVarO2))) {
                return false;
            }
            if (pVarJ.D0(kVarM) == 0) {
                return pVarJ.q(iVarO) || pVarJ.q(iVarO2) || pVarJ.h0(kVarM) == pVarJ.h0(pVarJ.M(iVarO2));
            }
        }
        return t(fVar, state, a10, b10, false, 8, null) && t(fVar, state, b10, a10, false, 8, null);
    }

    public final List<na.k> l(f1 state, na.k subType, na.n superConstructor) {
        f1.c cVar;
        kotlin.jvm.internal.m.f(state, "state");
        kotlin.jvm.internal.m.f(subType, "subType");
        kotlin.jvm.internal.m.f(superConstructor, "superConstructor");
        na.p pVarJ = state.j();
        if (pVarJ.u(subType)) {
            return f14277a.h(state, subType, superConstructor);
        }
        if (!pVarJ.p(superConstructor) && !pVarJ.I(superConstructor)) {
            return f14277a.g(state, subType, superConstructor);
        }
        sa.f<na.k> fVar = new sa.f();
        state.k();
        ArrayDeque<na.k> arrayDequeH = state.h();
        kotlin.jvm.internal.m.c(arrayDequeH);
        Set<na.k> setI = state.i();
        kotlin.jvm.internal.m.c(setI);
        arrayDequeH.push(subType);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + subType + ". Supertypes = " + kotlin.collections.r.q0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
            na.k current = arrayDequeH.pop();
            kotlin.jvm.internal.m.e(current, "current");
            if (setI.add(current)) {
                if (pVarJ.u(current)) {
                    fVar.add(current);
                    cVar = f1.c.C0269c.f14302a;
                } else {
                    cVar = f1.c.b.f14301a;
                }
                if (kotlin.jvm.internal.m.a(cVar, f1.c.C0269c.f14302a)) {
                    cVar = null;
                }
                if (cVar != null) {
                    na.p pVarJ2 = state.j();
                    Iterator<na.i> it = pVarJ2.q0(pVarJ2.f(current)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(cVar.a(state, it.next()));
                    }
                }
            }
        }
        state.e();
        ArrayList arrayList = new ArrayList();
        for (na.k it2 : fVar) {
            f fVar2 = f14277a;
            kotlin.jvm.internal.m.e(it2, "it");
            kotlin.collections.r.C(arrayList, fVar2.h(state, it2, superConstructor));
        }
        return arrayList;
    }

    public final boolean q(f1 f1Var, na.l capturedSubArguments, na.k superType) {
        boolean zK;
        f1 f1Var2 = f1Var;
        kotlin.jvm.internal.m.f(f1Var2, "<this>");
        kotlin.jvm.internal.m.f(capturedSubArguments, "capturedSubArguments");
        kotlin.jvm.internal.m.f(superType, "superType");
        na.p pVarJ = f1Var2.j();
        na.n nVarF = pVarJ.f(superType);
        int iJ0 = pVarJ.j0(capturedSubArguments);
        int iC0 = pVarJ.c0(nVarF);
        if (iJ0 != iC0 || iJ0 != pVarJ.D0(superType)) {
            return false;
        }
        for (int i10 = 0; i10 < iC0; i10++) {
            na.m mVarP = pVarJ.P(superType, i10);
            if (!pVarJ.o(mVarP)) {
                na.i iVarM = pVarJ.m(mVarP);
                na.m mVarS = pVarJ.s(capturedSubArguments, i10);
                pVarJ.h(mVarS);
                na.u uVar = na.u.INV;
                na.i iVarM2 = pVarJ.m(mVarS);
                f fVar = f14277a;
                na.u uVarJ = fVar.j(pVarJ.H(pVarJ.u0(nVarF, i10)), pVarJ.h(mVarP));
                if (uVarJ == null) {
                    return f1Var2.m();
                }
                if (uVarJ != uVar || (!fVar.v(pVarJ, iVarM2, iVarM, nVarF) && !fVar.v(pVarJ, iVarM, iVarM2, nVarF))) {
                    if (f1Var2.f14292g > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + iVarM2).toString());
                    }
                    f1Var2.f14292g++;
                    int i11 = a.f14279a[uVarJ.ordinal()];
                    if (i11 == 1) {
                        zK = fVar.k(f1Var2, iVarM2, iVarM);
                    } else if (i11 == 2) {
                        f1Var2 = f1Var;
                        zK = t(fVar, f1Var2, iVarM2, iVarM, false, 8, null);
                    } else {
                        if (i11 != 3) {
                            throw new r8.n();
                        }
                        zK = t(fVar, f1Var2, iVarM, iVarM2, false, 8, null);
                        f1Var2 = f1Var;
                    }
                    f1Var2.f14292g--;
                    if (!zK) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean r(f1 state, na.i subType, na.i superType) {
        kotlin.jvm.internal.m.f(state, "state");
        kotlin.jvm.internal.m.f(subType, "subType");
        kotlin.jvm.internal.m.f(superType, "superType");
        return t(this, state, subType, superType, false, 8, null);
    }

    public final boolean s(f1 state, na.i subType, na.i superType, boolean z10) {
        kotlin.jvm.internal.m.f(state, "state");
        kotlin.jvm.internal.m.f(subType, "subType");
        kotlin.jvm.internal.m.f(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.f(subType, superType)) {
            return i(state, subType, superType, z10);
        }
        return false;
    }

    private f() {
    }

    private final Boolean a(f1 f1Var, na.k kVar, na.k kVar2) {
        na.p pVarJ = f1Var.j();
        if (!pVarJ.B(kVar) && !pVarJ.B(kVar2)) {
            return null;
        }
        if (d(pVarJ, kVar) && d(pVarJ, kVar2)) {
            return Boolean.TRUE;
        }
        if (pVarJ.B(kVar)) {
            if (e(pVarJ, f1Var, kVar, kVar2, false)) {
                return Boolean.TRUE;
            }
        } else if (pVarJ.B(kVar2) && (c(pVarJ, kVar) || e(pVarJ, f1Var, kVar2, kVar, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean c(na.p pVar, na.k kVar) {
        na.n nVarF = pVar.f(kVar);
        if (nVarF instanceof na.h) {
            Collection<na.i> collectionQ0 = pVar.q0(nVarF);
            if (!(collectionQ0 instanceof Collection) || !collectionQ0.isEmpty()) {
                Iterator<T> it = collectionQ0.iterator();
                while (it.hasNext()) {
                    na.k kVarA = pVar.a((na.i) it.next());
                    if (kVarA != null && pVar.B(kVarA)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static final boolean d(na.p pVar, na.k kVar) {
        if (!pVar.B(kVar) && !b(pVar, kVar)) {
            return false;
        }
        return true;
    }

    private static final boolean e(na.p pVar, f1 f1Var, na.k kVar, na.k kVar2, boolean z10) {
        f1 f1Var2;
        na.k kVar3;
        Collection<na.i> collectionN = pVar.N(kVar);
        if ((collectionN instanceof Collection) && collectionN.isEmpty()) {
            return false;
        }
        for (na.i iVar : collectionN) {
            if (!kotlin.jvm.internal.m.a(pVar.y0(iVar), pVar.f(kVar2))) {
                if (z10) {
                    f1Var2 = f1Var;
                    kVar3 = kVar2;
                    if (t(f14277a, f1Var2, kVar3, iVar, false, 8, null)) {
                        return true;
                    }
                } else {
                    f1Var2 = f1Var;
                    kVar3 = kVar2;
                }
                f1Var = f1Var2;
                kVar2 = kVar3;
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0128  */
    /* JADX WARN: Code duplicated, block: B:83:0x0134  */
    private final Boolean f(f1 f1Var, na.k kVar, na.k kVar2) {
        na.k kVarJ;
        na.i iVarS0;
        na.o oVarM;
        na.p pVarJ = f1Var.j();
        boolean z10 = false;
        if (!pVarJ.v0(kVar) && !pVarJ.v0(kVar2)) {
            if (pVarJ.g0(kVar) && pVarJ.g0(kVar2)) {
                if (f14277a.p(pVarJ, kVar, kVar2) || f1Var.n()) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
            if (!pVarJ.T(kVar) && !pVarJ.T(kVar2)) {
                na.e eVarX0 = pVarJ.x0(kVar2);
                if (eVarX0 == null || (kVarJ = pVarJ.J(eVarX0)) == null) {
                    kVarJ = kVar2;
                }
                na.d dVarD = pVarJ.d(kVarJ);
                if (dVarD != null) {
                    iVarS0 = pVarJ.A0(dVarD);
                } else {
                    iVarS0 = null;
                }
                if (dVarD != null && iVarS0 != null) {
                    if (pVarJ.h0(kVar2)) {
                        iVarS0 = pVarJ.G(iVarS0, true);
                    } else if (pVarJ.n(kVar2)) {
                        iVarS0 = pVarJ.s0(iVarS0);
                    }
                    na.i iVar = iVarS0;
                    int i10 = a.f14280b[f1Var.g(kVar, dVarD).ordinal()];
                    if (i10 != 1) {
                        if (i10 == 2 && t(f14277a, f1Var, kVar, iVar, false, 8, null)) {
                            return Boolean.TRUE;
                        }
                    } else {
                        return Boolean.valueOf(t(f14277a, f1Var, kVar, iVar, false, 8, null));
                    }
                }
                na.n nVarF = pVarJ.f(kVar2);
                if (pVarJ.x(nVarF)) {
                    pVarJ.h0(kVar2);
                    Collection<na.i> collectionQ0 = pVarJ.q0(nVarF);
                    if ((collectionQ0 instanceof Collection) && collectionQ0.isEmpty()) {
                        z10 = true;
                    } else {
                        Iterator<T> it = collectionQ0.iterator();
                        while (it.hasNext()) {
                            if (!t(f14277a, f1Var, kVar, (na.i) it.next(), false, 8, null)) {
                            }
                        }
                        z10 = true;
                    }
                    return Boolean.valueOf(z10);
                }
                na.n nVarF2 = pVarJ.f(kVar);
                if (!(kVar instanceof na.d)) {
                    if (pVarJ.x(nVarF2)) {
                        Collection<na.i> collectionQ1 = pVarJ.q0(nVarF2);
                        if (!(collectionQ1 instanceof Collection) || !collectionQ1.isEmpty()) {
                            Iterator<T> it2 = collectionQ1.iterator();
                            while (it2.hasNext()) {
                                if (!(((na.i) it2.next()) instanceof na.d)) {
                                }
                            }
                            oVarM = f14277a.m(f1Var.j(), kVar2, kVar);
                            if (oVarM != null) {
                                return Boolean.TRUE;
                            }
                        } else {
                            oVarM = f14277a.m(f1Var.j(), kVar2, kVar);
                            if (oVarM != null) {
                                return Boolean.TRUE;
                            }
                        }
                    }
                } else {
                    oVarM = f14277a.m(f1Var.j(), kVar2, kVar);
                    if (oVarM != null && pVarJ.r(oVarM, pVarJ.f(kVar2))) {
                        return Boolean.TRUE;
                    }
                }
                return null;
            }
            return Boolean.valueOf(f1Var.n());
        }
        if (f1Var.m()) {
            return Boolean.TRUE;
        }
        if (pVarJ.h0(kVar) && !pVarJ.h0(kVar2)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(d.f14269a.b(pVarJ, pVarJ.g(kVar, false), pVarJ.g(kVar2, false)));
    }

    private final List<na.k> g(f1 f1Var, na.k kVar, na.n nVar) {
        f1.c cVarE;
        na.p pVarJ = f1Var.j();
        List<na.k> listO0 = pVarJ.o0(kVar, nVar);
        if (listO0 != null) {
            return listO0;
        }
        if (!pVarJ.p(nVar) && pVarJ.u(kVar)) {
            return kotlin.collections.r.l();
        }
        if (pVarJ.y(nVar)) {
            if (pVarJ.S(pVarJ.f(kVar), nVar)) {
                na.k kVarL = pVarJ.L(kVar, na.b.FOR_SUBTYPING);
                if (kVarL != null) {
                    kVar = kVarL;
                }
                return kotlin.collections.r.e(kVar);
            }
            return kotlin.collections.r.l();
        }
        sa.f fVar = new sa.f();
        f1Var.k();
        ArrayDeque<na.k> arrayDequeH = f1Var.h();
        kotlin.jvm.internal.m.c(arrayDequeH);
        Set<na.k> setI = f1Var.i();
        kotlin.jvm.internal.m.c(setI);
        arrayDequeH.push(kVar);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() <= 1000) {
                na.k current = arrayDequeH.pop();
                kotlin.jvm.internal.m.e(current, "current");
                if (setI.add(current)) {
                    na.k kVarL2 = pVarJ.L(current, na.b.FOR_SUBTYPING);
                    if (kVarL2 == null) {
                        kVarL2 = current;
                    }
                    if (pVarJ.S(pVarJ.f(kVarL2), nVar)) {
                        fVar.add(kVarL2);
                        cVarE = f1.c.C0269c.f14302a;
                    } else if (pVarJ.D0(kVarL2) == 0) {
                        cVarE = f1.c.b.f14301a;
                    } else {
                        cVarE = f1Var.j().E(kVarL2);
                    }
                    if (kotlin.jvm.internal.m.a(cVarE, f1.c.C0269c.f14302a)) {
                        cVarE = null;
                    }
                    if (cVarE != null) {
                        na.p pVarJ2 = f1Var.j();
                        Iterator<na.i> it = pVarJ2.q0(pVarJ2.f(current)).iterator();
                        while (it.hasNext()) {
                            arrayDequeH.add(cVarE.a(f1Var, it.next()));
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + kVar + ". Supertypes = " + kotlin.collections.r.q0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
        }
        f1Var.e();
        return fVar;
    }

    private final List<na.k> h(f1 f1Var, na.k kVar, na.n nVar) {
        return w(f1Var, g(f1Var, kVar, nVar));
    }

    private final boolean i(f1 f1Var, na.i iVar, na.i iVar2, boolean z10) {
        na.p pVarJ = f1Var.j();
        na.i iVarO = f1Var.o(f1Var.p(iVar));
        na.i iVarO2 = f1Var.o(f1Var.p(iVar2));
        f fVar = f14277a;
        Boolean boolF = fVar.f(f1Var, pVarJ.M(iVarO), pVarJ.d0(iVarO2));
        if (boolF != null) {
            boolean zBooleanValue = boolF.booleanValue();
            f1Var.c(iVarO, iVarO2, z10);
            return zBooleanValue;
        }
        Boolean boolC = f1Var.c(iVarO, iVarO2, z10);
        if (boolC != null) {
            return boolC.booleanValue();
        }
        return fVar.u(f1Var, pVarJ.M(iVarO), pVarJ.d0(iVarO2));
    }

    private final na.o m(na.p pVar, na.i iVar, na.i iVar2) {
        na.i iVarM;
        boolean z10;
        int iD0 = pVar.D0(iVar);
        int i10 = 0;
        while (true) {
            na.m mVar = null;
            if (i10 >= iD0) {
                return null;
            }
            na.m mVarP = pVar.P(iVar, i10);
            if (!pVar.o(mVarP)) {
                mVar = mVarP;
            }
            if (mVar != null && (iVarM = pVar.m(mVar)) != null) {
                if (pVar.C(pVar.F0(pVar.M(iVarM))) && pVar.C(pVar.F0(pVar.M(iVar2)))) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!kotlin.jvm.internal.m.a(iVarM, iVar2) && (!z10 || !kotlin.jvm.internal.m.a(pVar.y0(iVarM), pVar.y0(iVar2)))) {
                    na.o oVarM = m(pVar, iVarM, iVar2);
                    if (oVarM != null) {
                        return oVarM;
                    }
                } else {
                    return pVar.u0(pVar.y0(iVar), i10);
                }
            }
            i10++;
        }
    }

    private final boolean n(f1 f1Var, na.k kVar) {
        f1.c cVar;
        na.p pVarJ = f1Var.j();
        na.n nVarF = pVarJ.f(kVar);
        if (pVarJ.p(nVarF)) {
            return pVarJ.Z(nVarF);
        }
        if (pVarJ.Z(pVarJ.f(kVar))) {
            return true;
        }
        f1Var.k();
        ArrayDeque<na.k> arrayDequeH = f1Var.h();
        kotlin.jvm.internal.m.c(arrayDequeH);
        Set<na.k> setI = f1Var.i();
        kotlin.jvm.internal.m.c(setI);
        arrayDequeH.push(kVar);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() <= 1000) {
                na.k current = arrayDequeH.pop();
                kotlin.jvm.internal.m.e(current, "current");
                if (setI.add(current)) {
                    if (pVarJ.u(current)) {
                        cVar = f1.c.C0269c.f14302a;
                    } else {
                        cVar = f1.c.b.f14301a;
                    }
                    if (kotlin.jvm.internal.m.a(cVar, f1.c.C0269c.f14302a)) {
                        cVar = null;
                    }
                    if (cVar == null) {
                        continue;
                    } else {
                        na.p pVarJ2 = f1Var.j();
                        Iterator<na.i> it = pVarJ2.q0(pVarJ2.f(current)).iterator();
                        while (it.hasNext()) {
                            na.k kVarA = cVar.a(f1Var, it.next());
                            if (pVarJ.Z(pVarJ.f(kVarA))) {
                                f1Var.e();
                                return true;
                            }
                            arrayDequeH.add(kVarA);
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + kVar + ". Supertypes = " + kotlin.collections.r.q0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
        }
        f1Var.e();
        return false;
    }

    private final boolean o(na.p pVar, na.i iVar) {
        if (pVar.C0(pVar.y0(iVar)) && !pVar.K(iVar) && !pVar.n(iVar) && !pVar.Q(iVar) && kotlin.jvm.internal.m.a(pVar.f(pVar.M(iVar)), pVar.f(pVar.d0(iVar)))) {
            return true;
        }
        return false;
    }

    private final boolean p(na.p pVar, na.k kVar, na.k kVar2) {
        na.k kVarJ;
        na.k kVarJ2;
        na.e eVarX0 = pVar.x0(kVar);
        if (eVarX0 == null || (kVarJ = pVar.J(eVarX0)) == null) {
            kVarJ = kVar;
        }
        na.e eVarX1 = pVar.x0(kVar2);
        if (eVarX1 == null || (kVarJ2 = pVar.J(eVarX1)) == null) {
            kVarJ2 = kVar2;
        }
        if (pVar.f(kVarJ) != pVar.f(kVarJ2)) {
            return false;
        }
        if (!pVar.n(kVar) && pVar.n(kVar2)) {
            return false;
        }
        if (pVar.h0(kVar) && !pVar.h0(kVar2)) {
            return false;
        }
        return true;
    }

    private final boolean v(na.p pVar, na.i iVar, na.i iVar2, na.n nVar) {
        na.t tVar;
        na.o oVarT;
        na.k kVarA = pVar.a(iVar);
        if (kVarA instanceof na.d) {
            na.d dVar = (na.d) kVarA;
            if (pVar.D(dVar) || !pVar.o(pVar.p0(pVar.k(dVar))) || pVar.k0(dVar) != na.b.FOR_SUBTYPING) {
                return false;
            }
            na.n nVarY0 = pVar.y0(iVar2);
            if (nVarY0 instanceof na.t) {
                tVar = (na.t) nVarY0;
            } else {
                tVar = null;
            }
            if (tVar != null && (oVarT = pVar.t(tVar)) != null && pVar.r(oVarT, nVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<na.k> w(f1 f1Var, List<? extends na.k> list) {
        na.p pVarJ = f1Var.j();
        if (list.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                na.l lVarW0 = pVarJ.w0((na.k) obj);
                int iJ0 = pVarJ.j0(lVarW0);
                int i10 = 0;
                while (true) {
                    if (i10 < iJ0) {
                        if (pVarJ.r0(pVarJ.m(pVarJ.s(lVarW0, i10))) != null) {
                            break;
                        }
                        i10++;
                    } else {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return list;
    }
}
