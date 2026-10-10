package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import b2.a1;
import com.google.android.gms.internal.measurement.f3;
import com.google.firebase.installations.b;
import e2.j;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import m1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile FirebaseAnalytics f4703b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f3 f4704a;

    @Nullable
    @Keep
    public static a1 getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        f3 f3VarF = f3.f(context, null, null, null, bundle);
        if (f3VarF == null) {
            return null;
        }
        return new a(f3VarF);
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f4703b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f4703b == null) {
                        f4703b = new FirebaseAnalytics(f3.e(context));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4703b;
    }

    public final void a(@NonNull @Size(max = 40, min = 1) String str, @Nullable Bundle bundle) {
        this.f4704a.s(str, bundle);
    }

    @Keep
    @MainThread
    @Deprecated
    public final void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        this.f4704a.j(activity, str, str2);
    }

    private FirebaseAnalytics(f3 f3Var) {
        g.k(f3Var);
        this.f4704a = f3Var;
    }

    @NonNull
    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) j.b(b.n().l(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        } catch (ExecutionException e11) {
            throw new IllegalStateException(e11.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }
}
