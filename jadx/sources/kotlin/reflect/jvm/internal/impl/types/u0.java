package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class u0 extends l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.f1 f14379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r8.i f14380b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.a<g0> {
        a() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke() {
            return v0.b(u0.this.f14379a);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public boolean b() {
        return true;
    }

    public u0(kotlin.reflect.jvm.internal.impl.descriptors.f1 typeParameter) {
        kotlin.jvm.internal.m.f(typeParameter, "typeParameter");
        this.f14379a = typeParameter;
        this.f14380b = r8.j.b(r8.m.PUBLICATION, new a());
    }

    private final g0 e() {
        return (g0) this.f14380b.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public w1 a() {
        return w1.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public k1 c(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k1
    public g0 getType() {
        return e();
    }
}
