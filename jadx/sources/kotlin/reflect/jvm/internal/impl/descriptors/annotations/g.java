package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface g extends Iterable<c>, d9.a {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final a f12688i0 = a.f12689a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f12689a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final g f12690b = new C0218a();

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0218a implements g {
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public boolean isEmpty() {
                return true;
            }

            public Void e(ba.c fqName) {
                kotlin.jvm.internal.m.f(fqName, "fqName");
                return null;
            }

            public String toString() {
                return "EMPTY";
            }

            C0218a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public boolean F(ba.c cVar) {
                return b.b(this, cVar);
            }

            @Override // java.lang.Iterable
            public Iterator<c> iterator() {
                return r.l().iterator();
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public /* bridge */ /* synthetic */ c j(ba.c cVar) {
                return (c) e(cVar);
            }
        }

        public final g a(List<? extends c> annotations) {
            kotlin.jvm.internal.m.f(annotations, "annotations");
            return annotations.isEmpty() ? f12690b : new h(annotations);
        }

        public final g b() {
            return f12690b;
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
        public static c a(g gVar, ba.c fqName) {
            c next;
            kotlin.jvm.internal.m.f(fqName, "fqName");
            Iterator<c> it = gVar.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (kotlin.jvm.internal.m.a(next.d(), fqName)) {
                    return next;
                }
            }
            next = null;
            return next;
        }

        public static boolean b(g gVar, ba.c fqName) {
            kotlin.jvm.internal.m.f(fqName, "fqName");
            return gVar.j(fqName) != null;
        }
    }

    boolean F(ba.c cVar);

    boolean isEmpty();

    c j(ba.c cVar);
}
