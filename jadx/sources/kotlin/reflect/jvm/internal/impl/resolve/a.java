package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13881a = new a();

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0251a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a(ea.c.l((kotlin.reflect.jvm.internal.impl.descriptors.e) t10).b(), ea.c.l((kotlin.reflect.jvm.internal.impl.descriptors.e) t11).b());
        }
    }

    private static final void b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, LinkedHashSet<kotlin.reflect.jvm.internal.impl.descriptors.e> linkedHashSet, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, boolean z10) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.m mVar : kotlin.reflect.jvm.internal.impl.resolve.scopes.k.a.a(hVar, kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f13983t, null, 2, null)) {
            if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarO = (kotlin.reflect.jvm.internal.impl.descriptors.e) mVar;
                if (eVarO.I()) {
                    ba.f name = eVarO.getName();
                    kotlin.jvm.internal.m.e(name, "descriptor.name");
                    kotlin.reflect.jvm.internal.impl.descriptors.h hVarE = hVar.e(name, r9.d.WHEN_GET_ALL_DESCRIPTORS);
                    eVarO = hVarE instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarE : hVarE instanceof e1 ? ((e1) hVarE).o() : null;
                }
                if (eVarO != null) {
                    if (e.z(eVarO, eVar)) {
                        linkedHashSet.add(eVarO);
                    }
                    if (z10) {
                        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarU0 = eVarO.u0();
                        kotlin.jvm.internal.m.e(hVarU0, "refinedDescriptor.unsubstitutedInnerClassesScope");
                        b(eVar, linkedHashSet, hVarU0, z10);
                    }
                }
            }
        }
    }

    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> a(kotlin.reflect.jvm.internal.impl.descriptors.e sealedClass, boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.m next;
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB;
        kotlin.jvm.internal.m.f(sealedClass, "sealedClass");
        if (sealedClass.i() != e0.SEALED) {
            return r.l();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z10) {
            Iterator<kotlin.reflect.jvm.internal.impl.descriptors.m> it = ea.c.q(sealedClass).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof l0));
            mVarB = next;
        } else {
            mVarB = sealedClass.b();
        }
        if (mVarB instanceof l0) {
            b(sealedClass, linkedHashSet, ((l0) mVarB).n(), z10);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarU0 = sealedClass.u0();
        kotlin.jvm.internal.m.e(hVarU0, "sealedClass.unsubstitutedInnerClassesScope");
        b(sealedClass, linkedHashSet, hVarU0, true);
        return r.J0(linkedHashSet, new C0251a());
    }

    private a() {
    }
}
