package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.p1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f14010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r8.i f14011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p1 f14012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.m> f14013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final r8.i f14014f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.m>> {
        a() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke() {
            m mVar = m.this;
            return mVar.k(k.a.a(mVar.f14010b, null, null, 3, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements c9.a<p1> {
        final /* synthetic */ p1 $givenSubstitutor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(p1 p1Var) {
            super(0);
            this.$givenSubstitutor = p1Var;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p1 invoke() {
            return this.$givenSubstitutor.j().c();
        }
    }

    public m(h workerScope, p1 givenSubstitutor) {
        kotlin.jvm.internal.m.f(workerScope, "workerScope");
        kotlin.jvm.internal.m.f(givenSubstitutor, "givenSubstitutor");
        this.f14010b = workerScope;
        this.f14011c = r8.j.a(new b(givenSubstitutor));
        n1 n1VarJ = givenSubstitutor.j();
        kotlin.jvm.internal.m.e(n1VarJ, "givenSubstitutor.substitution");
        this.f14012d = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d.f(n1VarJ, false, 1, null).c();
        this.f14014f = r8.j.a(new a());
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> j() {
        return (Collection) this.f14014f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.m> Collection<D> k(Collection<? extends D> collection) {
        if (this.f14012d.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetG = sa.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetG.add(l((kotlin.reflect.jvm.internal.impl.descriptors.m) it.next()));
        }
        return linkedHashSetG;
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.m> D l(D d10) {
        if (this.f14012d.k()) {
            return d10;
        }
        if (this.f14013e == null) {
            this.f14013e = new HashMap();
        }
        Map<kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.m> map = this.f14013e;
        kotlin.jvm.internal.m.c(map);
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarC = map.get(d10);
        if (mVarC == null) {
            if (!(d10 instanceof c1)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + d10).toString());
            }
            mVarC = ((c1) d10).c(this.f14012d);
            if (mVarC == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d10 + " substitution fails");
            }
            map.put(d10, mVarC);
        }
        D d11 = (D) mVarC;
        kotlin.jvm.internal.m.d(d11, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return d11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<? extends u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return k(this.f14010b.a(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        return this.f14010b.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<? extends z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return k(this.f14010b.c(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        return this.f14010b.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarE = this.f14010b.e(name, location);
        if (hVarE != null) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.h) l(hVarE);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        return this.f14010b.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return j();
    }
}
