package s1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.m;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import m1.g;
import m1.l0;
import t1.e;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f18251b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f18252c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    public final ConcurrentHashMap f18253a = new ConcurrentHashMap();

    @NonNull
    public static b b() {
        if (f18252c == null) {
            synchronized (f18251b) {
                try {
                    if (f18252c == null) {
                        f18252c = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        b bVar = f18252c;
        g.k(bVar);
        return bVar;
    }

    private static boolean g(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof l0);
    }

    private static final boolean h(Context context, Intent intent, ServiceConnection serviceConnection, int i10, Executor executor) {
        if (executor == null) {
            executor = null;
        }
        return (!m.f() || executor == null) ? context.bindService(intent, serviceConnection, i10) : context.bindService(intent, i10, executor, serviceConnection);
    }

    public final boolean d(@NonNull Context context, @NonNull String str, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i10, Executor executor) {
        return f(context, str, intent, serviceConnection, 4225, true, executor);
    }

    private b() {
    }

    private static void e(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean f(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i10, boolean z10, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((e.a(context).b(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (g(serviceConnection)) {
            ServiceConnection serviceConnection2 = (ServiceConnection) this.f18253a.putIfAbsent(serviceConnection, serviceConnection);
            if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
            }
            try {
                boolean zH = h(context, intent, serviceConnection, i10, executor);
                if (!zH) {
                    this.f18253a.remove(serviceConnection, serviceConnection);
                    return false;
                }
                return zH;
            } catch (Throwable th) {
                this.f18253a.remove(serviceConnection, serviceConnection);
                throw th;
            }
        }
        return h(context, intent, serviceConnection, i10, executor);
    }

    public boolean a(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i10) {
        return f(context, context.getClass().getName(), intent, serviceConnection, i10, true, null);
    }

    public void c(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        if (g(serviceConnection) && this.f18253a.containsKey(serviceConnection)) {
            try {
                e(context, (ServiceConnection) this.f18253a.get(serviceConnection));
                return;
            } finally {
                this.f18253a.remove(serviceConnection);
            }
        }
        e(context, serviceConnection);
    }
}
