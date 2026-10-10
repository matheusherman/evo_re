package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class pb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3916a;

    private final int f() {
        try {
            String str = this.f3916a.get("CmpSdkID");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final int g() {
        try {
            String str = this.f3916a.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final Bundle h() {
        if (!"1".equals(this.f3916a.get("GoogleConsent"))) {
            return Bundle.EMPTY;
        }
        int iG = g();
        if (iG < 0) {
            return Bundle.EMPTY;
        }
        String str = this.f3916a.get("PurposeConsents");
        if (TextUtils.isEmpty(str)) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        String str2 = "denied";
        if (str.length() > 0) {
            bundle.putString(v7.a.AD_STORAGE.zze, str.charAt(0) == '1' ? "granted" : "denied");
        }
        if (str.length() > 3) {
            bundle.putString(v7.a.AD_PERSONALIZATION.zze, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
        }
        if (str.length() > 6 && iG >= 4) {
            String str3 = v7.a.AD_USER_DATA.zze;
            if (str.charAt(0) == '1' && str.charAt(6) == '1') {
                str2 = "granted";
            }
            bundle.putString(str3, str2);
        }
        return bundle;
    }

    public final Bundle a() {
        f5<Boolean> f5Var = g0.f3582l1;
        if (!f5Var.a(null).booleanValue() ? "1".equals(this.f3916a.get("GoogleConsent")) && "1".equals(this.f3916a.get("gdprApplies")) && "1".equals(this.f3916a.get("EnableAdvertiserConsentMode")) : "1".equals(this.f3916a.get("gdprApplies")) && "1".equals(this.f3916a.get("EnableAdvertiserConsentMode"))) {
            return Bundle.EMPTY;
        }
        if (!f5Var.a(null).booleanValue()) {
            return h();
        }
        if (this.f3916a.get("Version") == null) {
            return h();
        }
        if (g() < 0) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        String str = "denied";
        bundle.putString(v7.a.AD_STORAGE.zze, Objects.equals(this.f3916a.get("AuthorizePurpose1"), "1") ? "granted" : "denied");
        bundle.putString(v7.a.AD_PERSONALIZATION.zze, (Objects.equals(this.f3916a.get("AuthorizePurpose3"), "1") && Objects.equals(this.f3916a.get("AuthorizePurpose4"), "1")) ? "granted" : "denied");
        if (g() >= 4) {
            String str2 = v7.a.AD_USER_DATA.zze;
            if (Objects.equals(this.f3916a.get("AuthorizePurpose1"), "1") && Objects.equals(this.f3916a.get("AuthorizePurpose7"), "1")) {
                str = "granted";
            }
            bundle.putString(str2, str);
        }
        return bundle;
    }

    public final String b(pb pbVar) {
        String str = (pbVar.f3916a.isEmpty() || pbVar.f3916a.get("Version") != null) ? "0" : "1";
        Bundle bundleA = a();
        Bundle bundleA2 = pbVar.a();
        return str + ((bundleA.size() == bundleA2.size() && Objects.equals(bundleA.getString("ad_storage"), bundleA2.getString("ad_storage")) && Objects.equals(bundleA.getString("ad_personalization"), bundleA2.getString("ad_personalization")) && Objects.equals(bundleA.getString("ad_user_data"), bundleA2.getString("ad_user_data"))) ? "0" : "1");
    }

    public final String c() {
        String str = this.f3916a.get("PurposeDiagnostics");
        return TextUtils.isEmpty(str) ? "200000" : str;
    }

    public final String d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("1");
        int iF = f();
        if (iF < 0 || iF > 4095) {
            sb2.append("00");
        } else {
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt((iF >> 6) & 63));
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iF & 63));
        }
        int iG = g();
        if (iG < 0 || iG > 63) {
            sb2.append("0");
        } else {
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iG));
        }
        m1.g.a(true);
        int i10 = "1".equals(this.f3916a.get("gdprApplies")) ? 2 : 0;
        int i11 = i10 | 4;
        if ("1".equals(this.f3916a.get("EnableAdvertiserConsentMode"))) {
            i11 = i10 | 12;
        }
        sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i11));
        return sb2.toString();
    }

    final String e() {
        StringBuilder sb2 = new StringBuilder();
        com.google.common.collect.p<String> pVar = rb.f3978o;
        int size = pVar.size();
        int i10 = 0;
        while (i10 < size) {
            String str = pVar.get(i10);
            i10++;
            String str2 = str;
            if (this.f3916a.containsKey(str2)) {
                if (sb2.length() > 0) {
                    sb2.append(";");
                }
                sb2.append(str2);
                sb2.append("=");
                sb2.append(this.f3916a.get(str2));
            }
        }
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof pb) {
            return e().equalsIgnoreCase(((pb) obj).e());
        }
        return false;
    }

    pb(Map<String, String> map) {
        HashMap map2 = new HashMap();
        this.f3916a = map2;
        map2.putAll(map);
    }

    public final int hashCode() {
        return e().hashCode();
    }

    public final String toString() {
        return e();
    }
}
