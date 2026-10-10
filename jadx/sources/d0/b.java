package d0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import j.f;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<String, f> f9551a = new ConcurrentHashMap();

    @NonNull
    private static String b(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @Nullable
    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e10);
            return null;
        }
    }

    @NonNull
    public static f c(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, f> concurrentMap = f9551a;
        f fVar = concurrentMap.get(packageName);
        if (fVar == null) {
            f fVarD = d(context);
            f fVarPutIfAbsent = concurrentMap.putIfAbsent(packageName, fVarD);
            if (fVarPutIfAbsent == null) {
                return fVarD;
            }
            return fVarPutIfAbsent;
        }
        return fVar;
    }

    @NonNull
    private static f d(@NonNull Context context) {
        return new d(b(a(context)));
    }
}
