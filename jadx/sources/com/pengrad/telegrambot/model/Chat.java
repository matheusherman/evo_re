package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Chat implements Serializable {
    private static final long serialVersionUID = 0;
    private String first_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Long f8232id;
    private Boolean is_direct_messages;
    private Boolean is_forum;
    private String last_name;
    private String title;
    private Type type;
    private String username;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Type {
        Private,
        group,
        supergroup,
        channel
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Chat chat = (Chat) obj;
            if (Objects.equals(this.f8232id, chat.f8232id) && this.type == chat.type && Objects.equals(this.first_name, chat.first_name) && Objects.equals(this.last_name, chat.last_name) && Objects.equals(this.is_forum, chat.is_forum) && Objects.equals(this.is_direct_messages, chat.is_direct_messages) && Objects.equals(this.username, chat.username) && Objects.equals(this.title, chat.title)) {
                return true;
            }
        }
        return false;
    }

    public String firstName() {
        return this.first_name;
    }

    public int hashCode() {
        Long l10 = this.f8232id;
        if (l10 != null) {
            return l10.hashCode();
        }
        return 0;
    }

    public Long id() {
        return this.f8232id;
    }

    public Boolean isDirectMessages() {
        Boolean bool = this.is_direct_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean isForum() {
        Boolean bool = this.is_forum;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String lastName() {
        return this.last_name;
    }

    public String title() {
        return this.title;
    }

    public String toString() {
        return "Chat{id=" + this.f8232id + ", type=" + this.type + ", first_name='" + this.first_name + "', last_name='" + this.last_name + "', is_forum=" + this.is_forum + ", is_direct_messages=" + this.is_direct_messages + ", username='" + this.username + "', title='" + this.title + "'}";
    }

    public Type type() {
        return this.type;
    }

    public String username() {
        return this.username;
    }
}
