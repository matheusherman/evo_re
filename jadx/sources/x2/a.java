package x2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import p2.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f21795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f21796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f21797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21798d;

    public synchronized boolean b() {
        return this.f21798d;
    }

    private static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean c() {
        return this.f21796b.contains("firebase_data_collection_default_enabled") ? this.f21796b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f21795a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f21795a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public a(Context context, String str, c cVar) {
        Context contextA = a(context);
        this.f21795a = contextA;
        this.f21796b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f21797c = cVar;
        this.f21798d = c();
    }
}
