package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class MessengerUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, a> f1187a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Object> f1188b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class ServerService extends Service {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConcurrentHashMap<Integer, Messenger> f1189a = new ConcurrentHashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SuppressLint({"HandlerLeak"})
        private final Handler f1190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Messenger f1191c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 0) {
                    ServerService.this.f1189a.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i10 == 1) {
                    ServerService.this.f1189a.remove(Integer.valueOf(message.arg1));
                } else if (i10 != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            return this.f1191c.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i10, int i11) {
            Bundle extras;
            if (Build.VERSION.SDK_INT >= 26) {
                startForeground(1, x.j(l.a.f1240b, null));
            }
            if (intent != null && (extras = intent.getExtras()) != null) {
                Message messageObtain = Message.obtain(this.f1190b, 2);
                messageObtain.replyTo = this.f1191c;
                messageObtain.setData(extras);
                e(messageObtain);
                d(messageObtain);
            }
            return 2;
        }

        public ServerService() {
            a aVar = new a();
            this.f1190b = aVar;
            this.f1191c = new Messenger(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Message message) {
            String string;
            a aVar;
            Bundle data = message.getData();
            if (data != null && (string = data.getString("MESSENGER_UTILS")) != null && (aVar = (a) MessengerUtils.f1187a.get(string)) != null) {
                aVar.a(data);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Message message) {
            Message messageObtain = Message.obtain(message);
            for (Messenger messenger : this.f1189a.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(Message.obtain(messageObtain));
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            messageObtain.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(Bundle bundle);
    }
}
