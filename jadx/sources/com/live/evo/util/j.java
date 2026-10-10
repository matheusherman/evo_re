package com.live.evo.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7245a;

    public static Context a(Context context) {
        if (context == null) {
            return context;
        }
        String language = Locale.getDefault().getLanguage();
        String str = ("pt".equals(language) || "en".equals(language) || "es".equals(language)) ? language : "pt";
        if ((TextUtils.equals(str, language) && !f7245a) || !TextUtils.equals(str, "es") || !TextUtils.equals("pt", "es")) {
            return context;
        }
        f7245a = true;
        Resources resources = context.getResources();
        resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale("es", "ES");
        if (Build.VERSION.SDK_INT < 24) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        }
        configuration.setLocale(locale);
        i.a();
        configuration.setLocales(h.a(new Locale[]{locale}));
        return context.createConfigurationContext(configuration);
    }
}
