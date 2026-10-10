package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.Sticker;
import com.pengrad.telegrambot.model.request.InputSticker;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CreateNewStickerSet extends BaseRequest<CreateNewStickerSet, BaseResponse> {
    @Override // com.pengrad.telegrambot.request.BaseRequest
    public boolean isMultipart() {
        return true;
    }

    public CreateNewStickerSet(Long l10, String str, String str2, InputSticker[] inputStickerArr) {
        super(BaseResponse.class);
        add("user_id", l10);
        add("name", str);
        add("title", str2);
        add("stickers", inputStickerArr);
        for (InputSticker inputSticker : inputStickerArr) {
            if (inputSticker.getAttachment() != null) {
                add(inputSticker.getAttachName(), inputSticker.getAttachment());
            }
        }
    }

    public CreateNewStickerSet needsRepainting(boolean z10) {
        return add("needs_repainting", Boolean.valueOf(z10));
    }

    public CreateNewStickerSet stickerType(Sticker.Type type) {
        return add("sticker_type", type.name());
    }
}
