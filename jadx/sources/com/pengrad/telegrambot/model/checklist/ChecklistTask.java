package com.pengrad.telegrambot.model.checklist;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJL\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\rR\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\u000eR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u001d\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0006\u0010\u0012¨\u0006 "}, d2 = {"Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "text", "", "textEntities", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "completedByUser", "Lcom/pengrad/telegrambot/model/User;", "completionDate", "(ILjava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;Lcom/pengrad/telegrambot/model/User;Ljava/lang/Integer;)V", "()Lcom/pengrad/telegrambot/model/User;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()I", "()Ljava/lang/String;", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "[Lcom/pengrad/telegrambot/model/MessageEntity;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;Lcom/pengrad/telegrambot/model/User;Ljava/lang/Integer;)Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ChecklistTask {
    private final User completedByUser;
    private final Integer completionDate;
    private final int id;
    private final String text;
    private final MessageEntity[] textEntities;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChecklistTask)) {
            return false;
        }
        ChecklistTask checklistTask = (ChecklistTask) other;
        return this.id == checklistTask.id && m.a(this.text, checklistTask.text) && Arrays.equals(this.textEntities, checklistTask.textEntities) && m.a(this.completedByUser, checklistTask.completedByUser) && m.a(this.completionDate, checklistTask.completionDate);
    }

    public ChecklistTask(int i10, String text, MessageEntity[] messageEntityArr, User user, Integer num) {
        m.f(text, "text");
        this.id = i10;
        this.text = text;
        this.textEntities = messageEntityArr;
        this.completedByUser = user;
        this.completionDate = num;
    }

    public static /* synthetic */ ChecklistTask copy$default(ChecklistTask checklistTask, int i10, String str, MessageEntity[] messageEntityArr, User user, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = checklistTask.id;
        }
        if ((i11 & 2) != 0) {
            str = checklistTask.text;
        }
        if ((i11 & 4) != 0) {
            messageEntityArr = checklistTask.textEntities;
        }
        if ((i11 & 8) != 0) {
            user = checklistTask.completedByUser;
        }
        if ((i11 & 16) != 0) {
            num = checklistTask.completionDate;
        }
        Integer num2 = num;
        MessageEntity[] messageEntityArr2 = messageEntityArr;
        return checklistTask.copy(i10, str, messageEntityArr2, user, num2);
    }

    /* JADX INFO: renamed from: completedByUser, reason: from getter */
    public final User getCompletedByUser() {
        return this.completedByUser;
    }

    /* JADX INFO: renamed from: completionDate, reason: from getter */
    public final Integer getCompletionDate() {
        return this.completionDate;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MessageEntity[] getTextEntities() {
        return this.textEntities;
    }

    public final User component4() {
        return this.completedByUser;
    }

    public final Integer component5() {
        return this.completionDate;
    }

    public final ChecklistTask copy(int id2, String text, MessageEntity[] textEntities, User completedByUser, Integer completionDate) {
        m.f(text, "text");
        return new ChecklistTask(id2, text, textEntities, completedByUser, completionDate);
    }

    public int hashCode() {
        int i10 = this.id * 31;
        String str = this.text;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        MessageEntity[] messageEntityArr = this.textEntities;
        int iHashCode2 = (iHashCode + (messageEntityArr != null ? Arrays.hashCode(messageEntityArr) : 0)) * 31;
        User user = this.completedByUser;
        int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        Integer num = this.completionDate;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public final int id() {
        return this.id;
    }

    public final String text() {
        return this.text;
    }

    public final MessageEntity[] textEntities() {
        return this.textEntities;
    }

    public String toString() {
        return "ChecklistTask(id=" + this.id + ", text=" + this.text + ", textEntities=" + Arrays.toString(this.textEntities) + ", completedByUser=" + this.completedByUser + ", completionDate=" + this.completionDate + ')';
    }
}
