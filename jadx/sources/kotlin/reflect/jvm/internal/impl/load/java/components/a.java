package kotlin.reflect.jvm.internal.impl.load.java.components;

import c9.l;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.resolve.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.components.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class C0224a extends kotlin.reflect.jvm.internal.impl.resolve.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f13157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f13158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f13159c;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.components.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0225a implements l<kotlin.reflect.jvm.internal.impl.descriptors.b, z> {
            private static /* synthetic */ void a(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            C0225a() {
            }

            @Override // c9.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public z invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
                if (bVar == null) {
                    a(0);
                }
                C0224a.this.f13157a.a(bVar);
                return z.f17874a;
            }
        }

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "fromSuper";
            } else if (i10 == 2) {
                objArr[0] = "fromCurrent";
            } else if (i10 == 3) {
                objArr[0] = "member";
            } else if (i10 != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "conflict";
            } else if (i10 == 3 || i10 == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        C0224a(q qVar, Set set, boolean z10) {
            this.f13157a = qVar;
            this.f13158b = set;
            this.f13159c = z10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.j
        public void a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            if (bVar == null) {
                f(0);
            }
            k.K(bVar, new C0225a());
            this.f13158b.add(bVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.j
        public void d(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
            if (bVar == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.f13159c || bVar.g() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE) {
                super.d(bVar, collection);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.i
        public void e(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar2) {
            if (bVar == null) {
                f(1);
            }
            if (bVar2 == null) {
                f(2);
            }
        }
    }

    private static /* synthetic */ void a(int i10) {
        String str = i10 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 18 ? 3 : 2];
        switch (i10) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static j1 b(ba.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (fVar == null) {
            a(19);
        }
        if (eVar == null) {
            a(20);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> collectionK = eVar.k();
        if (collectionK.size() != 1) {
            return null;
        }
        for (j1 j1Var : collectionK.iterator().next().f()) {
            if (j1Var.getName().equals(fVar)) {
                return j1Var;
            }
        }
        return null;
    }

    private static <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> Collection<D> c(ba.f fVar, Collection<D> collection, Collection<D> collection2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, q qVar, k kVar, boolean z10) {
        if (fVar == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (eVar == null) {
            a(15);
        }
        if (qVar == null) {
            a(16);
        }
        if (kVar == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        kVar.v(fVar, collection, collection2, eVar, new C0224a(qVar, linkedHashSet, z10));
        return linkedHashSet;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> Collection<D> d(ba.f fVar, Collection<D> collection, Collection<D> collection2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, q qVar, k kVar) {
        if (fVar == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (eVar == null) {
            a(3);
        }
        if (qVar == null) {
            a(4);
        }
        if (kVar == null) {
            a(5);
        }
        return c(fVar, collection, collection2, eVar, qVar, kVar, false);
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> Collection<D> e(ba.f fVar, Collection<D> collection, Collection<D> collection2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, q qVar, k kVar) {
        if (fVar == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (eVar == null) {
            a(9);
        }
        if (qVar == null) {
            a(10);
        }
        if (kVar == null) {
            a(11);
        }
        return c(fVar, collection, collection2, eVar, qVar, kVar, true);
    }
}
