package com.pengrad.telegrambot.model.giveaway;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.User;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GiveawayWinners implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer additional_chat_count;
    private Chat chat;
    private Integer giveaway_message_id;
    private Boolean only_new_members;
    private Integer premium_subscription_month_count;
    private String prize_description;
    private Integer prize_star_count;
    private Integer unclaimed_prize_count;
    private Boolean was_refunded;
    private Integer winner_count;
    private User[] winners;
    private Integer winners_selection_date;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GiveawayWinners giveawayWinners = (GiveawayWinners) obj;
            if (Objects.equals(this.chat, giveawayWinners.chat) && Objects.equals(this.giveaway_message_id, giveawayWinners.giveaway_message_id) && Objects.equals(this.winners_selection_date, giveawayWinners.winners_selection_date) && Objects.equals(this.winner_count, giveawayWinners.winner_count) && Objects.deepEquals(this.winners, giveawayWinners.winners) && Objects.equals(this.additional_chat_count, giveawayWinners.additional_chat_count) && Objects.equals(this.premium_subscription_month_count, giveawayWinners.premium_subscription_month_count) && Objects.equals(this.unclaimed_prize_count, giveawayWinners.unclaimed_prize_count) && Objects.equals(this.only_new_members, giveawayWinners.only_new_members) && Objects.equals(this.was_refunded, giveawayWinners.was_refunded) && Objects.equals(this.prize_description, giveawayWinners.prize_description) && Objects.equals(this.prize_star_count, giveawayWinners.prize_star_count)) {
                return true;
            }
        }
        return false;
    }

    public Integer additionalChatCount() {
        return this.additional_chat_count;
    }

    public Chat chat() {
        return this.chat;
    }

    public Integer giveawayMessageId() {
        return this.giveaway_message_id;
    }

    public int hashCode() {
        return Objects.hash(this.chat, this.giveaway_message_id, this.winners_selection_date, this.winner_count, Integer.valueOf(Arrays.hashCode(this.winners)), this.additional_chat_count, this.premium_subscription_month_count, this.unclaimed_prize_count, this.only_new_members, this.was_refunded, this.prize_description, this.prize_star_count);
    }

    public Boolean onlyNewMembers() {
        return this.only_new_members;
    }

    public Integer premiumSubscriptionMonthCount() {
        return this.premium_subscription_month_count;
    }

    public String prizeDescription() {
        return this.prize_description;
    }

    public Integer prizeStarCount() {
        return this.prize_star_count;
    }

    public String toString() {
        return "GiveawayWinners{chat=" + this.chat + ", giveaway_message_id=" + this.giveaway_message_id + ", winners_selection_date=" + this.winners_selection_date + ", winner_count=" + this.winner_count + ", winners=" + Arrays.toString(this.winners) + ", additional_chat_count=" + this.additional_chat_count + ", premium_subscription_month_count=" + this.premium_subscription_month_count + ", unclaimed_prize_count=" + this.unclaimed_prize_count + ", only_new_members=" + this.only_new_members + ", was_refunded=" + this.was_refunded + ", prize_description='" + this.prize_description + "', prize_star_count=" + this.prize_star_count + '}';
    }

    public Integer unclaimedPrizeCount() {
        return this.unclaimed_prize_count;
    }

    public Boolean wasRefunded() {
        return this.was_refunded;
    }

    public Integer winnerCount() {
        return this.winner_count;
    }

    public User[] winners() {
        return this.winners;
    }

    public Integer winnersSelectionDate() {
        return this.winners_selection_date;
    }
}
