package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatShared implements Serializable {
    private static final long serialVersionUID = 0;
    private Long chat_id;
    private PhotoSize[] photo;
    private Integer request_id;
    private String title;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatShared chatShared = (ChatShared) obj;
            if (Objects.equals(this.request_id, chatShared.request_id) && Objects.equals(this.chat_id, chatShared.chat_id) && Objects.equals(this.title, chatShared.title) && Objects.equals(this.username, chatShared.username) && Arrays.equals(this.photo, chatShared.photo)) {
                return true;
            }
        }
        return false;
    }

    public Long chatId() {
        return this.chat_id;
    }

    public int hashCode() {
        return Objects.hash(this.request_id, this.chat_id, this.title, this.username, Integer.valueOf(Arrays.hashCode(this.photo)));
    }

    public PhotoSize[] photo() {
        return this.photo;
    }

    public Integer requestId() {
        return this.request_id;
    }

    public String title() {
        return this.title;
    }

    public String toString() {
        return "ChatShared{request_id=" + this.request_id + ", chat_id=" + this.chat_id + ", title='" + this.title + "', username='" + this.username + "', photo=" + Arrays.toString(this.photo) + '}';
    }

    public String username() {
        return this.username;
    }
}
