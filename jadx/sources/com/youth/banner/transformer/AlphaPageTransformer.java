package com.youth.banner.transformer;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class AlphaPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private float mMinAlpha;

    public AlphaPageTransformer() {
        this.mMinAlpha = 0.5f;
    }

    public AlphaPageTransformer(float f10) {
        this.mMinAlpha = f10;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f10) {
        view.setScaleX(0.999f);
        if (f10 < -1.0f) {
            view.setAlpha(this.mMinAlpha);
            return;
        }
        if (f10 <= 1.0f) {
            if (f10 < 0.0f) {
                float f11 = this.mMinAlpha;
                view.setAlpha(f11 + ((1.0f - f11) * (f10 + 1.0f)));
                return;
            } else {
                float f12 = this.mMinAlpha;
                view.setAlpha(f12 + ((1.0f - f12) * (1.0f - f10)));
                return;
            }
        }
        view.setAlpha(this.mMinAlpha);
    }
}
