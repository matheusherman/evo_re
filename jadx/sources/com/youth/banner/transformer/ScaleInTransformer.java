package com.youth.banner.transformer;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ScaleInTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinScale;

    public ScaleInTransformer() {
        this.mMinScale = DEFAULT_MIN_SCALE;
    }

    public ScaleInTransformer(float f10) {
        this.mMinScale = f10;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f10) {
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(width / 2);
        if (f10 < -1.0f) {
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            view.setPivotX(width);
            return;
        }
        if (f10 <= 1.0f) {
            if (f10 < 0.0f) {
                float f11 = this.mMinScale;
                float f12 = ((f10 + 1.0f) * (1.0f - f11)) + f11;
                view.setScaleX(f12);
                view.setScaleY(f12);
                view.setPivotX(width * (((-f10) * 0.5f) + 0.5f));
                return;
            }
            float f13 = 1.0f - f10;
            float f14 = this.mMinScale;
            float f15 = ((1.0f - f14) * f13) + f14;
            view.setScaleX(f15);
            view.setScaleY(f15);
            view.setPivotX(width * f13 * 0.5f);
            return;
        }
        view.setPivotX(0.0f);
        view.setScaleX(this.mMinScale);
        view.setScaleY(this.mMinScale);
    }
}
