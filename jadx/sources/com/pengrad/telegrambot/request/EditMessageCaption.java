package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EditMessageCaption extends BaseRequest<EditMessageCaption, BaseResponse> {
    public EditMessageCaption(Object obj, int i10) {
        super(SendResponse.class);
        add("chat_id", obj).add("message_id", Integer.valueOf(i10));
    }

    public EditMessageCaption businessConnectionId(String str) {
        return add("business_connection_id", str);
    }

    public EditMessageCaption caption(String str) {
        return add("caption", str);
    }

    public EditMessageCaption captionEntities(MessageEntity... messageEntityArr) {
        return add("caption_entities", messageEntityArr);
    }

    public EditMessageCaption parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public EditMessageCaption replyMarkup(InlineKeyboardMarkup inlineKeyboardMarkup) {
        return add("reply_markup", inlineKeyboardMarkup);
    }

    public EditMessageCaption showCaptionAboveMedia(Boolean bool) {
        return add("show_caption_above_media", bool);
    }

    public EditMessageCaption(String str) {
        super(BaseResponse.class);
        add("inline_message_id", str);
    }
}
