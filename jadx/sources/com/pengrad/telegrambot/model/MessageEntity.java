package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 0;
    private String custom_emoji_id;
    private String language;
    private Integer length;
    private Integer offset;
    private Type type;
    private String url;
    private User user;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Type {
        mention,
        hashtag,
        cashtag,
        bot_command,
        url,
        email,
        phone_number,
        bold,
        italic,
        code,
        pre,
        text_link,
        text_mention,
        underline,
        strikethrough,
        spoiler,
        custom_emoji,
        blockquote,
        expandable_blockquote
    }

    private MessageEntity() {
    }

    public String customEmojiId() {
        return this.custom_emoji_id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageEntity messageEntity = (MessageEntity) obj;
            if (this.type == messageEntity.type && Objects.equals(this.offset, messageEntity.offset) && Objects.equals(this.length, messageEntity.length) && Objects.equals(this.url, messageEntity.url) && Objects.equals(this.user, messageEntity.user) && Objects.equals(this.language, messageEntity.language) && Objects.equals(this.custom_emoji_id, messageEntity.custom_emoji_id)) {
                return true;
            }
        }
        return false;
    }

    public String language() {
        return this.language;
    }

    public String url() {
        return this.url;
    }

    public User user() {
        return this.user;
    }

    public MessageEntity(Type type, Integer num, Integer num2) {
        this.type = type;
        this.offset = num;
        this.length = num2;
    }

    public MessageEntity customEmojiId(String str) {
        this.custom_emoji_id = str;
        return this;
    }

    public int hashCode() {
        return Objects.hash(this.type, this.offset, this.length, this.url, this.user, this.language, this.custom_emoji_id);
    }

    public MessageEntity language(String str) {
        this.language = str;
        return this;
    }

    public Integer length() {
        return this.length;
    }

    public Integer offset() {
        return this.offset;
    }

    public String toString() {
        return "MessageEntity{type=" + this.type + ", offset=" + this.offset + ", length=" + this.length + ", url='" + this.url + "', user=" + this.user + ", language='" + this.language + "', custom_emoji_id='" + this.custom_emoji_id + "'}";
    }

    public Type type() {
        return this.type;
    }

    public MessageEntity url(String str) {
        this.url = str;
        return this;
    }

    public MessageEntity user(User user) {
        this.user = user;
        return this;
    }
}
