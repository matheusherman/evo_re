package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    public static void apply(int i10, int i11, int i12, @NonNull Rect rect, @NonNull Rect rect2, int i13) {
        Gravity.apply(i10, i11, i12, rect, rect2, i13);
    }

    public static void apply(int i10, int i11, int i12, @NonNull Rect rect, int i13, int i14, @NonNull Rect rect2, int i15) {
        Gravity.apply(i10, i11, i12, rect, i13, i14, rect2, i15);
    }

    private GravityCompat() {
    }

    public static void applyDisplay(int i10, @NonNull Rect rect, @NonNull Rect rect2, int i11) {
        Gravity.applyDisplay(i10, rect, rect2, i11);
    }

    public static int getAbsoluteGravity(int i10, int i11) {
        return Gravity.getAbsoluteGravity(i10, i11);
    }
}
