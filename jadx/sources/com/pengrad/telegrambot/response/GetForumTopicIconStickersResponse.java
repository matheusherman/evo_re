package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Sticker;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GetForumTopicIconStickersResponse extends BaseResponse {
    private List<Sticker> result;

    public List<Sticker> stickers() {
        return this.result;
    }

    @Override // com.pengrad.telegrambot.response.BaseResponse
    public String toString() {
        return "GetForumTopicIconStickersResponse{result=" + this.result + '}';
    }

    GetForumTopicIconStickersResponse() {
    }
}
