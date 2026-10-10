package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.p000lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Application f1254a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b<T> {
        void accept(T t10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface c<Ret, Par> {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface d {
        void a(Activity activity);

        void b(Activity activity);
    }

    public static Application a() {
        Application application = f1254a;
        if (application != null) {
            return application;
        }
        b(x.g());
        if (f1254a == null) {
            throw new NullPointerException("reflect failed.");
        }
        Log.i("Utils", x.h() + " reflect app success.");
        return f1254a;
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = f1254a;
        if (application2 == null) {
            f1254a = application;
            x.n(application);
            x.t();
        } else {
            if (application2.equals(application)) {
                return;
            }
            x.y(f1254a);
            f1254a = application;
            x.n(application);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {
        public void a(@NonNull Activity activity) {
        }

        public void b(@NonNull Activity activity) {
        }

        public void c(@NonNull Activity activity) {
        }

        public void d(@NonNull Activity activity) {
        }

        public void e(@NonNull Activity activity) {
        }

        public void f(@NonNull Activity activity) {
        }

        public void g(@NonNull Activity activity, Lifecycle.Event event) {
        }
    }
}
