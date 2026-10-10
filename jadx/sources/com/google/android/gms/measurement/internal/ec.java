package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ec extends yb {
    private static boolean z(String str) {
        String strA = g0.f3601t.a(null);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        for (String str2 : strA.split(",")) {
            if (str.equalsIgnoreCase(str2.trim())) {
                return true;
            }
        }
        return false;
    }

    ec(gc gcVar) {
        super(gcVar);
    }

    private final boolean x(String str, String str2) {
        x4 x4VarV0;
        com.google.android.gms.internal.measurement.w4 w4VarO = s().O(str);
        if (w4VarO == null || (x4VarV0 = r().V0(str)) == null) {
            return false;
        }
        if ((w4VarO.f0() && w4VarO.W().n() == 100) || j().G0(str, x4VarV0.v())) {
            return true;
        }
        if (TextUtils.isEmpty(str2) || Math.abs(str2.hashCode() % 100) >= w4VarO.W().n()) {
            return false;
        }
        return true;
    }

    private final String y(String str) {
        String strU = s().U(str);
        if (!TextUtils.isEmpty(strU)) {
            Uri uri = Uri.parse(g0.f3597r.a(null));
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.authority(strU + "." + uri.getAuthority());
            return builderBuildUpon.build().toString();
        }
        return g0.f3597r.a(null);
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ e e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a0 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ k5 g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a6 h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ sc o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ zc q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ m r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ j6 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ eb t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.yb
    public final /* bridge */ /* synthetic */ ec u() {
        return super.u();
    }

    public final dc v(String str) {
        String str2;
        i iVarD = d();
        f5<Boolean> f5Var = g0.P0;
        dc dcVar = null;
        if (iVarD.u(f5Var)) {
            x4 x4VarV0 = r().V0(str);
            if (x4VarV0 != null && x4VarV0.C()) {
                com.google.android.gms.internal.measurement.x5.a aVarK = com.google.android.gms.internal.measurement.x5.K();
                com.google.android.gms.internal.measurement.x5.d dVar = com.google.android.gms.internal.measurement.x5.d.GA_UPLOAD;
                com.google.android.gms.internal.measurement.x5.a aVarV = aVarK.y(dVar).v((com.google.android.gms.internal.measurement.x5.b) m1.g.k(com.google.android.gms.internal.measurement.x5.b.a(x4VarV0.F())));
                if (!x(str, x4VarV0.m())) {
                    aVarV.x(com.google.android.gms.internal.measurement.x5.c.NOT_IN_ROLLOUT);
                    return new dc(y(str), Collections.EMPTY_MAP, b2.c1.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.x5) ((com.google.android.gms.internal.measurement.ea) aVarV.w()));
                }
                String strL = x4VarV0.l();
                aVarV.y(dVar);
                com.google.android.gms.internal.measurement.w4 w4VarO = s().O(x4VarV0.l());
                if (w4VarO != null && w4VarO.f0()) {
                    HashMap map = new HashMap();
                    if (!TextUtils.isEmpty(x4VarV0.v())) {
                        map.put("x-gtm-server-preview", x4VarV0.v());
                    }
                    String strN = w4VarO.W().N();
                    com.google.android.gms.internal.measurement.x5.b bVarA = com.google.android.gms.internal.measurement.x5.b.a(x4VarV0.F());
                    if (bVarA != null && bVarA != com.google.android.gms.internal.measurement.x5.b.CLIENT_UPLOAD_ELIGIBLE) {
                        aVarV.v(bVarA);
                    } else if (!d().u(f5Var)) {
                        aVarV.v(com.google.android.gms.internal.measurement.x5.b.SERVICE_FLAG_OFF);
                    } else if (z(x4VarV0.l())) {
                        aVarV.v(com.google.android.gms.internal.measurement.x5.b.PINNED_TO_SERVICE_UPLOAD);
                    } else if (TextUtils.isEmpty(strN)) {
                        aVarV.v(com.google.android.gms.internal.measurement.x5.b.MISSING_SGTM_SERVER_URL);
                    } else {
                        l().L().b("[sgtm] Eligible for client side upload. appId", strL);
                        aVarV.y(com.google.android.gms.internal.measurement.x5.d.SDK_CLIENT_UPLOAD).v(com.google.android.gms.internal.measurement.x5.b.CLIENT_UPLOAD_ELIGIBLE);
                        dcVar = new dc(strN, map, b2.c1.SGTM_CLIENT, (com.google.android.gms.internal.measurement.x5) ((com.google.android.gms.internal.measurement.ea) aVarV.w()));
                    }
                    w4VarO.W().O();
                    w4VarO.W().M();
                    if (!TextUtils.isEmpty(strN)) {
                        l().L().b("[sgtm] Eligible for local service direct upload. appId", strL);
                        aVarV.y(com.google.android.gms.internal.measurement.x5.d.SDK_SERVICE_UPLOAD).x(com.google.android.gms.internal.measurement.x5.c.SERVICE_UPLOAD_ELIGIBLE);
                        dcVar = new dc(strN, map, b2.c1.SGTM, (com.google.android.gms.internal.measurement.x5) ((com.google.android.gms.internal.measurement.ea) aVarV.w()));
                    } else {
                        aVarV.x(com.google.android.gms.internal.measurement.x5.c.NON_PLAY_MISSING_SGTM_SERVER_URL);
                        l().L().b("[sgtm] Local service, missing sgtm_server_url", x4VarV0.l());
                    }
                } else {
                    l().L().b("[sgtm] Missing sgtm_setting in remote config. appId", strL);
                    aVarV.x(com.google.android.gms.internal.measurement.x5.c.MISSING_SGTM_SETTINGS);
                }
                if (dcVar != null) {
                    return dcVar;
                }
                return new dc(y(str), Collections.EMPTY_MAP, b2.c1.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.x5) ((com.google.android.gms.internal.measurement.ea) aVarV.w()));
            }
            return new dc(y(str), b2.c1.GOOGLE_ANALYTICS);
        }
        x4 x4VarV1 = r().V0(str);
        if (x4VarV1 == null) {
            return new dc(y(str), b2.c1.GOOGLE_ANALYTICS);
        }
        if (!x(str, x4VarV1.m())) {
            return new dc(y(str), b2.c1.GOOGLE_ANALYTICS);
        }
        if (x4VarV1.C()) {
            l().L().a("sgtm upload enabled in manifest.");
            com.google.android.gms.internal.measurement.w4 w4VarO2 = s().O(x4VarV1.l());
            if (w4VarO2 != null && w4VarO2.f0()) {
                String strO = w4VarO2.W().O();
                if (!TextUtils.isEmpty(strO)) {
                    String strM = w4VarO2.W().M();
                    r5 r5VarL = l().L();
                    if (TextUtils.isEmpty(strM)) {
                        str2 = "Y";
                    } else {
                        str2 = "N";
                    }
                    r5VarL.c("sgtm configured with upload_url, server_info", strO, str2);
                    if (TextUtils.isEmpty(strM)) {
                        dcVar = new dc(strO, b2.c1.SGTM);
                    } else {
                        HashMap map2 = new HashMap();
                        map2.put("x-sgtm-server-info", strM);
                        if (!TextUtils.isEmpty(x4VarV1.v())) {
                            map2.put("x-gtm-server-preview", x4VarV1.v());
                        }
                        dcVar = new dc(strO, map2, b2.c1.SGTM);
                    }
                }
            }
        }
        if (dcVar != null) {
            return dcVar;
        }
        return new dc(y(str), b2.c1.GOOGLE_ANALYTICS);
    }

    @WorkerThread
    final boolean w(String str, com.google.android.gms.internal.measurement.x5.b bVar) {
        com.google.android.gms.internal.measurement.w4 w4VarO;
        n();
        if (!d().u(g0.P0) || bVar != com.google.android.gms.internal.measurement.x5.b.CLIENT_UPLOAD_ELIGIBLE || z(str) || (w4VarO = s().O(str)) == null || !w4VarO.f0() || w4VarO.W().N().isEmpty()) {
            return false;
        }
        return true;
    }
}
