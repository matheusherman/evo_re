package com.pengrad.telegrambot.model;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u0004R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\t\"\u0004\b\u000b\u0010\u0004R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/pengrad/telegrambot/model/LocationAddress;", "", "countryCode", "", "(Ljava/lang/String;)V", "state", "city", "street", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "setCity", "setState", "setStreet", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocationAddress {
    private String city;
    private final String countryCode;
    private String state;
    private String street;

    private LocationAddress(String str, String str2, String str3, String str4) {
        this.countryCode = str;
        this.state = str2;
        this.city = str3;
        this.street = str4;
    }

    /* JADX INFO: renamed from: city, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: state, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: street, reason: from getter */
    public final String getStreet() {
        return this.street;
    }

    public final LocationAddress city(String city) {
        m.f(city, "city");
        this.city = city;
        return this;
    }

    /* JADX INFO: renamed from: countryCode, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final void setStreet(String str) {
        this.street = str;
    }

    public final LocationAddress state(String state) {
        m.f(state, "state");
        this.state = state;
        return this;
    }

    public final LocationAddress street(String street) {
        m.f(street, "street");
        this.street = street;
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocationAddress(String countryCode) {
        this(countryCode, null, null, null);
        m.f(countryCode, "countryCode");
    }
}
