package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.MessageIdsResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ForwardMessages extends BaseRequest<ForwardMessages, MessageIdsResponse> {
    public ForwardMessages(Object obj, Object obj2, int[] iArr) {
        super(MessageIdsResponse.class);
        add("chat_id", obj).add("from_chat_id", obj2).add("message_ids", iArr);
    }

    public ForwardMessages disableNotification(boolean z10) {
        return add("disable_notification", Boolean.valueOf(z10));
    }

    public ForwardMessages messageThreadId(Integer num) {
        return add("message_thread_id", num);
    }

    public ForwardMessages protectContent(boolean z10) {
        return add("protect_content", Boolean.valueOf(z10));
    }
}
