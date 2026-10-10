package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.Chat;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BusinessMessageDeleted {
    private String business_connection_id;
    private Chat chat;
    private Integer[] message_ids;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusinessMessageDeleted businessMessageDeleted = (BusinessMessageDeleted) obj;
            if (Objects.equals(this.business_connection_id, businessMessageDeleted.business_connection_id) && Objects.equals(this.chat, businessMessageDeleted.chat) && Objects.deepEquals(this.message_ids, businessMessageDeleted.message_ids)) {
                return true;
            }
        }
        return false;
    }

    public String businessConnectionId() {
        return this.business_connection_id;
    }

    public Chat chat() {
        return this.chat;
    }

    public int hashCode() {
        return Objects.hash(this.business_connection_id, this.chat, Integer.valueOf(Arrays.hashCode(this.message_ids)));
    }

    public Integer[] messageIds() {
        return this.message_ids;
    }

    public String toString() {
        return "BusinessMessageDeleted{business_connection_id='" + this.business_connection_id + "', chat=" + this.chat + ", message_ids=" + Arrays.toString(this.message_ids) + '}';
    }
}
