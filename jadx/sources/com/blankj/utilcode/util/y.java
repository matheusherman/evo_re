package com.blankj.utilcode.util;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class y {
    public static boolean a() {
        return TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? u.a().getResources().getConfiguration().getLocales().get(0) : u.a().getResources().getConfiguration().locale) == 1;
    }

    public static View b(@LayoutRes int i10) {
        return ((LayoutInflater) u.a().getSystemService("layout_inflater")).inflate(i10, (ViewGroup) null);
    }
}
