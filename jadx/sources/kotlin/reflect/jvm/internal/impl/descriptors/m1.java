package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f12985a = new m1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<n1, Integer> f12986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f12987c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12988c = new a();

        private a() {
            super(Configurator.INHERITED, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12989c = new b();

        private b() {
            super("internal", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f12990c = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class d extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f12991c = new d();

        private d() {
            super("local", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class e extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f12992c = new e();

        private e() {
            super("private", false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class f extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f12993c = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class g extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f12994c = new g();

        private g() {
            super("protected", true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class h extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f12995c = new h();

        private h() {
            super("public", true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class i extends n1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f12996c = new i();

        private i() {
            super("unknown", false);
        }
    }

    static {
        Map mapC = kotlin.collections.n0.c();
        mapC.put(f.f12993c, 0);
        mapC.put(e.f12992c, 0);
        mapC.put(b.f12989c, 1);
        mapC.put(g.f12994c, 1);
        h hVar = h.f12995c;
        mapC.put(hVar, 2);
        f12986b = kotlin.collections.n0.b(mapC);
        f12987c = hVar;
    }

    public final Integer a(n1 first, n1 second) {
        kotlin.jvm.internal.m.f(first, "first");
        kotlin.jvm.internal.m.f(second, "second");
        if (first == second) {
            return 0;
        }
        Map<n1, Integer> map = f12986b;
        Integer num = map.get(first);
        Integer num2 = map.get(second);
        if (num == null || num2 == null || kotlin.jvm.internal.m.a(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(n1 visibility) {
        kotlin.jvm.internal.m.f(visibility, "visibility");
        return visibility == e.f12992c || visibility == f.f12993c;
    }

    private m1() {
    }
}
