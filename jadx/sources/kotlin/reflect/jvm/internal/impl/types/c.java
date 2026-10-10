package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14228a = new c();

    public final boolean a(f1 f1Var, na.k type, f1.c supertypesPolicy) {
        kotlin.jvm.internal.m.f(f1Var, "<this>");
        kotlin.jvm.internal.m.f(type, "type");
        kotlin.jvm.internal.m.f(supertypesPolicy, "supertypesPolicy");
        na.p pVarJ = f1Var.j();
        if ((pVarJ.u(type) && !pVarJ.h0(type)) || pVarJ.n(type)) {
            return true;
        }
        f1Var.k();
        ArrayDeque<na.k> arrayDequeH = f1Var.h();
        kotlin.jvm.internal.m.c(arrayDequeH);
        Set<na.k> setI = f1Var.i();
        kotlin.jvm.internal.m.c(setI);
        arrayDequeH.push(type);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + type + ". Supertypes = " + kotlin.collections.r.q0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
            na.k current = arrayDequeH.pop();
            kotlin.jvm.internal.m.e(current, "current");
            if (setI.add(current)) {
                f1.c cVar = pVarJ.h0(current) ? f1.c.C0269c.f14302a : supertypesPolicy;
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
                        if ((pVarJ.u(kVarA) && !pVarJ.h0(kVarA)) || pVarJ.n(kVarA)) {
                            f1Var.e();
                            return true;
                        }
                        arrayDequeH.add(kVarA);
                    }
                }
            }
        }
        f1Var.e();
        return false;
    }

    public final boolean b(f1 state, na.k start, na.n end) {
        kotlin.jvm.internal.m.f(state, "state");
        kotlin.jvm.internal.m.f(start, "start");
        kotlin.jvm.internal.m.f(end, "end");
        na.p pVarJ = state.j();
        if (f14228a.c(state, start, end)) {
            return true;
        }
        state.k();
        ArrayDeque<na.k> arrayDequeH = state.h();
        kotlin.jvm.internal.m.c(arrayDequeH);
        Set<na.k> setI = state.i();
        kotlin.jvm.internal.m.c(setI);
        arrayDequeH.push(start);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + start + ". Supertypes = " + kotlin.collections.r.q0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
            na.k current = arrayDequeH.pop();
            kotlin.jvm.internal.m.e(current, "current");
            if (setI.add(current)) {
                f1.c cVar = pVarJ.h0(current) ? f1.c.C0269c.f14302a : f1.c.b.f14301a;
                if (kotlin.jvm.internal.m.a(cVar, f1.c.C0269c.f14302a)) {
                    cVar = null;
                }
                if (cVar == null) {
                    continue;
                } else {
                    na.p pVarJ2 = state.j();
                    Iterator<na.i> it = pVarJ2.q0(pVarJ2.f(current)).iterator();
                    while (it.hasNext()) {
                        na.k kVarA = cVar.a(state, it.next());
                        if (f14228a.c(state, kVarA, end)) {
                            state.e();
                            return true;
                        }
                        arrayDequeH.add(kVarA);
                    }
                }
            }
        }
        state.e();
        return false;
    }

    public final boolean d(f1 state, na.k subType, na.k superType) {
        kotlin.jvm.internal.m.f(state, "state");
        kotlin.jvm.internal.m.f(subType, "subType");
        kotlin.jvm.internal.m.f(superType, "superType");
        return e(state, subType, superType);
    }

    private c() {
    }

    private final boolean c(f1 f1Var, na.k kVar, na.n nVar) {
        na.p pVarJ = f1Var.j();
        if (pVarJ.O(kVar)) {
            return true;
        }
        if (pVarJ.h0(kVar)) {
            return false;
        }
        if (f1Var.n() && pVarJ.T(kVar)) {
            return true;
        }
        return pVarJ.S(pVarJ.f(kVar), nVar);
    }

    private final boolean e(f1 f1Var, na.k kVar, na.k kVar2) {
        na.p pVarJ = f1Var.j();
        if (f.f14278b) {
            if (!pVarJ.b(kVar) && !pVarJ.x(pVarJ.f(kVar))) {
                f1Var.l(kVar);
            }
            if (!pVarJ.b(kVar2)) {
                f1Var.l(kVar2);
            }
        }
        if (pVarJ.h0(kVar2) || pVarJ.n(kVar) || pVarJ.Q(kVar)) {
            return true;
        }
        if ((kVar instanceof na.d) && pVarJ.i0((na.d) kVar)) {
            return true;
        }
        c cVar = f14228a;
        if (cVar.a(f1Var, kVar, f1.c.b.f14301a)) {
            return true;
        }
        if (pVarJ.n(kVar2) || cVar.a(f1Var, kVar2, f1.c.d.f14303a) || pVarJ.u(kVar)) {
            return false;
        }
        return cVar.b(f1Var, kVar, pVarJ.f(kVar2));
    }
}
