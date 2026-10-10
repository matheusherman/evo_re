package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class h {
    private static Locale b(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }

    static void a(Activity activity) {
        Locale localeE;
        String strC = x.k().c("KEY_LOCALE");
        if (!TextUtils.isEmpty(strC)) {
            if ("VALUE_FOLLOW_SYSTEM".equals(strC)) {
                localeE = b(Resources.getSystem().getConfiguration());
            } else {
                localeE = e(strC);
            }
            if (localeE == null) {
                return;
            }
            g(activity, localeE);
            g(u.a(), localeE);
        }
    }

    private static boolean c(String str) {
        int i10 = 0;
        for (char c10 : str.toCharArray()) {
            if (c10 == '$') {
                if (i10 >= 1) {
                    return false;
                }
                i10++;
            }
        }
        if (i10 != 1) {
            return false;
        }
        return true;
    }

    private static void d(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    private static Locale e(String str) {
        Locale localeF = f(str);
        if (localeF == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            x.k().f("KEY_LOCALE");
        }
        return localeF;
    }

    private static Locale f(String str) {
        if (!c(str)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf("$");
            return new Locale(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    private static void g(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        d(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
