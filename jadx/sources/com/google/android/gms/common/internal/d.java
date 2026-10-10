package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.stub.StubApp;
import java.util.concurrent.Executor;
import m1.j0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f2332a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2333b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static a0 f2334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    @VisibleForTesting
    static HandlerThread f2335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private static Executor f2336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f2337f;

    protected abstract ConnectionResult c(j0 j0Var, ServiceConnection serviceConnection, String str, @Nullable Executor executor);

    protected abstract void d(j0 j0Var, ServiceConnection serviceConnection, String str);

    @NonNull
    public static d a(@NonNull Context context) {
        synchronized (f2332a) {
            try {
                if (f2334c == null) {
                    f2334c = new a0(StubApp.getOrigApplicationContext(context.getApplicationContext()), f2337f ? b().getLooper() : context.getMainLooper(), f2336e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f2334c;
    }

    @NonNull
    public static HandlerThread b() {
        synchronized (f2332a) {
            try {
                HandlerThread handlerThread = f2335d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", f2333b);
                f2335d = handlerThread2;
                handlerThread2.start();
                return f2335d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(@NonNull String str, @NonNull String str2, int i10, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z10) {
        d(new j0(str, str2, 4225, z10), serviceConnection, str3);
    }
}
