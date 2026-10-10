package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.PendingIntentCompat;
import m1.m0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2201a = d.f2204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f2202b = new b();

    @Nullable
    public Intent b(@Nullable Context context, int i10, @Nullable String str) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return null;
            }
            int i11 = m0.f15503c;
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && com.google.android.gms.common.util.h.d(context)) {
            int i12 = m0.f15503c;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("gcore_");
        sb2.append(f2201a);
        sb2.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        sb2.append("-");
        if (context != null) {
            sb2.append(context.getPackageName());
        }
        sb2.append("-");
        if (context != null) {
            try {
                sb2.append(t1.e.a(context).d(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb2.toString();
        int i13 = m0.f15503c;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(IjkMediaMeta.IJKM_KEY_TRACK_ID, "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    @Nullable
    public PendingIntent c(@NonNull Context context, int i10, int i11) {
        return d(context, i10, i11, null);
    }

    @NonNull
    public static b f() {
        return f2202b;
    }

    public int g(@NonNull Context context) {
        return h(context, f2201a);
    }

    b() {
    }

    public int a(@NonNull Context context) {
        return d.a(context);
    }

    @Nullable
    public PendingIntent d(@NonNull Context context, int i10, int i11, @Nullable String str) {
        Intent intentB = b(context, i10, str);
        if (intentB == null) {
            return null;
        }
        return PendingIntentCompat.getActivity(context, i11, intentB, 134217728, false);
    }

    @NonNull
    public String e(int i10) {
        return d.b(i10);
    }

    public int h(@NonNull Context context, int i10) {
        int iF = d.f(context, i10);
        if (d.g(context, iF)) {
            return 18;
        }
        return iF;
    }

    public boolean i(@NonNull Context context, @NonNull String str) {
        return d.k(context, str);
    }

    public boolean j(int i10) {
        return d.i(i10);
    }
}
