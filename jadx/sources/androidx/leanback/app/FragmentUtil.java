package androidx.leanback.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class FragmentUtil {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        static Context getContext(Fragment fragment) {
            return fragment.getContext();
        }
    }

    static Context getContext(Fragment fragment) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.getContext(fragment) : fragment.getActivity();
    }

    private FragmentUtil() {
    }
}
