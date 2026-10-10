package com.live.evo.util;

import android.text.TextUtils;
import com.live.evo.R$string;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7322a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7323b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7324c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f7325d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f7326e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f7327f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f7328g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f7329h = "";

    public static String a(String str, String str2) {
        return b(com.live.evo.l.n().i(str, str2));
    }

    public static String b(String str) {
        int i10;
        if (com.live.evo.l.n() != null) {
            if (TextUtils.isEmpty(f7322a)) {
                f7322a = com.live.evo.l.n().i("contact_email", t.v.c.i.a.f18646a.v());
            }
            if (TextUtils.isEmpty(f7323b)) {
                f7323b = com.live.evo.l.n().i("web_site", t.v.c.i.a.f18646a.N());
            }
            if (TextUtils.isEmpty(f7324c)) {
                f7324c = com.live.evo.l.n().i("whatsapp", t.v.c.i.a.f18646a.z());
            }
            if (TextUtils.isEmpty(f7325d)) {
                f7325d = com.live.evo.l.n().i("phone", "");
            }
            if (TextUtils.isEmpty(f7326e)) {
                f7326e = com.live.evo.l.n().i("facebook", "");
            }
            if (TextUtils.isEmpty(f7327f)) {
                f7327f = com.live.evo.l.n().i("twitter", "");
            }
            if (str.contains("${ValidTime}")) {
                long jL = com.live.evo.l.n().l();
                if (jL <= 0) {
                    jL = com.live.evo.l.n().h("validTime", -1L);
                }
                if (jL >= 0) {
                    int iJ = q1.j(u1.b().a(), jL);
                    if (iJ <= 1) {
                        f7328g = iJ + " " + x1.j(R$string.hour);
                    } else {
                        f7328g = iJ + " " + x1.j(R$string.hours);
                    }
                }
            }
            if (TextUtils.isEmpty(f7329h)) {
                int iG = com.live.evo.l.n().g("TrialDays", 0);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(iG);
                sb2.append(" ");
                if (iG > 1) {
                    i10 = R$string.days;
                } else {
                    i10 = R$string.day;
                }
                sb2.append(x1.j(i10));
                f7329h = sb2.toString();
            }
        }
        String strJ = x1.j(R$string.freetrial_app_name);
        String strReplace = str.replace("${Email}", f7322a).replace("${Website}", f7323b).replace("${Whatsapp}", f7324c).replace("${Phone}", f7325d).replace("${Facebook}", f7326e).replace("${Twitter}", f7327f).replace("${NewLine}", "<br/>");
        if (TextUtils.isEmpty(strJ)) {
            strJ = x1.f1.lb.util.k.f21398a.t();
        }
        return strReplace.replace("${AppName}", strJ).replace("${ValidTime}", f7328g).replace("${TrialDays}", f7329h);
    }
}
