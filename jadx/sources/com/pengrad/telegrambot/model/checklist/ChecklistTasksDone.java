package com.pengrad.telegrambot.model.checklist;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u001d\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\nR\u001d\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/pengrad/telegrambot/model/checklist/ChecklistTasksDone;", "", "checklistMessage", "Lcom/pengrad/telegrambot/model/Message;", "markedAsDoneTaskIds", "", "", "markedAsNotDoneTaskIds", "(Lcom/pengrad/telegrambot/model/Message;[Ljava/lang/Integer;[Ljava/lang/Integer;)V", "()Lcom/pengrad/telegrambot/model/Message;", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Lcom/pengrad/telegrambot/model/Message;[Ljava/lang/Integer;[Ljava/lang/Integer;)Lcom/pengrad/telegrambot/model/checklist/ChecklistTasksDone;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ChecklistTasksDone {
    private final Message checklistMessage;
    private final Integer[] markedAsDoneTaskIds;
    private final Integer[] markedAsNotDoneTaskIds;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChecklistTasksDone)) {
            return false;
        }
        ChecklistTasksDone checklistTasksDone = (ChecklistTasksDone) other;
        return m.a(this.checklistMessage, checklistTasksDone.checklistMessage) && Arrays.equals(this.markedAsDoneTaskIds, checklistTasksDone.markedAsDoneTaskIds) && Arrays.equals(this.markedAsNotDoneTaskIds, checklistTasksDone.markedAsNotDoneTaskIds);
    }

    public static /* synthetic */ ChecklistTasksDone copy$default(ChecklistTasksDone checklistTasksDone, Message message, Integer[] numArr, Integer[] numArr2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = checklistTasksDone.checklistMessage;
        }
        if ((i10 & 2) != 0) {
            numArr = checklistTasksDone.markedAsDoneTaskIds;
        }
        if ((i10 & 4) != 0) {
            numArr2 = checklistTasksDone.markedAsNotDoneTaskIds;
        }
        return checklistTasksDone.copy(message, numArr, numArr2);
    }

    /* JADX INFO: renamed from: checklistMessage, reason: from getter */
    public final Message getChecklistMessage() {
        return this.checklistMessage;
    }

    public final Message component1() {
        return this.checklistMessage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer[] getMarkedAsDoneTaskIds() {
        return this.markedAsDoneTaskIds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer[] getMarkedAsNotDoneTaskIds() {
        return this.markedAsNotDoneTaskIds;
    }

    public final ChecklistTasksDone copy(Message checklistMessage, Integer[] markedAsDoneTaskIds, Integer[] markedAsNotDoneTaskIds) {
        return new ChecklistTasksDone(checklistMessage, markedAsDoneTaskIds, markedAsNotDoneTaskIds);
    }

    public int hashCode() {
        Message message = this.checklistMessage;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        Integer[] numArr = this.markedAsDoneTaskIds;
        int iHashCode2 = (iHashCode + (numArr != null ? numArr.hashCode() : 0)) * 31;
        Integer[] numArr2 = this.markedAsNotDoneTaskIds;
        return iHashCode2 + (numArr2 != null ? numArr2.hashCode() : 0);
    }

    public final Integer[] markedAsDoneTaskIds() {
        return this.markedAsDoneTaskIds;
    }

    public final Integer[] markedAsNotDoneTaskIds() {
        return this.markedAsNotDoneTaskIds;
    }

    public String toString() {
        return "ChecklistTasksDone(checklistMessage=" + this.checklistMessage + ", markedAsDoneTaskIds=" + Arrays.toString(this.markedAsDoneTaskIds) + ", markedAsNotDoneTaskIds=" + Arrays.toString(this.markedAsNotDoneTaskIds) + ')';
    }

    public ChecklistTasksDone(Message message, Integer[] numArr, Integer[] numArr2) {
        this.checklistMessage = message;
        this.markedAsDoneTaskIds = numArr;
        this.markedAsNotDoneTaskIds = numArr2;
    }
}
