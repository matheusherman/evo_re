package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class r implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c9.l<kotlin.reflect.jvm.internal.impl.builtins.h, g0> f14465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14466c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f14467d = new a();

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.util.r$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0273a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.builtins.h, g0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0273a f14468a = new C0273a();

            C0273a() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g0 invoke(kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
                kotlin.jvm.internal.m.f(hVar, "$this$null");
                o0 booleanType = hVar.n();
                kotlin.jvm.internal.m.e(booleanType, "booleanType");
                return booleanType;
            }
        }

        private a() {
            super("Boolean", C0273a.f14468a, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f14469d = new b();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.builtins.h, g0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f14470a = new a();

            a() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g0 invoke(kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
                kotlin.jvm.internal.m.f(hVar, "$this$null");
                o0 intType = hVar.D();
                kotlin.jvm.internal.m.e(intType, "intType");
                return intType;
            }
        }

        private b() {
            super("Int", a.f14470a, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f14471d = new c();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.builtins.h, g0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f14472a = new a();

            a() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g0 invoke(kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
                kotlin.jvm.internal.m.f(hVar, "$this$null");
                o0 unitType = hVar.Z();
                kotlin.jvm.internal.m.e(unitType, "unitType");
                return unitType;
            }
        }

        private c() {
            super("Unit", a.f14472a, null);
        }
    }

    public /* synthetic */ r(String str, c9.l lVar, kotlin.jvm.internal.g gVar) {
        this(str, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private r(String str, c9.l<? super kotlin.reflect.jvm.internal.impl.builtins.h, ? extends g0> lVar) {
        this.f14464a = str;
        this.f14465b = lVar;
        this.f14466c = "must return " + str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public boolean b(y functionDescriptor) {
        kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
        return kotlin.jvm.internal.m.a(functionDescriptor.getReturnType(), this.f14465b.invoke(ea.c.j(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String getDescription() {
        return this.f14466c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }
}
