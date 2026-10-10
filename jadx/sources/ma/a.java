package ma;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.b1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b1> f15694a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends b1> translators) {
        m.f(translators, "translators");
        this.f15694a = translators;
    }

    public final List<b1> a() {
        return this.f15694a;
    }
}
