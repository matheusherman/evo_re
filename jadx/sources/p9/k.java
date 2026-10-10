package p9;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17447c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k f17448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p9.a f17449b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final k a(ClassLoader classLoader) {
            kotlin.jvm.internal.m.f(classLoader, "classLoader");
            g gVar = new g(classLoader);
            kotlin.reflect.jvm.internal.impl.load.kotlin.g.a aVar = kotlin.reflect.jvm.internal.impl.load.kotlin.g.f13577b;
            ClassLoader classLoader2 = z.class.getClassLoader();
            kotlin.jvm.internal.m.e(classLoader2, "Unit::class.java.classLoader");
            kotlin.reflect.jvm.internal.impl.load.kotlin.g.a.C0241a c0241aA = aVar.a(gVar, new g(classLoader2), new d(classLoader), "runtime module for " + classLoader, j.f17446b, l.f17450a);
            return new k(c0241aA.a().a(), new p9.a(c0241aA.b(), gVar), null);
        }
    }

    public /* synthetic */ k(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k kVar, p9.a aVar, kotlin.jvm.internal.g gVar) {
        this(kVar, aVar);
    }

    private k(kotlin.reflect.jvm.internal.impl.serialization.deserialization.k kVar, p9.a aVar) {
        this.f17448a = kVar;
        this.f17449b = aVar;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k a() {
        return this.f17448a;
    }

    public final h0 b() {
        return this.f17448a.p();
    }

    public final p9.a c() {
        return this.f17449b;
    }
}
