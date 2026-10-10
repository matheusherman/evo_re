package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.Sticker;
import com.pengrad.telegrambot.response.GetFileResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UploadStickerFile extends AbstractUploadRequest<UploadStickerFile, GetFileResponse> {
    public UploadStickerFile(Long l10, Object obj, Sticker.Format format) {
        super(GetFileResponse.class, "sticker", obj);
        add("user_id", l10);
        add("sticker_format", format.name().toLowerCase());
    }
}
