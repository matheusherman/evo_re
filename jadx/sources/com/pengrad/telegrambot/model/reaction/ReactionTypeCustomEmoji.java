package com.pengrad.telegrambot.model.reaction;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ReactionTypeCustomEmoji extends ReactionType {
    public static final String CUSTOM_EMOJI_TYPE = "custom_emoji";
    private String custom_emoji_id;

    public String customEmojiId() {
        return this.custom_emoji_id;
    }

    public ReactionTypeCustomEmoji(String str) {
        super(CUSTOM_EMOJI_TYPE);
        this.custom_emoji_id = str;
    }

    public void customEmojiId(String str) {
        this.custom_emoji_id = str;
    }

    @Override // com.pengrad.telegrambot.model.reaction.ReactionType
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            return Objects.equals(this.custom_emoji_id, ((ReactionTypeCustomEmoji) obj).custom_emoji_id);
        }
        return false;
    }

    @Override // com.pengrad.telegrambot.model.reaction.ReactionType
    public String toString() {
        return "ReactionTypeCustomEmoji{type='" + type() + "',custom_emoji_id='" + this.custom_emoji_id + "'}";
    }

    @Override // com.pengrad.telegrambot.model.reaction.ReactionType
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.custom_emoji_id);
    }
}
