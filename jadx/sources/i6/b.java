package i6;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smart.refresh.layout.kernel.R$id;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements Interpolator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11231b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f11232c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static float f11233d = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f11234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f11235f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11236a;

    public static boolean a(@NonNull View view, PointF pointF, boolean z10) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !f(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R$id.srl_tag);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean zA = a(childAt, pointF, z10);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return zA;
                }
            }
        }
        return z10 || view.canScrollVertically(-1);
    }

    public static boolean b(@NonNull View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(R$id.srl_tag);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean zB = b(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return zB;
            }
        }
        return true;
    }

    public static float i(int i10) {
        return i10 / f11233d;
    }

    public static int c(float f10) {
        return (int) ((f10 * f11233d) + 0.5f);
    }

    public static void d(View view, int i10) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i10);
            return;
        }
        if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i10);
            return;
        }
        if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i10);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i10);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i10);
        }
    }

    public static boolean e(View view) {
        if (view instanceof e6.a) {
            return false;
        }
        return f(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent);
    }

    public static boolean f(View view) {
        if (view instanceof e6.a) {
            return false;
        }
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    private static float k(float f10) {
        float f11 = f10 * 8.0f;
        return f11 < 1.0f ? f11 - (1.0f - ((float) Math.exp(-f11))) : ((1.0f - ((float) Math.exp(1.0f - f11))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (this.f11236a == f11232c) {
            float f11 = 1.0f - f10;
            return 1.0f - (f11 * f11);
        }
        float fK = f11234e * k(f10);
        return fK > 0.0f ? fK + f11235f : fK;
    }

    static {
        float fK = 1.0f / k(1.0f);
        f11234e = fK;
        f11235f = 1.0f - (fK * k(1.0f));
    }

    public b(int i10) {
        this.f11236a = i10;
    }

    public static boolean g(@NonNull View view, @NonNull View view2, float f10, float f11, PointF pointF) {
        boolean z10;
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f10, f11};
        fArr[0] = (view.getScrollX() - view2.getLeft()) + f10;
        float scrollY = fArr[1] + (view.getScrollY() - view2.getTop());
        fArr[1] = scrollY;
        float f12 = fArr[0];
        if (f12 >= 0.0f && scrollY >= 0.0f && f12 < view2.getWidth() && fArr[1] < view2.getHeight()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && pointF != null) {
            pointF.set(fArr[0] - f10, fArr[1] - f11);
        }
        return z10;
    }

    public static int h(View view) {
        int iMakeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i10 = layoutParams.height;
        if (i10 > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, iMakeMeasureSpec);
        return view.getMeasuredHeight();
    }

    public static void j(@NonNull AbsListView absListView, int i10) {
        absListView.scrollListBy(i10);
    }
}
