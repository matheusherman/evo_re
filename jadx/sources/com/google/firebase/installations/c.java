package com.google.firebase.installations;

import androidx.annotation.NonNull;
import j2.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class c extends k {

    @NonNull
    private final a status;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public c(@NonNull a aVar) {
        this.status = aVar;
    }

    public c(@NonNull String str, @NonNull a aVar) {
        super(str);
        this.status = aVar;
    }
}
