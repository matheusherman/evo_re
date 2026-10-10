package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.InlineQueryResult;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class InlineQueryResult<T extends InlineQueryResult<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    private MessageEntity[] caption_entities;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f8245id;
    private InputMessageContent input_message_content;
    private InlineKeyboardMarkup reply_markup;
    private Boolean show_caption_above_media;
    private final T thisAsT = this;
    private String type;

    public T captionEntities(MessageEntity... messageEntityArr) {
        this.caption_entities = messageEntityArr;
        return this.thisAsT;
    }

    public T inputMessageContent(InputMessageContent inputMessageContent) {
        this.input_message_content = inputMessageContent;
        return this.thisAsT;
    }

    public T replyMarkup(InlineKeyboardMarkup inlineKeyboardMarkup) {
        this.reply_markup = inlineKeyboardMarkup;
        return this.thisAsT;
    }

    public T showCaptionAboveMedia(Boolean bool) {
        this.show_caption_above_media = bool;
        return this.thisAsT;
    }

    public InlineQueryResult(String str, String str2) {
        this.type = str;
        this.f8245id = str2;
    }
}
