package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.reaction.ReactionType;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetMessageReaction extends BaseRequest<SetMessageReaction, BaseResponse> {
    public SetMessageReaction(Object obj, int i10, ReactionType... reactionTypeArr) {
        super(BaseResponse.class);
        add("chat_id", obj).add("message_id", Integer.valueOf(i10)).add("reaction", reactionTypeArr);
    }

    public SetMessageReaction isBig(boolean z10) {
        return add("is_big", Boolean.valueOf(z10));
    }

    public SetMessageReaction(Object obj, int i10) {
        super(BaseResponse.class);
        add("chat_id", obj).add("message_id", Integer.valueOf(i10));
    }
}
