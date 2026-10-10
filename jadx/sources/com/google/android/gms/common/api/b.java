package com.google.android.gms.common.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b extends Exception {

    @NonNull
    @Deprecated
    protected final Status mStatus;

    @NonNull
    public Status a() {
        return this.mStatus;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(@NonNull Status status) {
        String strP;
        int iM = status.M();
        if (status.P() != null) {
            strP = status.P();
        } else {
            strP = "";
        }
        super(iM + ": " + strP);
        this.mStatus = status;
    }
}
