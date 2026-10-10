package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<l0> f12997a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<l0, ba.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12998a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ba.c invoke(l0 it) {
            kotlin.jvm.internal.m.f(it, "it");
            return it.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<ba.c, Boolean> {
        final /* synthetic */ ba.c $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ba.c cVar) {
            super(1);
            this.$fqName = cVar;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(ba.c it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(!it.d() && kotlin.jvm.internal.m.a(it.e(), this.$fqName));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(Collection<? extends l0> packageFragments) {
        kotlin.jvm.internal.m.f(packageFragments, "packageFragments");
        this.f12997a = packageFragments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public boolean a(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        Collection<l0> collection = this.f12997a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.m.a(((l0) it.next()).d(), fqName)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public void b(ba.c fqName, Collection<l0> packageFragments) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(packageFragments, "packageFragments");
        for (Object obj : this.f12997a) {
            if (kotlin.jvm.internal.m.a(((l0) obj).d(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    public List<l0> c(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        Collection<l0> collection = this.f12997a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.m.a(((l0) obj).d(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    public Collection<ba.c> m(ba.c fqName, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return ta.k.P(ta.k.y(ta.k.J(kotlin.collections.r.Z(this.f12997a), a.f12998a), new b(fqName)));
    }
}
