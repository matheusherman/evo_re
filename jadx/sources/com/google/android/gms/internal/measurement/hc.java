package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class hc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final vc<?, ?> f2754a = new yc();

    public static void C(int i10, List<Integer> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.D(i10, list, z10);
    }

    public static void F(int i10, List<Long> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.A(i10, list, z10);
    }

    public static void I(int i10, List<Float> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.L(i10, list, z10);
    }

    public static void L(int i10, List<Integer> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.G(i10, list, z10);
    }

    public static void O(int i10, List<Long> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.i(i10, list, z10);
    }

    public static void R(int i10, List<Integer> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.d(i10, list, z10);
    }

    public static void U(int i10, List<Long> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.t(i10, list, z10);
    }

    public static void V(int i10, List<Integer> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.u(i10, list, z10);
    }

    public static void W(int i10, List<Long> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.p(i10, list, z10);
    }

    public static void X(int i10, List<Integer> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.F(i10, list, z10);
    }

    public static void Y(int i10, List<Long> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.C(i10, list, z10);
    }

    static int a(int i10, Object obj, fc<?> fcVar) {
        return obj instanceof va ? m9.z(i10, (va) obj) : m9.V(i10, (ob) obj, fcVar);
    }

    public static vc<?, ?> f() {
        return f2754a;
    }

    static <UT, UB> UB g(Object obj, int i10, int i11, UB ub2, vc<UT, UB> vcVar) {
        if (ub2 == null) {
            ub2 = vcVar.i(obj);
        }
        vcVar.f(ub2, i10, i11);
        return ub2;
    }

    static <UT, UB> UB h(Object obj, int i10, List<Integer> list, ia iaVar, UB ub2, vc<UT, UB> vcVar) {
        if (iaVar == null) {
            return ub2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (!iaVar.a(iIntValue)) {
                    ub2 = (UB) g(obj, i10, iIntValue, ub2, vcVar);
                    it.remove();
                }
            }
            return ub2;
        }
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Integer num = list.get(i12);
            int iIntValue2 = num.intValue();
            if (iaVar.a(iIntValue2)) {
                if (i12 != i11) {
                    list.set(i11, num);
                }
                i11++;
            } else {
                ub2 = (UB) g(obj, i10, iIntValue2, ub2, vcVar);
            }
        }
        if (i11 != size) {
            list.subList(i11, size).clear();
        }
        return ub2;
    }

    public static void i(int i10, List<v8> list, nd ndVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.O(i10, list);
    }

    public static void j(int i10, List<?> list, nd ndVar, fc<?> fcVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.o(i10, list, fcVar);
    }

    public static void k(int i10, List<Boolean> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.h(i10, list, z10);
    }

    public static void o(Class<?> cls) {
        ea.class.isAssignableFrom(cls);
    }

    static boolean p(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void u(int i10, List<String> list, nd ndVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.H(i10, list);
    }

    public static void v(int i10, List<?> list, nd ndVar, fc<?> fcVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.E(i10, list, fcVar);
    }

    public static void w(int i10, List<Double> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.q(i10, list, z10);
    }

    public static void z(int i10, List<Integer> list, nd ndVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ndVar.n(i10, list, z10);
    }

    static int A(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * m9.T(i10, 0L);
    }

    static int B(List<?> list) {
        return list.size() << 3;
    }

    static int D(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * m9.w0(i10));
    }

    static int E(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ha) {
            ha haVar = (ha) list;
            int iK0 = 0;
            while (i10 < size) {
                iK0 += m9.k0(haVar.f(i10));
                i10++;
            }
            return iK0;
        }
        int iK1 = 0;
        while (i10 < size) {
            iK1 += m9.k0(list.get(i10).intValue());
            i10++;
        }
        return iK1;
    }

    static int G(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return H(list) + (list.size() * m9.w0(i10));
    }

    static int H(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof za) {
            za zaVar = (za) list;
            int iE0 = 0;
            while (i10 < size) {
                iE0 += m9.e0(zaVar.l(i10));
                i10++;
            }
            return iE0;
        }
        int iE1 = 0;
        while (i10 < size) {
            iE1 += m9.e0(list.get(i10).longValue());
            i10++;
        }
        return iE1;
    }

    static int J(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return K(list) + (size * m9.w0(i10));
    }

    static int K(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ha) {
            ha haVar = (ha) list;
            int iS0 = 0;
            while (i10 < size) {
                iS0 += m9.s0(haVar.f(i10));
                i10++;
            }
            return iS0;
        }
        int iS1 = 0;
        while (i10 < size) {
            iS1 += m9.s0(list.get(i10).intValue());
            i10++;
        }
        return iS1;
    }

    static int M(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return N(list) + (size * m9.w0(i10));
    }

    static int N(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof za) {
            za zaVar = (za) list;
            int iN0 = 0;
            while (i10 < size) {
                iN0 += m9.n0(zaVar.l(i10));
                i10++;
            }
            return iN0;
        }
        int iN1 = 0;
        while (i10 < size) {
            iN1 += m9.n0(list.get(i10).longValue());
            i10++;
        }
        return iN1;
    }

    static int P(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return Q(list) + (size * m9.w0(i10));
    }

    static int Q(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ha) {
            ha haVar = (ha) list;
            int iZ0 = 0;
            while (i10 < size) {
                iZ0 += m9.z0(haVar.f(i10));
                i10++;
            }
            return iZ0;
        }
        int iZ1 = 0;
        while (i10 < size) {
            iZ1 += m9.z0(list.get(i10).intValue());
            i10++;
        }
        return iZ1;
    }

    static int S(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return T(list) + (size * m9.w0(i10));
    }

    static int T(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof za) {
            za zaVar = (za) list;
            int iR0 = 0;
            while (i10 < size) {
                iR0 += m9.r0(zaVar.l(i10));
                i10++;
            }
            return iR0;
        }
        int iR1 = 0;
        while (i10 < size) {
            iR1 += m9.r0(list.get(i10).longValue());
            i10++;
        }
        return iR1;
    }

    static int b(int i10, List<v8> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW0 = size * m9.w0(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            iW0 += m9.E(list.get(i11));
        }
        return iW0;
    }

    static int c(int i10, List<ob> list, fc<?> fcVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iB = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iB += m9.B(i10, list.get(i11), fcVar);
        }
        return iB;
    }

    static int d(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * m9.D(i10, true);
    }

    static int e(List<?> list) {
        return list.size();
    }

    static <T, FT extends z9<FT>> void l(s9<FT> s9Var, T t10, T t11) {
        x9<T> x9VarB = s9Var.b(t11);
        if (!x9VarB.f3227a.isEmpty()) {
            s9Var.f(t10).h(x9VarB);
        }
    }

    static <T> void m(hb hbVar, T t10, T t11, long j10) {
        xc.j(t10, j10, hbVar.f(xc.B(t10, j10), xc.B(t11, j10)));
    }

    static <T, UT, UB> void n(vc<UT, UB> vcVar, T t10, T t11) {
        vcVar.j(t10, vcVar.b(vcVar.k(t10), vcVar.k(t11)));
    }

    static int q(int i10, List<?> list) {
        int iG;
        int iG2;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iW0 = m9.w0(i10) * size;
        if (list instanceof ua) {
            ua uaVar = (ua) list;
            while (i11 < size) {
                Object objA = uaVar.a(i11);
                if (objA instanceof v8) {
                    iG2 = m9.E((v8) objA);
                } else {
                    iG2 = m9.G((String) objA);
                }
                iW0 += iG2;
                i11++;
            }
            return iW0;
        }
        while (i11 < size) {
            Object obj = list.get(i11);
            if (obj instanceof v8) {
                iG = m9.E((v8) obj);
            } else {
                iG = m9.G((String) obj);
            }
            iW0 += iG;
            i11++;
        }
        return iW0;
    }

    static int r(int i10, List<?> list, fc<?> fcVar) {
        int i11;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW0 = m9.w0(i10) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof va) {
                i11 = m9.h((va) obj);
            } else {
                i11 = m9.i((ob) obj, fcVar);
            }
            iW0 += i11;
        }
        return iW0;
    }

    static int s(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return t(list) + (size * m9.w0(i10));
    }

    static int t(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ha) {
            ha haVar = (ha) list;
            int iB0 = 0;
            while (i10 < size) {
                iB0 += m9.b0(haVar.f(i10));
                i10++;
            }
            return iB0;
        }
        int iB1 = 0;
        while (i10 < size) {
            iB1 += m9.b0(list.get(i10).intValue());
            i10++;
        }
        return iB1;
    }

    static int x(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * m9.l0(i10, 0);
    }

    static int y(List<?> list) {
        return list.size() << 2;
    }
}
