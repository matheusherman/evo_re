package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.ChatAdministratorRights;
import com.pengrad.telegrambot.response.BaseResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetMyDefaultAdministratorRights extends BaseRequest<SetMyDefaultAdministratorRights, BaseResponse> {
    public SetMyDefaultAdministratorRights() {
        super(BaseResponse.class);
    }

    public SetMyDefaultAdministratorRights forChannels(boolean z10) {
        return add("for_channels", Boolean.valueOf(z10));
    }

    public SetMyDefaultAdministratorRights rights(ChatAdministratorRights chatAdministratorRights) {
        return add("rights", chatAdministratorRights);
    }
}
