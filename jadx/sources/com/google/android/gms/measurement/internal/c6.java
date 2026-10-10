package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.ef;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f3452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f3453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ a6 f3454d;

    public c6(a6 a6Var, String str, Bundle bundle) {
        this.f3454d = a6Var;
        m1.g.e(str);
        this.f3451a = str;
        this.f3452b = new Bundle();
    }

    private final String c(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    if (ef.a() && this.f3454d.d().u(g0.W0)) {
                        if (obj instanceof String) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "d");
                        } else {
                            this.f3454d.l().H().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } else {
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.f3454d.l().H().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e10) {
                    this.f3454d.l().H().b("Cannot serialize bundle value to SharedPreferences", e10);
                }
            }
        }
        return jSONArray.toString();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0100 A[Catch: NumberFormatException | JSONException -> 0x0110, NumberFormatException | JSONException -> 0x0110, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x0110, blocks: (B:9:0x0025, B:21:0x0051, B:21:0x0051, B:23:0x0059, B:23:0x0059, B:25:0x005f, B:25:0x005f, B:27:0x006d, B:27:0x006d, B:29:0x007f, B:29:0x007f, B:30:0x0088, B:30:0x0088, B:50:0x0100, B:50:0x0100, B:31:0x008d, B:31:0x008d, B:33:0x0095, B:33:0x0095, B:35:0x009b, B:35:0x009b, B:37:0x00a9, B:37:0x00a9, B:39:0x00bb, B:39:0x00bb, B:40:0x00c4, B:40:0x00c4, B:41:0x00c8, B:41:0x00c8, B:43:0x00d0, B:43:0x00d0, B:44:0x00d8, B:44:0x00d8, B:46:0x00e0, B:46:0x00e0, B:47:0x00ec, B:47:0x00ec, B:49:0x00f4, B:49:0x00f4), top: B:64:0x0025, outer: #0 }] */
    @WorkerThread
    public final Bundle a() {
        if (this.f3453c == null) {
            String string = this.f3454d.L().getString(this.f3451a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i10);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int iHashCode = string3.hashCode();
                            if (iHashCode != 100) {
                                if (iHashCode != 108) {
                                    if (iHashCode != 115) {
                                        if (iHashCode != 3352) {
                                            if (iHashCode != 3445 || !string3.equals("la")) {
                                                this.f3454d.l().H().b("Unrecognized persisted bundle type. Type", string3);
                                            } else if (ef.a() && this.f3454d.d().u(g0.W0)) {
                                                JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                                int length = jSONArray2.length();
                                                long[] jArr = new long[length];
                                                for (int i11 = 0; i11 < length; i11++) {
                                                    jArr[i11] = jSONArray2.optLong(i11);
                                                }
                                                bundle.putLongArray(string2, jArr);
                                            }
                                        } else if (!string3.equals("ia")) {
                                            this.f3454d.l().H().b("Unrecognized persisted bundle type. Type", string3);
                                        } else if (ef.a() && this.f3454d.d().u(g0.W0)) {
                                            JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                            int length2 = jSONArray3.length();
                                            int[] iArr = new int[length2];
                                            for (int i12 = 0; i12 < length2; i12++) {
                                                iArr[i12] = jSONArray3.optInt(i12);
                                            }
                                            bundle.putIntArray(string2, iArr);
                                        }
                                    } else if (string3.equals("s")) {
                                        bundle.putString(string2, jSONObject.getString("v"));
                                    } else {
                                        this.f3454d.l().H().b("Unrecognized persisted bundle type. Type", string3);
                                    }
                                } else if (string3.equals("l")) {
                                    bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                                } else {
                                    this.f3454d.l().H().b("Unrecognized persisted bundle type. Type", string3);
                                }
                            } else if (string3.equals("d")) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else {
                                this.f3454d.l().H().b("Unrecognized persisted bundle type. Type", string3);
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f3454d.l().H().a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f3453c = bundle;
                } catch (JSONException unused2) {
                    this.f3454d.l().H().a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f3453c == null) {
                this.f3453c = this.f3452b;
            }
        }
        return new Bundle((Bundle) m1.g.k(this.f3453c));
    }

    @WorkerThread
    public final void b(Bundle bundle) {
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        SharedPreferences.Editor editorEdit = this.f3454d.L().edit();
        if (bundle2.size() == 0) {
            editorEdit.remove(this.f3451a);
        } else {
            editorEdit.putString(this.f3451a, c(bundle2));
        }
        editorEdit.apply();
        this.f3453c = bundle2;
    }
}
