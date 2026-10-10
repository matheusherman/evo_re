package com.pengrad.telegrambot.model.checklist;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\rJR\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\t\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\rR\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000b\u0010\rR\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u001d\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0004\u0010\u0012¨\u0006 "}, d2 = {"Lcom/pengrad/telegrambot/model/checklist/Checklist;", "", "title", "", "titleEntities", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "tasks", "Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;", "othersCanAddTasks", "", "othersCanMarkTasksAsDone", "(Ljava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;[Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()[Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;", "[Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;", "()Ljava/lang/String;", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "[Lcom/pengrad/telegrambot/model/MessageEntity;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;[Lcom/pengrad/telegrambot/model/checklist/ChecklistTask;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/pengrad/telegrambot/model/checklist/Checklist;", "equals", TransactionPartnerType.OTHER, "hashCode", "", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Checklist {
    private final Boolean othersCanAddTasks;
    private final Boolean othersCanMarkTasksAsDone;
    private final ChecklistTask[] tasks;
    private final String title;
    private final MessageEntity[] titleEntities;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Checklist)) {
            return false;
        }
        Checklist checklist = (Checklist) other;
        return m.a(this.title, checklist.title) && Arrays.equals(this.titleEntities, checklist.titleEntities) && Arrays.equals(this.tasks, checklist.tasks) && m.a(this.othersCanAddTasks, checklist.othersCanAddTasks) && m.a(this.othersCanMarkTasksAsDone, checklist.othersCanMarkTasksAsDone);
    }

    public Checklist(String title, MessageEntity[] messageEntityArr, ChecklistTask[] tasks, Boolean bool, Boolean bool2) {
        m.f(title, "title");
        m.f(tasks, "tasks");
        this.title = title;
        this.titleEntities = messageEntityArr;
        this.tasks = tasks;
        this.othersCanAddTasks = bool;
        this.othersCanMarkTasksAsDone = bool2;
    }

    public static /* synthetic */ Checklist copy$default(Checklist checklist, String str, MessageEntity[] messageEntityArr, ChecklistTask[] checklistTaskArr, Boolean bool, Boolean bool2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = checklist.title;
        }
        if ((i10 & 2) != 0) {
            messageEntityArr = checklist.titleEntities;
        }
        if ((i10 & 4) != 0) {
            checklistTaskArr = checklist.tasks;
        }
        if ((i10 & 8) != 0) {
            bool = checklist.othersCanAddTasks;
        }
        if ((i10 & 16) != 0) {
            bool2 = checklist.othersCanMarkTasksAsDone;
        }
        Boolean bool3 = bool2;
        ChecklistTask[] checklistTaskArr2 = checklistTaskArr;
        return checklist.copy(str, messageEntityArr, checklistTaskArr2, bool, bool3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MessageEntity[] getTitleEntities() {
        return this.titleEntities;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ChecklistTask[] getTasks() {
        return this.tasks;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getOthersCanAddTasks() {
        return this.othersCanAddTasks;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getOthersCanMarkTasksAsDone() {
        return this.othersCanMarkTasksAsDone;
    }

    public final Checklist copy(String title, MessageEntity[] titleEntities, ChecklistTask[] tasks, Boolean othersCanAddTasks, Boolean othersCanMarkTasksAsDone) {
        m.f(title, "title");
        m.f(tasks, "tasks");
        return new Checklist(title, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public int hashCode() {
        int iHashCode = this.title.hashCode() * 31;
        MessageEntity[] messageEntityArr = this.titleEntities;
        int iHashCode2 = (iHashCode + (messageEntityArr != null ? Arrays.hashCode(messageEntityArr) : 0)) * 31;
        ChecklistTask[] checklistTaskArr = this.tasks;
        int iHashCode3 = (iHashCode2 + (checklistTaskArr != null ? Arrays.hashCode(checklistTaskArr) : 0)) * 31;
        Boolean bool = this.othersCanAddTasks;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.othersCanMarkTasksAsDone;
        return iHashCode4 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final Boolean othersCanAddTasks() {
        return this.othersCanAddTasks;
    }

    public final Boolean othersCanMarkTasksAsDone() {
        return this.othersCanMarkTasksAsDone;
    }

    public final ChecklistTask[] tasks() {
        return this.tasks;
    }

    public final String title() {
        return this.title;
    }

    public final MessageEntity[] titleEntities() {
        return this.titleEntities;
    }

    public String toString() {
        return "Checklist(title=" + this.title + ", titleEntities=" + Arrays.toString(this.titleEntities) + ", tasks=" + Arrays.toString(this.tasks) + ", othersCanAddTasks=" + this.othersCanAddTasks + ", othersCanMarkTasksAsDone=" + this.othersCanMarkTasksAsDone + ')';
    }
}
