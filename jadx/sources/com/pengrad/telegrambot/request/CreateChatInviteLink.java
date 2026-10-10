package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.ChatInviteLinkResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CreateChatInviteLink extends BaseRequest<CreateChatInviteLink, ChatInviteLinkResponse> {
    public CreateChatInviteLink(Object obj) {
        super(ChatInviteLinkResponse.class);
        add("chat_id", obj);
    }

    public CreateChatInviteLink createsJoinRequest(Boolean bool) {
        return add("creates_join_request", bool);
    }

    public CreateChatInviteLink expireDate(Integer num) {
        return add("expire_date", num);
    }

    public CreateChatInviteLink memberLimit(Integer num) {
        return add("member_limit", num);
    }

    public CreateChatInviteLink name(String str) {
        return add("name", str);
    }
}
