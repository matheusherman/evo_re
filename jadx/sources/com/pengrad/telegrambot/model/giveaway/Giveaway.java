package com.pengrad.telegrambot.model.giveaway;

import com.pengrad.telegrambot.model.Chat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Giveaway implements Serializable {
    private static final long serialVersionUID = 0;
    private Chat[] chats;
    private String[] country_codes;
    private Boolean has_public_winners;
    private Boolean only_new_members;
    private Integer premium_subscription_month_count;
    private String prize_description;
    private Integer prize_star_count;
    private Integer winner_count;
    private Integer winners_selection_date;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Giveaway giveaway = (Giveaway) obj;
            if (Objects.deepEquals(this.chats, giveaway.chats) && Objects.equals(this.winners_selection_date, giveaway.winners_selection_date) && Objects.equals(this.winner_count, giveaway.winner_count) && Objects.equals(this.only_new_members, giveaway.only_new_members) && Objects.equals(this.has_public_winners, giveaway.has_public_winners) && Objects.equals(this.prize_description, giveaway.prize_description) && Objects.deepEquals(this.country_codes, giveaway.country_codes) && Objects.equals(this.premium_subscription_month_count, giveaway.premium_subscription_month_count) && Objects.equals(this.prize_star_count, giveaway.prize_star_count)) {
                return true;
            }
        }
        return false;
    }

    public Chat[] chats() {
        return this.chats;
    }

    public String[] countryCodes() {
        return this.country_codes;
    }

    public Boolean hasPublicWinners() {
        return this.has_public_winners;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.chats)), this.winners_selection_date, this.winner_count, this.only_new_members, this.has_public_winners, this.prize_description, Integer.valueOf(Arrays.hashCode(this.country_codes)), this.premium_subscription_month_count, this.prize_star_count);
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
        return "Giveaway{chats=" + Arrays.toString(this.chats) + ", winners_selection_date=" + this.winners_selection_date + ", winner_count=" + this.winner_count + ", only_new_members=" + this.only_new_members + ", has_public_winners=" + this.has_public_winners + ", prize_description='" + this.prize_description + "', country_codes=" + Arrays.toString(this.country_codes) + ", premium_subscription_month_count=" + this.premium_subscription_month_count + ", prize_star_count=" + this.prize_star_count + '}';
    }

    public Integer winnerCount() {
        return this.winner_count;
    }

    public Integer winnersSelectionDate() {
        return this.winners_selection_date;
    }
}
