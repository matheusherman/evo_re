package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SendChatAction extends BaseRequest<SendChatAction, BaseResponse> {
    public SendChatAction(Object obj, String str) {
        super(BaseResponse.class);
        add("chat_id", obj).add("action", str);
    }

    public SendChatAction businessConnectionId(String str) {
        return add("business_connection_id", str);
    }

    public SendChatAction messageThreadId(int i10) {
        add("message_thread_id", Integer.valueOf(i10));
        return this;
    }

    public SendChatAction(Object obj, ChatAction chatAction) {
        super(BaseResponse.class);
        add("chat_id", obj).add("action", chatAction.name());
    }
}
