package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatInviteLink implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean creates_join_request;
    private User creator;
    private Integer expire_date;
    private String invite_link;
    private Boolean is_primary;
    private Boolean is_revoked;
    private Integer member_limit;
    private String name;
    private Integer pending_join_request_count;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatInviteLink chatInviteLink = (ChatInviteLink) obj;
            if (Objects.equals(this.invite_link, chatInviteLink.invite_link) && Objects.equals(this.creator, chatInviteLink.creator) && Objects.equals(this.creates_join_request, chatInviteLink.creates_join_request) && Objects.equals(this.is_primary, chatInviteLink.is_primary) && Objects.equals(this.is_revoked, chatInviteLink.is_revoked) && Objects.equals(this.name, chatInviteLink.name) && Objects.equals(this.expire_date, chatInviteLink.expire_date) && Objects.equals(this.member_limit, chatInviteLink.member_limit) && Objects.equals(this.pending_join_request_count, chatInviteLink.pending_join_request_count)) {
                return true;
            }
        }
        return false;
    }

    public Boolean createsJoinRequest() {
        return this.creates_join_request;
    }

    public User creator() {
        return this.creator;
    }

    public Integer expireDate() {
        return this.expire_date;
    }

    public int hashCode() {
        return Objects.hash(this.invite_link, this.creator, this.creates_join_request, this.is_primary, this.is_revoked, this.name, this.expire_date, this.member_limit, this.pending_join_request_count);
    }

    public String inviteLink() {
        return this.invite_link;
    }

    public Boolean isPrimary() {
        return this.is_primary;
    }

    public Boolean isRevoked() {
        return this.is_revoked;
    }

    public Integer memberLimit() {
        return this.member_limit;
    }

    public String name() {
        return this.name;
    }

    public Integer pendingJoinRequestCount() {
        return this.pending_join_request_count;
    }

    public String toString() {
        return "ChatInviteLink{invite_link='" + this.invite_link + "', creator=" + this.creator + ", creates_join_request=" + this.creates_join_request + ", is_primary=" + this.is_primary + ", is_revoked=" + this.is_revoked + ", name=" + this.name + ", expire_date=" + this.expire_date + ", member_limit=" + this.member_limit + ", pending_join_request_count=" + this.pending_join_request_count + '}';
    }
}
