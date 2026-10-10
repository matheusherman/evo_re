package androidx.leanback.app;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Build;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PermissionHelper {
    @SuppressLint({"ReferencesDeprecated"})
    public static void requestPermissions(Fragment fragment, String[] strArr, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            fragment.requestPermissions(strArr, i10);
        }
    }

    private PermissionHelper() {
    }
}
