package androidx.leanback.widget;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
final class ShadowHelper {
    static boolean supportsDynamicShadow() {
        return true;
    }

    private ShadowHelper() {
    }

    static Object addDynamicShadow(View view, float f10, float f11, int i10) {
        return ShadowHelperApi21.addDynamicShadow(view, f10, f11, i10);
    }

    static void setShadowFocusLevel(Object obj, float f10) {
        ShadowHelperApi21.setShadowFocusLevel(obj, f10);
    }
}
