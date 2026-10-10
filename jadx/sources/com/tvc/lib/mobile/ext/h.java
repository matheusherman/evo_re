package com.tvc.lib.mobile.ext;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DrawableRes;
import com.hjq.toast.Toaster;
import com.tvc.lib.R$drawable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\b\u001a\u001b\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\b\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0010\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "Lr8/z;", "b", "(Ljava/lang/String;)V", "c", "Landroid/content/Context;", "context", "e", "(Ljava/lang/String;Landroid/content/Context;)V", "f", "g", "", "a", "(Landroid/content/Context;)Z", "", "icon", "d", "(Ljava/lang/String;Landroid/content/Context;I)V", "tvclib_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class h {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class a extends kotlin.jvm.internal.k implements c9.a<z> {
        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }

        a(Object obj) {
            super(0, obj, h.class, "log", "log(Ljava/lang/String;)V", 1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            h.b((String) this.receiver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class b extends kotlin.jvm.internal.k implements c9.a<z> {
        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }

        b(Object obj) {
            super(0, obj, h.class, "log", "log(Ljava/lang/String;)V", 1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            h.b((String) this.receiver);
        }
    }

    private static final boolean a(Context context) {
        Object systemService = context.getSystemService("activity");
        m.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static final void b(String str) {
        m.f(str, "<this>");
        if (x1.f1.lb.config.b.f20643a.t()) {
            new a(str);
            String simpleName = a.class.getEnclosingClass().getSimpleName();
            g0 g0Var = g0.f12340a;
            String str2 = String.format(simpleName, Arrays.copyOf(new Object[0], 0));
            m.e(str2, "format(...)");
            Log.d(str2, str);
        }
    }

    public static final void c(String str) {
        m.f(str, "<this>");
        new b(str);
        String simpleName = b.class.getEnclosingClass().getSimpleName();
        g0 g0Var = g0.f12340a;
        String str2 = String.format(simpleName, Arrays.copyOf(new Object[0], 0));
        m.e(str2, "format(...)");
        Log.w(str2, str);
    }

    public static final void e(String str, Context context) {
        m.f(str, "<this>");
        m.f(context, "context");
        d(str, context, R$drawable.toast_img_success);
    }

    public static final void f(String str, Context context) {
        m.f(context, "context");
        d(str, context, R$drawable.toast_img_success);
    }

    public static final void g(String str, Context context) {
        m.f(context, "context");
        d(str, context, 0);
    }

    private static final void d(String str, Context context, @DrawableRes int i10) {
        if (TextUtils.isEmpty(str)) {
            g("The content of the toast must not be empty", context);
            return;
        }
        if (!a(context)) {
            return;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                c("activity" + context.getClass().getSimpleName() + " is finishing, toast of \"" + str + "\" won't be shown");
                return;
            }
        }
        Toaster.showShort((CharSequence) str);
    }
}
