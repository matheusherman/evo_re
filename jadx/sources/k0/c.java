package k0;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f11757a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f11758b = "goog.exo.core";

    public static synchronized void a(String str) {
        if (f11757a.add(str)) {
            String str2 = f11758b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length());
            sb2.append(str2);
            sb2.append(", ");
            sb2.append(str);
            f11758b = sb2.toString();
        }
    }
}
