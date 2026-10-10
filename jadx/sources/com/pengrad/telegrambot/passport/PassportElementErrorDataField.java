package com.pengrad.telegrambot.passport;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PassportElementErrorDataField extends PassportElementError {
    private static final long serialVersionUID = 0;
    private final String data_hash;
    private final String field_name;

    public PassportElementErrorDataField(String str, String str2, String str3, String str4) {
        super("data", str, str4);
        this.field_name = str2;
        this.data_hash = str3;
    }
}
