package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PromoteChatMember extends BaseRequest<PromoteChatMember, BaseResponse> {
    public PromoteChatMember(Object obj, long j10) {
        super(BaseResponse.class);
        add("chat_id", obj).add("user_id", Long.valueOf(j10));
    }

    public PromoteChatMember canChangeInfo(boolean z10) {
        return add("can_change_info", Boolean.valueOf(z10));
    }

    public PromoteChatMember canDeleteMessages(boolean z10) {
        return add("can_delete_messages", Boolean.valueOf(z10));
    }

    public PromoteChatMember canDeleteStories(boolean z10) {
        return add("can_delete_stories", Boolean.valueOf(z10));
    }

    public PromoteChatMember canEditMessages(boolean z10) {
        return add("can_edit_messages", Boolean.valueOf(z10));
    }

    public PromoteChatMember canEditStories(boolean z10) {
        return add("can_edit_stories", Boolean.valueOf(z10));
    }

    public PromoteChatMember canInviteUsers(boolean z10) {
        return add("can_invite_users", Boolean.valueOf(z10));
    }

    public PromoteChatMember canManageChat(boolean z10) {
        return add("can_manage_chat", Boolean.valueOf(z10));
    }

    public PromoteChatMember canManageDirectMessages(boolean z10) {
        return add("can_manage_direct_messages", Boolean.valueOf(z10));
    }

    public PromoteChatMember canManageTopics(boolean z10) {
        return add("can_manage_topics", Boolean.valueOf(z10));
    }

    public PromoteChatMember canManageVideoChats(boolean z10) {
        return add("can_manage_video_chats", Boolean.valueOf(z10));
    }

    public PromoteChatMember canPinMessages(boolean z10) {
        return add("can_pin_messages", Boolean.valueOf(z10));
    }

    public PromoteChatMember canPostMessages(boolean z10) {
        return add("can_post_messages", Boolean.valueOf(z10));
    }

    public PromoteChatMember canPostStories(boolean z10) {
        return add("can_post_stories", Boolean.valueOf(z10));
    }

    public PromoteChatMember canPromoteMembers(boolean z10) {
        return add("can_promote_members", Boolean.valueOf(z10));
    }

    public PromoteChatMember canRestrictMembers(boolean z10) {
        return add("can_restrict_members", Boolean.valueOf(z10));
    }

    public PromoteChatMember isAnonymous(boolean z10) {
        return add("is_anonymous", Boolean.valueOf(z10));
    }
}
