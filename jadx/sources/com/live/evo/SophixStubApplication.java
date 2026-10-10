package com.live.evo;

import android.content.Context;
import androidx.annotation.Keep;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class SophixStubApplication extends SophixApplication {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5180a = "SophixStubApplication";

    private void a() {
        String str;
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = "0.0.0";
        }
        SophixManager.getInstance().setContext(this).setUsingEnhance(true).setAppVersion(str).setSecretMetaData(null, null, null).setEnableDebug(false).setEnableFullLog().setTags(j.a(new Object[]{"Gray"})).setPatchLoadStatusStub(new a(this)).initialize();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @SophixEntry(MyApplication.class)
    @Keep
    static class RealApplicationStub {
        RealApplicationStub() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements PatchLoadStatusListener {
        a(SophixStubApplication sophixStubApplication) {
        }

        @Override // com.taobao.sophix.listener.PatchLoadStatusListener
        public void onLoad(int i10, int i11, String str, int i12) {
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a();
    }

    @Override // com.taobao.sophix.SophixApplication, android.app.Application
    public void onCreate() {
        try {
            super.onCreate();
        } catch (Throwable unused) {
        }
    }
}
