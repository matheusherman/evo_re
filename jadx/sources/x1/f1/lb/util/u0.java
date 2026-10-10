package x1.f1.lb.util;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lx1/f1/lb/util/u0;", "", "<init>", "()V", "", "resId", "", "dft", "a", "(ILjava/lang/String;)Ljava/lang/String;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u0 f21448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    static {
        u0 u0Var = new u0();
        f21448a = u0Var;
        logger = q6.c.d(u0Var.getClass());
    }

    public static /* synthetic */ String b(u0 u0Var, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "";
        }
        return u0Var.a(i10, str);
    }

    public final String a(int resId, String dft) {
        String string;
        kotlin.jvm.internal.m.f(dft, "dft");
        try {
            Context contextA = x1.f1.lb.config.b.f20643a.a();
            return (contextA == null || (string = contextA.getString(resId)) == null) ? dft : string;
        } catch (Throwable th) {
            logger.error("getString failure", th);
            return dft;
        }
    }

    private u0() {
    }
}
