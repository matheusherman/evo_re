package com.live.evo;

import android.app.Application;
import android.content.Context;
import com.hjq.toast.Toaster;
import com.live.evo.activity.base.BaseActivity;
import com.live.evo.util.y0;
import com.taobao.sophix.SophixManager;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class MyApplication extends Application {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final q6.b f5173c = q6.c.d(MyApplication.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f5174d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static MyApplication f5175e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<BaseActivity> f5176a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Object> f5177b = new HashSet();

    public boolean d() {
        return true;
    }

    public static MyApplication a() {
        return f5175e;
    }

    public void b(BaseActivity baseActivity) {
        this.f5176a.add(baseActivity);
    }

    public void c(Object obj) {
        this.f5177b.add(obj);
    }

    public void e(BaseActivity baseActivity) {
        this.f5176a.remove(baseActivity);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f5174d = this;
        f5175e = this;
        try {
            com.bumptech.glide.c.c(this).j().r(p.h.class, InputStream.class, new com.bumptech.glide.integration.okhttp3.a.C0036a(of.e.f16588a.e()));
        } catch (Exception e10) {
            f5173c.error("glide https url loader setup failure", e10);
        }
        y0.a(this);
        l.B(this);
        Toaster.init(this);
        SophixManager.getInstance().queryAndLoadNewPatch();
        CrashReport.initCrashReport(this, "b1897f2807", true);
        x1.f1.lb.util.c.f21341a.n(this);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        System.exit(0);
    }
}
