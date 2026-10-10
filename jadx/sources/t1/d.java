package t1;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    protected final Context f18864a;

    public int a(@NonNull String str) {
        return this.f18864a.checkCallingOrSelfPermission(str);
    }

    @NonNull
    public ApplicationInfo b(@NonNull String str, int i10) {
        return this.f18864a.getPackageManager().getApplicationInfo(str, i10);
    }

    @NonNull
    public CharSequence c(@NonNull String str) {
        Context context = this.f18864a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    @NonNull
    public PackageInfo d(@NonNull String str, int i10) {
        return this.f18864a.getPackageManager().getPackageInfo(str, i10);
    }

    @TargetApi(19)
    public final boolean f(int i10, @NonNull String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) this.f18864a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i10, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public d(@NonNull Context context) {
        this.f18864a = context;
    }

    public boolean e() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return b.a(this.f18864a);
        }
        if (m.d() && (nameForUid = this.f18864a.getPackageManager().getNameForUid(Binder.getCallingUid())) != null) {
            return this.f18864a.getPackageManager().isInstantApp(nameForUid);
        }
        return false;
    }
}
