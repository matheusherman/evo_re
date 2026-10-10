package com.pengrad.telegrambot.model.chatboost.source;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatBoostSourceGiveaway extends ChatBoostSource implements Serializable {
    public static final String CHAT_BOOST_TYPE = "giveaway";
    private static final long serialVersionUID = 0;
    private Integer giveaway_message_id;
    private Boolean is_unclaimed;
    private Integer prize_star_count;

    @Override // com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        ChatBoostSourceGiveaway chatBoostSourceGiveaway = (ChatBoostSourceGiveaway) obj;
        return Objects.equals(this.giveaway_message_id, chatBoostSourceGiveaway.giveaway_message_id) && Objects.equals(this.is_unclaimed, chatBoostSourceGiveaway.is_unclaimed) && Objects.equals(this.prize_star_count, chatBoostSourceGiveaway.prize_star_count);
    }

    public Integer giveawayMessageId() {
        return this.giveaway_message_id;
    }

    public Boolean isUnclaimed() {
        Boolean bool = this.is_unclaimed;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Integer prizeStarCount() {
        return this.prize_star_count;
    }

    @Override // com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource
    public String toString() {
        return "ChatBoostSourceGiveaway{source='" + this.source + "',user='" + this.user + "',giveaway_message_id='" + this.giveaway_message_id + "',is_unclaimed='" + this.is_unclaimed + "',prize_star_count='" + this.prize_star_count + "'}";
    }

    @Override // com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.giveaway_message_id, this.is_unclaimed, this.prize_star_count);
    }
}
