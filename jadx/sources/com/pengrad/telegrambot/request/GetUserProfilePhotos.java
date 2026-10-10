package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetUserProfilePhotosResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GetUserProfilePhotos extends BaseRequest<GetUserProfilePhotos, GetUserProfilePhotosResponse> {
    public GetUserProfilePhotos(long j10) {
        super(GetUserProfilePhotosResponse.class);
        add("user_id", Long.valueOf(j10));
    }

    public GetUserProfilePhotos limit(int i10) {
        return add("limit", Integer.valueOf(i10));
    }

    public GetUserProfilePhotos offset(int i10) {
        return add("offset", Integer.valueOf(i10));
    }
}
