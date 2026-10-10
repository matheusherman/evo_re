package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class rb {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final com.google.common.collect.p<String> f3978o = com.google.common.collect.p.y("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.common.collect.q<com.google.android.gms.internal.measurement.m8, tb> f3979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.common.collect.q<com.google.android.gms.internal.measurement.m8, com.google.android.gms.internal.measurement.l8> f3980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.common.collect.s<String> f3981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char[] f3982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f3986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f3987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f3988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f3989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f3990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f3991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f3992n;

    /* JADX WARN: Illegal instructions before constructor call */
    public rb(SharedPreferences sharedPreferences) {
        com.google.android.gms.internal.measurement.m8 m8Var = com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        tb tbVar = tb.CONSENT;
        Map.Entry entryA = b2.o1.a(m8Var, tbVar);
        com.google.android.gms.internal.measurement.m8 m8Var2 = com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
        tb tbVar2 = tb.FLEXIBLE_LEGITIMATE_INTEREST;
        this(sharedPreferences, 755, com.google.common.collect.q.l(entryA, b2.o1.a(m8Var2, tbVar2), b2.o1.a(com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, tbVar), b2.o1.a(com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, tbVar), b2.o1.a(com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, tbVar2), b2.o1.a(com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, tbVar2), b2.o1.a(com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, tbVar2)), com.google.common.collect.s.x("CH"));
    }

    static int a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    private static int b(com.google.android.gms.internal.measurement.m8 m8Var) {
        if (m8Var == com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (m8Var == com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (m8Var == com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return m8Var == com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private final com.google.android.gms.internal.measurement.l8 d(com.google.android.gms.internal.measurement.m8 m8Var) {
        return this.f3980b.getOrDefault(m8Var, com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_UNDEFINED);
    }

    static String e(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    private final String f(com.google.android.gms.internal.measurement.m8 m8Var) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(this.f3989k) || this.f3989k.length() < m8Var.b()) ? "0" : String.valueOf(this.f3989k.charAt(m8Var.b() - 1));
        if (!TextUtils.isEmpty(this.f3990l) && this.f3990l.length() >= m8Var.b()) {
            strValueOf = String.valueOf(this.f3990l.charAt(m8Var.b() - 1));
        }
        return strValueOf2 + strValueOf;
    }

    public final Map<String, String> c() {
        com.google.common.collect.q<com.google.android.gms.internal.measurement.m8, com.google.android.gms.internal.measurement.l8> qVar = this.f3980b;
        com.google.android.gms.internal.measurement.m8 m8Var = com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.l8 l8Var = qVar.get(m8Var);
        com.google.common.collect.q<com.google.android.gms.internal.measurement.m8, com.google.android.gms.internal.measurement.l8> qVar2 = this.f3980b;
        com.google.android.gms.internal.measurement.m8 m8Var2 = com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.l8 l8Var2 = qVar2.get(m8Var2);
        com.google.common.collect.q<com.google.android.gms.internal.measurement.m8, com.google.android.gms.internal.measurement.l8> qVar3 = this.f3980b;
        com.google.android.gms.internal.measurement.m8 m8Var3 = com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.l8 l8Var3 = qVar3.get(m8Var3);
        com.google.common.collect.q<com.google.android.gms.internal.measurement.m8, com.google.android.gms.internal.measurement.l8> qVar4 = this.f3980b;
        com.google.android.gms.internal.measurement.m8 m8Var4 = com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.l8 l8Var4 = qVar4.get(m8Var4);
        return com.google.common.collect.q.a().f("Version", ExifInterface.GPS_MEASUREMENT_2D).f("VendorConsent", this.f3991m ? "1" : "0").f("VendorLegitimateInterest", this.f3992n ? "1" : "0").f("gdprApplies", this.f3985g == 1 ? "1" : "0").f("EnableAdvertiserConsentMode", this.f3984f == 1 ? "1" : "0").f("PolicyVersion", String.valueOf(this.f3986h)).f("CmpSdkID", String.valueOf(this.f3983e)).f("PurposeOneTreatment", this.f3987i == 1 ? "1" : "0").f("PublisherCC", this.f3988j).f("PublisherRestrictions1", String.valueOf(l8Var != null ? l8Var.b() : com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_UNDEFINED.b())).f("PublisherRestrictions3", String.valueOf(l8Var2 != null ? l8Var2.b() : com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_UNDEFINED.b())).f("PublisherRestrictions4", String.valueOf(l8Var3 != null ? l8Var3.b() : com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_UNDEFINED.b())).f("PublisherRestrictions7", String.valueOf(l8Var4 != null ? l8Var4.b() : com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_UNDEFINED.b())).i(com.google.common.collect.q.j("Purpose1", f(m8Var), "Purpose3", f(m8Var2), "Purpose4", f(m8Var3), "Purpose7", f(m8Var4))).i(com.google.common.collect.q.k("AuthorizePurpose1", i(m8Var) ? "1" : "0", "AuthorizePurpose3", i(m8Var2) ? "1" : "0", "AuthorizePurpose4", i(m8Var3) ? "1" : "0", "AuthorizePurpose7", i(m8Var4) ? "1" : "0", "PurposeDiagnostics", new String(this.f3982d))).c();
    }

    private final boolean g(com.google.android.gms.internal.measurement.m8 m8Var) {
        int iB = b(m8Var);
        boolean z10 = false;
        if (!this.f3991m) {
            if (iB > 0) {
                char[] cArr = this.f3982d;
                if (cArr[iB] != '2') {
                    cArr[iB] = '4';
                }
            }
            return false;
        }
        if (this.f3989k.length() < m8Var.b()) {
            if (iB > 0) {
                char[] cArr2 = this.f3982d;
                if (cArr2[iB] != '2') {
                    cArr2[iB] = '0';
                }
            }
            return false;
        }
        char c10 = '1';
        if (this.f3989k.charAt(m8Var.b() - 1) == '1') {
            z10 = true;
        }
        if (iB > 0) {
            char[] cArr3 = this.f3982d;
            if (cArr3[iB] != '2') {
                if (!z10) {
                    c10 = '6';
                }
                cArr3[iB] = c10;
            }
        }
        return z10;
    }

    private final boolean h(com.google.android.gms.internal.measurement.m8 m8Var) {
        int iB = b(m8Var);
        boolean z10 = false;
        if (!this.f3992n) {
            if (iB > 0) {
                char[] cArr = this.f3982d;
                if (cArr[iB] != '2') {
                    cArr[iB] = '5';
                }
            }
            return false;
        }
        if (this.f3990l.length() < m8Var.b()) {
            if (iB > 0) {
                char[] cArr2 = this.f3982d;
                if (cArr2[iB] != '2') {
                    cArr2[iB] = '0';
                }
            }
            return false;
        }
        char c10 = '1';
        if (this.f3990l.charAt(m8Var.b() - 1) == '1') {
            z10 = true;
        }
        if (iB > 0) {
            char[] cArr3 = this.f3982d;
            if (cArr3[iB] != '2') {
                if (!z10) {
                    c10 = '7';
                }
                cArr3[iB] = c10;
            }
        }
        return z10;
    }

    @VisibleForTesting
    private final boolean i(com.google.android.gms.internal.measurement.m8 m8Var) {
        int iB = b(m8Var);
        if (iB > 0 && (this.f3985g != 1 || this.f3984f != 1)) {
            this.f3982d[iB] = '2';
        }
        if (d(m8Var) == com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            if (iB > 0) {
                char[] cArr = this.f3982d;
                if (cArr[iB] != '2') {
                    cArr[iB] = '3';
                }
            }
            return false;
        }
        if (m8Var == com.google.android.gms.internal.measurement.m8.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE && this.f3987i == 1 && this.f3981c.contains(this.f3988j)) {
            if (iB > 0) {
                char[] cArr2 = this.f3982d;
                if (cArr2[iB] != '2') {
                    cArr2[iB] = '1';
                }
            }
            return true;
        }
        if (!this.f3979a.containsKey(m8Var)) {
            if (iB > 0) {
                char[] cArr3 = this.f3982d;
                if (cArr3[iB] != '2') {
                    cArr3[iB] = '0';
                }
            }
            return false;
        }
        tb tbVar = this.f3979a.get(m8Var);
        if (tbVar == null) {
            if (iB > 0) {
                char[] cArr4 = this.f3982d;
                if (cArr4[iB] != '2') {
                    cArr4[iB] = '0';
                }
            }
            return false;
        }
        int iOrdinal = tbVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iB > 0) {
                            char[] cArr5 = this.f3982d;
                            if (cArr5[iB] != '2') {
                                cArr5[iB] = '0';
                            }
                        }
                        return false;
                    }
                    if (d(m8Var) == com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                        return g(m8Var);
                    }
                    return h(m8Var);
                }
                if (d(m8Var) == com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                    return h(m8Var);
                }
                return g(m8Var);
            }
            if (d(m8Var) == com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                if (iB > 0) {
                    char[] cArr6 = this.f3982d;
                    if (cArr6[iB] != '2') {
                        cArr6[iB] = '8';
                    }
                }
                return false;
            }
            return h(m8Var);
        }
        if (d(m8Var) == com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
            if (iB > 0) {
                char[] cArr7 = this.f3982d;
                if (cArr7[iB] != '2') {
                    cArr7[iB] = '8';
                }
            }
            return false;
        }
        return g(m8Var);
    }

    @VisibleForTesting
    private rb(SharedPreferences sharedPreferences, int i10, com.google.common.collect.q<com.google.android.gms.internal.measurement.m8, tb> qVar, com.google.common.collect.s<String> sVar) {
        int i11;
        com.google.android.gms.internal.measurement.l8 l8Var;
        this.f3982d = new char[5];
        this.f3979a = qVar;
        this.f3981c = sVar;
        this.f3983e = a(sharedPreferences, "IABTCF_CmpSdkID");
        this.f3986h = a(sharedPreferences, "IABTCF_PolicyVersion");
        this.f3985g = a(sharedPreferences, "IABTCF_gdprApplies");
        this.f3987i = a(sharedPreferences, "IABTCF_PurposeOneTreatment");
        this.f3984f = a(sharedPreferences, "IABTCF_EnableAdvertiserConsentMode");
        this.f3988j = e(sharedPreferences, "IABTCF_PublisherCC");
        com.google.common.collect.q.a aVarA = com.google.common.collect.q.a();
        com.google.common.collect.s0<com.google.android.gms.internal.measurement.m8> it = qVar.keySet().iterator();
        while (true) {
            i11 = 1;
            if (!it.hasNext()) {
                break;
            }
            com.google.android.gms.internal.measurement.m8 next = it.next();
            String strE = e(sharedPreferences, "IABTCF_PublisherRestrictions" + next.b());
            if (!TextUtils.isEmpty(strE) && strE.length() >= 755) {
                int iDigit = Character.digit(strE.charAt(754), 10);
                if (iDigit < 0 || iDigit > com.google.android.gms.internal.measurement.l8.values().length) {
                    l8Var = com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_NOT_ALLOWED;
                } else if (iDigit == 0) {
                    l8Var = com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_NOT_ALLOWED;
                } else if (iDigit == 1) {
                    l8Var = com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                } else if (iDigit != 2) {
                    l8Var = com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_UNDEFINED;
                } else {
                    l8Var = com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                }
            } else {
                l8Var = com.google.android.gms.internal.measurement.l8.PURPOSE_RESTRICTION_UNDEFINED;
            }
            aVarA.f(next, l8Var);
        }
        this.f3980b = aVarA.c();
        this.f3989k = e(sharedPreferences, "IABTCF_PurposeConsents");
        String strE2 = e(sharedPreferences, "IABTCF_VendorConsents");
        if (!TextUtils.isEmpty(strE2) && strE2.length() >= 755) {
            this.f3991m = strE2.charAt(754) == '1';
        } else {
            this.f3991m = false;
        }
        this.f3990l = e(sharedPreferences, "IABTCF_PurposeLegitimateInterests");
        String strE3 = e(sharedPreferences, "IABTCF_VendorLegitimateInterests");
        if (!TextUtils.isEmpty(strE3) && strE3.length() >= 755) {
            this.f3992n = strE3.charAt(754) == '1';
        } else {
            this.f3992n = false;
        }
        this.f3982d[0] = '2';
        while (true) {
            char[] cArr = this.f3982d;
            if (i11 <= cArr.length) {
                return;
            }
            cArr[i11] = '0';
            i11++;
        }
    }
}
