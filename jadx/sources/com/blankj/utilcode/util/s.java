package com.blankj.utilcode.util;

import android.content.res.Resources;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import java.util.IllegalFormatException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class s {
    public static String b(@StringRes int i10) {
        return c(i10, null);
    }

    public static String a(@Nullable String str, Object... objArr) {
        if (str != null && objArr != null && objArr.length > 0) {
            try {
                return String.format(str, objArr);
            } catch (IllegalFormatException e10) {
                e10.printStackTrace();
            }
        }
        return str;
    }

    public static String c(@StringRes int i10, Object... objArr) {
        try {
            return a(u.a().getString(i10), objArr);
        } catch (Resources.NotFoundException e10) {
            e10.printStackTrace();
            return String.valueOf(i10);
        }
    }
}
