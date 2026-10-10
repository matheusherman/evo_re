package x1.f1.lb.util;

import android.content.Context;
import java.util.Locale;
import x.l1.b2.R$string;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q6.b f21377a = q6.c.d(d1.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f21378b = System.currentTimeMillis();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f21379c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static k0 f21380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f21381e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f21382a = System.currentTimeMillis();

        a() {
        }

        @Override // x1.f1.lb.util.k0
        public long b() {
            return System.currentTimeMillis() - this.f21382a;
        }
    }

    static {
        a aVar = new a();
        f21380d = aVar;
        f21381e = aVar.b();
    }

    public static String b(long j10, Context context) {
        String str;
        if (j10 < 0) {
            j10 = -j10;
            str = "-";
        } else {
            str = "";
        }
        float f10 = j10 / 1000.0f;
        if (f10 < 60.0f) {
            return String.format(Locale.getDefault(), "%s%.1f %s", str, Float.valueOf(f10), context == null ? "s" : context.getString(R$string.dur_seconds));
        }
        float f11 = f10 / 60.0f;
        if (f11 < 60.0f) {
            return String.format(Locale.getDefault(), "%s%.1f %s", str, Float.valueOf(f11), context == null ? "m" : context.getString(R$string.dur_minutes));
        }
        float f12 = f11 / 60.0f;
        if (f12 < 24.0f) {
            return String.format(Locale.getDefault(), "%s%.1f %s", str, Float.valueOf(f12), context == null ? "h" : context.getString(R$string.dur_hours));
        }
        return String.format(Locale.getDefault(), "%s%.1f %s", str, Float.valueOf(f12 / 24.0f), context == null ? "d" : context.getString(R$string.dur_days));
    }

    public static long c() {
        return f21378b + (f21380d.b() - f21381e);
    }

    public static void e(k0 k0Var) {
        if (k0Var != null) {
            f21380d = k0Var;
            f21381e = k0Var.b();
        }
        w0.f21452a.k("server-time-diff", new w0.a() { // from class: x1.f1.lb.util.c1
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                d1.f21379c = ((Long) obj).longValue();
            }
        }, 0L);
    }

    public static void f(String str, long j10, long j11, long j12) {
        long j13 = j10 - j11;
        if (j13 < 0) {
            f21377a.warn("{} server time sync, invalid round trip delay[{}], ignored, requestTime[{}], responseTime[{}], now[{}]", str, Long.valueOf(j13), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j10));
            return;
        }
        if (j12 <= 0) {
            f21377a.error("{} server time sync, invalid server response time", str, Long.valueOf(j12));
            return;
        }
        long j14 = j12 - (j11 + (j13 >> 1));
        f21379c = j14;
        if (x1.f1.lb.config.b.f20643a.t()) {
            f21377a.debug("{} server time sync, requestTime[{}], responseTime[{}], now[{}], roundTripDelay[{}], timeDiff[{}]", str, Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j10), Long.valueOf(j13), Long.valueOf(j14));
        }
    }

    public static long d() {
        return System.currentTimeMillis() + f21379c;
    }
}
