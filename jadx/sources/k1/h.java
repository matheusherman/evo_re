package k1;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface h {
    void B(@NonNull String str, @NonNull g gVar);

    void startActivityForResult(@NonNull Intent intent, int i10);

    @Nullable
    <T extends g> T w(@NonNull String str, @NonNull Class<T> cls);

    @Nullable
    Activity x();
}
