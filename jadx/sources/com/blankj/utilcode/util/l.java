package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class l {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1240b = new a(u.a().getPackageName(), u.a().getPackageName(), 3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private NotificationChannel f1241a;

        public NotificationChannel b() {
            return this.f1241a;
        }

        public a(String str, CharSequence charSequence, int i10) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f1241a = k.a(str, charSequence, i10);
            }
        }
    }

    public static Notification a(a aVar, u.b<NotificationCompat.Builder> bVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            ((NotificationManager) u.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(u.a());
        if (i10 >= 26) {
            builder.setChannelId(aVar.f1241a.getId());
        }
        if (bVar != null) {
            bVar.accept(builder);
        }
        return builder.build();
    }
}
