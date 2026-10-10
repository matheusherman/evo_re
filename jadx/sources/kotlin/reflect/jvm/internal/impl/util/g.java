package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14408a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f14409b = new a();

        private a() {
            super(false, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14410b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String error) {
            super(false, null);
            kotlin.jvm.internal.m.f(error, "error");
            this.f14410b = error;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f14411b = new c();

        private c() {
            super(true, null);
        }
    }

    public /* synthetic */ g(boolean z10, kotlin.jvm.internal.g gVar) {
        this(z10);
    }

    private g(boolean z10) {
        this.f14408a = z10;
    }

    public final boolean a() {
        return this.f14408a;
    }
}
