package com.pengrad.telegrambot.model.reaction;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ReactionTypeEmoji extends ReactionType {
    public static final String EMOJI_TYPE = "emoji";
    private String emoji;

    public String emoji() {
        return this.emoji;
    }

    public ReactionTypeEmoji(String str) {
        super(EMOJI_TYPE);
        this.emoji = str;
    }

    public void emoji(String str) {
        this.emoji = str;
    }

    @Override // com.pengrad.telegrambot.model.reaction.ReactionType
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            return Objects.equals(this.emoji, ((ReactionTypeEmoji) obj).emoji);
        }
        return false;
    }

    @Override // com.pengrad.telegrambot.model.reaction.ReactionType
    public String toString() {
        return "ReactionTypeEmoji{type='" + type() + "',emoji='" + this.emoji + "'}";
    }

    @Override // com.pengrad.telegrambot.model.reaction.ReactionType
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.emoji);
    }
}
