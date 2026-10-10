package z7;

import android.view.View;
import android.view.animation.AccelerateInterpolator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n {
    public static void a(View view) {
        if (view != null) {
            view.animate().scaleX(1.1f).scaleY(1.1f).setInterpolator(new AccelerateInterpolator()).setDuration(200L);
        }
    }

    public static void b(View view) {
        if (view != null) {
            view.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(200L);
        }
    }
}
