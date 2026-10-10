package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.CreateForumTopicResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CreateForumTopic extends BaseRequest<CreateForumTopic, CreateForumTopicResponse> {
    public CreateForumTopic(Long l10, String str) {
        this(l10.toString(), str);
    }

    public CreateForumTopic(String str, String str2) {
        super(CreateForumTopicResponse.class);
        add("chat_id", str);
        add("name", str2);
    }

    public CreateForumTopic iconColor(Integer num) {
        add("icon_color", num);
        return this;
    }

    public CreateForumTopic iconCustomEmojiId(String str) {
        add("icon_custom_emoji_id", str);
        return this;
    }
}
