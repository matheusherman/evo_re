package retrofit2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class m extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient f0<?> f18051a;
    private final int code;
    private final String message;

    private static String a(f0<?> f0Var) {
        Objects.requireNonNull(f0Var, "response == null");
        return "HTTP " + f0Var.b() + " " + f0Var.g();
    }

    public m(f0<?> f0Var) {
        super(a(f0Var));
        this.code = f0Var.b();
        this.message = f0Var.g();
        this.f18051a = f0Var;
    }
}
