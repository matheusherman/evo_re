package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.ResponseParameters;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BaseResponse {
    private String description;
    private int error_code;
    private boolean ok;
    private ResponseParameters parameters;

    public String description() {
        return this.description;
    }

    public int errorCode() {
        return this.error_code;
    }

    public boolean isOk() {
        return this.ok;
    }

    public ResponseParameters parameters() {
        return this.parameters;
    }

    public String toString() {
        return "BaseResponse{ok=" + this.ok + ", error_code=" + this.error_code + ", description='" + this.description + "', parameters=" + this.parameters + '}';
    }

    BaseResponse() {
    }
}
