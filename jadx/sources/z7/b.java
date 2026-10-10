package z7;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f¨\u0006\u0011"}, d2 = {"Lz7/b;", "", "<init>", "()V", "", "key", "dft", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "isACLEnable", "b", "(Z)Z", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    static {
        b bVar = new b();
        f23095a = bVar;
        logger = q6.c.d(bVar.getClass());
    }

    private final String a(String key, String dft) {
        try {
            return o.f23121a.a(key, dft);
        } catch (Throwable th) {
            logger.error("get_sys_prop [" + key + "] failure", th);
            return dft;
        }
    }

    public final boolean b(boolean isACLEnable) {
        return kotlin.jvm.internal.m.a(a("persist.sys.launcher.activation", isACLEnable ? "0" : "1"), "1");
    }

    private b() {
    }
}
