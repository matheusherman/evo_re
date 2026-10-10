package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14343a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n1 f14344b = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends n1 {
        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public boolean f() {
            return true;
        }

        public Void i(g0 key) {
            kotlin.jvm.internal.m.f(key, "key");
            return null;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }

        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public /* bridge */ /* synthetic */ k1 e(g0 g0Var) {
            return (k1) i(g0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends n1 {
        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public boolean a() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public boolean b() {
            return false;
        }

        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
            kotlin.jvm.internal.m.f(annotations, "annotations");
            return n1.this.d(annotations);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public k1 e(g0 key) {
            kotlin.jvm.internal.m.f(key, "key");
            return n1.this.e(key);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public boolean f() {
            return n1.this.f();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.n1
        public g0 g(g0 topLevelType, w1 position) {
            kotlin.jvm.internal.m.f(topLevelType, "topLevelType");
            kotlin.jvm.internal.m.f(position, "position");
            return n1.this.g(topLevelType, position);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public abstract k1 e(g0 g0Var);

    public boolean f() {
        return false;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
        kotlin.jvm.internal.m.f(annotations, "annotations");
        return annotations;
    }

    public g0 g(g0 topLevelType, w1 position) {
        kotlin.jvm.internal.m.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.m.f(position, "position");
        return topLevelType;
    }

    public final n1 h() {
        return new c();
    }

    public final p1 c() {
        p1 p1VarG = p1.g(this);
        kotlin.jvm.internal.m.e(p1VarG, "create(this)");
        return p1VarG;
    }
}
