package h8;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final /* synthetic */ class b {
    public static c a() {
        return k8.b.INSTANCE;
    }

    public static c b(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new f(runnable);
    }
}
