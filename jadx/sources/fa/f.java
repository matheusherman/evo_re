package fa;

import java.util.Collection;
import java.util.List;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10101a = a.f10102a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f10102a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final fa.a f10103b = new fa.a(r.l());

        public final fa.a a() {
            return f10103b;
        }

        private a() {
        }
    }

    void a(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, List<kotlin.reflect.jvm.internal.impl.descriptors.d> list);

    List<ba.f> b(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    void c(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, ba.f fVar, List<kotlin.reflect.jvm.internal.impl.descriptors.e> list);

    void d(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, ba.f fVar, Collection<z0> collection);

    void e(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, ba.f fVar, Collection<z0> collection);

    List<ba.f> f(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    List<ba.f> g(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar);
}
