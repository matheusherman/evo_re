package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface k {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(k kVar, d dVar, c9.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i10 & 1) != 0) {
                dVar = d.f13978o;
            }
            if ((i10 & 2) != 0) {
                lVar = h.f14001a.a();
            }
            return kVar.g(dVar, lVar);
        }
    }

    kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f fVar, r9.b bVar);

    Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d dVar, c9.l<? super ba.f, Boolean> lVar);
}
