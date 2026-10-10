package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class f implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0046b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0046b c0046b = new DynamiteModule.b.C0046b();
        int iA = aVar.a(context, str, false);
        c0046b.f2518b = iA;
        c0046b.f2519c = iA != 0 ? 1 : 0;
        return c0046b;
    }

    f() {
    }
}
