package com.pengrad.telegrambot;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0013\u0010\u0000\u001a\u00020\u00018G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"EMPTY_REQUEST_PREPROCESSOR", "Lcom/pengrad/telegrambot/RequestPreprocessor;", "getEmptyRequestPreprocessor", "()Lcom/pengrad/telegrambot/RequestPreprocessor;", "library"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RequestPreprocessorKt {
    private static final RequestPreprocessor EMPTY_REQUEST_PREPROCESSOR = new RequestPreprocessor() { // from class: com.pengrad.telegrambot.RequestPreprocessorKt$EMPTY_REQUEST_PREPROCESSOR$1
        @Override // com.pengrad.telegrambot.RequestPreprocessor
        public <REQ extends BaseRequest<REQ, RES>, RES extends BaseResponse> void process(BaseRequest<REQ, RES> request) {
            m.f(request, "request");
        }
    };

    public static final RequestPreprocessor getEmptyRequestPreprocessor() {
        return EMPTY_REQUEST_PREPROCESSOR;
    }
}
