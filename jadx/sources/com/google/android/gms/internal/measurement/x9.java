package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.z9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class x9<T extends z9<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final x9<?> f3226d = new x9<>(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final gc<T, Object> f3227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3229c;

    private x9() {
        this.f3227a = new jc();
    }

    private static int d(ed edVar, Object obj) {
        switch (w9.f3183b[edVar.ordinal()]) {
            case 1:
                return m9.c(((Double) obj).doubleValue());
            case 2:
                return m9.d(((Float) obj).floatValue());
            case 3:
                return m9.e0(((Long) obj).longValue());
            case 4:
                return m9.r0(((Long) obj).longValue());
            case 5:
                return m9.k0(((Integer) obj).intValue());
            case 6:
                return m9.W(((Long) obj).longValue());
            case 7:
                return m9.g0(((Integer) obj).intValue());
            case 8:
                return m9.j(((Boolean) obj).booleanValue());
            case 9:
                return m9.F((ob) obj);
            case 10:
                return obj instanceof ra ? m9.h((ra) obj) : m9.X((ob) obj);
            case 11:
                return obj instanceof v8 ? m9.E((v8) obj) : m9.G((String) obj);
            case 12:
                return obj instanceof v8 ? m9.E((v8) obj) : m9.k((byte[]) obj);
            case 13:
                return m9.z0(((Integer) obj).intValue());
            case 14:
                return m9.o0(((Integer) obj).intValue());
            case 15:
                return m9.j0(((Long) obj).longValue());
            case 16:
                return m9.s0(((Integer) obj).intValue());
            case 17:
                return m9.n0(((Long) obj).longValue());
            case 18:
                return obj instanceof ja ? m9.b0(((ja) obj).b()) : m9.b0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final Object f(T t10) {
        Object obj = this.f3227a.get(t10);
        if (obj instanceof ra) {
            throw new NoSuchMethodError();
        }
        return obj;
    }

    private static Object g(Object obj) {
        if (obj instanceof sb) {
            return ((sb) obj).b();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static <T extends z9<T>> x9<T> i() {
        return (x9<T>) f3226d;
    }

    private static boolean l(Object obj) {
        if (obj instanceof qb) {
            return ((qb) obj).i();
        }
        if (obj instanceof ra) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public final int a() {
        int iA = this.f3227a.a();
        int iE = 0;
        for (int i10 = 0; i10 < iA; i10++) {
            iE += e(this.f3227a.f(i10));
        }
        Iterator it = this.f3227a.h().iterator();
        while (it.hasNext()) {
            iE += e((Map.Entry) it.next());
        }
        return iE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() {
        x9 x9Var = new x9();
        int iA = this.f3227a.a();
        for (int i10 = 0; i10 < iA; i10++) {
            Map.Entry<K, Object> entryF = this.f3227a.f(i10);
            x9Var.j((z9) entryF.getKey(), entryF.getValue());
        }
        Iterator it = this.f3227a.h().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            x9Var.j((z9) entry.getKey(), entry.getValue());
        }
        x9Var.f3229c = this.f3229c;
        return x9Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x9) {
            return this.f3227a.equals(((x9) obj).f3227a);
        }
        return false;
    }

    public final void h(x9<T> x9Var) {
        int iA = x9Var.f3227a.a();
        for (int i10 = 0; i10 < iA; i10++) {
            k(x9Var.f3227a.f(i10));
        }
        Iterator it = x9Var.f3227a.h().iterator();
        while (it.hasNext()) {
            k((Map.Entry) it.next());
        }
    }

    public final int hashCode() {
        return this.f3227a.hashCode();
    }

    final Iterator<Map.Entry<T, Object>> m() {
        if (this.f3227a.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.f3229c ? new ta(this.f3227a.l().iterator()) : this.f3227a.l().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> p() {
        if (this.f3227a.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.f3229c ? new ta(this.f3227a.entrySet().iterator()) : this.f3227a.entrySet().iterator();
    }

    public final void q() {
        if (this.f3228b) {
            return;
        }
        int iA = this.f3227a.a();
        for (int i10 = 0; i10 < iA; i10++) {
            Object value = this.f3227a.f(i10).getValue();
            if (value instanceof ea) {
                ((ea) value).H();
            }
        }
        Iterator it = this.f3227a.h().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof ea) {
                ((ea) value2).H();
            }
        }
        this.f3227a.m();
        this.f3228b = true;
    }

    public final boolean r() {
        return this.f3228b;
    }

    public final boolean s() {
        int iA = this.f3227a.a();
        for (int i10 = 0; i10 < iA; i10++) {
            if (!o(this.f3227a.f(i10))) {
                return false;
            }
        }
        Iterator it = this.f3227a.h().iterator();
        while (it.hasNext()) {
            if (!o((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static int b(z9<?> z9Var, Object obj) {
        ed edVarC = z9Var.c();
        int iB = z9Var.b();
        if (z9Var.g()) {
            List list = (List) obj;
            int size = list.size();
            int i10 = 0;
            if (z9Var.e()) {
                if (list.isEmpty()) {
                    return 0;
                }
                int iD = 0;
                while (i10 < size) {
                    iD += d(edVarC, list.get(i10));
                    i10++;
                }
                return m9.w0(iB) + iD + m9.z0(iD);
            }
            int iC = 0;
            while (i10 < size) {
                iC += c(edVarC, iB, list.get(i10));
                i10++;
            }
            return iC;
        }
        return c(edVarC, iB, obj);
    }

    static int c(ed edVar, int i10, Object obj) {
        int iW0 = m9.w0(i10);
        if (edVar == ed.f2652j) {
            ga.g((ob) obj);
            iW0 <<= 1;
        }
        return iW0 + d(edVar, obj);
    }

    private static int e(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.d() == ld.MESSAGE && !key.g() && !key.e()) {
            if (value instanceof ra) {
                return m9.g(entry.getKey().b(), (ra) value);
            }
            return m9.A(entry.getKey().b(), (ob) value);
        }
        return b(key, value);
    }

    private final void j(T t10, Object obj) {
        if (t10.g()) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj2 = list.get(i10);
                    n(t10, obj2);
                    arrayList.add(obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            n(t10, obj);
        }
        if (obj instanceof ra) {
            this.f3229c = true;
        }
        this.f3227a.put(t10, obj);
    }

    private final void k(Map.Entry<T, Object> entry) {
        ob obVarW;
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z10 = value instanceof ra;
        if (key.g()) {
            if (!z10) {
                Object objF = f(key);
                List list = (List) value;
                int size = list.size();
                if (objF == null) {
                    objF = new ArrayList(size);
                }
                List list2 = (List) objF;
                for (int i10 = 0; i10 < size; i10++) {
                    list2.add(g(list.get(i10)));
                }
                this.f3227a.put(key, objF);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        }
        if (key.d() == ld.MESSAGE) {
            Object objF2 = f(key);
            if (objF2 == null) {
                this.f3227a.put(key, g(value));
                if (z10) {
                    this.f3229c = true;
                    return;
                }
                return;
            }
            if (!z10) {
                if (objF2 instanceof sb) {
                    obVarW = key.K((sb) objF2, (sb) value);
                } else {
                    obVarW = key.I(((ob) objF2).c(), (ob) value).w();
                }
                this.f3227a.put(key, obVarW);
                return;
            }
            throw new NoSuchMethodError();
        }
        if (!z10) {
            this.f3227a.put(key, g(value));
            return;
        }
        throw new IllegalStateException("Lazy fields must be message-valued");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0018  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    private static void n(T t10, Object obj) {
        boolean z10;
        ed edVarC = t10.c();
        ga.e(obj);
        switch (w9.f3182a[edVarC.a().ordinal()]) {
            case 1:
                z10 = obj instanceof Integer;
                break;
            case 2:
                z10 = obj instanceof Long;
                break;
            case 3:
                z10 = obj instanceof Float;
                break;
            case 4:
                z10 = obj instanceof Double;
                break;
            case 5:
                z10 = obj instanceof Boolean;
                break;
            case 6:
                z10 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof v8) && !(obj instanceof byte[])) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof ja)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                break;
            case 9:
                if (!(obj instanceof ob) && !(obj instanceof ra)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                break;
            default:
                z10 = false;
                break;
        }
        if (!z10) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t10.b()), t10.c().a(), obj.getClass().getName()));
        }
    }

    private static <T extends z9<T>> boolean o(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.d() == ld.MESSAGE) {
            if (key.g()) {
                List list = (List) entry.getValue();
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (!l(list.get(i10))) {
                        return false;
                    }
                }
                return true;
            }
            return l(entry.getValue());
        }
        return true;
    }

    private x9(gc<T, Object> gcVar) {
        this.f3227a = gcVar;
        q();
    }

    private x9(boolean z10) {
        this(new jc());
        q();
    }
}
