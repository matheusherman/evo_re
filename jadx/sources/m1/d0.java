package m1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f15481a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static String f15483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f15484d;

    private static void b(Context context) {
        synchronized (f15481a) {
            try {
                if (f15482b) {
                    return;
                }
                f15482b = true;
                try {
                    Bundle bundle = t1.e.a(context).b(context.getPackageName(), 128).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f15483c = bundle.getString("com.google.app.id");
                    f15484d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int a(Context context) {
        b(context);
        return f15484d;
    }
}
