package com.youth.banner.transformer;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RotateYTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 35.0f;
    private float mMaxRotate;

    public RotateYTransformer() {
        this.mMaxRotate = DEFAULT_MAX_ROTATE;
    }

    public RotateYTransformer(float f10) {
        this.mMaxRotate = f10;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f10) {
        view.setPivotY(view.getHeight() / 2);
        if (f10 < -1.0f) {
            view.setRotationY(this.mMaxRotate * (-1.0f));
            view.setPivotX(view.getWidth());
            return;
        }
        if (f10 <= 1.0f) {
            view.setRotationY(this.mMaxRotate * f10);
            if (f10 < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f10) * 0.5f) + 0.5f));
                view.setPivotX(view.getWidth());
                return;
            } else {
                view.setPivotX(view.getWidth() * 0.5f * (1.0f - f10));
                view.setPivotX(0.0f);
                return;
            }
        }
        view.setRotationY(this.mMaxRotate * 1.0f);
        view.setPivotX(0.0f);
    }
}
