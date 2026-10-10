package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class h implements DynamiteModule.b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0046b a(Context context, String str, DynamiteModule.b.a aVar) {
        int iA;
        DynamiteModule.b.C0046b c0046b = new DynamiteModule.b.C0046b();
        int iB = aVar.b(context, str);
        c0046b.f2517a = iB;
        int i10 = 1;
        int i11 = 0;
        if (iB != 0) {
            iA = aVar.a(context, str, false);
            c0046b.f2518b = iA;
        } else {
            iA = aVar.a(context, str, true);
            c0046b.f2518b = iA;
        }
        int i12 = c0046b.f2517a;
        if (i12 == 0) {
            if (iA == 0) {
                i10 = 0;
            }
            c0046b.f2519c = i10;
            return c0046b;
        }
        i11 = i12;
        if (i11 >= iA) {
            i10 = -1;
        }
        c0046b.f2519c = i10;
        return c0046b;
    }

    h() {
    }
}
