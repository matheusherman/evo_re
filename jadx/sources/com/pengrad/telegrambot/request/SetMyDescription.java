package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetMyDescription extends BaseRequest<SetMyDescription, BaseResponse> {
    public SetMyDescription() {
        super(BaseResponse.class);
    }

    public SetMyDescription description(String str) {
        add("description", str);
        return this;
    }

    public SetMyDescription languageCode(String str) {
        add("language_code", str);
        return this;
    }
}
