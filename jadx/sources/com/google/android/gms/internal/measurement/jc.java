package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class jc extends gc {
    jc() {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.gc
    public final void m() {
        if (!o()) {
            for (int i10 = 0; i10 < a(); i10++) {
                Map.Entry entryF = f(i10);
                if (((z9) entryF.getKey()).g()) {
                    entryF.setValue(Collections.unmodifiableList((List) entryF.getValue()));
                }
            }
            for (Map.Entry entry : h()) {
                if (((z9) entry.getKey()).g()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.m();
    }
}
