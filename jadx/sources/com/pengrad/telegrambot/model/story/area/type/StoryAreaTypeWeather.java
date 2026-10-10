package com.pengrad.telegrambot.model.story.area.type;

import com.pengrad.telegrambot.model.reaction.ReactionTypeEmoji;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaTypeWeather;", "Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaType;", "temperature", "", ReactionTypeEmoji.EMOJI_TYPE, "", "backgroundColor", "", "(DLjava/lang/String;I)V", "()I", "()Ljava/lang/String;", "()D", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StoryAreaTypeWeather extends StoryAreaType {
    private final int backgroundColor;
    private final String emoji;
    private final double temperature;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryAreaTypeWeather(double d10, String emoji, int i10) {
        super("weather");
        m.f(emoji, "emoji");
        this.temperature = d10;
        this.emoji = emoji;
        this.backgroundColor = i10;
    }

    /* JADX INFO: renamed from: backgroundColor, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: emoji, reason: from getter */
    public final String getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: temperature, reason: from getter */
    public final double getTemperature() {
        return this.temperature;
    }
}
