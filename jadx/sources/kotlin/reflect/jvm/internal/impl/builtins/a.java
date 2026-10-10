package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0213a f12454a = C0213a.f12455a;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.builtins.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0213a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0213a f12455a = new C0213a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final r8.i<a> f12456b = r8.j.b(r8.m.PUBLICATION, C0214a.f12457a);

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.builtins.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0214a extends kotlin.jvm.internal.o implements c9.a<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0214a f12457a = new C0214a();

            C0214a() {
                super(0);
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a invoke() {
                ServiceLoader implementations = ServiceLoader.load(a.class, a.class.getClassLoader());
                kotlin.jvm.internal.m.e(implementations, "implementations");
                a aVar = (a) r.h0(implementations);
                if (aVar != null) {
                    return aVar;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        public final a a() {
            return f12456b.getValue();
        }

        private C0213a() {
        }
    }

    m0 a(ka.n nVar, h0 h0Var, Iterable<? extends n9.b> iterable, n9.c cVar, n9.a aVar, boolean z10);
}
