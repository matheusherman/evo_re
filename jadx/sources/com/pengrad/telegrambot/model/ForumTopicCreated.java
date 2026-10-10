package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ForumTopicCreated implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer icon_color;
    private String icon_custom_emoji_id;
    private String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ForumTopicCreated forumTopicCreated = (ForumTopicCreated) obj;
            if (Objects.equals(this.name, forumTopicCreated.name) && Objects.equals(this.icon_color, forumTopicCreated.icon_color) && Objects.equals(this.icon_custom_emoji_id, forumTopicCreated.icon_custom_emoji_id)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.icon_color, this.icon_custom_emoji_id);
    }

    public Integer iconColor() {
        return this.icon_color;
    }

    public String iconCustomEmojiId() {
        return this.icon_custom_emoji_id;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        return "ForumTopicCreated{name='" + this.name + "', icon_color=" + this.icon_color + ", icon_custom_emoji_id='" + this.icon_custom_emoji_id + "'}";
    }
}
