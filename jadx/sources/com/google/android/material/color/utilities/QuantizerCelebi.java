package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerCelebi {
    public static Map<Integer, Integer> quantize(int[] iArr, int i10) {
        Set<Integer> setKeySet = new QuantizerWu().quantize(iArr, i10).colorToCount.keySet();
        int[] iArr2 = new int[setKeySet.size()];
        Iterator<Integer> it = setKeySet.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            iArr2[i11] = it.next().intValue();
            i11++;
        }
        return QuantizerWsmeans.quantize(iArr, iArr2, i10);
    }

    private QuantizerCelebi() {
    }
}
