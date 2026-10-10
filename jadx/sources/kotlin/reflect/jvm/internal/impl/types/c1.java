package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c1 extends kotlin.reflect.jvm.internal.impl.util.e<a1<?>, a1<?>> implements Iterable<a1<?>>, d9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14231b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c1 f14232c = new c1((List<? extends a1<?>>) kotlin.collections.r.l());

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends kotlin.reflect.jvm.internal.impl.util.s<a1<?>, a1<?>> {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.s
        public int b(ConcurrentHashMap<String, Integer> concurrentHashMap, String key, c9.l<? super String, Integer> compute) {
            int iIntValue;
            kotlin.jvm.internal.m.f(concurrentHashMap, "<this>");
            kotlin.jvm.internal.m.f(key, "key");
            kotlin.jvm.internal.m.f(compute, "compute");
            Integer num = concurrentHashMap.get(key);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                try {
                    Integer num2 = concurrentHashMap.get(key);
                    if (num2 == null) {
                        Integer numInvoke = compute.invoke(key);
                        concurrentHashMap.putIfAbsent(key, Integer.valueOf(numInvoke.intValue()));
                        num2 = numInvoke;
                    }
                    kotlin.jvm.internal.m.e(num2, "this[key] ?: compute(key…is.putIfAbsent(key, it) }");
                    iIntValue = num2.intValue();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iIntValue;
        }

        public final c1 g(List<? extends a1<?>> attributes) {
            kotlin.jvm.internal.m.f(attributes, "attributes");
            return attributes.isEmpty() ? h() : new c1(attributes, null);
        }

        public final c1 h() {
            return c1.f14232c;
        }
    }

    public /* synthetic */ c1(List list, kotlin.jvm.internal.g gVar) {
        this((List<? extends a1<?>>) list);
    }

    private c1(List<? extends a1<?>> list) {
        for (a1<?> a1Var : list) {
            h(a1Var.b(), a1Var);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.a
    protected kotlin.reflect.jvm.internal.impl.util.s<a1<?>, a1<?>> f() {
        return f14231b;
    }

    public final c1 k(c1 other) {
        a1 a1VarA;
        kotlin.jvm.internal.m.f(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f14231b.e().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            a1<?> a1Var = e().get(iIntValue);
            a1<?> a1Var2 = other.e().get(iIntValue);
            if (a1Var == null) {
                a1VarA = a1Var2 != null ? a1Var2.a(a1Var) : null;
            } else {
                a1VarA = a1Var.a(a1Var2);
            }
            sa.a.a(arrayList, a1VarA);
        }
        return f14231b.g(arrayList);
    }

    public final boolean m(a1<?> attribute) {
        kotlin.jvm.internal.m.f(attribute, "attribute");
        return e().get(f14231b.d(attribute.b())) != null;
    }

    public final c1 n(c1 other) {
        a1 a1VarC;
        kotlin.jvm.internal.m.f(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f14231b.e().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            a1<?> a1Var = e().get(iIntValue);
            a1<?> a1Var2 = other.e().get(iIntValue);
            if (a1Var == null) {
                a1VarC = a1Var2 != null ? a1Var2.c(a1Var) : null;
            } else {
                a1VarC = a1Var.c(a1Var2);
            }
            sa.a.a(arrayList, a1VarC);
        }
        return f14231b.g(arrayList);
    }

    public final c1 o(a1<?> attribute) {
        kotlin.jvm.internal.m.f(attribute, "attribute");
        if (m(attribute)) {
            return this;
        }
        if (isEmpty()) {
            return new c1(attribute);
        }
        return f14231b.g(kotlin.collections.r.C0(kotlin.collections.r.O0(this), attribute));
    }

    public final c1 q(a1<?> attribute) {
        kotlin.jvm.internal.m.f(attribute, "attribute");
        if (!isEmpty()) {
            kotlin.reflect.jvm.internal.impl.util.c<a1<?>> cVarE = e();
            ArrayList arrayList = new ArrayList();
            for (a1<?> a1Var : cVarE) {
                if (!kotlin.jvm.internal.m.a(a1Var, attribute)) {
                    arrayList.add(a1Var);
                }
            }
            if (arrayList.size() != e().e()) {
                return f14231b.g(arrayList);
            }
        }
        return this;
    }

    private c1(a1<?> a1Var) {
        this((List<? extends a1<?>>) kotlin.collections.r.e(a1Var));
    }
}
