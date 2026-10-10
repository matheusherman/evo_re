package ac;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Random f230a = new Random();

    public static int a(int i10, int i11) {
        i.a(i11 >= i10, "Start value must be smaller or equal to end value.", new Object[0]);
        i.a(i10 >= 0, "Both range values must be non-negative.", new Object[0]);
        return i10 == i11 ? i10 : i10 + f230a.nextInt(i11 - i10);
    }
}
