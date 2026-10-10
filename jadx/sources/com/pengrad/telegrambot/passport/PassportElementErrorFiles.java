package com.pengrad.telegrambot.passport;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PassportElementErrorFiles extends PassportElementError {
    private static final long serialVersionUID = 0;
    private String[] file_hashes;

    public PassportElementErrorFiles(String str, String[] strArr, String str2) {
        super("files", str, str2);
        this.file_hashes = strArr;
    }
}
