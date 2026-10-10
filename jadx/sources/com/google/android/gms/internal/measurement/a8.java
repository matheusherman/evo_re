package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a8 extends s7<Boolean> {
    a8(b8 b8Var, String str, Boolean bool, boolean z10) {
        super(b8Var, str, bool, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.s7
    final /* synthetic */ Boolean h(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (o6.f2913c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (o6.f2914d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + super.k() + ": " + String.valueOf(obj));
        return null;
    }
}
