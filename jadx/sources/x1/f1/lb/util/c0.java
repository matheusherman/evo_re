package x1.f1.lb.util;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import x.l1.b2.R$string;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lx1/f1/lb/util/c0;", "", "<init>", "()V", "", "a", "()J", "", "b", "I", "lastDvrDays", "c", "J", "dvrKeepMillis", "", "d", "[I", "WEEKDAY_TITLE", "e", "WEEKDAY_TITLE_F", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f21354a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int lastDvrDays;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long dvrKeepMillis;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int[] WEEKDAY_TITLE;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int[] WEEKDAY_TITLE_F;

    static {
        int i10 = R$string.sunday;
        int i11 = R$string.monday;
        int i12 = R$string.tuesday;
        WEEKDAY_TITLE = new int[]{i10, i11, i12, R$string.wednesday, i12, R$string.friday, R$string.saturday};
        int i13 = R$string.sunday_f;
        int i14 = R$string.monday_f;
        int i15 = R$string.tuesday_f;
        WEEKDAY_TITLE_F = new int[]{i13, i14, i15, R$string.wednesday_f, i15, R$string.friday_f, R$string.saturday_f};
    }

    private c0() {
    }

    public final long a() {
        long jD = d1.d();
        if (dvrKeepMillis == 0 || x1.f1.lb.config.b.f20643a.e() != lastDvrDays) {
            TimeUnit timeUnit = TimeUnit.DAYS;
            x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
            dvrKeepMillis = timeUnit.toMillis(bVar.e());
            lastDvrDays = bVar.e();
        }
        return jD - dvrKeepMillis;
    }
}
