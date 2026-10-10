package com.pengrad.telegrambot.model.story;

import com.pengrad.telegrambot.model.story.area.StoryAreaPosition;
import com.pengrad.telegrambot.model.story.area.type.StoryAreaType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/pengrad/telegrambot/model/story/StoryArea;", "", "position", "Lcom/pengrad/telegrambot/model/story/area/StoryAreaPosition;", IjkMediaMeta.IJKM_KEY_TYPE, "Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaType;", "(Lcom/pengrad/telegrambot/model/story/area/StoryAreaPosition;Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaType;)V", "()Lcom/pengrad/telegrambot/model/story/area/StoryAreaPosition;", "()Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaType;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StoryArea {
    private final StoryAreaPosition position;
    private final StoryAreaType type;

    public StoryArea(StoryAreaPosition position, StoryAreaType type) {
        m.f(position, "position");
        m.f(type, "type");
        this.position = position;
        this.type = type;
    }

    /* JADX INFO: renamed from: position, reason: from getter */
    public final StoryAreaPosition getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: type, reason: from getter */
    public final StoryAreaType getType() {
        return this.type;
    }
}
