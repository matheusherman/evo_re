package com.pengrad.telegrambot.model.chatboost;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatBoostAdded {
    private Integer boost_count;

    public Integer boostCount() {
        return this.boost_count;
    }

    public ChatBoostAdded boostCount(Integer num) {
        this.boost_count = num;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.boost_count, ((ChatBoostAdded) obj).boost_count);
    }

    public int hashCode() {
        return Objects.hash(this.boost_count);
    }

    public String toString() {
        return "ChatBoostAdded{boost_count=" + this.boost_count + '}';
    }
}
