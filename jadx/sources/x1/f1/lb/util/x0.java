package x1.f1.lb.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.stub.StubApp;
import java.math.BigDecimal;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\rJ\u001d\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0012J\u001d\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0012J\u001d\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0016J\u001d\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b!\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010%R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010'R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010%R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010%R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010%R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010%R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010/¨\u00061"}, d2 = {"Lx1/f1/lb/util/x0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "z", "", "b", "(Landroid/content/Context;Z)I", "", "i", "(Landroid/content/Context;)F", "j", "k", "a", "c", "(Landroid/content/Context;I)I", "Landroid/view/View;", "view", "d", "(Landroid/view/View;I)I", "e", "f", "g", "h", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "l", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;", "m", "(Landroid/content/Context;)I", "n", "Lq6/b;", "Lq6/b;", "logger", "F", "density", "I", "widthPixels", "heightPixels", "measureWidth", "measureHeight", "ratioX", "ratioY", "ratio", "Z", "verticalMode", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static float density;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int widthPixels;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int heightPixels;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static float ratioX;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static float ratioY;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static float ratio;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean verticalMode;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f21457a = new x0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(x0.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static float measureWidth = 1280.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static float measureHeight = 720.0f;

    private final int b(Context context, boolean z10) {
        q6.b bVar;
        if (widthPixels * heightPixels == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = context.getSystemService("window");
            kotlin.jvm.internal.m.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            widthPixels = displayMetrics.widthPixels;
            heightPixels = displayMetrics.heightPixels;
            if (x1.f1.lb.config.b.f20643a.t() && (bVar = logger) != null) {
                bVar.debug("display[resolution={}x{},density={},densityDpi={},scaledDensity={}]", Integer.valueOf(widthPixels), Integer.valueOf(heightPixels), Float.valueOf(displayMetrics.density), Integer.valueOf(displayMetrics.densityDpi), Float.valueOf(displayMetrics.scaledDensity));
            }
        }
        return z10 ? heightPixels : widthPixels;
    }

    private final float i(Context context) {
        if (ratio == 0.0f) {
            synchronized (x0.class) {
                try {
                    if (ratio == 0.0f) {
                        x0 x0Var = f21457a;
                        ratio = Math.min(x0Var.j(context), x0Var.k(context));
                    }
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ratio;
    }

    private final float j(Context context) {
        float fMax;
        float f10;
        if (ratioX == 0.0f) {
            synchronized (x0.class) {
                try {
                    if (ratioX == 0.0f) {
                        if (verticalMode) {
                            x0 x0Var = f21457a;
                            fMax = Math.min(x0Var.n(context), x0Var.m(context));
                            f10 = measureHeight;
                        } else {
                            x0 x0Var2 = f21457a;
                            fMax = Math.max(x0Var2.n(context), x0Var2.m(context));
                            f10 = measureWidth;
                        }
                        ratioX = fMax / f10;
                    }
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ratioX;
    }

    private final float k(Context context) {
        float fMin;
        float f10;
        if (ratioY == 0.0f) {
            synchronized (x0.class) {
                try {
                    if (ratioY == 0.0f) {
                        if (verticalMode) {
                            x0 x0Var = f21457a;
                            fMin = Math.max(x0Var.n(context), x0Var.m(context));
                            f10 = measureWidth;
                        } else {
                            x0 x0Var2 = f21457a;
                            fMin = Math.min(x0Var2.n(context), x0Var2.m(context));
                            f10 = measureHeight;
                        }
                        ratioY = fMin / f10;
                    }
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ratioY;
    }

    public final float a(Context context) {
        q6.b bVar;
        kotlin.jvm.internal.m.f(context, "context");
        if (density == 0.0f) {
            synchronized (x0.class) {
                try {
                    if (density == 0.0f) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        Object systemService = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("window");
                        kotlin.jvm.internal.m.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
                        density = displayMetrics.density;
                    }
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (x1.f1.lb.config.b.f20643a.t() && (bVar = logger) != null) {
            bVar.debug("ScreenDensity [" + density + "]", new Object[0]);
        }
        return density;
    }

    public final int c(Context context, int i10) {
        kotlin.jvm.internal.m.f(context, "context");
        float fI = i(context);
        if (Math.abs(j(context) - k(context)) < 0.15d) {
            fI = k(context);
        }
        return new BigDecimal(fI * i10).setScale(0, 4).intValue();
    }

    public final int d(View view, int i10) {
        kotlin.jvm.internal.m.f(view, "view");
        Context context = view.getContext();
        kotlin.jvm.internal.m.e(context, "getContext(...)");
        return c(context, i10);
    }

    public final int e(Context context, int i10) {
        kotlin.jvm.internal.m.f(context, "context");
        float fI = i(context);
        if (Math.abs(j(context) - k(context)) < 0.15d) {
            fI = j(context);
        }
        return new BigDecimal(fI * i10).setScale(0, 4).intValue();
    }

    public final int f(View view, int i10) {
        kotlin.jvm.internal.m.f(view, "view");
        Context context = view.getContext();
        kotlin.jvm.internal.m.e(context, "getContext(...)");
        return e(context, i10);
    }

    public final int g(Context context, int i10) {
        kotlin.jvm.internal.m.f(context, "context");
        return e(context, i10);
    }

    public final int h(View view, int i10) {
        kotlin.jvm.internal.m.f(view, "view");
        return f(view, i10);
    }

    public final ViewGroup.LayoutParams l(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.m.f(view, "view");
        kotlin.jvm.internal.m.f(layoutParams, "layoutParams");
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = h(view, marginLayoutParams.leftMargin);
            marginLayoutParams.rightMargin = h(view, marginLayoutParams.rightMargin);
            marginLayoutParams.topMargin = d(view, marginLayoutParams.topMargin);
            marginLayoutParams.bottomMargin = d(view, marginLayoutParams.bottomMargin);
        }
        int i10 = layoutParams.width;
        boolean z10 = false;
        if (i10 != -2 && i10 != -1) {
            z10 = i10 == layoutParams.height;
            layoutParams.width = h(view, i10);
        }
        int i11 = layoutParams.height;
        if (i11 != -2 && i11 != -1) {
            if (z10) {
                layoutParams.height = h(view, i11);
                return layoutParams;
            }
            layoutParams.height = d(view, i11);
        }
        return layoutParams;
    }

    public final int m(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        if (heightPixels == 0) {
            synchronized (x0.class) {
                if (heightPixels == 0) {
                    return f21457a.b(context, true);
                }
                r8.z zVar = r8.z.f17874a;
            }
        }
        return heightPixels;
    }

    public final int n(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        if (widthPixels == 0) {
            synchronized (x0.class) {
                if (widthPixels == 0) {
                    return f21457a.b(context, false);
                }
                r8.z zVar = r8.z.f17874a;
            }
        }
        return widthPixels;
    }

    private x0() {
    }
}
