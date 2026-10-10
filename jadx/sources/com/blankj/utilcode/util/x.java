package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class x {
    private static void u(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            t.b().execute(runnable);
        }
    }

    static void a(u.a aVar) {
        w.f1255g.d(aVar);
    }

    static List<Activity> e() {
        return w.f1255g.i();
    }

    static Application g() {
        return w.f1255g.m();
    }

    static p k() {
        return p.a("Utils");
    }

    static void n(Application application) {
        w.f1255g.n(application);
    }

    static boolean p() {
        return w.f1255g.o();
    }

    static void v(u.a aVar) {
        w.f1255g.s(aVar);
    }

    static void y(Application application) {
        w.f1255g.w(application);
    }

    static int b(float f10) {
        return r.a(f10);
    }

    static void c(Activity activity) {
        g.a(activity);
    }

    static String d(@Nullable String str, Object... objArr) {
        return s.a(str, objArr);
    }

    static int f() {
        return q.a();
    }

    static String h() {
        return o.a();
    }

    static int i() {
        return d.a();
    }

    static Notification j(l.a aVar, u.b<NotificationCompat.Builder> bVar) {
        return l.a(aVar, bVar);
    }

    static int l() {
        return d.b();
    }

    static String m(@StringRes int i10) {
        return s.b(i10);
    }

    static boolean o(Activity activity) {
        return a.a(activity);
    }

    @RequiresApi(api = 23)
    static boolean q() {
        return n.a();
    }

    static boolean r() {
        return y.a();
    }

    static View s(@LayoutRes int i10) {
        return y.b(i10);
    }

    static void t() {
        u(b.f());
    }

    static void w(Runnable runnable) {
        t.e(runnable);
    }

    static void x(Runnable runnable, long j10) {
        t.f(runnable, j10);
    }

    static Bitmap z(View view) {
        return f.a(view);
    }
}
