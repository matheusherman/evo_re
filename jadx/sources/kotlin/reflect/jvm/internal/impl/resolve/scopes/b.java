package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13960d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h[] f13962c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final h a(String debugName, Iterable<? extends h> scopes) {
            kotlin.jvm.internal.m.f(debugName, "debugName");
            kotlin.jvm.internal.m.f(scopes, "scopes");
            sa.f fVar = new sa.f();
            for (h hVar : scopes) {
                if (hVar != h.b.f14005b) {
                    if (hVar instanceof b) {
                        r.D(fVar, ((b) hVar).f13962c);
                    } else {
                        fVar.add(hVar);
                    }
                }
            }
            return b(debugName, fVar);
        }

        public final h b(String debugName, List<? extends h> scopes) {
            kotlin.jvm.internal.m.f(debugName, "debugName");
            kotlin.jvm.internal.m.f(scopes, "scopes");
            int size = scopes.size();
            if (size != 0) {
                return size != 1 ? new b(debugName, (h[]) scopes.toArray(new h[0]), null) : scopes.get(0);
            }
            return h.b.f14005b;
        }
    }

    public /* synthetic */ b(String str, h[] hVarArr, kotlin.jvm.internal.g gVar) {
        this(str, hVarArr);
    }

    private b(String str, h[] hVarArr) {
        this.f13961b = str;
        this.f13962c = hVarArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        h[] hVarArr = this.f13962c;
        int length = hVarArr.length;
        if (length == 0) {
            return r.l();
        }
        if (length == 1) {
            return hVarArr[0].a(name, location);
        }
        Collection<u0> collectionA = null;
        for (h hVar : hVarArr) {
            collectionA = ra.a.a(collectionA, hVar.a(name, location));
        }
        return collectionA == null ? v0.e() : collectionA;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        h[] hVarArr = this.f13962c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArr) {
            r.C(linkedHashSet, hVar.b());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        h[] hVarArr = this.f13962c;
        int length = hVarArr.length;
        if (length == 0) {
            return r.l();
        }
        if (length == 1) {
            return hVarArr[0].c(name, location);
        }
        Collection<z0> collectionA = null;
        for (h hVar : hVarArr) {
            collectionA = ra.a.a(collectionA, hVar.c(name, location));
        }
        return collectionA == null ? v0.e() : collectionA;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        h[] hVarArr = this.f13962c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArr) {
            r.C(linkedHashSet, hVar.d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar = null;
        for (h hVar2 : this.f13962c) {
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarE = hVar2.e(name, location);
            if (hVarE != null) {
                if (!(hVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.i) || !((kotlin.reflect.jvm.internal.impl.descriptors.i) hVarE).I()) {
                    return hVarE;
                }
                if (hVar == null) {
                    hVar = hVarE;
                }
            }
        }
        return hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        return j.a(kotlin.collections.j.F(this.f13962c));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        h[] hVarArr = this.f13962c;
        int length = hVarArr.length;
        if (length == 0) {
            return r.l();
        }
        if (length == 1) {
            return hVarArr[0].g(kindFilter, nameFilter);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionA = null;
        for (h hVar : hVarArr) {
            collectionA = ra.a.a(collectionA, hVar.g(kindFilter, nameFilter));
        }
        return collectionA == null ? v0.e() : collectionA;
    }

    public String toString() {
        return this.f13961b;
    }
}
