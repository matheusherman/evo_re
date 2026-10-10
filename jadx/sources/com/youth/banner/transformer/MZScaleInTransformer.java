package com.youth.banner.transformer;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MZScaleInTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinScale;

    public MZScaleInTransformer() {
        this.mMinScale = DEFAULT_MIN_SCALE;
    }

    public MZScaleInTransformer(float f10) {
        this.mMinScale = f10;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f10) {
        ViewPager2 viewPager2RequireViewPager = requireViewPager(view);
        float paddingLeft = viewPager2RequireViewPager.getPaddingLeft();
        float measuredWidth = f10 - (paddingLeft / ((viewPager2RequireViewPager.getMeasuredWidth() - paddingLeft) - viewPager2RequireViewPager.getPaddingRight()));
        float width = view.getWidth();
        float f11 = this.mMinScale;
        float f12 = ((1.0f - f11) * width) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(f12);
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            return;
        }
        double d10 = measuredWidth;
        if (d10 <= 1.0d) {
            float fAbs = (1.0f - f11) * Math.abs(1.0f - Math.abs(measuredWidth));
            float f13 = (-f12) * measuredWidth;
            if (d10 <= -0.5d) {
                view.setTranslationX(f13 + (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else if (measuredWidth > 0.0f && d10 >= 0.5d) {
                view.setTranslationX(f13 - (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else {
                view.setTranslationX(f13);
            }
            view.setScaleX(this.mMinScale + fAbs);
            view.setScaleY(fAbs + this.mMinScale);
            return;
        }
        view.setScaleX(f11);
        view.setScaleY(this.mMinScale);
        view.setTranslationX(-f12);
    }
}
