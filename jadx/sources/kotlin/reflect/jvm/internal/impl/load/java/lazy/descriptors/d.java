package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;
import u9.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d implements kotlin.reflect.jvm.internal.impl.resolve.scopes.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f13280f = {c0.g(new w(c0.b(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f13282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f13283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.i f13284e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h[]> {
        a() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] invoke() {
            Collection<s> collectionValues = d.this.f13282c.J0().values();
            d dVar = d.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarB = dVar.f13281b.a().b().b(dVar.f13282c, (s) it.next());
                if (hVarB != null) {
                    arrayList.add(hVarB);
                }
            }
            return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h[]) ra.a.b(arrayList).toArray(new kotlin.reflect.jvm.internal.impl.resolve.scopes.h[0]);
        }
    }

    public d(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, u jPackage, h packageFragment) {
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(jPackage, "jPackage");
        kotlin.jvm.internal.m.f(packageFragment, "packageFragment");
        this.f13281b = c10;
        this.f13282c = packageFragment;
        this.f13283d = new i(c10, jPackage, packageFragment);
        this.f13284e = c10.e().c(new a());
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] k() {
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h[]) ka.m.a(this.f13284e, this, f13280f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        l(name, location);
        i iVar = this.f13283d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] hVarArrK = k();
        Collection<? extends u0> collectionA = iVar.a(name, location);
        int length = hVarArrK.length;
        int i10 = 0;
        Collection collection = collectionA;
        while (i10 < length) {
            Collection collectionA2 = ra.a.a(collection, hVarArrK[i10].a(name, location));
            i10++;
            collection = collectionA2;
        }
        return collection == null ? v0.e() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        l(name, location);
        i iVar = this.f13283d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] hVarArrK = k();
        Collection<? extends z0> collectionC = iVar.c(name, location);
        int length = hVarArrK.length;
        int i10 = 0;
        Collection collection = collectionC;
        while (i10 < length) {
            Collection collectionA = ra.a.a(collection, hVarArrK[i10].c(name, location));
            i10++;
            collection = collectionA;
        }
        return collection == null ? v0.e() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        l(name, location);
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarQ = this.f13283d.e(name, location);
        if (eVarQ != null) {
            return eVarQ;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar = null;
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar2 : k()) {
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

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        i iVar = this.f13283d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] hVarArrK = k();
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionG = iVar.g(kindFilter, nameFilter);
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar : hVarArrK) {
            collectionG = ra.a.a(collectionG, hVar.g(kindFilter, nameFilter));
        }
        return collectionG == null ? v0.e() : collectionG;
    }

    public final i j() {
        return this.f13283d;
    }

    public void l(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        q9.a.b(this.f13281b.a().l(), location, this.f13282c, name);
    }

    public String toString() {
        return "scope for " + this.f13282c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] hVarArrK = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar : hVarArrK) {
            r.C(linkedHashSet, hVar.b());
        }
        linkedHashSet.addAll(this.f13283d.b());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h[] hVarArrK = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar : hVarArrK) {
            r.C(linkedHashSet, hVar.d());
        }
        linkedHashSet.addAll(this.f13283d.d());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        Set<ba.f> setA = kotlin.reflect.jvm.internal.impl.resolve.scopes.j.a(kotlin.collections.j.F(k()));
        if (setA != null) {
            setA.addAll(this.f13283d.f());
            return setA;
        }
        return null;
    }
}
