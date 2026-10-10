package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class y8 implements Comparator<v8> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(v8 v8Var, v8 v8Var2) {
        v8 v8Var3 = v8Var;
        v8 v8Var4 = v8Var2;
        c9 c9Var = (c9) v8Var3.iterator();
        c9 c9Var2 = (c9) v8Var4.iterator();
        while (c9Var.hasNext() && c9Var2.hasNext()) {
            int iCompare = Integer.compare(v8.g(c9Var.b()), v8.g(c9Var2.b()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(v8Var3.r(), v8Var4.r());
    }

    y8() {
    }
}
