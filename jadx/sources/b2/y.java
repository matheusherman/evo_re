package b2;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R$string;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f740b;

    @Nullable
    public final String b(String str) {
        int identifier = this.f739a.getIdentifier(str, TypedValues.Custom.S_STRING, this.f740b);
        if (identifier == 0) {
            return null;
        }
        try {
            return this.f739a.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public y(Context context, @Nullable String str) {
        m1.g.k(context);
        this.f739a = context.getResources();
        if (!TextUtils.isEmpty(str)) {
            this.f740b = str;
        } else {
            this.f740b = a(context);
        }
    }

    public static String a(Context context) {
        try {
            return context.getResources().getResourcePackageName(R$string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }
}
