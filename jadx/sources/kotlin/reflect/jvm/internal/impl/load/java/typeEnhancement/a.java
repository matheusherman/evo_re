package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.y;
import na.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a<TAnnotation> {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class C0233a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final na.i f13425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final y f13426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final na.o f13427c;

        public final y a() {
            return this.f13426b;
        }

        public final na.i b() {
            return this.f13425a;
        }

        public final na.o c() {
            return this.f13427c;
        }

        public C0233a(na.i iVar, y yVar, na.o oVar) {
            this.f13425a = iVar;
            this.f13426b = yVar;
            this.f13427c = oVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<Integer, e> {
        final /* synthetic */ e[] $computedResult;
        final /* synthetic */ q $predefined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(q qVar, e[] eVarArr) {
            super(1);
            this.$predefined = qVar;
            this.$computedResult = eVarArr;
        }

        public final e a(int i10) {
            Map<Integer, e> mapA;
            e eVar;
            q qVar = this.$predefined;
            if (qVar != null && (mapA = qVar.a()) != null && (eVar = mapA.get(Integer.valueOf(i10))) != null) {
                return eVar;
            }
            e[] eVarArr = this.$computedResult;
            return (i10 < 0 || i10 > kotlin.collections.j.R(eVarArr)) ? e.f13436e.a() : eVarArr[i10];
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ e invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<TAnnotation, Boolean> {
        final /* synthetic */ C0233a $this_extractQualifiersFromAnnotations;
        final /* synthetic */ a<TAnnotation> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a<TAnnotation> aVar, C0233a c0233a) {
            super(1);
            this.this$0 = aVar;
            this.$this_extractQualifiersFromAnnotations = c0233a;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(TAnnotation extractNullability) {
            kotlin.jvm.internal.m.f(extractNullability, "$this$extractNullability");
            return Boolean.valueOf(this.this$0.h(extractNullability, this.$this_extractQualifiersFromAnnotations.b()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.l<C0233a, Iterable<? extends C0233a>> {
        final /* synthetic */ na.p $this_with;
        final /* synthetic */ a<TAnnotation> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(a<TAnnotation> aVar, na.p pVar) {
            super(1);
            this.this$0 = aVar;
            this.$this_with = pVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Iterable<C0233a> invoke(C0233a it) {
            na.n nVarY0;
            List<na.o> listI;
            C0233a c0233a;
            na.g gVarR0;
            kotlin.jvm.internal.m.f(it, "it");
            if (this.this$0.u()) {
                na.i iVarB = it.b();
                if (((iVarB == null || (gVarR0 = this.$this_with.r0(iVarB)) == null) ? null : this.$this_with.v(gVarR0)) != null) {
                    return null;
                }
            }
            na.i iVarB2 = it.b();
            if (iVarB2 == null || (nVarY0 = this.$this_with.y0(iVarB2)) == null || (listI = this.$this_with.i(nVarY0)) == null) {
                return null;
            }
            List<na.o> list = listI;
            List<na.m> listR = this.$this_with.R(it.b());
            na.p pVar = this.$this_with;
            a<TAnnotation> aVar = this.this$0;
            Iterator<T> it2 = list.iterator();
            Iterator<T> it3 = listR.iterator();
            ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.r.w(list, 10), kotlin.collections.r.w(listR, 10)));
            while (it2.hasNext() && it3.hasNext()) {
                Object next = it2.next();
                na.m mVar = (na.m) it3.next();
                na.o oVar = (na.o) next;
                if (pVar.o(mVar)) {
                    c0233a = new C0233a(null, it.a(), oVar);
                } else {
                    na.i iVarM = pVar.m(mVar);
                    c0233a = new C0233a(iVarM, aVar.c(iVarM, it.a()), oVar);
                }
                arrayList.add(c0233a);
            }
            return arrayList;
        }
    }

    public abstract boolean A(na.i iVar);

    public abstract boolean h(TAnnotation tannotation, na.i iVar);

    public abstract kotlin.reflect.jvm.internal.impl.load.java.a<TAnnotation> i();

    public abstract Iterable<TAnnotation> j(na.i iVar);

    public abstract Iterable<TAnnotation> l();

    public abstract kotlin.reflect.jvm.internal.impl.load.java.b m();

    public abstract y n();

    public abstract boolean o();

    public abstract boolean p();

    public abstract na.i q(na.i iVar);

    public boolean r() {
        return false;
    }

    public abstract ba.d s(na.i iVar);

    public abstract boolean u();

    public abstract na.p v();

    public abstract boolean w(na.i iVar);

    public abstract boolean x();

    public abstract boolean y(na.i iVar, na.i iVar2);

    public abstract boolean z(na.o oVar);

    private final i B(i iVar, i iVar2) {
        if (iVar == null) {
            return iVar2;
        }
        return (iVar2 != null && ((iVar.d() && !iVar2.d()) || ((iVar.d() || !iVar2.d()) && (iVar.c().compareTo(iVar2.c()) < 0 || iVar.c().compareTo(iVar2.c()) <= 0)))) ? iVar2 : iVar;
    }

    private final <T> List<T> f(T t10, c9.l<? super T, ? extends Iterable<? extends T>> lVar) {
        ArrayList arrayList = new ArrayList(1);
        g(t10, arrayList, lVar);
        return arrayList;
    }

    public final c9.l<Integer, e> b(na.i iVar, Iterable<? extends na.i> overrides, q qVar, boolean z10) {
        int size;
        na.i iVarB;
        kotlin.jvm.internal.m.f(iVar, "<this>");
        kotlin.jvm.internal.m.f(overrides, "overrides");
        List<C0233a> listC = C(iVar);
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(overrides, 10));
        Iterator<? extends na.i> it = overrides.iterator();
        while (it.hasNext()) {
            arrayList.add(C(it.next()));
        }
        if (r()) {
            size = 1;
        } else {
            if (x() && (!(overrides instanceof Collection) || !((Collection) overrides).isEmpty())) {
                Iterator<? extends na.i> it2 = overrides.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!y(iVar, it2.next())) {
                            size = 1;
                        }
                    }
                }
            }
            size = listC.size();
        }
        e[] eVarArr = new e[size];
        int i10 = 0;
        while (i10 < size) {
            e eVarE = e(listC.get(i10));
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                C0233a c0233a = (C0233a) kotlin.collections.r.j0((List) it3.next(), i10);
                e eVarD = (c0233a == null || (iVarB = c0233a.b()) == null) ? null : d(iVarB);
                if (eVarD != null) {
                    arrayList2.add(eVarD);
                }
            }
            eVarArr[i10] = s.a(eVarE, arrayList2, i10 == 0 && x(), i10 == 0 && o(), z10);
            i10++;
        }
        return new b(qVar, eVarArr);
    }

    private final List<C0233a> C(na.i iVar) {
        return f(new C0233a(iVar, c(iVar, n()), null), new d(this, v()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y c(na.i iVar, y yVar) {
        return i().c(yVar, j(iVar));
    }

    private final e d(na.i iVar) {
        h hVarT;
        boolean z10;
        h hVarT2 = t(iVar);
        f fVar = null;
        if (hVarT2 == null) {
            na.i iVarQ = q(iVar);
            if (iVarQ != null) {
                hVarT = t(iVarQ);
            } else {
                hVarT = null;
            }
        } else {
            hVarT = hVarT2;
        }
        na.p pVarV = v();
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a;
        if (cVar.l(s(pVarV.M(iVar)))) {
            fVar = f.READ_ONLY;
        } else if (cVar.k(s(pVarV.d0(iVar)))) {
            fVar = f.MUTABLE;
        }
        boolean z11 = true;
        if (!v().n(iVar) && !A(iVar)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (hVarT == hVarT2) {
            z11 = false;
        }
        return new e(hVarT, fVar, z10, z11);
    }

    private final e e(C0233a c0233a) {
        boolean z10;
        List listL;
        na.o oVarL0;
        boolean z11;
        kotlin.reflect.jvm.internal.impl.load.java.b bVarM;
        kotlin.reflect.jvm.internal.impl.load.java.r rVarA;
        i iVarK;
        i iVarD;
        h hVarC;
        boolean z12;
        i iVarK2;
        na.i iVarB;
        na.n nVarY0;
        u uVarH;
        h hVarC2 = null;
        if (c0233a.b() == null) {
            na.p pVarV = v();
            na.o oVarC = c0233a.c();
            if (oVarC != null) {
                uVarH = pVarV.H(oVarC);
            } else {
                uVarH = null;
            }
            if (uVarH == u.IN) {
                return e.f13436e.a();
            }
        }
        boolean z13 = false;
        if (c0233a.c() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        na.i iVarB2 = c0233a.b();
        if (iVarB2 == null || (listL = j(iVarB2)) == null) {
            listL = kotlin.collections.r.l();
        }
        na.p pVarV2 = v();
        na.i iVarB3 = c0233a.b();
        if (iVarB3 != null && (nVarY0 = pVarV2.y0(iVarB3)) != null) {
            oVarL0 = pVarV2.l0(nVarY0);
        } else {
            oVarL0 = null;
        }
        if (m() == kotlin.reflect.jvm.internal.impl.load.java.b.TYPE_PARAMETER_BOUNDS) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            if (!z11 && p() && (iVarB = c0233a.b()) != null && w(iVarB)) {
                Iterable<TAnnotation> iterableL = l();
                ArrayList arrayList = new ArrayList();
                for (TAnnotation tannotation : iterableL) {
                    if (!i().m(tannotation)) {
                        arrayList.add(tannotation);
                    }
                }
                listL = kotlin.collections.r.B0(arrayList, listL);
            } else {
                listL = kotlin.collections.r.z0(l(), listL);
            }
        }
        f fVarE = i().e(listL);
        i iVarF = i().f(listL, new c(this, c0233a));
        if (iVarF != null) {
            h hVarC3 = iVarF.c();
            if (iVarF.c() == h.NOT_NULL && oVarL0 != null) {
                z13 = true;
            }
            return new e(hVarC3, fVarE, z13, iVarF.d());
        }
        if (!z10 && !z11) {
            bVarM = kotlin.reflect.jvm.internal.impl.load.java.b.TYPE_USE;
        } else {
            bVarM = m();
        }
        y yVarA = c0233a.a();
        if (yVarA != null) {
            rVarA = yVarA.a(bVarM);
        } else {
            rVarA = null;
        }
        if (oVarL0 != null) {
            iVarK = k(oVarL0);
        } else {
            iVarK = null;
        }
        if (iVarK == null || (iVarD = i.b(iVarK, h.NOT_NULL, false, 2, null)) == null) {
            if (rVarA != null) {
                iVarD = rVarA.d();
            } else {
                iVarD = null;
            }
        }
        if (iVarK != null) {
            hVarC = iVarK.c();
        } else {
            hVarC = null;
        }
        if (hVarC != h.NOT_NULL && (oVarL0 == null || rVarA == null || !rVarA.c())) {
            z12 = false;
        } else {
            z12 = true;
        }
        na.o oVarC2 = c0233a.c();
        if (oVarC2 != null && (iVarK2 = k(oVarC2)) != null) {
            if (iVarK2.c() == h.NULLABLE) {
                iVarK2 = i.b(iVarK2, h.FORCE_FLEXIBILITY, false, 2, null);
            }
        } else {
            iVarK2 = null;
        }
        i iVarB4 = B(iVarK2, iVarD);
        if (iVarB4 != null) {
            hVarC2 = iVarB4.c();
        }
        if (iVarB4 != null && iVarB4.d()) {
            z13 = true;
        }
        return new e(hVarC2, fVarE, z12, z13);
    }

    private final <T> void g(T t10, List<T> list, c9.l<? super T, ? extends Iterable<? extends T>> lVar) {
        list.add(t10);
        Iterable<? extends T> iterableInvoke = lVar.invoke(t10);
        if (iterableInvoke != null) {
            Iterator<? extends T> it = iterableInvoke.iterator();
            while (it.hasNext()) {
                g(it.next(), list, lVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00af  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:? A[LOOP:3: B:46:0x00b3->B:72:?, LOOP_END, SYNTHETIC] */
    private final i k(na.o oVar) {
        List<na.i> arrayList;
        List<na.i> list;
        Iterator<T> it;
        h hVar;
        boolean z10;
        na.p pVarV = v();
        if (!z(oVar)) {
            return null;
        }
        List<na.i> listZ0 = pVarV.z0(oVar);
        List<na.i> list2 = listZ0;
        boolean z11 = list2 instanceof Collection;
        if (!z11 || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!pVarV.v0((na.i) it2.next())) {
                    if (!z11 || !list2.isEmpty()) {
                        Iterator<T> it3 = list2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (t((na.i) it3.next()) != null) {
                                    arrayList = listZ0;
                                }
                            }
                            list = arrayList;
                            if ((list instanceof Collection) || !list.isEmpty()) {
                                it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (!pVarV.l((na.i) it.next())) {
                                            hVar = h.NOT_NULL;
                                            break;
                                        }
                                    } else {
                                        hVar = h.NULLABLE;
                                        break;
                                    }
                                }
                            } else {
                                hVar = h.NULLABLE;
                                break;
                            }
                            if (arrayList != listZ0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            return new i(hVar, z10);
                        }
                    }
                    if (!z11 || !list2.isEmpty()) {
                        Iterator<T> it4 = list2.iterator();
                        while (it4.hasNext()) {
                            if (q((na.i) it4.next()) != null) {
                                arrayList = new ArrayList<>();
                                Iterator<T> it5 = list2.iterator();
                                while (it5.hasNext()) {
                                    na.i iVarQ = q((na.i) it5.next());
                                    if (iVarQ != null) {
                                        arrayList.add(iVarQ);
                                    }
                                }
                                list = arrayList;
                                if (list instanceof Collection) {
                                    it = list.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (!pVarV.l((na.i) it.next())) {
                                                hVar = h.NOT_NULL;
                                                break;
                                            }
                                        } else {
                                            hVar = h.NULLABLE;
                                            break;
                                        }
                                    }
                                } else {
                                    it = list.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (!pVarV.l((na.i) it.next())) {
                                                hVar = h.NOT_NULL;
                                                break;
                                            }
                                        } else {
                                            hVar = h.NULLABLE;
                                            break;
                                        }
                                    }
                                }
                                if (arrayList != listZ0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                return new i(hVar, z10);
                            }
                        }
                        break;
                    }
                    break;
                }
            }
        }
        return null;
    }

    private final h t(na.i iVar) {
        na.p pVarV = v();
        if (pVarV.h0(pVarV.M(iVar))) {
            return h.NULLABLE;
        }
        if (!pVarV.h0(pVarV.d0(iVar))) {
            return h.NOT_NULL;
        }
        return null;
    }
}
