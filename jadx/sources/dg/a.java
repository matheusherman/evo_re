package dg;

import android.content.res.Resources;
import android.util.TypedValue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {
    public static int b(boolean z10, int i10, int i11) {
        if (!z10) {
            return i10;
        }
        if (i10 == 0) {
            return i11 - 1;
        }
        if (i10 == i11 + 1) {
            return 0;
        }
        return i10 - 1;
    }

    public static int a(float f10) {
        return (int) TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics());
    }
}
