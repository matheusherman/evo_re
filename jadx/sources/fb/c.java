package fb;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Locale f10104a = new Locale("", "");

    public static int a(Locale locale, Locale locale2) {
        if (locale == null) {
            return -1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return (locale2.getCountry().isEmpty() || locale2.getLanguage().isEmpty()) ? 1 : 0;
        }
        if (locale.getCountry().equals(locale2.getCountry())) {
            return 3;
        }
        return locale2.getCountry().isEmpty() ? 2 : 0;
    }
}
