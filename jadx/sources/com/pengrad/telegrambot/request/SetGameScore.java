package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetGameScore extends BaseRequest<SetGameScore, BaseResponse> {
    public SetGameScore(long j10, int i10, Object obj, int i11) {
        super(SendResponse.class);
        add("user_id", Long.valueOf(j10)).add("score", Integer.valueOf(i10)).add("chat_id", obj).add("message_id", Integer.valueOf(i11));
    }

    public SetGameScore disableEditMessage(boolean z10) {
        return add("disable_edit_message", Boolean.valueOf(z10));
    }

    public SetGameScore force(boolean z10) {
        return add("force", Boolean.valueOf(z10));
    }

    public SetGameScore(long j10, int i10, String str) {
        super(BaseResponse.class);
        add("user_id", Long.valueOf(j10)).add("score", Integer.valueOf(i10)).add("inline_message_id", str);
    }
}
