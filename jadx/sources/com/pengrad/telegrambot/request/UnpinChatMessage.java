package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UnpinChatMessage extends BaseRequest<UnpinChatMessage, BaseResponse> {
    public UnpinChatMessage(Object obj) {
        super(BaseResponse.class);
        add("chat_id", obj);
    }

    public UnpinChatMessage businessConnectionId(String str) {
        return add("business_connection_id", str);
    }

    public UnpinChatMessage messageId(Integer num) {
        return add("message_id", num);
    }
}
