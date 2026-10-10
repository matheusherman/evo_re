package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import r8.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n extends kotlin.reflect.jvm.internal.impl.resolve.scopes.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f14015d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f14017c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final h a(String message, Collection<? extends g0> types) {
            kotlin.jvm.internal.m.f(message, "message");
            kotlin.jvm.internal.m.f(types, "types");
            Collection<? extends g0> collection = types;
            ArrayList arrayList = new ArrayList(r.w(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((g0) it.next()).n());
            }
            sa.f<h> fVarB = ra.a.b(arrayList);
            h hVarB = kotlin.reflect.jvm.internal.impl.resolve.scopes.b.f13960d.b(message, fVarB);
            return fVarB.size() <= 1 ? hVarB : new n(message, hVarB, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14018a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(kotlin.reflect.jvm.internal.impl.descriptors.a selectMostSpecificInEachOverridableGroup) {
            kotlin.jvm.internal.m.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
            return selectMostSpecificInEachOverridableGroup;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements c9.l<z0, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14019a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(z0 selectMostSpecificInEachOverridableGroup) {
            kotlin.jvm.internal.m.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
            return selectMostSpecificInEachOverridableGroup;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends o implements c9.l<u0, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14020a = new d();

        d() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(u0 selectMostSpecificInEachOverridableGroup) {
            kotlin.jvm.internal.m.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
            return selectMostSpecificInEachOverridableGroup;
        }
    }

    public /* synthetic */ n(String str, h hVar, kotlin.jvm.internal.g gVar) {
        this(str, hVar);
    }

    private n(String str, h hVar) {
        this.f14016b = str;
        this.f14017c = hVar;
    }

    public static final h j(String str, Collection<? extends g0> collection) {
        return f14015d.a(str, collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return kotlin.reflect.jvm.internal.impl.resolve.m.a(super.a(name, location), d.f14020a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return kotlin.reflect.jvm.internal.impl.resolve.m.a(super.c(name, location), c.f14019a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionG = super.g(kindFilter, nameFilter);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionG) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.m) obj) instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        p pVar = new p(arrayList, arrayList2);
        List list = (List) pVar.a();
        List list2 = (List) pVar.b();
        kotlin.jvm.internal.m.d(list, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return r.B0(kotlin.reflect.jvm.internal.impl.resolve.m.a(list, b.f14018a), list2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a
    protected h i() {
        return this.f14017c;
    }
}
