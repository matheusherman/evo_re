package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.a1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y9.c f14203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y9.g f14204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a1 f14205c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final w9.c f14206d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final a f14207e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ba.b f14208f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final w9.c.EnumC0388c f14209g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f14210h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w9.c classProto, y9.c nameResolver, y9.g typeTable, a1 a1Var, a aVar) {
            super(nameResolver, typeTable, a1Var, null);
            kotlin.jvm.internal.m.f(classProto, "classProto");
            kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
            kotlin.jvm.internal.m.f(typeTable, "typeTable");
            this.f14206d = classProto;
            this.f14207e = aVar;
            this.f14208f = w.a(nameResolver, classProto.E0());
            w9.c.EnumC0388c enumC0388cD = y9.b.f22499f.d(classProto.D0());
            this.f14209g = enumC0388cD == null ? w9.c.EnumC0388c.CLASS : enumC0388cD;
            Boolean boolD = y9.b.f22500g.d(classProto.D0());
            kotlin.jvm.internal.m.e(boolD, "IS_INNER.get(classProto.flags)");
            this.f14210h = boolD.booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.y
        public ba.c a() {
            ba.c cVarB = this.f14208f.b();
            kotlin.jvm.internal.m.e(cVarB, "classId.asSingleFqName()");
            return cVarB;
        }

        public final ba.b e() {
            return this.f14208f;
        }

        public final w9.c f() {
            return this.f14206d;
        }

        public final w9.c.EnumC0388c g() {
            return this.f14209g;
        }

        public final a h() {
            return this.f14207e;
        }

        public final boolean i() {
            return this.f14210h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ba.c f14211d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ba.c fqName, y9.c nameResolver, y9.g typeTable, a1 a1Var) {
            super(nameResolver, typeTable, a1Var, null);
            kotlin.jvm.internal.m.f(fqName, "fqName");
            kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
            kotlin.jvm.internal.m.f(typeTable, "typeTable");
            this.f14211d = fqName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.y
        public ba.c a() {
            return this.f14211d;
        }
    }

    public /* synthetic */ y(y9.c cVar, y9.g gVar, a1 a1Var, kotlin.jvm.internal.g gVar2) {
        this(cVar, gVar, a1Var);
    }

    public abstract ba.c a();

    private y(y9.c cVar, y9.g gVar, a1 a1Var) {
        this.f14203a = cVar;
        this.f14204b = gVar;
        this.f14205c = a1Var;
    }

    public final y9.c b() {
        return this.f14203a;
    }

    public final a1 c() {
        return this.f14205c;
    }

    public final y9.g d() {
        return this.f14204b;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + a();
    }
}
