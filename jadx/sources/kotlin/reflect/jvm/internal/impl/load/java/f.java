package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f extends i0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f f13199n = new f();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13200a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf(f.f13199n.j(it));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13201a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b it) {
            kotlin.jvm.internal.m.f(it, "it");
            return Boolean.valueOf((it instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) && f.f13199n.j(it));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        return kotlin.collections.r.a0(i0.f13217a.e(), kotlin.reflect.jvm.internal.impl.load.kotlin.x.d(bVar));
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.y k(kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
        kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
        f fVar = f13199n;
        ba.f name = functionDescriptor.getName();
        kotlin.jvm.internal.m.e(name, "functionDescriptor.name");
        if (fVar.l(name)) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.y) ea.c.f(functionDescriptor, false, a.f13200a, 1, null);
        }
        return null;
    }

    public static final i0.b m(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarF;
        String strD;
        kotlin.jvm.internal.m.f(bVar, "<this>");
        i0.a aVar = i0.f13217a;
        if (!aVar.d().contains(bVar.getName()) || (bVarF = ea.c.f(bVar, false, b.f13201a, 1, null)) == null || (strD = kotlin.reflect.jvm.internal.impl.load.kotlin.x.d(bVarF)) == null) {
            return null;
        }
        return aVar.l(strD);
    }

    public final boolean l(ba.f fVar) {
        kotlin.jvm.internal.m.f(fVar, "<this>");
        return i0.f13217a.d().contains(fVar);
    }

    private f() {
    }
}
