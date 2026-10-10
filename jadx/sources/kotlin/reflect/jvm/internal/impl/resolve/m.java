package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import kotlin.collections.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m {

    /* JADX INFO: Add missing generic type declarations: [H] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a<H> extends kotlin.jvm.internal.o implements c9.l<H, z> {
        final /* synthetic */ sa.g<H> $conflictedHandles;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke2(obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(sa.g<H> gVar) {
            super(1);
            this.$conflictedHandles = gVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(H it) {
            sa.g<H> gVar = this.$conflictedHandles;
            kotlin.jvm.internal.m.e(it, "it");
            gVar.add(it);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> a(Collection<? extends H> collection, c9.l<? super H, ? extends kotlin.reflect.jvm.internal.impl.descriptors.a> descriptorByHandle) {
        kotlin.jvm.internal.m.f(collection, "<this>");
        kotlin.jvm.internal.m.f(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        sa.g gVarA = sa.g.f18524c.a();
        while (!linkedList.isEmpty()) {
            Object objG0 = r.g0(linkedList);
            sa.g gVarA2 = sa.g.f18524c.a();
            Collection<a0.f> collectionP = k.p(objG0, linkedList, descriptorByHandle, new a(gVarA2));
            kotlin.jvm.internal.m.e(collectionP, "conflictedHandles = Smar…nflictedHandles.add(it) }");
            if (collectionP.size() == 1 && gVarA2.isEmpty()) {
                Object objE0 = r.E0(collectionP);
                kotlin.jvm.internal.m.e(objE0, "overridableGroup.single()");
                gVarA.add(objE0);
            } else {
                a0.f fVar = (Object) k.L(collectionP, descriptorByHandle);
                kotlin.jvm.internal.m.e(fVar, "selectMostSpecificMember…roup, descriptorByHandle)");
                kotlin.reflect.jvm.internal.impl.descriptors.a aVarInvoke = descriptorByHandle.invoke(fVar);
                for (a0.f it : collectionP) {
                    kotlin.jvm.internal.m.e(it, "it");
                    if (!k.B(aVarInvoke, descriptorByHandle.invoke(it))) {
                        gVarA2.add(it);
                    }
                }
                if (!gVarA2.isEmpty()) {
                    gVarA.addAll(gVarA2);
                }
                gVarA.add(fVar);
            }
        }
        return gVarA;
    }
}
