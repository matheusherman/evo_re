package com.pengrad.telegrambot.model.story.area.type;

import com.pengrad.telegrambot.model.reaction.ReactionType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0005\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0007\u0010\t\"\u0004\b\r\u0010\u000bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaTypeSuggestedReaction;", "Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaType;", "reactionType", "Lcom/pengrad/telegrambot/model/reaction/ReactionType;", "(Lcom/pengrad/telegrambot/model/reaction/ReactionType;)V", "isDark", "", "isFlipped", "(Lcom/pengrad/telegrambot/model/reaction/ReactionType;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setDark", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setFlipped", "()Lcom/pengrad/telegrambot/model/reaction/ReactionType;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StoryAreaTypeSuggestedReaction extends StoryAreaType {
    private Boolean isDark;
    private Boolean isFlipped;
    private final ReactionType reactionType;

    private StoryAreaTypeSuggestedReaction(ReactionType reactionType, Boolean bool, Boolean bool2) {
        super("suggested_reaction");
        this.reactionType = reactionType;
        this.isDark = bool;
        this.isFlipped = bool2;
    }

    /* JADX INFO: renamed from: isDark, reason: from getter */
    public final Boolean getIsDark() {
        return this.isDark;
    }

    /* JADX INFO: renamed from: isFlipped, reason: from getter */
    public final Boolean getIsFlipped() {
        return this.isFlipped;
    }

    public final StoryAreaTypeSuggestedReaction isDark(boolean isDark) {
        this.isDark = Boolean.valueOf(isDark);
        return this;
    }

    public final StoryAreaTypeSuggestedReaction isFlipped(boolean isFlipped) {
        this.isFlipped = Boolean.valueOf(isFlipped);
        return this;
    }

    /* JADX INFO: renamed from: reactionType, reason: from getter */
    public final ReactionType getReactionType() {
        return this.reactionType;
    }

    public final void setDark(Boolean bool) {
        this.isDark = bool;
    }

    public final void setFlipped(Boolean bool) {
        this.isFlipped = bool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoryAreaTypeSuggestedReaction(ReactionType reactionType) {
        this(reactionType, null, null);
        m.f(reactionType, "reactionType");
    }
}
