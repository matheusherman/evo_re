package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.xd;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class m6 implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ j6 f3806b;

    m6(j6 j6Var, String str) {
        this.f3805a = str;
        this.f3806b = j6Var;
    }

    @Override // com.google.android.gms.internal.measurement.xd
    public final String i(String str) {
        Map map = (Map) this.f3806b.f3729d.get(this.f3805a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
