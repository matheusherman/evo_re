package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
import com.pengrad.telegrambot.response.BaseResponse;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetChatPhoto extends BaseRequest<SetChatPhoto, BaseResponse> {
    public SetChatPhoto(Object obj, byte[] bArr) {
        super(BaseResponse.class);
        add("chat_id", obj).add(PaidMediaPhoto.TYPE, bArr);
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public boolean isMultipart() {
        return true;
    }

    public SetChatPhoto(Object obj, File file) {
        super(BaseResponse.class);
        add("chat_id", obj).add(PaidMediaPhoto.TYPE, file);
    }
}
