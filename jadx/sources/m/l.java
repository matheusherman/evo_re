package m;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
interface l {
    String a(int i10, int i11, Bitmap.Config config);

    int b(Bitmap bitmap);

    void c(Bitmap bitmap);

    @Nullable
    Bitmap d(int i10, int i11, Bitmap.Config config);

    String e(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
