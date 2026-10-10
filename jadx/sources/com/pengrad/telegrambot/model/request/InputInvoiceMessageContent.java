package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputInvoiceMessageContent extends InputMessageContent implements Serializable {
    private static final long serialVersionUID = 0;
    private String currency;
    private String description;
    private boolean is_flexible;
    private Integer max_tip_amount;
    private boolean need_email;
    private boolean need_name;
    private boolean need_phone_number;
    private boolean need_shipping_address;
    private String payload;
    private Integer photo_height;
    private Integer photo_size;
    private String photo_url;
    private Integer photo_width;
    private LabeledPrice[] prices;
    private String provider_data;
    private String provider_token;
    private boolean send_email_to_provider;
    private boolean send_phone_number_to_provider;
    private Integer[] suggested_tip_amount;
    private String title;

    public InputInvoiceMessageContent isFlexible(boolean z10) {
        this.is_flexible = z10;
        return this;
    }

    public InputInvoiceMessageContent maxTipAmount(Integer num) {
        this.max_tip_amount = num;
        return this;
    }

    public InputInvoiceMessageContent needEmail(boolean z10) {
        this.need_email = z10;
        return this;
    }

    public InputInvoiceMessageContent needName(boolean z10) {
        this.need_name = z10;
        return this;
    }

    public InputInvoiceMessageContent needPhoneNumber(boolean z10) {
        this.need_phone_number = z10;
        return this;
    }

    public InputInvoiceMessageContent needShippingAddress(boolean z10) {
        this.need_shipping_address = z10;
        return this;
    }

    public InputInvoiceMessageContent photoHeight(Integer num) {
        this.photo_height = num;
        return this;
    }

    public InputInvoiceMessageContent photoSize(Integer num) {
        this.photo_size = num;
        return this;
    }

    public InputInvoiceMessageContent photoUrl(String str) {
        this.photo_url = str;
        return this;
    }

    public InputInvoiceMessageContent photoWidth(Integer num) {
        this.photo_width = num;
        return this;
    }

    public InputInvoiceMessageContent providerData(String str) {
        this.provider_data = str;
        return this;
    }

    public InputInvoiceMessageContent providerToken(String str) {
        this.provider_token = str;
        return this;
    }

    public InputInvoiceMessageContent sendEmailToProvider(boolean z10) {
        this.send_email_to_provider = z10;
        return this;
    }

    public InputInvoiceMessageContent sendPhoneNumberToProvider(boolean z10) {
        this.send_phone_number_to_provider = z10;
        return this;
    }

    public InputInvoiceMessageContent suggestedTipAmount(Integer[] numArr) {
        this.suggested_tip_amount = numArr;
        return this;
    }

    public InputInvoiceMessageContent(String str, String str2, String str3, String str4, LabeledPrice[] labeledPriceArr) {
        this.title = str;
        this.description = str2;
        this.payload = str3;
        this.currency = str4;
        this.prices = labeledPriceArr;
    }
}
