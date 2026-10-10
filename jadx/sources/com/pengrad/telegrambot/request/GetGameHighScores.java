package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetGameHighScoresResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GetGameHighScores extends BaseRequest<GetGameHighScores, GetGameHighScoresResponse> {
    public GetGameHighScores(long j10, Object obj, int i10) {
        super(GetGameHighScoresResponse.class);
        add("user_id", Long.valueOf(j10)).add("chat_id", obj).add("message_id", Integer.valueOf(i10));
    }

    public GetGameHighScores(long j10, String str) {
        super(GetGameHighScoresResponse.class);
        add("user_id", Long.valueOf(j10)).add("inline_message_id", str);
    }
}
