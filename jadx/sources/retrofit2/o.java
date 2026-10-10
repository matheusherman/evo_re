package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f18059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<?> f18060b;

    public Method a() {
        return this.f18059a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f18059a.getDeclaringClass().getName(), this.f18059a.getName(), this.f18060b);
    }

    o(Method method, List<?> list) {
        this.f18059a = method;
        this.f18060b = Collections.unmodifiableList(list);
    }
}
