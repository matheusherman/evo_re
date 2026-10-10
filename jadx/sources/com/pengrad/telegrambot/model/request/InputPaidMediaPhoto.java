package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
import com.pengrad.telegrambot.request.ContentTypes;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputPaidMediaPhoto extends InputPaidMedia implements Serializable {
    private static final long serialVersionUID = 1;

    public InputPaidMediaPhoto(String str) {
        super(PaidMediaPhoto.TYPE, str);
    }

    public InputPaidMediaPhoto(File file) {
        super(PaidMediaPhoto.TYPE, file);
    }

    @Override // com.pengrad.telegrambot.model.request.InputPaidMedia
    public String getDefaultContentType() {
        return ContentTypes.PHOTO_MIME_TYPE;
    }

    @Override // com.pengrad.telegrambot.model.request.InputPaidMedia
    public String getDefaultFileName() {
        return ContentTypes.PHOTO_FILE_NAME;
    }

    public InputPaidMediaPhoto(byte[] bArr) {
        super(PaidMediaPhoto.TYPE, bArr);
    }
}
