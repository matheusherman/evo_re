package com.taobao.sophix.aidl;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.b0;
import com.taobao.sophix.i0;
import com.taobao.sophix.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DownloadService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.taobao.sophix.aidl.a.AbstractBinderC0155a f8405a = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends com.taobao.sophix.aidl.a.AbstractBinderC0155a {
        a() {
        }

        @Override // com.taobao.sophix.aidl.a
        public void a(String str, b bVar) {
            b0 b0Var = new b0(1);
            b0Var.f8420d = -1;
            ((i0) SophixManager.getInstance()).a(str, b0Var, new x(bVar));
        }

        @Override // com.taobao.sophix.aidl.a
        public void b(String str, b bVar) throws Throwable {
            if (str.startsWith("content://")) {
                ((i0) SophixManager.getInstance()).a(Uri.parse(str), new x(bVar));
            } else {
                ((i0) SophixManager.getInstance()).a(str, new x(bVar));
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f8405a;
    }
}
