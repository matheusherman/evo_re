package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.User;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BusinessConnection {
    private Boolean can_reply;
    private Integer date;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f8241id;
    private Boolean is_enabled;
    private BusinessBotRights rights;
    private User user;
    private Long user_chat_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusinessConnection businessConnection = (BusinessConnection) obj;
            if (Objects.equals(this.f8241id, businessConnection.f8241id) && Objects.equals(this.user, businessConnection.user) && Objects.equals(this.user_chat_id, businessConnection.user_chat_id) && Objects.equals(this.date, businessConnection.date) && Objects.equals(this.rights, businessConnection.rights) && Objects.equals(this.is_enabled, businessConnection.is_enabled)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public Boolean canReply() {
        return this.can_reply;
    }

    public Integer date() {
        return this.date;
    }

    public int hashCode() {
        return Objects.hash(this.f8241id, this.user, this.user_chat_id, this.date, this.rights, this.is_enabled);
    }

    public String id() {
        return this.f8241id;
    }

    public Boolean isEnabled() {
        return this.is_enabled;
    }

    public BusinessBotRights rights() {
        return this.rights;
    }

    public String toString() {
        return "BusinessConnection{id='" + this.f8241id + "', user=" + this.user + ", user_chat_id=" + this.user_chat_id + ", date=" + this.date + ", rights=" + this.rights + ", is_enabled=" + this.is_enabled + '}';
    }

    public User user() {
        return this.user;
    }

    public Long userChatId() {
        return this.user_chat_id;
    }
}
