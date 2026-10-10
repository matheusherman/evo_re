package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.utility.BotUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class BaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> {
    private final Class<? extends R> responseClass;
    protected final T thisAsT = this;
    private final Map<String, Object> parameters = new LinkedHashMap();

    public int getTimeoutSeconds() {
        return 0;
    }

    public boolean isMultipart() {
        return false;
    }

    protected T add(String str, Object obj) {
        this.parameters.put(str, obj);
        return this.thisAsT;
    }

    protected T addAll(Map<String, Object> map) {
        this.parameters.putAll(map);
        return this.thisAsT;
    }

    public String getContentType() {
        return ContentTypes.GENERAL_MIME_TYPE;
    }

    public String getFileName() {
        return "file.txt";
    }

    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    public Class<? extends R> getResponseType() {
        return this.responseClass;
    }

    public String toWebhookResponse() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.parameters);
        linkedHashMap.put("method", getMethod());
        return BotUtils.toJson(linkedHashMap);
    }

    public BaseRequest(Class<? extends R> cls) {
        this.responseClass = cls;
    }

    public String getMethod() {
        String simpleName = getClass().getSimpleName();
        return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    }
}
