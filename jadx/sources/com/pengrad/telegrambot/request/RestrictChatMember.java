package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.ChatPermissions;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RestrictChatMember extends BaseRequest<RestrictChatMember, BaseResponse> {
    public RestrictChatMember(Object obj, long j10, ChatPermissions chatPermissions) {
        super(BaseResponse.class);
        add("chat_id", obj).add("user_id", Long.valueOf(j10)).add("permissions", chatPermissions);
    }

    public RestrictChatMember untilDate(int i10) {
        return add("until_date", Integer.valueOf(i10));
    }

    public RestrictChatMember useIndependentChatPermissions(boolean z10) {
        return add("use_independent_chat_permissions", Boolean.valueOf(z10));
    }
}
