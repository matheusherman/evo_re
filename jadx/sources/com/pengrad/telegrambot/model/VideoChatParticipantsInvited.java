package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class VideoChatParticipantsInvited implements Serializable {
    private static final long serialVersionUID = 0;
    private List<User> users;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.users, ((VideoChatParticipantsInvited) obj).users);
    }

    public int hashCode() {
        return Objects.hash(this.users);
    }

    public String toString() {
        return "VideoChatParticipantsInvited{users=" + this.users + '}';
    }

    public List<User> users() {
        return this.users;
    }
}
