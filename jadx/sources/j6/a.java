package j6;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smart.refresh.layout.kernel.R$id;
import e6.e;
import g6.f;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements e6.b, g6.a, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected View f11636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected View f11637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected View f11638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected View f11639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected View f11640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f11641f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f11642g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f11643h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected h6.a f11644i = new h6.a();

    @Override // e6.b
    public void c(int i10, int i11, int i12) {
        boolean z10;
        View viewFindViewById;
        View viewFindViewById2;
        boolean z11 = true;
        if (i11 == -1 || (viewFindViewById2 = this.f11637b.findViewById(i11)) == null) {
            z10 = false;
        } else if (i10 > 0) {
            viewFindViewById2.setTranslationY(i10);
            z10 = true;
        } else {
            if (viewFindViewById2.getTranslationY() > 0.0f) {
                viewFindViewById2.setTranslationY(0.0f);
            }
            z10 = false;
        }
        if (i12 == -1 || (viewFindViewById = this.f11637b.findViewById(i12)) == null) {
            z11 = z10;
        } else if (i10 < 0) {
            viewFindViewById.setTranslationY(i10);
        } else {
            if (viewFindViewById.getTranslationY() < 0.0f) {
                viewFindViewById.setTranslationY(0.0f);
            }
            z11 = z10;
        }
        if (z11) {
            this.f11637b.setTranslationY(0.0f);
        } else {
            this.f11637b.setTranslationY(i10);
        }
        View view = this.f11639d;
        if (view != null) {
            view.setTranslationY(Math.max(0, i10));
        }
        View view2 = this.f11640e;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i10));
        }
    }

    @Override // e6.b
    public boolean a() {
        return this.f11642g && this.f11644i.a(this.f11636a);
    }

    @Override // e6.b
    public void b(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f11636a.getLeft(), -this.f11636a.getTop());
        View view = this.f11638c;
        View view2 = this.f11636a;
        if (view != view2) {
            this.f11638c = l(view2, pointF, view);
        }
        if (this.f11638c == this.f11636a) {
            this.f11644i.f10848a = null;
        } else {
            this.f11644i.f10848a = pointF;
        }
    }

    @Override // e6.b
    public void d(f fVar) {
        if (fVar instanceof h6.a) {
            this.f11644i = (h6.a) fVar;
        } else {
            this.f11644i.f10849b = fVar;
        }
    }

    @Override // e6.b
    public void e(boolean z10) {
        this.f11644i.f10850c = z10;
    }

    @Override // e6.b
    public ValueAnimator.AnimatorUpdateListener f(int i10) {
        View view = this.f11638c;
        if (view == null || i10 == 0) {
            return null;
        }
        if ((i10 >= 0 || !view.canScrollVertically(1)) && (i10 <= 0 || !this.f11638c.canScrollVertically(-1))) {
            return null;
        }
        this.f11641f = i10;
        return this;
    }

    @Override // e6.b
    public void g(e eVar, View view, View view2) {
        k(this.f11636a, eVar);
        if (view == null && view2 == null) {
            return;
        }
        this.f11639d = view;
        this.f11640e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f11636a.getContext());
        int iIndexOfChild = eVar.e().getLayout().indexOfChild(this.f11636a);
        eVar.e().getLayout().removeView(this.f11636a);
        frameLayout.addView(this.f11636a, 0, new ViewGroup.LayoutParams(-1, -1));
        eVar.e().getLayout().addView(frameLayout, iIndexOfChild, this.f11636a.getLayoutParams());
        this.f11636a = frameLayout;
        if (view != null) {
            view.setTag(R$id.srl_tag, "fixed-top");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild2 = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams.height = i6.b.h(view);
            viewGroup.addView(new Space(this.f11636a.getContext()), iIndexOfChild2, layoutParams);
            frameLayout.addView(view, 1, layoutParams);
        }
        if (view2 != null) {
            view2.setTag(R$id.srl_tag, "fixed-bottom");
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int iIndexOfChild3 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams2.height = i6.b.h(view2);
            viewGroup2.addView(new Space(this.f11636a.getContext()), iIndexOfChild3, layoutParams2);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams3);
        }
    }

    @Override // e6.b
    @NonNull
    public View getView() {
        return this.f11636a;
    }

    @Override // e6.b
    public boolean h() {
        return this.f11643h && this.f11644i.b(this.f11636a);
    }

    @Override // g6.a
    public void i(boolean z10, boolean z11) {
        this.f11642g = z10;
        this.f11643h = z11;
    }

    @Override // e6.b
    @NonNull
    public View j() {
        return this.f11638c;
    }

    protected void k(View view, e eVar) {
        boolean zIsInEditMode = this.f11636a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = m(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!zIsInEditMode) {
                i6.a.a(view, eVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f11638c = view2;
        }
    }

    protected View l(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (i6.b.g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && i6.b.e(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewL = l(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewL;
                }
            }
        }
        return view2;
    }

    protected View m(View view, boolean z10) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z10 || view3 != view) && i6.b.e(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        linkedList.add(viewGroup.getChildAt(i10));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    public a(@NonNull View view) {
        this.f11638c = view;
        this.f11637b = view;
        this.f11636a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (iIntValue - this.f11641f) * this.f11638c.getScaleY();
            View view = this.f11638c;
            if (view instanceof AbsListView) {
                i6.b.j((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f11641f = iIntValue;
    }
}
