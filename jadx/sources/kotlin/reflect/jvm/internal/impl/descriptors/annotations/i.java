package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {
    public static final g a(g first, g second) {
        kotlin.jvm.internal.m.f(first, "first");
        kotlin.jvm.internal.m.f(second, "second");
        if (first.isEmpty()) {
            return second;
        }
        return second.isEmpty() ? first : new k(first, second);
    }
}
