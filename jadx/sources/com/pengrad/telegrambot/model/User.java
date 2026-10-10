package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class User implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean added_to_attachment_menu;
    private Boolean can_connect_to_business;
    private Boolean can_join_groups;
    private Boolean can_read_all_group_messages;
    private String first_name;
    private Boolean has_main_web_app;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Long f8240id;
    private Boolean is_bot;
    private Boolean is_premium;
    private String language_code;
    private String last_name;
    private Boolean supports_inline_queries;
    private String username;

    private User() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            User user = (User) obj;
            if (Objects.equals(this.f8240id, user.f8240id) && Objects.equals(this.is_bot, user.is_bot) && Objects.equals(this.first_name, user.first_name) && Objects.equals(this.last_name, user.last_name) && Objects.equals(this.username, user.username) && Objects.equals(this.language_code, user.language_code) && Objects.equals(this.is_premium, user.is_premium) && Objects.equals(this.added_to_attachment_menu, user.added_to_attachment_menu) && Objects.equals(this.can_join_groups, user.can_join_groups) && Objects.equals(this.can_read_all_group_messages, user.can_read_all_group_messages) && Objects.equals(this.supports_inline_queries, user.supports_inline_queries) && Objects.equals(this.can_connect_to_business, user.can_connect_to_business) && Objects.equals(this.has_main_web_app, user.has_main_web_app)) {
                return true;
            }
        }
        return false;
    }

    public User(Long l10) {
        this.f8240id = l10;
    }

    public Boolean addedToAttachmentMenu() {
        Boolean bool = this.added_to_attachment_menu;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canConnectToBusiness() {
        Boolean bool = this.can_connect_to_business;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canJoinGroups() {
        Boolean bool = this.can_join_groups;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean canReadAllGroupMessages() {
        Boolean bool = this.can_read_all_group_messages;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String firstName() {
        return this.first_name;
    }

    public Boolean hasMainWebApp() {
        return this.has_main_web_app;
    }

    public int hashCode() {
        Long l10 = this.f8240id;
        if (l10 != null) {
            return l10.hashCode();
        }
        return 0;
    }

    public Long id() {
        return this.f8240id;
    }

    public Boolean isBot() {
        return this.is_bot;
    }

    public Boolean isPremium() {
        Boolean bool = this.is_premium;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String languageCode() {
        return this.language_code;
    }

    public String lastName() {
        return this.last_name;
    }

    public Boolean supportsInlineQueries() {
        Boolean bool = this.supports_inline_queries;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String toString() {
        return "User{id=" + this.f8240id + ", is_bot=" + this.is_bot + ", first_name='" + this.first_name + "', last_name='" + this.last_name + "', username='" + this.username + "', language_code='" + this.language_code + "', is_premium='" + this.is_premium + "', added_to_attachment_menu='" + this.added_to_attachment_menu + "', can_join_groups=" + this.can_join_groups + ", can_read_all_group_messages=" + this.can_read_all_group_messages + ", supports_inline_queries=" + this.supports_inline_queries + ", can_connect_to_business=" + this.can_connect_to_business + ", has_main_web_app=" + this.has_main_web_app + '}';
    }

    public String username() {
        return this.username;
    }
}
