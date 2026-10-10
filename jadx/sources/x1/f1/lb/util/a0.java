package x1.f1.lb.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0016\u0010$\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001c¨\u0006%"}, d2 = {"Lx1/f1/lb/util/a0;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lr8/z;", "f", "(Landroid/app/Activity;)V", "Landroid/content/Context;", "context", "e", "(Landroid/content/Context;)V", "", "b", "(Landroid/content/Context;F)F", "", "c", "(Landroid/app/Activity;)I", "d", "(Landroid/content/Context;)F", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "F", "sNonCompatDensity", "sNonCompatScaledDensity", "I", "sNonCompatDensityDpi", "heightPixels", "g", "widthPixels", "h", "density", "i", "densityDpi", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f21295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static float sNonCompatDensity;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static float sNonCompatScaledDensity;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int sNonCompatDensityDpi;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int heightPixels;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int widthPixels;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static float density;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int densityDpi;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"x1/f1/lb/util/a0$a", "Landroid/content/ComponentCallbacks;", "Landroid/content/res/Configuration;", "p0", "Lr8/z;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onLowMemory", "()V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f21304a;

        a(Application application) {
            this.f21304a = application;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            if (p10.fontScale > 0.0f) {
                a0 a0Var = a0.f21295a;
                a0.sNonCompatScaledDensity = this.f21304a.getResources().getDisplayMetrics().scaledDensity;
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    static {
        a0 a0Var = new a0();
        f21295a = a0Var;
        logger = q6.c.d(a0Var.getClass());
    }

    public final float b(Context context, float f10) {
        kotlin.jvm.internal.m.f(context, "context");
        return (d(context) * f10) + 0.5f;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    public final int c(Activity activity) {
        int systemWindowInsetBottom;
        kotlin.jvm.internal.m.f(activity, "activity");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(activity.getWindow().getDecorView());
            if (rootWindowInsets != null) {
                systemWindowInsetBottom = rootWindowInsets.getSystemWindowInsetBottom();
            } else {
                systemWindowInsetBottom = 0;
            }
        } else {
            WindowInsets rootWindowInsets2 = activity.getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets2 != null) {
                systemWindowInsetBottom = rootWindowInsets2.getSystemWindowInsetBottom();
            } else {
                systemWindowInsetBottom = 0;
            }
        }
        if (systemWindowInsetBottom > 0) {
            return systemWindowInsetBottom;
        }
        try {
            int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return activity.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th) {
            logger.error("get nav bar height failure", th);
            return 0;
        }
    }

    public final float d(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        return x0.f21457a.a(context);
    }

    public final void e(Context context) {
        if (x1.f1.lb.config.b.f20643a.w()) {
            Activity activityI = c.f21341a.i(context);
            if (activityI == null) {
                logger.error("activity is null in setCustomDensity()", new Exception());
            } else {
                f(activityI);
            }
        }
    }

    public final void f(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.w()) {
            Application application = activity.getApplication();
            DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
            if (sNonCompatDensity == 0.0f) {
                sNonCompatDensity = displayMetrics.density;
                sNonCompatScaledDensity = displayMetrics.scaledDensity;
                sNonCompatDensityDpi = displayMetrics.densityDpi;
                application.registerComponentCallbacks(new a(application));
            }
            int i10 = displayMetrics.heightPixels;
            heightPixels = i10;
            widthPixels = i10;
            float f10 = (i10 * 1.0f) / displayMetrics.widthPixels;
            float f11 = f10 / 0.5625f;
            float f12 = f11 * 1.6875f * (sNonCompatScaledDensity / sNonCompatDensity);
            int i11 = sNonCompatDensityDpi;
            DisplayMetrics displayMetrics2 = activity.getResources().getDisplayMetrics();
            if (bVar.t()) {
                logger.debug("{}\nsetCustomDensity Activity[{}]\nScreen:\n    Width x Height[{} x {}], Ratio[{} x {} -> {}]\nApp:\n    Density[{} -> {}], ScaleDensity[{} -> {}], DensityDpi[{} -> {}]\nActivity:\n    Density[{} -> {}], ScaleDensity[{} -> {}], DensityDpi[{} -> {}]", q.c(q.f21441a, 0, 1, null), activity.getClass().getSimpleName(), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(0.5625f), Float.valueOf(displayMetrics.density), Float.valueOf(1.6875f), Float.valueOf(displayMetrics.scaledDensity), Float.valueOf(f12), Integer.valueOf(displayMetrics.densityDpi), Integer.valueOf(i11), Float.valueOf(displayMetrics2.density), Float.valueOf(1.6875f), Float.valueOf(displayMetrics2.scaledDensity), Float.valueOf(f12), Integer.valueOf(displayMetrics2.densityDpi), Integer.valueOf(i11));
            }
            displayMetrics.density = 1.6875f;
            displayMetrics.scaledDensity = f12;
            displayMetrics.densityDpi = i11;
            displayMetrics2.density = 1.6875f;
            displayMetrics2.scaledDensity = f12;
            displayMetrics2.densityDpi = i11;
            density = 1.6875f;
            densityDpi = i11;
        }
    }

    private a0() {
    }
}
