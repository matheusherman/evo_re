package m1;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R$string;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f15490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15491b;

    @Nullable
    public String a(@NonNull String str) {
        int identifier = this.f15490a.getIdentifier(str, TypedValues.Custom.S_STRING, this.f15491b);
        if (identifier == 0) {
            return null;
        }
        return this.f15490a.getString(identifier);
    }

    public i(@NonNull Context context) {
        g.k(context);
        Resources resources = context.getResources();
        this.f15490a = resources;
        this.f15491b = resources.getResourcePackageName(R$string.common_google_play_services_unknown_issue);
    }
}
