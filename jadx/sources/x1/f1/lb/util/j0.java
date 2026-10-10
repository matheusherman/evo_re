package x1.f1.lb.util;

import android.os.Build;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R\u001c\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lx1/f1/lb/util/j0;", "", "<init>", "()V", "Lr8/z;", "e", "c", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f21396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lx1/f1/lb/util/j0$a;", "", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "a", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        FirebaseAnalytics a();
    }

    static {
        j0 j0Var = new j0();
        f21396a = j0Var;
        logger = q6.c.d(j0Var.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j10, FirebaseAnalytics firebaseAnalytics, String str, long j11) {
        String str2;
        if (j11 != j10) {
            if (j10 - d1.d() > 604800000) {
                TimeUnit timeUnit = TimeUnit.DAYS;
                if (j10 < timeUnit.toMillis(13L)) {
                    str2 = "1w";
                } else if (j10 < timeUnit.toMillis(20L)) {
                    str2 = "2w";
                } else if (j10 < timeUnit.toMillis(40L)) {
                    str2 = "1m";
                } else if (j10 < timeUnit.toMillis(100L)) {
                    str2 = "3m";
                } else if (j10 < timeUnit.toMillis(200L)) {
                    str2 = "6m";
                } else if (j10 < timeUnit.toMillis(400L)) {
                    str2 = "1y";
                } else {
                    str2 = j10 < timeUnit.toMillis(800L) ? "2y" : "2y+";
                }
                Bundle bundle = new Bundle();
                bundle.putString("plan", str2);
                k kVar = k.f21398a;
                bundle.putString("app_type", kVar.r());
                bundle.putString(MessageOriginChannel.MESSAGE_ORIGIN_TYPE, kVar.v());
                firebaseAnalytics.a("user_add_plan", bundle);
            }
            w0.f21452a.s(str, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, FirebaseAnalytics firebaseAnalytics, String it) {
        kotlin.jvm.internal.m.f(it, "it");
        if (kotlin.jvm.internal.m.a(it, str)) {
            return;
        }
        Bundle bundle = new Bundle();
        k kVar = k.f21398a;
        bundle.putString("ver_name", kVar.t());
        bundle.putString("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("ver_code", String.valueOf(kVar.s()));
        bundle.putString("app_type", kVar.r());
        bundle.putString(MessageOriginChannel.MESSAGE_ORIGIN_TYPE, kVar.v());
        firebaseAnalytics.a("user_version", bundle);
    }

    public final void c() {
        final FirebaseAnalytics firebaseAnalyticsK = c.f21341a.k();
        if (firebaseAnalyticsK == null) {
            return;
        }
        x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
        if (fVar.O0()) {
            return;
        }
        final long jM0 = fVar.m0();
        final String str = "user_last_expire_ts." + of.a.f16585a.b();
        w0.f21452a.k(str, new w0.a() { // from class: x1.f1.lb.util.i0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                j0.d(jM0, firebaseAnalyticsK, str, ((Long) obj).longValue());
            }
        }, 0L);
    }

    public final void e() {
        final FirebaseAnalytics firebaseAnalyticsK = c.f21341a.k();
        if (firebaseAnalyticsK == null) {
            return;
        }
        final String strT = k.f21398a.t();
        w0.f21452a.n("user_version_name." + of.a.f16585a.b(), new w0.a() { // from class: x1.f1.lb.util.h0
            @Override // x1.f1.lb.util.w0.a
            public final void a(Object obj) {
                j0.f(strT, firebaseAnalyticsK, (String) obj);
            }
        }, "");
    }

    private j0() {
    }
}
