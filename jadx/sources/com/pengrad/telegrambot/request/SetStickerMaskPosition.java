package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetStickerMaskPosition extends BaseRequest<SetStickerMaskPosition, BaseResponse> {
    public SetStickerMaskPosition(String str) {
        super(BaseResponse.class);
        add("sticker", str);
    }

    public SetStickerMaskPosition maskPosition(MaskPosition maskPosition) {
        add("mask_position", maskPosition);
        return this;
    }
}
