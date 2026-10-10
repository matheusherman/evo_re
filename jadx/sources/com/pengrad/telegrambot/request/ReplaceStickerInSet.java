package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InputSticker;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ReplaceStickerInSet extends BaseRequest<ReplaceStickerInSet, BaseResponse> {
    public ReplaceStickerInSet(Long l10, String str, String str2, InputSticker inputSticker) {
        super(BaseResponse.class);
        add("user_id", l10);
        add("name", str);
        add("old_sticker", str2);
        add("sticker", inputSticker);
    }
}
