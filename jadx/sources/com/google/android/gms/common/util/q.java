package com.google.android.gms.common.util;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f2478a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean a(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}
