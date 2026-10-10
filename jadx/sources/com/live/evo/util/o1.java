package com.live.evo.util;

import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o1 {
    public static SimpleDateFormat a(@NonNull String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(l.d().c());
        return simpleDateFormat;
    }
}
