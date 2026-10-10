package com.pengrad.telegrambot.model.checklist;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ,\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u001d\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/pengrad/telegrambot/model/checklist/ChecklistTasksAdded;", "", "checklistMessage", "Lcom/pengrad/telegrambot/model/Message;", "tasks", "", "Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;", "(Lcom/pengrad/telegrambot/model/Message;[Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;)V", "()Lcom/pengrad/telegrambot/model/Message;", "()[Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;", "[Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;", "component1", "component2", "copy", "(Lcom/pengrad/telegrambot/model/Message;[Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;)Lcom/pengrad/telegrambot/model/checklist/ChecklistTasksAdded;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ChecklistTasksAdded {
    private final Message checklistMessage;
    private final ChecklistTask[] tasks;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChecklistTasksAdded)) {
            return false;
        }
        ChecklistTasksAdded checklistTasksAdded = (ChecklistTasksAdded) other;
        return m.a(this.checklistMessage, checklistTasksAdded.checklistMessage) && Arrays.equals(this.tasks, checklistTasksAdded.tasks);
    }

    public static /* synthetic */ ChecklistTasksAdded copy$default(ChecklistTasksAdded checklistTasksAdded, Message message, ChecklistTask[] checklistTaskArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            message = checklistTasksAdded.checklistMessage;
        }
        if ((i10 & 2) != 0) {
            checklistTaskArr = checklistTasksAdded.tasks;
        }
        return checklistTasksAdded.copy(message, checklistTaskArr);
    }

    /* JADX INFO: renamed from: checklistMessage, reason: from getter */
    public final Message getChecklistMessage() {
        return this.checklistMessage;
    }

    public final Message component1() {
        return this.checklistMessage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ChecklistTask[] getTasks() {
        return this.tasks;
    }

    public final ChecklistTasksAdded copy(Message checklistMessage, ChecklistTask[] tasks) {
        return new ChecklistTasksAdded(checklistMessage, tasks);
    }

    public int hashCode() {
        Message message = this.checklistMessage;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        ChecklistTask[] checklistTaskArr = this.tasks;
        return iHashCode + (checklistTaskArr != null ? checklistTaskArr.hashCode() : 0);
    }

    public final ChecklistTask[] tasks() {
        return this.tasks;
    }

    public String toString() {
        return "ChecklistTasksAdded(checklistMessage=" + this.checklistMessage + ", tasks=" + Arrays.toString(this.tasks) + ')';
    }

    public ChecklistTasksAdded(Message message, ChecklistTask[] checklistTaskArr) {
        this.checklistMessage = message;
        this.tasks = checklistTaskArr;
    }
}
