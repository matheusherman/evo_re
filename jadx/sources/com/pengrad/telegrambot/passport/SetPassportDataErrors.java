package com.pengrad.telegrambot.passport;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetPassportDataErrors extends BaseRequest<SetPassportDataErrors, BaseResponse> {
    public SetPassportDataErrors(long j10, PassportElementError... passportElementErrorArr) {
        super(BaseResponse.class);
        add("user_id", Long.valueOf(j10)).add("errors", passportElementErrorArr);
    }
}
