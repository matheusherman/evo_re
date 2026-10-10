package com.ta.utdid2.device;

import m7.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f8383d = -1;

    static boolean a(int i10) {
        return i10 >= 0 && i10 != 10012;
    }

    static b a(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("code")) {
                bVar.f8383d = jSONObject2.getInt("code");
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null && jSONObject.has("utdid")) {
                String string = jSONObject.getString("utdid");
                if (d.m95c(string)) {
                    l7.e.b(string);
                }
            }
            f.e("BizResponse", "content", str);
            return bVar;
        } catch (JSONException e10) {
            f.e("", e10.toString());
            return bVar;
        }
    }

    b() {
    }
}
