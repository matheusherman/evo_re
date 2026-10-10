package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputMediaDocument extends InputMedia<InputMediaDocument> implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean disable_content_type_detection;

    public InputMediaDocument(String str) {
        super("document", str);
    }

    public InputMediaDocument(File file) {
        super("document", file);
    }

    @Override // com.pengrad.telegrambot.model.request.InputMedia
    public String getDefaultContentType() {
        return ContentTypes.DOC_MIME_TYPE;
    }

    @Override // com.pengrad.telegrambot.model.request.InputMedia
    public String getDefaultFileName() {
        return "file.txt";
    }

    public InputMediaDocument(byte[] bArr) {
        super("document", bArr);
    }

    public InputMediaDocument disableContentTypeDetection(boolean z10) {
        this.disable_content_type_detection = Boolean.valueOf(z10);
        return this;
    }
}
