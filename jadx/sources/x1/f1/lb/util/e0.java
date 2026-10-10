package x1.f1.lb.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u0007R\u001c\u0010\f\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000b¨\u0006\r"}, d2 = {"Lx1/f1/lb/util/e0;", "", "<init>", "()V", "subscriber", "Lr8/z;", "a", "(Ljava/lang/Object;)V", "b", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f21385a = new e0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(e0.class);

    public final void a(Object subscriber) {
        kotlin.jvm.internal.m.f(subscriber, "subscriber");
        if (xe.c.c().j(subscriber)) {
            return;
        }
        try {
            xe.c.c().q(subscriber);
        } catch (Throwable th) {
            logger.error("register event bus failure", th);
        }
    }

    public final void b(Object subscriber) {
        kotlin.jvm.internal.m.f(subscriber, "subscriber");
        if (xe.c.c().j(subscriber)) {
            try {
                xe.c.c().u(subscriber);
            } catch (Throwable th) {
                logger.error("unregister event bus failure", th);
            }
        }
    }

    private e0() {
    }
}
