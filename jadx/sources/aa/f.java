package aa;

import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final z9.a.e f181h;

    /* JADX WARN: Illegal instructions before constructor call */
    public f(z9.a.e types, String[] strings) {
        Set setS0;
        m.f(types, "types");
        m.f(strings, "strings");
        List<Integer> _init_$lambda$0 = types.w();
        if (_init_$lambda$0.isEmpty()) {
            setS0 = v0.e();
        } else {
            m.e(_init_$lambda$0, "_init_$lambda$0");
            setS0 = r.S0(_init_$lambda$0);
        }
        List<z9.a.e.c> listX = types.x();
        m.e(listX, "types.recordList");
        super(strings, setS0, h.a(listX));
        this.f181h = types;
    }
}
