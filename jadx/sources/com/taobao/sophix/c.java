package com.taobao.sophix;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f8426a = {"hotfix-api.aliyuncs.com", "pre-hotfix-api.aliyun.com", "10.101.84.136"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f8427b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f8428c = "https://";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f8429d = true;

    public static void a(int i10, boolean z10) {
        if (!TextUtils.isEmpty(f8427b)) {
            s.e("ConnectConfig", "fail to set env because host is already set", new Object[0]);
        } else {
            if (i10 < 0 || i10 > 2) {
                return;
            }
            f8427b = f8426a[i10];
            a(z10);
        }
    }

    public static void a(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f8427b = str;
        a(z10);
        f8429d = false;
        s.a("ConnectConfig", "setHost", "host", str, "https", Boolean.valueOf(z10));
    }

    private static void a(boolean z10) {
        if (z10) {
            f8428c = "https://";
        } else {
            f8428c = "http://";
        }
    }
}
