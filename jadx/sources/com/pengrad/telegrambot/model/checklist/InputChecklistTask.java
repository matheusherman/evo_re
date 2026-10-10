package com.pengrad.telegrambot.model.checklist;

import com.pengrad.telegrambot.model.MessageEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u0019\u0010\b\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u0014R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\b\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/pengrad/telegrambot/model/checklist/InputChecklistTask;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "text", "", "(ILjava/lang/String;)V", "parseMode", "textEntities", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "(ILjava/lang/String;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;)V", "()I", "()Ljava/lang/String;", "setParseMode", "(Ljava/lang/String;)V", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "setTextEntities", "([Lcom/pengrad/telegrambot/model/MessageEntity;)V", "[Lcom/pengrad/telegrambot/model/MessageEntity;", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/model/checklist/InputChecklistTask;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InputChecklistTask {
    private final int id;
    private String parseMode;
    private final String text;
    private MessageEntity[] textEntities;

    private InputChecklistTask(int i10, String str, String str2, MessageEntity[] messageEntityArr) {
        this.id = i10;
        this.text = str;
        this.parseMode = str2;
        this.textEntities = messageEntityArr;
    }

    /* JADX INFO: renamed from: parseMode, reason: from getter */
    public final String getParseMode() {
        return this.parseMode;
    }

    /* JADX INFO: renamed from: textEntities, reason: from getter */
    public final MessageEntity[] getTextEntities() {
        return this.textEntities;
    }

    /* JADX INFO: renamed from: id, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final InputChecklistTask parseMode(String parseMode) {
        m.f(parseMode, "parseMode");
        this.parseMode = parseMode;
        return this;
    }

    public final void setParseMode(String str) {
        this.parseMode = str;
    }

    public final void setTextEntities(MessageEntity[] messageEntityArr) {
        this.textEntities = messageEntityArr;
    }

    /* JADX INFO: renamed from: text, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final InputChecklistTask textEntities(MessageEntity[] textEntities) {
        m.f(textEntities, "textEntities");
        this.textEntities = textEntities;
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputChecklistTask(int i10, String text) {
        this(i10, text, null, null);
        m.f(text, "text");
    }
}
