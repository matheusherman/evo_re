package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.Sticker;
import com.pengrad.telegrambot.response.BaseResponse;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetStickerSetThumbnail extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {
    public SetStickerSetThumbnail(String str, Long l10, Object obj, Sticker.Format format) {
        super(BaseResponse.class, "thumbnail", obj);
        add("name", str);
        add("user_id", l10);
        add(IjkMediaMeta.IJKM_KEY_FORMAT, format);
    }

    public SetStickerSetThumbnail(String str, Long l10, Sticker.Format format) {
        super(BaseResponse.class, "name", str);
        add("user_id", l10);
        add(IjkMediaMeta.IJKM_KEY_FORMAT, format);
    }
}
