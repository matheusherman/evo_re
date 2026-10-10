package com.pengrad.telegrambot.model.giveaway;

import com.pengrad.telegrambot.model.Message;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GiveawayCompleted implements Serializable {
    private static final long serialVersionUID = 0;
    private Message giveaway_message;
    private Boolean is_star_giveaway;
    private Integer unclaimed_prize_count;
    private Integer winner_count;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GiveawayCompleted giveawayCompleted = (GiveawayCompleted) obj;
            if (Objects.equals(this.winner_count, giveawayCompleted.winner_count) && Objects.equals(this.unclaimed_prize_count, giveawayCompleted.unclaimed_prize_count) && Objects.equals(this.giveaway_message, giveawayCompleted.giveaway_message) && Objects.equals(this.is_star_giveaway, giveawayCompleted.is_star_giveaway)) {
                return true;
            }
        }
        return false;
    }

    public Message giveawayMessage() {
        return this.giveaway_message;
    }

    public int hashCode() {
        return Objects.hash(this.winner_count, this.unclaimed_prize_count, this.giveaway_message, this.is_star_giveaway);
    }

    public Boolean isStarGiveaway() {
        return this.is_star_giveaway;
    }

    public String toString() {
        return "GiveawayCompleted{winner_count='" + this.winner_count + "',unclaimed_prize_count='" + this.unclaimed_prize_count + "',giveaway_message='" + this.giveaway_message + "'is_star_giveaway='" + this.is_star_giveaway + "'}";
    }

    public Integer unclaimedPrizeCount() {
        return this.unclaimed_prize_count;
    }

    public Integer winnerCount() {
        return this.winner_count;
    }
}
