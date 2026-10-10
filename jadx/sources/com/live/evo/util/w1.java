package com.live.evo.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.live.evo.MyApplication;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.live.evo.l f7376a;

    public w1(com.live.evo.l lVar) {
        this.f7376a = lVar;
    }

    public Bitmap b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new e1.a(MyApplication.a()).w(1).x(o3.a.TEXT).t(str).a().a();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(l5.a aVar) {
    }
}
