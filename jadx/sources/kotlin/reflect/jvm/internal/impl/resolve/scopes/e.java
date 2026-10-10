package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class e extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f13994d = {c0.g(new w(c0.b(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f13995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.i f13996c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.m>> {
        a() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.m> invoke() {
            List<y> listI = e.this.i();
            return r.B0(listI, e.this.j(listI));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.reflect.jvm.internal.impl.resolve.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.m> f13997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f13998b;

        b(ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.m> arrayList, e eVar) {
            this.f13997a = arrayList;
            this.f13998b = eVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.j
        public void a(kotlin.reflect.jvm.internal.impl.descriptors.b fakeOverride) {
            kotlin.jvm.internal.m.f(fakeOverride, "fakeOverride");
            kotlin.reflect.jvm.internal.impl.resolve.k.K(fakeOverride, null);
            this.f13997a.add(fakeOverride);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.i
        protected void e(kotlin.reflect.jvm.internal.impl.descriptors.b fromSuper, kotlin.reflect.jvm.internal.impl.descriptors.b fromCurrent) {
            kotlin.jvm.internal.m.f(fromSuper, "fromSuper");
            kotlin.jvm.internal.m.f(fromCurrent, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f13998b.l() + ": " + fromSuper + " vs " + fromCurrent).toString());
        }
    }

    protected abstract List<y> i();

    public e(ka.n storageManager, kotlin.reflect.jvm.internal.impl.descriptors.e containingClass) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(containingClass, "containingClass");
        this.f13995b = containingClass;
        this.f13996c = storageManager.c(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<kotlin.reflect.jvm.internal.impl.descriptors.m> j(List<? extends y> list) {
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collectionL;
        ArrayList arrayList = new ArrayList(3);
        Collection<g0> collectionB = this.f13995b.h().b();
        kotlin.jvm.internal.m.e(collectionB, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = collectionB.iterator();
        while (it.hasNext()) {
            r.C(arrayList2, k.a.a(((g0) it.next()).n(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            ba.f name = ((kotlin.reflect.jvm.internal.impl.descriptors.b) obj2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            ba.f fVar = (ba.f) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((kotlin.reflect.jvm.internal.impl.descriptors.b) obj3) instanceof y);
                Object arrayList5 = linkedHashMap2.get(boolValueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                kotlin.reflect.jvm.internal.impl.resolve.k kVar = kotlin.reflect.jvm.internal.impl.resolve.k.f13933f;
                List list4 = list3;
                if (zBooleanValue) {
                    collectionL = new ArrayList<>();
                    for (Object obj4 : list) {
                        if (kotlin.jvm.internal.m.a(((y) obj4).getName(), fVar)) {
                            collectionL.add(obj4);
                        }
                    }
                } else {
                    collectionL = r.l();
                }
                kVar.v(fVar, list4, collectionL, this.f13995b, new b(arrayList, this));
            }
        }
        return sa.a.c(arrayList);
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.m> k() {
        return (List) ka.m.a(this.f13996c, this, f13994d[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        List<kotlin.reflect.jvm.internal.impl.descriptors.m> listK = k();
        sa.f fVar = new sa.f();
        for (Object obj : listK) {
            if ((obj instanceof u0) && kotlin.jvm.internal.m.a(((u0) obj).getName(), name)) {
                fVar.add(obj);
            }
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        List<kotlin.reflect.jvm.internal.impl.descriptors.m> listK = k();
        sa.f fVar = new sa.f();
        for (Object obj : listK) {
            if ((obj instanceof z0) && kotlin.jvm.internal.m.a(((z0) obj).getName(), name)) {
                fVar.add(obj);
            }
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return !kindFilter.a(d.f13979p.m()) ? r.l() : k();
    }

    protected final kotlin.reflect.jvm.internal.impl.descriptors.e l() {
        return this.f13995b;
    }
}
