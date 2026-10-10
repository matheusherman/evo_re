package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface h extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14001a = a.f14002a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f14002a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final c9.l<ba.f, Boolean> f14003b = C0256a.f14004a;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.scopes.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0256a extends o implements c9.l<ba.f, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0256a f14004a = new C0256a();

            C0256a() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(ba.f it) {
                kotlin.jvm.internal.m.f(it, "it");
                return Boolean.TRUE;
            }
        }

        public final c9.l<ba.f, Boolean> a() {
            return f14003b;
        }

        private a() {
        }
    }

    Collection<? extends u0> a(ba.f fVar, r9.b bVar);

    Set<ba.f> b();

    Collection<? extends z0> c(ba.f fVar, r9.b bVar);

    Set<ba.f> d();

    Set<ba.f> f();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f14005b = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Set<ba.f> b() {
            return v0.e();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Set<ba.f> d() {
            return v0.e();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Set<ba.f> f() {
            return v0.e();
        }
    }
}
