package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f0 implements g1, na.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g0 f14281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<g0> f14282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14283c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> {
        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return f0.this.c(kotlinTypeRefiner).h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c9.l f14284a;

        public b(c9.l lVar) {
            this.f14284a = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            g0 it = (g0) t10;
            c9.l lVar = this.f14284a;
            kotlin.jvm.internal.m.e(it, "it");
            String string = lVar.invoke(it).toString();
            g0 it2 = (g0) t11;
            c9.l lVar2 = this.f14284a;
            kotlin.jvm.internal.m.e(it2, "it");
            return t8.a.a(string, lVar2.invoke(it2).toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l<g0, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14285a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(g0 it) {
            kotlin.jvm.internal.m.f(it, "it");
            return it.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends kotlin.jvm.internal.o implements c9.l<g0, CharSequence> {
        final /* synthetic */ c9.l<g0, Object> $getProperTypeRelatedToStringify;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(c9.l<? super g0, ? extends Object> lVar) {
            super(1);
            this.$getProperTypeRelatedToStringify = lVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(g0 it) {
            c9.l<g0, Object> lVar = this.$getProperTypeRelatedToStringify;
            kotlin.jvm.internal.m.e(it, "it");
            return lVar.invoke(it).toString();
        }
    }

    public f0(Collection<? extends g0> typesToIntersect) {
        kotlin.jvm.internal.m.f(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet<g0> linkedHashSet = new LinkedHashSet<>(typesToIntersect);
        this.f14282b = linkedHashSet;
        this.f14283c = linkedHashSet.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.descriptors.h d() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean e() {
        return false;
    }

    public String toString() {
        return k(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String k(f0 f0Var, c9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = c.f14285a;
        }
        return f0Var.j(lVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public Collection<g0> b() {
        return this.f14282b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f0) {
            return kotlin.jvm.internal.m.a(this.f14282b, ((f0) obj).f14282b);
        }
        return false;
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h g() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.n.f14015d.a("member scope for intersection type", this.f14282b);
    }

    public final o0 h() {
        return h0.l(c1.f14231b.h(), this, kotlin.collections.r.l(), false, g(), new a());
    }

    public int hashCode() {
        return this.f14283c;
    }

    public final g0 i() {
        return this.f14281a;
    }

    public final String j(c9.l<? super g0, ? extends Object> getProperTypeRelatedToStringify) {
        kotlin.jvm.internal.m.f(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return kotlin.collections.r.q0(kotlin.collections.r.J0(this.f14282b, new b(getProperTypeRelatedToStringify)), " & ", "{", "}", 0, null, new d(getProperTypeRelatedToStringify), 24, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public kotlin.reflect.jvm.internal.impl.builtins.h l() {
        kotlin.reflect.jvm.internal.impl.builtins.h hVarL = this.f14282b.iterator().next().J0().l();
        kotlin.jvm.internal.m.e(hVarL, "intersectedTypes.iterato…xt().constructor.builtIns");
        return hVarL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public f0 c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<g0> collectionB = b();
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(collectionB, 10));
        Iterator<T> it = collectionB.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            arrayList.add(((g0) it.next()).T0(kotlinTypeRefiner));
            z10 = true;
        }
        f0 f0VarN = null;
        if (z10) {
            g0 g0VarI = i();
            f0VarN = new f0(arrayList).n(g0VarI != null ? g0VarI.T0(kotlinTypeRefiner) : null);
        }
        return f0VarN == null ? this : f0VarN;
    }

    public final f0 n(g0 g0Var) {
        return new f0(this.f14282b, g0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public List<kotlin.reflect.jvm.internal.impl.descriptors.f1> getParameters() {
        return kotlin.collections.r.l();
    }

    private f0(Collection<? extends g0> collection, g0 g0Var) {
        this(collection);
        this.f14281a = g0Var;
    }
}
