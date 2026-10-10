package d1;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.StringRes;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@SuppressLint({"InlinedApi"})
public final class g {
    public static void a(Context context, String str, @StringRes int i10, @StringRes int i11, int i12) {
        if (k.f9577a >= 26) {
            NotificationManager notificationManager = (NotificationManager) a.b((NotificationManager) context.getSystemService("notification"));
            f.a();
            NotificationChannel notificationChannelA = com.blankj.utilcode.util.k.a(str, context.getString(i10), i12);
            if (i11 != 0) {
                notificationChannelA.setDescription(context.getString(i11));
            }
            notificationManager.createNotificationChannel(notificationChannelA);
        }
    }
}
