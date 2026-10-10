package t1;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.m;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f18862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private static Boolean f18863b;

    public static synchronized boolean a(@NonNull Context context) {
        Boolean bool;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        Context context2 = f18862a;
        if (context2 != null && (bool = f18863b) != null && context2 == origApplicationContext) {
            return bool.booleanValue();
        }
        f18863b = null;
        if (m.d()) {
            f18863b = Boolean.valueOf(origApplicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f18863b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f18863b = Boolean.FALSE;
            }
        }
        f18862a = origApplicationContext;
        return f18863b.booleanValue();
    }
}
