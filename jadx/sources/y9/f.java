package y9;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import w9.n;
import w9.q;
import w9.s;
import w9.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class f {
    public static final q a(q qVar, g typeTable) {
        m.f(qVar, "<this>");
        m.f(typeTable, "typeTable");
        if (qVar.j0()) {
            return qVar.R();
        }
        if (qVar.k0()) {
            return typeTable.a(qVar.S());
        }
        return null;
    }

    public static final List<q> b(w9.c cVar, g typeTable) {
        m.f(cVar, "<this>");
        m.f(typeTable, "typeTable");
        List<q> listX0 = cVar.x0();
        if (listX0.isEmpty()) {
            listX0 = null;
        }
        if (listX0 == null) {
            List<Integer> contextReceiverTypeIdList = cVar.w0();
            m.e(contextReceiverTypeIdList, "contextReceiverTypeIdList");
            List<Integer> list = contextReceiverTypeIdList;
            listX0 = new ArrayList<>(r.w(list, 10));
            for (Integer it : list) {
                m.e(it, "it");
                listX0.add(typeTable.a(it.intValue()));
            }
        }
        return listX0;
    }

    public static final List<q> c(w9.i iVar, g typeTable) {
        m.f(iVar, "<this>");
        m.f(typeTable, "typeTable");
        List<q> listY = iVar.Y();
        if (listY.isEmpty()) {
            listY = null;
        }
        if (listY == null) {
            List<Integer> contextReceiverTypeIdList = iVar.X();
            m.e(contextReceiverTypeIdList, "contextReceiverTypeIdList");
            List<Integer> list = contextReceiverTypeIdList;
            listY = new ArrayList<>(r.w(list, 10));
            for (Integer it : list) {
                m.e(it, "it");
                listY.add(typeTable.a(it.intValue()));
            }
        }
        return listY;
    }

    public static final List<q> d(n nVar, g typeTable) {
        m.f(nVar, "<this>");
        m.f(typeTable, "typeTable");
        List<q> listX = nVar.X();
        if (listX.isEmpty()) {
            listX = null;
        }
        if (listX == null) {
            List<Integer> contextReceiverTypeIdList = nVar.W();
            m.e(contextReceiverTypeIdList, "contextReceiverTypeIdList");
            List<Integer> list = contextReceiverTypeIdList;
            listX = new ArrayList<>(r.w(list, 10));
            for (Integer it : list) {
                m.e(it, "it");
                listX.add(typeTable.a(it.intValue()));
            }
        }
        return listX;
    }

    public static final q e(w9.r rVar, g typeTable) {
        m.f(rVar, "<this>");
        m.f(typeTable, "typeTable");
        if (rVar.d0()) {
            q expandedType = rVar.T();
            m.e(expandedType, "expandedType");
            return expandedType;
        }
        if (rVar.e0()) {
            return typeTable.a(rVar.U());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias");
    }

    public static final q f(q qVar, g typeTable) {
        m.f(qVar, "<this>");
        m.f(typeTable, "typeTable");
        if (qVar.o0()) {
            return qVar.b0();
        }
        if (qVar.p0()) {
            return typeTable.a(qVar.c0());
        }
        return null;
    }

    public static final boolean g(w9.i iVar) {
        m.f(iVar, "<this>");
        return iVar.v0() || iVar.w0();
    }

    public static final boolean h(n nVar) {
        m.f(nVar, "<this>");
        return nVar.s0() || nVar.t0();
    }

    public static final q i(w9.c cVar, g typeTable) {
        m.f(cVar, "<this>");
        m.f(typeTable, "typeTable");
        if (cVar.o1()) {
            return cVar.J0();
        }
        if (cVar.p1()) {
            return typeTable.a(cVar.K0());
        }
        return null;
    }

    public static final q j(q qVar, g typeTable) {
        m.f(qVar, "<this>");
        m.f(typeTable, "typeTable");
        if (qVar.r0()) {
            return qVar.e0();
        }
        if (qVar.s0()) {
            return typeTable.a(qVar.f0());
        }
        return null;
    }

    public static final q k(w9.i iVar, g typeTable) {
        m.f(iVar, "<this>");
        m.f(typeTable, "typeTable");
        if (iVar.v0()) {
            return iVar.f0();
        }
        if (iVar.w0()) {
            return typeTable.a(iVar.g0());
        }
        return null;
    }

    public static final q l(n nVar, g typeTable) {
        m.f(nVar, "<this>");
        m.f(typeTable, "typeTable");
        if (nVar.s0()) {
            return nVar.e0();
        }
        if (nVar.t0()) {
            return typeTable.a(nVar.f0());
        }
        return null;
    }

    public static final q m(w9.i iVar, g typeTable) {
        m.f(iVar, "<this>");
        m.f(typeTable, "typeTable");
        if (iVar.x0()) {
            q returnType = iVar.h0();
            m.e(returnType, "returnType");
            return returnType;
        }
        if (iVar.y0()) {
            return typeTable.a(iVar.i0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function");
    }

    public static final q n(n nVar, g typeTable) {
        m.f(nVar, "<this>");
        m.f(typeTable, "typeTable");
        if (nVar.u0()) {
            q returnType = nVar.g0();
            m.e(returnType, "returnType");
            return returnType;
        }
        if (nVar.v0()) {
            return typeTable.a(nVar.h0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property");
    }

    public static final List<q> o(w9.c cVar, g typeTable) {
        m.f(cVar, "<this>");
        m.f(typeTable, "typeTable");
        List<q> listA1 = cVar.a1();
        if (listA1.isEmpty()) {
            listA1 = null;
        }
        if (listA1 == null) {
            List<Integer> supertypeIdList = cVar.Z0();
            m.e(supertypeIdList, "supertypeIdList");
            List<Integer> list = supertypeIdList;
            listA1 = new ArrayList<>(r.w(list, 10));
            for (Integer it : list) {
                m.e(it, "it");
                listA1.add(typeTable.a(it.intValue()));
            }
        }
        return listA1;
    }

    public static final q p(q.b bVar, g typeTable) {
        m.f(bVar, "<this>");
        m.f(typeTable, "typeTable");
        if (bVar.A()) {
            return bVar.x();
        }
        if (bVar.B()) {
            return typeTable.a(bVar.y());
        }
        return null;
    }

    public static final q q(u uVar, g typeTable) {
        m.f(uVar, "<this>");
        m.f(typeTable, "typeTable");
        if (uVar.S()) {
            q type = uVar.L();
            m.e(type, "type");
            return type;
        }
        if (uVar.T()) {
            return typeTable.a(uVar.N());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter");
    }

    public static final q r(w9.r rVar, g typeTable) {
        m.f(rVar, "<this>");
        m.f(typeTable, "typeTable");
        if (rVar.h0()) {
            q underlyingType = rVar.a0();
            m.e(underlyingType, "underlyingType");
            return underlyingType;
        }
        if (rVar.i0()) {
            return typeTable.a(rVar.b0());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias");
    }

    public static final List<q> s(s sVar, g typeTable) {
        m.f(sVar, "<this>");
        m.f(typeTable, "typeTable");
        List<q> listS = sVar.S();
        if (listS.isEmpty()) {
            listS = null;
        }
        if (listS == null) {
            List<Integer> upperBoundIdList = sVar.R();
            m.e(upperBoundIdList, "upperBoundIdList");
            List<Integer> list = upperBoundIdList;
            listS = new ArrayList<>(r.w(list, 10));
            for (Integer it : list) {
                m.e(it, "it");
                listS.add(typeTable.a(it.intValue()));
            }
        }
        return listS;
    }

    public static final q t(u uVar, g typeTable) {
        m.f(uVar, "<this>");
        m.f(typeTable, "typeTable");
        if (uVar.U()) {
            return uVar.O();
        }
        if (uVar.V()) {
            return typeTable.a(uVar.P());
        }
        return null;
    }
}
