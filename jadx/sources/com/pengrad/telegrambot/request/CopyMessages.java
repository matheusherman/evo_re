package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.MessageIdsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\n¨\u0006\u0010"}, d2 = {"Lcom/pengrad/telegrambot/request/CopyMessages;", "Lcom/pengrad/telegrambot/request/BaseRequest;", "Lcom/pengrad/telegrambot/response/MessageIdsResponse;", "chatId", "", "fromChatId", "messageIds", "", "(Ljava/lang/Object;Ljava/lang/Object;[I)V", "disableNotification", "", "messageThreadId", "", "(Ljava/lang/Integer;)Lcom/pengrad/telegrambot/request/CopyMessages;", "protectContent", "removeCaption", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CopyMessages extends BaseRequest<CopyMessages, MessageIdsResponse> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CopyMessages(Object chatId, Object fromChatId, int[] messageIds) {
        super(MessageIdsResponse.class);
        m.f(chatId, "chatId");
        m.f(fromChatId, "fromChatId");
        m.f(messageIds, "messageIds");
        add("chat_id", chatId).add("from_chat_id", fromChatId).add("message_ids", messageIds);
    }

    public final CopyMessages disableNotification(boolean disableNotification) {
        CopyMessages copyMessagesAdd = add("disable_notification", Boolean.valueOf(disableNotification));
        m.e(copyMessagesAdd, "add(...)");
        return copyMessagesAdd;
    }

    public final CopyMessages messageThreadId(Integer messageThreadId) {
        CopyMessages copyMessagesAdd = add("message_thread_id", messageThreadId);
        m.e(copyMessagesAdd, "add(...)");
        return copyMessagesAdd;
    }

    public final CopyMessages protectContent(boolean protectContent) {
        CopyMessages copyMessagesAdd = add("protect_content", Boolean.valueOf(protectContent));
        m.e(copyMessagesAdd, "add(...)");
        return copyMessagesAdd;
    }

    public final CopyMessages removeCaption(boolean removeCaption) {
        CopyMessages copyMessagesAdd = add("remove_caption", Boolean.valueOf(removeCaption));
        m.e(copyMessagesAdd, "add(...)");
        return copyMessagesAdd;
    }
}
