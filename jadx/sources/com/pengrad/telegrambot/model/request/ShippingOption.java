package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ShippingOption implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f8246id;
    private LabeledPrice[] prices;
    private String title;

    public ShippingOption(String str, String str2, LabeledPrice... labeledPriceArr) {
        this.f8246id = str;
        this.title = str2;
        this.prices = labeledPriceArr;
    }
}
