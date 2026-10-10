package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetUpdatesResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GetUpdates extends BaseRequest<GetUpdates, GetUpdatesResponse> {
    private int limit;
    private int timeout;

    public GetUpdates() {
        super(GetUpdatesResponse.class);
        this.timeout = 0;
        this.limit = 100;
    }

    public GetUpdates allowedUpdates(String... strArr) {
        return add("allowed_updates", strArr);
    }

    public int getLimit() {
        return this.limit;
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public int getTimeoutSeconds() {
        return this.timeout;
    }

    public GetUpdates limit(int i10) {
        this.limit = i10;
        return add("limit", Integer.valueOf(i10));
    }

    public GetUpdates offset(int i10) {
        return add("offset", Integer.valueOf(i10));
    }

    public GetUpdates timeout(int i10) {
        this.timeout = i10;
        return add("timeout", Integer.valueOf(i10));
    }
}
