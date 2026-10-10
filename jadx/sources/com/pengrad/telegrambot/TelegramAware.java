package com.pengrad.telegrambot;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u0002H\u0003\"\u0014\b\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0005\"\b\b\u0001\u0010\u0003*\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0005H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/pengrad/telegrambot/TelegramAware;", "", "execute", "RES", "REQ", "Lcom/pengrad/telegrambot/request/BaseRequest;", "Lcom/pengrad/telegrambot/response/BaseResponse;", "request", "(Lcom/pengrad/telegrambot/request/BaseRequest;)Lcom/pengrad/telegrambot/response/BaseResponse;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TelegramAware {
    <REQ extends BaseRequest<REQ, RES>, RES extends BaseResponse> RES execute(BaseRequest<REQ, RES> request);
}
