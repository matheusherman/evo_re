package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.botcommandscope.BotCommandScope;
import com.pengrad.telegrambot.response.GetMyCommandsResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GetMyCommands extends BaseRequest<GetMyCommands, GetMyCommandsResponse> {
    public GetMyCommands() {
        super(GetMyCommandsResponse.class);
    }

    public GetMyCommands languageCode(String str) {
        add("language_code", str);
        return this;
    }

    public GetMyCommands scope(BotCommandScope botCommandScope) {
        add("scope", botCommandScope);
        return this;
    }
}
