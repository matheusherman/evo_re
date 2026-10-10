package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EditMessageLiveLocation extends BaseRequest<EditMessageLiveLocation, BaseResponse> {
    public EditMessageLiveLocation(Object obj, int i10, float f10, float f11) {
        super(SendResponse.class);
        add("chat_id", obj).add("message_id", Integer.valueOf(i10)).add("latitude", Float.valueOf(f10)).add("longitude", Float.valueOf(f11));
    }

    public EditMessageLiveLocation businessConnectionId(String str) {
        return add("business_connection_id", str);
    }

    public EditMessageLiveLocation heading(int i10) {
        return add("heading", Integer.valueOf(i10));
    }

    public EditMessageLiveLocation horizontalAccuracy(float f10) {
        return add("horizontal_accuracy", Float.valueOf(f10));
    }

    public EditMessageLiveLocation livePeriod(int i10) {
        return add("live_period", Integer.valueOf(i10));
    }

    public EditMessageLiveLocation proximityAlertRadius(int i10) {
        return add("proximity_alert_radius", Integer.valueOf(i10));
    }

    public EditMessageLiveLocation replyMarkup(InlineKeyboardMarkup inlineKeyboardMarkup) {
        return add("reply_markup", inlineKeyboardMarkup);
    }

    public EditMessageLiveLocation(String str, float f10, float f11) {
        super(BaseResponse.class);
        add("inline_message_id", str).add("latitude", Float.valueOf(f10)).add("longitude", Float.valueOf(f11));
    }
}
