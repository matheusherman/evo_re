package x1.f1.lb.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import x.l1.b2.R$array;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\fJ3\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\bJ+\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u001a¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b&\u0010\u0018J\u001d\u0010(\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0013¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b*\u0010\u001cJ\u0015\u0010+\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b.\u0010/R\u001c\u00103\u001a\n 1*\u0004\u0018\u000100008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u00102R\u0016\u00105\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u00104R(\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001a068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R0\u0010@\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0=j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010?¨\u0006A"}, d2 = {"Lx1/f1/lb/util/n0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lr8/z;", "f", "(Landroid/content/Context;)V", "Landroid/content/res/Configuration;", "config", "n", "(Landroid/content/Context;Landroid/content/res/Configuration;)Landroid/content/Context;", "l", "mContext", "Ljava/util/Locale;", "newUserLocale", "", "isFollowSystem", "", "pos", "p", "(Landroid/content/Context;Ljava/util/Locale;ZI)Landroid/content/Context;", "k", "(Landroid/content/Context;I)V", "pContext", "", "b", "(Landroid/content/Context;)Ljava/lang/String;", "g", "o", "(Landroid/content/Context;Ljava/util/Locale;Landroid/content/res/Configuration;)Landroid/content/Context;", "lang", "q", "(Ljava/lang/String;Landroid/content/Context;I)V", "langStr", "h", "(Ljava/lang/String;)Ljava/util/Locale;", "j", "def", "c", "(Landroid/content/Context;I)I", "d", "a", "(Landroid/content/Context;)Ljava/util/Locale;", "pNewUserLocale", "i", "(Landroid/content/Context;Ljava/util/Locale;)Z", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Ljava/lang/String;", "defLanguage", "", "Ljava/util/List;", "e", "()Ljava/util/List;", "setLanguageList", "(Ljava/util/List;)V", "languageList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "languageMap", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f21425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String defLanguage;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static List<String> languageList;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, String> languageMap;

    private final Context l(Context context, Configuration config) {
        try {
            String str = languageMap.get(languageList.get(ua.n.M(b(context), "pt", true) ? 2 : 1));
            if (str == null) {
                return context;
            }
            n0 n0Var = f21425a;
            return n0Var.o(context, n0Var.h(str), config);
        } catch (Throwable th) {
            logger.error("dft lang failure", th);
            return context;
        }
    }

    static {
        n0 n0Var = new n0();
        f21425a = n0Var;
        logger = q6.c.d(n0Var.getClass());
        defLanguage = "Follow the system";
        languageList = kotlin.collections.r.o("Follow the system", "English", "Portuguese");
        languageMap = new HashMap<>();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static final void f(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        String[] stringArray = context.getResources().getStringArray(R$array.language_array);
        kotlin.jvm.internal.m.e(stringArray, "getStringArray(...)");
        languageList = kotlin.collections.j.E0(stringArray);
        String[] stringArray2 = context.getResources().getStringArray(R$array.locale_array);
        kotlin.jvm.internal.m.e(stringArray2, "getStringArray(...)");
        List listE0 = kotlin.collections.j.E0(stringArray2);
        int i10 = 0;
        defLanguage = languageList.get(0);
        for (String str : languageList) {
            int i11 = i10 + 1;
            if (i10 < listE0.size() && !TextUtils.isEmpty((CharSequence) listE0.get(i10))) {
                languageMap.put(languageList.get(i10), (String) listE0.get(i10));
            }
            i10 = i11;
        }
        f21425a.g(context);
    }

    static /* synthetic */ Context m(n0 n0Var, Context context, Configuration configuration, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            configuration = null;
        }
        return n0Var.l(context, configuration);
    }

    public static final Context n(Context context, Configuration config) {
        kotlin.jvm.internal.m.f(context, "context");
        n0 n0Var = f21425a;
        int iC = n0Var.c(context, -1);
        if (iC < 0 || iC > languageList.size()) {
            n0Var.l(context, config);
            return context;
        }
        String str = languageMap.get(languageList.get(iC));
        if (str == null) {
            return n0Var.l(context, config);
        }
        try {
            return n0Var.o(context, n0Var.h(str), config);
        } catch (Throwable th) {
            logger.error("updateLocal failure", th);
            return context;
        }
    }

    public static /* synthetic */ Context r(Context context, Configuration configuration, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            configuration = null;
        }
        return n(context, configuration);
    }

    public static /* synthetic */ Context s(n0 n0Var, Context context, Locale locale, Configuration configuration, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            configuration = null;
        }
        return n0Var.o(context, locale, configuration);
    }

    public final Locale a(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = context.getResources().getConfiguration().getLocales().get(0);
            kotlin.jvm.internal.m.c(locale);
            return locale;
        }
        Locale locale2 = context.getResources().getConfiguration().locale;
        kotlin.jvm.internal.m.c(locale2);
        return locale2;
    }

    public final int c(Context context, int def) {
        kotlin.jvm.internal.m.f(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("language_sp", 0);
        kotlin.jvm.internal.m.e(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences.getInt("language_key", def);
    }

    public final String d(Context context) {
        String str;
        kotlin.jvm.internal.m.f(context, "context");
        int iC = c(context, -1);
        String str2 = "";
        String str3 = (iC < 0 || iC >= languageList.size()) ? "" : languageList.get(iC);
        HashMap<String, String> map = languageMap;
        if (map.containsKey(str3) && (str = map.get(str3)) != null) {
            str2 = str;
        }
        return str2.length() == 0 ? f21425a.b(context) : str2;
    }

    public final List<String> e() {
        return languageList;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void g(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        if (c(context, -1) == -1) {
            m(this, context, null, 2, null);
            return;
        }
        Context contextR = r(context, null, 2, null);
        if (kotlin.jvm.internal.m.a(contextR, context)) {
            return;
        }
        String[] stringArray = contextR.getResources().getStringArray(R$array.language_array);
        kotlin.jvm.internal.m.e(stringArray, "getStringArray(...)");
        languageList = kotlin.collections.j.E0(stringArray);
        String[] stringArray2 = contextR.getResources().getStringArray(R$array.locale_array);
        kotlin.jvm.internal.m.e(stringArray2, "getStringArray(...)");
        List listE0 = kotlin.collections.j.E0(stringArray2);
        int i10 = 0;
        defLanguage = languageList.get(0);
        for (String str : languageList) {
            int i11 = i10 + 1;
            if (i10 < listE0.size() && !TextUtils.isEmpty((CharSequence) listE0.get(i10))) {
                languageMap.put(languageList.get(i10), (String) listE0.get(i10));
            }
            i10 = i11;
        }
    }

    public final Locale h(String langStr) {
        List listL;
        List listL2;
        kotlin.jvm.internal.m.f(langStr, "langStr");
        if (ua.n.O(langStr, "-", false, 2, null)) {
            List<String> listG = new ua.l("-").g(langStr, 0);
            if (listG.isEmpty()) {
                listL2 = kotlin.collections.r.l();
            } else {
                ListIterator<String> listIterator = listG.listIterator(listG.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listL2 = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                    }
                }
                listL2 = kotlin.collections.r.l();
            }
            String[] strArr = (String[]) listL2.toArray(new String[0]);
            List listO = kotlin.collections.r.o(Arrays.copyOf(strArr, strArr.length));
            return new Locale((String) listO.get(0), (String) listO.get(1));
        }
        if (!ua.n.O(langStr, "_", false, 2, null)) {
            return new Locale(langStr);
        }
        List<String> listG2 = new ua.l("_").g(langStr, 0);
        if (listG2.isEmpty()) {
            listL = kotlin.collections.r.l();
        } else {
            ListIterator<String> listIterator2 = listG2.listIterator(listG2.size());
            while (listIterator2.hasPrevious()) {
                if (listIterator2.previous().length() != 0) {
                    listL = kotlin.collections.r.K0(listG2, listIterator2.nextIndex() + 1);
                }
            }
            listL = kotlin.collections.r.l();
        }
        String[] strArr2 = (String[]) listL.toArray(new String[0]);
        List listO2 = kotlin.collections.r.o(Arrays.copyOf(strArr2, strArr2.length));
        return new Locale((String) listO2.get(0), (String) listO2.get(1));
    }

    public final boolean i(Context context, Locale pNewUserLocale) {
        kotlin.jvm.internal.m.f(context, "context");
        Locale localeA = a(context);
        if (pNewUserLocale != null) {
            return (kotlin.jvm.internal.m.a(localeA, pNewUserLocale) && context.getResources().getConfiguration().locale.getLanguage().equals(pNewUserLocale.getLanguage())) ? false : true;
        }
        return false;
    }

    public final void j(Context context, int pos) {
        kotlin.jvm.internal.m.f(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("language_sp", 0);
        kotlin.jvm.internal.m.e(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("language_key", pos);
        editorEdit.commit();
    }

    public final Context o(Context context, Locale newUserLocale, Configuration config) {
        kotlin.jvm.internal.m.f(context, "context");
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(newUserLocale);
            com.live.evo.util.i.a();
            configuration.setLocales(com.live.evo.util.h.a(new Locale[]{newUserLocale}));
            if (config != null) {
                config.setLocale(newUserLocale);
            }
            if (config != null) {
                com.live.evo.util.i.a();
                config.setLocales(com.live.evo.util.h.a(new Locale[]{newUserLocale}));
            }
        } else {
            configuration.locale = newUserLocale;
            if (config != null) {
                config.locale = newUserLocale;
            }
        }
        if (newUserLocale != null) {
            Locale.setDefault(newUserLocale);
        }
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        kotlin.jvm.internal.m.e(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    public final void q(String lang, Context context, int pos) {
        kotlin.jvm.internal.m.f(lang, "lang");
        kotlin.jvm.internal.m.f(context, "context");
        if (kotlin.jvm.internal.m.a(lang, defLanguage)) {
            p(context, null, true, pos);
            return;
        }
        String str = languageMap.get(lang);
        if (str != null) {
            n0 n0Var = f21425a;
            n0Var.p(context, n0Var.h(str), false, pos);
        }
    }

    private n0() {
    }

    private final String b(Context pContext) {
        Locale localeA = a(pContext);
        String language = localeA.getLanguage();
        String country = localeA.getCountry();
        if (kotlin.jvm.internal.m.a(language, "zh") && (ua.n.w(country, "hk", true) || ua.n.w(country, "tw", true))) {
            language = language + "-hk";
        }
        kotlin.jvm.internal.m.c(language);
        return language;
    }

    private final void k(Context mContext, int pos) {
        j(mContext, pos);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0020  */
    /* JADX WARN: Code duplicated, block: B:20:0x002e A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #1 {all -> 0x002a, blocks: (B:17:0x0025, B:20:0x002e), top: B:32:0x001e }] */
    private final Context p(Context mContext, Locale newUserLocale, boolean isFollowSystem, int pos) {
        Object obj;
        Locale locale;
        Context context;
        try {
            String strB = b(mContext);
            if (newUserLocale == null) {
                if (!isFollowSystem) {
                    strB = "en";
                }
                if (strB != null) {
                    try {
                        newUserLocale = f21425a.h(strB);
                    } catch (Throwable th) {
                        obj = th;
                    }
                } else {
                    newUserLocale = null;
                }
                locale = newUserLocale;
                if (i(mContext, locale)) {
                    context = mContext;
                    mContext = s(this, context, locale, null, 4, null);
                } else {
                    context = mContext;
                    context.getResources().updateConfiguration(context.getResources().getConfiguration(), context.getResources().getDisplayMetrics());
                    mContext = context;
                }
                k(context, pos);
                return mContext;
            }
            locale = newUserLocale;
            try {
                if (i(mContext, locale)) {
                    context = mContext;
                    mContext = s(this, context, locale, null, 4, null);
                } else {
                    context = mContext;
                    context.getResources().updateConfiguration(context.getResources().getConfiguration(), context.getResources().getDisplayMetrics());
                    mContext = context;
                }
                try {
                    k(context, pos);
                    return mContext;
                } catch (Throwable th2) {
                    th = th2;
                    obj = th;
                    logger.a("updateLocale failure", obj);
                    return mContext;
                }
            } catch (Throwable th3) {
                obj = th3;
                mContext = context;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        logger.a("updateLocale failure", obj);
        return mContext;
    }
}
