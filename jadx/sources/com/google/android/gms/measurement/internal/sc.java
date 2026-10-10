package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.ef;
import com.google.android.gms.internal.measurement.rf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.log4j.spi.Configurator;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class sc extends bc {
    private static void T(Uri.Builder builder, String[] strArr, Bundle bundle, Set<String> set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                S(builder, str3, string, set);
            }
        }
    }

    private static void X(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
    }

    static int z(com.google.android.gms.internal.measurement.t5.a aVar, String str) {
        if (aVar == null) {
            return -1;
        }
        for (int i10 = 0; i10 < aVar.k0(); i10++) {
            if (str.equals(aVar.S0(i10).a0())) {
                return i10;
            }
        }
        return -1;
    }

    final <T extends Parcelable> T E(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (n1.a.C0307a unused) {
            l().H().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.google.android.gms.measurement.internal.bc
    protected final boolean y() {
        return false;
    }

    static Bundle C(List<com.google.android.gms.internal.measurement.q5> list) {
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.q5 q5Var : list) {
            String strC0 = q5Var.c0();
            if (q5Var.f0()) {
                bundle.putDouble(strC0, q5Var.K());
            } else if (q5Var.g0()) {
                bundle.putFloat(strC0, q5Var.S());
            } else if (q5Var.j0()) {
                bundle.putString(strC0, q5Var.d0());
            } else if (q5Var.h0()) {
                bundle.putLong(strC0, q5Var.Y());
            }
        }
        return bundle;
    }

    private final Bundle D(Map<String, Object> map, boolean z10) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z10) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    arrayList2.add(D((Map) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    private static String O(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("Dynamic ");
        }
        if (z11) {
            sb2.append("Sequence ");
        }
        if (z12) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    private final void Y(StringBuilder sb2, int i10, com.google.android.gms.internal.measurement.n4 n4Var) {
        if (n4Var == null) {
            return;
        }
        X(sb2, i10);
        sb2.append("filter {\n");
        if (n4Var.S()) {
            b0(sb2, i10, "complement", Boolean.valueOf(n4Var.R()));
        }
        if (n4Var.U()) {
            b0(sb2, i10, "param_name", g().f(n4Var.Q()));
        }
        if (n4Var.W()) {
            int i11 = i10 + 1;
            com.google.android.gms.internal.measurement.q4 q4VarO = n4Var.O();
            if (q4VarO != null) {
                X(sb2, i11);
                sb2.append("string_filter");
                sb2.append(" {\n");
                if (q4VarO.T()) {
                    b0(sb2, i11, "match_type", q4VarO.K().name());
                }
                if (q4VarO.S()) {
                    b0(sb2, i11, "expression", q4VarO.N());
                }
                if (q4VarO.R()) {
                    b0(sb2, i11, "case_sensitive", Boolean.valueOf(q4VarO.Q()));
                }
                if (q4VarO.n() > 0) {
                    X(sb2, i10 + 2);
                    sb2.append("expression_list {\n");
                    for (String str : q4VarO.O()) {
                        X(sb2, i10 + 3);
                        sb2.append(str);
                        sb2.append("\n");
                    }
                    sb2.append("}\n");
                }
                X(sb2, i11);
                sb2.append("}\n");
            }
        }
        if (n4Var.T()) {
            Z(sb2, i10 + 1, "number_filter", n4Var.N());
        }
        X(sb2, i10);
        sb2.append("}\n");
    }

    private static void Z(StringBuilder sb2, int i10, String str, com.google.android.gms.internal.measurement.o4 o4Var) {
        if (o4Var == null) {
            return;
        }
        X(sb2, i10);
        sb2.append(str);
        sb2.append(" {\n");
        if (o4Var.S()) {
            b0(sb2, i10, "comparison_type", o4Var.K().name());
        }
        if (o4Var.U()) {
            b0(sb2, i10, "match_as_float", Boolean.valueOf(o4Var.R()));
        }
        if (o4Var.T()) {
            b0(sb2, i10, "comparison_value", o4Var.N());
        }
        if (o4Var.X()) {
            b0(sb2, i10, "min_comparison_value", o4Var.Q());
        }
        if (o4Var.W()) {
            b0(sb2, i10, "max_comparison_value", o4Var.O());
        }
        X(sb2, i10);
        sb2.append("}\n");
    }

    private static void a0(StringBuilder sb2, int i10, String str, com.google.android.gms.internal.measurement.v5 v5Var) {
        if (v5Var == null) {
            return;
        }
        X(sb2, 3);
        sb2.append(str);
        sb2.append(" {\n");
        if (v5Var.M() != 0) {
            X(sb2, 4);
            sb2.append("results: ");
            int i11 = 0;
            for (Long l10 : v5Var.b0()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l10);
                i11 = i12;
            }
            sb2.append('\n');
        }
        if (v5Var.T() != 0) {
            X(sb2, 4);
            sb2.append("status: ");
            int i13 = 0;
            for (Long l11 : v5Var.d0()) {
                int i14 = i13 + 1;
                if (i13 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l11);
                i13 = i14;
            }
            sb2.append('\n');
        }
        if (v5Var.n() != 0) {
            X(sb2, 4);
            sb2.append("dynamic_filter_timestamps: {");
            int i15 = 0;
            for (com.google.android.gms.internal.measurement.n5 n5Var : v5Var.a0()) {
                int i16 = i15 + 1;
                if (i15 != 0) {
                    sb2.append(", ");
                }
                sb2.append(n5Var.R() ? Integer.valueOf(n5Var.n()) : null);
                sb2.append(":");
                sb2.append(n5Var.Q() ? Long.valueOf(n5Var.M()) : null);
                i15 = i16;
            }
            sb2.append("}\n");
        }
        if (v5Var.Q() != 0) {
            X(sb2, 4);
            sb2.append("sequence_filter_timestamps: {");
            int i17 = 0;
            for (com.google.android.gms.internal.measurement.w5 w5Var : v5Var.c0()) {
                int i18 = i17 + 1;
                if (i17 != 0) {
                    sb2.append(", ");
                }
                sb2.append(w5Var.S() ? Integer.valueOf(w5Var.N()) : null);
                sb2.append(": [");
                Iterator<Long> it = w5Var.R().iterator();
                int i19 = 0;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int i20 = i19 + 1;
                    if (i19 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(jLongValue);
                    i19 = i20;
                }
                sb2.append("]");
                i17 = i18;
            }
            sb2.append("}\n");
        }
        X(sb2, 3);
        sb2.append("}\n");
    }

    private static void b0(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj == null) {
            return;
        }
        X(sb2, i10 + 1);
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        sb2.append('\n');
    }

    private final void c0(StringBuilder sb2, int i10, List<com.google.android.gms.internal.measurement.q5> list) {
        if (list == null) {
            return;
        }
        int i11 = i10 + 1;
        for (com.google.android.gms.internal.measurement.q5 q5Var : list) {
            if (q5Var != null) {
                X(sb2, i11);
                sb2.append("param {\n");
                b0(sb2, i11, "name", q5Var.i0() ? g().f(q5Var.c0()) : null);
                b0(sb2, i11, "string_value", q5Var.j0() ? q5Var.d0() : null);
                b0(sb2, i11, "int_value", q5Var.h0() ? Long.valueOf(q5Var.Y()) : null);
                b0(sb2, i11, "double_value", q5Var.f0() ? Double.valueOf(q5Var.K()) : null);
                if (q5Var.W() > 0) {
                    c0(sb2, i11, q5Var.e0());
                }
                X(sb2, i11);
                sb2.append("}\n");
            }
        }
    }

    static boolean h0(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static Bundle[] j0(List<com.google.android.gms.internal.measurement.q5> list) {
        ArrayList arrayList = new ArrayList();
        for (com.google.android.gms.internal.measurement.q5 q5Var : list) {
            if (q5Var != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.q5 q5Var2 : q5Var.e0()) {
                    if (q5Var2.j0()) {
                        bundle.putString(q5Var2.c0(), q5Var2.d0());
                    } else if (q5Var2.h0()) {
                        bundle.putLong(q5Var2.c0(), q5Var2.Y());
                    } else if (q5Var2.f0()) {
                        bundle.putDouble(q5Var2.c0(), q5Var2.K());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    final String L(com.google.android.gms.internal.measurement.m4 m4Var) {
        if (m4Var == null) {
            return Configurator.NULL;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nevent_filter {\n");
        if (m4Var.Z()) {
            b0(sb2, 0, "filter_id", Integer.valueOf(m4Var.N()));
        }
        b0(sb2, 0, "event_name", g().c(m4Var.S()));
        String strO = O(m4Var.U(), m4Var.W(), m4Var.X());
        if (!strO.isEmpty()) {
            b0(sb2, 0, "filter_type", strO);
        }
        if (m4Var.Y()) {
            Z(sb2, 1, "event_count_filter", m4Var.R());
        }
        if (m4Var.n() > 0) {
            sb2.append("  filters {\n");
            Iterator<com.google.android.gms.internal.measurement.n4> it = m4Var.T().iterator();
            while (it.hasNext()) {
                Y(sb2, 2, it.next());
            }
        }
        X(sb2, 1);
        sb2.append("}\n}\n");
        return sb2.toString();
    }

    final String M(com.google.android.gms.internal.measurement.p4 p4Var) {
        if (p4Var == null) {
            return Configurator.NULL;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nproperty_filter {\n");
        if (p4Var.T()) {
            b0(sb2, 0, "filter_id", Integer.valueOf(p4Var.n()));
        }
        b0(sb2, 0, "property_name", g().g(p4Var.O()));
        String strO = O(p4Var.Q(), p4Var.R(), p4Var.S());
        if (!strO.isEmpty()) {
            b0(sb2, 0, "filter_type", strO);
        }
        Y(sb2, 1, p4Var.L());
        sb2.append("}\n");
        return sb2.toString();
    }

    final String N(com.google.android.gms.internal.measurement.s5 s5Var) {
        com.google.android.gms.internal.measurement.l5 l5VarI2;
        if (s5Var == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        if (s5Var.a0()) {
            b0(sb2, 0, "upload_subdomain", s5Var.X());
        }
        if (s5Var.Z()) {
            b0(sb2, 0, "sgtm_join_id", s5Var.W());
        }
        for (com.google.android.gms.internal.measurement.t5 t5Var : s5Var.Y()) {
            if (t5Var != null) {
                X(sb2, 1);
                sb2.append("bundle {\n");
                if (t5Var.b1()) {
                    b0(sb2, 1, "protocol_version", Integer.valueOf(t5Var.H1()));
                }
                if (rf.a() && d().I(t5Var.c0(), g0.L0) && t5Var.e1()) {
                    b0(sb2, 1, "session_stitching_token", t5Var.r0());
                }
                b0(sb2, 1, "platform", t5Var.p0());
                if (t5Var.W0()) {
                    b0(sb2, 1, "gmp_version", Long.valueOf(t5Var.u2()));
                }
                if (t5Var.r1()) {
                    b0(sb2, 1, "uploading_gmp_version", Long.valueOf(t5Var.G2()));
                }
                if (t5Var.U0()) {
                    b0(sb2, 1, "dynamite_version", Long.valueOf(t5Var.n2()));
                }
                if (t5Var.N0()) {
                    b0(sb2, 1, "config_version", Long.valueOf(t5Var.f2()));
                }
                b0(sb2, 1, "gmp_app_id", t5Var.m0());
                b0(sb2, 1, "admob_app_id", t5Var.b0());
                b0(sb2, 1, "app_id", t5Var.c0());
                b0(sb2, 1, "app_version", t5Var.f0());
                if (t5Var.J0()) {
                    b0(sb2, 1, "app_version_major", Integer.valueOf(t5Var.B0()));
                }
                b0(sb2, 1, "firebase_instance_id", t5Var.l0());
                if (t5Var.S0()) {
                    b0(sb2, 1, "dev_cert_hash", Long.valueOf(t5Var.j2()));
                }
                b0(sb2, 1, "app_store", t5Var.e0());
                if (t5Var.q1()) {
                    b0(sb2, 1, "upload_timestamp_millis", Long.valueOf(t5Var.E2()));
                }
                if (t5Var.g1()) {
                    b0(sb2, 1, "start_timestamp_millis", Long.valueOf(t5Var.A2()));
                }
                if (t5Var.V0()) {
                    b0(sb2, 1, "end_timestamp_millis", Long.valueOf(t5Var.r2()));
                }
                if (t5Var.a1()) {
                    b0(sb2, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(t5Var.y2()));
                }
                if (t5Var.Z0()) {
                    b0(sb2, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(t5Var.w2()));
                }
                b0(sb2, 1, "app_instance_id", t5Var.d0());
                b0(sb2, 1, "resettable_device_id", t5Var.q0());
                b0(sb2, 1, "ds_id", t5Var.k0());
                if (t5Var.Y0()) {
                    b0(sb2, 1, "limited_ad_tracking", Boolean.valueOf(t5Var.y0()));
                }
                b0(sb2, 1, "os_version", t5Var.o0());
                b0(sb2, 1, "device_model", t5Var.j0());
                b0(sb2, 1, "user_default_language", t5Var.s0());
                if (t5Var.i1()) {
                    b0(sb2, 1, "time_zone_offset_minutes", Integer.valueOf(t5Var.R1()));
                }
                if (t5Var.M0()) {
                    b0(sb2, 1, "bundle_sequential_index", Integer.valueOf(t5Var.j1()));
                }
                if (t5Var.R0()) {
                    b0(sb2, 1, "delivery_index", Integer.valueOf(t5Var.u1()));
                }
                if (t5Var.d1()) {
                    b0(sb2, 1, "service_upload", Boolean.valueOf(t5Var.z0()));
                }
                b0(sb2, 1, "health_monitor", t5Var.n0());
                if (t5Var.c1()) {
                    b0(sb2, 1, IjkMediaPlayer.OnNativeInvokeListener.ARG_RETRY_COUNTER, Integer.valueOf(t5Var.M1()));
                }
                if (t5Var.P0()) {
                    b0(sb2, 1, "consent_signals", t5Var.h0());
                }
                if (t5Var.X0()) {
                    b0(sb2, 1, "is_dma_region", Boolean.valueOf(t5Var.x0()));
                }
                if (t5Var.Q0()) {
                    b0(sb2, 1, "core_platform_services", t5Var.i0());
                }
                if (t5Var.O0()) {
                    b0(sb2, 1, "consent_diagnostics", t5Var.g0());
                }
                if (t5Var.h1()) {
                    b0(sb2, 1, "target_os_version", Long.valueOf(t5Var.C2()));
                }
                if (ef.a() && d().I(t5Var.c0(), g0.V0)) {
                    b0(sb2, 1, "ad_services_version", Integer.valueOf(t5Var.n()));
                    if (t5Var.K0() && (l5VarI2 = t5Var.I2()) != null) {
                        X(sb2, 2);
                        sb2.append("attribution_eligibility_status {\n");
                        b0(sb2, 2, "eligible", Boolean.valueOf(l5VarI2.X()));
                        b0(sb2, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(l5VarI2.a0()));
                        b0(sb2, 2, "pre_r", Boolean.valueOf(l5VarI2.b0()));
                        b0(sb2, 2, "r_extensions_too_old", Boolean.valueOf(l5VarI2.c0()));
                        b0(sb2, 2, "adservices_extension_too_old", Boolean.valueOf(l5VarI2.U()));
                        b0(sb2, 2, "ad_storage_not_allowed", Boolean.valueOf(l5VarI2.S()));
                        b0(sb2, 2, "measurement_manager_disabled", Boolean.valueOf(l5VarI2.Z()));
                        X(sb2, 2);
                        sb2.append("}\n");
                    }
                }
                if (t5Var.A0()) {
                    com.google.android.gms.internal.measurement.j5 j5VarH2 = t5Var.H2();
                    X(sb2, 2);
                    sb2.append("ad_campaign_info {\n");
                    if (j5VarH2.n0()) {
                        b0(sb2, 2, "deep_link_gclid", j5VarH2.h0());
                    }
                    if (j5VarH2.m0()) {
                        b0(sb2, 2, "deep_link_gbraid", j5VarH2.g0());
                    }
                    if (j5VarH2.l0()) {
                        b0(sb2, 2, "deep_link_gad_source", j5VarH2.d0());
                    }
                    if (j5VarH2.o0()) {
                        b0(sb2, 2, "deep_link_session_millis", Long.valueOf(j5VarH2.K()));
                    }
                    if (j5VarH2.s0()) {
                        b0(sb2, 2, "market_referrer_gclid", j5VarH2.k0());
                    }
                    if (j5VarH2.r0()) {
                        b0(sb2, 2, "market_referrer_gbraid", j5VarH2.j0());
                    }
                    if (j5VarH2.q0()) {
                        b0(sb2, 2, "market_referrer_gad_source", j5VarH2.i0());
                    }
                    if (j5VarH2.p0()) {
                        b0(sb2, 2, "market_referrer_click_millis", Long.valueOf(j5VarH2.O()));
                    }
                    X(sb2, 2);
                    sb2.append("}\n");
                }
                if (t5Var.L0()) {
                    b0(sb2, 1, "batching_timestamp_millis", Long.valueOf(t5Var.b2()));
                }
                if (t5Var.f1()) {
                    com.google.android.gms.internal.measurement.x5 x5VarL2 = t5Var.L2();
                    X(sb2, 2);
                    sb2.append("sgtm_diagnostics {\n");
                    b0(sb2, 2, "upload_type", x5VarL2.R().name());
                    b0(sb2, 2, "client_upload_eligibility", x5VarL2.O().name());
                    b0(sb2, 2, "service_upload_eligibility", x5VarL2.Q().name());
                    X(sb2, 2);
                    sb2.append("}\n");
                }
                List<com.google.android.gms.internal.measurement.y5> listV0 = t5Var.v0();
                if (listV0 != null) {
                    for (com.google.android.gms.internal.measurement.y5 y5Var : listV0) {
                        if (y5Var != null) {
                            X(sb2, 2);
                            sb2.append("user_property {\n");
                            b0(sb2, 2, "set_timestamp_millis", y5Var.f0() ? Long.valueOf(y5Var.X()) : null);
                            b0(sb2, 2, "name", g().g(y5Var.a0()));
                            b0(sb2, 2, "string_value", y5Var.b0());
                            b0(sb2, 2, "int_value", y5Var.e0() ? Long.valueOf(y5Var.U()) : null);
                            b0(sb2, 2, "double_value", y5Var.c0() ? Double.valueOf(y5Var.K()) : null);
                            X(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.m5> listT0 = t5Var.t0();
                t5Var.c0();
                if (listT0 != null) {
                    for (com.google.android.gms.internal.measurement.m5 m5Var : listT0) {
                        if (m5Var != null) {
                            X(sb2, 2);
                            sb2.append("audience_membership {\n");
                            if (m5Var.U()) {
                                b0(sb2, 2, "audience_id", Integer.valueOf(m5Var.n()));
                            }
                            if (m5Var.W()) {
                                b0(sb2, 2, "new_audience", Boolean.valueOf(m5Var.T()));
                            }
                            a0(sb2, 2, "current_data", m5Var.R());
                            if (m5Var.X()) {
                                a0(sb2, 2, "previous_data", m5Var.S());
                            }
                            X(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.o5> listU0 = t5Var.u0();
                if (listU0 != null) {
                    for (com.google.android.gms.internal.measurement.o5 o5Var : listU0) {
                        if (o5Var != null) {
                            X(sb2, 2);
                            sb2.append("event {\n");
                            b0(sb2, 2, "name", g().c(o5Var.a0()));
                            if (o5Var.e0()) {
                                b0(sb2, 2, "timestamp_millis", Long.valueOf(o5Var.X()));
                            }
                            if (o5Var.d0()) {
                                b0(sb2, 2, "previous_timestamp_millis", Long.valueOf(o5Var.W()));
                            }
                            if (o5Var.c0()) {
                                b0(sb2, 2, "count", Integer.valueOf(o5Var.n()));
                            }
                            if (o5Var.T() != 0) {
                                c0(sb2, 2, o5Var.b0());
                            }
                            X(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                X(sb2, 1);
                sb2.append("}\n");
            }
        }
        sb2.append("} // End-of-batch\n");
        return sb2.toString();
    }

    final List<Long> Q(List<Long> list, List<Integer> list2) {
        int i10;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                l().M().b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    l().M().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i10);
    }

    final Map<String, Object> R(Bundle bundle, boolean z10) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z11 = obj instanceof Parcelable[];
            if (z11 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z10) {
                    ArrayList arrayList = new ArrayList();
                    if (z11) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(R((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj2 = arrayList2.get(i10);
                            i10++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(R((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(R((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    final boolean d0(long j10, long j11) {
        return j10 == 0 || j11 <= 0 || Math.abs(c().a() - j10) > j11;
    }

    final byte[] i0(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            l().H().b("Failed to gzip content", e10);
            throw e10;
        }
    }

    final byte[] k0(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i10 = gZIPInputStream.read(bArr2);
                if (i10 <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i10);
            }
        } catch (IOException e10) {
            l().H().b("Failed to ungzip content", e10);
            throw e10;
        }
    }

    final List<Integer> l0() {
        Map<String, String> mapE = g0.e(this.f4241b.b());
        if (mapE == null || mapE.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = g0.f3560e0.a(null).intValue();
        for (Map.Entry<String, String> entry : mapE.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i10 = Integer.parseInt(entry.getValue());
                    if (i10 != 0) {
                        arrayList.add(Integer.valueOf(i10));
                        if (arrayList.size() >= iIntValue) {
                            l().M().b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e10) {
                    l().M().b("Experiment ID NumberFormatException", e10);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    sc(gc gcVar) {
        super(gcVar);
    }

    static com.google.android.gms.internal.measurement.q5 G(com.google.android.gms.internal.measurement.o5 o5Var, String str) {
        for (com.google.android.gms.internal.measurement.q5 q5Var : o5Var.b0()) {
            if (q5Var.c0().equals(str)) {
                return q5Var;
            }
        }
        return null;
    }

    static <BuilderT extends com.google.android.gms.internal.measurement.nb> BuilderT H(BuilderT buildert, byte[] bArr) {
        com.google.android.gms.internal.measurement.q9 q9VarA = com.google.android.gms.internal.measurement.q9.a();
        if (q9VarA != null) {
            return (BuilderT) buildert.V(bArr, q9VarA);
        }
        return (BuilderT) buildert.P(bArr);
    }

    static Object K(com.google.android.gms.internal.measurement.o5 o5Var, String str, Object obj) {
        Object objG0 = g0(o5Var, str);
        if (objG0 == null) {
            return obj;
        }
        return objG0;
    }

    static List<Long> P(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 << 6) + i11;
                if (i12 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i12)) {
                    j10 |= 1 << i11;
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    private static void S(Uri.Builder builder, String str, String str2, Set<String> set) {
        if (!set.contains(str) && !TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    static void U(com.google.android.gms.internal.measurement.o5.a aVar, String str, Object obj) {
        List<com.google.android.gms.internal.measurement.q5> listO = aVar.O();
        int i10 = 0;
        while (true) {
            if (i10 < listO.size()) {
                if (str.equals(listO.get(i10).c0())) {
                    break;
                } else {
                    i10++;
                }
            } else {
                i10 = -1;
                break;
            }
        }
        com.google.android.gms.internal.measurement.q5.a aVarC = com.google.android.gms.internal.measurement.q5.a0().C(str);
        if (obj instanceof Long) {
            aVarC.y(((Long) obj).longValue());
        } else if (obj instanceof String) {
            aVarC.E((String) obj);
        } else if (obj instanceof Double) {
            aVarC.x(((Double) obj).doubleValue());
        }
        if (i10 >= 0) {
            aVar.y(i10, aVarC);
        } else {
            aVar.C(aVarC);
        }
    }

    @WorkerThread
    static boolean e0(zzbj zzbjVar, zzq zzqVar) {
        m1.g.k(zzbjVar);
        m1.g.k(zzqVar);
        if (TextUtils.isEmpty(zzqVar.f4323b) && TextUtils.isEmpty(zzqVar.f4337p)) {
            return false;
        }
        return true;
    }

    static boolean f0(List<Long> list, int i10) {
        if (i10 < (list.size() << 6)) {
            if (((1 << (i10 % 64)) & list.get(i10 / 64).longValue()) != 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    static Object g0(com.google.android.gms.internal.measurement.o5 o5Var, String str) {
        com.google.android.gms.internal.measurement.q5 q5VarG = G(o5Var, str);
        if (q5VarG != null) {
            if (q5VarG.j0()) {
                return q5VarG.d0();
            }
            if (q5VarG.h0()) {
                return Long.valueOf(q5VarG.Y());
            }
            if (q5VarG.f0()) {
                return Double.valueOf(q5VarG.K());
            }
            if (q5VarG.W() > 0) {
                return j0(q5VarG.e0());
            }
            return null;
        }
        return null;
    }

    final long A(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return B(str.getBytes(Charset.forName("UTF-8")));
    }

    @WorkerThread
    final long B(byte[] bArr) {
        m1.g.k(bArr);
        j().n();
        MessageDigest messageDigestU0 = wc.U0();
        if (messageDigestU0 == null) {
            l().H().a("Failed to get MD5");
            return 0L;
        }
        return wc.C(messageDigestU0.digest(bArr));
    }

    final com.google.android.gms.internal.measurement.o5 F(d0 d0Var) {
        com.google.android.gms.internal.measurement.o5.a aVarA = com.google.android.gms.internal.measurement.o5.Y().A(d0Var.f3476e);
        for (String str : d0Var.f3477f) {
            com.google.android.gms.internal.measurement.q5.a aVarC = com.google.android.gms.internal.measurement.q5.a0().C(str);
            Object objI0 = d0Var.f3477f.i0(str);
            m1.g.k(objI0);
            V(aVarC, objI0);
            aVarA.C(aVarC);
        }
        if (!TextUtils.isEmpty(d0Var.f3474c) && d0Var.f3477f.i0("_o") == null) {
            aVarA.D((com.google.android.gms.internal.measurement.q5) ((com.google.android.gms.internal.measurement.ea) com.google.android.gms.internal.measurement.q5.a0().C("_o").E(d0Var.f3474c).w()));
        }
        return (com.google.android.gms.internal.measurement.o5) ((com.google.android.gms.internal.measurement.ea) aVarA.w());
    }

    final zzbj I(com.google.android.gms.internal.measurement.e eVar) {
        String string;
        Object obj;
        Bundle bundleD = D(eVar.g(), true);
        if (bundleD.containsKey("_o") && (obj = bundleD.get("_o")) != null) {
            string = obj.toString();
        } else {
            string = "app";
        }
        String str = string;
        String strB = b2.j0.b(eVar.e());
        if (strB == null) {
            strB = eVar.e();
        }
        return new zzbj(strB, new zzbi(bundleD), str, eVar.a());
    }

    @TargetApi(30)
    final zzow J(String str, com.google.android.gms.internal.measurement.t5.a aVar, com.google.android.gms.internal.measurement.o5.a aVar2, String str2) {
        int iIndexOf;
        if (ef.a() && d().I(str, g0.V0)) {
            long jA = c().a();
            String[] strArrSplit = d().G(str, g0.f3602t0).split(",");
            HashSet hashSet = new HashSet(strArrSplit.length);
            for (String str3 : strArrSplit) {
                Objects.requireNonNull(str3);
                if (!hashSet.add(str3)) {
                    throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
                }
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
            ec ecVarU = u();
            String strU = ecVarU.s().U(str);
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(ecVarU.d().G(str, g0.f3584m0));
            if (!TextUtils.isEmpty(strU)) {
                builder.authority(strU + "." + ecVarU.d().G(str, g0.f3587n0));
            } else {
                builder.authority(ecVarU.d().G(str, g0.f3587n0));
            }
            builder.path(ecVarU.d().G(str, g0.f3590o0));
            S(builder, "gmp_app_id", aVar.r1(), setUnmodifiableSet);
            S(builder, "gmp_version", "118003", setUnmodifiableSet);
            String strO1 = aVar.o1();
            i iVarD = d();
            f5<Boolean> f5Var = g0.Y0;
            if (iVarD.I(str, f5Var) && s().d0(str)) {
                strO1 = "";
            }
            S(builder, "app_instance_id", strO1, setUnmodifiableSet);
            S(builder, "rdid", aVar.Q(), setUnmodifiableSet);
            S(builder, "bundle_id", aVar.n1(), setUnmodifiableSet);
            String strN = aVar2.N();
            String strA = b2.j0.a(strN);
            if (!TextUtils.isEmpty(strA)) {
                strN = strA;
            }
            S(builder, "app_event_name", strN, setUnmodifiableSet);
            S(builder, "app_version", String.valueOf(aVar.Y()), setUnmodifiableSet);
            String strS1 = aVar.s1();
            if (d().I(str, f5Var) && s().h0(str) && !TextUtils.isEmpty(strS1) && (iIndexOf = strS1.indexOf(".")) != -1) {
                strS1 = strS1.substring(0, iIndexOf);
            }
            S(builder, "os_version", strS1, setUnmodifiableSet);
            S(builder, "timestamp", String.valueOf(aVar2.K()), setUnmodifiableSet);
            String str4 = "1";
            if (aVar.W()) {
                S(builder, "lat", "1", setUnmodifiableSet);
            }
            S(builder, "privacy_sandbox_version", String.valueOf(aVar.v()), setUnmodifiableSet);
            S(builder, "trigger_uri_source", "1", setUnmodifiableSet);
            S(builder, "trigger_uri_timestamp", String.valueOf(jA), setUnmodifiableSet);
            S(builder, "request_uuid", str2, setUnmodifiableSet);
            List<com.google.android.gms.internal.measurement.q5> listO = aVar2.O();
            Bundle bundle = new Bundle();
            for (com.google.android.gms.internal.measurement.q5 q5Var : listO) {
                String strC0 = q5Var.c0();
                if (q5Var.f0()) {
                    bundle.putString(strC0, String.valueOf(q5Var.K()));
                } else if (q5Var.g0()) {
                    bundle.putString(strC0, String.valueOf(q5Var.S()));
                } else if (q5Var.j0()) {
                    bundle.putString(strC0, q5Var.d0());
                } else if (q5Var.h0()) {
                    bundle.putString(strC0, String.valueOf(q5Var.Y()));
                }
            }
            T(builder, d().G(str, g0.f3600s0).split("\\|"), bundle, setUnmodifiableSet);
            List<com.google.android.gms.internal.measurement.y5> listT = aVar.T();
            Bundle bundle2 = new Bundle();
            for (com.google.android.gms.internal.measurement.y5 y5Var : listT) {
                String strA0 = y5Var.a0();
                if (y5Var.c0()) {
                    bundle2.putString(strA0, String.valueOf(y5Var.K()));
                } else if (y5Var.d0()) {
                    bundle2.putString(strA0, String.valueOf(y5Var.Q()));
                } else if (y5Var.g0()) {
                    bundle2.putString(strA0, y5Var.b0());
                } else if (y5Var.e0()) {
                    bundle2.putString(strA0, String.valueOf(y5Var.U()));
                }
            }
            T(builder, d().G(str, g0.f3598r0).split("\\|"), bundle2, setUnmodifiableSet);
            if (!aVar.U()) {
                str4 = "0";
            }
            S(builder, "dma", str4, setUnmodifiableSet);
            if (!aVar.q1().isEmpty()) {
                S(builder, "dma_cps", aVar.q1(), setUnmodifiableSet);
            }
            if (d().u(g0.f3549a1) && aVar.X()) {
                com.google.android.gms.internal.measurement.j5 j5VarZ0 = aVar.z0();
                if (!j5VarZ0.h0().isEmpty()) {
                    S(builder, "dl_gclid", j5VarZ0.h0(), setUnmodifiableSet);
                }
                if (!j5VarZ0.g0().isEmpty()) {
                    S(builder, "dl_gbraid", j5VarZ0.g0(), setUnmodifiableSet);
                }
                if (!j5VarZ0.d0().isEmpty()) {
                    S(builder, "dl_gs", j5VarZ0.d0(), setUnmodifiableSet);
                }
                if (j5VarZ0.K() > 0) {
                    S(builder, "dl_ss_ts", String.valueOf(j5VarZ0.K()), setUnmodifiableSet);
                }
                if (!j5VarZ0.k0().isEmpty()) {
                    S(builder, "mr_gclid", j5VarZ0.k0(), setUnmodifiableSet);
                }
                if (!j5VarZ0.j0().isEmpty()) {
                    S(builder, "mr_gbraid", j5VarZ0.j0(), setUnmodifiableSet);
                }
                if (!j5VarZ0.i0().isEmpty()) {
                    S(builder, "mr_gs", j5VarZ0.i0(), setUnmodifiableSet);
                }
                if (j5VarZ0.O() > 0) {
                    S(builder, "mr_click_ts", String.valueOf(j5VarZ0.O()), setUnmodifiableSet);
                }
            }
            return new zzow(builder.build().toString(), jA, 1);
        }
        return null;
    }

    final void V(com.google.android.gms.internal.measurement.q5.a aVar, Object obj) {
        m1.g.k(obj);
        aVar.H().F().D().G();
        if (obj instanceof String) {
            aVar.E((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.y(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            aVar.x(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    com.google.android.gms.internal.measurement.q5.a aVarA0 = com.google.android.gms.internal.measurement.q5.a0();
                    for (String str : bundle.keySet()) {
                        com.google.android.gms.internal.measurement.q5.a aVarC = com.google.android.gms.internal.measurement.q5.a0().C(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            aVarC.y(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            aVarC.E((String) obj2);
                        } else if (obj2 instanceof Double) {
                            aVarC.x(((Double) obj2).doubleValue());
                        }
                        aVarA0.z(aVarC);
                    }
                    if (aVarA0.v() > 0) {
                        arrayList.add((com.google.android.gms.internal.measurement.q5) ((com.google.android.gms.internal.measurement.ea) aVarA0.w()));
                    }
                }
            }
            aVar.A(arrayList);
            return;
        }
        l().H().b("Ignoring invalid (type) event param value", obj);
    }

    final void W(com.google.android.gms.internal.measurement.y5.a aVar, Object obj) {
        m1.g.k(obj);
        aVar.E().A().v();
        if (obj instanceof String) {
            aVar.D((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.y(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.x(((Double) obj).doubleValue());
        } else {
            l().H().b("Ignoring invalid (type) user attribute value", obj);
        }
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
}
