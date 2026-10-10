package c5;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lq6/b;", "logger", "", "t", "", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "c", "(Lq6/b;Ljava/lang/Throwable;Ljava/lang/String;)V", "b", "(Lq6/b;Ljava/lang/String;Ljava/lang/Throwable;)V", "a", "(Lq6/b;Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class b {
    public static final void a(q6.b logger, String str) {
        m.f(logger, "logger");
        logger.debug(str, new Object[0]);
    }

    public static final void b(q6.b logger, String str, Throwable th) {
        m.f(logger, "logger");
        logger.error(str, th);
    }

    public static final void c(q6.b logger, Throwable th, String str) {
        m.f(logger, "logger");
        logger.error(str, th);
    }
}
