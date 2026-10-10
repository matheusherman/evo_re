package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class HideRightViewOnScrollDelegate extends HideViewOnScrollDelegate {
    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    int getTargetTranslation() {
        return 0;
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    int getViewEdge() {
        return 0;
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    <V extends View> void setAdditionalHiddenOffset(@NonNull V v10, int i10, int i11) {
        v10.setTranslationX(i10 + i11);
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    <V extends View> void setViewTranslation(@NonNull V v10, int i10) {
        v10.setTranslationX(i10);
    }

    HideRightViewOnScrollDelegate() {
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    <V extends View> int getSize(@NonNull V v10, @NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return v10.getMeasuredWidth() + marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    <V extends View> ViewPropertyAnimator getViewTranslationAnimator(@NonNull V v10, int i10) {
        return v10.animate().translationX(i10);
    }
}
