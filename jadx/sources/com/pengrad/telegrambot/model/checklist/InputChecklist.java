package com.pengrad.telegrambot.model.checklist;

import com.pengrad.telegrambot.model.MessageEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007BK\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003J\u0019\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u001dR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000b\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0004\u0010\u0017R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014R&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\t\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/pengrad/telegrambot/model/checklist/InputChecklist;", "", "title", "", "tasks", "", "Lcom/pengrad/telegrambot/model/checklist/InputChecklistTask;", "(Ljava/lang/String;[Lcom/pengrad/telegrambot/model/checklist/InputChecklistTask;)V", "parseMode", "titleEntities", "Lcom/pengrad/telegrambot/model/MessageEntity;", "othersCanAddTasks", "", "othersCanMarkTasksAsDone", "(Ljava/lang/String;Ljava/lang/String;[Lcom/pengrad/telegrambot/model/MessageEntity;[Lcom/pengrad/telegrambot/model/checklist/InputChecklistTask;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setOthersCanAddTasks", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setOthersCanMarkTasksAsDone", "()Ljava/lang/String;", "setParseMode", "(Ljava/lang/String;)V", "()[Lcom/pengrad/telegrambot/model/checklist/InputChecklistTask;", "[Lcom/pengrad/telegrambot/model/checklist/InputChecklistTask;", "()[Lcom/pengrad/telegrambot/model/MessageEntity;", "setTitleEntities", "([Lcom/pengrad/telegrambot/model/MessageEntity;)V", "[Lcom/pengrad/telegrambot/model/MessageEntity;", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/model/checklist/InputChecklist;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InputChecklist {
    private Boolean othersCanAddTasks;
    private Boolean othersCanMarkTasksAsDone;
    private String parseMode;
    private final InputChecklistTask[] tasks;
    private final String title;
    private MessageEntity[] titleEntities;

    private InputChecklist(String str, String str2, MessageEntity[] messageEntityArr, InputChecklistTask[] inputChecklistTaskArr, Boolean bool, Boolean bool2) {
        this.title = str;
        this.parseMode = str2;
        this.titleEntities = messageEntityArr;
        this.tasks = inputChecklistTaskArr;
        this.othersCanAddTasks = bool;
        this.othersCanMarkTasksAsDone = bool2;
    }

    /* JADX INFO: renamed from: othersCanAddTasks, reason: from getter */
    public final Boolean getOthersCanAddTasks() {
        return this.othersCanAddTasks;
    }

    /* JADX INFO: renamed from: othersCanMarkTasksAsDone, reason: from getter */
    public final Boolean getOthersCanMarkTasksAsDone() {
        return this.othersCanMarkTasksAsDone;
    }

    /* JADX INFO: renamed from: parseMode, reason: from getter */
    public final String getParseMode() {
        return this.parseMode;
    }

    /* JADX INFO: renamed from: titleEntities, reason: from getter */
    public final MessageEntity[] getTitleEntities() {
        return this.titleEntities;
    }

    public final InputChecklist othersCanAddTasks(boolean othersCanAddTasks) {
        this.othersCanAddTasks = Boolean.valueOf(othersCanAddTasks);
        return this;
    }

    public final InputChecklist othersCanMarkTasksAsDone(boolean othersCanMarkTasksAsDone) {
        this.othersCanMarkTasksAsDone = Boolean.valueOf(othersCanMarkTasksAsDone);
        return this;
    }

    public final InputChecklist parseMode(String parseMode) {
        m.f(parseMode, "parseMode");
        this.parseMode = parseMode;
        return this;
    }

    public final void setOthersCanAddTasks(Boolean bool) {
        this.othersCanAddTasks = bool;
    }

    public final void setOthersCanMarkTasksAsDone(Boolean bool) {
        this.othersCanMarkTasksAsDone = bool;
    }

    public final void setParseMode(String str) {
        this.parseMode = str;
    }

    public final void setTitleEntities(MessageEntity[] messageEntityArr) {
        this.titleEntities = messageEntityArr;
    }

    /* JADX INFO: renamed from: tasks, reason: from getter */
    public final InputChecklistTask[] getTasks() {
        return this.tasks;
    }

    /* JADX INFO: renamed from: title, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final InputChecklist titleEntities(MessageEntity[] titleEntities) {
        m.f(titleEntities, "titleEntities");
        this.titleEntities = titleEntities;
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputChecklist(String title, InputChecklistTask[] tasks) {
        this(title, null, null, tasks, null, null);
        m.f(title, "title");
        m.f(tasks, "tasks");
    }
}
