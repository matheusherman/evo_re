package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.v0;
import u9.r;
import u9.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface b {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13279a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        public w c(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        public u9.n d(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public List<r> b(ba.f name) {
            kotlin.jvm.internal.m.f(name, "name");
            return kotlin.collections.r.l();
        }

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        public Set<ba.f> a() {
            return v0.e();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        public Set<ba.f> e() {
            return v0.e();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
        public Set<ba.f> f() {
            return v0.e();
        }
    }

    Set<ba.f> a();

    Collection<r> b(ba.f fVar);

    w c(ba.f fVar);

    u9.n d(ba.f fVar);

    Set<ba.f> e();

    Set<ba.f> f();
}
