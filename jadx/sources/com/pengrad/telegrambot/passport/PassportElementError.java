package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class PassportElementError implements Serializable {
    private static final long serialVersionUID = 0;
    private final String message;
    private final String source;
    private final String type;

    public PassportElementError(String str, String str2, String str3) {
        this.source = str;
        this.type = str2;
        this.message = str3;
    }
}
