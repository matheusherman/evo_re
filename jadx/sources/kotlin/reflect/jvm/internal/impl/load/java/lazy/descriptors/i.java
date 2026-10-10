package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.load.java.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.q;
import kotlin.reflect.jvm.internal.impl.load.kotlin.r;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;
import u9.d0;
import u9.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i extends m {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final u f13333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final h f13334o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ka.j<Set<String>> f13335p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ka.h<a, kotlin.reflect.jvm.internal.impl.descriptors.e> f13336q;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ba.f f13337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final u9.g f13338b;

        public a(ba.f name, u9.g gVar) {
            kotlin.jvm.internal.m.f(name, "name");
            this.f13337a = name;
            this.f13338b = gVar;
        }

        public final u9.g a() {
            return this.f13338b;
        }

        public final ba.f b() {
            return this.f13337a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.m.a(this.f13337a, ((a) obj).f13337a);
        }

        public int hashCode() {
            return this.f13337a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class b {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final kotlin.reflect.jvm.internal.impl.descriptors.e f13339a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlin.reflect.jvm.internal.impl.descriptors.e descriptor) {
                super(null);
                kotlin.jvm.internal.m.f(descriptor, "descriptor");
                this.f13339a = descriptor;
            }

            public final kotlin.reflect.jvm.internal.impl.descriptors.e a() {
                return this.f13339a;
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.i$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0231b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0231b f13340a = new C0231b();

            private C0231b() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f13341a = new c();

            private c() {
                super(null);
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.l<a, kotlin.reflect.jvm.internal.impl.descriptors.e> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.g $c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar) {
            super(1);
            this.$c = gVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke(a request) {
            kotlin.jvm.internal.m.f(request, "request");
            ba.b bVar = new ba.b(i.this.C().d(), request.b());
            q.a aVarC = request.a() != null ? this.$c.a().j().c(request.a(), i.this.R()) : this.$c.a().j().b(bVar, i.this.R());
            s sVarA = aVarC != null ? aVarC.a() : null;
            ba.b bVarE = sVarA != null ? sVarA.e() : null;
            if (bVarE != null && (bVarE.l() || bVarE.k())) {
                return null;
            }
            b bVarT = i.this.T(sVarA);
            if (bVarT instanceof b.a) {
                return ((b.a) bVarT).a();
            }
            if (bVarT instanceof b.c) {
                return null;
            }
            if (!(bVarT instanceof b.C0231b)) {
                throw new r8.n();
            }
            u9.g gVarA = request.a();
            if (gVarA == null) {
                gVarA = this.$c.a().d().a(new p.a(bVar, null, null, 4, null));
            }
            u9.g gVar = gVarA;
            if ((gVar != null ? gVar.G() : null) != d0.BINARY) {
                ba.c cVarD = gVar != null ? gVar.d() : null;
                if (cVarD == null || cVarD.d() || !kotlin.jvm.internal.m.a(cVarD.e(), i.this.C().d())) {
                    return null;
                }
                f fVar = new f(this.$c, i.this.C(), gVar, null, 8, null);
                this.$c.a().e().a(fVar);
                return fVar;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + r.b(this.$c.a().j(), gVar, i.this.R()) + "\nfindKotlinClass(ClassId) = " + r.a(this.$c.a().j(), bVar, i.this.R()) + '\n');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends o implements c9.a<Set<? extends String>> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.g $c;
        final /* synthetic */ i this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, i iVar) {
            super(0);
            this.$c = gVar;
            this.this$0 = iVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set<String> invoke() {
            return this.$c.a().d().b(this.this$0.C().d());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, u jPackage, h ownerDescriptor) {
        super(c10);
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(jPackage, "jPackage");
        kotlin.jvm.internal.m.f(ownerDescriptor, "ownerDescriptor");
        this.f13333n = jPackage;
        this.f13334o = ownerDescriptor;
        this.f13335p = c10.e().g(new d(c10, this));
        this.f13336q = c10.e().i(new c(c10));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.e O(ba.f fVar, u9.g gVar) {
        if (!ba.h.f942a.a(fVar)) {
            return null;
        }
        Set<String> setInvoke = this.f13335p.invoke();
        if (gVar != null || setInvoke == null || setInvoke.contains(fVar.f())) {
            return this.f13336q.invoke(new a(fVar, gVar));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b T(s sVar) {
        if (sVar == null) {
            return b.C0231b.f13340a;
        }
        if (sVar.g().c() != v9.a.EnumC0377a.CLASS) {
            return b.c.f13341a;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarL = w().a().b().l(sVar);
        return eVarL != null ? new b.a(eVarL) : b.C0231b.f13340a;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e P(u9.g javaClass) {
        kotlin.jvm.internal.m.f(javaClass, "javaClass");
        return O(javaClass.getName(), javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return O(name, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public h C() {
        return this.f13334o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return kotlin.collections.r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.d.a aVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c;
        if (!kindFilter.a(aVar.e() | aVar.c())) {
            return kotlin.collections.r.l();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionInvoke = v().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            kotlin.reflect.jvm.internal.impl.descriptors.m mVar = (kotlin.reflect.jvm.internal.impl.descriptors.m) obj;
            if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                ba.f name = ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar).getName();
                kotlin.jvm.internal.m.e(name, "it.name");
                if (nameFilter.invoke(name).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected Set<ba.f> l(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        if (!kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13966c.e())) {
            return v0.e();
        }
        Set<String> setInvoke = this.f13335p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(ba.f.l((String) it.next()));
            }
            return hashSet;
        }
        u uVar = this.f13333n;
        if (lVar == null) {
            lVar = sa.e.a();
        }
        Collection<u9.g> collectionE = uVar.E(lVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (u9.g gVar : collectionE) {
            ba.f name = gVar.G() == d0.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected Set<ba.f> n(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        return v0.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b p() {
        return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b.a.f13279a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void r(Collection<z0> result, ba.f name) {
        kotlin.jvm.internal.m.f(result, "result");
        kotlin.jvm.internal.m.f(name, "name");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected Set<ba.f> t(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> lVar) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        return v0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final aa.e R() {
        return sa.c.a(w().a().b().d().g());
    }
}
