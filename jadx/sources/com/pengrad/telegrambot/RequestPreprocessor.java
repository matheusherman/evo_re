package com.pengrad.telegrambot;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\b\u001a\u00020\u0007\"\u0014\b\u0000\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\b\b\u0001\u0010\u0005*\u00020\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/pengrad/telegrambot/RequestPreprocessor;", "", "Lcom/pengrad/telegrambot/request/BaseRequest;", "REQ", "Lcom/pengrad/telegrambot/response/BaseResponse;", "RES", "request", "Lr8/z;", "process", "(Lcom/pengrad/telegrambot/request/BaseRequest;)V", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RequestPreprocessor {
    <REQ extends BaseRequest<REQ, RES>, RES extends BaseResponse> void process(BaseRequest<REQ, RES> request);
}
