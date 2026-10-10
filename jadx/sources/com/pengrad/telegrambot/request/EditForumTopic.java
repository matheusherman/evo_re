package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EditForumTopic extends BaseRequest<EditForumTopic, BaseResponse> {
    public EditForumTopic(Long l10, Integer num) {
        this(l10.toString(), num);
    }

    public EditForumTopic(String str, Integer num) {
        super(BaseResponse.class);
        add("chat_id", str);
        add("message_thread_id", num);
    }

    public EditForumTopic iconCustomEmojiId(String str) {
        add("icon_custom_emoji_id", str);
        return this;
    }

    public EditForumTopic name(String str) {
        add("name", str);
        return this;
    }

    public EditForumTopic(Long l10, Integer num, String str, String str2) {
        this(l10.toString(), num, str, str2);
    }

    public EditForumTopic(String str, Integer num, String str2, String str3) {
        super(BaseResponse.class);
        add("chat_id", str);
        add("message_thread_id", num);
        add("name", str2);
        add("icon_custom_emoji_id", str3);
    }
}
