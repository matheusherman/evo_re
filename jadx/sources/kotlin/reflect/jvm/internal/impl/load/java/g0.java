package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum g0 {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13207a = new a(null);
    private final String description;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    public final String f() {
        return this.description;
    }

    public final boolean i() {
        return this == IGNORE;
    }

    public final boolean j() {
        return this == WARN;
    }

    g0(String str) {
        this.description = str;
    }
}
