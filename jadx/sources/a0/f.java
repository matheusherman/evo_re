package a0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public interface f {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        boolean a() {
            return this.isComplete;
        }

        a(boolean z10) {
            this.isComplete = z10;
        }
    }

    boolean a();

    void b(e eVar);

    boolean c(e eVar);

    boolean e(e eVar);

    boolean f(e eVar);

    f getRoot();

    void i(e eVar);
}
