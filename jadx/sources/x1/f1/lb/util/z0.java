package x1.f1.lb.util;

import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lx1/f1/lb/util/z0;", "", "<init>", "()V", "", "bps", "", "a", "(J)Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f21483a = new z0();

    public final String a(long bps) {
        double d10 = bps / 1024.0d;
        if (d10 > 1023.0d) {
            kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
            String str = String.format("%.2fMb/s", Arrays.copyOf(new Object[]{Double.valueOf(d10 / 1024.0d)}, 1));
            kotlin.jvm.internal.m.e(str, "format(...)");
            return str;
        }
        kotlin.jvm.internal.g0 g0Var2 = kotlin.jvm.internal.g0.f12340a;
        String str2 = String.format("%dKb/s", Arrays.copyOf(new Object[]{Integer.valueOf((int) d10)}, 1));
        kotlin.jvm.internal.m.e(str2, "format(...)");
        return str2;
    }

    private z0() {
    }
}
