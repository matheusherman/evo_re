package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class HideViewOnScrollDelegate {
    abstract <V extends View> int getSize(@NonNull V v10, @NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract int getTargetTranslation();

    abstract int getViewEdge();

    abstract <V extends View> ViewPropertyAnimator getViewTranslationAnimator(@NonNull V v10, int i10);

    abstract <V extends View> void setAdditionalHiddenOffset(@NonNull V v10, int i10, int i11);

    abstract <V extends View> void setViewTranslation(@NonNull V v10, int i10);

    HideViewOnScrollDelegate() {
    }
}
