package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class l0 extends a0 {
    private static s d(p0 p0Var, Iterator<s> it, s sVar) {
        if (it != null) {
            while (it.hasNext()) {
                s sVarA = p0Var.a(it.next()).a((g) sVar);
                if (sVarA instanceof l) {
                    l lVar = (l) sVarA;
                    if ("break".equals(lVar.b())) {
                        return s.f3010a0;
                    }
                    if ("return".equals(lVar.b())) {
                        return lVar;
                    }
                }
            }
        }
        return s.f3010a0;
    }

    private static s e(p0 p0Var, s sVar, s sVar2) {
        if (sVar instanceof Iterable) {
            return d(p0Var, ((Iterable) sVar).iterator(), sVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0087  */
    /* JADX WARN: Code duplicated, block: B:21:0x0093  */
    /* JADX WARN: Code duplicated, block: B:88:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.a0
    public final s b(String str, v6 v6Var, List<s> list) {
        s sVarA;
        l lVar;
        switch (o0.f2902a[c5.c(str).ordinal()]) {
            case 1:
                c5.f(y0.FOR_IN, 3, list);
                if (!(list.get(0) instanceof u)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                }
                String strF = list.get(0).f();
                return c(new s0(v6Var, strF), v6Var.b(list.get(1)), v6Var.b(list.get(2)));
            case 2:
                c5.f(y0.FOR_IN_CONST, 3, list);
                if (!(list.get(0) instanceof u)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                }
                String strF2 = list.get(0).f();
                return c(new n0(v6Var, strF2), v6Var.b(list.get(1)), v6Var.b(list.get(2)));
            case 3:
                c5.f(y0.FOR_IN_LET, 3, list);
                if (!(list.get(0) instanceof u)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                }
                String strF3 = list.get(0).f();
                return c(new q0(v6Var, strF3), v6Var.b(list.get(1)), v6Var.b(list.get(2)));
            case 4:
                c5.f(y0.FOR_LET, 4, list);
                s sVarB = v6Var.b(list.get(0));
                if (!(sVarB instanceof g)) {
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                }
                g gVar = (g) sVarB;
                s sVar = list.get(1);
                s sVar2 = list.get(2);
                s sVarB2 = v6Var.b(list.get(3));
                v6 v6VarD = v6Var.d();
                for (int i10 = 0; i10 < gVar.t(); i10++) {
                    String strF4 = gVar.q(i10).f();
                    v6VarD.h(strF4, v6Var.c(strF4));
                }
                while (v6Var.b(sVar).e().booleanValue()) {
                    s sVarA2 = v6Var.a((g) sVarB2);
                    if (sVarA2 instanceof l) {
                        l lVar2 = (l) sVarA2;
                        if ("break".equals(lVar2.b())) {
                            return s.f3010a0;
                        }
                        if ("return".equals(lVar2.b())) {
                            return lVar2;
                        }
                    }
                    v6 v6VarD2 = v6Var.d();
                    for (int i11 = 0; i11 < gVar.t(); i11++) {
                        String strF5 = gVar.q(i11).f();
                        v6VarD2.h(strF5, v6VarD.c(strF5));
                    }
                    v6VarD2.b(sVar2);
                    v6VarD = v6VarD2;
                }
                return s.f3010a0;
            case 5:
                c5.f(y0.FOR_OF, 3, list);
                if (!(list.get(0) instanceof u)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                }
                String strF6 = list.get(0).f();
                return e(new s0(v6Var, strF6), v6Var.b(list.get(1)), v6Var.b(list.get(2)));
            case 6:
                c5.f(y0.FOR_OF_CONST, 3, list);
                if (!(list.get(0) instanceof u)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                }
                String strF7 = list.get(0).f();
                return e(new n0(v6Var, strF7), v6Var.b(list.get(1)), v6Var.b(list.get(2)));
            case 7:
                c5.f(y0.FOR_OF_LET, 3, list);
                if (!(list.get(0) instanceof u)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                }
                String strF8 = list.get(0).f();
                return e(new q0(v6Var, strF8), v6Var.b(list.get(1)), v6Var.b(list.get(2)));
            case 8:
                c5.f(y0.WHILE, 4, list);
                s sVar3 = list.get(0);
                s sVar4 = list.get(1);
                s sVar5 = list.get(2);
                s sVarB3 = v6Var.b(list.get(3));
                if (v6Var.b(sVar5).e().booleanValue()) {
                    s sVarA3 = v6Var.a((g) sVarB3);
                    if (sVarA3 instanceof l) {
                        l lVar3 = (l) sVarA3;
                        if (!"break".equals(lVar3.b())) {
                            if ("return".equals(lVar3.b())) {
                                return lVar3;
                            }
                            while (v6Var.b(sVar3).e().booleanValue()) {
                                sVarA = v6Var.a((g) sVarB3);
                                if (sVarA instanceof l) {
                                    lVar = (l) sVarA;
                                    if (!"break".equals(lVar.b())) {
                                        if ("return".equals(lVar.b())) {
                                            return lVar;
                                        }
                                    }
                                }
                                v6Var.b(sVar4);
                            }
                        }
                    } else {
                        while (v6Var.b(sVar3).e().booleanValue()) {
                            sVarA = v6Var.a((g) sVarB3);
                            if (sVarA instanceof l) {
                                lVar = (l) sVarA;
                                if (!"break".equals(lVar.b())) {
                                    if ("return".equals(lVar.b())) {
                                        return lVar;
                                    }
                                }
                            }
                            v6Var.b(sVar4);
                        }
                    }
                } else {
                    while (v6Var.b(sVar3).e().booleanValue()) {
                        sVarA = v6Var.a((g) sVarB3);
                        if (sVarA instanceof l) {
                            lVar = (l) sVarA;
                            if (!"break".equals(lVar.b())) {
                                if ("return".equals(lVar.b())) {
                                    return lVar;
                                }
                            }
                        }
                        v6Var.b(sVar4);
                    }
                }
                return s.f3010a0;
            default:
                return super.a(str);
        }
    }

    protected l0() {
        this.f2523a.add(y0.FOR_IN);
        this.f2523a.add(y0.FOR_IN_CONST);
        this.f2523a.add(y0.FOR_IN_LET);
        this.f2523a.add(y0.FOR_LET);
        this.f2523a.add(y0.FOR_OF);
        this.f2523a.add(y0.FOR_OF_CONST);
        this.f2523a.add(y0.FOR_OF_LET);
        this.f2523a.add(y0.WHILE);
    }

    private static s c(p0 p0Var, s sVar, s sVar2) {
        return d(p0Var, sVar.h(), sVar2);
    }
}
