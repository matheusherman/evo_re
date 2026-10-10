package androidx.leanback.widget;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
final class RoundedRectHelper {
    static void setClipToRoundedOutline(View view, boolean z10, int i10) {
        RoundedRectHelperApi21.setClipToRoundedOutline(view, z10, i10);
    }

    static boolean supportsRoundedCorner() {
        return true;
    }

    static void setClipToRoundedOutline(View view, boolean z10) {
        RoundedRectHelperApi21.setClipToRoundedOutline(view, z10, view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius));
    }

    private RoundedRectHelper() {
    }
}
