package com.youth.banner.transformer;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DepthPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.75f;
    private float mMinScale;

    public DepthPageTransformer() {
        this.mMinScale = 0.75f;
    }

    public DepthPageTransformer(float f10) {
        this.mMinScale = f10;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f10) {
        int width = view.getWidth();
        if (f10 < -1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f10 <= 0.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            return;
        }
        if (f10 <= 1.0f) {
            view.setVisibility(0);
            view.setAlpha(1.0f - f10);
            view.setTranslationX(width * (-f10));
            float f11 = this.mMinScale;
            float fAbs = f11 + ((1.0f - f11) * (1.0f - Math.abs(f10)));
            view.setScaleX(fAbs);
            view.setScaleY(fAbs);
            if (f10 == 1.0f) {
                view.setVisibility(4);
                return;
            }
            return;
        }
        view.setAlpha(0.0f);
    }
}
