package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InputSticker;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class AddStickerToSet extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {
    public AddStickerToSet(Long l10, String str, InputSticker inputSticker) {
        super(BaseResponse.class, attachName(inputSticker), attachment(inputSticker));
        add("user_id", l10);
        add("name", str);
        add("sticker", inputSticker);
    }

    private static String attachName(InputSticker inputSticker) {
        if (inputSticker.getAttachment() != null) {
            return inputSticker.getAttachName();
        }
        return "sticker_id";
    }

    private static Object attachment(InputSticker inputSticker) {
        if (inputSticker.getAttachment() != null) {
            return inputSticker.getAttachment();
        }
        return "sticker_id";
    }
}
