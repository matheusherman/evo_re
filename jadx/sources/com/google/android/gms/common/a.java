package com.google.android.gms.common;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.zabx;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import k1.f0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {x1.d.class, x1.e.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("lock")
    private String f2135c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f2133e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f2134f = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f2132d = b.f2201a;

    public void o(@NonNull Context context, int i10) {
        t(context, i10, null, d(context, i10, 0, "n"));
    }

    @Nullable
    final Dialog p(@NonNull Context context, int i10, @Nullable m1.v vVar, @Nullable DialogInterface.OnCancelListener onCancelListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder;
        AlertDialog.Builder builder2 = null;
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder2 == null) {
            builder2 = builder;
            builder2 = new AlertDialog.Builder(context);
        }
        builder2 = builder;
        builder2.setMessage(m1.s.c(context, i10));
        if (onCancelListener != null) {
            builder2.setOnCancelListener(onCancelListener);
        }
        String strB = m1.s.b(context, i10);
        DialogInterface.OnClickListener onClickListener2 = vVar;
        if (strB != null) {
            if (vVar == null) {
                onClickListener2 = onClickListener;
            }
            builder2.setPositiveButton(strB, onClickListener2);
        }
        String strF = m1.s.f(context, i10);
        if (strF != null) {
            builder2.setTitle(strF);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i10)), new IllegalArgumentException());
        return builder2.create();
    }

    @NonNull
    public static a m() {
        return f2134f;
    }

    @Nullable
    public Dialog k(@NonNull Activity activity, int i10, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return p(activity, i10, m1.v.b(activity, b(activity, i10, "d"), i11), onCancelListener, null);
    }

    @NonNull
    public final Dialog q(@NonNull Activity activity, @NonNull DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(m1.s.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        s(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    @Nullable
    @ResultIgnorabilityUnspecified
    public final zabx r(Context context, f0 f0Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabxVar = new zabx(f0Var);
        x1.j.a(context, zabxVar, intentFilter);
        zabxVar.a(context);
        if (i(context, "com.google.android.gms")) {
            return zabxVar;
        }
        f0Var.a();
        zabxVar.b();
        return null;
    }

    final void s(Activity activity, Dialog dialog, String str, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                j1.g.R(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        j1.b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    final void u(Context context) {
        new f(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    @ResultIgnorabilityUnspecified
    public final boolean v(@NonNull Activity activity, @NonNull k1.h hVar, int i10, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogP = p(activity, i10, m1.v.c(hVar, b(activity, i10, "d"), 2), onCancelListener, null);
        if (dialogP == null) {
            return false;
        }
        s(activity, dialogP, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    @Override // com.google.android.gms.common.b
    @Nullable
    public Intent b(@Nullable Context context, int i10, @Nullable String str) {
        return super.b(context, i10, str);
    }

    @Override // com.google.android.gms.common.b
    @Nullable
    public PendingIntent c(@NonNull Context context, int i10, int i11) {
        return super.c(context, i10, i11);
    }

    @Override // com.google.android.gms.common.b
    @NonNull
    public final String e(int i10) {
        return super.e(i10);
    }

    @Override // com.google.android.gms.common.b
    @ResultIgnorabilityUnspecified
    public int g(@NonNull Context context) {
        return super.g(context);
    }

    @Override // com.google.android.gms.common.b
    public int h(@NonNull Context context, int i10) {
        return super.h(context, i10);
    }

    @Override // com.google.android.gms.common.b
    public final boolean j(int i10) {
        return super.j(i10);
    }

    @Nullable
    public PendingIntent l(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        if (connectionResult.S()) {
            return connectionResult.P();
        }
        return c(context, connectionResult.J(), 0);
    }

    @ResultIgnorabilityUnspecified
    public boolean n(@NonNull Activity activity, int i10, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogK = k(activity, i10, i11, onCancelListener);
        if (dialogK == null) {
            return false;
        }
        s(activity, dialogK, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    @TargetApi(20)
    final void t(Context context, int i10, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        int i11;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i10), null), new IllegalArgumentException());
        if (i10 == 18) {
            u(context);
            return;
        }
        if (pendingIntent == null) {
            if (i10 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = m1.s.e(context, i10);
        String strD = m1.s.d(context, i10);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) m1.g.k(context.getSystemService("notification"));
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strE).setStyle(new NotificationCompat.BigTextStyle().bigText(strD));
        if (com.google.android.gms.common.util.h.c(context)) {
            m1.g.o(com.google.android.gms.common.util.m.b());
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (com.google.android.gms.common.util.h.d(context)) {
                style.addAction(R$drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R$string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(com.google.android.gms.base.R$string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strD);
        }
        if (com.google.android.gms.common.util.m.d()) {
            m1.g.o(com.google.android.gms.common.util.m.d());
            synchronized (f2133e) {
                str2 = this.f2135c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(com.google.android.gms.base.R$string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(com.blankj.utilcode.util.k.a("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            style.setChannelId(str2);
        }
        Notification notificationBuild = style.build();
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            i11 = 39789;
        } else {
            d.f2205b.set(false);
            i11 = 10436;
        }
        notificationManager.notify(i11, notificationBuild);
    }

    public final boolean w(@NonNull Context context, @NonNull ConnectionResult connectionResult, int i10) {
        PendingIntent pendingIntentL;
        if (t1.b.a(context) || (pendingIntentL = l(context, connectionResult)) == null) {
            return false;
        }
        t(context, connectionResult.J(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentL, i10, true), x1.k.f21793a | 134217728));
        return true;
    }
}
